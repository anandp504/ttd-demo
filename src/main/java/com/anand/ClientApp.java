package com.anand;

import com.anand.nonmodular.MonolithClient;
import com.anand.testdriven.ModularClient;
import okhttp3.OkHttpClient;

import java.util.List;

public class ClientApp {


    public static void main(String...args) {
        // MonolithClient monolithClient = new MonolithClient();
        ModularClient modularClient = new ModularClient("http://localhost:9000/org/search/", new OkHttpClient());
        try {
            // monolithClient.searchOrg("0125134851644620800");
            List<String> locationIds = modularClient.orgSearchApi("0125134851644620800");
            System.out.println(String.join("," , locationIds));
        } catch (Exception ex) {
            System.out.println("Error occurred: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
