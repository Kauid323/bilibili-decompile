package kotlinx.datetime.format;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.DayOfWeekNames;
import kotlinx.datetime.internal.format.BasicFormatStructure;

/* compiled from: LocalDateFormat.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a%\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u0001H\u000f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0000¢\u0006\u0002\u0010\u0012\u001a\f\u0010\u0013\u001a\u00020\u000b*\u00020\u0014H\u0002\u001a\f\u0010\u0013\u001a\u00020\u000b*\u00020\u0015H\u0002\u001a\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0000\u001a\u0014\u0010\u001b\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\"!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"ISO_DATE", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDate;", "getISO_DATE", "()Lkotlinx/datetime/format/DateTimeFormat;", "ISO_DATE$delegate", "Lkotlin/Lazy;", "ISO_DATE_BASIC", "getISO_DATE_BASIC", "ISO_DATE_BASIC$delegate", "YEAR_OF_ERA_COMMENT", "", "emptyIncompleteLocalDate", "Lkotlinx/datetime/format/IncompleteLocalDate;", "requireParsedField", "T", "field", "name", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "toKotlinCode", "Lkotlinx/datetime/format/DayOfWeekNames;", "Lkotlinx/datetime/format/MonthNames;", "yearOfEra", "", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "padding", "Lkotlinx/datetime/format/Padding;", "yearOfEraTwoDigits", "baseYear", "", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class LocalDateFormatKt {
    private static final String YEAR_OF_ERA_COMMENT = " /** TODO: the original format had an `y` directive, so the behavior is different on years earlier than 1 AD. See the [kotlinx.datetime.format.byUnicodePattern] documentation for details. */";
    private static final Lazy ISO_DATE$delegate = LazyKt.lazy(new Function0<DateTimeFormat<LocalDate>>() { // from class: kotlinx.datetime.format.LocalDateFormatKt$ISO_DATE$2
        @Override // kotlin.jvm.functions.Function0
        public final DateTimeFormat<LocalDate> invoke() {
            return LocalDateFormat.Companion.build(new Function1<DateTimeFormatBuilder.WithDate, Unit>() { // from class: kotlinx.datetime.format.LocalDateFormatKt$ISO_DATE$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDate withDate) {
                    invoke2(withDate);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(DateTimeFormatBuilder.WithDate build) {
                    Intrinsics.checkNotNullParameter(build, "$this$build");
                    DateTimeFormatBuilder.WithDate.DefaultImpls.year$default(build, null, 1, null);
                    DateTimeFormatBuilderKt.m1484char(build, '-');
                    DateTimeFormatBuilder.WithDate.DefaultImpls.monthNumber$default(build, null, 1, null);
                    DateTimeFormatBuilderKt.m1484char(build, '-');
                    DateTimeFormatBuilder.WithDate.DefaultImpls.dayOfMonth$default(build, null, 1, null);
                }
            });
        }
    });
    private static final Lazy ISO_DATE_BASIC$delegate = LazyKt.lazy(new Function0<DateTimeFormat<LocalDate>>() { // from class: kotlinx.datetime.format.LocalDateFormatKt$ISO_DATE_BASIC$2
        @Override // kotlin.jvm.functions.Function0
        public final DateTimeFormat<LocalDate> invoke() {
            return LocalDateFormat.Companion.build(new Function1<DateTimeFormatBuilder.WithDate, Unit>() { // from class: kotlinx.datetime.format.LocalDateFormatKt$ISO_DATE_BASIC$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDate withDate) {
                    invoke2(withDate);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(DateTimeFormatBuilder.WithDate build) {
                    Intrinsics.checkNotNullParameter(build, "$this$build");
                    DateTimeFormatBuilder.WithDate.DefaultImpls.year$default(build, null, 1, null);
                    DateTimeFormatBuilder.WithDate.DefaultImpls.monthNumber$default(build, null, 1, null);
                    DateTimeFormatBuilder.WithDate.DefaultImpls.dayOfMonth$default(build, null, 1, null);
                }
            });
        }
    });
    private static final IncompleteLocalDate emptyIncompleteLocalDate = new IncompleteLocalDate(null, null, null, null, 15, null);

    public static final /* synthetic */ IncompleteLocalDate access$getEmptyIncompleteLocalDate$p() {
        return emptyIncompleteLocalDate;
    }

    public static final String toKotlinCode(MonthNames $this$toKotlinCode) {
        List<String> names = $this$toKotlinCode.getNames();
        if (Intrinsics.areEqual(names, MonthNames.Companion.getENGLISH_FULL().getNames())) {
            StringBuilder append = new StringBuilder().append("MonthNames.");
            DayOfWeekNames.Companion companion = DayOfWeekNames.Companion;
            return append.append("ENGLISH_FULL").toString();
        } else if (Intrinsics.areEqual(names, MonthNames.Companion.getENGLISH_ABBREVIATED().getNames())) {
            StringBuilder append2 = new StringBuilder().append("MonthNames.");
            DayOfWeekNames.Companion companion2 = DayOfWeekNames.Companion;
            return append2.append("ENGLISH_ABBREVIATED").toString();
        } else {
            return CollectionsKt.joinToString$default($this$toKotlinCode.getNames(), ", ", "MonthNames(", ")", 0, null, LocalDateFormatKt$toKotlinCode$1.INSTANCE, 24, null);
        }
    }

    public static final String toKotlinCode(DayOfWeekNames $this$toKotlinCode) {
        List<String> names = $this$toKotlinCode.getNames();
        if (Intrinsics.areEqual(names, DayOfWeekNames.Companion.getENGLISH_FULL().getNames())) {
            StringBuilder append = new StringBuilder().append("DayOfWeekNames.");
            DayOfWeekNames.Companion companion = DayOfWeekNames.Companion;
            return append.append("ENGLISH_FULL").toString();
        } else if (Intrinsics.areEqual(names, DayOfWeekNames.Companion.getENGLISH_ABBREVIATED().getNames())) {
            StringBuilder append2 = new StringBuilder().append("DayOfWeekNames.");
            DayOfWeekNames.Companion companion2 = DayOfWeekNames.Companion;
            return append2.append("ENGLISH_ABBREVIATED").toString();
        } else {
            return CollectionsKt.joinToString$default($this$toKotlinCode.getNames(), ", ", "DayOfWeekNames(", ")", 0, null, LocalDateFormatKt$toKotlinCode$2.INSTANCE, 24, null);
        }
    }

    public static final <T> T requireParsedField(T t, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (t == null) {
            throw new DateTimeFormatException("Can not create a " + name + " from the given input: the field " + name + " is missing");
        }
        return t;
    }

    public static final void yearOfEra(DateTimeFormatBuilder.WithDate $this$yearOfEra, Padding padding) {
        Intrinsics.checkNotNullParameter($this$yearOfEra, "<this>");
        Intrinsics.checkNotNullParameter(padding, "padding");
        if ($this$yearOfEra instanceof AbstractWithDateBuilder) {
            ((AbstractWithDateBuilder) $this$yearOfEra).addFormatStructureForDate(new BasicFormatStructure(new YearDirective(padding, true)));
        }
    }

    public static final void yearOfEraTwoDigits(DateTimeFormatBuilder.WithDate $this$yearOfEraTwoDigits, int baseYear) {
        Intrinsics.checkNotNullParameter($this$yearOfEraTwoDigits, "<this>");
        if ($this$yearOfEraTwoDigits instanceof AbstractWithDateBuilder) {
            ((AbstractWithDateBuilder) $this$yearOfEraTwoDigits).addFormatStructureForDate(new BasicFormatStructure(new ReducedYearDirective(baseYear, true)));
        }
    }

    public static final DateTimeFormat<LocalDate> getISO_DATE() {
        return (DateTimeFormat) ISO_DATE$delegate.getValue();
    }

    public static final DateTimeFormat<LocalDate> getISO_DATE_BASIC() {
        return (DateTimeFormat) ISO_DATE_BASIC$delegate.getValue();
    }
}