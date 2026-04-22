package j$.time.chrono;

import j$.time.DateTimeException;
import j$.time.LocalDate;
import j$.time.Year;
import j$.time.chrono.Era;
import j$.time.format.DateTimeFormatterBuilder;
import j$.time.format.TextStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.ValueRange;
import j$.util.Objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;

public final class JapaneseEra implements Era, Serializable {
    static final int ERA_OFFSET = 2;
    private static final long serialVersionUID = 1466499369062886794L;
    private final transient String abbreviation;
    private final transient int eraValue;
    private final transient String name;
    private final transient LocalDate since;
    public static final JapaneseEra MEIJI = new JapaneseEra(-1, LocalDate.of(1868, 1, 1), "Meiji", "M");
    public static final JapaneseEra REIWA = new JapaneseEra(3, LocalDate.of(2019, 5, 1), "Reiwa", "R");
    private static final int N_ERA_CONSTANTS = REIWA.getValue() + 2;
    public static final JapaneseEra TAISHO = new JapaneseEra(N_ERA_CONSTANTS, LocalDate.of(1912, 7, 30), "Taisho", "T");
    public static final JapaneseEra SHOWA = new JapaneseEra(1, LocalDate.of(1926, 12, 25), "Showa", "S");
    public static final JapaneseEra HEISEI = new JapaneseEra(2, LocalDate.of(1989, 1, 8), "Heisei", "H");
    private static final JapaneseEra[] KNOWN_ERAS = new JapaneseEra[N_ERA_CONSTANTS];

    @Override // j$.time.chrono.Era, j$.time.temporal.TemporalAdjuster
    public /* synthetic */ Temporal adjustInto(Temporal temporal) {
        Temporal with;
        with = temporal.with(ChronoField.ERA, getValue());
        return with;
    }

    @Override // j$.time.chrono.Era, j$.time.temporal.TemporalAccessor
    public /* synthetic */ int get(TemporalField temporalField) {
        return Era.CC.$default$get(this, temporalField);
    }

    @Override // j$.time.chrono.Era, j$.time.temporal.TemporalAccessor
    public /* synthetic */ long getLong(TemporalField temporalField) {
        return Era.CC.$default$getLong(this, temporalField);
    }

    @Override // j$.time.chrono.Era, j$.time.temporal.TemporalAccessor
    public /* synthetic */ boolean isSupported(TemporalField temporalField) {
        return Era.CC.$default$isSupported(this, temporalField);
    }

    @Override // j$.time.chrono.Era, j$.time.temporal.TemporalAccessor
    public /* synthetic */ Object query(TemporalQuery temporalQuery) {
        return Era.CC.$default$query(this, temporalQuery);
    }

    static {
        KNOWN_ERAS[N_ERA_CONSTANTS] = MEIJI;
        KNOWN_ERAS[1] = TAISHO;
        KNOWN_ERAS[2] = SHOWA;
        KNOWN_ERAS[3] = HEISEI;
        KNOWN_ERAS[4] = REIWA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JapaneseEra getCurrentEra() {
        return KNOWN_ERAS[KNOWN_ERAS.length - 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long shortestYearsOfEra() {
        int min = (Year.MAX_VALUE - getCurrentEra().since.getYear()) + 1;
        int lastStartYear = KNOWN_ERAS[N_ERA_CONSTANTS].since.getYear();
        for (int i = 1; i < KNOWN_ERAS.length; i++) {
            JapaneseEra era = KNOWN_ERAS[i];
            int lastYearsOfEra = (era.since.getYear() - lastStartYear) + 1;
            min = Math.min(min, lastYearsOfEra);
            lastStartYear = era.since.getYear();
        }
        return min;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long shortestDaysOfYear() {
        long min = ChronoField.DAY_OF_YEAR.range().getSmallestMaximum();
        JapaneseEra[] japaneseEraArr = KNOWN_ERAS;
        int length = japaneseEraArr.length;
        for (int i = N_ERA_CONSTANTS; i < length; i++) {
            JapaneseEra era = japaneseEraArr[i];
            min = Math.min(min, (era.since.lengthOfYear() - era.since.getDayOfYear()) + 1);
            if (era.next() != null) {
                min = Math.min(min, era.next().since.getDayOfYear() - 1);
            }
        }
        return min;
    }

    private JapaneseEra(int eraValue, LocalDate since, String name, String abbreviation) {
        this.eraValue = eraValue;
        this.since = since;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalDate getSince() {
        return this.since;
    }

    public static JapaneseEra of(int japaneseEra) {
        int i = ordinal(japaneseEra);
        if (i < 0 || i >= KNOWN_ERAS.length) {
            throw new DateTimeException("Invalid era: " + japaneseEra);
        }
        return KNOWN_ERAS[i];
    }

    public static JapaneseEra valueOf(String japaneseEra) {
        Objects.requireNonNull(japaneseEra, "japaneseEra");
        JapaneseEra[] japaneseEraArr = KNOWN_ERAS;
        int length = japaneseEraArr.length;
        for (int i = N_ERA_CONSTANTS; i < length; i++) {
            JapaneseEra era = japaneseEraArr[i];
            if (era.getName().equals(japaneseEra)) {
                return era;
            }
        }
        throw new IllegalArgumentException("japaneseEra is invalid");
    }

    public static JapaneseEra[] values() {
        return (JapaneseEra[]) Arrays.copyOf(KNOWN_ERAS, KNOWN_ERAS.length);
    }

    @Override // j$.time.chrono.Era
    public String getDisplayName(TextStyle style, Locale locale) {
        if (getValue() <= N_ERA_CONSTANTS - 2) {
            return new DateTimeFormatterBuilder().appendText(ChronoField.ERA, style).toFormatter(locale).withChronology(JapaneseChronology.INSTANCE).format(this == MEIJI ? JapaneseDate.MEIJI_6_ISODATE : this.since);
        }
        Objects.requireNonNull(locale, "locale");
        return style.asNormal() == TextStyle.NARROW ? getAbbreviation() : getName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JapaneseEra from(LocalDate date) {
        if (date.isBefore(JapaneseDate.MEIJI_6_ISODATE)) {
            throw new DateTimeException("JapaneseDate before Meiji 6 are not supported");
        }
        for (int i = KNOWN_ERAS.length - 1; i >= 0; i--) {
            JapaneseEra era = KNOWN_ERAS[i];
            if (date.compareTo((ChronoLocalDate) era.since) >= 0) {
                return era;
            }
        }
        return null;
    }

    private static int ordinal(int eraValue) {
        return (eraValue + 2) - 1;
    }

    @Override // j$.time.chrono.Era
    public int getValue() {
        return this.eraValue;
    }

    @Override // j$.time.chrono.Era, j$.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField field) {
        ValueRange $default$range;
        if (field != ChronoField.ERA) {
            $default$range = TemporalAccessor.CC.$default$range(this, field);
            return $default$range;
        }
        return JapaneseChronology.INSTANCE.range(ChronoField.ERA);
    }

    String getAbbreviation() {
        return this.abbreviation;
    }

    String getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JapaneseEra next() {
        if (this == getCurrentEra()) {
            return null;
        }
        return of(this.eraValue + 1);
    }

    public String toString() {
        return getName();
    }

    private void readObject(ObjectInputStream s) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput out) {
        out.writeByte(getValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JapaneseEra readExternal(DataInput in) {
        byte eraValue = in.readByte();
        return of(eraValue);
    }
}