package com.pagerduty.client.utils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

public class HttpUtil {

    public static final String PAGERDUTY_API = "Token token=y_NbAkKc66ryYTWUXYEu";
    public static final String GET = "GET";
    public static final String POST = "POST";

    public static String httpGetRequest(String url) throws IOException {
        HttpURLConnection con = getConnection(url, GET);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public static String httpPostRequest(String url, String jsonBody) throws IOException {
        HttpURLConnection con = getConnection(url, POST);
        con.setDoOutput(true);

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    private static HttpURLConnection getConnection(String urlAddress, String method) throws IOException {
        URL urlObj = new URL(urlAddress);
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
        con.setRequestMethod(method);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Authorization", PAGERDUTY_API);
        return con;
    }

    public static Map parseJsonToMap(String jsonStr) {
        Gson gson = new Gson();
        return gson.fromJson(jsonStr, Map.class);
    }

    public static <T> T parseJsonToObject(String jsonStr, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonStr, clazz);
    }

    public static String readKeyboardInputFromUser() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}