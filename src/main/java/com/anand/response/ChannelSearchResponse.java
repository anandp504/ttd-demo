package com.anand.response;

import java.util.List;
import java.util.Map;

public class ChannelSearchResponse {
    // public static final String SUCCESS_RESPONSE_STATUS = "successful";
    public static final String SUCCESS_RESPONSE_STATUS = "success";
    private String id;
    private String ver;
    private String ts;
    private Map<String, Object> params;
    // private SearchResult result;
    private SearchResponse result;

    public boolean successful() {
        return params != null && SUCCESS_RESPONSE_STATUS.equals(params.get("status"));
    }

    public String value() {
        /*
        if (result.count > 0) {
            // return result.org.get(0).locationId();
            return result.org.get(0).locationIds();
        }
        */
        if (result.response.count > 0 && result.response.content.size() > 0) {
            if (result.response.content.get(0).locationIds().isEmpty()) return null;
            else return result.response.content.get(0).locationIds();
        }
        return null;
    }

    private class SearchResult {
        // private List<OrgObject> org;
        private List<OrgObject> content;
        private Integer count;

        @Override
        public String toString() {
            return "SearchResult{" +
                    // "content=" + org +
                    "content=" + content +
                    ", count=" + count +
                    '}';
        }
    }

    private class SearchResponse {
        private SearchResult response;

        @Override
        public String toString() {
            return "Response{" + response +
                    '}';
        }
    }
}
