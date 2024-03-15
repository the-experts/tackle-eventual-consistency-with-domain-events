package nl.the_experts.tackle_eventual_consistency_with_domain_events.data.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Maik Kingma
 */

@Repository
public interface AuthorRepository extends JpaRepository<AuthorJPA, Long> {
}
