package com.hellosign.teambulker;

import org.json.JSONArray;
import org.json.JSONObject;

import com.hellosign.sdk.HelloSignClient;
import com.hellosign.sdk.HelloSignException;
import com.hellosign.sdk.resource.Account;
import com.hellosign.sdk.resource.Team;

public class MockClient extends HelloSignClient {

    public MockClient(String apiKey) {
        super(apiKey);
    }

    @Override
    public Team inviteTeamMember(String idOrEmail) throws HelloSignException {
        JSONObject teamJson = new JSONObject();
        JSONArray accounts = new JSONArray();
        JSONObject accountJson = new JSONObject();
        try {
            accountJson.put(Account.ACCOUNT_EMAIL_ADDRESS, idOrEmail);
            accounts.put(accountJson);
            teamJson.put(Team.TEAM_ACCOUNTS, accounts);
        } catch (Exception ex) {
            throw new HelloSignException("Couldn't invite team member: " + ex.getMessage());
        }
        return new Team(teamJson);
    }
}
