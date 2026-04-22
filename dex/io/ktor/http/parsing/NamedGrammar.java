package io.ktor.http.parsing;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParserDsl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/http/parsing/NamedGrammar;", "Lio/ktor/http/parsing/Grammar;", "", ContentDisposition.Parameters.Name, "grammar", "<init>", "(Ljava/lang/String;Lio/ktor/http/parsing/Grammar;)V", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Lio/ktor/http/parsing/Grammar;", "getGrammar", "()Lio/ktor/http/parsing/Grammar;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NamedGrammar extends Grammar {
    private final Grammar grammar;
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NamedGrammar(String name, Grammar grammar) {
        super(null);
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        this.name = name;
        this.grammar = grammar;
    }

    public final Grammar getGrammar() {
        return this.grammar;
    }

    public final String getName() {
        return this.name;
    }
}