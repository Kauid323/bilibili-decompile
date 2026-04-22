package io.ktor.websocket;

import androidx.compose.animation.core.MutatorMutex$;
import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FrameParser.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\fR\"\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R$\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R$\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R$\u0010 \u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\u0019R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010&\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010$R$\u0010(\u001a\u00020'2\u0006\u0010\u0015\u001a\u00020'8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R(\u0010,\u001a\u0004\u0018\u00010\"2\b\u0010\u0015\u001a\u0004\u0018\u00010\"8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0011\u00103\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00105\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b4\u0010\u0019¨\u00067"}, d2 = {"Lio/ktor/websocket/FrameParser;", Column.INVAL_VALUE, "<init>", "()V", Column.INVAL_VALUE, "bodyComplete", "Ljava/nio/ByteBuffer;", "bb", "frame", "(Ljava/nio/ByteBuffer;)V", Column.INVAL_VALUE, "handleStep", "(Ljava/nio/ByteBuffer;)Z", "parseHeader1", "parseLength", "parseMaskKey", "Ljava/util/concurrent/atomic/AtomicReference;", "Lio/ktor/websocket/FrameParser$State;", "kotlin.jvm.PlatformType", "state", "Ljava/util/concurrent/atomic/AtomicReference;", "value", "fin", "Z", "getFin", "()Z", "rsv1", "getRsv1", "rsv2", "getRsv2", "rsv3", "getRsv3", "mask", "getMask", Column.INVAL_VALUE, "opcode", "I", "lastOpcode", "lengthLength", Column.INVAL_VALUE, "length", "J", "getLength", "()J", "maskKey", "Ljava/lang/Integer;", "getMaskKey", "()Ljava/lang/Integer;", "Lio/ktor/websocket/FrameType;", "getFrameType", "()Lio/ktor/websocket/FrameType;", "frameType", "getBodyReady", "bodyReady", "State", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FrameParser {
    private boolean fin;
    private int lastOpcode;
    private long length;
    private int lengthLength;
    private boolean mask;
    private Integer maskKey;
    private int opcode;
    private boolean rsv1;
    private boolean rsv2;
    private boolean rsv3;
    private final AtomicReference<State> state = new AtomicReference<>(State.HEADER0);

    /* compiled from: FrameParser.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.HEADER0.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[State.LENGTH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[State.MASK_KEY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[State.BODY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean getFin() {
        return this.fin;
    }

    public final boolean getRsv1() {
        return this.rsv1;
    }

    public final boolean getRsv2() {
        return this.rsv2;
    }

    public final boolean getRsv3() {
        return this.rsv3;
    }

    public final boolean getMask() {
        return this.mask;
    }

    public final long getLength() {
        return this.length;
    }

    public final Integer getMaskKey() {
        return this.maskKey;
    }

    public final FrameType getFrameType() {
        FrameType frameType = FrameType.Companion.get(this.opcode);
        if (frameType != null) {
            return frameType;
        }
        throw new IllegalStateException("Unsupported opcode " + Integer.toHexString(this.opcode));
    }

    /* compiled from: FrameParser.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/ktor/websocket/FrameParser$State;", Column.INVAL_VALUE, "<init>", "(Ljava/lang/String;I)V", "HEADER0", "LENGTH", "MASK_KEY", "BODY", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
    public enum State {
        HEADER0,
        LENGTH,
        MASK_KEY,
        BODY;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }
    }

    public final boolean getBodyReady() {
        return this.state.get() == State.BODY;
    }

    public final void bodyComplete() {
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.state, State.BODY, State.HEADER0)) {
            throw new IllegalStateException("It should be state BODY but it is " + this.state.get());
        }
        this.opcode = 0;
        this.length = 0L;
        this.lengthLength = 0;
        this.maskKey = null;
    }

    public final void frame(ByteBuffer bb) {
        Intrinsics.checkNotNullParameter(bb, "bb");
        if (!Intrinsics.areEqual(bb.order(), ByteOrder.BIG_ENDIAN)) {
            throw new IllegalArgumentException(("Buffer order should be BIG_ENDIAN but it is " + bb.order()).toString());
        }
        do {
        } while (handleStep(bb));
    }

    private final boolean handleStep(ByteBuffer bb) {
        State state = this.state.get();
        Intrinsics.checkNotNull(state);
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                return parseHeader1(bb);
            case 2:
                return parseLength(bb);
            case 3:
                return parseMaskKey(bb);
            case 4:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean parseHeader1(ByteBuffer bb) {
        int i = 0;
        if (bb.remaining() < 2) {
            return false;
        }
        int flagsAndOpcode = bb.get();
        int maskAndLength1 = bb.get();
        this.fin = (flagsAndOpcode & 128) != 0;
        this.rsv1 = (flagsAndOpcode & 64) != 0;
        this.rsv2 = (flagsAndOpcode & 32) != 0;
        this.rsv3 = (flagsAndOpcode & 16) != 0;
        this.opcode = flagsAndOpcode & 15;
        if (this.opcode == 0 && this.lastOpcode == 0) {
            throw new ProtocolViolationException("Can't continue finished frames");
        }
        if (this.opcode == 0) {
            this.opcode = this.lastOpcode;
        } else if (this.lastOpcode != 0 && !getFrameType().getControlFrame()) {
            throw new ProtocolViolationException("Can't start new data frame before finishing previous one");
        }
        if (!getFrameType().getControlFrame()) {
            this.lastOpcode = this.fin ? 0 : this.opcode;
        } else if (!this.fin) {
            throw new ProtocolViolationException("control frames can't be fragmented");
        }
        this.mask = (maskAndLength1 & 128) != 0;
        int length1 = maskAndLength1 & 127;
        if (getFrameType().getControlFrame() && length1 > 125) {
            throw new ProtocolViolationException("control frames can't be larger than 125 bytes");
        }
        switch (length1) {
            case 126:
                i = 2;
                break;
            case 127:
                i = 8;
                break;
        }
        this.lengthLength = i;
        this.length = this.lengthLength == 0 ? length1 : 0L;
        if (this.lengthLength > 0) {
            this.state.set(State.LENGTH);
        } else if (this.mask) {
            this.state.set(State.MASK_KEY);
        } else {
            this.state.set(State.BODY);
        }
        return true;
    }

    private final boolean parseLength(ByteBuffer bb) {
        long j;
        if (bb.remaining() < this.lengthLength) {
            return false;
        }
        switch (this.lengthLength) {
            case 2:
                j = bb.getShort() & 65535;
                break;
            case 8:
                j = bb.getLong();
                break;
            default:
                throw new IllegalStateException();
        }
        this.length = j;
        State mask = this.mask ? State.MASK_KEY : State.BODY;
        this.state.set(mask);
        return true;
    }

    private final boolean parseMaskKey(ByteBuffer bb) {
        if (bb.remaining() < 4) {
            return false;
        }
        this.maskKey = Integer.valueOf(bb.getInt());
        this.state.set(State.BODY);
        return true;
    }
}