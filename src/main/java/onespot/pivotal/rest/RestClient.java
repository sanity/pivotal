package onespot.pivotal.rest;

import com.google.common.collect.Multimap;
import com.mashape.unirest.http.HttpResponse;

import onespot.pivotal.api.ex.PivotalAPIException;

/**
 * Created by ian on 3/27/15.
 */
public interface RestClient {
    HttpResponse<String> get(String path, Multimap<String, String> params) throws PivotalAPIException;

    HttpResponse<String> put(String path, Multimap<String, String> params, String payload) throws PivotalAPIException;

    HttpResponse<String> post(String path, Multimap<String, String> params, String payload) throws PivotalAPIException;

    HttpResponse<String> delete(String path, Multimap<String, String> params) throws PivotalAPIException;
}
