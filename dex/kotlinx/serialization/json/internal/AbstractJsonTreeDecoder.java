package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.NamedValueDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TreeJsonDecoder.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0014J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0017H$J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020!H\u0016J!\u0010\"\u001a\u0002H#\"\u0004\b\u0000\u0010#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%H\u0016¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0018\u0010.\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u0015H\u0014J\u0010\u00101\u001a\u0002022\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0018\u00103\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u0015H\u0014J\u0010\u00105\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u00106\u001a\u0002072\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u00108\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0012\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010;\u001a\u00020<2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010=\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010>\u001a\u00020?2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010@\u001a\u00020A2\u0006\u0010\u001b\u001a\u00020\u0017H\u0004J\u0010\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020\u0017H\u0002J\u0014\u0010D\u001a\u00020E*\u00020A2\u0006\u0010F\u001a\u00020\u0017H\u0002J?\u0010C\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020G*\u00020A2\u0006\u0010C\u001a\u00020\u00172\u0019\u0010H\u001a\u0015\u0012\u0004\u0012\u00020A\u0012\u0006\u0012\u0004\u0018\u0001H#0I¢\u0006\u0002\bJH\u0082\b¢\u0006\u0002\u0010KR\u0010\u0010\b\u001a\u00020\t8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0001\u0003LMN¨\u0006O"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "getJson", "()Lkotlinx/serialization/json/Json;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "composeName", "", "parentName", "childName", "currentElement", "tag", "currentObject", "decodeInline", "Lkotlinx/serialization/encoding/Decoder;", "decodeJsonElement", "decodeNotNullMark", "", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeTaggedBoolean", "decodeTaggedByte", "", "decodeTaggedChar", "", "decodeTaggedDouble", "", "decodeTaggedEnum", "", "enumDescriptor", "decodeTaggedFloat", "", "decodeTaggedInline", "inlineDescriptor", "decodeTaggedInt", "decodeTaggedLong", "", "decodeTaggedNotNullMark", "decodeTaggedNull", "", "decodeTaggedShort", "", "decodeTaggedString", "endStructure", "", "getPrimitiveValue", "Lkotlinx/serialization/json/JsonPrimitive;", "unparsedPrimitive", TreeJsonEncoderKt.PRIMITIVE_TAG, "asLiteral", "Lkotlinx/serialization/json/JsonLiteral;", "type", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeListDecoder;", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbstractJsonTreeDecoder extends NamedValueDecoder implements JsonDecoder {
    protected final JsonConfiguration configuration;
    private final Json json;
    private final JsonElement value;

    public /* synthetic */ AbstractJsonTreeDecoder(Json json, JsonElement jsonElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonElement);
    }

    protected abstract JsonElement currentElement(String str);

    @Override // kotlinx.serialization.json.JsonDecoder
    public Json getJson() {
        return this.json;
    }

    public JsonElement getValue() {
        return this.value;
    }

    private AbstractJsonTreeDecoder(Json json, JsonElement value) {
        this.json = json;
        this.value = value;
        this.configuration = getJson().getConfiguration();
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule getSerializersModule() {
        return getJson().getSerializersModule();
    }

    private final JsonElement currentObject() {
        JsonElement currentElement;
        String it = getCurrentTagOrNull();
        return (it == null || (currentElement = currentElement(it)) == null) ? getValue() : currentElement;
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public JsonElement decodeJsonElement() {
        return currentObject();
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) PolymorphicKt.decodeSerializableValuePolymorphic(this, deserializer);
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    protected String composeName(String parentName, String childName) {
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        return childName;
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        CompositeDecoder jsonTreeMapDecoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonElement currentObject = currentObject();
        SerialKind kind = descriptor.getKind();
        if (!(Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE) ? true : kind instanceof PolymorphicKind)) {
            if (Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE)) {
                Json $this$selectMapMode$iv = getJson();
                SerialDescriptor keyDescriptor$iv = WriteModeKt.carrierDescriptor(descriptor.getElementDescriptor(0), $this$selectMapMode$iv.getSerializersModule());
                SerialKind keyKind$iv = keyDescriptor$iv.getKind();
                if ((keyKind$iv instanceof PrimitiveKind) || Intrinsics.areEqual(keyKind$iv, SerialKind.ENUM.INSTANCE)) {
                    Json json = getJson();
                    if (currentObject instanceof JsonObject) {
                        jsonTreeMapDecoder = new JsonTreeMapDecoder(json, (JsonObject) currentObject);
                    } else {
                        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
                    }
                } else if ($this$selectMapMode$iv.getConfiguration().getAllowStructuredMapKeys()) {
                    Json json2 = getJson();
                    if (currentObject instanceof JsonArray) {
                        jsonTreeMapDecoder = new JsonTreeListDecoder(json2, (JsonArray) currentObject);
                    } else {
                        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonArray.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
                    }
                } else {
                    throw JsonExceptionsKt.InvalidKeyKindException(keyDescriptor$iv);
                }
                return jsonTreeMapDecoder;
            }
            Json json3 = getJson();
            if (currentObject instanceof JsonObject) {
                return new JsonTreeDecoder(json3, (JsonObject) currentObject, null, null, 12, null);
            }
            throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
        }
        Json json4 = getJson();
        if (currentObject instanceof JsonArray) {
            return new JsonTreeListDecoder(json4, (JsonArray) currentObject);
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonArray.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !(currentObject() instanceof JsonNull);
    }

    protected final JsonPrimitive getPrimitiveValue(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement currentElement = currentElement(tag);
        JsonPrimitive jsonPrimitive = currentElement instanceof JsonPrimitive ? (JsonPrimitive) currentElement : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected JsonPrimitive at " + tag + ", found " + currentElement, currentObject().toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public int decodeTaggedEnum(String tag, SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.getJsonNameIndexOrThrow$default(enumDescriptor, getJson(), getPrimitiveValue(tag).getContent(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public Void decodeTaggedNull(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public boolean decodeTaggedNotNullMark(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return currentElement(tag) != JsonNull.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public boolean decodeTaggedBoolean(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive value = getPrimitiveValue(tag);
        if (!getJson().getConfiguration().isLenient()) {
            JsonLiteral literal = asLiteral(value, "boolean");
            if (literal.isString()) {
                throw JsonExceptionsKt.JsonDecodingException(-1, "Boolean literal for key '" + tag + "' should be unquoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", currentObject().toString());
            }
        }
        try {
            Boolean booleanOrNull = JsonElementKt.getBooleanOrNull(value);
            if (booleanOrNull != null) {
                return booleanOrNull.booleanValue();
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            unparsedPrimitive("boolean");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public byte decodeTaggedByte(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive $this$primitive$iv = getPrimitiveValue(tag);
        try {
            int result = JsonElementKt.getInt($this$primitive$iv);
            boolean z = false;
            if (-128 <= result && result <= 127) {
                z = true;
            }
            Byte valueOf = z ? Byte.valueOf((byte) result) : null;
            if (valueOf == null) {
                unparsedPrimitive("byte");
                throw new KotlinNothingValueException();
            }
            return valueOf.byteValue();
        } catch (IllegalArgumentException e) {
            unparsedPrimitive("byte");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public short decodeTaggedShort(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive $this$primitive$iv = getPrimitiveValue(tag);
        try {
            int result = JsonElementKt.getInt($this$primitive$iv);
            boolean z = false;
            if (-32768 <= result && result <= 32767) {
                z = true;
            }
            Short valueOf = z ? Short.valueOf((short) result) : null;
            if (valueOf == null) {
                unparsedPrimitive("short");
                throw new KotlinNothingValueException();
            }
            return valueOf.shortValue();
        } catch (IllegalArgumentException e) {
            unparsedPrimitive("short");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public int decodeTaggedInt(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive $this$primitive$iv = getPrimitiveValue(tag);
        try {
            return JsonElementKt.getInt($this$primitive$iv);
        } catch (IllegalArgumentException e) {
            unparsedPrimitive("int");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public long decodeTaggedLong(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive $this$primitive$iv = getPrimitiveValue(tag);
        try {
            return JsonElementKt.getLong($this$primitive$iv);
        } catch (IllegalArgumentException e) {
            unparsedPrimitive("long");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public float decodeTaggedFloat(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive $this$primitive$iv = getPrimitiveValue(tag);
        try {
            float result = JsonElementKt.getFloat($this$primitive$iv);
            boolean specialFp = getJson().getConfiguration().getAllowSpecialFloatingPointValues();
            if (!specialFp) {
                if (!((Float.isInfinite(result) || Float.isNaN(result)) ? false : true)) {
                    throw JsonExceptionsKt.InvalidFloatingPointDecoded(Float.valueOf(result), tag, currentObject().toString());
                }
            }
            return result;
        } catch (IllegalArgumentException e) {
            unparsedPrimitive("float");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public double decodeTaggedDouble(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive $this$primitive$iv = getPrimitiveValue(tag);
        try {
            double result = JsonElementKt.getDouble($this$primitive$iv);
            boolean specialFp = getJson().getConfiguration().getAllowSpecialFloatingPointValues();
            if (!specialFp) {
                if (!((Double.isInfinite(result) || Double.isNaN(result)) ? false : true)) {
                    throw JsonExceptionsKt.InvalidFloatingPointDecoded(Double.valueOf(result), tag, currentObject().toString());
                }
            }
            return result;
        } catch (IllegalArgumentException e) {
            unparsedPrimitive("double");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public char decodeTaggedChar(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive $this$primitive$iv = getPrimitiveValue(tag);
        try {
            return StringsKt.single($this$primitive$iv.getContent());
        } catch (IllegalArgumentException e) {
            unparsedPrimitive("char");
            throw new KotlinNothingValueException();
        }
    }

    private final <T> T primitive(JsonPrimitive $this$primitive, String primitive, Function1<? super JsonPrimitive, ? extends T> function1) {
        try {
            T invoke = function1.invoke($this$primitive);
            if (invoke != null) {
                return invoke;
            }
            unparsedPrimitive(primitive);
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException e) {
            unparsedPrimitive(primitive);
            throw new KotlinNothingValueException();
        }
    }

    private final Void unparsedPrimitive(String primitive) {
        throw JsonExceptionsKt.JsonDecodingException(-1, "Failed to parse '" + primitive + '\'', currentObject().toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public String decodeTaggedString(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive value = getPrimitiveValue(tag);
        if (!getJson().getConfiguration().isLenient()) {
            JsonLiteral literal = asLiteral(value, "string");
            if (!literal.isString()) {
                throw JsonExceptionsKt.JsonDecodingException(-1, "String literal for key '" + tag + "' should be quoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", currentObject().toString());
            }
        }
        if (value instanceof JsonNull) {
            throw JsonExceptionsKt.JsonDecodingException(-1, "Unexpected 'null' value instead of string literal", currentObject().toString());
        }
        return value.getContent();
    }

    private final JsonLiteral asLiteral(JsonPrimitive $this$asLiteral, String type) {
        JsonLiteral jsonLiteral = $this$asLiteral instanceof JsonLiteral ? (JsonLiteral) $this$asLiteral : null;
        if (jsonLiteral != null) {
            return jsonLiteral;
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, "Unexpected 'null' when " + type + " was expected");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public Decoder decodeTaggedInline(String tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        return StreamingJsonEncoderKt.isUnsignedNumber(inlineDescriptor) ? new JsonDecoderForUnsignedTypes(new StringJsonLexer(getPrimitiveValue(tag).getContent()), getJson()) : super.decodeTaggedInline((AbstractJsonTreeDecoder) tag, inlineDescriptor);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return getCurrentTagOrNull() != null ? super.decodeInline(descriptor) : new JsonPrimitiveDecoder(getJson(), getValue()).decodeInline(descriptor);
    }
}