// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridnetwork.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.hybridnetwork.HybridNetworkManager;
import com.azure.resourcemanager.hybridnetwork.models.Component;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ComponentsListByNetworkFunctionMockTests {
    @Test
    public void testListByNetworkFunction() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"provisioningState\":\"Deleted\",\"deploymentProfile\":\"ta\",\"deploymentStatus\":{\"status\":\"Upgrading\",\"resources\":{\"deployments\":[{},{},{}],\"pods\":[{}],\"replicaSets\":[{}],\"statefulSets\":[{}],\"daemonSets\":[{},{},{},{}]},\"nextExpectedUpdateAt\":\"2021-09-11T10:59:22Z\"}},\"id\":\"cpeogkhnmgbrou\",\"name\":\"ddbhf\",\"type\":\"pfpazjzoywjxhpdu\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        HybridNetworkManager manager = HybridNetworkManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<Component> response = manager.components()
            .listByNetworkFunction("axmqeqal", "hjnhgwydyynfsvk", com.azure.core.util.Context.NONE);

    }
}
