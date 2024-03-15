package nl.the_experts.tackle_eventual_consistency_with_domain_events.command.author;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author.AuthorFlow;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authors/commands")
public class AuthorCommands {

    private final AuthorFlow authorFlow;

    public AuthorCommands(AuthorFlow authorFlow) {
        this.authorFlow = authorFlow;
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void create(@RequestBody RegisterAuthorPayload registerAuthorPayload) {
        authorFlow.registerAuthorByName(registerAuthorPayload.firstName(), registerAuthorPayload.lastName());
    }
}
