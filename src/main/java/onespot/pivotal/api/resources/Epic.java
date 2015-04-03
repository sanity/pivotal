package onespot.pivotal.api.resources;

import java.time.Instant;
import java.util.List;

/**
 * Created by ian on 4/3/15.
 */
public class Epic {
    public int id;
    public int projectId;
    public String name;
    public int labelId;
    public Label label;
    public String description;
    public List<Integer> commentIds;
    public List<Comment> comments;
    public List<Integer> followerIds;
    public List<Person> followers;
    public Instant createdAt, updatedAt;
    public Integer afterId, beforeId;
    public String url;
    public String kind;

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

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(List<Integer> commentIds) {
        this.commentIds = commentIds;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Integer> getFollowerIds() {
        return followerIds;
    }

    public void setFollowerIds(List<Integer> followerIds) {
        this.followerIds = followerIds;
    }

    public List<Person> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Person> followers) {
        this.followers = followers;
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

    public Integer getAfterId() {
        return afterId;
    }

    public void setAfterId(Integer afterId) {
        this.afterId = afterId;
    }

    public Integer getBeforeId() {
        return beforeId;
    }

    public void setBeforeId(Integer beforeId) {
        this.beforeId = beforeId;
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

    public enum EpicFieldNames {
        id,project_id,name,label_id,label,description,comment_ids,comments,follower_ids,followers,created_at,updated_at,after_id,before_id,url,kind
    }
}
