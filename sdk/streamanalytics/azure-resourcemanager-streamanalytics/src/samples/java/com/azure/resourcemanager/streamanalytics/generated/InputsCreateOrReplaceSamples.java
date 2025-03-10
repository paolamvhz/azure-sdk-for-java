// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.streamanalytics.generated;

import com.azure.resourcemanager.streamanalytics.models.AvroSerialization;
import com.azure.resourcemanager.streamanalytics.models.BlobReferenceInputDataSource;
import com.azure.resourcemanager.streamanalytics.models.BlobStreamInputDataSource;
import com.azure.resourcemanager.streamanalytics.models.CsvSerialization;
import com.azure.resourcemanager.streamanalytics.models.Encoding;
import com.azure.resourcemanager.streamanalytics.models.EventHubStreamInputDataSource;
import com.azure.resourcemanager.streamanalytics.models.FileReferenceInputDataSource;
import com.azure.resourcemanager.streamanalytics.models.GatewayMessageBusStreamInputDataSource;
import com.azure.resourcemanager.streamanalytics.models.IoTHubStreamInputDataSource;
import com.azure.resourcemanager.streamanalytics.models.JsonSerialization;
import com.azure.resourcemanager.streamanalytics.models.ReferenceInputProperties;
import com.azure.resourcemanager.streamanalytics.models.StorageAccount;
import com.azure.resourcemanager.streamanalytics.models.StreamInputProperties;
import java.util.Arrays;

/**
 * Samples for Inputs CreateOrReplace.
 */
public final class InputsCreateOrReplaceSamples {
    /*
     * x-ms-original-file:
     * specification/streamanalytics/resource-manager/Microsoft.StreamAnalytics/stable/2020-03-01/examples/
     * Input_Create_Reference_File.json
     */
    /**
     * Sample code: Create a reference file input.
     * 
     * @param manager Entry point to StreamAnalyticsManager.
     */
    public static void
        createAReferenceFileInput(com.azure.resourcemanager.streamanalytics.StreamAnalyticsManager manager) {
        manager.inputs()
            .define("input7225")
            .withExistingStreamingjob("sjrg8440", "sj9597")
            .withProperties(
                new ReferenceInputProperties().withDatasource(new FileReferenceInputDataSource().withPath("my/path")))
            .create();
    }

    /*
     * x-ms-original-file:
     * specification/streamanalytics/resource-manager/Microsoft.StreamAnalytics/stable/2020-03-01/examples/
     * Input_Create_Stream_IoTHub_Avro.json
     */
    /**
     * Sample code: Create a stream IoT Hub input with Avro serialization.
     * 
     * @param manager Entry point to StreamAnalyticsManager.
     */
    public static void createAStreamIoTHubInputWithAvroSerialization(
        com.azure.resourcemanager.streamanalytics.StreamAnalyticsManager manager) {
        manager.inputs()
            .define("input7970")
            .withExistingStreamingjob("sjrg3467", "sj9742")
            .withProperties(new StreamInputProperties().withSerialization(new AvroSerialization())
                .withDatasource(new IoTHubStreamInputDataSource().withIotHubNamespace("iothub")
                    .withSharedAccessPolicyName("owner")
                    .withSharedAccessPolicyKey("fakeTokenPlaceholder")
                    .withConsumerGroupName("sdkconsumergroup")
                    .withEndpoint("messages/events")))
            .create();
    }

    /*
     * x-ms-original-file:
     * specification/streamanalytics/resource-manager/Microsoft.StreamAnalytics/stable/2020-03-01/examples/
     * Input_Create_Reference_Blob_CSV.json
     */
    /**
     * Sample code: Create a reference blob input with CSV serialization.
     * 
     * @param manager Entry point to StreamAnalyticsManager.
     */
    public static void createAReferenceBlobInputWithCSVSerialization(
        com.azure.resourcemanager.streamanalytics.StreamAnalyticsManager manager) {
        manager.inputs()
            .define("input7225")
            .withExistingStreamingjob("sjrg8440", "sj9597")
            .withProperties(new ReferenceInputProperties()
                .withSerialization(new CsvSerialization().withFieldDelimiter(",").withEncoding(Encoding.UTF8))
                .withDatasource(new BlobReferenceInputDataSource()
                    .withStorageAccounts(Arrays.asList(
                        new StorageAccount().withAccountName("someAccountName").withAccountKey("fakeTokenPlaceholder")))
                    .withContainer("state")
                    .withPathPattern("{date}/{time}")
                    .withDateFormat("yyyy/MM/dd")
                    .withTimeFormat("HH")))
            .create();
    }

    /*
     * x-ms-original-file:
     * specification/streamanalytics/resource-manager/Microsoft.StreamAnalytics/stable/2020-03-01/examples/
     * Input_Create_GatewayMessageBus.json
     */
    /**
     * Sample code: Create a Gateway Message Bus input.
     * 
     * @param manager Entry point to StreamAnalyticsManager.
     */
    public static void
        createAGatewayMessageBusInput(com.azure.resourcemanager.streamanalytics.StreamAnalyticsManager manager) {
        manager.inputs()
            .define("input7970")
            .withExistingStreamingjob("sjrg3467", "sj9742")
            .withProperties(new StreamInputProperties()
                .withDatasource(new GatewayMessageBusStreamInputDataSource().withTopic("EdgeTopic1")))
            .create();
    }

    /*
     * x-ms-original-file:
     * specification/streamanalytics/resource-manager/Microsoft.StreamAnalytics/stable/2020-03-01/examples/
     * Input_Create_Stream_EventHub_JSON.json
     */
    /**
     * Sample code: Create a stream Event Hub input with JSON serialization.
     * 
     * @param manager Entry point to StreamAnalyticsManager.
     */
    public static void createAStreamEventHubInputWithJSONSerialization(
        com.azure.resourcemanager.streamanalytics.StreamAnalyticsManager manager) {
        manager.inputs()
            .define("input7425")
            .withExistingStreamingjob("sjrg3139", "sj197")
            .withProperties(
                new StreamInputProperties().withSerialization(new JsonSerialization().withEncoding(Encoding.UTF8))
                    .withDatasource(new EventHubStreamInputDataSource().withConsumerGroupName("sdkconsumergroup")
                        .withEventHubName("sdkeventhub")
                        .withServiceBusNamespace("sdktest")
                        .withSharedAccessPolicyName("RootManageSharedAccessKey")
                        .withSharedAccessPolicyKey("fakeTokenPlaceholder")))
            .create();
    }

    /*
     * x-ms-original-file:
     * specification/streamanalytics/resource-manager/Microsoft.StreamAnalytics/stable/2020-03-01/examples/
     * Input_Create_Stream_Blob_CSV.json
     */
    /**
     * Sample code: Create a stream blob input with CSV serialization.
     * 
     * @param manager Entry point to StreamAnalyticsManager.
     */
    public static void createAStreamBlobInputWithCSVSerialization(
        com.azure.resourcemanager.streamanalytics.StreamAnalyticsManager manager) {
        manager.inputs()
            .define("input8899")
            .withExistingStreamingjob("sjrg8161", "sj6695")
            .withProperties(new StreamInputProperties()
                .withSerialization(new CsvSerialization().withFieldDelimiter(",").withEncoding(Encoding.UTF8))
                .withDatasource(new BlobStreamInputDataSource().withSourcePartitionCount(16)
                    .withStorageAccounts(Arrays.asList(
                        new StorageAccount().withAccountName("someAccountName").withAccountKey("fakeTokenPlaceholder")))
                    .withContainer("state")
                    .withPathPattern("{date}/{time}")
                    .withDateFormat("yyyy/MM/dd")
                    .withTimeFormat("HH")))
            .create();
    }
}
