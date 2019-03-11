package com.anand.testdriven;

import com.anand.response.ChannelSearchResponse;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModularClient implements ApiClient {

    private String apiHost;
    private OkHttpClient httpClient;

    public ModularClient(){}

    public ModularClient(String apiHost, OkHttpClient httpClient) {
        this.apiHost = apiHost;
        this.httpClient = httpClient;
    }

    /*
    @Override
    public ChannelSearchResponse orgSearchApi(String channel) throws IOException {
        Request request = new Request.Builder()
                .url(apiHost + channel)
                .get()
                .build();
        Response response = httpClient.newCall(request).execute();
        String responseBody = response.body().string();
        return null;
    }
    */

    @Override
    public List<String> orgSearchApi(String channel) throws IOException {
        Response httpResponse = searchOrgApiCall(channel);
        String responseBody = httpResponse.body().string();
        List<String> locationIds = parseOrgResponse(responseBody).value();
        return locationIds == null ? new ArrayList<String>() : locationIds;
    }

    public Response searchOrgApiCall(String channel) throws IOException {
        Request request = new Request.Builder()
                .url(apiHost + channel)
                .get()
                .build();
        return httpClient.newCall(request).execute();
    }

    public ChannelSearchResponse parseOrgResponse(String responseBody) {
        return new Gson().fromJson(responseBody, ChannelSearchResponse.class);
    }
}
