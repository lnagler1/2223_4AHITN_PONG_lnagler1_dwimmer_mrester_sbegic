package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Client;


import com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.HelloApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client extends HelloApplication {
    static Thread t = new Thread();
    static HttpRequest request;
    static HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder().uri(URI.create("http://localhost:3000")).build();

        HttpResponse<String> response =
                null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.body());

        if (response.body().equals("Connect")) {

                System.out.println("so");
                HelloApplication.launch(Client.class);
        }
    }

    public void pressedFinish() throws IOException, InterruptedException {
        request = HttpRequest.newBuilder().uri(URI.create("http://localhost:3000/ready")).build();
        System.out.println(client.send(request, HttpResponse.BodyHandlers.ofString()).body());
    }

}
