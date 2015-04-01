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
    // TODO: Might not be flexible enough
    public List<JsonObject> changes, primaryResources;
    public Integer projectId;
    public Project project;
    public Integer performedById;
    public Person performedBy;
    public Instant occurredAt;
}
