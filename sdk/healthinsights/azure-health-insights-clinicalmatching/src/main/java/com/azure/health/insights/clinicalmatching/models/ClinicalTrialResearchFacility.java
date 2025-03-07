// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.health.insights.clinicalmatching.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Details of a research facility where a clinical trial is conducted.
 */
@Fluent
public final class ClinicalTrialResearchFacility implements JsonSerializable<ClinicalTrialResearchFacility> {

    /*
     * The facility's name.
     */
    @Generated
    private final String name;

    /*
     * City name.
     */
    @Generated
    private String city;

    /*
     * State name.
     */
    @Generated
    private String state;

    /*
     * Country/region name.
     */
    @Generated
    private final String countryOrRegion;

    /**
     * Creates an instance of ClinicalTrialResearchFacility class.
     *
     * @param name the name value to set.
     * @param countryOrRegion the countryOrRegion value to set.
     */
    @Generated
    public ClinicalTrialResearchFacility(String name, String countryOrRegion) {
        this.name = name;
        this.countryOrRegion = countryOrRegion;
    }

    /**
     * Get the name property: The facility's name.
     *
     * @return the name value.
     */
    @Generated
    public String getName() {
        return this.name;
    }

    /**
     * Get the city property: City name.
     *
     * @return the city value.
     */
    @Generated
    public String getCity() {
        return this.city;
    }

    /**
     * Set the city property: City name.
     *
     * @param city the city value to set.
     * @return the ClinicalTrialResearchFacility object itself.
     */
    @Generated
    public ClinicalTrialResearchFacility setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * Get the state property: State name.
     *
     * @return the state value.
     */
    @Generated
    public String getState() {
        return this.state;
    }

    /**
     * Set the state property: State name.
     *
     * @param state the state value to set.
     * @return the ClinicalTrialResearchFacility object itself.
     */
    @Generated
    public ClinicalTrialResearchFacility setState(String state) {
        this.state = state;
        return this;
    }

    /**
     * Get the countryOrRegion property: Country/region name.
     *
     * @return the countryOrRegion value.
     */
    @Generated
    public String getCountryOrRegion() {
        return this.countryOrRegion;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("countryOrRegion", this.countryOrRegion);
        jsonWriter.writeStringField("city", this.city);
        jsonWriter.writeStringField("state", this.state);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ClinicalTrialResearchFacility from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of ClinicalTrialResearchFacility if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ClinicalTrialResearchFacility.
     */
    @Generated
    public static ClinicalTrialResearchFacility fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String name = null;
            String countryOrRegion = null;
            String city = null;
            String state = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("name".equals(fieldName)) {
                    name = reader.getString();
                } else if ("countryOrRegion".equals(fieldName)) {
                    countryOrRegion = reader.getString();
                } else if ("city".equals(fieldName)) {
                    city = reader.getString();
                } else if ("state".equals(fieldName)) {
                    state = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            ClinicalTrialResearchFacility deserializedClinicalTrialResearchFacility
                = new ClinicalTrialResearchFacility(name, countryOrRegion);
            deserializedClinicalTrialResearchFacility.city = city;
            deserializedClinicalTrialResearchFacility.state = state;
            return deserializedClinicalTrialResearchFacility;
        });
    }
}
