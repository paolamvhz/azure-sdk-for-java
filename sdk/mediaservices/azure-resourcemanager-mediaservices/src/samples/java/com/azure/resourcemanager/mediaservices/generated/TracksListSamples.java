// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.generated;

/**
 * Samples for Tracks List.
 */
public final class TracksListSamples {
    /*
     * x-ms-original-file:
     * specification/mediaservices/resource-manager/Microsoft.Media/Metadata/stable/2022-08-01/examples/asset-tracks-
     * list-all.json
     */
    /**
     * Sample code: Lists all Tracks.
     * 
     * @param manager Entry point to MediaServicesManager.
     */
    public static void listsAllTracks(com.azure.resourcemanager.mediaservices.MediaServicesManager manager) {
        manager.tracks().list("contosorg", "contosomedia", "ClimbingMountRainer", com.azure.core.util.Context.NONE);
    }
}
