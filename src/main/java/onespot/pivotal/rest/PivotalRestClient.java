package onespot.pivotal.rest;

import com.google.common.base.Joiner;
import com.google.common.collect.Multimap;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import onespot.pivotal.api.ex.PivotalAPIException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ian on 3/23/15.
 */
public class PivotalRestClient implements RestClient {
    public static final String URL_PREFIX = "https://www.pivotaltracker.com/services/v5";
    public static final String URL_UI = "https://www.pivotaltracker.com/n/";
    private final String apiToken;

    public PivotalRestClient(String apiToken) {
        this.apiToken = apiToken;
    }

    @Override
    public HttpResponse<String> get(String path, Multimap<String, String> params) throws PivotalAPIException {
        String parameters = paramsToStringWithoutURLEncoding(params);

        String url = URL_PREFIX + "/" + path + "?" + parameters;

        try {
            return Unirest.get(url).header("X-TrackerToken", apiToken).asString();
        } catch (UnirestException uex) {
            throw new PivotalAPIException(uex);
        }
    }

    @Override
    public HttpResponse<String> put(String path, com.google.common.collect.Multimap<String, String> params, String payload) throws PivotalAPIException {
        try {
            return Unirest.put(URL_PREFIX + "/" + path).header("X-TrackerToken", apiToken)
                    .header("Content-Type", "application/json")
                    .body(payload).asString();
        } catch (UnirestException uex) {
            throw new PivotalAPIException(uex);
        }
    }

    @Override
    public HttpResponse<String> post(String path, com.google.common.collect.Multimap<String, String> params, String payload) throws PivotalAPIException {
        String url = URL_PREFIX + "/" + path;
        try {
            return Unirest.post(url).header("X-TrackerToken", apiToken)
                    .header("Content-Type", "application/json")
                    .body(payload).asString();
        } catch (UnirestException uex) {
            throw new PivotalAPIException(uex);
        }
    }

    @Override
    public HttpResponse<String> delete(String path, com.google.common.collect.Multimap<String, String> params) throws PivotalAPIException {
        try {
            return Unirest.delete(URL_PREFIX + "/" + path).header("X-TrackerToken", apiToken).asString();
        } catch (UnirestException uex) {
            throw new PivotalAPIException(uex);
        }
    }

    /*
     * Don't URL encode because this will encode comma (,), whereas the 'fields'
     * URL parameter is expected to contain commas.  I've read conflicting
     * guidelines on whether this is allowed for query values, but someone
     * at Pivotal Labs clearly thinks that it is.
     *
     * TODO: Figure out what the actual standard is, which hopefully permits
     *       commas in query parameter values, and enforce that.
     */
    private String paramsToStringWithoutURLEncoding(Multimap<String, String> params) {
        List<String> parameterList = params.entries().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.toList());

        return Joiner.on('&').join(parameterList);
    }

}
