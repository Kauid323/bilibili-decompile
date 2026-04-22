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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdEasterEggParams.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdDrawGesture.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdDrawGesture;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdDrawGesture$$serializer implements GeneratedSerializer<AdDrawGesture> {
    public static final AdDrawGesture$$serializer INSTANCE = new AdDrawGesture$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdDrawGesture", INSTANCE, 10);
        pluginGeneratedSerialDescriptor.addElement("guideImage", true);
        pluginGeneratedSerialDescriptor.addElement("imageWidth", true);
        pluginGeneratedSerialDescriptor.addElement("imageHeight", true);
        pluginGeneratedSerialDescriptor.addElement("positionX", true);
        pluginGeneratedSerialDescriptor.addElement("positionY", true);
        pluginGeneratedSerialDescriptor.addElement("activeTimes", true);
        pluginGeneratedSerialDescriptor.addElement("duration", true);
        pluginGeneratedSerialDescriptor.addElement("drawLength", true);
        pluginGeneratedSerialDescriptor.addElement("startAngle", true);
        pluginGeneratedSerialDescriptor.addElement("endAngle", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdDrawGesture$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = AdDrawGesture.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), FloatSerializer.INSTANCE, FloatSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable((KSerializer) lazyArr[5].getValue()), IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    public final AdDrawGesture deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        int i5;
        List list;
        int i6;
        String str;
        int i7;
        float f2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = AdDrawGesture.$childSerializers;
        int i8 = 9;
        int i9 = 7;
        int i10 = 6;
        int i11 = 0;
        if (beginStructure.decodeSequentially()) {
            float decodeFloatElement = beginStructure.decodeFloatElement(serialDescriptor, 1);
            float decodeFloatElement2 = beginStructure.decodeFloatElement(serialDescriptor, 2);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 3);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 4);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 6);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 7);
            int decodeIntElement5 = beginStructure.decodeIntElement(serialDescriptor, 8);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            i2 = beginStructure.decodeIntElement(serialDescriptor, 9);
            i3 = decodeIntElement4;
            i7 = decodeIntElement3;
            i = decodeIntElement;
            i4 = decodeIntElement5;
            i5 = decodeIntElement2;
            f2 = decodeFloatElement2;
            f = decodeFloatElement;
            i6 = 1023;
        } else {
            float f3 = 0.0f;
            float f4 = 0.0f;
            boolean z = true;
            int i12 = 0;
            int i13 = 0;
            i = 0;
            int i14 = 0;
            int i15 = 0;
            List list2 = null;
            String str2 = null;
            int i16 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        i8 = 9;
                        i9 = 7;
                        i10 = 6;
                        break;
                    case 0:
                        str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str2);
                        i11 |= 1;
                        i8 = 9;
                        i9 = 7;
                        i10 = 6;
                        break;
                    case 1:
                        f4 = beginStructure.decodeFloatElement(serialDescriptor, 1);
                        i11 |= 2;
                        i8 = 9;
                        break;
                    case 2:
                        f3 = beginStructure.decodeFloatElement(serialDescriptor, 2);
                        i11 |= 4;
                        break;
                    case 3:
                        i = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i11 |= 8;
                        break;
                    case 4:
                        i15 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i11 |= 16;
                        break;
                    case 5:
                        list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list2);
                        i11 |= 32;
                        break;
                    case 6:
                        i13 = beginStructure.decodeIntElement(serialDescriptor, i10);
                        i11 |= 64;
                        break;
                    case 7:
                        i16 = beginStructure.decodeIntElement(serialDescriptor, i9);
                        i11 |= 128;
                        break;
                    case 8:
                        i14 = beginStructure.decodeIntElement(serialDescriptor, 8);
                        i11 |= 256;
                        break;
                    case 9:
                        i12 = beginStructure.decodeIntElement(serialDescriptor, i8);
                        i11 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str3 = str2;
            i2 = i12;
            i3 = i16;
            f = f4;
            i4 = i14;
            i5 = i15;
            list = list2;
            i6 = i11;
            str = str3;
            float f5 = f3;
            i7 = i13;
            f2 = f5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdDrawGesture(i6, str, f, f2, i, i5, list, i7, i3, i4, i2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdDrawGesture value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdDrawGesture.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}