package io.ktor.http.parsing;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParserDsl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/http/parsing/AtLeastOne;", "Lio/ktor/http/parsing/Grammar;", "Lio/ktor/http/parsing/SimpleGrammar;", "grammar", "<init>", "(Lio/ktor/http/parsing/Grammar;)V", "Lio/ktor/http/parsing/Grammar;", "getGrammar", "()Lio/ktor/http/parsing/Grammar;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AtLeastOne extends Grammar implements SimpleGrammar {
    private final Grammar grammar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtLeastOne(Grammar grammar) {
        super(null);
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        this.grammar = grammar;
    }

    @Override // io.ktor.http.parsing.SimpleGrammar
    public Grammar getGrammar() {
        return this.grammar;
    }
}