package com.anand;

import com.anand.response.ChannelSearchResponse;
import com.anand.testdriven.ApiClient;
import com.anand.testdriven.ModularClient;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.mock.MockInterceptor;
import okhttp3.mock.Rule;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static okhttp3.mock.MediaTypes.MEDIATYPE_JSON;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TestSearchApi {

    private ModularClient client;
    private OkHttpClient mockHttpClient;
    private String mockApiEndPoint;
    private MockInterceptor interceptor;

    @SuppressWarnings("unchecked")
    @Before
    public void setUp() {
        mockApiEndPoint = "http://test-endpoint:9000/";
        mockHttpClient = mock(OkHttpClient.class);
        interceptor = new MockInterceptor();
        client = new ModularClient(mockApiEndPoint, mockHttpClient);
    }

    @Test
    public void clientShouldReturnSuccessfulResponse() throws IOException {
        interceptor.addRule()
                .get()
                .url(mockApiEndPoint + "0125134851644620800")
                .answer(request -> new Response.Builder()
                        .code(200)
                        .body(ResponseBody.create(MEDIATYPE_JSON, "{}")));
        mockHttpClient = new OkHttpClient().newBuilder().addInterceptor(interceptor).build();
        client = new ModularClient(mockApiEndPoint, mockHttpClient);
        Response response = client.searchOrgApiCall("0125134851644620800");
        assertTrue(response.isSuccessful());
    }

    /*
    @Test(expected = IOException.class)
    public void clientShouldThrowIOException() throws IOException {
        interceptor.addRule()
                .get()
                .url(mockApiEndPoint + "0125134851644620800")
                .answer(request -> new Response.Builder()
                        .code(200)
                        .body(ResponseBody.create(MEDIATYPE_JSON, "{}")));
        mockHttpClient = new OkHttpClient().newBuilder().addInterceptor(interceptor).build();
        client = new ModularClient(mockApiEndPoint, mockHttpClient);
        client.searchOrgApiCall("0125134851644620800");
    }
    */

    @Test
    public void clientShouldReturnValidResponse() throws IOException {
        interceptor.addRule()
                .get()
                .url(mockApiEndPoint + "0125134851644620800")
                .answer(request -> new Response.Builder()
                        .code(200)
                        .body(ResponseBody.create(MEDIATYPE_JSON, ResponseData.responseWithLocation)));
        mockHttpClient = new OkHttpClient().newBuilder().addInterceptor(interceptor).build();
        client = new ModularClient(mockApiEndPoint, mockHttpClient);
        Response response = client.searchOrgApiCall("0125134851644620800");
        assertTrue(response.isSuccessful());
        ChannelSearchResponse responseBody = new Gson().fromJson(response.body().string(), ChannelSearchResponse.class);
        assertTrue(responseBody.successful());
    }

    @Test
    public void testOrgResponseJsonParser() {
        ChannelSearchResponse channelSearchResponse = client.parseOrgResponse(ResponseData.responseWithLocation);
        assertEquals("969dd3c1-4e98-4c17-a994-559f2dc70e18", String.join("," , channelSearchResponse.value()));
    }

    @Test
    public void searchOrgApiShouldValidChannelSearchResponse() throws IOException {
        interceptor.addRule()
                .get()
                .url(mockApiEndPoint + "0125134851644620800")
                .answer(request -> new Response.Builder()
                        .code(200)
                        .body(ResponseBody.create(MEDIATYPE_JSON, ResponseData.responseWithLocation)));
        mockHttpClient = new OkHttpClient().newBuilder().addInterceptor(interceptor).build();
        client = new ModularClient(mockApiEndPoint, mockHttpClient);
        ChannelSearchResponse channelSearchResponse = client.orgSearchApi("0125134851644620800");
        assertEquals("969dd3c1-4e98-4c17-a994-559f2dc70e18", String.join("," , channelSearchResponse.value()));
    }
}
