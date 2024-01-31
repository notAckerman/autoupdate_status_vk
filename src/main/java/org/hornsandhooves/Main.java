package org.hornsandhooves;

import com.google.gson.Gson;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import com.vk.api.sdk.objects.status.Status;
import com.vk.api.sdk.objects.wall.responses.GetResponse;

import javax.annotation.processing.Filer;
import javax.xml.crypto.Data;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws ClientException, ApiException {
        StatusUpdater statusUpdater = StatusUpdater.getInstance();

        new Thread(() -> {
            synchronized (statusUpdater) {
                while (true) {
                    try {
                        statusUpdater.updateStatus(new Date().toString());
                        Thread.sleep(60000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }).start();
    }
}