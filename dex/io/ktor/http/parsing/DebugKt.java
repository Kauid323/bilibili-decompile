package io.ktor.http.parsing;

import io.ktor.sse.ServerSentEventKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: Debug.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/http/parsing/Grammar;", "", "offset", "", "printDebug", "(Lio/ktor/http/parsing/Grammar;I)V", "", "node", "printlnWithOffset", "(ILjava/lang/Object;)V", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DebugKt {
    public static final void printDebug(Grammar $this$printDebug, int offset) {
        Intrinsics.checkNotNullParameter($this$printDebug, "<this>");
        if (!($this$printDebug instanceof StringGrammar)) {
            if (!($this$printDebug instanceof RawGrammar)) {
                if ($this$printDebug instanceof NamedGrammar) {
                    printlnWithOffset(offset, "NAMED[" + ((NamedGrammar) $this$printDebug).getName() + ']');
                    printDebug(((NamedGrammar) $this$printDebug).getGrammar(), offset + 2);
                    return;
                } else if ($this$printDebug instanceof SequenceGrammar) {
                    printlnWithOffset(offset, "SEQUENCE");
                    Iterable $this$forEach$iv = ((SequenceGrammar) $this$printDebug).getGrammars();
                    for (Object element$iv : $this$forEach$iv) {
                        Grammar it = (Grammar) element$iv;
                        printDebug(it, offset + 2);
                    }
                    return;
                } else if ($this$printDebug instanceof OrGrammar) {
                    printlnWithOffset(offset, "OR");
                    Iterable $this$forEach$iv2 = ((OrGrammar) $this$printDebug).getGrammars();
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Grammar it2 = (Grammar) element$iv2;
                        printDebug(it2, offset + 2);
                    }
                    return;
                } else if ($this$printDebug instanceof MaybeGrammar) {
                    printlnWithOffset(offset, "MAYBE");
                    printDebug(((MaybeGrammar) $this$printDebug).getGrammar(), offset + 2);
                    return;
                } else if ($this$printDebug instanceof ManyGrammar) {
                    printlnWithOffset(offset, "MANY");
                    printDebug(((ManyGrammar) $this$printDebug).getGrammar(), offset + 2);
                    return;
                } else if ($this$printDebug instanceof AtLeastOne) {
                    printlnWithOffset(offset, "MANY_NOT_EMPTY");
                    printDebug(((AtLeastOne) $this$printDebug).getGrammar(), offset + 2);
                    return;
                } else if (!($this$printDebug instanceof AnyOfGrammar)) {
                    if (!($this$printDebug instanceof RangeGrammar)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    printlnWithOffset(offset, "RANGE[" + ((RangeGrammar) $this$printDebug).getFrom() + '-' + ((RangeGrammar) $this$printDebug).getTo() + ']');
                    return;
                } else {
                    printlnWithOffset(offset, "ANY_OF[" + Regex.Companion.escape(((AnyOfGrammar) $this$printDebug).getValue()) + ']');
                    return;
                }
            }
            printlnWithOffset(offset, "STRING[" + ((RawGrammar) $this$printDebug).getValue() + ']');
            return;
        }
        printlnWithOffset(offset, "STRING[" + Regex.Companion.escape(((StringGrammar) $this$printDebug).getValue()) + ']');
    }

    public static /* synthetic */ void printDebug$default(Grammar grammar, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        printDebug(grammar, i2);
    }

    private static final void printlnWithOffset(int offset, Object node) {
        System.out.println((Object) (StringsKt.repeat(ServerSentEventKt.SPACE, offset) + (offset / 2) + ": " + node));
    }
}