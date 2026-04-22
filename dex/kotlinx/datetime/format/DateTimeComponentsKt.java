package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlinx.datetime.format.DateTimeComponents;
import kotlinx.datetime.internal.format.GenericFieldSpec;
import kotlinx.datetime.internal.format.PropertyAccessor;

/* compiled from: DateTimeComponents.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a)\u0010\u0007\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\t0\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\r\u001a \u0010\u000e\u001a\u00020\t*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"emptyDateTimeComponentsContents", "Lkotlinx/datetime/format/DateTimeComponentsContents;", "timeZoneField", "Lkotlinx/datetime/internal/format/GenericFieldSpec;", "", "getTimeZoneField", "()Lkotlinx/datetime/internal/format/GenericFieldSpec;", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "parse", "Lkotlinx/datetime/format/DateTimeComponents$Companion;", "input", "", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DateTimeComponentsKt {
    private static final GenericFieldSpec<DateTimeComponentsContents, String> timeZoneField = new GenericFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.DateTimeComponentsKt$timeZoneField$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object receiver0) {
            return ((DateTimeComponentsContents) receiver0).getTimeZoneId();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object receiver0, Object value) {
            ((DateTimeComponentsContents) receiver0).setTimeZoneId((String) value);
        }
    }), null, null, null, 14, null);
    private static final DateTimeComponentsContents emptyDateTimeComponentsContents = new DateTimeComponentsContents(null, null, null, null, 15, null);

    public static final String format(DateTimeFormat<DateTimeComponents> dateTimeFormat, Function1<? super DateTimeComponents, Unit> block) {
        Intrinsics.checkNotNullParameter(dateTimeFormat, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        DateTimeComponents $this$format_u24lambda_u240 = new DateTimeComponents(null, 1, null);
        block.invoke($this$format_u24lambda_u240);
        return dateTimeFormat.format($this$format_u24lambda_u240);
    }

    public static final DateTimeComponents parse(DateTimeComponents.Companion $this$parse, CharSequence input, DateTimeFormat<DateTimeComponents> format) {
        Intrinsics.checkNotNullParameter($this$parse, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(format, "format");
        return format.parse(input);
    }

    public static final GenericFieldSpec<DateTimeComponentsContents, String> getTimeZoneField() {
        return timeZoneField;
    }
}