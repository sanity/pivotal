package onespot.pivotal.api.dao;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.Multimap;
import com.google.gson.reflect.TypeToken;

import onespot.pivotal.api.resources.Project;
import onespot.pivotal.rest.JsonRestClient;

/**
 * Created by ian on 3/29/15.
 */
public class ProjectsDAO extends DAO {

    public ProjectsDAO(JsonRestClient jsonRestClient, String pathPrefix, Multimap<String, String> params) {
        super(jsonRestClient, pathPrefix, params);
    }

    public List<Project> id() {
        return jsonRestClient.get(new TypeToken<List<Project>>(){}.getType(), path, params);
    }

    public ProjectDAO id(int id) {
        return new ProjectDAO(jsonRestClient, path +"/"+id, params);
    }

    public ProjectsDAO withFields(Project.ProjectFieldNames... fields) {
        params.put("fields", Joiner.on(',').join(fields));
        return this;
    }
}
