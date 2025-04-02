package sesac.sesac_spring_boot_security.config;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.CorsFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import sesac.sesac_spring_boot_security.security.JwtAuthenticationFilter;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Slf4j
@EnableWebSecurity
// Spring Security 의 기본 웹 보안 설정을 활성화하는 어노테이션
// Spring boot 가 기본으로 해주는 보안설정을 커스터마이징할 수 있도록 하는 어노테이션
@Configuration // 해당 클래스가 설정 클래스임을 알리는 어노테이션
public class WebSecurityConfig {
    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        // 설정
        http
          .cors(withDefaults()) // cors 설정
          .csrf(CsrfConfigurer::disable) // cross site request forgery 방지 (csrf disable), (JWT 는 stateless 하므로 필요 없음)
          // .httpBasic(withDefaults()) // HTTP 기본 인증 방식, (토큰 인증방식에서는 사용하지 않음)
          // .formLogin() // 폼 로그인 방식, session 로그인일 때 사용, (토큰인증 방식에서는 사용하지 않음)
          .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 람다식
                // session 기반이 아니므로 무상태(STATELESS) 설정, stateless: 서버가 세션을 생성하거나 보관하지 않음.
                // 🔥 여기 추가!
                .exceptionHandling(exception ->
                        exception.authenticationEntryPoint((req, res, ex) -> {
                            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                        })
                )
          .authorizeHttpRequests(authorize ->
                  authorize.requestMatchers("/", "/auth/**").permitAll() //  /, /auth/** 경로는 인증 안해도 됨
                           .anyRequest().authenticated() // /, /** 이외의 모든 경로는 인증해야 됨
          );

//        log.info();
        // filter 등록: 매 요청마다 CorsFilter 실행한 후에 (의존성 주입한) jwtAuthenticationFilter 실행
        http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class); // (allie 참고:CorsFilter import apache 에서 하지 않도록, spring boot 에서 import 하도록!! 주의! )


        // 최종 SecurityFilterChain 객체 생성 
        // - HttpSecurity 클래스가 builder 패턴을 사용하기 때문에 . build()로 객체 생성
        // - 위의 설정 객체 값이 담겨 있음
        return http.build(); 
    }

    // Bean 으로 등록한 corsConfigurationSource 메서드는 프로젝트 내에서 사용되는건 아니지만
    // .cors(withDefaults()) 설정시 Spring Security 가 가져다가 쓰는 메서드임!
    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = new CorsConfiguration(); // cors config 객체 생성

        // 모든 출처, 메소드, 헤더를 허용하는 CORS 설정
        config.setAllowCredentials(true);
        config.setAllowedOriginPatterns(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("HEAD","POST","GET","DELETE","PUT","PATCH"));
        config.setAllowedHeaders(Arrays.asList("*"));
        // 참고: asList - 고정 크기 list 반환

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // 모든 경로에 대해 위에서 설정한 CORS 정책 적용

        return source;
    }
}
