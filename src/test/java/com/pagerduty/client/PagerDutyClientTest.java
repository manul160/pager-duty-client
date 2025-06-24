package com.pagerduty.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.pagerduty.client.model.Team;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagerDutyClientTest {


    private static final int port = 8905;
    private static WireMockServer wireMockServer;

    @BeforeEach
    public void setUp() {
        wireMockServer = new WireMockServer(port);
        wireMockServer.start();
    }

    @AfterEach
    public void tearDown() {
        wireMockServer.stop();
    }


    @Test
    void fetchAllTeams_returnsTeamsFromStub() throws IOException {
        wireMockServer.stubFor(get(urlPathEqualTo("/teams"))
                .willReturn(ok().withBody("{\"teams\":[{\"id\":\"T1\"},{\"id\":\"T2\"}]}")));

        PagerDutyClient client = new PagerDutyClient("http://localhost:" + port);
        List<Team> teams = client.getTeams();

        assertEquals(2, teams.size());
        assertEquals("T2", teams.get(1).getId());
    }
}
