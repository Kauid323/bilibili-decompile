package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: ProtobufTaggedEncoder.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001EB\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0017J\u001e\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0017J\u0016\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001cJ\u001e\u0010\u001d\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u001cJ\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000fJ\u001e\u0010!\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020#J\u001e\u0010$\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020#J\u0006\u0010%\u001a\u00020\bJ=\u0010&\u001a\u00020\b\"\b\b\u0000\u0010'*\u00020(2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H'0*2\b\u0010\t\u001a\u0004\u0018\u0001H'¢\u0006\u0002\u0010+J7\u0010,\u001a\u00020\b\"\u0004\b\u0000\u0010'2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H'0*2\u0006\u0010\t\u001a\u0002H'¢\u0006\u0002\u0010+J\u000e\u0010-\u001a\u00020\b2\u0006\u0010\t\u001a\u00020.J\u001e\u0010/\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020.J\u000e\u00100\u001a\u00020\b2\u0006\u0010\t\u001a\u000201J\u001e\u00102\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u000201J\u001c\u00103\u001a\u00020\b2\n\u00104\u001a\u00060#j\u0002`52\u0006\u0010\t\u001a\u00020\nH$J\u001c\u00106\u001a\u00020\b2\n\u00104\u001a\u00060#j\u0002`52\u0006\u0010\t\u001a\u00020\u0011H$J\u001c\u00107\u001a\u00020\b2\n\u00104\u001a\u00060#j\u0002`52\u0006\u0010\t\u001a\u00020\u0014H$J\u001c\u00108\u001a\u00020\b2\n\u00104\u001a\u00060#j\u0002`52\u0006\u0010\t\u001a\u00020\u0017H$J$\u00109\u001a\u00020\b2\n\u00104\u001a\u00060#j\u0002`52\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010:\u001a\u00020\u000fH$J\u001c\u0010;\u001a\u00020\b2\n\u00104\u001a\u00060#j\u0002`52\u0006\u0010\t\u001a\u00020\u001cH$J\u001c\u0010<\u001a\u00020\u00022\n\u00104\u001a\u00060#j\u0002`52\u0006\u0010=\u001a\u00020\rH\u0014J\u001c\u0010>\u001a\u00020\b2\n\u00104\u001a\u00060#j\u0002`52\u0006\u0010\t\u001a\u00020\u000fH$J\u001c\u0010?\u001a\u00020\b2\n\u00104\u001a\u00060#j\u0002`52\u0006\u0010\t\u001a\u00020#H$J\u001c\u0010@\u001a\u00020\b2\n\u00104\u001a\u00060#j\u0002`52\u0006\u0010\t\u001a\u00020.H$J\u001c\u0010A\u001a\u00020\b2\n\u00104\u001a\u00060#j\u0002`52\u0006\u0010\t\u001a\u000201H$J\u0010\u0010B\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u000e\u0010C\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010D\u001a\u00060#j\u0002`5*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH$R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lkotlinx/serialization/protobuf/internal/ProtobufTaggedEncoder;", "Lkotlinx/serialization/protobuf/internal/ProtobufTaggedBase;", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "()V", "nullableMode", "Lkotlinx/serialization/protobuf/internal/ProtobufTaggedEncoder$NullableMode;", "encodeBoolean", "", "value", "", "encodeBooleanElement", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "encodeByte", "", "encodeByteElement", "encodeChar", "", "encodeCharElement", "encodeDouble", "", "encodeDoubleElement", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeFloatElement", "encodeInline", "encodeInlineElement", "encodeInt", "encodeIntElement", "encodeLong", "", "encodeLongElement", "encodeNull", "encodeNullableSerializableElement", "T", "", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableElement", "encodeShort", "", "encodeShortElement", "encodeString", "", "encodeStringElement", "encodeTaggedBoolean", "tag", "Lkotlinx/serialization/protobuf/internal/ProtoDesc;", "encodeTaggedByte", "encodeTaggedChar", "encodeTaggedDouble", "encodeTaggedEnum", "ordinal", "encodeTaggedFloat", "encodeTaggedInline", "inlineDescriptor", "encodeTaggedInt", "encodeTaggedLong", "encodeTaggedShort", "encodeTaggedString", "endEncode", "endStructure", "getTag", "NullableMode", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ProtobufTaggedEncoder extends ProtobufTaggedBase implements Encoder, CompositeEncoder {
    private NullableMode nullableMode = NullableMode.NOT_NULL;

    /* compiled from: ProtobufTaggedEncoder.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/serialization/protobuf/internal/ProtobufTaggedEncoder$NullableMode;", "", "(Ljava/lang/String;I)V", "ACCEPTABLE", "OPTIONAL", "COLLECTION", "NOT_NULL", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private enum NullableMode {
        ACCEPTABLE,
        OPTIONAL,
        COLLECTION,
        NOT_NULL
    }

    /* compiled from: ProtobufTaggedEncoder.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NullableMode.values().length];
            try {
                iArr[NullableMode.OPTIONAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NullableMode.COLLECTION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NullableMode.NOT_NULL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    protected abstract void encodeTaggedBoolean(long j, boolean z);

    protected abstract void encodeTaggedByte(long j, byte b);

    protected abstract void encodeTaggedChar(long j, char c);

    protected abstract void encodeTaggedDouble(long j, double d);

    protected abstract void encodeTaggedEnum(long j, SerialDescriptor serialDescriptor, int i);

    protected abstract void encodeTaggedFloat(long j, float f);

    protected abstract void encodeTaggedInt(long j, int i);

    protected abstract void encodeTaggedLong(long j, long j2);

    protected abstract void encodeTaggedShort(long j, short s);

    protected abstract void encodeTaggedString(long j, String str);

    protected abstract long getTag(SerialDescriptor serialDescriptor, int i);

    public CompositeEncoder beginCollection(SerialDescriptor descriptor, int collectionSize) {
        return Encoder.DefaultImpls.beginCollection(this, descriptor, collectionSize);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @ExperimentalSerializationApi
    public void encodeNotNullMark() {
        Encoder.DefaultImpls.encodeNotNullMark(this);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @ExperimentalSerializationApi
    public <T> void encodeNullableSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        Encoder.DefaultImpls.encodeNullableSerializableValue(this, serializationStrategy, t);
    }

    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        Encoder.DefaultImpls.encodeSerializableValue(this, serializationStrategy, t);
    }

    @ExperimentalSerializationApi
    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int index) {
        return CompositeEncoder.DefaultImpls.shouldEncodeElementDefault(this, descriptor, index);
    }

    protected Encoder encodeTaggedInline(long tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        ProtobufTaggedEncoder $this$encodeTaggedInline_u24lambda_u240 = this;
        $this$encodeTaggedInline_u24lambda_u240.pushTag(tag);
        return this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeNull() {
        String message;
        if (this.nullableMode != NullableMode.ACCEPTABLE) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.nullableMode.ordinal()]) {
                case 1:
                    message = "'null' is not supported for optional properties in ProtoBuf";
                    break;
                case 2:
                    message = "'null' is not supported for collection types in ProtoBuf";
                    break;
                case 3:
                    message = "'null' is not allowed for not-null properties";
                    break;
                default:
                    message = "'null' is not supported in ProtoBuf";
                    break;
            }
            throw new SerializationException(message);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeBoolean(boolean value) {
        encodeTaggedBoolean(popTagOrDefault(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeByte(byte value) {
        encodeTaggedByte(popTagOrDefault(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeShort(short value) {
        encodeTaggedShort(popTagOrDefault(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeInt(int value) {
        encodeTaggedInt(popTagOrDefault(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeLong(long value) {
        encodeTaggedLong(popTagOrDefault(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeFloat(float value) {
        encodeTaggedFloat(popTagOrDefault(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeDouble(double value) {
        encodeTaggedDouble(popTagOrDefault(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeChar(char value) {
        encodeTaggedChar(popTagOrDefault(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        encodeTaggedString(popTagOrDefault(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeEnum(SerialDescriptor enumDescriptor, int index) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        encodeTaggedEnum(popTagOrDefault(), enumDescriptor, index);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.stackSize >= 0) {
            popTag();
        }
        endEncode(descriptor);
    }

    protected void endEncode(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeBooleanElement(SerialDescriptor descriptor, int index, boolean value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedBoolean(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeByteElement(SerialDescriptor descriptor, int index, byte value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedByte(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeShortElement(SerialDescriptor descriptor, int index, short value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedShort(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeIntElement(SerialDescriptor descriptor, int index, int value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedInt(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeLongElement(SerialDescriptor descriptor, int index, long value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedLong(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeFloatElement(SerialDescriptor descriptor, int index, float value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedFloat(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeDoubleElement(SerialDescriptor descriptor, int index, double value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedDouble(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeCharElement(SerialDescriptor descriptor, int index, char value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedChar(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeStringElement(SerialDescriptor descriptor, int index, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        encodeTaggedString(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final <T> void encodeSerializableElement(SerialDescriptor descriptor, int index, SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.nullableMode = NullableMode.NOT_NULL;
        pushTag(getTag(descriptor, index));
        encodeSerializableValue(serializer, t);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final <T> void encodeNullableSerializableElement(SerialDescriptor descriptor, int index, SerializationStrategy<? super T> serializer, T t) {
        NullableMode nullableMode;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        SerialKind elementKind = descriptor.getElementDescriptor(index).getKind();
        if (descriptor.isElementOptional(index)) {
            nullableMode = NullableMode.OPTIONAL;
        } else if (Intrinsics.areEqual(elementKind, StructureKind.MAP.INSTANCE) || Intrinsics.areEqual(elementKind, StructureKind.LIST.INSTANCE)) {
            nullableMode = NullableMode.COLLECTION;
        } else {
            nullableMode = NullableMode.ACCEPTABLE;
        }
        this.nullableMode = nullableMode;
        pushTag(getTag(descriptor, index));
        encodeNullableSerializableValue(serializer, t);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return encodeTaggedInline(popTag(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public Encoder encodeInlineElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return encodeTaggedInline(getTag(descriptor, index), descriptor.getElementDescriptor(index));
    }
}