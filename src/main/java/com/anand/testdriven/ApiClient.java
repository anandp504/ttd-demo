package com.anand.testdriven;

import com.anand.response.ChannelSearchResponse;

import java.io.IOException;

public interface ApiClient {
    ChannelSearchResponse searchOrg(String channel) throws IOException;
}
