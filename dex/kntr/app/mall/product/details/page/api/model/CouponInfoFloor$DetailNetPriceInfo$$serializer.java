package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CouponInfoFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CouponInfoFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/CouponInfoFloor.DetailNetPriceInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CouponInfoFloor$DetailNetPriceInfo$$serializer implements GeneratedSerializer<CouponInfoFloor.DetailNetPriceInfo> {
    public static final int $stable;
    public static final CouponInfoFloor$DetailNetPriceInfo$$serializer INSTANCE = new CouponInfoFloor$DetailNetPriceInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.CouponInfoFloor.DetailNetPriceInfo", INSTANCE, 11);
        pluginGeneratedSerialDescriptor.addElement("detailCouponInfo", true);
        pluginGeneratedSerialDescriptor.addElement("detailCouponInfos", true);
        pluginGeneratedSerialDescriptor.addElement("detailPrice", true);
        pluginGeneratedSerialDescriptor.addElement("detailPriceType", true);
        pluginGeneratedSerialDescriptor.addElement("netPriceDescription", true);
        pluginGeneratedSerialDescriptor.addElement("netPriceExpression", true);
        pluginGeneratedSerialDescriptor.addElement("netPriceExpressions", true);
        pluginGeneratedSerialDescriptor.addElement("netPricePreDesc", true);
        pluginGeneratedSerialDescriptor.addElement("netPriceStartsDescription", true);
        pluginGeneratedSerialDescriptor.addElement("netPriceType", true);
        pluginGeneratedSerialDescriptor.addElement("netPriceUrl", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CouponInfoFloor$DetailNetPriceInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = CouponInfoFloor.DetailNetPriceInfo.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[1].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[6].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final CouponInfoFloor.DetailNetPriceInfo deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        CouponInfoFloor.DetailNetPriceInfo.NetPriceExpression netPriceExpression;
        int i;
        Integer num;
        String str;
        String str2;
        List list;
        String str3;
        String str4;
        String str5;
        Integer num2;
        List list2;
        CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo detailCouponInfo;
        CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo detailCouponInfo2;
        Integer num3;
        Integer num4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = CouponInfoFloor.DetailNetPriceInfo.$childSerializers;
        CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo detailCouponInfo3 = null;
        if (beginStructure.decodeSequentially()) {
            detailCouponInfo = (CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo$$serializer.INSTANCE, (Object) null);
            List list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), (Object) null);
            String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), (Object) null);
            i = 2047;
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, IntSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            str5 = str7;
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            list2 = list3;
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, (Object) null);
            netPriceExpression = (CouponInfoFloor.DetailNetPriceInfo.NetPriceExpression) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$$serializer.INSTANCE, (Object) null);
            str4 = str6;
        } else {
            List list4 = null;
            Integer num5 = null;
            String str8 = null;
            netPriceExpression = null;
            String str9 = null;
            List list5 = null;
            String str10 = null;
            String str11 = null;
            boolean z = true;
            int i2 = 0;
            Integer num6 = null;
            String str12 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        num4 = num5;
                        z = false;
                        break;
                    case 0:
                        num4 = num5;
                        detailCouponInfo3 = (CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo$$serializer.INSTANCE, detailCouponInfo3);
                        i2 |= 1;
                        break;
                    case 1:
                        detailCouponInfo2 = detailCouponInfo3;
                        num3 = num5;
                        list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list4);
                        i2 |= 2;
                        num5 = num3;
                        detailCouponInfo3 = detailCouponInfo2;
                    case 2:
                        detailCouponInfo2 = detailCouponInfo3;
                        num3 = num5;
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str12);
                        i2 |= 4;
                        num5 = num3;
                        detailCouponInfo3 = detailCouponInfo2;
                    case 3:
                        detailCouponInfo2 = detailCouponInfo3;
                        num3 = num5;
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num6);
                        i2 |= 8;
                        num5 = num3;
                        detailCouponInfo3 = detailCouponInfo2;
                    case 4:
                        detailCouponInfo2 = detailCouponInfo3;
                        num3 = num5;
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str10);
                        i2 |= 16;
                        num5 = num3;
                        detailCouponInfo3 = detailCouponInfo2;
                    case 5:
                        detailCouponInfo2 = detailCouponInfo3;
                        num3 = num5;
                        netPriceExpression = (CouponInfoFloor.DetailNetPriceInfo.NetPriceExpression) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$$serializer.INSTANCE, netPriceExpression);
                        i2 |= 32;
                        num5 = num3;
                        detailCouponInfo3 = detailCouponInfo2;
                    case 6:
                        detailCouponInfo2 = detailCouponInfo3;
                        list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), list5);
                        i2 |= 64;
                        detailCouponInfo3 = detailCouponInfo2;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        detailCouponInfo2 = detailCouponInfo3;
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str8);
                        i2 |= 128;
                        detailCouponInfo3 = detailCouponInfo2;
                    case 8:
                        detailCouponInfo2 = detailCouponInfo3;
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str11);
                        i2 |= 256;
                        detailCouponInfo3 = detailCouponInfo2;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        detailCouponInfo2 = detailCouponInfo3;
                        num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, IntSerializer.INSTANCE, num5);
                        i2 |= 512;
                        detailCouponInfo3 = detailCouponInfo2;
                    case 10:
                        detailCouponInfo2 = detailCouponInfo3;
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str9);
                        i2 |= 1024;
                        detailCouponInfo3 = detailCouponInfo2;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
                num5 = num4;
            }
            Integer num7 = num5;
            i = i2;
            num = num6;
            str = str12;
            str2 = str9;
            list = list5;
            str3 = str8;
            str4 = str10;
            str5 = str11;
            num2 = num7;
            CouponInfoFloor.DetailNetPriceInfo.DetailCouponInfo detailCouponInfo4 = detailCouponInfo3;
            list2 = list4;
            detailCouponInfo = detailCouponInfo4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CouponInfoFloor.DetailNetPriceInfo(i, detailCouponInfo, list2, str, num, str4, netPriceExpression, list, str3, str5, num2, str2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CouponInfoFloor.DetailNetPriceInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CouponInfoFloor.DetailNetPriceInfo.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}