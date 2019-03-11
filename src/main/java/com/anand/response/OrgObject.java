package com.anand.response;

public class OrgObject {
    private String name;
    private String identifier;
    // private String locationId;
    private String locationIds;


    public String name() {
        return name;
    }

    public String identifier() {
        return identifier;
    }

    /*
    public String locationId() {
        return locationId;
    }
    */

    public String locationIds() {
        return locationIds;
    }

    @Override
    public String toString() {
        return "OrgObject{" +
                "name='" + name + '\'' +
                ", identifier='" + identifier + '\'' +
                // ", locationId=" + locationId +
                ", locationIds=" + locationIds +
                '}';
    }
}
