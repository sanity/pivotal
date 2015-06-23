package onespot.pivotal.api.resources;

import com.google.gson.JsonObject;

import java.time.Instant;
import java.util.List;

/**
 * Created by ian on 4/1/15.
 */
public class Activity {
    private String kind;
    private String guid;
    private Integer projectVersion;
    private String message;
    private String highlight;
    // TODO: Map these to POJOs rather than arbitrary JsonObjects, problem is
    //       that the API spec doesn't appear to specify the schema for these
    //       changes or resources, except by way of example, which may be
    //       fragile.
    private List<JsonObject> changes, primaryResources;
    private Integer projectId;
    private Project project;
    private Integer performedById;
    private Person performedBy;
    private Instant occurredAt;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (!guid.equals(activity.guid)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return guid.hashCode();
    }

    @Override

    public String toString() {
        return "Activity{" +
                "message='" + message + '\'' +
                ", guid='" + guid + '\'' +
                '}';
    }
}
