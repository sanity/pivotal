package onespot.pivotal.api.dao;

import com.google.common.base.Joiner;
import com.google.common.collect.Multimap;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.exceptions.UnirestException;
import onespot.pivotal.api.resources.Epic;
import onespot.pivotal.rest.JsonRestClient;

import java.util.List;

/**
 * Created by ian on 4/3/15.
 */
public class EpicsDAO extends DAO {

    public EpicsDAO(JsonRestClient jsonRestClient, String path, Multimap<String, String> params) {
        super(jsonRestClient, path, params);
    }

    public List<Epic> get() throws UnirestException {
        return jsonRestClient.get(new TypeToken<List<Epic>>(){}.getType(), path, params);
    }

    public EpicDAO id(int id) throws UnirestException {
        return new EpicDAO(jsonRestClient, "/"+id, params);
    }


    public EpicsDAO withFields(Epic.EpicFieldNames... fields) {
        params.put("fields", Joiner.on(',').join(fields));
        return this;
    }
}
