package kntr.app.live.room.multivideo.poll;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* compiled from: LivePollConnection.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.multivideo.poll.LivePollConnection$start$2", f = "LivePollConnection.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3}, l = {44, 45, 53, 57}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "response", "$this$launch", "response", "delayTime", "curOffset", "curDelay", "$this$launch", "response", "delayTime"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "J$0", "J$1", "J$2", "L$0", "L$1", "J$0"}, v = 1)
final class LivePollConnection$start$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    long J$1;
    long J$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LivePollConnection<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePollConnection$start$2(LivePollConnection<T> livePollConnection, Continuation<? super LivePollConnection$start$2> continuation) {
        super(2, continuation);
        this.this$0 = livePollConnection;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> livePollConnection$start$2 = new LivePollConnection$start$2(this.this$0, continuation);
        livePollConnection$start$2.L$0 = obj;
        return livePollConnection$start$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0115  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00eb -> B:11:0x0059). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x010b -> B:33:0x0111). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        LivePollConnection$start$2 livePollConnection$start$2;
        Object response;
        CoroutineScope $this$launch;
        Object response2;
        LivePollConnection$start$2 livePollConnection$start$22;
        Object response3;
        LivePollParam livePollParam;
        long delayTime;
        LivePollParam livePollParam2;
        Object response4;
        LivePollConnection$start$2 livePollConnection$start$23;
        long j2;
        MutableSharedFlow mutableSharedFlow;
        LivePollParam livePollParam3;
        CoroutineScope $this$launch2 = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                livePollConnection$start$2 = this;
                response = coroutine_suspended;
                $this$launch = $this$launch2;
                if (CoroutineScopeKt.isActive($this$launch)) {
                    livePollParam3 = ((LivePollConnection) livePollConnection$start$2.this$0).livePollParam;
                    Function1 fetcher = livePollParam3.getFetcher();
                    livePollConnection$start$2.L$0 = $this$launch;
                    livePollConnection$start$2.L$1 = null;
                    livePollConnection$start$2.label = 1;
                    response2 = fetcher.invoke(livePollConnection$start$2);
                    if (response2 == response) {
                        return response;
                    }
                    mutableSharedFlow = ((LivePollConnection) livePollConnection$start$2.this$0).messageFlow;
                    livePollConnection$start$2.L$0 = $this$launch;
                    livePollConnection$start$2.L$1 = SpillingKt.nullOutSpilledVariable(response2);
                    livePollConnection$start$2.label = 2;
                    if (mutableSharedFlow.emit(response2, (Continuation) livePollConnection$start$2) == response) {
                        return response;
                    }
                    livePollParam = ((LivePollConnection) livePollConnection$start$2.this$0).livePollParam;
                    delayTime = livePollParam.getDelay() * 1000;
                    if (delayTime <= 0) {
                        delayTime = LivePollConnection.DEFAULT_INTERVAL;
                    }
                    livePollParam2 = ((LivePollConnection) livePollConnection$start$2.this$0).livePollParam;
                    if (livePollParam2.getScatter()) {
                        long curOffset = Random.Default.nextLong(delayTime);
                        j2 = ((LivePollConnection) livePollConnection$start$2.this$0).lastOffset;
                        long curDelay = (delayTime - curOffset) + j2;
                        ((LivePollConnection) livePollConnection$start$2.this$0).lastOffset = curOffset;
                        livePollConnection$start$2.L$0 = $this$launch;
                        livePollConnection$start$2.L$1 = SpillingKt.nullOutSpilledVariable(response2);
                        livePollConnection$start$2.J$0 = delayTime;
                        livePollConnection$start$2.J$1 = curOffset;
                        livePollConnection$start$2.J$2 = curDelay;
                        livePollConnection$start$2.label = 3;
                        if (DelayKt.delay(curDelay, (Continuation) livePollConnection$start$2) == response) {
                            return response;
                        }
                        response3 = response;
                        livePollConnection$start$22 = livePollConnection$start$2;
                        response = response3;
                        livePollConnection$start$2 = livePollConnection$start$22;
                        if (CoroutineScopeKt.isActive($this$launch)) {
                            return Unit.INSTANCE;
                        }
                    } else {
                        ((LivePollConnection) livePollConnection$start$2.this$0).lastOffset = 0L;
                        livePollConnection$start$2.L$0 = $this$launch;
                        livePollConnection$start$2.L$1 = SpillingKt.nullOutSpilledVariable(response2);
                        livePollConnection$start$2.J$0 = delayTime;
                        livePollConnection$start$2.label = 4;
                        if (DelayKt.delay(delayTime, (Continuation) livePollConnection$start$2) == response) {
                            return response;
                        }
                        response4 = response;
                        livePollConnection$start$23 = livePollConnection$start$2;
                        response = response4;
                        livePollConnection$start$2 = livePollConnection$start$23;
                        if (CoroutineScopeKt.isActive($this$launch)) {
                        }
                    }
                }
            case 1:
                ResultKt.throwOnFailure($result);
                response2 = $result;
                livePollConnection$start$2 = this;
                response = coroutine_suspended;
                $this$launch = $this$launch2;
                mutableSharedFlow = ((LivePollConnection) livePollConnection$start$2.this$0).messageFlow;
                livePollConnection$start$2.L$0 = $this$launch;
                livePollConnection$start$2.L$1 = SpillingKt.nullOutSpilledVariable(response2);
                livePollConnection$start$2.label = 2;
                if (mutableSharedFlow.emit(response2, (Continuation) livePollConnection$start$2) == response) {
                }
                livePollParam = ((LivePollConnection) livePollConnection$start$2.this$0).livePollParam;
                delayTime = livePollParam.getDelay() * 1000;
                if (delayTime <= 0) {
                }
                livePollParam2 = ((LivePollConnection) livePollConnection$start$2.this$0).livePollParam;
                if (livePollParam2.getScatter()) {
                }
                break;
            case 2:
                Object response5 = this.L$1;
                ResultKt.throwOnFailure($result);
                livePollConnection$start$2 = this;
                response2 = response5;
                response = coroutine_suspended;
                $this$launch = $this$launch2;
                livePollParam = ((LivePollConnection) livePollConnection$start$2.this$0).livePollParam;
                delayTime = livePollParam.getDelay() * 1000;
                if (delayTime <= 0) {
                }
                livePollParam2 = ((LivePollConnection) livePollConnection$start$2.this$0).livePollParam;
                if (livePollParam2.getScatter()) {
                }
                break;
            case 3:
                long delayTime2 = this.J$2;
                long j3 = this.J$1;
                long j4 = this.J$0;
                Object obj = this.L$1;
                ResultKt.throwOnFailure($result);
                livePollConnection$start$22 = this;
                response3 = coroutine_suspended;
                $this$launch = $this$launch2;
                response = response3;
                livePollConnection$start$2 = livePollConnection$start$22;
                if (CoroutineScopeKt.isActive($this$launch)) {
                }
                break;
            case 4:
                long j5 = this.J$0;
                Object obj2 = this.L$1;
                ResultKt.throwOnFailure($result);
                livePollConnection$start$23 = this;
                response4 = coroutine_suspended;
                $this$launch = $this$launch2;
                response = response4;
                livePollConnection$start$2 = livePollConnection$start$23;
                if (CoroutineScopeKt.isActive($this$launch)) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}