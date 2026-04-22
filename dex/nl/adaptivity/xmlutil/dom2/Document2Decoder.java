package nl.adaptivity.xmlutil.dom2;

import javax.xml.namespace.QName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.modules.SerializersModule;
import nl.adaptivity.xmlutil.util.impl.CreateDocumentKt;

/* compiled from: ElementSerializer.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0096\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0017H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J\t\u0010\u001f\u001a\u00020\u000fH\u0097\u0001J\u000b\u0010 \u001a\u0004\u0018\u00010!H\u0097\u0001J*\u0010\"\u001a\u0004\u0018\u0001H#\"\b\b\u0000\u0010#*\u00020$2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H#0&H\u0097\u0001¢\u0006\u0002\u0010'J(\u0010(\u001a\u0002H#\"\n\b\u0000\u0010#*\u0004\u0018\u00010$2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0&H\u0096\u0001¢\u0006\u0002\u0010'J\t\u0010)\u001a\u00020*H\u0096\u0001J\t\u0010+\u001a\u00020,H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0012\u0010-\u001a\u00020.X\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/Document2Decoder;", "Lkotlinx/serialization/encoding/Decoder;", "delegate", "document", "Lnl/adaptivity/xmlutil/dom2/Document;", "<init>", "(Lkotlinx/serialization/encoding/Decoder;Lnl/adaptivity/xmlutil/dom2/Document;)V", "(Lkotlinx/serialization/encoding/Decoder;)V", "getDocument", "()Lnl/adaptivity/xmlutil/dom2/Document;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeBoolean", "", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeEnum", "", "enumDescriptor", "decodeFloat", "", "decodeInline", "decodeInt", "decodeLong", "", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableValue", "T", "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableValue", "decodeShort", "", "decodeString", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Document2Decoder implements Decoder {
    private final Decoder delegate;
    private final Document document;

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean decodeBoolean() {
        return this.delegate.decodeBoolean();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public byte decodeByte() {
        return this.delegate.decodeByte();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public char decodeChar() {
        return this.delegate.decodeChar();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public double decodeDouble() {
        return this.delegate.decodeDouble();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return this.delegate.decodeEnum(enumDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public float decodeFloat() {
        return this.delegate.decodeFloat();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.delegate.decodeInline(descriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int decodeInt() {
        return this.delegate.decodeInt();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public long decodeLong() {
        return this.delegate.decodeLong();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    @ExperimentalSerializationApi
    public boolean decodeNotNullMark() {
        return this.delegate.decodeNotNullMark();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    @ExperimentalSerializationApi
    public Void decodeNull() {
        return this.delegate.decodeNull();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    @ExperimentalSerializationApi
    public <T> T decodeNullableSerializableValue(DeserializationStrategy<? extends T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) this.delegate.decodeNullableSerializableValue(deserializer);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) this.delegate.decodeSerializableValue(deserializer);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public short decodeShort() {
        return this.delegate.decodeShort();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        return this.delegate.decodeString();
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule getSerializersModule() {
        return this.delegate.getSerializersModule();
    }

    public Document2Decoder(Decoder delegate, Document document) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(document, "document");
        this.delegate = delegate;
        this.document = document;
    }

    public final Document getDocument() {
        return this.document;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Document2Decoder(Decoder delegate) {
        this(delegate, $this$_init__u24lambda_u241);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Document $this$_init__u24lambda_u241 = CreateDocumentKt.createDocument(new QName("dummy"));
        Element it = $this$_init__u24lambda_u241.getDocumentElement();
        if (it != null) {
            $this$_init__u24lambda_u241.removeChild(it);
        }
        Unit unit = Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return new Document2CompositeDecoder(this.delegate.beginStructure(descriptor), this.document);
    }
}