package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.AdvStateFloor;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdvStateFloor.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/AdvStateFloor.AdvState.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdvStateFloor$AdvState$$serializer implements GeneratedSerializer<AdvStateFloor.AdvState> {
    public static final int $stable;
    public static final AdvStateFloor$AdvState$$serializer INSTANCE = new AdvStateFloor$AdvState$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.AdvStateFloor.AdvState", INSTANCE, 11);
        pluginGeneratedSerialDescriptor.addElement("activityDeposit", true);
        pluginGeneratedSerialDescriptor.addElement("batchRecords", true);
        pluginGeneratedSerialDescriptor.addElement("deposit", true);
        pluginGeneratedSerialDescriptor.addElement("depositType", true);
        pluginGeneratedSerialDescriptor.addElement("maxActivityDeposit", true);
        pluginGeneratedSerialDescriptor.addElement("maxDeposit", true);
        pluginGeneratedSerialDescriptor.addElement("preSale", true);
        pluginGeneratedSerialDescriptor.addElement("presaleEndOrderTime", true);
        pluginGeneratedSerialDescriptor.addElement("presaleStartOrderTime", true);
        pluginGeneratedSerialDescriptor.addElement("remain", true);
        pluginGeneratedSerialDescriptor.addElement("state", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private AdvStateFloor$AdvState$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = AdvStateFloor.AdvState.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[1].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[10].getValue())};
    }

    public final AdvStateFloor.AdvState deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        String str;
        int i;
        List list;
        Integer num;
        Boolean bool;
        String str2;
        String str3;
        Integer num2;
        Integer num3;
        Integer num4;
        String str4;
        List list2;
        String str5;
        List list3;
        List list4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = AdvStateFloor.AdvState.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            List list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), (Object) null);
            String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), (Object) null);
            i = 2047;
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, IntSerializer.INSTANCE, (Object) null);
            list = list5;
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, IntSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, (Object) null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, BooleanSerializer.INSTANCE, (Object) null);
            num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            str2 = str6;
        } else {
            str = null;
            List list6 = null;
            Integer num5 = null;
            Integer num6 = null;
            Boolean bool2 = null;
            String str7 = null;
            Integer num7 = null;
            String str8 = null;
            Integer num8 = null;
            boolean z = true;
            String str9 = null;
            int i2 = 0;
            List list7 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        list4 = list6;
                        z = false;
                        list6 = list4;
                    case 0:
                        list4 = list6;
                        str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str);
                        i2 |= 1;
                        list6 = list4;
                    case 1:
                        str5 = str;
                        list3 = list6;
                        list7 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list7);
                        i2 |= 2;
                        list6 = list3;
                        str = str5;
                    case 2:
                        str5 = str;
                        list3 = list6;
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str9);
                        i2 |= 4;
                        list6 = list3;
                        str = str5;
                    case 3:
                        str5 = str;
                        list3 = list6;
                        num8 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num8);
                        i2 |= 8;
                        list6 = list3;
                        str = str5;
                    case 4:
                        str5 = str;
                        list3 = list6;
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str7);
                        i2 |= 16;
                        list6 = list3;
                        str = str5;
                    case 5:
                        str5 = str;
                        list3 = list6;
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str8);
                        i2 |= 32;
                        list6 = list3;
                        str = str5;
                    case 6:
                        str5 = str;
                        list3 = list6;
                        bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, BooleanSerializer.INSTANCE, bool2);
                        i2 |= 64;
                        list6 = list3;
                        str = str5;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str5 = str;
                        list3 = list6;
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, IntSerializer.INSTANCE, num6);
                        i2 |= 128;
                        list6 = list3;
                        str = str5;
                    case 8:
                        str5 = str;
                        list3 = list6;
                        num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, num5);
                        i2 |= 256;
                        list6 = list3;
                        str = str5;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        str5 = str;
                        list3 = list6;
                        num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, IntSerializer.INSTANCE, num7);
                        i2 |= 512;
                        list6 = list3;
                        str = str5;
                    case 10:
                        str5 = str;
                        list6 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), list6);
                        i2 |= 1024;
                        str = str5;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            List list8 = list6;
            i = i2;
            list = list7;
            num = num7;
            bool = bool2;
            str2 = str7;
            str3 = str8;
            num2 = num6;
            num3 = num8;
            num4 = num5;
            str4 = str9;
            list2 = list8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdvStateFloor.AdvState(i, str, list, str4, num3, str2, str3, bool, num2, num4, num, list2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdvStateFloor.AdvState value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdvStateFloor.AdvState.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}