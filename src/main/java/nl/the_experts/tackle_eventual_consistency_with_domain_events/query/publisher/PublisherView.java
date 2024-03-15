package nl.the_experts.tackle_eventual_consistency_with_domain_events.query.publisher;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.publisher.PublisherDTO;

import java.util.UUID;

/**
 * @author Maik Kingma
 */

public record PublisherView(UUID id, String name) {
    public PublisherView(PublisherDTO publisherDTO) {
        this(publisherDTO.id(), publisherDTO.name());
    }
}
