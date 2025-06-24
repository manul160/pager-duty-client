package com.pagerduty.client;

import com.pagerduty.client.model.ListUser;
import com.pagerduty.client.model.Team;
import com.pagerduty.client.model.TeamsResponse;
import com.pagerduty.client.model.UsersResponse;
import com.pagerduty.client.utils.HttpUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PagerDutyClient {
    private final static String BASE_PATH = "https://api.pagerduty.com";
    private final static String LIST_TEAMS_ENDPOINT = "/teams";
    private final static String LIST_USERS_ENDPOINT = "/users";

    private final String basePath;

    public PagerDutyClient(String basePath) {
        this.basePath = basePath;
    }

    public PagerDutyClient() {
        this(BASE_PATH);
    }

    public List<Team> getTeams() throws IOException {
        TeamsResponse teamsResp = getTeamsResponse();
        if (teamsResp == null || teamsResp.getTeams() == null) {
            return Collections.emptyList();
        }
        List<Team> allTeams = new ArrayList<>(teamsResp.getTeams());
        int offset = 1;
        while (teamsResp.isMore()) {
            teamsResp = getTeamsResponse(offset++);
            if (teamsResp != null && teamsResp.getTeams() != null) {
                allTeams.addAll(teamsResp.getTeams());
            } else {
                System.out.println("An error occurred during teams retrieval.");
                return Collections.emptyList();
            }
        }

        return allTeams;
    }

    public List<ListUser> getUsers() throws IOException {
        String responseStr;
//        String getPath = offset == null ? getFullPath(LIST_USERS_ENDPOINT) : getFullPath(LIST_USERS_ENDPOINT, "offset", offset.toString());

        responseStr = HttpUtil.httpGetRequest(getFullPath(LIST_USERS_ENDPOINT, "include[]", "contact_methods"));
        return HttpUtil.parseJsonToObject(responseStr, UsersResponse.class).getUsers();
    }

    public List<ListUser> getUsersByTeamId(String teamId) throws IOException {
        String responseStr;
        responseStr = HttpUtil.httpGetRequest(getFullPath(LIST_USERS_ENDPOINT, "team_ids[]", teamId));
        return HttpUtil.parseJsonToObject(responseStr, UsersResponse.class).getUsers();
    }

    private TeamsResponse getTeamsResponse() throws IOException {
        return getTeamsResponse(null);
    }

    private TeamsResponse getTeamsResponse(Integer offset) throws IOException {
        String responseStr;
        try {
            String getPath = offset == null ? getFullPath(LIST_TEAMS_ENDPOINT, "limit", "1") : getFullPath(LIST_TEAMS_ENDPOINT, "limit", "1", "offset", offset.toString());
            responseStr = HttpUtil.httpGetRequest(getPath);
            return HttpUtil.parseJsonToObject(responseStr, TeamsResponse.class);
        } catch (Exception e) {
            System.out.println("Couldn't get and parse teams properly");
            return null;
        }
    }

    public void getTeamsResponse2() throws IOException {
        String responseStr;
        try {
            String getPath = getFullPath(LIST_TEAMS_ENDPOINT, "limit", "1");
            responseStr = HttpUtil.httpGetRequest(getPath);
            Map<String, Object> res = (Map<String, Object>) HttpUtil.parseJsonToMap(responseStr);
            List<Map<String, Object>> teams = (List<Map<String, Object>>) res.get("teams");
            for (Map<String, Object> team : teams) {
                String id = (String) team.get("id");
                String name = (String) team.get("name");
                String summary = (String) team.get("summary"); // may be null
                System.out.printf("Team ID: %s, Name: %s, Summary: %s%n",
                        id, name, summary);
            }
        } catch (Exception e) {
            System.out.println("Couldn't get and parse teams properly");
        }
    }



    private String getFullPath(String apiEndpoint, String... queryParams) {
        String queryString = "";
        if (queryParams.length > 0) {
            StringBuilder sb;
            sb = new StringBuilder("?" + queryParams[0] + "=" + queryParams[1]);
            for (int i = 2; i < queryParams.length; i += 2) {
                sb.append("&").append(queryParams[i]).append("=").append(queryParams[i + 1]);
            }
            queryString = sb.toString();
        }

        return basePath + apiEndpoint + queryString;
    }


}
