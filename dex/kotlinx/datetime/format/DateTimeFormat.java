package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateTimeFormat.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0012J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J+\u0010\u0007\u001a\u0002H\b\"\f\b\u0001\u0010\b*\u00060\tj\u0002`\n2\u0006\u0010\u000b\u001a\u0002H\b2\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000fH&¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000e\u001a\u00020\u000fH&¢\u0006\u0002\u0010\u0010\u0082\u0001\u0001\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/datetime/format/DateTimeFormat;", "T", "", "format", "", "value", "(Ljava/lang/Object;)Ljava/lang/String;", "formatTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "appendable", "(Ljava/lang/Appendable;Ljava/lang/Object;)Ljava/lang/Appendable;", "parse", "input", "", "(Ljava/lang/CharSequence;)Ljava/lang/Object;", "parseOrNull", "Companion", "Lkotlinx/datetime/format/AbstractDateTimeFormat;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface DateTimeFormat<T> {
    public static final Companion Companion = Companion.$$INSTANCE;

    String format(T t);

    <A extends Appendable> A formatTo(A a, T t);

    T parse(CharSequence charSequence);

    T parseOrNull(CharSequence charSequence);

    /* compiled from: DateTimeFormat.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/datetime/format/DateTimeFormat$Companion;", "", "()V", "formatAsKotlinBuilderDsl", "", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final String formatAsKotlinBuilderDsl(DateTimeFormat<?> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            if (format instanceof AbstractDateTimeFormat) {
                return DateTimeFormatBuilderKt.builderString(((AbstractDateTimeFormat) format).getActualFormat(), DateTimeFormatKt.access$getAllFormatConstants());
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}