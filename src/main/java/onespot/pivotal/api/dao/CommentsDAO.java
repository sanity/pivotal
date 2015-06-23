package onespot.pivotal.api.dao;

import com.google.common.collect.Multimap;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.exceptions.UnirestException;
import onespot.pivotal.api.resources.Comment;
import onespot.pivotal.rest.JsonRestClient;

import java.util.List;

/**
 * Created by ian on 3/30/15.
 */
public class CommentsDAO extends DAO {
    public CommentsDAO(JsonRestClient jsonRestClient, String pathPrefix, Multimap<String, String> params) {
        super(jsonRestClient, pathPrefix, params);
    }

    public List<Comment> get() throws UnirestException {
        return jsonRestClient.get(new TypeToken<List<Comment>>(){}.getType(), path, params);
    }

    public Comment get(int id) throws UnirestException {
        return jsonRestClient.get(Comment.class, path+"/"+id, params);
    }

    public void put(int id, Comment comment) throws UnirestException {
        jsonRestClient.put(Comment.class, path+"/"+id, params, comment);
    }

    public void post(Comment comment) throws UnirestException {
        jsonRestClient.post(Comment.class, path, params, comment);
    }
}
