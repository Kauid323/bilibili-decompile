package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.websocket.Frame;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: PingPong.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a[\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame$Pong;", "outgoing", "Lio/ktor/websocket/Frame$Ping;", "ponger", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/SendChannel;)Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame;", Column.INVAL_VALUE, "periodMillis", "timeoutMillis", "Lkotlin/Function2;", "Lio/ktor/websocket/CloseReason;", "Lkotlin/coroutines/Continuation;", Column.INVAL_VALUE, Column.INVAL_VALUE, "onTimeout", "pinger", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/SendChannel;JJLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/CoroutineName;", "PongerCoroutineName", "Lkotlinx/coroutines/CoroutineName;", "PingerCoroutineName", "ktor-websockets"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PingPongKt {
    private static final CoroutineName PongerCoroutineName = new CoroutineName("ws-ponger");
    private static final CoroutineName PingerCoroutineName = new CoroutineName("ws-pinger");

    public static final SendChannel<Frame.Ping> ponger(CoroutineScope $this$ponger, SendChannel<? super Frame.Pong> sendChannel) {
        Intrinsics.checkNotNullParameter($this$ponger, "<this>");
        Intrinsics.checkNotNullParameter(sendChannel, "outgoing");
        SendChannel<Frame.Ping> Channel$default = ChannelKt.Channel$default(5, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        BuildersKt.launch$default($this$ponger, PongerCoroutineName, (CoroutineStart) null, new PingPongKt$ponger$1(Channel$default, sendChannel, null), 2, (Object) null);
        return Channel$default;
    }

    public static final SendChannel<Frame.Pong> pinger(CoroutineScope $this$pinger, SendChannel<? super Frame> sendChannel, long periodMillis, long timeoutMillis, Function2<? super CloseReason, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter($this$pinger, "<this>");
        Intrinsics.checkNotNullParameter(sendChannel, "outgoing");
        Intrinsics.checkNotNullParameter(function2, "onTimeout");
        final CompletableJob actorJob = JobKt.Job$default((Job) null, 1, (Object) null);
        SendChannel<Frame.Pong> Channel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        BuildersKt.launch$default($this$pinger, actorJob.plus(PingerCoroutineName), (CoroutineStart) null, new PingPongKt$pinger$1(periodMillis, timeoutMillis, function2, Channel$default, sendChannel, null), 2, (Object) null);
        Job job = $this$pinger.getCoroutineContext().get(Job.Key);
        Intrinsics.checkNotNull(job);
        job.invokeOnCompletion(new Function1() { // from class: io.ktor.websocket.PingPongKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit pinger$lambda$0;
                pinger$lambda$0 = PingPongKt.pinger$lambda$0(actorJob, (Throwable) obj);
                return pinger$lambda$0;
            }
        });
        return Channel$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pinger$lambda$0(CompletableJob $actorJob, Throwable it) {
        Job.DefaultImpls.cancel$default((Job) $actorJob, (CancellationException) null, 1, (Object) null);
        return Unit.INSTANCE;
    }
}