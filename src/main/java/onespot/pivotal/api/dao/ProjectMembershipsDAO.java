package onespot.pivotal.api.dao;

import com.google.common.collect.Multimap;
import com.google.gson.reflect.TypeToken;
import onespot.pivotal.api.resources.ProjectMembership;
import onespot.pivotal.api.resources.Story;
import onespot.pivotal.rest.JsonRestClient;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Author: Arthur Halet
 * Date: 12/07/2016
 */
public class ProjectMembershipsDAO extends DAO {


    public ProjectMembershipsDAO(JsonRestClient jsonRestClient, String path, Multimap<String, String> params) {
        super(jsonRestClient, path, params);
    }

    public ProjectMembershipDAO id(int id) {
        return new ProjectMembershipDAO(this.jsonRestClient, this.path + "/" + id, this.params);
    }

    public ProjectMembership getMembershipFromStory(Story story) {
        return getMembershipFromPersonId(story.requestedById);
    }

    public ProjectMembership getMembershipFromPersonId(int personId) {
        for (ProjectMembership membership : getAll()) {
            if (membership.getPerson().id == personId) {
                return membership;
            }
        }
        return null;
    }

    protected Type getListTypeToken() {
        return (new TypeToken<List<ProjectMembership>>() {
        }).getType();
    }

    public List<ProjectMembership> getAll() {
        return this.jsonRestClient.get(getListTypeToken(), this.path, this.params);
    }
}
