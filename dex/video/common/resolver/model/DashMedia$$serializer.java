package video.common.resolver.model;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
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

/* compiled from: DashMedia.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"video/common/resolver/model/DashMedia.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lvideo/common/resolver/model/DashMedia;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", IjkMediaMeta.IJKM_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "resolver_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class DashMedia$$serializer implements GeneratedSerializer<DashMedia> {
    public static final DashMedia$$serializer INSTANCE = new DashMedia$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.common.resolver.model.DashMedia", INSTANCE, 14);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement(IjkMediaMeta.IJKM_ASSET_KEY_BASE_URL, true);
        pluginGeneratedSerialDescriptor.addElement("backup_url", true);
        pluginGeneratedSerialDescriptor.addElement("bandwidth", true);
        pluginGeneratedSerialDescriptor.addElement("codecid", true);
        pluginGeneratedSerialDescriptor.addElement("md5", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("audio_id", true);
        pluginGeneratedSerialDescriptor.addElement("no_rexcode", true);
        pluginGeneratedSerialDescriptor.addElement("frame_rate", true);
        pluginGeneratedSerialDescriptor.addElement("width", true);
        pluginGeneratedSerialDescriptor.addElement("height", true);
        pluginGeneratedSerialDescriptor.addElement("widevinePssh", true);
        pluginGeneratedSerialDescriptor.addElement("bilidrmUri", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DashMedia$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = DashMedia.$childSerializers;
        return new KSerializer[]{IntSerializer.INSTANCE, StringSerializer.INSTANCE, lazyArr[2].getValue(), IntSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    public final DashMedia deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        List list;
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i3;
        long j;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        char c;
        char c2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = DashMedia.$childSerializers;
        int i8 = 9;
        char c3 = 3;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 3);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 4);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 5);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 6);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 7);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 8);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 9);
            int decodeIntElement5 = beginStructure.decodeIntElement(serialDescriptor, 10);
            int decodeIntElement6 = beginStructure.decodeIntElement(serialDescriptor, 11);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 12);
            str5 = beginStructure.decodeStringElement(serialDescriptor, 13);
            str3 = decodeStringElement3;
            i4 = decodeIntElement5;
            i5 = decodeIntElement6;
            str4 = decodeStringElement4;
            str = decodeStringElement;
            j = decodeLongElement;
            z = decodeBooleanElement;
            i = decodeIntElement2;
            i2 = decodeIntElement3;
            str2 = decodeStringElement2;
            i7 = 16383;
            i6 = decodeIntElement;
            i3 = decodeIntElement4;
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
        } else {
            boolean z2 = true;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            boolean z3 = false;
            int i13 = 0;
            int i14 = 0;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            long j2 = 0;
            String str10 = null;
            List list2 = null;
            int i15 = 0;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        c3 = c3;
                        z2 = false;
                        i8 = 9;
                    case 0:
                        i11 |= 1;
                        c3 = c3;
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i8 = 9;
                    case 1:
                        c = c3;
                        c2 = 2;
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i11 |= 2;
                        c3 = c;
                        i8 = 9;
                    case 2:
                        c = c3;
                        c2 = 2;
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list2);
                        i11 |= 4;
                        c3 = c;
                        i8 = 9;
                    case 3:
                        i11 |= 8;
                        c3 = 3;
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 3);
                    case 4:
                        i15 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i11 |= 16;
                        c3 = 3;
                    case 5:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i11 |= 32;
                        c3 = 3;
                    case 6:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 6);
                        i11 |= 64;
                        c3 = 3;
                    case 7:
                        i12 = beginStructure.decodeIntElement(serialDescriptor, 7);
                        i11 |= 128;
                        c3 = 3;
                    case 8:
                        z3 = beginStructure.decodeBooleanElement(serialDescriptor, 8);
                        i11 |= IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
                        c3 = 3;
                    case 9:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, i8);
                        i11 |= 512;
                        c3 = 3;
                    case 10:
                        i13 = beginStructure.decodeIntElement(serialDescriptor, 10);
                        i11 |= 1024;
                        c3 = 3;
                    case 11:
                        i14 = beginStructure.decodeIntElement(serialDescriptor, 11);
                        i11 |= IjkMediaMeta.FF_PROFILE_H264_INTRA;
                        c3 = 3;
                    case 12:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 12);
                        i11 |= 4096;
                        c3 = 3;
                    case 13:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 13);
                        i11 |= 8192;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i9;
            list = list2;
            i2 = i15;
            str = str10;
            str2 = str6;
            str3 = str7;
            str4 = str8;
            str5 = str9;
            i3 = i12;
            j = j2;
            z = z3;
            i4 = i13;
            i5 = i14;
            i6 = i10;
            i7 = i11;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DashMedia(i7, i6, str, list, i, i2, str2, j, i3, z, str3, i4, i5, str4, str5, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, DashMedia value) {
        Intrinsics.checkNotNullParameter(encoder, IjkMediaMeta.IJKM_KEY_ENCODER);
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DashMedia.write$Self$resolver_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}