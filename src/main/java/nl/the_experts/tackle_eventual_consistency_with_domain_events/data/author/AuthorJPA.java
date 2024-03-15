package nl.the_experts.tackle_eventual_consistency_with_domain_events.data.author;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

/**
 * @author Maik Kingma
 */

@Entity
@Builder
@NoArgsConstructor()
@AllArgsConstructor
@Table(name = "author")
public class AuthorJPA {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "author_seq_gen")
    @SequenceGenerator(name = "author_seq_gen", sequenceName = "author_seq", allocationSize = 1)
    @Getter
    private Long id;

    @Getter
    private String firstName;

    @Getter
    private String lastName;
}

