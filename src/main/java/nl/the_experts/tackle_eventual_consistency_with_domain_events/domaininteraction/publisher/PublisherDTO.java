package nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.publisher;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.publisher.Publisher;

import java.util.UUID;

/**
 * @author Maik Kingma
 */

public record PublisherDTO(UUID id, String name) {
    public PublisherDTO(Publisher publisher) {
        this(publisher.id(), publisher.name());
    }
}
