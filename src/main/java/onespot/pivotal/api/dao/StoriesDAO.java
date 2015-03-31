package onespot.pivotal.api.dao;

import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.exceptions.UnirestException;
import gumi.builders.url.UrlParameterMultimap;
import onespot.pivotal.api.resources.Story;
import onespot.pivotal.rest.JsonRestClient;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.List;

/**
 * Created by ian on 3/29/15.
 */
public class StoriesDAO extends AbstractPaginatedDAO<Story> {
    public StoriesDAO(JsonRestClient jsonRestClient, String pathPrefix, UrlParameterMultimap params) {
        super(jsonRestClient, pathPrefix, params);
    }

    @Override
    protected Type getListTypeToken() {
        return new TypeToken<List<Story>>() {
        }.getType();
    }

    @Override
    public List<Story> get() throws UnirestException {
        return jsonRestClient.get(new TypeToken<List<Story>>() {
        }.getType(), path, params);
    }

    public StoryDAO id(int id) throws UnirestException {
        return new StoryDAO(jsonRestClient, "/" + id, params);
    }

    public void post(Story story) throws UnirestException {
        jsonRestClient.post(Story.class, path, params, story);
    }

    public StoriesDAO withLabel(String label) {
        params.add("with_label", label);
        return this;
    }

    public StoriesDAO withState(Story.StoryState state) {
        params.add("with_state", state.name());
        return this;
    }

    public StoriesDAO afterStoryId(int storyId) {
        params.add("after_story_id", Integer.toString(storyId));
        return this;
    }

    public StoriesDAO beforeStoryId(int storyId) {
        params.add("before_story_id", Integer.toString(storyId));
        return this;
    }

    public StoriesDAO acceptedBefore(Instant instant) {
        params.add("accepted_before", instant.toString());
        return this;
    }

    public StoriesDAO acceptedAfter(Instant instant) {
        params.add("accepted_after", instant.toString());
        return this;
    }

    public StoriesDAO createdBefore(Instant instant) {
        params.add("created_before", instant.toString());
        return this;
    }

    public StoriesDAO createdAfter(Instant instant) {
        params.add("created_after", instant.toString());
        return this;
    }

    public StoriesDAO updatedBefore(Instant instant) {
        params.add("updated_before", instant.toString());
        return this;
    }

    public StoriesDAO updatedAfter(Instant instant) {
        params.add("updated_after", instant.toString());
        return this;
    }

    public StoriesDAO deadlineBefore(Instant instant) {
        params.add("deadline_before", instant.toString());
        return this;
    }

    public StoriesDAO deadlineAfter(Instant instant) {
        params.add("deadline_after", instant.toString());
        return this;
    }

    public StoriesDAO filter(String filter) {
        params.add("filter", filter);
        return this;
    }
}
