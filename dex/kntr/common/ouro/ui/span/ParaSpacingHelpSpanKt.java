package kntr.common.ouro.ui.span;

import android.text.Spanned;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParaSpacingHelpSpan.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\"\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a \u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a \u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"getParaSpacingHelpSpanInLineHeightSpan", "Lkntr/common/ouro/ui/span/ParaSpacingHelpSpan;", "text", "", "start", "", "end", "getParaSpacingHelpSpanInListItemSpan", "matchParagraphSpacingInLineHeightSpan", "", "matchParagraphSpacingInListItemSpan", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ParaSpacingHelpSpanKt {
    public static final ParaSpacingHelpSpan getParaSpacingHelpSpanInLineHeightSpan(CharSequence text, int start, int end) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (matchParagraphSpacingInLineHeightSpan(text, start, end) && (text instanceof Spanned)) {
            Spanned $this$getSpans$iv = (Spanned) text;
            ParaSpacingHelpSpan[] paraSpacingSpans = (ParaSpacingHelpSpan[]) $this$getSpans$iv.getSpans(start, end, ParaSpacingHelpSpan.class);
            return (ParaSpacingHelpSpan) ArraysKt.firstOrNull(paraSpacingSpans);
        }
        return null;
    }

    public static final ParaSpacingHelpSpan getParaSpacingHelpSpanInListItemSpan(CharSequence text, int start, int end) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (matchParagraphSpacingInListItemSpan(text, start, end) && (text instanceof Spanned)) {
            Spanned $this$getSpans$iv = (Spanned) text;
            ParaSpacingHelpSpan[] paraSpacingSpans = (ParaSpacingHelpSpan[]) $this$getSpans$iv.getSpans(start, end, ParaSpacingHelpSpan.class);
            return (ParaSpacingHelpSpan) ArraysKt.firstOrNull(paraSpacingSpans);
        }
        return null;
    }

    private static final boolean matchParagraphSpacingInLineHeightSpan(CharSequence text, int start, int end) {
        return end - start == 2 && text.charAt(start) == 8203 && text.charAt(end + (-1)) == '\n';
    }

    private static final boolean matchParagraphSpacingInListItemSpan(CharSequence text, int start, int end) {
        return start + 1 == end && text.charAt(start) == 8203;
    }
}