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
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: PlayIndex.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"video/common/resolver/model/PlayIndex.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lvideo/common/resolver/model/PlayIndex;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", IjkMediaMeta.IJKM_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "resolver_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class PlayIndex$$serializer implements GeneratedSerializer<PlayIndex> {
    public static final PlayIndex$$serializer INSTANCE = new PlayIndex$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.common.resolver.model.PlayIndex", INSTANCE, 10);
        pluginGeneratedSerialDescriptor.addElement(AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, false);
        pluginGeneratedSerialDescriptor.addElement(IjkMediaMeta.IJKM_KEY_FORMAT, false);
        pluginGeneratedSerialDescriptor.addElement("segment_list", true);
        pluginGeneratedSerialDescriptor.addElement("typeTag", true);
        pluginGeneratedSerialDescriptor.addElement("new_description", true);
        pluginGeneratedSerialDescriptor.addElement("display_desc", true);
        pluginGeneratedSerialDescriptor.addElement("superscript", true);
        pluginGeneratedSerialDescriptor.addElement("subtitle", true);
        pluginGeneratedSerialDescriptor.addElement("needVip", true);
        pluginGeneratedSerialDescriptor.addElement("vipFree", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PlayIndex$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = PlayIndex.$childSerializers;
        return new KSerializer[]{IntSerializer.INSTANCE, StringSerializer.INSTANCE, lazyArr[2].getValue(), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE};
    }

    public final PlayIndex deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        int i2;
        boolean z;
        String str;
        String str2;
        String str3;
        List list;
        boolean z2;
        String str4;
        String str5;
        String str6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = PlayIndex.$childSerializers;
        int i3 = 9;
        int i4 = 0;
        if (beginStructure.decodeSequentially()) {
            i = beginStructure.decodeIntElement(serialDescriptor, 0);
            str4 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 4);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 5);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 6);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 7);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 8);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            z2 = beginStructure.decodeBooleanElement(serialDescriptor, 9);
            str3 = decodeStringElement4;
            str5 = decodeStringElement3;
            str2 = decodeStringElement2;
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            z = decodeBooleanElement;
            str = decodeStringElement;
            i2 = 1023;
        } else {
            boolean z3 = true;
            i = 0;
            boolean z4 = false;
            String str7 = null;
            List list2 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            boolean z5 = false;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z3 = false;
                        i3 = 9;
                        break;
                    case 0:
                        i4 |= 1;
                        i = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i3 = 9;
                        break;
                    case 1:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i4 |= 2;
                        i3 = 9;
                        break;
                    case 2:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list2);
                        i4 |= 4;
                        i3 = 9;
                        break;
                    case 3:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str7);
                        i4 |= 8;
                        i3 = 9;
                        continue;
                    case 4:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i4 |= 16;
                        break;
                    case 5:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i4 |= 32;
                        break;
                    case 6:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i4 |= 64;
                        break;
                    case 7:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i4 |= 128;
                        break;
                    case 8:
                        z4 = beginStructure.decodeBooleanElement(serialDescriptor, 8);
                        i4 |= IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
                        break;
                    case 9:
                        z5 = beginStructure.decodeBooleanElement(serialDescriptor, i3);
                        i4 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i2 = i4;
            z = z4;
            str = str9;
            str2 = str10;
            str3 = str12;
            list = list2;
            z2 = z5;
            str4 = str8;
            str5 = str11;
            str6 = str7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new PlayIndex(i2, i, str4, list, str6, str, str2, str5, str3, z, z2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, PlayIndex value) {
        Intrinsics.checkNotNullParameter(encoder, IjkMediaMeta.IJKM_KEY_ENCODER);
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        PlayIndex.write$Self$resolver_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}