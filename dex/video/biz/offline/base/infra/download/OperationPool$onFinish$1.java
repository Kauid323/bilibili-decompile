package video.biz.offline.base.infra.download;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.download.OperationPool$onFinish$1;
import video.biz.offline.base.infra.utils.DownloadLog;

/* compiled from: OperationPool.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.download.OperationPool$onFinish$1", f = "OperationPool.kt", i = {}, l = {162, 170}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OperationPool$onFinish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TaskGroup $group;
    int label;
    final /* synthetic */ OperationPool this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationPool$onFinish$1(OperationPool operationPool, TaskGroup taskGroup, Continuation<? super OperationPool$onFinish$1> continuation) {
        super(2, continuation);
        this.this$0 = operationPool;
        this.$group = taskGroup;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OperationPool$onFinish$1(this.this$0, this.$group, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperationPool.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.base.infra.download.OperationPool$onFinish$1$1", f = "OperationPool.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: video.biz.offline.base.infra.download.OperationPool$onFinish$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ TaskGroup $group;
        int label;
        final /* synthetic */ OperationPool this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TaskGroup taskGroup, OperationPool operationPool, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$group = taskGroup;
            this.this$0 = operationPool;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$group, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            List list;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    new DownloadLog(this.$group.getKey()).info("TaskGroup finished");
                    this.$group.cancel();
                    list = this.this$0.activeTasks;
                    final TaskGroup taskGroup = this.$group;
                    return Boxing.boxBoolean(CollectionsKt.removeAll(list, new Function1() { // from class: video.biz.offline.base.infra.download.OperationPool$onFinish$1$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            boolean invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = OperationPool$onFinish$1.AnonymousClass1.invokeSuspend$lambda$0(TaskGroup.this, (Pair) obj);
                            return Boolean.valueOf(invokeSuspend$lambda$0);
                        }
                    }));
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$0(TaskGroup $group, Pair it) {
            return Intrinsics.areEqual(it.getFirst(), $group);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        CoroutineContext coroutineContext;
        DownloadProgressCallback downloadProgressCallback;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                coroutineContext = this.this$0.operationDispatcher;
                this.label = 1;
                if (BuildersKt.withContext(coroutineContext, new AnonymousClass1(this.$group, this.this$0, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                downloadProgressCallback = this.this$0.progressCallback;
                downloadProgressCallback.downloadComplete(this.$group.getVideo());
                this.label = 2;
                if (this.this$0.autoDownloadNext((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                downloadProgressCallback = this.this$0.progressCallback;
                downloadProgressCallback.downloadComplete(this.$group.getVideo());
                this.label = 2;
                if (this.this$0.autoDownloadNext((Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}