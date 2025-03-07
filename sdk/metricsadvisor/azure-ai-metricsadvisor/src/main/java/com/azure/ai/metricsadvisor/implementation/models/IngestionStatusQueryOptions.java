// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The IngestionStatusQueryOptions model.
 */
@Fluent
public final class IngestionStatusQueryOptions implements JsonSerializable<IngestionStatusQueryOptions> {
    /*
     * the start point of time range to query data ingestion status.
     */
    private OffsetDateTime startTime;

    /*
     * the end point of time range to query data ingestion status.
     */
    private OffsetDateTime endTime;

    /**
     * Creates an instance of IngestionStatusQueryOptions class.
     */
    public IngestionStatusQueryOptions() {
    }

    /**
     * Get the startTime property: the start point of time range to query data ingestion status.
     * 
     * @return the startTime value.
     */
    public OffsetDateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Set the startTime property: the start point of time range to query data ingestion status.
     * 
     * @param startTime the startTime value to set.
     * @return the IngestionStatusQueryOptions object itself.
     */
    public IngestionStatusQueryOptions setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get the endTime property: the end point of time range to query data ingestion status.
     * 
     * @return the endTime value.
     */
    public OffsetDateTime getEndTime() {
        return this.endTime;
    }

    /**
     * Set the endTime property: the end point of time range to query data ingestion status.
     * 
     * @param endTime the endTime value to set.
     * @return the IngestionStatusQueryOptions object itself.
     */
    public IngestionStatusQueryOptions setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("startTime",
            this.startTime == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.startTime));
        jsonWriter.writeStringField("endTime",
            this.endTime == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.endTime));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of IngestionStatusQueryOptions from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of IngestionStatusQueryOptions if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the IngestionStatusQueryOptions.
     */
    public static IngestionStatusQueryOptions fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            IngestionStatusQueryOptions deserializedIngestionStatusQueryOptions = new IngestionStatusQueryOptions();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("startTime".equals(fieldName)) {
                    deserializedIngestionStatusQueryOptions.startTime = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("endTime".equals(fieldName)) {
                    deserializedIngestionStatusQueryOptions.endTime = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedIngestionStatusQueryOptions;
        });
    }
}
