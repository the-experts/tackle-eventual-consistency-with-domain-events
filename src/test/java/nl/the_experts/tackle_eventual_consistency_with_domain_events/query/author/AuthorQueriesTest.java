package nl.the_experts.tackle_eventual_consistency_with_domain_events.query.author;

import nl.the_experts.tackle_eventual_consistency_with_domain_events.domain.author.Author;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author.AuthorDTO;
import nl.the_experts.tackle_eventual_consistency_with_domain_events.domaininteraction.author.AuthorFlow;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorQueriesTest {

    @Mock
    private AuthorFlow authorFlow;

    @InjectMocks
    private AuthorQueries authorQueries;

    @Test
    void getAll() {
        // given
        List<AuthorDTO> mockedAuthorListResponse =
                List.of(new AuthorDTO(Author.restore().id(1L).firstName("firstName").lastName("lastName").build()));
        when(authorFlow.getListOfAllAuthors()).thenReturn(mockedAuthorListResponse);
        // when then
        List<AuthorView> result = authorQueries.getAll();
        verify(authorFlow, times(1)).getListOfAllAuthors();
        assertThat(result).containsExactly(new AuthorView(1L, "firstName lastName"));
    }
}
