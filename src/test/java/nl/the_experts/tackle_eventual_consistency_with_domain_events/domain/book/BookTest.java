package nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.book;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.author.Author;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.book.Genre.HORROR;
import static org.assertj.core.api.Assertions.assertThat;


class BookTest {

    @Test
    void requestPublishing() {
        // given
        Book book = Book.createManuscript("title", HORROR, Author.restore().firstName("first").lastName("last").id(1L).build());
        UUID publisherId = UUID.randomUUID();
        assertThat(book.isPublished()).isFalse();
        assertThat(book.getPublisherId()).isNull();
        assertThat(book.getIsbn()).isNull();
        assertThat(book.canBePublished()).isTrue();
        // when
        book.requestPublishing(publisherId);
        // then
        assertThat(book.isPublished()).isFalse();
        assertThat(book.getPublisherId()).isEqualTo(publisherId);
        assertThat(book.canBePublished()).isFalse();
        assertThat(book.getIsbn()).isNull();
        assertThat(book.getDomainEvents()).hasSize(1).containsExactly(new Book.RequestPublishingEvent(book.getId(), publisherId));
    }
}
