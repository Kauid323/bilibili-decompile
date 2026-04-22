package io.ktor.utils.io.core;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Buffers.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/utils/io/core/BufferLimitExceededException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "message", "<init>", "(Ljava/lang/String;)V", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class BufferLimitExceededException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferLimitExceededException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}