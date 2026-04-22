package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.UtilKt;

/* compiled from: ParserOperation.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J-\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/internal/format/parser/PlainStringParserOperation;", "Output", "Lkotlinx/datetime/internal/format/parser/ParserOperation;", "string", "", "(Ljava/lang/String;)V", "getString", "()Ljava/lang/String;", "consume", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "storage", "input", "", "startIndex", "", "consume-FANa98k", "(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;", "toString", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlainStringParserOperation<Output> implements ParserOperation<Output> {
    private final String string;

    public PlainStringParserOperation(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.string = string;
        if (!(this.string.length() > 0)) {
            throw new IllegalArgumentException("Empty string is not allowed".toString());
        }
        if (UtilKt.isAsciiDigit(this.string.charAt(0))) {
            throw new IllegalArgumentException(("String '" + this.string + "' starts with a digit").toString());
        }
        if (!UtilKt.isAsciiDigit(this.string.charAt(this.string.length() - 1))) {
            return;
        }
        throw new IllegalArgumentException(("String '" + this.string + "' ends with a digit").toString());
    }

    public final String getString() {
        return this.string;
    }

    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    /* renamed from: consume-FANa98k */
    public Object mo1490consumeFANa98k(Output output, final CharSequence input, final int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (this.string.length() + startIndex > input.length()) {
            return ParseResult.Companion.m1500ErrorRg3Co2E(startIndex, new Function0<String>(this) { // from class: kotlinx.datetime.internal.format.parser.PlainStringParserOperation$consume$1
                final /* synthetic */ PlainStringParserOperation<Output> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unexpected end of input: yet to parse '" + this.this$0.getString() + '\'';
                }
            });
        }
        int length = this.string.length();
        for (final int i = 0; i < length; i++) {
            if (input.charAt(startIndex + i) != this.string.charAt(i)) {
                return ParseResult.Companion.m1500ErrorRg3Co2E(startIndex, new Function0<String>(this) { // from class: kotlinx.datetime.internal.format.parser.PlainStringParserOperation$consume$2
                    final /* synthetic */ PlainStringParserOperation<Output> this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Expected " + this.this$0.getString() + " but got " + input.subSequence(startIndex, startIndex + i + 1).toString();
                    }
                });
            }
        }
        return ParseResult.Companion.m1501OkQi1bsqg(this.string.length() + startIndex);
    }

    public String toString() {
        return '\'' + this.string + '\'';
    }
}