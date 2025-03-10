// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automation.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Type of the HybridWorkerGroup.
 */
public final class GroupTypeEnum extends ExpandableStringEnum<GroupTypeEnum> {
    /**
     * Static value User for GroupTypeEnum.
     */
    public static final GroupTypeEnum USER = fromString("User");

    /**
     * Static value System for GroupTypeEnum.
     */
    public static final GroupTypeEnum SYSTEM = fromString("System");

    /**
     * Creates a new instance of GroupTypeEnum value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public GroupTypeEnum() {
    }

    /**
     * Creates or finds a GroupTypeEnum from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding GroupTypeEnum.
     */
    public static GroupTypeEnum fromString(String name) {
        return fromString(name, GroupTypeEnum.class);
    }

    /**
     * Gets known GroupTypeEnum values.
     * 
     * @return known GroupTypeEnum values.
     */
    public static Collection<GroupTypeEnum> values() {
        return values(GroupTypeEnum.class);
    }
}
