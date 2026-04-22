package kntr.base.dd.impl.internal.container;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.KSerializer;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: DDContainer.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.impl.internal.container.DDContainer$asFlow$3", f = "DDContainer.kt", i = {0}, l = {162}, m = "invokeSuspend", n = {"$this$onStart"}, s = {"L$0"}, v = 1)
final class DDContainer$asFlow$3<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ IDeviceDecision.Context $context;
    final /* synthetic */ T $defaultValue;
    final /* synthetic */ String $key;
    final /* synthetic */ KSerializer<T> $serializer;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DDContainer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DDContainer$asFlow$3(DDContainer dDContainer, String str, KSerializer<T> kSerializer, T t, IDeviceDecision.Context context, Continuation<? super DDContainer$asFlow$3> continuation) {
        super(2, continuation);
        this.this$0 = dDContainer;
        this.$key = str;
        this.$serializer = kSerializer;
        this.$defaultValue = t;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> dDContainer$asFlow$3 = new DDContainer$asFlow$3<>(this.this$0, this.$key, this.$serializer, this.$defaultValue, this.$context, continuation);
        dDContainer$asFlow$3.L$0 = obj;
        return dDContainer$asFlow$3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((FlowCollector) ((FlowCollector) obj), (Continuation) obj2);
    }

    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        FlowCollector $this$onStart = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$onStart);
                this.label = 1;
                if ($this$onStart.emit(this.this$0.get(this.$key, this.$serializer, this.$defaultValue, this.$context), (Continuation) this) == coroutine_suspended) {
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