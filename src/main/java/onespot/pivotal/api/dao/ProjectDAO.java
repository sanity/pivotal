package onespot.pivotal.api.dao;

import com.mashape.unirest.http.exceptions.UnirestException;
import gumi.builders.url.UrlParameterMultimap;
import onespot.pivotal.api.resources.Project;
import onespot.pivotal.rest.JsonRestClient;

/**
 * Created by ian on 3/29/15.
 */
public class ProjectDAO extends DAO {
    public ProjectDAO(JsonRestClient jsonRestClient, String pathPrefix, UrlParameterMultimap params) {
        super(jsonRestClient, pathPrefix, params);
    }

    public Project get() throws UnirestException {
        return jsonRestClient.get(Project.class, path, params);
    }

    public StoriesDAO stories() throws UnirestException {
        return new StoriesDAO(jsonRestClient, path +"/stories", params);
    }
}
