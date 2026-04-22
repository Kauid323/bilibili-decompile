package io.ktor.util;

import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteReadChannelOperations_jvmKt;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.io.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EncodersJvm.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.EncodersJvmKt$inflate$1", f = "EncodersJvm.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {78, 95, 96, 106, 113, 119, 131}, m = "invokeSuspend", n = {"$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "magic", "format", "flags", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "magic", "format", "flags", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "S$0", "B$0", "B$1", "L$0", "L$1", "L$2", "L$3", "L$4", "S$0", "B$0", "B$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class EncodersJvmKt$inflate$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $gzip;
    final /* synthetic */ ByteReadChannel $source;
    byte B$0;
    byte B$1;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    short S$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncodersJvmKt$inflate$1(boolean z, ByteReadChannel byteReadChannel, Continuation<? super EncodersJvmKt$inflate$1> continuation) {
        super(2, continuation);
        this.$gzip = z;
        this.$source = byteReadChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> encodersJvmKt$inflate$1 = new EncodersJvmKt$inflate$1(this.$gzip, this.$source, continuation);
        encodersJvmKt$inflate$1.L$0 = obj;
        return encodersJvmKt$inflate$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0375 A[Catch: all -> 0x0488, TRY_LEAVE, TryCatch #2 {all -> 0x0488, blocks: (B:102:0x036f, B:104:0x0375, B:112:0x03be, B:114:0x03c2, B:119:0x03cf, B:124:0x03f2, B:130:0x03fc, B:131:0x0425, B:132:0x0426, B:133:0x0432, B:134:0x0433, B:135:0x045a, B:136:0x045b, B:140:0x0478, B:141:0x0483, B:83:0x02f4, B:85:0x02fa, B:87:0x0300, B:95:0x0353, B:73:0x02aa, B:75:0x02b2, B:99:0x0362, B:101:0x036a, B:143:0x0487), top: B:156:0x02f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03be A[Catch: all -> 0x0488, TRY_ENTER, TryCatch #2 {all -> 0x0488, blocks: (B:102:0x036f, B:104:0x0375, B:112:0x03be, B:114:0x03c2, B:119:0x03cf, B:124:0x03f2, B:130:0x03fc, B:131:0x0425, B:132:0x0426, B:133:0x0432, B:134:0x0433, B:135:0x045a, B:136:0x045b, B:140:0x0478, B:141:0x0483, B:83:0x02f4, B:85:0x02fa, B:87:0x0300, B:95:0x0353, B:73:0x02aa, B:75:0x02b2, B:99:0x0362, B:101:0x036a, B:143:0x0487), top: B:156:0x02f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02b2 A[Catch: all -> 0x0488, TRY_LEAVE, TryCatch #2 {all -> 0x0488, blocks: (B:102:0x036f, B:104:0x0375, B:112:0x03be, B:114:0x03c2, B:119:0x03cf, B:124:0x03f2, B:130:0x03fc, B:131:0x0425, B:132:0x0426, B:133:0x0432, B:134:0x0433, B:135:0x045a, B:136:0x045b, B:140:0x0478, B:141:0x0483, B:83:0x02f4, B:85:0x02fa, B:87:0x0300, B:95:0x0353, B:73:0x02aa, B:75:0x02b2, B:99:0x0362, B:101:0x036a, B:143:0x0487), top: B:156:0x02f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02df A[Catch: all -> 0x035d, TRY_LEAVE, TryCatch #6 {all -> 0x035d, blocks: (B:79:0x02d7, B:81:0x02df), top: B:163:0x02d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02fa A[Catch: all -> 0x0488, TryCatch #2 {all -> 0x0488, blocks: (B:102:0x036f, B:104:0x0375, B:112:0x03be, B:114:0x03c2, B:119:0x03cf, B:124:0x03f2, B:130:0x03fc, B:131:0x0425, B:132:0x0426, B:133:0x0432, B:134:0x0433, B:135:0x045a, B:136:0x045b, B:140:0x0478, B:141:0x0483, B:83:0x02f4, B:85:0x02fa, B:87:0x0300, B:95:0x0353, B:73:0x02aa, B:75:0x02b2, B:99:0x0362, B:101:0x036a, B:143:0x0487), top: B:156:0x02f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0362 A[Catch: all -> 0x0488, TryCatch #2 {all -> 0x0488, blocks: (B:102:0x036f, B:104:0x0375, B:112:0x03be, B:114:0x03c2, B:119:0x03cf, B:124:0x03f2, B:130:0x03fc, B:131:0x0425, B:132:0x0426, B:133:0x0432, B:134:0x0433, B:135:0x045a, B:136:0x045b, B:140:0x0478, B:141:0x0483, B:83:0x02f4, B:85:0x02fa, B:87:0x0300, B:95:0x0353, B:73:0x02aa, B:75:0x02b2, B:99:0x0362, B:101:0x036a, B:143:0x0487), top: B:156:0x02f4 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x039b -> B:157:0x03a0). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x02f1 -> B:156:0x02f4). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0326 -> B:161:0x032f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x0358 -> B:73:0x02aa). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ByteBuffer readBuffer;
        ByteBuffer writeBuffer;
        Inflater inflater;
        Object $result;
        WriterScope $this$writer;
        ByteBuffer writeBuffer2;
        CRC32 checksum;
        Object $result2;
        Object $result3;
        WriterScope $this$writer2;
        ByteBuffer readBuffer2;
        ByteBuffer readBuffer3;
        Inflater inflater2;
        CRC32 checksum2;
        short magic;
        byte format;
        byte readByte;
        int flags;
        CRC32 checksum3;
        Inflater inflater3;
        ByteBuffer readBuffer4;
        Object $result4;
        ByteBuffer readBuffer5;
        CRC32 checksum4;
        byte format2;
        Inflater inflater4;
        byte format3;
        WriterScope $this$writer3;
        ByteBuffer writeBuffer3;
        short magic2;
        long extraLen;
        WriterScope $this$writer4;
        ByteBuffer readBuffer6;
        boolean has;
        boolean has2;
        boolean has3;
        Ref.IntRef totalSize;
        EncodersJvmKt$inflate$1 encodersJvmKt$inflate$1;
        CRC32 checksum5;
        WriterScope $this$writer5;
        Object $result5;
        EncodersJvmKt$inflate$1 encodersJvmKt$inflate$12;
        Ref.IntRef totalSize2;
        Object $result6;
        WriterScope $this$writer6;
        CRC32 checksum6;
        int i;
        Object inflateTo;
        WriterScope $this$writer7;
        ByteBuffer readBuffer7;
        Ref.IntRef totalSize3;
        ByteBuffer writeBuffer4;
        Inflater inflater5;
        Object $result7;
        Object $result8;
        CRC32 checksum7;
        Ref.IntRef intRef;
        int i2;
        Object inflateTo2;
        Ref.IntRef totalSize4;
        Object $result9;
        Object $result10;
        EncodersJvmKt$inflate$1 encodersJvmKt$inflate$13;
        Ref.IntRef intRef2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    $result = obj;
                    $this$writer = (WriterScope) this.L$0;
                    ByteBuffer readBuffer8 = (ByteBuffer) ByteBufferPoolKt.getKtorDefaultPool().borrow();
                    writeBuffer2 = (ByteBuffer) ByteBufferPoolKt.getKtorDefaultPool().borrow();
                    Inflater inflater6 = new Inflater(true);
                    checksum = new CRC32();
                    if (this.$gzip) {
                        this.L$0 = $this$writer;
                        this.L$1 = readBuffer8;
                        this.L$2 = writeBuffer2;
                        this.L$3 = inflater6;
                        this.L$4 = checksum;
                        this.label = 1;
                        Object readPacket = ByteReadChannelOperationsKt.readPacket(this.$source, 10, (Continuation) this);
                        if (readPacket == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result2 = $result;
                        $result3 = readPacket;
                        $this$writer2 = $this$writer;
                        readBuffer2 = readBuffer8;
                        readBuffer3 = writeBuffer2;
                        inflater2 = inflater6;
                        checksum2 = checksum;
                        Source header = (Source) $result3;
                        magic = ByteReadPacketKt.readShortLittleEndian(header);
                        format = header.readByte();
                        readByte = header.readByte();
                        ByteReadPacketKt.discard$default(header, 0L, 1, (Object) null);
                        if ((readByte & 4) == 0) {
                            this.L$0 = $this$writer2;
                            this.L$1 = readBuffer2;
                            this.L$2 = readBuffer3;
                            this.L$3 = inflater2;
                            this.L$4 = checksum2;
                            this.S$0 = magic;
                            this.B$0 = format;
                            this.B$1 = readByte;
                            this.label = 2;
                            $result4 = ByteReadChannelOperationsKt.readShort(this.$source, (Continuation) this);
                            if ($result4 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            readBuffer5 = readBuffer2;
                            checksum4 = checksum2;
                            format2 = readByte;
                            WriterScope writerScope = $this$writer2;
                            inflater4 = inflater2;
                            format3 = format;
                            $this$writer3 = writerScope;
                            writeBuffer3 = readBuffer3;
                            magic2 = magic;
                            extraLen = ((Number) $result4).shortValue();
                            this.L$0 = $this$writer3;
                            this.L$1 = readBuffer5;
                            this.L$2 = writeBuffer3;
                            this.L$3 = inflater4;
                            this.L$4 = checksum4;
                            this.S$0 = magic2;
                            this.B$0 = format3;
                            this.B$1 = format2;
                            this.label = 3;
                            if (ByteReadChannelOperationsKt.discardExact(this.$source, extraLen, (Continuation) this) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result = $result2;
                            $this$writer4 = $this$writer3;
                            readBuffer6 = readBuffer5;
                            flags = format2;
                            checksum3 = checksum4;
                            inflater3 = inflater4;
                            $this$writer = $this$writer4;
                            ByteBuffer byteBuffer = readBuffer6;
                            format = format3;
                            writeBuffer2 = writeBuffer3;
                            magic = magic2;
                            readBuffer4 = byteBuffer;
                            if (!(magic == -29921)) {
                                throw new IllegalStateException(("GZIP magic invalid: " + ((int) magic)).toString());
                            }
                            if (!(format == 8)) {
                                throw new IllegalStateException(("Deflater method unsupported: " + ((int) format) + '.').toString());
                            }
                            has = EncodersJvmKt.has(flags, 8);
                            if (has) {
                                throw new IllegalStateException("Gzip file name not supported".toString());
                            }
                            has2 = EncodersJvmKt.has(flags, 16);
                            if (has2) {
                                throw new IllegalStateException("Gzip file comment not supported".toString());
                            }
                            has3 = EncodersJvmKt.has(flags, 2);
                            if (has3) {
                                this.L$0 = $this$writer;
                                this.L$1 = readBuffer4;
                                this.L$2 = writeBuffer2;
                                this.L$3 = inflater3;
                                this.L$4 = checksum3;
                                this.label = 4;
                                if (ByteReadChannelOperationsKt.discardExact(this.$source, 2L, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                checksum = checksum3;
                                readBuffer = readBuffer4;
                                inflater = inflater3;
                                try {
                                    totalSize = new Ref.IntRef();
                                    encodersJvmKt$inflate$1 = this;
                                    checksum5 = checksum;
                                    WriterScope writerScope2 = $this$writer;
                                    writeBuffer = writeBuffer2;
                                    $this$writer5 = writerScope2;
                                    if (encodersJvmKt$inflate$1.$source.isClosedForRead()) {
                                        encodersJvmKt$inflate$1.L$0 = $this$writer5;
                                        encodersJvmKt$inflate$1.L$1 = readBuffer;
                                        encodersJvmKt$inflate$1.L$2 = writeBuffer;
                                        encodersJvmKt$inflate$1.L$3 = inflater;
                                        encodersJvmKt$inflate$1.L$4 = checksum5;
                                        encodersJvmKt$inflate$1.L$5 = totalSize;
                                        encodersJvmKt$inflate$1.L$6 = null;
                                        encodersJvmKt$inflate$1.label = 5;
                                        Object readAvailable = ByteReadChannelOperations_jvmKt.readAvailable(encodersJvmKt$inflate$1.$source, readBuffer, (Continuation) encodersJvmKt$inflate$1);
                                        if (readAvailable == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        Ref.IntRef intRef3 = totalSize;
                                        $result6 = $result;
                                        $result5 = readAvailable;
                                        encodersJvmKt$inflate$12 = encodersJvmKt$inflate$1;
                                        totalSize2 = intRef3;
                                        try {
                                            if (((Number) $result5).intValue() <= 0) {
                                                try {
                                                    readBuffer.flip();
                                                    inflater.setInput(readBuffer.array(), readBuffer.position(), readBuffer.remaining());
                                                    if (!inflater.needsInput() || inflater.finished()) {
                                                        readBuffer.compact();
                                                        if (encodersJvmKt$inflate$1.$source.isClosedForRead()) {
                                                            Throwable it = encodersJvmKt$inflate$1.$source.getClosedCause();
                                                            if (it != null) {
                                                                throw it;
                                                            }
                                                            readBuffer.flip();
                                                            $this$writer6 = $this$writer5;
                                                            checksum6 = checksum5;
                                                            if (!inflater.finished()) {
                                                                i2 = totalSize.element;
                                                                encodersJvmKt$inflate$1.L$0 = $this$writer6;
                                                                encodersJvmKt$inflate$1.L$1 = readBuffer;
                                                                encodersJvmKt$inflate$1.L$2 = writeBuffer;
                                                                encodersJvmKt$inflate$1.L$3 = inflater;
                                                                encodersJvmKt$inflate$1.L$4 = checksum6;
                                                                encodersJvmKt$inflate$1.L$5 = totalSize;
                                                                encodersJvmKt$inflate$1.L$6 = totalSize;
                                                                encodersJvmKt$inflate$1.I$0 = i2;
                                                                encodersJvmKt$inflate$1.label = 7;
                                                                inflateTo2 = EncodersJvmKt.inflateTo(inflater, $this$writer6.getChannel(), writeBuffer, checksum6, (Continuation) encodersJvmKt$inflate$1);
                                                                if (inflateTo2 == coroutine_suspended) {
                                                                    return coroutine_suspended;
                                                                }
                                                                totalSize4 = totalSize;
                                                                $result9 = $result;
                                                                $result10 = inflateTo2;
                                                                encodersJvmKt$inflate$13 = encodersJvmKt$inflate$1;
                                                                intRef2 = totalSize4;
                                                                try {
                                                                    intRef2.element = i2 + ((Number) $result10).intValue();
                                                                    readBuffer.position(readBuffer.limit() - inflater.getRemaining());
                                                                    $result = $result9;
                                                                    encodersJvmKt$inflate$1 = encodersJvmKt$inflate$13;
                                                                    totalSize = totalSize4;
                                                                    if (!inflater.finished()) {
                                                                        if (encodersJvmKt$inflate$1.$gzip) {
                                                                            if (!(readBuffer.remaining() == 8)) {
                                                                                throw new IllegalStateException(("Expected 8 bytes in the trailer. Actual: " + readBuffer.remaining() + " $").toString());
                                                                            }
                                                                            readBuffer.order(ByteOrder.LITTLE_ENDIAN);
                                                                            int expectedChecksum = readBuffer.getInt(readBuffer.position());
                                                                            int expectedSize = readBuffer.getInt(readBuffer.position() + 4);
                                                                            int expectedChecksum2 = ((int) checksum6.getValue()) == expectedChecksum ? 1 : 0;
                                                                            if (expectedChecksum2 == 0) {
                                                                                throw new IllegalStateException("Gzip checksum invalid.".toString());
                                                                            }
                                                                            if (!(totalSize.element == expectedSize)) {
                                                                                throw new IllegalStateException(("Gzip size invalid. Expected " + expectedSize + ", actual " + totalSize.element).toString());
                                                                            }
                                                                        } else if (readBuffer.hasRemaining()) {
                                                                            throw new IllegalStateException("Check failed.".toString());
                                                                        }
                                                                        inflater.end();
                                                                        ByteBufferPoolKt.getKtorDefaultPool().recycle(readBuffer);
                                                                        ByteBufferPoolKt.getKtorDefaultPool().recycle(writeBuffer);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                } catch (Throwable th) {
                                                                    cause = th;
                                                                    try {
                                                                        throw cause;
                                                                    } catch (Throwable cause) {
                                                                        inflater.end();
                                                                        ByteBufferPoolKt.getKtorDefaultPool().recycle(readBuffer);
                                                                        ByteBufferPoolKt.getKtorDefaultPool().recycle(writeBuffer);
                                                                        throw cause;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        i = totalSize.element;
                                                        encodersJvmKt$inflate$1.L$0 = $this$writer5;
                                                        encodersJvmKt$inflate$1.L$1 = readBuffer;
                                                        encodersJvmKt$inflate$1.L$2 = writeBuffer;
                                                        encodersJvmKt$inflate$1.L$3 = inflater;
                                                        encodersJvmKt$inflate$1.L$4 = checksum5;
                                                        encodersJvmKt$inflate$1.L$5 = totalSize;
                                                        encodersJvmKt$inflate$1.L$6 = totalSize;
                                                        encodersJvmKt$inflate$1.I$0 = i;
                                                        encodersJvmKt$inflate$1.label = 6;
                                                        inflateTo = EncodersJvmKt.inflateTo(inflater, $this$writer5.getChannel(), writeBuffer, checksum5, (Continuation) encodersJvmKt$inflate$1);
                                                        if (inflateTo == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        $this$writer7 = $this$writer5;
                                                        readBuffer7 = readBuffer;
                                                        totalSize3 = totalSize;
                                                        writeBuffer4 = writeBuffer;
                                                        inflater5 = inflater;
                                                        $result7 = $result;
                                                        $result8 = inflateTo;
                                                        checksum7 = checksum5;
                                                        intRef = totalSize3;
                                                        try {
                                                            intRef.element = i + ((Number) $result8).intValue();
                                                            readBuffer7.position(readBuffer7.limit() - inflater5.getRemaining());
                                                            $result = $result7;
                                                            totalSize = totalSize3;
                                                            checksum5 = checksum7;
                                                            inflater = inflater5;
                                                            writeBuffer = writeBuffer4;
                                                            readBuffer = readBuffer7;
                                                            $this$writer5 = $this$writer7;
                                                            if (inflater.needsInput()) {
                                                            }
                                                            readBuffer.compact();
                                                            if (encodersJvmKt$inflate$1.$source.isClosedForRead()) {
                                                            }
                                                        } catch (Throwable th2) {
                                                            cause = th2;
                                                            inflater = inflater5;
                                                            writeBuffer = writeBuffer4;
                                                            readBuffer = readBuffer7;
                                                            throw cause;
                                                        }
                                                    }
                                                } catch (Throwable th3) {
                                                    cause = th3;
                                                    throw cause;
                                                }
                                                $result = $result6;
                                                totalSize = totalSize2;
                                                encodersJvmKt$inflate$1 = encodersJvmKt$inflate$12;
                                            } else {
                                                $result = $result6;
                                                totalSize = totalSize2;
                                                encodersJvmKt$inflate$1 = encodersJvmKt$inflate$12;
                                                if (encodersJvmKt$inflate$1.$source.isClosedForRead()) {
                                                }
                                            }
                                        } catch (Throwable th4) {
                                            cause = th4;
                                            throw cause;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    cause = th5;
                                    writeBuffer = writeBuffer2;
                                    throw cause;
                                }
                            } else {
                                checksum = checksum3;
                                readBuffer = readBuffer4;
                                inflater = inflater3;
                                totalSize = new Ref.IntRef();
                                encodersJvmKt$inflate$1 = this;
                                checksum5 = checksum;
                                WriterScope writerScope22 = $this$writer;
                                writeBuffer = writeBuffer2;
                                $this$writer5 = writerScope22;
                                if (encodersJvmKt$inflate$1.$source.isClosedForRead()) {
                                }
                            }
                        } else {
                            flags = readByte;
                            $result = $result2;
                            checksum3 = checksum2;
                            inflater3 = inflater2;
                            writeBuffer2 = readBuffer3;
                            readBuffer4 = readBuffer2;
                            $this$writer = $this$writer2;
                            if (!(magic == -29921)) {
                            }
                        }
                    } else {
                        readBuffer = readBuffer8;
                        inflater = inflater6;
                        totalSize = new Ref.IntRef();
                        encodersJvmKt$inflate$1 = this;
                        checksum5 = checksum;
                        WriterScope writerScope222 = $this$writer;
                        writeBuffer = writeBuffer2;
                        $this$writer5 = writerScope222;
                        if (encodersJvmKt$inflate$1.$source.isClosedForRead()) {
                        }
                    }
                case 1:
                    $result3 = obj;
                    Inflater inflater7 = (Inflater) this.L$3;
                    ByteBuffer writeBuffer5 = (ByteBuffer) this.L$2;
                    ByteBuffer readBuffer9 = (ByteBuffer) this.L$1;
                    ResultKt.throwOnFailure($result3);
                    $this$writer2 = (WriterScope) this.L$0;
                    readBuffer2 = readBuffer9;
                    readBuffer3 = writeBuffer5;
                    inflater2 = inflater7;
                    checksum2 = (CRC32) this.L$4;
                    $result2 = $result3;
                    Source header2 = (Source) $result3;
                    magic = ByteReadPacketKt.readShortLittleEndian(header2);
                    format = header2.readByte();
                    readByte = header2.readByte();
                    ByteReadPacketKt.discard$default(header2, 0L, 1, (Object) null);
                    if ((readByte & 4) == 0) {
                    }
                    break;
                case 2:
                    $result4 = obj;
                    byte b = this.B$1;
                    byte format4 = this.B$0;
                    short magic3 = this.S$0;
                    Inflater inflater8 = (Inflater) this.L$3;
                    ByteBuffer writeBuffer6 = (ByteBuffer) this.L$2;
                    ByteBuffer readBuffer10 = (ByteBuffer) this.L$1;
                    $this$writer3 = (WriterScope) this.L$0;
                    ResultKt.throwOnFailure($result4);
                    readBuffer5 = readBuffer10;
                    writeBuffer3 = writeBuffer6;
                    inflater4 = inflater8;
                    checksum4 = (CRC32) this.L$4;
                    magic2 = magic3;
                    format3 = format4;
                    format2 = b;
                    $result2 = $result4;
                    extraLen = ((Number) $result4).shortValue();
                    this.L$0 = $this$writer3;
                    this.L$1 = readBuffer5;
                    this.L$2 = writeBuffer3;
                    this.L$3 = inflater4;
                    this.L$4 = checksum4;
                    this.S$0 = magic2;
                    this.B$0 = format3;
                    this.B$1 = format2;
                    this.label = 3;
                    if (ByteReadChannelOperationsKt.discardExact(this.$source, extraLen, (Continuation) this) != coroutine_suspended) {
                    }
                    break;
                case 3:
                    $result = obj;
                    format2 = this.B$1;
                    format3 = this.B$0;
                    magic2 = this.S$0;
                    checksum4 = (CRC32) this.L$4;
                    inflater4 = (Inflater) this.L$3;
                    writeBuffer3 = (ByteBuffer) this.L$2;
                    readBuffer6 = (ByteBuffer) this.L$1;
                    $this$writer4 = (WriterScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    flags = format2;
                    checksum3 = checksum4;
                    inflater3 = inflater4;
                    $this$writer = $this$writer4;
                    ByteBuffer byteBuffer2 = readBuffer6;
                    format = format3;
                    writeBuffer2 = writeBuffer3;
                    magic = magic2;
                    readBuffer4 = byteBuffer2;
                    if (!(magic == -29921)) {
                    }
                    break;
                case 4:
                    $result = obj;
                    checksum3 = (CRC32) this.L$4;
                    inflater3 = (Inflater) this.L$3;
                    writeBuffer2 = (ByteBuffer) this.L$2;
                    readBuffer4 = (ByteBuffer) this.L$1;
                    $this$writer = (WriterScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    checksum = checksum3;
                    readBuffer = readBuffer4;
                    inflater = inflater3;
                    totalSize = new Ref.IntRef();
                    encodersJvmKt$inflate$1 = this;
                    checksum5 = checksum;
                    WriterScope writerScope2222 = $this$writer;
                    writeBuffer = writeBuffer2;
                    $this$writer5 = writerScope2222;
                    if (encodersJvmKt$inflate$1.$source.isClosedForRead()) {
                    }
                    break;
                case 5:
                    $result5 = obj;
                    Ref.IntRef totalSize5 = (Ref.IntRef) this.L$5;
                    checksum5 = (CRC32) this.L$4;
                    inflater = (Inflater) this.L$3;
                    writeBuffer = (ByteBuffer) this.L$2;
                    readBuffer = (ByteBuffer) this.L$1;
                    $this$writer5 = (WriterScope) this.L$0;
                    ResultKt.throwOnFailure($result5);
                    encodersJvmKt$inflate$12 = this;
                    totalSize2 = totalSize5;
                    $result6 = $result5;
                    if (((Number) $result5).intValue() <= 0) {
                    }
                    break;
                case 6:
                    $result8 = obj;
                    int i3 = this.I$0;
                    intRef = (Ref.IntRef) this.L$6;
                    totalSize3 = (Ref.IntRef) this.L$5;
                    checksum7 = (CRC32) this.L$4;
                    inflater5 = (Inflater) this.L$3;
                    writeBuffer4 = (ByteBuffer) this.L$2;
                    readBuffer7 = (ByteBuffer) this.L$1;
                    $this$writer7 = (WriterScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result8);
                        i = i3;
                        encodersJvmKt$inflate$1 = this;
                        $result7 = $result8;
                        intRef.element = i + ((Number) $result8).intValue();
                        readBuffer7.position(readBuffer7.limit() - inflater5.getRemaining());
                        $result = $result7;
                        totalSize = totalSize3;
                        checksum5 = checksum7;
                        inflater = inflater5;
                        writeBuffer = writeBuffer4;
                        readBuffer = readBuffer7;
                        $this$writer5 = $this$writer7;
                        if (inflater.needsInput()) {
                        }
                        readBuffer.compact();
                        if (encodersJvmKt$inflate$1.$source.isClosedForRead()) {
                        }
                    } catch (Throwable th6) {
                        cause = th6;
                        inflater = inflater5;
                        writeBuffer = writeBuffer4;
                        readBuffer = readBuffer7;
                        throw cause;
                    }
                    break;
                case 7:
                    $result10 = obj;
                    int i4 = this.I$0;
                    intRef2 = (Ref.IntRef) this.L$6;
                    totalSize4 = (Ref.IntRef) this.L$5;
                    checksum6 = (CRC32) this.L$4;
                    inflater = (Inflater) this.L$3;
                    writeBuffer = (ByteBuffer) this.L$2;
                    readBuffer = (ByteBuffer) this.L$1;
                    $this$writer6 = (WriterScope) this.L$0;
                    ResultKt.throwOnFailure($result10);
                    encodersJvmKt$inflate$13 = this;
                    i2 = i4;
                    $result9 = $result10;
                    intRef2.element = i2 + ((Number) $result10).intValue();
                    readBuffer.position(readBuffer.limit() - inflater.getRemaining());
                    $result = $result9;
                    encodersJvmKt$inflate$1 = encodersJvmKt$inflate$13;
                    totalSize = totalSize4;
                    if (!inflater.finished()) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th7) {
            cause = th7;
        }
    }
}