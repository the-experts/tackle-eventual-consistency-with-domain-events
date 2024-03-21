package nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.kafka;

public interface KafkaProducerService {
    public void sendMessage(String topic, String message);
}
