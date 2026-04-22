package kntr.common.ouro.ui.utils;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroTextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextRangeUtils.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"toTextRange", "Landroidx/compose/ui/text/TextRange;", "Lkntr/common/ouro/core/model/OuroTextRange;", "(Lkntr/common/ouro/core/model/OuroTextRange;)J", "toOuroTextRange", "toOuroTextRange-5zc-tL8", "(J)Lkntr/common/ouro/core/model/OuroTextRange;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TextRangeUtilsKt {
    public static final long toTextRange(OuroTextRange $this$toTextRange) {
        Intrinsics.checkNotNullParameter($this$toTextRange, "<this>");
        return TextRangeKt.TextRange($this$toTextRange.getStart(), $this$toTextRange.getEnd());
    }

    /* renamed from: toOuroTextRange-5zc-tL8  reason: not valid java name */
    public static final OuroTextRange m2143toOuroTextRange5zctL8(long j) {
        return new OuroTextRange(TextRange.getStart-impl(j), TextRange.getEnd-impl(j));
    }
}