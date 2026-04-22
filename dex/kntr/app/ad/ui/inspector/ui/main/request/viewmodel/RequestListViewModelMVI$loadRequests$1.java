package kntr.app.ad.ui.inspector.ui.main.request.viewmodel;

import java.util.List;
import java.util.Map;
import kntr.app.ad.domain.inspector.core.work.RequestJobData;
import kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestListViewModelMVI;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestListViewModelMVI.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestListViewModelMVI$loadRequests$1", f = "RequestListViewModelMVI.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RequestListViewModelMVI$loadRequests$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RequestListViewModelMVI this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestListViewModelMVI$loadRequests$1(RequestListViewModelMVI requestListViewModelMVI, Continuation<? super RequestListViewModelMVI$loadRequests$1> continuation) {
        super(2, continuation);
        this.this$0 = requestListViewModelMVI;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RequestListViewModelMVI$loadRequests$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Flow allRequestJobDataFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                allRequestJobDataFlow = this.this$0.getAllRequestJobDataFlow();
                Flow flow = FlowKt.catch(allRequestJobDataFlow, new AnonymousClass1(this.this$0, null));
                final RequestListViewModelMVI requestListViewModelMVI = this.this$0;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestListViewModelMVI$loadRequests$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((List) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(List<RequestJobData> list, Continuation<? super Unit> continuation) {
                        MutableStateFlow mutableStateFlow;
                        MutableStateFlow mutableStateFlow2;
                        List filteredForStats;
                        Map counts;
                        List filteredRequests;
                        MutableStateFlow mutableStateFlow3;
                        mutableStateFlow = RequestListViewModelMVI.this.requests;
                        mutableStateFlow.setValue(list);
                        mutableStateFlow2 = RequestListViewModelMVI.this._state;
                        RequestListViewModelMVI.ViewState currentState = (RequestListViewModelMVI.ViewState) mutableStateFlow2.getValue();
                        filteredForStats = RequestListViewModelMVI.this.applyNonStatusFilters(list, currentState.getSelectedType(), currentState.getSelectedSlot());
                        counts = RequestListViewModelMVI.this.calculateStats(filteredForStats);
                        filteredRequests = RequestListViewModelMVI.this.applyAllFilters(list, currentState.getSelectedStatus(), currentState.getSelectedType(), currentState.getSelectedSlot());
                        mutableStateFlow3 = RequestListViewModelMVI.this._state;
                        mutableStateFlow3.setValue(RequestListViewModelMVI.ViewState.copy$default(currentState, false, list, filteredRequests, null, null, null, counts, null, 56, null));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestListViewModelMVI.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/flow/FlowCollector;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/core/work/RequestJobData;", "e", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestListViewModelMVI$loadRequests$1$1", f = "RequestListViewModelMVI.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestListViewModelMVI$loadRequests$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends RequestJobData>>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RequestListViewModelMVI this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RequestListViewModelMVI requestListViewModelMVI, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.this$0 = requestListViewModelMVI;
        }

        public final Object invoke(FlowCollector<? super List<RequestJobData>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = th;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MutableStateFlow mutableStateFlow;
            MutableStateFlow mutableStateFlow2;
            Throwable e = (Throwable) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    mutableStateFlow = this.this$0._state;
                    mutableStateFlow2 = this.this$0._state;
                    mutableStateFlow.setValue(RequestListViewModelMVI.ViewState.copy$default((RequestListViewModelMVI.ViewState) mutableStateFlow2.getValue(), false, null, null, null, null, null, null, "加载失败: " + e.getMessage(), 126, null));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}