package kntr.app.upper.entrance.bubble2.bean;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: BubbleTiredConfig.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/upper/entrance/bubble2/bean/FansShow.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/upper/entrance/bubble2/bean/FansShow;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class FansShow$$serializer implements GeneratedSerializer<FansShow> {
    public static final FansShow$$serializer INSTANCE = new FansShow$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.upper.entrance.bubble2.bean.FansShow", INSTANCE, 5);
        pluginGeneratedSerialDescriptor.addElement("fan_start", true);
        pluginGeneratedSerialDescriptor.addElement("fan_end", true);
        pluginGeneratedSerialDescriptor.addElement("day", true);
        pluginGeneratedSerialDescriptor.addElement("times", true);
        pluginGeneratedSerialDescriptor.addElement("info", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FansShow$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = FansShow.$childSerializers;
        return new KSerializer[]{IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, lazyArr[4].getValue()};
    }

    public final FansShow deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        int i2;
        List list;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = FansShow.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 1);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 2);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 3);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), (Object) null);
            i5 = decodeIntElement;
            i2 = decodeIntElement4;
            i3 = decodeIntElement3;
            i4 = 31;
            i = decodeIntElement2;
        } else {
            boolean z = true;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            i = 0;
            List list2 = null;
            int i9 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        i6 = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i8 |= 1;
                        continue;
                    case 1:
                        i = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i8 |= 2;
                        break;
                    case 2:
                        i7 = beginStructure.decodeIntElement(serialDescriptor, 2);
                        i8 |= 4;
                        break;
                    case 3:
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i8 |= 8;
                        break;
                    case 4:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list2);
                        i8 |= 16;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i2 = i9;
            list = list2;
            i3 = i7;
            i4 = i8;
            i5 = i6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new FansShow(i4, i5, i, i3, i2, list, null);
    }

    public final void serialize(Encoder encoder, FansShow value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        FansShow.write$Self$entrance_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}