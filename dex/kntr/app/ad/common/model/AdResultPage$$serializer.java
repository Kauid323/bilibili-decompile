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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdLotteryCard.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdResultPage.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdResultPage;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdResultPage$$serializer implements GeneratedSerializer<AdResultPage> {
    public static final AdResultPage$$serializer INSTANCE = new AdResultPage$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdResultPage", INSTANCE, 8);
        pluginGeneratedSerialDescriptor.addElement("bgImage", true);
        pluginGeneratedSerialDescriptor.addElement("logImage", true);
        pluginGeneratedSerialDescriptor.addElement("themeColor", true);
        pluginGeneratedSerialDescriptor.addElement("contentImage", true);
        pluginGeneratedSerialDescriptor.addElement("guideTxt", true);
        pluginGeneratedSerialDescriptor.addElement("promptTxt", true);
        pluginGeneratedSerialDescriptor.addElement("tinyButton", true);
        pluginGeneratedSerialDescriptor.addElement("extraInfo", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdResultPage$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdTinyButton$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdExtraInfo$$serializer.INSTANCE)};
    }

    public final AdResultPage deserialize(Decoder decoder) {
        AdExtraInfo adExtraInfo;
        AdTinyButton adTinyButton;
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        String str7 = null;
        if (beginStructure.decodeSequentially()) {
            adExtraInfo = (AdExtraInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, AdExtraInfo$$serializer.INSTANCE, (Object) null);
            adTinyButton = (AdTinyButton) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, AdTinyButton$$serializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            i = 255;
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            int i3 = 0;
            AdExtraInfo adExtraInfo2 = null;
            AdTinyButton adTinyButton2 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        i2 = 7;
                        break;
                    case 0:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str7);
                        i3 |= 1;
                        i2 = 7;
                        break;
                    case 1:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str10);
                        i3 |= 2;
                        i2 = 7;
                        break;
                    case 2:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str11);
                        i3 |= 4;
                        i2 = 7;
                        break;
                    case 3:
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str12);
                        i3 |= 8;
                        i2 = 7;
                        break;
                    case 4:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str9);
                        i3 |= 16;
                        i2 = 7;
                        continue;
                    case 5:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str8);
                        i3 |= 32;
                        break;
                    case 6:
                        adTinyButton2 = (AdTinyButton) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, AdTinyButton$$serializer.INSTANCE, adTinyButton2);
                        i3 |= 64;
                        break;
                    case 7:
                        adExtraInfo2 = (AdExtraInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, AdExtraInfo$$serializer.INSTANCE, adExtraInfo2);
                        i3 |= 128;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            adExtraInfo = adExtraInfo2;
            adTinyButton = adTinyButton2;
            str = str8;
            i = i3;
            String str13 = str12;
            str2 = str9;
            str3 = str7;
            str4 = str10;
            str5 = str11;
            str6 = str13;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdResultPage(i, str3, str4, str5, str6, str2, str, adTinyButton, adExtraInfo, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdResultPage value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdResultPage.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}