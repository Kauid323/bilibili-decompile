package kotlinx.datetime.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: toKotlinCode.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000¨\u0006\u0003"}, d2 = {"toKotlinCode", "", "", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ToKotlinCodeKt {
    public static final String toKotlinCode(String $this$toKotlinCode) {
        Intrinsics.checkNotNullParameter($this$toKotlinCode, "<this>");
        StringBuilder $this$toKotlinCode_u24lambda_u240 = new StringBuilder();
        $this$toKotlinCode_u24lambda_u240.append('\"');
        int length = $this$toKotlinCode.length();
        for (int i = 0; i < length; i++) {
            char c = $this$toKotlinCode.charAt(i);
            if (c == '\"') {
                $this$toKotlinCode_u24lambda_u240.append("\\\"");
            } else if (c == '\\') {
                $this$toKotlinCode_u24lambda_u240.append("\\\\");
            } else if (c == '\b') {
                $this$toKotlinCode_u24lambda_u240.append("\\b");
            } else if (c == '\t') {
                $this$toKotlinCode_u24lambda_u240.append("\\t");
            } else if (c == '\n') {
                $this$toKotlinCode_u24lambda_u240.append("\\n");
            } else if (c == '\r') {
                $this$toKotlinCode_u24lambda_u240.append("\\r");
            } else {
                $this$toKotlinCode_u24lambda_u240.append(c);
            }
        }
        $this$toKotlinCode_u24lambda_u240.append('\"');
        String sb = $this$toKotlinCode_u24lambda_u240.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final String toKotlinCode(char $this$toKotlinCode) {
        return $this$toKotlinCode == '\'' ? "'\\''" : new StringBuilder().append('\'').append($this$toKotlinCode).append('\'').toString();
    }
}