package kotlinx.io;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: JvmCore.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\"\u001c\u0010\u0006\u001a\u00020\u0007*\u00060\bj\u0002`\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"asSink", "Lkotlinx/io/RawSink;", "Ljava/io/OutputStream;", "asSource", "Lkotlinx/io/RawSource;", "Ljava/io/InputStream;", "isAndroidGetsocknameError", "", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "(Ljava/lang/AssertionError;)Z", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class JvmCoreKt {
    public static final RawSink asSink(OutputStream $this$asSink) {
        Intrinsics.checkNotNullParameter($this$asSink, "<this>");
        return new OutputStreamSink($this$asSink);
    }

    public static final RawSource asSource(InputStream $this$asSource) {
        Intrinsics.checkNotNullParameter($this$asSource, "<this>");
        return new InputStreamSource($this$asSource);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError $this$isAndroidGetsocknameError) {
        Intrinsics.checkNotNullParameter($this$isAndroidGetsocknameError, "<this>");
        if ($this$isAndroidGetsocknameError.getCause() != null) {
            String message = $this$isAndroidGetsocknameError.getMessage();
            return message != null ? StringsKt.contains$default((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null) : false;
        }
        return false;
    }
}