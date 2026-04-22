package video.biz.offline.list.logic.model;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MaxConcurrentModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lvideo/biz/offline/list/logic/model/MaxConcurrentModel;", "", "count", "", "tip", "", "selected", "", "<init>", "(ILjava/lang/String;Z)V", "getCount", "()I", "getTip", "()Ljava/lang/String;", "getSelected", "()Z", "setSelected", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MaxConcurrentModel {
    public static final int $stable = 8;
    private final int count;
    private boolean selected;
    private final String tip;

    public static /* synthetic */ MaxConcurrentModel copy$default(MaxConcurrentModel maxConcurrentModel, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = maxConcurrentModel.count;
        }
        if ((i2 & 2) != 0) {
            str = maxConcurrentModel.tip;
        }
        if ((i2 & 4) != 0) {
            z = maxConcurrentModel.selected;
        }
        return maxConcurrentModel.copy(i, str, z);
    }

    public final int component1() {
        return this.count;
    }

    public final String component2() {
        return this.tip;
    }

    public final boolean component3() {
        return this.selected;
    }

    public final MaxConcurrentModel copy(int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "tip");
        return new MaxConcurrentModel(i, str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MaxConcurrentModel) {
            MaxConcurrentModel maxConcurrentModel = (MaxConcurrentModel) obj;
            return this.count == maxConcurrentModel.count && Intrinsics.areEqual(this.tip, maxConcurrentModel.tip) && this.selected == maxConcurrentModel.selected;
        }
        return false;
    }

    public int hashCode() {
        return (((this.count * 31) + this.tip.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.selected);
    }

    public String toString() {
        int i = this.count;
        String str = this.tip;
        return "MaxConcurrentModel(count=" + i + ", tip=" + str + ", selected=" + this.selected + ")";
    }

    public MaxConcurrentModel(int count, String tip, boolean selected) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        this.count = count;
        this.tip = tip;
        this.selected = selected;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getTip() {
        return this.tip;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }
}