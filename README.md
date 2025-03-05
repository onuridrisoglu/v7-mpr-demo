**Vaadin 7 MRP Demo**

This is a demo project that shows how to migrate a Vaadin 7 application to Vaadin 24 using MPR (Multiplatform Runtime).

It consists of 3 commits:

- Initial Commit is the sample Vaadin 7 application
- Configuring MPR so that the whole app is wrapped inside Vaadin 24
- Migrating the layouts to Vaadin 24 - while keeping the Vaadin 7 Grid

Run `mvn jetty:run` command to start the project. Note that Vaadin 7 requires Java 8 while Vaadin 24 part needs Java 17
