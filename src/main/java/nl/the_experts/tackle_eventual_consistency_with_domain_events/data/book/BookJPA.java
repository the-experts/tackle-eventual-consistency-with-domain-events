package nl.the_experts.tackle_eventual_consistency_with_domain_events.data.book;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.data.author.AuthorJPA;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.data.baserepository.AggregateRoot;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.domainevent.DomainEvent;

import java.util.List;
import java.util.UUID;

import static jakarta.persistence.GenerationType.SEQUENCE;


/**
 * @author Maik Kingma
 */

@Entity
@Builder
@NoArgsConstructor()
@AllArgsConstructor
@Table(name = "book")
public class BookJPA extends AggregateRoot<BookJPA> {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "book_seq_gen")
    @SequenceGenerator(name = "book_seq_gen", sequenceName = "book_seq", allocationSize = 1)
    @Getter
    private Long id;

    @Getter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private AuthorJPA author;

    @Getter
    private String title;

    @Getter
    private String genre;

    @Getter
    private UUID publisherId;

    @Getter
    private boolean published;

    @Getter
    private String isbn;

    public void registerDomainEvents(List<DomainEvent> domainEvents) {
        domainEvents.forEach(this::andEvent);
    }
}
