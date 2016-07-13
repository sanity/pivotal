package onespot.pivotal.api.dao;

import com.google.common.collect.Multimap;
import com.google.gson.reflect.TypeToken;
import onespot.pivotal.api.resources.Person;
import onespot.pivotal.rest.JsonRestClient;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ian on 3/30/15.
 */
public class OwnersDAO extends DAO {
    public OwnersDAO(JsonRestClient jsonRestClient, String pathPrefix, Multimap<String, String> params) {
        super(jsonRestClient, pathPrefix, params);
    }

    protected Type getListTypeToken() {
        return (new TypeToken<List<Person>>() {
        }).getType();
    }

    public List<Person> getAll() {
        return this.jsonRestClient.get(getListTypeToken(), this.path, this.params);
    }
}
