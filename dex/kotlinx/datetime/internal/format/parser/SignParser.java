package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParserOperation.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B/\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ-\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\tH\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Lkotlinx/datetime/internal/format/parser/SignParser;", "Output", "Lkotlinx/datetime/internal/format/parser/ParserOperation;", "isNegativeSetter", "Lkotlin/Function2;", "", "", "withPlusSign", "whatThisExpects", "", "(Lkotlin/jvm/functions/Function2;ZLjava/lang/String;)V", "consume", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "storage", "input", "", "startIndex", "", "consume-FANa98k", "(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;", "toString", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SignParser<Output> implements ParserOperation<Output> {
    private final Function2<Output, Boolean, Unit> isNegativeSetter;
    private final String whatThisExpects;
    private final boolean withPlusSign;

    /* JADX WARN: Multi-variable type inference failed */
    public SignParser(Function2<? super Output, ? super Boolean, Unit> isNegativeSetter, boolean withPlusSign, String whatThisExpects) {
        Intrinsics.checkNotNullParameter(isNegativeSetter, "isNegativeSetter");
        Intrinsics.checkNotNullParameter(whatThisExpects, "whatThisExpects");
        this.isNegativeSetter = isNegativeSetter;
        this.withPlusSign = withPlusSign;
        this.whatThisExpects = whatThisExpects;
    }

    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    /* renamed from: consume-FANa98k */
    public Object mo1490consumeFANa98k(Output output, CharSequence input, int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (startIndex >= input.length()) {
            return ParseResult.Companion.m1501OkQi1bsqg(startIndex);
        }
        final char charAt = input.charAt(startIndex);
        if (charAt == '-') {
            this.isNegativeSetter.invoke(output, true);
            return ParseResult.Companion.m1501OkQi1bsqg(startIndex + 1);
        } else if (charAt == '+' && this.withPlusSign) {
            this.isNegativeSetter.invoke(output, false);
            return ParseResult.Companion.m1501OkQi1bsqg(startIndex + 1);
        } else {
            return ParseResult.Companion.m1500ErrorRg3Co2E(startIndex, new Function0<String>(this) { // from class: kotlinx.datetime.internal.format.parser.SignParser$consume$1
                final /* synthetic */ SignParser<Output> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str;
                    StringBuilder append = new StringBuilder().append("Expected ");
                    str = ((SignParser) this.this$0).whatThisExpects;
                    return append.append(str).append(" but got ").append(charAt).toString();
                }
            });
        }
    }

    public String toString() {
        return this.whatThisExpects;
    }
}