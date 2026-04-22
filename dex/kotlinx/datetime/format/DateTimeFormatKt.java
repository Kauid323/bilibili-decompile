package kotlinx.datetime.format;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.format.DateTimeComponents;
import kotlinx.datetime.internal.format.CachedFormatStructure;

/* compiled from: DateTimeFormat.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\nH\u0080\b\u001a\u001c\u0010\r\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\nH\u0080\b¢\u0006\u0002\u0010\u000e\u001a\f\u0010\u000f\u001a\u00020\u0003*\u00020\u000bH\u0000\"1\u0010\u0000\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"allFormatConstants", "", "Lkotlin/Pair;", "", "Lkotlinx/datetime/internal/format/CachedFormatStructure;", "getAllFormatConstants", "()Ljava/util/List;", "allFormatConstants$delegate", "Lkotlin/Lazy;", "minDigits", "", "Lkotlinx/datetime/format/Padding;", "width", "spaces", "(Lkotlinx/datetime/format/Padding;I)Ljava/lang/Integer;", "toKotlinCode", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DateTimeFormatKt {
    private static final Lazy allFormatConstants$delegate = LazyKt.lazy(new Function0<List<? extends Pair<? extends String, ? extends CachedFormatStructure<?>>>>() { // from class: kotlinx.datetime.format.DateTimeFormatKt$allFormatConstants$2
        private static final CachedFormatStructure<?> invoke$unwrap(DateTimeFormat<?> dateTimeFormat) {
            Intrinsics.checkNotNull(dateTimeFormat, "null cannot be cast to non-null type kotlinx.datetime.format.AbstractDateTimeFormat<*, *>");
            return ((AbstractDateTimeFormat) dateTimeFormat).getActualFormat();
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Pair<? extends String, ? extends CachedFormatStructure<?>>> invoke() {
            return CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("dateTimeComponents(DateTimeComponents.Formats.RFC_1123)", invoke$unwrap(DateTimeComponents.Formats.INSTANCE.getRFC_1123())), TuplesKt.to("dateTimeComponents(DateTimeComponents.Formats.ISO_DATE_TIME_OFFSET)", invoke$unwrap(DateTimeComponents.Formats.INSTANCE.getISO_DATE_TIME_OFFSET())), TuplesKt.to("date(LocalDateTime.Formats.ISO)", invoke$unwrap(LocalDateTime.Formats.INSTANCE.getISO())), TuplesKt.to("date(LocalDate.Formats.ISO)", invoke$unwrap(LocalDate.Formats.INSTANCE.getISO())), TuplesKt.to("date(LocalDate.Formats.ISO_BASIC)", invoke$unwrap(LocalDate.Formats.INSTANCE.getISO_BASIC())), TuplesKt.to("time(LocalTime.Formats.ISO)", invoke$unwrap(LocalTime.Formats.INSTANCE.getISO())), TuplesKt.to("offset(UtcOffset.Formats.ISO)", invoke$unwrap(UtcOffset.Formats.INSTANCE.getISO())), TuplesKt.to("offset(UtcOffset.Formats.ISO_BASIC)", invoke$unwrap(UtcOffset.Formats.INSTANCE.getISO_BASIC())), TuplesKt.to("offset(UtcOffset.Formats.FOUR_DIGITS)", invoke$unwrap(UtcOffset.Formats.INSTANCE.getFOUR_DIGITS()))});
        }
    });

    /* compiled from: DateTimeFormat.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Padding.values().length];
            try {
                iArr[Padding.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Padding.ZERO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Padding.SPACE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String toKotlinCode(Padding $this$toKotlinCode) {
        Intrinsics.checkNotNullParameter($this$toKotlinCode, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toKotlinCode.ordinal()]) {
            case 1:
                return "Padding.NONE";
            case 2:
                return "Padding.ZERO";
            case 3:
                return "Padding.SPACE";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final int minDigits(Padding $this$minDigits, int width) {
        Intrinsics.checkNotNullParameter($this$minDigits, "<this>");
        if ($this$minDigits == Padding.ZERO) {
            return width;
        }
        return 1;
    }

    public static final Integer spaces(Padding $this$spaces, int width) {
        Intrinsics.checkNotNullParameter($this$spaces, "<this>");
        if ($this$spaces == Padding.SPACE) {
            return Integer.valueOf(width);
        }
        return null;
    }

    public static final List<Pair<String, CachedFormatStructure<?>>> getAllFormatConstants() {
        return (List) allFormatConstants$delegate.getValue();
    }
}