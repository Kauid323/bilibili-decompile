package kntr.app.upper.entrance.bubble2.bean;

import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: BubbleTiredConfig.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/upper/entrance/bubble2/bean/BubbleResourceShow.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/upper/entrance/bubble2/bean/BubbleResourceShow;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class BubbleResourceShow$$serializer implements GeneratedSerializer<BubbleResourceShow> {
    public static final BubbleResourceShow$$serializer INSTANCE = new BubbleResourceShow$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.upper.entrance.bubble2.bean.BubbleResourceShow", INSTANCE, 3);
        pluginGeneratedSerialDescriptor.addElement("day", true);
        pluginGeneratedSerialDescriptor.addElement("times", true);
        pluginGeneratedSerialDescriptor.addElement("info", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BubbleResourceShow$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, IntSerializer.INSTANCE, BubbleResourceShowInfo$$serializer.INSTANCE};
    }

    public final BubbleResourceShow deserialize(Decoder decoder) {
        int i;
        int i2;
        int i3;
        BubbleResourceShowInfo bubbleResourceShowInfo;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            i2 = beginStructure.decodeIntElement(serialDescriptor, 1);
            i = decodeIntElement;
            i3 = 7;
            bubbleResourceShowInfo = (BubbleResourceShowInfo) beginStructure.decodeSerializableElement(serialDescriptor, 2, BubbleResourceShowInfo$$serializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            int i4 = 0;
            int i5 = 0;
            BubbleResourceShowInfo bubbleResourceShowInfo2 = null;
            int i6 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        i4 = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i5 |= 1;
                        break;
                    case 1:
                        i6 = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i5 |= 2;
                        break;
                    case 2:
                        bubbleResourceShowInfo2 = (BubbleResourceShowInfo) beginStructure.decodeSerializableElement(serialDescriptor, 2, BubbleResourceShowInfo$$serializer.INSTANCE, bubbleResourceShowInfo2);
                        i5 |= 4;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i4;
            i2 = i6;
            i3 = i5;
            bubbleResourceShowInfo = bubbleResourceShowInfo2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BubbleResourceShow(i3, i, i2, bubbleResourceShowInfo, null);
    }

    public final void serialize(Encoder encoder, BubbleResourceShow value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BubbleResourceShow.write$Self$entrance_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}