// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.implementation;

import com.azure.cosmos.CosmosItemSerializer;
import com.azure.cosmos.implementation.directconnectivity.Address;
import com.azure.cosmos.implementation.guava25.base.Function;
import com.azure.cosmos.implementation.query.PartitionedQueryExecutionInfoInternal;
import com.azure.cosmos.implementation.query.QueryInfo;
import com.azure.cosmos.implementation.query.QueryItem;
import com.azure.cosmos.implementation.routing.Range;
import com.azure.cosmos.models.ChangeFeedPolicy;
import com.azure.cosmos.models.CompositePath;
import com.azure.cosmos.models.ConflictResolutionPolicy;
import com.azure.cosmos.models.ExcludedPath;
import com.azure.cosmos.models.IncludedPath;
import com.azure.cosmos.models.IndexingPolicy;
import com.azure.cosmos.models.ModelBridgeInternal;
import com.azure.cosmos.models.PartitionKeyDefinition;
import com.azure.cosmos.models.SpatialSpec;
import com.azure.cosmos.models.SqlParameter;
import com.azure.cosmos.models.SqlQuerySpec;
import com.azure.cosmos.models.UniqueKey;
import com.azure.cosmos.models.UniqueKeyPolicy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.ByteBufferBackedInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.util.annotation.Nullable;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import static com.azure.cosmos.implementation.guava25.base.Preconditions.checkArgument;
import static com.azure.cosmos.implementation.guava25.base.Preconditions.checkNotNull;

/**
 * Represents a base resource that can be serialized to JSON in the Azure Cosmos DB database service.
 */
public class JsonSerializable {
    private static final ObjectMapper OBJECT_MAPPER = Utils.getSimpleObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonSerializable.class);
    private final static ImplementationBridgeHelpers.CosmosItemSerializerHelper.CosmosItemSerializerAccessor itemSerializerAccessor =
        ImplementationBridgeHelpers.CosmosItemSerializerHelper.getCosmosItemSerializerAccessor();
    transient ObjectNode propertyBag = null;
    private ObjectMapper om;

    public JsonSerializable() {
        this.propertyBag = OBJECT_MAPPER.createObjectNode();
    }

    /**
     * Constructor.
     *
     * @param jsonString the json string that represents the JsonSerializable.
     * @param objectMapper the custom object mapper
     */
    protected JsonSerializable(String jsonString, ObjectMapper objectMapper) {
        // TODO: Made package private due to #153. #171 adding custom serialization options back.
        this.propertyBag = fromJson(jsonString, objectMapper);
        this.om = objectMapper;
    }

    /**
     * Constructor.
     *
     * @param jsonString the json string that represents the JsonSerializable.
     */
    public JsonSerializable(String jsonString) {
        this.propertyBag = fromJson(jsonString, OBJECT_MAPPER);
    }

    /**
     * Constructor.
     *
     * @param objectNode the {@link ObjectNode} that represent the {@link JsonSerializable}
     */
    public JsonSerializable(ObjectNode objectNode) {
        this.propertyBag = objectNode;
    }

    protected JsonSerializable(ByteBuffer byteBuffer) {
        this.propertyBag = fromJson(byteBuffer);
    }

    protected JsonSerializable(byte[] bytes) {
        this.propertyBag = fromJson(bytes);
    }

    public static JsonSerializable instantiateFromObjectNodeAndType(ObjectNode objectNode, Class<?> klassType) {
        if (klassType.equals(Document.class)) {
            return new Document(objectNode);
        }
        if (klassType.equals(InternalObjectNode.class)) {
            return new InternalObjectNode(objectNode);
        }
        if (klassType.equals(PartitionKeyRange.class)) {
            return new PartitionKeyRange(objectNode);
        }
        if (klassType.equals(Range.class)) {
            return new Range<>(objectNode);
        }
        if (klassType.equals(QueryInfo.class)) {
            return new QueryInfo(objectNode);
        }
        if (klassType.equals(PartitionedQueryExecutionInfoInternal.class)) {
            return new PartitionedQueryExecutionInfoInternal(objectNode);
        }
        if (klassType.equals(QueryItem.class)) {
            return new QueryItem(objectNode);
        }
        if (klassType.equals(Address.class)) {
            return new Address(objectNode);
        }
        if (klassType.equals(DatabaseAccount.class)) {
            return new DatabaseAccount(objectNode);
        }
        if (klassType.equals(DatabaseAccountLocation.class)) {
            return new DatabaseAccountLocation(objectNode);
        }
        if (klassType.equals(ReplicationPolicy.class)) {
            return new ReplicationPolicy(objectNode);
        }
        if (klassType.equals(ConsistencyPolicy.class)) {
            return new ConsistencyPolicy(objectNode);
        }
        if (klassType.equals(DocumentCollection.class)) {
            return new DocumentCollection(objectNode);
        }
        if (klassType.equals(Database.class)) {
            return new Database(objectNode);
        } else {
            // This should rarely execute. Keeping this for sanity sake
            try {
                return (JsonSerializable) klassType.getDeclaredConstructor(ObjectNode.class)
                                              .newInstance(objectNode);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    private static void checkForValidPOJO(Class<?> c) {
        if (c.isAnonymousClass() || c.isLocalClass()) {
            throw new IllegalArgumentException(
                String.format("%s can't be an anonymous or local class.", c.getName()));
        }
        if (c.isMemberClass() && !Modifier.isStatic(c.getModifiers())) {
            throw new IllegalArgumentException(
                String.format("%s must be static if it's a member class.", c.getName()));
        }
    }

    public static Object getValue(JsonNode value) {
        if (value.isValueNode()) {
            switch (value.getNodeType()) {
                case BOOLEAN:
                    return value.asBoolean();
                case NUMBER:
                    if (value.isInt()) {
                        return value.asInt();
                    } else if (value.isLong()) {
                        return value.asLong();
                    } else if (value.isDouble()) {
                        return value.asDouble();
                    } else {
                        return value;
                    }
                case STRING:
                    return value.asText();
                default:
                    return value;
            }
        }
        return value;
    }

    @JsonIgnore
    public Logger getLogger() {
        return LOGGER;
    }

    public void populatePropertyBag() {
    }

    /**
     * Returns the propertybag(JsonNode) in a hashMap
     *
     * @return the HashMap.
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getMap() {
        return OBJECT_MAPPER.convertValue(this.propertyBag, HashMap.class);
    }

    @SuppressWarnings("unchecked")
    public <T> Map<String, T> getMap(String propertyKey) {
        if (this.propertyBag.has(propertyKey)) {
            Object value = this.get(propertyKey);
            return (Map<String, T>) OBJECT_MAPPER.convertValue(value, HashMap.class);
        }
        return null;
    }

    /**
     * Checks whether a property exists.
     *
     * @param propertyName the property to look up.
     * @return true if the property exists.
     */
    public boolean has(String propertyName) {
        return this.propertyBag.has(propertyName);
    }

    /**
     * Removes a value by propertyName.
     *
     * @param propertyName the property to remove.
     */
    public void remove(String propertyName) {
        this.propertyBag.remove(propertyName);
    }

    /**
     * Sets the value of a property.
     *
     * @param <T> the type of the object.
     * @param propertyName the property to set.
     * @param value the value of the property.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T> void set(String propertyName, T value) {
        set(propertyName, value, DefaultCosmosItemSerializer.INTERNAL_DEFAULT_SERIALIZER, false);
    }

    /**
     * Sets the value of a property.
     *
     * @param <T> the type of the object.
     * @param propertyName the property to set.
     * @param value the value of the property.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T> void set(String propertyName, T value, CosmosItemSerializer itemSerializer, boolean forceSerialization) {
        checkNotNull(itemSerializer, "Argument 'itemSerializer' must not be null.");
        if (value == null) {
            // Sets null.
            this.propertyBag.putNull(propertyName);
        } else if (!forceSerialization && value instanceof Collection) {
            // Collection.
            ArrayNode jsonArray = propertyBag.arrayNode();
            this.internalSetCollection(propertyName, (Collection) value, jsonArray);
            this.propertyBag.set(propertyName, jsonArray);
        } else if (!forceSerialization && value instanceof JsonNode) {
            this.propertyBag.set(propertyName, (JsonNode) value);
        } else if (!forceSerialization && value instanceof JsonSerializable) {
            // JsonSerializable
            JsonSerializable castedValue = (JsonSerializable) value;
            castedValue.populatePropertyBag();
            this.propertyBag.set(propertyName, castedValue.propertyBag);
        } else if (!forceSerialization && containsJsonSerializable(value.getClass())) {
            ModelBridgeInternal.populatePropertyBag(value);
            this.propertyBag.set(propertyName, ModelBridgeInternal.getJsonSerializable(value).propertyBag);
        } else {
            // Arrays, POJO, ObjectNode, number (includes int, float, double etc), boolean,
            // and string
            Map<String, Object> jsonTreeMap = itemSerializerAccessor.serializeSafe(itemSerializer, value);
            if (jsonTreeMap instanceof ObjectNodeMap) {
                this.propertyBag.set(propertyName, ((ObjectNodeMap) jsonTreeMap).getObjectNode());
            } else if (jsonTreeMap instanceof PrimitiveJsonNodeMap) {
                this.propertyBag.set(propertyName, ((PrimitiveJsonNodeMap) jsonTreeMap).getPrimitiveJsonNode());
            } else {
                if (jsonTreeMap.size() == 1 && jsonTreeMap.get(PrimitiveJsonNodeMap.VALUE_KEY) != null) {
                    this.propertyBag.set(
                        propertyName,
                        OBJECT_MAPPER.convertValue(jsonTreeMap.get(PrimitiveJsonNodeMap.VALUE_KEY), JsonNode.class));
                } else {
                    this.propertyBag.set(
                        propertyName,
                        OBJECT_MAPPER.convertValue(jsonTreeMap, ObjectNode.class));
                }
            }
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private <T> void internalSetCollection(String propertyName, Collection<T> collection, ArrayNode targetArray) {
        for (T childValue : collection) {
            if (childValue == null) {
                // Sets null.
                targetArray.addNull();
            } else if (childValue instanceof Collection) {
                // When T is also a Collection, use recursion.
                ArrayNode childArray = targetArray.addArray();
                this.internalSetCollection(propertyName, (Collection) childValue, childArray);
            } else if (childValue instanceof JsonNode) {
                targetArray.add((JsonNode) childValue);
            } else if (childValue instanceof JsonSerializable) {
                // JsonSerializable
                JsonSerializable castedValue = (JsonSerializable) childValue;
                castedValue.populatePropertyBag();
                targetArray.add(castedValue.propertyBag != null ? castedValue.propertyBag
                                    : OBJECT_MAPPER.createObjectNode());
            } else if (containsJsonSerializable(childValue.getClass())) {
                ModelBridgeInternal.populatePropertyBag(childValue);
                targetArray.add(ModelBridgeInternal.getJsonSerializable(childValue).propertyBag != null ?
                    ModelBridgeInternal.getJsonSerializable(childValue).propertyBag : OBJECT_MAPPER.createObjectNode());
            } else {
                // POJO, JsonNode, NUMBER (includes Int, Float, Double etc),
                // Boolean, and STRING.
                targetArray.add(OBJECT_MAPPER.valueToTree(childValue));
            }
        }
    }

    /**
     * Gets a property value as Object.
     *
     * @param propertyName the property to get.
     * @return the value of the property.
     */
    public Object get(String propertyName) {
        return getWithMapping(propertyName, JsonSerializable::getValue);
    }

    /**
     * Gets a string value.
     *
     * @param propertyName the property to get.
     * @return the string value.
     */
    public String getString(String propertyName) {
        return getWithMapping(propertyName, JsonNode::asText);
    }

    /**
     * Gets a boolean value.
     *
     * @param propertyName the property to get.
     * @return the boolean value.
     */
    // The method returning Boolean can be invoked as though it returned a value of type boolean,
    // and the compiler will insert automatic unboxing of the Boolean value. If a null value is
    // returned, this will result in a NPE. @Nullable is used indicate that returning null is permitted.
    @Nullable
    public Boolean getBoolean(String propertyName) {
        return getWithMapping(propertyName, JsonNode::asBoolean);
    }

    /**
     * Gets an integer value.
     *
     * @param propertyName the property to get.
     * @return the boolean value
     */
    public Integer getInt(String propertyName) {
        return getWithMapping(propertyName, JsonNode::asInt);
    }

    /**
     * Gets a long value.
     *
     * @param propertyName the property to get.
     * @return the long value
     */
    public Long getLong(String propertyName) {
        return getWithMapping(propertyName, JsonNode::asLong);
    }

    /**
     * Gets a double value.
     *
     * @param propertyName the property to get.
     * @return the double value.
     */
    public Double getDouble(String propertyName) {
        return getWithMapping(propertyName, JsonNode::asDouble);
    }

    /**
     * Helper method that optimizes retrieval and conversion of a property value to a specific type.
     * <p>
     * Before this, the get* methods were checking both {@link #has(String)} and {@link JsonNode#hasNonNull(String)}
     * which was redundant as {@link JsonNode#hasNonNull(String)} already checks {@link #has(String)}. Additionally,
     * there would be the check for {@link JsonNode#hasNonNull(String)} then getting the value and converting it to the
     * required type. This method combines all these steps into one.
     *
     * @param propertyName the property to get.
     * @param mapper the function to convert the JsonNode to the required type.
     * @return the value of the property, or null if the property does not exist or is null.
     * @param <T> the type of the object.
     */
    private <T> T getWithMapping(String propertyName, Function<JsonNode, T> mapper) {
        JsonNode node = this.propertyBag.get(propertyName);
        if (node == null || node.isNull()) {
            return null;
        }

        return mapper.apply(node);
    }

    /**
     * Gets an object value.
     *
     * @param <T> the type of the object.
     * @param propertyName the property to get.
     * @param c the class of the object. If c is a POJO class, it must be a member (and not an anonymous or local)
     * and a static one.
     * @param convertFromCamelCase boolean indicating if String should be converted from camel case to upper case
     * separated by underscore,
     * before converting to required class.
     * @return the object value.
     * @throws IllegalStateException thrown if an error occurs
     */
    @SuppressWarnings("unchecked")
    // Implicit or explicit cast to T is done only after checking values are assignable from Class<T>.
    public <T> T getObject(String propertyName, Class<T> c, boolean... convertFromCamelCase) {
        return getWithMapping(propertyName, jsonObj -> {
            if (Number.class.isAssignableFrom(c) || String.class.isAssignableFrom(c)
                    || Boolean.class.isAssignableFrom(c) || Object.class == c) {
                // NUMBER, STRING, Boolean
                return c.cast(getValue(jsonObj));
            } else if (Enum.class.isAssignableFrom(c)) {
                try {
                    String value = (String) getValue(jsonObj);
                    value = convertFromCamelCase.length > 0 && convertFromCamelCase[0]
                                ? Strings.fromCamelCaseToUpperCase(value) : value;
                    return c.cast(c.getMethod("valueOf", String.class).invoke(null, value));
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                             | NoSuchMethodException | SecurityException e) {
                    throw new IllegalStateException("Failed to create enum.", e);
                }
            } else if (JsonSerializable.class.isAssignableFrom(c)) {
                return (T) instantiateFromObjectNodeAndType((ObjectNode) jsonObj, c);
            } else if (containsJsonSerializable(c)) {
                return ModelBridgeInternal.instantiateByObjectNode((ObjectNode) jsonObj, c);
            }
            else {
                // POJO
                JsonSerializable.checkForValidPOJO(c);
                try {
                    return OBJECT_MAPPER.treeToValue(jsonObj, c);
                } catch (IOException e) {
                    throw new IllegalStateException("Failed to get POJO.", e);
                }
            }
        });
    }

    /**
     * Gets an object List.
     *
     * @param <T> the type of the objects in the List.
     * @param propertyName the property to get
     * @param c the class of the object. If c is a POJO class, it must be a member (and not an anonymous or local)
     * and a static one.
     * @param convertFromCamelCase boolean indicating if String should be converted from camel case to upper case
     * separated by underscore,
     * before converting to required class.
     * @return the object collection.
     * @throws IllegalStateException thrown if an error occurs
     */
    @SuppressWarnings("unchecked")
    // Implicit or explicit cast to T is done only after checking values are assignable from Class<T>.
    public <T> List<T> getList(String propertyName, Class<T> c, boolean... convertFromCamelCase) {
        return getWithMapping(propertyName, jsonArray -> {
            ArrayList<T> result = new ArrayList<>();

            boolean isBaseClass = false;
            boolean isEnumClass = false;
            boolean isJsonSerializable = false;
            boolean containsJsonSerializable = false;

            // Check once.
            if (Number.class.isAssignableFrom(c) || String.class.isAssignableFrom(c)
                    || Boolean.class.isAssignableFrom(c) || Object.class == c) {
                isBaseClass = true;
            } else if (Enum.class.isAssignableFrom(c)) {
                isEnumClass = true;
            } else if (JsonSerializable.class.isAssignableFrom(c)) {
                isJsonSerializable = true;
            } else if (containsJsonSerializable(c)) {
                containsJsonSerializable = true;
            } else {
                JsonSerializable.checkForValidPOJO(c);
            }

            for (JsonNode n : jsonArray) {
                if (isBaseClass) {
                    // NUMBER, STRING, Boolean
                    result.add(c.cast(getValue(n)));
                } else if (isEnumClass) {
                    try {
                        String value = (String) getValue(n);
                        value = convertFromCamelCase.length > 0 && convertFromCamelCase[0]
                                    ? Strings.fromCamelCaseToUpperCase(value) : value;
                        result.add(c.cast(c.getMethod("valueOf", String.class).invoke(null, value)));
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                                 | NoSuchMethodException | SecurityException e) {
                        throw new IllegalStateException("Failed to create enum.", e);
                    }
                } else if (isJsonSerializable) {
                    // JsonSerializable
                    T t = (T) instantiateFromObjectNodeAndType((ObjectNode) n, c);
                    result.add(t);

                } else if (containsJsonSerializable) {
                    T t = ModelBridgeInternal.instantiateByObjectNode((ObjectNode) n, c);
                    result.add(t);
                } else {
                    // POJO
                    try {
                        result.add(OBJECT_MAPPER.treeToValue(n, c));
                    } catch (IOException e) {
                        throw new IllegalStateException("Failed to get POJO.", e);
                    }
                }
            }
            return result;
        });
    }

    /**
     * Gets an object collection.
     *
     * @param <T> the type of the objects in the collection.
     * @param propertyName the property to get
     * @param c the class of the object. If c is a POJO class, it must be a member (and not an anonymous or local)
     * and a static one.
     * @param convertFromCamelCase boolean indicating if String should be converted from camel case to upper case
     * separated by underscore,
     * before converting to required class.
     * @return the object collection.
     */
    public <T> Collection<T> getCollection(String propertyName, Class<T> c, boolean... convertFromCamelCase) {
        return getList(propertyName, c, convertFromCamelCase);
    }

    /**
     * Gets a ObjectNode.
     *
     * @param propertyName the property to get.
     * @return the ObjectNode.
     */
    public ObjectNode getObject(String propertyName) {
        return getWithMapping(propertyName, n -> (ObjectNode) n);
    }

    /**
     * Gets the value of a property identified by an array of property names that forms the path.
     *
     * @param propertyNames that form the path to the property to get.
     * @return the value of the property.
     */
    public Object getObjectByPath(List<String> propertyNames) {
        ObjectNode propBag = this.propertyBag;
        JsonNode value = null;
        String propertyName = null;
        int matchedProperties = 0;
        Iterator<String> iterator = propertyNames.iterator();
        if (iterator.hasNext()) {
            do {
                propertyName = iterator.next();
                if (propBag.has(propertyName)) {
                    matchedProperties++;
                    value = propBag.get(propertyName);
                    if (!value.isObject()) {
                        break;
                    }
                    propBag = (ObjectNode) value;
                } else {
                    break;
                }
            } while (iterator.hasNext());

            if (value != null && matchedProperties == propertyNames.size()) {
                return getValue(value);
            }
        }

        return null;
    }

    private ObjectNode fromJson(byte[] bytes) {
        try {
            return (ObjectNode) OBJECT_MAPPER.readTree(bytes);
        } catch (IOException e) {
            throw new IllegalArgumentException(
                String.format("Unable to parse JSON %s", Arrays.toString(bytes)), e);
        }
    }

    private ObjectNode fromJson(String json, ObjectMapper objectMapper) {
        try {
            return (ObjectNode) objectMapper.readTree(json);
        } catch (IOException e) {
            throw new IllegalArgumentException(
                String.format("Unable to parse JSON %s", json), e);
        }
    }

    private ObjectNode fromJson(ByteBuffer json) {
        try {
            return (ObjectNode) OBJECT_MAPPER.readTree(new ByteBufferBackedInputStream(json));
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to parse JSON from ByteBuffer", e);
        }
    }

    public ByteBuffer serializeJsonToByteBuffer(CosmosItemSerializer itemSerializer, Consumer<Map<String, Object>> onAfterSerialization, boolean isIdValidationEnabled) {
        this.populatePropertyBag();
        return Utils.serializeJsonToByteBuffer(itemSerializer, propertyBag, onAfterSerialization, isIdValidationEnabled);
    }

    private String toJson(Object object) {
        return toJson(OBJECT_MAPPER, object);
    }

    private static String toJson(ObjectMapper mapper, Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Unable to convert JSON to STRING", e);
        }
    }

    private String toPrettyJson(Object object) {
        try {
            return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Unable to convert JSON to STRING", e);
        }
    }

    /**
     * Converts to an Object (only POJOs and JsonNode are supported).
     *
     * @param <T> the type of the object.
     * @param c the class of the object, either a POJO class or JsonNode. If c is a POJO class, it must be a member
     * (and not an anonymous or local) and a static one.
     * @return the POJO.
     * @throws IllegalArgumentException thrown if an error occurs
     * @throws IllegalStateException thrown when objectmapper is unable to read tree
     */
    @SuppressWarnings("unchecked")
    // Implicit or explicit cast to T is done after checking values are assignable from Class<T>.
    public <T> T toObject(Class<T> c) {
        // TODO: We have to remove this if we do not want to support InternalObjectNode anymore, and change all the
        //  tests accordingly
        if (InternalObjectNode.class.isAssignableFrom(c)) {
            return (T) new InternalObjectNode(this.propertyBag);
        }
        if (JsonSerializable.class.isAssignableFrom(c)
            || String.class.isAssignableFrom(c)
            || Number.class.isAssignableFrom(c)
            || Boolean.class.isAssignableFrom(c)
            || containsJsonSerializable(c)) {

            return c.cast(this.get(Constants.Properties.VALUE));
        }
        if (List.class.isAssignableFrom(c)) {
            Object o = this.get(Constants.Properties.VALUE);
            try {
                return OBJECT_MAPPER.readValue(o.toString(), c);
            } catch (IOException e) {
                throw new IllegalStateException("Failed to convert to collection.", e);
            }
        }
        if (JsonNode.class.isAssignableFrom(c) || ObjectNode.class.isAssignableFrom(c)) {
            // JsonNode
            if (JsonNode.class != c) {
                if (ObjectNode.class != c) {
                    throw new IllegalArgumentException(
                        "We support JsonNode but not its sub-classes.");
                }
            }
            return c.cast(this.propertyBag);
        } else {
            // POJO
            JsonSerializable.checkForValidPOJO(c);
            try {
                return OBJECT_MAPPER.treeToValue(propertyBag, c);
            } catch (IOException e) {
                throw new IllegalStateException("Failed to get POJO.", e);
            }
        }
    }

    /**
     * Converts to an Object (only POJOs and JsonNode are supported).
     *
     * @param <T> the type of the object.
     * @param c the class of the object, either a POJO class or JsonNode. If c is a POJO class, it must be a member
     * (and not an anonymous or local) and a static one.
     * @return the POJO.
     * @throws IllegalArgumentException thrown if an error occurs
     * @throws IllegalStateException thrown when objectmapper is unable to read tree
     */
    @SuppressWarnings("unchecked")
    // Implicit or explicit cast to T is done after checking values are assignable from Class<T>.
    public static <T> T toObjectFromObjectNode(JsonNode node, boolean isValueQuery, Class<T> c) {
        if (isValueQuery && node.has(Constants.Properties.VALUE)) {
            return OBJECT_MAPPER.convertValue(node.get(Constants.Properties.VALUE), c);
        }

        if (InternalObjectNode.class.isAssignableFrom(c)) {
            return (T) new InternalObjectNode((ObjectNode)node);
        }

        if (node instanceof ObjectNode &&
            (JsonSerializable.class.isAssignableFrom(c) || containsJsonSerializable(c))) {

            return c.cast(instantiateFromObjectNodeAndType((ObjectNode)node, c));
        }

        if (List.class.isAssignableFrom(c)) {
            try {
                return OBJECT_MAPPER.readValue(node.toString(), c);
            } catch (IOException e) {
                throw new IllegalStateException("Failed to convert to collection.", e);
            }
        }
        if (JsonNode.class.isAssignableFrom(c) || ObjectNode.class.isAssignableFrom(c)) {
            // JsonNode
            if (JsonNode.class != c) {
                if (ObjectNode.class != c) {
                    throw new IllegalArgumentException(
                        "We support JsonNode but not its sub-classes.");
                }
            }

            return c.cast(node);
        } else {
            // POJO
            JsonSerializable.checkForValidPOJO(c);
            try {
                return OBJECT_MAPPER.treeToValue(node, c);
            } catch (IOException e) {
               throw new IllegalStateException(
                    String.format(
                        "Failed to get POJO of type '%s' for json '%s'.",
                        c.getName(),
                        toJson(OBJECT_MAPPER, node)),
                    e);
            }
        }
    }

    /**
     * Converts to a JSON string.
     *
     * @return the JSON string.
     */
    public String toJson() {
        return this.toJson(SerializationFormattingPolicy.NONE);
    }

    /**
     * Converts to a JSON string.
     *
     * @param formattingPolicy the formatting policy to be used.
     * @return the JSON string.
     */
    protected String toJson(SerializationFormattingPolicy formattingPolicy) {
        this.populatePropertyBag();
        if (SerializationFormattingPolicy.INDENTED.equals(formattingPolicy)) {
            return toPrettyJson(propertyBag);
        } else {
            return toJson(propertyBag);
        }
    }

    /**
     * Gets Simple STRING representation of property bag.
     * <p>
     * For proper conversion to json and inclusion of the default values
     * use {@link #toJson()}.
     *
     * @return string representation of property bag.
     */
    public String toString() {
        return toJson(propertyBag);
    }

    public ObjectNode getPropertyBag() {
        return this.propertyBag;
    }

    static <T> boolean containsJsonSerializable(Class<T> c) {
        return CompositePath.class.equals(c)
            || ConflictResolutionPolicy.class.equals(c)
            || ChangeFeedPolicy.class.equals(c)
            || ExcludedPath.class.equals(c)
            || IncludedPath.class.equals(c)
            || IndexingPolicy.class.equals(c)
            || PartitionKeyDefinition.class.equals(c)
            || SpatialSpec.class.equals(c)
            || SqlParameter.class.equals(c)
            || SqlQuerySpec.class.equals(c)
            || UniqueKey.class.equals(c)
            || UniqueKeyPolicy.class.equals(c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JsonSerializable that = (JsonSerializable) o;
        return Objects.equals(propertyBag, that.propertyBag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyBag);
    }
}
