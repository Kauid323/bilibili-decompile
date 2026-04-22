package kntr.app.digital.preview;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kntr.app.digital.preview.CardNumberGradientColor;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: CardNumberColorUtil.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/digital/preview/CardNumberGradientColor.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/digital/preview/CardNumberGradientColor;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CardNumberGradientColor$$serializer implements GeneratedSerializer<CardNumberGradientColor> {
    public static final int $stable;
    public static final CardNumberGradientColor$$serializer INSTANCE = new CardNumberGradientColor$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.digital.preview.CardNumberGradientColor", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("start_point", true);
        pluginGeneratedSerialDescriptor.addElement("end_point", true);
        pluginGeneratedSerialDescriptor.addElement("colors", true);
        pluginGeneratedSerialDescriptor.addElement("gradients", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CardNumberGradientColor$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = CardNumberGradientColor.$childSerializers;
        return new KSerializer[]{CardNumberGradientColor.OffsetSerializer.INSTANCE, CardNumberGradientColor.OffsetSerializer.INSTANCE, BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[3].getValue())};
    }

    public final CardNumberGradientColor deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        Offset offset;
        Offset offset2;
        List list;
        List list2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = CardNumberGradientColor.$childSerializers;
        Offset offset3 = null;
        if (beginStructure.decodeSequentially()) {
            offset = (Offset) beginStructure.decodeSerializableElement(serialDescriptor, 0, CardNumberGradientColor.OffsetSerializer.INSTANCE, (Object) null);
            Offset offset4 = (Offset) beginStructure.decodeSerializableElement(serialDescriptor, 1, CardNumberGradientColor.OffsetSerializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), (Object) null);
            i = 15;
            offset2 = offset4;
        } else {
            boolean z = true;
            int i2 = 0;
            Offset offset5 = null;
            List list3 = null;
            List list4 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        break;
                    case 0:
                        offset3 = (Offset) beginStructure.decodeSerializableElement(serialDescriptor, 0, CardNumberGradientColor.OffsetSerializer.INSTANCE, offset3);
                        i2 |= 1;
                        break;
                    case 1:
                        offset5 = (Offset) beginStructure.decodeSerializableElement(serialDescriptor, 1, CardNumberGradientColor.OffsetSerializer.INSTANCE, offset5);
                        i2 |= 2;
                        break;
                    case 2:
                        list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list3);
                        i2 |= 4;
                        break;
                    case 3:
                        list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list4);
                        i2 |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i2;
            offset = offset3;
            offset2 = offset5;
            list = list3;
            list2 = list4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CardNumberGradientColor(i, offset, offset2, list, list2, null, null);
    }

    public final void serialize(Encoder encoder, CardNumberGradientColor value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CardNumberGradientColor.write$Self$preview_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}