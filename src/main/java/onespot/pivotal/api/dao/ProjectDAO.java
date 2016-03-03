package onespot.pivotal.api.dao;

import java.util.Map;

import onespot.pivotal.api.resources.Project;
import onespot.pivotal.rest.JsonRestClient;

/**
 * Created by ian on 3/29/15.
 */
public class ProjectDAO extends DAO {
    public ProjectDAO(JsonRestClient jsonRestClient, String pathPrefix, Map<String, String> params) {
        super(jsonRestClient, pathPrefix, params);
    }

    public Project get() {
        return jsonRestClient.get(Project.class, path, params);
    }

    public StoriesDAO stories()  {
        return new StoriesDAO(jsonRestClient, path +"/stories", params);
    }

    public IterationsDAO iterations()  {
        return new IterationsDAO(jsonRestClient, path + "/iterations", params);
    }

    public LabelsDAO labels()  {
        return new LabelsDAO(jsonRestClient, path+"/labels", params);
    }

    public EpicsDAO epics()  {
        return new EpicsDAO(jsonRestClient, path+"/epics", params);
    }
    
    public ActivitiesDAO activity() {
        return new ActivitiesDAO(jsonRestClient, path + "/activity", params);
    }
}
