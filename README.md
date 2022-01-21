This project was forked in order to test it using ArchUnit. The file README.md contains the documentation of the original project.

With this project we want to show how to use ArchUnit to test some architectural feature of a Java Project. Some of these are preimplemented in the ArchUnit API, some other have been implemented from scratch.

All test classes concerning the architectural level are located in src/test/java/alexp/blog/arch.


# Installation

Requirements:
- JDK 8
- Maven
- (Optional) A Java IDE like IntelliJ

Steps using the shell:
1. Clone the repository (`git clone https://github.com/KronosRob/Progetto-OOBD-2021-2022.git` or download and extract zip archive);
2. Go inside the project directory;
3. Use Maven in order to execute all tests (`mvn test`);
4. Use Maven in order to see all metrics values for all components (`mvn test-compile exec:java`)


Steps using IntelliJ:
1. Clone the repository (`git clone https://github.com/KronosRob/Progetto-OOBD-2021-2022.git` or download and extract zip archive);
2. Open the project using Intellij
3. In order to execute all tests, open a test class and execute manually each test;
4. In order to see each metrics value for each component, open the metrics class MetricsRunner.java and execute the main() method. 