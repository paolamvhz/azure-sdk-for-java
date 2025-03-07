// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datalakeanalytics.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.datalakeanalytics.DataLakeAnalyticsManager;
import com.azure.resourcemanager.datalakeanalytics.models.DataLakeAnalyticsAccountBasic;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class AccountsListByResourceGroupMockTests {
    @Test
    public void testListByResourceGroup() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"accountId\":\"cff1813b-b47c-4b29-87b1-30a183d6faf5\",\"provisioningState\":\"Canceled\",\"state\":\"Suspended\",\"creationTime\":\"2021-11-06T18:49:40Z\",\"lastModifiedTime\":\"2021-10-14T05:29:13Z\",\"endpoint\":\"znud\"},\"location\":\"od\",\"tags\":{\"rzdzucerscdnt\":\"bncblylpstdbhhx\"},\"id\":\"evfiwjmygt\",\"name\":\"sslswtmweriof\",\"type\":\"pyqs\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        DataLakeAnalyticsManager manager = DataLakeAnalyticsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<DataLakeAnalyticsAccountBasic> response = manager.accounts()
            .listByResourceGroup("aolps", "lqlfm", 219002993, 57076299, "bbglzpswiydmc", "yhz", true,
                com.azure.core.util.Context.NONE);

        Assertions.assertEquals("od", response.iterator().next().location());
        Assertions.assertEquals("bncblylpstdbhhx", response.iterator().next().tags().get("rzdzucerscdnt"));
    }
}
