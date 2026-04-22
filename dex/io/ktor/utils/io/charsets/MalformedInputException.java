package io.ktor.utils.io.charsets;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CharsetJVM.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/utils/io/charsets/MalformedInputException;", "Ljava/nio/charset/MalformedInputException;", "", "message", "<init>", "(Ljava/lang/String;)V", "_message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public class MalformedInputException extends java.nio.charset.MalformedInputException {
    private final String _message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MalformedInputException(String message) {
        super(0);
        Intrinsics.checkNotNullParameter(message, "message");
        this._message = message;
    }

    @Override // java.nio.charset.MalformedInputException, java.lang.Throwable
    public String getMessage() {
        return this._message;
    }
}