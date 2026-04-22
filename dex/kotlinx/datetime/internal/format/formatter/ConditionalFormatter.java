package kotlinx.datetime.internal.format.formatter;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Formatter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B6\u0012/\u0010\u0003\u001a+\u0012'\u0012%\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00050\u0004¢\u0006\u0002\u0010\tJ)\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0011R7\u0010\u0003\u001a+\u0012'\u0012%\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/internal/format/formatter/ConditionalFormatter;", "T", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "formatters", "", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/List;)V", "format", "", "obj", "builder", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "minusNotRequired", "(Ljava/lang/Object;Ljava/lang/Appendable;Z)V", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConditionalFormatter<T> implements FormatterStructure<T> {
    private final List<Pair<Function1<T, Boolean>, FormatterStructure<T>>> formatters;

    public ConditionalFormatter(List<? extends Pair<? extends Function1<? super T, Boolean>, ? extends FormatterStructure<? super T>>> formatters) {
        Intrinsics.checkNotNullParameter(formatters, "formatters");
        this.formatters = formatters;
    }

    @Override // kotlinx.datetime.internal.format.formatter.FormatterStructure
    public void format(T t, Appendable builder, boolean minusNotRequired) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        for (Pair<Function1<T, Boolean>, FormatterStructure<T>> pair : this.formatters) {
            Function1 condition = (Function1) pair.component1();
            FormatterStructure formatter = (FormatterStructure) pair.component2();
            if (((Boolean) condition.invoke(t)).booleanValue()) {
                formatter.format(t, builder, minusNotRequired);
                return;
            }
        }
    }
}