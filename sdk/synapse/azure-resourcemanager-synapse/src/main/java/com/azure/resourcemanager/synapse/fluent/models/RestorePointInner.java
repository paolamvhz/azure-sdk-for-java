// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.management.ProxyResource;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.synapse.models.RestorePointType;
import java.io.IOException;
import java.time.OffsetDateTime;

/**
 * Database restore points.
 */
@Immutable
public final class RestorePointInner extends ProxyResource {
    /*
     * Resource location.
     */
    private String location;

    /*
     * Resource properties.
     */
    private RestorePointProperties innerProperties;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /**
     * Creates an instance of RestorePointInner class.
     */
    public RestorePointInner() {
    }

    /**
     * Get the location property: Resource location.
     * 
     * @return the location value.
     */
    public String location() {
        return this.location;
    }

    /**
     * Get the innerProperties property: Resource properties.
     * 
     * @return the innerProperties value.
     */
    private RestorePointProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
    }

    /**
     * Get the restorePointType property: The type of restore point.
     * 
     * @return the restorePointType value.
     */
    public RestorePointType restorePointType() {
        return this.innerProperties() == null ? null : this.innerProperties().restorePointType();
    }

    /**
     * Get the earliestRestoreDate property: The earliest time to which this database can be restored.
     * 
     * @return the earliestRestoreDate value.
     */
    public OffsetDateTime earliestRestoreDate() {
        return this.innerProperties() == null ? null : this.innerProperties().earliestRestoreDate();
    }

    /**
     * Get the restorePointCreationDate property: The time the backup was taken.
     * 
     * @return the restorePointCreationDate value.
     */
    public OffsetDateTime restorePointCreationDate() {
        return this.innerProperties() == null ? null : this.innerProperties().restorePointCreationDate();
    }

    /**
     * Get the restorePointLabel property: The label of restore point for backup request by user.
     * 
     * @return the restorePointLabel value.
     */
    public String restorePointLabel() {
        return this.innerProperties() == null ? null : this.innerProperties().restorePointLabel();
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }

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
     * Reads an instance of RestorePointInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RestorePointInner if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the RestorePointInner.
     */
    public static RestorePointInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RestorePointInner deserializedRestorePointInner = new RestorePointInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedRestorePointInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedRestorePointInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedRestorePointInner.type = reader.getString();
                } else if ("location".equals(fieldName)) {
                    deserializedRestorePointInner.location = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedRestorePointInner.innerProperties = RestorePointProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRestorePointInner;
        });
    }
}
