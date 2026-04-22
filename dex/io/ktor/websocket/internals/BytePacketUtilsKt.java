package io.ktor.websocket.internals;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* compiled from: BytePacketUtils.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/io/Source;", Column.INVAL_VALUE, "data", Column.INVAL_VALUE, "endsWith", "(Lkotlinx/io/Source;[B)Z", "ktor-websockets"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BytePacketUtilsKt {
    public static final boolean endsWith(Source $this$endsWith, byte[] data) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Source $this$endsWith_u24lambda_u240 = ByteReadPacketKt.copy($this$endsWith);
        ByteReadPacketKt.discard($this$endsWith_u24lambda_u240, ByteReadPacketKt.getRemaining($this$endsWith_u24lambda_u240) - data.length);
        return Arrays.equals(SourcesKt.readByteArray($this$endsWith_u24lambda_u240), data);
    }
}