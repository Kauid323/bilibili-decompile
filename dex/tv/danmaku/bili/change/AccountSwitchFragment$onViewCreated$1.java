package tv.danmaku.bili.change;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.normal.ui.RouteUtilKt;

/* compiled from: AccountSwitchFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.change.AccountSwitchFragment$onViewCreated$1", f = "AccountSwitchFragment.kt", i = {}, l = {BR.contentAlpha}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AccountSwitchFragment$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AccountSwitchFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountSwitchFragment$onViewCreated$1(AccountSwitchFragment accountSwitchFragment, Continuation<? super AccountSwitchFragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = accountSwitchFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountSwitchFragment$onViewCreated$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        AccountSwitchViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                viewModel = this.this$0.getViewModel();
                SharedFlow<IEventAction> pageActionFlow = viewModel.getPageActionFlow();
                final AccountSwitchFragment accountSwitchFragment = this.this$0;
                this.label = 1;
                if (pageActionFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.change.AccountSwitchFragment$onViewCreated$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((IEventAction) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(IEventAction it, Continuation<? super Unit> continuation) {
                        AccountSwitchViewModel viewModel2;
                        AccountSwitchViewModel viewModel3;
                        String str;
                        String toast;
                        if (it instanceof ToastAction) {
                            if (!StringsKt.isBlank(((ToastAction) it).getToast())) {
                                toast = ((ToastAction) it).getToast();
                            } else if (((ToastAction) it).getToastRes() != 0) {
                                Context context = AccountSwitchFragment.this.getContext();
                                if (context == null || (toast = context.getString(((ToastAction) it).getToastRes())) == null) {
                                    toast = "";
                                }
                            } else {
                                toast = "";
                            }
                            if (!StringsKt.isBlank(toast)) {
                                ToastHelper.showToastShort(AccountSwitchFragment.this.getContext(), toast);
                            }
                        } else {
                            boolean z = true;
                            if (Intrinsics.areEqual(it, LoginAction.INSTANCE)) {
                                Neurons.reportClick$default(false, "main.change-account.add.0.click", (Map) null, 4, (Object) null);
                                Context context2 = AccountSwitchFragment.this.getContext();
                                if (context2 != null) {
                                    str = AccountSwitchFragment.this.spmid;
                                    RouteUtilKt.showSmsLoginDialog$default(context2, str, null, Boxing.boxBoolean(true), false, 16, null);
                                }
                            } else if (it instanceof LoginFinishAction) {
                                if (((LoginFinishAction) it).getLoginSuccess()) {
                                    viewModel2 = AccountSwitchFragment.this.getViewModel();
                                    viewModel2.handleAction(LoadAccountListAction.INSTANCE);
                                    viewModel3 = AccountSwitchFragment.this.getViewModel();
                                    viewModel3.handleAction(RouteToMineAction.INSTANCE);
                                }
                            } else if (Intrinsics.areEqual(it, RouteToMineAction.INSTANCE)) {
                                FragmentActivity activity = AccountSwitchFragment.this.getActivity();
                                if (activity == null || !activity.isFinishing()) {
                                    z = false;
                                }
                                if (!z) {
                                    BLRouter.routeTo(RouteRequestKt.toRouteRequest("bilibili://root?bottom_tab_id=我的Bottom"), AccountSwitchFragment.this);
                                    FragmentActivity activity2 = AccountSwitchFragment.this.getActivity();
                                    if (activity2 != null) {
                                        activity2.finish();
                                    }
                                }
                            } else if (Intrinsics.areEqual(it, PageExitAction.INSTANCE)) {
                                FragmentActivity activity3 = AccountSwitchFragment.this.getActivity();
                                if (activity3 != null) {
                                    activity3.onBackPressed();
                                }
                            } else if (!(it instanceof ExitAccountAction)) {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}