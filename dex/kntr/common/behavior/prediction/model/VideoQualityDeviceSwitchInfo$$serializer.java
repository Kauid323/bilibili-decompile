package kntr.common.behavior.prediction.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
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

/* compiled from: VideoQualityDeviceActionInfo.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/common/behavior/prediction/model/VideoQualityDeviceSwitchInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/common/behavior/prediction/model/VideoQualityDeviceSwitchInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class VideoQualityDeviceSwitchInfo$$serializer implements GeneratedSerializer<VideoQualityDeviceSwitchInfo> {
    public static final VideoQualityDeviceSwitchInfo$$serializer INSTANCE = new VideoQualityDeviceSwitchInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.common.behavior.prediction.model.VideoQualityDeviceSwitchInfo", INSTANCE, 7);
        pluginGeneratedSerialDescriptor.addElement("ctime", true);
        pluginGeneratedSerialDescriptor.addElement(CommonProjectType.NETWORK, true);
        pluginGeneratedSerialDescriptor.addElement("from_quality", true);
        pluginGeneratedSerialDescriptor.addElement("to_quality", true);
        pluginGeneratedSerialDescriptor.addElement("player_quality", true);
        pluginGeneratedSerialDescriptor.addElement("holiday_type", true);
        pluginGeneratedSerialDescriptor.addElement("vacation_type", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private VideoQualityDeviceSwitchInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LongSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    public final VideoQualityDeviceSwitchInfo deserialize(Decoder decoder) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 1);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 2);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 3);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 4);
            int decodeIntElement5 = beginStructure.decodeIntElement(serialDescriptor, 5);
            i5 = decodeIntElement;
            i = beginStructure.decodeIntElement(serialDescriptor, 6);
            i2 = decodeIntElement5;
            i6 = decodeIntElement3;
            i7 = decodeIntElement4;
            i4 = decodeIntElement2;
            i3 = 127;
            j = decodeLongElement;
        } else {
            boolean z = true;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            long j2 = 0;
            int i13 = 0;
            int i14 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 0);
                        i12 |= 1;
                        continue;
                    case 1:
                        i8 = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i12 |= 2;
                        break;
                    case 2:
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 2);
                        i12 |= 4;
                        break;
                    case 3:
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i12 |= 8;
                        break;
                    case 4:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i12 |= 16;
                        break;
                    case 5:
                        i14 = beginStructure.decodeIntElement(serialDescriptor, 5);
                        i12 |= 32;
                        break;
                    case 6:
                        i13 = beginStructure.decodeIntElement(serialDescriptor, 6);
                        i12 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i13;
            i2 = i14;
            i3 = i12;
            i4 = i11;
            i5 = i8;
            long j3 = j2;
            i6 = i9;
            i7 = i10;
            j = j3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new VideoQualityDeviceSwitchInfo(i3, j, i5, i4, i6, i7, i2, i, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, VideoQualityDeviceSwitchInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        VideoQualityDeviceSwitchInfo.write$Self$behavior_prediction_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}