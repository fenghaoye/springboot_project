package com.fh.project.annotation;

import com.fh.project.TestService;
import com.fh.project.TestServiceImpl;
import com.fh.project.entity.People;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ConditionalOnProperty
 *  能够控制某个配置类是否生效，主要是通过name和havingValue属性来实现
 *  name:从application.properties配置文件中读取某个属性值，如果该值为空，就为false，不为空就与havingValue属性
 *  的属性值进行比较，如果一样，则返回true
 *  返回为true时，该配置类生效
 */
@Configuration
@ConditionalOnProperty(name={"TestConditionalOnProperty"},havingValue = "1")
public class TestConditionalOnProperty {

    @Bean(name = "TestService")
    //@Qualifier("SecondDataSource")
    //@ConfigurationProperties(prefix = "spring.second.datasource")
    //@ConfigurationProperties
    public TestService testService() {
        return new TestServiceImpl();

    }

    @Bean
    @ConfigurationProperties(prefix = "people")
    public People people() {
        return new People();
    }

}
