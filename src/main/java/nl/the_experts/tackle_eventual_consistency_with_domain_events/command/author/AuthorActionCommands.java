package nl.the_experts.tackle_eventual_consistency_with_domain_events.command.author;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author.AuthorFlow;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authors/{id}/commands")
public class AuthorActionCommands {

    private final AuthorFlow authorFlow;

    public AuthorActionCommands(AuthorFlow authorFlow) {
        this.authorFlow = authorFlow;
    }

    @PostMapping("/writeBook")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void writeBook(@PathVariable("id") Long authorId, @RequestBody WriteBookPayload writeBookPayload) {
        authorFlow.writeManuscript(authorId, writeBookPayload.title(), writeBookPayload.genre());
    }
}
