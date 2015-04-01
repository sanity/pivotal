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
}
