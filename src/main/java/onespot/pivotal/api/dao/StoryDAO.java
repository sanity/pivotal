package onespot.pivotal.api.dao;

import com.google.common.collect.Multimap;

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
        return jsonRestClient.get(Story.class, path, params);
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


    public ActivitiesDAO activity() {
        return new ActivitiesDAO(jsonRestClient, path + "/activity", params);
    }
}
