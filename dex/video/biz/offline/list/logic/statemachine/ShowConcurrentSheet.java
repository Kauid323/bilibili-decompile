package video.biz.offline.list.logic.statemachine;

import BottomSheetItemData$;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineDownloadingPageStateMachine.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/ShowConcurrentSheet;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "show", "", "<init>", "(Z)V", "getShow", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ShowConcurrentSheet implements OfflineListAction {
    public static final int $stable = 0;
    private final boolean show;

    public static /* synthetic */ ShowConcurrentSheet copy$default(ShowConcurrentSheet showConcurrentSheet, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = showConcurrentSheet.show;
        }
        return showConcurrentSheet.copy(z);
    }

    public final boolean component1() {
        return this.show;
    }

    public final ShowConcurrentSheet copy(boolean z) {
        return new ShowConcurrentSheet(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShowConcurrentSheet) && this.show == ((ShowConcurrentSheet) obj).show;
    }

    public int hashCode() {
        return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.show);
    }

    public String toString() {
        return "ShowConcurrentSheet(show=" + this.show + ")";
    }

    public ShowConcurrentSheet(boolean show) {
        this.show = show;
    }

    public final boolean getShow() {
        return this.show;
    }
}