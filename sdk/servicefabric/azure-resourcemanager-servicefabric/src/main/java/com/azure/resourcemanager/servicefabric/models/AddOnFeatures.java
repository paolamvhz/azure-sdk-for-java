// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicefabric.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Available cluster add-on features.
 */
public final class AddOnFeatures extends ExpandableStringEnum<AddOnFeatures> {
    /**
     * Static value RepairManager for AddOnFeatures.
     */
    public static final AddOnFeatures REPAIR_MANAGER = fromString("RepairManager");

    /**
     * Static value DnsService for AddOnFeatures.
     */
    public static final AddOnFeatures DNS_SERVICE = fromString("DnsService");

    /**
     * Static value BackupRestoreService for AddOnFeatures.
     */
    public static final AddOnFeatures BACKUP_RESTORE_SERVICE = fromString("BackupRestoreService");

    /**
     * Static value ResourceMonitorService for AddOnFeatures.
     */
    public static final AddOnFeatures RESOURCE_MONITOR_SERVICE = fromString("ResourceMonitorService");

    /**
     * Creates a new instance of AddOnFeatures value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public AddOnFeatures() {
    }

    /**
     * Creates or finds a AddOnFeatures from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding AddOnFeatures.
     */
    public static AddOnFeatures fromString(String name) {
        return fromString(name, AddOnFeatures.class);
    }

    /**
     * Gets known AddOnFeatures values.
     * 
     * @return known AddOnFeatures values.
     */
    public static Collection<AddOnFeatures> values() {
        return values(AddOnFeatures.class);
    }
}
