package io.ktor.http.parsing;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GrammarBuilder.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0086\u0004¢\u0006\u0004\b\u0006\u0010\nJ\u001a\u0010\r\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0086\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\r\u001a\u00020\f*\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\r\u0010\u000fJ\u0014\u0010\r\u001a\u00020\f*\u00020\bH\u0086\u0002¢\u0006\u0004\b\r\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/http/parsing/GrammarBuilder;", "", "<init>", "()V", "Lio/ktor/http/parsing/Grammar;", "grammar", "then", "(Lio/ktor/http/parsing/Grammar;)Lio/ktor/http/parsing/GrammarBuilder;", "", "value", "(Ljava/lang/String;)Lio/ktor/http/parsing/GrammarBuilder;", "Lkotlin/Function0;", "", "unaryPlus", "(Lkotlin/jvm/functions/Function0;)V", "(Lio/ktor/http/parsing/Grammar;)V", "(Ljava/lang/String;)V", "build", "()Lio/ktor/http/parsing/Grammar;", "", "grammars", "Ljava/util/List;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GrammarBuilder {
    private final List<Grammar> grammars = new ArrayList();

    public final GrammarBuilder then(Grammar grammar) {
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        this.grammars.add(grammar);
        return this;
    }

    public final GrammarBuilder then(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.grammars.add(new StringGrammar(value));
        return this;
    }

    public final void unaryPlus(Function0<? extends Grammar> function0) {
        Intrinsics.checkNotNullParameter(function0, "<this>");
        this.grammars.add(function0.invoke());
    }

    public final void unaryPlus(Grammar $this$unaryPlus) {
        Intrinsics.checkNotNullParameter($this$unaryPlus, "<this>");
        this.grammars.add($this$unaryPlus);
    }

    public final void unaryPlus(String $this$unaryPlus) {
        Intrinsics.checkNotNullParameter($this$unaryPlus, "<this>");
        this.grammars.add(new StringGrammar($this$unaryPlus));
    }

    public final Grammar build() {
        return (Grammar) (this.grammars.size() == 1 ? CollectionsKt.first(this.grammars) : new SequenceGrammar(this.grammars));
    }
}