package kntr.app.mall.product.details.page.api.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ActionIconModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/mall/product/details/page/api/model/ActionIconModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActionIconModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ActionIconModel$$serializer implements GeneratedSerializer<ActionIconModel> {
    public static final int $stable;
    public static final ActionIconModel$$serializer INSTANCE = new ActionIconModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.ActionIconModel", INSTANCE, 13);
        pluginGeneratedSerialDescriptor.addElement("active", true);
        pluginGeneratedSerialDescriptor.addElement("activeIcon", true);
        pluginGeneratedSerialDescriptor.addElement("activeNightIcon", true);
        pluginGeneratedSerialDescriptor.addElement("activatedIcon", true);
        pluginGeneratedSerialDescriptor.addElement("desc", true);
        pluginGeneratedSerialDescriptor.addElement("icon", true);
        pluginGeneratedSerialDescriptor.addElement("nightIcon", true);
        pluginGeneratedSerialDescriptor.addElement("jumpUrl", true);
        pluginGeneratedSerialDescriptor.addElement("shareExtra", true);
        pluginGeneratedSerialDescriptor.addElement("count", true);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("iconOutlineColor", true);
        pluginGeneratedSerialDescriptor.addElement("shareTemplateId", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private ActionIconModel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ShareExtra$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final ActionIconModel deserialize(Decoder decoder) {
        Boolean bool;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Integer num;
        String str6;
        Integer num2;
        ShareExtra shareExtra;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            String str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            String str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            String str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            shareExtra = (ShareExtra) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, ShareExtra$$serializer.INSTANCE, (Object) null);
            String str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            str4 = str17;
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BooleanSerializer.INSTANCE, (Object) null);
            i = 8191;
            str2 = str13;
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, (Object) null);
            str3 = str14;
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, IntSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            str6 = str15;
            str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            str7 = str16;
        } else {
            Boolean bool2 = null;
            String str18 = null;
            String str19 = null;
            String str20 = null;
            Integer num3 = null;
            ShareExtra shareExtra2 = null;
            String str21 = null;
            String str22 = null;
            Integer num4 = null;
            String str23 = null;
            String str24 = null;
            boolean z = true;
            int i2 = 0;
            String str25 = null;
            String str26 = null;
            while (z) {
                Boolean bool3 = bool2;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        str11 = str18;
                        str12 = str25;
                        z = false;
                        bool2 = bool3;
                        str18 = str11;
                        str25 = str12;
                        break;
                    case 0:
                        str12 = str25;
                        str11 = str18;
                        bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BooleanSerializer.INSTANCE, bool3);
                        i2 |= 1;
                        str18 = str11;
                        str25 = str12;
                        break;
                    case 1:
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str18);
                        i2 |= 2;
                        str25 = str25;
                        bool2 = bool3;
                        break;
                    case 2:
                        str10 = str18;
                        str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str25);
                        i2 |= 4;
                        bool2 = bool3;
                        str18 = str10;
                        break;
                    case 3:
                        str10 = str18;
                        str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str26);
                        i2 |= 8;
                        bool2 = bool3;
                        str18 = str10;
                        break;
                    case 4:
                        str10 = str18;
                        str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str24);
                        i2 |= 16;
                        bool2 = bool3;
                        str18 = str10;
                        break;
                    case 5:
                        str10 = str18;
                        str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str22);
                        i2 |= 32;
                        bool2 = bool3;
                        str18 = str10;
                        break;
                    case 6:
                        str10 = str18;
                        str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str23);
                        i2 |= 64;
                        bool2 = bool3;
                        str18 = str10;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str10 = str18;
                        str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str21);
                        i2 |= 128;
                        bool2 = bool3;
                        str18 = str10;
                        break;
                    case 8:
                        str10 = str18;
                        shareExtra2 = (ShareExtra) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, ShareExtra$$serializer.INSTANCE, shareExtra2);
                        i2 |= 256;
                        bool2 = bool3;
                        str18 = str10;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        str10 = str18;
                        num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, IntSerializer.INSTANCE, num3);
                        i2 |= 512;
                        bool2 = bool3;
                        str18 = str10;
                        break;
                    case 10:
                        str10 = str18;
                        num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num4);
                        i2 |= 1024;
                        bool2 = bool3;
                        str18 = str10;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        str10 = str18;
                        str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str20);
                        i2 |= 2048;
                        bool2 = bool3;
                        str18 = str10;
                        break;
                    case 12:
                        str10 = str18;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str19);
                        i2 |= 4096;
                        bool2 = bool3;
                        str18 = str10;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str27 = str18;
            String str28 = str25;
            bool = bool2;
            i = i2;
            str = str19;
            str2 = str27;
            str3 = str28;
            String str29 = str26;
            str4 = str20;
            str5 = str29;
            String str30 = str23;
            num = num3;
            str6 = str24;
            num2 = num4;
            shareExtra = shareExtra2;
            str7 = str22;
            str8 = str21;
            str9 = str30;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ActionIconModel(i, bool, str2, str3, str5, str6, str7, str9, str8, shareExtra, num, num2, str4, str, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, ActionIconModel value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ActionIconModel.write$Self$product_details_page_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}