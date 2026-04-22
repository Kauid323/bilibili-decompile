package kntr.app.ad.common.utils;

import java.lang.annotation.Annotation;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: JsonExt.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000b\u001a\u0019\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000e\u001a\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u0004\u0018\u00010\n*\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u0004\u0018\u00010\b*\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001e\u0010\u001a\u001a\u0004\u0018\u0001H\u001b\"\u0006\b\u0000\u0010\u001b\u0018\u0001*\u0004\u0018\u00010\nH\u0086\b¢\u0006\u0002\u0010\u001c\u001a\u001a\u0010\u001d\u001a\u00020\n\"\u0006\b\u0000\u0010\u001b\u0018\u0001*\u0002H\u001bH\u0086\b¢\u0006\u0002\u0010\u001e\u001a\u001a\u0010\u001f\u001a\u00020\b\"\u0006\b\u0000\u0010\u001b\u0018\u0001*\u0002H\u001bH\u0086\b¢\u0006\u0002\u0010 \u001a*\u0010!\u001a\u0002H\u001b\"\u0006\b\u0000\u0010\u001b\u0018\u0001*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\"\u001a\u0002H\u001bH\u0086\b¢\u0006\u0002\u0010#\u001a*\u0010$\u001a\u0004\u0018\u0001H%\"\u0006\b\u0000\u0010%\u0018\u0001*\u0004\u0018\u00010&2\n\b\u0002\u0010\"\u001a\u0004\u0018\u0001H%H\u0086\b¢\u0006\u0002\u0010'\"\u0017\u0010\u0000\u001a\u00020\u0001¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006("}, d2 = {"adJson", "Lkotlinx/serialization/json/Json;", "getAdJson$annotations", "()V", "getAdJson", "()Lkotlinx/serialization/json/Json;", "getIntOrNull", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/json/JsonObject;", "key", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "getLongOrNull", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Long;", "getFloatOrNull", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Float;", "getDoubleOrNull", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Double;", "getStringOrNull", "getBooleanOrNull", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "getJsonObjectOrNull", "parseToObj", "T", "(Ljava/lang/String;)Ljava/lang/Object;", "encodeToString", "(Ljava/lang/Object;)Ljava/lang/String;", "toJsonObject", "(Ljava/lang/Object;)Lkotlinx/serialization/json/JsonObject;", "getOrDefault", "default", "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "convertJson", "R", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "utils_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class JsonExtKt {
    private static final Json adJson = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.app.ad.common.utils.JsonExtKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit adJson$lambda$0;
            adJson$lambda$0 = JsonExtKt.adJson$lambda$0((JsonBuilder) obj);
            return adJson$lambda$0;
        }
    }, 1, (Object) null);

    public static /* synthetic */ void getAdJson$annotations() {
    }

    public static final Json getAdJson() {
        return adJson;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit adJson$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setCoerceInputValues(true);
        $this$Json.setUseAlternativeNames(true);
        $this$Json.setNamingStrategy(new JsonNamingStrategy() { // from class: kntr.app.ad.common.utils.JsonExtKt$adJson$1$1
            public String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName) {
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                Intrinsics.checkNotNullParameter(serialName, "serialName");
                Iterable $this$forEach$iv = descriptor.getElementAnnotations(elementIndex);
                for (Object element$iv : $this$forEach$iv) {
                    Annotation it = (Annotation) element$iv;
                    if (it instanceof AdJsonSerialName) {
                        return ((AdJsonSerialName) it).value();
                    }
                }
                return JsonNamingStrategy.Builtins.getSnakeCase().serialNameForJson(descriptor, elementIndex, serialName);
            }
        });
        return Unit.INSTANCE;
    }

    public static final Integer getIntOrNull(JsonObject $this$getIntOrNull, String key) {
        Object obj;
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter($this$getIntOrNull, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Result.Companion companion = Result.Companion;
            JsonElement jsonElement = (JsonElement) $this$getIntOrNull.get(key);
            obj = Result.constructor-impl((jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : JsonElementKt.getIntOrNull(jsonPrimitive));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return Result.isFailure-impl(obj) ? null : obj;
    }

    public static final Long getLongOrNull(JsonObject $this$getLongOrNull, String key) {
        Object obj;
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter($this$getLongOrNull, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Result.Companion companion = Result.Companion;
            JsonElement jsonElement = (JsonElement) $this$getLongOrNull.get(key);
            obj = Result.constructor-impl((jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : JsonElementKt.getLongOrNull(jsonPrimitive));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return Result.isFailure-impl(obj) ? null : obj;
    }

    public static final Float getFloatOrNull(JsonObject $this$getFloatOrNull, String key) {
        Object obj;
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter($this$getFloatOrNull, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Result.Companion companion = Result.Companion;
            JsonElement jsonElement = (JsonElement) $this$getFloatOrNull.get(key);
            obj = Result.constructor-impl((jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : JsonElementKt.getFloatOrNull(jsonPrimitive));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return Result.isFailure-impl(obj) ? null : obj;
    }

    public static final Double getDoubleOrNull(JsonObject $this$getDoubleOrNull, String key) {
        Object obj;
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter($this$getDoubleOrNull, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Result.Companion companion = Result.Companion;
            JsonElement jsonElement = (JsonElement) $this$getDoubleOrNull.get(key);
            obj = Result.constructor-impl((jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : JsonElementKt.getDoubleOrNull(jsonPrimitive));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return Result.isFailure-impl(obj) ? null : obj;
    }

    public static final String getStringOrNull(JsonObject $this$getStringOrNull, String key) {
        Object obj;
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter($this$getStringOrNull, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Result.Companion companion = Result.Companion;
            JsonElement jsonElement = (JsonElement) $this$getStringOrNull.get(key);
            obj = Result.constructor-impl((jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : JsonElementKt.getContentOrNull(jsonPrimitive));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return Result.isFailure-impl(obj) ? null : obj;
    }

    public static final Boolean getBooleanOrNull(JsonObject $this$getBooleanOrNull, String key) {
        Object obj;
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter($this$getBooleanOrNull, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Result.Companion companion = Result.Companion;
            JsonElement jsonElement = (JsonElement) $this$getBooleanOrNull.get(key);
            obj = Result.constructor-impl((jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : JsonElementKt.getBooleanOrNull(jsonPrimitive));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return Result.isFailure-impl(obj) ? null : obj;
    }

    public static final JsonObject getJsonObjectOrNull(JsonObject $this$getJsonObjectOrNull, String key) {
        Object obj;
        Intrinsics.checkNotNullParameter($this$getJsonObjectOrNull, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Result.Companion companion = Result.Companion;
            JsonElement jsonElement = (JsonElement) $this$getJsonObjectOrNull.get(key);
            obj = Result.constructor-impl(jsonElement != null ? JsonElementKt.getJsonObject(jsonElement) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return Result.isFailure-impl(obj) ? null : obj;
    }

    public static final /* synthetic */ <T> T parseToObj(String $this$parseToObj) {
        Object obj;
        String str = $this$parseToObj;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            String $this$parseToObj_u24lambda_u240 = $this$parseToObj;
            Json this_$iv = getAdJson();
            SerializersModule serializersModule = this_$iv.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            obj = Result.constructor-impl(this_$iv.decodeFromString(SerializersKt.serializer(serializersModule, (KType) null), $this$parseToObj_u24lambda_u240));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            Throwable it = th2;
            Logger_androidKt.getAdLog().e("JsonExt", it.toString());
        }
        if (Result.isFailure-impl(obj)) {
            return null;
        }
        return (T) obj;
    }

    public static final /* synthetic */ <T> String encodeToString(T t) {
        Object $this$encodeToString_u24lambda_u240;
        try {
            Result.Companion companion = Result.Companion;
            StringFormat $this$encodeToString$iv = getAdJson();
            SerializersModule serializersModule = $this$encodeToString$iv.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            $this$encodeToString_u24lambda_u240 = Result.constructor-impl($this$encodeToString$iv.encodeToString(SerializersKt.serializer(serializersModule, (KType) null), t));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            $this$encodeToString_u24lambda_u240 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl($this$encodeToString_u24lambda_u240);
        if (th2 != null) {
            Throwable it = th2;
            Logger_androidKt.getAdLog().e("JsonExt", it.toString());
        }
        if (Result.isFailure-impl($this$encodeToString_u24lambda_u240)) {
            $this$encodeToString_u24lambda_u240 = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        return (String) $this$encodeToString_u24lambda_u240;
    }

    public static final /* synthetic */ <T> JsonObject toJsonObject(T t) {
        JsonObject $this$toJsonObject_u24lambda_u240;
        try {
            Result.Companion companion = Result.Companion;
            Json $this$encodeToJsonElement$iv = getAdJson();
            SerializersModule serializersModule = $this$encodeToJsonElement$iv.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            $this$toJsonObject_u24lambda_u240 = Result.constructor-impl(JsonElementKt.getJsonObject($this$encodeToJsonElement$iv.encodeToJsonElement(SerializersKt.serializer(serializersModule, (KType) null), t)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            $this$toJsonObject_u24lambda_u240 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl($this$toJsonObject_u24lambda_u240);
        if (th2 != null) {
            Throwable it = th2;
            Logger_androidKt.getAdLog().e("JsonExt", it.toString());
        }
        JsonObject jsonObject = new JsonObject(MapsKt.emptyMap());
        if (Result.isFailure-impl($this$toJsonObject_u24lambda_u240)) {
            $this$toJsonObject_u24lambda_u240 = jsonObject;
        }
        return (JsonObject) $this$toJsonObject_u24lambda_u240;
    }

    public static final /* synthetic */ <T> T getOrDefault(JsonObject $this$getOrDefault, String key, T t) {
        T t2;
        JsonElement element;
        Intrinsics.checkNotNullParameter($this$getOrDefault, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject $this$getOrDefault_u24lambda_u240 = $this$getOrDefault;
            element = (JsonElement) $this$getOrDefault_u24lambda_u240.get(key);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            t2 = (T) Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (element == null) {
            return t;
        }
        Json $this$decodeFromJsonElement$iv = getAdJson();
        SerializersModule serializersModule = $this$decodeFromJsonElement$iv.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        t2 = (T) Result.constructor-impl($this$decodeFromJsonElement$iv.decodeFromJsonElement(SerializersKt.serializer(serializersModule, (KType) null), element));
        Throwable th2 = Result.exceptionOrNull-impl(t2);
        if (th2 != null) {
            Throwable it = th2;
            Logger_androidKt.getAdLog().e("JsonExt", it.toString());
        }
        return Result.isFailure-impl(t2) ? t : t2;
    }

    public static /* synthetic */ Object convertJson$default(Object $this$convertJson_u24default, Object obj, int i, Object obj2) {
        Object obj3;
        String decodeFromJsonElement;
        if ((i & 1) != 0) {
            obj = null;
        }
        if ($this$convertJson_u24default == null) {
            return obj;
        }
        try {
            Result.Companion companion = Result.Companion;
            if (!($this$convertJson_u24default instanceof String)) {
                if (!($this$convertJson_u24default instanceof JsonObject)) {
                    if (!($this$convertJson_u24default instanceof JsonElement)) {
                        Json $this$encodeToJsonElement$iv = getAdJson();
                        JsonElement element = $this$encodeToJsonElement$iv.encodeToJsonElement(SerializersKt.noCompiledSerializer($this$encodeToJsonElement$iv.getSerializersModule(), Reflection.getOrCreateKotlinClass(Object.class)), $this$convertJson_u24default);
                        Intrinsics.reifiedOperationMarker(4, "R");
                        if (Object.class == String.class) {
                            StringFormat $this$encodeToString$iv = getAdJson();
                            $this$encodeToString$iv.getSerializersModule();
                            String encodeToString = $this$encodeToString$iv.encodeToString(JsonElement.Companion.serializer(), element);
                            Intrinsics.reifiedOperationMarker(1, "R");
                            decodeFromJsonElement = encodeToString;
                        } else {
                            Json $this$decodeFromJsonElement$iv = getAdJson();
                            SerializersModule serializersModule = $this$decodeFromJsonElement$iv.getSerializersModule();
                            Intrinsics.reifiedOperationMarker(6, "R");
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                            decodeFromJsonElement = $this$decodeFromJsonElement$iv.decodeFromJsonElement(SerializersKt.serializer(serializersModule, (KType) null), element);
                        }
                    } else {
                        Json $this$decodeFromJsonElement$iv2 = getAdJson();
                        JsonElement json$iv = (JsonElement) $this$convertJson_u24default;
                        SerializersModule serializersModule2 = $this$decodeFromJsonElement$iv2.getSerializersModule();
                        Intrinsics.reifiedOperationMarker(6, "R");
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                        decodeFromJsonElement = $this$decodeFromJsonElement$iv2.decodeFromJsonElement(SerializersKt.serializer(serializersModule2, (KType) null), json$iv);
                    }
                } else {
                    Json $this$decodeFromJsonElement$iv3 = getAdJson();
                    JsonElement json$iv2 = (JsonElement) $this$convertJson_u24default;
                    SerializersModule serializersModule3 = $this$decodeFromJsonElement$iv3.getSerializersModule();
                    Intrinsics.reifiedOperationMarker(6, "R");
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                    decodeFromJsonElement = $this$decodeFromJsonElement$iv3.decodeFromJsonElement(SerializersKt.serializer(serializersModule3, (KType) null), json$iv2);
                }
            } else {
                Json this_$iv = getAdJson();
                String string$iv = (String) $this$convertJson_u24default;
                SerializersModule serializersModule4 = this_$iv.getSerializersModule();
                Intrinsics.reifiedOperationMarker(6, "R");
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                decodeFromJsonElement = this_$iv.decodeFromString(SerializersKt.serializer(serializersModule4, (KType) null), string$iv);
            }
            obj3 = Result.constructor-impl(decodeFromJsonElement);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj3);
        if (th2 != null) {
            Throwable it = th2;
            Logger_androidKt.getAdLog().e("JsonExt", it.toString());
        }
        return Result.isFailure-impl(obj3) ? obj : obj3;
    }

    public static final /* synthetic */ <R> R convertJson(Object $this$convertJson, R r) {
        R r2;
        String decodeFromJsonElement;
        if ($this$convertJson == null) {
            return r;
        }
        try {
            Result.Companion companion = Result.Companion;
            if (!($this$convertJson instanceof String)) {
                if (!($this$convertJson instanceof JsonObject)) {
                    if (!($this$convertJson instanceof JsonElement)) {
                        Json $this$encodeToJsonElement$iv = getAdJson();
                        JsonElement element = $this$encodeToJsonElement$iv.encodeToJsonElement(SerializersKt.noCompiledSerializer($this$encodeToJsonElement$iv.getSerializersModule(), Reflection.getOrCreateKotlinClass(Object.class)), $this$convertJson);
                        Intrinsics.reifiedOperationMarker(4, "R");
                        if (Object.class == String.class) {
                            StringFormat $this$encodeToString$iv = getAdJson();
                            $this$encodeToString$iv.getSerializersModule();
                            String encodeToString = $this$encodeToString$iv.encodeToString(JsonElement.Companion.serializer(), element);
                            Intrinsics.reifiedOperationMarker(1, "R");
                            decodeFromJsonElement = encodeToString;
                        } else {
                            Json $this$decodeFromJsonElement$iv = getAdJson();
                            SerializersModule serializersModule = $this$decodeFromJsonElement$iv.getSerializersModule();
                            Intrinsics.reifiedOperationMarker(6, "R");
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                            decodeFromJsonElement = $this$decodeFromJsonElement$iv.decodeFromJsonElement(SerializersKt.serializer(serializersModule, (KType) null), element);
                        }
                    } else {
                        Json $this$decodeFromJsonElement$iv2 = getAdJson();
                        JsonElement json$iv = (JsonElement) $this$convertJson;
                        SerializersModule serializersModule2 = $this$decodeFromJsonElement$iv2.getSerializersModule();
                        Intrinsics.reifiedOperationMarker(6, "R");
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                        decodeFromJsonElement = $this$decodeFromJsonElement$iv2.decodeFromJsonElement(SerializersKt.serializer(serializersModule2, (KType) null), json$iv);
                    }
                } else {
                    Json $this$decodeFromJsonElement$iv3 = getAdJson();
                    JsonElement json$iv2 = (JsonElement) $this$convertJson;
                    SerializersModule serializersModule3 = $this$decodeFromJsonElement$iv3.getSerializersModule();
                    Intrinsics.reifiedOperationMarker(6, "R");
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                    decodeFromJsonElement = $this$decodeFromJsonElement$iv3.decodeFromJsonElement(SerializersKt.serializer(serializersModule3, (KType) null), json$iv2);
                }
            } else {
                Json this_$iv = getAdJson();
                String string$iv = (String) $this$convertJson;
                SerializersModule serializersModule4 = this_$iv.getSerializersModule();
                Intrinsics.reifiedOperationMarker(6, "R");
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                decodeFromJsonElement = this_$iv.decodeFromString(SerializersKt.serializer(serializersModule4, (KType) null), string$iv);
            }
            Object $this$convertJson_u24lambda_u240 = Result.constructor-impl(decodeFromJsonElement);
            r2 = (R) $this$convertJson_u24lambda_u240;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            r2 = (R) Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(r2);
        if (th2 != null) {
            Throwable it = th2;
            Logger_androidKt.getAdLog().e("JsonExt", it.toString());
        }
        return Result.isFailure-impl(r2) ? r : r2;
    }
}