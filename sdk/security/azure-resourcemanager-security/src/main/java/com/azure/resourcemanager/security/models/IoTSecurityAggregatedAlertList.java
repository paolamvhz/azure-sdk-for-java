// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.security.fluent.models.IoTSecurityAggregatedAlertInner;
import java.io.IOException;
import java.util.List;

/**
 * List of IoT Security solution aggregated alert data.
 */
@Fluent
public final class IoTSecurityAggregatedAlertList implements JsonSerializable<IoTSecurityAggregatedAlertList> {
    /*
     * List of aggregated alerts data.
     */
    private List<IoTSecurityAggregatedAlertInner> value;

    /*
     * When there is too much alert data for one page, use this URI to fetch the next page.
     */
    private String nextLink;

    /**
     * Creates an instance of IoTSecurityAggregatedAlertList class.
     */
    public IoTSecurityAggregatedAlertList() {
    }

    /**
     * Get the value property: List of aggregated alerts data.
     * 
     * @return the value value.
     */
    public List<IoTSecurityAggregatedAlertInner> value() {
        return this.value;
    }

    /**
     * Set the value property: List of aggregated alerts data.
     * 
     * @param value the value value to set.
     * @return the IoTSecurityAggregatedAlertList object itself.
     */
    public IoTSecurityAggregatedAlertList withValue(List<IoTSecurityAggregatedAlertInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: When there is too much alert data for one page, use this URI to fetch the next page.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property value in model IoTSecurityAggregatedAlertList"));
        } else {
            value().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(IoTSecurityAggregatedAlertList.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of IoTSecurityAggregatedAlertList from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of IoTSecurityAggregatedAlertList if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the IoTSecurityAggregatedAlertList.
     */
    public static IoTSecurityAggregatedAlertList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            IoTSecurityAggregatedAlertList deserializedIoTSecurityAggregatedAlertList
                = new IoTSecurityAggregatedAlertList();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<IoTSecurityAggregatedAlertInner> value
                        = reader.readArray(reader1 -> IoTSecurityAggregatedAlertInner.fromJson(reader1));
                    deserializedIoTSecurityAggregatedAlertList.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedIoTSecurityAggregatedAlertList.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedIoTSecurityAggregatedAlertList;
        });
    }
}
