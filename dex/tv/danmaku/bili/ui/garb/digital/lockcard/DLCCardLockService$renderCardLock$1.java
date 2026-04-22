package tv.danmaku.bili.ui.garb.digital.lockcard;

import com.alibaba.fastjson.JSONObject;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.DigitalJsCallHandler;
import tv.danmaku.bili.ui.garb.api.CardLockStatus;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DLCCardLockService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.digital.lockcard.DLCCardLockService$renderCardLock$1", f = "DLCCardLockService.kt", i = {}, l = {BR.bgCover}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DLCCardLockService$renderCardLock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<CardLockStatus, Unit> $cardStatusChange;
    int label;
    final /* synthetic */ DLCCardLockService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DLCCardLockService$renderCardLock$1(DLCCardLockService dLCCardLockService, Function1<? super CardLockStatus, Unit> function1, Continuation<? super DLCCardLockService$renderCardLock$1> continuation) {
        super(2, continuation);
        this.this$0 = dLCCardLockService;
        this.$cardStatusChange = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DLCCardLockService$renderCardLock$1(this.this$0, this.$cardStatusChange, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutableStateFlow = this.this$0.cardStatusChangedFlow;
                final Function1<CardLockStatus, Unit> function1 = this.$cardStatusChange;
                final DLCCardLockService dLCCardLockService = this.this$0;
                this.label = 1;
                if (mutableStateFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.DLCCardLockService$renderCardLock$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((Pair) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(Pair<Long, ? extends CardLockStatus> pair, Continuation<? super Unit> continuation) {
                        DigitalJsCallHandler digitalJsCallHandler;
                        if (pair != null) {
                            Function1<CardLockStatus, Unit> function12 = function1;
                            if (function12 != null) {
                                function12.invoke(pair.getSecond());
                            }
                            JSONObject changeObj = new JSONObject();
                            changeObj.put("smelt_lock_status", ((CardLockStatus) pair.getSecond()).m1726getValue());
                            changeObj.put("card_id", pair.getFirst());
                            digitalJsCallHandler = dLCCardLockService.handler;
                            if (digitalJsCallHandler != null) {
                                digitalJsCallHandler.onCardInfoChange(changeObj);
                            }
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
        throw new KotlinNothingValueException();
    }
}