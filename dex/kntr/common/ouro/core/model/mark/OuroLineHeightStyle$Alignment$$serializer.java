package kntr.common.ouro.core.model.mark;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroLineHeightStyle;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.InlineClassDescriptor;

/* compiled from: OuroParagraphMark.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"kntr/common/ouro/core/model/mark/OuroLineHeightStyle.Alignment.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Alignment;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-xJrq4TY", "(Lkotlinx/serialization/encoding/Decoder;)F", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-ejfVRtQ", "(Lkotlinx/serialization/encoding/Encoder;F)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class OuroLineHeightStyle$Alignment$$serializer implements GeneratedSerializer<OuroLineHeightStyle.Alignment> {
    public static final OuroLineHeightStyle$Alignment$$serializer INSTANCE = new OuroLineHeightStyle$Alignment$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor inlineClassDescriptor = new InlineClassDescriptor("kntr.common.ouro.core.model.mark.OuroLineHeightStyle.Alignment", INSTANCE);
        inlineClassDescriptor.addElement("topRatio", false);
        descriptor = inlineClassDescriptor;
    }

    private OuroLineHeightStyle$Alignment$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{FloatSerializer.INSTANCE};
    }

    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return OuroLineHeightStyle.Alignment.m1973boximpl(m1970deserializexJrq4TY(decoder));
    }

    /* renamed from: deserialize-xJrq4TY  reason: not valid java name */
    public final float m1970deserializexJrq4TY(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return OuroLineHeightStyle.Alignment.m1974constructorimpl(decoder.decodeInline(descriptor).decodeFloat());
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object value) {
        m1971serializeejfVRtQ(encoder, ((OuroLineHeightStyle.Alignment) value).m1979unboximpl());
    }

    /* renamed from: serialize-ejfVRtQ  reason: not valid java name */
    public final void m1971serializeejfVRtQ(Encoder encoder, float f) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Encoder encodeInline = encoder.encodeInline(descriptor);
        if (encodeInline == null) {
            return;
        }
        encodeInline.encodeFloat(f);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}