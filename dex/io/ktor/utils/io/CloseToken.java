package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.CopyableThrowable;

/* compiled from: CloseToken.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0013\u0010\n\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lio/ktor/utils/io/CloseToken;", "", "", "origin", "<init>", "(Ljava/lang/Throwable;)V", "closedException", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "cause", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class CloseToken {
    private final Throwable closedException;

    public CloseToken(Throwable origin) {
        IOException iOException;
        if (origin == null) {
            iOException = null;
        } else if (origin instanceof CancellationException) {
            if (origin instanceof CopyableThrowable) {
                iOException = ((CopyableThrowable) origin).createCopy();
            } else {
                String message = ((CancellationException) origin).getMessage();
                iOException = kotlinx.coroutines.ExceptionsKt.CancellationException(message == null ? "Channel was cancelled" : message, origin);
            }
        } else if ((origin instanceof IOException) && (origin instanceof CopyableThrowable)) {
            iOException = ((CopyableThrowable) origin).createCopy();
        } else {
            String message2 = origin.getMessage();
            iOException = new IOException(message2 == null ? "Channel was closed" : message2, origin);
        }
        this.closedException = iOException;
    }

    public final Throwable getCause() {
        if (this.closedException == null) {
            return null;
        }
        if (this.closedException instanceof IOException) {
            if (this.closedException instanceof CopyableThrowable) {
                return this.closedException.createCopy();
            }
            return new IOException(((IOException) this.closedException).getMessage(), this.closedException);
        } else if (this.closedException instanceof CopyableThrowable) {
            Throwable createCopy = this.closedException.createCopy();
            return createCopy == null ? kotlinx.coroutines.ExceptionsKt.CancellationException(this.closedException.getMessage(), this.closedException) : createCopy;
        } else {
            return kotlinx.coroutines.ExceptionsKt.CancellationException(this.closedException.getMessage(), this.closedException);
        }
    }
}