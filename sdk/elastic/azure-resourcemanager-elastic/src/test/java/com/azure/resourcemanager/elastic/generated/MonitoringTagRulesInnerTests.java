// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elastic.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.elastic.fluent.models.MonitoringTagRulesInner;
import com.azure.resourcemanager.elastic.models.FilteringTag;
import com.azure.resourcemanager.elastic.models.LogRules;
import com.azure.resourcemanager.elastic.models.MonitoringTagRulesProperties;
import com.azure.resourcemanager.elastic.models.ProvisioningState;
import com.azure.resourcemanager.elastic.models.TagAction;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class MonitoringTagRulesInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MonitoringTagRulesInner model = BinaryData.fromString(
            "{\"properties\":{\"provisioningState\":\"Failed\",\"logRules\":{\"sendAadLogs\":false,\"sendSubscriptionLogs\":false,\"sendActivityLogs\":false,\"filteringTags\":[{\"name\":\"mzsb\",\"value\":\"oggigrxwburv\",\"action\":\"Include\"},{\"name\":\"nspydptkoenkoukn\",\"value\":\"dwtiukbldngkp\",\"action\":\"Exclude\"},{\"name\":\"azyxoegukg\",\"value\":\"piu\",\"action\":\"Exclude\"},{\"name\":\"evqzntypmrbp\",\"value\":\"c\",\"action\":\"Exclude\"}]}},\"id\":\"sdpydnfyhxdeoejz\",\"name\":\"cwif\",\"type\":\"jttgzf\"}")
            .toObject(MonitoringTagRulesInner.class);
        Assertions.assertEquals(ProvisioningState.FAILED, model.properties().provisioningState());
        Assertions.assertEquals(false, model.properties().logRules().sendAadLogs());
        Assertions.assertEquals(false, model.properties().logRules().sendSubscriptionLogs());
        Assertions.assertEquals(false, model.properties().logRules().sendActivityLogs());
        Assertions.assertEquals("mzsb", model.properties().logRules().filteringTags().get(0).name());
        Assertions.assertEquals("oggigrxwburv", model.properties().logRules().filteringTags().get(0).value());
        Assertions.assertEquals(TagAction.INCLUDE, model.properties().logRules().filteringTags().get(0).action());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MonitoringTagRulesInner model = new MonitoringTagRulesInner()
            .withProperties(new MonitoringTagRulesProperties().withProvisioningState(ProvisioningState.FAILED)
                .withLogRules(new LogRules().withSendAadLogs(false)
                    .withSendSubscriptionLogs(false)
                    .withSendActivityLogs(false)
                    .withFilteringTags(Arrays.asList(
                        new FilteringTag().withName("mzsb").withValue("oggigrxwburv").withAction(TagAction.INCLUDE),
                        new FilteringTag().withName("nspydptkoenkoukn")
                            .withValue("dwtiukbldngkp")
                            .withAction(TagAction.EXCLUDE),
                        new FilteringTag().withName("azyxoegukg").withValue("piu").withAction(TagAction.EXCLUDE),
                        new FilteringTag().withName("evqzntypmrbp").withValue("c").withAction(TagAction.EXCLUDE)))));
        model = BinaryData.fromObject(model).toObject(MonitoringTagRulesInner.class);
        Assertions.assertEquals(ProvisioningState.FAILED, model.properties().provisioningState());
        Assertions.assertEquals(false, model.properties().logRules().sendAadLogs());
        Assertions.assertEquals(false, model.properties().logRules().sendSubscriptionLogs());
        Assertions.assertEquals(false, model.properties().logRules().sendActivityLogs());
        Assertions.assertEquals("mzsb", model.properties().logRules().filteringTags().get(0).name());
        Assertions.assertEquals("oggigrxwburv", model.properties().logRules().filteringTags().get(0).value());
        Assertions.assertEquals(TagAction.INCLUDE, model.properties().logRules().filteringTags().get(0).action());
    }
}
