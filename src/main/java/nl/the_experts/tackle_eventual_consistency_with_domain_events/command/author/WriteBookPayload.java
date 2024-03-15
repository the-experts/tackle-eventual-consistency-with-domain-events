package nl.the_experts.tackle_eventual_consistency_with_domain_events.command.author;

/**
 * @author Maik Kingma
 */

public record WriteBookPayload(String title, String genre) {
}
