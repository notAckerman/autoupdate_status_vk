package org.hornsandhooves;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;

import java.util.Date;

public class StatusUpdater {
    private final String ACCESS_TOKEN = "YOUR_TOKEN";
    private final Integer USER_ID = 0; // YOUR_ID
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
