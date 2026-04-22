package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.util.internal.ExceptionUtilsJvmKt;
import kotlin.Metadata;
import kotlinx.coroutines.CopyableThrowable;

/* compiled from: FrameTooBigException.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/websocket/FrameTooBigException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlinx/coroutines/CopyableThrowable;", Column.INVAL_VALUE, "frameSize", "<init>", "(J)V", "createCopy", "()Lio/ktor/websocket/FrameTooBigException;", "J", "getFrameSize", "()J", Column.INVAL_VALUE, "getMessage", "()Ljava/lang/String;", "message", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FrameTooBigException extends Exception implements CopyableThrowable<FrameTooBigException> {
    private final long frameSize;

    public final long getFrameSize() {
        return this.frameSize;
    }

    public FrameTooBigException(long frameSize) {
        this.frameSize = frameSize;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Frame is too big: " + this.frameSize;
    }

    /* renamed from: createCopy */
    public FrameTooBigException m2172createCopy() {
        FrameTooBigException it = new FrameTooBigException(this.frameSize);
        ExceptionUtilsJvmKt.initCauseBridge(it, this);
        return it;
    }
}