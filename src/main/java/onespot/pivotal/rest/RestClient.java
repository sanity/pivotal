package onespot.pivotal.rest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import gumi.builders.url.UrlParameterMultimap;

/**
 * Created by ian on 3/27/15.
 */
public interface RestClient {
    HttpResponse<String> get(String path, UrlParameterMultimap params) throws UnirestException;

    HttpResponse<String> put(String path, UrlParameterMultimap params, String payload) throws UnirestException;

    HttpResponse<String> post(String path, UrlParameterMultimap params, String payload) throws UnirestException;

    HttpResponse<String> delete(String path, UrlParameterMultimap params) throws UnirestException;
}
