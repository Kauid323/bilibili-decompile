package kntr.app.ad.common.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdRcmdReasonStyle.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdRcmdReasonStyle.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdRcmdReasonStyle;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdRcmdReasonStyle$$serializer implements GeneratedSerializer<AdRcmdReasonStyle> {
    public static final AdRcmdReasonStyle$$serializer INSTANCE = new AdRcmdReasonStyle$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdRcmdReasonStyle", INSTANCE, 19);
        pluginGeneratedSerialDescriptor.addElement("text", true);
        pluginGeneratedSerialDescriptor.addElement("textColor", true);
        pluginGeneratedSerialDescriptor.addElement("textColorNight", true);
        pluginGeneratedSerialDescriptor.addElement("borderColor", true);
        pluginGeneratedSerialDescriptor.addElement("borderColorNight", true);
        pluginGeneratedSerialDescriptor.addElement("bgColor", true);
        pluginGeneratedSerialDescriptor.addElement("bgColorNight", true);
        pluginGeneratedSerialDescriptor.addElement("iconUrl", true);
        pluginGeneratedSerialDescriptor.addElement("iconNightUrl", true);
        pluginGeneratedSerialDescriptor.addElement("iconWidth", true);
        pluginGeneratedSerialDescriptor.addElement("iconHeight", true);
        pluginGeneratedSerialDescriptor.addElement("rightIconType", true);
        pluginGeneratedSerialDescriptor.addElement("iconBgUrl", true);
        pluginGeneratedSerialDescriptor.addElement("textLen", true);
        pluginGeneratedSerialDescriptor.addElement("bgStyle", true);
        pluginGeneratedSerialDescriptor.addElement("uri", true);
        pluginGeneratedSerialDescriptor.addElement("event", true);
        pluginGeneratedSerialDescriptor.addElement("eventV2", true);
        pluginGeneratedSerialDescriptor.addElement("leftIconType", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdRcmdReasonStyle$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final AdRcmdReasonStyle deserialize(Decoder decoder) {
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str12;
        String str13;
        String str14;
        String str15;
        int i7;
        String str16;
        String str17;
        String str18;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 9);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 10);
            i6 = beginStructure.decodeIntElement(serialDescriptor, 11);
            String str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 13);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 14);
            String str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, (Object) null);
            String str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, (Object) null);
            String str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, (Object) null);
            i = 524287;
            str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            str11 = str20;
            str6 = str21;
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, (Object) null);
            str3 = str23;
            i3 = decodeIntElement3;
            str5 = str22;
            i2 = decodeIntElement4;
            str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            i4 = decodeIntElement2;
            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            i5 = decodeIntElement;
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str2 = str19;
        } else {
            String str24 = null;
            i = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            boolean z = true;
            String str25 = null;
            String str26 = null;
            String str27 = null;
            String str28 = null;
            str = null;
            String str29 = null;
            String str30 = null;
            String str31 = null;
            String str32 = null;
            String str33 = null;
            String str34 = null;
            String str35 = null;
            String str36 = null;
            while (z) {
                String str37 = str25;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        str16 = str26;
                        str17 = str27;
                        str18 = str37;
                        z = false;
                        str25 = str18;
                        str27 = str17;
                        str26 = str16;
                        break;
                    case 0:
                        str16 = str26;
                        str17 = str27;
                        str18 = str37;
                        str36 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str36);
                        i |= 1;
                        str25 = str18;
                        str27 = str17;
                        str26 = str16;
                        break;
                    case 1:
                        str16 = str26;
                        str17 = str27;
                        str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str37);
                        i |= 2;
                        str27 = str17;
                        str26 = str16;
                        break;
                    case 2:
                        str29 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str29);
                        i |= 4;
                        str26 = str26;
                        str25 = str37;
                        break;
                    case 3:
                        str15 = str29;
                        str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str);
                        i |= 8;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case 4:
                        str15 = str29;
                        str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str26);
                        i |= 16;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case 5:
                        str15 = str29;
                        str28 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str28);
                        i |= 32;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case 6:
                        str15 = str29;
                        str35 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str35);
                        i |= 64;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case 7:
                        str15 = str29;
                        str34 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str34);
                        i |= 128;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case 8:
                        str15 = str29;
                        str33 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str33);
                        i |= 256;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case 9:
                        str15 = str29;
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 9);
                        i |= 512;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case 10:
                        str15 = str29;
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 10);
                        i |= 1024;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        str15 = str29;
                        i12 = beginStructure.decodeIntElement(serialDescriptor, 11);
                        i |= 2048;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        str15 = str29;
                        str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str27);
                        i |= 4096;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                        str15 = str29;
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 13);
                        i |= 8192;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                        str15 = str29;
                        i8 = beginStructure.decodeIntElement(serialDescriptor, 14);
                        i |= 16384;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case AdditionVote2.CARD_TYPE_FIELD_NUMBER /* 15 */:
                        str15 = str29;
                        str32 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str32);
                        i7 = 32768;
                        i |= i7;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case AdditionVote2.TIPS_FIELD_NUMBER /* 16 */:
                        str15 = str29;
                        str31 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str31);
                        i7 = 65536;
                        i |= i7;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case AdditionVote2.URI_FIELD_NUMBER /* 17 */:
                        str15 = str29;
                        str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str24);
                        i7 = 131072;
                        i |= i7;
                        str25 = str37;
                        str29 = str15;
                        break;
                    case AdditionVote2.IS_VOTED_FIELD_NUMBER /* 18 */:
                        str15 = str29;
                        str30 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, str30);
                        i7 = 262144;
                        i |= i7;
                        str25 = str37;
                        str29 = str15;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str38 = str26;
            String str39 = str27;
            str2 = str36;
            str3 = str24;
            str4 = str30;
            str5 = str31;
            str6 = str32;
            str7 = str33;
            str8 = str34;
            str9 = str35;
            str10 = str25;
            str11 = str39;
            i2 = i8;
            i3 = i9;
            i4 = i10;
            i5 = i11;
            i6 = i12;
            str12 = str28;
            str13 = str29;
            str14 = str38;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdRcmdReasonStyle(i, str2, str10, str13, str, str14, str12, str9, str8, str7, i5, i4, i6, str11, i3, i2, str6, str5, str3, str4, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdRcmdReasonStyle value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdRcmdReasonStyle.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}