package nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.publisher;

import java.util.UUID;

/**
 * @author Maik Kingma
 */

public record Publisher(UUID id, String name) {
}
