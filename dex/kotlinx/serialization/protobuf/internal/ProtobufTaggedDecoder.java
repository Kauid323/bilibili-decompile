package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

/* compiled from: ProtobufTaggedDecoder.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\u001d\u001a\u00020\fJ\u0016\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010!\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\"\u001a\u00020\tH\u0016J\b\u0010#\u001a\u0004\u0018\u00010$JA\u0010%\u001a\u0004\u0018\u0001H&\"\b\b\u0000\u0010&*\u00020'2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H&0)2\b\u0010*\u001a\u0004\u0018\u0001H&¢\u0006\u0002\u0010+J9\u0010,\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)2\b\u0010*\u001a\u0004\u0018\u0001H&¢\u0006\u0002\u0010+J+\u0010-\u001a\u0002H&\"\u0004\b\u0000\u0010&2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)2\b\u0010*\u001a\u0004\u0018\u0001H&H$¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u000200J\u0016\u00101\u001a\u0002002\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u00102\u001a\u000203J\u0016\u00104\u001a\u0002032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u00105\u001a\u00020\t2\n\u00106\u001a\u00060 j\u0002`7H$J\u0014\u00108\u001a\u00020\u000e2\n\u00106\u001a\u00060 j\u0002`7H$J\u0014\u00109\u001a\u00020\u00112\n\u00106\u001a\u00060 j\u0002`7H$J\u0014\u0010:\u001a\u00020\u00142\n\u00106\u001a\u00060 j\u0002`7H$J\u001c\u0010;\u001a\u00020\f2\n\u00106\u001a\u00060 j\u0002`72\u0006\u0010<\u001a\u00020\u0007H$J\u0014\u0010=\u001a\u00020\u00192\n\u00106\u001a\u00060 j\u0002`7H$J\u001c\u0010>\u001a\u00020\u00022\n\u00106\u001a\u00060 j\u0002`72\u0006\u0010?\u001a\u00020\u0007H\u0014J\u0014\u0010@\u001a\u00020\f2\n\u00106\u001a\u00060 j\u0002`7H$J\u0014\u0010A\u001a\u00020 2\n\u00106\u001a\u00060 j\u0002`7H$J\u0014\u0010B\u001a\u0002002\n\u00106\u001a\u00060 j\u0002`7H$J\u0014\u0010C\u001a\u0002032\n\u00106\u001a\u00060 j\u0002`7H$J\u0010\u0010D\u001a\u00020E2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010F\u001a\u00060 j\u0002`7*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH$¨\u0006G"}, d2 = {"Lkotlinx/serialization/protobuf/internal/ProtobufTaggedDecoder;", "Lkotlinx/serialization/protobuf/internal/ProtobufTaggedBase;", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "()V", "beginStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeBoolean", "", "decodeBooleanElement", "index", "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInline", "decodeInlineElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", "T", "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeSerializableElement", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeTaggedBoolean", "tag", "Lkotlinx/serialization/protobuf/internal/ProtoDesc;", "decodeTaggedByte", "decodeTaggedChar", "decodeTaggedDouble", "decodeTaggedEnum", "enumDescription", "decodeTaggedFloat", "decodeTaggedInline", "inlineDescriptor", "decodeTaggedInt", "decodeTaggedLong", "decodeTaggedShort", "decodeTaggedString", "endStructure", "", "getTag", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ProtobufTaggedDecoder extends ProtobufTaggedBase implements Decoder, CompositeDecoder {
    protected abstract <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy, T t);

    protected abstract boolean decodeTaggedBoolean(long j);

    protected abstract byte decodeTaggedByte(long j);

    protected abstract char decodeTaggedChar(long j);

    protected abstract double decodeTaggedDouble(long j);

    protected abstract int decodeTaggedEnum(long j, SerialDescriptor serialDescriptor);

    protected abstract float decodeTaggedFloat(long j);

    protected abstract int decodeTaggedInt(long j);

    protected abstract long decodeTaggedLong(long j);

    protected abstract short decodeTaggedShort(long j);

    protected abstract String decodeTaggedString(long j);

    protected abstract long getTag(SerialDescriptor serialDescriptor, int i);

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeCollectionSize(SerialDescriptor descriptor) {
        return CompositeDecoder.DefaultImpls.decodeCollectionSize(this, descriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    @ExperimentalSerializationApi
    public <T> T decodeNullableSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy) {
        return (T) Decoder.DefaultImpls.decodeNullableSerializableValue(this, deserializationStrategy);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    @ExperimentalSerializationApi
    public boolean decodeSequentially() {
        return CompositeDecoder.DefaultImpls.decodeSequentially(this);
    }

    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy) {
        return (T) Decoder.DefaultImpls.decodeSerializableValue(this, deserializationStrategy);
    }

    protected Decoder decodeTaggedInline(long tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        ProtobufTaggedDecoder $this$decodeTaggedInline_u24lambda_u240 = this;
        $this$decodeTaggedInline_u24lambda_u240.pushTag(tag);
        return this;
    }

    public boolean decodeNotNullMark() {
        return true;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Void decodeNull() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean decodeBoolean() {
        return decodeTaggedBoolean(popTagOrDefault());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        return decodeTaggedByte(popTagOrDefault());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        return decodeTaggedShort(popTagOrDefault());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        return decodeTaggedInt(popTagOrDefault());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        return decodeTaggedLong(popTagOrDefault());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float decodeFloat() {
        return decodeTaggedFloat(popTagOrDefault());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double decodeDouble() {
        return decodeTaggedDouble(popTagOrDefault());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char decodeChar() {
        return decodeTaggedChar(popTagOrDefault());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final String decodeString() {
        return decodeTaggedString(popTagOrDefault());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return decodeTaggedEnum(popTagOrDefault(), enumDescriptor);
    }

    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean decodeBooleanElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedBoolean(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final byte decodeByteElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedByte(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final short decodeShortElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedShort(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeIntElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInt(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final long decodeLongElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedLong(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final float decodeFloatElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedFloat(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final double decodeDoubleElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedDouble(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final char decodeCharElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedChar(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final String decodeStringElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedString(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final <T> T decodeSerializableElement(SerialDescriptor descriptor, int index, DeserializationStrategy<? extends T> deserializer, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        ProtobufTaggedDecoder this_$iv = this;
        long tag$iv = getTag(descriptor, index);
        this_$iv.pushTag(tag$iv);
        return (T) decodeSerializableValue(deserializer, t);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final <T> T decodeNullableSerializableElement(SerialDescriptor descriptor, int index, DeserializationStrategy<? extends T> deserializer, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        ProtobufTaggedDecoder this_$iv = this;
        long tag$iv = getTag(descriptor, index);
        this_$iv.pushTag(tag$iv);
        if (decodeNotNullMark()) {
            return (T) decodeSerializableValue(deserializer, t);
        }
        return (T) decodeNull();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInline(popTag(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Decoder decodeInlineElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInline(getTag(descriptor, index), descriptor.getElementDescriptor(index));
    }
}