package onespot.pivotal.api.dao;

import com.google.common.base.Joiner;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.reflect.TypeToken;
import onespot.pivotal.api.resources.ProjectMembership;
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
    public List<Story> get() {
        List<Story> stories = jsonRestClient.get(new TypeToken<List<Story>>() {
        }.getType(), path, params);
        for (Story story : stories) {
            story.setOwners(this.id(story.getId()).owners().getAll());
            ProjectMembership projectMembership = this.id(story.getId()).requester(story);
            if (projectMembership != null) {
                story.setRequester(projectMembership.getPerson());
            }

        }
        return stories;
    }

    public StoryDAO id(int id) {
        return new StoryDAO(jsonRestClient, path + "/" + id, HashMultimap.create());
    }

    public void post(Story story) {
        jsonRestClient.post(Story.class, path, HashMultimap.create(), story);
    }

    public StoriesDAO withFields(Story.StoryFieldNames... fields) {
        params.put("fields", Joiner.on(',').join(fields));
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
