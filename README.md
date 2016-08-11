# teambulker
A Java CLI tool to bulk-invite users to your HelloSign team.

## Run It

1. Download the JAR.
1. Get your HelloSign API key.
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

mvn clean compile assembly:single