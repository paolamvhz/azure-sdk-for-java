// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.postgresqlflexibleserver.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.postgresqlflexibleserver.PostgreSqlManager;
import com.azure.resourcemanager.postgresqlflexibleserver.models.CheckNameAvailabilityReason;
import com.azure.resourcemanager.postgresqlflexibleserver.models.CheckNameAvailabilityRequest;
import com.azure.resourcemanager.postgresqlflexibleserver.models.NameAvailability;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class CheckNameAvailabilityWithLocationsExecuteWithResponseMockTests {
    @Test
    public void testExecuteWithResponse() throws Exception {
        String responseStr
            = "{\"name\":\"ktalhsnvkcdmxz\",\"type\":\"oaimlnw\",\"nameAvailable\":false,\"reason\":\"AlreadyExists\",\"message\":\"l\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        PostgreSqlManager manager = PostgreSqlManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        NameAvailability response = manager.checkNameAvailabilityWithLocations()
            .executeWithResponse("yhohujswtwkozzwc",
                new CheckNameAvailabilityRequest().withName("kb").withType("pfajnjwltlwtjj"),
                com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals(false, response.nameAvailable());
        Assertions.assertEquals(CheckNameAvailabilityReason.ALREADY_EXISTS, response.reason());
        Assertions.assertEquals("l", response.message());
    }
}
