package kntr.app.digital.preview.action;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Action.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lkntr/app/digital/preview/action/Action;", "T", RoomRecommendViewModel.EMPTY_CURSOR, "data", "report", "Lkntr/app/digital/preview/action/Report;", "<init>", "(Ljava/lang/Object;Lkntr/app/digital/preview/action/Report;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getReport", "()Lkntr/app/digital/preview/action/Report;", "component1", "component2", "copy", "(Ljava/lang/Object;Lkntr/app/digital/preview/action/Report;)Lkntr/app/digital/preview/action/Action;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Action<T> {
    public static final int $stable = 8;
    private final T data;
    private final Report report;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Action copy$default(Action action, Object obj, Report report, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = action.data;
        }
        if ((i & 2) != 0) {
            report = action.report;
        }
        return action.copy(obj, report);
    }

    public final T component1() {
        return this.data;
    }

    public final Report component2() {
        return this.report;
    }

    public final Action<T> copy(T t, Report report) {
        Intrinsics.checkNotNullParameter(t, "data");
        return new Action<>(t, report);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Action) {
            Action action = (Action) obj;
            return Intrinsics.areEqual(this.data, action.data) && Intrinsics.areEqual(this.report, action.report);
        }
        return false;
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + (this.report == null ? 0 : this.report.hashCode());
    }

    public String toString() {
        T t = this.data;
        return "Action(data=" + t + ", report=" + this.report + ")";
    }

    public Action(T t, Report report) {
        Intrinsics.checkNotNullParameter(t, "data");
        this.data = t;
        this.report = report;
    }

    public /* synthetic */ Action(Object obj, Report report, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : report);
    }

    public final T getData() {
        return this.data;
    }

    public final Report getReport() {
        return this.report;
    }
}