# Template Java Pilot Architecture

**Status:** Hosted validation pilot

## Runtime boundary

The runtime consists only of the pure Java `TicketPriorityClassifier` and its
`Priority` result enum. There is no server, database, queue, cache, filesystem,
network, provider, or deployment boundary.

## Build boundary

The root `pom.xml` owns Java 21 compilation, JUnit, Spotless, Checkstyle,
JaCoCo, Surefire, and JAR output. The inherited template mapper invokes Maven;
the consumer does not replace workflow commands.

## Data flow

```text
severity + customer impact + security flag
                    |
                    v
        TicketPriorityClassifier
                    |
                    v
             P1 | P2 | P3 | P4
```

Invalid input stops at the classifier boundary with `IllegalArgumentException`.
No input is stored or transmitted.

## Delivery boundary

GitHub Actions runs inherited quality, test, security, build, and attestation
workflows. Deployment and smoke-test workflows remain unwired and out of scope.
