package tv.danmaku.bili.change;

import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.model.SimpleAccountItem;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AccountSwitchFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.change.AccountSwitchViewModel$handleAction$1", f = "AccountSwitchFragment.kt", i = {}, l = {BR.hallSubtitle, BR.newPageName}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AccountSwitchViewModel$handleAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ISwitchAction $action;
    int label;
    final /* synthetic */ AccountSwitchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountSwitchViewModel$handleAction$1(ISwitchAction iSwitchAction, AccountSwitchViewModel accountSwitchViewModel, Continuation<? super AccountSwitchViewModel$handleAction$1> continuation) {
        super(2, continuation);
        this.$action = iSwitchAction;
        this.this$0 = accountSwitchViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountSwitchViewModel$handleAction$1(this.$action, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableStateFlow mutableStateFlow;
        ActionResult actionResult;
        MutableStateFlow mutableStateFlow2;
        int i;
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!(this.$action instanceof IEventAction)) {
                    mutableStateFlow = this.this$0._pageState;
                    AccountSwitchPage current = (AccountSwitchPage) mutableStateFlow.getValue();
                    ISwitchAction iSwitchAction = this.$action;
                    if (iSwitchAction instanceof AccountListLoadedAction) {
                        Neurons.reportExposure$default(false, "main.change-account.0.0.show", (Map) null, (List) null, 12, (Object) null);
                        List infos = ((AccountListLoadedAction) this.$action).getAccountInfo().getInfos();
                        int maxUserSize = ((AccountListLoadedAction) this.$action).getAccountInfo().getMaxUserSize();
                        List $this$indexOfFirst$iv = ((AccountListLoadedAction) this.$action).getAccountInfo().getInfos();
                        AccountSwitchViewModel accountSwitchViewModel = this.this$0;
                        int index$iv = 0;
                        Iterator it = $this$indexOfFirst$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Object item$iv = it.next();
                                SimpleAccountItem it2 = (SimpleAccountItem) item$iv;
                                SimpleAccountItem it3 = it2.getMid() == BiliAccounts.get(accountSwitchViewModel.getApplication()).mid() ? 1 : null;
                                if (it3 != null) {
                                    i = index$iv;
                                } else {
                                    index$iv++;
                                }
                            } else {
                                i = -1;
                            }
                        }
                        actionResult = new ActionResult(AccountSwitchPage.copy$default(current, infos, false, maxUserSize, i, false, AccountLoadState.SUCCESS, 16, null), null, 2, null);
                    } else if (iSwitchAction instanceof AccountListLoadFailedAction) {
                        actionResult = new ActionResult(AccountSwitchPage.copy$default(current, null, false, 0, 0, false, current.getAccountLoadState() == AccountLoadState.LOADING ? AccountLoadState.ERROR : current.getAccountLoadState(), 31, null), new AccountSwitchViewModel$handleAction$1$result$2(this.$action, null));
                    } else if (iSwitchAction instanceof EditModeAction) {
                        Neurons.reportClick(false, "main.change-account.manage.0.click", MapsKt.mapOf(TuplesKt.to("type", ((EditModeAction) this.$action).getEditMode() ? "1" : "2")));
                        actionResult = new ActionResult(AccountSwitchPage.copy$default(current, null, ((EditModeAction) this.$action).getEditMode(), 0, 0, false, null, 61, null), null, 2, null);
                    } else if (iSwitchAction instanceof SwitchAccountAction) {
                        actionResult = new ActionResult(current, new AccountSwitchViewModel$handleAction$1$result$3(this.$action, null));
                    } else if (iSwitchAction instanceof SwitchAccountFinishedAction) {
                        actionResult = new ActionResult(current, new AccountSwitchViewModel$handleAction$1$result$4(this.$action, null));
                    } else if (Intrinsics.areEqual(iSwitchAction, LoadAccountListAction.INSTANCE)) {
                        actionResult = new ActionResult(current, new AccountSwitchViewModel$handleAction$1$result$5(this.this$0, null));
                    } else if (iSwitchAction instanceof LoadingAction) {
                        actionResult = new ActionResult(AccountSwitchPage.copy$default(current, null, false, 0, 0, ((LoadingAction) this.$action).getShow(), null, 47, null), null, 2, null);
                    } else if (iSwitchAction instanceof RemoveAccountAction) {
                        actionResult = new ActionResult(current, new AccountSwitchViewModel$handleAction$1$result$6(this.$action, null));
                    } else if (!(iSwitchAction instanceof RemoveFinishedAction)) {
                        actionResult = new ActionResult(current, null, 2, null);
                    } else if (((RemoveFinishedAction) this.$action).getError() == null) {
                        Iterable $this$filterNotTo$iv$iv = current.getAccountList();
                        ISwitchAction iSwitchAction2 = this.$action;
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$filterNotTo$iv$iv) {
                            SimpleAccountItem it4 = (SimpleAccountItem) element$iv$iv;
                            SimpleAccountItem it5 = it4.getMid() == ((RemoveFinishedAction) iSwitchAction2).getAccount().getMid() ? 1 : null;
                            if (it5 == null) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        actionResult = new ActionResult(AccountSwitchPage.copy$default(current, (List) destination$iv$iv, false, 0, 0, false, null, 62, null), null, 2, null);
                    } else {
                        actionResult = new ActionResult(current, null, 2, null);
                    }
                    ActionResult result = actionResult;
                    mutableStateFlow2 = this.this$0._pageState;
                    mutableStateFlow2.setValue(result.getState());
                    Flow<ISwitchAction> sideEffect = result.getSideEffect();
                    final AccountSwitchViewModel accountSwitchViewModel2 = this.this$0;
                    this.label = 2;
                    if (sideEffect.collect(new FlowCollector() { // from class: tv.danmaku.bili.change.AccountSwitchViewModel$handleAction$1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((ISwitchAction) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(ISwitchAction it6, Continuation<? super Unit> continuation) {
                            AccountSwitchViewModel.this.handleAction(it6);
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                } else {
                    mutableSharedFlow = this.this$0._pageActionFlow;
                    this.label = 1;
                    if (mutableSharedFlow.emit(this.$action, (Continuation) this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}