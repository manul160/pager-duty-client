package com.pagerduty.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListUser {

    private String id;
    private String type;
    private String summary;
    private String self;
    private String html_url;
    private String name;
    private String email;
    @SerializedName("time_zone")
    private String timeZone;
    private String color;
    private String role;
    private String avatar_url;
    private String description;

    public List<UserTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<UserTeam> teams) {
        this.teams = teams;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public List<NotificationRule> getNotification_rules() {
        return notification_rules;
    }

    public void setNotification_rules(List<NotificationRule> notification_rules) {
        this.notification_rules = notification_rules;
    }

    public List<ContactMethod> getContact_methods() {
        return contact_methods;
    }

    public void setContact_methods(List<ContactMethod> contact_methods) {
        this.contact_methods = contact_methods;
    }

    public boolean isInvitation_sent() {
        return invitation_sent;
    }

    public void setInvitation_sent(boolean invitation_sent) {
        this.invitation_sent = invitation_sent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean invitation_sent;
    private List<ContactMethod> contact_methods;
    private List<NotificationRule> notification_rules;
    private String job_title;
    private List<UserTeam> teams;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}



