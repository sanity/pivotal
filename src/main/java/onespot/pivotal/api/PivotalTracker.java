package onespot.pivotal.api;

import com.google.common.collect.HashMultimap;

import onespot.pivotal.api.dao.ProjectsDAO;
import onespot.pivotal.api.resources.Me;
import onespot.pivotal.rest.JsonRestClient;
import onespot.pivotal.rest.PivotalRestClient;

/**
 * Created by ian on 3/28/15.
 */
public class PivotalTracker {

    private JsonRestClient jsonRestClient;

    public PivotalTracker(String pivotalToken) {
        this(new JsonRestClient(new PivotalRestClient(pivotalToken)));
    }

    public PivotalTracker(JsonRestClient jsonRestClient) {
        this.jsonRestClient = jsonRestClient;
    }

    public Me getMe() {
        return jsonRestClient.get(Me.class, "me", HashMultimap.create());
    }

    public ProjectsDAO projects() {
        return new ProjectsDAO(jsonRestClient, "projects", HashMultimap.create());
    }


}
