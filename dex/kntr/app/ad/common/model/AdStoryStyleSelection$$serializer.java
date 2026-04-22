package kntr.app.ad.common.model;

import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AdStoryStyleSelection.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdStoryStyleSelection.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdStoryStyleSelection;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdStoryStyleSelection$$serializer implements GeneratedSerializer<AdStoryStyleSelection> {
    public static final AdStoryStyleSelection$$serializer INSTANCE = new AdStoryStyleSelection$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdStoryStyleSelection", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("showTime", true);
        pluginGeneratedSerialDescriptor.addElement("delayTime", true);
        pluginGeneratedSerialDescriptor.addElement("basicCard", true);
        pluginGeneratedSerialDescriptor.addElement("reinforcedCard", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdStoryStyleSelection$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(AdStorySelectionCard$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdStorySelectionCard$$serializer.INSTANCE)};
    }

    public final AdStoryStyleSelection deserialize(Decoder decoder) {
        int i;
        int i2;
        int i3;
        AdStorySelectionCard adStorySelectionCard;
        AdStorySelectionCard adStorySelectionCard2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 1);
            i = decodeIntElement;
            i3 = 15;
            adStorySelectionCard2 = (AdStorySelectionCard) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, AdStorySelectionCard$$serializer.INSTANCE, (Object) null);
            adStorySelectionCard = (AdStorySelectionCard) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, AdStorySelectionCard$$serializer.INSTANCE, (Object) null);
            i2 = decodeIntElement2;
        } else {
            boolean z = true;
            int i4 = 0;
            int i5 = 0;
            AdStorySelectionCard adStorySelectionCard3 = null;
            AdStorySelectionCard adStorySelectionCard4 = null;
            int i6 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
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
                        adStorySelectionCard3 = (AdStorySelectionCard) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, AdStorySelectionCard$$serializer.INSTANCE, adStorySelectionCard3);
                        i5 |= 4;
                        break;
                    case 3:
                        adStorySelectionCard4 = (AdStorySelectionCard) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, AdStorySelectionCard$$serializer.INSTANCE, adStorySelectionCard4);
                        i5 |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i4;
            i2 = i6;
            i3 = i5;
            adStorySelectionCard = adStorySelectionCard3;
            adStorySelectionCard2 = adStorySelectionCard4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdStoryStyleSelection(i3, i, i2, adStorySelectionCard, adStorySelectionCard2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdStoryStyleSelection value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdStoryStyleSelection.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}