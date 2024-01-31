package org.hornsandhooves;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;

import java.util.Date;

public class StatusUpdater {
    private final String ACCESS_TOKEN = "vk1.a.8g8-c_fo150yXO6HUAaFBOun0e2zShWMQVDyRmxdGeE3BOEICaFsjq1FcWyrfKdR_5K-UzrYIjSpNUFbmNNWMFtPcZwpUVR5Jl7-UrxYbcga1m5wU-UmcJMsTHSyaLwki4hcu2d4reNQc4RkUxuuZVVr0j8Bw0pPqxKTriqFFxcr5HbqFDWrYoS_hF0F3j7ZIkdV0lrpmvkL4JhgHnAzZA";
    private final Integer USER_ID = 273718654;
    private TransportClient transportClient;
    private VkApiClient vk;
    private UserActor actor;
    private static StatusUpdater statusUpdater;

    private StatusUpdater() {
        transportClient = new HttpTransportClient();
        vk = new VkApiClient(transportClient);
        actor = new UserActor(USER_ID, ACCESS_TOKEN);
    }

    public static StatusUpdater getInstance() {
        if (statusUpdater == null) {
            statusUpdater = new StatusUpdater();
        }
        return statusUpdater;
    }

    public void updateStatus(String message) throws ClientException, ApiException {
        vk.status().set(actor).text(message).execute();
    }
}
