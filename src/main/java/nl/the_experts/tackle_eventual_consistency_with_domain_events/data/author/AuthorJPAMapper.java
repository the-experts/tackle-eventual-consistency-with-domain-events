package nl.the_experts.tackle_eventual_consistency_with_domain_events.data.author;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author.AuthorDTO;

public class AuthorJPAMapper {
    public static AuthorJPA mapToJPA(AuthorDTO author){
        return AuthorJPA.builder()
                .id(author.id())
                .firstName(author.firstName())
                .lastName(author.lastName())
                .build();
    }
}
