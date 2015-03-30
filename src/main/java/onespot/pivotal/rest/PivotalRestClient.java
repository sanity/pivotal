package onespot.pivotal.rest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import gumi.builders.UrlBuilder;
import gumi.builders.url.UrlParameterMultimap;

/**
 * Created by ian on 3/23/15.
 */
public class PivotalRestClient implements RestClient {
    public static final String URL_PREFIX = "https://www.pivotaltracker.com/services/v5/";
    private final String apiToken;

    public PivotalRestClient(String apiToken) {
        this.apiToken = apiToken;
    }

    @Override
    public HttpResponse<String> get(String path, UrlParameterMultimap params) throws UnirestException {
        UrlBuilder urlBuilder = UrlBuilder.fromString(URL_PREFIX + path).withParameters(params);
        return Unirest.get(urlBuilder.toString()).header("X-TrackerToken", apiToken).asString();
    }


    @Override
    public HttpResponse<String> put(String path, UrlParameterMultimap params, String payload) throws UnirestException {
        return Unirest.put(URL_PREFIX+ "/" + path).header("X-TrackerToken", apiToken)
                .body(payload).asString();
    }


    @Override
    public HttpResponse<String> post(String path, UrlParameterMultimap params, String payload) throws UnirestException {
        return Unirest.post(URL_PREFIX + "/" + path).header("X-TrackerToken", apiToken).body(payload).asString();
    }


    @Override
    public HttpResponse<String> delete(String path, UrlParameterMultimap params) throws UnirestException {
        return Unirest.delete(URL_PREFIX + "/" + path).header("X-TrackerToken", apiToken).asString();
    }

}
