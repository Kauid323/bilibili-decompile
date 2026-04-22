package kntr.common.komponent;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.komponent.KomponentHostScope;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [S] */
/* compiled from: Komponent.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "S", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkntr/common/komponent/UiComposableLike;", "it", "Lkntr/common/komponent/Komponent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.komponent.KomponentKt$embedFlow$1", f = "Komponent.kt", i = {0, 0}, l = {43}, m = "invokeSuspend", n = {"$this$transformLatest", "it"}, s = {"L$0", "L$1"}, v = 1)
final class KomponentKt$embedFlow$1<S> extends SuspendLambda implements Function3<FlowCollector<? super UiComposableLike<? extends S>>, Komponent<? extends S>, Continuation<? super Unit>, Object> {
    final /* synthetic */ KomponentHostScope $this_embedFlow;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KomponentKt$embedFlow$1(KomponentHostScope komponentHostScope, Continuation<? super KomponentKt$embedFlow$1> continuation) {
        super(3, continuation);
        this.$this_embedFlow = komponentHostScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((FlowCollector) ((FlowCollector) obj), (Komponent) ((Komponent) obj2), (Continuation) obj3);
    }

    public final Object invoke(FlowCollector<? super UiComposableLike<? extends S>> flowCollector, Komponent<? extends S> komponent, Continuation<? super Unit> continuation) {
        KomponentKt$embedFlow$1 komponentKt$embedFlow$1 = new KomponentKt$embedFlow$1(this.$this_embedFlow, continuation);
        komponentKt$embedFlow$1.L$0 = flowCollector;
        komponentKt$embedFlow$1.L$1 = komponent;
        return komponentKt$embedFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Komponent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.common.komponent.KomponentKt$embedFlow$1$1", f = "Komponent.kt", i = {0, 1}, l = {44, 45}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$coroutineScope"}, s = {"L$0", "L$0"}, v = 1)
    /* renamed from: kntr.common.komponent.KomponentKt$embedFlow$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<UiComposableLike<? extends S>> $$this$transformLatest;
        final /* synthetic */ Komponent<S> $it;
        final /* synthetic */ KomponentHostScope $this_embedFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(FlowCollector<? super UiComposableLike<? extends S>> flowCollector, KomponentHostScope komponentHostScope, Komponent<? extends S> komponent, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$transformLatest = flowCollector;
            this.$this_embedFlow = komponentHostScope;
            this.$it = komponent;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$$this$transformLatest, this.$this_embedFlow, this.$it, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0054 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.label = 1;
                    if (this.$$this$transformLatest.emit(KomponentHostScope.CC.embed$default(KomponentHostScope.CC.__sub$default(this.$this_embedFlow, $this$coroutineScope, null, 2, null), this.$it, null, 2, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.label = 2;
                    if (DelayKt.awaitCancellation((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    throw new KotlinNothingValueException();
                case 1:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.label = 2;
                    if (DelayKt.awaitCancellation((Continuation) this) == coroutine_suspended) {
                    }
                    throw new KotlinNothingValueException();
                case 2:
                    ResultKt.throwOnFailure($result);
                    throw new KotlinNothingValueException();
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        FlowCollector $this$transformLatest = (FlowCollector) this.L$0;
        Komponent it = (Komponent) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$transformLatest);
                this.L$1 = SpillingKt.nullOutSpilledVariable(it);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1($this$transformLatest, this.$this_embedFlow, it, null), (Continuation) this) == coroutine_suspended) {
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