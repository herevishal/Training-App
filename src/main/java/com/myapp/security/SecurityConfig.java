package com.myapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

 /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("authorization");
        http.authorizeRequests()
          .anyRequest()//get put post 
          .permitAll()  // all request should be permitted
        .and().httpBasic();//basic security
        http.csrf().disable();//cross site request forgery  javascript attacks
    }*/
  @Autowired
  public void configure(AuthenticationManagerBuilder auth)
          throws Exception
  {

	/*FileReader reader=new FileReader("db.properties");  
	    Properties p=new Properties();  
   	    p.load(reader);  
           String uname=p.getProperty("user"));  
           String pass=p.getProperty("password"));  
           String adminrole1=p.getProperty("role1"));  
*/

      	   auth.inMemoryAuthentication()
          .withUser("vishal").password("{noop}password").roles("USER").and()
          .withUser("adminuser").password("admin@123").roles("admin");           
  }

	@Override
  protected void configure(HttpSecurity http) throws Exception {
      System.out.println("authorization");
      http.authorizeRequests()
      .antMatchers("/hello").hasRole("USER")
      .anyRequest()//get put post 
      .fullyAuthenticated() //every request must be authenticated
      .and().httpBasic();//basic security
      http.csrf().disable();//cross site request forgery  unnecessary popups
  }
  
} 