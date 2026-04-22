package tv.danmaku.bili.ui.personinfo.modifyNameV2;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ModifyNameV2.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/EditState;", "", "tips", "", "canEdit", "", "<init>", "(Ljava/lang/String;Z)V", "getTips", "()Ljava/lang/String;", "getCanEdit", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class EditState {
    public static final int $stable = 0;
    private final boolean canEdit;
    private final String tips;

    public EditState() {
        this(null, false, 3, null);
    }

    public static /* synthetic */ EditState copy$default(EditState editState, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = editState.tips;
        }
        if ((i & 2) != 0) {
            z = editState.canEdit;
        }
        return editState.copy(str, z);
    }

    public final String component1() {
        return this.tips;
    }

    public final boolean component2() {
        return this.canEdit;
    }

    public final EditState copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "tips");
        return new EditState(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EditState) {
            EditState editState = (EditState) obj;
            return Intrinsics.areEqual(this.tips, editState.tips) && this.canEdit == editState.canEdit;
        }
        return false;
    }

    public int hashCode() {
        return (this.tips.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.canEdit);
    }

    public String toString() {
        String str = this.tips;
        return "EditState(tips=" + str + ", canEdit=" + this.canEdit + ")";
    }

    public EditState(String tips, boolean canEdit) {
        Intrinsics.checkNotNullParameter(tips, "tips");
        this.tips = tips;
        this.canEdit = canEdit;
    }

    public /* synthetic */ EditState(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? true : z);
    }

    public final String getTips() {
        return this.tips;
    }

    public final boolean getCanEdit() {
        return this.canEdit;
    }
}