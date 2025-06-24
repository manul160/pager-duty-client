package com.pagerduty.client.model;

import java.util.List;

public class UsersResponse {
    private List<ListUser> users;
    private int limit;
    private int offset;
    private boolean more;

    public List<ListUser> getUsers() {
        return users;
    }

    public void setUsers(List<ListUser> users) {
        this.users = users;
    }

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

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public boolean isTotal() {
        return total;
    }

    public void setTotal(boolean total) {
        this.total = total;
    }

    private boolean total;

}
