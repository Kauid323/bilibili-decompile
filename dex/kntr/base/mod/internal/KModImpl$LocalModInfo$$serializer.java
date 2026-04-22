package kntr.base.mod.internal;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.mod.internal.KModImpl;
import kntr.common.upper.trace.config.AppKey;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: KModImpl.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/base/mod/internal/KModImpl.LocalModInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/base/mod/internal/KModImpl$LocalModInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class KModImpl$LocalModInfo$$serializer implements GeneratedSerializer<KModImpl.LocalModInfo> {
    public static final KModImpl$LocalModInfo$$serializer INSTANCE = new KModImpl$LocalModInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.base.mod.internal.KModImpl.LocalModInfo", INSTANCE, 10);
        pluginGeneratedSerialDescriptor.addElement("poolName", false);
        pluginGeneratedSerialDescriptor.addElement("modName", false);
        pluginGeneratedSerialDescriptor.addElement("moduleId", false);
        pluginGeneratedSerialDescriptor.addElement(AppKey.VERSION, false);
        pluginGeneratedSerialDescriptor.addElement("md5", false);
        pluginGeneratedSerialDescriptor.addElement("size", false);
        pluginGeneratedSerialDescriptor.addElement("fileName", false);
        pluginGeneratedSerialDescriptor.addElement("region", false);
        pluginGeneratedSerialDescriptor.addElement("unzipDirName", false);
        pluginGeneratedSerialDescriptor.addElement("deletedFromRemote", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private KModImpl$LocalModInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE};
    }

    public final KModImpl.LocalModInfo deserialize(Decoder decoder) {
        int i;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        long j;
        long j2;
        String str6;
        long j3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 9;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 2);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 3);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 4);
            long decodeLongElement3 = beginStructure.decodeLongElement(serialDescriptor, 5);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 6);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 7);
            z = beginStructure.decodeBooleanElement(serialDescriptor, 9);
            str2 = decodeStringElement5;
            str6 = decodeStringElement4;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            str3 = decodeStringElement3;
            i = 1023;
            j2 = decodeLongElement3;
            j3 = decodeLongElement2;
            j = decodeLongElement;
            str4 = decodeStringElement;
            str5 = decodeStringElement2;
        } else {
            long j4 = 0;
            boolean z2 = true;
            boolean z3 = false;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            long j5 = 0;
            long j6 = 0;
            String str12 = null;
            i = 0;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = false;
                        i2 = 9;
                        break;
                    case 0:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i |= 1;
                        i2 = 9;
                        break;
                    case 1:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i |= 2;
                        break;
                    case 2:
                        j5 = beginStructure.decodeLongElement(serialDescriptor, 2);
                        i |= 4;
                        break;
                    case 3:
                        j6 = beginStructure.decodeLongElement(serialDescriptor, 3);
                        i |= 8;
                        break;
                    case 4:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i |= 16;
                        break;
                    case 5:
                        j4 = beginStructure.decodeLongElement(serialDescriptor, 5);
                        i |= 32;
                        break;
                    case 6:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i |= 64;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i |= 128;
                        break;
                    case 8:
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str12);
                        i |= 256;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        z3 = beginStructure.decodeBooleanElement(serialDescriptor, i2);
                        i |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z = z3;
            long j7 = j6;
            str = str12;
            str2 = str11;
            str3 = str9;
            long j8 = j4;
            str4 = str7;
            str5 = str8;
            j = j5;
            j2 = j8;
            str6 = str10;
            j3 = j7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new KModImpl.LocalModInfo(i, str4, str5, j, j3, str3, j2, str6, str2, str, z, null);
    }

    public final void serialize(Encoder encoder, KModImpl.LocalModInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        KModImpl.LocalModInfo.write$Self$mod_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}