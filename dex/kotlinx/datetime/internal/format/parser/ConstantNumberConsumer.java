package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.NumberConsumptionError;

/* compiled from: NumberConsumer.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J/\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/internal/format/parser/ConstantNumberConsumer;", "Receiver", "Lkotlinx/datetime/internal/format/parser/NumberConsumer;", "expected", "", "(Ljava/lang/String;)V", "consume", "Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "storage", "input", "", "start", "", "end", "(Ljava/lang/Object;Ljava/lang/CharSequence;II)Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConstantNumberConsumer<Receiver> extends NumberConsumer<Receiver> {
    private final String expected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstantNumberConsumer(String expected) {
        super(Integer.valueOf(expected.length()), "the predefined string " + expected, null);
        Intrinsics.checkNotNullParameter(expected, "expected");
        this.expected = expected;
    }

    @Override // kotlinx.datetime.internal.format.parser.NumberConsumer
    public NumberConsumptionError consume(Receiver receiver, CharSequence input, int start, int end) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (Intrinsics.areEqual(input.subSequence(start, end).toString(), this.expected)) {
            return null;
        }
        return new NumberConsumptionError.WrongConstant(this.expected);
    }
}