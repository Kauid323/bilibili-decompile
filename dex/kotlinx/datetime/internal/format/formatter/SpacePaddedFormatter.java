package kotlinx.datetime.internal.format.formatter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Formatter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/internal/format/formatter/SpacePaddedFormatter;", "T", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "formatter", "padding", "", "(Lkotlinx/datetime/internal/format/formatter/FormatterStructure;I)V", "format", "", "obj", "builder", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "minusNotRequired", "", "(Ljava/lang/Object;Ljava/lang/Appendable;Z)V", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SpacePaddedFormatter<T> implements FormatterStructure<T> {
    private final FormatterStructure<T> formatter;
    private final int padding;

    /* JADX WARN: Multi-variable type inference failed */
    public SpacePaddedFormatter(FormatterStructure<? super T> formatter, int padding) {
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        this.formatter = formatter;
        this.padding = padding;
    }

    @Override // kotlinx.datetime.internal.format.formatter.FormatterStructure
    public void format(T t, Appendable builder, boolean minusNotRequired) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        StringBuilder it = new StringBuilder();
        this.formatter.format(t, it, minusNotRequired);
        String string = it.toString();
        Intrinsics.checkNotNullExpressionValue(string, "let(...)");
        int length = this.padding - string.length();
        for (int i = 0; i < length; i++) {
            builder.append(' ');
        }
        builder.append(string);
    }
}