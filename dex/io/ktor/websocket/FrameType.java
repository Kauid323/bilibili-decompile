package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FrameType.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/websocket/FrameType;", Column.INVAL_VALUE, Column.INVAL_VALUE, "controlFrame", Column.INVAL_VALUE, "opcode", "<init>", "(Ljava/lang/String;IZI)V", "Z", "getControlFrame", "()Z", "I", "getOpcode", "()I", "Companion", "TEXT", "BINARY", "CLOSE", "PING", "PONG", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum FrameType {
    TEXT(false, 1),
    BINARY(false, 2),
    CLOSE(true, 8),
    PING(true, 9),
    PONG(true, 10);
    
    private static final FrameType[] byOpcodeArray;
    private static final int maxOpcode;
    private final boolean controlFrame;
    private final int opcode;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    FrameType(boolean controlFrame, int opcode) {
        this.controlFrame = controlFrame;
        this.opcode = opcode;
    }

    public final boolean getControlFrame() {
        return this.controlFrame;
    }

    public final int getOpcode() {
        return this.opcode;
    }

    static {
        Object maxElem$iv;
        Iterable $this$maxByOrNull$iv = getEntries();
        Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
        if (iterator$iv.hasNext()) {
            maxElem$iv = iterator$iv.next();
            if (iterator$iv.hasNext()) {
                FrameType it = (FrameType) maxElem$iv;
                int maxValue$iv = it.opcode;
                do {
                    Object e$iv = iterator$iv.next();
                    FrameType it2 = (FrameType) e$iv;
                    int v$iv = it2.opcode;
                    if (maxValue$iv < v$iv) {
                        maxElem$iv = e$iv;
                        maxValue$iv = v$iv;
                    }
                } while (iterator$iv.hasNext());
            }
        } else {
            maxElem$iv = null;
        }
        Intrinsics.checkNotNull(maxElem$iv);
        maxOpcode = ((FrameType) maxElem$iv).opcode;
        int i = maxOpcode + 1;
        FrameType[] frameTypeArr = new FrameType[i];
        int i2 = 0;
        while (i2 < i) {
            Iterable $this$singleOrNull$iv = getEntries();
            Object single$iv = null;
            boolean found$iv = false;
            Iterator it3 = $this$singleOrNull$iv.iterator();
            while (true) {
                if (it3.hasNext()) {
                    Object element$iv = it3.next();
                    FrameType it4 = (FrameType) element$iv;
                    FrameType it5 = it4.opcode == i2 ? 1 : null;
                    if (it5 != null) {
                        if (found$iv) {
                            single$iv = null;
                            break;
                        } else {
                            single$iv = element$iv;
                            found$iv = true;
                        }
                    }
                } else if (!found$iv) {
                    single$iv = null;
                }
            }
            frameTypeArr[i2] = single$iv;
            i2++;
        }
        byOpcodeArray = frameTypeArr;
    }

    /* compiled from: FrameType.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/websocket/FrameType$Companion;", Column.INVAL_VALUE, "<init>", "()V", Column.INVAL_VALUE, "opcode", "Lio/ktor/websocket/FrameType;", "get", "(I)Lio/ktor/websocket/FrameType;", "maxOpcode", "I", Column.INVAL_VALUE, "byOpcodeArray", "[Lio/ktor/websocket/FrameType;", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FrameType get(int opcode) {
            boolean z = false;
            if (opcode >= 0 && opcode <= FrameType.maxOpcode) {
                z = true;
            }
            if (z) {
                return FrameType.byOpcodeArray[opcode];
            }
            return null;
        }
    }

    public static EnumEntries<FrameType> getEntries() {
        return $ENTRIES;
    }
}