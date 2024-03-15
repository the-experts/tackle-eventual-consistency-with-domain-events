package nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.author.Author;

public record AuthorDTO(Long id, String firstName, String lastName) {
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public AuthorDTO(Author author) {
        this(author.getId(), author.getFirstName(), author.getLastName());
    }
}
