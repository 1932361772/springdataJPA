package cn.itmuch.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration // 相当于spring.xml文件;
public class JpaConfiguration {
	@Bean
	public DataSource CreateDataSource() {
		// 此方式不需要设置driverClass.因为已经将类引入了.
		MysqlDataSource ds = new MysqlDataSource();
		ds.setUrl("jdbc:mysql:///jpa");
		ds.setUser("root");
		ds.setPassword("123");
		return ds;
	}

	@Bean(name = "entityManagerFactory") // 默认是方法名;
	public EntityManagerFactory createEntityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setShowSql(true);
		emf.setPackagesToScan("cn.itmuch.entity");//可以指定一个或多实体类的个包的路径.实体类的路径.
		emf.setJpaVendorAdapter(jpaVendorAdapter);
		emf.afterPropertiesSet();
		return emf.getObject();

	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager createPlatformTransactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);

		return transactionManager;
	}

}
