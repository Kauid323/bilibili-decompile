package kntr.app.ad.common.model;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdEasterEggParams.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdEasterEggParams.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdEasterEggParams;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdEasterEggParams$$serializer implements GeneratedSerializer<AdEasterEggParams> {
    public static final AdEasterEggParams$$serializer INSTANCE = new AdEasterEggParams$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdEasterEggParams", INSTANCE, 18);
        pluginGeneratedSerialDescriptor.addElement("eggType", true);
        pluginGeneratedSerialDescriptor.addElement("eggLottieDurTime", true);
        pluginGeneratedSerialDescriptor.addElement("eggLottie", true);
        pluginGeneratedSerialDescriptor.addElement("eggImage", true);
        pluginGeneratedSerialDescriptor.addElement("eggHint", true);
        pluginGeneratedSerialDescriptor.addElement("eggTwistAngle", true);
        pluginGeneratedSerialDescriptor.addElement("eggTwistSpeed", true);
        pluginGeneratedSerialDescriptor.addElement("eggLottieX", true);
        pluginGeneratedSerialDescriptor.addElement("eggLottieY", true);
        pluginGeneratedSerialDescriptor.addElement("natureStartTime", true);
        pluginGeneratedSerialDescriptor.addElement("natureCanTwistEndTime", true);
        pluginGeneratedSerialDescriptor.addElement("natureEndTime", true);
        pluginGeneratedSerialDescriptor.addElement("showBindSourceType", true);
        pluginGeneratedSerialDescriptor.addElement("lottieAnimateStyle", true);
        pluginGeneratedSerialDescriptor.addElement("lottieClickAble", true);
        pluginGeneratedSerialDescriptor.addElement("eggClickHint", true);
        pluginGeneratedSerialDescriptor.addElement("eggDesc", true);
        pluginGeneratedSerialDescriptor.addElement("drawGesture", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdEasterEggParams$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), FloatSerializer.INSTANCE, FloatSerializer.INSTANCE, FloatSerializer.INSTANCE, FloatSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdDrawGesture$$serializer.INSTANCE)};
    }

    public final AdEasterEggParams deserialize(Decoder decoder) {
        String str;
        int i;
        String str2;
        int i2;
        String str3;
        long j2;
        float f;
        float f2;
        float f3;
        int i3;
        long j3;
        AdDrawGesture adDrawGesture;
        String str4;
        float f4;
        String str5;
        boolean z;
        int i4;
        long j4;
        long j5;
        int i5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i6 = 9;
        char c = 6;
        int i7 = 8;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 1);
            float decodeFloatElement = beginStructure.decodeFloatElement(serialDescriptor, 5);
            float decodeFloatElement2 = beginStructure.decodeFloatElement(serialDescriptor, 6);
            float decodeFloatElement3 = beginStructure.decodeFloatElement(serialDescriptor, 7);
            float decodeFloatElement4 = beginStructure.decodeFloatElement(serialDescriptor, 8);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 9);
            long decodeLongElement3 = beginStructure.decodeLongElement(serialDescriptor, 10);
            long decodeLongElement4 = beginStructure.decodeLongElement(serialDescriptor, 11);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 12);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 13);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 14);
            String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, (Object) null);
            adDrawGesture = (AdDrawGesture) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, AdDrawGesture$$serializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            i2 = 262143;
            z = decodeBooleanElement;
            i4 = decodeIntElement2;
            i3 = decodeIntElement3;
            str4 = str6;
            i = decodeIntElement;
            j2 = decodeLongElement;
            j3 = decodeLongElement3;
            j5 = decodeLongElement4;
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            f2 = decodeFloatElement2;
            f3 = decodeFloatElement;
            j4 = decodeLongElement2;
            f4 = decodeFloatElement4;
            f = decodeFloatElement3;
        } else {
            boolean z2 = false;
            int i8 = 0;
            int i9 = 0;
            float f5 = 0.0f;
            float f6 = 0.0f;
            float f7 = 0.0f;
            boolean z3 = true;
            AdDrawGesture adDrawGesture2 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            int i10 = 0;
            String str10 = null;
            String str11 = null;
            float f8 = 0.0f;
            int i11 = 0;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z3 = false;
                        i7 = 8;
                        i6 = 9;
                        c = 6;
                        break;
                    case 0:
                        i10 |= 1;
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i7 = 8;
                        i6 = 9;
                        c = 6;
                        break;
                    case 1:
                        j6 = beginStructure.decodeLongElement(serialDescriptor, 1);
                        i10 |= 2;
                        i7 = 8;
                        i6 = 9;
                        c = 6;
                        break;
                    case 2:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str11);
                        i10 |= 4;
                        i7 = 8;
                        i6 = 9;
                        c = 6;
                        break;
                    case 3:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str10);
                        i10 |= 8;
                        i7 = 8;
                        i6 = 9;
                        c = 6;
                        break;
                    case 4:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str8);
                        i10 |= 16;
                        i7 = 8;
                        i6 = 9;
                        c = 6;
                        break;
                    case 5:
                        f7 = beginStructure.decodeFloatElement(serialDescriptor, 5);
                        i10 |= 32;
                        i7 = 8;
                        c = 6;
                        continue;
                    case 6:
                        f6 = beginStructure.decodeFloatElement(serialDescriptor, 6);
                        i10 |= 64;
                        c = 6;
                        i7 = 8;
                        break;
                    case 7:
                        f5 = beginStructure.decodeFloatElement(serialDescriptor, 7);
                        i10 |= 128;
                        c = 6;
                        break;
                    case 8:
                        f8 = beginStructure.decodeFloatElement(serialDescriptor, i7);
                        i10 |= 256;
                        c = 6;
                        break;
                    case 9:
                        j8 = beginStructure.decodeLongElement(serialDescriptor, i6);
                        i10 |= 512;
                        c = 6;
                        break;
                    case 10:
                        j7 = beginStructure.decodeLongElement(serialDescriptor, 10);
                        i10 |= 1024;
                        c = 6;
                        break;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        j9 = beginStructure.decodeLongElement(serialDescriptor, 11);
                        i10 |= 2048;
                        c = 6;
                        break;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        i8 = beginStructure.decodeIntElement(serialDescriptor, 12);
                        i10 |= 4096;
                        c = 6;
                        break;
                    case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 13);
                        i10 |= 8192;
                        c = 6;
                        break;
                    case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                        z2 = beginStructure.decodeBooleanElement(serialDescriptor, 14);
                        i10 |= 16384;
                        c = 6;
                        break;
                    case AdditionVote2.CARD_TYPE_FIELD_NUMBER /* 15 */:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str7);
                        i5 = 32768;
                        i10 |= i5;
                        c = 6;
                        break;
                    case AdditionVote2.TIPS_FIELD_NUMBER /* 16 */:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str9);
                        i5 = 65536;
                        i10 |= i5;
                        c = 6;
                        break;
                    case AdditionVote2.URI_FIELD_NUMBER /* 17 */:
                        adDrawGesture2 = (AdDrawGesture) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, AdDrawGesture$$serializer.INSTANCE, adDrawGesture2);
                        i5 = 131072;
                        i10 |= i5;
                        c = 6;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str10;
            i = i11;
            str2 = str8;
            i2 = i10;
            str3 = str11;
            j2 = j6;
            f = f5;
            f2 = f6;
            f3 = f7;
            i3 = i9;
            j3 = j7;
            adDrawGesture = adDrawGesture2;
            str4 = str7;
            f4 = f8;
            str5 = str9;
            z = z2;
            i4 = i8;
            j4 = j8;
            j5 = j9;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdEasterEggParams(i2, i, j2, str3, str, str2, f3, f2, f, f4, j4, j3, j5, i4, i3, z, str4, str5, adDrawGesture, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdEasterEggParams value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdEasterEggParams.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}