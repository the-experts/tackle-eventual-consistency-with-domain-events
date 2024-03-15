package nl.the_experts.tackle_eventual_consistency_with_domain_events.data.book;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.data.author.AuthorJPAMapper;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.data.book.BookJPA;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.data.book.BookJPAMapper;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author.AuthorDTO;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.book.BookDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BookJPAMapperTest {

    @Test
    void mapToJPA() {
        AuthorDTO authorDTO = new AuthorDTO(1L, "firstName", "lastName");
        BookJPA bookJPA = BookJPAMapper.mapToJPA(new BookDTO(1L, authorDTO, "title", "genre",
                null, false, null));
        assertThat(bookJPA).usingRecursiveComparison().isEqualTo(BookJPA.builder()
                .id(1L)
                .title("title")
                .author(AuthorJPAMapper.mapToJPA(authorDTO))
                .genre("genre")
                .isbn(null)
                .published(false)
                .publisherId(null)
                .build());
    }
}
