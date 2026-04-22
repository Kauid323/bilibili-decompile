package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import com.bilibili.upper.comm.statistics.StatisticsHelper;
import kotlin.Metadata;
import kotlinx.coroutines.DisposableHandle;

/* compiled from: FrameCommon.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/websocket/NonDisposableHandle;", "Lkotlinx/coroutines/DisposableHandle;", "<init>", "()V", Column.INVAL_VALUE, "dispose", Column.INVAL_VALUE, StatisticsHelper.PAGE_RELATION_FROM_OTHER, Column.INVAL_VALUE, "equals", "(Ljava/lang/Object;)Z", Column.INVAL_VALUE, "hashCode", "()I", Column.INVAL_VALUE, "toString", "()Ljava/lang/String;", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NonDisposableHandle implements DisposableHandle {
    public static final NonDisposableHandle INSTANCE = new NonDisposableHandle();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NonDisposableHandle) {
            NonDisposableHandle nonDisposableHandle = (NonDisposableHandle) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 207988788;
    }

    public String toString() {
        return "NonDisposableHandle";
    }

    private NonDisposableHandle() {
    }

    public void dispose() {
    }
}