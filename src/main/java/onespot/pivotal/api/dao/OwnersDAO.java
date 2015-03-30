package onespot.pivotal.api.dao;

import gumi.builders.url.UrlParameterMultimap;
import onespot.pivotal.rest.JsonRestClient;

/**
 * Created by ian on 3/30/15.
 */
public class OwnersDAO extends DAO {
    public OwnersDAO(JsonRestClient jsonRestClient, String pathPrefix, UrlParameterMultimap params) {
        super(jsonRestClient, pathPrefix, params);
    }
}
