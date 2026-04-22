package home.sidecenter.tabs;

import BottomSheetItemData$;
import com.bapis.bilibili.app.home.v1.KTab;
import com.bapis.bilibili.app.home.v1.KTabExtraInfo;
import com.bapis.bilibili.app.home.v1.KTopLeftTabRes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SideCenterTabs.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003JA\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lhome/sidecenter/tabs/SideCenterTabsState;", "", "pageStatus", "Lhome/sidecenter/tabs/SideCenterTabsStatus;", "toast", "", "tabs", "", "Lhome/sidecenter/tabs/SideCenterTab;", "defaultTab", "showSwitchToMine", "", "<init>", "(Lhome/sidecenter/tabs/SideCenterTabsStatus;Ljava/lang/String;Ljava/util/List;Lhome/sidecenter/tabs/SideCenterTab;Z)V", "rsp", "Lcom/bapis/bilibili/app/home/v1/KTopLeftTabRes;", "(Lcom/bapis/bilibili/app/home/v1/KTopLeftTabRes;)V", "getPageStatus", "()Lhome/sidecenter/tabs/SideCenterTabsStatus;", "getToast", "()Ljava/lang/String;", "getTabs", "()Ljava/util/List;", "getDefaultTab", "()Lhome/sidecenter/tabs/SideCenterTab;", "getShowSwitchToMine", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SideCenterTabsState {
    public static final int $stable = 8;
    private final SideCenterTab defaultTab;
    private final SideCenterTabsStatus pageStatus;
    private final boolean showSwitchToMine;
    private final List<SideCenterTab> tabs;
    private final String toast;

    public static /* synthetic */ SideCenterTabsState copy$default(SideCenterTabsState sideCenterTabsState, SideCenterTabsStatus sideCenterTabsStatus, String str, List list, SideCenterTab sideCenterTab, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sideCenterTabsStatus = sideCenterTabsState.pageStatus;
        }
        if ((i2 & 2) != 0) {
            str = sideCenterTabsState.toast;
        }
        String str2 = str;
        List<SideCenterTab> list2 = list;
        if ((i2 & 4) != 0) {
            list2 = sideCenterTabsState.tabs;
        }
        List list3 = list2;
        if ((i2 & 8) != 0) {
            sideCenterTab = sideCenterTabsState.defaultTab;
        }
        SideCenterTab sideCenterTab2 = sideCenterTab;
        if ((i2 & 16) != 0) {
            z = sideCenterTabsState.showSwitchToMine;
        }
        return sideCenterTabsState.copy(sideCenterTabsStatus, str2, list3, sideCenterTab2, z);
    }

    public final SideCenterTabsStatus component1() {
        return this.pageStatus;
    }

    public final String component2() {
        return this.toast;
    }

    public final List<SideCenterTab> component3() {
        return this.tabs;
    }

    public final SideCenterTab component4() {
        return this.defaultTab;
    }

    public final boolean component5() {
        return this.showSwitchToMine;
    }

    public final SideCenterTabsState copy(SideCenterTabsStatus sideCenterTabsStatus, String str, List<? extends SideCenterTab> list, SideCenterTab sideCenterTab, boolean z) {
        Intrinsics.checkNotNullParameter(sideCenterTabsStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(str, "toast");
        Intrinsics.checkNotNullParameter(list, "tabs");
        Intrinsics.checkNotNullParameter(sideCenterTab, "defaultTab");
        return new SideCenterTabsState(sideCenterTabsStatus, str, list, sideCenterTab, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SideCenterTabsState) {
            SideCenterTabsState sideCenterTabsState = (SideCenterTabsState) obj;
            return this.pageStatus == sideCenterTabsState.pageStatus && Intrinsics.areEqual(this.toast, sideCenterTabsState.toast) && Intrinsics.areEqual(this.tabs, sideCenterTabsState.tabs) && this.defaultTab == sideCenterTabsState.defaultTab && this.showSwitchToMine == sideCenterTabsState.showSwitchToMine;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.pageStatus.hashCode() * 31) + this.toast.hashCode()) * 31) + this.tabs.hashCode()) * 31) + this.defaultTab.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showSwitchToMine);
    }

    public String toString() {
        SideCenterTabsStatus sideCenterTabsStatus = this.pageStatus;
        String str = this.toast;
        List<SideCenterTab> list = this.tabs;
        SideCenterTab sideCenterTab = this.defaultTab;
        return "SideCenterTabsState(pageStatus=" + sideCenterTabsStatus + ", toast=" + str + ", tabs=" + list + ", defaultTab=" + sideCenterTab + ", showSwitchToMine=" + this.showSwitchToMine + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SideCenterTabsState(SideCenterTabsStatus pageStatus, String toast, List<? extends SideCenterTab> list, SideCenterTab defaultTab, boolean showSwitchToMine) {
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(toast, "toast");
        Intrinsics.checkNotNullParameter(list, "tabs");
        Intrinsics.checkNotNullParameter(defaultTab, "defaultTab");
        this.pageStatus = pageStatus;
        this.toast = toast;
        this.tabs = list;
        this.defaultTab = defaultTab;
        this.showSwitchToMine = showSwitchToMine;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SideCenterTabsState(SideCenterTabsStatus sideCenterTabsStatus, String str, List list, SideCenterTab sideCenterTab, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, list, sideCenterTab, z);
        SideCenterTabsStatus sideCenterTabsStatus2;
        String str2;
        if ((i2 & 1) == 0) {
            sideCenterTabsStatus2 = sideCenterTabsStatus;
        } else {
            sideCenterTabsStatus2 = SideCenterTabsStatus.Idle;
        }
        if ((i2 & 2) == 0) {
            str2 = str;
        } else {
            str2 = "";
        }
    }

    public final SideCenterTabsStatus getPageStatus() {
        return this.pageStatus;
    }

    public final String getToast() {
        return this.toast;
    }

    public final List<SideCenterTab> getTabs() {
        return this.tabs;
    }

    public final SideCenterTab getDefaultTab() {
        return this.defaultTab;
    }

    public final boolean getShowSwitchToMine() {
        return this.showSwitchToMine;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SideCenterTabsState(KTopLeftTabRes rsp) {
        this(r3, null, r5, r6, r0 != null ? r0.getSwitchToMineConfigBubble() : false, 2, null);
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        SideCenterTabsStatus sideCenterTabsStatus = SideCenterTabsStatus.Success;
        Iterable $this$mapNotNull$iv = rsp.getTabs();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            SideCenterTab it = SideCenterTab.Companion.fromKTab((KTab) element$iv$iv$iv);
            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            it = it != SideCenterTab.UNKNOWN ? it : null;
            if (it != null) {
                destination$iv$iv.add(it);
            }
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
        }
        List distinct = CollectionsKt.distinct((List) destination$iv$iv);
        SideCenterTab fromKTab = SideCenterTab.Companion.fromKTab(rsp.getDefaultTab());
        KTabExtraInfo extra = rsp.getExtra();
    }
}