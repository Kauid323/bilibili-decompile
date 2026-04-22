package tv.danmaku.bili.aurora.api.trace;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: XTrace.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"TAG", "", "toHex", "", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class XTraceKt {
    private static final String TAG = "net.aurora.xtrace";

    public static final String toHex(byte[] $this$toHex) {
        Intrinsics.checkNotNullParameter($this$toHex, "<this>");
        return ArraysKt.joinToString$default($this$toHex, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.aurora.api.trace.XTraceKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence hex$lambda$0;
                hex$lambda$0 = XTraceKt.toHex$lambda$0(((Byte) obj).byteValue());
                return hex$lambda$0;
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toHex$lambda$0(byte eachByte) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(eachByte)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}