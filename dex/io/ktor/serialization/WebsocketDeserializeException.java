package io.ktor.serialization;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentConvertException.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/serialization/WebsocketDeserializeException;", "Lio/ktor/serialization/WebsocketContentConvertException;", "", "message", "", "cause", "Lio/ktor/websocket/Frame;", "frame", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Lio/ktor/websocket/Frame;)V", "Lio/ktor/websocket/Frame;", "getFrame", "()Lio/ktor/websocket/Frame;", "ktor-serialization"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WebsocketDeserializeException extends WebsocketContentConvertException {
    private final Frame frame;

    public /* synthetic */ WebsocketDeserializeException(String str, Throwable th, Frame frame, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : th, frame);
    }

    public final Frame getFrame() {
        return this.frame;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebsocketDeserializeException(String message, Throwable cause, Frame frame) {
        super(message, cause);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(frame, "frame");
        this.frame = frame;
    }
}