package tv.danmaku.bili.ui.watchlater.data;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WLAction.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0011\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0082\u0001\u0011\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006$À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "", "LoadAction", "RefreshAction", "LoadCompleteAction", "SortAction", "LoadError", "RefreshError", "Loading", "Refreshing", "ChangeCardCheckState", "CheckAll", "CancelAll", "ChangeCheckState", "DeleteWatched", "DeleteInvalid", "DeleteChecked", "DeleteItem", "BatchOperation", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$BatchOperation;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$CancelAll;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$ChangeCardCheckState;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$ChangeCheckState;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$CheckAll;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$DeleteChecked;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$DeleteInvalid;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$DeleteItem;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$DeleteWatched;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$LoadAction;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$LoadCompleteAction;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$LoadError;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$Loading;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$RefreshAction;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$RefreshError;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$Refreshing;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction$SortAction;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface WLAction {

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$LoadAction;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "pageIndex", "", "isLoadMore", "", "<init>", "(IZ)V", "getPageIndex", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class LoadAction implements WLAction {
        public static final int $stable = 0;
        private final boolean isLoadMore;
        private final int pageIndex;

        public static /* synthetic */ LoadAction copy$default(LoadAction loadAction, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = loadAction.pageIndex;
            }
            if ((i2 & 2) != 0) {
                z = loadAction.isLoadMore;
            }
            return loadAction.copy(i, z);
        }

        public final int component1() {
            return this.pageIndex;
        }

        public final boolean component2() {
            return this.isLoadMore;
        }

        public final LoadAction copy(int i, boolean z) {
            return new LoadAction(i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadAction) {
                LoadAction loadAction = (LoadAction) obj;
                return this.pageIndex == loadAction.pageIndex && this.isLoadMore == loadAction.isLoadMore;
            }
            return false;
        }

        public int hashCode() {
            return (this.pageIndex * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoadMore);
        }

        public String toString() {
            int i = this.pageIndex;
            return "LoadAction(pageIndex=" + i + ", isLoadMore=" + this.isLoadMore + ")";
        }

        public LoadAction(int pageIndex, boolean isLoadMore) {
            this.pageIndex = pageIndex;
            this.isLoadMore = isLoadMore;
        }

        public /* synthetic */ LoadAction(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? false : z);
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final boolean isLoadMore() {
            return this.isLoadMore;
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$RefreshAction;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class RefreshAction implements WLAction {
        public static final int $stable = 0;
        private final int pageIndex;

        public static /* synthetic */ RefreshAction copy$default(RefreshAction refreshAction, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = refreshAction.pageIndex;
            }
            return refreshAction.copy(i);
        }

        public final int component1() {
            return this.pageIndex;
        }

        public final RefreshAction copy(int i) {
            return new RefreshAction(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RefreshAction) && this.pageIndex == ((RefreshAction) obj).pageIndex;
        }

        public int hashCode() {
            return this.pageIndex;
        }

        public String toString() {
            return "RefreshAction(pageIndex=" + this.pageIndex + ")";
        }

        public RefreshAction(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$LoadCompleteAction;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "response", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterResponse;", "pageIndex", "", "isLoadMore", "", "<init>", "(Ltv/danmaku/bili/ui/watchlater/data/WatchLaterResponse;IZ)V", "getResponse", "()Ltv/danmaku/bili/ui/watchlater/data/WatchLaterResponse;", "getPageIndex", "()I", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class LoadCompleteAction implements WLAction {
        public static final int $stable = 8;
        private final boolean isLoadMore;
        private final int pageIndex;
        private final WatchLaterResponse response;

        public static /* synthetic */ LoadCompleteAction copy$default(LoadCompleteAction loadCompleteAction, WatchLaterResponse watchLaterResponse, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                watchLaterResponse = loadCompleteAction.response;
            }
            if ((i2 & 2) != 0) {
                i = loadCompleteAction.pageIndex;
            }
            if ((i2 & 4) != 0) {
                z = loadCompleteAction.isLoadMore;
            }
            return loadCompleteAction.copy(watchLaterResponse, i, z);
        }

        public final WatchLaterResponse component1() {
            return this.response;
        }

        public final int component2() {
            return this.pageIndex;
        }

        public final boolean component3() {
            return this.isLoadMore;
        }

        public final LoadCompleteAction copy(WatchLaterResponse watchLaterResponse, int i, boolean z) {
            return new LoadCompleteAction(watchLaterResponse, i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadCompleteAction) {
                LoadCompleteAction loadCompleteAction = (LoadCompleteAction) obj;
                return Intrinsics.areEqual(this.response, loadCompleteAction.response) && this.pageIndex == loadCompleteAction.pageIndex && this.isLoadMore == loadCompleteAction.isLoadMore;
            }
            return false;
        }

        public int hashCode() {
            return ((((this.response == null ? 0 : this.response.hashCode()) * 31) + this.pageIndex) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoadMore);
        }

        public String toString() {
            WatchLaterResponse watchLaterResponse = this.response;
            int i = this.pageIndex;
            return "LoadCompleteAction(response=" + watchLaterResponse + ", pageIndex=" + i + ", isLoadMore=" + this.isLoadMore + ")";
        }

        public LoadCompleteAction(WatchLaterResponse response, int pageIndex, boolean isLoadMore) {
            this.response = response;
            this.pageIndex = pageIndex;
            this.isLoadMore = isLoadMore;
        }

        public final WatchLaterResponse getResponse() {
            return this.response;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final boolean isLoadMore() {
            return this.isLoadMore;
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$SortAction;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "<init>", "()V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SortAction implements WLAction {
        public static final int $stable = 0;
        public static final SortAction INSTANCE = new SortAction();

        private SortAction() {
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$LoadError;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "pageIndex", "", "isLoadMore", "", "networkActive", "<init>", "(IZZ)V", "getPageIndex", "()I", "()Z", "getNetworkActive", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class LoadError implements WLAction {
        public static final int $stable = 0;
        private final boolean isLoadMore;
        private final boolean networkActive;
        private final int pageIndex;

        public static /* synthetic */ LoadError copy$default(LoadError loadError, int i, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = loadError.pageIndex;
            }
            if ((i2 & 2) != 0) {
                z = loadError.isLoadMore;
            }
            if ((i2 & 4) != 0) {
                z2 = loadError.networkActive;
            }
            return loadError.copy(i, z, z2);
        }

        public final int component1() {
            return this.pageIndex;
        }

        public final boolean component2() {
            return this.isLoadMore;
        }

        public final boolean component3() {
            return this.networkActive;
        }

        public final LoadError copy(int i, boolean z, boolean z2) {
            return new LoadError(i, z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadError) {
                LoadError loadError = (LoadError) obj;
                return this.pageIndex == loadError.pageIndex && this.isLoadMore == loadError.isLoadMore && this.networkActive == loadError.networkActive;
            }
            return false;
        }

        public int hashCode() {
            return (((this.pageIndex * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoadMore)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.networkActive);
        }

        public String toString() {
            int i = this.pageIndex;
            boolean z = this.isLoadMore;
            return "LoadError(pageIndex=" + i + ", isLoadMore=" + z + ", networkActive=" + this.networkActive + ")";
        }

        public LoadError(int pageIndex, boolean isLoadMore, boolean networkActive) {
            this.pageIndex = pageIndex;
            this.isLoadMore = isLoadMore;
            this.networkActive = networkActive;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final boolean isLoadMore() {
            return this.isLoadMore;
        }

        public final boolean getNetworkActive() {
            return this.networkActive;
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$RefreshError;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class RefreshError implements WLAction {
        public static final int $stable = 0;
        private final int pageIndex;

        public static /* synthetic */ RefreshError copy$default(RefreshError refreshError, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = refreshError.pageIndex;
            }
            return refreshError.copy(i);
        }

        public final int component1() {
            return this.pageIndex;
        }

        public final RefreshError copy(int i) {
            return new RefreshError(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RefreshError) && this.pageIndex == ((RefreshError) obj).pageIndex;
        }

        public int hashCode() {
            return this.pageIndex;
        }

        public String toString() {
            return "RefreshError(pageIndex=" + this.pageIndex + ")";
        }

        public RefreshError(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$Loading;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "pageIndex", "", "isLoadMore", "", "<init>", "(IZ)V", "getPageIndex", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Loading implements WLAction {
        public static final int $stable = 0;
        private final boolean isLoadMore;
        private final int pageIndex;

        public static /* synthetic */ Loading copy$default(Loading loading, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = loading.pageIndex;
            }
            if ((i2 & 2) != 0) {
                z = loading.isLoadMore;
            }
            return loading.copy(i, z);
        }

        public final int component1() {
            return this.pageIndex;
        }

        public final boolean component2() {
            return this.isLoadMore;
        }

        public final Loading copy(int i, boolean z) {
            return new Loading(i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Loading) {
                Loading loading = (Loading) obj;
                return this.pageIndex == loading.pageIndex && this.isLoadMore == loading.isLoadMore;
            }
            return false;
        }

        public int hashCode() {
            return (this.pageIndex * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoadMore);
        }

        public String toString() {
            int i = this.pageIndex;
            return "Loading(pageIndex=" + i + ", isLoadMore=" + this.isLoadMore + ")";
        }

        public Loading(int pageIndex, boolean isLoadMore) {
            this.pageIndex = pageIndex;
            this.isLoadMore = isLoadMore;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final boolean isLoadMore() {
            return this.isLoadMore;
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$Refreshing;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Refreshing implements WLAction {
        public static final int $stable = 0;
        private final int pageIndex;

        public static /* synthetic */ Refreshing copy$default(Refreshing refreshing, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = refreshing.pageIndex;
            }
            return refreshing.copy(i);
        }

        public final int component1() {
            return this.pageIndex;
        }

        public final Refreshing copy(int i) {
            return new Refreshing(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Refreshing) && this.pageIndex == ((Refreshing) obj).pageIndex;
        }

        public int hashCode() {
            return this.pageIndex;
        }

        public String toString() {
            return "Refreshing(pageIndex=" + this.pageIndex + ")";
        }

        public Refreshing(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$ChangeCardCheckState;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "pageIndex", "", "itemId", "", "<init>", "(ILjava/lang/String;)V", "getPageIndex", "()I", "getItemId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ChangeCardCheckState implements WLAction {
        public static final int $stable = 0;
        private final String itemId;
        private final int pageIndex;

        public static /* synthetic */ ChangeCardCheckState copy$default(ChangeCardCheckState changeCardCheckState, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = changeCardCheckState.pageIndex;
            }
            if ((i2 & 2) != 0) {
                str = changeCardCheckState.itemId;
            }
            return changeCardCheckState.copy(i, str);
        }

        public final int component1() {
            return this.pageIndex;
        }

        public final String component2() {
            return this.itemId;
        }

        public final ChangeCardCheckState copy(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            return new ChangeCardCheckState(i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ChangeCardCheckState) {
                ChangeCardCheckState changeCardCheckState = (ChangeCardCheckState) obj;
                return this.pageIndex == changeCardCheckState.pageIndex && Intrinsics.areEqual(this.itemId, changeCardCheckState.itemId);
            }
            return false;
        }

        public int hashCode() {
            return (this.pageIndex * 31) + this.itemId.hashCode();
        }

        public String toString() {
            int i = this.pageIndex;
            return "ChangeCardCheckState(pageIndex=" + i + ", itemId=" + this.itemId + ")";
        }

        public ChangeCardCheckState(int pageIndex, String itemId) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            this.pageIndex = pageIndex;
            this.itemId = itemId;
        }

        public final String getItemId() {
            return this.itemId;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$CheckAll;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CheckAll implements WLAction {
        public static final int $stable = 0;
        private final int pageIndex;

        public static /* synthetic */ CheckAll copy$default(CheckAll checkAll, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = checkAll.pageIndex;
            }
            return checkAll.copy(i);
        }

        public final int component1() {
            return this.pageIndex;
        }

        public final CheckAll copy(int i) {
            return new CheckAll(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CheckAll) && this.pageIndex == ((CheckAll) obj).pageIndex;
        }

        public int hashCode() {
            return this.pageIndex;
        }

        public String toString() {
            return "CheckAll(pageIndex=" + this.pageIndex + ")";
        }

        public CheckAll(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$CancelAll;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CancelAll implements WLAction {
        public static final int $stable = 0;
        private final int pageIndex;

        public static /* synthetic */ CancelAll copy$default(CancelAll cancelAll, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = cancelAll.pageIndex;
            }
            return cancelAll.copy(i);
        }

        public final int component1() {
            return this.pageIndex;
        }

        public final CancelAll copy(int i) {
            return new CancelAll(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CancelAll) && this.pageIndex == ((CancelAll) obj).pageIndex;
        }

        public int hashCode() {
            return this.pageIndex;
        }

        public String toString() {
            return "CancelAll(pageIndex=" + this.pageIndex + ")";
        }

        public CancelAll(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$ChangeCheckState;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "<init>", "()V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ChangeCheckState implements WLAction {
        public static final int $stable = 0;
        public static final ChangeCheckState INSTANCE = new ChangeCheckState();

        private ChangeCheckState() {
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$DeleteWatched;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "<init>", "()V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DeleteWatched implements WLAction {
        public static final int $stable = 0;
        public static final DeleteWatched INSTANCE = new DeleteWatched();

        private DeleteWatched() {
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$DeleteInvalid;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "<init>", "()V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DeleteInvalid implements WLAction {
        public static final int $stable = 0;
        public static final DeleteInvalid INSTANCE = new DeleteInvalid();

        private DeleteInvalid() {
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$DeleteChecked;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "realDelete", "", "<init>", "(Z)V", "getRealDelete", "()Z", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DeleteChecked implements WLAction {
        public static final int $stable = 0;
        private final boolean realDelete;

        public DeleteChecked(boolean realDelete) {
            this.realDelete = realDelete;
        }

        public final boolean getRealDelete() {
            return this.realDelete;
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$DeleteItem;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "aid", "", "<init>", "(J)V", "getAid", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DeleteItem implements WLAction {
        public static final int $stable = 0;
        private final long aid;

        public static /* synthetic */ DeleteItem copy$default(DeleteItem deleteItem, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = deleteItem.aid;
            }
            return deleteItem.copy(j);
        }

        public final long component1() {
            return this.aid;
        }

        public final DeleteItem copy(long j) {
            return new DeleteItem(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeleteItem) && this.aid == ((DeleteItem) obj).aid;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.aid);
        }

        public String toString() {
            return "DeleteItem(aid=" + this.aid + ")";
        }

        public DeleteItem(long aid) {
            this.aid = aid;
        }

        public final long getAid() {
            return this.aid;
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLAction$BatchOperation;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "opType", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "<init>", "(ILandroidx/fragment/app/FragmentManager;)V", "getOpType", "()I", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class BatchOperation implements WLAction {
        public static final int $stable = 8;
        private final FragmentManager fragmentManager;
        private final int opType;

        public static /* synthetic */ BatchOperation copy$default(BatchOperation batchOperation, int i, FragmentManager fragmentManager, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = batchOperation.opType;
            }
            if ((i2 & 2) != 0) {
                fragmentManager = batchOperation.fragmentManager;
            }
            return batchOperation.copy(i, fragmentManager);
        }

        public final int component1() {
            return this.opType;
        }

        public final FragmentManager component2() {
            return this.fragmentManager;
        }

        public final BatchOperation copy(int i, FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            return new BatchOperation(i, fragmentManager);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BatchOperation) {
                BatchOperation batchOperation = (BatchOperation) obj;
                return this.opType == batchOperation.opType && Intrinsics.areEqual(this.fragmentManager, batchOperation.fragmentManager);
            }
            return false;
        }

        public int hashCode() {
            return (this.opType * 31) + this.fragmentManager.hashCode();
        }

        public String toString() {
            int i = this.opType;
            return "BatchOperation(opType=" + i + ", fragmentManager=" + this.fragmentManager + ")";
        }

        public BatchOperation(int opType, FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            this.opType = opType;
            this.fragmentManager = fragmentManager;
        }

        public final int getOpType() {
            return this.opType;
        }

        public final FragmentManager getFragmentManager() {
            return this.fragmentManager;
        }
    }
}