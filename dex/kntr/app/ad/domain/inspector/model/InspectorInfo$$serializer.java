package kntr.app.ad.domain.inspector.model;

import kntr.app.ad.common.model.AdSlot;
import kntr.app.ad.domain.inspector.core.work.Pipeline;
import kntr.app.ad.domain.inspector.core.work.Pipeline$$serializer;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: InspectorInfo.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/domain/inspector/model/InspectorInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/domain/inspector/model/InspectorInfo;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class InspectorInfo$$serializer implements GeneratedSerializer<InspectorInfo> {
    public static final int $stable;
    public static final InspectorInfo$$serializer INSTANCE = new InspectorInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.domain.inspector.model.InspectorInfo", INSTANCE, 6);
        pluginGeneratedSerialDescriptor.addElement("adSlot", false);
        pluginGeneratedSerialDescriptor.addElement("adData", false);
        pluginGeneratedSerialDescriptor.addElement("dirty", true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.ID, true);
        pluginGeneratedSerialDescriptor.addElement("pipeline", true);
        pluginGeneratedSerialDescriptor.addElement("timestamp", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private InspectorInfo$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = InspectorInfo.$childSerializers;
        return new KSerializer[]{lazyArr[0].getValue(), AdData$$serializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, Pipeline$$serializer.INSTANCE, LongSerializer.INSTANCE};
    }

    public final InspectorInfo deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        Pipeline pipeline;
        int i;
        AdData adData;
        String str;
        long j2;
        long j3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = InspectorInfo.$childSerializers;
        int i2 = 5;
        int i3 = 3;
        AdSlot adSlot = null;
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 2);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 3);
            adData = (AdData) beginStructure.decodeSerializableElement(serialDescriptor, 1, AdData$$serializer.INSTANCE, (Object) null);
            str = decodeStringElement;
            pipeline = (Pipeline) beginStructure.decodeSerializableElement(serialDescriptor, 4, Pipeline$$serializer.INSTANCE, (Object) null);
            j2 = decodeLongElement;
            j3 = beginStructure.decodeLongElement(serialDescriptor, 5);
            adSlot = (AdSlot) beginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), (Object) null);
            i = 63;
        } else {
            long j4 = 0;
            boolean z = true;
            int i4 = 0;
            Pipeline pipeline2 = null;
            AdData adData2 = null;
            String str2 = null;
            long j5 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        i2 = 5;
                        i3 = 3;
                        break;
                    case 0:
                        adSlot = (AdSlot) beginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), adSlot);
                        i4 |= 1;
                        i2 = 5;
                        i3 = 3;
                        break;
                    case 1:
                        adData2 = (AdData) beginStructure.decodeSerializableElement(serialDescriptor, 1, AdData$$serializer.INSTANCE, adData2);
                        i4 |= 2;
                        i2 = 5;
                        i3 = 3;
                        break;
                    case 2:
                        j4 = beginStructure.decodeLongElement(serialDescriptor, 2);
                        i4 |= 4;
                        break;
                    case 3:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, i3);
                        i4 |= 8;
                        break;
                    case 4:
                        pipeline2 = (Pipeline) beginStructure.decodeSerializableElement(serialDescriptor, 4, Pipeline$$serializer.INSTANCE, pipeline2);
                        i4 |= 16;
                        break;
                    case 5:
                        j5 = beginStructure.decodeLongElement(serialDescriptor, i2);
                        i4 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            pipeline = pipeline2;
            AdData adData3 = adData2;
            i = i4;
            long j6 = j4;
            adData = adData3;
            str = str2;
            j2 = j6;
            j3 = j5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new InspectorInfo(i, adSlot, adData, j2, str, pipeline, j3, null);
    }

    public final void serialize(Encoder encoder, InspectorInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        InspectorInfo.write$Self$inspector_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}