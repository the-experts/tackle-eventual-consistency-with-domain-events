package nl.the_experts.tackle_eventual_consistency_with_domain_events.acl.kafka;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.kafka.KafkaProducerService;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private static final Logger log = getLogger(KafkaProducerServiceImpl.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String topic, String message) {
        log.info("publishing Kafka message {} to topic {}", message, topic);
        kafkaTemplate.send(topic, message);
    }
}
