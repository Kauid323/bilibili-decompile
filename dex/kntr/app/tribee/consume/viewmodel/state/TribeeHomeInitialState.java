package kntr.app.tribee.consume.viewmodel.state;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import java.util.Set;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeHomeState.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeInitialState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "uiAction", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "observedRequestingActions", "", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "categoryId", "", "autoCheckJoin", "", "<init>", "(Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;Ljava/util/Set;JZ)V", "getUiAction", "()Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "getObservedRequestingActions", "()Ljava/util/Set;", "getCategoryId", "()J", "getAutoCheckJoin", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeHomeInitialState extends TribeeHomeState {
    public static final int $stable = 0;
    private final boolean autoCheckJoin;
    private final long categoryId;
    private final Set<TribeeHomeStateAction> observedRequestingActions;
    private final TribeeHomeUIAction uiAction;

    public TribeeHomeInitialState() {
        this(null, null, 0L, false, 15, null);
    }

    public static /* synthetic */ TribeeHomeInitialState copy$default(TribeeHomeInitialState tribeeHomeInitialState, TribeeHomeUIAction tribeeHomeUIAction, Set set, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            tribeeHomeUIAction = tribeeHomeInitialState.uiAction;
        }
        Set<TribeeHomeStateAction> set2 = set;
        if ((i & 2) != 0) {
            set2 = tribeeHomeInitialState.observedRequestingActions;
        }
        Set set3 = set2;
        if ((i & 4) != 0) {
            j = tribeeHomeInitialState.categoryId;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            z = tribeeHomeInitialState.autoCheckJoin;
        }
        return tribeeHomeInitialState.copy(tribeeHomeUIAction, set3, j2, z);
    }

    public final TribeeHomeUIAction component1() {
        return this.uiAction;
    }

    public final Set<TribeeHomeStateAction> component2() {
        return this.observedRequestingActions;
    }

    public final long component3() {
        return this.categoryId;
    }

    public final boolean component4() {
        return this.autoCheckJoin;
    }

    public final TribeeHomeInitialState copy(TribeeHomeUIAction tribeeHomeUIAction, Set<? extends TribeeHomeStateAction> set, long j, boolean z) {
        Intrinsics.checkNotNullParameter(set, "observedRequestingActions");
        return new TribeeHomeInitialState(tribeeHomeUIAction, set, j, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TribeeHomeInitialState) {
            TribeeHomeInitialState tribeeHomeInitialState = (TribeeHomeInitialState) obj;
            return Intrinsics.areEqual(this.uiAction, tribeeHomeInitialState.uiAction) && Intrinsics.areEqual(this.observedRequestingActions, tribeeHomeInitialState.observedRequestingActions) && this.categoryId == tribeeHomeInitialState.categoryId && this.autoCheckJoin == tribeeHomeInitialState.autoCheckJoin;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.uiAction == null ? 0 : this.uiAction.hashCode()) * 31) + this.observedRequestingActions.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.categoryId)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.autoCheckJoin);
    }

    public String toString() {
        TribeeHomeUIAction tribeeHomeUIAction = this.uiAction;
        Set<TribeeHomeStateAction> set = this.observedRequestingActions;
        long j = this.categoryId;
        return "TribeeHomeInitialState(uiAction=" + tribeeHomeUIAction + ", observedRequestingActions=" + set + ", categoryId=" + j + ", autoCheckJoin=" + this.autoCheckJoin + ")";
    }

    public /* synthetic */ TribeeHomeInitialState(TribeeHomeUIAction tribeeHomeUIAction, Set set, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tribeeHomeUIAction, (i & 2) != 0 ? SetsKt.emptySet() : set, (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? false : z);
    }

    @Override // kntr.app.tribee.consume.viewmodel.state.TribeeHomeState
    public TribeeHomeUIAction getUiAction() {
        return this.uiAction;
    }

    @Override // kntr.app.tribee.consume.viewmodel.state.TribeeHomeState
    public Set<TribeeHomeStateAction> getObservedRequestingActions() {
        return this.observedRequestingActions;
    }

    @Override // kntr.app.tribee.consume.viewmodel.state.TribeeHomeState
    public long getCategoryId() {
        return this.categoryId;
    }

    public final boolean getAutoCheckJoin() {
        return this.autoCheckJoin;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeHomeInitialState(TribeeHomeUIAction uiAction, Set<? extends TribeeHomeStateAction> set, long categoryId, boolean autoCheckJoin) {
        super(categoryId, null, null, SetsKt.setOf(TribeeHomeStateAction.Initial.INSTANCE), 6, null);
        Intrinsics.checkNotNullParameter(set, "observedRequestingActions");
        this.uiAction = uiAction;
        this.observedRequestingActions = set;
        this.categoryId = categoryId;
        this.autoCheckJoin = autoCheckJoin;
    }
}