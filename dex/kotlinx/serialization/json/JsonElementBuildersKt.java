package kotlinx.serialization.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

/* compiled from: JsonElementBuilders.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0010\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a2\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a2\u0010\u0007\u001a\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u0019\u0010\n\u001a\u00020\u000b*\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\r\u001a\u0016\u0010\n\u001a\u00020\u000b*\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000eH\u0007\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000f\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0010\u001a!\u0010\u0011\u001a\u00020\u000b*\u00020\u00042\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0013H\u0007¢\u0006\u0002\b\u0014\u001a!\u0010\u0011\u001a\u00020\u000b*\u00020\u00042\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0013H\u0007¢\u0006\u0002\b\u0015\u001a!\u0010\u0011\u001a\u00020\u000b*\u00020\u00042\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0013H\u0007¢\u0006\u0002\b\u0016\u001a#\u0010\u0017\u001a\u00020\u000b*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a#\u0010\u0018\u001a\u00020\u000b*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a#\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001c\u001a \u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000eH\u0007\u001a\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000f\u001a\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u0010\u001a-\u0010\u001d\u001a\u0004\u0018\u00010\u001a*\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00102\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a-\u0010\u001e\u001a\u0004\u0018\u00010\u001a*\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00102\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"buildJsonArray", "Lkotlinx/serialization/json/JsonArray;", "builderAction", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonArrayBuilder;", "", "Lkotlin/ExtensionFunctionType;", "buildJsonObject", "Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonObjectBuilder;", "add", "", "value", "(Lkotlinx/serialization/json/JsonArrayBuilder;Ljava/lang/Boolean;)Z", "", "", "", "addAll", "values", "", "addAllBooleans", "addAllNumbers", "addAllStrings", "addJsonArray", "addJsonObject", "put", "Lkotlinx/serialization/json/JsonElement;", "key", "(Lkotlinx/serialization/json/JsonObjectBuilder;Ljava/lang/String;Ljava/lang/Boolean;)Lkotlinx/serialization/json/JsonElement;", "putJsonArray", "putJsonObject", "kotlinx-serialization-json"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JsonElementBuildersKt {
    public static final JsonObject buildJsonObject(Function1<? super JsonObjectBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        JsonObjectBuilder builder = new JsonObjectBuilder();
        builderAction.invoke(builder);
        return builder.build();
    }

    public static final JsonArray buildJsonArray(Function1<? super JsonArrayBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        JsonArrayBuilder builder = new JsonArrayBuilder();
        builderAction.invoke(builder);
        return builder.build();
    }

    public static final JsonElement putJsonObject(JsonObjectBuilder $this$putJsonObject, String key, Function1<? super JsonObjectBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter($this$putJsonObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        builderAction.invoke(builder$iv);
        return $this$putJsonObject.put(key, builder$iv.build());
    }

    public static final JsonElement putJsonArray(JsonObjectBuilder $this$putJsonArray, String key, Function1<? super JsonArrayBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter($this$putJsonArray, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        JsonArrayBuilder builder$iv = new JsonArrayBuilder();
        builderAction.invoke(builder$iv);
        return $this$putJsonArray.put(key, builder$iv.build());
    }

    public static final JsonElement put(JsonObjectBuilder $this$put, String key, Boolean value) {
        Intrinsics.checkNotNullParameter($this$put, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return $this$put.put(key, JsonElementKt.JsonPrimitive(value));
    }

    public static final JsonElement put(JsonObjectBuilder $this$put, String key, Number value) {
        Intrinsics.checkNotNullParameter($this$put, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return $this$put.put(key, JsonElementKt.JsonPrimitive(value));
    }

    public static final JsonElement put(JsonObjectBuilder $this$put, String key, String value) {
        Intrinsics.checkNotNullParameter($this$put, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return $this$put.put(key, JsonElementKt.JsonPrimitive(value));
    }

    @ExperimentalSerializationApi
    public static final JsonElement put(JsonObjectBuilder $this$put, String key, Void value) {
        Intrinsics.checkNotNullParameter($this$put, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return $this$put.put(key, JsonNull.INSTANCE);
    }

    public static final boolean add(JsonArrayBuilder $this$add, Boolean value) {
        Intrinsics.checkNotNullParameter($this$add, "<this>");
        return $this$add.add(JsonElementKt.JsonPrimitive(value));
    }

    public static final boolean add(JsonArrayBuilder $this$add, Number value) {
        Intrinsics.checkNotNullParameter($this$add, "<this>");
        return $this$add.add(JsonElementKt.JsonPrimitive(value));
    }

    public static final boolean add(JsonArrayBuilder $this$add, String value) {
        Intrinsics.checkNotNullParameter($this$add, "<this>");
        return $this$add.add(JsonElementKt.JsonPrimitive(value));
    }

    @ExperimentalSerializationApi
    public static final boolean add(JsonArrayBuilder $this$add, Void value) {
        Intrinsics.checkNotNullParameter($this$add, "<this>");
        return $this$add.add(JsonNull.INSTANCE);
    }

    public static final boolean addJsonObject(JsonArrayBuilder $this$addJsonObject, Function1<? super JsonObjectBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter($this$addJsonObject, "<this>");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        builderAction.invoke(builder$iv);
        return $this$addJsonObject.add(builder$iv.build());
    }

    public static final boolean addJsonArray(JsonArrayBuilder $this$addJsonArray, Function1<? super JsonArrayBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter($this$addJsonArray, "<this>");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        JsonArrayBuilder builder$iv = new JsonArrayBuilder();
        builderAction.invoke(builder$iv);
        return $this$addJsonArray.add(builder$iv.build());
    }

    @ExperimentalSerializationApi
    public static final boolean addAllStrings(JsonArrayBuilder $this$addAll, Collection<String> values) {
        Intrinsics.checkNotNullParameter($this$addAll, "<this>");
        Intrinsics.checkNotNullParameter(values, "values");
        Collection<String> $this$map$iv = values;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String p0 = (String) item$iv$iv;
            destination$iv$iv.add(JsonElementKt.JsonPrimitive(p0));
        }
        return $this$addAll.addAll((List) destination$iv$iv);
    }

    @ExperimentalSerializationApi
    public static final boolean addAllBooleans(JsonArrayBuilder $this$addAll, Collection<Boolean> values) {
        Intrinsics.checkNotNullParameter($this$addAll, "<this>");
        Intrinsics.checkNotNullParameter(values, "values");
        Collection<Boolean> $this$map$iv = values;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Boolean p0 = (Boolean) item$iv$iv;
            destination$iv$iv.add(JsonElementKt.JsonPrimitive(p0));
        }
        return $this$addAll.addAll((List) destination$iv$iv);
    }

    @ExperimentalSerializationApi
    public static final boolean addAllNumbers(JsonArrayBuilder $this$addAll, Collection<? extends Number> values) {
        Intrinsics.checkNotNullParameter($this$addAll, "<this>");
        Intrinsics.checkNotNullParameter(values, "values");
        Collection<? extends Number> $this$map$iv = values;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Number p0 = (Number) item$iv$iv;
            destination$iv$iv.add(JsonElementKt.JsonPrimitive(p0));
        }
        return $this$addAll.addAll((List) destination$iv$iv);
    }
}