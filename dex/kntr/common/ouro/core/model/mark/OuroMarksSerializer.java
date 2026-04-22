package kntr.common.ouro.core.model.mark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.utils.SerializationUtilsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: OuroMarks.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u0014\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroMarksSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "<init>", "()V", "markSerializer", "Lkotlinx/serialization/PolymorphicSerializer;", "Lkntr/common/ouro/core/model/mark/OuroMark;", "listSerializer", "", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroMarksSerializer implements KSerializer<OuroMarks<?>> {
    public static final OuroMarksSerializer INSTANCE = new OuroMarksSerializer();
    private static final PolymorphicSerializer<OuroMark> markSerializer = new PolymorphicSerializer<>(Reflection.getOrCreateKotlinClass(OuroMark.class));
    private static final KSerializer<List<byte[]>> listSerializer = BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.ByteArraySerializer());
    private static final SerialDescriptor descriptor = listSerializer.getDescriptor();

    private OuroMarksSerializer() {
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, OuroMarks<?> ouroMarks) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(ouroMarks, "value");
        OuroMarks<?> $this$map$iv = ouroMarks;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            OuroMark mark = (OuroMark) item$iv$iv;
            destination$iv$iv.add(SerializationUtilsKt.getOuroProtoBuf().encodeToByteArray(markSerializer, mark));
        }
        List marksList = (List) destination$iv$iv;
        encoder.encodeSerializableValue(listSerializer, marksList);
    }

    public OuroMarks<?> deserialize(Decoder decoder) {
        OuroMark ouroMark;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Iterable marksList = (List) decoder.decodeSerializableValue(listSerializer);
        Iterable $this$mapNotNull$iv = marksList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            byte[] markJson = (byte[]) element$iv$iv$iv;
            try {
                ouroMark = (OuroMark) SerializationUtilsKt.getOuroProtoBuf().decodeFromByteArray(markSerializer, markJson);
            } catch (Exception e) {
                ouroMark = null;
            }
            if (ouroMark != null) {
                destination$iv$iv.add(ouroMark);
            }
        }
        List marks = (List) destination$iv$iv;
        return new OuroMarks<>(marks);
    }
}