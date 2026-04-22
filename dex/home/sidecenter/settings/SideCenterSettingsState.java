package home.sidecenter.settings;

import com.bapis.bilibili.app.home.v1.KMineSelection;
import com.bapis.bilibili.app.home.v1.KMineSelectionContentRes;
import com.bapis.bilibili.app.home.v1.KTab;
import com.bapis.bilibili.app.home.v1.KTopLeftTabRes;
import home.sidecenter.recent.MineSelection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SideCenterSettings.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eB\u001d\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\u000e\u0010)\u001a\u00020\fHÀ\u0003¢\u0006\u0002\b*JC\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010,\u001a\u00020\"2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\fHÖ\u0001J\t\u0010/\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017¨\u00060"}, d2 = {"Lhome/sidecenter/settings/SideCenterSettingsState;", "", "pageStatus", "Lhome/sidecenter/settings/SideCenterSettingsPageStatus;", "settingGroups", "", "Lhome/sidecenter/settings/ISideCenterSettingGroup;", "mineSelection", "Lhome/sidecenter/recent/MineSelection;", "checkedMineTabToast", "", "toastDismissDelayId", "", "<init>", "(Lhome/sidecenter/settings/SideCenterSettingsPageStatus;Ljava/util/List;Lhome/sidecenter/recent/MineSelection;Ljava/lang/String;I)V", "tabRsp", "Lcom/bapis/bilibili/app/home/v1/KTopLeftTabRes;", "mineSelectionRes", "Lcom/bapis/bilibili/app/home/v1/KMineSelectionContentRes;", "(Lcom/bapis/bilibili/app/home/v1/KTopLeftTabRes;Lcom/bapis/bilibili/app/home/v1/KMineSelectionContentRes;)V", "getPageStatus", "()Lhome/sidecenter/settings/SideCenterSettingsPageStatus;", "getSettingGroups", "()Ljava/util/List;", "getMineSelection", "()Lhome/sidecenter/recent/MineSelection;", "getCheckedMineTabToast", "()Ljava/lang/String;", "getToastDismissDelayId$sidecenter_debug", "()I", "settings", "Lhome/sidecenter/settings/ISideCenterSettingItem;", "getSettings", "isTabChecked", "", "tab", "Lhome/sidecenter/settings/SideCenterSettingType;", "component1", "component2", "component3", "component4", "component5", "component5$sidecenter_debug", "copy", "equals", "other", "hashCode", "toString", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SideCenterSettingsState {
    public static final int $stable = 8;
    private final String checkedMineTabToast;
    private final MineSelection mineSelection;
    private final SideCenterSettingsPageStatus pageStatus;
    private final List<ISideCenterSettingGroup> settingGroups;
    private final List<ISideCenterSettingItem> settings;
    private final int toastDismissDelayId;

    public SideCenterSettingsState() {
        this(null, null, null, null, 0, 31, null);
    }

    public static /* synthetic */ SideCenterSettingsState copy$default(SideCenterSettingsState sideCenterSettingsState, SideCenterSettingsPageStatus sideCenterSettingsPageStatus, List list, MineSelection mineSelection, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            sideCenterSettingsPageStatus = sideCenterSettingsState.pageStatus;
        }
        List<ISideCenterSettingGroup> list2 = list;
        if ((i3 & 2) != 0) {
            list2 = sideCenterSettingsState.settingGroups;
        }
        List list3 = list2;
        if ((i3 & 4) != 0) {
            mineSelection = sideCenterSettingsState.mineSelection;
        }
        MineSelection mineSelection2 = mineSelection;
        if ((i3 & 8) != 0) {
            str = sideCenterSettingsState.checkedMineTabToast;
        }
        String str2 = str;
        if ((i3 & 16) != 0) {
            i2 = sideCenterSettingsState.toastDismissDelayId;
        }
        return sideCenterSettingsState.copy(sideCenterSettingsPageStatus, list3, mineSelection2, str2, i2);
    }

    public final SideCenterSettingsPageStatus component1() {
        return this.pageStatus;
    }

    public final List<ISideCenterSettingGroup> component2() {
        return this.settingGroups;
    }

    public final MineSelection component3() {
        return this.mineSelection;
    }

    public final String component4() {
        return this.checkedMineTabToast;
    }

    public final int component5$sidecenter_debug() {
        return this.toastDismissDelayId;
    }

    public final SideCenterSettingsState copy(SideCenterSettingsPageStatus sideCenterSettingsPageStatus, List<? extends ISideCenterSettingGroup> list, MineSelection mineSelection, String str, int i2) {
        Intrinsics.checkNotNullParameter(sideCenterSettingsPageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(list, "settingGroups");
        Intrinsics.checkNotNullParameter(str, "checkedMineTabToast");
        return new SideCenterSettingsState(sideCenterSettingsPageStatus, list, mineSelection, str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SideCenterSettingsState) {
            SideCenterSettingsState sideCenterSettingsState = (SideCenterSettingsState) obj;
            return this.pageStatus == sideCenterSettingsState.pageStatus && Intrinsics.areEqual(this.settingGroups, sideCenterSettingsState.settingGroups) && Intrinsics.areEqual(this.mineSelection, sideCenterSettingsState.mineSelection) && Intrinsics.areEqual(this.checkedMineTabToast, sideCenterSettingsState.checkedMineTabToast) && this.toastDismissDelayId == sideCenterSettingsState.toastDismissDelayId;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.pageStatus.hashCode() * 31) + this.settingGroups.hashCode()) * 31) + (this.mineSelection == null ? 0 : this.mineSelection.hashCode())) * 31) + this.checkedMineTabToast.hashCode()) * 31) + this.toastDismissDelayId;
    }

    public String toString() {
        SideCenterSettingsPageStatus sideCenterSettingsPageStatus = this.pageStatus;
        List<ISideCenterSettingGroup> list = this.settingGroups;
        MineSelection mineSelection = this.mineSelection;
        String str = this.checkedMineTabToast;
        return "SideCenterSettingsState(pageStatus=" + sideCenterSettingsPageStatus + ", settingGroups=" + list + ", mineSelection=" + mineSelection + ", checkedMineTabToast=" + str + ", toastDismissDelayId=" + this.toastDismissDelayId + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SideCenterSettingsState(SideCenterSettingsPageStatus pageStatus, List<? extends ISideCenterSettingGroup> list, MineSelection mineSelection, String checkedMineTabToast, int toastDismissDelayId) {
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(list, "settingGroups");
        Intrinsics.checkNotNullParameter(checkedMineTabToast, "checkedMineTabToast");
        this.pageStatus = pageStatus;
        this.settingGroups = list;
        this.mineSelection = mineSelection;
        this.checkedMineTabToast = checkedMineTabToast;
        this.toastDismissDelayId = toastDismissDelayId;
        Iterable $this$flatMap$iv = this.settingGroups;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            ISideCenterSettingGroup it = (ISideCenterSettingGroup) element$iv$iv;
            Iterable list$iv$iv = CollectionsKt.plus(CollectionsKt.listOf(it), it.getItems());
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        this.settings = (List) destination$iv$iv;
    }

    public /* synthetic */ SideCenterSettingsState(SideCenterSettingsPageStatus sideCenterSettingsPageStatus, List list, MineSelection mineSelection, String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? SideCenterSettingsPageStatus.Idle : sideCenterSettingsPageStatus, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? null : mineSelection, (i3 & 8) != 0 ? "" : str, (i3 & 16) != 0 ? 0 : i2);
    }

    public final SideCenterSettingsPageStatus getPageStatus() {
        return this.pageStatus;
    }

    public final List<ISideCenterSettingGroup> getSettingGroups() {
        return this.settingGroups;
    }

    public final MineSelection getMineSelection() {
        return this.mineSelection;
    }

    public final String getCheckedMineTabToast() {
        return this.checkedMineTabToast;
    }

    public final int getToastDismissDelayId$sidecenter_debug() {
        return this.toastDismissDelayId;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SideCenterSettingsState(KTopLeftTabRes tabRsp, KMineSelectionContentRes mineSelectionRes) {
        this(r1, r2, (mineSelectionRes == null || (it = mineSelectionRes.getMineSelection()) == null) ? r13 : new MineSelection(it), null, 0, 24, null);
        MineSelection mineSelection;
        ArrayList emptyList;
        KMineSelection it;
        SideCenterSettingsPageStatus sideCenterSettingsPageStatus = SideCenterSettingsPageStatus.Success;
        if (tabRsp != null) {
            ArrayList arrayList = new ArrayList();
            Iterable $this$map$iv = tabRsp.getTabs();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv.add(SideCenterSettingType.Companion.fromKTab((KTab) item$iv$iv));
            }
            List types = (List) destination$iv$iv;
            boolean isHasRecent = types.contains(SideCenterSettingType.Recent);
            boolean isHasStory = types.contains(SideCenterSettingType.Story);
            boolean isHasListen = types.contains(SideCenterSettingType.Listen);
            arrayList.add(new SideCenterSettingGroup(new SideCenterSettingItem(SideCenterSettingType.Recent, isHasRecent), CollectionsKt.listOf(new SideCenterSettingItem[]{new SideCenterSettingItem(SideCenterSettingType.Story, isHasStory), new SideCenterSettingItem(SideCenterSettingType.Listen, isHasListen)})));
            mineSelection = null;
            arrayList.add(new SideCenterSettingGroup(new SideCenterSettingItem(SideCenterSettingType.Mine, !isHasRecent), null, 2, null));
            emptyList = arrayList;
        } else {
            mineSelection = null;
            emptyList = CollectionsKt.emptyList();
        }
    }

    public final List<ISideCenterSettingItem> getSettings() {
        return this.settings;
    }

    public final boolean isTabChecked(SideCenterSettingType tab) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(tab, "tab");
        Iterator<T> it = this.settings.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ISideCenterSettingItem it2 = (ISideCenterSettingItem) obj;
            if (it2.getTab() == tab) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        ISideCenterSettingItem iSideCenterSettingItem = (ISideCenterSettingItem) obj;
        if (iSideCenterSettingItem != null) {
            return iSideCenterSettingItem.isChecked();
        }
        return false;
    }
}