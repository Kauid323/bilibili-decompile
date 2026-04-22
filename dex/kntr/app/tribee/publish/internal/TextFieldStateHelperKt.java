package kntr.app.tribee.publish.internal;

import androidx.compose.foundation.text.input.TextFieldBuffer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: TextFieldStateHelper.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0006"}, d2 = {"filterSpaceOnStart", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "filterEmptyOnStart", "filterContinuousSpace", "filterNewLine", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TextFieldStateHelperKt {
    public static final void filterSpaceOnStart(TextFieldBuffer $this$filterSpaceOnStart) {
        Intrinsics.checkNotNullParameter($this$filterSpaceOnStart, "<this>");
        MatchResult trim = Regex.find$default(new Regex("^[^\\S\\r\\n]+"), $this$filterSpaceOnStart.asCharSequence(), 0, 2, (Object) null);
        if (trim != null) {
            $this$filterSpaceOnStart.replace(trim.getRange().getFirst(), trim.getRange().getLast() + 1, "");
        }
    }

    public static final void filterEmptyOnStart(TextFieldBuffer $this$filterEmptyOnStart) {
        Intrinsics.checkNotNullParameter($this$filterEmptyOnStart, "<this>");
        MatchResult trim = Regex.find$default(new Regex("^\\s+"), $this$filterEmptyOnStart.asCharSequence(), 0, 2, (Object) null);
        if (trim != null) {
            $this$filterEmptyOnStart.replace(trim.getRange().getFirst(), trim.getRange().getLast() + 1, "");
        }
    }

    public static final void filterContinuousSpace(TextFieldBuffer $this$filterContinuousSpace) {
        Intrinsics.checkNotNullParameter($this$filterContinuousSpace, "<this>");
        Iterable $this$forEach$iv = CollectionsKt.reversed(SequencesKt.toList(Regex.findAll$default(new Regex("[^\\S\\r\\n]{2,}"), $this$filterContinuousSpace.asCharSequence(), 0, 2, (Object) null)));
        for (Object element$iv : $this$forEach$iv) {
            MatchResult it = (MatchResult) element$iv;
            $this$filterContinuousSpace.replace(it.getRange().getFirst(), it.getRange().getLast() + 1, " ");
        }
    }

    public static final void filterNewLine(TextFieldBuffer $this$filterNewLine) {
        Intrinsics.checkNotNullParameter($this$filterNewLine, "<this>");
        Iterable $this$forEach$iv = CollectionsKt.reversed(SequencesKt.toList(Regex.findAll$default(new Regex("\\n+"), $this$filterNewLine.asCharSequence(), 0, 2, (Object) null)));
        for (Object element$iv : $this$forEach$iv) {
            MatchResult it = (MatchResult) element$iv;
            $this$filterNewLine.replace(it.getRange().getFirst(), it.getRange().getLast() + 1, "");
        }
    }
}