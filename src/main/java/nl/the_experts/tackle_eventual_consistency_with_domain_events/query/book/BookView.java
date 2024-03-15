package nl.the_experts.tackle_eventual_consistency_with_domain_events.query.book;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author.AuthorDTO;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.book.BookDTO;

/**
 * @author Maik Kingma
 */

public record BookView(Long id, String title, String genre, String authorName) {
    public BookView(BookDTO bookDTO, AuthorDTO authorDTO) {
        this(bookDTO.id(), bookDTO.title(), bookDTO.genre(), authorDTO.getFullName());
    }
}
