package nl.the_experts.tackle_eventual_consistency_with_domain_events.data.baserepository;

import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Collection;

public class AggregateRoot<A extends AbstractAggregateRoot<A>> extends AbstractAggregateRoot<A> {

    public Collection<Object> retrieveDomainEvents() {
        return domainEvents();
    }

    public void removeAllDomainEvents() {
        clearDomainEvents();
    }
}
