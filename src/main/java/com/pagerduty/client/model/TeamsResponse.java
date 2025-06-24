package com.pagerduty.client.model;

import java.util.List;

public class TeamsResponse {
    private List<Team> teams;
    private int limit;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    private int offset;
    private String total;
    private boolean more;
    public TeamsResponse() {}

    public List<Team> getTeams() {
        return teams;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "teams=" + teams +
                ", limit=" + limit +
                ", offset=" + offset +
                ", total='" + total + '\'' +
                ", more=" + more +
                '}';
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
