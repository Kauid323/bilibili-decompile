package tv.danmaku.bili.ui.garb.nft;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.nft.CardDataState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DLCDrawCardDataManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.nft.DLCDrawCardDataManager$requestData$2", f = "DLCDrawCardDataManager.kt", i = {0, 1}, l = {BR.badgeBgColor, BR.badgeBgColorNight}, m = "invokeSuspend", n = {"downloadResultTask", "respInfo"}, s = {"L$0", "L$0"}, v = 1)
public final class DLCDrawCardDataManager$requestData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<CardDataState> $state;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DLCDrawCardDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DLCDrawCardDataManager$requestData$2(Ref.ObjectRef<CardDataState> objectRef, DLCDrawCardDataManager dLCDrawCardDataManager, Continuation<? super DLCDrawCardDataManager$requestData$2> continuation) {
        super(2, continuation);
        this.$state = objectRef;
        this.this$0 = dLCDrawCardDataManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> dLCDrawCardDataManager$requestData$2 = new DLCDrawCardDataManager$requestData$2(this.$state, this.this$0, continuation);
        dLCDrawCardDataManager$requestData$2.L$0 = obj;
        return dLCDrawCardDataManager$requestData$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Deferred downloadResultTask;
        Object await;
        CardDataState respInfo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                Deferred respInfoTask = BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DLCDrawCardDataManager$requestData$2$respInfoTask$1(this.this$0, null), 3, (Object) null);
                Deferred downloadResultTask2 = BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DLCDrawCardDataManager$requestData$2$downloadResultTask$1(this.this$0, null), 3, (Object) null);
                this.L$0 = downloadResultTask2;
                this.label = 1;
                Object await2 = respInfoTask.await((Continuation) this);
                if (await2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = await2;
                downloadResultTask = downloadResultTask2;
                CardDataState respInfo2 = (CardDataState) $result;
                this.L$0 = respInfo2;
                this.label = 2;
                await = downloadResultTask.await((Continuation) this);
                if (await != coroutine_suspended) {
                    return coroutine_suspended;
                }
                respInfo = respInfo2;
                $result = await;
                Boolean downloadResult = (Boolean) $result;
                BLog.d(DLCDrawCardDataManager.Companion.getTAG(), "respInfo: " + respInfo + " downloadResult: " + downloadResult);
                if (!(respInfo instanceof CardDataState.Success) && Intrinsics.areEqual(downloadResult, Boxing.boxBoolean(true))) {
                    this.$state.element = respInfo;
                } else if (!(respInfo instanceof CardDataState.ApiFailed)) {
                    this.$state.element = respInfo;
                } else if (Intrinsics.areEqual(downloadResult, Boxing.boxBoolean(false))) {
                    this.$state.element = respInfo instanceof CardDataState.Success ? new CardDataState.ResFailed(((CardDataState.Success) respInfo).getDlcRespInfo()) : new CardDataState.ResFailed(null, 1, null);
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                downloadResultTask = (Deferred) this.L$0;
                CardDataState respInfo22 = (CardDataState) $result;
                this.L$0 = respInfo22;
                this.label = 2;
                await = downloadResultTask.await((Continuation) this);
                if (await != coroutine_suspended) {
                }
                break;
            case 2:
                respInfo = (CardDataState) this.L$0;
                ResultKt.throwOnFailure($result);
                Boolean downloadResult2 = (Boolean) $result;
                BLog.d(DLCDrawCardDataManager.Companion.getTAG(), "respInfo: " + respInfo + " downloadResult: " + downloadResult2);
                if (!(respInfo instanceof CardDataState.Success)) {
                    break;
                }
                if (!(respInfo instanceof CardDataState.ApiFailed)) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}