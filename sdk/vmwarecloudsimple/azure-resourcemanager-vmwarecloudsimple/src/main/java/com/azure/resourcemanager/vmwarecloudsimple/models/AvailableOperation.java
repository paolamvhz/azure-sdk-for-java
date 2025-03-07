// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.vmwarecloudsimple.models;

import com.azure.resourcemanager.vmwarecloudsimple.fluent.models.AvailableOperationInner;

/**
 * An immutable client-side representation of AvailableOperation.
 */
public interface AvailableOperation {
    /**
     * Gets the display property: The list of operations.
     * 
     * @return the display value.
     */
    AvailableOperationDisplay display();

    /**
     * Gets the isDataAction property: Indicating whether the operation is a data action or not.
     * 
     * @return the isDataAction value.
     */
    Boolean isDataAction();

    /**
     * Gets the name property: {resourceProviderNamespace}/{resourceType}/{read|write|delete|action}.
     * 
     * @return the name value.
     */
    String name();

    /**
     * Gets the origin property: The origin of operation.
     * 
     * @return the origin value.
     */
    OperationOrigin origin();

    /**
     * Gets the serviceSpecification property: The list of specification's service metrics.
     * 
     * @return the serviceSpecification value.
     */
    AvailableOperationDisplayPropertyServiceSpecificationMetricsList serviceSpecification();

    /**
     * Gets the inner com.azure.resourcemanager.vmwarecloudsimple.fluent.models.AvailableOperationInner object.
     * 
     * @return the inner object.
     */
    AvailableOperationInner innerModel();
}
