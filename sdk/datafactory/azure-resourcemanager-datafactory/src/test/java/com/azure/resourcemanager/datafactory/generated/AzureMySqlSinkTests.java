// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.AzureMySqlSink;

public final class AzureMySqlSinkTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AzureMySqlSink model = BinaryData.fromString(
            "{\"type\":\"AzureMySqlSink\",\"preCopyScript\":\"datavijdr\",\"writeBatchSize\":\"datayqvhz\",\"writeBatchTimeout\":\"datayvhrenozl\",\"sinkRetryCount\":\"dataqfghlosho\",\"sinkRetryWait\":\"datakpcmtsbandesalv\",\"maxConcurrentConnections\":\"datawrljmlo\",\"disableMetricsCollection\":\"datatzvtfyqe\",\"\":{\"xhcygfg\":\"databsyni\",\"aosttbwap\":\"datamdbazggr\"}}")
            .toObject(AzureMySqlSink.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AzureMySqlSink model = new AzureMySqlSink().withWriteBatchSize("datayqvhz")
            .withWriteBatchTimeout("datayvhrenozl")
            .withSinkRetryCount("dataqfghlosho")
            .withSinkRetryWait("datakpcmtsbandesalv")
            .withMaxConcurrentConnections("datawrljmlo")
            .withDisableMetricsCollection("datatzvtfyqe")
            .withPreCopyScript("datavijdr");
        model = BinaryData.fromObject(model).toObject(AzureMySqlSink.class);
    }
}
