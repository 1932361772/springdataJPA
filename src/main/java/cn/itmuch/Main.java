package cn.itmuch;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan
@EnableJpaRepositories(value = "cn.itmuch", namedQueriesLocation = "query/jpa-named-queries.properties")//sql写在外置文件中,不在类中.
@EnableAsync
@EnableJpaAuditing(setDates=true,modifyOnCreate=false,auditorAwareRef="createAuditorAware",dateTimeProviderRef="createDateTimeProvider")//审计
@EnableTransactionManagement//启用事务
public class Main {//启动类.

}
