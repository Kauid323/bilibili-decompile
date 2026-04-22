package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParseResult.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlinx/datetime/internal/format/parser/ParseError;", "", "position", "", "message", "Lkotlin/Function0;", "", "(ILkotlin/jvm/functions/Function0;)V", "getMessage", "()Lkotlin/jvm/functions/Function0;", "getPosition", "()I", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ParseError {
    private final Function0<String> message;
    private final int position;

    public ParseError(int position, Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.position = position;
        this.message = message;
    }

    public final Function0<String> getMessage() {
        return this.message;
    }

    public final int getPosition() {
        return this.position;
    }
}