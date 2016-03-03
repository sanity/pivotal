package onespot.pivotal.rest;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mashape.unirest.http.HttpResponse;

import onespot.pivotal.api.ex.PivotalAPIException;

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

    private static class JsonObjectTypeAdapter implements JsonSerializer<JsonObject>, JsonDeserializer<JsonObject> {

        @Override
        public JsonObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return (JsonObject) json;
        }

        @Override
        public JsonElement serialize(JsonObject src, Type typeOfSrc, JsonSerializationContext context) {
            return src;
        }
    }


        public JsonRestClient(RestClient restClient) {
        this.restClient = restClient;
        this.gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Instant.class, new InstantTypeAdapter())
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(JsonObject.class, new JsonObjectTypeAdapter())
                .create();
    }

    public <T> T get(Class<T> cls, String path, HashMap<String, String> params) throws PivotalAPIException {
        HttpResponse<String> response = httpResponse(path, params);
        String body = extractBody(response);
        return gson.fromJson(body, cls);
    }

    public <T> T get(Type cls, String path, Map<String, String> params) throws PivotalAPIException {
        HttpResponse<String> response = httpResponse(path, params);
        try {
            String body = extractBody(response);
            return gson.fromJson(body, cls);
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to GET "+path, e);
        }
    }

    public <T> T put(Type cls, String path, Map<String, String> params, T payload) throws PivotalAPIException {
        return gson.fromJson(extractBody(restClient.put(path, params, gson.toJson(payload))), cls);
    }

    public <T> T put(Class<T> cls, String path, Map<String, String> params, T payload) throws PivotalAPIException {
        return gson.fromJson(extractBody(restClient.put(path, params, gson.toJson(payload))), cls);
    }

    public <T> T post(Class<T> cls, String path, Map<String, String> params, T payload) throws PivotalAPIException {
        String payloadJson = gson.toJson(payload);
        return gson.fromJson(extractBody(restClient.post(path, params, payloadJson)), cls);
    }

    public <T> T post(Type cls, String path, Map<String, String> params, T payload) throws PivotalAPIException {
        return gson.fromJson(extractBody(restClient.post(path, params, gson.toJson(payload))), cls);
    }

    public <T> T delete(Class<T> cls, String path, Map<String, String> params) throws PivotalAPIException {
        return gson.fromJson(extractBody(restClient.delete(path, params)), cls);
    }

    public <T> T delete(Type cls, String path, Map<String, String> params) throws PivotalAPIException {
        return gson.fromJson(extractBody(restClient.delete(path, params)), cls);
    }

    private String extractBody(HttpResponse<String> response) {
        if (response.getStatus() != 200) {
            throw new RuntimeException("Request failed, status: " + response.getStatus() + ", text: " + response.getStatusText() + " body: " + response.getBody());
        }
        return response.getBody();
    }

    private HttpResponse<String> httpResponse(String path, Map<String, String> params) throws PivotalAPIException {
    	return restClient.get(path, params);
    }
}
