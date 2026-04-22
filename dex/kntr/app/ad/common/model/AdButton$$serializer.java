package kntr.app.ad.common.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import java.util.List;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdButton.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdButton.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdButton;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdButton$$serializer implements GeneratedSerializer<AdButton> {
    public static final AdButton$$serializer INSTANCE = new AdButton$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdButton", INSTANCE, 22);
        pluginGeneratedSerialDescriptor.addElement("text", true);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("jumpUrl", true);
        pluginGeneratedSerialDescriptor.addElement("callup_url", true);
        pluginGeneratedSerialDescriptor.addElement("reportUrls", true);
        pluginGeneratedSerialDescriptor.addElement("dlsuc_callup_url", true);
        pluginGeneratedSerialDescriptor.addElement("btnDelayTime", true);
        pluginGeneratedSerialDescriptor.addElement("gameId", true);
        pluginGeneratedSerialDescriptor.addElement("gameMonitorParam", true);
        pluginGeneratedSerialDescriptor.addElement("extremeTeamScore", true);
        pluginGeneratedSerialDescriptor.addElement("storyArrow", true);
        pluginGeneratedSerialDescriptor.addElement("showStyle", true);
        pluginGeneratedSerialDescriptor.addElement("showDynamicTime", true);
        pluginGeneratedSerialDescriptor.addElement("btnBgColor", true);
        pluginGeneratedSerialDescriptor.addElement("textColor", true);
        pluginGeneratedSerialDescriptor.addElement("show_game_custom_text", true);
        pluginGeneratedSerialDescriptor.addElement("btnStyle", true);
        pluginGeneratedSerialDescriptor.addElement("gameChannelId", true);
        pluginGeneratedSerialDescriptor.addElement("gameChannelExtra", true);
        pluginGeneratedSerialDescriptor.addElement("gameSourcefrom", true);
        pluginGeneratedSerialDescriptor.addElement("subcard_module", true);
        pluginGeneratedSerialDescriptor.addElement("dlsucCallupText", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdButton$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = AdButton.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[4].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LongSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, IntSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdSubCardModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final AdButton deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        String str5;
        String str6;
        AdSubCardModule adSubCardModule;
        String str7;
        String str8;
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        boolean z2;
        long j2;
        long j3;
        int i6;
        String str9;
        String str10;
        int i7;
        String str11;
        String str12;
        int i8;
        int i9;
        Lazy[] lazyArr2;
        String str13;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = AdButton.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 1);
            List list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), (Object) null);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 6);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 7);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 9);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 10);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 11);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 12);
            String str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            String str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 15);
            int decodeIntElement5 = beginStructure.decodeIntElement(serialDescriptor, 16);
            int decodeIntElement6 = beginStructure.decodeIntElement(serialDescriptor, 17);
            String str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, (Object) null);
            String str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, (Object) null);
            AdSubCardModule adSubCardModule2 = (AdSubCardModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, AdSubCardModule$$serializer.INSTANCE, (Object) null);
            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, (Object) null);
            i3 = decodeIntElement5;
            i5 = decodeIntElement4;
            z2 = decodeBooleanElement2;
            str10 = str17;
            str2 = str15;
            i4 = decodeIntElement6;
            str7 = str16;
            str3 = str14;
            j2 = decodeLongElement2;
            adSubCardModule = adSubCardModule2;
            j3 = decodeLongElement;
            i7 = 4194303;
            str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            i6 = decodeIntElement2;
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            i = decodeIntElement3;
            z = decodeBooleanElement;
            list = list2;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            i2 = decodeIntElement;
        } else {
            int i10 = 0;
            boolean z3 = false;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            boolean z4 = false;
            boolean z5 = true;
            String str18 = null;
            String str19 = null;
            String str20 = null;
            String str21 = null;
            String str22 = null;
            List list3 = null;
            String str23 = null;
            String str24 = null;
            AdSubCardModule adSubCardModule3 = null;
            String str25 = null;
            String str26 = null;
            long j4 = 0;
            long j5 = 0;
            i = 0;
            int i14 = 0;
            String str27 = null;
            int i15 = 0;
            while (z5) {
                int i16 = i10;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z5 = false;
                        str18 = str18;
                        i10 = i16;
                    case 0:
                        lazyArr2 = lazyArr;
                        str13 = str18;
                        i15 |= 1;
                        str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str26);
                        str18 = str13;
                        lazyArr = lazyArr2;
                        i10 = i16;
                    case 1:
                        lazyArr2 = lazyArr;
                        str13 = str18;
                        i14 = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i15 |= 2;
                        str18 = str13;
                        lazyArr = lazyArr2;
                        i10 = i16;
                    case 2:
                        str13 = str18;
                        lazyArr2 = lazyArr;
                        str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str27);
                        i15 |= 4;
                        str18 = str13;
                        lazyArr = lazyArr2;
                        i10 = i16;
                    case 3:
                        str11 = str27;
                        str12 = str18;
                        str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str24);
                        i15 |= 8;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case 4:
                        str11 = str27;
                        str12 = str18;
                        list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list3);
                        i15 |= 16;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case 5:
                        str11 = str27;
                        str12 = str18;
                        str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str21);
                        i15 |= 32;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case 6:
                        str11 = str27;
                        str12 = str18;
                        j5 = beginStructure.decodeLongElement(serialDescriptor, 6);
                        i15 |= 64;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case 7:
                        str11 = str27;
                        i15 |= 128;
                        str18 = str18;
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 7);
                        str27 = str11;
                    case 8:
                        str11 = str27;
                        str12 = str18;
                        str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str23);
                        i15 |= 256;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case 9:
                        str11 = str27;
                        str12 = str18;
                        i = beginStructure.decodeIntElement(serialDescriptor, 9);
                        i15 |= 512;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case 10:
                        str11 = str27;
                        str12 = str18;
                        z3 = beginStructure.decodeBooleanElement(serialDescriptor, 10);
                        i15 |= 1024;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        str11 = str27;
                        str12 = str18;
                        i13 = beginStructure.decodeIntElement(serialDescriptor, 11);
                        i15 |= 2048;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        str11 = str27;
                        str12 = str18;
                        j4 = beginStructure.decodeLongElement(serialDescriptor, 12);
                        i15 |= 4096;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                        str11 = str27;
                        str12 = str18;
                        str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str20);
                        i15 |= 8192;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                        str11 = str27;
                        str12 = str18;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str19);
                        i15 |= 16384;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case AdditionVote2.CARD_TYPE_FIELD_NUMBER /* 15 */:
                        str11 = str27;
                        str12 = str18;
                        z4 = beginStructure.decodeBooleanElement(serialDescriptor, 15);
                        i8 = 32768;
                        i15 |= i8;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case AdditionVote2.TIPS_FIELD_NUMBER /* 16 */:
                        str11 = str27;
                        str12 = str18;
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 16);
                        i8 = 65536;
                        i15 |= i8;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case AdditionVote2.URI_FIELD_NUMBER /* 17 */:
                        str11 = str27;
                        str12 = str18;
                        i12 = beginStructure.decodeIntElement(serialDescriptor, 17);
                        i8 = 131072;
                        i15 |= i8;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case AdditionVote2.IS_VOTED_FIELD_NUMBER /* 18 */:
                        str11 = str27;
                        str12 = str18;
                        str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, str25);
                        i15 |= 262144;
                        str18 = str12;
                        i10 = i16;
                        str27 = str11;
                    case AdditionVote2.CHOICE_CNT_FIELD_NUMBER /* 19 */:
                        str11 = str27;
                        str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, str22);
                        i9 = 524288;
                        i15 |= i9;
                        i10 = i16;
                        str27 = str11;
                    case AdditionVote2.DEFAULE_SELECT_SHARE_FIELD_NUMBER /* 20 */:
                        str11 = str27;
                        adSubCardModule3 = (AdSubCardModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, AdSubCardModule$$serializer.INSTANCE, adSubCardModule3);
                        i9 = 1048576;
                        i15 |= i9;
                        i10 = i16;
                        str27 = str11;
                    case AdditionVote2.ONLY_FANS_VOTE_FIELD_NUMBER /* 21 */:
                        str11 = str27;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, str18);
                        i9 = 2097152;
                        i15 |= i9;
                        i10 = i16;
                        str27 = str11;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str28 = str18;
            String str29 = str26;
            str = str27;
            str2 = str19;
            str3 = str20;
            str4 = str21;
            list = list3;
            str5 = str23;
            str6 = str24;
            adSubCardModule = adSubCardModule3;
            str7 = str25;
            str8 = str28;
            i2 = i14;
            z = z3;
            i3 = i11;
            i4 = i12;
            i5 = i13;
            z2 = z4;
            j2 = j4;
            j3 = j5;
            i6 = i10;
            str9 = str29;
            str10 = str22;
            i7 = i15;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdButton(i7, str9, i2, str, str6, list, str4, j3, i6, str5, i, z, i5, j2, str3, str2, z2, i3, i4, str7, str10, adSubCardModule, str8, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdButton value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdButton.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}