package org.javaasync1;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.function.Consumer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void myfunc(String input) {
        System.out.println("myfunc");
    }
    public static void main(String[] args) throws Exception {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        // Inspired by
        // https://stackoverflow.com/questions/3142915/how-do-you-create-an-asynchronous-http-request-in-java
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://ed0-as2119.cdn.svt.se/ed4/d0/se/20240229/809c32a2-7747-4493-ad94-d244dd305517/dash-full.mpd"))
                .timeout(Duration.ofMinutes(2))
                .build();

        System.out.println("before request");
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        /*
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://openjdk.org/"))
                .build();

         /*
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

         */

        System.out.println(response.statusCode());
        System.out.println(response.body());
        /*
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(Main::myfunc);
        */
    }
}