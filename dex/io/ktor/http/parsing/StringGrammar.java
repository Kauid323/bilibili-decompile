package io.ktor.http.parsing;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParserDsl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/http/parsing/StringGrammar;", "Lio/ktor/http/parsing/Grammar;", "", "value", "<init>", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StringGrammar extends Grammar {
    private final String value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringGrammar(String value) {
        super(null);
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public final String getValue() {
        return this.value;
    }
}