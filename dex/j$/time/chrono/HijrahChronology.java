package j$.time.chrono;

import j$.time.Clock;
import j$.time.DateTimeException;
import j$.time.Duration$DurationUnits$$ExternalSyntheticBackport0;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalField;
import j$.time.temporal.ValueRange;
import j$.util.DesugarCalendar;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class HijrahChronology extends AbstractChronology implements Serializable {
    public static final HijrahChronology INSTANCE = new HijrahChronology("Hijrah-umalqura", "islamic-umalqura");
    private static final long serialVersionUID = 3127340209035924785L;
    private final transient String calendarType;
    private transient int[] hijrahEpochMonthStartDays;
    private transient int hijrahStartEpochMonth;
    private volatile transient boolean initComplete;
    private transient int maxEpochDay;
    private transient int maxMonthLength;
    private transient int maxYearLength;
    private transient int minEpochDay;
    private transient int minMonthLength;
    private transient int minYearLength;
    private final transient String typeId;

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate resolveDate(Map map, ResolverStyle resolverStyle) {
        return resolveDate((Map<TemporalField, Long>) map, resolverStyle);
    }

    static {
        AbstractChronology.registerChrono(INSTANCE, "Hijrah");
        AbstractChronology.registerChrono(INSTANCE, "islamic");
    }

    private HijrahChronology(String id, String calType) {
        if (id.isEmpty()) {
            throw new IllegalArgumentException("calendar id is empty");
        }
        if (calType.isEmpty()) {
            throw new IllegalArgumentException("calendar typeId is empty");
        }
        this.typeId = id;
        this.calendarType = calType;
    }

    private void checkCalendarInit() {
        if (!this.initComplete) {
            loadCalendarData();
            this.initComplete = true;
        }
    }

    @Override // j$.time.chrono.Chronology
    public String getId() {
        return this.typeId;
    }

    @Override // j$.time.chrono.Chronology
    public String getCalendarType() {
        return this.calendarType;
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public HijrahDate date(Era era, int yearOfEra, int month, int dayOfMonth) {
        return date(prolepticYear(era, yearOfEra), month, dayOfMonth);
    }

    @Override // j$.time.chrono.Chronology
    public HijrahDate date(int prolepticYear, int month, int dayOfMonth) {
        return HijrahDate.of(this, prolepticYear, month, dayOfMonth);
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public HijrahDate dateYearDay(Era era, int yearOfEra, int dayOfYear) {
        return dateYearDay(prolepticYear(era, yearOfEra), dayOfYear);
    }

    @Override // j$.time.chrono.Chronology
    public HijrahDate dateYearDay(int prolepticYear, int dayOfYear) {
        HijrahDate date = HijrahDate.of(this, prolepticYear, 1, 1);
        if (dayOfYear > date.lengthOfYear()) {
            throw new DateTimeException("Invalid dayOfYear: " + dayOfYear);
        }
        return date.plusDays(dayOfYear - 1);
    }

    @Override // j$.time.chrono.Chronology
    public HijrahDate dateEpochDay(long epochDay) {
        return HijrahDate.ofEpochDay(this, epochDay);
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public HijrahDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public HijrahDate dateNow(ZoneId zone) {
        return dateNow(Clock.system(zone));
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public HijrahDate dateNow(Clock clock) {
        return date((TemporalAccessor) LocalDate.now(clock));
    }

    @Override // j$.time.chrono.Chronology
    public HijrahDate date(TemporalAccessor temporal) {
        if (temporal instanceof HijrahDate) {
            return (HijrahDate) temporal;
        }
        return HijrahDate.ofEpochDay(this, temporal.getLong(ChronoField.EPOCH_DAY));
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public ChronoLocalDateTime<HijrahDate> localDateTime(TemporalAccessor temporal) {
        return super.localDateTime(temporal);
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public ChronoZonedDateTime<HijrahDate> zonedDateTime(TemporalAccessor temporal) {
        return super.zonedDateTime(temporal);
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public ChronoZonedDateTime<HijrahDate> zonedDateTime(Instant instant, ZoneId zone) {
        return super.zonedDateTime(instant, zone);
    }

    @Override // j$.time.chrono.Chronology
    public boolean isLeapYear(long prolepticYear) {
        checkCalendarInit();
        if (prolepticYear < getMinimumYear() || prolepticYear > getMaximumYear()) {
            return false;
        }
        int len = getYearLength((int) prolepticYear);
        return len > 354;
    }

    @Override // j$.time.chrono.Chronology
    public int prolepticYear(Era era, int yearOfEra) {
        if (!(era instanceof HijrahEra)) {
            throw new ClassCastException("Era must be HijrahEra");
        }
        return yearOfEra;
    }

    @Override // j$.time.chrono.Chronology
    public HijrahEra eraOf(int eraValue) {
        switch (eraValue) {
            case 1:
                return HijrahEra.AH;
            default:
                throw new DateTimeException("invalid Hijrah era");
        }
    }

    @Override // j$.time.chrono.Chronology
    public List<Era> eras() {
        return Duration$DurationUnits$$ExternalSyntheticBackport0.m(HijrahEra.values());
    }

    @Override // j$.time.chrono.Chronology
    public ValueRange range(ChronoField field) {
        checkCalendarInit();
        if (field instanceof ChronoField) {
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[field.ordinal()]) {
                case 1:
                    return ValueRange.of(1L, 1L, getMinimumMonthLength(), getMaximumMonthLength());
                case DesugarCalendar.LONG_FORMAT /* 2 */:
                    return ValueRange.of(1L, getMaximumDayOfYear());
                case 3:
                    return ValueRange.of(1L, 5L);
                case 4:
                case 5:
                    return ValueRange.of(getMinimumYear(), getMaximumYear());
                case 6:
                    return ValueRange.of(1L, 1L);
                default:
                    return field.range();
            }
        }
        return field.range();
    }

    /* renamed from: j$.time.chrono.HijrahChronology$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField = new int[ChronoField.values().length];

        static {
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ERA.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public HijrahDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        return (HijrahDate) super.resolveDate(map, resolverStyle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int checkValidYear(long prolepticYear) {
        if (prolepticYear < getMinimumYear() || prolepticYear > getMaximumYear()) {
            throw new DateTimeException("Invalid Hijrah year: " + prolepticYear);
        }
        return (int) prolepticYear;
    }

    void checkValidDayOfYear(int dayOfYear) {
        if (dayOfYear < 1 || dayOfYear > getMaximumDayOfYear()) {
            throw new DateTimeException("Invalid Hijrah day of year: " + dayOfYear);
        }
    }

    void checkValidMonth(int month) {
        if (month < 1 || month > 12) {
            throw new DateTimeException("Invalid Hijrah month: " + month);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getHijrahDateInfo(int epochDay) {
        checkCalendarInit();
        if (epochDay < this.minEpochDay || epochDay >= this.maxEpochDay) {
            throw new DateTimeException("Hijrah date out of range");
        }
        int epochMonth = epochDayToEpochMonth(epochDay);
        int year = epochMonthToYear(epochMonth);
        int month = epochMonthToMonth(epochMonth);
        int day1 = epochMonthToEpochDay(epochMonth);
        int date = epochDay - day1;
        int[] dateInfo = {year, month + 1, date + 1};
        return dateInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getEpochDay(int prolepticYear, int monthOfYear, int dayOfMonth) {
        checkCalendarInit();
        checkValidMonth(monthOfYear);
        int epochMonth = yearToEpochMonth(prolepticYear) + (monthOfYear - 1);
        if (epochMonth < 0 || epochMonth >= this.hijrahEpochMonthStartDays.length) {
            throw new DateTimeException("Invalid Hijrah date, year: " + prolepticYear + ", month: " + monthOfYear);
        }
        if (dayOfMonth < 1 || dayOfMonth > getMonthLength(prolepticYear, monthOfYear)) {
            throw new DateTimeException("Invalid Hijrah day of month: " + dayOfMonth);
        }
        return epochMonthToEpochDay(epochMonth) + (dayOfMonth - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getDayOfYear(int prolepticYear, int month) {
        return yearMonthToDayOfYear(prolepticYear, month - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMonthLength(int prolepticYear, int monthOfYear) {
        int epochMonth = yearToEpochMonth(prolepticYear) + (monthOfYear - 1);
        if (epochMonth < 0 || epochMonth >= this.hijrahEpochMonthStartDays.length) {
            throw new DateTimeException("Invalid Hijrah date, year: " + prolepticYear + ", month: " + monthOfYear);
        }
        return epochMonthLength(epochMonth);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getYearLength(int prolepticYear) {
        return yearMonthToDayOfYear(prolepticYear, 12);
    }

    int getMinimumYear() {
        return epochMonthToYear(0);
    }

    int getMaximumYear() {
        return epochMonthToYear(this.hijrahEpochMonthStartDays.length - 1) - 1;
    }

    int getMaximumMonthLength() {
        return this.maxMonthLength;
    }

    int getMinimumMonthLength() {
        return this.minMonthLength;
    }

    int getMaximumDayOfYear() {
        return this.maxYearLength;
    }

    int getSmallestMaximumDayOfYear() {
        return this.minYearLength;
    }

    private int epochDayToEpochMonth(int epochDay) {
        int ndx = Arrays.binarySearch(this.hijrahEpochMonthStartDays, epochDay);
        if (ndx < 0) {
            return (-ndx) - 2;
        }
        return ndx;
    }

    private int epochMonthToYear(int epochMonth) {
        return (this.hijrahStartEpochMonth + epochMonth) / 12;
    }

    private int yearToEpochMonth(int year) {
        return (year * 12) - this.hijrahStartEpochMonth;
    }

    private int epochMonthToMonth(int epochMonth) {
        return (this.hijrahStartEpochMonth + epochMonth) % 12;
    }

    private int epochMonthToEpochDay(int epochMonth) {
        return this.hijrahEpochMonthStartDays[epochMonth];
    }

    private int yearMonthToDayOfYear(int prolepticYear, int month) {
        int epochMonthFirst = yearToEpochMonth(prolepticYear);
        return epochMonthToEpochDay(epochMonthFirst + month) - epochMonthToEpochDay(epochMonthFirst);
    }

    private int epochMonthLength(int epochMonth) {
        return this.hijrahEpochMonthStartDays[epochMonth + 1] - this.hijrahEpochMonthStartDays[epochMonth];
    }

    private void loadCalendarData() {
        try {
            Map<Integer, int[]> years = new HashMap<>();
            int[][] monthLengths = hijrahUmalquraMonthLengths();
            int maxYear = (monthLengths.length + 1300) - 1;
            int isoStart = (int) LocalDate.of(1882, 11, 12).toEpochDay();
            for (int year = 1300; year <= maxYear; year++) {
                int[] numbers = monthLengths[year - 1300];
                if (numbers.length != 12) {
                    throw new IllegalArgumentException("wrong number of months on line: " + Arrays.toString(numbers) + "; count: " + numbers.length);
                }
                years.put(Integer.valueOf(year), numbers);
            }
            if (!getId().equals("Hijrah-umalqura")) {
                throw new IllegalArgumentException("Configuration is for a different calendar: Hijrah-umalqura");
            }
            if (!getCalendarType().equals("islamic-umalqura")) {
                throw new IllegalArgumentException("Configuration is for a different calendar type: islamic-umalqura");
            }
            if ("1.8.0_1".isEmpty()) {
                throw new IllegalArgumentException("Configuration does not contain a version");
            }
            if (isoStart != 0) {
                this.hijrahStartEpochMonth = 15600;
                this.minEpochDay = isoStart;
                this.hijrahEpochMonthStartDays = createEpochMonths(this.minEpochDay, 1300, maxYear, years);
                this.maxEpochDay = this.hijrahEpochMonthStartDays[this.hijrahEpochMonthStartDays.length - 1];
                for (int year2 = 1300; year2 < maxYear; year2++) {
                    int length = getYearLength(year2);
                    this.minYearLength = Math.min(this.minYearLength, length);
                    this.maxYearLength = Math.max(this.maxYearLength, length);
                }
                return;
            }
            throw new IllegalArgumentException("Configuration does not contain a ISO start date");
        } catch (Exception ex) {
            throw new DateTimeException("Unable to initialize HijrahCalendar: " + this.typeId, ex);
        }
    }

    private int[] createEpochMonths(int epochDay, int minYear, int maxYear, Map<Integer, int[]> years) {
        int numMonths = (((maxYear - minYear) + 1) * 12) + 1;
        int epochMonth = 0;
        int[] epochMonths = new int[numMonths];
        this.minMonthLength = Integer.MAX_VALUE;
        this.maxMonthLength = Integer.MIN_VALUE;
        for (int year = minYear; year <= maxYear; year++) {
            int[] months = years.get(Integer.valueOf(year));
            int month = 0;
            while (month < 12) {
                int length = months[month];
                int epochMonth2 = epochMonth + 1;
                epochMonths[epochMonth] = epochDay;
                if (length < 29 || length > 32) {
                    throw new IllegalArgumentException("Invalid month length in year: " + minYear);
                }
                epochDay += length;
                this.minMonthLength = Math.min(this.minMonthLength, length);
                this.maxMonthLength = Math.max(this.maxMonthLength, length);
                month++;
                epochMonth = epochMonth2;
            }
        }
        int epochMonth3 = epochMonth + 1;
        epochMonths[epochMonth] = epochDay;
        if (epochMonth3 != epochMonths.length) {
            throw new IllegalStateException("Did not fill epochMonths exactly: ndx = " + epochMonth3 + " should be " + epochMonths.length);
        }
        return epochMonths;
    }

    private static int[][] hijrahUmalquraMonthLengths() {
        return new int[][]{new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29}, new int[]{30, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 29}, new int[]{30, 30, 30, 29, 30, 30, 29, 29, 30, 29, 29, 30}, new int[]{29, 30, 30, 29, 30, 30, 29, 30, 29, 30, 29, 29}, new int[]{29, 30, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29}, new int[]{29, 29, 30, 30, 29, 30, 30, 29, 30, 30, 29, 29}, new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 30, 29, 30}, new int[]{29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30}, new int[]{29, 30, 30, 29, 30, 29, 30, 29, 30, 29, 29, 30}, new int[]{29, 30, 30, 30, 30, 29, 29, 30, 29, 29, 30, 29}, new int[]{30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 29, 30}, new int[]{29, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 29}, new int[]{30, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29}, new int[]{29, 30, 29, 30, 29, 30, 29, 30, 30, 30, 29, 29}, new int[]{30, 30, 29, 30, 29, 29, 30, 29, 30, 30, 29, 30}, new int[]{29, 30, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30}, new int[]{29, 30, 30, 30, 29, 30, 29, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 30, 29, 30, 29, 30, 29, 30, 29, 29}, new int[]{30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30, 29}, new int[]{29, 30, 29, 30, 30, 29, 30, 29, 30, 30, 29, 30}, new int[]{29, 30, 29, 29, 30, 29, 30, 29, 30, 30, 30, 29}, new int[]{30, 29, 30, 29, 29, 30, 29, 29, 30, 30, 30, 30}, new int[]{29, 30, 29, 30, 29, 29, 29, 30, 29, 30, 30, 30}, new int[]{29, 30, 30, 29, 30, 29, 29, 29, 30, 29, 30, 30}, new int[]{29, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30}, new int[]{30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 29, 30}, new int[]{29, 29, 30, 29, 30, 30, 29, 30, 29, 30, 30, 29}, new int[]{30, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30}, new int[]{29, 30, 29, 29, 30, 29, 29, 30, 30, 30, 29, 30}, new int[]{30, 29, 30, 29, 29, 30, 29, 29, 30, 30, 29, 30}, new int[]{30, 30, 29, 30, 29, 29, 30, 29, 29, 30, 30, 29}, new int[]{30, 30, 29, 30, 30, 29, 29, 30, 29, 30, 29, 30}, new int[]{29, 30, 29, 30, 30, 29, 30, 29, 30, 30, 29, 29}, new int[]{30, 29, 29, 30, 30, 29, 30, 30, 29, 30, 30, 29}, new int[]{29, 29, 30, 29, 30, 29, 30, 30, 30, 29, 30, 29}, new int[]{30, 29, 30, 29, 29, 30, 29, 30, 30, 29, 30, 30}, new int[]{29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30}, new int[]{30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30}, new int[]{29, 30, 30, 29, 30, 30, 29, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 29, 30, 30, 30, 29, 30, 29, 29, 30}, new int[]{29, 29, 30, 29, 30, 30, 30, 30, 29, 30, 29, 29}, new int[]{30, 29, 29, 30, 29, 30, 30, 30, 29, 30, 30, 29}, new int[]{29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30, 29}, new int[]{30, 29, 29, 30, 29, 30, 29, 30, 29, 30, 30, 29}, new int[]{30, 29, 30, 29, 30, 30, 29, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 30, 30, 29, 30, 29, 29, 30, 29, 29}, new int[]{30, 29, 30, 30, 30, 30, 29, 30, 29, 29, 30, 29}, new int[]{29, 30, 29, 30, 30, 30, 29, 30, 30, 29, 29, 30}, new int[]{29, 29, 30, 29, 30, 30, 29, 30, 30, 30, 29, 29}, new int[]{30, 29, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30}, new int[]{29, 30, 29, 30, 29, 30, 29, 29, 30, 30, 29, 30}, new int[]{30, 29, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30}, new int[]{30, 29, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29}, new int[]{30, 29, 30, 30, 30, 29, 30, 29, 29, 30, 29, 30}, new int[]{29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 29}, new int[]{30, 29, 29, 30, 30, 29, 30, 30, 29, 30, 30, 29}, new int[]{29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30, 30}, new int[]{29, 29, 30, 29, 30, 29, 29, 30, 29, 30, 30, 30}, new int[]{29, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 30}, new int[]{29, 30, 30, 29, 30, 29, 30, 29, 29, 29, 30, 30}, new int[]{29, 30, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29}, new int[]{30, 29, 30, 30, 29, 30, 30, 29, 29, 30, 29, 30}, new int[]{29, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30}, new int[]{29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30}, new int[]{30, 30, 29, 29, 30, 29, 29, 30, 29, 30, 29, 30}, new int[]{30, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29}, new int[]{30, 30, 29, 30, 30, 29, 30, 29, 29, 30, 29, 30}, new int[]{29, 30, 29, 30, 30, 30, 29, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 30, 29}, new int[]{30, 29, 29, 30, 29, 30, 29, 30, 29, 30, 30, 30}, new int[]{29, 30, 29, 29, 30, 29, 30, 29, 30, 29, 30, 30}, new int[]{30, 29, 29, 30, 29, 30, 29, 29, 30, 29, 30, 30}, new int[]{30, 29, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30}, new int[]{30, 29, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29}, new int[]{30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30, 29}, new int[]{29, 30, 29, 30, 29, 30, 30, 30, 29, 30, 29, 30}, new int[]{29, 29, 30, 29, 29, 30, 30, 30, 29, 30, 30, 29}, new int[]{30, 29, 29, 29, 30, 29, 30, 30, 29, 30, 30, 30}, new int[]{29, 30, 29, 29, 29, 30, 29, 30, 30, 29, 30, 30}, new int[]{29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30}, new int[]{29, 30, 29, 30, 30, 29, 30, 29, 30, 29, 29, 30}, new int[]{29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 29}, new int[]{30, 29, 29, 30, 30, 30, 29, 30, 30, 29, 30, 29}, new int[]{29, 30, 29, 29, 30, 30, 29, 30, 30, 30, 29, 30}, new int[]{29, 29, 30, 29, 29, 30, 30, 29, 30, 30, 30, 29}, new int[]{30, 29, 29, 30, 29, 29, 30, 30, 29, 30, 30, 29}, new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29}, new int[]{30, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 29}, new int[]{30, 30, 29, 30, 30, 29, 30, 30, 29, 29, 30, 29}, new int[]{29, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 30}, new int[]{29, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29}, new int[]{30, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30}, new int[]{29, 30, 29, 29, 30, 29, 30, 29, 30, 29, 30, 30}, new int[]{30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 29, 30}, new int[]{30, 29, 30, 30, 29, 30, 29, 29, 30, 29, 29, 30}, new int[]{30, 29, 30, 30, 29, 30, 30, 29, 29, 30, 29, 29}, new int[]{30, 29, 30, 30, 29, 30, 30, 30, 29, 29, 29, 30}, new int[]{29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 29}, new int[]{30, 29, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30}, new int[]{30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 29, 30}, new int[]{30, 30, 29, 30, 29, 29, 30, 29, 29, 30, 29, 30}, new int[]{30, 30, 30, 29, 30, 29, 29, 30, 29, 29, 30, 29}, new int[]{30, 30, 30, 29, 30, 30, 29, 29, 30, 29, 29, 30}, new int[]{29, 30, 30, 29, 30, 30, 29, 30, 29, 30, 29, 29}, new int[]{30, 29, 30, 29, 30, 30, 30, 29, 30, 29, 29, 30}, new int[]{30, 29, 29, 30, 29, 30, 30, 29, 30, 29, 30, 30}, new int[]{29, 30, 29, 29, 30, 29, 30, 29, 30, 29, 30, 30}, new int[]{30, 29, 30, 29, 30, 29, 29, 30, 29, 29, 30, 30}, new int[]{30, 30, 29, 30, 29, 30, 29, 29, 30, 29, 29, 30}, new int[]{30, 30, 29, 30, 30, 29, 30, 29, 29, 30, 29, 29}, new int[]{30, 30, 29, 30, 30, 29, 30, 30, 29, 29, 30, 29}, new int[]{30, 29, 30, 29, 30, 29, 30, 30, 30, 29, 29, 30}, new int[]{29, 30, 29, 29, 30, 29, 30, 30, 30, 29, 30, 29}, new int[]{30, 29, 30, 29, 29, 30, 29, 30, 30, 29, 30, 30}, new int[]{29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30}, new int[]{30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30}, new int[]{30, 29, 30, 30, 29, 29, 30, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 30, 29, 30, 29, 30, 29, 30, 29, 30}, new int[]{29, 30, 29, 30, 29, 30, 29, 30, 30, 30, 29, 29}, new int[]{29, 30, 29, 29, 30, 29, 30, 30, 30, 30, 29, 30}, new int[]{29, 29, 30, 29, 29, 29, 30, 30, 30, 30, 29, 30}, new int[]{30, 29, 29, 30, 29, 29, 29, 30, 30, 30, 29, 30}, new int[]{30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30}, new int[]{30, 29, 30, 30, 29, 30, 29, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 30, 29, 30, 29, 30, 30, 29, 30, 29}, new int[]{29, 30, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30}, new int[]{29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30, 29}, new int[]{30, 29, 29, 30, 29, 29, 30, 30, 30, 29, 30, 30}, new int[]{29, 30, 29, 29, 30, 29, 29, 30, 30, 29, 30, 30}, new int[]{29, 30, 30, 29, 29, 30, 29, 30, 29, 30, 29, 30}, new int[]{29, 30, 30, 29, 30, 29, 30, 29, 30, 29, 29, 30}, new int[]{29, 30, 30, 30, 29, 30, 29, 30, 29, 30, 29, 29}, new int[]{30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30, 29}, new int[]{29, 30, 29, 30, 29, 30, 30, 29, 30, 30, 29, 29}, new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 30, 29, 30}, new int[]{29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30}, new int[]{30, 29, 30, 30, 29, 29, 30, 29, 30, 29, 29, 30}, new int[]{30, 29, 30, 30, 30, 29, 29, 30, 29, 29, 30, 29}, new int[]{30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 29, 30}, new int[]{29, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 29}, new int[]{30, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29}, new int[]{29, 30, 29, 30, 29, 30, 29, 30, 30, 29, 30, 29}, new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30}, new int[]{29, 30, 29, 30, 30, 29, 29, 30, 29, 30, 29, 30}, new int[]{29, 30, 30, 30, 29, 30, 29, 29, 30, 29, 29, 30}, new int[]{29, 30, 30, 30, 29, 30, 30, 29, 29, 30, 29, 29}, new int[]{30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 30, 29}, new int[]{29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30}, new int[]{29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30, 29}, new int[]{30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30, 29}, new int[]{30, 30, 30, 29, 29, 30, 29, 29, 30, 30, 29, 30}, new int[]{30, 29, 30, 30, 29, 29, 30, 29, 29, 30, 29, 30}, new int[]{30, 29, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29}, new int[]{30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30, 29}, new int[]{29, 30, 29, 30, 30, 29, 30, 29, 30, 30, 29, 30}, new int[]{29, 29, 30, 29, 30, 29, 30, 29, 30, 30, 30, 29}, new int[]{30, 29, 29, 30, 29, 29, 30, 29, 30, 30, 30, 30}, new int[]{29, 30, 29, 29, 30, 29, 29, 30, 29, 30, 30, 30}, new int[]{29, 30, 30, 29, 29, 30, 29, 29, 30, 29, 30, 30}, new int[]{29, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30}, new int[]{29, 30, 30, 29, 30, 29, 30, 29, 30, 30, 29, 29}, new int[]{30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 30, 29}, new int[]{29, 30, 29, 30, 29, 30, 29, 30, 30, 30, 29, 30}, new int[]{29, 30, 29, 29, 30, 29, 29, 30, 30, 30, 29, 30}, new int[]{30, 29, 30, 29, 29, 30, 29, 29, 30, 30, 29, 30}, new int[]{30, 30, 29, 30, 29, 29, 29, 30, 29, 30, 30, 29}, new int[]{30, 30, 29, 30, 30, 29, 29, 30, 29, 30, 29, 30}, new int[]{29, 30, 29, 30, 30, 29, 30, 29, 30, 29, 30, 29}, new int[]{29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30}, new int[]{29, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29}, new int[]{30, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30}, new int[]{29, 30, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30}, new int[]{29, 30, 29, 30, 30, 29, 29, 30, 29, 30, 29, 30}, new int[]{29, 30, 30, 29, 30, 30, 29, 29, 30, 29, 30, 29}, new int[]{29, 30, 30, 29, 30, 30, 30, 29, 29, 30, 29, 29}, new int[]{30, 29, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29}, new int[]{29, 30, 29, 29, 30, 30, 30, 30, 29, 30, 29, 30}, new int[]{29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30, 29}, new int[]{30, 29, 29, 30, 29, 30, 29, 30, 29, 30, 30, 29}, new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 30, 29, 30, 29, 30, 29, 30, 29, 29}, new int[]{30, 29, 30, 30, 30, 30, 29, 30, 29, 29, 30, 29}, new int[]{29, 30, 29, 30, 30, 30, 29, 30, 30, 29, 29, 30}, new int[]{29, 29, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29}, new int[]{30, 29, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30}, new int[]{29, 30, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30}, new int[]{30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30}, new int[]{30, 29, 30, 30, 29, 30, 29, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 30, 30, 29, 30, 29, 29, 30, 29, 30}, new int[]{29, 30, 29, 30, 30, 29, 30, 30, 29, 29, 30, 29}, new int[]{30, 29, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30}, new int[]{29, 30, 29, 29, 30, 30, 29, 30, 29, 30, 30, 29}, new int[]{30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 30, 30}, new int[]{29, 30, 29, 30, 29, 30, 29, 29, 29, 30, 30, 30}, new int[]{29, 30, 30, 29, 30, 29, 29, 30, 29, 29, 30, 30}, new int[]{29, 30, 30, 30, 29, 30, 29, 29, 30, 29, 29, 30}, new int[]{30, 29, 30, 30, 29, 30, 29, 30, 29, 30, 29, 30}, new int[]{29, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 29, 29, 30, 30, 29, 30, 29, 30, 30}, new int[]{29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30}, new int[]{30, 29, 30, 29, 30, 29, 29, 29, 30, 29, 30, 30}, new int[]{30, 30, 29, 30, 29, 30, 29, 29, 29, 30, 30, 29}, new int[]{30, 30, 29, 30, 30, 29, 30, 29, 29, 29, 30, 30}, new int[]{29, 30, 29, 30, 30, 30, 29, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 30, 29}, new int[]{29, 30, 29, 29, 30, 30, 29, 30, 30, 29, 30, 30}, new int[]{29, 29, 30, 29, 29, 30, 30, 29, 30, 29, 30, 30}, new int[]{30, 29, 29, 30, 29, 30, 29, 29, 30, 29, 30, 30}, new int[]{30, 29, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30}, new int[]{30, 29, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29}, new int[]{30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 29, 30}, new int[]{29, 30, 29, 30, 29, 30, 30, 30, 29, 30, 29, 30}, new int[]{29, 29, 29, 30, 29, 30, 30, 30, 29, 30, 30, 29}, new int[]{30, 29, 29, 29, 30, 29, 30, 30, 29, 30, 30, 30}, new int[]{29, 29, 30, 29, 29, 30, 29, 30, 30, 29, 30, 30}, new int[]{29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30}, new int[]{29, 30, 29, 30, 29, 30, 30, 29, 29, 30, 29, 30}, new int[]{29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 29}, new int[]{30, 29, 29, 30, 30, 30, 29, 30, 30, 29, 30, 29}, new int[]{29, 30, 29, 29, 30, 30, 30, 29, 30, 30, 29, 30}, new int[]{29, 29, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30}, new int[]{30, 29, 29, 29, 30, 29, 30, 30, 29, 30, 30, 29}, new int[]{30, 29, 30, 29, 30, 29, 30, 29, 29, 30, 30, 29}, new int[]{30, 30, 29, 30, 29, 30, 29, 30, 29, 29, 30, 29}, new int[]{30, 30, 29, 30, 30, 29, 30, 29, 30, 29, 29, 30}, new int[]{29, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 29}, new int[]{30, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29}, new int[]{30, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30}, new int[]{29, 30, 29, 29, 30, 29, 30, 29, 30, 29, 30, 30}, new int[]{29, 30, 30, 29, 29, 30, 29, 30, 29, 29, 30, 30}, new int[]{29, 30, 30, 30, 29, 29, 30, 29, 30, 29, 29, 30}, new int[]{29, 30, 30, 30, 29, 30, 30, 29, 29, 29, 30, 29}, new int[]{30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 29, 30}, new int[]{29, 30, 29, 30, 30, 29, 30, 30, 29, 29, 30, 29}, new int[]{30, 29, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30}, new int[]{29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30}, new int[]{30, 29, 30, 30, 29, 29, 30, 29, 29, 30, 29, 30}, new int[]{30, 30, 29, 30, 30, 29, 29, 30, 29, 29, 30, 29}, new int[]{30, 30, 30, 29, 30, 30, 29, 29, 30, 29, 29, 30}, new int[]{29, 30, 30, 29, 30, 30, 29, 30, 29, 29, 30, 29}, new int[]{30, 29, 30, 29, 30, 30, 30, 29, 30, 29, 29, 30}, new int[]{29, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 30}, new int[]{29, 30, 29, 29, 30, 29, 30, 29, 30, 29, 30, 30}, new int[]{30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 29, 30}, new int[]{30, 30, 29, 30, 29, 29, 30, 29, 30, 29, 29, 30}, new int[]{30, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 29}, new int[]{30, 30, 29, 30, 30, 29, 30, 29, 30, 29, 30, 29}, new int[]{30, 29, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30}, new int[]{29, 30, 29, 29, 30, 29, 30, 30, 30, 29, 30, 29}, new int[]{30, 29, 30, 29, 29, 29, 30, 30, 30, 29, 30, 30}, new int[]{29, 30, 29, 29, 30, 29, 29, 30, 30, 29, 30, 30}, new int[]{30, 29, 30, 29, 29, 30, 29, 29, 30, 30, 29, 30}, new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 29, 30}, new int[]{29, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29}, new int[]{30, 29, 29, 30, 29, 30, 29, 30, 30, 30, 29, 30}, new int[]{29, 30, 29, 29, 29, 30, 29, 30, 30, 30, 30, 29}, new int[]{30, 29, 30, 29, 29, 29, 30, 29, 30, 30, 30, 29}, new int[]{30, 30, 29, 29, 30, 29, 29, 30, 30, 29, 30, 29}, new int[]{30, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30}, new int[]{29, 30, 30, 29, 30, 29, 30, 30, 29, 29, 30, 29}, new int[]{29, 30, 30, 29, 30, 29, 30, 30, 30, 29, 29, 30}, new int[]{29, 30, 29, 29, 30, 29, 30, 30, 30, 29, 30, 29}, new int[]{30, 29, 30, 29, 29, 30, 29, 30, 30, 30, 29, 30}, new int[]{29, 30, 29, 30, 29, 29, 30, 29, 30, 30, 29, 30}, new int[]{30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30}, new int[]{30, 29, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29}, new int[]{30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 29, 29}, new int[]{30, 29, 30, 30, 30, 29, 30, 30, 29, 30, 29, 29}, new int[]{29, 30, 29, 30, 30, 29, 30, 30, 30, 29, 29, 30}, new int[]{29, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29}, new int[]{30, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 29}, new int[]{30, 29, 30, 30, 29, 30, 29, 29, 30, 29, 30, 29}, new int[]{30, 30, 29, 30, 30, 29, 30, 29, 29, 30, 29, 29}, new int[]{30, 30, 30, 29, 30, 30, 29, 30, 29, 29, 29, 30}, new int[]{29, 30, 30, 29, 30, 30, 30, 29, 30, 29, 29, 29}, new int[]{30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30, 29}, new int[]{29, 30, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30}, new int[]{29, 30, 29, 30, 29, 29, 30, 30, 29, 30, 29, 30}, new int[]{29, 30, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30}, new int[]{30, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29}, new int[]{30, 30, 29, 30, 30, 29, 30, 29, 30, 29, 29, 29}, new int[]{30, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 29}, new int[]{29, 30, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29}, new int[]{29, 30, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30}, new int[]{29, 29, 30, 29, 30, 29, 29, 30, 30, 30, 29, 30}, new int[]{29, 30, 30, 29, 29, 29, 30, 29, 30, 29, 30, 30}, new int[]{30, 29, 30, 30, 29, 29, 29, 30, 29, 30, 29, 30}, new int[]{30, 29, 30, 30, 29, 30, 29, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 30, 30, 29, 29, 30, 29, 30, 29, 30}, new int[]{29, 30, 29, 30, 30, 29, 30, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 30, 30, 29}, new int[]{30, 29, 29, 30, 29, 29, 30, 29, 30, 30, 30, 29}, new int[]{30, 30, 29, 29, 30, 29, 29, 29, 30, 30, 30, 30}, new int[]{29, 30, 29, 30, 29, 29, 30, 29, 29, 30, 30, 30}, new int[]{29, 30, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30}, new int[]{29, 30, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29}, new int[]{30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 30, 29}, new int[]{29, 30, 29, 30, 29, 30, 29, 30, 30, 30, 29, 30}, new int[]{29, 29, 30, 29, 30, 29, 29, 30, 30, 30, 29, 30}};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.time.chrono.AbstractChronology
    public Object writeReplace() {
        return super.writeReplace();
    }

    private void readObject(ObjectInputStream s) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}