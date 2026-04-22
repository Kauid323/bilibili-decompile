package kntr.app.tribee.publish.draft;

import com.bapis.bilibili.dynamic.common.KOpus;
import com.bapis.bilibili.dynamic.common.KOpus$;
import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.tribee.publish.TribeeInfo$$serializer;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: TribeeDraftContent.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/tribee/publish/draft/TribeeDraftContent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/tribee/publish/draft/TribeeDraftContent;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class TribeeDraftContent$$serializer implements GeneratedSerializer<TribeeDraftContent> {
    public static final TribeeDraftContent$$serializer INSTANCE = new TribeeDraftContent$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.tribee.publish.draft.TribeeDraftContent", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("tribeeInfo", false);
        pluginGeneratedSerialDescriptor.addElement("opusContent", false);
        pluginGeneratedSerialDescriptor.addElement("sendToFollowing", false);
        pluginGeneratedSerialDescriptor.addElement("selectedCategoryId", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TribeeDraftContent$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{TribeeInfo$$serializer.INSTANCE, KOpus$.serializer.INSTANCE, BooleanSerializer.INSTANCE, LongSerializer.INSTANCE};
    }

    public final TribeeDraftContent deserialize(Decoder decoder) {
        int i;
        boolean z;
        long j;
        TribeeInfo tribeeInfo;
        KOpus kOpus;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            KOpus kOpus2 = (KOpus) beginStructure.decodeSerializableElement(serialDescriptor, 1, KOpus$.serializer.INSTANCE, (Object) null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            j = beginStructure.decodeLongElement(serialDescriptor, 3);
            tribeeInfo = (TribeeInfo) beginStructure.decodeSerializableElement(serialDescriptor, 0, TribeeInfo$$serializer.INSTANCE, (Object) null);
            i = 15;
            z = decodeBooleanElement;
            kOpus = kOpus2;
        } else {
            long j2 = 0;
            boolean z2 = true;
            i = 0;
            TribeeInfo tribeeInfo2 = null;
            KOpus kOpus3 = null;
            boolean z3 = false;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = false;
                        break;
                    case 0:
                        tribeeInfo2 = (TribeeInfo) beginStructure.decodeSerializableElement(serialDescriptor, 0, TribeeInfo$$serializer.INSTANCE, tribeeInfo2);
                        i |= 1;
                        break;
                    case 1:
                        kOpus3 = (KOpus) beginStructure.decodeSerializableElement(serialDescriptor, 1, KOpus$.serializer.INSTANCE, kOpus3);
                        i |= 2;
                        break;
                    case 2:
                        z3 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                        i |= 4;
                        break;
                    case 3:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 3);
                        i |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z = z3;
            j = j2;
            tribeeInfo = tribeeInfo2;
            kOpus = kOpus3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new TribeeDraftContent(i, tribeeInfo, kOpus, z, j, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, TribeeDraftContent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        TribeeDraftContent.write$Self$core_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}