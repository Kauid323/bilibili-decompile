package io.ktor.http.parsing.regex;

import faceverify.q;
import io.ktor.http.parsing.AnyOfGrammar;
import io.ktor.http.parsing.AtLeastOne;
import io.ktor.http.parsing.ComplexGrammar;
import io.ktor.http.parsing.Grammar;
import io.ktor.http.parsing.ManyGrammar;
import io.ktor.http.parsing.MaybeGrammar;
import io.ktor.http.parsing.NamedGrammar;
import io.ktor.http.parsing.OrGrammar;
import io.ktor.http.parsing.Parser;
import io.ktor.http.parsing.RangeGrammar;
import io.ktor.http.parsing.RawGrammar;
import io.ktor.http.parsing.SimpleGrammar;
import io.ktor.http.parsing.StringGrammar;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: RegexParserGenerator.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001aA\u0010\r\u001a\u00020\f*\u00020\u00002\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a5\u0010\u0012\u001a\u00020\u0011*\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/http/parsing/Grammar;", "Lio/ktor/http/parsing/Parser;", "buildRegexParser", "(Lio/ktor/http/parsing/Grammar;)Lio/ktor/http/parsing/Parser;", "", "", "", "", "groups", "offset", "", "shouldGroup", "Lio/ktor/http/parsing/regex/GrammarRegex;", "toRegex", "(Lio/ktor/http/parsing/Grammar;Ljava/util/Map;IZ)Lio/ktor/http/parsing/regex/GrammarRegex;", q.KEY_RES_9_KEY, "value", "", "add", "(Ljava/util/Map;Ljava/lang/String;I)V", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RegexParserGeneratorKt {
    public static final Parser buildRegexParser(Grammar $this$buildRegexParser) {
        Intrinsics.checkNotNullParameter($this$buildRegexParser, "<this>");
        Map groups = new LinkedHashMap();
        String expression = toRegex$default($this$buildRegexParser, groups, 0, false, 6, null).getRegex();
        return new RegexParser(new Regex(expression), groups);
    }

    static /* synthetic */ GrammarRegex toRegex$default(Grammar grammar, Map map, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return toRegex(grammar, map, i2, z);
    }

    private static final GrammarRegex toRegex(Grammar $this$toRegex, Map<String, List<Integer>> map, int offset, boolean shouldGroup) {
        char operator;
        if ($this$toRegex instanceof StringGrammar) {
            return new GrammarRegex(Regex.Companion.escape(((StringGrammar) $this$toRegex).getValue()), 0, false, 6, null);
        }
        if ($this$toRegex instanceof RawGrammar) {
            return new GrammarRegex(((RawGrammar) $this$toRegex).getValue(), 0, false, 6, null);
        }
        boolean z = true;
        if ($this$toRegex instanceof NamedGrammar) {
            GrammarRegex nested = toRegex$default(((NamedGrammar) $this$toRegex).getGrammar(), map, offset + 1, false, 4, null);
            add(map, ((NamedGrammar) $this$toRegex).getName(), offset);
            return new GrammarRegex(nested.getRegex(), nested.getGroupsCount(), true);
        } else if ($this$toRegex instanceof ComplexGrammar) {
            StringBuilder expression = new StringBuilder();
            int currentOffset = shouldGroup ? offset + 1 : offset;
            Iterable $this$forEachIndexed$iv = ((ComplexGrammar) $this$toRegex).getGrammars();
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Grammar grammar = (Grammar) item$iv;
                GrammarRegex current = toRegex(grammar, map, currentOffset, z);
                if (index != 0 && ($this$toRegex instanceof OrGrammar)) {
                    expression.append("|");
                }
                expression.append(current.getRegex());
                currentOffset += current.getGroupsCount();
                index = index$iv;
                z = true;
            }
            int groupsCount = currentOffset - offset;
            if (shouldGroup) {
                groupsCount--;
            }
            String sb = expression.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            return new GrammarRegex(sb, groupsCount, shouldGroup);
        } else if ($this$toRegex instanceof SimpleGrammar) {
            if ($this$toRegex instanceof MaybeGrammar) {
                operator = '?';
            } else if ($this$toRegex instanceof ManyGrammar) {
                operator = '*';
            } else if (!($this$toRegex instanceof AtLeastOne)) {
                throw new IllegalStateException(("Unsupported simple grammar element: " + $this$toRegex).toString());
            } else {
                operator = '+';
            }
            GrammarRegex nested2 = toRegex(((SimpleGrammar) $this$toRegex).getGrammar(), map, offset, true);
            return new GrammarRegex(nested2.getRegex() + operator, nested2.getGroupsCount(), false, 4, null);
        } else if ($this$toRegex instanceof AnyOfGrammar) {
            return new GrammarRegex('[' + Regex.Companion.escape(((AnyOfGrammar) $this$toRegex).getValue()) + ']', 0, false, 6, null);
        } else {
            if ($this$toRegex instanceof RangeGrammar) {
                return new GrammarRegex(new StringBuilder().append('[').append(((RangeGrammar) $this$toRegex).getFrom()).append('-').append(((RangeGrammar) $this$toRegex).getTo()).append(']').toString(), 0, false, 6, null);
            }
            throw new IllegalStateException(("Unsupported grammar element: " + $this$toRegex).toString());
        }
    }

    private static final void add(Map<String, List<Integer>> map, String key, int value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList());
        }
        Integer valueOf = Integer.valueOf(value);
        List<Integer> list = map.get(key);
        Intrinsics.checkNotNull(list);
        list.add(valueOf);
    }
}