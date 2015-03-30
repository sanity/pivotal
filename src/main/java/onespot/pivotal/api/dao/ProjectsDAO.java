package onespot.pivotal.api.dao;

import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.exceptions.UnirestException;
import gumi.builders.url.UrlParameterMultimap;
import onespot.pivotal.api.resources.Project;
import onespot.pivotal.rest.JsonRestClient;

import java.util.List;

/**
 * Created by ian on 3/29/15.
 */
public class ProjectsDAO extends DAO {

    public ProjectsDAO(JsonRestClient jsonRestClient, String pathPrefix, UrlParameterMultimap params) {
        super(jsonRestClient, pathPrefix, params);
    }

    public List<Project> get() throws UnirestException {
        return jsonRestClient.get(new TypeToken<List<Project>>(){}.getType(), path, params);
    }

    public ProjectDAO get(int id) throws UnirestException {
        return new ProjectDAO(jsonRestClient, path +"/"+id, params);
    }
}
