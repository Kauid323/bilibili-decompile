package im.session.service;

import faceverify.q;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: IMMessageSummaryService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"im/session/service/SummaryPrefix.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lim/session/service/SummaryPrefix;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class SummaryPrefix$$serializer implements GeneratedSerializer<SummaryPrefix> {
    public static final SummaryPrefix$$serializer INSTANCE = new SummaryPrefix$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("im.session.service.SummaryPrefix", INSTANCE, 2);
        pluginGeneratedSerialDescriptor.addElement(q.KEY_RES_9_CONTENT, true);
        pluginGeneratedSerialDescriptor.addElement("prefixType", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SummaryPrefix$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = SummaryPrefix.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, lazyArr[1].getValue()};
    }

    /* renamed from: deserialize */
    public final SummaryPrefix m3371deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        SummaryPrefixType summaryPrefixType;
        String str;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = SummaryPrefix.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            str = beginStructure.decodeStringElement(serialDescriptor, 0);
            summaryPrefixType = (SummaryPrefixType) beginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), (Object) null);
            i2 = 3;
        } else {
            boolean z = true;
            int i3 = 0;
            SummaryPrefixType summaryPrefixType2 = null;
            String str2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i3 |= 1;
                        break;
                    case 1:
                        summaryPrefixType2 = (SummaryPrefixType) beginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), summaryPrefixType2);
                        i3 |= 2;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            summaryPrefixType = summaryPrefixType2;
            str = str2;
            i2 = i3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SummaryPrefix(i2, str, summaryPrefixType, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, SummaryPrefix value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SummaryPrefix.write$Self$session_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}