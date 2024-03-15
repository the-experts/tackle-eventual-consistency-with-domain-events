package nl.the_experts.tackle_eventual_consistency_with_domain_events.query.author;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author.AuthorDTO;

/**
 * @author Maik Kingma
 */

public record AuthorView (Long id, String name) {
    public AuthorView(AuthorDTO authorDTO) {
        this(authorDTO.id(), authorDTO.getFullName());
    }
}
