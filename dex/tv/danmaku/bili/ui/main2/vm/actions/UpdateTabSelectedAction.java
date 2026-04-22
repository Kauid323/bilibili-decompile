package tv.danmaku.bili.ui.main2.vm.actions;

import com.bilibili.lib.homepage.home.model.HomePageState;
import com.bilibili.lib.homepage.home.model.HomeState;
import com.bilibili.lib.homepage.home.model.HomeUpdateEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: UpdateTabSelectedAction.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/main2/vm/actions/UpdateTabSelectedAction;", "Lcom/bilibili/lib/homepage/home/model/HomeUpdateEvent;", "position", "", "<init>", "(I)V", "getPosition", "()I", "reduce", "Lcom/bilibili/lib/homepage/home/model/HomeState;", AuthResultCbHelper.ARGS_STATE, "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UpdateTabSelectedAction implements HomeUpdateEvent {
    public static final int $stable = 0;
    private final int position;

    public static /* synthetic */ UpdateTabSelectedAction copy$default(UpdateTabSelectedAction updateTabSelectedAction, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = updateTabSelectedAction.position;
        }
        return updateTabSelectedAction.copy(i);
    }

    public final int component1() {
        return this.position;
    }

    public final UpdateTabSelectedAction copy(int i) {
        return new UpdateTabSelectedAction(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UpdateTabSelectedAction) && this.position == ((UpdateTabSelectedAction) obj).position;
    }

    public int hashCode() {
        return this.position;
    }

    public String toString() {
        return "UpdateTabSelectedAction(position=" + this.position + ")";
    }

    public UpdateTabSelectedAction(int position) {
        this.position = position;
    }

    public final int getPosition() {
        return this.position;
    }

    public HomeState reduce(HomeState state) {
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        return state.copy(HomePageState.copy$default(state.getHomePageState(), this.position, false, 2, (Object) null));
    }
}