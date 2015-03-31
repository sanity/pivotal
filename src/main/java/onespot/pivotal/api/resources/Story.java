package onespot.pivotal.api.resources;

import java.time.Instant;
import java.util.List;

/**
 * Created by ian on 3/27/15.
 */
public class Story {
    public int id;
    public int projectId;
    public String name;
    public String description;
    public StoryType storyType;
    public StoryState currentState;
    public float estimate;
    public Instant acceptedAt, deadline, createdAt, updatedAt;
    public int requestedById;
    public List<Integer> ownerIds, labelIds, taskIds, followerIds, commentIds;
    public List<Label> labels;
    public Integer beforeId, afterId;
    public int integrationId;
    public List<Person> owners;
    public String externalId;
    public String url;
    public String kind;

    public List<Person> getOwners() {
        return owners;
    }

    public void setOwners(List<Person> owners) {
        this.owners = owners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Story story = (Story) o;

        if (id != story.id) return false;
        return projectId == story.projectId;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + projectId;
        return result;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StoryType getStoryType() {
        return storyType;
    }

    public void setStoryType(StoryType storyType) {
        this.storyType = storyType;
    }

    public StoryState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(StoryState currentState) {
        this.currentState = currentState;
    }

    public float getEstimate() {
        return estimate;
    }

    public void setEstimate(float estimate) {
        this.estimate = estimate;
    }

    public Instant getAcceptedAt() {
        return acceptedAt;
    }

    public void setAcceptedAt(Instant acceptedAt) {
        this.acceptedAt = acceptedAt;
    }

    public Instant getDeadline() {
        return deadline;
    }

    public void setDeadline(Instant deadline) {
        this.deadline = deadline;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getRequestedById() {
        return requestedById;
    }

    public void setRequestedById(int requestedById) {
        this.requestedById = requestedById;
    }

    public List<Integer> getOwnerIds() {
        return ownerIds;
    }

    public void setOwnerIds(List<Integer> ownerIds) {
        this.ownerIds = ownerIds;
    }

    public List<Integer> getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(List<Integer> labelIds) {
        this.labelIds = labelIds;
    }

    public List<Integer> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<Integer> taskIds) {
        this.taskIds = taskIds;
    }

    public List<Integer> getFollowerIds() {
        return followerIds;
    }

    public void setFollowerIds(List<Integer> followerIds) {
        this.followerIds = followerIds;
    }

    public List<Integer> getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(List<Integer> commentIds) {
        this.commentIds = commentIds;
    }

    public Integer getBeforeId() {
        return beforeId;
    }

    public void setBeforeId(Integer beforeId) {
        this.beforeId = beforeId;
    }

    public Integer getAfterId() {
        return afterId;
    }

    public void setAfterId(Integer afterId) {
        this.afterId = afterId;
    }

    public int getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(int integrationId) {
        this.integrationId = integrationId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public enum StoryType {
        feature, bug, chore, release
    }

    public enum StoryState {
        accepted, delivered, finished, started, rejected, planned, unstarted, unscheduled
    }
}
