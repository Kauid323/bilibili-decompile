package kotlinx.datetime.format;

import j$.time.DayOfWeek;
import j$.time.Month;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.DayOfWeekKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.MonthKt;
import kotlinx.datetime.TimeZoneKt;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.format.DateTimeComponentsFormat;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.DateCalculationsKt;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.io.FilenameUtils;

/* compiled from: DateTimeComponents.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b-\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 ~2\u00020\u0001:\u0002~\u007fB\u0013\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0006¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u000f¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0017¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010(R/\u00101\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R/\u00105\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R/\u00109\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010,\u001a\u0004\b7\u0010.\"\u0004\b8\u00100R/\u0010=\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010,\u001a\u0004\b;\u0010.\"\u0004\b<\u00100R/\u0010A\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010,\u001a\u0004\b?\u0010.\"\u0004\b@\u00100R/\u0010E\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bB\u0010,\u001a\u0004\bC\u0010.\"\u0004\bD\u00100R/\u0010I\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bF\u0010,\u001a\u0004\bG\u0010.\"\u0004\bH\u00100R/\u0010M\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bJ\u0010,\u001a\u0004\bK\u0010.\"\u0004\bL\u00100R/\u0010Q\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bN\u0010,\u001a\u0004\bO\u0010.\"\u0004\bP\u00100R/\u0010V\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bR\u0010.\"\u0004\bS\u00100*\u0004\bT\u0010UR4\u0010^\u001a\n\u0018\u00010Wj\u0004\u0018\u0001`X2\u000e\u0010Y\u001a\n\u0018\u00010Wj\u0004\u0018\u0001`X8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R4\u0010e\u001a\n\u0018\u00010_j\u0004\u0018\u0001``2\u000e\u0010Y\u001a\n\u0018\u00010_j\u0004\u0018\u0001``8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR/\u0010l\u001a\u0004\u0018\u00010f2\b\u0010*\u001a\u0004\u0018\u00010f8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bg\u0010h\"\u0004\bi\u0010j*\u0004\bk\u0010UR(\u0010o\u001a\u0004\u0018\u00010)2\b\u0010Y\u001a\u0004\u0018\u00010)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bm\u0010.\"\u0004\bn\u00100R/\u0010v\u001a\u0004\u0018\u00010p2\b\u0010*\u001a\u0004\u0018\u00010p8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bq\u0010r\"\u0004\bs\u0010t*\u0004\bu\u0010UR/\u0010}\u001a\u0004\u0018\u00010w2\b\u0010*\u001a\u0004\u0018\u00010w8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{*\u0004\b|\u0010U¨\u0006\u0080\u0001"}, d2 = {"Lkotlinx/datetime/format/DateTimeComponents;", "", "Lkotlinx/datetime/format/DateTimeComponentsContents;", "contents", "<init>", "(Lkotlinx/datetime/format/DateTimeComponentsContents;)V", "Lkotlinx/datetime/LocalTime;", "localTime", "", "setTime", "(Lkotlinx/datetime/LocalTime;)V", "Lkotlinx/datetime/LocalDate;", "localDate", "setDate", "(Lkotlinx/datetime/LocalDate;)V", "Lkotlinx/datetime/LocalDateTime;", "localDateTime", "setDateTime", "(Lkotlinx/datetime/LocalDateTime;)V", "Lkotlinx/datetime/UtcOffset;", "utcOffset", "setOffset", "(Lkotlinx/datetime/UtcOffset;)V", "Lkotlinx/datetime/Instant;", "instant", "setDateTimeOffset", "(Lkotlinx/datetime/Instant;Lkotlinx/datetime/UtcOffset;)V", "(Lkotlinx/datetime/LocalDateTime;Lkotlinx/datetime/UtcOffset;)V", "toUtcOffset", "()Lkotlinx/datetime/UtcOffset;", "toLocalDate", "()Lkotlinx/datetime/LocalDate;", "toLocalTime", "()Lkotlinx/datetime/LocalTime;", "toLocalDateTime", "()Lkotlinx/datetime/LocalDateTime;", "toInstantUsingOffset", "()Lkotlinx/datetime/Instant;", "Lkotlinx/datetime/format/DateTimeComponentsContents;", "getContents$kotlinx_datetime", "()Lkotlinx/datetime/format/DateTimeComponentsContents;", "", "<set-?>", "monthNumber$delegate", "Lkotlinx/datetime/format/TwoDigitNumber;", "getMonthNumber", "()Ljava/lang/Integer;", "setMonthNumber", "(Ljava/lang/Integer;)V", "monthNumber", "dayOfMonth$delegate", "getDayOfMonth", "setDayOfMonth", "dayOfMonth", "hour$delegate", "getHour", "setHour", "hour", "hourOfAmPm$delegate", "getHourOfAmPm", "setHourOfAmPm", "hourOfAmPm", "minute$delegate", "getMinute", "setMinute", "minute", "second$delegate", "getSecond", "setSecond", "second", "offsetHours$delegate", "getOffsetHours", "setOffsetHours", "offsetHours", "offsetMinutesOfHour$delegate", "getOffsetMinutesOfHour", "setOffsetMinutesOfHour", "offsetMinutesOfHour", "offsetSecondsOfMinute$delegate", "getOffsetSecondsOfMinute", "setOffsetSecondsOfMinute", "offsetSecondsOfMinute", "getYear", "setYear", "getYear$delegate", "(Lkotlinx/datetime/format/DateTimeComponents;)Ljava/lang/Object;", "year", "j$/time/Month", "Lkotlinx/datetime/Month;", "value", "getMonth", "()Lj$/time/Month;", "setMonth", "(Lj$/time/Month;)V", "month", "j$/time/DayOfWeek", "Lkotlinx/datetime/DayOfWeek;", "getDayOfWeek", "()Lj$/time/DayOfWeek;", "setDayOfWeek", "(Lj$/time/DayOfWeek;)V", "dayOfWeek", "Lkotlinx/datetime/format/AmPmMarker;", "getAmPm", "()Lkotlinx/datetime/format/AmPmMarker;", "setAmPm", "(Lkotlinx/datetime/format/AmPmMarker;)V", "getAmPm$delegate", "amPm", "getNanosecond", "setNanosecond", "nanosecond", "", "getOffsetIsNegative", "()Ljava/lang/Boolean;", "setOffsetIsNegative", "(Ljava/lang/Boolean;)V", "getOffsetIsNegative$delegate", "offsetIsNegative", "", "getTimeZoneId", "()Ljava/lang/String;", "setTimeZoneId", "(Ljava/lang/String;)V", "getTimeZoneId$delegate", "timeZoneId", "Companion", "Formats", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DateTimeComponents {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "monthNumber", "getMonthNumber()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "dayOfMonth", "getDayOfMonth()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "hour", "getHour()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "hourOfAmPm", "getHourOfAmPm()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "minute", "getMinute()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "second", "getSecond()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "offsetHours", "getOffsetHours()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "offsetMinutesOfHour", "getOffsetMinutesOfHour()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "offsetSecondsOfMinute", "getOffsetSecondsOfMinute()Ljava/lang/Integer;", 0))};
    public static final Companion Companion = new Companion(null);
    private final DateTimeComponentsContents contents;
    private final TwoDigitNumber dayOfMonth$delegate;
    private final TwoDigitNumber hour$delegate;
    private final TwoDigitNumber hourOfAmPm$delegate;
    private final TwoDigitNumber minute$delegate;
    private final TwoDigitNumber monthNumber$delegate;
    private final TwoDigitNumber offsetHours$delegate;
    private final TwoDigitNumber offsetMinutesOfHour$delegate;
    private final TwoDigitNumber offsetSecondsOfMinute$delegate;
    private final TwoDigitNumber second$delegate;

    public DateTimeComponents() {
        this(null, 1, null);
    }

    /* compiled from: DateTimeComponents.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Lkotlinx/datetime/format/DateTimeComponents$Companion;", "", "()V", "Format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "block", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "", "Lkotlin/ExtensionFunctionType;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DateTimeFormat<DateTimeComponents> Format(Function1<? super DateTimeFormatBuilder.WithDateTimeComponents, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            DateTimeComponentsFormat.Builder builder = new DateTimeComponentsFormat.Builder(new AppendableFormatStructure());
            block.invoke(builder);
            return new DateTimeComponentsFormat(builder.build());
        }
    }

    public DateTimeComponents(DateTimeComponentsContents contents) {
        Intrinsics.checkNotNullParameter(contents, "contents");
        this.contents = contents;
        this.contents.getDate();
        final IncompleteLocalDate date = this.contents.getDate();
        this.monthNumber$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(date) { // from class: kotlinx.datetime.format.DateTimeComponents$monthNumber$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalDate) this.receiver).getMonthNumber();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object value) {
                ((IncompleteLocalDate) this.receiver).setMonthNumber((Integer) value);
            }
        });
        final IncompleteLocalDate date2 = this.contents.getDate();
        this.dayOfMonth$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(date2) { // from class: kotlinx.datetime.format.DateTimeComponents$dayOfMonth$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalDate) this.receiver).getDayOfMonth();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object value) {
                ((IncompleteLocalDate) this.receiver).setDayOfMonth((Integer) value);
            }
        });
        final IncompleteLocalTime time = this.contents.getTime();
        this.hour$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(time) { // from class: kotlinx.datetime.format.DateTimeComponents$hour$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalTime) this.receiver).getHour();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object value) {
                ((IncompleteLocalTime) this.receiver).setHour((Integer) value);
            }
        });
        final IncompleteLocalTime time2 = this.contents.getTime();
        this.hourOfAmPm$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(time2) { // from class: kotlinx.datetime.format.DateTimeComponents$hourOfAmPm$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalTime) this.receiver).getHourOfAmPm();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object value) {
                ((IncompleteLocalTime) this.receiver).setHourOfAmPm((Integer) value);
            }
        });
        this.contents.getTime();
        final IncompleteLocalTime time3 = this.contents.getTime();
        this.minute$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(time3) { // from class: kotlinx.datetime.format.DateTimeComponents$minute$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalTime) this.receiver).getMinute();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object value) {
                ((IncompleteLocalTime) this.receiver).setMinute((Integer) value);
            }
        });
        final IncompleteLocalTime time4 = this.contents.getTime();
        this.second$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(time4) { // from class: kotlinx.datetime.format.DateTimeComponents$second$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalTime) this.receiver).getSecond();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object value) {
                ((IncompleteLocalTime) this.receiver).setSecond((Integer) value);
            }
        });
        this.contents.getOffset();
        final IncompleteUtcOffset offset = this.contents.getOffset();
        this.offsetHours$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(offset) { // from class: kotlinx.datetime.format.DateTimeComponents$offsetHours$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteUtcOffset) this.receiver).getTotalHoursAbs();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object value) {
                ((IncompleteUtcOffset) this.receiver).setTotalHoursAbs((Integer) value);
            }
        });
        final IncompleteUtcOffset offset2 = this.contents.getOffset();
        this.offsetMinutesOfHour$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(offset2) { // from class: kotlinx.datetime.format.DateTimeComponents$offsetMinutesOfHour$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteUtcOffset) this.receiver).getMinutesOfHour();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object value) {
                ((IncompleteUtcOffset) this.receiver).setMinutesOfHour((Integer) value);
            }
        });
        final IncompleteUtcOffset offset3 = this.contents.getOffset();
        this.offsetSecondsOfMinute$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(offset3) { // from class: kotlinx.datetime.format.DateTimeComponents$offsetSecondsOfMinute$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteUtcOffset) this.receiver).getSecondsOfMinute();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object value) {
                ((IncompleteUtcOffset) this.receiver).setSecondsOfMinute((Integer) value);
            }
        });
    }

    public /* synthetic */ DateTimeComponents(DateTimeComponentsContents dateTimeComponentsContents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DateTimeComponentsContents(null, null, null, null, 15, null) : dateTimeComponentsContents);
    }

    public final DateTimeComponentsContents getContents$kotlinx_datetime() {
        return this.contents;
    }

    /* compiled from: DateTimeComponents.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlinx/datetime/format/DateTimeComponents$Formats;", "", "()V", "ISO_DATE_TIME_OFFSET", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "getISO_DATE_TIME_OFFSET", "()Lkotlinx/datetime/format/DateTimeFormat;", "RFC_1123", "getRFC_1123", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Formats {
        public static final Formats INSTANCE = new Formats();
        private static final DateTimeFormat<DateTimeComponents> ISO_DATE_TIME_OFFSET = DateTimeComponents.Companion.Format(new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                invoke2(withDateTimeComponents);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents Format) {
                Intrinsics.checkNotNullParameter(Format, "$this$Format");
                Format.date(LocalDateFormatKt.getISO_DATE());
                DateTimeFormatBuilderKt.alternativeParsing(Format, new Function1[]{new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                        invoke2(withDateTimeComponents);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        DateTimeFormatBuilderKt.m1484char(alternativeParsing, 't');
                    }
                }}, new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                        invoke2(withDateTimeComponents);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        DateTimeFormatBuilderKt.m1484char(alternativeParsing, 'T');
                    }
                });
                DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default(Format, null, 1, null);
                DateTimeFormatBuilderKt.m1484char(Format, AbstractJsonLexerKt.COLON);
                DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default(Format, null, 1, null);
                DateTimeFormatBuilderKt.m1484char(Format, AbstractJsonLexerKt.COLON);
                DateTimeFormatBuilder.WithTime.DefaultImpls.second$default(Format, null, 1, null);
                DateTimeFormatBuilderKt.optional$default(Format, null, new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                        invoke2(withDateTimeComponents);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents optional) {
                        Intrinsics.checkNotNullParameter(optional, "$this$optional");
                        DateTimeFormatBuilderKt.m1484char(optional, FilenameUtils.EXTENSION_SEPARATOR);
                        optional.secondFraction(1, 9);
                    }
                }, 1, null);
                DateTimeFormatBuilderKt.alternativeParsing(Format, new Function1[]{new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                        invoke2(withDateTimeComponents);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetHours$default(alternativeParsing, null, 1, null);
                    }
                }}, new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1.5
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                        invoke2(withDateTimeComponents);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        alternativeParsing.offset(UtcOffset.Formats.INSTANCE.getISO());
                    }
                });
            }
        });
        private static final DateTimeFormat<DateTimeComponents> RFC_1123 = DateTimeComponents.Companion.Format(new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                invoke2(withDateTimeComponents);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents Format) {
                Intrinsics.checkNotNullParameter(Format, "$this$Format");
                DateTimeFormatBuilderKt.alternativeParsing(Format, new Function1[]{new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                        invoke2(withDateTimeComponents);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                    }
                }}, new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                        invoke2(withDateTimeComponents);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        alternativeParsing.dayOfWeek(DayOfWeekNames.Companion.getENGLISH_ABBREVIATED());
                        alternativeParsing.chars(", ");
                    }
                });
                Format.dayOfMonth(Padding.NONE);
                DateTimeFormatBuilderKt.m1484char(Format, ' ');
                Format.monthName(MonthNames.Companion.getENGLISH_ABBREVIATED());
                DateTimeFormatBuilderKt.m1484char(Format, ' ');
                DateTimeFormatBuilder.WithDate.DefaultImpls.year$default(Format, null, 1, null);
                DateTimeFormatBuilderKt.m1484char(Format, ' ');
                DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default(Format, null, 1, null);
                DateTimeFormatBuilderKt.m1484char(Format, AbstractJsonLexerKt.COLON);
                DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default(Format, null, 1, null);
                DateTimeFormatBuilderKt.optional$default(Format, null, new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                        invoke2(withDateTimeComponents);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents optional) {
                        Intrinsics.checkNotNullParameter(optional, "$this$optional");
                        DateTimeFormatBuilderKt.m1484char(optional, AbstractJsonLexerKt.COLON);
                        DateTimeFormatBuilder.WithTime.DefaultImpls.second$default(optional, null, 1, null);
                    }
                }, 1, null);
                Format.chars(" ");
                DateTimeFormatBuilderKt.alternativeParsing(Format, new Function1[]{new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                        invoke2(withDateTimeComponents);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        alternativeParsing.chars("UT");
                    }
                }, new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1.5
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                        invoke2(withDateTimeComponents);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        alternativeParsing.chars("Z");
                    }
                }}, new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1.6
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                        invoke2(withDateTimeComponents);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        DateTimeFormatBuilderKt.optional(alternativeParsing, "GMT", new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents.Formats.RFC_1123.1.6.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                                invoke2(withDateTimeComponents);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents optional) {
                                Intrinsics.checkNotNullParameter(optional, "$this$optional");
                                optional.offset(UtcOffset.Formats.INSTANCE.getFOUR_DIGITS());
                            }
                        });
                    }
                });
            }
        });

        private Formats() {
        }

        public final DateTimeFormat<DateTimeComponents> getISO_DATE_TIME_OFFSET() {
            return ISO_DATE_TIME_OFFSET;
        }

        public final DateTimeFormat<DateTimeComponents> getRFC_1123() {
            return RFC_1123;
        }
    }

    public final void setTime(LocalTime localTime) {
        Intrinsics.checkNotNullParameter(localTime, "localTime");
        this.contents.getTime().populateFrom(localTime);
    }

    public final void setDate(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "localDate");
        this.contents.getDate().populateFrom(localDate);
    }

    public final void setDateTime(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "localDateTime");
        this.contents.getDate().populateFrom(localDateTime.getDate());
        this.contents.getTime().populateFrom(localDateTime.getTime());
    }

    public final void setOffset(UtcOffset utcOffset) {
        Intrinsics.checkNotNullParameter(utcOffset, "utcOffset");
        this.contents.getOffset().populateFrom(utcOffset);
    }

    public final void setDateTimeOffset(Instant instant, UtcOffset utcOffset) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        Intrinsics.checkNotNullParameter(utcOffset, "utcOffset");
        Instant smallerInstant = Instant.Companion.fromEpochSeconds(instant.getEpochSeconds() % DateCalculationsKt.SECONDS_PER_10000_YEARS, instant.getNanosecondsOfSecond());
        setDateTime(TimeZoneKt.toLocalDateTime(smallerInstant, utcOffset));
        setOffset(utcOffset);
        Integer year = getYear();
        Intrinsics.checkNotNull(year);
        setYear(Integer.valueOf(year.intValue() + ((int) ((instant.getEpochSeconds() / DateCalculationsKt.SECONDS_PER_10000_YEARS) * 10000))));
    }

    public final void setDateTimeOffset(LocalDateTime localDateTime, UtcOffset utcOffset) {
        Intrinsics.checkNotNullParameter(localDateTime, "localDateTime");
        Intrinsics.checkNotNullParameter(utcOffset, "utcOffset");
        setDateTime(localDateTime);
        setOffset(utcOffset);
    }

    public final Integer getYear() {
        return this.contents.getDate().getYear();
    }

    public final void setYear(Integer num) {
        this.contents.getDate().setYear(num);
    }

    public final Integer getMonthNumber() {
        return this.monthNumber$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setMonthNumber(Integer num) {
        this.monthNumber$delegate.setValue(this, $$delegatedProperties[0], num);
    }

    public final Month getMonth() {
        Integer monthNumber = getMonthNumber();
        if (monthNumber != null) {
            int it = monthNumber.intValue();
            return MonthKt.Month(it);
        }
        return null;
    }

    public final void setMonth(Month value) {
        setMonthNumber(value != null ? Integer.valueOf(MonthKt.getNumber(value)) : null);
    }

    public final Integer getDayOfMonth() {
        return this.dayOfMonth$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setDayOfMonth(Integer num) {
        this.dayOfMonth$delegate.setValue(this, $$delegatedProperties[1], num);
    }

    public final DayOfWeek getDayOfWeek() {
        Integer isoDayOfWeek = this.contents.getDate().getIsoDayOfWeek();
        if (isoDayOfWeek != null) {
            int it = isoDayOfWeek.intValue();
            return DayOfWeekKt.DayOfWeek(it);
        }
        return null;
    }

    public final void setDayOfWeek(DayOfWeek value) {
        this.contents.getDate().setIsoDayOfWeek(value != null ? Integer.valueOf(DayOfWeekKt.getIsoDayNumber(value)) : null);
    }

    public final Integer getHour() {
        return this.hour$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setHour(Integer num) {
        this.hour$delegate.setValue(this, $$delegatedProperties[2], num);
    }

    public final Integer getHourOfAmPm() {
        return this.hourOfAmPm$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final void setHourOfAmPm(Integer num) {
        this.hourOfAmPm$delegate.setValue(this, $$delegatedProperties[3], num);
    }

    public final AmPmMarker getAmPm() {
        return this.contents.getTime().getAmPm();
    }

    public final void setAmPm(AmPmMarker amPmMarker) {
        this.contents.getTime().setAmPm(amPmMarker);
    }

    public final Integer getMinute() {
        return this.minute$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final void setMinute(Integer num) {
        this.minute$delegate.setValue(this, $$delegatedProperties[4], num);
    }

    public final Integer getSecond() {
        return this.second$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final void setSecond(Integer num) {
        this.second$delegate.setValue(this, $$delegatedProperties[5], num);
    }

    public final Integer getNanosecond() {
        return this.contents.getTime().getNanosecond();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
        if (new kotlin.ranges.IntRange(0, 999999999).contains(r4.intValue()) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setNanosecond(Integer value) {
        boolean z = value == null;
        if (!z) {
            throw new IllegalArgumentException("Nanosecond must be in the range [0, 999_999_999].".toString());
        }
        this.contents.getTime().setNanosecond(value);
    }

    public final Boolean getOffsetIsNegative() {
        return this.contents.getOffset().isNegative();
    }

    public final void setOffsetIsNegative(Boolean bool) {
        this.contents.getOffset().setNegative(bool);
    }

    public final Integer getOffsetHours() {
        return this.offsetHours$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final void setOffsetHours(Integer num) {
        this.offsetHours$delegate.setValue(this, $$delegatedProperties[6], num);
    }

    public final Integer getOffsetMinutesOfHour() {
        return this.offsetMinutesOfHour$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final void setOffsetMinutesOfHour(Integer num) {
        this.offsetMinutesOfHour$delegate.setValue(this, $$delegatedProperties[7], num);
    }

    public final Integer getOffsetSecondsOfMinute() {
        return this.offsetSecondsOfMinute$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final void setOffsetSecondsOfMinute(Integer num) {
        this.offsetSecondsOfMinute$delegate.setValue(this, $$delegatedProperties[8], num);
    }

    public final String getTimeZoneId() {
        return this.contents.getTimeZoneId();
    }

    public final void setTimeZoneId(String str) {
        this.contents.setTimeZoneId(str);
    }

    public final UtcOffset toUtcOffset() {
        return this.contents.getOffset().toUtcOffset();
    }

    public final LocalDate toLocalDate() {
        return this.contents.getDate().toLocalDate();
    }

    public final LocalTime toLocalTime() {
        return this.contents.getTime().toLocalTime();
    }

    public final LocalDateTime toLocalDateTime() {
        return LocalDateKt.atTime(toLocalDate(), toLocalTime());
    }

    public final Instant toInstantUsingOffset() {
        Integer year;
        UtcOffset offset = toUtcOffset();
        LocalTime time = toLocalTime();
        IncompleteLocalDate truncatedDate = this.contents.getDate().copy();
        truncatedDate.setYear(Integer.valueOf(((Number) LocalDateFormatKt.requireParsedField(truncatedDate.getYear(), "year")).intValue() % 10000));
        try {
            Intrinsics.checkNotNull(getYear());
            long secDelta = MathJvmKt.safeMultiply(year.intValue() / 10000, (long) DateCalculationsKt.SECONDS_PER_10000_YEARS);
            long epochDays = truncatedDate.toLocalDate().toEpochDays();
            long totalSeconds = MathJvmKt.safeAdd(secDelta, ((((long) DateCalculationsKt.SECONDS_PER_DAY) * epochDays) + time.toSecondOfDay()) - offset.getTotalSeconds());
            if (totalSeconds < Instant.Companion.getMIN$kotlinx_datetime().getEpochSeconds() || totalSeconds > Instant.Companion.getMAX$kotlinx_datetime().getEpochSeconds()) {
                throw new DateTimeFormatException("The parsed date is outside the range representable by Instant");
            }
            Instant.Companion companion = Instant.Companion;
            Integer nanosecond = getNanosecond();
            return companion.fromEpochSeconds(totalSeconds, nanosecond != null ? nanosecond.intValue() : 0);
        } catch (ArithmeticException e) {
            throw new DateTimeFormatException("The parsed date is outside the range representable by Instant", e);
        }
    }
}