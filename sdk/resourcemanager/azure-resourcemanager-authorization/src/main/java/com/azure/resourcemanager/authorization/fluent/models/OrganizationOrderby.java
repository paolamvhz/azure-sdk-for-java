// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for OrganizationOrderby. */
public final class OrganizationOrderby extends ExpandableStringEnum<OrganizationOrderby> {
    /** Static value id for OrganizationOrderby. */
    public static final OrganizationOrderby ID = fromString("id");

    /** Static value id desc for OrganizationOrderby. */
    public static final OrganizationOrderby ID_DESC = fromString("id desc");

    /**
     * Creates or finds a OrganizationOrderby from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding OrganizationOrderby.
     */
    @JsonCreator
    public static OrganizationOrderby fromString(String name) {
        return fromString(name, OrganizationOrderby.class);
    }

    /** @return known OrganizationOrderby values. */
    public static Collection<OrganizationOrderby> values() {
        return values(OrganizationOrderby.class);
    }
}
