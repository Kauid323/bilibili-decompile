package kntr.base.mod.internal;

import java.util.concurrent.CancellationException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.KDownloader.KDownloader.IDownloader;
import kntr.base.mod.internal.KModImpl;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.io.files.Path;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KModImpl.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.internal.KModImpl$JobManager$download$1", f = "KModImpl.kt", i = {0, 0, 0}, l = {447}, m = "invokeSuspend", n = {"$this$flow", "c", "task"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class KModImpl$JobManager$download$1 extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends Long, ? extends Long>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $md5;
    final /* synthetic */ Path $path;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ KModImpl.JobManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModImpl$JobManager$download$1(KModImpl.JobManager jobManager, String str, Path path, String str2, Continuation<? super KModImpl$JobManager$download$1> continuation) {
        super(2, continuation);
        this.this$0 = jobManager;
        this.$url = str;
        this.$path = path;
        this.$md5 = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kModImpl$JobManager$download$1 = new KModImpl$JobManager$download$1(this.this$0, this.$url, this.$path, this.$md5, continuation);
        kModImpl$JobManager$download$1.L$0 = obj;
        return kModImpl$JobManager$download$1;
    }

    public final Object invoke(FlowCollector<? super Pair<Long, Long>> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CancellationException e;
        IDownloader.Task task;
        FlowCollector $this$flow = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ReceiveChannel Channel$default = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
                IDownloader.Task task2 = this.this$0.getDownloader().create(this.$url, this.$path.toString(), "kmod").md5(this.$md5).addListener(new IDownloader.DownloadListener() { // from class: kntr.base.mod.internal.KModImpl$JobManager$download$1$task$1
                    @Override // kntr.base.KDownloader.KDownloader.IDownloader.DownloadListener
                    public /* bridge */ void onCancel() {
                        IDownloader.DownloadListener.CC.$default$onCancel(this);
                    }

                    @Override // kntr.base.KDownloader.KDownloader.IDownloader.DownloadListener
                    public /* bridge */ void onPause() {
                        IDownloader.DownloadListener.CC.$default$onPause(this);
                    }

                    @Override // kntr.base.KDownloader.KDownloader.IDownloader.DownloadListener
                    public void onError(IDownloader.Info.Error result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        Channel$default.close(result.getThrowable());
                    }

                    @Override // kntr.base.KDownloader.KDownloader.IDownloader.DownloadListener
                    public void onFinish(IDownloader.Info.Success result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        SendChannel.DefaultImpls.close$default(Channel$default, (Throwable) null, 1, (Object) null);
                    }

                    @Override // kntr.base.KDownloader.KDownloader.IDownloader.DownloadListener
                    public void onLoading(IDownloader.Info.Loading info) {
                        Intrinsics.checkNotNullParameter(info, "info");
                        Channel$default.trySend-JP2dKIU(new Pair(Long.valueOf(info.getLoadedSize()), Long.valueOf(info.getTotalSize())));
                    }
                }).build();
                task2.enqueue();
                try {
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(Channel$default);
                    this.L$2 = task2;
                    this.label = 1;
                    if (FlowKt.emitAll($this$flow, Channel$default, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                } catch (CancellationException e2) {
                    e = e2;
                    task = task2;
                    this.this$0.getDownloader().cancel(task.getTaskId());
                    throw e;
                }
            case 1:
                task = (IDownloader.Task) this.L$2;
                Channel channel = (Channel) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                } catch (CancellationException e3) {
                    e = e3;
                    this.this$0.getDownloader().cancel(task.getTaskId());
                    throw e;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}