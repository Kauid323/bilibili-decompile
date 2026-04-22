package kntr.app.tribee.repost.state;

import BottomSheetItemData$;
import com.bapis.bilibili.app.dynamic.v2.KRepostOpus2TribeeOptionsResp;
import kntr.app.tribee.repost.action.TribeeRepostUIAction;
import kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetState;
import kntr.app.tribee.repost.page.introBottomSheet.IntroBottomSheetState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeRepostState.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0015\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lkntr/app/tribee/repost/state/TribeeRepostState;", "", "uiAction", "Lkntr/app/tribee/repost/action/TribeeRepostUIAction;", "<init>", "(Lkntr/app/tribee/repost/action/TribeeRepostUIAction;)V", "getUiAction", "()Lkntr/app/tribee/repost/action/TribeeRepostUIAction;", "TribeeRepostLoadingState", "TribeeRepostErrorState", "TribeeRepostContentState", "Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostContentState;", "Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostErrorState;", "Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostLoadingState;", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class TribeeRepostState {
    public static final int $stable = 0;
    private final TribeeRepostUIAction uiAction;

    public /* synthetic */ TribeeRepostState(TribeeRepostUIAction tribeeRepostUIAction, DefaultConstructorMarker defaultConstructorMarker) {
        this(tribeeRepostUIAction);
    }

    private TribeeRepostState(TribeeRepostUIAction uiAction) {
        this.uiAction = uiAction;
    }

    public /* synthetic */ TribeeRepostState(TribeeRepostUIAction tribeeRepostUIAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tribeeRepostUIAction, null);
    }

    public TribeeRepostUIAction getUiAction() {
        return this.uiAction;
    }

    /* compiled from: TribeeRepostState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostLoadingState;", "Lkntr/app/tribee/repost/state/TribeeRepostState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TribeeRepostLoadingState extends TribeeRepostState {
        public static final int $stable = 0;
        public static final TribeeRepostLoadingState INSTANCE = new TribeeRepostLoadingState();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TribeeRepostLoadingState) {
                TribeeRepostLoadingState tribeeRepostLoadingState = (TribeeRepostLoadingState) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1937686559;
        }

        public String toString() {
            return "TribeeRepostLoadingState";
        }

        private TribeeRepostLoadingState() {
            super(null, 1, null);
        }
    }

    /* compiled from: TribeeRepostState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostErrorState;", "Lkntr/app/tribee/repost/state/TribeeRepostState;", "uiAction", "Lkntr/app/tribee/repost/action/TribeeRepostUIAction;", "<init>", "(Lkntr/app/tribee/repost/action/TribeeRepostUIAction;)V", "getUiAction", "()Lkntr/app/tribee/repost/action/TribeeRepostUIAction;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TribeeRepostErrorState extends TribeeRepostState {
        public static final int $stable = 0;
        private final TribeeRepostUIAction uiAction;

        public TribeeRepostErrorState() {
            this(null, 1, null);
        }

        public static /* synthetic */ TribeeRepostErrorState copy$default(TribeeRepostErrorState tribeeRepostErrorState, TribeeRepostUIAction tribeeRepostUIAction, int i, Object obj) {
            if ((i & 1) != 0) {
                tribeeRepostUIAction = tribeeRepostErrorState.uiAction;
            }
            return tribeeRepostErrorState.copy(tribeeRepostUIAction);
        }

        public final TribeeRepostUIAction component1() {
            return this.uiAction;
        }

        public final TribeeRepostErrorState copy(TribeeRepostUIAction tribeeRepostUIAction) {
            return new TribeeRepostErrorState(tribeeRepostUIAction);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TribeeRepostErrorState) && Intrinsics.areEqual(this.uiAction, ((TribeeRepostErrorState) obj).uiAction);
        }

        public int hashCode() {
            if (this.uiAction == null) {
                return 0;
            }
            return this.uiAction.hashCode();
        }

        public String toString() {
            return "TribeeRepostErrorState(uiAction=" + this.uiAction + ")";
        }

        public TribeeRepostErrorState(TribeeRepostUIAction uiAction) {
            super(null, 1, null);
            this.uiAction = uiAction;
        }

        public /* synthetic */ TribeeRepostErrorState(TribeeRepostUIAction tribeeRepostUIAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : tribeeRepostUIAction);
        }

        @Override // kntr.app.tribee.repost.state.TribeeRepostState
        public TribeeRepostUIAction getUiAction() {
            return this.uiAction;
        }
    }

    /* compiled from: TribeeRepostState.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b+\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B·\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0013\u0012\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u00105\u001a\u00020\tHÆ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\t\u00107\u001a\u00020\u0010HÆ\u0003J\t\u00108\u001a\u00020\u0010HÆ\u0003J\u0019\u00109\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0013HÆ\u0003J\u0019\u0010:\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0013HÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003J½\u0001\u0010=\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00132\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00132\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\tHÆ\u0001J\u0013\u0010>\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020BHÖ\u0001J\t\u0010C\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R!\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R!\u0010\u0015\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0011\u0010\u0017\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!¨\u0006D"}, d2 = {"Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostContentState;", "Lkntr/app/tribee/repost/state/TribeeRepostState;", "uiAction", "Lkntr/app/tribee/repost/action/TribeeRepostUIAction;", "data", "Lcom/bapis/bilibili/app/dynamic/v2/KRepostOpus2TribeeOptionsResp;", "introBottomSheetState", "Lkntr/app/tribee/repost/page/introBottomSheet/IntroBottomSheetState;", "showSelectTribeeBottomSheet", "", "editRepostMainTextBottomSheetState", "Lkntr/app/tribee/repost/page/editTextBottomSheet/EditTextBottomSheetState;", "editRepostTitleTextBottomSheetState", "enableRepostToFollowing", "enableRepostWithSource", "repostMainText", "", "repostTitleText", "selectedTribee", "Lkotlin/Pair;", "", "selectedPartition", "enableClickPageRepost", "hasLoadedSelectTribeeBottomSheet", "<init>", "(Lkntr/app/tribee/repost/action/TribeeRepostUIAction;Lcom/bapis/bilibili/app/dynamic/v2/KRepostOpus2TribeeOptionsResp;Lkntr/app/tribee/repost/page/introBottomSheet/IntroBottomSheetState;ZLkntr/app/tribee/repost/page/editTextBottomSheet/EditTextBottomSheetState;Lkntr/app/tribee/repost/page/editTextBottomSheet/EditTextBottomSheetState;ZZLjava/lang/String;Ljava/lang/String;Lkotlin/Pair;Lkotlin/Pair;ZZ)V", "getUiAction", "()Lkntr/app/tribee/repost/action/TribeeRepostUIAction;", "getData", "()Lcom/bapis/bilibili/app/dynamic/v2/KRepostOpus2TribeeOptionsResp;", "getIntroBottomSheetState", "()Lkntr/app/tribee/repost/page/introBottomSheet/IntroBottomSheetState;", "getShowSelectTribeeBottomSheet", "()Z", "getEditRepostMainTextBottomSheetState", "()Lkntr/app/tribee/repost/page/editTextBottomSheet/EditTextBottomSheetState;", "getEditRepostTitleTextBottomSheetState", "getEnableRepostToFollowing", "getEnableRepostWithSource", "getRepostMainText", "()Ljava/lang/String;", "getRepostTitleText", "getSelectedTribee", "()Lkotlin/Pair;", "getSelectedPartition", "getEnableClickPageRepost", "getHasLoadedSelectTribeeBottomSheet", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "", "hashCode", "", "toString", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TribeeRepostContentState extends TribeeRepostState {
        public static final int $stable = 0;
        private final KRepostOpus2TribeeOptionsResp data;
        private final EditTextBottomSheetState editRepostMainTextBottomSheetState;
        private final EditTextBottomSheetState editRepostTitleTextBottomSheetState;
        private final boolean enableClickPageRepost;
        private final boolean enableRepostToFollowing;
        private final boolean enableRepostWithSource;
        private final boolean hasLoadedSelectTribeeBottomSheet;
        private final IntroBottomSheetState introBottomSheetState;
        private final String repostMainText;
        private final String repostTitleText;
        private final Pair<Long, String> selectedPartition;
        private final Pair<Long, String> selectedTribee;
        private final boolean showSelectTribeeBottomSheet;
        private final TribeeRepostUIAction uiAction;

        public final TribeeRepostUIAction component1() {
            return this.uiAction;
        }

        public final String component10() {
            return this.repostTitleText;
        }

        public final Pair<Long, String> component11() {
            return this.selectedTribee;
        }

        public final Pair<Long, String> component12() {
            return this.selectedPartition;
        }

        public final boolean component13() {
            return this.enableClickPageRepost;
        }

        public final boolean component14() {
            return this.hasLoadedSelectTribeeBottomSheet;
        }

        public final KRepostOpus2TribeeOptionsResp component2() {
            return this.data;
        }

        public final IntroBottomSheetState component3() {
            return this.introBottomSheetState;
        }

        public final boolean component4() {
            return this.showSelectTribeeBottomSheet;
        }

        public final EditTextBottomSheetState component5() {
            return this.editRepostMainTextBottomSheetState;
        }

        public final EditTextBottomSheetState component6() {
            return this.editRepostTitleTextBottomSheetState;
        }

        public final boolean component7() {
            return this.enableRepostToFollowing;
        }

        public final boolean component8() {
            return this.enableRepostWithSource;
        }

        public final String component9() {
            return this.repostMainText;
        }

        public final TribeeRepostContentState copy(TribeeRepostUIAction tribeeRepostUIAction, KRepostOpus2TribeeOptionsResp kRepostOpus2TribeeOptionsResp, IntroBottomSheetState introBottomSheetState, boolean z, EditTextBottomSheetState editTextBottomSheetState, EditTextBottomSheetState editTextBottomSheetState2, boolean z2, boolean z3, String str, String str2, Pair<Long, String> pair, Pair<Long, String> pair2, boolean z4, boolean z5) {
            Intrinsics.checkNotNullParameter(kRepostOpus2TribeeOptionsResp, "data");
            Intrinsics.checkNotNullParameter(str, "repostMainText");
            Intrinsics.checkNotNullParameter(str2, "repostTitleText");
            Intrinsics.checkNotNullParameter(pair, "selectedTribee");
            Intrinsics.checkNotNullParameter(pair2, "selectedPartition");
            return new TribeeRepostContentState(tribeeRepostUIAction, kRepostOpus2TribeeOptionsResp, introBottomSheetState, z, editTextBottomSheetState, editTextBottomSheetState2, z2, z3, str, str2, pair, pair2, z4, z5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TribeeRepostContentState) {
                TribeeRepostContentState tribeeRepostContentState = (TribeeRepostContentState) obj;
                return Intrinsics.areEqual(this.uiAction, tribeeRepostContentState.uiAction) && Intrinsics.areEqual(this.data, tribeeRepostContentState.data) && Intrinsics.areEqual(this.introBottomSheetState, tribeeRepostContentState.introBottomSheetState) && this.showSelectTribeeBottomSheet == tribeeRepostContentState.showSelectTribeeBottomSheet && Intrinsics.areEqual(this.editRepostMainTextBottomSheetState, tribeeRepostContentState.editRepostMainTextBottomSheetState) && Intrinsics.areEqual(this.editRepostTitleTextBottomSheetState, tribeeRepostContentState.editRepostTitleTextBottomSheetState) && this.enableRepostToFollowing == tribeeRepostContentState.enableRepostToFollowing && this.enableRepostWithSource == tribeeRepostContentState.enableRepostWithSource && Intrinsics.areEqual(this.repostMainText, tribeeRepostContentState.repostMainText) && Intrinsics.areEqual(this.repostTitleText, tribeeRepostContentState.repostTitleText) && Intrinsics.areEqual(this.selectedTribee, tribeeRepostContentState.selectedTribee) && Intrinsics.areEqual(this.selectedPartition, tribeeRepostContentState.selectedPartition) && this.enableClickPageRepost == tribeeRepostContentState.enableClickPageRepost && this.hasLoadedSelectTribeeBottomSheet == tribeeRepostContentState.hasLoadedSelectTribeeBottomSheet;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((this.uiAction == null ? 0 : this.uiAction.hashCode()) * 31) + this.data.hashCode()) * 31) + (this.introBottomSheetState == null ? 0 : this.introBottomSheetState.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showSelectTribeeBottomSheet)) * 31) + (this.editRepostMainTextBottomSheetState == null ? 0 : this.editRepostMainTextBottomSheetState.hashCode())) * 31) + (this.editRepostTitleTextBottomSheetState != null ? this.editRepostTitleTextBottomSheetState.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableRepostToFollowing)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableRepostWithSource)) * 31) + this.repostMainText.hashCode()) * 31) + this.repostTitleText.hashCode()) * 31) + this.selectedTribee.hashCode()) * 31) + this.selectedPartition.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableClickPageRepost)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasLoadedSelectTribeeBottomSheet);
        }

        public String toString() {
            TribeeRepostUIAction tribeeRepostUIAction = this.uiAction;
            KRepostOpus2TribeeOptionsResp kRepostOpus2TribeeOptionsResp = this.data;
            IntroBottomSheetState introBottomSheetState = this.introBottomSheetState;
            boolean z = this.showSelectTribeeBottomSheet;
            EditTextBottomSheetState editTextBottomSheetState = this.editRepostMainTextBottomSheetState;
            EditTextBottomSheetState editTextBottomSheetState2 = this.editRepostTitleTextBottomSheetState;
            boolean z2 = this.enableRepostToFollowing;
            boolean z3 = this.enableRepostWithSource;
            String str = this.repostMainText;
            String str2 = this.repostTitleText;
            Pair<Long, String> pair = this.selectedTribee;
            Pair<Long, String> pair2 = this.selectedPartition;
            boolean z4 = this.enableClickPageRepost;
            return "TribeeRepostContentState(uiAction=" + tribeeRepostUIAction + ", data=" + kRepostOpus2TribeeOptionsResp + ", introBottomSheetState=" + introBottomSheetState + ", showSelectTribeeBottomSheet=" + z + ", editRepostMainTextBottomSheetState=" + editTextBottomSheetState + ", editRepostTitleTextBottomSheetState=" + editTextBottomSheetState2 + ", enableRepostToFollowing=" + z2 + ", enableRepostWithSource=" + z3 + ", repostMainText=" + str + ", repostTitleText=" + str2 + ", selectedTribee=" + pair + ", selectedPartition=" + pair2 + ", enableClickPageRepost=" + z4 + ", hasLoadedSelectTribeeBottomSheet=" + this.hasLoadedSelectTribeeBottomSheet + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TribeeRepostContentState(TribeeRepostUIAction uiAction, KRepostOpus2TribeeOptionsResp data, IntroBottomSheetState introBottomSheetState, boolean showSelectTribeeBottomSheet, EditTextBottomSheetState editRepostMainTextBottomSheetState, EditTextBottomSheetState editRepostTitleTextBottomSheetState, boolean enableRepostToFollowing, boolean enableRepostWithSource, String repostMainText, String repostTitleText, Pair<Long, String> pair, Pair<Long, String> pair2, boolean enableClickPageRepost, boolean hasLoadedSelectTribeeBottomSheet) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(repostMainText, "repostMainText");
            Intrinsics.checkNotNullParameter(repostTitleText, "repostTitleText");
            Intrinsics.checkNotNullParameter(pair, "selectedTribee");
            Intrinsics.checkNotNullParameter(pair2, "selectedPartition");
            this.uiAction = uiAction;
            this.data = data;
            this.introBottomSheetState = introBottomSheetState;
            this.showSelectTribeeBottomSheet = showSelectTribeeBottomSheet;
            this.editRepostMainTextBottomSheetState = editRepostMainTextBottomSheetState;
            this.editRepostTitleTextBottomSheetState = editRepostTitleTextBottomSheetState;
            this.enableRepostToFollowing = enableRepostToFollowing;
            this.enableRepostWithSource = enableRepostWithSource;
            this.repostMainText = repostMainText;
            this.repostTitleText = repostTitleText;
            this.selectedTribee = pair;
            this.selectedPartition = pair2;
            this.enableClickPageRepost = enableClickPageRepost;
            this.hasLoadedSelectTribeeBottomSheet = hasLoadedSelectTribeeBottomSheet;
        }

        public /* synthetic */ TribeeRepostContentState(TribeeRepostUIAction tribeeRepostUIAction, KRepostOpus2TribeeOptionsResp kRepostOpus2TribeeOptionsResp, IntroBottomSheetState introBottomSheetState, boolean z, EditTextBottomSheetState editTextBottomSheetState, EditTextBottomSheetState editTextBottomSheetState2, boolean z2, boolean z3, String str, String str2, Pair pair, Pair pair2, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : tribeeRepostUIAction, kRepostOpus2TribeeOptionsResp, (i & 4) != 0 ? null : introBottomSheetState, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : editTextBottomSheetState, (i & 32) != 0 ? null : editTextBottomSheetState2, (i & 64) != 0 ? true : z2, (i & 128) != 0 ? true : z3, (i & 256) != 0 ? "" : str, (i & 512) != 0 ? "" : str2, pair, (i & 2048) != 0 ? TuplesKt.to(null, null) : pair2, (i & 4096) != 0 ? true : z4, (i & 8192) != 0 ? false : z5);
        }

        @Override // kntr.app.tribee.repost.state.TribeeRepostState
        public TribeeRepostUIAction getUiAction() {
            return this.uiAction;
        }

        public final KRepostOpus2TribeeOptionsResp getData() {
            return this.data;
        }

        public final IntroBottomSheetState getIntroBottomSheetState() {
            return this.introBottomSheetState;
        }

        public final boolean getShowSelectTribeeBottomSheet() {
            return this.showSelectTribeeBottomSheet;
        }

        public final EditTextBottomSheetState getEditRepostMainTextBottomSheetState() {
            return this.editRepostMainTextBottomSheetState;
        }

        public final EditTextBottomSheetState getEditRepostTitleTextBottomSheetState() {
            return this.editRepostTitleTextBottomSheetState;
        }

        public final boolean getEnableRepostToFollowing() {
            return this.enableRepostToFollowing;
        }

        public final boolean getEnableRepostWithSource() {
            return this.enableRepostWithSource;
        }

        public final String getRepostMainText() {
            return this.repostMainText;
        }

        public final String getRepostTitleText() {
            return this.repostTitleText;
        }

        public final Pair<Long, String> getSelectedTribee() {
            return this.selectedTribee;
        }

        public final Pair<Long, String> getSelectedPartition() {
            return this.selectedPartition;
        }

        public final boolean getEnableClickPageRepost() {
            return this.enableClickPageRepost;
        }

        public final boolean getHasLoadedSelectTribeeBottomSheet() {
            return this.hasLoadedSelectTribeeBottomSheet;
        }
    }
}