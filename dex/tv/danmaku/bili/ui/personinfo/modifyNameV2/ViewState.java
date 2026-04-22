package tv.danmaku.bili.ui.personinfo.modifyNameV2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.PageState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ModifyNameV2.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ViewState;", "", "pageState", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/PageState;", "editState", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/EditState;", "<init>", "(Ltv/danmaku/bili/ui/personinfo/modifyNameV2/PageState;Ltv/danmaku/bili/ui/personinfo/modifyNameV2/EditState;)V", "getPageState", "()Ltv/danmaku/bili/ui/personinfo/modifyNameV2/PageState;", "getEditState", "()Ltv/danmaku/bili/ui/personinfo/modifyNameV2/EditState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ViewState {
    public static final int $stable = 0;
    private final EditState editState;
    private final PageState pageState;

    public ViewState() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ ViewState copy$default(ViewState viewState, PageState pageState, EditState editState, int i, Object obj) {
        if ((i & 1) != 0) {
            pageState = viewState.pageState;
        }
        if ((i & 2) != 0) {
            editState = viewState.editState;
        }
        return viewState.copy(pageState, editState);
    }

    public final PageState component1() {
        return this.pageState;
    }

    public final EditState component2() {
        return this.editState;
    }

    public final ViewState copy(PageState pageState, EditState editState) {
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(editState, "editState");
        return new ViewState(pageState, editState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ViewState) {
            ViewState viewState = (ViewState) obj;
            return Intrinsics.areEqual(this.pageState, viewState.pageState) && Intrinsics.areEqual(this.editState, viewState.editState);
        }
        return false;
    }

    public int hashCode() {
        return (this.pageState.hashCode() * 31) + this.editState.hashCode();
    }

    public String toString() {
        PageState pageState = this.pageState;
        return "ViewState(pageState=" + pageState + ", editState=" + this.editState + ")";
    }

    public ViewState(PageState pageState, EditState editState) {
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(editState, "editState");
        this.pageState = pageState;
        this.editState = editState;
    }

    public /* synthetic */ ViewState(PageState.Initial initial, EditState editState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PageState.Initial.INSTANCE : initial, (i & 2) != 0 ? new EditState(null, false, 3, null) : editState);
    }

    public final PageState getPageState() {
        return this.pageState;
    }

    public final EditState getEditState() {
        return this.editState;
    }
}