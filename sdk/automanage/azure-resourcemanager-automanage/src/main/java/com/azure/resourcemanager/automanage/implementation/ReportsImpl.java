// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automanage.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.automanage.fluent.ReportsClient;
import com.azure.resourcemanager.automanage.fluent.models.ReportInner;
import com.azure.resourcemanager.automanage.models.Report;
import com.azure.resourcemanager.automanage.models.Reports;

public final class ReportsImpl implements Reports {
    private static final ClientLogger LOGGER = new ClientLogger(ReportsImpl.class);

    private final ReportsClient innerClient;

    private final com.azure.resourcemanager.automanage.AutomanageManager serviceManager;

    public ReportsImpl(ReportsClient innerClient,
        com.azure.resourcemanager.automanage.AutomanageManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<Report> getWithResponse(String resourceGroupName, String configurationProfileAssignmentName,
        String reportName, String vmName, Context context) {
        Response<ReportInner> inner = this.serviceClient()
            .getWithResponse(resourceGroupName, configurationProfileAssignmentName, reportName, vmName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new ReportImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public Report get(String resourceGroupName, String configurationProfileAssignmentName, String reportName,
        String vmName) {
        ReportInner inner
            = this.serviceClient().get(resourceGroupName, configurationProfileAssignmentName, reportName, vmName);
        if (inner != null) {
            return new ReportImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<Report> listByConfigurationProfileAssignments(String resourceGroupName,
        String configurationProfileAssignmentName, String vmName) {
        PagedIterable<ReportInner> inner = this.serviceClient()
            .listByConfigurationProfileAssignments(resourceGroupName, configurationProfileAssignmentName, vmName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new ReportImpl(inner1, this.manager()));
    }

    public PagedIterable<Report> listByConfigurationProfileAssignments(String resourceGroupName,
        String configurationProfileAssignmentName, String vmName, Context context) {
        PagedIterable<ReportInner> inner = this.serviceClient()
            .listByConfigurationProfileAssignments(resourceGroupName, configurationProfileAssignmentName, vmName,
                context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new ReportImpl(inner1, this.manager()));
    }

    private ReportsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.automanage.AutomanageManager manager() {
        return this.serviceManager;
    }
}
