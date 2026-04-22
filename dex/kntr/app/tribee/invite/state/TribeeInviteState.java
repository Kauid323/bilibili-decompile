package kntr.app.tribee.invite.state;

import com.bapis.bilibili.app.dynamic.v2.KTribeeInviteCodeAllResp;
import kntr.app.tribee.invite.viewmodel.TribeeInviteUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeInviteState.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0015\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lkntr/app/tribee/invite/state/TribeeInviteState;", "", "uiAction", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;", "<init>", "(Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;)V", "getUiAction", "()Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;", "TribeeInviteInitiateState", "TribeeInviteErrorState", "TribeeInviteContentState", "Lkntr/app/tribee/invite/state/TribeeInviteState$TribeeInviteContentState;", "Lkntr/app/tribee/invite/state/TribeeInviteState$TribeeInviteErrorState;", "Lkntr/app/tribee/invite/state/TribeeInviteState$TribeeInviteInitiateState;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class TribeeInviteState {
    public static final int $stable = 0;
    private final TribeeInviteUIAction uiAction;

    public /* synthetic */ TribeeInviteState(TribeeInviteUIAction tribeeInviteUIAction, DefaultConstructorMarker defaultConstructorMarker) {
        this(tribeeInviteUIAction);
    }

    private TribeeInviteState(TribeeInviteUIAction uiAction) {
        this.uiAction = uiAction;
    }

    public /* synthetic */ TribeeInviteState(TribeeInviteUIAction tribeeInviteUIAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tribeeInviteUIAction, null);
    }

    public TribeeInviteUIAction getUiAction() {
        return this.uiAction;
    }

    /* compiled from: TribeeInviteState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/invite/state/TribeeInviteState$TribeeInviteInitiateState;", "Lkntr/app/tribee/invite/state/TribeeInviteState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TribeeInviteInitiateState extends TribeeInviteState {
        public static final int $stable = 0;
        public static final TribeeInviteInitiateState INSTANCE = new TribeeInviteInitiateState();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TribeeInviteInitiateState) {
                TribeeInviteInitiateState tribeeInviteInitiateState = (TribeeInviteInitiateState) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -627423850;
        }

        public String toString() {
            return "TribeeInviteInitiateState";
        }

        private TribeeInviteInitiateState() {
            super(null, 1, null);
        }
    }

    /* compiled from: TribeeInviteState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/invite/state/TribeeInviteState$TribeeInviteErrorState;", "Lkntr/app/tribee/invite/state/TribeeInviteState;", "uiAction", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;", "<init>", "(Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;)V", "getUiAction", "()Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TribeeInviteErrorState extends TribeeInviteState {
        public static final int $stable = 0;
        private final TribeeInviteUIAction uiAction;

        public TribeeInviteErrorState() {
            this(null, 1, null);
        }

        public static /* synthetic */ TribeeInviteErrorState copy$default(TribeeInviteErrorState tribeeInviteErrorState, TribeeInviteUIAction tribeeInviteUIAction, int i, Object obj) {
            if ((i & 1) != 0) {
                tribeeInviteUIAction = tribeeInviteErrorState.uiAction;
            }
            return tribeeInviteErrorState.copy(tribeeInviteUIAction);
        }

        public final TribeeInviteUIAction component1() {
            return this.uiAction;
        }

        public final TribeeInviteErrorState copy(TribeeInviteUIAction tribeeInviteUIAction) {
            return new TribeeInviteErrorState(tribeeInviteUIAction);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TribeeInviteErrorState) && Intrinsics.areEqual(this.uiAction, ((TribeeInviteErrorState) obj).uiAction);
        }

        public int hashCode() {
            if (this.uiAction == null) {
                return 0;
            }
            return this.uiAction.hashCode();
        }

        public String toString() {
            return "TribeeInviteErrorState(uiAction=" + this.uiAction + ")";
        }

        public TribeeInviteErrorState(TribeeInviteUIAction uiAction) {
            super(null, 1, null);
            this.uiAction = uiAction;
        }

        public /* synthetic */ TribeeInviteErrorState(TribeeInviteUIAction tribeeInviteUIAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : tribeeInviteUIAction);
        }

        @Override // kntr.app.tribee.invite.state.TribeeInviteState
        public TribeeInviteUIAction getUiAction() {
            return this.uiAction;
        }
    }

    /* compiled from: TribeeInviteState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/invite/state/TribeeInviteState$TribeeInviteContentState;", "Lkntr/app/tribee/invite/state/TribeeInviteState;", "data", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeAllResp;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeAllResp;)V", "getData", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeAllResp;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TribeeInviteContentState extends TribeeInviteState {
        public static final int $stable = 0;
        private final KTribeeInviteCodeAllResp data;

        public static /* synthetic */ TribeeInviteContentState copy$default(TribeeInviteContentState tribeeInviteContentState, KTribeeInviteCodeAllResp kTribeeInviteCodeAllResp, int i, Object obj) {
            if ((i & 1) != 0) {
                kTribeeInviteCodeAllResp = tribeeInviteContentState.data;
            }
            return tribeeInviteContentState.copy(kTribeeInviteCodeAllResp);
        }

        public final KTribeeInviteCodeAllResp component1() {
            return this.data;
        }

        public final TribeeInviteContentState copy(KTribeeInviteCodeAllResp kTribeeInviteCodeAllResp) {
            Intrinsics.checkNotNullParameter(kTribeeInviteCodeAllResp, "data");
            return new TribeeInviteContentState(kTribeeInviteCodeAllResp);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TribeeInviteContentState) && Intrinsics.areEqual(this.data, ((TribeeInviteContentState) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "TribeeInviteContentState(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TribeeInviteContentState(KTribeeInviteCodeAllResp data) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final KTribeeInviteCodeAllResp getData() {
            return this.data;
        }
    }
}