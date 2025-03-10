// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.workloadssapvirtualinstance.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.workloadssapvirtualinstance.fluent.models.OperationStatusResultInner;
import com.azure.resourcemanager.workloadssapvirtualinstance.fluent.models.SapApplicationServerInstanceInner;
import com.azure.resourcemanager.workloadssapvirtualinstance.models.StartRequest;
import com.azure.resourcemanager.workloadssapvirtualinstance.models.StopRequest;
import com.azure.resourcemanager.workloadssapvirtualinstance.models.UpdateSapApplicationInstanceRequest;

/**
 * An instance of this class provides access to all the operations defined in SapApplicationServerInstancesClient.
 */
public interface SapApplicationServerInstancesClient {
    /**
     * Gets the SAP Application Server Instance corresponding to the Virtual Instance for SAP solutions resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the SAP Application Server Instance corresponding to the Virtual Instance for SAP solutions resource
     * along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<SapApplicationServerInstanceInner> getWithResponse(String resourceGroupName, String sapVirtualInstanceName,
        String applicationInstanceName, Context context);

    /**
     * Gets the SAP Application Server Instance corresponding to the Virtual Instance for SAP solutions resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the SAP Application Server Instance corresponding to the Virtual Instance for SAP solutions resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SapApplicationServerInstanceInner get(String resourceGroupName, String sapVirtualInstanceName,
        String applicationInstanceName);

    /**
     * Puts the SAP Application Server Instance resource. &amp;lt;br&amp;gt;&amp;lt;br&amp;gt;This will be used by
     * service only. PUT by end user will return a Bad Request error.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @param resource The SAP Application Server Instance resource request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of define the SAP Application Server Instance resource.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<SapApplicationServerInstanceInner>, SapApplicationServerInstanceInner> beginCreate(
        String resourceGroupName, String sapVirtualInstanceName, String applicationInstanceName,
        SapApplicationServerInstanceInner resource);

    /**
     * Puts the SAP Application Server Instance resource. &amp;lt;br&amp;gt;&amp;lt;br&amp;gt;This will be used by
     * service only. PUT by end user will return a Bad Request error.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @param resource The SAP Application Server Instance resource request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of define the SAP Application Server Instance resource.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<SapApplicationServerInstanceInner>, SapApplicationServerInstanceInner> beginCreate(
        String resourceGroupName, String sapVirtualInstanceName, String applicationInstanceName,
        SapApplicationServerInstanceInner resource, Context context);

    /**
     * Puts the SAP Application Server Instance resource. &amp;lt;br&amp;gt;&amp;lt;br&amp;gt;This will be used by
     * service only. PUT by end user will return a Bad Request error.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @param resource The SAP Application Server Instance resource request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return define the SAP Application Server Instance resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SapApplicationServerInstanceInner create(String resourceGroupName, String sapVirtualInstanceName,
        String applicationInstanceName, SapApplicationServerInstanceInner resource);

    /**
     * Puts the SAP Application Server Instance resource. &amp;lt;br&amp;gt;&amp;lt;br&amp;gt;This will be used by
     * service only. PUT by end user will return a Bad Request error.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @param resource The SAP Application Server Instance resource request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return define the SAP Application Server Instance resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SapApplicationServerInstanceInner create(String resourceGroupName, String sapVirtualInstanceName,
        String applicationInstanceName, SapApplicationServerInstanceInner resource, Context context);

    /**
     * Puts the SAP Application Server Instance resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @param properties The SAP Application Server Instance resource request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return define the SAP Application Server Instance resource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<SapApplicationServerInstanceInner> updateWithResponse(String resourceGroupName,
        String sapVirtualInstanceName, String applicationInstanceName, UpdateSapApplicationInstanceRequest properties,
        Context context);

    /**
     * Puts the SAP Application Server Instance resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @param properties The SAP Application Server Instance resource request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return define the SAP Application Server Instance resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SapApplicationServerInstanceInner update(String resourceGroupName, String sapVirtualInstanceName,
        String applicationInstanceName, UpdateSapApplicationInstanceRequest properties);

    /**
     * Deletes the SAP Application Server Instance resource. &amp;lt;br&amp;gt;&amp;lt;br&amp;gt;This operation will be
     * used by service only. Delete by end user will return a Bad Request error.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String sapVirtualInstanceName,
        String applicationInstanceName);

    /**
     * Deletes the SAP Application Server Instance resource. &amp;lt;br&amp;gt;&amp;lt;br&amp;gt;This operation will be
     * used by service only. Delete by end user will return a Bad Request error.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String sapVirtualInstanceName,
        String applicationInstanceName, Context context);

    /**
     * Deletes the SAP Application Server Instance resource. &amp;lt;br&amp;gt;&amp;lt;br&amp;gt;This operation will be
     * used by service only. Delete by end user will return a Bad Request error.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String sapVirtualInstanceName, String applicationInstanceName);

    /**
     * Deletes the SAP Application Server Instance resource. &amp;lt;br&amp;gt;&amp;lt;br&amp;gt;This operation will be
     * used by service only. Delete by end user will return a Bad Request error.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String sapVirtualInstanceName, String applicationInstanceName,
        Context context);

    /**
     * Lists the SAP Application Server Instance resources for a given Virtual Instance for SAP solutions resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a SAPApplicationServerInstance list operation as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<SapApplicationServerInstanceInner> list(String resourceGroupName, String sapVirtualInstanceName);

    /**
     * Lists the SAP Application Server Instance resources for a given Virtual Instance for SAP solutions resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a SAPApplicationServerInstance list operation as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<SapApplicationServerInstanceInner> list(String resourceGroupName, String sapVirtualInstanceName,
        Context context);

    /**
     * Starts the SAP Application Server Instance.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OperationStatusResultInner>, OperationStatusResultInner> beginStart(String resourceGroupName,
        String sapVirtualInstanceName, String applicationInstanceName);

    /**
     * Starts the SAP Application Server Instance.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @param body SAP Application server instance start request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OperationStatusResultInner>, OperationStatusResultInner> beginStart(String resourceGroupName,
        String sapVirtualInstanceName, String applicationInstanceName, StartRequest body, Context context);

    /**
     * Starts the SAP Application Server Instance.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OperationStatusResultInner start(String resourceGroupName, String sapVirtualInstanceName,
        String applicationInstanceName);

    /**
     * Starts the SAP Application Server Instance.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @param body SAP Application server instance start request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OperationStatusResultInner start(String resourceGroupName, String sapVirtualInstanceName,
        String applicationInstanceName, StartRequest body, Context context);

    /**
     * Stops the SAP Application Server Instance.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OperationStatusResultInner>, OperationStatusResultInner> beginStop(String resourceGroupName,
        String sapVirtualInstanceName, String applicationInstanceName);

    /**
     * Stops the SAP Application Server Instance.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @param body SAP Application server instance stop request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OperationStatusResultInner>, OperationStatusResultInner> beginStop(String resourceGroupName,
        String sapVirtualInstanceName, String applicationInstanceName, StopRequest body, Context context);

    /**
     * Stops the SAP Application Server Instance.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OperationStatusResultInner stop(String resourceGroupName, String sapVirtualInstanceName,
        String applicationInstanceName);

    /**
     * Stops the SAP Application Server Instance.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param sapVirtualInstanceName The name of the Virtual Instances for SAP solutions resource.
     * @param applicationInstanceName The name of SAP Application Server instance resource.
     * @param body SAP Application server instance stop request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OperationStatusResultInner stop(String resourceGroupName, String sapVirtualInstanceName,
        String applicationInstanceName, StopRequest body, Context context);
}
