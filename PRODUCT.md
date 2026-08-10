# Template Java Pilot Product

**Status:** Hosted validation pilot

## Product vision

Provide auditable evidence that a fresh Java 21/Maven consumer can adopt the
template-ai-native quality, security, build, artifact, and provenance controls
without framework or infrastructure dependencies.

## Users

- Template maintainers evaluating Java adoption readiness.
- Consumer engineers deciding whether the generic Java baseline is usable.
- Security and platform reviewers checking inherited controls.

## Business value

Reduce adoption risk by detecting Java-specific workflow gaps before a real
service depends on the template.

## Scope

- Deterministic ticket-priority domain logic.
- Unit, integration, E2E, coverage, quality, build, and hosted security checks.
- JAR artifact and post-merge provenance evidence.

## Out of scope

- Production service behavior, HTTP, persistence, authentication, deployment,
  AI providers, profile activation, and operational readiness.

## Success metrics

- Every applicable Java PR job executes and passes.
- Overall line coverage is at least 80%.
- A Java build artifact and post-merge attestation are produced.
- No inherited security control is weakened.
