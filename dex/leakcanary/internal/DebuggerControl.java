package leakcanary.internal;

import android.os.Debug;
import kotlin.Metadata;

/* compiled from: DebuggerControl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0006"}, d2 = {"Lleakcanary/internal/DebuggerControl;", "", "()V", "isDebuggerAttached", "", "()Z", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class DebuggerControl {
    public static final DebuggerControl INSTANCE = new DebuggerControl();

    private DebuggerControl() {
    }

    public final boolean isDebuggerAttached() {
        return Debug.isDebuggerConnected();
    }
}