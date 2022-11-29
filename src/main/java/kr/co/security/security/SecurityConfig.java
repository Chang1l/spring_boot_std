package kr.co.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import kr.co.security.TestService;


@Configuration
@EnableWebSecurity// 시큐리티 필터 등록
@EnableGlobalMethodSecurity(prePostEnabled = true)
//특정 페이지에 특정  권한이 있는  유저만 접근을 허용할 경우 권한 및 인증을 미리 체크하겠다는 설정을 활성화함
public class SecurityConfig extends WebSecurityConfigurerAdapter{


	@Autowired
	TestService service;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public static NoOpPasswordEncoder noOpPasswordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		//인증을 받지 않아도 되는 url 제외 목록
		web.ignoring().antMatchers("/css/**","/js/**","lib/**","/newMember","/loginForm");
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
//		인증을 받아야하는 url 목록
		http.authorizeHttpRequests()
		.antMatchers("/member").authenticated() //인증된 유저만 접근 가능
		.antMatchers("/super").hasAuthority("super")// 권한이(auth) super 인 사용자만 접근 가능
		.antMatchers("/normal").hasAnyAuthority("super","normal")//권한이 normal super 인 사용자만 접근 가능
		.antMatchers("/**").permitAll(); //해당 경로 접근 허용
		
//	로그인 성공 시 , 실패시, 인증 실패시 보여지는 페이지 설정
		http.formLogin()
		.loginProcessingUrl("/login")//브라우저에 login 으로 요청하면 동작 username, password 키명으로 보내야한다
		.loginPage("/loginForm") //해당주소로 로그인 페이지 호출
		.defaultSuccessUrl("/member").failureUrl("/deny")
		.permitAll().and().csrf().disable();
//		csrf 토큰 활성화 시 사용
//		쿠키를 생성할 때 HttpOnly 태그를 사용하면 클라이언트 스크립트가 보호된 쿠키에 엑세스하는
//		위험을 줄일 수 있으므로 쿠키의 보안을 강화 할 수 있다
//		SPA 같은 싱글 페이지 어플리케이션과 연동하려면 아래처럼 CSRF값을 헤더에 포함하여 사용 할 수 있다
		
//		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/index")
			.invalidateHttpSession(true) //인증정보를 지우고 세션을 무효화
			.deleteCookies("JSESSIONID"); //JSESSIONID 쿠키 삭제;
		
		http.exceptionHandling().accessDeniedPage("/deny");
	}
		
	//시큐리티가 로그인 과정에서 password를 가로챌때 해당 해쉬로 암호화해서 비교한다
	@Override
	public void configure(AuthenticationManagerBuilder auth)throws Exception{
//		auth.userDetailsService(service).passwordEncoder(noOpPasswordEncoder());
//		비밀번호 암호화하지 않았을때의 로그인 매칭 로직
		auth.userDetailsService(service).passwordEncoder(passwordEncoder());
//		비밀번호 암호화했을때의 로그인 매칭 로직
	}
}
