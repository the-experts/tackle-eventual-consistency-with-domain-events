package nl.the_experts.tackle_eventual_consistency_with_domain_events.query.book;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author.AuthorDTO;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author.AuthorFlow;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.book.BookDTO;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.book.BookFlow;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Maik Kingma
 */

@RestController
@RequestMapping(value = "/books")
public class BookQueries {
    private final BookFlow bookFlow;
    private final AuthorFlow authorFlow;

    public BookQueries(BookFlow bookFlow, AuthorFlow authorFlow) {
        this.bookFlow = bookFlow;
        this.authorFlow = authorFlow;
    }

    @GetMapping
    public List<BookView> findBooks(@RequestParam(value = "title", required = false) String title) {
        if(title == null || title.isEmpty()) {
            return bookFlow.findAllBooks().stream()
                    .map(bookDTO -> new BookView(bookDTO, getBookAuthor(bookDTO)))
                    .toList();
        } else {
            return bookFlow.findAllBooksWithMatchingTitle(title).stream()
                    .map(bookDTO -> new BookView(bookDTO, getBookAuthor(bookDTO)))
                    .toList();
        }
    }

    private AuthorDTO getBookAuthor(BookDTO bookDTO) {
        return authorFlow.findById(bookDTO.authorDTO().id());
    }
}
