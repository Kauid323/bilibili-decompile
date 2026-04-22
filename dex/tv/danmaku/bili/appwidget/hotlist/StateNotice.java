package tv.danmaku.bili.appwidget.hotlist;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: StateNotice.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/appwidget/hotlist/StateNotice;", "", "<init>", "()V", "listeners", "", "Ltv/danmaku/bili/appwidget/hotlist/DataChangeListener;", "addNotice", "", "listener", "refreshCard", "tryUpdate", "resetPage", "", "updateMode", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StateNotice {
    public static final int $stable = 8;
    private final List<DataChangeListener> listeners = new ArrayList();

    public final void addNotice(DataChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void refreshCard() {
        Iterable $this$forEach$iv = this.listeners;
        for (Object element$iv : $this$forEach$iv) {
            DataChangeListener it = (DataChangeListener) element$iv;
            it.onCardRefresh();
        }
    }

    public final void tryUpdate(boolean resetPage) {
        Iterable $this$forEach$iv = this.listeners;
        for (Object element$iv : $this$forEach$iv) {
            DataChangeListener it = (DataChangeListener) element$iv;
            it.onTryUpdate(resetPage);
        }
    }

    public final void updateMode() {
        Iterable $this$forEach$iv = this.listeners;
        for (Object element$iv : $this$forEach$iv) {
            DataChangeListener it = (DataChangeListener) element$iv;
            it.onChangeMode();
        }
    }
}