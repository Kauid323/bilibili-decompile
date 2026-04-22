package kotlinx.serialization.json.internal;

import java.lang.annotation.Annotation;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonClassDiscriminator;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: Polymorphic.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0001\u001a*\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u0007*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a%\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u0014*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0017H\u0000¢\u0006\u0002\u0010\u0018\u001aE\u0010\u0019\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0014*\u00020\u001a2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00140\f2\u0006\u0010\u001b\u001a\u0002H\u00142\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u001dH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"checkKind", "", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "throwSerializerNotFound", "", "type", "", "jsonTree", "Lkotlinx/serialization/json/JsonObject;", "validateIfSealed", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "actualSerializer", "", "classDiscriminator", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "json", "Lkotlinx/serialization/json/Json;", "decodeSerializableValuePolymorphic", "T", "Lkotlinx/serialization/json/JsonDecoder;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/JsonDecoder;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "encodePolymorphically", "Lkotlinx/serialization/json/JsonEncoder;", "value", "ifPolymorphic", "Lkotlin/Function1;", "(Lkotlinx/serialization/json/JsonEncoder;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "kotlinx-serialization-json"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PolymorphicKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void encodePolymorphically(JsonEncoder $this$encodePolymorphically, SerializationStrategy<? super T> serializer, T t, Function1<? super String, Unit> ifPolymorphic) {
        Intrinsics.checkNotNullParameter($this$encodePolymorphically, "<this>");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(ifPolymorphic, "ifPolymorphic");
        if (!(serializer instanceof AbstractPolymorphicSerializer) || $this$encodePolymorphically.getJson().getConfiguration().getUseArrayPolymorphism()) {
            serializer.serialize($this$encodePolymorphically, t);
            return;
        }
        AbstractPolymorphicSerializer casted = (AbstractPolymorphicSerializer) serializer;
        String baseClassDiscriminator = classDiscriminator(serializer.getDescriptor(), $this$encodePolymorphically.getJson());
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Any");
        SerializationStrategy actualSerializer = PolymorphicSerializerKt.findPolymorphicSerializer(casted, $this$encodePolymorphically, t);
        validateIfSealed(casted, actualSerializer, baseClassDiscriminator);
        checkKind(actualSerializer.getDescriptor().getKind());
        ifPolymorphic.invoke(baseClassDiscriminator);
        actualSerializer.serialize($this$encodePolymorphically, t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateIfSealed(SerializationStrategy<?> serializationStrategy, SerializationStrategy<Object> serializationStrategy2, String classDiscriminator) {
        if ((serializationStrategy instanceof SealedClassSerializer) && JsonInternalDependenciesKt.jsonCachedSerialNames(serializationStrategy2.getDescriptor()).contains(classDiscriminator)) {
            String baseName = serializationStrategy.getDescriptor().getSerialName();
            String actualName = serializationStrategy2.getDescriptor().getSerialName();
            throw new IllegalStateException(("Sealed class '" + actualName + "' cannot be serialized as base class '" + baseName + "' because it has property name that conflicts with JSON class discriminator '" + classDiscriminator + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
        }
    }

    public static final void checkKind(SerialKind kind) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (kind instanceof SerialKind.ENUM) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        }
        if (kind instanceof PrimitiveKind) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        }
        if (kind instanceof PolymorphicKind) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
        }
    }

    public static final <T> T decodeSerializableValuePolymorphic(JsonDecoder $this$decodeSerializableValuePolymorphic, DeserializationStrategy<? extends T> deserializer) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter($this$decodeSerializableValuePolymorphic, "<this>");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        if (!(deserializer instanceof AbstractPolymorphicSerializer) || $this$decodeSerializableValuePolymorphic.getJson().getConfiguration().getUseArrayPolymorphism()) {
            return deserializer.deserialize($this$decodeSerializableValuePolymorphic);
        }
        String discriminator = classDiscriminator(deserializer.getDescriptor(), $this$decodeSerializableValuePolymorphic.getJson());
        JsonElement value$iv = $this$decodeSerializableValuePolymorphic.decodeJsonElement();
        SerialDescriptor descriptor$iv = deserializer.getDescriptor();
        if (value$iv instanceof JsonObject) {
            JsonObject jsonTree = (JsonObject) value$iv;
            JsonElement jsonElement = (JsonElement) jsonTree.get((Object) discriminator);
            String type = (jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : jsonPrimitive.getContent();
            DeserializationStrategy actualSerializer = ((AbstractPolymorphicSerializer) deserializer).findPolymorphicSerializerOrNull($this$decodeSerializableValuePolymorphic, type);
            if (actualSerializer == null) {
                throwSerializerNotFound(type, jsonTree);
                throw new KotlinNothingValueException();
            }
            return (T) TreeJsonDecoderKt.readPolymorphicJson($this$decodeSerializableValuePolymorphic.getJson(), discriminator, jsonTree, actualSerializer);
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class) + " as the serialized body of " + descriptor$iv.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv.getClass()));
    }

    public static final Void throwSerializerNotFound(String type, JsonObject jsonTree) {
        Intrinsics.checkNotNullParameter(jsonTree, "jsonTree");
        String suffix = type == null ? "missing class discriminator ('null')" : "class discriminator '" + type + '\'';
        throw JsonExceptionsKt.JsonDecodingException(-1, "Polymorphic serializer was not found for " + suffix, jsonTree.toString());
    }

    public static final String classDiscriminator(SerialDescriptor $this$classDiscriminator, Json json) {
        Intrinsics.checkNotNullParameter($this$classDiscriminator, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        for (Annotation annotation : $this$classDiscriminator.getAnnotations()) {
            if (annotation instanceof JsonClassDiscriminator) {
                return ((JsonClassDiscriminator) annotation).discriminator();
            }
        }
        return json.getConfiguration().getClassDiscriminator();
    }
}