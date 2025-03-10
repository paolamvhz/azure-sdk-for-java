// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.security.keyvault.keys.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The encryption algorithm to use to protected the exported key material.
 */
public final class KeyExportEncryptionAlgorithm extends ExpandableStringEnum<KeyExportEncryptionAlgorithm> {

    /**
     * Static value CKM_RSA_AES_KEY_WRAP for KeyExportEncryptionAlgorithm.
     */
    public static final KeyExportEncryptionAlgorithm CKM_RSA_AES_KEY_WRAP = fromString("CKM_RSA_AES_KEY_WRAP");

    /**
     * Static value RSA_AES_KEY_WRAP_256 for KeyExportEncryptionAlgorithm.
     */
    public static final KeyExportEncryptionAlgorithm RSA_AES_KEY_WRAP_256 = fromString("RSA_AES_KEY_WRAP_256");

    /**
     * Static value RSA_AES_KEY_WRAP_384 for KeyExportEncryptionAlgorithm.
     */
    public static final KeyExportEncryptionAlgorithm RSA_AES_KEY_WRAP_384 = fromString("RSA_AES_KEY_WRAP_384");

    /**
     * Creates a new instance of KeyExportEncryptionAlgorithm value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public KeyExportEncryptionAlgorithm() {
    }

    /**
     * Creates or finds a KeyExportEncryptionAlgorithm from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding KeyExportEncryptionAlgorithm.
     */
    public static KeyExportEncryptionAlgorithm fromString(String name) {
        return fromString(name, KeyExportEncryptionAlgorithm.class);
    }

    /**
     * Gets known KeyExportEncryptionAlgorithm values.
     *
     * @return known KeyExportEncryptionAlgorithm values.
     */
    public static Collection<KeyExportEncryptionAlgorithm> values() {
        return values(KeyExportEncryptionAlgorithm.class);
    }
}
