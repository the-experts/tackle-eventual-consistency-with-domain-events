package nl.the_experts.tackle_eventual_consistency_with_domain_events.data.author;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.data.baserepository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Maik Kingma
 */

@Repository
public interface AuthorRepository extends BaseJpaRepository<AuthorJPA, Long> {
}
