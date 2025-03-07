// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.RecommendationConfigStatus;
import com.azure.resourcemanager.security.models.RecommendationConfigurationProperties;
import com.azure.resourcemanager.security.models.RecommendationType;
import com.azure.resourcemanager.security.models.UpdateIotSecuritySolutionData;
import com.azure.resourcemanager.security.models.UserDefinedResourcesProperties;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class UpdateIotSecuritySolutionDataTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        UpdateIotSecuritySolutionData model = BinaryData.fromString(
            "{\"properties\":{\"userDefinedResources\":{\"query\":\"rnxxmueed\",\"querySubscriptions\":[\"rdvstkwqqtch\"]},\"recommendationsConfiguration\":[{\"recommendationType\":\"IoT_PermissiveInputFirewallRules\",\"name\":\"mtdaa\",\"status\":\"Disabled\"},{\"recommendationType\":\"IoT_IPFilter_DenyAll\",\"name\":\"wvgpiohg\",\"status\":\"Enabled\"},{\"recommendationType\":\"IoT_OpenPorts\",\"name\":\"fudxepxgyqagvrv\",\"status\":\"Enabled\"}]},\"tags\":{\"mfnjh\":\"ukghimdblxgw\"}}")
            .toObject(UpdateIotSecuritySolutionData.class);
        Assertions.assertEquals("ukghimdblxgw", model.tags().get("mfnjh"));
        Assertions.assertEquals("rnxxmueed", model.userDefinedResources().query());
        Assertions.assertEquals("rdvstkwqqtch", model.userDefinedResources().querySubscriptions().get(0));
        Assertions.assertEquals(RecommendationType.IO_T_PERMISSIVE_INPUT_FIREWALL_RULES,
            model.recommendationsConfiguration().get(0).recommendationType());
        Assertions.assertEquals(RecommendationConfigStatus.DISABLED,
            model.recommendationsConfiguration().get(0).status());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        UpdateIotSecuritySolutionData model = new UpdateIotSecuritySolutionData()
            .withTags(mapOf("mfnjh", "ukghimdblxgw"))
            .withUserDefinedResources(new UserDefinedResourcesProperties().withQuery("rnxxmueed")
                .withQuerySubscriptions(Arrays.asList("rdvstkwqqtch")))
            .withRecommendationsConfiguration(Arrays.asList(
                new RecommendationConfigurationProperties()
                    .withRecommendationType(RecommendationType.IO_T_PERMISSIVE_INPUT_FIREWALL_RULES)
                    .withStatus(RecommendationConfigStatus.DISABLED),
                new RecommendationConfigurationProperties()
                    .withRecommendationType(RecommendationType.IO_T_IPFILTER_DENY_ALL)
                    .withStatus(RecommendationConfigStatus.ENABLED),
                new RecommendationConfigurationProperties().withRecommendationType(RecommendationType.IO_T_OPEN_PORTS)
                    .withStatus(RecommendationConfigStatus.ENABLED)));
        model = BinaryData.fromObject(model).toObject(UpdateIotSecuritySolutionData.class);
        Assertions.assertEquals("ukghimdblxgw", model.tags().get("mfnjh"));
        Assertions.assertEquals("rnxxmueed", model.userDefinedResources().query());
        Assertions.assertEquals("rdvstkwqqtch", model.userDefinedResources().querySubscriptions().get(0));
        Assertions.assertEquals(RecommendationType.IO_T_PERMISSIVE_INPUT_FIREWALL_RULES,
            model.recommendationsConfiguration().get(0).recommendationType());
        Assertions.assertEquals(RecommendationConfigStatus.DISABLED,
            model.recommendationsConfiguration().get(0).status());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
