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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdTreasureHuntBall.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdTreasureHuntBall.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdTreasureHuntBall;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdTreasureHuntBall$$serializer implements GeneratedSerializer<AdTreasureHuntBall> {
    public static final AdTreasureHuntBall$$serializer INSTANCE = new AdTreasureHuntBall$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdTreasureHuntBall", INSTANCE, 18);
        pluginGeneratedSerialDescriptor.addElement("ballId", true);
        pluginGeneratedSerialDescriptor.addElement("achieveStatus", true);
        pluginGeneratedSerialDescriptor.addElement("appearanceTime", true);
        pluginGeneratedSerialDescriptor.addElement("appearanceDuration", true);
        pluginGeneratedSerialDescriptor.addElement("text", true);
        pluginGeneratedSerialDescriptor.addElement("imageUrl", true);
        pluginGeneratedSerialDescriptor.addElement("options", true);
        pluginGeneratedSerialDescriptor.addElement("buttonText", true);
        pluginGeneratedSerialDescriptor.addElement("successText", true);
        pluginGeneratedSerialDescriptor.addElement("successImageUrl", true);
        pluginGeneratedSerialDescriptor.addElement("successButtonText", true);
        pluginGeneratedSerialDescriptor.addElement("failureText", true);
        pluginGeneratedSerialDescriptor.addElement("achieveText", true);
        pluginGeneratedSerialDescriptor.addElement("achieveImageUrl", true);
        pluginGeneratedSerialDescriptor.addElement("achieveButtonText", true);
        pluginGeneratedSerialDescriptor.addElement("jumpUrl", true);
        pluginGeneratedSerialDescriptor.addElement("adTagImageUrl", true);
        pluginGeneratedSerialDescriptor.addElement("adTagText", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdTreasureHuntBall$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = AdTreasureHuntBall.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[6].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final AdTreasureHuntBall deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        List list;
        String str10;
        long j2;
        long j3;
        String str11;
        String str12;
        String str13;
        int i;
        int i2;
        String str14;
        String str15;
        Lazy[] lazyArr2;
        String str16;
        List list2;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = AdTreasureHuntBall.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 1);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 2);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 3);
            String str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            String str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            String str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, (Object) null);
            String str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, (Object) null);
            str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, (Object) null);
            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            str13 = str20;
            j2 = decodeLongElement;
            str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            str4 = str17;
            j3 = decodeLongElement2;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            str9 = str19;
            str10 = str18;
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), (Object) null);
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            i2 = decodeIntElement;
            i = 262143;
        } else {
            boolean z = true;
            int i4 = 0;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            String str24 = null;
            List list3 = null;
            String str25 = null;
            String str26 = null;
            String str27 = null;
            String str28 = null;
            String str29 = null;
            String str30 = null;
            String str31 = null;
            String str32 = null;
            String str33 = null;
            long j4 = 0;
            long j5 = 0;
            String str34 = null;
            int i5 = 0;
            while (z) {
                List list4 = list3;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        str22 = str22;
                        list3 = list4;
                        str21 = str21;
                        break;
                    case 0:
                        str15 = str21;
                        lazyArr2 = lazyArr;
                        str16 = str22;
                        list2 = list4;
                        str31 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str31);
                        i5 |= 1;
                        str32 = str32;
                        str22 = str16;
                        list3 = list2;
                        str21 = str15;
                        lazyArr = lazyArr2;
                        break;
                    case 1:
                        str15 = str21;
                        lazyArr2 = lazyArr;
                        str16 = str22;
                        list2 = list4;
                        i4 = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i5 |= 2;
                        str22 = str16;
                        list3 = list2;
                        str21 = str15;
                        lazyArr = lazyArr2;
                        break;
                    case 2:
                        str15 = str21;
                        lazyArr2 = lazyArr;
                        str16 = str22;
                        list2 = list4;
                        j4 = beginStructure.decodeLongElement(serialDescriptor, 2);
                        i5 |= 4;
                        str22 = str16;
                        list3 = list2;
                        str21 = str15;
                        lazyArr = lazyArr2;
                        break;
                    case 3:
                        str15 = str21;
                        lazyArr2 = lazyArr;
                        str16 = str22;
                        list2 = list4;
                        j5 = beginStructure.decodeLongElement(serialDescriptor, 3);
                        i5 |= 8;
                        str22 = str16;
                        list3 = list2;
                        str21 = str15;
                        lazyArr = lazyArr2;
                        break;
                    case 4:
                        str15 = str21;
                        lazyArr2 = lazyArr;
                        list2 = list4;
                        str16 = str22;
                        str32 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str32);
                        i5 |= 16;
                        str22 = str16;
                        list3 = list2;
                        str21 = str15;
                        lazyArr = lazyArr2;
                        break;
                    case 5:
                        str15 = str21;
                        lazyArr2 = lazyArr;
                        list2 = list4;
                        str33 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str33);
                        i5 |= 32;
                        list3 = list2;
                        str21 = str15;
                        lazyArr = lazyArr2;
                        break;
                    case 6:
                        lazyArr2 = lazyArr;
                        str15 = str21;
                        i5 |= 64;
                        list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr2[6].getValue(), list4);
                        str21 = str15;
                        lazyArr = lazyArr2;
                        break;
                    case 7:
                        lazyArr2 = lazyArr;
                        str30 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str30);
                        i5 |= 128;
                        list3 = list4;
                        lazyArr = lazyArr2;
                        break;
                    case 8:
                        lazyArr2 = lazyArr;
                        str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str24);
                        i5 |= 256;
                        list3 = list4;
                        lazyArr = lazyArr2;
                        break;
                    case 9:
                        lazyArr2 = lazyArr;
                        str29 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str29);
                        i5 |= 512;
                        list3 = list4;
                        lazyArr = lazyArr2;
                        break;
                    case 10:
                        lazyArr2 = lazyArr;
                        str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str25);
                        i5 |= 1024;
                        list3 = list4;
                        lazyArr = lazyArr2;
                        break;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        lazyArr2 = lazyArr;
                        str28 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str28);
                        i5 |= 2048;
                        list3 = list4;
                        lazyArr = lazyArr2;
                        break;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        lazyArr2 = lazyArr;
                        str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str23);
                        i5 |= 4096;
                        list3 = list4;
                        lazyArr = lazyArr2;
                        break;
                    case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                        lazyArr2 = lazyArr;
                        str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str27);
                        i5 |= 8192;
                        list3 = list4;
                        lazyArr = lazyArr2;
                        break;
                    case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                        lazyArr2 = lazyArr;
                        str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str21);
                        i5 |= 16384;
                        list3 = list4;
                        lazyArr = lazyArr2;
                        break;
                    case AdditionVote2.CARD_TYPE_FIELD_NUMBER /* 15 */:
                        lazyArr2 = lazyArr;
                        str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str22);
                        i3 = 32768;
                        i5 |= i3;
                        list3 = list4;
                        lazyArr = lazyArr2;
                        break;
                    case AdditionVote2.TIPS_FIELD_NUMBER /* 16 */:
                        lazyArr2 = lazyArr;
                        str34 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str34);
                        i3 = 65536;
                        i5 |= i3;
                        list3 = list4;
                        lazyArr = lazyArr2;
                        break;
                    case AdditionVote2.URI_FIELD_NUMBER /* 17 */:
                        lazyArr2 = lazyArr;
                        str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str26);
                        i3 = 131072;
                        i5 |= i3;
                        list3 = list4;
                        lazyArr = lazyArr2;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str24;
            str2 = str33;
            str3 = str25;
            str4 = str27;
            str5 = str28;
            str6 = str29;
            str7 = str30;
            str8 = str32;
            str9 = str22;
            list = list3;
            str10 = str21;
            j2 = j4;
            j3 = j5;
            str11 = str23;
            str12 = str26;
            str13 = str34;
            i = i5;
            i2 = i4;
            str14 = str31;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdTreasureHuntBall(i, str14, i2, j2, j3, str8, str2, list, str7, str, str6, str3, str5, str11, str4, str10, str9, str13, str12, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdTreasureHuntBall value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdTreasureHuntBall.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}