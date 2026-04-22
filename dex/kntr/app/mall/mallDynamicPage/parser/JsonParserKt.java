package kntr.app.mall.mallDynamicPage.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.app.mall.mallDynamicPage.MallDynamicPageViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: JsonParser.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0003*\u00020\bH\u0000\u001a\u001c\u0010\t\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0000\u001a\u001c\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0002\b\u00030\u000ej\u0006\u0012\u0002\b\u0003`\u000fH\u0000\u001a:\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0000¨\u0006\u0015"}, d2 = {"jsonToMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "jsonString", "toMap", "Lkotlinx/serialization/json/JsonObject;", "toAny", "Lkotlinx/serialization/json/JsonElement;", "mapToJsonObject", "map", "mapToJsonArray", "Lkotlinx/serialization/json/JsonArray;", "array", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "calAntlrExec", "vm", "Lkntr/app/mall/mallDynamicPage/MallDynamicPageViewModel;", "ui", "data", "mallDynamicPage_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class JsonParserKt {
    public static final Map<String, Object> jsonToMap(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        JsonObject parseToJsonElement = Json.Default.parseToJsonElement(jsonString);
        if (parseToJsonElement instanceof JsonObject) {
            return toMap(parseToJsonElement);
        }
        throw new IllegalArgumentException("Invalid JSON string");
    }

    public static final Map<String, Object> toMap(JsonObject $this$toMap) {
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        Map $this$mapValues$iv = (Map) $this$toMap;
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Object key = it$iv$iv.getKey();
            JsonElement value = (JsonElement) ((Map.Entry) element$iv$iv$iv).getValue();
            destination$iv$iv.put(key, toAny(value));
        }
        return destination$iv$iv;
    }

    public static final Object toAny(JsonElement $this$toAny) {
        Intrinsics.checkNotNullParameter($this$toAny, "<this>");
        if ($this$toAny instanceof JsonPrimitive) {
            return ((JsonPrimitive) $this$toAny).isString() ? ((JsonPrimitive) $this$toAny).getContent() : JsonElementKt.getBooleanOrNull((JsonPrimitive) $this$toAny) != null ? Boolean.valueOf(JsonElementKt.getBoolean((JsonPrimitive) $this$toAny)) : JsonElementKt.getIntOrNull((JsonPrimitive) $this$toAny) != null ? Integer.valueOf(JsonElementKt.getInt((JsonPrimitive) $this$toAny)) : JsonElementKt.getDoubleOrNull((JsonPrimitive) $this$toAny) != null ? Double.valueOf(JsonElementKt.getDouble((JsonPrimitive) $this$toAny)) : ((JsonPrimitive) $this$toAny).getContent();
        } else if ($this$toAny instanceof JsonObject) {
            return toMap((JsonObject) $this$toAny);
        } else {
            if (!($this$toAny instanceof JsonArray)) {
                throw new NoWhenBranchMatchedException();
            }
            Iterable $this$map$iv = (Iterable) $this$toAny;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                JsonElement it = (JsonElement) item$iv$iv;
                destination$iv$iv.add(toAny(it));
            }
            return (List) destination$iv$iv;
        }
    }

    public static final JsonObject mapToJsonObject(Map<String, ? extends Object> map) {
        JsonPrimitive mapToJsonArray;
        Intrinsics.checkNotNullParameter(map, "map");
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterable $this$associateByTo$iv$iv$iv = map.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Object key = it$iv$iv.getKey();
            Object value = ((Map.Entry) element$iv$iv$iv).getValue();
            if (value instanceof String) {
                mapToJsonArray = JsonElementKt.JsonPrimitive((String) value);
            } else if (value instanceof Integer) {
                mapToJsonArray = JsonElementKt.JsonPrimitive((Number) value);
            } else if (value instanceof Double) {
                mapToJsonArray = JsonElementKt.JsonPrimitive((Number) value);
            } else if (value instanceof Boolean) {
                mapToJsonArray = JsonElementKt.JsonPrimitive((Boolean) value);
            } else if (value instanceof Map) {
                Map tempMap = value instanceof Map ? (Map) value : null;
                if (tempMap == null) {
                    throw new IllegalArgumentException("Unsupported map type:");
                }
                mapToJsonArray = mapToJsonObject(tempMap);
            } else if (!(value instanceof ArrayList)) {
                throw new IllegalArgumentException("Unsupported value type: " + Reflection.getOrCreateKotlinClass(value.getClass()).getSimpleName());
            } else {
                mapToJsonArray = mapToJsonArray((ArrayList) value);
            }
            destination$iv$iv.put(key, (JsonElement) mapToJsonArray);
        }
        return new JsonObject(destination$iv$iv);
    }

    public static final JsonArray mapToJsonArray(ArrayList<?> arrayList) {
        JsonPrimitive mapToJsonArray;
        Intrinsics.checkNotNullParameter(arrayList, "array");
        ArrayList<?> $this$map$iv = arrayList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            if (!(item$iv$iv instanceof String)) {
                if (!(item$iv$iv instanceof Integer)) {
                    if (!(item$iv$iv instanceof Double)) {
                        if (!(item$iv$iv instanceof Boolean)) {
                            if (!(item$iv$iv instanceof Map)) {
                                if (!(item$iv$iv instanceof ArrayList)) {
                                    throw new IllegalArgumentException("Unsupported array element type");
                                }
                                mapToJsonArray = mapToJsonArray((ArrayList) item$iv$iv);
                            } else {
                                Map tempMap = item$iv$iv instanceof Map ? (Map) item$iv$iv : null;
                                if (tempMap == null) {
                                    throw new IllegalArgumentException("Unsupported map type:");
                                }
                                mapToJsonArray = mapToJsonObject(tempMap);
                            }
                        } else {
                            mapToJsonArray = JsonElementKt.JsonPrimitive((Boolean) item$iv$iv);
                        }
                    } else {
                        mapToJsonArray = JsonElementKt.JsonPrimitive((Number) item$iv$iv);
                    }
                } else {
                    mapToJsonArray = JsonElementKt.JsonPrimitive((Number) item$iv$iv);
                }
            } else {
                mapToJsonArray = JsonElementKt.JsonPrimitive((String) item$iv$iv);
            }
            destination$iv$iv.add((JsonElement) mapToJsonArray);
        }
        return new JsonArray((List) destination$iv$iv);
    }

    public static final Map<String, Object> calAntlrExec(MallDynamicPageViewModel vm, Object ui, Map<String, ? extends Object> map) {
        Map map2;
        Intrinsics.checkNotNullParameter(vm, "vm");
        Intrinsics.checkNotNullParameter(map, "data");
        if (ui == null) {
            return MapsKt.emptyMap();
        }
        if (ui instanceof String) {
            map2 = jsonToMap((String) ui);
        } else {
            map2 = (Map) ui;
        }
        Map resultMap = MapsKt.toMutableMap(map2);
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                Object result = vm.getValueBridge().invoke("execAntlr", MapsKt.mapOf(new Pair[]{TuplesKt.to("expression", value), TuplesKt.to("data", map)}));
                if (result == null) {
                    resultMap.remove(key);
                } else {
                    resultMap.put(key, result);
                }
            } else if (value instanceof Map) {
                resultMap.put(key, calAntlrExec(vm, value, map));
            }
        }
        return resultMap;
    }
}