package com.anand.nonmodular;

import com.anand.response.ChannelSearchResponse;
import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;


public class MonolithClient {

    private final OkHttpClient httpClient;

    public MonolithClient() {
        this.httpClient = new OkHttpClient();
    }

    public String searchOrg(String channel) throws IOException {
        Request request = new Request.Builder()
                .url("http://localhost:9000/org/search/" + channel)
                .get()
                .build();
        Response response = httpClient.newCall(request).execute();
        String responseBody = response.body().string();
        try {
            ChannelSearchResponse channelSearchResponse = new Gson().fromJson(responseBody, ChannelSearchResponse.class);
            if (!channelSearchResponse.successful()) {
                System.out.println("SEARCH SERVICE RESPONSE UNSUCCESSFUL. RESPONSE: " + channelSearchResponse.toString());
                return null;
            }
            if (channelSearchResponse.value() != null) {
                System.out.println("SEARCH SERVICE RESPONSE SUCCESSFUL. RESPONSE: " + channelSearchResponse.toString());
                return channelSearchResponse.value();
            }
        } catch (Exception ex) {
            System.out.println("SEARCH RESPONSE PARSING FAILED. RESPONSE: {}" + responseBody);
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            System.out.println("Error trace when parsing Search Response: " + sw.toString());
        }
        return null;
    }
}
