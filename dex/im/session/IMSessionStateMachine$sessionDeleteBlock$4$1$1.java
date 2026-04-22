package im.session;

import im.base.IMLog;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionCardKt;
import kntr.app.im.base.IMEventHub;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$sessionDeleteBlock$4$1$1", f = "IMSessionStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IMSessionStateMachine$sessionDeleteBlock$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ IMSessionCard $session;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$sessionDeleteBlock$4$1$1(IMSessionStateMachine iMSessionStateMachine, IMSessionCard iMSessionCard, Continuation<? super IMSessionStateMachine$sessionDeleteBlock$4$1$1> continuation) {
        super(2, continuation);
        this.this$0 = iMSessionStateMachine;
        this.$session = iMSessionCard;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMSessionStateMachine$sessionDeleteBlock$4$1$1 = new IMSessionStateMachine$sessionDeleteBlock$4$1$1(this.this$0, this.$session, continuation);
        iMSessionStateMachine$sessionDeleteBlock$4$1$1.L$0 = obj;
        return iMSessionStateMachine$sessionDeleteBlock$4$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMSessionStateMachine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "im.session.IMSessionStateMachine$sessionDeleteBlock$4$1$1$1", f = "IMSessionStateMachine.kt", i = {}, l = {738}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: im.session.IMSessionStateMachine$sessionDeleteBlock$4$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IMSessionCard $session;
        int label;
        final /* synthetic */ IMSessionStateMachine this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IMSessionStateMachine iMSessionStateMachine, IMSessionCard iMSessionCard, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = iMSessionStateMachine;
            this.$session = iMSessionCard;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$session, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    IMLog.Companion companion = IMLog.Companion;
                    str = this.this$0.sessionLogTag;
                    companion.i(str, "通知EventHub会话删除 " + IMSessionCardKt.getStringId(this.$session.getId()));
                    this.label = 1;
                    if (IMEventHub.INSTANCE.getDeletedSessionFromListFlow().emit(this.$session.getId(), (Continuation) this) == coroutine_suspended) {
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
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.this$0, this.$session, null), 3, (Object) null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}