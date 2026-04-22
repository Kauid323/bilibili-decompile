package kntr.common.komponent;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: Komponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.komponent.KomponentHostScopeImpl$__sub$1", f = "Komponent.kt", i = {0}, l = {213}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
final class KomponentHostScopeImpl$__sub$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ProvideLocalsScope, Unit> $provideLocals;
    final /* synthetic */ Ref.ObjectRef<KomponentHostScope> $result;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KomponentHostScopeImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public KomponentHostScopeImpl$__sub$1(Ref.ObjectRef<KomponentHostScope> objectRef, KomponentHostScopeImpl komponentHostScopeImpl, Function1<? super ProvideLocalsScope, Unit> function1, Continuation<? super KomponentHostScopeImpl$__sub$1> continuation) {
        super(2, continuation);
        this.$result = objectRef;
        this.this$0 = komponentHostScopeImpl;
        this.$provideLocals = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> komponentHostScopeImpl$__sub$1 = new KomponentHostScopeImpl$__sub$1(this.$result, this.this$0, this.$provideLocals, continuation);
        komponentHostScopeImpl$__sub$1.L$0 = obj;
        return komponentHostScopeImpl$__sub$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$result.element = this.this$0.__sub($this$launch, this.$provideLocals);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                this.label = 1;
                if (DelayKt.awaitCancellation((Continuation) this) == coroutine_suspended) {
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