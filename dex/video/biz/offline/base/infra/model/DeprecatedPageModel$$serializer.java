package video.biz.offline.base.infra.model;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: DeprecatedEntryModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"video/biz/offline/base/infra/model/DeprecatedPageModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lvideo/biz/offline/base/infra/model/DeprecatedPageModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", IjkMediaMeta.IJKM_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class DeprecatedPageModel$$serializer implements GeneratedSerializer<DeprecatedPageModel> {
    public static final int $stable;
    public static final DeprecatedPageModel$$serializer INSTANCE = new DeprecatedPageModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.base.infra.model.DeprecatedPageModel", INSTANCE, 13);
        pluginGeneratedSerialDescriptor.addElement("cid", true);
        pluginGeneratedSerialDescriptor.addElement("page", true);
        pluginGeneratedSerialDescriptor.addElement("from", true);
        pluginGeneratedSerialDescriptor.addElement("part", true);
        pluginGeneratedSerialDescriptor.addElement("link", true);
        pluginGeneratedSerialDescriptor.addElement("rich_vid", true);
        pluginGeneratedSerialDescriptor.addElement("has_alias", true);
        pluginGeneratedSerialDescriptor.addElement("tid", true);
        pluginGeneratedSerialDescriptor.addElement("width", true);
        pluginGeneratedSerialDescriptor.addElement("height", true);
        pluginGeneratedSerialDescriptor.addElement("rotate", true);
        pluginGeneratedSerialDescriptor.addElement("download_title", true);
        pluginGeneratedSerialDescriptor.addElement("download_subtitle", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private DeprecatedPageModel$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LongSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, IntSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    public final DeprecatedPageModel deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        String str5;
        int i;
        String str6;
        int i2;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i3 = 11;
        int i4 = 0;
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 1);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 3);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 4);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 5);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 6);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 7);
            long decodeLongElement3 = beginStructure.decodeLongElement(serialDescriptor, 8);
            long decodeLongElement4 = beginStructure.decodeLongElement(serialDescriptor, 9);
            long decodeLongElement5 = beginStructure.decodeLongElement(serialDescriptor, 10);
            str6 = beginStructure.decodeStringElement(serialDescriptor, 11);
            j2 = decodeLongElement5;
            i = decodeIntElement;
            z = decodeBooleanElement;
            str2 = decodeStringElement4;
            str3 = decodeStringElement2;
            str = beginStructure.decodeStringElement(serialDescriptor, 12);
            str4 = decodeStringElement3;
            j4 = decodeLongElement3;
            j = decodeLongElement4;
            str5 = decodeStringElement;
            j3 = decodeLongElement2;
            j5 = decodeLongElement;
            i2 = 8191;
        } else {
            long j6 = 0;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            int i5 = 0;
            boolean z2 = false;
            boolean z3 = true;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            long j10 = 0;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z3 = false;
                        i3 = 11;
                        break;
                    case 0:
                        j6 = beginStructure.decodeLongElement(serialDescriptor, 0);
                        i4 |= 1;
                        i3 = 11;
                        break;
                    case 1:
                        j8 = beginStructure.decodeLongElement(serialDescriptor, 1);
                        i4 |= 2;
                        i3 = 11;
                        continue;
                    case 2:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i4 |= 4;
                        break;
                    case 3:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i4 |= 8;
                        break;
                    case 4:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i4 |= 16;
                        break;
                    case 5:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i4 |= 32;
                        break;
                    case 6:
                        z2 = beginStructure.decodeBooleanElement(serialDescriptor, 6);
                        i4 |= 64;
                        break;
                    case 7:
                        i5 = beginStructure.decodeIntElement(serialDescriptor, 7);
                        i4 |= 128;
                        break;
                    case 8:
                        j9 = beginStructure.decodeLongElement(serialDescriptor, 8);
                        i4 |= IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
                        break;
                    case 9:
                        j10 = beginStructure.decodeLongElement(serialDescriptor, 9);
                        i4 |= 512;
                        break;
                    case 10:
                        j7 = beginStructure.decodeLongElement(serialDescriptor, 10);
                        i4 |= 1024;
                        break;
                    case 11:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, i3);
                        i4 |= IjkMediaMeta.FF_PROFILE_H264_INTRA;
                        break;
                    case 12:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 12);
                        i4 |= 4096;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str10;
            str2 = str8;
            str3 = str9;
            str4 = str11;
            z = z2;
            str5 = str12;
            i = i5;
            str6 = str7;
            long j11 = j6;
            i2 = i4;
            j = j10;
            j2 = j7;
            j3 = j8;
            j4 = j9;
            j5 = j11;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DeprecatedPageModel(i2, j5, j3, str5, str3, str4, str2, z, i, j4, j, j2, str6, str, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, DeprecatedPageModel value) {
        Intrinsics.checkNotNullParameter(encoder, IjkMediaMeta.IJKM_KEY_ENCODER);
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DeprecatedPageModel.write$Self$infra_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}