package kntr.app.tribee.repost.action;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeRepostAction.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0018\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u0082\u0001\u0018\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./01¨\u00062À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "", "Loading", "ShowSelectTribeeBottomSheet", "SelectTribeeBottomSheetHasLoaded", "SelectTribeeBottomSheetTribeeItemExposed", "SelectedTribeeOrPartitionChanged", "DismissSelectTribeeBottomSheet", "ShowIntroBottomSheet", "IntroBottomSheetExposed", "IntroBottomSheetConfirmClick", "DismissIntroBottomSheet", "ShowEditMainTextBottomSheet", "EditMainTextBottomSheetExposed", "MainTextChanged", "EditMainTextBottomSheetConfirmClick", "DismissEditMainTextBottomSheet", "ShowEditTitleTextBottomSheet", "EditTitleTextBottomSheetExposed", "TitleTextChanged", "EditTitleTextBottomSheetConfirmClick", "DismissEditTitleTextBottomSheet", "RepostToFollowingChanged", "RepostWithSourceChanged", "RepostClick", "RequestRepost", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$DismissEditMainTextBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$DismissEditTitleTextBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$DismissIntroBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$DismissSelectTribeeBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$EditMainTextBottomSheetConfirmClick;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$EditMainTextBottomSheetExposed;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$EditTitleTextBottomSheetConfirmClick;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$EditTitleTextBottomSheetExposed;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$IntroBottomSheetConfirmClick;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$IntroBottomSheetExposed;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$Loading;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$MainTextChanged;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$RepostClick;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$RepostToFollowingChanged;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$RepostWithSourceChanged;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$RequestRepost;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$SelectTribeeBottomSheetHasLoaded;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$SelectTribeeBottomSheetTribeeItemExposed;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$SelectedTribeeOrPartitionChanged;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$ShowEditMainTextBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$ShowEditTitleTextBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$ShowIntroBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$ShowSelectTribeeBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$TitleTextChanged;", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeRepostStateAction {

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$Loading;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Loading implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Loading) {
                Loading loading = (Loading) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1335198481;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$ShowSelectTribeeBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShowSelectTribeeBottomSheet implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final ShowSelectTribeeBottomSheet INSTANCE = new ShowSelectTribeeBottomSheet();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowSelectTribeeBottomSheet) {
                ShowSelectTribeeBottomSheet showSelectTribeeBottomSheet = (ShowSelectTribeeBottomSheet) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 26381945;
        }

        public String toString() {
            return "ShowSelectTribeeBottomSheet";
        }

        private ShowSelectTribeeBottomSheet() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$SelectTribeeBottomSheetHasLoaded;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SelectTribeeBottomSheetHasLoaded implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final SelectTribeeBottomSheetHasLoaded INSTANCE = new SelectTribeeBottomSheetHasLoaded();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SelectTribeeBottomSheetHasLoaded) {
                SelectTribeeBottomSheetHasLoaded selectTribeeBottomSheetHasLoaded = (SelectTribeeBottomSheetHasLoaded) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 606064425;
        }

        public String toString() {
            return "SelectTribeeBottomSheetHasLoaded";
        }

        private SelectTribeeBottomSheetHasLoaded() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$SelectTribeeBottomSheetTribeeItemExposed;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "tribeeId", "", "tribeeName", "", "<init>", "(JLjava/lang/String;)V", "getTribeeId", "()J", "getTribeeName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SelectTribeeBottomSheetTribeeItemExposed implements TribeeRepostStateAction {
        public static final int $stable = 0;
        private final long tribeeId;
        private final String tribeeName;

        public static /* synthetic */ SelectTribeeBottomSheetTribeeItemExposed copy$default(SelectTribeeBottomSheetTribeeItemExposed selectTribeeBottomSheetTribeeItemExposed, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = selectTribeeBottomSheetTribeeItemExposed.tribeeId;
            }
            if ((i & 2) != 0) {
                str = selectTribeeBottomSheetTribeeItemExposed.tribeeName;
            }
            return selectTribeeBottomSheetTribeeItemExposed.copy(j, str);
        }

        public final long component1() {
            return this.tribeeId;
        }

        public final String component2() {
            return this.tribeeName;
        }

        public final SelectTribeeBottomSheetTribeeItemExposed copy(long j, String str) {
            Intrinsics.checkNotNullParameter(str, "tribeeName");
            return new SelectTribeeBottomSheetTribeeItemExposed(j, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SelectTribeeBottomSheetTribeeItemExposed) {
                SelectTribeeBottomSheetTribeeItemExposed selectTribeeBottomSheetTribeeItemExposed = (SelectTribeeBottomSheetTribeeItemExposed) obj;
                return this.tribeeId == selectTribeeBottomSheetTribeeItemExposed.tribeeId && Intrinsics.areEqual(this.tribeeName, selectTribeeBottomSheetTribeeItemExposed.tribeeName);
            }
            return false;
        }

        public int hashCode() {
            return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.tribeeId) * 31) + this.tribeeName.hashCode();
        }

        public String toString() {
            long j = this.tribeeId;
            return "SelectTribeeBottomSheetTribeeItemExposed(tribeeId=" + j + ", tribeeName=" + this.tribeeName + ")";
        }

        public SelectTribeeBottomSheetTribeeItemExposed(long tribeeId, String tribeeName) {
            Intrinsics.checkNotNullParameter(tribeeName, "tribeeName");
            this.tribeeId = tribeeId;
            this.tribeeName = tribeeName;
        }

        public final long getTribeeId() {
            return this.tribeeId;
        }

        public final String getTribeeName() {
            return this.tribeeName;
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003JG\u0010\u0013\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$SelectedTribeeOrPartitionChanged;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "tribee", "Lkotlin/Pair;", "", "", "partition", "byUserClick", "", "<init>", "(Lkotlin/Pair;Lkotlin/Pair;Z)V", "getTribee", "()Lkotlin/Pair;", "getPartition", "getByUserClick", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SelectedTribeeOrPartitionChanged implements TribeeRepostStateAction {
        public static final int $stable = 0;
        private final boolean byUserClick;
        private final Pair<Long, String> partition;
        private final Pair<Long, String> tribee;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SelectedTribeeOrPartitionChanged copy$default(SelectedTribeeOrPartitionChanged selectedTribeeOrPartitionChanged, Pair pair, Pair pair2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                pair = selectedTribeeOrPartitionChanged.tribee;
            }
            if ((i & 2) != 0) {
                pair2 = selectedTribeeOrPartitionChanged.partition;
            }
            if ((i & 4) != 0) {
                z = selectedTribeeOrPartitionChanged.byUserClick;
            }
            return selectedTribeeOrPartitionChanged.copy(pair, pair2, z);
        }

        public final Pair<Long, String> component1() {
            return this.tribee;
        }

        public final Pair<Long, String> component2() {
            return this.partition;
        }

        public final boolean component3() {
            return this.byUserClick;
        }

        public final SelectedTribeeOrPartitionChanged copy(Pair<Long, String> pair, Pair<Long, String> pair2, boolean z) {
            Intrinsics.checkNotNullParameter(pair, "tribee");
            Intrinsics.checkNotNullParameter(pair2, "partition");
            return new SelectedTribeeOrPartitionChanged(pair, pair2, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SelectedTribeeOrPartitionChanged) {
                SelectedTribeeOrPartitionChanged selectedTribeeOrPartitionChanged = (SelectedTribeeOrPartitionChanged) obj;
                return Intrinsics.areEqual(this.tribee, selectedTribeeOrPartitionChanged.tribee) && Intrinsics.areEqual(this.partition, selectedTribeeOrPartitionChanged.partition) && this.byUserClick == selectedTribeeOrPartitionChanged.byUserClick;
            }
            return false;
        }

        public int hashCode() {
            return (((this.tribee.hashCode() * 31) + this.partition.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.byUserClick);
        }

        public String toString() {
            Pair<Long, String> pair = this.tribee;
            Pair<Long, String> pair2 = this.partition;
            return "SelectedTribeeOrPartitionChanged(tribee=" + pair + ", partition=" + pair2 + ", byUserClick=" + this.byUserClick + ")";
        }

        public SelectedTribeeOrPartitionChanged(Pair<Long, String> pair, Pair<Long, String> pair2, boolean byUserClick) {
            Intrinsics.checkNotNullParameter(pair, "tribee");
            Intrinsics.checkNotNullParameter(pair2, "partition");
            this.tribee = pair;
            this.partition = pair2;
            this.byUserClick = byUserClick;
        }

        public final Pair<Long, String> getTribee() {
            return this.tribee;
        }

        public final Pair<Long, String> getPartition() {
            return this.partition;
        }

        public final boolean getByUserClick() {
            return this.byUserClick;
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$DismissSelectTribeeBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DismissSelectTribeeBottomSheet implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final DismissSelectTribeeBottomSheet INSTANCE = new DismissSelectTribeeBottomSheet();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DismissSelectTribeeBottomSheet) {
                DismissSelectTribeeBottomSheet dismissSelectTribeeBottomSheet = (DismissSelectTribeeBottomSheet) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -397262462;
        }

        public String toString() {
            return "DismissSelectTribeeBottomSheet";
        }

        private DismissSelectTribeeBottomSheet() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$ShowIntroBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShowIntroBottomSheet implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final ShowIntroBottomSheet INSTANCE = new ShowIntroBottomSheet();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowIntroBottomSheet) {
                ShowIntroBottomSheet showIntroBottomSheet = (ShowIntroBottomSheet) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1805779280;
        }

        public String toString() {
            return "ShowIntroBottomSheet";
        }

        private ShowIntroBottomSheet() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$IntroBottomSheetExposed;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class IntroBottomSheetExposed implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final IntroBottomSheetExposed INSTANCE = new IntroBottomSheetExposed();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IntroBottomSheetExposed) {
                IntroBottomSheetExposed introBottomSheetExposed = (IntroBottomSheetExposed) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -34020371;
        }

        public String toString() {
            return "IntroBottomSheetExposed";
        }

        private IntroBottomSheetExposed() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$IntroBottomSheetConfirmClick;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class IntroBottomSheetConfirmClick implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final IntroBottomSheetConfirmClick INSTANCE = new IntroBottomSheetConfirmClick();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IntroBottomSheetConfirmClick) {
                IntroBottomSheetConfirmClick introBottomSheetConfirmClick = (IntroBottomSheetConfirmClick) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 927260667;
        }

        public String toString() {
            return "IntroBottomSheetConfirmClick";
        }

        private IntroBottomSheetConfirmClick() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$DismissIntroBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DismissIntroBottomSheet implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final DismissIntroBottomSheet INSTANCE = new DismissIntroBottomSheet();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DismissIntroBottomSheet) {
                DismissIntroBottomSheet dismissIntroBottomSheet = (DismissIntroBottomSheet) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 221754983;
        }

        public String toString() {
            return "DismissIntroBottomSheet";
        }

        private DismissIntroBottomSheet() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$ShowEditMainTextBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShowEditMainTextBottomSheet implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final ShowEditMainTextBottomSheet INSTANCE = new ShowEditMainTextBottomSheet();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowEditMainTextBottomSheet) {
                ShowEditMainTextBottomSheet showEditMainTextBottomSheet = (ShowEditMainTextBottomSheet) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 452100796;
        }

        public String toString() {
            return "ShowEditMainTextBottomSheet";
        }

        private ShowEditMainTextBottomSheet() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$EditMainTextBottomSheetExposed;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class EditMainTextBottomSheetExposed implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final EditMainTextBottomSheetExposed INSTANCE = new EditMainTextBottomSheetExposed();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EditMainTextBottomSheetExposed) {
                EditMainTextBottomSheetExposed editMainTextBottomSheetExposed = (EditMainTextBottomSheetExposed) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1236689433;
        }

        public String toString() {
            return "EditMainTextBottomSheetExposed";
        }

        private EditMainTextBottomSheetExposed() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$MainTextChanged;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MainTextChanged implements TribeeRepostStateAction {
        public static final int $stable = 0;
        private final String text;

        public static /* synthetic */ MainTextChanged copy$default(MainTextChanged mainTextChanged, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mainTextChanged.text;
            }
            return mainTextChanged.copy(str);
        }

        public final String component1() {
            return this.text;
        }

        public final MainTextChanged copy(String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new MainTextChanged(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MainTextChanged) && Intrinsics.areEqual(this.text, ((MainTextChanged) obj).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "MainTextChanged(text=" + this.text + ")";
        }

        public MainTextChanged(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$EditMainTextBottomSheetConfirmClick;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class EditMainTextBottomSheetConfirmClick implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final EditMainTextBottomSheetConfirmClick INSTANCE = new EditMainTextBottomSheetConfirmClick();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EditMainTextBottomSheetConfirmClick) {
                EditMainTextBottomSheetConfirmClick editMainTextBottomSheetConfirmClick = (EditMainTextBottomSheetConfirmClick) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1944366527;
        }

        public String toString() {
            return "EditMainTextBottomSheetConfirmClick";
        }

        private EditMainTextBottomSheetConfirmClick() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$DismissEditMainTextBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DismissEditMainTextBottomSheet implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final DismissEditMainTextBottomSheet INSTANCE = new DismissEditMainTextBottomSheet();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DismissEditMainTextBottomSheet) {
                DismissEditMainTextBottomSheet dismissEditMainTextBottomSheet = (DismissEditMainTextBottomSheet) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 28456389;
        }

        public String toString() {
            return "DismissEditMainTextBottomSheet";
        }

        private DismissEditMainTextBottomSheet() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$ShowEditTitleTextBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShowEditTitleTextBottomSheet implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final ShowEditTitleTextBottomSheet INSTANCE = new ShowEditTitleTextBottomSheet();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowEditTitleTextBottomSheet) {
                ShowEditTitleTextBottomSheet showEditTitleTextBottomSheet = (ShowEditTitleTextBottomSheet) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -63177823;
        }

        public String toString() {
            return "ShowEditTitleTextBottomSheet";
        }

        private ShowEditTitleTextBottomSheet() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$EditTitleTextBottomSheetExposed;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class EditTitleTextBottomSheetExposed implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final EditTitleTextBottomSheetExposed INSTANCE = new EditTitleTextBottomSheetExposed();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EditTitleTextBottomSheetExposed) {
                EditTitleTextBottomSheetExposed editTitleTextBottomSheetExposed = (EditTitleTextBottomSheetExposed) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -495104132;
        }

        public String toString() {
            return "EditTitleTextBottomSheetExposed";
        }

        private EditTitleTextBottomSheetExposed() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$TitleTextChanged;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TitleTextChanged implements TribeeRepostStateAction {
        public static final int $stable = 0;
        private final String text;

        public static /* synthetic */ TitleTextChanged copy$default(TitleTextChanged titleTextChanged, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = titleTextChanged.text;
            }
            return titleTextChanged.copy(str);
        }

        public final String component1() {
            return this.text;
        }

        public final TitleTextChanged copy(String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new TitleTextChanged(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TitleTextChanged) && Intrinsics.areEqual(this.text, ((TitleTextChanged) obj).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "TitleTextChanged(text=" + this.text + ")";
        }

        public TitleTextChanged(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$EditTitleTextBottomSheetConfirmClick;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class EditTitleTextBottomSheetConfirmClick implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final EditTitleTextBottomSheetConfirmClick INSTANCE = new EditTitleTextBottomSheetConfirmClick();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EditTitleTextBottomSheetConfirmClick) {
                EditTitleTextBottomSheetConfirmClick editTitleTextBottomSheetConfirmClick = (EditTitleTextBottomSheetConfirmClick) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 265311692;
        }

        public String toString() {
            return "EditTitleTextBottomSheetConfirmClick";
        }

        private EditTitleTextBottomSheetConfirmClick() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$DismissEditTitleTextBottomSheet;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DismissEditTitleTextBottomSheet implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final DismissEditTitleTextBottomSheet INSTANCE = new DismissEditTitleTextBottomSheet();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DismissEditTitleTextBottomSheet) {
                DismissEditTitleTextBottomSheet dismissEditTitleTextBottomSheet = (DismissEditTitleTextBottomSheet) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -311252552;
        }

        public String toString() {
            return "DismissEditTitleTextBottomSheet";
        }

        private DismissEditTitleTextBottomSheet() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$RepostToFollowingChanged;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "checked", "", "<init>", "(Z)V", "getChecked", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RepostToFollowingChanged implements TribeeRepostStateAction {
        public static final int $stable = 0;
        private final boolean checked;

        public static /* synthetic */ RepostToFollowingChanged copy$default(RepostToFollowingChanged repostToFollowingChanged, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = repostToFollowingChanged.checked;
            }
            return repostToFollowingChanged.copy(z);
        }

        public final boolean component1() {
            return this.checked;
        }

        public final RepostToFollowingChanged copy(boolean z) {
            return new RepostToFollowingChanged(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RepostToFollowingChanged) && this.checked == ((RepostToFollowingChanged) obj).checked;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.checked);
        }

        public String toString() {
            return "RepostToFollowingChanged(checked=" + this.checked + ")";
        }

        public RepostToFollowingChanged(boolean checked) {
            this.checked = checked;
        }

        public final boolean getChecked() {
            return this.checked;
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$RepostWithSourceChanged;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "checked", "", "<init>", "(Z)V", "getChecked", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RepostWithSourceChanged implements TribeeRepostStateAction {
        public static final int $stable = 0;
        private final boolean checked;

        public static /* synthetic */ RepostWithSourceChanged copy$default(RepostWithSourceChanged repostWithSourceChanged, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = repostWithSourceChanged.checked;
            }
            return repostWithSourceChanged.copy(z);
        }

        public final boolean component1() {
            return this.checked;
        }

        public final RepostWithSourceChanged copy(boolean z) {
            return new RepostWithSourceChanged(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RepostWithSourceChanged) && this.checked == ((RepostWithSourceChanged) obj).checked;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.checked);
        }

        public String toString() {
            return "RepostWithSourceChanged(checked=" + this.checked + ")";
        }

        public RepostWithSourceChanged(boolean checked) {
            this.checked = checked;
        }

        public final boolean getChecked() {
            return this.checked;
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$RepostClick;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RepostClick implements TribeeRepostStateAction {
        public static final int $stable = 0;
        public static final RepostClick INSTANCE = new RepostClick();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RepostClick) {
                RepostClick repostClick = (RepostClick) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -424965302;
        }

        public String toString() {
            return "RepostClick";
        }

        private RepostClick() {
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostStateAction$RequestRepost;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "fromType", "", "<init>", "(I)V", "getFromType", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RequestRepost implements TribeeRepostStateAction {
        public static final int $stable = 0;
        private final int fromType;

        public static /* synthetic */ RequestRepost copy$default(RequestRepost requestRepost, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = requestRepost.fromType;
            }
            return requestRepost.copy(i);
        }

        public final int component1() {
            return this.fromType;
        }

        public final RequestRepost copy(int i) {
            return new RequestRepost(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RequestRepost) && this.fromType == ((RequestRepost) obj).fromType;
        }

        public int hashCode() {
            return this.fromType;
        }

        public String toString() {
            return "RequestRepost(fromType=" + this.fromType + ")";
        }

        public RequestRepost(int fromType) {
            this.fromType = fromType;
        }

        public final int getFromType() {
            return this.fromType;
        }
    }
}