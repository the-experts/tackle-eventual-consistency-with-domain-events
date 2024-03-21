package nl.the_experts.tackle_eventual_consistency_with_domain_events.data.baserepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
