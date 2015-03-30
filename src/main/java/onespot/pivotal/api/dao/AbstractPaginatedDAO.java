package onespot.pivotal.api.dao;

import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.exceptions.UnirestException;
import gumi.builders.url.UrlParameterMultimap;
import onespot.pivotal.api.resources.Story;
import onespot.pivotal.rest.JsonRestClient;

import java.util.List;

/**
 * Created by ian on 3/30/15.
 */
public abstract class AbstractPaginatedDAO<R> extends DAO {
    public AbstractPaginatedDAO(JsonRestClient jsonRestClient, String path, UrlParameterMultimap params) {
        super(jsonRestClient, path, params);
    }

    public List<R> get() throws UnirestException {
        return jsonRestClient.get(new TypeToken<List<Story>>(){}.getType(), path, params);
    }

    /**
     * Retrieve all items under this DAO using the pagination mechanism.
     * As this may require multiple calls to the pivotal API, it might take a while.
     * @return
     * @throws UnirestException
     */
    public List<R> getAll() throws UnirestException {
        List<R> items = Lists.newArrayList();
        int position = 0;
        while (true) {
            // TODO(ic): Would be better to look at Tracker-Pagination-Total header
            this.offset(position).limit(100);
            List<R> retrievedItems = this.get();
            items.addAll(retrievedItems);
            int numberOfItemsReceived = retrievedItems.size();
            if (numberOfItemsReceived < 100) {
                break;
            }
            position += numberOfItemsReceived;
        }
        return items;
    }

    public AbstractPaginatedDAO<R> limit(int limit) {
        params.add("limit", Integer.toString(limit));
        return this;
    }

    public AbstractPaginatedDAO<R> offset(int offset) {
        params.add("offset", Integer.toString(offset));
        return this;
    }
}
