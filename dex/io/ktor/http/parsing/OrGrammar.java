package io.ktor.http.parsing;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParserDsl.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/http/parsing/OrGrammar;", "Lio/ktor/http/parsing/Grammar;", "Lio/ktor/http/parsing/ComplexGrammar;", "", "sourceGrammars", "<init>", "(Ljava/util/List;)V", "grammars", "Ljava/util/List;", "getGrammars", "()Ljava/util/List;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OrGrammar extends Grammar implements ComplexGrammar {
    private final List<Grammar> grammars;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrGrammar(List<? extends Grammar> list) {
        super(null);
        Intrinsics.checkNotNullParameter(list, "sourceGrammars");
        List result$iv = new ArrayList();
        List<? extends Grammar> $this$forEach$iv$iv = list;
        for (Object element$iv$iv : $this$forEach$iv$iv) {
            Grammar it$iv = (Grammar) element$iv$iv;
            if (it$iv instanceof OrGrammar) {
                CollectionsKt.addAll(result$iv, ((ComplexGrammar) it$iv).getGrammars());
            } else {
                result$iv.add(it$iv);
            }
        }
        this.grammars = result$iv;
    }

    @Override // io.ktor.http.parsing.ComplexGrammar
    public List<Grammar> getGrammars() {
        return this.grammars;
    }
}