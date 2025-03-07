// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datalakestore.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datalakestore.fluent.models.CreateOrUpdateVirtualNetworkRuleProperties;
import java.io.IOException;

/**
 * The parameters used to create a new virtual network rule.
 */
@Fluent
public final class CreateOrUpdateVirtualNetworkRuleParameters
    implements JsonSerializable<CreateOrUpdateVirtualNetworkRuleParameters> {
    /*
     * The virtual network rule properties to use when creating a new virtual network rule.
     */
    private CreateOrUpdateVirtualNetworkRuleProperties innerProperties
        = new CreateOrUpdateVirtualNetworkRuleProperties();

    /**
     * Creates an instance of CreateOrUpdateVirtualNetworkRuleParameters class.
     */
    public CreateOrUpdateVirtualNetworkRuleParameters() {
    }

    /**
     * Get the innerProperties property: The virtual network rule properties to use when creating a new virtual network
     * rule.
     * 
     * @return the innerProperties value.
     */
    private CreateOrUpdateVirtualNetworkRuleProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the subnetId property: The resource identifier for the subnet.
     * 
     * @return the subnetId value.
     */
    public String subnetId() {
        return this.innerProperties() == null ? null : this.innerProperties().subnetId();
    }

    /**
     * Set the subnetId property: The resource identifier for the subnet.
     * 
     * @param subnetId the subnetId value to set.
     * @return the CreateOrUpdateVirtualNetworkRuleParameters object itself.
     */
    public CreateOrUpdateVirtualNetworkRuleParameters withSubnetId(String subnetId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new CreateOrUpdateVirtualNetworkRuleProperties();
        }
        this.innerProperties().withSubnetId(subnetId);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property innerProperties in model CreateOrUpdateVirtualNetworkRuleParameters"));
        } else {
            innerProperties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(CreateOrUpdateVirtualNetworkRuleParameters.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CreateOrUpdateVirtualNetworkRuleParameters from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CreateOrUpdateVirtualNetworkRuleParameters if the JsonReader was pointing to an instance
     * of it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CreateOrUpdateVirtualNetworkRuleParameters.
     */
    public static CreateOrUpdateVirtualNetworkRuleParameters fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CreateOrUpdateVirtualNetworkRuleParameters deserializedCreateOrUpdateVirtualNetworkRuleParameters
                = new CreateOrUpdateVirtualNetworkRuleParameters();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("properties".equals(fieldName)) {
                    deserializedCreateOrUpdateVirtualNetworkRuleParameters.innerProperties
                        = CreateOrUpdateVirtualNetworkRuleProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCreateOrUpdateVirtualNetworkRuleParameters;
        });
    }
}
