package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.NamedValueEncoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TreeJsonEncoder.kt */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0002HK\b3\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0014J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\bH\u0016J)\u0010&\u001a\u00020\b\"\u0004\b\u0000\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010*\u001a\u0002H'H\u0016¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010*\u001a\u00020.H\u0014J\u0018\u0010/\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010*\u001a\u000200H\u0014J\u0018\u00101\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010*\u001a\u000202H\u0014J\u0018\u00103\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010*\u001a\u000204H\u0014J \u00105\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001fH\u0014J\u0018\u00108\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010*\u001a\u000209H\u0014J\u0018\u0010:\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u0019H\u0014J\u0018\u0010<\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u001fH\u0014J\u0018\u0010=\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010*\u001a\u00020>H\u0014J\u0010\u0010?\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0011H\u0014J\u0018\u0010@\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010*\u001a\u00020AH\u0014J\u0018\u0010B\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0011H\u0014J\u0018\u0010C\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010*\u001a\u00020DH\u0014J\u0010\u0010E\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010F\u001a\u00020\u0007H&J\u001d\u0010G\u001a\u00020H2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010IJ\u0015\u0010J\u001a\u00020K2\u0006\u0010-\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010LJ\u0018\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0007H&J\u0018\u0010O\u001a\u00020.2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0010\u0010\n\u001a\u00020\u000b8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0001\u0003PQR¨\u0006S"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "Lkotlinx/serialization/internal/NamedValueEncoder;", "Lkotlinx/serialization/json/JsonEncoder;", "json", "Lkotlinx/serialization/json/Json;", "nodeConsumer", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonElement;", "", "(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "getJson", "()Lkotlinx/serialization/json/Json;", "getNodeConsumer", "()Lkotlin/jvm/functions/Function1;", "polymorphicDiscriminator", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "composeName", "parentName", "childName", "elementName", "index", "", "encodeInline", "Lkotlinx/serialization/encoding/Encoder;", "encodeJsonElement", "element", "encodeNotNullMark", "encodeNull", "encodeSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeTaggedBoolean", "tag", "", "encodeTaggedByte", "", "encodeTaggedChar", "", "encodeTaggedDouble", "", "encodeTaggedEnum", "enumDescriptor", "ordinal", "encodeTaggedFloat", "", "encodeTaggedInline", "inlineDescriptor", "encodeTaggedInt", "encodeTaggedLong", "", "encodeTaggedNull", "encodeTaggedShort", "", "encodeTaggedString", "encodeTaggedValue", "", "endEncode", "getCurrent", "inlineUnquotedLiteralEncoder", "kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1;", "inlineUnsignedNumberEncoder", "kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1", "(Ljava/lang/String;)Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1;", "putElement", "key", "shouldEncodeElementDefault", "Lkotlinx/serialization/json/internal/JsonPrimitiveEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeListEncoder;", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalSerializationApi
public abstract class AbstractJsonTreeEncoder extends NamedValueEncoder implements JsonEncoder {
    protected final JsonConfiguration configuration;
    private final Json json;
    private final Function1<JsonElement, Unit> nodeConsumer;
    private String polymorphicDiscriminator;

    public /* synthetic */ AbstractJsonTreeEncoder(Json json, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, function1);
    }

    public abstract JsonElement getCurrent();

    public abstract void putElement(String str, JsonElement jsonElement);

    @Override // kotlinx.serialization.json.JsonEncoder
    public final Json getJson() {
        return this.json;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Function1<JsonElement, Unit> getNodeConsumer() {
        return this.nodeConsumer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AbstractJsonTreeEncoder(Json json, Function1<? super JsonElement, Unit> function1) {
        this.json = json;
        this.nodeConsumer = function1;
        this.configuration = this.json.getConfiguration();
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder, kotlinx.serialization.encoding.CompositeEncoder
    public final SerializersModule getSerializersModule() {
        return this.json.getSerializersModule();
    }

    @Override // kotlinx.serialization.internal.NamedValueEncoder
    protected String elementName(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return JsonNamesMapKt.getJsonElementName(descriptor, this.json, index);
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public void encodeJsonElement(JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        encodeSerializableValue(JsonElementSerializer.INSTANCE, element);
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }

    @Override // kotlinx.serialization.internal.NamedValueEncoder
    protected String composeName(String parentName, String childName) {
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        return childName;
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeNotNullMark() {
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        String tag = getCurrentTagOrNull();
        if (tag == null) {
            this.nodeConsumer.invoke(JsonNull.INSTANCE);
        } else {
            encodeTaggedNull(tag);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedNull(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonNull.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedInt(String tag, int value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Integer.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedByte(String tag, byte value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Byte.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedShort(String tag, short value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Short.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedLong(String tag, long value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Long.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedFloat(String tag, float value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Float.valueOf(value)));
        if (this.configuration.getAllowSpecialFloatingPointValues()) {
            return;
        }
        if (!((Float.isInfinite(value) || Float.isNaN(value)) ? false : true)) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded(Float.valueOf(value), tag, getCurrent().toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializer, T t) {
        boolean requiresTopLevelTag;
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (getCurrentTagOrNull() == null) {
            requiresTopLevelTag = TreeJsonEncoderKt.getRequiresTopLevelTag(WriteModeKt.carrierDescriptor(serializer.getDescriptor(), getSerializersModule()));
            if (requiresTopLevelTag) {
                JsonPrimitiveEncoder $this$encodeSerializableValue_u24lambda_u241 = new JsonPrimitiveEncoder(this.json, this.nodeConsumer);
                $this$encodeSerializableValue_u24lambda_u241.encodeSerializableValue(serializer, t);
                return;
            }
        }
        AbstractJsonTreeEncoder $this$encodePolymorphically$iv = this;
        if (!(serializer instanceof AbstractPolymorphicSerializer) || $this$encodePolymorphically$iv.getJson().getConfiguration().getUseArrayPolymorphism()) {
            serializer.serialize($this$encodePolymorphically$iv, t);
            return;
        }
        AbstractPolymorphicSerializer casted$iv = (AbstractPolymorphicSerializer) serializer;
        String baseClassDiscriminator$iv = PolymorphicKt.classDiscriminator(serializer.getDescriptor(), $this$encodePolymorphically$iv.getJson());
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Any");
        SerializationStrategy actualSerializer$iv = PolymorphicSerializerKt.findPolymorphicSerializer(casted$iv, $this$encodePolymorphically$iv, t);
        PolymorphicKt.validateIfSealed(casted$iv, actualSerializer$iv, baseClassDiscriminator$iv);
        PolymorphicKt.checkKind(actualSerializer$iv.getDescriptor().getKind());
        this.polymorphicDiscriminator = baseClassDiscriminator$iv;
        actualSerializer$iv.serialize($this$encodePolymorphically$iv, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedDouble(String tag, double value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Double.valueOf(value)));
        if (this.configuration.getAllowSpecialFloatingPointValues()) {
            return;
        }
        if (!((Double.isInfinite(value) || Double.isNaN(value)) ? false : true)) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded(Double.valueOf(value), tag, getCurrent().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedBoolean(String tag, boolean value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Boolean.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedChar(String tag, char value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(String.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedString(String tag, String value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(value, "value");
        putElement(tag, JsonElementKt.JsonPrimitive(value));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedEnum(String tag, SerialDescriptor enumDescriptor, int ordinal) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        putElement(tag, JsonElementKt.JsonPrimitive(enumDescriptor.getElementName(ordinal)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedValue(String tag, Object value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(value, "value");
        putElement(tag, JsonElementKt.JsonPrimitive(value.toString()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public Encoder encodeTaggedInline(String tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        return StreamingJsonEncoderKt.isUnsignedNumber(inlineDescriptor) ? inlineUnsignedNumberEncoder(tag) : StreamingJsonEncoderKt.isUnquotedLiteral(inlineDescriptor) ? inlineUnquotedLiteralEncoder(tag, inlineDescriptor) : super.encodeTaggedInline((AbstractJsonTreeEncoder) tag, inlineDescriptor);
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return getCurrentTagOrNull() != null ? super.encodeInline(descriptor) : new JsonPrimitiveEncoder(this.json, this.nodeConsumer).encodeInline(descriptor);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1] */
    private final AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1 inlineUnsignedNumberEncoder(final String tag) {
        return new AbstractEncoder() { // from class: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1
            private final SerializersModule serializersModule;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.serializersModule = AbstractJsonTreeEncoder.this.getJson().getSerializersModule();
            }

            @Override // kotlinx.serialization.encoding.Encoder, kotlinx.serialization.encoding.CompositeEncoder
            public SerializersModule getSerializersModule() {
                return this.serializersModule;
            }

            public final void putUnquotedString(String s) {
                Intrinsics.checkNotNullParameter(s, "s");
                AbstractJsonTreeEncoder.this.putElement(tag, new JsonLiteral(s, false, null, 4, null));
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeInt(int value) {
                putUnquotedString(AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1$$ExternalSyntheticBackport0.m(UInt.constructor-impl(value)));
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeLong(long value) {
                putUnquotedString(AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1$$ExternalSyntheticBackport2.m(ULong.constructor-impl(value)));
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeByte(byte value) {
                putUnquotedString(UByte.toString-impl(UByte.constructor-impl(value)));
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeShort(short value) {
                putUnquotedString(UShort.toString-impl(UShort.constructor-impl(value)));
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1] */
    private final AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1 inlineUnquotedLiteralEncoder(final String tag, final SerialDescriptor inlineDescriptor) {
        return new AbstractEncoder() { // from class: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1
            @Override // kotlinx.serialization.encoding.Encoder, kotlinx.serialization.encoding.CompositeEncoder
            public SerializersModule getSerializersModule() {
                return AbstractJsonTreeEncoder.this.getJson().getSerializersModule();
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                AbstractJsonTreeEncoder.this.putElement(tag, new JsonLiteral(value, false, inlineDescriptor));
            }
        };
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        JsonTreeEncoder encoder;
        AbstractJsonTreeEncoder jsonTreeMapEncoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Function1 consumer = getCurrentTagOrNull() == null ? this.nodeConsumer : new Function1<JsonElement, Unit>() { // from class: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$beginStructure$consumer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonElement jsonElement) {
                invoke2(jsonElement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(JsonElement node) {
                String currentTag;
                Intrinsics.checkNotNullParameter(node, "node");
                AbstractJsonTreeEncoder abstractJsonTreeEncoder = AbstractJsonTreeEncoder.this;
                currentTag = AbstractJsonTreeEncoder.this.getCurrentTag();
                abstractJsonTreeEncoder.putElement(currentTag, node);
            }
        };
        SerialKind kind = descriptor.getKind();
        if (Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE) ? true : kind instanceof PolymorphicKind) {
            encoder = new JsonTreeListEncoder(this.json, consumer);
        } else if (!Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE)) {
            encoder = new JsonTreeEncoder(this.json, consumer);
        } else {
            Json $this$selectMapMode$iv = this.json;
            SerialDescriptor keyDescriptor$iv = WriteModeKt.carrierDescriptor(descriptor.getElementDescriptor(0), $this$selectMapMode$iv.getSerializersModule());
            SerialKind keyKind$iv = keyDescriptor$iv.getKind();
            if ((keyKind$iv instanceof PrimitiveKind) || Intrinsics.areEqual(keyKind$iv, SerialKind.ENUM.INSTANCE)) {
                jsonTreeMapEncoder = new JsonTreeMapEncoder(this.json, consumer);
            } else if ($this$selectMapMode$iv.getConfiguration().getAllowStructuredMapKeys()) {
                jsonTreeMapEncoder = new JsonTreeListEncoder(this.json, consumer);
            } else {
                throw JsonExceptionsKt.InvalidKeyKindException(keyDescriptor$iv);
            }
            encoder = jsonTreeMapEncoder;
        }
        if (this.polymorphicDiscriminator != null) {
            String str = this.polymorphicDiscriminator;
            Intrinsics.checkNotNull(str);
            encoder.putElement(str, JsonElementKt.JsonPrimitive(descriptor.getSerialName()));
            this.polymorphicDiscriminator = null;
        }
        return encoder;
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    protected void endEncode(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.nodeConsumer.invoke(getCurrent());
    }
}