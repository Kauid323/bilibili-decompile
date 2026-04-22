package io.ktor.util.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LockFreeLinkedList.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lio/ktor/util/internal/Symbol;", "", "", "symbol", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getSymbol", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class Symbol {
    private final String symbol;

    public Symbol(String symbol) {
        Intrinsics.checkNotNullParameter(symbol, "symbol");
        this.symbol = symbol;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public String toString() {
        return this.symbol;
    }
}