package com.anand.testdriven;

import com.anand.response.ChannelSearchResponse;

import java.io.IOException;
import java.util.List;

public interface ApiClient {
    List<String> orgSearchApi(String channel) throws IOException;
}
