package onespot.pivotal.api.dao;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import onespot.pivotal.rest.JsonRestClient;

/**
 * Created by ian on 3/29/15.
 */
public abstract class DAO {
    protected final JsonRestClient jsonRestClient;
    protected final String path;
    protected Multimap<String, String> params;

    public DAO(JsonRestClient jsonRestClient, String path, Multimap<String, String> params) {
        this.jsonRestClient = jsonRestClient;
        this.path = path;
        this.params = HashMultimap.create(params);
    }
}
