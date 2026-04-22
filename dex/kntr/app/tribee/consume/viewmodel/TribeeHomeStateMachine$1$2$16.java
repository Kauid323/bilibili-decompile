package kntr.app.tribee.consume.viewmodel;

import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KAppMineRcmd;
import com.bapis.bilibili.app.dynamic.v2.KFootHoverToast;
import com.bapis.bilibili.app.dynamic.v2.KNavigationEntry;
import com.bapis.bilibili.app.dynamic.v2.KNavigationEntryBasicInfo;
import com.bapis.bilibili.app.dynamic.v2.KNavigationEntryDisplayAppMine;
import com.bapis.bilibili.app.dynamic.v2.KNavigationType;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInteraction;
import com.bapis.bilibili.app.dynamic.v2.KTribeeNavigation;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.tribee.consume.TribeePreference;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeUIAction;
import kntr.app.tribee.consume.viewmodel.service.TribeeHomeDataService;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeState;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "action", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$SwitchRevisitSettings;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$16", f = "TribeeHomeStateMachine.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {683, 692, 694}, m = "invokeSuspend", n = {"action", "state", "action", "state", "guide", "action", "state", "guide"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
public final class TribeeHomeStateMachine$1$2$16 extends SuspendLambda implements Function3<TribeeHomeStateAction.SwitchRevisitSettings, State<TribeeHomeContentState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TribeeHomeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomeStateMachine$1$2$16(TribeeHomeStateMachine tribeeHomeStateMachine, Continuation<? super TribeeHomeStateMachine$1$2$16> continuation) {
        super(3, continuation);
        this.this$0 = tribeeHomeStateMachine;
    }

    public final Object invoke(TribeeHomeStateAction.SwitchRevisitSettings switchRevisitSettings, State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$1$2$16 tribeeHomeStateMachine$1$2$16 = new TribeeHomeStateMachine$1$2$16(this.this$0, continuation);
        tribeeHomeStateMachine$1$2$16.L$0 = switchRevisitSettings;
        tribeeHomeStateMachine$1$2$16.L$1 = state;
        return tribeeHomeStateMachine$1$2$16.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeeHomeDataService tribeeHomeDataService;
        Object string;
        final KFootHoverToast guide;
        Object string2;
        KAppMineRcmd appMineRcmd;
        String str;
        final TribeeHomeStateAction.SwitchRevisitSettings action = (TribeeHomeStateAction.SwitchRevisitSettings) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    tribeeHomeDataService = this.this$0.dataService;
                    this.L$0 = action;
                    this.L$1 = state;
                    this.label = 1;
                    if (tribeeHomeDataService.switchRevisitSettings(action.getChecked(), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                case 2:
                    guide = (KFootHoverToast) this.L$2;
                    ResultKt.throwOnFailure($result);
                    string2 = $result;
                    str = (String) string2;
                    final String resultTips = str;
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$16$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            TribeeHomeContentState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$16.invokeSuspend$lambda$0(guide, action, resultTips, (TribeeHomeContentState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                case 3:
                    guide = (KFootHoverToast) this.L$2;
                    ResultKt.throwOnFailure($result);
                    string = $result;
                    str = (String) string;
                    final String resultTips2 = str;
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$16$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            TribeeHomeContentState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$16.invokeSuspend$lambda$0(guide, action, resultTips2, (TribeeHomeContentState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            KTribeeInteraction interaction = ((TribeeHomeContentState) state.getSnapshot()).getInteraction();
            KFootHoverToast guide2 = (interaction == null || (appMineRcmd = interaction.getAppMineRcmd()) == null) ? null : appMineRcmd.getFirstAdd();
            if (action.getChecked()) {
                this.L$0 = action;
                this.L$1 = state;
                this.L$2 = guide2;
                this.label = 2;
                string2 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_42(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                guide = guide2;
                str = (String) string2;
                final String resultTips22 = str;
                return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$16$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeHomeContentState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$16.invokeSuspend$lambda$0(guide, action, resultTips22, (TribeeHomeContentState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            }
            this.L$0 = action;
            this.L$1 = state;
            this.L$2 = guide2;
            this.label = 3;
            string = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_43(TribeeRes.INSTANCE.getString()), (Continuation) this);
            if (string == coroutine_suspended) {
                return coroutine_suspended;
            }
            guide = guide2;
            str = (String) string;
            final String resultTips222 = str;
            return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$16$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    TribeeHomeContentState invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$16.invokeSuspend$lambda$0(guide, action, resultTips222, (TribeeHomeContentState) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "switch revisit settings occur error!", e);
            return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$16$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    TribeeHomeContentState invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = TribeeHomeStateMachine$1$2$16.invokeSuspend$lambda$1(e, action, (TribeeHomeContentState) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$0(KFootHoverToast $guide, TribeeHomeStateAction.SwitchRevisitSettings $action, String $resultTips, TribeeHomeContentState $this$mutate) {
        TribeeHomeUIAction toastTips;
        TribeeHomeContentState copy;
        KNavigationEntry kNavigationEntry;
        KTribeeNavigation navigation = $this$mutate.getNavigation();
        KTribeeNavigation kTribeeNavigation = null;
        if (navigation != null) {
            Iterable $this$map$iv = $this$mutate.getNavigation().getNavEntries();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                KNavigationEntry it = (KNavigationEntry) item$iv$iv;
                if (Intrinsics.areEqual(it.getNavigationType(), KNavigationType.DISPLAY_APP_MINE.INSTANCE)) {
                    KNavigationEntry.KDisplayAppMine data = it.getData();
                    KNavigationEntry.KDisplayAppMine data2 = data instanceof KNavigationEntry.KDisplayAppMine ? data : null;
                    kNavigationEntry = KNavigationEntry.copy$default(it, (KNavigationType) null, (KNavigationEntryBasicInfo) null, data2 != null ? data2.copy(new KNavigationEntryDisplayAppMine($action.getChecked())) : null, 3, (Object) null);
                } else {
                    kNavigationEntry = it;
                }
                destination$iv$iv.add(kNavigationEntry);
            }
            kTribeeNavigation = navigation.copy((List) destination$iv$iv);
        }
        KTribeeNavigation kTribeeNavigation2 = kTribeeNavigation;
        if ($guide != null && TribeePreference.INSTANCE.getShowRevisitGuide() && $action.getChecked()) {
            toastTips = new TribeeHomeUIAction.ShowRevisitGuide($guide);
        } else {
            toastTips = new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create($resultTips));
        }
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : kTribeeNavigation2, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : null, (r20 & 128) != 0 ? $this$mutate.uiAction : toastTips);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$1(Exception $e, TribeeHomeStateAction.SwitchRevisitSettings $action, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : $this$mutate.removeIfObservedAction($action), (r20 & 128) != 0 ? $this$mutate.uiAction : new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, $e, null, 2, null)));
        return copy;
    }
}