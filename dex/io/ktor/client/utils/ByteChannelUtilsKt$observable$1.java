package io.ktor.client.utils;

import io.ktor.client.content.ProgressListener;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ByteArrayPoolKt;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannelUtils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.utils.ByteChannelUtilsKt$observable$1", f = "ByteChannelUtils.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3}, l = {22, 24, 26, 31}, m = "invokeSuspend", n = {"$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "bytesSend", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "bytesSend", "read", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "bytesSend", "$this$useInstance$iv", "instance$iv"}, s = {"L$0", "L$1", "L$5", "L$6", "J$0", "L$0", "L$1", "L$5", "L$6", "J$0", "I$0", "L$0", "L$1", "L$5", "L$6", "J$0", "L$0", "L$1"})
public final class ByteChannelUtilsKt$observable$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $contentLength;
    final /* synthetic */ ProgressListener $listener;
    final /* synthetic */ ByteReadChannel $this_observable;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelUtilsKt$observable$1(ByteReadChannel byteReadChannel, ProgressListener progressListener, Long l, Continuation<? super ByteChannelUtilsKt$observable$1> continuation) {
        super(2, continuation);
        this.$this_observable = byteReadChannel;
        this.$listener = progressListener;
        this.$contentLength = l;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> byteChannelUtilsKt$observable$1 = new ByteChannelUtilsKt$observable$1(this.$this_observable, this.$listener, this.$contentLength, continuation);
        byteChannelUtilsKt$observable$1.L$0 = obj;
        return byteChannelUtilsKt$observable$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x00d4: MOVE  (r5 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY] A[D('$this$useInstance$iv' io.ktor.utils.io.pool.ObjectPool)]), block:B:23:0x00d2 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00d3: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY] A[D('instance$iv' java.lang.Object)]), block:B:23:0x00d2 */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015d A[Catch: all -> 0x01d5, TRY_LEAVE, TryCatch #6 {all -> 0x01d5, blocks: (B:35:0x0155, B:37:0x015d), top: B:94:0x0155 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x01b1 -> B:46:0x01c0). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x01cb -> B:92:0x0103). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object instance$iv;
        Object instance$iv2;
        ObjectPool $this$useInstance$iv;
        ObjectPool $this$useInstance$iv2;
        boolean z;
        long bytesSend;
        ByteReadChannel byteReadChannel;
        ProgressListener progressListener;
        Long l;
        byte[] byteArray;
        ByteChannelUtilsKt$observable$1 byteChannelUtilsKt$observable$1;
        Object $result2;
        boolean z2;
        WriterScope $this$writer;
        Object $result3;
        Object $result4;
        Object instance$iv3;
        Object $result5;
        Object instance$iv4;
        boolean z3;
        Object $result6;
        boolean z4;
        int read;
        long bytesSend2;
        byte[] byteArray2;
        ObjectPool $this$useInstance$iv3;
        ByteChannelUtilsKt$observable$1 byteChannelUtilsKt$observable$12;
        boolean z5;
        Long l2;
        ProgressListener progressListener2;
        WriterScope $this$writer2;
        boolean z6;
        Object $result7;
        long bytesSend3;
        int read2;
        ByteChannelUtilsKt$observable$1 byteChannelUtilsKt$observable$13;
        WriterScope $this$writer3;
        long bytesSend4;
        ByteReadChannel byteReadChannel2;
        boolean z7;
        ProgressListener progressListener3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th) {
            th = th;
            instance$iv2 = instance$iv;
            $this$useInstance$iv2 = $this$useInstance$iv;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                WriterScope $this$writer4 = (WriterScope) this.L$0;
                $this$useInstance$iv2 = ByteArrayPoolKt.getByteArrayPool();
                ByteReadChannel byteReadChannel3 = this.$this_observable;
                ProgressListener progressListener4 = this.$listener;
                Long l3 = this.$contentLength;
                z = false;
                Object instance$iv5 = $this$useInstance$iv2.borrow();
                try {
                    byte[] byteArray3 = (byte[]) instance$iv5;
                    bytesSend = 0;
                    byteReadChannel = byteReadChannel3;
                    progressListener = progressListener4;
                    l = l3;
                    instance$iv2 = instance$iv5;
                    byteArray = byteArray3;
                    byteChannelUtilsKt$observable$1 = this;
                    $result2 = coroutine_suspended;
                    z2 = false;
                    $this$writer = $this$writer4;
                    $result3 = $result;
                    try {
                        if (byteReadChannel.isClosedForRead()) {
                            try {
                                try {
                                    byteChannelUtilsKt$observable$1.L$0 = $this$writer;
                                    byteChannelUtilsKt$observable$1.L$1 = $this$useInstance$iv2;
                                    byteChannelUtilsKt$observable$1.L$2 = byteReadChannel;
                                    byteChannelUtilsKt$observable$1.L$3 = progressListener;
                                    byteChannelUtilsKt$observable$1.L$4 = l;
                                    byteChannelUtilsKt$observable$1.L$5 = instance$iv2;
                                    byteChannelUtilsKt$observable$1.L$6 = byteArray;
                                    byteChannelUtilsKt$observable$1.J$0 = bytesSend;
                                    byteChannelUtilsKt$observable$1.label = 1;
                                    Object readAvailable$default = ByteReadChannelOperationsKt.readAvailable$default(byteReadChannel, byteArray, 0, 0, byteChannelUtilsKt$observable$13, 6, (Object) null);
                                    if (readAvailable$default == $result2) {
                                        return $result2;
                                    }
                                    byteChannelUtilsKt$observable$1 = byteChannelUtilsKt$observable$13;
                                    progressListener = progressListener3;
                                    byteReadChannel = byteReadChannel2;
                                    z2 = z7;
                                    $this$writer = $this$writer3;
                                    bytesSend = bytesSend4;
                                    Object obj = $result3;
                                    $result5 = $result2;
                                    $result4 = readAvailable$default;
                                    z3 = z;
                                    instance$iv3 = instance$iv2;
                                    instance$iv4 = obj;
                                    try {
                                        read2 = ((Number) $result4).intValue();
                                        if (read2 <= 0) {
                                            boolean z8 = z2;
                                            ByteWriteChannel channel = $this$writer.getChannel();
                                            byteChannelUtilsKt$observable$1.L$0 = $this$writer;
                                            byteChannelUtilsKt$observable$1.L$1 = $this$useInstance$iv2;
                                            byteChannelUtilsKt$observable$1.L$2 = byteReadChannel;
                                            byteChannelUtilsKt$observable$1.L$3 = progressListener;
                                            byteChannelUtilsKt$observable$1.L$4 = l;
                                            byteChannelUtilsKt$observable$1.L$5 = instance$iv3;
                                            byteChannelUtilsKt$observable$1.L$6 = byteArray;
                                            byteChannelUtilsKt$observable$1.J$0 = bytesSend;
                                            byteChannelUtilsKt$observable$1.I$0 = read2;
                                            byteChannelUtilsKt$observable$1.label = 2;
                                            if (ByteWriteChannelOperationsKt.writeFully(channel, byteArray, 0, read2, byteChannelUtilsKt$observable$1) == $result5) {
                                                return $result5;
                                            }
                                            try {
                                                z5 = z8;
                                                coroutine_suspended = $result5;
                                                z4 = z3;
                                                l2 = l;
                                                ObjectPool objectPool = $this$useInstance$iv2;
                                                read = read2;
                                                $result6 = instance$iv4;
                                                instance$iv2 = instance$iv3;
                                                byteArray2 = byteArray;
                                                bytesSend2 = bytesSend;
                                                $this$useInstance$iv3 = objectPool;
                                                $this$writer2 = $this$writer;
                                                byteChannelUtilsKt$observable$12 = byteChannelUtilsKt$observable$1;
                                                progressListener2 = progressListener;
                                                byteChannelUtilsKt$observable$12.L$0 = $this$writer2;
                                                byteChannelUtilsKt$observable$12.L$1 = $this$useInstance$iv3;
                                                byteChannelUtilsKt$observable$12.L$2 = byteReadChannel;
                                                byteChannelUtilsKt$observable$12.L$3 = progressListener2;
                                                byteChannelUtilsKt$observable$12.L$4 = l2;
                                                byteChannelUtilsKt$observable$12.L$5 = instance$iv2;
                                                byteChannelUtilsKt$observable$12.L$6 = byteArray2;
                                                byteChannelUtilsKt$observable$12.J$0 = bytesSend3;
                                                byteChannelUtilsKt$observable$12.label = 3;
                                                if (progressListener2.onProgress(bytesSend3, l2, byteChannelUtilsKt$observable$12) != coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                $result2 = coroutine_suspended;
                                                byteArray = byteArray2;
                                                z2 = z6;
                                                z = z4;
                                                progressListener = progressListener2;
                                                byteChannelUtilsKt$observable$1 = byteChannelUtilsKt$observable$12;
                                                $this$writer = $this$writer2;
                                                $result3 = $result7;
                                                l = l2;
                                                $this$useInstance$iv2 = $this$useInstance$iv3;
                                                bytesSend = bytesSend3;
                                                if (byteReadChannel.isClosedForRead()) {
                                                    ByteChannelUtilsKt$observable$1 byteChannelUtilsKt$observable$14 = byteChannelUtilsKt$observable$1;
                                                    WriterScope $this$writer5 = $this$writer;
                                                    long bytesSend5 = bytesSend;
                                                    ProgressListener progressListener5 = progressListener;
                                                    try {
                                                        Throwable closedCause = byteReadChannel.getClosedCause();
                                                        ByteWriteChannelOperationsKt.close($this$writer5.getChannel(), closedCause);
                                                        try {
                                                            if (closedCause == null && bytesSend5 == 0) {
                                                                byteChannelUtilsKt$observable$14.L$0 = $this$useInstance$iv2;
                                                                byteChannelUtilsKt$observable$14.L$1 = instance$iv2;
                                                                byteChannelUtilsKt$observable$14.L$2 = null;
                                                                byteChannelUtilsKt$observable$14.L$3 = null;
                                                                byteChannelUtilsKt$observable$14.L$4 = null;
                                                                byteChannelUtilsKt$observable$14.L$5 = null;
                                                                byteChannelUtilsKt$observable$14.L$6 = null;
                                                                byteChannelUtilsKt$observable$14.label = 4;
                                                                if (progressListener5.onProgress(bytesSend5, l, byteChannelUtilsKt$observable$14) == $result2) {
                                                                    return $result2;
                                                                }
                                                                Unit unit = Unit.INSTANCE;
                                                                $this$useInstance$iv2.recycle(instance$iv2);
                                                                return Unit.INSTANCE;
                                                            }
                                                            Unit unit2 = Unit.INSTANCE;
                                                            $this$useInstance$iv2.recycle(instance$iv2);
                                                            return Unit.INSTANCE;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                        }
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                    }
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                $this$useInstance$iv2 = $this$useInstance$iv3;
                                            }
                                            z6 = z5;
                                            $result7 = $result6;
                                            bytesSend3 = bytesSend2 + read;
                                        } else {
                                            $result2 = $result5;
                                            $result3 = instance$iv4;
                                            instance$iv2 = instance$iv3;
                                            z = z3;
                                            if (byteReadChannel.isClosedForRead()) {
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        instance$iv2 = instance$iv3;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                            }
                            byteChannelUtilsKt$observable$13 = byteChannelUtilsKt$observable$1;
                            $this$writer3 = $this$writer;
                            bytesSend4 = bytesSend;
                            byteReadChannel2 = byteReadChannel;
                            z7 = z2;
                            progressListener3 = progressListener;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    instance$iv2 = instance$iv5;
                }
                $this$useInstance$iv2.recycle(instance$iv2);
                throw th;
            case 1:
                $result4 = $result;
                long bytesSend6 = this.J$0;
                byteArray = (byte[]) this.L$6;
                instance$iv3 = this.L$5;
                Long l4 = (Long) this.L$4;
                ProgressListener progressListener6 = (ProgressListener) this.L$3;
                ByteReadChannel byteReadChannel4 = (ByteReadChannel) this.L$2;
                ObjectPool $this$useInstance$iv4 = (ObjectPool) this.L$1;
                WriterScope $this$writer6 = (WriterScope) this.L$0;
                ResultKt.throwOnFailure($result4);
                progressListener = progressListener6;
                byteReadChannel = byteReadChannel4;
                $this$writer = $this$writer6;
                byteChannelUtilsKt$observable$1 = this;
                $result5 = coroutine_suspended;
                z2 = false;
                instance$iv4 = $result4;
                z3 = false;
                l = l4;
                $this$useInstance$iv2 = $this$useInstance$iv4;
                bytesSend = bytesSend6;
                read2 = ((Number) $result4).intValue();
                if (read2 <= 0) {
                }
                break;
            case 2:
                $result6 = $result;
                z4 = false;
                read = this.I$0;
                bytesSend2 = this.J$0;
                byteArray2 = (byte[]) this.L$6;
                Object instance$iv6 = this.L$5;
                Long l5 = (Long) this.L$4;
                ProgressListener progressListener7 = (ProgressListener) this.L$3;
                ByteReadChannel byteReadChannel5 = (ByteReadChannel) this.L$2;
                $this$useInstance$iv3 = (ObjectPool) this.L$1;
                WriterScope $this$writer7 = (WriterScope) this.L$0;
                try {
                    ResultKt.throwOnFailure($result6);
                    byteChannelUtilsKt$observable$12 = this;
                    z5 = false;
                    instance$iv2 = instance$iv6;
                    l2 = l5;
                    progressListener2 = progressListener7;
                    byteReadChannel = byteReadChannel5;
                    $this$writer2 = $this$writer7;
                    z6 = z5;
                    $result7 = $result6;
                    bytesSend3 = bytesSend2 + read;
                    byteChannelUtilsKt$observable$12.L$0 = $this$writer2;
                    byteChannelUtilsKt$observable$12.L$1 = $this$useInstance$iv3;
                    byteChannelUtilsKt$observable$12.L$2 = byteReadChannel;
                    byteChannelUtilsKt$observable$12.L$3 = progressListener2;
                    byteChannelUtilsKt$observable$12.L$4 = l2;
                    byteChannelUtilsKt$observable$12.L$5 = instance$iv2;
                    byteChannelUtilsKt$observable$12.L$6 = byteArray2;
                    byteChannelUtilsKt$observable$12.J$0 = bytesSend3;
                    byteChannelUtilsKt$observable$12.label = 3;
                    if (progressListener2.onProgress(bytesSend3, l2, byteChannelUtilsKt$observable$12) != coroutine_suspended) {
                    }
                } catch (Throwable th10) {
                    th = th10;
                    instance$iv2 = instance$iv6;
                    $this$useInstance$iv2 = $this$useInstance$iv3;
                    break;
                }
                break;
            case 3:
                long bytesSend7 = this.J$0;
                byteArray = (byte[]) this.L$6;
                Object instance$iv7 = this.L$5;
                Long l6 = (Long) this.L$4;
                ProgressListener progressListener8 = (ProgressListener) this.L$3;
                ByteReadChannel byteReadChannel6 = (ByteReadChannel) this.L$2;
                ObjectPool $this$useInstance$iv5 = (ObjectPool) this.L$1;
                WriterScope $this$writer8 = (WriterScope) this.L$0;
                ResultKt.throwOnFailure($result);
                progressListener = progressListener8;
                byteReadChannel = byteReadChannel6;
                $this$writer = $this$writer8;
                byteChannelUtilsKt$observable$1 = this;
                $result2 = coroutine_suspended;
                z2 = false;
                instance$iv2 = instance$iv7;
                z = false;
                $result3 = $result;
                l = l6;
                $this$useInstance$iv2 = $this$useInstance$iv5;
                bytesSend = bytesSend7;
                if (byteReadChannel.isClosedForRead()) {
                }
                $this$useInstance$iv2.recycle(instance$iv2);
                throw th;
            case 4:
                instance$iv2 = this.L$1;
                $this$useInstance$iv2 = (ObjectPool) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    Unit unit22 = Unit.INSTANCE;
                    $this$useInstance$iv2.recycle(instance$iv2);
                    return Unit.INSTANCE;
                } catch (Throwable th11) {
                    th = th11;
                    break;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}