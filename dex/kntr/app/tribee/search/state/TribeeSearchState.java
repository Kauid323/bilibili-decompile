package kntr.app.tribee.search.state;

import BottomSheetItemData$;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.ui.text.TextRangeKt;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchCard;
import com.bapis.bilibili.pagination.KPaginationReply;
import java.util.List;
import kntr.app.tribee.search.base.TribeeSearchStore;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSearchPageState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00102\u00020\u0001:\u0003\u000e\u000f\u0010B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\u0082\u0001\u0002\u0011\u0012¨\u0006\u0013"}, d2 = {"Lkntr/app/tribee/search/state/TribeeSearchState;", "", "<init>", "()V", "searchBarState", "Lkntr/app/tribee/search/state/SearchBarState;", "getSearchBarState", "()Lkntr/app/tribee/search/state/SearchBarState;", "globalSearchUri", "", "getGlobalSearchUri", "()Ljava/lang/String;", "tribeeId", "getTribeeId", "Find", "Result", "Companion", "Lkntr/app/tribee/search/state/TribeeSearchState$Find;", "Lkntr/app/tribee/search/state/TribeeSearchState$Result;", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class TribeeSearchState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    public /* synthetic */ TribeeSearchState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getGlobalSearchUri();

    public abstract SearchBarState getSearchBarState();

    public abstract String getTribeeId();

    private TribeeSearchState() {
    }

    /* compiled from: TribeeSearchPageState.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013¨\u0006$"}, d2 = {"Lkntr/app/tribee/search/state/TribeeSearchState$Find;", "Lkntr/app/tribee/search/state/TribeeSearchState;", "searchBarState", "Lkntr/app/tribee/search/state/SearchBarState;", "globalSearchUri", "", "tribeeId", "isEnableHistory", "", "isShowClearDialog", "searchHistory", "", "<init>", "(Lkntr/app/tribee/search/state/SearchBarState;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;)V", "getSearchBarState", "()Lkntr/app/tribee/search/state/SearchBarState;", "getGlobalSearchUri", "()Ljava/lang/String;", "getTribeeId", "()Z", "getSearchHistory", "()Ljava/util/List;", "isShowHistory", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Find extends TribeeSearchState {
        public static final int $stable = 8;
        private final String globalSearchUri;
        private final boolean isEnableHistory;
        private final boolean isShowClearDialog;
        private final SearchBarState searchBarState;
        private final List<String> searchHistory;
        private final String tribeeId;

        public static /* synthetic */ Find copy$default(Find find, SearchBarState searchBarState, String str, String str2, boolean z, boolean z2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                searchBarState = find.searchBarState;
            }
            if ((i & 2) != 0) {
                str = find.globalSearchUri;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = find.tribeeId;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                z = find.isEnableHistory;
            }
            boolean z3 = z;
            if ((i & 16) != 0) {
                z2 = find.isShowClearDialog;
            }
            boolean z4 = z2;
            List<String> list2 = list;
            if ((i & 32) != 0) {
                list2 = find.searchHistory;
            }
            return find.copy(searchBarState, str3, str4, z3, z4, list2);
        }

        public final SearchBarState component1() {
            return this.searchBarState;
        }

        public final String component2() {
            return this.globalSearchUri;
        }

        public final String component3() {
            return this.tribeeId;
        }

        public final boolean component4() {
            return this.isEnableHistory;
        }

        public final boolean component5() {
            return this.isShowClearDialog;
        }

        public final List<String> component6() {
            return this.searchHistory;
        }

        public final Find copy(SearchBarState searchBarState, String str, String str2, boolean z, boolean z2, List<String> list) {
            Intrinsics.checkNotNullParameter(searchBarState, "searchBarState");
            Intrinsics.checkNotNullParameter(str, "globalSearchUri");
            Intrinsics.checkNotNullParameter(str2, "tribeeId");
            Intrinsics.checkNotNullParameter(list, "searchHistory");
            return new Find(searchBarState, str, str2, z, z2, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Find) {
                Find find = (Find) obj;
                return Intrinsics.areEqual(this.searchBarState, find.searchBarState) && Intrinsics.areEqual(this.globalSearchUri, find.globalSearchUri) && Intrinsics.areEqual(this.tribeeId, find.tribeeId) && this.isEnableHistory == find.isEnableHistory && this.isShowClearDialog == find.isShowClearDialog && Intrinsics.areEqual(this.searchHistory, find.searchHistory);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.searchBarState.hashCode() * 31) + this.globalSearchUri.hashCode()) * 31) + this.tribeeId.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isEnableHistory)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isShowClearDialog)) * 31) + this.searchHistory.hashCode();
        }

        public String toString() {
            SearchBarState searchBarState = this.searchBarState;
            String str = this.globalSearchUri;
            String str2 = this.tribeeId;
            boolean z = this.isEnableHistory;
            boolean z2 = this.isShowClearDialog;
            return "Find(searchBarState=" + searchBarState + ", globalSearchUri=" + str + ", tribeeId=" + str2 + ", isEnableHistory=" + z + ", isShowClearDialog=" + z2 + ", searchHistory=" + this.searchHistory + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Find(SearchBarState searchBarState, String globalSearchUri, String tribeeId, boolean isEnableHistory, boolean isShowClearDialog, List<String> list) {
            super(null);
            Intrinsics.checkNotNullParameter(searchBarState, "searchBarState");
            Intrinsics.checkNotNullParameter(globalSearchUri, "globalSearchUri");
            Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
            Intrinsics.checkNotNullParameter(list, "searchHistory");
            this.searchBarState = searchBarState;
            this.globalSearchUri = globalSearchUri;
            this.tribeeId = tribeeId;
            this.isEnableHistory = isEnableHistory;
            this.isShowClearDialog = isShowClearDialog;
            this.searchHistory = list;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Find(SearchBarState searchBarState, String str, String str2, boolean z, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(searchBarState, str, str2, z, r5, list);
            boolean z3;
            if ((i & 16) == 0) {
                z3 = z2;
            } else {
                z3 = false;
            }
        }

        @Override // kntr.app.tribee.search.state.TribeeSearchState
        public SearchBarState getSearchBarState() {
            return this.searchBarState;
        }

        @Override // kntr.app.tribee.search.state.TribeeSearchState
        public String getGlobalSearchUri() {
            return this.globalSearchUri;
        }

        @Override // kntr.app.tribee.search.state.TribeeSearchState
        public String getTribeeId() {
            return this.tribeeId;
        }

        public final boolean isEnableHistory() {
            return this.isEnableHistory;
        }

        public final boolean isShowClearDialog() {
            return this.isShowClearDialog;
        }

        public final List<String> getSearchHistory() {
            return this.searchHistory;
        }

        public final boolean isShowHistory() {
            return this.isEnableHistory && !this.searchHistory.isEmpty();
        }
    }

    /* compiled from: TribeeSearchPageState.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lkntr/app/tribee/search/state/TribeeSearchState$Result;", "Lkntr/app/tribee/search/state/TribeeSearchState;", "<init>", "()V", "trackId", "", "getTrackId", "()Ljava/lang/String;", "Loading", "Success", "Empty", "Lkntr/app/tribee/search/state/TribeeSearchState$Result$Empty;", "Lkntr/app/tribee/search/state/TribeeSearchState$Result$Loading;", "Lkntr/app/tribee/search/state/TribeeSearchState$Result$Success;", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static abstract class Result extends TribeeSearchState {
        public static final int $stable = 0;

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract String getTrackId();

        private Result() {
            super(null);
        }

        /* compiled from: TribeeSearchPageState.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lkntr/app/tribee/search/state/TribeeSearchState$Result$Loading;", "Lkntr/app/tribee/search/state/TribeeSearchState$Result;", "searchBarState", "Lkntr/app/tribee/search/state/SearchBarState;", "globalSearchUri", "", "tribeeId", "trackId", "<init>", "(Lkntr/app/tribee/search/state/SearchBarState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSearchBarState", "()Lkntr/app/tribee/search/state/SearchBarState;", "getGlobalSearchUri", "()Ljava/lang/String;", "getTribeeId", "getTrackId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Loading extends Result {
            public static final int $stable = 0;
            private final String globalSearchUri;
            private final SearchBarState searchBarState;
            private final String trackId;
            private final String tribeeId;

            public static /* synthetic */ Loading copy$default(Loading loading, SearchBarState searchBarState, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    searchBarState = loading.searchBarState;
                }
                if ((i & 2) != 0) {
                    str = loading.globalSearchUri;
                }
                if ((i & 4) != 0) {
                    str2 = loading.tribeeId;
                }
                if ((i & 8) != 0) {
                    str3 = loading.trackId;
                }
                return loading.copy(searchBarState, str, str2, str3);
            }

            public final SearchBarState component1() {
                return this.searchBarState;
            }

            public final String component2() {
                return this.globalSearchUri;
            }

            public final String component3() {
                return this.tribeeId;
            }

            public final String component4() {
                return this.trackId;
            }

            public final Loading copy(SearchBarState searchBarState, String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(searchBarState, "searchBarState");
                Intrinsics.checkNotNullParameter(str, "globalSearchUri");
                Intrinsics.checkNotNullParameter(str2, "tribeeId");
                return new Loading(searchBarState, str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Loading) {
                    Loading loading = (Loading) obj;
                    return Intrinsics.areEqual(this.searchBarState, loading.searchBarState) && Intrinsics.areEqual(this.globalSearchUri, loading.globalSearchUri) && Intrinsics.areEqual(this.tribeeId, loading.tribeeId) && Intrinsics.areEqual(this.trackId, loading.trackId);
                }
                return false;
            }

            public int hashCode() {
                return (((((this.searchBarState.hashCode() * 31) + this.globalSearchUri.hashCode()) * 31) + this.tribeeId.hashCode()) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode());
            }

            public String toString() {
                SearchBarState searchBarState = this.searchBarState;
                String str = this.globalSearchUri;
                String str2 = this.tribeeId;
                return "Loading(searchBarState=" + searchBarState + ", globalSearchUri=" + str + ", tribeeId=" + str2 + ", trackId=" + this.trackId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loading(SearchBarState searchBarState, String globalSearchUri, String tribeeId, String trackId) {
                super(null);
                Intrinsics.checkNotNullParameter(searchBarState, "searchBarState");
                Intrinsics.checkNotNullParameter(globalSearchUri, "globalSearchUri");
                Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
                this.searchBarState = searchBarState;
                this.globalSearchUri = globalSearchUri;
                this.tribeeId = tribeeId;
                this.trackId = trackId;
            }

            public /* synthetic */ Loading(SearchBarState searchBarState, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(searchBarState, str, str2, (i & 8) != 0 ? null : str3);
            }

            @Override // kntr.app.tribee.search.state.TribeeSearchState
            public SearchBarState getSearchBarState() {
                return this.searchBarState;
            }

            @Override // kntr.app.tribee.search.state.TribeeSearchState
            public String getGlobalSearchUri() {
                return this.globalSearchUri;
            }

            @Override // kntr.app.tribee.search.state.TribeeSearchState
            public String getTribeeId() {
                return this.tribeeId;
            }

            @Override // kntr.app.tribee.search.state.TribeeSearchState.Result
            public String getTrackId() {
                return this.trackId;
            }
        }

        /* compiled from: TribeeSearchPageState.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010$\u001a\u00020\u000eHÆ\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006,"}, d2 = {"Lkntr/app/tribee/search/state/TribeeSearchState$Result$Success;", "Lkntr/app/tribee/search/state/TribeeSearchState$Result;", "searchBarState", "Lkntr/app/tribee/search/state/SearchBarState;", "globalSearchUri", "", "tribeeId", "trackId", "contents", "", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSearchCard;", "nextPage", "Lcom/bapis/bilibili/pagination/KPaginationReply;", "isLoadingMore", "", "<init>", "(Lkntr/app/tribee/search/state/SearchBarState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/bapis/bilibili/pagination/KPaginationReply;Z)V", "getSearchBarState", "()Lkntr/app/tribee/search/state/SearchBarState;", "getGlobalSearchUri", "()Ljava/lang/String;", "getTribeeId", "getTrackId", "getContents", "()Ljava/util/List;", "getNextPage", "()Lcom/bapis/bilibili/pagination/KPaginationReply;", "()Z", "hasMore", "getHasMore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Success extends Result {
            public static final int $stable = 8;
            private final List<KTribeeSearchCard> contents;
            private final String globalSearchUri;
            private final boolean isLoadingMore;
            private final KPaginationReply nextPage;
            private final SearchBarState searchBarState;
            private final String trackId;
            private final String tribeeId;

            public static /* synthetic */ Success copy$default(Success success, SearchBarState searchBarState, String str, String str2, String str3, List list, KPaginationReply kPaginationReply, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    searchBarState = success.searchBarState;
                }
                if ((i & 2) != 0) {
                    str = success.globalSearchUri;
                }
                String str4 = str;
                if ((i & 4) != 0) {
                    str2 = success.tribeeId;
                }
                String str5 = str2;
                if ((i & 8) != 0) {
                    str3 = success.trackId;
                }
                String str6 = str3;
                List<KTribeeSearchCard> list2 = list;
                if ((i & 16) != 0) {
                    list2 = success.contents;
                }
                List list3 = list2;
                if ((i & 32) != 0) {
                    kPaginationReply = success.nextPage;
                }
                KPaginationReply kPaginationReply2 = kPaginationReply;
                if ((i & 64) != 0) {
                    z = success.isLoadingMore;
                }
                return success.copy(searchBarState, str4, str5, str6, list3, kPaginationReply2, z);
            }

            public final SearchBarState component1() {
                return this.searchBarState;
            }

            public final String component2() {
                return this.globalSearchUri;
            }

            public final String component3() {
                return this.tribeeId;
            }

            public final String component4() {
                return this.trackId;
            }

            public final List<KTribeeSearchCard> component5() {
                return this.contents;
            }

            public final KPaginationReply component6() {
                return this.nextPage;
            }

            public final boolean component7() {
                return this.isLoadingMore;
            }

            public final Success copy(SearchBarState searchBarState, String str, String str2, String str3, List<KTribeeSearchCard> list, KPaginationReply kPaginationReply, boolean z) {
                Intrinsics.checkNotNullParameter(searchBarState, "searchBarState");
                Intrinsics.checkNotNullParameter(str, "globalSearchUri");
                Intrinsics.checkNotNullParameter(str2, "tribeeId");
                Intrinsics.checkNotNullParameter(list, "contents");
                return new Success(searchBarState, str, str2, str3, list, kPaginationReply, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Success) {
                    Success success = (Success) obj;
                    return Intrinsics.areEqual(this.searchBarState, success.searchBarState) && Intrinsics.areEqual(this.globalSearchUri, success.globalSearchUri) && Intrinsics.areEqual(this.tribeeId, success.tribeeId) && Intrinsics.areEqual(this.trackId, success.trackId) && Intrinsics.areEqual(this.contents, success.contents) && Intrinsics.areEqual(this.nextPage, success.nextPage) && this.isLoadingMore == success.isLoadingMore;
                }
                return false;
            }

            public int hashCode() {
                return (((((((((((this.searchBarState.hashCode() * 31) + this.globalSearchUri.hashCode()) * 31) + this.tribeeId.hashCode()) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + this.contents.hashCode()) * 31) + (this.nextPage != null ? this.nextPage.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoadingMore);
            }

            public String toString() {
                SearchBarState searchBarState = this.searchBarState;
                String str = this.globalSearchUri;
                String str2 = this.tribeeId;
                String str3 = this.trackId;
                List<KTribeeSearchCard> list = this.contents;
                KPaginationReply kPaginationReply = this.nextPage;
                return "Success(searchBarState=" + searchBarState + ", globalSearchUri=" + str + ", tribeeId=" + str2 + ", trackId=" + str3 + ", contents=" + list + ", nextPage=" + kPaginationReply + ", isLoadingMore=" + this.isLoadingMore + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(SearchBarState searchBarState, String globalSearchUri, String tribeeId, String trackId, List<KTribeeSearchCard> list, KPaginationReply nextPage, boolean isLoadingMore) {
                super(null);
                Intrinsics.checkNotNullParameter(searchBarState, "searchBarState");
                Intrinsics.checkNotNullParameter(globalSearchUri, "globalSearchUri");
                Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
                Intrinsics.checkNotNullParameter(list, "contents");
                this.searchBarState = searchBarState;
                this.globalSearchUri = globalSearchUri;
                this.tribeeId = tribeeId;
                this.trackId = trackId;
                this.contents = list;
                this.nextPage = nextPage;
                this.isLoadingMore = isLoadingMore;
            }

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public /* synthetic */ Success(SearchBarState searchBarState, String str, String str2, String str3, List list, KPaginationReply kPaginationReply, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(searchBarState, str, str2, r5, list, kPaginationReply, r8);
                String str4;
                boolean z2;
                if ((i & 8) == 0) {
                    str4 = str3;
                } else {
                    str4 = null;
                }
                if ((i & 64) == 0) {
                    z2 = z;
                } else {
                    z2 = false;
                }
            }

            @Override // kntr.app.tribee.search.state.TribeeSearchState
            public SearchBarState getSearchBarState() {
                return this.searchBarState;
            }

            @Override // kntr.app.tribee.search.state.TribeeSearchState
            public String getGlobalSearchUri() {
                return this.globalSearchUri;
            }

            @Override // kntr.app.tribee.search.state.TribeeSearchState
            public String getTribeeId() {
                return this.tribeeId;
            }

            @Override // kntr.app.tribee.search.state.TribeeSearchState.Result
            public String getTrackId() {
                return this.trackId;
            }

            public final List<KTribeeSearchCard> getContents() {
                return this.contents;
            }

            public final KPaginationReply getNextPage() {
                return this.nextPage;
            }

            public final boolean isLoadingMore() {
                return this.isLoadingMore;
            }

            public final boolean getHasMore() {
                KPaginationReply kPaginationReply = this.nextPage;
                String next = kPaginationReply != null ? kPaginationReply.getNext() : null;
                return !(next == null || next.length() == 0);
            }
        }

        /* compiled from: TribeeSearchPageState.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001f"}, d2 = {"Lkntr/app/tribee/search/state/TribeeSearchState$Result$Empty;", "Lkntr/app/tribee/search/state/TribeeSearchState$Result;", "searchBarState", "Lkntr/app/tribee/search/state/SearchBarState;", "globalSearchUri", "", "tribeeId", "trackId", "query", "<init>", "(Lkntr/app/tribee/search/state/SearchBarState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSearchBarState", "()Lkntr/app/tribee/search/state/SearchBarState;", "getGlobalSearchUri", "()Ljava/lang/String;", "getTribeeId", "getTrackId", "getQuery", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Empty extends Result {
            public static final int $stable = 0;
            private final String globalSearchUri;
            private final String query;
            private final SearchBarState searchBarState;
            private final String trackId;
            private final String tribeeId;

            public static /* synthetic */ Empty copy$default(Empty empty, SearchBarState searchBarState, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    searchBarState = empty.searchBarState;
                }
                if ((i & 2) != 0) {
                    str = empty.globalSearchUri;
                }
                String str5 = str;
                if ((i & 4) != 0) {
                    str2 = empty.tribeeId;
                }
                String str6 = str2;
                if ((i & 8) != 0) {
                    str3 = empty.trackId;
                }
                String str7 = str3;
                if ((i & 16) != 0) {
                    str4 = empty.query;
                }
                return empty.copy(searchBarState, str5, str6, str7, str4);
            }

            public final SearchBarState component1() {
                return this.searchBarState;
            }

            public final String component2() {
                return this.globalSearchUri;
            }

            public final String component3() {
                return this.tribeeId;
            }

            public final String component4() {
                return this.trackId;
            }

            public final String component5() {
                return this.query;
            }

            public final Empty copy(SearchBarState searchBarState, String str, String str2, String str3, String str4) {
                Intrinsics.checkNotNullParameter(searchBarState, "searchBarState");
                Intrinsics.checkNotNullParameter(str, "globalSearchUri");
                Intrinsics.checkNotNullParameter(str2, "tribeeId");
                Intrinsics.checkNotNullParameter(str4, "query");
                return new Empty(searchBarState, str, str2, str3, str4);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Empty) {
                    Empty empty = (Empty) obj;
                    return Intrinsics.areEqual(this.searchBarState, empty.searchBarState) && Intrinsics.areEqual(this.globalSearchUri, empty.globalSearchUri) && Intrinsics.areEqual(this.tribeeId, empty.tribeeId) && Intrinsics.areEqual(this.trackId, empty.trackId) && Intrinsics.areEqual(this.query, empty.query);
                }
                return false;
            }

            public int hashCode() {
                return (((((((this.searchBarState.hashCode() * 31) + this.globalSearchUri.hashCode()) * 31) + this.tribeeId.hashCode()) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + this.query.hashCode();
            }

            public String toString() {
                SearchBarState searchBarState = this.searchBarState;
                String str = this.globalSearchUri;
                String str2 = this.tribeeId;
                String str3 = this.trackId;
                return "Empty(searchBarState=" + searchBarState + ", globalSearchUri=" + str + ", tribeeId=" + str2 + ", trackId=" + str3 + ", query=" + this.query + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Empty(SearchBarState searchBarState, String globalSearchUri, String tribeeId, String trackId, String query) {
                super(null);
                Intrinsics.checkNotNullParameter(searchBarState, "searchBarState");
                Intrinsics.checkNotNullParameter(globalSearchUri, "globalSearchUri");
                Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
                Intrinsics.checkNotNullParameter(query, "query");
                this.searchBarState = searchBarState;
                this.globalSearchUri = globalSearchUri;
                this.tribeeId = tribeeId;
                this.trackId = trackId;
                this.query = query;
            }

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public /* synthetic */ Empty(SearchBarState searchBarState, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(searchBarState, str, str2, r4, str4);
                String str5;
                if ((i & 8) == 0) {
                    str5 = str3;
                } else {
                    str5 = null;
                }
            }

            @Override // kntr.app.tribee.search.state.TribeeSearchState
            public SearchBarState getSearchBarState() {
                return this.searchBarState;
            }

            @Override // kntr.app.tribee.search.state.TribeeSearchState
            public String getGlobalSearchUri() {
                return this.globalSearchUri;
            }

            @Override // kntr.app.tribee.search.state.TribeeSearchState
            public String getTribeeId() {
                return this.tribeeId;
            }

            @Override // kntr.app.tribee.search.state.TribeeSearchState.Result
            public String getTrackId() {
                return this.trackId;
            }

            public final String getQuery() {
                return this.query;
            }
        }
    }

    /* compiled from: TribeeSearchPageState.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0007¨\u0006\r"}, d2 = {"Lkntr/app/tribee/search/state/TribeeSearchState$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/search/state/TribeeSearchState;", "keyword", "", "hint", "enableHistory", "", "globalSearchUri", "tribeeId", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TribeeSearchState create(String keyword, String hint, boolean enableHistory, String globalSearchUri, String tribeeId) {
            Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
            String initialText = keyword == null ? "" : keyword;
            SearchBarState searchBarState = new SearchBarState(hint != null ? hint : "", new TextFieldState(initialText, TextRangeKt.TextRange(initialText.length()), (DefaultConstructorMarker) null));
            String globalSearchUri2 = globalSearchUri == null ? "bilibili://search?" : globalSearchUri;
            String str = keyword;
            if (str == null || str.length() == 0) {
                return new Find(searchBarState, globalSearchUri2, tribeeId, enableHistory, false, TribeeSearchStore.INSTANCE.getHistories(tribeeId));
            }
            return new Result.Loading(searchBarState, globalSearchUri2, tribeeId, null, 8, null);
        }
    }
}