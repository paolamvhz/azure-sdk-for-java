// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.streamanalytics.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * A collection of read-only information about the state of the connection to the private remote resource.
 */
@Immutable
public final class PrivateLinkConnectionState implements JsonSerializable<PrivateLinkConnectionState> {
    /*
     * Indicates whether the connection has been Approved/Rejected/Removed by the owner of the remote resource/service.
     */
    private String status;

    /*
     * The reason for approval/rejection of the connection.
     */
    private String description;

    /*
     * A message indicating if changes on the service provider require any updates on the consumer.
     */
    private String actionsRequired;

    /**
     * Creates an instance of PrivateLinkConnectionState class.
     */
    public PrivateLinkConnectionState() {
    }

    /**
     * Get the status property: Indicates whether the connection has been Approved/Rejected/Removed by the owner of the
     * remote resource/service.
     * 
     * @return the status value.
     */
    public String status() {
        return this.status;
    }

    /**
     * Get the description property: The reason for approval/rejection of the connection.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Get the actionsRequired property: A message indicating if changes on the service provider require any updates on
     * the consumer.
     * 
     * @return the actionsRequired value.
     */
    public String actionsRequired() {
        return this.actionsRequired;
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
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PrivateLinkConnectionState from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PrivateLinkConnectionState if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the PrivateLinkConnectionState.
     */
    public static PrivateLinkConnectionState fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PrivateLinkConnectionState deserializedPrivateLinkConnectionState = new PrivateLinkConnectionState();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("status".equals(fieldName)) {
                    deserializedPrivateLinkConnectionState.status = reader.getString();
                } else if ("description".equals(fieldName)) {
                    deserializedPrivateLinkConnectionState.description = reader.getString();
                } else if ("actionsRequired".equals(fieldName)) {
                    deserializedPrivateLinkConnectionState.actionsRequired = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPrivateLinkConnectionState;
        });
    }
}
