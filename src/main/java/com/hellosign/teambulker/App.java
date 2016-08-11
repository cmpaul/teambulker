package com.hellosign.teambulker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.routines.EmailValidator;

import com.hellosign.sdk.HelloSignClient;
import com.hellosign.sdk.HelloSignException;
import com.hellosign.sdk.resource.Account;
import com.hellosign.sdk.resource.Team;
import com.hellosign.sdk.resource.support.Warning;

/**
 * Hello world!
 *
 */
public class App {

    private HelloSignClient client;

    public App(HelloSignClient client) {
        this.client = client;
    }

    /**
     * Invites the given user to the currently authenticated user's team.
     * @param email String email address of the new team member to add.
     * @return true if the invite was successful
     */
    public boolean addTeamMember(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        if (validator.isValid(email)) {
            try {
                System.out.print("Attempting to invite " + email + "... ");
                Team t = client.inviteTeamMember(email);
                System.out.println("SUCCESS! Invited to team: " + t.getName());
                for (Warning w : t.getWarnings()) {
                    System.out.println("  WARNING: " + w.getMessage());
                }
            } catch (HelloSignException ex) {
                System.out.println("FAILED! " + ex.getMessage());
            }
        } else {
            System.out.println("Email is not valid: " + email);
        }
        return false;
    }

    /**
     * Reads emails from a file, one email address per line,
     * and invites the email to the currently authenticated user's team.
     * @param f File
     */
    public void processFile(File f) {
        if (!f.exists() || f.length() <= 0) {
            System.out.println("File does not exist or is empty: " + f.getAbsolutePath());
            return;
        }
        List<String> emails = new ArrayList<String>();
        try {   
            FileReader fileReader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                emails.add(line);
            }
            bufferedReader.close();
        } catch (Exception ex) {
            System.out.println("Unable to process file " + f.getAbsolutePath() + ": " + ex.getMessage());
        }
        for (String email : emails) {
            this.addTeamMember(email);
        }
    }

    /**
     * Main function for running the application via the command line.
     * @param args command line arguments:
     *  - API Key
     *  - email address OR CSV file
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Invite team members to your HelloSign team in bulk.");
            System.out.println("Usage:");
            System.out.println("  java -jar teambulker.jar api_key csv_path");
            System.out.println("  java -jar teambulker.jar api_key email_address");
            return;
        }
        String apikey = args[0];
        System.out.print("Initializing...");
        HelloSignClient client = new HelloSignClient(apikey);
        App app = new App(client);
        System.out.println("OK");
        String emailOrFile = args[1];
        if (EmailValidator.getInstance().isValid(emailOrFile)) {
            app.addTeamMember(emailOrFile);
        } else {
            app.processFile(new File(emailOrFile));
        }
        System.out.println("Done");
    }
}
