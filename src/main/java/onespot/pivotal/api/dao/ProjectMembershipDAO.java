package onespot.pivotal.api.dao;

import com.google.common.collect.Multimap;
import onespot.pivotal.api.resources.ProjectMembership;
import onespot.pivotal.rest.JsonRestClient;

/**
 * Author: Arthur Halet
 * Date: 12/07/2016
 */
public class ProjectMembershipDAO extends DAO {
    public ProjectMembershipDAO(JsonRestClient jsonRestClient, String path, Multimap<String, String> params) {
        super(jsonRestClient, path, params);
    }

    public ProjectMembership get() {
        return (ProjectMembership) this.jsonRestClient.get(ProjectMembership.class, this.path, this.params);
    }
}
