# teambulker
A Java CLI tool to bulk-invite users to your HelloSign team.

## Run It

1. Download [the JAR](releases/latest/teambulker.jar).
1. Get your [HelloSign API key](https://www.hellosign.com/home/myAccount/current_tab/integrations#api).
1. Execute one of the following from a command line:
  1. To invite a single user to your team:
    ```bash
    java -jar <path_to_JAR_file> <api_key> <email_address>
    ```
  1. To invite multiple users to your team from a text file (one email address per line):
    ```bash
    java -jar <path_to_JAR_file> <api_key> <file_path>
    ```

## Build It

To build from source, make sure you have [Maven](https://maven.apache.org/) and a [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) installed.

Run:

```bash
mvn clean compile assembly:single
```

## Test It

```bash
mvn clean compile test
```