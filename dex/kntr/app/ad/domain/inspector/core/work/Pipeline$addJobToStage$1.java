package kntr.app.ad.domain.inspector.core.work;

import kntr.app.ad.domain.inspector.core.StateManager;
import kntr.app.ad.domain.inspector.core.util.DateTimeUtils;
import kntr.app.ad.domain.inspector.model.InspectorInfo;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Pipeline.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.inspector.core.work.Pipeline$addJobToStage$1", f = "Pipeline.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class Pipeline$addJobToStage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IJob $job;
    int label;
    final /* synthetic */ Pipeline this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pipeline$addJobToStage$1(IJob iJob, Pipeline pipeline, Continuation<? super Pipeline$addJobToStage$1> continuation) {
        super(2, continuation);
        this.$job = iJob;
        this.this$0 = pipeline;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Pipeline$addJobToStage$1(this.$job, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Pipeline.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it", "Lkntr/app/ad/domain/inspector/core/work/IJobData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.ad.domain.inspector.core.work.Pipeline$addJobToStage$1$1", f = "Pipeline.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.ad.domain.inspector.core.work.Pipeline$addJobToStage$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<IJobData, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ Pipeline this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Pipeline pipeline, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = pipeline;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(IJobData iJobData, Continuation<? super Unit> continuation) {
            return create(iJobData, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    InspectorInfo inspector = StateManager.INSTANCE.getInspector(this.this$0.getId());
                    if (inspector != null) {
                        InspectorInfo newInspector = InspectorInfo.copy$default(inspector, null, null, DateTimeUtils.INSTANCE.currentTimeMillis(), 3, null);
                        newInspector.setPipeline$inspector_debug(inspector.getPipeline());
                        StateManager.INSTANCE.addInspectorInfo(newInspector);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (FlowKt.collectLatest(this.$job.getDataFlow(), new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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