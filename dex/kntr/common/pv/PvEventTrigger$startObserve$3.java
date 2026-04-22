package kntr.common.pv;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PvEventTrigger.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.pv.PvEventTrigger$startObserve$3", f = "PvEventTrigger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PvEventTrigger$startObserve$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PvEventTrigger this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PvEventTrigger$startObserve$3(PvEventTrigger pvEventTrigger, Continuation<? super PvEventTrigger$startObserve$3> continuation) {
        super(2, continuation);
        this.this$0 = pvEventTrigger;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> pvEventTrigger$startObserve$3 = new PvEventTrigger$startObserve$3(this.this$0, continuation);
        pvEventTrigger$startObserve$3.L$0 = obj;
        return pvEventTrigger$startObserve$3;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PvEventTrigger.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.common.pv.PvEventTrigger$startObserve$3$1", f = "PvEventTrigger.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.common.pv.PvEventTrigger$startObserve$3$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PvEventTrigger this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PvEventTrigger pvEventTrigger, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = pvEventTrigger;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Flow flow;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    flow = this.this$0.stataFlow;
                    Flow drop = FlowKt.drop(flow, 1);
                    final PvEventTrigger pvEventTrigger = this.this$0;
                    this.label = 1;
                    if (drop.collect(new FlowCollector() { // from class: kntr.common.pv.PvEventTrigger.startObserve.3.1.1

                        /* compiled from: PvEventTrigger.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        /* renamed from: kntr.common.pv.PvEventTrigger$startObserve$3$1$1$WhenMappings */
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[PvState.values().length];
                                try {
                                    iArr[PvState.Visible.ordinal()] = 1;
                                } catch (NoSuchFieldError e) {
                                }
                                try {
                                    iArr[PvState.Invisible.ordinal()] = 2;
                                } catch (NoSuchFieldError e2) {
                                }
                                $EnumSwitchMapping$0 = iArr;
                            }
                        }

                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((PvState) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(PvState state, Continuation<? super Unit> continuation) {
                            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                                case 1:
                                    PvEventTrigger.this.onVisible(PageLoadType.Back);
                                    break;
                                case 2:
                                    PvEventTrigger.this.onInvisible();
                                    break;
                                default:
                                    throw new NoWhenBranchMatchedException();
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
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.this$0, null), 3, (Object) null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}