// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resourcehealth.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Azure service impacted by the service health event.
 */
@Fluent
public final class Impact implements JsonSerializable<Impact> {
    /*
     * Impacted service name.
     */
    private String impactedService;

    /*
     * List regions impacted by the service health event.
     */
    private List<ImpactedServiceRegion> impactedRegions;

    /**
     * Creates an instance of Impact class.
     */
    public Impact() {
    }

    /**
     * Get the impactedService property: Impacted service name.
     * 
     * @return the impactedService value.
     */
    public String impactedService() {
        return this.impactedService;
    }

    /**
     * Set the impactedService property: Impacted service name.
     * 
     * @param impactedService the impactedService value to set.
     * @return the Impact object itself.
     */
    public Impact withImpactedService(String impactedService) {
        this.impactedService = impactedService;
        return this;
    }

    /**
     * Get the impactedRegions property: List regions impacted by the service health event.
     * 
     * @return the impactedRegions value.
     */
    public List<ImpactedServiceRegion> impactedRegions() {
        return this.impactedRegions;
    }

    /**
     * Set the impactedRegions property: List regions impacted by the service health event.
     * 
     * @param impactedRegions the impactedRegions value to set.
     * @return the Impact object itself.
     */
    public Impact withImpactedRegions(List<ImpactedServiceRegion> impactedRegions) {
        this.impactedRegions = impactedRegions;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (impactedRegions() != null) {
            impactedRegions().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("impactedService", this.impactedService);
        jsonWriter.writeArrayField("impactedRegions", this.impactedRegions,
            (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of Impact from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of Impact if the JsonReader was pointing to an instance of it, or null if it was pointing to
     * JSON null.
     * @throws IOException If an error occurs while reading the Impact.
     */
    public static Impact fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            Impact deserializedImpact = new Impact();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("impactedService".equals(fieldName)) {
                    deserializedImpact.impactedService = reader.getString();
                } else if ("impactedRegions".equals(fieldName)) {
                    List<ImpactedServiceRegion> impactedRegions
                        = reader.readArray(reader1 -> ImpactedServiceRegion.fromJson(reader1));
                    deserializedImpact.impactedRegions = impactedRegions;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedImpact;
        });
    }
}
