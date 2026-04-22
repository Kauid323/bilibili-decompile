package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharkLog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0086\bJ\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0086\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lshark/SharkLog;", "", "()V", "logger", "Lshark/SharkLog$Logger;", "getLogger", "()Lshark/SharkLog$Logger;", "setLogger", "(Lshark/SharkLog$Logger;)V", "d", "", "message", "Lkotlin/Function0;", "", "throwable", "", "Logger", "shark-log"}, k = 1, mv = {1, 4, 1})
public final class SharkLog {
    public static final SharkLog INSTANCE = new SharkLog();
    private static volatile Logger logger;

    /* compiled from: SharkLog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lshark/SharkLog$Logger;", "", "d", "", "message", "", "throwable", "", "shark-log"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface Logger {
        void d(String str);

        void d(Throwable th, String str);
    }

    private SharkLog() {
    }

    public final Logger getLogger() {
        return logger;
    }

    public final void setLogger(Logger logger2) {
        logger = logger2;
    }

    public final void d(Function0<String> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "message");
        Logger logger2 = getLogger();
        if (logger2 == null) {
            return;
        }
        logger2.d((String) function0.invoke());
    }

    public final void d(Throwable throwable, Function0<String> function0) {
        Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        Intrinsics.checkParameterIsNotNull(function0, "message");
        Logger logger2 = getLogger();
        if (logger2 == null) {
            return;
        }
        logger2.d(throwable, (String) function0.invoke());
    }
}