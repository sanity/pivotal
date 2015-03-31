package onespot.pivotal.api.dao;

import com.google.common.base.Joiner;
import com.google.common.collect.Multimap;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.exceptions.UnirestException;
import onespot.pivotal.api.resources.Label;
import onespot.pivotal.rest.JsonRestClient;

import java.util.List;

/**
 * Created by ian on 3/30/15.
 */
public class LabelsDAO extends DAO {
    public LabelsDAO(JsonRestClient jsonRestClient, String path, Multimap<String, String> params) {
        super(jsonRestClient, path, params);
    }

    public List<Label> get() throws UnirestException {
        return jsonRestClient.get(new TypeToken<List<Label>>(){}.getType(), path, params);
    }

    public Label get(int id) throws UnirestException {
        return jsonRestClient.get(Label.class, "/"+id, params);
    }

    public LabelsDAO withFields(Label.LabelFieldNames... fields) {
        params.put("fields", Joiner.on(',').join(fields));
        return this;
    }
}
