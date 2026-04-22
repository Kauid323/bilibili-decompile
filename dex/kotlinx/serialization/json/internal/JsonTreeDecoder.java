package kotlinx.serialization.json.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonSchemaCacheKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TreeJsonDecoder.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\tH\u0016J \u0010\u0016\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0014J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "polyDiscriminator", "", "polyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "forceNull", "", "position", "", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "absenceIsNull", "descriptor", "index", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "coerceInputValue", "tag", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "decodeElementIndex", "decodeNotNullMark", "elementName", "endStructure", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class JsonTreeDecoder extends AbstractJsonTreeDecoder {
    private boolean forceNull;
    private final SerialDescriptor polyDescriptor;
    private final String polyDiscriminator;
    private int position;
    private final JsonObject value;

    public /* synthetic */ JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonObject, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : serialDescriptor);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public JsonObject getValue() {
        return this.value;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeDecoder(Json json, JsonObject value, String polyDiscriminator, SerialDescriptor polyDescriptor) {
        super(json, value, null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.polyDiscriminator = polyDiscriminator;
        this.polyDescriptor = polyDescriptor;
    }

    private final boolean coerceInputValue(SerialDescriptor descriptor, int index, String tag) {
        Json $this$tryCoerceValue_u24default$iv = getJson();
        SerialDescriptor elementDescriptor$iv = descriptor.getElementDescriptor(index);
        if (!elementDescriptor$iv.isNullable()) {
            boolean it = currentElement(tag) instanceof JsonNull;
            if (it) {
                return true;
            }
        }
        if (Intrinsics.areEqual(elementDescriptor$iv.getKind(), SerialKind.ENUM.INSTANCE)) {
            if (elementDescriptor$iv.isNullable()) {
                boolean it2 = currentElement(tag) instanceof JsonNull;
                if (it2) {
                    return false;
                }
            }
            JsonElement currentElement = currentElement(tag);
            JsonPrimitive jsonPrimitive = currentElement instanceof JsonPrimitive ? (JsonPrimitive) currentElement : null;
            String contentOrNull = jsonPrimitive != null ? JsonElementKt.getContentOrNull(jsonPrimitive) : null;
            if (contentOrNull == null) {
                return false;
            }
            String enumValue$iv = contentOrNull;
            int enumIndex$iv = JsonNamesMapKt.getJsonNameIndex(elementDescriptor$iv, $this$tryCoerceValue_u24default$iv, enumValue$iv);
            if (enumIndex$iv == -3) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        while (this.position < descriptor.getElementsCount()) {
            int i = this.position;
            this.position = i + 1;
            String name = getTag(descriptor, i);
            int index = this.position - 1;
            this.forceNull = false;
            if (getValue().containsKey((Object) name) || absenceIsNull(descriptor, index)) {
                if (!this.configuration.getCoerceInputValues() || !coerceInputValue(descriptor, index, name)) {
                    return index;
                }
            }
        }
        return -1;
    }

    private final boolean absenceIsNull(SerialDescriptor descriptor, int index) {
        this.forceNull = (getJson().getConfiguration().getExplicitNulls() || descriptor.isElementOptional(index) || !descriptor.getElementDescriptor(index).isNullable()) ? false : true;
        return this.forceNull;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !this.forceNull && super.decodeNotNullMark();
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    protected String elementName(SerialDescriptor descriptor, int index) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonNamingStrategy strategy = JsonNamesMapKt.namingStrategy(descriptor, getJson());
        String baseName = descriptor.getElementName(index);
        if (strategy != null || (this.configuration.getUseAlternativeNames() && !getValue().keySet().contains(baseName))) {
            Map deserializationNamesMap = JsonNamesMapKt.deserializationNamesMap(getJson(), descriptor);
            Iterator<T> it = getValue().keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Integer num = deserializationNamesMap.get((String) obj);
                if (num != null && num.intValue() == index) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            String it2 = (String) obj;
            if (it2 != null) {
                return it2;
            }
            String fallbackName = strategy != null ? strategy.serialNameForJson(descriptor, index, baseName) : null;
            return fallbackName == null ? baseName : fallbackName;
        }
        return baseName;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    protected JsonElement currentElement(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return (JsonElement) MapsKt.getValue(getValue(), tag);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return descriptor == this.polyDescriptor ? this : super.beginStructure(descriptor);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor descriptor) {
        Set names;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.configuration.getIgnoreUnknownKeys() || (descriptor.getKind() instanceof PolymorphicKind)) {
            return;
        }
        JsonNamingStrategy strategy = JsonNamesMapKt.namingStrategy(descriptor, getJson());
        if (strategy == null && !this.configuration.getUseAlternativeNames()) {
            names = JsonInternalDependenciesKt.jsonCachedSerialNames(descriptor);
        } else if (strategy != null) {
            names = JsonNamesMapKt.deserializationNamesMap(getJson(), descriptor).keySet();
        } else {
            Set<String> jsonCachedSerialNames = JsonInternalDependenciesKt.jsonCachedSerialNames(descriptor);
            Map map = (Map) JsonSchemaCacheKt.getSchemaCache(getJson()).get(descriptor, JsonNamesMapKt.getJsonDeserializationNamesKey());
            Set keySet = map != null ? map.keySet() : null;
            if (keySet == null) {
                keySet = SetsKt.emptySet();
            }
            names = SetsKt.plus((Set) jsonCachedSerialNames, (Iterable) keySet);
        }
        for (String key : getValue().keySet()) {
            if (!names.contains(key) && !Intrinsics.areEqual(key, this.polyDiscriminator)) {
                throw JsonExceptionsKt.UnknownKeyException(key, getValue().toString());
            }
        }
    }
}