package kotlinx.datetime.format;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.internal.format.AlternativesParsingFormatStructure;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.ConcatenatedFormatStructure;
import kotlinx.datetime.internal.format.ConstantFormatStructure;
import kotlinx.datetime.internal.format.OptionalFormatStructure;

/* compiled from: DateTimeFormatBuilder.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0014\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00002\u00020\u0003J\\\u0010\b\u001a\u00020\t24\u0010\n\u001a\u001b\u0012\u0017\b\u0001\u0012\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\r0\u000b\"\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\rH\u0016¢\u0006\u0002\u0010\u000fJ)\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\rH\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\r\u0010\u0018\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0019R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lkotlinx/datetime/format/AbstractDateTimeFormatBuilder;", "Target", "ActualSelf", "Lkotlinx/datetime/format/DateTimeFormatBuilder;", "actualBuilder", "Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "getActualBuilder", "()Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "appendAlternativeParsingImpl", "", "otherFormats", "", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "mainFormat", "([Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "appendOptionalImpl", "onZero", "", "format", "build", "Lkotlinx/datetime/internal/format/CachedFormatStructure;", "chars", "value", "createEmpty", "()Lkotlinx/datetime/format/AbstractDateTimeFormatBuilder;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AbstractDateTimeFormatBuilder<Target, ActualSelf extends AbstractDateTimeFormatBuilder<Target, ActualSelf>> extends DateTimeFormatBuilder {
    void appendAlternativeParsingImpl(Function1<? super ActualSelf, Unit>[] function1Arr, Function1<? super ActualSelf, Unit> function1);

    void appendOptionalImpl(String str, Function1<? super ActualSelf, Unit> function1);

    CachedFormatStructure<Target> build();

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder
    void chars(String str);

    ActualSelf createEmpty();

    AppendableFormatStructure<Target> getActualBuilder();

    /* compiled from: DateTimeFormatBuilder.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        public static <Target, ActualSelf extends AbstractDateTimeFormatBuilder<Target, ActualSelf>> void appendAlternativeParsingImpl(AbstractDateTimeFormatBuilder<Target, ActualSelf> abstractDateTimeFormatBuilder, Function1<? super ActualSelf, Unit>[] otherFormats, Function1<? super ActualSelf, Unit> mainFormat) {
            Intrinsics.checkNotNullParameter(otherFormats, "otherFormats");
            Intrinsics.checkNotNullParameter(mainFormat, "mainFormat");
            Collection destination$iv$iv = new ArrayList(otherFormats.length);
            for (Function1<? super ActualSelf, Unit> function1 : otherFormats) {
                AbstractDateTimeFormatBuilder it = abstractDateTimeFormatBuilder.createEmpty();
                function1.invoke(it);
                destination$iv$iv.add(it.getActualBuilder().build());
            }
            List others = (List) destination$iv$iv;
            AbstractDateTimeFormatBuilder it2 = abstractDateTimeFormatBuilder.createEmpty();
            mainFormat.invoke(it2);
            ConcatenatedFormatStructure main = it2.getActualBuilder().build();
            abstractDateTimeFormatBuilder.getActualBuilder().add(new AlternativesParsingFormatStructure(main, others));
        }

        public static <Target, ActualSelf extends AbstractDateTimeFormatBuilder<Target, ActualSelf>> void appendOptionalImpl(AbstractDateTimeFormatBuilder<Target, ActualSelf> abstractDateTimeFormatBuilder, String onZero, Function1<? super ActualSelf, Unit> format) {
            Intrinsics.checkNotNullParameter(onZero, "onZero");
            Intrinsics.checkNotNullParameter(format, "format");
            AppendableFormatStructure<Target> actualBuilder = abstractDateTimeFormatBuilder.getActualBuilder();
            AbstractDateTimeFormatBuilder it = abstractDateTimeFormatBuilder.createEmpty();
            format.invoke(it);
            Unit unit = Unit.INSTANCE;
            actualBuilder.add(new OptionalFormatStructure(onZero, it.getActualBuilder().build()));
        }

        public static <Target, ActualSelf extends AbstractDateTimeFormatBuilder<Target, ActualSelf>> void chars(AbstractDateTimeFormatBuilder<Target, ActualSelf> abstractDateTimeFormatBuilder, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            abstractDateTimeFormatBuilder.getActualBuilder().add(new ConstantFormatStructure(value));
        }

        public static <Target, ActualSelf extends AbstractDateTimeFormatBuilder<Target, ActualSelf>> CachedFormatStructure<Target> build(AbstractDateTimeFormatBuilder<Target, ActualSelf> abstractDateTimeFormatBuilder) {
            return new CachedFormatStructure<>(abstractDateTimeFormatBuilder.getActualBuilder().build().getFormats());
        }
    }
}