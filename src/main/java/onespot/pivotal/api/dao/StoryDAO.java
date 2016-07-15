package onespot.pivotal.api.dao;

import com.google.common.collect.Multimap;
import onespot.pivotal.api.resources.ProjectMembership;
import onespot.pivotal.api.resources.Story;
import onespot.pivotal.rest.JsonRestClient;

/**
 * Created by ian on 3/29/15.
 */
public class StoryDAO extends DAO {
    public StoryDAO(JsonRestClient jsonRestClient, String path, Multimap<String, String> params) {
        super(jsonRestClient, path, params);
    }

    public Story get() {
        Story story = jsonRestClient.get(Story.class, path, params);
        story.setOwners(this.owners().getAll());
        story.setRequester(this.requester(story).getPerson());
        return story;
    }

    public void put(Story story) {
        jsonRestClient.put(Story.class, path, params, story);
    }

    public OwnersDAO owners() {
        return new OwnersDAO(jsonRestClient, path + "/owners", params);
    }

    public CommentsDAO comments() {
        return new CommentsDAO(jsonRestClient, path + "/comments", params);
    }

    public ProjectMembership requester() {
        Story story = this.get();
        return this.requester(story);
    }

    private ProjectMembership requester(Story story) {
        String[] pathSplitted = this.path.split("/");
        String[] finalPathSplitted = new String[pathSplitted.length - 1];
        pathSplitted[pathSplitted.length - 2] = "memberships";
        System.arraycopy(pathSplitted, 0, finalPathSplitted, 0, pathSplitted.length - 1);
        String membershipsPath = String.join("/", finalPathSplitted);
        ProjectMembershipsDAO projectMembershipsDAO = new ProjectMembershipsDAO(jsonRestClient, membershipsPath, params);
        return projectMembershipsDAO.getMembershipFromStory(story);
    }

    public ActivitiesDAO activity() {
        return new ActivitiesDAO(jsonRestClient, path + "/activity", params);
    }
}
