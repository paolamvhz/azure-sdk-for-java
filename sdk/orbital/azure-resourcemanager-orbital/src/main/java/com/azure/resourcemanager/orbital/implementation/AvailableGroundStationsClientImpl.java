// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.orbital.implementation;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.resourcemanager.orbital.fluent.AvailableGroundStationsClient;
import com.azure.resourcemanager.orbital.fluent.models.AvailableGroundStationInner;
import com.azure.resourcemanager.orbital.models.AvailableGroundStationListResult;
import com.azure.resourcemanager.orbital.models.CapabilityParameter;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in AvailableGroundStationsClient.
 */
public final class AvailableGroundStationsClientImpl implements AvailableGroundStationsClient {
    /**
     * The proxy service used to perform REST calls.
     */
    private final AvailableGroundStationsService service;

    /**
     * The service client containing this operation class.
     */
    private final AzureOrbitalImpl client;

    /**
     * Initializes an instance of AvailableGroundStationsClientImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    AvailableGroundStationsClientImpl(AzureOrbitalImpl client) {
        this.service = RestProxy.create(AvailableGroundStationsService.class, client.getHttpPipeline(),
            client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for AzureOrbitalAvailableGroundStations to be used by the proxy service
     * to perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "AzureOrbitalAvailabl")
    public interface AvailableGroundStationsService {
        @Headers({ "Content-Type: application/json" })
        @Get("/subscriptions/{subscriptionId}/providers/Microsoft.Orbital/availableGroundStations")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<AvailableGroundStationListResult>> list(@HostParam("$host") String endpoint,
            @PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion,
            @QueryParam("capability") CapabilityParameter capability, @HeaderParam("Accept") String accept,
            Context context);

        @Headers({ "Content-Type: application/json" })
        @Get("{nextLink}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<AvailableGroundStationListResult>> listByCapabilityNext(
            @PathParam(value = "nextLink", encoded = true) String nextLink, @HostParam("$host") String endpoint,
            @HeaderParam("Accept") String accept, Context context);
    }

    /**
     * Returns list of available ground stations.
     * 
     * @param capability Ground Station Capability.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for the AvailableGroundStations API service call along with {@link PagedResponse} on successful
     * completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<AvailableGroundStationInner>> listSinglePageAsync(CapabilityParameter capability) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (capability == null) {
            return Mono.error(new IllegalArgumentException("Parameter capability is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.list(this.client.getEndpoint(), this.client.getSubscriptionId(),
                this.client.getApiVersion(), capability, accept, context))
            .<PagedResponse<AvailableGroundStationInner>>map(res -> new PagedResponseBase<>(res.getRequest(),
                res.getStatusCode(), res.getHeaders(), res.getValue().value(), res.getValue().nextLink(), null))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Returns list of available ground stations.
     * 
     * @param capability Ground Station Capability.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for the AvailableGroundStations API service call along with {@link PagedResponse} on successful
     * completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<AvailableGroundStationInner>> listSinglePageAsync(CapabilityParameter capability,
        Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (capability == null) {
            return Mono.error(new IllegalArgumentException("Parameter capability is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service
            .list(this.client.getEndpoint(), this.client.getSubscriptionId(), this.client.getApiVersion(), capability,
                accept, context)
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                res.getValue().value(), res.getValue().nextLink(), null));
    }

    /**
     * Returns list of available ground stations.
     * 
     * @param capability Ground Station Capability.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for the AvailableGroundStations API service call as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    private PagedFlux<AvailableGroundStationInner> listAsync(CapabilityParameter capability) {
        return new PagedFlux<>(() -> listSinglePageAsync(capability),
            nextLink -> listByCapabilityNextSinglePageAsync(nextLink));
    }

    /**
     * Returns list of available ground stations.
     * 
     * @param capability Ground Station Capability.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for the AvailableGroundStations API service call as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    private PagedFlux<AvailableGroundStationInner> listAsync(CapabilityParameter capability, Context context) {
        return new PagedFlux<>(() -> listSinglePageAsync(capability, context),
            nextLink -> listByCapabilityNextSinglePageAsync(nextLink, context));
    }

    /**
     * Returns list of available ground stations.
     * 
     * @param capability Ground Station Capability.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for the AvailableGroundStations API service call as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<AvailableGroundStationInner> list(CapabilityParameter capability) {
        return new PagedIterable<>(listAsync(capability));
    }

    /**
     * Returns list of available ground stations.
     * 
     * @param capability Ground Station Capability.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for the AvailableGroundStations API service call as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<AvailableGroundStationInner> list(CapabilityParameter capability, Context context) {
        return new PagedIterable<>(listAsync(capability, context));
    }

    /**
     * Get the next page of items.
     * 
     * @param nextLink The URL to get the next list of items.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for the AvailableGroundStations API service call along with {@link PagedResponse} on successful
     * completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<AvailableGroundStationInner>> listByCapabilityNextSinglePageAsync(String nextLink) {
        if (nextLink == null) {
            return Mono.error(new IllegalArgumentException("Parameter nextLink is required and cannot be null."));
        }
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.listByCapabilityNext(nextLink, this.client.getEndpoint(), accept, context))
            .<PagedResponse<AvailableGroundStationInner>>map(res -> new PagedResponseBase<>(res.getRequest(),
                res.getStatusCode(), res.getHeaders(), res.getValue().value(), res.getValue().nextLink(), null))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Get the next page of items.
     * 
     * @param nextLink The URL to get the next list of items.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for the AvailableGroundStations API service call along with {@link PagedResponse} on successful
     * completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<AvailableGroundStationInner>> listByCapabilityNextSinglePageAsync(String nextLink,
        Context context) {
        if (nextLink == null) {
            return Mono.error(new IllegalArgumentException("Parameter nextLink is required and cannot be null."));
        }
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.listByCapabilityNext(nextLink, this.client.getEndpoint(), accept, context)
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                res.getValue().value(), res.getValue().nextLink(), null));
    }
}
