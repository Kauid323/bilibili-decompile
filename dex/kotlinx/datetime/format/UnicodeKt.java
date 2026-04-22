package kotlinx.datetime.format;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.UnicodeFormat;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: Unicode.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007\u001a\u0018\u0010\u0011\u001a\u00020\t*\u00020\u00122\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002\u001a\f\u0010\u0013\u001a\u00020\t*\u00020\u0012H\u0002\u001a\u0014\u0010\u0014\u001a\u00020\t*\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0007H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"nonPlainCharacters", "", "", "unicodeDirective", "Lkotlinx/datetime/format/UnicodeFormat;", "char", "formatLength", "", "unsupportedDirective", "", "fieldName", "", "recommendation", "byUnicodePattern", "", "Lkotlinx/datetime/format/DateTimeFormatBuilder;", "pattern", "localizedDirective", "Lkotlinx/datetime/format/UnicodeFormat$Directive;", "unknownLength", "unsupportedPadding", "digits", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UnicodeKt {
    private static final List<Character> nonPlainCharacters = CollectionsKt.plus((Collection) CollectionsKt.plus((Iterable) new CharRange('a', 'z'), (Iterable) new CharRange('A', 'Z')), (Iterable) CollectionsKt.listOf((Object[]) new Character[]{Character.valueOf(AbstractJsonLexerKt.BEGIN_LIST), Character.valueOf(AbstractJsonLexerKt.END_LIST), '\''}));

    public static final void byUnicodePattern(DateTimeFormatBuilder $this$byUnicodePattern, String pattern) {
        Intrinsics.checkNotNullParameter($this$byUnicodePattern, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        UnicodeFormat directives = UnicodeFormat.Companion.parse(pattern);
        byUnicodePattern$rec($this$byUnicodePattern, directives);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void byUnicodePattern$rec(DateTimeFormatBuilder builder, final UnicodeFormat format) {
        if (!(format instanceof UnicodeFormat.StringLiteral)) {
            if (!(format instanceof UnicodeFormat.Sequence)) {
                if (!(format instanceof UnicodeFormat.OptionalGroup)) {
                    if (format instanceof UnicodeFormat.Directive) {
                        UnicodeFormat.Directive directive = (UnicodeFormat.Directive) format;
                        if (directive instanceof UnicodeFormat.Directive.TimeBased) {
                            if (!(builder instanceof DateTimeFormatBuilder.WithTime)) {
                                throw new IllegalArgumentException(("A time-based directive " + format + " was used in a format builder that doesn't support time components").toString());
                            }
                            ((UnicodeFormat.Directive.TimeBased) format).mo1487addToFormat((DateTimeFormatBuilder.WithTime) builder);
                            return;
                        } else if (directive instanceof UnicodeFormat.Directive.DateBased) {
                            if (!(builder instanceof DateTimeFormatBuilder.WithDate)) {
                                throw new IllegalArgumentException(("A date-based directive " + format + " was used in a format builder that doesn't support date components").toString());
                            }
                            ((UnicodeFormat.Directive.DateBased) format).mo1485addToFormat((DateTimeFormatBuilder.WithDate) builder);
                            return;
                        } else if (directive instanceof UnicodeFormat.Directive.ZoneBased) {
                            if (!(builder instanceof DateTimeFormatBuilder.WithDateTimeComponents)) {
                                throw new IllegalArgumentException(("A time-zone-based directive " + format + " was used in a format builder that doesn't support time-zone components").toString());
                            }
                            ((UnicodeFormat.Directive.ZoneBased) format).mo1488addToFormat((DateTimeFormatBuilder.WithDateTimeComponents) builder);
                            return;
                        } else if (directive instanceof UnicodeFormat.Directive.OffsetBased) {
                            if (!(builder instanceof DateTimeFormatBuilder.WithUtcOffset)) {
                                throw new IllegalArgumentException(("A UTC-offset-based directive " + format + " was used in a format builder that doesn't support UTC offset components").toString());
                            }
                            ((UnicodeFormat.Directive.OffsetBased) format).mo1486addToFormat((DateTimeFormatBuilder.WithUtcOffset) builder);
                            return;
                        } else if (directive instanceof UnknownUnicodeDirective) {
                            throw new IllegalArgumentException("The meaning of the directive '" + format + "' is unknown");
                        } else {
                            return;
                        }
                    }
                    return;
                }
                DateTimeFormatBuilderKt.alternativeParsing(builder, new Function1[]{new Function1<DateTimeFormatBuilder, Unit>() { // from class: kotlinx.datetime.format.UnicodeKt$byUnicodePattern$rec$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder dateTimeFormatBuilder) {
                        invoke2(dateTimeFormatBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                    }
                }}, new Function1<DateTimeFormatBuilder, Unit>() { // from class: kotlinx.datetime.format.UnicodeKt$byUnicodePattern$rec$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder dateTimeFormatBuilder) {
                        invoke2(dateTimeFormatBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        UnicodeKt.byUnicodePattern$rec(alternativeParsing, ((UnicodeFormat.OptionalGroup) UnicodeFormat.this).getFormat());
                    }
                });
                return;
            }
            Iterable $this$forEach$iv = ((UnicodeFormat.Sequence) format).getFormats();
            for (Object element$iv : $this$forEach$iv) {
                UnicodeFormat it = (UnicodeFormat) element$iv;
                byUnicodePattern$rec(builder, it);
            }
            return;
        }
        builder.chars(((UnicodeFormat.StringLiteral) format).getLiteral());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UnicodeFormat unicodeDirective(char c, int formatLength) {
        return c == 'G' ? new UnicodeFormat.Directive.DateBased.Era(formatLength) : c == 'y' ? new UnicodeFormat.Directive.DateBased.YearOfEra(formatLength) : c == 'Y' ? new UnicodeFormat.Directive.DateBased.WeekBasedYear(formatLength) : c == 'u' ? new UnicodeFormat.Directive.DateBased.Year(formatLength) : c == 'U' ? new UnicodeFormat.Directive.DateBased.CyclicYearName(formatLength) : c == 'r' ? new UnicodeFormat.Directive.DateBased.RelatedGregorianYear(formatLength) : c == 'Q' ? new UnicodeFormat.Directive.DateBased.QuarterOfYear(formatLength) : c == 'q' ? new UnicodeFormat.Directive.DateBased.StandaloneQuarterOfYear(formatLength) : c == 'M' ? new UnicodeFormat.Directive.DateBased.MonthOfYear(formatLength) : c == 'L' ? new UnicodeFormat.Directive.DateBased.StandaloneMonthOfYear(formatLength) : c == 'w' ? new UnicodeFormat.Directive.DateBased.WeekOfWeekBasedYear(formatLength) : c == 'W' ? new UnicodeFormat.Directive.DateBased.WeekOfMonth(formatLength) : c == 'd' ? new UnicodeFormat.Directive.DateBased.DayOfMonth(formatLength) : c == 'D' ? new UnicodeFormat.Directive.DateBased.DayOfYear(formatLength) : c == 'F' ? new UnicodeFormat.Directive.DateBased.DayOfWeekInMonth(formatLength) : c == 'g' ? new UnicodeFormat.Directive.DateBased.ModifiedJulianDay(formatLength) : c == 'E' ? new UnicodeFormat.Directive.DateBased.DayOfWeek(formatLength) : c == 'e' ? new UnicodeFormat.Directive.DateBased.LocalizedDayOfWeek(formatLength) : c == 'c' ? new UnicodeFormat.Directive.DateBased.StandaloneLocalizedDayOfWeek(formatLength) : c == 'a' ? new UnicodeFormat.Directive.TimeBased.AmPmMarker(formatLength) : c == 'h' ? new UnicodeFormat.Directive.TimeBased.AmPmHourOfDay(formatLength) : c == 'H' ? new UnicodeFormat.Directive.TimeBased.HourOfDay(formatLength) : c == 'm' ? new UnicodeFormat.Directive.TimeBased.MinuteOfHour(formatLength) : c == 's' ? new UnicodeFormat.Directive.TimeBased.WithSecondPrecision.SecondOfMinute(formatLength) : c == 'S' ? new UnicodeFormat.Directive.TimeBased.WithSubsecondPrecision.FractionOfSecond(formatLength) : c == 'A' ? new UnicodeFormat.Directive.TimeBased.WithSubsecondPrecision.MilliOfDay(formatLength) : c == 'n' ? new UnicodeFormat.Directive.TimeBased.WithSubsecondPrecision.NanoOfSecond(formatLength) : c == 'N' ? new UnicodeFormat.Directive.TimeBased.WithSubsecondPrecision.NanoOfDay(formatLength) : c == 'V' ? new UnicodeFormat.Directive.ZoneBased.TimeZoneId(formatLength) : c == 'v' ? new UnicodeFormat.Directive.ZoneBased.GenericTimeZoneName(formatLength) : c == 'z' ? new UnicodeFormat.Directive.ZoneBased.TimeZoneName(formatLength) : c == 'O' ? new UnicodeFormat.Directive.OffsetBased.LocalizedZoneOffset(formatLength) : c == 'X' ? new UnicodeFormat.Directive.OffsetBased.ZoneOffset1(formatLength) : c == 'x' ? new UnicodeFormat.Directive.OffsetBased.ZoneOffset2(formatLength) : c == 'Z' ? new UnicodeFormat.Directive.OffsetBased.ZoneOffset3(formatLength) : new UnknownUnicodeDirective(c, formatLength);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void unsupportedDirective$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return unsupportedDirective(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void unsupportedDirective(String fieldName, String recommendation) {
        throw new UnsupportedOperationException("kotlinx.datetime formatting does not support the " + fieldName + " field. " + (recommendation != null ? recommendation + ' ' : "") + "Please report your use case to https://github.com/Kotlin/kotlinx-datetime/issues");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void unknownLength(UnicodeFormat.Directive $this$unknownLength) {
        throw new IllegalArgumentException("Unknown length " + $this$unknownLength.getFormatLength() + " for the " + $this$unknownLength.getFormatLetter() + " directive");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void localizedDirective$default(UnicodeFormat.Directive directive, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return localizedDirective(directive, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void localizedDirective(UnicodeFormat.Directive $this$localizedDirective, String recommendation) {
        throw new IllegalArgumentException("The directive '" + $this$localizedDirective + "' is locale-dependent, but locales are not supported in Kotlin" + (recommendation != null ? ". " + recommendation : ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void unsupportedPadding(UnicodeFormat.Directive $this$unsupportedPadding, int digits) {
        throw new UnsupportedOperationException("Padding do " + digits + " digits is not supported for the " + $this$unsupportedPadding.getFormatLetter() + " directive");
    }
}