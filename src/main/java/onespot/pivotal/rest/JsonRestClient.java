package onespot.pivotal.rest;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;

/**
 * Created by ian on 3/27/15.
 */
public class JsonRestClient {
    private final RestClient restClient;
    private final Gson gson;

    private static class InstantTypeAdapter implements JsonSerializer<Instant>, JsonDeserializer<Instant> {

        @Override
        public Instant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Instant.parse(json.getAsString());
        }

        @Override
        public JsonElement serialize(Instant src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }
    }

    private static class LocalDateTypeAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return LocalDate.parse(json.getAsString());
        }

        @Override
        public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }
    }

    public JsonRestClient(RestClient restClient) {
        this.restClient = restClient;
        this.gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Instant.class, new InstantTypeAdapter())
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .create();
    }

    public <T> T get(Class<T> cls, String path, Multimap<String, String> params) throws UnirestException {
        HttpResponse<String> response = httpResponse(path, params);
        String body = extractBody(response);
        return gson.fromJson(body, cls);
    }

    public <T> T get(Type cls, String path, Multimap<String, String> params) throws UnirestException {
        HttpResponse<String> response = httpResponse(path, params);
        String body = extractBody(response);
        return gson.fromJson(body, cls);
    }

    public <T> T put(Type cls, String path, Multimap<String, String> params, T payload) throws UnirestException {
        return gson.fromJson(extractBody(restClient.put(path, params, gson.toJson(payload))), cls);
    }

    public <T> T put(Class<T> cls, String path, Multimap<String, String> params, T payload) throws UnirestException {
        return gson.fromJson(extractBody(restClient.put(path, params, gson.toJson(payload))), cls);
    }

    public <T> T post(Class<T> cls, String path, Multimap<String, String> params, T payload) throws UnirestException {
        return gson.fromJson(extractBody(restClient.post(path, params, gson.toJson(payload))), cls);
    }

    public <T> T post(Type cls, String path, Multimap<String, String> params, T payload) throws UnirestException {
        return gson.fromJson(extractBody(restClient.post(path, params, gson.toJson(payload))), cls);
    }

    public <T> T delete(Class<T> cls, String path, Multimap<String, String> params) throws UnirestException {
        return gson.fromJson(extractBody(restClient.delete(path, params)), cls);
    }

    public <T> T delete(Type cls, String path, Multimap<String, String> params) throws UnirestException {
        return gson.fromJson(extractBody(restClient.delete(path, params)), cls);
    }



    private String extractBody(HttpResponse<String> response) {
        if (response.getStatus() != 200) {
            throw new RuntimeException("Request failed, status: " + response.getStatus() + ", text: " + response.getStatusText() + " body: " + response.getBody());
        }
        return response.getBody();
    }



    private HttpResponse<String> httpResponse(String path) throws UnirestException {
        return httpResponse(path, HashMultimap.create());
    }

    private HttpResponse<String> httpResponse(String path, Multimap<String, String> params) throws UnirestException {
        return restClient.get(path, params);
    }
}
