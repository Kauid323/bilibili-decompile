package kntr.app.mall.product.details.page.api;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CommentInfoApiService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$$serializer implements GeneratedSerializer<CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo> {
    public static final int $stable;
    public static final CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$$serializer INSTANCE = new CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo", INSTANCE, 25);
        pluginGeneratedSerialDescriptor.addElement("attention", true);
        pluginGeneratedSerialDescriptor.addElement("avatar", true);
        pluginGeneratedSerialDescriptor.addElement("avatarIcon", true);
        pluginGeneratedSerialDescriptor.addElement("avatarIdentity", true);
        pluginGeneratedSerialDescriptor.addElement("decorateImg", true);
        pluginGeneratedSerialDescriptor.addElement("fans", true);
        pluginGeneratedSerialDescriptor.addElement("followed", true);
        pluginGeneratedSerialDescriptor.addElement("level", true);
        pluginGeneratedSerialDescriptor.addElement("merchant", true);
        pluginGeneratedSerialDescriptor.addElement("merchantIcon", true);
        pluginGeneratedSerialDescriptor.addElement("merchantId", true);
        pluginGeneratedSerialDescriptor.addElement("merchantUrl", true);
        pluginGeneratedSerialDescriptor.addElement("mid", true);
        pluginGeneratedSerialDescriptor.addElement("nicknameColor", true);
        pluginGeneratedSerialDescriptor.addElement("official", true);
        pluginGeneratedSerialDescriptor.addElement("relation", true);
        pluginGeneratedSerialDescriptor.addElement("sex", true);
        pluginGeneratedSerialDescriptor.addElement("sign", true);
        pluginGeneratedSerialDescriptor.addElement("spaceUrl", true);
        pluginGeneratedSerialDescriptor.addElement("subjectRelation", true);
        pluginGeneratedSerialDescriptor.addElement("supportFollowAction", true);
        pluginGeneratedSerialDescriptor.addElement("uname", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("userName", true);
        pluginGeneratedSerialDescriptor.addElement("vip", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$OfficialModel$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$VipModel$$serializer.INSTANCE)};
    }

    public final CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo deserialize(Decoder decoder) {
        String str;
        String str2;
        CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo.VipModel vipModel;
        String str3;
        String str4;
        String str5;
        Integer num;
        String str6;
        Integer num2;
        Boolean bool;
        Long l;
        String str7;
        Integer num3;
        Boolean bool2;
        Integer num4;
        Integer num5;
        int i;
        CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo.OfficialModel officialModel;
        String str8;
        Long l2;
        String str9;
        Boolean bool3;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        int i2;
        int i3;
        Long l3;
        String str16;
        CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo.OfficialModel officialModel2;
        String str17;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            Long l4 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, LongSerializer.INSTANCE, (Object) null);
            String str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo.OfficialModel officialModel3 = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo.OfficialModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$OfficialModel$$serializer.INSTANCE, (Object) null);
            Integer num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, IntSerializer.INSTANCE, (Object) null);
            String str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, (Object) null);
            String str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, (Object) null);
            String str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, (Object) null);
            Integer num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, IntSerializer.INSTANCE, (Object) null);
            Boolean bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, BooleanSerializer.INSTANCE, (Object) null);
            String str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, (Object) null);
            String str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 22, StringSerializer.INSTANCE, (Object) null);
            String str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 23, StringSerializer.INSTANCE, (Object) null);
            vipModel = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo.VipModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 24, CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$VipModel$$serializer.INSTANCE, (Object) null);
            i = 33554431;
            bool2 = bool4;
            num4 = num7;
            str11 = str22;
            str12 = str21;
            str13 = str20;
            num5 = num6;
            officialModel = officialModel3;
            str8 = str19;
            str4 = str23;
            str3 = str24;
            str2 = str25;
            num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, BooleanSerializer.INSTANCE, (Object) null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, LongSerializer.INSTANCE, (Object) null);
            l2 = l4;
            str7 = str18;
            bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, (Object) null);
            str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            String str26 = null;
            CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo.OfficialModel officialModel4 = null;
            String str27 = null;
            Boolean bool5 = null;
            String str28 = null;
            String str29 = null;
            Integer num8 = null;
            String str30 = null;
            String str31 = null;
            Long l5 = null;
            CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo.VipModel vipModel2 = null;
            String str32 = null;
            Integer num9 = null;
            String str33 = null;
            String str34 = null;
            Integer num10 = null;
            String str35 = null;
            Integer num11 = null;
            Boolean bool6 = null;
            String str36 = null;
            Boolean bool7 = null;
            String str37 = null;
            Long l6 = null;
            String str38 = null;
            int i4 = 0;
            Integer num12 = null;
            while (z) {
                Long l7 = l5;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        l3 = l7;
                        z = false;
                        str27 = str27;
                        officialModel4 = officialModel4;
                        break;
                    case 0:
                        str16 = str26;
                        officialModel2 = officialModel4;
                        str17 = str27;
                        l3 = l7;
                        num9 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, num9);
                        i4 |= 1;
                        str27 = str17;
                        officialModel4 = officialModel2;
                        str26 = str16;
                        break;
                    case 1:
                        str33 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str33);
                        i4 |= 2;
                        str27 = str27;
                        officialModel4 = officialModel4;
                        str26 = str26;
                        l5 = l7;
                        str34 = str34;
                        continue;
                    case 2:
                        str34 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str34);
                        i4 |= 4;
                        str27 = str27;
                        officialModel4 = officialModel4;
                        str26 = str26;
                        l5 = l7;
                        num10 = num10;
                        continue;
                    case 3:
                        num10 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num10);
                        i4 |= 8;
                        str27 = str27;
                        officialModel4 = officialModel4;
                        str26 = str26;
                        l5 = l7;
                        str35 = str35;
                        continue;
                    case 4:
                        str35 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str35);
                        i4 |= 16;
                        str27 = str27;
                        officialModel4 = officialModel4;
                        str26 = str26;
                        l5 = l7;
                        num11 = num11;
                        continue;
                    case 5:
                        num11 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num11);
                        i4 |= 32;
                        str27 = str27;
                        officialModel4 = officialModel4;
                        str26 = str26;
                        l5 = l7;
                        bool6 = bool6;
                        continue;
                    case 6:
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, BooleanSerializer.INSTANCE, bool6);
                        i4 |= 64;
                        str27 = str27;
                        officialModel4 = officialModel4;
                        str26 = str26;
                        l5 = l7;
                        str36 = str36;
                        continue;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str36 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str36);
                        i4 |= 128;
                        str27 = str27;
                        officialModel4 = officialModel4;
                        str26 = str26;
                        l5 = l7;
                        bool7 = bool7;
                        continue;
                    case 8:
                        bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, bool7);
                        i4 |= 256;
                        str27 = str27;
                        officialModel4 = officialModel4;
                        str26 = str26;
                        l5 = l7;
                        str37 = str37;
                        continue;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        str37 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str37);
                        i4 |= 512;
                        str27 = str27;
                        officialModel4 = officialModel4;
                        str26 = str26;
                        l5 = l7;
                        l6 = l6;
                        continue;
                    case 10:
                        l6 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, LongSerializer.INSTANCE, l6);
                        i4 |= 1024;
                        str27 = str27;
                        officialModel4 = officialModel4;
                        str26 = str26;
                        l5 = l7;
                        str38 = str38;
                        continue;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        str16 = str26;
                        officialModel2 = officialModel4;
                        str17 = str27;
                        l3 = l7;
                        str38 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str38);
                        i4 |= 2048;
                        str27 = str17;
                        officialModel4 = officialModel2;
                        str26 = str16;
                        break;
                    case 12:
                        i4 |= 4096;
                        l5 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, LongSerializer.INSTANCE, l7);
                        str27 = str27;
                        officialModel4 = officialModel4;
                        str26 = str26;
                        continue;
                    case 13:
                        str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str26);
                        i4 |= 8192;
                        str27 = str27;
                        officialModel4 = officialModel4;
                        l5 = l7;
                        continue;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        str14 = str26;
                        str15 = str27;
                        officialModel4 = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo.OfficialModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$OfficialModel$$serializer.INSTANCE, officialModel4);
                        i4 |= 16384;
                        str27 = str15;
                        l5 = l7;
                        str26 = str14;
                    case 15:
                        str14 = str26;
                        str15 = str27;
                        num12 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, IntSerializer.INSTANCE, num12);
                        i2 = 32768;
                        i4 |= i2;
                        str27 = str15;
                        l5 = l7;
                        str26 = str14;
                    case 16:
                        str14 = str26;
                        str15 = str27;
                        str31 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str31);
                        i2 = 65536;
                        i4 |= i2;
                        str27 = str15;
                        l5 = l7;
                        str26 = str14;
                    case 17:
                        str14 = str26;
                        str15 = str27;
                        str30 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str30);
                        i2 = 131072;
                        i4 |= i2;
                        str27 = str15;
                        l5 = l7;
                        str26 = str14;
                    case 18:
                        str14 = str26;
                        str15 = str27;
                        str28 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, str28);
                        i2 = 262144;
                        i4 |= i2;
                        str27 = str15;
                        l5 = l7;
                        str26 = str14;
                    case 19:
                        str14 = str26;
                        str15 = str27;
                        num8 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, IntSerializer.INSTANCE, num8);
                        i2 = 524288;
                        i4 |= i2;
                        str27 = str15;
                        l5 = l7;
                        str26 = str14;
                    case 20:
                        str14 = str26;
                        bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, BooleanSerializer.INSTANCE, bool5);
                        i3 = 1048576;
                        i4 |= i3;
                        l5 = l7;
                        str26 = str14;
                    case 21:
                        str14 = str26;
                        str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, str27);
                        i3 = 2097152;
                        i4 |= i3;
                        l5 = l7;
                        str26 = str14;
                    case 22:
                        str14 = str26;
                        str32 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 22, StringSerializer.INSTANCE, str32);
                        i3 = 4194304;
                        i4 |= i3;
                        l5 = l7;
                        str26 = str14;
                    case 23:
                        str14 = str26;
                        str29 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 23, StringSerializer.INSTANCE, str29);
                        i3 = 8388608;
                        i4 |= i3;
                        l5 = l7;
                        str26 = str14;
                    case 24:
                        str14 = str26;
                        vipModel2 = (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo.VipModel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 24, CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$VipModel$$serializer.INSTANCE, vipModel2);
                        i3 = 16777216;
                        i4 |= i3;
                        l5 = l7;
                        str26 = str14;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
                l5 = l3;
            }
            CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo.OfficialModel officialModel5 = officialModel4;
            Integer num13 = num9;
            String str39 = str34;
            Integer num14 = num10;
            str = str33;
            str2 = str29;
            vipModel = vipModel2;
            str3 = str32;
            str4 = str27;
            str5 = str39;
            num = num14;
            str6 = str35;
            num2 = num11;
            bool = bool6;
            l = l6;
            str7 = str38;
            num3 = num13;
            bool2 = bool5;
            num4 = num8;
            num5 = num12;
            i = i4;
            officialModel = officialModel5;
            str8 = str26;
            l2 = l5;
            str9 = str36;
            bool3 = bool7;
            str10 = str37;
            str11 = str28;
            str12 = str30;
            str13 = str31;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo(i, num3, str, str5, num, str6, num2, bool, str9, bool3, str10, l, str7, l2, str8, officialModel, num5, str13, str12, str11, num4, bool2, str4, str3, str2, vipModel, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}