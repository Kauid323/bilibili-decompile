package video.biz.offline.list.logic.statemachine;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.model.OfflineCachedCardModel;
import video.biz.offline.list.logic.utils.VipFromType;

/* compiled from: OfflineListAction.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0013\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0082\u0001\u001e\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./012¨\u00063À\u0006\u0003"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "", "LoadData", "UpdateHistoryProgress", "GetStorageInfo", "ItemClick", "ItemLongClick", "Search", "Delete", "DeleteConfirmed", "UpdateDanmaku", "EnterEditMode", "ExitEditMode", "ClickSelectAll", "ShowLoading", "DismissLoading", "DismissDialog", "VipPurchase", "ClickToDetail", "ShowBandWidthAlert", "Jump2BandWidth", "Lvideo/biz/offline/list/logic/statemachine/ClickContinuousPlay;", "Lvideo/biz/offline/list/logic/statemachine/ClickDownloading;", "Lvideo/biz/offline/list/logic/statemachine/ClickReserve;", "Lvideo/biz/offline/list/logic/statemachine/ClickSearch;", "Lvideo/biz/offline/list/logic/statemachine/ClickSetting;", "Lvideo/biz/offline/list/logic/statemachine/ItemCoverClick;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ClickSelectAll;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ClickToDetail;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$Delete;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$DeleteConfirmed;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$DismissDialog;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$DismissLoading;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$EnterEditMode;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ExitEditMode;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$GetStorageInfo;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemClick;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemLongClick;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$Jump2BandWidth;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$LoadData;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$Search;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ShowBandWidthAlert;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ShowLoading;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$UpdateDanmaku;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$UpdateHistoryProgress;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$VipPurchase;", "Lvideo/biz/offline/list/logic/statemachine/SetConcurrentCount;", "Lvideo/biz/offline/list/logic/statemachine/ShowConcurrentSheet;", "Lvideo/biz/offline/list/logic/statemachine/StartAll;", "Lvideo/biz/offline/list/logic/statemachine/StartAuthentication;", "Lvideo/biz/offline/list/logic/statemachine/StopAll;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OfflineListAction {

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$LoadData;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class LoadData implements OfflineListAction {
        public static final int $stable = 0;
        public static final LoadData INSTANCE = new LoadData();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadData) {
                LoadData loadData = (LoadData) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1541916984;
        }

        public String toString() {
            return "LoadData";
        }

        private LoadData() {
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$UpdateHistoryProgress;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "completed", "", "Lvideo/biz/offline/list/logic/model/OfflineCachedCardModel;", "<init>", "(Ljava/util/List;)V", "getCompleted", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class UpdateHistoryProgress implements OfflineListAction {
        public static final int $stable = 8;
        private final List<OfflineCachedCardModel> completed;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UpdateHistoryProgress copy$default(UpdateHistoryProgress updateHistoryProgress, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = updateHistoryProgress.completed;
            }
            return updateHistoryProgress.copy(list);
        }

        public final List<OfflineCachedCardModel> component1() {
            return this.completed;
        }

        public final UpdateHistoryProgress copy(List<OfflineCachedCardModel> list) {
            Intrinsics.checkNotNullParameter(list, "completed");
            return new UpdateHistoryProgress(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateHistoryProgress) && Intrinsics.areEqual(this.completed, ((UpdateHistoryProgress) obj).completed);
        }

        public int hashCode() {
            return this.completed.hashCode();
        }

        public String toString() {
            return "UpdateHistoryProgress(completed=" + this.completed + ")";
        }

        public UpdateHistoryProgress(List<OfflineCachedCardModel> list) {
            Intrinsics.checkNotNullParameter(list, "completed");
            this.completed = list;
        }

        public final List<OfflineCachedCardModel> getCompleted() {
            return this.completed;
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$GetStorageInfo;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class GetStorageInfo implements OfflineListAction {
        public static final int $stable = 0;
        public static final GetStorageInfo INSTANCE = new GetStorageInfo();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GetStorageInfo) {
                GetStorageInfo getStorageInfo = (GetStorageInfo) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1387501029;
        }

        public String toString() {
            return "GetStorageInfo";
        }

        private GetStorageInfo() {
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemClick;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "key", "", "<init>", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ItemClick implements OfflineListAction {
        public static final int $stable = 0;
        private final String key;

        public static /* synthetic */ ItemClick copy$default(ItemClick itemClick, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemClick.key;
            }
            return itemClick.copy(str);
        }

        public final String component1() {
            return this.key;
        }

        public final ItemClick copy(String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            return new ItemClick(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ItemClick) && Intrinsics.areEqual(this.key, ((ItemClick) obj).key);
        }

        public int hashCode() {
            return this.key.hashCode();
        }

        public String toString() {
            return "ItemClick(key=" + this.key + ")";
        }

        public ItemClick(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
        }

        public final String getKey() {
            return this.key;
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemLongClick;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "key", "", "<init>", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ItemLongClick implements OfflineListAction {
        public static final int $stable = 0;
        private final String key;

        public static /* synthetic */ ItemLongClick copy$default(ItemLongClick itemLongClick, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemLongClick.key;
            }
            return itemLongClick.copy(str);
        }

        public final String component1() {
            return this.key;
        }

        public final ItemLongClick copy(String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            return new ItemLongClick(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ItemLongClick) && Intrinsics.areEqual(this.key, ((ItemLongClick) obj).key);
        }

        public int hashCode() {
            return this.key.hashCode();
        }

        public String toString() {
            return "ItemLongClick(key=" + this.key + ")";
        }

        public ItemLongClick(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
        }

        public final String getKey() {
            return this.key;
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$Search;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", ChronosDanmakuSender.KEY_MARK_DANMAKU, "", "<init>", "(Ljava/lang/String;)V", "getKeyword", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Search implements OfflineListAction {
        public static final int $stable = 0;
        private final String keyword;

        public static /* synthetic */ Search copy$default(Search search, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = search.keyword;
            }
            return search.copy(str);
        }

        public final String component1() {
            return this.keyword;
        }

        public final Search copy(String str) {
            Intrinsics.checkNotNullParameter(str, ChronosDanmakuSender.KEY_MARK_DANMAKU);
            return new Search(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Search) && Intrinsics.areEqual(this.keyword, ((Search) obj).keyword);
        }

        public int hashCode() {
            return this.keyword.hashCode();
        }

        public String toString() {
            return "Search(keyword=" + this.keyword + ")";
        }

        public Search(String keyword) {
            Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
            this.keyword = keyword;
        }

        public final String getKeyword() {
            return this.keyword;
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$Delete;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "key", "", "<init>", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Delete implements OfflineListAction {
        public static final int $stable = 0;
        private final String key;

        public Delete() {
            this(null, 1, null);
        }

        public static /* synthetic */ Delete copy$default(Delete delete, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = delete.key;
            }
            return delete.copy(str);
        }

        public final String component1() {
            return this.key;
        }

        public final Delete copy(String str) {
            return new Delete(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Delete) && Intrinsics.areEqual(this.key, ((Delete) obj).key);
        }

        public int hashCode() {
            if (this.key == null) {
                return 0;
            }
            return this.key.hashCode();
        }

        public String toString() {
            return "Delete(key=" + this.key + ")";
        }

        public Delete(String key) {
            this.key = key;
        }

        public /* synthetic */ Delete(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getKey() {
            return this.key;
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$DeleteConfirmed;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "keys", "", "", "<init>", "(Ljava/util/List;)V", "getKeys", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DeleteConfirmed implements OfflineListAction {
        public static final int $stable = 8;
        private final List<String> keys;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DeleteConfirmed copy$default(DeleteConfirmed deleteConfirmed, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = deleteConfirmed.keys;
            }
            return deleteConfirmed.copy(list);
        }

        public final List<String> component1() {
            return this.keys;
        }

        public final DeleteConfirmed copy(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "keys");
            return new DeleteConfirmed(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeleteConfirmed) && Intrinsics.areEqual(this.keys, ((DeleteConfirmed) obj).keys);
        }

        public int hashCode() {
            return this.keys.hashCode();
        }

        public String toString() {
            return "DeleteConfirmed(keys=" + this.keys + ")";
        }

        public DeleteConfirmed(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "keys");
            this.keys = list;
        }

        public final List<String> getKeys() {
            return this.keys;
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$UpdateDanmaku;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "key", "", "<init>", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class UpdateDanmaku implements OfflineListAction {
        public static final int $stable = 0;
        private final String key;

        public UpdateDanmaku() {
            this(null, 1, null);
        }

        public static /* synthetic */ UpdateDanmaku copy$default(UpdateDanmaku updateDanmaku, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateDanmaku.key;
            }
            return updateDanmaku.copy(str);
        }

        public final String component1() {
            return this.key;
        }

        public final UpdateDanmaku copy(String str) {
            return new UpdateDanmaku(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateDanmaku) && Intrinsics.areEqual(this.key, ((UpdateDanmaku) obj).key);
        }

        public int hashCode() {
            if (this.key == null) {
                return 0;
            }
            return this.key.hashCode();
        }

        public String toString() {
            return "UpdateDanmaku(key=" + this.key + ")";
        }

        public UpdateDanmaku(String key) {
            this.key = key;
        }

        public /* synthetic */ UpdateDanmaku(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getKey() {
            return this.key;
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$EnterEditMode;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class EnterEditMode implements OfflineListAction {
        public static final int $stable = 0;
        public static final EnterEditMode INSTANCE = new EnterEditMode();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EnterEditMode) {
                EnterEditMode enterEditMode = (EnterEditMode) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -611415235;
        }

        public String toString() {
            return "EnterEditMode";
        }

        private EnterEditMode() {
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ExitEditMode;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ExitEditMode implements OfflineListAction {
        public static final int $stable = 0;
        public static final ExitEditMode INSTANCE = new ExitEditMode();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ExitEditMode) {
                ExitEditMode exitEditMode = (ExitEditMode) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 95462803;
        }

        public String toString() {
            return "ExitEditMode";
        }

        private ExitEditMode() {
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ClickSelectAll;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ClickSelectAll implements OfflineListAction {
        public static final int $stable = 0;
        public static final ClickSelectAll INSTANCE = new ClickSelectAll();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ClickSelectAll) {
                ClickSelectAll clickSelectAll = (ClickSelectAll) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -754668571;
        }

        public String toString() {
            return "ClickSelectAll";
        }

        private ClickSelectAll() {
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ShowLoading;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowLoading implements OfflineListAction {
        public static final int $stable = 0;
        public static final ShowLoading INSTANCE = new ShowLoading();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowLoading) {
                ShowLoading showLoading = (ShowLoading) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 368125687;
        }

        public String toString() {
            return "ShowLoading";
        }

        private ShowLoading() {
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$DismissLoading;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DismissLoading implements OfflineListAction {
        public static final int $stable = 0;
        public static final DismissLoading INSTANCE = new DismissLoading();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DismissLoading) {
                DismissLoading dismissLoading = (DismissLoading) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -911575846;
        }

        public String toString() {
            return "DismissLoading";
        }

        private DismissLoading() {
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$DismissDialog;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DismissDialog implements OfflineListAction {
        public static final int $stable = 0;
        public static final DismissDialog INSTANCE = new DismissDialog();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DismissDialog) {
                DismissDialog dismissDialog = (DismissDialog) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 567311850;
        }

        public String toString() {
            return "DismissDialog";
        }

        private DismissDialog() {
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$VipPurchase;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "type", "Lvideo/biz/offline/list/logic/utils/VipFromType;", "<init>", "(Lvideo/biz/offline/list/logic/utils/VipFromType;)V", "getType", "()Lvideo/biz/offline/list/logic/utils/VipFromType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VipPurchase implements OfflineListAction {
        public static final int $stable = 0;
        private final VipFromType type;

        public static /* synthetic */ VipPurchase copy$default(VipPurchase vipPurchase, VipFromType vipFromType, int i, Object obj) {
            if ((i & 1) != 0) {
                vipFromType = vipPurchase.type;
            }
            return vipPurchase.copy(vipFromType);
        }

        public final VipFromType component1() {
            return this.type;
        }

        public final VipPurchase copy(VipFromType vipFromType) {
            Intrinsics.checkNotNullParameter(vipFromType, "type");
            return new VipPurchase(vipFromType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VipPurchase) && this.type == ((VipPurchase) obj).type;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "VipPurchase(type=" + this.type + ")";
        }

        public VipPurchase(VipFromType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public final VipFromType getType() {
            return this.type;
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ClickToDetail;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "aid", "", "<init>", "(J)V", "getAid", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ClickToDetail implements OfflineListAction {
        public static final int $stable = 0;
        private final long aid;

        public static /* synthetic */ ClickToDetail copy$default(ClickToDetail clickToDetail, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = clickToDetail.aid;
            }
            return clickToDetail.copy(j);
        }

        public final long component1() {
            return this.aid;
        }

        public final ClickToDetail copy(long j) {
            return new ClickToDetail(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClickToDetail) && this.aid == ((ClickToDetail) obj).aid;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.aid);
        }

        public String toString() {
            return "ClickToDetail(aid=" + this.aid + ")";
        }

        public ClickToDetail(long aid) {
            this.aid = aid;
        }

        public final long getAid() {
            return this.aid;
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ShowBandWidthAlert;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "action", "Lkotlin/Function0;", "", "hasFreeBandwidthError", "", "<init>", "(Lkotlin/jvm/functions/Function0;Z)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "getHasFreeBandwidthError", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowBandWidthAlert implements OfflineListAction {
        public static final int $stable = 0;
        private final Function0<Unit> action;
        private final boolean hasFreeBandwidthError;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ShowBandWidthAlert copy$default(ShowBandWidthAlert showBandWidthAlert, Function0 function0, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                function0 = showBandWidthAlert.action;
            }
            if ((i & 2) != 0) {
                z = showBandWidthAlert.hasFreeBandwidthError;
            }
            return showBandWidthAlert.copy(function0, z);
        }

        public final Function0<Unit> component1() {
            return this.action;
        }

        public final boolean component2() {
            return this.hasFreeBandwidthError;
        }

        public final ShowBandWidthAlert copy(Function0<Unit> function0, boolean z) {
            Intrinsics.checkNotNullParameter(function0, "action");
            return new ShowBandWidthAlert(function0, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowBandWidthAlert) {
                ShowBandWidthAlert showBandWidthAlert = (ShowBandWidthAlert) obj;
                return Intrinsics.areEqual(this.action, showBandWidthAlert.action) && this.hasFreeBandwidthError == showBandWidthAlert.hasFreeBandwidthError;
            }
            return false;
        }

        public int hashCode() {
            return (this.action.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasFreeBandwidthError);
        }

        public String toString() {
            Function0<Unit> function0 = this.action;
            return "ShowBandWidthAlert(action=" + function0 + ", hasFreeBandwidthError=" + this.hasFreeBandwidthError + ")";
        }

        public ShowBandWidthAlert(Function0<Unit> function0, boolean hasFreeBandwidthError) {
            Intrinsics.checkNotNullParameter(function0, "action");
            this.action = function0;
            this.hasFreeBandwidthError = hasFreeBandwidthError;
        }

        public /* synthetic */ ShowBandWidthAlert(Function0 function0, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function0, (i & 2) != 0 ? false : z);
        }

        public final Function0<Unit> getAction() {
            return this.action;
        }

        public final boolean getHasFreeBandwidthError() {
            return this.hasFreeBandwidthError;
        }
    }

    /* compiled from: OfflineListAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$Jump2BandWidth;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Jump2BandWidth implements OfflineListAction {
        public static final int $stable = 0;
        public static final Jump2BandWidth INSTANCE = new Jump2BandWidth();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Jump2BandWidth) {
                Jump2BandWidth jump2BandWidth = (Jump2BandWidth) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1676420939;
        }

        public String toString() {
            return "Jump2BandWidth";
        }

        private Jump2BandWidth() {
        }
    }
}