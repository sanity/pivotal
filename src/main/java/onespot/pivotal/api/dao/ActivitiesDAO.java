package onespot.pivotal.api.dao;

import com.google.common.collect.Multimap;
import com.google.gson.reflect.TypeToken;
import onespot.pivotal.api.resources.Activity;
import onespot.pivotal.rest.JsonRestClient;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ian on 4/1/15.
 */
public class ActivitiesDAO extends AbstractPaginatedDAO<Activity> {
    public ActivitiesDAO(JsonRestClient jsonRestClient, String path, Multimap<String, String> params) {
        super(jsonRestClient, path, params);
    }

    @Override
    protected Type getListTypeToken() {
        return new TypeToken<List<Activity>>() {
        }.getType();
    }
}
