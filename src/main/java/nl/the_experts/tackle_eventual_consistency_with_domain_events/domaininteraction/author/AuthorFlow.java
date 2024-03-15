package nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.author.Author;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.book.Genre;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.book.BookDTO;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.book.BookDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorFlow {

    private final AuthorDataService authorDataService;
    private final BookDataService bookDataService;

    public AuthorFlow(AuthorDataService authorDataService, BookDataService bookDataService) {
        this.authorDataService = authorDataService;
        this.bookDataService = bookDataService;
    }

    public void registerAuthorByName(String firstName, String lastName) {
        Author author = Author.create(firstName, lastName);
        authorDataService.save(new AuthorDTO(author));
    }

    public List<AuthorDTO> getListOfAllAuthors() {
        return authorDataService.findAll();
    }

    public AuthorDTO findById(Long authorId) {
        return authorDataService.findById(authorId);
    }

    public void writeManuscript(Long authorId, String title, String genre) {
        var author = AuthorDomainMapper.mapToDomain(authorDataService.findById(authorId));
        var book = author.writeManuscript(title, Genre.fromString(genre));
        bookDataService.save(new BookDTO(book));
    }
}
