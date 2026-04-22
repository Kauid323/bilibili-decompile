package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParserOperation.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J-\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/internal/format/parser/UnconditionalModification;", "Output", "Lkotlinx/datetime/internal/format/parser/ParserOperation;", "operation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "consume", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "storage", "input", "", "startIndex", "", "consume-FANa98k", "(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UnconditionalModification<Output> implements ParserOperation<Output> {
    private final Function1<Output, Unit> operation;

    /* JADX WARN: Multi-variable type inference failed */
    public UnconditionalModification(Function1<? super Output, Unit> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        this.operation = operation;
    }

    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    /* renamed from: consume-FANa98k */
    public Object mo1490consumeFANa98k(Output output, CharSequence input, int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.operation.invoke(output);
        return ParseResult.Companion.m1501OkQi1bsqg(startIndex);
    }
}