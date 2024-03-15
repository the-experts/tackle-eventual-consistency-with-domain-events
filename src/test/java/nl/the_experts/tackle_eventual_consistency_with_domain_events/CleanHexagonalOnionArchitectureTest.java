package nl.the_experts.tackle_eventual_consistency_with_domain_events;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.data.book.BookJPA;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.DomainEvent;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

/**
 * @author Maik Kingma
 */

@AnalyzeClasses(packages = "nl.the_experts.tackle_eventual_consistency_with_domain_events", importOptions = {ImportOption.DoNotIncludeTests.class})
public class CleanHexagonalOnionArchitectureTest {

    @ArchTest
    static final ArchRule layer_dependencies_are_respected =
            layeredArchitecture().consideringAllDependencies()

            .layer("command").definedBy("nl.the_experts.tackle_eventual_consistency_with_domain_events.command..")
            .layer("query").definedBy("nl.the_experts.tackle_eventual_consistency_with_domain_events.query..")
            .layer("data").definedBy("nl.the_experts.tackle_eventual_consistency_with_domain_events.data..")
            .layer("acl").definedBy("nl.the_experts.tackle_eventual_consistency_with_domain_events.acl..")
            .layer("domain interaction").definedBy("nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction..")
            .layer("domain").definedBy("nl.the_experts.tackle_eventual_consistency_with_domain_events.domain..")

            .whereLayer("command").mayNotBeAccessedByAnyLayer()
            .whereLayer("query").mayNotBeAccessedByAnyLayer()
            .whereLayer("data").mayNotBeAccessedByAnyLayer()
            .whereLayer("acl").mayNotBeAccessedByAnyLayer()
            .whereLayer("domain interaction").mayOnlyBeAccessedByLayers("command", "query", "data", "acl")
            .whereLayer("domain").mayOnlyBeAccessedByLayers("domain interaction")
            // we will ignore the Domain Event dependencies from the process layer to the domain layer
            // We are eventually trying to solve complexity, not add to it. Adding another layer to solve
            // this would be overkill and overcomplicate things
            .ignoreDependency(BookJPA.class, DomainEvent.class);
}
