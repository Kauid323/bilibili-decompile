package kntr.app.ad.common.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import java.util.List;
import kntr.app.ad.common.model.AdIMaxLandingPage;
import kntr.app.game.base.router.RouterHelperKt;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdIMaxLandingPage.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdIMaxLandingPage.ConfigBean.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdIMaxLandingPage$ConfigBean;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdIMaxLandingPage$ConfigBean$$serializer implements GeneratedSerializer<AdIMaxLandingPage.ConfigBean> {
    public static final AdIMaxLandingPage$ConfigBean$$serializer INSTANCE = new AdIMaxLandingPage$ConfigBean$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdIMaxLandingPage.ConfigBean", INSTANCE, 17);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        pluginGeneratedSerialDescriptor.addElement("icon", true);
        pluginGeneratedSerialDescriptor.addElement("tags", true);
        pluginGeneratedSerialDescriptor.addElement("cover", true);
        pluginGeneratedSerialDescriptor.addElement("jumpUrl", true);
        pluginGeneratedSerialDescriptor.addElement("callupUrl", true);
        pluginGeneratedSerialDescriptor.addElement("reportUrls", true);
        pluginGeneratedSerialDescriptor.addElement("desc", true);
        pluginGeneratedSerialDescriptor.addElement("button", true);
        pluginGeneratedSerialDescriptor.addElement("video", true);
        pluginGeneratedSerialDescriptor.addElement("reportTime", true);
        pluginGeneratedSerialDescriptor.addElement("avid", true);
        pluginGeneratedSerialDescriptor.addElement("weburl", true);
        pluginGeneratedSerialDescriptor.addElement("gameId", true);
        pluginGeneratedSerialDescriptor.addElement("gameMonitorParam", true);
        pluginGeneratedSerialDescriptor.addElement("source", true);
        pluginGeneratedSerialDescriptor.addElement(RouterHelperKt.PARAM_SOURCE_FROM, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdIMaxLandingPage$ConfigBean$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = AdIMaxLandingPage.ConfigBean.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[6].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdButton$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdVideo$$serializer.INSTANCE), LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final AdIMaxLandingPage.ConfigBean deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        String str;
        String str2;
        String str3;
        AdButton adButton;
        List list;
        String str4;
        AdVideo adVideo;
        String str5;
        String str6;
        String str7;
        String str8;
        int i;
        long j2;
        String str9;
        List list2;
        String str10;
        String str11;
        int i2;
        String str12;
        int i3;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = AdIMaxLandingPage.ConfigBean.$childSerializers;
        String str18 = null;
        if (beginStructure.decodeSequentially()) {
            List list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), (Object) null);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 10);
            String str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            String str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 13);
            String str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            String str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, (Object) null);
            str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, (Object) null);
            str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            str11 = str22;
            str2 = str21;
            i = decodeIntElement;
            str8 = str20;
            list = list3;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            adVideo = (AdVideo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, AdVideo$$serializer.INSTANCE, (Object) null);
            adButton = (AdButton) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, AdButton$$serializer.INSTANCE, (Object) null);
            str3 = str19;
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            j2 = decodeLongElement;
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            i2 = 131071;
        } else {
            boolean z = true;
            int i4 = 0;
            int i5 = 0;
            String str23 = null;
            String str24 = null;
            String str25 = null;
            String str26 = null;
            String str27 = null;
            String str28 = null;
            String str29 = null;
            AdButton adButton2 = null;
            List list4 = null;
            String str30 = null;
            AdVideo adVideo2 = null;
            String str31 = null;
            String str32 = null;
            List list5 = null;
            long j3 = 0;
            while (z) {
                String str33 = str26;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        str13 = str24;
                        z = false;
                        str26 = str33;
                        lazyArr = lazyArr;
                        str30 = str30;
                        str24 = str13;
                        break;
                    case 0:
                        str14 = str23;
                        str15 = str24;
                        str16 = str30;
                        str31 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str31);
                        i4 |= 1;
                        str26 = str33;
                        lazyArr = lazyArr;
                        str30 = str16;
                        str24 = str15;
                        str23 = str14;
                        break;
                    case 1:
                        str13 = str24;
                        str32 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str32);
                        i4 |= 2;
                        lazyArr = lazyArr;
                        str30 = str30;
                        str23 = str23;
                        str26 = str33;
                        str24 = str13;
                        break;
                    case 2:
                        str14 = str23;
                        str15 = str24;
                        str16 = str30;
                        str17 = str33;
                        list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list5);
                        i4 |= 4;
                        str26 = str17;
                        str30 = str16;
                        str24 = str15;
                        str23 = str14;
                        break;
                    case 3:
                        str14 = str23;
                        str15 = str24;
                        str16 = str30;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str33);
                        i4 |= 8;
                        str26 = str17;
                        str30 = str16;
                        str24 = str15;
                        str23 = str14;
                        break;
                    case 4:
                        str30 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str30);
                        i4 |= 16;
                        str24 = str24;
                        str23 = str23;
                        str26 = str33;
                        break;
                    case 5:
                        str12 = str30;
                        str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str24);
                        i4 |= 32;
                        str23 = str23;
                        str26 = str33;
                        str30 = str12;
                        break;
                    case 6:
                        str12 = str30;
                        list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), list4);
                        i4 |= 64;
                        str26 = str33;
                        str30 = str12;
                        break;
                    case 7:
                        str12 = str30;
                        str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str25);
                        i4 |= 128;
                        str26 = str33;
                        str30 = str12;
                        break;
                    case 8:
                        str12 = str30;
                        adButton2 = (AdButton) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, AdButton$$serializer.INSTANCE, adButton2);
                        i4 |= 256;
                        str26 = str33;
                        str30 = str12;
                        break;
                    case 9:
                        str12 = str30;
                        adVideo2 = (AdVideo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, AdVideo$$serializer.INSTANCE, adVideo2);
                        i4 |= 512;
                        str26 = str33;
                        str30 = str12;
                        break;
                    case 10:
                        str12 = str30;
                        j3 = beginStructure.decodeLongElement(serialDescriptor, 10);
                        i4 |= 1024;
                        str26 = str33;
                        str30 = str12;
                        break;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        str12 = str30;
                        str29 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str29);
                        i4 |= 2048;
                        str26 = str33;
                        str30 = str12;
                        break;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        str12 = str30;
                        str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str23);
                        i4 |= 4096;
                        str26 = str33;
                        str30 = str12;
                        break;
                    case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                        str12 = str30;
                        i5 = beginStructure.decodeIntElement(serialDescriptor, 13);
                        i4 |= 8192;
                        str26 = str33;
                        str30 = str12;
                        break;
                    case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                        str12 = str30;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str18);
                        i4 |= 16384;
                        str26 = str33;
                        str30 = str12;
                        break;
                    case AdditionVote2.CARD_TYPE_FIELD_NUMBER /* 15 */:
                        str12 = str30;
                        str28 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str28);
                        i3 = 32768;
                        i4 |= i3;
                        str26 = str33;
                        str30 = str12;
                        break;
                    case AdditionVote2.TIPS_FIELD_NUMBER /* 16 */:
                        str12 = str30;
                        str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str27);
                        i3 = 65536;
                        i4 |= i3;
                        str26 = str33;
                        str30 = str12;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str25;
            str2 = str18;
            str3 = str29;
            adButton = adButton2;
            list = list4;
            str4 = str32;
            adVideo = adVideo2;
            str5 = str26;
            str6 = str30;
            str7 = str24;
            str8 = str23;
            i = i5;
            j2 = j3;
            str9 = str31;
            list2 = list5;
            str10 = str27;
            str11 = str28;
            i2 = i4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdIMaxLandingPage.ConfigBean(i2, str9, str4, list2, str5, str6, str7, list, str, adButton, adVideo, j2, str3, str8, i, str2, str11, str10, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdIMaxLandingPage.ConfigBean value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdIMaxLandingPage.ConfigBean.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}