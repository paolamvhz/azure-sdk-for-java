// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.SystemData;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.securityinsights.fluent.models.DataConnectorInner;
import com.azure.resourcemanager.securityinsights.fluent.models.TIDataConnectorProperties;
import java.io.IOException;
import java.time.OffsetDateTime;

/**
 * Represents threat intelligence data connector.
 */
@Fluent
public final class TIDataConnector extends DataConnectorInner {
    /*
     * The data connector kind
     */
    private DataConnectorKind kind = DataConnectorKind.THREAT_INTELLIGENCE;

    /*
     * TI (Threat Intelligence) data connector properties.
     */
    private TIDataConnectorProperties innerProperties;

    /*
     * Azure Resource Manager metadata containing createdBy and modifiedBy information.
     */
    private SystemData systemData;

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
     * Creates an instance of TIDataConnector class.
     */
    public TIDataConnector() {
    }

    /**
     * Get the kind property: The data connector kind.
     * 
     * @return the kind value.
     */
    @Override
    public DataConnectorKind kind() {
        return this.kind;
    }

    /**
     * Get the innerProperties property: TI (Threat Intelligence) data connector properties.
     * 
     * @return the innerProperties value.
     */
    private TIDataConnectorProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    @Override
    public SystemData systemData() {
        return this.systemData;
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
     * {@inheritDoc}
     */
    @Override
    public TIDataConnector withEtag(String etag) {
        super.withEtag(etag);
        return this;
    }

    /**
     * Get the tenantId property: The tenant id to connect to, and get the data from.
     * 
     * @return the tenantId value.
     */
    public String tenantId() {
        return this.innerProperties() == null ? null : this.innerProperties().tenantId();
    }

    /**
     * Set the tenantId property: The tenant id to connect to, and get the data from.
     * 
     * @param tenantId the tenantId value to set.
     * @return the TIDataConnector object itself.
     */
    public TIDataConnector withTenantId(String tenantId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new TIDataConnectorProperties();
        }
        this.innerProperties().withTenantId(tenantId);
        return this;
    }

    /**
     * Get the tipLookbackPeriod property: The lookback period for the feed to be imported.
     * 
     * @return the tipLookbackPeriod value.
     */
    public OffsetDateTime tipLookbackPeriod() {
        return this.innerProperties() == null ? null : this.innerProperties().tipLookbackPeriod();
    }

    /**
     * Set the tipLookbackPeriod property: The lookback period for the feed to be imported.
     * 
     * @param tipLookbackPeriod the tipLookbackPeriod value to set.
     * @return the TIDataConnector object itself.
     */
    public TIDataConnector withTipLookbackPeriod(OffsetDateTime tipLookbackPeriod) {
        if (this.innerProperties() == null) {
            this.innerProperties = new TIDataConnectorProperties();
        }
        this.innerProperties().withTipLookbackPeriod(tipLookbackPeriod);
        return this;
    }

    /**
     * Get the dataTypes property: The available data types for the connector.
     * 
     * @return the dataTypes value.
     */
    public TIDataConnectorDataTypes dataTypes() {
        return this.innerProperties() == null ? null : this.innerProperties().dataTypes();
    }

    /**
     * Set the dataTypes property: The available data types for the connector.
     * 
     * @param dataTypes the dataTypes value to set.
     * @return the TIDataConnector object itself.
     */
    public TIDataConnector withDataTypes(TIDataConnectorDataTypes dataTypes) {
        if (this.innerProperties() == null) {
            this.innerProperties = new TIDataConnectorProperties();
        }
        this.innerProperties().withDataTypes(dataTypes);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
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
        jsonWriter.writeStringField("etag", etag());
        jsonWriter.writeStringField("kind", this.kind == null ? null : this.kind.toString());
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TIDataConnector from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of TIDataConnector if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the TIDataConnector.
     */
    public static TIDataConnector fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            TIDataConnector deserializedTIDataConnector = new TIDataConnector();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedTIDataConnector.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedTIDataConnector.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedTIDataConnector.type = reader.getString();
                } else if ("etag".equals(fieldName)) {
                    deserializedTIDataConnector.withEtag(reader.getString());
                } else if ("systemData".equals(fieldName)) {
                    deserializedTIDataConnector.systemData = SystemData.fromJson(reader);
                } else if ("kind".equals(fieldName)) {
                    deserializedTIDataConnector.kind = DataConnectorKind.fromString(reader.getString());
                } else if ("properties".equals(fieldName)) {
                    deserializedTIDataConnector.innerProperties = TIDataConnectorProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedTIDataConnector;
        });
    }
}
