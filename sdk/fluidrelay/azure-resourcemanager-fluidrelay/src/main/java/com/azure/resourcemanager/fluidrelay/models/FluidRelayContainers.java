// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.fluidrelay.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of FluidRelayContainers.
 */
public interface FluidRelayContainers {
    /**
     * Get a Fluid Relay container.
     * 
     * @param resourceGroup The resource group containing the resource.
     * @param fluidRelayServerName The Fluid Relay server resource name.
     * @param fluidRelayContainerName The Fluid Relay container resource name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Fluid Relay container along with {@link Response}.
     */
    Response<FluidRelayContainer> getWithResponse(String resourceGroup, String fluidRelayServerName,
        String fluidRelayContainerName, Context context);

    /**
     * Get a Fluid Relay container.
     * 
     * @param resourceGroup The resource group containing the resource.
     * @param fluidRelayServerName The Fluid Relay server resource name.
     * @param fluidRelayContainerName The Fluid Relay container resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Fluid Relay container.
     */
    FluidRelayContainer get(String resourceGroup, String fluidRelayServerName, String fluidRelayContainerName);

    /**
     * Delete a Fluid Relay container.
     * 
     * @param resourceGroup The resource group containing the resource.
     * @param fluidRelayServerName The Fluid Relay server resource name.
     * @param fluidRelayContainerName The Fluid Relay container resource name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> deleteWithResponse(String resourceGroup, String fluidRelayServerName, String fluidRelayContainerName,
        Context context);

    /**
     * Delete a Fluid Relay container.
     * 
     * @param resourceGroup The resource group containing the resource.
     * @param fluidRelayServerName The Fluid Relay server resource name.
     * @param fluidRelayContainerName The Fluid Relay container resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroup, String fluidRelayServerName, String fluidRelayContainerName);

    /**
     * List all Fluid Relay containers which are children of a given Fluid Relay server.
     * 
     * @param resourceGroup The resource group containing the resource.
     * @param fluidRelayServerName The Fluid Relay server resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return paged response as paginated response with {@link PagedIterable}.
     */
    PagedIterable<FluidRelayContainer> listByFluidRelayServers(String resourceGroup, String fluidRelayServerName);

    /**
     * List all Fluid Relay containers which are children of a given Fluid Relay server.
     * 
     * @param resourceGroup The resource group containing the resource.
     * @param fluidRelayServerName The Fluid Relay server resource name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return paged response as paginated response with {@link PagedIterable}.
     */
    PagedIterable<FluidRelayContainer> listByFluidRelayServers(String resourceGroup, String fluidRelayServerName,
        Context context);
}
