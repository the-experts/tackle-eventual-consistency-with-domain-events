package nl.the_experts.tackle_eventual_consistency_with_domain_events.data.baserepository;

import jakarta.persistence.EntityManager;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.kafka.KafkaProducerService;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.core.RepositoryInformation;

public class BaseJpaRepositoryFactory extends JpaRepositoryFactory {

    private final EntityManager entityManager;
    private final KafkaProducerService kafkaProducerService;

    public BaseJpaRepositoryFactory(EntityManager entityManager, KafkaProducerService kafkaProducerService) {
        super(entityManager);
        this.entityManager = entityManager;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Override
    protected JpaRepositoryImplementation<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
        return new BaseJpaRepositoryImpl<>(getEntityInformation(information.getDomainType()), entityManager, kafkaProducerService);
    }
}
