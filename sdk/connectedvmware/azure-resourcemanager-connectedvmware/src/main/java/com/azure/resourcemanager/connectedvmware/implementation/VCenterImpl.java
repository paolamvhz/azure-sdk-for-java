// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.connectedvmware.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.connectedvmware.fluent.models.VCenterInner;
import com.azure.resourcemanager.connectedvmware.models.ExtendedLocation;
import com.azure.resourcemanager.connectedvmware.models.ProvisioningState;
import com.azure.resourcemanager.connectedvmware.models.ResourcePatch;
import com.azure.resourcemanager.connectedvmware.models.ResourceStatus;
import com.azure.resourcemanager.connectedvmware.models.VCenter;
import com.azure.resourcemanager.connectedvmware.models.VICredential;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class VCenterImpl implements VCenter, VCenter.Definition, VCenter.Update {
    private VCenterInner innerObject;

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

    public String fqdn() {
        return this.innerModel().fqdn();
    }

    public Integer port() {
        return this.innerModel().port();
    }

    public String version() {
        return this.innerModel().version();
    }

    public String instanceUuid() {
        return this.innerModel().instanceUuid();
    }

    public String connectionStatus() {
        return this.innerModel().connectionStatus();
    }

    public String customResourceName() {
        return this.innerModel().customResourceName();
    }

    public VICredential credentials() {
        return this.innerModel().credentials();
    }

    public List<ResourceStatus> statuses() {
        List<ResourceStatus> inner = this.innerModel().statuses();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
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

    public VCenterInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.connectedvmware.ConnectedVMwareManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String vcenterName;

    private ResourcePatch updateBody;

    public VCenterImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public VCenter create() {
        this.innerObject = serviceManager.serviceClient()
            .getVCenters()
            .create(resourceGroupName, vcenterName, this.innerModel(), Context.NONE);
        return this;
    }

    public VCenter create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getVCenters()
            .create(resourceGroupName, vcenterName, this.innerModel(), context);
        return this;
    }

    VCenterImpl(String name, com.azure.resourcemanager.connectedvmware.ConnectedVMwareManager serviceManager) {
        this.innerObject = new VCenterInner();
        this.serviceManager = serviceManager;
        this.vcenterName = name;
    }

    public VCenterImpl update() {
        this.updateBody = new ResourcePatch();
        return this;
    }

    public VCenter apply() {
        this.innerObject = serviceManager.serviceClient()
            .getVCenters()
            .updateWithResponse(resourceGroupName, vcenterName, updateBody, Context.NONE)
            .getValue();
        return this;
    }

    public VCenter apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getVCenters()
            .updateWithResponse(resourceGroupName, vcenterName, updateBody, context)
            .getValue();
        return this;
    }

    VCenterImpl(VCenterInner innerObject,
        com.azure.resourcemanager.connectedvmware.ConnectedVMwareManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.vcenterName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "vcenters");
    }

    public VCenter refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getVCenters()
            .getByResourceGroupWithResponse(resourceGroupName, vcenterName, Context.NONE)
            .getValue();
        return this;
    }

    public VCenter refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getVCenters()
            .getByResourceGroupWithResponse(resourceGroupName, vcenterName, context)
            .getValue();
        return this;
    }

    public VCenterImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public VCenterImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public VCenterImpl withFqdn(String fqdn) {
        this.innerModel().withFqdn(fqdn);
        return this;
    }

    public VCenterImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateBody.withTags(tags);
            return this;
        }
    }

    public VCenterImpl withExtendedLocation(ExtendedLocation extendedLocation) {
        this.innerModel().withExtendedLocation(extendedLocation);
        return this;
    }

    public VCenterImpl withKind(String kind) {
        this.innerModel().withKind(kind);
        return this;
    }

    public VCenterImpl withPort(Integer port) {
        this.innerModel().withPort(port);
        return this;
    }

    public VCenterImpl withCredentials(VICredential credentials) {
        this.innerModel().withCredentials(credentials);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
