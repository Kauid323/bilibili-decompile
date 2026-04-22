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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdAppDownloadStyle.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdAppDownloadStyle.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdAppDownloadStyle;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdAppDownloadStyle$$serializer implements GeneratedSerializer<AdAppDownloadStyle> {
    public static final AdAppDownloadStyle$$serializer INSTANCE = new AdAppDownloadStyle$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdAppDownloadStyle", INSTANCE, 7);
        pluginGeneratedSerialDescriptor.addElement("style", true);
        pluginGeneratedSerialDescriptor.addElement("tags", true);
        pluginGeneratedSerialDescriptor.addElement("guideText", true);
        pluginGeneratedSerialDescriptor.addElement("head_imgs", true);
        pluginGeneratedSerialDescriptor.addElement("detail_imgs", true);
        pluginGeneratedSerialDescriptor.addElement("detailImageLayout", true);
        pluginGeneratedSerialDescriptor.addElement("detailText", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdAppDownloadStyle$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = AdAppDownloadStyle.$childSerializers;
        return new KSerializer[]{IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable((KSerializer) lazyArr[1].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[3].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[4].getValue()), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final AdAppDownloadStyle deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        String str;
        int i;
        List list;
        List list2;
        int i2;
        List list3;
        int i3;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = AdAppDownloadStyle.$childSerializers;
        int i4 = 6;
        int i5 = 5;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 5);
            list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), (Object) null);
            i2 = decodeIntElement;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            i = decodeIntElement2;
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), (Object) null);
            i3 = 127;
        } else {
            boolean z = true;
            int i6 = 0;
            int i7 = 0;
            String str3 = null;
            List list4 = null;
            List list5 = null;
            String str4 = null;
            List list6 = null;
            int i8 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        i4 = 6;
                        i5 = 5;
                        break;
                    case 0:
                        i6 = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i7 |= 1;
                        i4 = 6;
                        i5 = 5;
                        break;
                    case 1:
                        list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list5);
                        i7 |= 2;
                        i4 = 6;
                        i5 = 5;
                        break;
                    case 2:
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str4);
                        i7 |= 4;
                        i4 = 6;
                        i5 = 5;
                        break;
                    case 3:
                        list6 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list6);
                        i7 |= 8;
                        i4 = 6;
                        break;
                    case 4:
                        list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list4);
                        i7 |= 16;
                        break;
                    case 5:
                        i8 = beginStructure.decodeIntElement(serialDescriptor, i5);
                        i7 |= 32;
                        break;
                    case 6:
                        str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i4, StringSerializer.INSTANCE, str3);
                        i7 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str3;
            i = i8;
            list = list5;
            list2 = list6;
            i2 = i6;
            String str5 = str4;
            list3 = list4;
            i3 = i7;
            str2 = str5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdAppDownloadStyle(i3, i2, list, str2, list2, list3, i, str, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdAppDownloadStyle value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdAppDownloadStyle.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}