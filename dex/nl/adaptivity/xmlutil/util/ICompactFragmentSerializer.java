package nl.adaptivity.xmlutil.util;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.XmlSerializer;
import nl.adaptivity.xmlutil.XmlWriter;

/* compiled from: ICompactFragmentSerializer.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J(\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J*\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0007\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lnl/adaptivity/xmlutil/util/ICompactFragmentSerializer;", "Lnl/adaptivity/xmlutil/XmlSerializer;", "Lnl/adaptivity/xmlutil/util/ICompactFragment;", "<init>", "()V", "delegate", "Lnl/adaptivity/xmlutil/util/CompactFragmentSerializer;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serializeXML", "output", "Lnl/adaptivity/xmlutil/XmlWriter;", "isValueChild", "", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserializeXML", "input", "Lnl/adaptivity/xmlutil/XmlReader;", "previousValue", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ICompactFragmentSerializer implements XmlSerializer<ICompactFragment> {
    public static final ICompactFragmentSerializer INSTANCE = new ICompactFragmentSerializer();
    private static final CompactFragmentSerializer delegate = CompactFragmentSerializer.INSTANCE;
    private static final Lazy descriptor$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: nl.adaptivity.xmlutil.util.ICompactFragmentSerializer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SerialDescriptor descriptor_delegate$lambda$0;
            descriptor_delegate$lambda$0 = ICompactFragmentSerializer.descriptor_delegate$lambda$0();
            return descriptor_delegate$lambda$0;
        }
    });

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    private ICompactFragmentSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) descriptor$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor descriptor_delegate$lambda$0() {
        return SerialDescriptorsKt.SerialDescriptor("ICompactFragment", delegate.getDescriptor());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ICompactFragment value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        delegate.serializeImpl$core(encoder, value);
    }

    @Override // nl.adaptivity.xmlutil.XmlSerializationStrategy
    public void serializeXML(Encoder encoder, XmlWriter output, ICompactFragment value, boolean isValueChild) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(value, "value");
        delegate.serializeXMLImpl$core(encoder, output, value, isValueChild);
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ICompactFragment deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return delegate.deserialize(decoder);
    }

    @Override // nl.adaptivity.xmlutil.XmlDeserializationStrategy
    public ICompactFragment deserializeXML(Decoder decoder, XmlReader input, ICompactFragment previousValue, boolean isValueChild) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(input, "input");
        return delegate.deserializeXML(decoder, input, (CompactFragment) previousValue, isValueChild);
    }
}