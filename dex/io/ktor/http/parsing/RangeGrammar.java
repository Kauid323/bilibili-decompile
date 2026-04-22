package io.ktor.http.parsing;

import kotlin.Metadata;

/* compiled from: ParserDsl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lio/ktor/http/parsing/RangeGrammar;", "Lio/ktor/http/parsing/Grammar;", "", "from", "to", "<init>", "(CC)V", "C", "getFrom", "()C", "getTo", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RangeGrammar extends Grammar {
    private final char from;
    private final char to;

    public RangeGrammar(char from, char to) {
        super(null);
        this.from = from;
        this.to = to;
    }

    public final char getFrom() {
        return this.from;
    }

    public final char getTo() {
        return this.to;
    }
}