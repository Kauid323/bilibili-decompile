package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugProbesImpl.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"repr", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DebugProbesImplKt {
    public static final String repr(String $this$repr) {
        StringBuilder $this$repr_u24lambda_u240 = new StringBuilder();
        $this$repr_u24lambda_u240.append('\"');
        int length = $this$repr.length();
        for (int i = 0; i < length; i++) {
            char c = $this$repr.charAt(i);
            if (c == '\"') {
                $this$repr_u24lambda_u240.append("\\\"");
            } else if (c == '\\') {
                $this$repr_u24lambda_u240.append("\\\\");
            } else if (c == '\b') {
                $this$repr_u24lambda_u240.append("\\b");
            } else if (c == '\n') {
                $this$repr_u24lambda_u240.append("\\n");
            } else if (c == '\r') {
                $this$repr_u24lambda_u240.append("\\r");
            } else if (c == '\t') {
                $this$repr_u24lambda_u240.append("\\t");
            } else {
                $this$repr_u24lambda_u240.append(c);
            }
        }
        $this$repr_u24lambda_u240.append('\"');
        String sb = $this$repr_u24lambda_u240.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }
}