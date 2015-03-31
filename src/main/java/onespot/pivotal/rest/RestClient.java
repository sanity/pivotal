package onespot.pivotal.rest;

import com.google.common.collect.Multimap;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by ian on 3/27/15.
 */
public interface RestClient {
    HttpResponse<String> get(String path, Multimap<String, String> params) throws UnirestException;

    HttpResponse<String> put(String path, Multimap<String, String> params, String payload) throws UnirestException;

    HttpResponse<String> post(String path, Multimap<String, String> params, String payload) throws UnirestException;

    HttpResponse<String> delete(String path, Multimap<String, String> params) throws UnirestException;
}
