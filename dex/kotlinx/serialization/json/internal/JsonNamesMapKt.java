package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.json.JsonSchemaCacheKt;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;

/* compiled from: JsonNamesMap.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0004*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0003H\u0000\u001a&\u0010\u0017\u001a\u00020\u0004*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a'\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\n*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001aH\u0000¢\u0006\u0002\u0010\u001d\u001a[\u0010\u001e\u001a\u00020\u001f*\u00020\u00102\u0006\u0010 \u001a\u00020\u000e2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b#\u0012\b\b\u0016\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u001f0\"2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030&2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020(0&H\u0080\bø\u0001\u0000\".\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"JsonDeserializationNamesKey", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "", "", "", "getJsonDeserializationNamesKey$annotations", "()V", "getJsonDeserializationNamesKey", "()Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "JsonSerializationNamesKey", "", "getJsonSerializationNamesKey$annotations", "getJsonSerializationNamesKey", "buildDeserializationNamesMap", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "json", "Lkotlinx/serialization/json/Json;", "deserializationNamesMap", "descriptor", "getJsonElementName", "index", "getJsonNameIndex", "name", "getJsonNameIndexOrThrow", "suffix", "namingStrategy", "Lkotlinx/serialization/json/JsonNamingStrategy;", "serializationNamesIndices", "strategy", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonNamingStrategy;)[Ljava/lang/String;", "tryCoerceValue", "", "elementDescriptor", "peekNull", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "consume", "peekString", "Lkotlin/Function0;", "onEnumCoercing", "", "kotlinx-serialization-json"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JsonNamesMapKt {
    private static final DescriptorSchemaCache.Key<Map<String, Integer>> JsonDeserializationNamesKey = new DescriptorSchemaCache.Key<>();
    private static final DescriptorSchemaCache.Key<String[]> JsonSerializationNamesKey = new DescriptorSchemaCache.Key<>();

    public static /* synthetic */ void getJsonDeserializationNamesKey$annotations() {
    }

    public static /* synthetic */ void getJsonSerializationNamesKey$annotations() {
    }

    public static final DescriptorSchemaCache.Key<Map<String, Integer>> getJsonDeserializationNamesKey() {
        return JsonDeserializationNamesKey;
    }

    public static final DescriptorSchemaCache.Key<String[]> getJsonSerializationNamesKey() {
        return JsonSerializationNamesKey;
    }

    private static final void buildDeserializationNamesMap$putOrThrow(Map<String, Integer> map, SerialDescriptor $this_buildDeserializationNamesMap, String name, int index) {
        if (map.containsKey(name)) {
            throw new JsonException("The suggested name '" + name + "' for property " + $this_buildDeserializationNamesMap.getElementName(index) + " is already one of the names for property " + $this_buildDeserializationNamesMap.getElementName(((Number) MapsKt.getValue(map, name)).intValue()) + " in " + $this_buildDeserializationNamesMap);
        }
        map.put(name, Integer.valueOf(index));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Integer> buildDeserializationNamesMap(SerialDescriptor $this$buildDeserializationNamesMap, Json json) {
        String[] names;
        Map builder = new LinkedHashMap();
        JsonNamingStrategy strategy = namingStrategy($this$buildDeserializationNamesMap, json);
        int elementsCount = $this$buildDeserializationNamesMap.getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            Iterable $this$filterIsInstance$iv = $this$buildDeserializationNamesMap.getElementAnnotations(i);
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterIsInstance$iv) {
                if (element$iv$iv instanceof JsonNames) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            JsonNames jsonNames = (JsonNames) CollectionsKt.singleOrNull((List<? extends Object>) destination$iv$iv);
            if (jsonNames != null && (names = jsonNames.names()) != null) {
                for (String str : names) {
                    buildDeserializationNamesMap$putOrThrow(builder, $this$buildDeserializationNamesMap, str, i);
                }
            }
            if (strategy != null) {
                buildDeserializationNamesMap$putOrThrow(builder, $this$buildDeserializationNamesMap, strategy.serialNameForJson($this$buildDeserializationNamesMap, i, $this$buildDeserializationNamesMap.getElementName(i)), i);
            }
        }
        return builder.isEmpty() ? MapsKt.emptyMap() : builder;
    }

    public static final Map<String, Integer> deserializationNamesMap(final Json $this$deserializationNamesMap, final SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter($this$deserializationNamesMap, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return (Map) JsonSchemaCacheKt.getSchemaCache($this$deserializationNamesMap).getOrPut(descriptor, JsonDeserializationNamesKey, new Function0<Map<String, ? extends Integer>>() { // from class: kotlinx.serialization.json.internal.JsonNamesMapKt$deserializationNamesMap$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends Integer> invoke() {
                Map<String, ? extends Integer> buildDeserializationNamesMap;
                buildDeserializationNamesMap = JsonNamesMapKt.buildDeserializationNamesMap(SerialDescriptor.this, $this$deserializationNamesMap);
                return buildDeserializationNamesMap;
            }
        });
    }

    public static final String[] serializationNamesIndices(final SerialDescriptor $this$serializationNamesIndices, Json json, final JsonNamingStrategy strategy) {
        Intrinsics.checkNotNullParameter($this$serializationNamesIndices, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        return (String[]) JsonSchemaCacheKt.getSchemaCache(json).getOrPut($this$serializationNamesIndices, JsonSerializationNamesKey, new Function0<String[]>() { // from class: kotlinx.serialization.json.internal.JsonNamesMapKt$serializationNamesIndices$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String[] invoke() {
                int elementsCount = SerialDescriptor.this.getElementsCount();
                String[] strArr = new String[elementsCount];
                for (int i = 0; i < elementsCount; i++) {
                    String baseName = SerialDescriptor.this.getElementName(i);
                    strArr[i] = strategy.serialNameForJson(SerialDescriptor.this, i, baseName);
                }
                return strArr;
            }
        });
    }

    public static final String getJsonElementName(SerialDescriptor $this$getJsonElementName, Json json, int index) {
        Intrinsics.checkNotNullParameter($this$getJsonElementName, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        JsonNamingStrategy strategy = namingStrategy($this$getJsonElementName, json);
        return strategy == null ? $this$getJsonElementName.getElementName(index) : serializationNamesIndices($this$getJsonElementName, json, strategy)[index];
    }

    public static final JsonNamingStrategy namingStrategy(SerialDescriptor $this$namingStrategy, Json json) {
        Intrinsics.checkNotNullParameter($this$namingStrategy, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        if (Intrinsics.areEqual($this$namingStrategy.getKind(), StructureKind.CLASS.INSTANCE)) {
            return json.getConfiguration().getNamingStrategy();
        }
        return null;
    }

    private static final int getJsonNameIndex$getJsonNameIndexSlowPath(Json $json, SerialDescriptor $this_getJsonNameIndex, String $name) {
        Integer num = deserializationNamesMap($json, $this_getJsonNameIndex).get($name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final int getJsonNameIndex(SerialDescriptor $this$getJsonNameIndex, Json json, String name) {
        Intrinsics.checkNotNullParameter($this$getJsonNameIndex, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        JsonNamingStrategy strategy = namingStrategy($this$getJsonNameIndex, json);
        if (strategy != null) {
            return getJsonNameIndex$getJsonNameIndexSlowPath(json, $this$getJsonNameIndex, name);
        }
        int index = $this$getJsonNameIndex.getElementIndex(name);
        return (index == -3 && json.getConfiguration().getUseAlternativeNames()) ? getJsonNameIndex$getJsonNameIndexSlowPath(json, $this$getJsonNameIndex, name) : index;
    }

    public static /* synthetic */ int getJsonNameIndexOrThrow$default(SerialDescriptor serialDescriptor, Json json, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return getJsonNameIndexOrThrow(serialDescriptor, json, str, str2);
    }

    public static final int getJsonNameIndexOrThrow(SerialDescriptor $this$getJsonNameIndexOrThrow, Json json, String name, String suffix) {
        Intrinsics.checkNotNullParameter($this$getJsonNameIndexOrThrow, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        int index = getJsonNameIndex($this$getJsonNameIndexOrThrow, json, name);
        if (index == -3) {
            throw new SerializationException($this$getJsonNameIndexOrThrow.getSerialName() + " does not contain element with name '" + name + '\'' + suffix);
        }
        return index;
    }

    public static /* synthetic */ boolean tryCoerceValue$default(Json $this$tryCoerceValue_u24default, SerialDescriptor elementDescriptor, Function1 peekNull, Function0 peekString, Function0 onEnumCoercing, int i, Object obj) {
        String enumValue;
        if ((i & 8) != 0) {
            Function0 onEnumCoercing2 = new Function0<Unit>() { // from class: kotlinx.serialization.json.internal.JsonNamesMapKt$tryCoerceValue$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
            onEnumCoercing = onEnumCoercing2;
        }
        Intrinsics.checkNotNullParameter($this$tryCoerceValue_u24default, "<this>");
        Intrinsics.checkNotNullParameter(elementDescriptor, "elementDescriptor");
        Intrinsics.checkNotNullParameter(peekNull, "peekNull");
        Intrinsics.checkNotNullParameter(peekString, "peekString");
        Intrinsics.checkNotNullParameter(onEnumCoercing, "onEnumCoercing");
        if (elementDescriptor.isNullable() || !((Boolean) peekNull.invoke(true)).booleanValue()) {
            if (!Intrinsics.areEqual(elementDescriptor.getKind(), SerialKind.ENUM.INSTANCE) || ((elementDescriptor.isNullable() && ((Boolean) peekNull.invoke(false)).booleanValue()) || (enumValue = (String) peekString.invoke()) == null)) {
                return false;
            }
            int enumIndex = getJsonNameIndex(elementDescriptor, $this$tryCoerceValue_u24default, enumValue);
            if (enumIndex == -3) {
                onEnumCoercing.invoke();
                return true;
            }
            return false;
        }
        return true;
    }

    public static final boolean tryCoerceValue(Json $this$tryCoerceValue, SerialDescriptor elementDescriptor, Function1<? super Boolean, Boolean> peekNull, Function0<String> peekString, Function0<Unit> onEnumCoercing) {
        String enumValue;
        Intrinsics.checkNotNullParameter($this$tryCoerceValue, "<this>");
        Intrinsics.checkNotNullParameter(elementDescriptor, "elementDescriptor");
        Intrinsics.checkNotNullParameter(peekNull, "peekNull");
        Intrinsics.checkNotNullParameter(peekString, "peekString");
        Intrinsics.checkNotNullParameter(onEnumCoercing, "onEnumCoercing");
        if (elementDescriptor.isNullable() || !peekNull.invoke(true).booleanValue()) {
            if (!Intrinsics.areEqual(elementDescriptor.getKind(), SerialKind.ENUM.INSTANCE) || ((elementDescriptor.isNullable() && peekNull.invoke(false).booleanValue()) || (enumValue = peekString.invoke()) == null)) {
                return false;
            }
            int enumIndex = getJsonNameIndex(elementDescriptor, $this$tryCoerceValue, enumValue);
            if (enumIndex == -3) {
                onEnumCoercing.invoke();
                return true;
            }
            return false;
        }
        return true;
    }
}