// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Has time period for pulling data for the forecast.
 */
@Fluent
public final class ForecastTimePeriod implements JsonSerializable<ForecastTimePeriod> {
    /*
     * The start date to pull data from.
     */
    private OffsetDateTime from;

    /*
     * The end date to pull data to.
     */
    private OffsetDateTime to;

    /**
     * Creates an instance of ForecastTimePeriod class.
     */
    public ForecastTimePeriod() {
    }

    /**
     * Get the from property: The start date to pull data from.
     * 
     * @return the from value.
     */
    public OffsetDateTime from() {
        return this.from;
    }

    /**
     * Set the from property: The start date to pull data from.
     * 
     * @param from the from value to set.
     * @return the ForecastTimePeriod object itself.
     */
    public ForecastTimePeriod withFrom(OffsetDateTime from) {
        this.from = from;
        return this;
    }

    /**
     * Get the to property: The end date to pull data to.
     * 
     * @return the to value.
     */
    public OffsetDateTime to() {
        return this.to;
    }

    /**
     * Set the to property: The end date to pull data to.
     * 
     * @param to the to value to set.
     * @return the ForecastTimePeriod object itself.
     */
    public ForecastTimePeriod withTo(OffsetDateTime to) {
        this.to = to;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (from() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property from in model ForecastTimePeriod"));
        }
        if (to() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property to in model ForecastTimePeriod"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ForecastTimePeriod.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("from",
            this.from == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.from));
        jsonWriter.writeStringField("to",
            this.to == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.to));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ForecastTimePeriod from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ForecastTimePeriod if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ForecastTimePeriod.
     */
    public static ForecastTimePeriod fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ForecastTimePeriod deserializedForecastTimePeriod = new ForecastTimePeriod();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("from".equals(fieldName)) {
                    deserializedForecastTimePeriod.from = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("to".equals(fieldName)) {
                    deserializedForecastTimePeriod.to = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedForecastTimePeriod;
        });
    }
}
