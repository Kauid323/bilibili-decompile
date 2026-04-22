package tv.danmaku.bili.change;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import bili.resource.account.R;
import com.bilibili.lib.coroutineextension.dialog.BiliCommonDialogWrapBuilder;
import com.bilibili.lib.coroutineextension.dialog.BiliCommonDialogWrapperKt;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;

/* compiled from: AccountSwitchFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.change.AccountSwitchFragment$onViewCreated$2", f = "AccountSwitchFragment.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AccountSwitchFragment$onViewCreated$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AccountSwitchFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountSwitchFragment$onViewCreated$2(AccountSwitchFragment accountSwitchFragment, Continuation<? super AccountSwitchFragment$onViewCreated$2> continuation) {
        super(2, continuation);
        this.this$0 = accountSwitchFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountSwitchFragment$onViewCreated$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccountSwitchFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.change.AccountSwitchFragment$onViewCreated$2$1", f = "AccountSwitchFragment.kt", i = {}, l = {BR.dialogBackground}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.change.AccountSwitchFragment$onViewCreated$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AccountSwitchFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AccountSwitchFragment accountSwitchFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = accountSwitchFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AccountSwitchFragment.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ltv/danmaku/bili/change/IEventAction;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        @DebugMetadata(c = "tv.danmaku.bili.change.AccountSwitchFragment$onViewCreated$2$1$1", f = "AccountSwitchFragment.kt", i = {0}, l = {BR.dynamicPlayedNumIcon}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
        /* renamed from: tv.danmaku.bili.change.AccountSwitchFragment$onViewCreated$2$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class C00021 extends SuspendLambda implements Function2<IEventAction, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AccountSwitchFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00021(AccountSwitchFragment accountSwitchFragment, Continuation<? super C00021> continuation) {
                super(2, continuation);
                this.this$0 = accountSwitchFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00021 = new C00021(this.this$0, continuation);
                c00021.L$0 = obj;
                return c00021;
            }

            public final Object invoke(IEventAction iEventAction, Continuation<? super Unit> continuation) {
                return create(iEventAction, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:25:0x00e8  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object $result) {
                Object $result2;
                IEventAction it;
                AccountSwitchViewModel viewModel;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IEventAction it2 = (IEventAction) this.L$0;
                        if (it2 instanceof ExitAccountAction) {
                            Neurons.reportClick$default(false, "main.change-account.exit.0.click", (Map) null, 4, (Object) null);
                            try {
                                Context context = this.this$0.requireContext();
                                Intrinsics.checkNotNullExpressionValue(context, "requireContext(...)");
                                Neurons.reportExposure$default(false, "main.change-account.exit.confirm-popup.show", (Map) null, (List) null, 12, (Object) null);
                                BiliCommonDialog.Builder buttonStyle = new BiliCommonDialog.Builder(context).setButtonStyle(1);
                                String string = context.getString(R.string.account_global_string_187);
                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                BiliCommonDialog.Builder title = buttonStyle.setTitle(string);
                                String string2 = context.getString(R.string.account_global_string_162);
                                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                BiliCommonDialogWrapBuilder asCoroutine = BiliCommonDialogWrapperKt.asCoroutine(title.setContentText(string2));
                                FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
                                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                                String string3 = context.getString(R.string.account_global_string_71);
                                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                                String string4 = context.getString(R.string.account_global_string_57);
                                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                                this.L$0 = it2;
                                this.label = 1;
                                if (BiliCommonDialogWrapBuilder.show$default(asCoroutine, childFragmentManager, string3, string4, (String) null, (Continuation) this, 8, (Object) null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result2 = $result;
                                it = it2;
                                Neurons.reportClick(false, "main.change-account.exit.confirm-popup.click", MapsKt.mapOf(TuplesKt.to("option", "1")));
                                viewModel = this.this$0.getViewModel();
                                viewModel.handleAction(new RemoveAccountAction(((ExitAccountAction) it).getAccount()));
                            } catch (Exception e) {
                                e = e;
                                $result2 = $result;
                                it = it2;
                                if (e instanceof CancellationException) {
                                    Neurons.reportClick(false, "main.change-account.exit.confirm-popup.click", MapsKt.mapOf(TuplesKt.to("option", "2")));
                                }
                                BLog.e("AccountSwitch", "Remove account " + ((ExitAccountAction) it).getAccount() + " failed", e);
                                return Unit.INSTANCE;
                            }
                        }
                    case 1:
                        $result2 = $result;
                        it = (IEventAction) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            Neurons.reportClick(false, "main.change-account.exit.confirm-popup.click", MapsKt.mapOf(TuplesKt.to("option", "1")));
                            viewModel = this.this$0.getViewModel();
                            viewModel.handleAction(new RemoveAccountAction(((ExitAccountAction) it).getAccount()));
                        } catch (Exception e2) {
                            e = e2;
                            if (e instanceof CancellationException) {
                            }
                            BLog.e("AccountSwitch", "Remove account " + ((ExitAccountAction) it).getAccount() + " failed", e);
                            return Unit.INSTANCE;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object $result) {
            AccountSwitchViewModel viewModel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    viewModel = this.this$0.getViewModel();
                    this.label = 1;
                    if (FlowKt.collectLatest(viewModel.getPageActionFlow(), new C00021(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(this.this$0.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}