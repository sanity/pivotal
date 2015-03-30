package onespot.pivotal.rest;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import gumi.builders.url.UrlParameterMultimap;

import java.lang.reflect.Type;

/**
 * Created by ian on 3/27/15.
 */
public class JsonRestClient {
    private final RestClient restClient;
    private final Gson gson;

    public JsonRestClient(RestClient restClient, Gson gson) {
        this.restClient = restClient;
        this.gson = gson;
    }

    public <T> T get(Class<T> cls, String path, UrlParameterMultimap params) throws UnirestException {
        HttpResponse<String> response = httpResponse(path, params);
        return gson.fromJson(extractBody(response), cls);
    }

    public <T> T get(Type cls, String path, UrlParameterMultimap params) throws UnirestException {
        HttpResponse<String> response = httpResponse(path, params);
        return gson.fromJson(extractBody(response), cls);
    }

    public <T> T put(Type cls, String path, UrlParameterMultimap params, Object payload) throws UnirestException {
        return gson.fromJson(extractBody(restClient.put(path, params, gson.toJson(payload))), cls);
    }

    public <T> T put(Class<T> cls, String path, UrlParameterMultimap params, Object payload) throws UnirestException {
        return gson.fromJson(extractBody(restClient.put(path, params, gson.toJson(payload))), cls);
    }

    public <T> T post(Class<T> cls, String path, UrlParameterMultimap params, Object payload) throws UnirestException {
        return gson.fromJson(extractBody(restClient.post(path, params, gson.toJson(payload))), cls);
    }

    public <T> T post(Type cls, String path, UrlParameterMultimap params, Object payload) throws UnirestException {
        return gson.fromJson(extractBody(restClient.post(path, params, gson.toJson(payload))), cls);
    }

    public <T> T delete(Class<T> cls, String path, UrlParameterMultimap params) throws UnirestException {
        return gson.fromJson(extractBody(restClient.delete(path, params)), cls);
    }

    public <T> T delete(Type cls, String path, UrlParameterMultimap params) throws UnirestException {
        return gson.fromJson(extractBody(restClient.delete(path, params)), cls);
    }



    private String extractBody(HttpResponse<String> response) {
        if (response.getStatus() != 200) {
            throw new RuntimeException("Request failed, status: " + response.getStatus() + ", text: " + response.getStatusText() + " body: " + response.getBody());
        }
        return response.getBody();
    }



    private HttpResponse<String> httpResponse(String path) throws UnirestException {
        return httpResponse(path, UrlParameterMultimap.newMultimap());
    }

    private HttpResponse<String> httpResponse(String path, UrlParameterMultimap params) throws UnirestException {
        return restClient.get(path, params);
    }
}
