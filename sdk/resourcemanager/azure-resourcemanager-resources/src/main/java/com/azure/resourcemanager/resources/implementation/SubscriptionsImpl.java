// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.resourcemanager.resources.implementation;

import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.resourcemanager.resources.models.Subscription;
import com.azure.resourcemanager.resources.models.Subscriptions;
import com.azure.resourcemanager.resources.fluentcore.arm.collection.implementation.SupportsGettingByIdImpl;
import com.azure.resourcemanager.resources.fluent.models.SubscriptionInner;
import com.azure.resourcemanager.resources.fluent.SubscriptionsClient;
import reactor.core.publisher.Mono;
import com.azure.resourcemanager.resources.fluentcore.utils.PagedConverter;

/**
 * The implementation of Subscriptions.
 */
public final class SubscriptionsImpl extends SupportsGettingByIdImpl<Subscription> implements Subscriptions {
    private final SubscriptionsClient client;

    public SubscriptionsImpl(final SubscriptionsClient client) {
        this.client = client;
    }

    @Override
    public PagedIterable<Subscription> list() {
        return PagedConverter.mapPage(client.list(), inner -> wrapModel(inner));
    }

    @Override
    public Mono<Subscription> getByIdAsync(String id) {
        return client.getAsync(id).map(inner -> wrapModel(inner));
    }

    @Override
    public PagedFlux<Subscription> listAsync() {
        return PagedConverter.mapPage(client.listAsync(), inner -> wrapModel(inner));
    }

    private SubscriptionImpl wrapModel(SubscriptionInner subscriptionInner) {
        if (subscriptionInner == null) {
            return null;
        }
        return new SubscriptionImpl(subscriptionInner, client);
    }
}
