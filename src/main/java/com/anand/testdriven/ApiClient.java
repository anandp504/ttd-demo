package com.anand.testdriven;

import com.anand.response.ChannelSearchResponse;

import java.io.IOException;

public interface ApiClient {
    ChannelSearchResponse orgSearchApi(String channel) throws IOException;
}
