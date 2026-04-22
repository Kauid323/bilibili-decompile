package kntr.app.mall.mallDynamicPage.component.business.bean;

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

/* compiled from: MallFeedsModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/mallDynamicPage/component/business/bean/TagInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/mallDynamicPage/component/business/bean/TagInfo;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class TagInfo$$serializer implements GeneratedSerializer<TagInfo> {
    public static final int $stable;
    public static final TagInfo$$serializer INSTANCE = new TagInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.mallDynamicPage.component.business.bean.TagInfo", INSTANCE, 20);
        pluginGeneratedSerialDescriptor.addElement("tagType", true);
        pluginGeneratedSerialDescriptor.addElement("backImgUrl", true);
        pluginGeneratedSerialDescriptor.addElement("backImgWidth", true);
        pluginGeneratedSerialDescriptor.addElement("backImgHeight", true);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        pluginGeneratedSerialDescriptor.addElement("cornerRadius", true);
        pluginGeneratedSerialDescriptor.addElement("useBoard", true);
        pluginGeneratedSerialDescriptor.addElement("boardDayColor1", true);
        pluginGeneratedSerialDescriptor.addElement("boardDayColor2", true);
        pluginGeneratedSerialDescriptor.addElement("boardNightColor1", true);
        pluginGeneratedSerialDescriptor.addElement("boardNightColor2", true);
        pluginGeneratedSerialDescriptor.addElement("backDayColor1", true);
        pluginGeneratedSerialDescriptor.addElement("backDayColor2", true);
        pluginGeneratedSerialDescriptor.addElement("backNightColor1", true);
        pluginGeneratedSerialDescriptor.addElement("backNightColor2", true);
        pluginGeneratedSerialDescriptor.addElement("titleDayColor1", true);
        pluginGeneratedSerialDescriptor.addElement("titleDayColor2", true);
        pluginGeneratedSerialDescriptor.addElement("titleNightColor1", true);
        pluginGeneratedSerialDescriptor.addElement("titleNightColor2", true);
        pluginGeneratedSerialDescriptor.addElement("location", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private TagInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final TagInfo deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        String str6;
        String str7;
        String str8;
        String str9;
        Integer num;
        Integer num2;
        String str10;
        Integer num3;
        Integer num4;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        Integer num5;
        String str16;
        int i2;
        String str17;
        String str18;
        String str19;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            String str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            String str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            String str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            String str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, (Object) null);
            String str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, (Object) null);
            String str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, (Object) null);
            String str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, (Object) null);
            str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            i = 1048575;
            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            str14 = str27;
            str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, (Object) null);
            num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, (Object) null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, (Object) null);
            str9 = str20;
            str3 = str26;
            str7 = str21;
            str4 = str25;
            str6 = str22;
            str5 = str24;
            str13 = str23;
        } else {
            boolean z = true;
            String str28 = null;
            String str29 = null;
            String str30 = null;
            String str31 = null;
            String str32 = null;
            String str33 = null;
            String str34 = null;
            String str35 = null;
            String str36 = null;
            String str37 = null;
            String str38 = null;
            str = null;
            Integer num6 = null;
            String str39 = null;
            Integer num7 = null;
            Integer num8 = null;
            String str40 = null;
            Integer num9 = null;
            Integer num10 = null;
            int i3 = 0;
            String str41 = null;
            while (z) {
                String str42 = str30;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        str17 = str28;
                        str18 = str29;
                        str19 = str42;
                        z = false;
                        str30 = str19;
                        str29 = str18;
                        str28 = str17;
                        break;
                    case 0:
                        str17 = str28;
                        str18 = str29;
                        str19 = str42;
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, num6);
                        i3 |= 1;
                        str39 = str39;
                        str30 = str19;
                        str29 = str18;
                        str28 = str17;
                        break;
                    case 1:
                        str17 = str28;
                        str18 = str29;
                        str19 = str42;
                        str39 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str39);
                        i3 |= 2;
                        num7 = num7;
                        str30 = str19;
                        str29 = str18;
                        str28 = str17;
                        break;
                    case 2:
                        str17 = str28;
                        str18 = str29;
                        str19 = str42;
                        num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num7);
                        i3 |= 4;
                        num8 = num8;
                        str30 = str19;
                        str29 = str18;
                        str28 = str17;
                        break;
                    case 3:
                        str17 = str28;
                        str18 = str29;
                        str19 = str42;
                        num8 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num8);
                        i3 |= 8;
                        str40 = str40;
                        str30 = str19;
                        str29 = str18;
                        str28 = str17;
                        break;
                    case 4:
                        str17 = str28;
                        str18 = str29;
                        str19 = str42;
                        str40 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str40);
                        i3 |= 16;
                        num9 = num9;
                        str30 = str19;
                        str29 = str18;
                        str28 = str17;
                        break;
                    case 5:
                        str17 = str28;
                        str18 = str29;
                        str19 = str42;
                        num9 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num9);
                        i3 |= 32;
                        num10 = num10;
                        str30 = str19;
                        str29 = str18;
                        str28 = str17;
                        break;
                    case 6:
                        str17 = str28;
                        str18 = str29;
                        str19 = str42;
                        num10 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, num10);
                        i3 |= 64;
                        str30 = str19;
                        str29 = str18;
                        str28 = str17;
                        break;
                    case 7:
                        str17 = str28;
                        str18 = str29;
                        str30 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str42);
                        i3 |= 128;
                        str29 = str18;
                        str28 = str17;
                        break;
                    case 8:
                        str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str);
                        i3 |= 256;
                        str28 = str28;
                        str30 = str42;
                        break;
                    case 9:
                        str16 = str;
                        str38 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str38);
                        i3 |= 512;
                        str30 = str42;
                        str = str16;
                        break;
                    case 10:
                        str16 = str;
                        str32 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str32);
                        i3 |= 1024;
                        str30 = str42;
                        str = str16;
                        break;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        str16 = str;
                        str37 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str37);
                        i3 |= 2048;
                        str30 = str42;
                        str = str16;
                        break;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        str16 = str;
                        str36 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str36);
                        i3 |= 4096;
                        str30 = str42;
                        str = str16;
                        break;
                    case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                        str16 = str;
                        str28 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str28);
                        i3 |= 8192;
                        str30 = str42;
                        str = str16;
                        break;
                    case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                        str16 = str;
                        str29 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str29);
                        i3 |= 16384;
                        str30 = str42;
                        str = str16;
                        break;
                    case AdditionVote2.CARD_TYPE_FIELD_NUMBER /* 15 */:
                        str16 = str;
                        str41 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str41);
                        i2 = 32768;
                        i3 |= i2;
                        str30 = str42;
                        str = str16;
                        break;
                    case AdditionVote2.TIPS_FIELD_NUMBER /* 16 */:
                        str16 = str;
                        str35 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str35);
                        i2 = 65536;
                        i3 |= i2;
                        str30 = str42;
                        str = str16;
                        break;
                    case AdditionVote2.URI_FIELD_NUMBER /* 17 */:
                        str16 = str;
                        str34 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str34);
                        i2 = 131072;
                        i3 |= i2;
                        str30 = str42;
                        str = str16;
                        break;
                    case AdditionVote2.IS_VOTED_FIELD_NUMBER /* 18 */:
                        str16 = str;
                        str31 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, str31);
                        i2 = 262144;
                        i3 |= i2;
                        str30 = str42;
                        str = str16;
                        break;
                    case AdditionVote2.CHOICE_CNT_FIELD_NUMBER /* 19 */:
                        str16 = str;
                        str33 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, str33);
                        i2 = 524288;
                        i3 |= i2;
                        str30 = str42;
                        str = str16;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str2 = str32;
            str3 = str34;
            str4 = str35;
            str5 = str41;
            i = i3;
            str6 = str36;
            str7 = str37;
            str8 = str38;
            str9 = str39;
            num = num7;
            num2 = num8;
            str10 = str40;
            num3 = num9;
            num4 = num10;
            str11 = str30;
            str12 = str29;
            str13 = str28;
            str14 = str31;
            str15 = str33;
            num5 = num6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new TagInfo(i, num5, str9, num, num2, str10, num3, num4, str11, str, str8, str2, str7, str6, str13, str12, str5, str4, str3, str14, str15, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, TagInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        TagInfo.write$Self$mallDynamicPage_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}