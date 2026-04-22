package tv.danmaku.biliplayerv2.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.biliplayerv2.service.interact.biz.model.ChronosThumbnailInfo;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SeekService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.SeekService$mergeWatchPointAndHeaderTail$1", f = "SeekService.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SeekService$mergeWatchPointAndHeaderTail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SeekService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeekService$mergeWatchPointAndHeaderTail$1(SeekService seekService, Continuation<? super SeekService$mergeWatchPointAndHeaderTail$1> continuation) {
        super(2, continuation);
        this.this$0 = seekService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeekService$mergeWatchPointAndHeaderTail$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        List it;
        Iterable iterable;
        MutableStateFlow mutableStateFlow;
        boolean conflictTo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                List list = new ArrayList();
                it = this.this$0.watchPoints;
                if (it != null) {
                    CollectionsKt.addAll(list, it);
                }
                iterable = this.this$0.headerTailPoints;
                if (iterable != null) {
                    Iterable $this$filterTo$iv$iv = iterable;
                    SeekService seekService = this.this$0;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filterTo$iv$iv) {
                        conflictTo = seekService.conflictTo((ChronosThumbnailInfo.WatchPoint) element$iv$iv, list);
                        if ((!conflictTo ? 1 : null) != null) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    CollectionsKt.addAll(list, (List) destination$iv$iv);
                }
                mutableStateFlow = this.this$0._watchPointListFlow;
                this.label = 1;
                if (mutableStateFlow.emit(list, (Continuation) this) == coroutine_suspended) {
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