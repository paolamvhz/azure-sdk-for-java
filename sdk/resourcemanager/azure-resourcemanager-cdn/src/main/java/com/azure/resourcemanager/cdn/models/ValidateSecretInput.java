// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Input of the secret to be validated.
 */
@Fluent
public final class ValidateSecretInput implements JsonSerializable<ValidateSecretInput> {
    /*
     * The secret type.
     */
    private SecretType secretType;

    /*
     * Resource reference to the Azure Key Vault secret. Expected to be in format of
     * /subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}
     * /providers/Microsoft.KeyVault/vaults/{vaultName}
     * /secrets/{secretName}
     *
     */
    private ResourceReference secretSource;

    /*
     * Secret version, if customer is using a specific version.
     */
    private String secretVersion;

    /**
     * Creates an instance of ValidateSecretInput class.
     */
    public ValidateSecretInput() {
    }

    /**
     * Get the secretType property: The secret type.
     *
     * @return the secretType value.
     */
    public SecretType secretType() {
        return this.secretType;
    }

    /**
     * Set the secretType property: The secret type.
     *
     * @param secretType the secretType value to set.
     * @return the ValidateSecretInput object itself.
     */
    public ValidateSecretInput withSecretType(SecretType secretType) {
        this.secretType = secretType;
        return this;
    }

    /**
     * Get the secretSource property: Resource reference to the Azure Key Vault secret. Expected to be in format of
     * /subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.KeyVault/vaults/{vaultName}/secrets/{secretName}.
     *
     * @return the secretSource value.
     */
    public ResourceReference secretSource() {
        return this.secretSource;
    }

    /**
     * Set the secretSource property: Resource reference to the Azure Key Vault secret. Expected to be in format of
     * /subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.KeyVault/vaults/{vaultName}/secrets/{secretName}.
     *
     * @param secretSource the secretSource value to set.
     * @return the ValidateSecretInput object itself.
     */
    public ValidateSecretInput withSecretSource(ResourceReference secretSource) {
        this.secretSource = secretSource;
        return this;
    }

    /**
     * Get the secretVersion property: Secret version, if customer is using a specific version.
     *
     * @return the secretVersion value.
     */
    public String secretVersion() {
        return this.secretVersion;
    }

    /**
     * Set the secretVersion property: Secret version, if customer is using a specific version.
     *
     * @param secretVersion the secretVersion value to set.
     * @return the ValidateSecretInput object itself.
     */
    public ValidateSecretInput withSecretVersion(String secretVersion) {
        this.secretVersion = secretVersion;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (secretType() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property secretType in model ValidateSecretInput"));
        }
        if (secretSource() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property secretSource in model ValidateSecretInput"));
        } else {
            secretSource().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ValidateSecretInput.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("secretType", this.secretType == null ? null : this.secretType.toString());
        jsonWriter.writeJsonField("secretSource", this.secretSource);
        jsonWriter.writeStringField("secretVersion", this.secretVersion);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ValidateSecretInput from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of ValidateSecretInput if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ValidateSecretInput.
     */
    public static ValidateSecretInput fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ValidateSecretInput deserializedValidateSecretInput = new ValidateSecretInput();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("secretType".equals(fieldName)) {
                    deserializedValidateSecretInput.secretType = SecretType.fromString(reader.getString());
                } else if ("secretSource".equals(fieldName)) {
                    deserializedValidateSecretInput.secretSource = ResourceReference.fromJson(reader);
                } else if ("secretVersion".equals(fieldName)) {
                    deserializedValidateSecretInput.secretVersion = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedValidateSecretInput;
        });
    }
}
