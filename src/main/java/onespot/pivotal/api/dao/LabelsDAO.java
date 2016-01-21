package onespot.pivotal.api.dao;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.Multimap;
import com.google.gson.reflect.TypeToken;

import onespot.pivotal.api.resources.Label;
import onespot.pivotal.rest.JsonRestClient;

/**
 * Created by ian on 3/30/15.
 */
public class LabelsDAO extends DAO {
    public LabelsDAO(JsonRestClient jsonRestClient, String path, Multimap<String, String> params) {
        super(jsonRestClient, path, params);
    }

    public List<Label> get() {
        return jsonRestClient.get(new TypeToken<List<Label>>(){}.getType(), path, params);
    }

    public Label get(int id) {
        return jsonRestClient.get(Label.class, "/"+id, params);
    }

    public LabelsDAO withFields(Label.LabelFieldNames... fields) {
        params.put("fields", Joiner.on(',').join(fields));
        return this;
    }
}
