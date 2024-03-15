package nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.book;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.book.Book;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.book.Genre;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author.AuthorDomainMapper;

/**
 * @author Maik Kingma
 */

public class BookDomainMapper {
    public static Book mapToDomain(BookDTO bookDTO) {
        return Book.restore()
                .id(bookDTO.id())
                .title(bookDTO.title())
                .author(AuthorDomainMapper.mapToDomain(bookDTO.authorDTO()))
                .genre(Genre.fromString(bookDTO.genre()))
                .published(bookDTO.published())
                .publisherId(bookDTO.publisherId())
                .isbn(bookDTO.isbn())
                .build();
    }
}
