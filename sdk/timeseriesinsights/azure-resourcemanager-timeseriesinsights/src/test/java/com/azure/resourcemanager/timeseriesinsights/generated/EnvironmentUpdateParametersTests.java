// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.timeseriesinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.timeseriesinsights.models.EnvironmentUpdateParameters;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class EnvironmentUpdateParametersTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        EnvironmentUpdateParameters model = BinaryData.fromString(
            "{\"kind\":\"EnvironmentUpdateParameters\",\"tags\":{\"jbavorxzdm\":\"wd\",\"nvowgujju\":\"hctbqvudwxdn\",\"zj\":\"wdkcglhsl\"}}")
            .toObject(EnvironmentUpdateParameters.class);
        Assertions.assertEquals("wd", model.tags().get("jbavorxzdm"));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        EnvironmentUpdateParameters model = new EnvironmentUpdateParameters()
            .withTags(mapOf("jbavorxzdm", "wd", "nvowgujju", "hctbqvudwxdn", "zj", "wdkcglhsl"));
        model = BinaryData.fromObject(model).toObject(EnvironmentUpdateParameters.class);
        Assertions.assertEquals("wd", model.tags().get("jbavorxzdm"));
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
