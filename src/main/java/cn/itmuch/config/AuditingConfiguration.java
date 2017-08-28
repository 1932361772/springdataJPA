package cn.itmuch.config;

import java.util.Calendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
//审计springdatajpa的功能.
@Configuration
public class AuditingConfiguration {
	/*
	 * 用来修改创建者和修改者.
	 */
	@Bean(name="createAuditorAware")//默认方法名.
	public AuditorAware<String> createAuditorAware() {
		return new AuditorAware<String>() {
			@Override
			public String getCurrentAuditor() {
				// TODO Auto-generated method stub
				return  "manager";
			}
		};
	}
	
	/*
	 * 用来获取创建时间和修改时间.
	 */
	@Bean//默认方法名.
	public DateTimeProvider createDateTimeProvider() {
		return new DateTimeProvider() {
			@Override
			public Calendar getNow() {
				// TODO Auto-generated method stub
				return Calendar.getInstance();//返回当前时间.
			}
		};
		
	}
	
	
	
	
}
