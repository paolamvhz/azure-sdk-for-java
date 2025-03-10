// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.deviceregistry.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.deviceregistry.DeviceRegistryManager;
import com.azure.resourcemanager.deviceregistry.models.Format;
import com.azure.resourcemanager.deviceregistry.models.Schema;
import com.azure.resourcemanager.deviceregistry.models.SchemaType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class SchemasGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"uuid\":\"psvuoymgc\",\"displayName\":\"lvez\",\"description\":\"pqlmfe\",\"format\":\"JsonSchema/draft-07\",\"schemaType\":\"MessageSchema\",\"provisioningState\":\"Deleting\",\"tags\":{\"opgxedkowepb\":\"yhko\",\"fkbw\":\"pc\",\"khtj\":\"csnjvcdwxlpqekft\"}},\"id\":\"i\",\"name\":\"gwfqatmt\",\"type\":\"htmdvy\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        DeviceRegistryManager manager = DeviceRegistryManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        Schema response = manager.schemas()
            .getWithResponse("lvdnkfx", "semdwzrmu", "apfcqdpsq", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("lvez", response.properties().displayName());
        Assertions.assertEquals("pqlmfe", response.properties().description());
        Assertions.assertEquals(Format.JSON_SCHEMA_DRAFT7, response.properties().format());
        Assertions.assertEquals(SchemaType.MESSAGE_SCHEMA, response.properties().schemaType());
        Assertions.assertEquals("yhko", response.properties().tags().get("opgxedkowepb"));
    }
}
