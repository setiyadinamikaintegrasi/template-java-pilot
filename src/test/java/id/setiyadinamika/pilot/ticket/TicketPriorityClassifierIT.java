package id.setiyadinamika.pilot.ticket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TicketPriorityClassifierIT {
  @Test
  void normalizesPublicBoundaryValues() {
    TicketPriorityClassifier classifier = new TicketPriorityClassifier();

    assertEquals(Priority.P2, classifier.classify(" high ", "single-user", false));
  }
}
