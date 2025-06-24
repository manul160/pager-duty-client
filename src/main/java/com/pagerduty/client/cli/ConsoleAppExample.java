package com.pagerduty.client.cli;

import com.pagerduty.client.PagerDutyClient;
import com.pagerduty.client.model.Team;
import com.pagerduty.client.utils.HttpUtil;

import java.io.IOException;
import java.util.*;

public class ConsoleAppExample {
    public void run() {
        try {
            PagerDutyClient client = new PagerDutyClient();
            List<Team> teams = client.getTeams();
            if (teams == null || teams.isEmpty()) {
                System.out.println("No teams were found");
                return;
            }
            teams.forEach(team -> System.out.println("The team ID is: " + team.getId() + " and the name is " + team.getName()));
            System.out.println("In total we got " + teams.size() + " teams");

            System.out.print("Please provide a team ID: ");
            String userInput = HttpUtil.readKeyboardInputFromUser();
            if (teams.stream().noneMatch(team -> team.getId().equals(userInput))) {
                System.out.println("The team ID you typed is not valid.");
            } else {
                client.getUsersByTeamId(userInput).forEach(u ->
                        System.out.println("User name is " + u.getName() + " and email is: " + u.getEmail()));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
