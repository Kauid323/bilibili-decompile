package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.io.Buffer;
import kotlinx.io.Source;

/* compiled from: ByteReadChannel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\u001a\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "", "min", "", "awaitContent", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)V", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForRead", "()Z", "Lkotlinx/io/Source;", "getReadBuffer", "()Lkotlinx/io/Source;", "getReadBuffer$annotations", "()V", "readBuffer", "Companion", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public interface ByteReadChannel {
    public static final Companion Companion = Companion.$$INSTANCE;

    Object awaitContent(int i, Continuation<? super Boolean> continuation);

    void cancel(Throwable th);

    Throwable getClosedCause();

    /* renamed from: getReadBuffer */
    Source mo1388getReadBuffer();

    boolean isClosedForRead();

    /* compiled from: ByteReadChannel.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
    /* loaded from: /data/np/file-convert/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7.dex */
    public static final class DefaultImpls {
        @InternalAPI
        public static /* synthetic */ void getReadBuffer$annotations() {
        }

        public static /* synthetic */ Object awaitContent$default(ByteReadChannel byteReadChannel, int i, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 1;
                }
                return byteReadChannel.awaitContent(i, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitContent");
        }
    }

    /* compiled from: ByteReadChannel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel$Companion;", "", "<init>", "()V", "Lio/ktor/utils/io/ByteReadChannel;", "Empty", "Lio/ktor/utils/io/ByteReadChannel;", "getEmpty", "()Lio/ktor/utils/io/ByteReadChannel;", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
    /* loaded from: /data/np/file-convert/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ByteReadChannel Empty = new ByteReadChannel() { // from class: io.ktor.utils.io.ByteReadChannel$Companion$Empty$1
            private final Throwable closedCause;
            private final Source readBuffer = new Buffer();

            @InternalAPI
            public static /* synthetic */ void getReadBuffer$annotations() {
            }

            @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
            public Throwable getClosedCause() {
                return this.closedCause;
            }

            @Override // io.ktor.utils.io.ByteReadChannel
            public boolean isClosedForRead() {
                return true;
            }

            @Override // io.ktor.utils.io.ByteReadChannel
            /* renamed from: getReadBuffer */
            public Source mo1388getReadBuffer() {
                return this.readBuffer;
            }

            @Override // io.ktor.utils.io.ByteReadChannel
            public Object awaitContent(int min, Continuation<? super Boolean> continuation) {
                return Boxing.boxBoolean(false);
            }

            @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
            public void cancel(Throwable cause) {
            }
        };

        private Companion() {
        }

        public final ByteReadChannel getEmpty() {
            return Empty;
        }
    }
}