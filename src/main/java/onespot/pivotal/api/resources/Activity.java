package onespot.pivotal.api.resources;

import com.google.gson.JsonObject;

import java.time.Instant;
import java.util.List;

/**
 * Created by ian on 4/1/15.
 */
public class Activity {
    public String kind;
    public String guid;
    public Integer projectVersion;
    public String message;
    public String highlight;
    // TODO: Map these to POJOs rather than arbitrary JsonObjects, problem is
    //       that the API spec doesn't appear to specify the schema for these
    //       changes or resources, except by way of example, which may be
    //       fragile.
    public List<JsonObject> changes, primaryResources;
    public Integer projectId;
    public Project project;
    public Integer performedById;
    public Person performedBy;
    public Instant occurredAt;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getProjectVersion() {
        return projectVersion;
    }

    public void setProjectVersion(Integer projectVersion) {
        this.projectVersion = projectVersion;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public List<JsonObject> getChanges() {
        return changes;
    }

    public void setChanges(List<JsonObject> changes) {
        this.changes = changes;
    }

    public List<JsonObject> getPrimaryResources() {
        return primaryResources;
    }

    public void setPrimaryResources(List<JsonObject> primaryResources) {
        this.primaryResources = primaryResources;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getPerformedById() {
        return performedById;
    }

    public void setPerformedById(Integer performedById) {
        this.performedById = performedById;
    }

    public Person getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(Person performedBy) {
        this.performedBy = performedBy;
    }

    public Instant getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(Instant occurredAt) {
        this.occurredAt = occurredAt;
    }
}
