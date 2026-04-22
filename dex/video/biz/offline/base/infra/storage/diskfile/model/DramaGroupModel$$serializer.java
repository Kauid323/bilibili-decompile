package video.biz.offline.base.infra.storage.diskfile.model;

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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: DramaGroupModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"video/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", IjkMediaMeta.IJKM_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class DramaGroupModel$$serializer implements GeneratedSerializer<DramaGroupModel> {
    public static final int $stable;
    public static final DramaGroupModel$$serializer INSTANCE = new DramaGroupModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement(RankRouter.BundleKey.ACTION_PARAM_TITLE, false);
        pluginGeneratedSerialDescriptor.addElement(RankRouter.BundleKey.VIDEO_DETAIL_COVER, true);
        pluginGeneratedSerialDescriptor.addElement("items", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private DramaGroupModel$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = DramaGroupModel.$childSerializers;
        return new KSerializer[]{LongSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, lazyArr[3].getValue()};
    }

    public final DramaGroupModel deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        String str;
        String str2;
        List list;
        long j;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = DramaGroupModel.$childSerializers;
        String str3 = null;
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), (Object) null);
            str2 = decodeStringElement2;
            i = 15;
            str = decodeStringElement;
            j = decodeLongElement;
        } else {
            boolean z = true;
            int i2 = 0;
            long j2 = 0;
            String str4 = null;
            List list2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 0);
                        i2 |= 1;
                        break;
                    case 1:
                        str3 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                        break;
                    case 3:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list2);
                        i2 |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i2;
            str = str3;
            str2 = str4;
            list = list2;
            j = j2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DramaGroupModel(i, j, str, str2, list, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, DramaGroupModel value) {
        Intrinsics.checkNotNullParameter(encoder, IjkMediaMeta.IJKM_KEY_ENCODER);
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DramaGroupModel.write$Self$infra_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}