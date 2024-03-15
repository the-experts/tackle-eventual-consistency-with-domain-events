package nl.the_experts.tackle_eventual_consistency_with_domain_events.data.book;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.data.author.AuthorJPAMapper;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.book.BookDTO;

public class BookJPAMapper {
    static BookJPA mapToJPA(BookDTO bookDTO) {
        return BookJPA.builder()
                .id(bookDTO.id())
                .title(bookDTO.title())
                .author(AuthorJPAMapper.mapToJPA(bookDTO.authorDTO()))
                .genre(bookDTO.genre())
                .isbn(bookDTO.isbn())
                .published(bookDTO.published())
                .publisherId(bookDTO.publisherId())
                .build();
    }
}
