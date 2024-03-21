package nl.the_experts.tackle_eventual_consistency_with_domain_events.data.book;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.data.baserepository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Maik Kingma
 */

@Repository
public interface BookRepository extends BaseJpaRepository<BookJPA, Long> {
    List<BookJPA> findByTitleContains(String title);
}
