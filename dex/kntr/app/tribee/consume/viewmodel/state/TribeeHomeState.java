package kntr.app.tribee.consume.viewmodel.state;

import java.util.Set;
import kntr.app.tribee.consume.page.model.TribeeFetchModel;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: TribeeHomeState.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B7\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u0082\u0001\u0003\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "", "categoryId", "", "fetchModel", "Lkntr/app/tribee/consume/page/model/TribeeFetchModel;", "uiAction", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "observedRequestingActions", "", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "<init>", "(JLkntr/app/tribee/consume/page/model/TribeeFetchModel;Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;Ljava/util/Set;)V", "getCategoryId", "()J", "getFetchModel", "()Lkntr/app/tribee/consume/page/model/TribeeFetchModel;", "getUiAction", "()Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "getObservedRequestingActions", "()Ljava/util/Set;", "removeIfObservedAction", "action", "insertActionAndRemoveAllConflicted", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeErrorState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeInitialState;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class TribeeHomeState {
    public static final int $stable = 0;
    private final long categoryId;
    private final TribeeFetchModel fetchModel;
    private final Set<TribeeHomeStateAction> observedRequestingActions;
    private final TribeeHomeUIAction uiAction;

    public /* synthetic */ TribeeHomeState(long j, TribeeFetchModel tribeeFetchModel, TribeeHomeUIAction tribeeHomeUIAction, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, tribeeFetchModel, tribeeHomeUIAction, set);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TribeeHomeState(long categoryId, TribeeFetchModel fetchModel, TribeeHomeUIAction uiAction, Set<? extends TribeeHomeStateAction> set) {
        this.categoryId = categoryId;
        this.fetchModel = fetchModel;
        this.uiAction = uiAction;
        this.observedRequestingActions = set;
    }

    public /* synthetic */ TribeeHomeState(long j, TribeeFetchModel tribeeFetchModel, TribeeHomeUIAction tribeeHomeUIAction, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? new TribeeFetchModel(null, 0, 3, null) : tribeeFetchModel, (i & 4) != 0 ? null : tribeeHomeUIAction, (i & 8) != 0 ? SetsKt.emptySet() : set, null);
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public TribeeFetchModel getFetchModel() {
        return this.fetchModel;
    }

    public TribeeHomeUIAction getUiAction() {
        return this.uiAction;
    }

    public Set<TribeeHomeStateAction> getObservedRequestingActions() {
        return this.observedRequestingActions;
    }

    public final Set<TribeeHomeStateAction> removeIfObservedAction(final TribeeHomeStateAction action) {
        boolean z = false;
        if (action != null && action.beObserved()) {
            z = true;
        }
        if (z) {
            Set $this$removeIfObservedAction_u24lambda_u240 = CollectionsKt.toMutableSet(getObservedRequestingActions());
            CollectionsKt.removeAll($this$removeIfObservedAction_u24lambda_u240, new Function1() { // from class: kntr.app.tribee.consume.viewmodel.state.TribeeHomeState$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    boolean removeIfObservedAction$lambda$0$0;
                    removeIfObservedAction$lambda$0$0 = TribeeHomeState.removeIfObservedAction$lambda$0$0(TribeeHomeStateAction.this, (TribeeHomeStateAction) obj);
                    return Boolean.valueOf(removeIfObservedAction$lambda$0$0);
                }
            });
            return $this$removeIfObservedAction_u24lambda_u240;
        }
        return getObservedRequestingActions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeIfObservedAction$lambda$0$0(TribeeHomeStateAction $action, TribeeHomeStateAction i) {
        Intrinsics.checkNotNullParameter(i, "i");
        return i.getClass() == $action.getClass();
    }

    public final Set<TribeeHomeStateAction> insertActionAndRemoveAllConflicted(final TribeeHomeStateAction action) {
        final Set conflictedActionClassSet;
        if (action == null || (conflictedActionClassSet = action.conflictedActionClassSet()) == null) {
            return getObservedRequestingActions();
        }
        Set $this$insertActionAndRemoveAllConflicted_u24lambda_u240 = CollectionsKt.toMutableSet(getObservedRequestingActions());
        CollectionsKt.removeAll($this$insertActionAndRemoveAllConflicted_u24lambda_u240, new Function1() { // from class: kntr.app.tribee.consume.viewmodel.state.TribeeHomeState$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean insertActionAndRemoveAllConflicted$lambda$0$0;
                insertActionAndRemoveAllConflicted$lambda$0$0 = TribeeHomeState.insertActionAndRemoveAllConflicted$lambda$0$0(conflictedActionClassSet, action, (TribeeHomeStateAction) obj);
                return Boolean.valueOf(insertActionAndRemoveAllConflicted$lambda$0$0);
            }
        });
        $this$insertActionAndRemoveAllConflicted_u24lambda_u240.add(action);
        return $this$insertActionAndRemoveAllConflicted_u24lambda_u240;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean insertActionAndRemoveAllConflicted$lambda$0$0(Set $conflictedActionClassSet, TribeeHomeStateAction $action, TribeeHomeStateAction i) {
        Intrinsics.checkNotNullParameter(i, "i");
        return $conflictedActionClassSet.contains(Reflection.getOrCreateKotlinClass(i.getClass())) || i.getClass() == $action.getClass();
    }
}