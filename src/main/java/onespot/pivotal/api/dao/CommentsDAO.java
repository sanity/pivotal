package onespot.pivotal.api.dao;

import java.util.List;

import com.google.common.collect.Multimap;
import com.google.gson.reflect.TypeToken;

import onespot.pivotal.api.resources.Comment;
import onespot.pivotal.rest.JsonRestClient;

/**
 * Created by ian on 3/30/15.
 */
public class CommentsDAO extends DAO {
    public CommentsDAO(JsonRestClient jsonRestClient, String pathPrefix, Multimap<String, String> params) {
        super(jsonRestClient, pathPrefix, params);
    }

    public List<Comment> get() {
        return jsonRestClient.get(new TypeToken<List<Comment>>(){}.getType(), path, params);
    }

    public Comment get(int id) {
        return jsonRestClient.get(Comment.class, path+"/"+id, params);
    }

    public void put(int id, Comment comment) {
        jsonRestClient.put(Comment.class, path+"/"+id, params, comment);
    }

    public void post(Comment comment) {
        jsonRestClient.post(Comment.class, path, params, comment);
    }
}
