package kntr.app.tribee.search.event;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSearchEvent.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\u0082\u0001\b\n\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/search/event/TribeeSearchEvent;", "", "DoSearch", "ClearQueryText", "GotoFindPage", "RefreshHistory", "ShowClearHistoryDialog", "HideClearHistoryDialog", "ConfirmClearHistory", "LoadMore", "Lkntr/app/tribee/search/event/TribeeSearchEvent$ClearQueryText;", "Lkntr/app/tribee/search/event/TribeeSearchEvent$ConfirmClearHistory;", "Lkntr/app/tribee/search/event/TribeeSearchEvent$DoSearch;", "Lkntr/app/tribee/search/event/TribeeSearchEvent$GotoFindPage;", "Lkntr/app/tribee/search/event/TribeeSearchEvent$HideClearHistoryDialog;", "Lkntr/app/tribee/search/event/TribeeSearchEvent$LoadMore;", "Lkntr/app/tribee/search/event/TribeeSearchEvent$RefreshHistory;", "Lkntr/app/tribee/search/event/TribeeSearchEvent$ShowClearHistoryDialog;", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeSearchEvent {

    /* compiled from: TribeeSearchEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/search/event/TribeeSearchEvent$DoSearch;", "Lkntr/app/tribee/search/event/TribeeSearchEvent;", "keyword", "", "<init>", "(Ljava/lang/String;)V", "getKeyword", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DoSearch implements TribeeSearchEvent {
        public static final int $stable = 0;
        private final String keyword;

        public static /* synthetic */ DoSearch copy$default(DoSearch doSearch, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = doSearch.keyword;
            }
            return doSearch.copy(str);
        }

        public final String component1() {
            return this.keyword;
        }

        public final DoSearch copy(String str) {
            Intrinsics.checkNotNullParameter(str, "keyword");
            return new DoSearch(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DoSearch) && Intrinsics.areEqual(this.keyword, ((DoSearch) obj).keyword);
        }

        public int hashCode() {
            return this.keyword.hashCode();
        }

        public String toString() {
            return "DoSearch(keyword=" + this.keyword + ")";
        }

        public DoSearch(String keyword) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            this.keyword = keyword;
        }

        public final String getKeyword() {
            return this.keyword;
        }
    }

    /* compiled from: TribeeSearchEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/search/event/TribeeSearchEvent$ClearQueryText;", "Lkntr/app/tribee/search/event/TribeeSearchEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ClearQueryText implements TribeeSearchEvent {
        public static final int $stable = 0;
        public static final ClearQueryText INSTANCE = new ClearQueryText();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ClearQueryText) {
                ClearQueryText clearQueryText = (ClearQueryText) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1700086648;
        }

        public String toString() {
            return "ClearQueryText";
        }

        private ClearQueryText() {
        }
    }

    /* compiled from: TribeeSearchEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/search/event/TribeeSearchEvent$GotoFindPage;", "Lkntr/app/tribee/search/event/TribeeSearchEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class GotoFindPage implements TribeeSearchEvent {
        public static final int $stable = 0;
        public static final GotoFindPage INSTANCE = new GotoFindPage();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GotoFindPage) {
                GotoFindPage gotoFindPage = (GotoFindPage) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1323136101;
        }

        public String toString() {
            return "GotoFindPage";
        }

        private GotoFindPage() {
        }
    }

    /* compiled from: TribeeSearchEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/search/event/TribeeSearchEvent$RefreshHistory;", "Lkntr/app/tribee/search/event/TribeeSearchEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RefreshHistory implements TribeeSearchEvent {
        public static final int $stable = 0;
        public static final RefreshHistory INSTANCE = new RefreshHistory();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RefreshHistory) {
                RefreshHistory refreshHistory = (RefreshHistory) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -69799319;
        }

        public String toString() {
            return "RefreshHistory";
        }

        private RefreshHistory() {
        }
    }

    /* compiled from: TribeeSearchEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/search/event/TribeeSearchEvent$ShowClearHistoryDialog;", "Lkntr/app/tribee/search/event/TribeeSearchEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShowClearHistoryDialog implements TribeeSearchEvent {
        public static final int $stable = 0;
        public static final ShowClearHistoryDialog INSTANCE = new ShowClearHistoryDialog();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowClearHistoryDialog) {
                ShowClearHistoryDialog showClearHistoryDialog = (ShowClearHistoryDialog) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1466542916;
        }

        public String toString() {
            return "ShowClearHistoryDialog";
        }

        private ShowClearHistoryDialog() {
        }
    }

    /* compiled from: TribeeSearchEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/search/event/TribeeSearchEvent$HideClearHistoryDialog;", "Lkntr/app/tribee/search/event/TribeeSearchEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class HideClearHistoryDialog implements TribeeSearchEvent {
        public static final int $stable = 0;
        public static final HideClearHistoryDialog INSTANCE = new HideClearHistoryDialog();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HideClearHistoryDialog) {
                HideClearHistoryDialog hideClearHistoryDialog = (HideClearHistoryDialog) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -2088685631;
        }

        public String toString() {
            return "HideClearHistoryDialog";
        }

        private HideClearHistoryDialog() {
        }
    }

    /* compiled from: TribeeSearchEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/search/event/TribeeSearchEvent$ConfirmClearHistory;", "Lkntr/app/tribee/search/event/TribeeSearchEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ConfirmClearHistory implements TribeeSearchEvent {
        public static final int $stable = 0;
        public static final ConfirmClearHistory INSTANCE = new ConfirmClearHistory();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ConfirmClearHistory) {
                ConfirmClearHistory confirmClearHistory = (ConfirmClearHistory) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 325351735;
        }

        public String toString() {
            return "ConfirmClearHistory";
        }

        private ConfirmClearHistory() {
        }
    }

    /* compiled from: TribeeSearchEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/search/event/TribeeSearchEvent$LoadMore;", "Lkntr/app/tribee/search/event/TribeeSearchEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LoadMore implements TribeeSearchEvent {
        public static final int $stable = 0;
        public static final LoadMore INSTANCE = new LoadMore();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadMore) {
                LoadMore loadMore = (LoadMore) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1485432181;
        }

        public String toString() {
            return "LoadMore";
        }

        private LoadMore() {
        }
    }
}