package tv.danmaku.bili.inner;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import bili.resource.account.R;
import com.bilibili.app.comm.list.widget.dialog.LoadingDialog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerLoginFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginFragment$registerLoadingDialog$1", f = "InnerLoginFragment.kt", i = {}, l = {BR.inlineEventListener}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InnerLoginFragment$registerLoadingDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InnerLoginFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoginFragment$registerLoadingDialog$1(InnerLoginFragment innerLoginFragment, Continuation<? super InnerLoginFragment$registerLoadingDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = innerLoginFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerLoginFragment$registerLoadingDialog$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InnerLoginFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginFragment$registerLoadingDialog$1$1", f = "InnerLoginFragment.kt", i = {}, l = {BR.inlineOperationListener}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.inner.InnerLoginFragment$registerLoadingDialog$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InnerLoginFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InnerLoginFragment innerLoginFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = innerLoginFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: InnerLoginFragment.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ReportEvent.EVENT_TYPE_SHOW, ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        @DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginFragment$registerLoadingDialog$1$1$1", f = "InnerLoginFragment.kt", i = {0}, l = {BR.rankNoneLayoutVisible}, m = "invokeSuspend", n = {ReportEvent.EVENT_TYPE_SHOW}, s = {"Z$0"}, v = 1)
        /* renamed from: tv.danmaku.bili.inner.InnerLoginFragment$registerLoadingDialog$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class C00121 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            Object L$0;
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ InnerLoginFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00121(InnerLoginFragment innerLoginFragment, Continuation<? super C00121> continuation) {
                super(2, continuation);
                this.this$0 = innerLoginFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00121 = new C00121(this.this$0, continuation);
                c00121.Z$0 = ((Boolean) obj).booleanValue();
                return c00121;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
            }

            public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                return create(Boolean.valueOf(z), continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        boolean show = this.Z$0;
                        InnerLoginFragment innerLoginFragment = this.this$0;
                        this.L$0 = innerLoginFragment;
                        this.Z$0 = show;
                        this.label = 1;
                        Continuation uCont$iv = (Continuation) this;
                        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                        cancellableContinuationImpl.initCancellability();
                        CancellableContinuation it = cancellableContinuationImpl;
                        LoadingDialog.Companion companion = LoadingDialog.Companion;
                        String string = innerLoginFragment.getString(R.string.account_global_string_89);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        final LoadingDialog loadingDialog = companion.create(string, true, true);
                        if (show && !loadingDialog.isAdded()) {
                            loadingDialog.showNow(innerLoginFragment.getChildFragmentManager(), "loading");
                        } else if (loadingDialog.isAdded()) {
                            loadingDialog.dismissAllowingStateLoss();
                        }
                        it.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$registerLoadingDialog$1$1$1$1$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((Throwable) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Throwable it2) {
                                if (loadingDialog.isAdded()) {
                                    BLog.d(InnerLoginViewModelKt.TAG_INNER_LOGIN, "dismiss dialog");
                                    loadingDialog.dismissAllowingStateLoss();
                                }
                            }
                        });
                        Object result = cancellableContinuationImpl.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended((Continuation) this);
                        }
                        if (result != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        InnerLoginFragment innerLoginFragment2 = (InnerLoginFragment) this.L$0;
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
                    if (FlowKt.collectLatest(this.this$0.getViewModel().getDialogState(), new C00121(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
                LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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