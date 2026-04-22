package io.ktor.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Charset.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0019\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "", "isLowerCase", "(C)Z", "", "", "toCharArray", "(Ljava/lang/String;)[C", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CharsetKt {
    public static final boolean isLowerCase(char $this$isLowerCase) {
        return Character.toLowerCase($this$isLowerCase) == $this$isLowerCase;
    }

    public static final char[] toCharArray(String $this$toCharArray) {
        Intrinsics.checkNotNullParameter($this$toCharArray, "<this>");
        int length = $this$toCharArray.length();
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = $this$toCharArray.charAt(i);
        }
        return cArr;
    }
}