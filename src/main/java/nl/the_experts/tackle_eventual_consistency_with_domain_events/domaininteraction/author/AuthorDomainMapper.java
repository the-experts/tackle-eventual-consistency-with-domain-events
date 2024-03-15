package nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.author.Author;

public class AuthorDomainMapper {
    // we keep this method because we will need it later when actual business logic needs to be triggered from the
    // domain core
    public static Author mapToDomain(AuthorDTO authorJPA) {
        return Author.restore()
                .id(authorJPA.id())
                .firstName(authorJPA.firstName())
                .lastName(authorJPA.lastName())
                .build();
    }
}
