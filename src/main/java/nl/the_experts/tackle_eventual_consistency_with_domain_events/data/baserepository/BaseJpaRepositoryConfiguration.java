package nl.the_experts.tackle_eventual_consistency_with_domain_events.data.baserepository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "nl.the_experts.tackle_eventual_consistency_with_domain_events.data",
        repositoryBaseClass = BaseJpaRepositoryImpl.class, repositoryFactoryBeanClass = BaseJpaRepositoryFactoryBean.class)
public class BaseJpaRepositoryConfiguration {

}
