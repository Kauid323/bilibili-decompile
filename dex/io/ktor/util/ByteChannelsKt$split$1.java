package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.pool.ByteArrayPoolKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* compiled from: ByteChannels.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1", f = "ByteChannels.kt", i = {0, 0, 1, 1}, l = {27, 32}, m = "invokeSuspend", n = {"$this$launch", "buffer", "$this$launch", "buffer"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class ByteChannelsKt$split$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteChannel $first;
    final /* synthetic */ ByteChannel $second;
    final /* synthetic */ ByteReadChannel $this_split;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelsKt$split$1(ByteReadChannel byteReadChannel, ByteChannel byteChannel, ByteChannel byteChannel2, Continuation<? super ByteChannelsKt$split$1> continuation) {
        super(2, continuation);
        this.$this_split = byteReadChannel;
        this.$first = byteChannel;
        this.$second = byteChannel2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> byteChannelsKt$split$1 = new ByteChannelsKt$split$1(this.$this_split, this.$first, this.$second, continuation);
        byteChannelsKt$split$1.L$0 = obj;
        return byteChannelsKt$split$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059 A[Catch: all -> 0x00ed, TRY_LEAVE, TryCatch #3 {all -> 0x00ed, blocks: (B:15:0x0051, B:17:0x0059, B:31:0x00d0, B:36:0x00ec), top: B:51:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007b A[Catch: all -> 0x00cc, TRY_LEAVE, TryCatch #2 {all -> 0x00cc, blocks: (B:21:0x0073, B:23:0x007b), top: B:49:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d0 A[Catch: all -> 0x00ed, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x00ed, blocks: (B:15:0x0051, B:17:0x0059, B:31:0x00d0, B:36:0x00ec), top: B:51:0x0051 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00c6 -> B:51:0x0051). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00c9 -> B:51:0x0051). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ByteChannelsKt$split$1 byteChannelsKt$split$1;
        byte[] buffer;
        Object $result;
        CoroutineScope $this$launch;
        byte[] buffer2;
        Object $result2;
        CoroutineScope $this$launch2;
        Object $result3;
        int read;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th) {
            it = th;
            byteChannelsKt$split$1 = this;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                $result = obj;
                $this$launch = (CoroutineScope) this.L$0;
                byteChannelsKt$split$1 = this;
                buffer2 = (byte[]) ByteArrayPoolKt.getByteArrayPool().borrow();
                try {
                } catch (Throwable th2) {
                    it = th2;
                    buffer = buffer2;
                    try {
                        byteChannelsKt$split$1.$this_split.cancel(it);
                        byteChannelsKt$split$1.$first.cancel(it);
                        byteChannelsKt$split$1.$second.cancel(it);
                        ByteArrayPoolKt.getByteArrayPool().recycle(buffer);
                        byteChannelsKt$split$1.$first.close();
                        byteChannelsKt$split$1.$second.close();
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        ByteArrayPoolKt.getByteArrayPool().recycle(buffer);
                        byteChannelsKt$split$1.$first.close();
                        byteChannelsKt$split$1.$second.close();
                        throw th3;
                    }
                }
                if (byteChannelsKt$split$1.$this_split.isClosedForRead()) {
                    byteChannelsKt$split$1.L$0 = $this$launch;
                    byteChannelsKt$split$1.L$1 = buffer2;
                    byteChannelsKt$split$1.label = 1;
                    Object readAvailable$default = ByteReadChannelOperationsKt.readAvailable$default(byteChannelsKt$split$1.$this_split, buffer2, 0, 0, (Continuation) byteChannelsKt$split$1, 6, (Object) null);
                    if (readAvailable$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$launch2 = $this$launch;
                    $result3 = $result;
                    $result2 = readAvailable$default;
                    try {
                        read = ((Number) $result2).intValue();
                        if (read <= 0) {
                            Deferred[] deferredArr = {BuildersKt.async$default($this$launch2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(byteChannelsKt$split$1.$first, buffer2, read, null), 3, (Object) null), BuildersKt.async$default($this$launch2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(byteChannelsKt$split$1.$second, buffer2, read, null), 3, (Object) null)};
                            byteChannelsKt$split$1.L$0 = $this$launch2;
                            byteChannelsKt$split$1.L$1 = buffer2;
                            byteChannelsKt$split$1.label = 2;
                            if (AwaitKt.awaitAll(kotlin.collections.CollectionsKt.listOf(deferredArr), (Continuation) byteChannelsKt$split$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result = $result3;
                            $this$launch = $this$launch2;
                        } else {
                            $result = $result3;
                            $this$launch = $this$launch2;
                        }
                    } catch (Throwable th4) {
                        it = th4;
                        buffer = buffer2;
                        byteChannelsKt$split$1.$this_split.cancel(it);
                        byteChannelsKt$split$1.$first.cancel(it);
                        byteChannelsKt$split$1.$second.cancel(it);
                        ByteArrayPoolKt.getByteArrayPool().recycle(buffer);
                        byteChannelsKt$split$1.$first.close();
                        byteChannelsKt$split$1.$second.close();
                        return Unit.INSTANCE;
                    }
                    if (byteChannelsKt$split$1.$this_split.isClosedForRead()) {
                        Throwable it = byteChannelsKt$split$1.$this_split.getClosedCause();
                        if (it != null) {
                            throw it;
                        }
                        ByteArrayPoolKt.getByteArrayPool().recycle(buffer2);
                        byteChannelsKt$split$1.$first.close();
                        byteChannelsKt$split$1.$second.close();
                        return Unit.INSTANCE;
                    }
                }
            case 1:
                $result2 = obj;
                byte[] buffer3 = (byte[]) this.L$1;
                CoroutineScope $this$launch3 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result2);
                byteChannelsKt$split$1 = this;
                buffer2 = buffer3;
                $this$launch2 = $this$launch3;
                $result3 = $result2;
                read = ((Number) $result2).intValue();
                if (read <= 0) {
                }
                if (byteChannelsKt$split$1.$this_split.isClosedForRead()) {
                }
                break;
            case 2:
                $result = obj;
                byte[] buffer4 = (byte[]) this.L$1;
                CoroutineScope $this$launch4 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result);
                byteChannelsKt$split$1 = this;
                buffer2 = buffer4;
                $this$launch = $this$launch4;
                if (byteChannelsKt$split$1.$this_split.isClosedForRead()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteChannels.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1$1", f = "ByteChannels.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.util.ByteChannelsKt$split$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $buffer;
        final /* synthetic */ ByteChannel $first;
        final /* synthetic */ int $read;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ByteChannel byteChannel, byte[] bArr, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$first = byteChannel;
            this.$buffer = bArr;
            this.$read = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$first, this.$buffer, this.$read, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (ByteWriteChannelOperationsKt.writeFully(this.$first, this.$buffer, 0, this.$read, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteChannels.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1$2", f = "ByteChannels.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.util.ByteChannelsKt$split$1$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $buffer;
        final /* synthetic */ int $read;
        final /* synthetic */ ByteChannel $second;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ByteChannel byteChannel, byte[] bArr, int i, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$second = byteChannel;
            this.$buffer = bArr;
            this.$read = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$second, this.$buffer, this.$read, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (ByteWriteChannelOperationsKt.writeFully(this.$second, this.$buffer, 0, this.$read, (Continuation) this) == coroutine_suspended) {
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
}