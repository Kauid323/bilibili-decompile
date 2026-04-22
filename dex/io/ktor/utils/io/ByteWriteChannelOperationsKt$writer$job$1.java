package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteWriteChannelOperations.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
@DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelOperationsKt$writer$job$1", f = "ByteWriteChannelOperations.kt", i = {0, 0, 1, 3, 5}, l = {PropertyIDConstants.EnterTransitionName, PropertyIDConstants.PaddingInlineStart, PropertyIDConstants.PaddingInlineEnd, PropertyIDConstants.PaddingInlineStart, PropertyIDConstants.PaddingInlineEnd, PropertyIDConstants.PaddingInlineStart, PropertyIDConstants.PaddingInlineEnd}, m = "invokeSuspend", n = {"$this$launch", "nested", "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$1", "L$0", "L$0", "L$0"})
public final class ByteWriteChannelOperationsKt$writer$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<WriterScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ ByteChannel $channel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ByteWriteChannelOperationsKt$writer$job$1(Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object> function2, ByteChannel byteChannel, Continuation<? super ByteWriteChannelOperationsKt$writer$job$1> continuation) {
        super(2, continuation);
        this.$block = function2;
        this.$channel = byteChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> byteWriteChannelOperationsKt$writer$job$1 = new ByteWriteChannelOperationsKt$writer$job$1(this.$block, this.$channel, continuation);
        byteWriteChannelOperationsKt$writer$job$1.L$0 = obj;
        return byteWriteChannelOperationsKt$writer$job$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab A[Catch: all -> 0x005c, TRY_LEAVE, TryCatch #4 {all -> 0x005c, blocks: (B:25:0x0058, B:34:0x009a, B:36:0x00ab), top: B:87:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0113 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0125 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0126  */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v32, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ?? r1;
        CoroutineScope $this$launch;
        CompletableJob nested;
        Function2<WriterScope, Continuation<? super Unit>, Object> function2;
        WriterScope writerScope;
        Object obj;
        ByteChannel byteChannel;
        ByteChannel byteChannel2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                    Result.Companion companion = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                    return Unit.INSTANCE;
                }
            } catch (Throwable th2) {
                th = th2;
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                return Unit.INSTANCE;
            }
        } catch (Throwable th3) {
            Result.Companion companion3 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th3));
            r1 = i;
        }
        switch (i) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$launch2 = (CoroutineScope) this.L$0;
                Job Job = JobKt.Job(JobKt.getJob($this$launch2.getCoroutineContext()));
                try {
                    function2 = this.$block;
                    writerScope = new WriterScope(this.$channel, $this$launch2.getCoroutineContext().plus((CoroutineContext) Job));
                    this.L$0 = $this$launch2;
                    this.L$1 = Job;
                    this.label = 1;
                } catch (Throwable th4) {
                    cause = th4;
                    $this$launch = $this$launch2;
                    nested = Job;
                    try {
                        JobKt.cancel(nested, "Exception thrown while writing to channel", cause);
                        this.$channel.cancel(cause);
                        this.L$0 = $this$launch;
                        this.L$1 = null;
                        this.label = 4;
                        if (nested.join((Continuation) this) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        byteChannel2 = this.$channel;
                        Result.Companion companion4 = Result.Companion;
                        this.L$0 = null;
                        this.label = 5;
                        if (byteChannel2.flushAndClose(this) != coroutine_suspended) {
                        }
                    } catch (Throwable th5) {
                        this.L$0 = $this$launch;
                        this.L$1 = th5;
                        this.label = 6;
                        if (nested.join((Continuation) this) != coroutine_suspended) {
                            obj = th5;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    }
                }
                if (function2.invoke(writerScope, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$launch = $this$launch2;
                nested = Job;
                nested.complete();
                if (JobKt.getJob($this$launch.getCoroutineContext()).isCancelled()) {
                    this.$channel.cancel(JobKt.getJob($this$launch.getCoroutineContext()).getCancellationException());
                }
                this.L$0 = $this$launch;
                this.L$1 = null;
                this.label = 2;
                if (nested.join((Continuation) this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteChannel = this.$channel;
                Result.Companion companion5 = Result.Companion;
                this.L$0 = null;
                this.label = 3;
                if (byteChannel.flushAndClose(this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Result.constructor-impl(Unit.INSTANCE);
                return Unit.INSTANCE;
            case 1:
                nested = (CompletableJob) this.L$1;
                $this$launch = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    nested.complete();
                    if (JobKt.getJob($this$launch.getCoroutineContext()).isCancelled()) {
                    }
                    this.L$0 = $this$launch;
                    this.L$1 = null;
                    this.label = 2;
                    if (nested.join((Continuation) this) != coroutine_suspended) {
                    }
                } catch (Throwable th6) {
                    cause = th6;
                    JobKt.cancel(nested, "Exception thrown while writing to channel", cause);
                    this.$channel.cancel(cause);
                    this.L$0 = $this$launch;
                    this.L$1 = null;
                    this.label = 4;
                    if (nested.join((Continuation) this) != coroutine_suspended) {
                    }
                }
                break;
            case 2:
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result);
                byteChannel = this.$channel;
                Result.Companion companion52 = Result.Companion;
                this.L$0 = null;
                this.label = 3;
                if (byteChannel.flushAndClose(this) != coroutine_suspended) {
                }
                break;
            case 3:
                ResultKt.throwOnFailure($result);
                Result.constructor-impl(Unit.INSTANCE);
                return Unit.INSTANCE;
            case 4:
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result);
                byteChannel2 = this.$channel;
                Result.Companion companion42 = Result.Companion;
                this.L$0 = null;
                this.label = 5;
                if (byteChannel2.flushAndClose(this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Result.constructor-impl(Unit.INSTANCE);
                return Unit.INSTANCE;
            case 5:
                ResultKt.throwOnFailure($result);
                Result.constructor-impl(Unit.INSTANCE);
                return Unit.INSTANCE;
            case 6:
                obj = (Throwable) this.L$1;
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result);
                ByteChannel byteChannel3 = this.$channel;
                Result.Companion companion6 = Result.Companion;
                this.L$0 = obj;
                this.L$1 = null;
                this.label = 7;
                if (byteChannel3.flushAndClose(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = obj;
                Result.constructor-impl(Unit.INSTANCE);
                r1 = i;
                throw r1;
            case 7:
                ?? r12 = (Throwable) this.L$0;
                ResultKt.throwOnFailure($result);
                i = r12;
                Result.constructor-impl(Unit.INSTANCE);
                r1 = i;
                throw r1;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}