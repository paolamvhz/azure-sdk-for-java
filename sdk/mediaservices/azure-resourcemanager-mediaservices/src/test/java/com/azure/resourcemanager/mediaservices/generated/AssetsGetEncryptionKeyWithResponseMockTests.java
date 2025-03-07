// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.mediaservices.MediaServicesManager;
import com.azure.resourcemanager.mediaservices.models.StorageEncryptedAssetDecryptionData;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class AssetsGetEncryptionKeyWithResponseMockTests {
    @Test
    public void testGetEncryptionKeyWithResponse() throws Exception {
        String responseStr
            = "{\"assetFileEncryptionMetadata\":[{\"initializationVector\":\"tvwkpqhjpenu\",\"assetFileName\":\"bqeqqekewvnqvcd\",\"assetFileId\":\"4383dafc-7627-41be-97c6-6136d88633bb\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        MediaServicesManager manager = MediaServicesManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        StorageEncryptedAssetDecryptionData response = manager.assets()
            .getEncryptionKeyWithResponse("haru", "t", "iqxf", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("tvwkpqhjpenu", response.assetFileEncryptionMetadata().get(0).initializationVector());
        Assertions.assertEquals("bqeqqekewvnqvcd", response.assetFileEncryptionMetadata().get(0).assetFileName());
        Assertions.assertEquals(UUID.fromString("4383dafc-7627-41be-97c6-6136d88633bb"),
            response.assetFileEncryptionMetadata().get(0).assetFileId());
    }
}
