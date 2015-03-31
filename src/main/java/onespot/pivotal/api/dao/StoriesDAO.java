package onespot.pivotal.api.dao;

import com.google.common.collect.Multimap;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.exceptions.UnirestException;
import onespot.pivotal.api.resources.Story;
import onespot.pivotal.rest.JsonRestClient;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.List;

/**
 * Created by ian on 3/29/15.
 */
public class StoriesDAO extends AbstractPaginatedDAO<Story> {
    public StoriesDAO(JsonRestClient jsonRestClient, String pathPrefix, Multimap<String, String> params) {
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

    public StoriesDAO withFields(String fields) {
        params.put("fields", fields);
        return this;
    }

    public StoriesDAO withLabel(String label) {
        params.put("with_label", label);
        return this;
    }

    public StoriesDAO withState(Story.StoryState state) {
        params.put("with_state", state.name());
        return this;
    }

    public StoriesDAO afterStoryId(int storyId) {
        params.put("after_story_id", Integer.toString(storyId));
        return this;
    }

    public StoriesDAO beforeStoryId(int storyId) {
        params.put("before_story_id", Integer.toString(storyId));
        return this;
    }

    public StoriesDAO acceptedBefore(Instant instant) {
        params.put("accepted_before", instant.toString());
        return this;
    }

    public StoriesDAO acceptedAfter(Instant instant) {
        params.put("accepted_after", instant.toString());
        return this;
    }

    public StoriesDAO createdBefore(Instant instant) {
        params.put("created_before", instant.toString());
        return this;
    }

    public StoriesDAO createdAfter(Instant instant) {
        params.put("created_after", instant.toString());
        return this;
    }

    public StoriesDAO updatedBefore(Instant instant) {
        params.put("updated_before", instant.toString());
        return this;
    }

    public StoriesDAO updatedAfter(Instant instant) {
        params.put("updated_after", instant.toString());
        return this;
    }

    public StoriesDAO deadlineBefore(Instant instant) {
        params.put("deadline_before", instant.toString());
        return this;
    }

    public StoriesDAO deadlineAfter(Instant instant) {
        params.put("deadline_after", instant.toString());
        return this;
    }

    public StoriesDAO filter(String filter) {
        params.put("filter", filter);
        return this;
    }
}
