// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automanage.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.automanage.AutomanageManager;
import com.azure.resourcemanager.automanage.models.ConfigurationProfile;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ConfigurationProfilesVersionsGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"configuration\":\"datawwrq\"},\"location\":\"edckzywbiexzfey\",\"tags\":{\"zyoxaepdkzjan\":\"xibxujwbhqwalm\",\"hdwbavxbniwdjs\":\"ux\"},\"id\":\"zt\",\"name\":\"dbpgnxytxhp\",\"type\":\"xbzpfzab\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        AutomanageManager manager = AutomanageManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        ConfigurationProfile response = manager.configurationProfilesVersions()
            .getWithResponse("axdbabph", "wrqlfktsthsuco", "mnyyazt", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("edckzywbiexzfey", response.location());
        Assertions.assertEquals("xibxujwbhqwalm", response.tags().get("zyoxaepdkzjan"));
    }
}
