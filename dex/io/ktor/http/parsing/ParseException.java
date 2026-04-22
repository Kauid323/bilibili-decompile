package io.ktor.http.parsing;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParseException.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/http/parsing/ParseException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "", "message", "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ParseException extends IllegalArgumentException {
    private final Throwable cause;
    private final String message;

    public /* synthetic */ ParseException(String str, Throwable th, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : th);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParseException(String message, Throwable cause) {
        super(message, cause);
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
        this.cause = cause;
    }
}