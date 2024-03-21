package nl.the_experts.tackle_eventual_consistency_with_domain_events.data.baserepository;

import jakarta.persistence.EntityManager;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.kafka.KafkaProducerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.lang.NonNull;

import java.io.Serializable;

public class BaseJpaRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable> extends JpaRepositoryFactoryBean<T, S, ID> {
    private final KafkaProducerService kafkaProducerService;

    public BaseJpaRepositoryFactoryBean(Class<? extends T> repositoryInterface, KafkaProducerService kafkaProducerService) {
        super(repositoryInterface);
        this.kafkaProducerService = kafkaProducerService;
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(@NonNull EntityManager entityManager) {
        return new BaseJpaRepositoryFactory(entityManager, kafkaProducerService);
    }
}
