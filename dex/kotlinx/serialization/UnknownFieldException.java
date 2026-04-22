package kotlinx.serialization;

import kotlin.Metadata;

/* compiled from: SerializationExceptions.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0011\b\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/serialization/UnknownFieldException;", "Lkotlinx/serialization/SerializationException;", "index", "", "(I)V", "message", "", "(Ljava/lang/String;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UnknownFieldException extends SerializationException {
    public UnknownFieldException(String message) {
        super(message);
    }

    public UnknownFieldException(int index) {
        this("An unknown field for index " + index);
    }
}