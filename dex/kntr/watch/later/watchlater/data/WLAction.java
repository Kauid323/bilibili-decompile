package kntr.watch.later.watchlater.data;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WLAction.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0010\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0082\u0001\u0010\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !¨\u0006\"À\u0006\u0003"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction;", "", "LoadAction", "RefreshAction", "LoadCompleteAction", "SortAction", "LoadError", "RefreshError", "Loading", "Refreshing", "ChangeCardCheckState", "CheckAll", "CancelAll", "ChangeCheckState", "DeleteWatched", "DeleteInvalid", "DeleteChecked", "DeleteItem", "Lkntr/watch/later/watchlater/data/WLAction$CancelAll;", "Lkntr/watch/later/watchlater/data/WLAction$ChangeCardCheckState;", "Lkntr/watch/later/watchlater/data/WLAction$ChangeCheckState;", "Lkntr/watch/later/watchlater/data/WLAction$CheckAll;", "Lkntr/watch/later/watchlater/data/WLAction$DeleteChecked;", "Lkntr/watch/later/watchlater/data/WLAction$DeleteInvalid;", "Lkntr/watch/later/watchlater/data/WLAction$DeleteItem;", "Lkntr/watch/later/watchlater/data/WLAction$DeleteWatched;", "Lkntr/watch/later/watchlater/data/WLAction$LoadAction;", "Lkntr/watch/later/watchlater/data/WLAction$LoadCompleteAction;", "Lkntr/watch/later/watchlater/data/WLAction$LoadError;", "Lkntr/watch/later/watchlater/data/WLAction$Loading;", "Lkntr/watch/later/watchlater/data/WLAction$RefreshAction;", "Lkntr/watch/later/watchlater/data/WLAction$RefreshError;", "Lkntr/watch/later/watchlater/data/WLAction$Refreshing;", "Lkntr/watch/later/watchlater/data/WLAction$SortAction;", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface WLAction {

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$LoadAction;", "Lkntr/watch/later/watchlater/data/WLAction;", "pageIndex", "", "isLoadMore", "", "<init>", "(IZ)V", "getPageIndex", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
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
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$RefreshAction;", "Lkntr/watch/later/watchlater/data/WLAction;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
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
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0019"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$LoadCompleteAction;", "Lkntr/watch/later/watchlater/data/WLAction;", "response", "Lkntr/watch/later/watchlater/data/WatchLaterResponse;", "pageIndex", "", "isLoadMore", "", "<init>", "(Lkntr/watch/later/watchlater/data/WatchLaterResponse;IZ)V", "getResponse", "()Lkntr/watch/later/watchlater/data/WatchLaterResponse;", "getPageIndex", "()I", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
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
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$SortAction;", "Lkntr/watch/later/watchlater/data/WLAction;", "<init>", "()V", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SortAction implements WLAction {
        public static final int $stable = 0;
        public static final SortAction INSTANCE = new SortAction();

        private SortAction() {
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$LoadError;", "Lkntr/watch/later/watchlater/data/WLAction;", "pageIndex", "", "isLoadMore", "", "<init>", "(IZ)V", "getPageIndex", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LoadError implements WLAction {
        public static final int $stable = 0;
        private final boolean isLoadMore;
        private final int pageIndex;

        public static /* synthetic */ LoadError copy$default(LoadError loadError, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = loadError.pageIndex;
            }
            if ((i2 & 2) != 0) {
                z = loadError.isLoadMore;
            }
            return loadError.copy(i, z);
        }

        public final int component1() {
            return this.pageIndex;
        }

        public final boolean component2() {
            return this.isLoadMore;
        }

        public final LoadError copy(int i, boolean z) {
            return new LoadError(i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadError) {
                LoadError loadError = (LoadError) obj;
                return this.pageIndex == loadError.pageIndex && this.isLoadMore == loadError.isLoadMore;
            }
            return false;
        }

        public int hashCode() {
            return (this.pageIndex * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoadMore);
        }

        public String toString() {
            int i = this.pageIndex;
            return "LoadError(pageIndex=" + i + ", isLoadMore=" + this.isLoadMore + ")";
        }

        public LoadError(int pageIndex, boolean isLoadMore) {
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
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$RefreshError;", "Lkntr/watch/later/watchlater/data/WLAction;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
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
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$Loading;", "Lkntr/watch/later/watchlater/data/WLAction;", "pageIndex", "", "isLoadMore", "", "<init>", "(IZ)V", "getPageIndex", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
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
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$Refreshing;", "Lkntr/watch/later/watchlater/data/WLAction;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
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
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$ChangeCardCheckState;", "Lkntr/watch/later/watchlater/data/WLAction;", "pageIndex", "", "itemId", "", "<init>", "(ILjava/lang/String;)V", "getPageIndex", "()I", "getItemId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
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

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final String getItemId() {
            return this.itemId;
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$CheckAll;", "Lkntr/watch/later/watchlater/data/WLAction;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
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
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$CancelAll;", "Lkntr/watch/later/watchlater/data/WLAction;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
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
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$ChangeCheckState;", "Lkntr/watch/later/watchlater/data/WLAction;", "<init>", "()V", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ChangeCheckState implements WLAction {
        public static final int $stable = 0;
        public static final ChangeCheckState INSTANCE = new ChangeCheckState();

        private ChangeCheckState() {
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$DeleteWatched;", "Lkntr/watch/later/watchlater/data/WLAction;", "<init>", "()V", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DeleteWatched implements WLAction {
        public static final int $stable = 0;
        public static final DeleteWatched INSTANCE = new DeleteWatched();

        private DeleteWatched() {
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$DeleteInvalid;", "Lkntr/watch/later/watchlater/data/WLAction;", "<init>", "()V", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DeleteInvalid implements WLAction {
        public static final int $stable = 0;
        public static final DeleteInvalid INSTANCE = new DeleteInvalid();

        private DeleteInvalid() {
        }
    }

    /* compiled from: WLAction.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$DeleteChecked;", "Lkntr/watch/later/watchlater/data/WLAction;", "realDelete", "", "<init>", "(Z)V", "getRealDelete", "()Z", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/watch/later/watchlater/data/WLAction$DeleteItem;", "Lkntr/watch/later/watchlater/data/WLAction;", "aid", "", "<init>", "(J)V", "getAid", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
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
}