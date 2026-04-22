package kntr.app.tribee.consume.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KNavigationEntry;
import com.bapis.bilibili.app.dynamic.v2.KNavigationEntryBasicInfo;
import com.bapis.bilibili.app.dynamic.v2.KNavigationEntryInviteCode;
import com.bapis.bilibili.app.dynamic.v2.KNavigationType;
import com.bapis.bilibili.app.dynamic.v2.KTribeeBaseInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDesc;
import com.bapis.bilibili.app.dynamic.v2.KTribeeNavigation;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchBar;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.service.TribeeHomeDataService;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "action", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ReportNotification;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$9", f = "TribeeHomeStateMachine.kt", i = {0, 0}, l = {512}, m = "invokeSuspend", n = {"action", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class TribeeHomeStateMachine$1$2$9 extends SuspendLambda implements Function3<TribeeHomeStateAction.ReportNotification, State<TribeeHomeContentState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ TribeeHomeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomeStateMachine$1$2$9(TribeeHomeStateMachine tribeeHomeStateMachine, Continuation<? super TribeeHomeStateMachine$1$2$9> continuation) {
        super(3, continuation);
        this.this$0 = tribeeHomeStateMachine;
    }

    public final Object invoke(TribeeHomeStateAction.ReportNotification reportNotification, State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$1$2$9 tribeeHomeStateMachine$1$2$9 = new TribeeHomeStateMachine$1$2$9(this.this$0, continuation);
        tribeeHomeStateMachine$1$2$9.L$0 = reportNotification;
        tribeeHomeStateMachine$1$2$9.L$1 = state;
        return tribeeHomeStateMachine$1$2$9.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeeHomeDataService tribeeHomeDataService;
        final TribeeHomeStateAction.ReportNotification action = (TribeeHomeStateAction.ReportNotification) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    tribeeHomeDataService = this.this$0.dataService;
                    boolean fromBubble = action.getFromBubble();
                    boolean inHomePage = action.getInHomePage();
                    boolean z = !action.getInHomePage();
                    this.L$0 = action;
                    this.L$1 = state;
                    this.label = 1;
                    if (tribeeHomeDataService.inviteCodeFeedback(fromBubble, inHomePage, z, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$9$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    TribeeHomeContentState invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$9.invokeSuspend$lambda$0(TribeeHomeStateAction.ReportNotification.this, (TribeeHomeContentState) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "report red dot has error! (" + e.getMessage() + ")");
            return state.noChange();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$0(TribeeHomeStateAction.ReportNotification $action, TribeeHomeContentState $this$mutate) {
        List navEntries;
        KTribeeBaseInfo kTribeeBaseInfo;
        TribeeHomeContentState copy;
        boolean isNewCodeRedDot;
        Iterable navEntries2;
        KTribeeBaseInfo base = $this$mutate.getBaseInfo();
        KTribeeNavigation kTribeeNavigation = null;
        if (!$action.getInHomePage()) {
            KTribeeNavigation navigation = $this$mutate.getNavigation();
            if (navigation == null || (navEntries2 = navigation.getNavEntries()) == null) {
                navEntries = null;
            } else {
                Iterable $this$map$iv = navEntries2;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    KNavigationEntry it = (KNavigationEntry) item$iv$iv;
                    KNavigationEntry.KInviteCode data = it.getData();
                    KNavigationEntry.KInviteCode inviteData = data instanceof KNavigationEntry.KInviteCode ? data : null;
                    destination$iv$iv.add(inviteData != null ? KNavigationEntry.copy$default(it, (KNavigationType) null, (KNavigationEntryBasicInfo) null, inviteData.copy(KNavigationEntryInviteCode.copy$default(inviteData.getValue(), false, 0L, 2, (Object) null)), 3, (Object) null) : it);
                }
                navEntries = (List) destination$iv$iv;
            }
        } else {
            KTribeeNavigation navigation2 = $this$mutate.getNavigation();
            navEntries = navigation2 != null ? navigation2.getNavEntries() : null;
        }
        List navEntries3 = navEntries;
        if (base != null) {
            boolean isNewCodePopup = $action.getFromBubble() ? false : base.isNewCodePopup();
            if (!$action.getFromBubble() && $action.getInHomePage()) {
                isNewCodeRedDot = false;
            } else {
                isNewCodeRedDot = base.isNewCodeRedDot();
            }
            kTribeeBaseInfo = KTribeeBaseInfo.copy$default(base, (KTribeeDesc) null, false, isNewCodePopup, isNewCodeRedDot, (String) null, (KTribeeSearchBar) null, 51, (Object) null);
        } else {
            kTribeeBaseInfo = null;
        }
        KTribeeNavigation navigation3 = $this$mutate.getNavigation();
        if (navigation3 != null) {
            kTribeeNavigation = navigation3.copy(navEntries3 == null ? CollectionsKt.emptyList() : navEntries3);
        }
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : kTribeeBaseInfo, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : kTribeeNavigation, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : null, (r20 & 128) != 0 ? $this$mutate.uiAction : null);
        return copy;
    }
}