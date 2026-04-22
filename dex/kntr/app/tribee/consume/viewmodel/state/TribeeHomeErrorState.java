package kntr.app.tribee.consume.viewmodel.state;

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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeErrorState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "uiAction", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "observedRequestingActions", "", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "categoryId", "", "<init>", "(Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;Ljava/util/Set;J)V", "getUiAction", "()Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "getObservedRequestingActions", "()Ljava/util/Set;", "getCategoryId", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeHomeErrorState extends TribeeHomeState {
    public static final int $stable = 0;
    private final long categoryId;
    private final Set<TribeeHomeStateAction> observedRequestingActions;
    private final TribeeHomeUIAction uiAction;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TribeeHomeErrorState copy$default(TribeeHomeErrorState tribeeHomeErrorState, TribeeHomeUIAction tribeeHomeUIAction, Set set, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            tribeeHomeUIAction = tribeeHomeErrorState.uiAction;
        }
        if ((i & 2) != 0) {
            set = tribeeHomeErrorState.observedRequestingActions;
        }
        if ((i & 4) != 0) {
            j = tribeeHomeErrorState.categoryId;
        }
        return tribeeHomeErrorState.copy(tribeeHomeUIAction, set, j);
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

    public final TribeeHomeErrorState copy(TribeeHomeUIAction tribeeHomeUIAction, Set<? extends TribeeHomeStateAction> set, long j) {
        Intrinsics.checkNotNullParameter(set, "observedRequestingActions");
        return new TribeeHomeErrorState(tribeeHomeUIAction, set, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TribeeHomeErrorState) {
            TribeeHomeErrorState tribeeHomeErrorState = (TribeeHomeErrorState) obj;
            return Intrinsics.areEqual(this.uiAction, tribeeHomeErrorState.uiAction) && Intrinsics.areEqual(this.observedRequestingActions, tribeeHomeErrorState.observedRequestingActions) && this.categoryId == tribeeHomeErrorState.categoryId;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.uiAction == null ? 0 : this.uiAction.hashCode()) * 31) + this.observedRequestingActions.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.categoryId);
    }

    public String toString() {
        TribeeHomeUIAction tribeeHomeUIAction = this.uiAction;
        Set<TribeeHomeStateAction> set = this.observedRequestingActions;
        return "TribeeHomeErrorState(uiAction=" + tribeeHomeUIAction + ", observedRequestingActions=" + set + ", categoryId=" + this.categoryId + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeHomeErrorState(TribeeHomeUIAction uiAction, Set<? extends TribeeHomeStateAction> set, long categoryId) {
        super(categoryId, null, null, null, 14, null);
        Intrinsics.checkNotNullParameter(set, "observedRequestingActions");
        this.uiAction = uiAction;
        this.observedRequestingActions = set;
        this.categoryId = categoryId;
    }

    public /* synthetic */ TribeeHomeErrorState(TribeeHomeUIAction tribeeHomeUIAction, Set set, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tribeeHomeUIAction, (i & 2) != 0 ? SetsKt.emptySet() : set, j);
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
}