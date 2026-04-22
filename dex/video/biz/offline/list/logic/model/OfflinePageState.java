package video.biz.offline.list.logic.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.model.ReserveInfo;
import video.biz.offline.base.model.model.StorageInfoModel;
import video.biz.offline.list.logic.model.DialogType;
import video.biz.offline.list.logic.model.SelectionState;

/* compiled from: OfflinePageState.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010$\u001a\u00020%J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'J\u0018\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010(J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\t\u00103\u001a\u00020\fHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00106\u001a\u00020\u0012HÆ\u0003Ji\u00107\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00108\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020*HÖ\u0001J\t\u0010;\u001a\u00020(HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010)\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006<"}, d2 = {"Lvideo/biz/offline/list/logic/model/OfflinePageState;", "", "downloading", "", "Lvideo/biz/offline/list/logic/model/OfflineDownloadingCardModel;", "completed", "Lvideo/biz/offline/list/logic/model/OfflineCachedCardModel;", "dataState", "Lvideo/biz/offline/list/logic/model/DataState;", "selectionState", "Lvideo/biz/offline/list/logic/model/SelectionState;", "config", "Lvideo/biz/offline/list/logic/model/OfflinePageConfig;", "storageInfo", "Lvideo/biz/offline/base/model/model/StorageInfoModel;", "reserveInfo", "Lvideo/biz/offline/base/model/model/ReserveInfo;", "dialogType", "Lvideo/biz/offline/list/logic/model/DialogType;", "<init>", "(Ljava/util/List;Ljava/util/List;Lvideo/biz/offline/list/logic/model/DataState;Lvideo/biz/offline/list/logic/model/SelectionState;Lvideo/biz/offline/list/logic/model/OfflinePageConfig;Lvideo/biz/offline/base/model/model/StorageInfoModel;Lvideo/biz/offline/base/model/model/ReserveInfo;Lvideo/biz/offline/list/logic/model/DialogType;)V", "getDownloading", "()Ljava/util/List;", "getCompleted", "getDataState", "()Lvideo/biz/offline/list/logic/model/DataState;", "getSelectionState", "()Lvideo/biz/offline/list/logic/model/SelectionState;", "getConfig", "()Lvideo/biz/offline/list/logic/model/OfflinePageConfig;", "getStorageInfo", "()Lvideo/biz/offline/base/model/model/StorageInfoModel;", "getReserveInfo", "()Lvideo/biz/offline/base/model/model/ReserveInfo;", "getDialogType", "()Lvideo/biz/offline/list/logic/model/DialogType;", "isEdit", "", "selected", "", "", "selectedCount", "", "getSelectedCount", "()I", "selectedCompletedTask", "key", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflinePageState {
    public static final int $stable = 8;
    private final List<OfflineCachedCardModel> completed;
    private final OfflinePageConfig config;
    private final DataState dataState;
    private final DialogType dialogType;
    private final List<OfflineDownloadingCardModel> downloading;
    private final ReserveInfo reserveInfo;
    private final SelectionState selectionState;
    private final StorageInfoModel storageInfo;

    public OfflinePageState() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public final List<OfflineDownloadingCardModel> component1() {
        return this.downloading;
    }

    public final List<OfflineCachedCardModel> component2() {
        return this.completed;
    }

    public final DataState component3() {
        return this.dataState;
    }

    public final SelectionState component4() {
        return this.selectionState;
    }

    public final OfflinePageConfig component5() {
        return this.config;
    }

    public final StorageInfoModel component6() {
        return this.storageInfo;
    }

    public final ReserveInfo component7() {
        return this.reserveInfo;
    }

    public final DialogType component8() {
        return this.dialogType;
    }

    public final OfflinePageState copy(List<OfflineDownloadingCardModel> list, List<OfflineCachedCardModel> list2, DataState dataState, SelectionState selectionState, OfflinePageConfig offlinePageConfig, StorageInfoModel storageInfoModel, ReserveInfo reserveInfo, DialogType dialogType) {
        Intrinsics.checkNotNullParameter(list, "downloading");
        Intrinsics.checkNotNullParameter(list2, "completed");
        Intrinsics.checkNotNullParameter(dataState, "dataState");
        Intrinsics.checkNotNullParameter(selectionState, "selectionState");
        Intrinsics.checkNotNullParameter(offlinePageConfig, "config");
        Intrinsics.checkNotNullParameter(dialogType, "dialogType");
        return new OfflinePageState(list, list2, dataState, selectionState, offlinePageConfig, storageInfoModel, reserveInfo, dialogType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OfflinePageState) {
            OfflinePageState offlinePageState = (OfflinePageState) obj;
            return Intrinsics.areEqual(this.downloading, offlinePageState.downloading) && Intrinsics.areEqual(this.completed, offlinePageState.completed) && this.dataState == offlinePageState.dataState && Intrinsics.areEqual(this.selectionState, offlinePageState.selectionState) && Intrinsics.areEqual(this.config, offlinePageState.config) && Intrinsics.areEqual(this.storageInfo, offlinePageState.storageInfo) && Intrinsics.areEqual(this.reserveInfo, offlinePageState.reserveInfo) && Intrinsics.areEqual(this.dialogType, offlinePageState.dialogType);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.downloading.hashCode() * 31) + this.completed.hashCode()) * 31) + this.dataState.hashCode()) * 31) + this.selectionState.hashCode()) * 31) + this.config.hashCode()) * 31) + (this.storageInfo == null ? 0 : this.storageInfo.hashCode())) * 31) + (this.reserveInfo != null ? this.reserveInfo.hashCode() : 0)) * 31) + this.dialogType.hashCode();
    }

    public String toString() {
        List<OfflineDownloadingCardModel> list = this.downloading;
        List<OfflineCachedCardModel> list2 = this.completed;
        DataState dataState = this.dataState;
        SelectionState selectionState = this.selectionState;
        OfflinePageConfig offlinePageConfig = this.config;
        StorageInfoModel storageInfoModel = this.storageInfo;
        ReserveInfo reserveInfo = this.reserveInfo;
        return "OfflinePageState(downloading=" + list + ", completed=" + list2 + ", dataState=" + dataState + ", selectionState=" + selectionState + ", config=" + offlinePageConfig + ", storageInfo=" + storageInfoModel + ", reserveInfo=" + reserveInfo + ", dialogType=" + this.dialogType + ")";
    }

    public OfflinePageState(List<OfflineDownloadingCardModel> list, List<OfflineCachedCardModel> list2, DataState dataState, SelectionState selectionState, OfflinePageConfig config, StorageInfoModel storageInfo, ReserveInfo reserveInfo, DialogType dialogType) {
        Intrinsics.checkNotNullParameter(list, "downloading");
        Intrinsics.checkNotNullParameter(list2, "completed");
        Intrinsics.checkNotNullParameter(dataState, "dataState");
        Intrinsics.checkNotNullParameter(selectionState, "selectionState");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dialogType, "dialogType");
        this.downloading = list;
        this.completed = list2;
        this.dataState = dataState;
        this.selectionState = selectionState;
        this.config = config;
        this.storageInfo = storageInfo;
        this.reserveInfo = reserveInfo;
        this.dialogType = dialogType;
    }

    public /* synthetic */ OfflinePageState(List list, List list2, DataState dataState, SelectionState selectionState, OfflinePageConfig offlinePageConfig, StorageInfoModel storageInfoModel, ReserveInfo reserveInfo, DialogType dialogType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? DataState.IDLE : dataState, (i & 8) != 0 ? SelectionState.Inactive.INSTANCE : selectionState, (i & 16) != 0 ? new OfflinePageConfig(null, null, 0, 7, null) : offlinePageConfig, (i & 32) != 0 ? null : storageInfoModel, (i & 64) == 0 ? reserveInfo : null, (i & 128) != 0 ? DialogType.None.INSTANCE : dialogType);
    }

    public final List<OfflineDownloadingCardModel> getDownloading() {
        return this.downloading;
    }

    public final List<OfflineCachedCardModel> getCompleted() {
        return this.completed;
    }

    public final DataState getDataState() {
        return this.dataState;
    }

    public final SelectionState getSelectionState() {
        return this.selectionState;
    }

    public final OfflinePageConfig getConfig() {
        return this.config;
    }

    public final StorageInfoModel getStorageInfo() {
        return this.storageInfo;
    }

    public final ReserveInfo getReserveInfo() {
        return this.reserveInfo;
    }

    public final DialogType getDialogType() {
        return this.dialogType;
    }

    public final boolean isEdit() {
        return this.selectionState instanceof SelectionState.Active;
    }

    public final Set<String> selected() {
        SelectionState state = this.selectionState;
        if (Intrinsics.areEqual(state, SelectionState.Inactive.INSTANCE)) {
            return SetsKt.emptySet();
        }
        if (state instanceof SelectionState.Active) {
            return ((SelectionState.Active) state).getSelectedIds();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int getSelectedCount() {
        SelectionState state = this.selectionState;
        if (Intrinsics.areEqual(state, SelectionState.Inactive.INSTANCE)) {
            return 0;
        }
        if (state instanceof SelectionState.Active) {
            return ((SelectionState.Active) state).getSelectedIds().size();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ List selectedCompletedTask$default(OfflinePageState offlinePageState, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return offlinePageState.selectedCompletedTask(str);
    }

    public final List<OfflineCachedCardModel> selectedCompletedTask(String key) {
        List selected;
        if (key == null) {
            selected = CollectionsKt.toList(selected());
        } else {
            selected = CollectionsKt.listOf(key);
        }
        Iterable $this$filter$iv = this.completed;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            OfflineCachedCardModel it = (OfflineCachedCardModel) element$iv$iv;
            if (selected.contains(it.getId())) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }
}