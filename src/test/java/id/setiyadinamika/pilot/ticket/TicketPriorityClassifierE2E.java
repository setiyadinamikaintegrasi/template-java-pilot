package id.setiyadinamika.pilot.ticket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class TicketPriorityClassifierE2E {
  private record Scenario(
      String severity, String impact, boolean securityIncident, Priority expected) {}

  @Test
  void classifiesRepresentativeTicketJourneys() {
    TicketPriorityClassifier classifier = new TicketPriorityClassifier();
    List<Scenario> scenarios =
        List.of(
            new Scenario("low", "single-user", true, Priority.P1),
            new Scenario("critical", "single-user", false, Priority.P1),
            new Scenario("high", "multiple-users", false, Priority.P2),
            new Scenario("low", "business-wide", false, Priority.P2),
            new Scenario("medium", "single-user", false, Priority.P3),
            new Scenario("low", "multiple-users", false, Priority.P3),
            new Scenario("low", "single-user", false, Priority.P4));

    for (Scenario scenario : scenarios) {
      assertEquals(
          scenario.expected(),
          classifier.classify(scenario.severity(), scenario.impact(), scenario.securityIncident()));
    }
  }
}
