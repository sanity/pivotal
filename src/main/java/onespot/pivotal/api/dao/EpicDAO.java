package onespot.pivotal.api.dao;

import com.google.common.collect.Multimap;
import com.mashape.unirest.http.exceptions.UnirestException;
import onespot.pivotal.api.resources.Epic;
import onespot.pivotal.rest.JsonRestClient;

/**
 * Created by ian on 3/29/15.
 */
public class EpicDAO extends DAO {
    public EpicDAO(JsonRestClient jsonRestClient, String path, Multimap<String, String> params) {
        super(jsonRestClient, path, params);
    }

    public Epic get() throws UnirestException {
        return jsonRestClient.get(Epic.class, path, params);
    }

    public void put(Epic epic) throws UnirestException {
        jsonRestClient.put(Epic.class, path, params, epic);
    }
}
