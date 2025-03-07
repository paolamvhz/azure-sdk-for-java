// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.connectedvmware.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.connectedvmware.fluent.models.DatastoreInner;
import com.azure.resourcemanager.connectedvmware.models.Datastore;
import com.azure.resourcemanager.connectedvmware.models.ExtendedLocation;
import com.azure.resourcemanager.connectedvmware.models.ProvisioningState;
import com.azure.resourcemanager.connectedvmware.models.ResourcePatch;
import com.azure.resourcemanager.connectedvmware.models.ResourceStatus;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DatastoreImpl implements Datastore, Datastore.Definition, Datastore.Update {
    private DatastoreInner innerObject;

    private final com.azure.resourcemanager.connectedvmware.ConnectedVMwareManager serviceManager;

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public String location() {
        return this.innerModel().location();
    }

    public Map<String, String> tags() {
        Map<String, String> inner = this.innerModel().tags();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public ExtendedLocation extendedLocation() {
        return this.innerModel().extendedLocation();
    }

    public SystemData systemData() {
        return this.innerModel().systemData();
    }

    public String kind() {
        return this.innerModel().kind();
    }

    public String uuid() {
        return this.innerModel().uuid();
    }

    public String vCenterId() {
        return this.innerModel().vCenterId();
    }

    public String moRefId() {
        return this.innerModel().moRefId();
    }

    public String inventoryItemId() {
        return this.innerModel().inventoryItemId();
    }

    public String moName() {
        return this.innerModel().moName();
    }

    public List<ResourceStatus> statuses() {
        List<ResourceStatus> inner = this.innerModel().statuses();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public String customResourceName() {
        return this.innerModel().customResourceName();
    }

    public Long capacityGB() {
        return this.innerModel().capacityGB();
    }

    public Long freeSpaceGB() {
        return this.innerModel().freeSpaceGB();
    }

    public ProvisioningState provisioningState() {
        return this.innerModel().provisioningState();
    }

    public Region region() {
        return Region.fromName(this.regionName());
    }

    public String regionName() {
        return this.location();
    }

    public String resourceGroupName() {
        return resourceGroupName;
    }

    public DatastoreInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.connectedvmware.ConnectedVMwareManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String datastoreName;

    private ResourcePatch updateBody;

    public DatastoreImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public Datastore create() {
        this.innerObject = serviceManager.serviceClient()
            .getDatastores()
            .create(resourceGroupName, datastoreName, this.innerModel(), Context.NONE);
        return this;
    }

    public Datastore create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getDatastores()
            .create(resourceGroupName, datastoreName, this.innerModel(), context);
        return this;
    }

    DatastoreImpl(String name, com.azure.resourcemanager.connectedvmware.ConnectedVMwareManager serviceManager) {
        this.innerObject = new DatastoreInner();
        this.serviceManager = serviceManager;
        this.datastoreName = name;
    }

    public DatastoreImpl update() {
        this.updateBody = new ResourcePatch();
        return this;
    }

    public Datastore apply() {
        this.innerObject = serviceManager.serviceClient()
            .getDatastores()
            .updateWithResponse(resourceGroupName, datastoreName, updateBody, Context.NONE)
            .getValue();
        return this;
    }

    public Datastore apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getDatastores()
            .updateWithResponse(resourceGroupName, datastoreName, updateBody, context)
            .getValue();
        return this;
    }

    DatastoreImpl(DatastoreInner innerObject,
        com.azure.resourcemanager.connectedvmware.ConnectedVMwareManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.datastoreName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "datastores");
    }

    public Datastore refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getDatastores()
            .getByResourceGroupWithResponse(resourceGroupName, datastoreName, Context.NONE)
            .getValue();
        return this;
    }

    public Datastore refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getDatastores()
            .getByResourceGroupWithResponse(resourceGroupName, datastoreName, context)
            .getValue();
        return this;
    }

    public DatastoreImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public DatastoreImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public DatastoreImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateBody.withTags(tags);
            return this;
        }
    }

    public DatastoreImpl withExtendedLocation(ExtendedLocation extendedLocation) {
        this.innerModel().withExtendedLocation(extendedLocation);
        return this;
    }

    public DatastoreImpl withKind(String kind) {
        this.innerModel().withKind(kind);
        return this;
    }

    public DatastoreImpl withVCenterId(String vCenterId) {
        this.innerModel().withVCenterId(vCenterId);
        return this;
    }

    public DatastoreImpl withMoRefId(String moRefId) {
        this.innerModel().withMoRefId(moRefId);
        return this;
    }

    public DatastoreImpl withInventoryItemId(String inventoryItemId) {
        this.innerModel().withInventoryItemId(inventoryItemId);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
