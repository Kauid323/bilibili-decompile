package kntr.app.ad.common.model;

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

/* compiled from: AdStoryGoods.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdStoryGoods.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdStoryGoods;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdStoryGoods$$serializer implements GeneratedSerializer<AdStoryGoods> {
    public static final AdStoryGoods$$serializer INSTANCE = new AdStoryGoods$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdStoryGoods", INSTANCE, 10);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        pluginGeneratedSerialDescriptor.addElement("desc", true);
        pluginGeneratedSerialDescriptor.addElement("imageUrl", true);
        pluginGeneratedSerialDescriptor.addElement("price", true);
        pluginGeneratedSerialDescriptor.addElement("qualityInfos", true);
        pluginGeneratedSerialDescriptor.addElement("button", true);
        pluginGeneratedSerialDescriptor.addElement("showDynamicTime", true);
        pluginGeneratedSerialDescriptor.addElement("storyCartIcon", true);
        pluginGeneratedSerialDescriptor.addElement("jkCart", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdStoryGoods$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = AdStoryGoods.$childSerializers;
        return new KSerializer[]{IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdPrice$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[5].getValue()), BuiltinSerializersKt.getNullable(AdButton$$serializer.INSTANCE), LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(AdStoryCartIcon$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdJkCart$$serializer.INSTANCE)};
    }

    public final AdStoryGoods deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        AdJkCart adJkCart;
        AdStoryCartIcon adStoryCartIcon;
        AdPrice adPrice;
        List list;
        AdButton adButton;
        long j2;
        int i;
        String str;
        int i2;
        String str2;
        String str3;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = AdStoryGoods.$childSerializers;
        int i3 = 9;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 7);
            i = decodeIntElement;
            adJkCart = (AdJkCart) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, AdJkCart$$serializer.INSTANCE, (Object) null);
            adStoryCartIcon = (AdStoryCartIcon) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, AdStoryCartIcon$$serializer.INSTANCE, (Object) null);
            adButton = (AdButton) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, AdButton$$serializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            j2 = decodeLongElement;
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), (Object) null);
            i2 = 1023;
            adPrice = (AdPrice) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, AdPrice$$serializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            int i4 = 0;
            AdJkCart adJkCart2 = null;
            AdStoryCartIcon adStoryCartIcon2 = null;
            AdPrice adPrice2 = null;
            List list2 = null;
            String str4 = null;
            AdButton adButton2 = null;
            String str5 = null;
            long j3 = 0;
            String str6 = null;
            int i5 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        i3 = 9;
                        break;
                    case 0:
                        i4 = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i5 |= 1;
                        i3 = 9;
                        break;
                    case 1:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str6);
                        i5 |= 2;
                        i3 = 9;
                        break;
                    case 2:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str5);
                        i5 |= 4;
                        i3 = 9;
                        break;
                    case 3:
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str4);
                        i5 |= 8;
                        i3 = 9;
                        break;
                    case 4:
                        adPrice2 = (AdPrice) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, AdPrice$$serializer.INSTANCE, adPrice2);
                        i5 |= 16;
                        i3 = 9;
                        break;
                    case 5:
                        list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list2);
                        i5 |= 32;
                        i3 = 9;
                        break;
                    case 6:
                        adButton2 = (AdButton) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, AdButton$$serializer.INSTANCE, adButton2);
                        i5 |= 64;
                        i3 = 9;
                        break;
                    case 7:
                        c = '\b';
                        j3 = beginStructure.decodeLongElement(serialDescriptor, 7);
                        i5 |= 128;
                        i3 = 9;
                        break;
                    case 8:
                        c = '\b';
                        adStoryCartIcon2 = (AdStoryCartIcon) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, AdStoryCartIcon$$serializer.INSTANCE, adStoryCartIcon2);
                        i5 |= 256;
                        i3 = 9;
                        break;
                    case 9:
                        adJkCart2 = (AdJkCart) beginStructure.decodeNullableSerializableElement(serialDescriptor, i3, AdJkCart$$serializer.INSTANCE, adJkCart2);
                        i5 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            adJkCart = adJkCart2;
            adStoryCartIcon = adStoryCartIcon2;
            adPrice = adPrice2;
            list = list2;
            adButton = adButton2;
            j2 = j3;
            i = i4;
            int i6 = i5;
            str = str4;
            i2 = i6;
            String str7 = str6;
            str2 = str5;
            str3 = str7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdStoryGoods(i2, i, str3, str2, str, adPrice, list, adButton, j2, adStoryCartIcon, adJkCart, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdStoryGoods value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdStoryGoods.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}