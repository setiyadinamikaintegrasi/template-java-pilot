package id.setiyadinamika.pilot.ticket;

import java.util.Locale;

public final class TicketPriorityClassifier {
  private enum Severity {
    LOW,
    MEDIUM,
    HIGH,
    CRITICAL
  }

  private enum Impact {
    SINGLE_USER,
    MULTIPLE_USERS,
    BUSINESS_WIDE
  }

  public Priority classify(String severityValue, String impactValue, boolean securityIncident) {
    Severity severity = parse("severity", severityValue, Severity.class);
    Impact impact = parse("impact", impactValue, Impact.class);

    if (securityIncident || severity == Severity.CRITICAL) {
      return Priority.P1;
    }
    if (severity == Severity.HIGH || impact == Impact.BUSINESS_WIDE) {
      return Priority.P2;
    }
    if (severity == Severity.MEDIUM || impact == Impact.MULTIPLE_USERS) {
      return Priority.P3;
    }
    return Priority.P4;
  }

  private static <T extends Enum<T>> T parse(String field, String value, Class<T> type) {
    if (value == null || value.isBlank()) {
      throw new IllegalArgumentException(field + " is required");
    }
    try {
      String normalized = value.trim().toUpperCase(Locale.ROOT).replace('-', '_');
      return Enum.valueOf(type, normalized);
    } catch (IllegalArgumentException error) {
      throw new IllegalArgumentException("unsupported " + field + ": " + value, error);
    }
  }
}
