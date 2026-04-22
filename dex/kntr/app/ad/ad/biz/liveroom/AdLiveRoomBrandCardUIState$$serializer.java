package kntr.app.ad.ad.biz.liveroom;

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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: BaseLiveRoomUIState.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/ad/biz/liveroom/AdLiveRoomBrandCardUIState.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/ad/biz/liveroom/AdLiveRoomBrandCardUIState;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "liveroom_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdLiveRoomBrandCardUIState$$serializer implements GeneratedSerializer<AdLiveRoomBrandCardUIState> {
    public static final int $stable;
    public static final AdLiveRoomBrandCardUIState$$serializer INSTANCE = new AdLiveRoomBrandCardUIState$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.ad.biz.liveroom.AdLiveRoomBrandCardUIState", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("coverState", false);
        pluginGeneratedSerialDescriptor.addElement("buttonState", false);
        pluginGeneratedSerialDescriptor.addElement("titleState", false);
        pluginGeneratedSerialDescriptor.addElement("adTagState", false);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private AdLiveRoomBrandCardUIState$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(AdLiveBrandCardCoverState$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdLiveBrandCardButtonState$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdLiveBrandCardTitleState$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdLiveBrandCardTagViewState$$serializer.INSTANCE)};
    }

    public final AdLiveRoomBrandCardUIState deserialize(Decoder decoder) {
        int i;
        AdLiveBrandCardCoverState adLiveBrandCardCoverState;
        AdLiveBrandCardButtonState adLiveBrandCardButtonState;
        AdLiveBrandCardTitleState adLiveBrandCardTitleState;
        AdLiveBrandCardTagViewState adLiveBrandCardTagViewState;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        AdLiveBrandCardCoverState adLiveBrandCardCoverState2 = null;
        if (beginStructure.decodeSequentially()) {
            AdLiveBrandCardButtonState adLiveBrandCardButtonState2 = (AdLiveBrandCardButtonState) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, AdLiveBrandCardButtonState$$serializer.INSTANCE, (Object) null);
            AdLiveBrandCardTagViewState adLiveBrandCardTagViewState2 = (AdLiveBrandCardTagViewState) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, AdLiveBrandCardTagViewState$$serializer.INSTANCE, (Object) null);
            adLiveBrandCardCoverState = (AdLiveBrandCardCoverState) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, AdLiveBrandCardCoverState$$serializer.INSTANCE, (Object) null);
            i = 15;
            adLiveBrandCardTagViewState = adLiveBrandCardTagViewState2;
            adLiveBrandCardTitleState = (AdLiveBrandCardTitleState) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, AdLiveBrandCardTitleState$$serializer.INSTANCE, (Object) null);
            adLiveBrandCardButtonState = adLiveBrandCardButtonState2;
        } else {
            boolean z = true;
            i = 0;
            AdLiveBrandCardButtonState adLiveBrandCardButtonState3 = null;
            AdLiveBrandCardTitleState adLiveBrandCardTitleState2 = null;
            AdLiveBrandCardTagViewState adLiveBrandCardTagViewState3 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        break;
                    case 0:
                        adLiveBrandCardCoverState2 = (AdLiveBrandCardCoverState) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, AdLiveBrandCardCoverState$$serializer.INSTANCE, adLiveBrandCardCoverState2);
                        i |= 1;
                        break;
                    case 1:
                        adLiveBrandCardButtonState3 = (AdLiveBrandCardButtonState) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, AdLiveBrandCardButtonState$$serializer.INSTANCE, adLiveBrandCardButtonState3);
                        i |= 2;
                        break;
                    case 2:
                        adLiveBrandCardTitleState2 = (AdLiveBrandCardTitleState) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, AdLiveBrandCardTitleState$$serializer.INSTANCE, adLiveBrandCardTitleState2);
                        i |= 4;
                        break;
                    case 3:
                        adLiveBrandCardTagViewState3 = (AdLiveBrandCardTagViewState) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, AdLiveBrandCardTagViewState$$serializer.INSTANCE, adLiveBrandCardTagViewState3);
                        i |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            adLiveBrandCardCoverState = adLiveBrandCardCoverState2;
            adLiveBrandCardButtonState = adLiveBrandCardButtonState3;
            adLiveBrandCardTitleState = adLiveBrandCardTitleState2;
            adLiveBrandCardTagViewState = adLiveBrandCardTagViewState3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdLiveRoomBrandCardUIState(i, adLiveBrandCardCoverState, adLiveBrandCardButtonState, adLiveBrandCardTitleState, adLiveBrandCardTagViewState, null);
    }

    public final void serialize(Encoder encoder, AdLiveRoomBrandCardUIState value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdLiveRoomBrandCardUIState.write$Self$liveroom_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}