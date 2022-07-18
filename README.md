## Id-Generator

This requirement is very simple, to generate a random string as an id. 

Class `org.mdnote.idgen.BadIdGenerator`  code is badly written, so try to refactor it.  Class `org.mdnote.idgen.RandomLogTraceIdGenerator` is the refactored code


###  Code check list

Check list guides us to write high-quality code, but only if you master the relevant concepts

* Code readability
  * Whether the code is easy to read, and whether the names of paths, class names, methods, and parameters are reasonable.
  * Whether to write comments (What: what this code does, why: why design it, how: how to use)
  * Whether the code neat
  * Are there unit tests that help us understand how the code is used
* Testability
  * Is there an Anti-Pattern (using static methods, pending conditions without abstraction)
  * Whether it conforms to the Dependency Inversion Principle
* Reusability and Extensibility
  * Whether the class and method conform to the Single Responsibility Principle, whether the design of the class utilizes the object-oriented feature, and whether it conforms to the interface-oriented rather than the implementation
  * Whether it conforms to SOLID, YANG, DRY, KISS LOC principles
* Performance
  * Is it possible to optimize (code, SQL, etc.)
  * Is it possible to use async to improve efficiency
* Feature
  * Whether it meets the requirements and covers all logic
  * Did you log
  * Is it easy to use
  * Does the code have concurrency issues
  * Is there a security breach

