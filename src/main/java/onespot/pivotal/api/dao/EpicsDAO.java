package onespot.pivotal.api.dao;

import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.gson.reflect.TypeToken;

import onespot.pivotal.api.resources.Epic;
import onespot.pivotal.rest.JsonRestClient;

/**
 * Created by ian on 4/3/15.
 */
public class EpicsDAO extends DAO {

    public EpicsDAO(JsonRestClient jsonRestClient, String path, Map<String, String> params) {
        super(jsonRestClient, path, params);
    }

    public List<Epic> get() {
        return jsonRestClient.get(new TypeToken<List<Epic>>(){}.getType(), path, params);
    }

    public EpicDAO id(int id) {
        return new EpicDAO(jsonRestClient, "/"+id, params);
    }


    public EpicsDAO withFields(Epic.EpicFieldNames... fields) {
        params.put("fields", Joiner.on(',').join(fields));
        return this;
    }
}
