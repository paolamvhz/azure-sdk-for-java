// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Export Route Policy Configuration.
 */
@Fluent
public final class ExportRoutePolicyInformation implements JsonSerializable<ExportRoutePolicyInformation> {
    /*
     * Export IPv4 Route Policy Id.
     */
    private String exportIpv4RoutePolicyId;

    /*
     * Export IPv6 Route Policy Id.
     */
    private String exportIpv6RoutePolicyId;

    /**
     * Creates an instance of ExportRoutePolicyInformation class.
     */
    public ExportRoutePolicyInformation() {
    }

    /**
     * Get the exportIpv4RoutePolicyId property: Export IPv4 Route Policy Id.
     * 
     * @return the exportIpv4RoutePolicyId value.
     */
    public String exportIpv4RoutePolicyId() {
        return this.exportIpv4RoutePolicyId;
    }

    /**
     * Set the exportIpv4RoutePolicyId property: Export IPv4 Route Policy Id.
     * 
     * @param exportIpv4RoutePolicyId the exportIpv4RoutePolicyId value to set.
     * @return the ExportRoutePolicyInformation object itself.
     */
    public ExportRoutePolicyInformation withExportIpv4RoutePolicyId(String exportIpv4RoutePolicyId) {
        this.exportIpv4RoutePolicyId = exportIpv4RoutePolicyId;
        return this;
    }

    /**
     * Get the exportIpv6RoutePolicyId property: Export IPv6 Route Policy Id.
     * 
     * @return the exportIpv6RoutePolicyId value.
     */
    public String exportIpv6RoutePolicyId() {
        return this.exportIpv6RoutePolicyId;
    }

    /**
     * Set the exportIpv6RoutePolicyId property: Export IPv6 Route Policy Id.
     * 
     * @param exportIpv6RoutePolicyId the exportIpv6RoutePolicyId value to set.
     * @return the ExportRoutePolicyInformation object itself.
     */
    public ExportRoutePolicyInformation withExportIpv6RoutePolicyId(String exportIpv6RoutePolicyId) {
        this.exportIpv6RoutePolicyId = exportIpv6RoutePolicyId;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("exportIpv4RoutePolicyId", this.exportIpv4RoutePolicyId);
        jsonWriter.writeStringField("exportIpv6RoutePolicyId", this.exportIpv6RoutePolicyId);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ExportRoutePolicyInformation from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ExportRoutePolicyInformation if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ExportRoutePolicyInformation.
     */
    public static ExportRoutePolicyInformation fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ExportRoutePolicyInformation deserializedExportRoutePolicyInformation = new ExportRoutePolicyInformation();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("exportIpv4RoutePolicyId".equals(fieldName)) {
                    deserializedExportRoutePolicyInformation.exportIpv4RoutePolicyId = reader.getString();
                } else if ("exportIpv6RoutePolicyId".equals(fieldName)) {
                    deserializedExportRoutePolicyInformation.exportIpv6RoutePolicyId = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedExportRoutePolicyInformation;
        });
    }
}
