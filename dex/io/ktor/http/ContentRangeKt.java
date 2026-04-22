package io.ktor.http;

import io.ktor.sse.ServerSentEventKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

/* compiled from: ContentRange.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a-\u0010\u0007\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\u0007\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/ranges/LongRange;", "range", "", "fullLength", "Lio/ktor/http/RangeUnits;", "unit", "", "contentRangeHeaderValue", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;Lio/ktor/http/RangeUnits;)Ljava/lang/String;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;Ljava/lang/String;)Ljava/lang/String;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContentRangeKt {
    public static /* synthetic */ String contentRangeHeaderValue$default(LongRange longRange, Long l, RangeUnits rangeUnits, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        if ((i2 & 4) != 0) {
            rangeUnits = RangeUnits.Bytes;
        }
        return contentRangeHeaderValue(longRange, l, rangeUnits);
    }

    public static final String contentRangeHeaderValue(LongRange range, Long fullLength, RangeUnits unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return contentRangeHeaderValue(range, fullLength, unit.getUnitToken());
    }

    public static /* synthetic */ String contentRangeHeaderValue$default(LongRange longRange, Long l, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        if ((i2 & 4) != 0) {
            str = RangeUnits.Bytes.getUnitToken();
        }
        return contentRangeHeaderValue(longRange, l, str);
    }

    public static final String contentRangeHeaderValue(LongRange range, Long fullLength, String unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        StringBuilder $this$contentRangeHeaderValue_u24lambda_u240 = new StringBuilder();
        $this$contentRangeHeaderValue_u24lambda_u240.append(unit);
        $this$contentRangeHeaderValue_u24lambda_u240.append(ServerSentEventKt.SPACE);
        if (range != null) {
            $this$contentRangeHeaderValue_u24lambda_u240.append(range.getFirst());
            $this$contentRangeHeaderValue_u24lambda_u240.append('-');
            $this$contentRangeHeaderValue_u24lambda_u240.append(range.getLast());
        } else {
            $this$contentRangeHeaderValue_u24lambda_u240.append('*');
        }
        $this$contentRangeHeaderValue_u24lambda_u240.append('/');
        $this$contentRangeHeaderValue_u24lambda_u240.append(fullLength == null ? "*" : fullLength);
        String sb = $this$contentRangeHeaderValue_u24lambda_u240.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }
}