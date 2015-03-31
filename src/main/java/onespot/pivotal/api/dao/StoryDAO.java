package onespot.pivotal.api.dao;

import com.mashape.unirest.http.exceptions.UnirestException;
import gumi.builders.url.UrlParameterMultimap;
import onespot.pivotal.api.resources.Story;
import onespot.pivotal.rest.JsonRestClient;

/**
 * Created by ian on 3/29/15.
 */
public class StoryDAO extends DAO {
    public StoryDAO(JsonRestClient jsonRestClient, String path, UrlParameterMultimap params) {
        super(jsonRestClient, path, params);
    }

    public Story get() throws UnirestException {
        return jsonRestClient.get(Story.class, path, params);
    }

    public void put(Story story) throws UnirestException {
        jsonRestClient.put(Story.class, path, params, story);
    }

    public OwnersDAO owners() {
        return new OwnersDAO(jsonRestClient, path + "/owners", params);
    }
}
