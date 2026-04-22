package nl.adaptivity.xmlutil;

import java.io.InputStream;
import java.io.Reader;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JVMXmlStreaming.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0005\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b¢\u0006\u0002\u0010\u0007\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"deserialize", "T", "", "input", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)Ljava/lang/Object;", "Ljava/io/Reader;", "(Ljava/io/Reader;)Ljava/lang/Object;", "", "(Ljava/lang/String;)Ljava/lang/Object;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class JVMXmlStreamingKt {
    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public static final /* synthetic */ <T> T deserialize(InputStream input) {
        Intrinsics.checkNotNullParameter(input, "input");
        XmlStreaming xmlStreaming = XmlStreaming.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) xmlStreaming.deSerialize(input, Object.class);
    }

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public static final /* synthetic */ <T> T deserialize(Reader input) {
        Intrinsics.checkNotNullParameter(input, "input");
        XmlStreaming xmlStreaming = XmlStreaming.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) xmlStreaming.deSerialize(input, Object.class);
    }

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public static final /* synthetic */ <T> T deserialize(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        XmlStreaming xmlStreaming = XmlStreaming.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) xmlStreaming.deSerialize(input, Object.class);
    }
}