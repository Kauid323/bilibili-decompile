package kntr.app.digital.preview;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: CardNumberColorUtil.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lkntr/app/digital/preview/RgbaColorSerializer;", "Lkotlinx/serialization/KSerializer;", "Landroidx/compose/ui/graphics/Color;", "<init>", "()V", "delegateSerializer", RoomRecommendViewModel.EMPTY_CURSOR, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-4WTKRHQ", "(Lkotlinx/serialization/encoding/Encoder;J)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-vNxB06k", "(Lkotlinx/serialization/encoding/Decoder;)J", "parseColor", RoomRecommendViewModel.EMPTY_CURSOR, "colorString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RgbaColorSerializer implements KSerializer<Color> {
    public static final RgbaColorSerializer INSTANCE = new RgbaColorSerializer();
    private static final KSerializer<String> delegateSerializer = BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE);
    private static final SerialDescriptor descriptor = delegateSerializer.getDescriptor();
    public static final int $stable = 8;

    private RgbaColorSerializer() {
    }

    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return Color.box-impl(m871deserializevNxB06k(decoder));
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object value) {
        m872serialize4WTKRHQ(encoder, ((Color) value).unbox-impl());
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* renamed from: serialize-4WTKRHQ  reason: not valid java name */
    public void m872serialize4WTKRHQ(Encoder encoder, long j2) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        throw new UnsupportedOperationException("Serialization not implemented");
    }

    /* renamed from: deserialize-vNxB06k  reason: not valid java name */
    public long m871deserializevNxB06k(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        String string = (String) decoder.decodeSerializableValue(delegateSerializer);
        return ColorKt.Color(parseColor(string));
    }

    private final int parseColor(String colorString) {
        int rgba;
        if ((colorString.length() == 0) || colorString.charAt(0) != '#') {
            throw new IllegalArgumentException("Unknown color format: " + colorString);
        }
        String substring = colorString.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        long color = Long.parseLong(substring, CharsKt.checkRadix(16));
        switch (colorString.length()) {
            case 7:
                rgba = (int) (4278190080L | color);
                break;
            case 8:
            default:
                throw new IllegalArgumentException("Unknown color format: " + colorString);
            case 9:
                rgba = (int) color;
                break;
        }
        return (rgba >>> 8) | (rgba << 24);
    }
}