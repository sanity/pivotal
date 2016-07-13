package onespot.pivotal.api.resources;

import java.time.Instant;
import java.util.List;

/**
 * Created by ian on 4/3/15.
 */
public class Comment {
    public Integer id;
    public Integer storyId;
    public Integer epicId;
    public String text;
    public String url;
    public Integer personId;
    public Person person;
    public Instant createdAt, updatedAt;
    public List<Integer> fileAttachmentIds;
    // TODO: add fileAttachments;
    public List<Integer> googleAttachmentIds;
    // TODO: add googleAttachments
    public String commitIdentifier;
    public String kind;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getStoryId() {
        return storyId;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }

    public Integer getEpicId() {
        return epicId;
    }

    public void setEpicId(Integer epicId) {
        this.epicId = epicId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
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

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Integer> getFileAttachmentIds() {
        return fileAttachmentIds;
    }

    public void setFileAttachmentIds(List<Integer> fileAttachmentIds) {
        this.fileAttachmentIds = fileAttachmentIds;
    }

    public List<Integer> getGoogleAttachmentIds() {
        return googleAttachmentIds;
    }

    public void setGoogleAttachmentIds(List<Integer> googleAttachmentIds) {
        this.googleAttachmentIds = googleAttachmentIds;
    }

    public String getCommitIdentifier() {
        return commitIdentifier;
    }

    public void setCommitIdentifier(String commitIdentifier) {
        this.commitIdentifier = commitIdentifier;
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
}
