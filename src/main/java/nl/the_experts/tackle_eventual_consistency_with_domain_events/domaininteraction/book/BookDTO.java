package nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.book;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.book.Book;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author.AuthorDTO;

import java.util.List;
import java.util.UUID;

/**
 * @author Maik Kingma
 */

public record BookDTO(Long id, AuthorDTO authorDTO, String title, String genre, UUID publisherId, boolean published,
                      String isbn, List<DomainEvent> domainEvents) {
    public BookDTO(Book book) {
        this(book.getId(), new AuthorDTO(book.getAuthor()), book.getTitle(), book.getGenre().toString(),
                book.getPublisherId(), book.isPublished(), book.getIsbn(), book.getDomainEvents());
    }
}
