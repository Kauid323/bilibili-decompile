package kntr.app.digital.preview.api;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.protocol.report.SubmitType;
import kntr.app.digital.preview.CardNumberGradientColor;
import kntr.app.digital.preview.CardNumberGradientColor$$serializer;
import kntr.app.digital.preview.api.CardData;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CardPreviewModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/digital/preview/api/CardData.Data.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/digital/preview/api/CardData$Data;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CardData$Data$$serializer implements GeneratedSerializer<CardData.Data> {
    public static final int $stable;
    public static final CardData$Data$$serializer INSTANCE = new CardData$Data$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.digital.preview.api.CardData.Data", INSTANCE, 26);
        pluginGeneratedSerialDescriptor.addElement("unique_id", true);
        pluginGeneratedSerialDescriptor.addElement("card_id", true);
        pluginGeneratedSerialDescriptor.addElement("card_type_id", true);
        pluginGeneratedSerialDescriptor.addElement("highlighted", true);
        pluginGeneratedSerialDescriptor.addElement("card_name", true);
        pluginGeneratedSerialDescriptor.addElement("card_image", true);
        pluginGeneratedSerialDescriptor.addElement("card_image_download", true);
        pluginGeneratedSerialDescriptor.addElement("card_no", true);
        pluginGeneratedSerialDescriptor.addElement("card_video", true);
        pluginGeneratedSerialDescriptor.addElement("card_video_download", true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.CARD_TYPE, true);
        pluginGeneratedSerialDescriptor.addElement("card_sub_type", true);
        pluginGeneratedSerialDescriptor.addElement("desc_tag", true);
        pluginGeneratedSerialDescriptor.addElement("top_text", true);
        pluginGeneratedSerialDescriptor.addElement("smelt_lock_status", true);
        pluginGeneratedSerialDescriptor.addElement("holding_rate", true);
        pluginGeneratedSerialDescriptor.addElement("holding_rate_url", true);
        pluginGeneratedSerialDescriptor.addElement("card_scarcity", true);
        pluginGeneratedSerialDescriptor.addElement(SubmitType.MMA_KEY_PLAY, true);
        pluginGeneratedSerialDescriptor.addElement("is_mute", true);
        pluginGeneratedSerialDescriptor.addElement("badge_url", true);
        pluginGeneratedSerialDescriptor.addElement("smelt_info", true);
        pluginGeneratedSerialDescriptor.addElement("color_format", true);
        pluginGeneratedSerialDescriptor.addElement("actions", true);
        pluginGeneratedSerialDescriptor.addElement("modules", true);
        pluginGeneratedSerialDescriptor.addElement("cardLockStatus", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CardData$Data$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = CardData.Data.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable((KSerializer) lazyArr[8].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[9].getValue()), IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(DescTag$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(TopText$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(Play$$serializer.INSTANCE), BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(SmeltInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(CardNumberGradientColor$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[23].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[24].getValue()), lazyArr[25].getValue()};
    }

    public final CardData.Data deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        List list;
        String str;
        CardNumberGradientColor cardNumberGradientColor;
        String str2;
        Integer num;
        DescTag descTag;
        CardData.Data.CardLockStatus cardLockStatus;
        String str3;
        String str4;
        int i;
        List list2;
        String str5;
        List list3;
        boolean z;
        int i2;
        List list4;
        TopText topText;
        long j2;
        int i3;
        String str6;
        SmeltInfo smeltInfo;
        Play play;
        int i4;
        String str7;
        String str8;
        boolean z2;
        long j3;
        DescTag descTag2;
        int i5;
        int i6;
        CardData.Data.CardLockStatus cardLockStatus2;
        Lazy[] lazyArr2;
        List list5;
        List list6;
        Lazy[] lazyArr3;
        CardData.Data.CardLockStatus cardLockStatus3;
        List list7;
        CardData.Data.CardLockStatus cardLockStatus4;
        int i7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = CardData.Data.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 1);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 2);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 3);
            str3 = beginStructure.decodeStringElement(serialDescriptor, 4);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 5);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 7);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 10);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 11);
            TopText topText2 = (TopText) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, TopText$$serializer.INSTANCE, (Object) null);
            descTag = (DescTag) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, DescTag$$serializer.INSTANCE, (Object) null);
            Integer num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, IntSerializer.INSTANCE, (Object) null);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, (Object) null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, (Object) null);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 17);
            Play play2 = (Play) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, Play$$serializer.INSTANCE, (Object) null);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 19);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 20);
            SmeltInfo smeltInfo2 = (SmeltInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, SmeltInfo$$serializer.INSTANCE, (Object) null);
            CardNumberGradientColor cardNumberGradientColor2 = (CardNumberGradientColor) beginStructure.decodeNullableSerializableElement(serialDescriptor, 22, CardNumberGradientColor$$serializer.INSTANCE, (Object) null);
            List list8 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 23, (DeserializationStrategy) lazyArr[23].getValue(), (Object) null);
            list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 24, (DeserializationStrategy) lazyArr[24].getValue(), (Object) null);
            cardLockStatus = (CardData.Data.CardLockStatus) beginStructure.decodeSerializableElement(serialDescriptor, 25, (DeserializationStrategy) lazyArr[25].getValue(), (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), (Object) null);
            i2 = decodeIntElement;
            str8 = decodeStringElement;
            str6 = decodeStringElement2;
            num = num2;
            z = decodeBooleanElement;
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), (Object) null);
            i4 = 67108863;
            str5 = decodeStringElement4;
            i = decodeIntElement2;
            j2 = decodeLongElement;
            play = play2;
            z2 = decodeBooleanElement2;
            smeltInfo = smeltInfo2;
            str2 = str9;
            str4 = decodeStringElement3;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            j3 = decodeLongElement2;
            i3 = decodeIntElement3;
            cardNumberGradientColor = cardNumberGradientColor2;
            list4 = list8;
            str7 = str10;
            topText = topText2;
        } else {
            boolean z3 = true;
            int i8 = 0;
            int i9 = 0;
            boolean z4 = false;
            boolean z5 = false;
            int i10 = 0;
            CardData.Data.CardLockStatus cardLockStatus5 = null;
            List list9 = null;
            SmeltInfo smeltInfo3 = null;
            Play play3 = null;
            String str11 = null;
            String str12 = null;
            Integer num3 = null;
            DescTag descTag3 = null;
            TopText topText3 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            String str18 = null;
            List list10 = null;
            long j4 = 0;
            long j5 = 0;
            CardNumberGradientColor cardNumberGradientColor3 = null;
            List list11 = null;
            List list12 = null;
            int i11 = 0;
            while (z3) {
                List list13 = list9;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        cardLockStatus2 = cardLockStatus5;
                        lazyArr2 = lazyArr;
                        list5 = list12;
                        list6 = list13;
                        z3 = false;
                        cardLockStatus5 = cardLockStatus2;
                        lazyArr = lazyArr2;
                        list9 = list6;
                        list12 = list5;
                    case 0:
                        cardLockStatus2 = cardLockStatus5;
                        lazyArr2 = lazyArr;
                        list5 = list12;
                        list6 = list13;
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i11 |= 1;
                        cardLockStatus5 = cardLockStatus2;
                        lazyArr = lazyArr2;
                        list9 = list6;
                        list12 = list5;
                    case 1:
                        cardLockStatus2 = cardLockStatus5;
                        lazyArr2 = lazyArr;
                        list5 = list12;
                        list6 = list13;
                        j4 = beginStructure.decodeLongElement(serialDescriptor, 1);
                        i11 |= 2;
                        cardLockStatus5 = cardLockStatus2;
                        lazyArr = lazyArr2;
                        list9 = list6;
                        list12 = list5;
                    case 2:
                        cardLockStatus2 = cardLockStatus5;
                        lazyArr2 = lazyArr;
                        list5 = list12;
                        list6 = list13;
                        j5 = beginStructure.decodeLongElement(serialDescriptor, 2);
                        i11 |= 4;
                        cardLockStatus5 = cardLockStatus2;
                        lazyArr = lazyArr2;
                        list9 = list6;
                        list12 = list5;
                    case 3:
                        cardLockStatus2 = cardLockStatus5;
                        lazyArr2 = lazyArr;
                        list5 = list12;
                        list6 = list13;
                        z5 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i11 |= 8;
                        cardLockStatus5 = cardLockStatus2;
                        lazyArr = lazyArr2;
                        list9 = list6;
                        list12 = list5;
                    case 4:
                        cardLockStatus2 = cardLockStatus5;
                        lazyArr2 = lazyArr;
                        list5 = list12;
                        list6 = list13;
                        str14 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i11 |= 16;
                        cardLockStatus5 = cardLockStatus2;
                        lazyArr = lazyArr2;
                        list9 = list6;
                        list12 = list5;
                    case 5:
                        cardLockStatus2 = cardLockStatus5;
                        lazyArr2 = lazyArr;
                        list5 = list12;
                        list6 = list13;
                        str15 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i11 |= 32;
                        cardLockStatus5 = cardLockStatus2;
                        lazyArr = lazyArr2;
                        list9 = list6;
                        list12 = list5;
                    case 6:
                        lazyArr3 = lazyArr;
                        list5 = list12;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str18);
                        i11 |= 64;
                        list9 = list13;
                        cardLockStatus5 = cardLockStatus5;
                        list10 = list10;
                        lazyArr = lazyArr3;
                        list12 = list5;
                    case 7:
                        cardLockStatus3 = cardLockStatus5;
                        lazyArr3 = lazyArr;
                        list5 = list12;
                        list7 = list13;
                        str16 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i11 |= 128;
                        list9 = list7;
                        cardLockStatus5 = cardLockStatus3;
                        lazyArr = lazyArr3;
                        list12 = list5;
                    case 8:
                        cardLockStatus3 = cardLockStatus5;
                        list5 = list12;
                        list7 = list13;
                        lazyArr3 = lazyArr;
                        list10 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), list10);
                        i11 |= 256;
                        list9 = list7;
                        cardLockStatus5 = cardLockStatus3;
                        lazyArr = lazyArr3;
                        list12 = list5;
                    case 9:
                        list5 = list12;
                        list9 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), list13);
                        i11 |= 512;
                        cardLockStatus5 = cardLockStatus5;
                        list12 = list5;
                    case 10:
                        cardLockStatus4 = cardLockStatus5;
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 10);
                        i11 |= 1024;
                        cardLockStatus5 = cardLockStatus4;
                        list9 = list13;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        cardLockStatus4 = cardLockStatus5;
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 11);
                        i11 |= 2048;
                        cardLockStatus5 = cardLockStatus4;
                        list9 = list13;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        cardLockStatus4 = cardLockStatus5;
                        descTag3 = (DescTag) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, DescTag$$serializer.INSTANCE, descTag3);
                        i11 |= 4096;
                        cardLockStatus5 = cardLockStatus4;
                        list9 = list13;
                    case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                        descTag2 = descTag3;
                        topText3 = (TopText) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, TopText$$serializer.INSTANCE, topText3);
                        i11 |= 8192;
                        list9 = list13;
                        descTag3 = descTag2;
                    case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                        descTag2 = descTag3;
                        num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, IntSerializer.INSTANCE, num3);
                        i11 |= 16384;
                        list9 = list13;
                        descTag3 = descTag2;
                    case AdditionVote2.CARD_TYPE_FIELD_NUMBER /* 15 */:
                        descTag2 = descTag3;
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str12);
                        i5 = 32768;
                        i11 |= i5;
                        list9 = list13;
                        descTag3 = descTag2;
                    case AdditionVote2.TIPS_FIELD_NUMBER /* 16 */:
                        descTag2 = descTag3;
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str11);
                        i5 = 65536;
                        i11 |= i5;
                        list9 = list13;
                        descTag3 = descTag2;
                    case AdditionVote2.URI_FIELD_NUMBER /* 17 */:
                        i8 = beginStructure.decodeIntElement(serialDescriptor, 17);
                        i7 = 131072;
                        i11 |= i7;
                        list9 = list13;
                    case AdditionVote2.IS_VOTED_FIELD_NUMBER /* 18 */:
                        descTag2 = descTag3;
                        play3 = (Play) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, Play$$serializer.INSTANCE, play3);
                        i5 = 262144;
                        i11 |= i5;
                        list9 = list13;
                        descTag3 = descTag2;
                    case AdditionVote2.CHOICE_CNT_FIELD_NUMBER /* 19 */:
                        z4 = beginStructure.decodeBooleanElement(serialDescriptor, 19);
                        i7 = 524288;
                        i11 |= i7;
                        list9 = list13;
                    case AdditionVote2.DEFAULE_SELECT_SHARE_FIELD_NUMBER /* 20 */:
                        str17 = beginStructure.decodeStringElement(serialDescriptor, 20);
                        i7 = 1048576;
                        i11 |= i7;
                        list9 = list13;
                    case AdditionVote2.ONLY_FANS_VOTE_FIELD_NUMBER /* 21 */:
                        descTag2 = descTag3;
                        smeltInfo3 = (SmeltInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, SmeltInfo$$serializer.INSTANCE, smeltInfo3);
                        i5 = 2097152;
                        i11 |= i5;
                        list9 = list13;
                        descTag3 = descTag2;
                    case AdditionVote2.VOTE_OWNER_MID_FIELD_NUMBER /* 22 */:
                        descTag2 = descTag3;
                        cardNumberGradientColor3 = (CardNumberGradientColor) beginStructure.decodeNullableSerializableElement(serialDescriptor, 22, CardNumberGradientColor$$serializer.INSTANCE, cardNumberGradientColor3);
                        i5 = 4194304;
                        i11 |= i5;
                        list9 = list13;
                        descTag3 = descTag2;
                    case 23:
                        descTag2 = descTag3;
                        list11 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 23, (DeserializationStrategy) lazyArr[23].getValue(), list11);
                        i6 = 8388608;
                        i11 |= i6;
                        list9 = list13;
                        descTag3 = descTag2;
                    case 24:
                        descTag2 = descTag3;
                        list12 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 24, (DeserializationStrategy) lazyArr[24].getValue(), list12);
                        i5 = 16777216;
                        i11 |= i5;
                        list9 = list13;
                        descTag3 = descTag2;
                    case 25:
                        descTag2 = descTag3;
                        cardLockStatus5 = (CardData.Data.CardLockStatus) beginStructure.decodeSerializableElement(serialDescriptor, 25, (DeserializationStrategy) lazyArr[25].getValue(), cardLockStatus5);
                        i6 = 33554432;
                        i11 |= i6;
                        list9 = list13;
                        descTag3 = descTag2;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list9;
            str = str18;
            cardNumberGradientColor = cardNumberGradientColor3;
            str2 = str12;
            num = num3;
            descTag = descTag3;
            cardLockStatus = cardLockStatus5;
            str3 = str14;
            str4 = str16;
            i = i9;
            list2 = list10;
            str5 = str17;
            list3 = list12;
            z = z5;
            i2 = i10;
            list4 = list11;
            topText = topText3;
            j2 = j4;
            i3 = i8;
            str6 = str15;
            smeltInfo = smeltInfo3;
            play = play3;
            i4 = i11;
            str7 = str11;
            str8 = str13;
            z2 = z4;
            j3 = j5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CardData.Data(i4, str8, j2, j3, z, str3, str6, str, str4, list2, list, i2, i, descTag, topText, num, str2, str7, i3, play, z2, str5, smeltInfo, cardNumberGradientColor, list4, list3, cardLockStatus, null);
    }

    public final void serialize(Encoder encoder, CardData.Data value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CardData.Data.write$Self$preview_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}