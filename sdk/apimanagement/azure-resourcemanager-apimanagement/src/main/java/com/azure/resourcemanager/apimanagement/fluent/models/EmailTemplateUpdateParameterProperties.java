// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.apimanagement.models.EmailTemplateParametersContractProperties;
import java.io.IOException;
import java.util.List;

/**
 * Email Template Update Contract properties.
 */
@Fluent
public final class EmailTemplateUpdateParameterProperties
    implements JsonSerializable<EmailTemplateUpdateParameterProperties> {
    /*
     * Subject of the Template.
     */
    private String subject;

    /*
     * Title of the Template.
     */
    private String title;

    /*
     * Description of the Email Template.
     */
    private String description;

    /*
     * Email Template Body. This should be a valid XDocument
     */
    private String body;

    /*
     * Email Template Parameter values.
     */
    private List<EmailTemplateParametersContractProperties> parameters;

    /**
     * Creates an instance of EmailTemplateUpdateParameterProperties class.
     */
    public EmailTemplateUpdateParameterProperties() {
    }

    /**
     * Get the subject property: Subject of the Template.
     * 
     * @return the subject value.
     */
    public String subject() {
        return this.subject;
    }

    /**
     * Set the subject property: Subject of the Template.
     * 
     * @param subject the subject value to set.
     * @return the EmailTemplateUpdateParameterProperties object itself.
     */
    public EmailTemplateUpdateParameterProperties withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Get the title property: Title of the Template.
     * 
     * @return the title value.
     */
    public String title() {
        return this.title;
    }

    /**
     * Set the title property: Title of the Template.
     * 
     * @param title the title value to set.
     * @return the EmailTemplateUpdateParameterProperties object itself.
     */
    public EmailTemplateUpdateParameterProperties withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get the description property: Description of the Email Template.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: Description of the Email Template.
     * 
     * @param description the description value to set.
     * @return the EmailTemplateUpdateParameterProperties object itself.
     */
    public EmailTemplateUpdateParameterProperties withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the body property: Email Template Body. This should be a valid XDocument.
     * 
     * @return the body value.
     */
    public String body() {
        return this.body;
    }

    /**
     * Set the body property: Email Template Body. This should be a valid XDocument.
     * 
     * @param body the body value to set.
     * @return the EmailTemplateUpdateParameterProperties object itself.
     */
    public EmailTemplateUpdateParameterProperties withBody(String body) {
        this.body = body;
        return this;
    }

    /**
     * Get the parameters property: Email Template Parameter values.
     * 
     * @return the parameters value.
     */
    public List<EmailTemplateParametersContractProperties> parameters() {
        return this.parameters;
    }

    /**
     * Set the parameters property: Email Template Parameter values.
     * 
     * @param parameters the parameters value to set.
     * @return the EmailTemplateUpdateParameterProperties object itself.
     */
    public EmailTemplateUpdateParameterProperties
        withParameters(List<EmailTemplateParametersContractProperties> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (parameters() != null) {
            parameters().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("subject", this.subject);
        jsonWriter.writeStringField("title", this.title);
        jsonWriter.writeStringField("description", this.description);
        jsonWriter.writeStringField("body", this.body);
        jsonWriter.writeArrayField("parameters", this.parameters, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of EmailTemplateUpdateParameterProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of EmailTemplateUpdateParameterProperties if the JsonReader was pointing to an instance of
     * it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the EmailTemplateUpdateParameterProperties.
     */
    public static EmailTemplateUpdateParameterProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            EmailTemplateUpdateParameterProperties deserializedEmailTemplateUpdateParameterProperties
                = new EmailTemplateUpdateParameterProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("subject".equals(fieldName)) {
                    deserializedEmailTemplateUpdateParameterProperties.subject = reader.getString();
                } else if ("title".equals(fieldName)) {
                    deserializedEmailTemplateUpdateParameterProperties.title = reader.getString();
                } else if ("description".equals(fieldName)) {
                    deserializedEmailTemplateUpdateParameterProperties.description = reader.getString();
                } else if ("body".equals(fieldName)) {
                    deserializedEmailTemplateUpdateParameterProperties.body = reader.getString();
                } else if ("parameters".equals(fieldName)) {
                    List<EmailTemplateParametersContractProperties> parameters
                        = reader.readArray(reader1 -> EmailTemplateParametersContractProperties.fromJson(reader1));
                    deserializedEmailTemplateUpdateParameterProperties.parameters = parameters;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedEmailTemplateUpdateParameterProperties;
        });
    }
}
