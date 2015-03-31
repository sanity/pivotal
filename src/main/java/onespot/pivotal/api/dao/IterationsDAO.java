package onespot.pivotal.api.dao;

import com.google.common.base.Joiner;
import com.google.common.collect.Multimap;
import com.google.gson.reflect.TypeToken;
import onespot.pivotal.api.resources.Iteration;
import onespot.pivotal.rest.JsonRestClient;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ian on 3/30/15.
 */
public class IterationsDAO extends AbstractPaginatedDAO<Iteration> {
    public IterationsDAO(JsonRestClient jsonRestClient, String path, Multimap<String, String> params) {
        super(jsonRestClient, path, params);
    }

    @Override
    protected Type getListTypeToken() {
        return new TypeToken<List<Iteration>>() {
        }.getType();
    }

    public IterationsDAO withLabel(String label) {
        params.put("label", label);
        return this;
    }

    public IterationsDAO withFields(Iteration.IterationFieldNames... fields) {
        params.put("fields", Joiner.on(',').join(fields));
        return this;
    }

    public IterationsDAO scope(IterationsScope iterationsScope) {
        params.put("scope", iterationsScope.name());
        return this;
    }

    public enum IterationsScope {
        done, current, backlog, current_backlog
    }
}
