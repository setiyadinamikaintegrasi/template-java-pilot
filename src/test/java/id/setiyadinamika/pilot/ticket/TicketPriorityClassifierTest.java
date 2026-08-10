package id.setiyadinamika.pilot.ticket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TicketPriorityClassifierTest {
  private final TicketPriorityClassifier classifier = new TicketPriorityClassifier();

  @Test
  void securityIncidentIsP1() {
    assertEquals(Priority.P1, classifier.classify("LOW", "SINGLE_USER", true));
  }

  @Test
  void criticalSeverityIsP1() {
    assertEquals(Priority.P1, classifier.classify("CRITICAL", "SINGLE_USER", false));
  }

  @Test
  void highSeverityIsP2() {
    assertEquals(Priority.P2, classifier.classify("HIGH", "SINGLE_USER", false));
  }

  @Test
  void businessWideImpactIsP2() {
    assertEquals(Priority.P2, classifier.classify("LOW", "BUSINESS_WIDE", false));
  }

  @Test
  void mediumSeverityIsP3() {
    assertEquals(Priority.P3, classifier.classify("MEDIUM", "SINGLE_USER", false));
  }

  @Test
  void multipleUserImpactIsP3() {
    assertEquals(Priority.P3, classifier.classify("LOW", "MULTIPLE_USERS", false));
  }

  @Test
  void lowSingleUserTicketIsP4() {
    assertEquals(Priority.P4, classifier.classify("LOW", "SINGLE_USER", false));
  }

  @Test
  void blankSeverityFailsClosed() {
    IllegalArgumentException error =
        assertThrows(
            IllegalArgumentException.class, () -> classifier.classify(" ", "SINGLE_USER", false));
    assertEquals("severity is required", error.getMessage());
  }

  @Test
  void unsupportedImpactFailsClosed() {
    IllegalArgumentException error =
        assertThrows(
            IllegalArgumentException.class, () -> classifier.classify("LOW", "CONTINENT", false));
    assertEquals("unsupported impact: CONTINENT", error.getMessage());
  }
}
