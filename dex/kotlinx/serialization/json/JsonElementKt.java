package kotlinx.serialization.json;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.InlineClassDescriptorKt;
import kotlinx.serialization.json.internal.JsonEncodingException;
import kotlinx.serialization.json.internal.StringOpsKt;

/* compiled from: JsonElement.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\u0010\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0015\u0010>\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010@\u001a\u0012\u0010>\u001a\u00020-2\b\u0010?\u001a\u0004\u0018\u00010AH\u0007\u001a\u0010\u0010>\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010B\u001a\u0010\u0010>\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010\u000f\u001a\u001d\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020CH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010E\u001a\u001d\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020FH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010H\u001a\u001d\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020IH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010K\u001a\u001d\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020LH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bM\u0010N\u001a\u0012\u0010O\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u0018\u0010P\u001a\u00020A2\u0006\u0010Q\u001a\u00020\u000f2\u0006\u0010R\u001a\u00020\u000fH\u0001\u001a\u0014\u0010S\u001a\u00020A*\u00020)2\u0006\u0010T\u001a\u00020\u000fH\u0002\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u0012\u001a\u00020\u0013*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u0013*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u001a*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0015\u0010 \u001a\u00020!*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0017\u0010$\u001a\u0004\u0018\u00010!*\u00020\b8F¢\u0006\u0006\u001a\u0004\b%\u0010&\"\u0015\u0010'\u001a\u00020(*\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0015\u0010,\u001a\u00020-*\u00020)8F¢\u0006\u0006\u001a\u0004\b.\u0010/\"\u0015\u00100\u001a\u000201*\u00020)8F¢\u0006\u0006\u001a\u0004\b2\u00103\"\u0015\u00104\u001a\u00020\b*\u00020)8F¢\u0006\u0006\u001a\u0004\b5\u00106\"\u0015\u00107\u001a\u000208*\u00020\b8F¢\u0006\u0006\u001a\u0004\b9\u0010:\"\u0017\u0010;\u001a\u0004\u0018\u000108*\u00020\b8F¢\u0006\u0006\u001a\u0004\b<\u0010=\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006U"}, d2 = {"jsonUnquotedLiteralDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getJsonUnquotedLiteralDescriptor$annotations", "()V", "getJsonUnquotedLiteralDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "boolean", "", "Lkotlinx/serialization/json/JsonPrimitive;", "getBoolean", "(Lkotlinx/serialization/json/JsonPrimitive;)Z", "booleanOrNull", "getBooleanOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Boolean;", "contentOrNull", "", "getContentOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/String;", "double", "", "getDouble", "(Lkotlinx/serialization/json/JsonPrimitive;)D", "doubleOrNull", "getDoubleOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Double;", "float", "", "getFloat", "(Lkotlinx/serialization/json/JsonPrimitive;)F", "floatOrNull", "getFloatOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Float;", "int", "", "getInt", "(Lkotlinx/serialization/json/JsonPrimitive;)I", "intOrNull", "getIntOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Integer;", "jsonArray", "Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonElement;", "getJsonArray", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonArray;", "jsonNull", "Lkotlinx/serialization/json/JsonNull;", "getJsonNull", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonNull;", "jsonObject", "Lkotlinx/serialization/json/JsonObject;", "getJsonObject", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;", "jsonPrimitive", "getJsonPrimitive", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonPrimitive;", "long", "", "getLong", "(Lkotlinx/serialization/json/JsonPrimitive;)J", "longOrNull", "getLongOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Long;", "JsonPrimitive", "value", "(Ljava/lang/Boolean;)Lkotlinx/serialization/json/JsonPrimitive;", "", "", "Lkotlin/UByte;", "JsonPrimitive-7apg3OU", "(B)Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlin/UInt;", "JsonPrimitive-WZ4Q5Ns", "(I)Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlin/ULong;", "JsonPrimitive-VKZWuLQ", "(J)Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlin/UShort;", "JsonPrimitive-xj2QHRw", "(S)Lkotlinx/serialization/json/JsonPrimitive;", "JsonUnquotedLiteral", "unexpectedJson", "key", "expected", "error", "element", "kotlinx-serialization-json"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JsonElementKt {
    private static final SerialDescriptor jsonUnquotedLiteralDescriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlinx.serialization.json.JsonUnquotedLiteral", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));

    public static /* synthetic */ void getJsonUnquotedLiteralDescriptor$annotations() {
    }

    public static final JsonPrimitive JsonPrimitive(Boolean value) {
        return value == null ? JsonNull.INSTANCE : new JsonLiteral(value, false, null, 4, null);
    }

    public static final JsonPrimitive JsonPrimitive(Number value) {
        return value == null ? JsonNull.INSTANCE : new JsonLiteral(value, false, null, 4, null);
    }

    @ExperimentalSerializationApi
    /* renamed from: JsonPrimitive-7apg3OU  reason: not valid java name */
    public static final JsonPrimitive m1565JsonPrimitive7apg3OU(byte value) {
        return m1566JsonPrimitiveVKZWuLQ(ULong.constructor-impl(value & 255));
    }

    @ExperimentalSerializationApi
    /* renamed from: JsonPrimitive-xj2QHRw  reason: not valid java name */
    public static final JsonPrimitive m1568JsonPrimitivexj2QHRw(short value) {
        return m1566JsonPrimitiveVKZWuLQ(ULong.constructor-impl(value & 65535));
    }

    @ExperimentalSerializationApi
    /* renamed from: JsonPrimitive-WZ4Q5Ns  reason: not valid java name */
    public static final JsonPrimitive m1567JsonPrimitiveWZ4Q5Ns(int value) {
        return m1566JsonPrimitiveVKZWuLQ(ULong.constructor-impl(value & 4294967295L));
    }

    @ExperimentalSerializationApi
    /* renamed from: JsonPrimitive-VKZWuLQ  reason: not valid java name */
    public static final JsonPrimitive m1566JsonPrimitiveVKZWuLQ(long value) {
        return JsonUnquotedLiteral(JsonElementKt$$ExternalSyntheticBackport0.m(value));
    }

    public static final JsonPrimitive JsonPrimitive(String value) {
        return value == null ? JsonNull.INSTANCE : new JsonLiteral(value, true, null, 4, null);
    }

    @ExperimentalSerializationApi
    public static final JsonNull JsonPrimitive(Void value) {
        return JsonNull.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final JsonPrimitive JsonUnquotedLiteral(String value) {
        if (value == null) {
            return JsonNull.INSTANCE;
        }
        if (Intrinsics.areEqual(value, JsonNull.INSTANCE.getContent())) {
            throw new JsonEncodingException("Creating a literal unquoted value of 'null' is forbidden. If you want to create JSON null literal, use JsonNull object, otherwise, use JsonPrimitive");
        }
        return new JsonLiteral(value, false, jsonUnquotedLiteralDescriptor);
    }

    public static final SerialDescriptor getJsonUnquotedLiteralDescriptor() {
        return jsonUnquotedLiteralDescriptor;
    }

    public static final JsonPrimitive getJsonPrimitive(JsonElement $this$jsonPrimitive) {
        Intrinsics.checkNotNullParameter($this$jsonPrimitive, "<this>");
        JsonPrimitive jsonPrimitive = $this$jsonPrimitive instanceof JsonPrimitive ? (JsonPrimitive) $this$jsonPrimitive : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        error($this$jsonPrimitive, "JsonPrimitive");
        throw new KotlinNothingValueException();
    }

    public static final JsonObject getJsonObject(JsonElement $this$jsonObject) {
        Intrinsics.checkNotNullParameter($this$jsonObject, "<this>");
        JsonObject jsonObject = $this$jsonObject instanceof JsonObject ? (JsonObject) $this$jsonObject : null;
        if (jsonObject != null) {
            return jsonObject;
        }
        error($this$jsonObject, "JsonObject");
        throw new KotlinNothingValueException();
    }

    public static final JsonArray getJsonArray(JsonElement $this$jsonArray) {
        Intrinsics.checkNotNullParameter($this$jsonArray, "<this>");
        JsonArray jsonArray = $this$jsonArray instanceof JsonArray ? (JsonArray) $this$jsonArray : null;
        if (jsonArray != null) {
            return jsonArray;
        }
        error($this$jsonArray, "JsonArray");
        throw new KotlinNothingValueException();
    }

    public static final JsonNull getJsonNull(JsonElement $this$jsonNull) {
        Intrinsics.checkNotNullParameter($this$jsonNull, "<this>");
        JsonNull jsonNull = $this$jsonNull instanceof JsonNull ? (JsonNull) $this$jsonNull : null;
        if (jsonNull != null) {
            return jsonNull;
        }
        error($this$jsonNull, "JsonNull");
        throw new KotlinNothingValueException();
    }

    public static final int getInt(JsonPrimitive $this$int) {
        Intrinsics.checkNotNullParameter($this$int, "<this>");
        return Integer.parseInt($this$int.getContent());
    }

    public static final Integer getIntOrNull(JsonPrimitive $this$intOrNull) {
        Intrinsics.checkNotNullParameter($this$intOrNull, "<this>");
        return StringsKt.toIntOrNull($this$intOrNull.getContent());
    }

    public static final long getLong(JsonPrimitive $this$long) {
        Intrinsics.checkNotNullParameter($this$long, "<this>");
        return Long.parseLong($this$long.getContent());
    }

    public static final Long getLongOrNull(JsonPrimitive $this$longOrNull) {
        Intrinsics.checkNotNullParameter($this$longOrNull, "<this>");
        return StringsKt.toLongOrNull($this$longOrNull.getContent());
    }

    public static final double getDouble(JsonPrimitive $this$double) {
        Intrinsics.checkNotNullParameter($this$double, "<this>");
        return Double.parseDouble($this$double.getContent());
    }

    public static final Double getDoubleOrNull(JsonPrimitive $this$doubleOrNull) {
        Intrinsics.checkNotNullParameter($this$doubleOrNull, "<this>");
        return StringsKt.toDoubleOrNull($this$doubleOrNull.getContent());
    }

    public static final float getFloat(JsonPrimitive $this$float) {
        Intrinsics.checkNotNullParameter($this$float, "<this>");
        return Float.parseFloat($this$float.getContent());
    }

    public static final Float getFloatOrNull(JsonPrimitive $this$floatOrNull) {
        Intrinsics.checkNotNullParameter($this$floatOrNull, "<this>");
        return StringsKt.toFloatOrNull($this$floatOrNull.getContent());
    }

    public static final boolean getBoolean(JsonPrimitive $this$boolean) {
        Intrinsics.checkNotNullParameter($this$boolean, "<this>");
        Boolean booleanStrictOrNull = StringOpsKt.toBooleanStrictOrNull($this$boolean.getContent());
        if (booleanStrictOrNull != null) {
            return booleanStrictOrNull.booleanValue();
        }
        throw new IllegalStateException($this$boolean + " does not represent a Boolean");
    }

    public static final Boolean getBooleanOrNull(JsonPrimitive $this$booleanOrNull) {
        Intrinsics.checkNotNullParameter($this$booleanOrNull, "<this>");
        return StringOpsKt.toBooleanStrictOrNull($this$booleanOrNull.getContent());
    }

    public static final String getContentOrNull(JsonPrimitive $this$contentOrNull) {
        Intrinsics.checkNotNullParameter($this$contentOrNull, "<this>");
        if ($this$contentOrNull instanceof JsonNull) {
            return null;
        }
        return $this$contentOrNull.getContent();
    }

    private static final Void error(JsonElement $this$error, String element) {
        throw new IllegalArgumentException("Element " + Reflection.getOrCreateKotlinClass($this$error.getClass()) + " is not a " + element);
    }

    public static final Void unexpectedJson(String key, String expected) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(expected, "expected");
        throw new IllegalArgumentException("Element " + key + " is not a " + expected);
    }
}