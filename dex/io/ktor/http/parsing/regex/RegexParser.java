package io.ktor.http.parsing.regex;

import io.ktor.http.parsing.ParseResult;
import io.ktor.http.parsing.Parser;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: RegexParser.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/http/parsing/regex/RegexParser;", "Lio/ktor/http/parsing/Parser;", "Lkotlin/text/Regex;", "expression", "", "", "", "", "indexes", "<init>", "(Lkotlin/text/Regex;Ljava/util/Map;)V", "input", "Lio/ktor/http/parsing/ParseResult;", "parse", "(Ljava/lang/String;)Lio/ktor/http/parsing/ParseResult;", "", "match", "(Ljava/lang/String;)Z", "Lkotlin/text/Regex;", "Ljava/util/Map;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RegexParser implements Parser {
    private final Regex expression;
    private final Map<String, List<Integer>> indexes;

    /* JADX WARN: Multi-variable type inference failed */
    public RegexParser(Regex expression, Map<String, ? extends List<Integer>> map) {
        Intrinsics.checkNotNullParameter(expression, "expression");
        Intrinsics.checkNotNullParameter(map, "indexes");
        this.expression = expression;
        this.indexes = map;
    }

    @Override // io.ktor.http.parsing.Parser
    public ParseResult parse(String input) {
        MatchResult match;
        Map $this$forEach$iv;
        Intrinsics.checkNotNullParameter(input, "input");
        MatchResult match2 = this.expression.matchEntire(input);
        if (match2 != null && match2.getValue().length() == input.length()) {
            Map mapping = new LinkedHashMap();
            Map $this$forEach$iv2 = this.indexes;
            for (Map.Entry element$iv : $this$forEach$iv2.entrySet()) {
                String key = element$iv.getKey();
                List<Integer> locations = element$iv.getValue();
                for (Number number : locations) {
                    int index = number.intValue();
                    ArrayList arrayList = new ArrayList();
                    MatchGroup it = match2.getGroups().get(index);
                    if (it != null) {
                        match = match2;
                        $this$forEach$iv = $this$forEach$iv2;
                        arrayList.add(it.getValue());
                    } else {
                        match = match2;
                        $this$forEach$iv = $this$forEach$iv2;
                    }
                    if (!arrayList.isEmpty()) {
                        mapping.put(key, arrayList);
                    }
                    match2 = match;
                    $this$forEach$iv2 = $this$forEach$iv;
                }
            }
            return new ParseResult(mapping);
        }
        return null;
    }

    @Override // io.ktor.http.parsing.Parser
    public boolean match(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.expression.matches(input);
    }
}