package io.ktor.utils.io.charsets;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Encoding.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/utils/io/charsets/TooLongLineException;", "Lio/ktor/utils/io/charsets/MalformedInputException;", "", "message", "<init>", "(Ljava/lang/String;)V", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class TooLongLineException extends MalformedInputException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooLongLineException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}