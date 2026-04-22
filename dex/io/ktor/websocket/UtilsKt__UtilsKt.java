package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import com.bilibili.upper.comm.statistics.StatisticsHelper;
import kotlin.Metadata;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0080\f¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0007\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0080\b¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {Column.INVAL_VALUE, StatisticsHelper.PAGE_RELATION_FROM_OTHER, "xor", "(BB)B", Column.INVAL_VALUE, Column.INVAL_VALUE, "at", "flagAt", "(ZI)I", "ktor-websockets"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "io/ktor/websocket/UtilsKt")
final /* synthetic */ class UtilsKt__UtilsKt {
    public static final byte xor(byte $this$xor, byte other) {
        return (byte) ($this$xor ^ other);
    }

    public static final int flagAt(boolean $this$flagAt, int at) {
        if ($this$flagAt) {
            return 1 << at;
        }
        return 0;
    }
}