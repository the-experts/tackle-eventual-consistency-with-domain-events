package nl.the_experts.tackle_eventual_consistency_with_domain_events.query.publisher;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.publisher.PublisherAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Maik Kingma
 */

@RestController
@RequestMapping(value = "/publishers")
public class PublisherQuery {

    private final PublisherAppService publisherAppService;

    public PublisherQuery(PublisherAppService publisherAppService) {
        this.publisherAppService = publisherAppService;
    }

    @GetMapping
    List<PublisherView> getAllPublishers() {
        return publisherAppService.getAllPublishers().stream()
                .map(PublisherView::new)
                .toList();
    }
}
