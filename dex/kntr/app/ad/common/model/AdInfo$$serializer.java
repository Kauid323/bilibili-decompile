package kntr.app.ad.common.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import java.util.Arrays;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
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
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonNames;

/* compiled from: AdInfo.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdInfo;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdInfo$$serializer implements GeneratedSerializer<AdInfo> {
    public static final AdInfo$$serializer INSTANCE = new AdInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdInfo", INSTANCE, 28);
        pluginGeneratedSerialDescriptor.addElement("is_ad_loc", true);
        pluginGeneratedSerialDescriptor.addElement("source_id", true);
        final String[] strArr = {"source_id", "source", ReportBuildInParam.SRC_ID};
        pluginGeneratedSerialDescriptor.pushAnnotation(new JsonNames(strArr) { // from class: kntr.app.ad.common.model.AdInfo$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0
            private final /* synthetic */ String[] names;

            {
                Intrinsics.checkNotNullParameter(strArr, "names");
                this.names = strArr;
            }

            public final /* synthetic */ Class annotationType() {
                return JsonNames.class;
            }

            public final boolean equals(Object obj) {
                return (obj instanceof JsonNames) && Arrays.equals(names(), ((JsonNames) obj).names());
            }

            public final int hashCode() {
                return ("names".hashCode() * 127) ^ Arrays.hashCode(this.names);
            }

            public final /* synthetic */ String[] names() {
                return this.names;
            }

            public final String toString() {
                return "@kotlinx.serialization.json.JsonNames(names=" + Arrays.toString(this.names) + ")";
            }
        });
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.RESOURCE_ID, true);
        final String[] strArr2 = {ReportBuildInParam.RESOURCE_ID, "resource"};
        pluginGeneratedSerialDescriptor.pushAnnotation(new JsonNames(strArr2) { // from class: kntr.app.ad.common.model.AdInfo$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0
            private final /* synthetic */ String[] names;

            {
                Intrinsics.checkNotNullParameter(strArr2, "names");
                this.names = strArr2;
            }

            public final /* synthetic */ Class annotationType() {
                return JsonNames.class;
            }

            public final boolean equals(Object obj) {
                return (obj instanceof JsonNames) && Arrays.equals(names(), ((JsonNames) obj).names());
            }

            public final int hashCode() {
                return ("names".hashCode() * 127) ^ Arrays.hashCode(this.names);
            }

            public final /* synthetic */ String[] names() {
                return this.names;
            }

            public final String toString() {
                return "@kotlinx.serialization.json.JsonNames(names=" + Arrays.toString(this.names) + ")";
            }
        });
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.REQUEST_ID, true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.SERVER_TYPE, true);
        pluginGeneratedSerialDescriptor.addElement("client_ip", true);
        pluginGeneratedSerialDescriptor.addElement("index", true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.CARD_INDEX, true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.ID, true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.IS_AD, true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.CREATIVE_ID, true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.CREATIVE_TYPE, true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.CREATIVE_STYLE, true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.CARD_TYPE, true);
        pluginGeneratedSerialDescriptor.addElement("ad_cb", true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.CM_MARK, true);
        pluginGeneratedSerialDescriptor.addElement("live_booking_id", true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.NATURE_AD, true);
        pluginGeneratedSerialDescriptor.addElement("track_id", true);
        pluginGeneratedSerialDescriptor.addElement("shopId", true);
        pluginGeneratedSerialDescriptor.addElement("upMid", true);
        pluginGeneratedSerialDescriptor.addElement("productId", true);
        pluginGeneratedSerialDescriptor.addElement("replaceStrategy", true);
        pluginGeneratedSerialDescriptor.addElement("fromTrackId", true);
        pluginGeneratedSerialDescriptor.addElement("cmFromTrackId", true);
        pluginGeneratedSerialDescriptor.addElement("itemId", true);
        pluginGeneratedSerialDescriptor.addElement("itemSource", true);
        pluginGeneratedSerialDescriptor.addElement("extraParams", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BooleanSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LongSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, BooleanSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, LongSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LongSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LongSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final AdInfo deserialize(Decoder decoder) {
        int i;
        String str;
        String str2;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        String str3;
        long j8;
        long j9;
        int i4;
        String str4;
        String str5;
        long j10;
        String str6;
        int i5;
        long j11;
        String str7;
        long j12;
        long j13;
        String str8;
        int i6;
        long j14;
        int i7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 0);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 1);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 2);
            long decodeLongElement3 = beginStructure.decodeLongElement(serialDescriptor, 4);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            long decodeLongElement4 = beginStructure.decodeLongElement(serialDescriptor, 6);
            long decodeLongElement5 = beginStructure.decodeLongElement(serialDescriptor, 7);
            long decodeLongElement6 = beginStructure.decodeLongElement(serialDescriptor, 8);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 9);
            long decodeLongElement7 = beginStructure.decodeLongElement(serialDescriptor, 10);
            long decodeLongElement8 = beginStructure.decodeLongElement(serialDescriptor, 11);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 12);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 15);
            long decodeLongElement9 = beginStructure.decodeLongElement(serialDescriptor, 16);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 17);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, (Object) null);
            long decodeLongElement10 = beginStructure.decodeLongElement(serialDescriptor, 19);
            long decodeLongElement11 = beginStructure.decodeLongElement(serialDescriptor, 20);
            long decodeLongElement12 = beginStructure.decodeLongElement(serialDescriptor, 21);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 22);
            String str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 23, StringSerializer.INSTANCE, (Object) null);
            String str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 24, StringSerializer.INSTANCE, (Object) null);
            long decodeLongElement13 = beginStructure.decodeLongElement(serialDescriptor, 25);
            int decodeIntElement5 = beginStructure.decodeIntElement(serialDescriptor, 26);
            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 27, StringSerializer.INSTANCE, (Object) null);
            i6 = decodeIntElement5;
            j7 = decodeLongElement13;
            str5 = str14;
            str4 = str13;
            j14 = decodeLongElement8;
            i = decodeIntElement4;
            j13 = decodeLongElement9;
            i4 = 268435455;
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            z2 = decodeBooleanElement2;
            i3 = decodeIntElement;
            j12 = decodeLongElement;
            z = decodeBooleanElement;
            str3 = str10;
            str = str12;
            j10 = decodeLongElement3;
            i2 = decodeIntElement3;
            str2 = str9;
            j4 = decodeLongElement6;
            i5 = decodeIntElement2;
            str6 = str11;
            j3 = decodeLongElement4;
            j2 = decodeLongElement5;
            j8 = decodeLongElement10;
            j5 = decodeLongElement11;
            j6 = decodeLongElement12;
            j11 = decodeLongElement2;
            j9 = decodeLongElement7;
        } else {
            String str15 = null;
            String str16 = null;
            String str17 = null;
            String str18 = null;
            String str19 = null;
            String str20 = null;
            boolean z3 = true;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            boolean z4 = false;
            int i11 = 0;
            long j15 = 0;
            long j16 = 0;
            long j17 = 0;
            long j18 = 0;
            long j19 = 0;
            long j20 = 0;
            long j21 = 0;
            long j22 = 0;
            long j23 = 0;
            long j24 = 0;
            long j25 = 0;
            long j26 = 0;
            long j27 = 0;
            String str21 = null;
            int i12 = 0;
            boolean z5 = false;
            int i13 = 0;
            String str22 = null;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        Unit unit = Unit.INSTANCE;
                        z3 = false;
                        continue;
                    case 0:
                        boolean decodeBooleanElement3 = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                        i8 |= 1;
                        Unit unit2 = Unit.INSTANCE;
                        z5 = decodeBooleanElement3;
                        continue;
                    case 1:
                        j17 = beginStructure.decodeLongElement(serialDescriptor, 1);
                        i8 |= 2;
                        Unit unit3 = Unit.INSTANCE;
                        break;
                    case 2:
                        j21 = beginStructure.decodeLongElement(serialDescriptor, 2);
                        i8 |= 4;
                        Unit unit4 = Unit.INSTANCE;
                        break;
                    case 3:
                        i8 |= 8;
                        Unit unit5 = Unit.INSTANCE;
                        str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str22);
                        break;
                    case 4:
                        j16 = beginStructure.decodeLongElement(serialDescriptor, 4);
                        i8 |= 16;
                        Unit unit6 = Unit.INSTANCE;
                        break;
                    case 5:
                        i8 |= 32;
                        Unit unit7 = Unit.INSTANCE;
                        str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str21);
                        break;
                    case 6:
                        j22 = beginStructure.decodeLongElement(serialDescriptor, 6);
                        i8 |= 64;
                        Unit unit8 = Unit.INSTANCE;
                        break;
                    case 7:
                        j19 = beginStructure.decodeLongElement(serialDescriptor, 7);
                        i8 |= 128;
                        Unit unit82 = Unit.INSTANCE;
                        break;
                    case 8:
                        j23 = beginStructure.decodeLongElement(serialDescriptor, 8);
                        i8 |= 256;
                        Unit unit822 = Unit.INSTANCE;
                        break;
                    case 9:
                        z4 = beginStructure.decodeBooleanElement(serialDescriptor, 9);
                        i8 |= 512;
                        Unit unit8222 = Unit.INSTANCE;
                        break;
                    case 10:
                        j18 = beginStructure.decodeLongElement(serialDescriptor, 10);
                        i8 |= 1024;
                        Unit unit82222 = Unit.INSTANCE;
                        break;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        j24 = beginStructure.decodeLongElement(serialDescriptor, 11);
                        i8 |= 2048;
                        Unit unit822222 = Unit.INSTANCE;
                        break;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 12);
                        i8 |= 4096;
                        Unit unit9 = Unit.INSTANCE;
                        break;
                    case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                        i8 |= 8192;
                        Unit unit10 = Unit.INSTANCE;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str18);
                        break;
                    case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str16);
                        i8 |= 16384;
                        Unit unit11 = Unit.INSTANCE;
                        break;
                    case AdditionVote2.CARD_TYPE_FIELD_NUMBER /* 15 */:
                        int decodeIntElement6 = beginStructure.decodeIntElement(serialDescriptor, 15);
                        i8 |= 32768;
                        Unit unit12 = Unit.INSTANCE;
                        i13 = decodeIntElement6;
                        continue;
                    case AdditionVote2.TIPS_FIELD_NUMBER /* 16 */:
                        j20 = beginStructure.decodeLongElement(serialDescriptor, 16);
                        i8 |= 65536;
                        Unit unit13 = Unit.INSTANCE;
                        break;
                    case AdditionVote2.URI_FIELD_NUMBER /* 17 */:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 17);
                        i8 |= 131072;
                        Unit unit14 = Unit.INSTANCE;
                        break;
                    case AdditionVote2.IS_VOTED_FIELD_NUMBER /* 18 */:
                        i8 |= 262144;
                        Unit unit15 = Unit.INSTANCE;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, str17);
                        break;
                    case AdditionVote2.CHOICE_CNT_FIELD_NUMBER /* 19 */:
                        j15 = beginStructure.decodeLongElement(serialDescriptor, 19);
                        i7 = 524288;
                        i8 |= i7;
                        Unit unit16 = Unit.INSTANCE;
                        break;
                    case AdditionVote2.DEFAULE_SELECT_SHARE_FIELD_NUMBER /* 20 */:
                        j25 = beginStructure.decodeLongElement(serialDescriptor, 20);
                        i7 = 1048576;
                        i8 |= i7;
                        Unit unit162 = Unit.INSTANCE;
                        break;
                    case AdditionVote2.ONLY_FANS_VOTE_FIELD_NUMBER /* 21 */:
                        j26 = beginStructure.decodeLongElement(serialDescriptor, 21);
                        i7 = 2097152;
                        i8 |= i7;
                        Unit unit1622 = Unit.INSTANCE;
                        break;
                    case AdditionVote2.VOTE_OWNER_MID_FIELD_NUMBER /* 22 */:
                        i12 = beginStructure.decodeIntElement(serialDescriptor, 22);
                        i7 = 4194304;
                        i8 |= i7;
                        Unit unit16222 = Unit.INSTANCE;
                        break;
                    case 23:
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 23, StringSerializer.INSTANCE, str15);
                        i7 = 8388608;
                        i8 |= i7;
                        Unit unit162222 = Unit.INSTANCE;
                        break;
                    case 24:
                        i8 |= 16777216;
                        Unit unit17 = Unit.INSTANCE;
                        str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 24, StringSerializer.INSTANCE, str20);
                        break;
                    case 25:
                        j27 = beginStructure.decodeLongElement(serialDescriptor, 25);
                        i7 = 33554432;
                        i8 |= i7;
                        Unit unit1622222 = Unit.INSTANCE;
                        break;
                    case 26:
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 26);
                        i7 = 67108864;
                        i8 |= i7;
                        Unit unit16222222 = Unit.INSTANCE;
                        break;
                    case 27:
                        i8 |= 134217728;
                        Unit unit18 = Unit.INSTANCE;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 27, StringSerializer.INSTANCE, str19);
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i12;
            str = str17;
            str2 = str21;
            z = z5;
            i2 = i10;
            z2 = z4;
            i3 = i11;
            j2 = j19;
            j3 = j22;
            j4 = j23;
            j5 = j25;
            j6 = j26;
            j7 = j27;
            str3 = str18;
            j8 = j15;
            j9 = j18;
            i4 = i8;
            str4 = str15;
            str5 = str20;
            j10 = j16;
            str6 = str16;
            i5 = i13;
            j11 = j21;
            String str23 = str19;
            str7 = str22;
            j12 = j17;
            j13 = j20;
            str8 = str23;
            i6 = i9;
            j14 = j24;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdInfo(i4, z, j12, j11, str7, j10, str2, j3, j2, j4, z2, j9, j14, i3, str3, str6, i5, j13, i2, str, j8, j5, j6, i, str4, str5, j7, i6, str8, null);
    }

    public final void serialize(Encoder encoder, AdInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdInfo.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}