package im.session;

import com.bapis.bilibili.app.im.v1.KSessionId;
import com.tencent.tauth.AuthActivity;
import im.session.model.IMSessionCard;
import java.util.Iterator;
import kntr.app.im.base.IMEventHub;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", AuthActivity.ACTION_KEY, "Lim/session/IMActionClearAllSessionsSucceed;", "<unused var>", "Lim/session/IMState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$clearSessionListBlock$2", f = "IMSessionStateMachine.kt", i = {0}, l = {638}, m = "invokeSuspend", n = {AuthActivity.ACTION_KEY}, s = {"L$0"}, v = 1)
final class IMSessionStateMachine$clearSessionListBlock$2 extends SuspendLambda implements Function3<IMActionClearAllSessionsSucceed, IMState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSessionStateMachine$clearSessionListBlock$2(Continuation<? super IMSessionStateMachine$clearSessionListBlock$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IMActionClearAllSessionsSucceed iMActionClearAllSessionsSucceed, IMState iMState, Continuation<? super Unit> continuation) {
        IMSessionStateMachine$clearSessionListBlock$2 iMSessionStateMachine$clearSessionListBlock$2 = new IMSessionStateMachine$clearSessionListBlock$2(continuation);
        iMSessionStateMachine$clearSessionListBlock$2.L$0 = iMActionClearAllSessionsSucceed;
        return iMSessionStateMachine$clearSessionListBlock$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMSessionStateMachine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "im.session.IMSessionStateMachine$clearSessionListBlock$2$1", f = "IMSessionStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: im.session.IMSessionStateMachine$clearSessionListBlock$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IMActionClearAllSessionsSucceed $action;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IMActionClearAllSessionsSucceed iMActionClearAllSessionsSucceed, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$action = iMActionClearAllSessionsSucceed;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$action, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: IMSessionStateMachine.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "im.session.IMSessionStateMachine$clearSessionListBlock$2$1$1", f = "IMSessionStateMachine.kt", i = {0, 0, 0, 0, 0}, l = {641}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-IMSessionStateMachine$clearSessionListBlock$2$1$1$1"}, s = {"L$0", "L$2", "L$3", "I$0", "I$1"}, v = 1)
        /* renamed from: im.session.IMSessionStateMachine$clearSessionListBlock$2$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class C00291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ IMActionClearAllSessionsSucceed $action;
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00291(IMActionClearAllSessionsSucceed iMActionClearAllSessionsSucceed, Continuation<? super C00291> continuation) {
                super(2, continuation);
                this.$action = iMActionClearAllSessionsSucceed;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00291(this.$action, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0046  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0088  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x007a -> B:14:0x0082). Please submit an issue!!! */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object $result) {
                int $i$f$forEach;
                Iterable $this$forEach$iv;
                Iterator it;
                C00291 c00291;
                C00291 c002912;
                Iterable $this$forEach$iv2;
                Iterator it2;
                int $i$f$forEach2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Iterable $this$forEach$iv3 = this.$action.getList();
                        $i$f$forEach = 0;
                        $this$forEach$iv = $this$forEach$iv3;
                        it = $this$forEach$iv3.iterator();
                        c00291 = this;
                        break;
                    case 1:
                        int i2 = this.I$1;
                        int $i$f$forEach3 = this.I$0;
                        IMSessionCard iMSessionCard = (IMSessionCard) this.L$3;
                        Object obj = this.L$2;
                        ResultKt.throwOnFailure($result);
                        $this$forEach$iv2 = (Iterable) this.L$0;
                        it2 = (Iterator) this.L$1;
                        $i$f$forEach2 = $i$f$forEach3;
                        c002912 = this;
                        c00291 = c002912;
                        $i$f$forEach = $i$f$forEach2;
                        it = it2;
                        $this$forEach$iv = $this$forEach$iv2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!it.hasNext()) {
                    Object element$iv = it.next();
                    IMSessionCard it3 = (IMSessionCard) element$iv;
                    MutableSharedFlow deletedSessionFromListFlow = IMEventHub.INSTANCE.getDeletedSessionFromListFlow();
                    KSessionId id = it3.getId();
                    c00291.L$0 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                    c00291.L$1 = it;
                    c00291.L$2 = SpillingKt.nullOutSpilledVariable(element$iv);
                    c00291.L$3 = SpillingKt.nullOutSpilledVariable(it3);
                    c00291.I$0 = $i$f$forEach;
                    c00291.I$1 = 0;
                    c00291.label = 1;
                    if (deletedSessionFromListFlow.emit(id, c00291) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i3 = $i$f$forEach;
                    c002912 = c00291;
                    $this$forEach$iv2 = $this$forEach$iv;
                    it2 = it;
                    $i$f$forEach2 = i3;
                    c00291 = c002912;
                    $i$f$forEach = $i$f$forEach2;
                    it = it2;
                    $this$forEach$iv = $this$forEach$iv2;
                    if (!it.hasNext()) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }

        public final Object invokeSuspend(Object $result) {
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C00291(this.$action, null), 3, (Object) null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        IMActionClearAllSessionsSucceed action = (IMActionClearAllSessionsSucceed) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(action, null), (Continuation) this) == coroutine_suspended) {
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