package nl.adaptivity.xmlutil.core.impl;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: string.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0001\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001¨\u0006\u0005"}, d2 = {"contentEquals", "", "", "other", "", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class StringKt {
    @Deprecated(message = "Don't use, just use string comparison")
    public static final boolean contentEquals(CharSequence $this$contentEquals, CharSequence other) {
        if ($this$contentEquals == null) {
            return other == null;
        } else if (other != null && $this$contentEquals.length() == other.length()) {
            int length = $this$contentEquals.length();
            for (int i = 0; i < length; i++) {
                if ($this$contentEquals.charAt(i) != other.charAt(i)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Deprecated(message = "Use string equals", replaceWith = @ReplaceWith(expression = "this == other", imports = {}))
    public static final boolean contentEquals(String $this$contentEquals, String other) {
        return Intrinsics.areEqual($this$contentEquals, other);
    }
}