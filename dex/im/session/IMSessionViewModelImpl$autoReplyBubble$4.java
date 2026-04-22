package im.session;

import com.bapis.bilibili.app.im.v1.KAutoReplyToast;
import im.base.IMLog;
import im.session.log.LogTagKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionViewModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/bapis/bilibili/app/im/v1/KAutoReplyToast;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionViewModelImpl$autoReplyBubble$4", f = "IMSessionViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSessionViewModelImpl$autoReplyBubble$4 extends SuspendLambda implements Function2<KAutoReplyToast, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IMSessionViewModelImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionViewModelImpl$autoReplyBubble$4(IMSessionViewModelImpl iMSessionViewModelImpl, Continuation<? super IMSessionViewModelImpl$autoReplyBubble$4> continuation) {
        super(2, continuation);
        this.this$0 = iMSessionViewModelImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMSessionViewModelImpl$autoReplyBubble$4 = new IMSessionViewModelImpl$autoReplyBubble$4(this.this$0, continuation);
        iMSessionViewModelImpl$autoReplyBubble$4.L$0 = obj;
        return iMSessionViewModelImpl$autoReplyBubble$4;
    }

    public final Object invoke(KAutoReplyToast kAutoReplyToast, Continuation<? super Unit> continuation) {
        return create(kAutoReplyToast, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        KAutoReplyToast it = (KAutoReplyToast) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (it != null) {
                    BuildersKt.launch$default(this.this$0.getScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.this$0, null), 3, (Object) null);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMSessionViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "im.session.IMSessionViewModelImpl$autoReplyBubble$4$1", f = "IMSessionViewModel.kt", i = {}, l = {137, 139}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: im.session.IMSessionViewModelImpl$autoReplyBubble$4$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ IMSessionViewModelImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IMSessionViewModelImpl iMSessionViewModelImpl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = iMSessionViewModelImpl;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0052 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            IMSessionStateMachine iMSessionStateMachine;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Duration.Companion companion = Duration.Companion;
                    this.label = 1;
                    if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration(5, DurationUnit.SECONDS), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    IMLog.Companion.i(LogTagKt.getVMLogTag(), "自动回复气泡消失");
                    iMSessionStateMachine = this.this$0.stateMachine;
                    this.label = 2;
                    if (iMSessionStateMachine.dispatch(IMActionDismissAutoReply.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    IMLog.Companion.i(LogTagKt.getVMLogTag(), "自动回复气泡消失");
                    iMSessionStateMachine = this.this$0.stateMachine;
                    this.label = 2;
                    if (iMSessionStateMachine.dispatch(IMActionDismissAutoReply.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}