package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NumberConsumer.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0019\b\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J/\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0002\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0004\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lkotlinx/datetime/internal/format/parser/NumberConsumer;", "Receiver", "", "length", "", "whatThisExpects", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWhatThisExpects", "()Ljava/lang/String;", "consume", "Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "storage", "input", "", "start", "end", "(Ljava/lang/Object;Ljava/lang/CharSequence;II)Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "Lkotlinx/datetime/internal/format/parser/ConstantNumberConsumer;", "Lkotlinx/datetime/internal/format/parser/FractionPartConsumer;", "Lkotlinx/datetime/internal/format/parser/ReducedIntConsumer;", "Lkotlinx/datetime/internal/format/parser/UnsignedIntConsumer;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class NumberConsumer<Receiver> {
    private final Integer length;
    private final String whatThisExpects;

    public /* synthetic */ NumberConsumer(Integer num, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str);
    }

    public abstract NumberConsumptionError consume(Receiver receiver, CharSequence charSequence, int i, int i2);

    private NumberConsumer(Integer length, String whatThisExpects) {
        this.length = length;
        this.whatThisExpects = whatThisExpects;
    }

    public Integer getLength() {
        return this.length;
    }

    public final String getWhatThisExpects() {
        return this.whatThisExpects;
    }
}