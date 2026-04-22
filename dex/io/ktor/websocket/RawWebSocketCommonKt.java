package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.InternalAPI;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.MemoryKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* compiled from: RawWebSocketCommon.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a$\u0010\u000b\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0087@¢\u0006\u0004\b\u000b\u0010\f\u001a$\u0010\u0011\u001a\u00020\u0006*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0001H\u0087@¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/io/Source;", Column.INVAL_VALUE, "maskKey", "mask", "(Lkotlinx/io/Source;I)Lkotlinx/io/Source;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/websocket/Frame;", "frame", Column.INVAL_VALUE, "masking", Column.INVAL_VALUE, "writeFrame", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/websocket/Frame;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", Column.INVAL_VALUE, "maxFrameSize", "lastOpcode", "readFrame", "(Lio/ktor/utils/io/ByteReadChannel;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websockets"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RawWebSocketCommonKt {
    private static final Source mask(final Source $this$mask, final int maskKey) {
        return (Source) MemoryKt.withMemory(4, new Function1() { // from class: io.ktor.websocket.RawWebSocketCommonKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Source mask$lambda$2;
                mask$lambda$2 = RawWebSocketCommonKt.mask$lambda$2(maskKey, $this$mask, (byte[]) obj);
                return mask$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Source mask$lambda$2(int $maskKey, Source $this_mask, byte[] maskMemory) {
        Intrinsics.checkNotNullParameter(maskMemory, "maskMemory");
        MemoryKt.storeIntAt(maskMemory, 0, $maskKey);
        Source buffer = new Buffer();
        Sink $this$mask_u24lambda_u242_u24lambda_u241 = (Sink) buffer;
        int remaining = (int) ByteReadPacketKt.getRemaining($this_mask);
        for (int i = 0; i < remaining; i++) {
            int i2 = i;
            $this$mask_u24lambda_u242_u24lambda_u241.writeByte((byte) ($this_mask.readByte() ^ maskMemory[i2 % 4]));
        }
        return buffer;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0124 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0197 A[RETURN] */
    @InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object writeFrame(ByteWriteChannel byteWriteChannel, Frame frame, boolean masking, Continuation<? super Unit> continuation) {
        RawWebSocketCommonKt$writeFrame$1 rawWebSocketCommonKt$writeFrame$1;
        ByteWriteChannel $this$writeFrame;
        Frame frame2;
        int length;
        boolean masking2;
        int at$iv;
        boolean masking3;
        int formattedLength;
        ByteWriteChannel $this$writeFrame2;
        Frame frame3;
        boolean masking4;
        Frame frame4;
        ByteWriteChannel $this$writeFrame3;
        Frame frame5;
        Source data;
        int maskKey;
        Source data2;
        ByteWriteChannel $this$writeFrame4;
        Source maskedData;
        if (continuation instanceof RawWebSocketCommonKt$writeFrame$1) {
            rawWebSocketCommonKt$writeFrame$1 = (RawWebSocketCommonKt$writeFrame$1) continuation;
            if ((rawWebSocketCommonKt$writeFrame$1.label & Integer.MIN_VALUE) != 0) {
                rawWebSocketCommonKt$writeFrame$1.label -= Integer.MIN_VALUE;
                Object $result = rawWebSocketCommonKt$writeFrame$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rawWebSocketCommonKt$writeFrame$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$writeFrame = byteWriteChannel;
                        frame2 = frame;
                        int length2 = frame2.getData().length;
                        boolean $this$flagAt$iv = frame2.getFin();
                        int i = $this$flagAt$iv ? 1 << 7 : 0;
                        boolean $this$flagAt$iv2 = frame2.getRsv1();
                        int i2 = i | ($this$flagAt$iv2 ? 1 << 6 : 0);
                        boolean $this$flagAt$iv3 = frame2.getRsv2();
                        int i3 = i2 | ($this$flagAt$iv3 ? 1 << 5 : 0);
                        boolean $this$flagAt$iv4 = frame2.getRsv3();
                        int flagsAndOpcode = i3 | ($this$flagAt$iv4 ? 1 << 4 : 0) | frame2.getFrameType().getOpcode();
                        rawWebSocketCommonKt$writeFrame$1.L$0 = $this$writeFrame;
                        rawWebSocketCommonKt$writeFrame$1.L$1 = frame2;
                        rawWebSocketCommonKt$writeFrame$1.Z$0 = masking;
                        rawWebSocketCommonKt$writeFrame$1.I$0 = length2;
                        rawWebSocketCommonKt$writeFrame$1.label = 1;
                        if (ByteWriteChannelOperationsKt.writeByte($this$writeFrame, (byte) flagsAndOpcode, rawWebSocketCommonKt$writeFrame$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        length = length2;
                        masking2 = masking;
                        int formattedLength2 = 126;
                        if (length >= 126) {
                            formattedLength2 = length;
                        } else if (length > 65535) {
                            formattedLength2 = 127;
                        }
                        boolean $this$flagAt$iv5 = masking2;
                        at$iv = (!$this$flagAt$iv5 ? 1 << 7 : 0) | formattedLength2;
                        rawWebSocketCommonKt$writeFrame$1.L$0 = $this$writeFrame;
                        rawWebSocketCommonKt$writeFrame$1.L$1 = frame2;
                        rawWebSocketCommonKt$writeFrame$1.Z$0 = masking2;
                        rawWebSocketCommonKt$writeFrame$1.I$0 = length;
                        rawWebSocketCommonKt$writeFrame$1.I$1 = formattedLength2;
                        rawWebSocketCommonKt$writeFrame$1.label = 2;
                        if (ByteWriteChannelOperationsKt.writeByte($this$writeFrame, (byte) at$iv, rawWebSocketCommonKt$writeFrame$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Frame frame6 = frame2;
                        masking3 = masking2;
                        formattedLength = formattedLength2;
                        $this$writeFrame2 = $this$writeFrame;
                        frame3 = frame6;
                        switch (formattedLength) {
                            case 126:
                                rawWebSocketCommonKt$writeFrame$1.L$0 = $this$writeFrame2;
                                rawWebSocketCommonKt$writeFrame$1.L$1 = frame3;
                                rawWebSocketCommonKt$writeFrame$1.Z$0 = masking3;
                                rawWebSocketCommonKt$writeFrame$1.label = 3;
                                if (ByteWriteChannelOperationsKt.writeShort($this$writeFrame2, (short) length, rawWebSocketCommonKt$writeFrame$1) != coroutine_suspended) {
                                    masking4 = masking3;
                                    frame4 = frame3;
                                    $this$writeFrame3 = $this$writeFrame2;
                                    frame3 = frame4;
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            case 127:
                                rawWebSocketCommonKt$writeFrame$1.L$0 = $this$writeFrame2;
                                rawWebSocketCommonKt$writeFrame$1.L$1 = frame3;
                                rawWebSocketCommonKt$writeFrame$1.Z$0 = masking3;
                                rawWebSocketCommonKt$writeFrame$1.label = 4;
                                if (ByteWriteChannelOperationsKt.writeLong($this$writeFrame2, length, rawWebSocketCommonKt$writeFrame$1) != coroutine_suspended) {
                                    masking4 = masking3;
                                    frame5 = frame3;
                                    $this$writeFrame3 = $this$writeFrame2;
                                    frame3 = frame5;
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            default:
                                masking4 = masking3;
                                $this$writeFrame3 = $this$writeFrame2;
                                break;
                        }
                        data = ByteReadPacketKt.ByteReadPacket$default(frame3.getData(), 0, 0, 6, (Object) null);
                        if (masking4) {
                            if (masking4) {
                                throw new NoWhenBranchMatchedException();
                            }
                            maskedData = data;
                            rawWebSocketCommonKt$writeFrame$1.L$0 = null;
                            rawWebSocketCommonKt$writeFrame$1.L$1 = null;
                            rawWebSocketCommonKt$writeFrame$1.label = 6;
                            if (ByteWriteChannelOperationsKt.writePacket($this$writeFrame3, maskedData, rawWebSocketCommonKt$writeFrame$1) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        }
                        maskKey = Random.Default.nextInt();
                        rawWebSocketCommonKt$writeFrame$1.L$0 = $this$writeFrame3;
                        rawWebSocketCommonKt$writeFrame$1.L$1 = data;
                        rawWebSocketCommonKt$writeFrame$1.I$0 = maskKey;
                        rawWebSocketCommonKt$writeFrame$1.label = 5;
                        if (ByteWriteChannelOperationsKt.writeInt($this$writeFrame3, maskKey, rawWebSocketCommonKt$writeFrame$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        data2 = data;
                        $this$writeFrame4 = $this$writeFrame3;
                        $this$writeFrame3 = $this$writeFrame4;
                        data = mask(data2, maskKey);
                        maskedData = data;
                        rawWebSocketCommonKt$writeFrame$1.L$0 = null;
                        rawWebSocketCommonKt$writeFrame$1.L$1 = null;
                        rawWebSocketCommonKt$writeFrame$1.label = 6;
                        if (ByteWriteChannelOperationsKt.writePacket($this$writeFrame3, maskedData, rawWebSocketCommonKt$writeFrame$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        int formattedLength3 = rawWebSocketCommonKt$writeFrame$1.I$0;
                        boolean masking5 = rawWebSocketCommonKt$writeFrame$1.Z$0;
                        frame2 = (Frame) rawWebSocketCommonKt$writeFrame$1.L$1;
                        $this$writeFrame = (ByteWriteChannel) rawWebSocketCommonKt$writeFrame$1.L$0;
                        ResultKt.throwOnFailure($result);
                        length = formattedLength3;
                        masking2 = masking5;
                        int formattedLength22 = 126;
                        if (length >= 126) {
                        }
                        boolean $this$flagAt$iv52 = masking2;
                        at$iv = (!$this$flagAt$iv52 ? 1 << 7 : 0) | formattedLength22;
                        rawWebSocketCommonKt$writeFrame$1.L$0 = $this$writeFrame;
                        rawWebSocketCommonKt$writeFrame$1.L$1 = frame2;
                        rawWebSocketCommonKt$writeFrame$1.Z$0 = masking2;
                        rawWebSocketCommonKt$writeFrame$1.I$0 = length;
                        rawWebSocketCommonKt$writeFrame$1.I$1 = formattedLength22;
                        rawWebSocketCommonKt$writeFrame$1.label = 2;
                        if (ByteWriteChannelOperationsKt.writeByte($this$writeFrame, (byte) at$iv, rawWebSocketCommonKt$writeFrame$1) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        formattedLength = rawWebSocketCommonKt$writeFrame$1.I$1;
                        length = rawWebSocketCommonKt$writeFrame$1.I$0;
                        masking3 = rawWebSocketCommonKt$writeFrame$1.Z$0;
                        frame3 = (Frame) rawWebSocketCommonKt$writeFrame$1.L$1;
                        $this$writeFrame2 = (ByteWriteChannel) rawWebSocketCommonKt$writeFrame$1.L$0;
                        ResultKt.throwOnFailure($result);
                        switch (formattedLength) {
                        }
                        data = ByteReadPacketKt.ByteReadPacket$default(frame3.getData(), 0, 0, 6, (Object) null);
                        if (masking4) {
                        }
                        break;
                    case 3:
                        masking4 = rawWebSocketCommonKt$writeFrame$1.Z$0;
                        frame4 = (Frame) rawWebSocketCommonKt$writeFrame$1.L$1;
                        $this$writeFrame3 = (ByteWriteChannel) rawWebSocketCommonKt$writeFrame$1.L$0;
                        ResultKt.throwOnFailure($result);
                        frame3 = frame4;
                        data = ByteReadPacketKt.ByteReadPacket$default(frame3.getData(), 0, 0, 6, (Object) null);
                        if (masking4) {
                        }
                        break;
                    case 4:
                        masking4 = rawWebSocketCommonKt$writeFrame$1.Z$0;
                        frame5 = (Frame) rawWebSocketCommonKt$writeFrame$1.L$1;
                        $this$writeFrame3 = (ByteWriteChannel) rawWebSocketCommonKt$writeFrame$1.L$0;
                        ResultKt.throwOnFailure($result);
                        frame3 = frame5;
                        data = ByteReadPacketKt.ByteReadPacket$default(frame3.getData(), 0, 0, 6, (Object) null);
                        if (masking4) {
                        }
                        break;
                    case 5:
                        maskKey = rawWebSocketCommonKt$writeFrame$1.I$0;
                        data2 = (Source) rawWebSocketCommonKt$writeFrame$1.L$1;
                        $this$writeFrame4 = (ByteWriteChannel) rawWebSocketCommonKt$writeFrame$1.L$0;
                        ResultKt.throwOnFailure($result);
                        $this$writeFrame3 = $this$writeFrame4;
                        data = mask(data2, maskKey);
                        maskedData = data;
                        rawWebSocketCommonKt$writeFrame$1.L$0 = null;
                        rawWebSocketCommonKt$writeFrame$1.L$1 = null;
                        rawWebSocketCommonKt$writeFrame$1.label = 6;
                        if (ByteWriteChannelOperationsKt.writePacket($this$writeFrame3, maskedData, rawWebSocketCommonKt$writeFrame$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 6:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        rawWebSocketCommonKt$writeFrame$1 = new RawWebSocketCommonKt$writeFrame$1(continuation);
        Object $result2 = rawWebSocketCommonKt$writeFrame$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rawWebSocketCommonKt$writeFrame$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0215  */
    @InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readFrame(ByteReadChannel byteReadChannel, long j, int i, Continuation<? super Frame> continuation) {
        RawWebSocketCommonKt$readFrame$1 rawWebSocketCommonKt$readFrame$1;
        ByteReadChannel $this$readFrame;
        long maxFrameSize;
        int flagsAndOpcode;
        Object readByte;
        Object readByte2;
        ByteReadChannel $this$readFrame2;
        int lastOpcode;
        byte b;
        long maxFrameSize2;
        byte byteValue;
        int rawOpcode;
        FrameType frameType;
        FrameType frameType2;
        int maskAndLength;
        Object readShort;
        byte b2;
        int maskAndLength2;
        Object readLong;
        byte b3;
        int maskAndLength3;
        long length;
        long maxFrameSize3;
        byte b4;
        ByteReadChannel $this$readFrame3;
        FrameType frameType3;
        int maskAndLength4;
        FrameType frameType4;
        int maskKey;
        Object readInt;
        Object readPacket;
        int maskKey2;
        int maskKey3;
        FrameType frameType5;
        int flagsAndOpcode2;
        if (continuation instanceof RawWebSocketCommonKt$readFrame$1) {
            rawWebSocketCommonKt$readFrame$1 = (RawWebSocketCommonKt$readFrame$1) continuation;
            if ((rawWebSocketCommonKt$readFrame$1.label & Integer.MIN_VALUE) != 0) {
                rawWebSocketCommonKt$readFrame$1.label -= Integer.MIN_VALUE;
                Object $result = rawWebSocketCommonKt$readFrame$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rawWebSocketCommonKt$readFrame$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$readFrame = byteReadChannel;
                        maxFrameSize = j;
                        flagsAndOpcode = i;
                        rawWebSocketCommonKt$readFrame$1.L$0 = $this$readFrame;
                        rawWebSocketCommonKt$readFrame$1.J$0 = maxFrameSize;
                        rawWebSocketCommonKt$readFrame$1.I$0 = flagsAndOpcode;
                        rawWebSocketCommonKt$readFrame$1.label = 1;
                        readByte = ByteReadChannelOperationsKt.readByte($this$readFrame, rawWebSocketCommonKt$readFrame$1);
                        if (readByte == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        byte byteValue2 = ((Number) readByte).byteValue();
                        rawWebSocketCommonKt$readFrame$1.L$0 = $this$readFrame;
                        rawWebSocketCommonKt$readFrame$1.J$0 = maxFrameSize;
                        rawWebSocketCommonKt$readFrame$1.I$0 = flagsAndOpcode;
                        rawWebSocketCommonKt$readFrame$1.B$0 = byteValue2;
                        rawWebSocketCommonKt$readFrame$1.label = 2;
                        readByte2 = ByteReadChannelOperationsKt.readByte($this$readFrame, rawWebSocketCommonKt$readFrame$1);
                        if (readByte2 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$readFrame2 = $this$readFrame;
                        long j2 = maxFrameSize;
                        lastOpcode = flagsAndOpcode;
                        b = byteValue2;
                        maxFrameSize2 = j2;
                        byteValue = ((Number) readByte2).byteValue();
                        rawOpcode = b & 15;
                        if (rawOpcode == 0 || lastOpcode != 0) {
                            int opcode = rawOpcode != 0 ? lastOpcode : rawOpcode;
                            frameType = FrameType.Companion.get(opcode);
                            if (frameType == null) {
                                frameType2 = frameType;
                                if (rawOpcode == 0 || lastOpcode == 0 || frameType2.getControlFrame()) {
                                    maskAndLength = (b & 128) != 0 ? 1 : 0;
                                    if (frameType2.getControlFrame() && maskAndLength == 0) {
                                        throw new ProtocolViolationException("control frames can't be fragmented");
                                    }
                                    int length2 = byteValue & Byte.MAX_VALUE;
                                    switch (length2) {
                                        case 126:
                                            rawWebSocketCommonKt$readFrame$1.L$0 = $this$readFrame2;
                                            rawWebSocketCommonKt$readFrame$1.L$1 = frameType2;
                                            rawWebSocketCommonKt$readFrame$1.J$0 = maxFrameSize2;
                                            rawWebSocketCommonKt$readFrame$1.B$0 = b;
                                            rawWebSocketCommonKt$readFrame$1.B$1 = byteValue;
                                            rawWebSocketCommonKt$readFrame$1.I$0 = maskAndLength;
                                            rawWebSocketCommonKt$readFrame$1.label = 3;
                                            readShort = ByteReadChannelOperationsKt.readShort($this$readFrame2, rawWebSocketCommonKt$readFrame$1);
                                            if (readShort != coroutine_suspended) {
                                                int i2 = maskAndLength;
                                                b2 = byteValue;
                                                maskAndLength2 = i2;
                                                length = ((Number) readShort).shortValue() & 65535;
                                                maxFrameSize3 = maxFrameSize2;
                                                b4 = b;
                                                byte b5 = b2;
                                                maskAndLength = maskAndLength2;
                                                byteValue = b5;
                                                FrameType frameType6 = frameType2;
                                                $this$readFrame3 = $this$readFrame2;
                                                frameType3 = frameType6;
                                                break;
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        case 127:
                                            rawWebSocketCommonKt$readFrame$1.L$0 = $this$readFrame2;
                                            rawWebSocketCommonKt$readFrame$1.L$1 = frameType2;
                                            rawWebSocketCommonKt$readFrame$1.J$0 = maxFrameSize2;
                                            rawWebSocketCommonKt$readFrame$1.B$0 = b;
                                            rawWebSocketCommonKt$readFrame$1.B$1 = byteValue;
                                            rawWebSocketCommonKt$readFrame$1.I$0 = maskAndLength;
                                            rawWebSocketCommonKt$readFrame$1.label = 4;
                                            readLong = ByteReadChannelOperationsKt.readLong($this$readFrame2, rawWebSocketCommonKt$readFrame$1);
                                            if (readLong != coroutine_suspended) {
                                                int i3 = maskAndLength;
                                                b3 = byteValue;
                                                maskAndLength3 = i3;
                                                maxFrameSize3 = maxFrameSize2;
                                                length = ((Number) readLong).longValue();
                                                b4 = b;
                                                byte b6 = b3;
                                                maskAndLength = maskAndLength3;
                                                byteValue = b6;
                                                FrameType frameType7 = frameType2;
                                                $this$readFrame3 = $this$readFrame2;
                                                frameType3 = frameType7;
                                                break;
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        default:
                                            length = length2;
                                            maxFrameSize3 = maxFrameSize2;
                                            b4 = b;
                                            $this$readFrame3 = $this$readFrame2;
                                            frameType3 = frameType2;
                                            break;
                                    }
                                    if (frameType3.getControlFrame() || length <= 125) {
                                        maskAndLength4 = (byteValue & 128) != 0 ? 1 : 0;
                                        if (maskAndLength4 != 1) {
                                            if (maskAndLength4 == 0) {
                                                frameType4 = frameType3;
                                                maskKey = -1;
                                                if (length <= 2147483647L) {
                                                }
                                                throw new FrameTooBigException(length);
                                            }
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        rawWebSocketCommonKt$readFrame$1.L$0 = $this$readFrame3;
                                        rawWebSocketCommonKt$readFrame$1.L$1 = frameType3;
                                        rawWebSocketCommonKt$readFrame$1.J$0 = maxFrameSize3;
                                        rawWebSocketCommonKt$readFrame$1.B$0 = b4;
                                        rawWebSocketCommonKt$readFrame$1.I$0 = maskAndLength;
                                        rawWebSocketCommonKt$readFrame$1.J$1 = length;
                                        rawWebSocketCommonKt$readFrame$1.label = 5;
                                        readInt = ByteReadChannelOperationsKt.readInt($this$readFrame3, rawWebSocketCommonKt$readFrame$1);
                                        if (readInt == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        maskKey = ((Number) readInt).intValue();
                                        frameType4 = frameType3;
                                        if (length <= 2147483647L || length > maxFrameSize3) {
                                            throw new FrameTooBigException(length);
                                        }
                                        rawWebSocketCommonKt$readFrame$1.L$0 = frameType4;
                                        rawWebSocketCommonKt$readFrame$1.L$1 = null;
                                        rawWebSocketCommonKt$readFrame$1.B$0 = b4;
                                        rawWebSocketCommonKt$readFrame$1.I$0 = maskAndLength;
                                        rawWebSocketCommonKt$readFrame$1.I$1 = maskKey;
                                        rawWebSocketCommonKt$readFrame$1.label = 6;
                                        readPacket = ByteReadChannelOperationsKt.readPacket($this$readFrame3, (int) length, rawWebSocketCommonKt$readFrame$1);
                                        if (readPacket == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        maskKey2 = maskKey;
                                        maskKey3 = maskAndLength;
                                        frameType5 = frameType4;
                                        flagsAndOpcode2 = b4;
                                        Source data = (Source) readPacket;
                                        if (maskKey2 != -1) {
                                            data = mask(data, maskKey2);
                                        }
                                        Source maskedData = data;
                                        return Frame.Companion.byType(maskKey3 == 0, frameType5, SourcesKt.readByteArray(maskedData), (flagsAndOpcode2 & 64) == 0, (flagsAndOpcode2 & 32) == 0, (flagsAndOpcode2 & 16) == 0);
                                    }
                                    throw new ProtocolViolationException("control frames can't be larger than 125 bytes");
                                }
                                throw new ProtocolViolationException("Can't start new data frame before finishing previous one");
                            }
                            throw new IllegalStateException("Unsupported opcode: " + opcode);
                        }
                        throw new ProtocolViolationException("Can't continue finished frames");
                    case 1:
                        flagsAndOpcode = rawWebSocketCommonKt$readFrame$1.I$0;
                        maxFrameSize = rawWebSocketCommonKt$readFrame$1.J$0;
                        $this$readFrame = (ByteReadChannel) rawWebSocketCommonKt$readFrame$1.L$0;
                        ResultKt.throwOnFailure($result);
                        readByte = $result;
                        byte byteValue22 = ((Number) readByte).byteValue();
                        rawWebSocketCommonKt$readFrame$1.L$0 = $this$readFrame;
                        rawWebSocketCommonKt$readFrame$1.J$0 = maxFrameSize;
                        rawWebSocketCommonKt$readFrame$1.I$0 = flagsAndOpcode;
                        rawWebSocketCommonKt$readFrame$1.B$0 = byteValue22;
                        rawWebSocketCommonKt$readFrame$1.label = 2;
                        readByte2 = ByteReadChannelOperationsKt.readByte($this$readFrame, rawWebSocketCommonKt$readFrame$1);
                        if (readByte2 != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        byte b7 = rawWebSocketCommonKt$readFrame$1.B$0;
                        lastOpcode = rawWebSocketCommonKt$readFrame$1.I$0;
                        long maxFrameSize4 = rawWebSocketCommonKt$readFrame$1.J$0;
                        ResultKt.throwOnFailure($result);
                        readByte2 = $result;
                        $this$readFrame2 = (ByteReadChannel) rawWebSocketCommonKt$readFrame$1.L$0;
                        maxFrameSize2 = maxFrameSize4;
                        b = b7;
                        byteValue = ((Number) readByte2).byteValue();
                        rawOpcode = b & 15;
                        if (rawOpcode == 0) {
                        }
                        if (rawOpcode != 0) {
                        }
                        frameType = FrameType.Companion.get(opcode);
                        if (frameType == null) {
                        }
                        break;
                    case 3:
                        maskAndLength2 = rawWebSocketCommonKt$readFrame$1.I$0;
                        b2 = rawWebSocketCommonKt$readFrame$1.B$1;
                        b = rawWebSocketCommonKt$readFrame$1.B$0;
                        maxFrameSize2 = rawWebSocketCommonKt$readFrame$1.J$0;
                        $this$readFrame2 = (ByteReadChannel) rawWebSocketCommonKt$readFrame$1.L$0;
                        ResultKt.throwOnFailure($result);
                        frameType2 = (FrameType) rawWebSocketCommonKt$readFrame$1.L$1;
                        readShort = $result;
                        length = ((Number) readShort).shortValue() & 65535;
                        maxFrameSize3 = maxFrameSize2;
                        b4 = b;
                        byte b52 = b2;
                        maskAndLength = maskAndLength2;
                        byteValue = b52;
                        FrameType frameType62 = frameType2;
                        $this$readFrame3 = $this$readFrame2;
                        frameType3 = frameType62;
                        if (frameType3.getControlFrame()) {
                            break;
                        }
                        if ((byteValue & 128) != 0) {
                        }
                        if (maskAndLength4 != 1) {
                        }
                        break;
                    case 4:
                        maskAndLength3 = rawWebSocketCommonKt$readFrame$1.I$0;
                        b3 = rawWebSocketCommonKt$readFrame$1.B$1;
                        b = rawWebSocketCommonKt$readFrame$1.B$0;
                        maxFrameSize2 = rawWebSocketCommonKt$readFrame$1.J$0;
                        $this$readFrame2 = (ByteReadChannel) rawWebSocketCommonKt$readFrame$1.L$0;
                        ResultKt.throwOnFailure($result);
                        frameType2 = (FrameType) rawWebSocketCommonKt$readFrame$1.L$1;
                        readLong = $result;
                        maxFrameSize3 = maxFrameSize2;
                        length = ((Number) readLong).longValue();
                        b4 = b;
                        byte b62 = b3;
                        maskAndLength = maskAndLength3;
                        byteValue = b62;
                        FrameType frameType72 = frameType2;
                        $this$readFrame3 = $this$readFrame2;
                        frameType3 = frameType72;
                        if (frameType3.getControlFrame()) {
                        }
                        if ((byteValue & 128) != 0) {
                        }
                        if (maskAndLength4 != 1) {
                        }
                        break;
                    case 5:
                        long length3 = rawWebSocketCommonKt$readFrame$1.J$1;
                        int i4 = rawWebSocketCommonKt$readFrame$1.I$0;
                        b4 = rawWebSocketCommonKt$readFrame$1.B$0;
                        maxFrameSize3 = rawWebSocketCommonKt$readFrame$1.J$0;
                        frameType3 = (FrameType) rawWebSocketCommonKt$readFrame$1.L$1;
                        $this$readFrame3 = (ByteReadChannel) rawWebSocketCommonKt$readFrame$1.L$0;
                        ResultKt.throwOnFailure($result);
                        length = length3;
                        maskAndLength = i4;
                        readInt = $result;
                        maskKey = ((Number) readInt).intValue();
                        frameType4 = frameType3;
                        if (length <= 2147483647L) {
                        }
                        throw new FrameTooBigException(length);
                    case 6:
                        maskKey2 = rawWebSocketCommonKt$readFrame$1.I$1;
                        maskKey3 = rawWebSocketCommonKt$readFrame$1.I$0;
                        flagsAndOpcode2 = rawWebSocketCommonKt$readFrame$1.B$0;
                        ResultKt.throwOnFailure($result);
                        readPacket = $result;
                        frameType5 = (FrameType) rawWebSocketCommonKt$readFrame$1.L$0;
                        Source data2 = (Source) readPacket;
                        if (maskKey2 != -1) {
                        }
                        Source maskedData2 = data2;
                        return Frame.Companion.byType(maskKey3 == 0, frameType5, SourcesKt.readByteArray(maskedData2), (flagsAndOpcode2 & 64) == 0, (flagsAndOpcode2 & 32) == 0, (flagsAndOpcode2 & 16) == 0);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        rawWebSocketCommonKt$readFrame$1 = new RawWebSocketCommonKt$readFrame$1(continuation);
        Object $result2 = rawWebSocketCommonKt$readFrame$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rawWebSocketCommonKt$readFrame$1.label) {
        }
    }
}