package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteChannel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/utils/io/ConcurrentIOException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "", "taskName", "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ConcurrentIOException extends IllegalStateException {
    public /* synthetic */ ConcurrentIOException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcurrentIOException(String taskName, Throwable cause) {
        super("Concurrent " + taskName + " attempts", cause);
        Intrinsics.checkNotNullParameter(taskName, "taskName");
    }
}