package nz.fiore.mvelrs.servlet.util;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.StringReader;

/**
 * Created by fiorenzo on 19/07/16.
 */
public class RsCaller {

    public JsonArray list(String url) throws Exception {
        Response response = null;
        try {
            WebTarget target = getTarget(url);
            response = target.request().get();
            Object value = response.readEntity(String.class);
            JsonReader reader = Json.createReader(new StringReader(value.toString()));
            return reader.readArray();
        } finally {
        }
        // You should close connections!
    }

    public JsonObject get(String url) throws Exception {
        Response response = null;
        try {
            WebTarget target = getTarget(url);
            response = target.request().get();
            Object value = response.readEntity(String.class);
            JsonReader reader = Json.createReader(new StringReader(value.toString()));
            return reader.readObject();
        } finally {
        }
        // You should close connections!
    }


    public static WebTarget getTarget(String url) {
        try {
            Client client = new ResteasyClientBuilder().disableTrustManager()
                    .build();
            WebTarget target = client.target(url);
            return target;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
