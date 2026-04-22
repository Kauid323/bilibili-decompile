package kntr.common.komponent;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.config.FlowControlConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: StablerSnapshotFlow.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.komponent.StablerSnapshotFlowKt$stablerSnapshotFlow$1", f = "StablerSnapshotFlow.kt", i = {0, 0, 0, 0}, l = {57}, m = "invokeSuspend", n = {"$this$channelFlow", "onChangedChannel", "stateObserver", "onValueChangedInBlock"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
final class StablerSnapshotFlowKt$stablerSnapshotFlow$1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T> $calculation;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StablerSnapshotFlowKt$stablerSnapshotFlow$1(Function0<? extends T> function0, Continuation<? super StablerSnapshotFlowKt$stablerSnapshotFlow$1> continuation) {
        super(2, continuation);
        this.$calculation = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stablerSnapshotFlowKt$stablerSnapshotFlow$1 = new StablerSnapshotFlowKt$stablerSnapshotFlow$1<>(this.$calculation, continuation);
        stablerSnapshotFlowKt$stablerSnapshotFlow$1.L$0 = obj;
        return stablerSnapshotFlowKt$stablerSnapshotFlow$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((ProducerScope) ((ProducerScope) obj), (Continuation) obj2);
    }

    public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009f A[Catch: all -> 0x00b8, TRY_LEAVE, TryCatch #3 {all -> 0x00b8, blocks: (B:18:0x0097, B:20:0x009f), top: B:38:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x008d -> B:38:0x0097). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        final SnapshotStateObserver stateObserver;
        Object $result2;
        StablerSnapshotFlowKt$stablerSnapshotFlow$1 stablerSnapshotFlowKt$stablerSnapshotFlow$1;
        Channel onChangedChannel;
        SnapshotStateObserver stateObserver2;
        Ref.ObjectRef onValueChangedInBlock;
        ChannelIterator channelIterator;
        Object obj;
        ProducerScope $this$channelFlow;
        final ProducerScope $this$channelFlow2 = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final Channel onChangedChannel2 = ChannelKt.Channel$default((int) FlowControlConfig.RETRY_MAX_TIMES, (BufferOverflow) null, (Function1) null, 6, (Object) null);
                stateObserver = new SnapshotStateObserver(new Function1() { // from class: kntr.common.komponent.StablerSnapshotFlowKt$stablerSnapshotFlow$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = StablerSnapshotFlowKt$stablerSnapshotFlow$1.invokeSuspend$lambda$0(onChangedChannel2, (Function0) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
                final Ref.ObjectRef onValueChangedInBlock2 = new Ref.ObjectRef();
                final Function0<T> function0 = this.$calculation;
                onValueChangedInBlock2.element = new Function1() { // from class: kntr.common.komponent.StablerSnapshotFlowKt$stablerSnapshotFlow$1$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj2) {
                        Unit invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = StablerSnapshotFlowKt$stablerSnapshotFlow$1.invokeSuspend$lambda$2(stateObserver, onValueChangedInBlock2, $this$channelFlow2, function0, (Unit) obj2);
                        return invokeSuspend$lambda$2;
                    }
                };
                stateObserver.start();
                try {
                    invokeSuspend$observeBlock(stateObserver, onValueChangedInBlock2, $this$channelFlow2, this.$calculation);
                    ChannelIterator it = onChangedChannel2.iterator();
                    StablerSnapshotFlowKt$stablerSnapshotFlow$1 stablerSnapshotFlowKt$stablerSnapshotFlow$12 = this;
                    try {
                        stablerSnapshotFlowKt$stablerSnapshotFlow$12.L$0 = SpillingKt.nullOutSpilledVariable($this$channelFlow2);
                        stablerSnapshotFlowKt$stablerSnapshotFlow$12.L$1 = SpillingKt.nullOutSpilledVariable(onChangedChannel2);
                        stablerSnapshotFlowKt$stablerSnapshotFlow$12.L$2 = stateObserver;
                        stablerSnapshotFlowKt$stablerSnapshotFlow$12.L$3 = SpillingKt.nullOutSpilledVariable(onValueChangedInBlock2);
                        stablerSnapshotFlowKt$stablerSnapshotFlow$12.L$4 = it;
                        stablerSnapshotFlowKt$stablerSnapshotFlow$12.label = 1;
                        Object hasNext = it.hasNext((Continuation) stablerSnapshotFlowKt$stablerSnapshotFlow$12);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ProducerScope producerScope = $this$channelFlow2;
                        $result2 = $result;
                        $result = hasNext;
                        stablerSnapshotFlowKt$stablerSnapshotFlow$1 = stablerSnapshotFlowKt$stablerSnapshotFlow$12;
                        onChangedChannel = onChangedChannel2;
                        stateObserver2 = stateObserver;
                        onValueChangedInBlock = onValueChangedInBlock2;
                        channelIterator = it;
                        obj = coroutine_suspended;
                        $this$channelFlow = producerScope;
                        try {
                            if (!((Boolean) $result).booleanValue()) {
                                Function0 onChanged = (Function0) channelIterator.next();
                                onChanged.invoke();
                                $result = $result2;
                                $this$channelFlow2 = $this$channelFlow;
                                coroutine_suspended = obj;
                                it = channelIterator;
                                onValueChangedInBlock2 = onValueChangedInBlock;
                                stateObserver = stateObserver2;
                                onChangedChannel2 = onChangedChannel;
                                stablerSnapshotFlowKt$stablerSnapshotFlow$12 = stablerSnapshotFlowKt$stablerSnapshotFlow$1;
                                stablerSnapshotFlowKt$stablerSnapshotFlow$12.L$0 = SpillingKt.nullOutSpilledVariable($this$channelFlow2);
                                stablerSnapshotFlowKt$stablerSnapshotFlow$12.L$1 = SpillingKt.nullOutSpilledVariable(onChangedChannel2);
                                stablerSnapshotFlowKt$stablerSnapshotFlow$12.L$2 = stateObserver;
                                stablerSnapshotFlowKt$stablerSnapshotFlow$12.L$3 = SpillingKt.nullOutSpilledVariable(onValueChangedInBlock2);
                                stablerSnapshotFlowKt$stablerSnapshotFlow$12.L$4 = it;
                                stablerSnapshotFlowKt$stablerSnapshotFlow$12.label = 1;
                                Object hasNext2 = it.hasNext((Continuation) stablerSnapshotFlowKt$stablerSnapshotFlow$12);
                                if (hasNext2 != coroutine_suspended) {
                                }
                            } else {
                                stateObserver2.stop();
                                return Unit.INSTANCE;
                            }
                        } catch (Throwable th) {
                            stateObserver = stateObserver2;
                            th = th;
                            stateObserver.stop();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        stateObserver.stop();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    stateObserver.stop();
                    throw th;
                }
            case 1:
                ChannelIterator channelIterator2 = (ChannelIterator) this.L$4;
                Ref.ObjectRef onValueChangedInBlock3 = (Ref.ObjectRef) this.L$3;
                stateObserver = (SnapshotStateObserver) this.L$2;
                Channel onChangedChannel3 = (Channel) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    stablerSnapshotFlowKt$stablerSnapshotFlow$1 = this;
                    onChangedChannel = onChangedChannel3;
                    stateObserver2 = stateObserver;
                    onValueChangedInBlock = onValueChangedInBlock3;
                    channelIterator = channelIterator2;
                    obj = coroutine_suspended;
                    $this$channelFlow = $this$channelFlow2;
                    $result2 = $result;
                    if (!((Boolean) $result).booleanValue()) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    stateObserver.stop();
                    throw th;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Channel $onChangedChannel, Function0 it) {
        $onChangedChannel.trySend-JP2dKIU(it);
        return Unit.INSTANCE;
    }

    private static final <T> void invokeSuspend$observeBlock(SnapshotStateObserver stateObserver, Ref.ObjectRef<Function1<Unit, Unit>> objectRef, final ProducerScope<? super T> producerScope, final Function0<? extends T> function0) {
        Function1 function1;
        Unit unit = Unit.INSTANCE;
        if (objectRef.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onValueChangedInBlock");
            function1 = null;
        } else {
            function1 = (Function1) objectRef.element;
        }
        stateObserver.observeReads(unit, function1, new Function0() { // from class: kntr.common.komponent.StablerSnapshotFlowKt$stablerSnapshotFlow$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit invokeSuspend$observeBlock$lambda$1;
                invokeSuspend$observeBlock$lambda$1 = StablerSnapshotFlowKt$stablerSnapshotFlow$1.invokeSuspend$observeBlock$lambda$1(producerScope, function0);
                return invokeSuspend$observeBlock$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$observeBlock$lambda$1(ProducerScope $$this$channelFlow, Function0 $calculation) {
        $$this$channelFlow.trySend-JP2dKIU($calculation.invoke());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2(SnapshotStateObserver $stateObserver, Ref.ObjectRef $onValueChangedInBlock, ProducerScope $$this$channelFlow, Function0 $calculation, Unit unit) {
        invokeSuspend$observeBlock($stateObserver, $onValueChangedInBlock, $$this$channelFlow, $calculation);
        return Unit.INSTANCE;
    }
}