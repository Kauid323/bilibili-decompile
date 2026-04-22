package im.session.service;

import faceverify.q;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: IMMessageSummaryService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"im/session/service/Summary.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lim/session/service/Summary;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class Summary$$serializer implements GeneratedSerializer<Summary> {
    public static final Summary$$serializer INSTANCE = new Summary$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("im.session.service.Summary", INSTANCE, 3);
        pluginGeneratedSerialDescriptor.addElement("prefix", true);
        pluginGeneratedSerialDescriptor.addElement(q.KEY_RES_9_CONTENT, true);
        pluginGeneratedSerialDescriptor.addElement("contentForDisplay", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Summary$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{SummaryPrefix$$serializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    /* renamed from: deserialize */
    public final Summary m3370deserialize(Decoder decoder) {
        int i2;
        SummaryPrefix summaryPrefix;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        SummaryPrefix summaryPrefix2 = null;
        if (beginStructure.decodeSequentially()) {
            str = beginStructure.decodeStringElement(serialDescriptor, 1);
            summaryPrefix = (SummaryPrefix) beginStructure.decodeSerializableElement(serialDescriptor, 0, SummaryPrefix$$serializer.INSTANCE, (Object) null);
            i2 = 7;
            str2 = beginStructure.decodeStringElement(serialDescriptor, 2);
        } else {
            boolean z = true;
            i2 = 0;
            String str3 = null;
            String str4 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        summaryPrefix2 = (SummaryPrefix) beginStructure.decodeSerializableElement(serialDescriptor, 0, SummaryPrefix$$serializer.INSTANCE, summaryPrefix2);
                        i2 |= 1;
                        break;
                    case 1:
                        str3 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            summaryPrefix = summaryPrefix2;
            str = str3;
            str2 = str4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new Summary(i2, summaryPrefix, str, str2, null);
    }

    public final void serialize(Encoder encoder, Summary value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        Summary.write$Self$session_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}