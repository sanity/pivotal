package onespot.pivotal.api.dao;

import java.util.HashMap;
import java.util.Map;

import onespot.pivotal.rest.JsonRestClient;

/**
 * Created by ian on 3/29/15.
 */
public abstract class DAO {
    protected final JsonRestClient jsonRestClient;
    protected final String path;
    protected Map<String, String> params;

    public DAO(JsonRestClient jsonRestClient, String path, Map<String, String> params) {
        this.jsonRestClient = jsonRestClient;
        this.path = path;
        this.params = new HashMap<>(params);
    }
}
