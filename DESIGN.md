# Template Java Pilot Design

**Status:** Approved 2026-08-10

## Problem

Local mapper contracts do not prove that the inherited Java workflow succeeds
on GitHub-hosted runners with a real Maven consumer.

## Decision

Implement a framework-free `TicketPriorityClassifier` on Java 21. It accepts
severity, customer impact, and a security-incident flag and returns `P1`, `P2`,
`P3`, or `P4`.

## Business rules

1. A security incident or critical severity returns `P1`.
2. High severity or business-wide impact returns `P2`.
3. Medium severity or multiple-user impact returns `P3`.
4. All other supported combinations return `P4`.
5. Blank and unsupported values fail with `IllegalArgumentException`.
6. The public boundary accepts case-insensitive values, surrounding whitespace,
   and hyphenated enum words.

## Quality contract

- Java release 21 and explicitly pinned Maven plugins.
- Spotless formatting and Google Checkstyle validation.
- JUnit unit, integration, and E2E behavior tests.
- JaCoCo overall line coverage of at least 80%.
- Standard JAR output under `target/`.

## Security and data

The classifier uses synthetic inputs, requires no credential, performs no I/O,
and has no external integration.

## Acceptance criteria

The pull request must execute and pass Java quality, test, coverage, build,
CodeQL, OSV, secret, documentation, metadata, and workflow-security controls.
After human-approved merge, the main workflow must create a Java artifact and
provenance attestation.
