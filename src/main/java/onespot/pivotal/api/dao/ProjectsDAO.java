package onespot.pivotal.api.dao;

import com.google.common.collect.Multimap;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.exceptions.UnirestException;
import onespot.pivotal.api.resources.Project;
import onespot.pivotal.rest.JsonRestClient;

import java.util.List;

/**
 * Created by ian on 3/29/15.
 */
public class ProjectsDAO extends DAO {

    public ProjectsDAO(JsonRestClient jsonRestClient, String pathPrefix, Multimap<String, String> params) {
        super(jsonRestClient, pathPrefix, params);
    }

    public List<Project> id() throws UnirestException {
        return jsonRestClient.get(new TypeToken<List<Project>>(){}.getType(), path, params);
    }

    public ProjectDAO id(int id) throws UnirestException {
        return new ProjectDAO(jsonRestClient, path +"/"+id, params);
    }
}
