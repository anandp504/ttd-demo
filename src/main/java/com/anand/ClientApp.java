package com.anand;

import com.anand.nonmodular.MonolithClient;

public class ClientApp {

    public static void main(String...args) {
        MonolithClient monolithClient = new MonolithClient();
        try {
            monolithClient.searchOrg("0125134851644620800");
        } catch (Exception ex) {
            System.out.println("Error occurred: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
