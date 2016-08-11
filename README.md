# teambulker
A Java CLI tool to bulk-invite users to your HelloSign team.

## Run It

Make sure you have [Java](https://java.com/en/download/) installed.

1. Download [the JAR](/releases/download/v1.0/teambulker.jar).
1. Get your [HelloSign API key](https://www.hellosign.com/home/myAccount/current_tab/integrations#api).
1. Execute one of the following from a command line:

```bash
# Invite a single user to your team:
java -jar <path_to_JAR_file> <api_key> <email_address>
```

Or:

```bash
# Invite multiple users with a text file, one email address per line:
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