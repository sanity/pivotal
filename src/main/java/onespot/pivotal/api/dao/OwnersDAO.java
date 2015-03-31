package onespot.pivotal.api.dao;

import com.google.common.collect.Multimap;
import onespot.pivotal.rest.JsonRestClient;

/**
 * Created by ian on 3/30/15.
 */
public class OwnersDAO extends DAO {
    public OwnersDAO(JsonRestClient jsonRestClient, String pathPrefix, Multimap<String, String> params) {
        super(jsonRestClient, pathPrefix, params);
    }
}
