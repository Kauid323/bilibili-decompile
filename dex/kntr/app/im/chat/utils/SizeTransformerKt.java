package kntr.app.im.chat.utils;

import kntr.app.im.chat.db.model.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SizeTransformer.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0003*\u00060\u0001j\u0002`\u0004¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u00060\u0001j\u0002`\u0004*\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\t"}, d2 = {"BSize", "Lkntr/app/im/chat/db/model/Size;", "toComposeSize", "Landroidx/compose/ui/geometry/Size;", "Lkntr/app/im/chat/utils/BSize;", "(Lkntr/app/im/chat/db/model/Size;)J", "toBSize", "toBSize-uvyYCjk", "(J)Lkntr/app/im/chat/db/model/Size;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SizeTransformerKt {
    public static final long toComposeSize(Size $this$toComposeSize) {
        Intrinsics.checkNotNullParameter($this$toComposeSize, "<this>");
        float width$iv = $this$toComposeSize.getWidth();
        float height$iv = $this$toComposeSize.getHeight();
        long v1$iv$iv = Float.floatToRawIntBits(width$iv);
        long v2$iv$iv = Float.floatToRawIntBits(height$iv);
        return androidx.compose.ui.geometry.Size.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
    }

    /* renamed from: toBSize-uvyYCjk  reason: not valid java name */
    public static final Size m1996toBSizeuvyYCjk(long j2) {
        int bits$iv$iv$iv = (int) (j2 >> 32);
        int bits$iv$iv$iv2 = (int) (4294967295L & j2);
        return new Size(Float.intBitsToFloat(bits$iv$iv$iv), Float.intBitsToFloat(bits$iv$iv$iv2));
    }
}