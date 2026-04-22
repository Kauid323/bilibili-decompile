package io.ktor.utils.io.core;

import com.lynx.tasm.behavior.PropertyIDConstants;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Closeable.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aC\u0010\u0006\u001a\u00028\u0001\"\u0010\b\u0000\u0010\u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001\"\u0004\b\u0001\u0010\u0003*\u00028\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, d2 = {"Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "T", "R", "Lkotlin/Function1;", "block", "use", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class CloseableKt {
    public static final <T extends Closeable, R> R use(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        try {
            R r = (R) function1.invoke(t);
            InlineMarker.finallyStart(1);
            if (t != null) {
                t.close();
            }
            InlineMarker.finallyEnd(1);
            return r;
        } catch (Throwable cause) {
            if (t != null) {
                try {
                    t.close();
                }
            }
            throw cause;
        }
    }
}