package kntr.app.tribee.operation.viewmodel.state;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSendInviteCodeOptionsResp;
import kntr.app.tribee.operation.viewmodel.TribeeOperationUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeOperationState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\u001f\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState;", "", "uiAction", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;", "selectedTribeeId", "", "<init>", "(Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;Ljava/lang/Long;)V", "getUiAction", "()Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;", "getSelectedTribeeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "TribeeOperationInitiateState", "TribeeOperationContentState", "TribeeOperationErrorState", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState$TribeeOperationContentState;", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState$TribeeOperationErrorState;", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState$TribeeOperationInitiateState;", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class TribeeOperationState {
    public static final int $stable = 0;
    private final Long selectedTribeeId;
    private final TribeeOperationUIAction uiAction;

    public /* synthetic */ TribeeOperationState(TribeeOperationUIAction tribeeOperationUIAction, Long l, DefaultConstructorMarker defaultConstructorMarker) {
        this(tribeeOperationUIAction, l);
    }

    private TribeeOperationState(TribeeOperationUIAction uiAction, Long selectedTribeeId) {
        this.uiAction = uiAction;
        this.selectedTribeeId = selectedTribeeId;
    }

    public /* synthetic */ TribeeOperationState(TribeeOperationUIAction tribeeOperationUIAction, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tribeeOperationUIAction, l, null);
    }

    public TribeeOperationUIAction getUiAction() {
        return this.uiAction;
    }

    public Long getSelectedTribeeId() {
        return this.selectedTribeeId;
    }

    /* compiled from: TribeeOperationState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState$TribeeOperationInitiateState;", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState;", "selectedTribeeId", "", "<init>", "(Ljava/lang/Long;)V", "getSelectedTribeeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState$TribeeOperationInitiateState;", "equals", "", "other", "", "hashCode", "", "toString", "", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TribeeOperationInitiateState extends TribeeOperationState {
        public static final int $stable = 0;
        private final Long selectedTribeeId;

        public static /* synthetic */ TribeeOperationInitiateState copy$default(TribeeOperationInitiateState tribeeOperationInitiateState, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                l = tribeeOperationInitiateState.selectedTribeeId;
            }
            return tribeeOperationInitiateState.copy(l);
        }

        public final Long component1() {
            return this.selectedTribeeId;
        }

        public final TribeeOperationInitiateState copy(Long l) {
            return new TribeeOperationInitiateState(l);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TribeeOperationInitiateState) && Intrinsics.areEqual(this.selectedTribeeId, ((TribeeOperationInitiateState) obj).selectedTribeeId);
        }

        public int hashCode() {
            if (this.selectedTribeeId == null) {
                return 0;
            }
            return this.selectedTribeeId.hashCode();
        }

        public String toString() {
            return "TribeeOperationInitiateState(selectedTribeeId=" + this.selectedTribeeId + ")";
        }

        public TribeeOperationInitiateState(Long selectedTribeeId) {
            super(null, selectedTribeeId, 1, null);
            this.selectedTribeeId = selectedTribeeId;
        }

        @Override // kntr.app.tribee.operation.viewmodel.state.TribeeOperationState
        public Long getSelectedTribeeId() {
            return this.selectedTribeeId;
        }
    }

    /* compiled from: TribeeOperationState.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J?\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState$TribeeOperationContentState;", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState;", "uiAction", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;", "pageContent", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp;", "selectedSendTypeItem", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KInviteTypeItem;", "selectedSendCount", "", "selectedTribee", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KTribeeSelectItem;", "<init>", "(Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KInviteTypeItem;JLcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KTribeeSelectItem;)V", "getUiAction", "()Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;", "getPageContent", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp;", "getSelectedSendTypeItem", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KInviteTypeItem;", "getSelectedSendCount", "()J", "getSelectedTribee", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KTribeeSelectItem;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TribeeOperationContentState extends TribeeOperationState {
        public static final int $stable = 0;
        private final KTribeeSendInviteCodeOptionsResp pageContent;
        private final long selectedSendCount;
        private final KTribeeSendInviteCodeOptionsResp.KInviteTypeItem selectedSendTypeItem;
        private final KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem selectedTribee;
        private final TribeeOperationUIAction uiAction;

        public static /* synthetic */ TribeeOperationContentState copy$default(TribeeOperationContentState tribeeOperationContentState, TribeeOperationUIAction tribeeOperationUIAction, KTribeeSendInviteCodeOptionsResp kTribeeSendInviteCodeOptionsResp, KTribeeSendInviteCodeOptionsResp.KInviteTypeItem kInviteTypeItem, long j, KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem kTribeeSelectItem, int i, Object obj) {
            if ((i & 1) != 0) {
                tribeeOperationUIAction = tribeeOperationContentState.uiAction;
            }
            if ((i & 2) != 0) {
                kTribeeSendInviteCodeOptionsResp = tribeeOperationContentState.pageContent;
            }
            KTribeeSendInviteCodeOptionsResp kTribeeSendInviteCodeOptionsResp2 = kTribeeSendInviteCodeOptionsResp;
            if ((i & 4) != 0) {
                kInviteTypeItem = tribeeOperationContentState.selectedSendTypeItem;
            }
            KTribeeSendInviteCodeOptionsResp.KInviteTypeItem kInviteTypeItem2 = kInviteTypeItem;
            if ((i & 8) != 0) {
                j = tribeeOperationContentState.selectedSendCount;
            }
            long j2 = j;
            if ((i & 16) != 0) {
                kTribeeSelectItem = tribeeOperationContentState.selectedTribee;
            }
            return tribeeOperationContentState.copy(tribeeOperationUIAction, kTribeeSendInviteCodeOptionsResp2, kInviteTypeItem2, j2, kTribeeSelectItem);
        }

        public final TribeeOperationUIAction component1() {
            return this.uiAction;
        }

        public final KTribeeSendInviteCodeOptionsResp component2() {
            return this.pageContent;
        }

        public final KTribeeSendInviteCodeOptionsResp.KInviteTypeItem component3() {
            return this.selectedSendTypeItem;
        }

        public final long component4() {
            return this.selectedSendCount;
        }

        public final KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem component5() {
            return this.selectedTribee;
        }

        public final TribeeOperationContentState copy(TribeeOperationUIAction tribeeOperationUIAction, KTribeeSendInviteCodeOptionsResp kTribeeSendInviteCodeOptionsResp, KTribeeSendInviteCodeOptionsResp.KInviteTypeItem kInviteTypeItem, long j, KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem kTribeeSelectItem) {
            Intrinsics.checkNotNullParameter(kTribeeSendInviteCodeOptionsResp, "pageContent");
            Intrinsics.checkNotNullParameter(kInviteTypeItem, "selectedSendTypeItem");
            return new TribeeOperationContentState(tribeeOperationUIAction, kTribeeSendInviteCodeOptionsResp, kInviteTypeItem, j, kTribeeSelectItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TribeeOperationContentState) {
                TribeeOperationContentState tribeeOperationContentState = (TribeeOperationContentState) obj;
                return Intrinsics.areEqual(this.uiAction, tribeeOperationContentState.uiAction) && Intrinsics.areEqual(this.pageContent, tribeeOperationContentState.pageContent) && Intrinsics.areEqual(this.selectedSendTypeItem, tribeeOperationContentState.selectedSendTypeItem) && this.selectedSendCount == tribeeOperationContentState.selectedSendCount && Intrinsics.areEqual(this.selectedTribee, tribeeOperationContentState.selectedTribee);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((this.uiAction == null ? 0 : this.uiAction.hashCode()) * 31) + this.pageContent.hashCode()) * 31) + this.selectedSendTypeItem.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.selectedSendCount)) * 31) + (this.selectedTribee != null ? this.selectedTribee.hashCode() : 0);
        }

        public String toString() {
            TribeeOperationUIAction tribeeOperationUIAction = this.uiAction;
            KTribeeSendInviteCodeOptionsResp kTribeeSendInviteCodeOptionsResp = this.pageContent;
            KTribeeSendInviteCodeOptionsResp.KInviteTypeItem kInviteTypeItem = this.selectedSendTypeItem;
            long j = this.selectedSendCount;
            return "TribeeOperationContentState(uiAction=" + tribeeOperationUIAction + ", pageContent=" + kTribeeSendInviteCodeOptionsResp + ", selectedSendTypeItem=" + kInviteTypeItem + ", selectedSendCount=" + j + ", selectedTribee=" + this.selectedTribee + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TribeeOperationContentState(TribeeOperationUIAction uiAction, KTribeeSendInviteCodeOptionsResp pageContent, KTribeeSendInviteCodeOptionsResp.KInviteTypeItem selectedSendTypeItem, long selectedSendCount, KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem selectedTribee) {
            super(null, selectedTribee != null ? Long.valueOf(selectedTribee.getId()) : null, 1, null);
            Intrinsics.checkNotNullParameter(pageContent, "pageContent");
            Intrinsics.checkNotNullParameter(selectedSendTypeItem, "selectedSendTypeItem");
            this.uiAction = uiAction;
            this.pageContent = pageContent;
            this.selectedSendTypeItem = selectedSendTypeItem;
            this.selectedSendCount = selectedSendCount;
            this.selectedTribee = selectedTribee;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ TribeeOperationContentState(TribeeOperationUIAction tribeeOperationUIAction, KTribeeSendInviteCodeOptionsResp kTribeeSendInviteCodeOptionsResp, KTribeeSendInviteCodeOptionsResp.KInviteTypeItem kInviteTypeItem, long j, KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem kTribeeSelectItem, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(r1, kTribeeSendInviteCodeOptionsResp, kInviteTypeItem, j, kTribeeSelectItem);
            TribeeOperationUIAction tribeeOperationUIAction2;
            if ((i & 1) == 0) {
                tribeeOperationUIAction2 = tribeeOperationUIAction;
            } else {
                tribeeOperationUIAction2 = null;
            }
        }

        @Override // kntr.app.tribee.operation.viewmodel.state.TribeeOperationState
        public TribeeOperationUIAction getUiAction() {
            return this.uiAction;
        }

        public final KTribeeSendInviteCodeOptionsResp getPageContent() {
            return this.pageContent;
        }

        public final KTribeeSendInviteCodeOptionsResp.KInviteTypeItem getSelectedSendTypeItem() {
            return this.selectedSendTypeItem;
        }

        public final long getSelectedSendCount() {
            return this.selectedSendCount;
        }

        public final KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem getSelectedTribee() {
            return this.selectedTribee;
        }
    }

    /* compiled from: TribeeOperationState.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState$TribeeOperationErrorState;", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState;", "selectedTribeeId", "", "uiAction", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;", "<init>", "(Ljava/lang/Long;Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;)V", "getSelectedTribeeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUiAction", "()Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;", "component1", "component2", "copy", "(Ljava/lang/Long;Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;)Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState$TribeeOperationErrorState;", "equals", "", "other", "", "hashCode", "", "toString", "", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TribeeOperationErrorState extends TribeeOperationState {
        public static final int $stable = 0;
        private final Long selectedTribeeId;
        private final TribeeOperationUIAction uiAction;

        public static /* synthetic */ TribeeOperationErrorState copy$default(TribeeOperationErrorState tribeeOperationErrorState, Long l, TribeeOperationUIAction tribeeOperationUIAction, int i, Object obj) {
            if ((i & 1) != 0) {
                l = tribeeOperationErrorState.selectedTribeeId;
            }
            if ((i & 2) != 0) {
                tribeeOperationUIAction = tribeeOperationErrorState.uiAction;
            }
            return tribeeOperationErrorState.copy(l, tribeeOperationUIAction);
        }

        public final Long component1() {
            return this.selectedTribeeId;
        }

        public final TribeeOperationUIAction component2() {
            return this.uiAction;
        }

        public final TribeeOperationErrorState copy(Long l, TribeeOperationUIAction tribeeOperationUIAction) {
            return new TribeeOperationErrorState(l, tribeeOperationUIAction);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TribeeOperationErrorState) {
                TribeeOperationErrorState tribeeOperationErrorState = (TribeeOperationErrorState) obj;
                return Intrinsics.areEqual(this.selectedTribeeId, tribeeOperationErrorState.selectedTribeeId) && Intrinsics.areEqual(this.uiAction, tribeeOperationErrorState.uiAction);
            }
            return false;
        }

        public int hashCode() {
            return ((this.selectedTribeeId == null ? 0 : this.selectedTribeeId.hashCode()) * 31) + (this.uiAction != null ? this.uiAction.hashCode() : 0);
        }

        public String toString() {
            Long l = this.selectedTribeeId;
            return "TribeeOperationErrorState(selectedTribeeId=" + l + ", uiAction=" + this.uiAction + ")";
        }

        public TribeeOperationErrorState(Long selectedTribeeId, TribeeOperationUIAction uiAction) {
            super(null, selectedTribeeId, 1, null);
            this.selectedTribeeId = selectedTribeeId;
            this.uiAction = uiAction;
        }

        public /* synthetic */ TribeeOperationErrorState(Long l, TribeeOperationUIAction tribeeOperationUIAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(l, (i & 2) != 0 ? null : tribeeOperationUIAction);
        }

        @Override // kntr.app.tribee.operation.viewmodel.state.TribeeOperationState
        public Long getSelectedTribeeId() {
            return this.selectedTribeeId;
        }

        @Override // kntr.app.tribee.operation.viewmodel.state.TribeeOperationState
        public TribeeOperationUIAction getUiAction() {
            return this.uiAction;
        }
    }
}