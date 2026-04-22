package io.ktor.utils.io.core.internal;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.PropsConstants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Numbers.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0081\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "", PropsConstants.NAME, "", "toIntOrFail", "(JLjava/lang/String;)I", "value", "", "failLongToIntConversion", "(JLjava/lang/String;)Ljava/lang/Void;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class NumbersKt {
    public static final int toIntOrFail(long $this$toIntOrFail, String name) {
        Intrinsics.checkNotNullParameter(name, PropsConstants.NAME);
        if ($this$toIntOrFail >= 2147483647L) {
            failLongToIntConversion($this$toIntOrFail, name);
            throw new KotlinNothingValueException();
        }
        return (int) $this$toIntOrFail;
    }

    public static final Void failLongToIntConversion(long value, String name) {
        Intrinsics.checkNotNullParameter(name, PropsConstants.NAME);
        throw new IllegalArgumentException("Long value " + value + " of " + name + " doesn't fit into 32-bit integer");
    }
}