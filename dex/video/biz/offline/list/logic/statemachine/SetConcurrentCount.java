package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineDownloadingPageStateMachine.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/SetConcurrentCount;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "count", "", "<init>", "(I)V", "getCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SetConcurrentCount implements OfflineListAction {
    public static final int $stable = 0;
    private final int count;

    public static /* synthetic */ SetConcurrentCount copy$default(SetConcurrentCount setConcurrentCount, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = setConcurrentCount.count;
        }
        return setConcurrentCount.copy(i);
    }

    public final int component1() {
        return this.count;
    }

    public final SetConcurrentCount copy(int i) {
        return new SetConcurrentCount(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SetConcurrentCount) && this.count == ((SetConcurrentCount) obj).count;
    }

    public int hashCode() {
        return this.count;
    }

    public String toString() {
        return "SetConcurrentCount(count=" + this.count + ")";
    }

    public SetConcurrentCount(int count) {
        this.count = count;
    }

    public final int getCount() {
        return this.count;
    }
}