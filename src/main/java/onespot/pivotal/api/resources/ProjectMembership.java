package onespot.pivotal.api.resources;

import java.time.Instant;

/**
 * Author: Arthur Halet
 * Date: 12/07/2016
 */
public class ProjectMembership {
    public Integer id;
    public String name;
    public String kind;
    public Person person;
    public Instant createdAt;
    public Instant lastViewedAt;
    public Instant updatedAt;
    public int projectId;
    public String projectColor;
    public String role;
    public boolean wantsCommentNotificationEmails;
    public boolean willReceiveMentionNotificationsOrEmails;

    public ProjectMembership() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getLastViewedAt() {
        return lastViewedAt;
    }

    public void setLastViewedAt(Instant lastViewedAt) {
        this.lastViewedAt = lastViewedAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectColor() {
        return projectColor;
    }

    public void setProjectColor(String projectColor) {
        this.projectColor = projectColor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isWantsCommentNotificationEmails() {
        return wantsCommentNotificationEmails;
    }

    public void setWantsCommentNotificationEmails(boolean wantsCommentNotificationEmails) {
        this.wantsCommentNotificationEmails = wantsCommentNotificationEmails;
    }

    public boolean isWillReceiveMentionNotificationsOrEmails() {
        return willReceiveMentionNotificationsOrEmails;
    }

    public void setWillReceiveMentionNotificationsOrEmails(boolean willReceiveMentionNotificationsOrEmails) {
        this.willReceiveMentionNotificationsOrEmails = willReceiveMentionNotificationsOrEmails;
    }
}
