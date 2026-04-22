package kntr.app.ad.ui.inspector.ui.main.console.viewmodel;

import java.util.List;
import java.util.Map;
import kntr.app.ad.domain.inspector.core.work.PrintJobData;
import kntr.app.ad.ui.inspector.ui.main.console.viewmodel.ConsoleListViewModel;
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
/* compiled from: ConsoleListViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.ui.inspector.ui.main.console.viewmodel.ConsoleListViewModel$loadPrintJobs$1", f = "ConsoleListViewModel.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ConsoleListViewModel$loadPrintJobs$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConsoleListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsoleListViewModel$loadPrintJobs$1(ConsoleListViewModel consoleListViewModel, Continuation<? super ConsoleListViewModel$loadPrintJobs$1> continuation) {
        super(2, continuation);
        this.this$0 = consoleListViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConsoleListViewModel$loadPrintJobs$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Flow allPrintJobDataFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                allPrintJobDataFlow = this.this$0.getAllPrintJobDataFlow();
                Flow flow = FlowKt.catch(allPrintJobDataFlow, new AnonymousClass1(this.this$0, null));
                final ConsoleListViewModel consoleListViewModel = this.this$0;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: kntr.app.ad.ui.inspector.ui.main.console.viewmodel.ConsoleListViewModel$loadPrintJobs$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((List) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(List<PrintJobData> list, Continuation<? super Unit> continuation) {
                        MutableStateFlow mutableStateFlow;
                        MutableStateFlow mutableStateFlow2;
                        Map typeCounts;
                        List filteredPrintJobs;
                        MutableStateFlow mutableStateFlow3;
                        mutableStateFlow = ConsoleListViewModel.this.printJobs;
                        mutableStateFlow.setValue(list);
                        mutableStateFlow2 = ConsoleListViewModel.this._state;
                        ConsoleListViewModel.ViewState currentState = (ConsoleListViewModel.ViewState) mutableStateFlow2.getValue();
                        typeCounts = ConsoleListViewModel.this.calculateTypeStats(list);
                        filteredPrintJobs = ConsoleListViewModel.this.applyFilters(list, currentState.getSelectedPrintType(), currentState.getSearchText());
                        mutableStateFlow3 = ConsoleListViewModel.this._state;
                        mutableStateFlow3.setValue(ConsoleListViewModel.ViewState.copy$default(currentState, false, list, filteredPrintJobs, null, null, typeCounts, null, 24, null));
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
    /* compiled from: ConsoleListViewModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/flow/FlowCollector;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/core/work/PrintJobData;", "e", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.ad.ui.inspector.ui.main.console.viewmodel.ConsoleListViewModel$loadPrintJobs$1$1", f = "ConsoleListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.ad.ui.inspector.ui.main.console.viewmodel.ConsoleListViewModel$loadPrintJobs$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends PrintJobData>>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ConsoleListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ConsoleListViewModel consoleListViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.this$0 = consoleListViewModel;
        }

        public final Object invoke(FlowCollector<? super List<PrintJobData>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
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
                    mutableStateFlow.setValue(ConsoleListViewModel.ViewState.copy$default((ConsoleListViewModel.ViewState) mutableStateFlow2.getValue(), false, null, null, null, null, null, "加载失败: " + e.getMessage(), 62, null));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}