package nl.the_experts.tackle_eventual_consistency_with_domain_events.process.book;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.book.Book;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.book.BookFlow;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Maik Kingma
 */
@Service
public class PublishBookDelegate {
    private final BookFlow bookFlow;

    public PublishBookDelegate(BookFlow bookFlow) {
        this.bookFlow = bookFlow;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void publishBook(Book.RequestPublishingEvent event) {
        bookFlow.requestPublishingAtPublisher(event.getPublisherId(), event.getBookId());
    }
}
