package kntr.base.localization.preview;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.localization.DateTimeFormatKt;
import kntr.base.localization.Locale;
import kntr.base.localization.Localization;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Clock;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.Instant;
import kotlinx.datetime.InstantJvmKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;
import kotlinx.datetime.format.DateTimeFormat;

/* compiled from: DateTimeFormatTest.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ0\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\fH\u0002J\b\u0010#\u001a\u00020\fH\u0002J\b\u0010$\u001a\u00020\fH\u0002J\u0013\u0010%\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lkntr/base/localization/preview/DateTimeFormatTest;", "", "<init>", "()V", "timeZone", "Lkotlinx/datetime/TimeZone;", "TAG", "", "totalTests", "", "passedTests", "testAll", "", "recordTestResult", "testName", "isPassed", "", "expected", "actual", "printTestSummary", "testRelativeDateTimeJustNowAllLanguages", "testRelativeDateTimeMinutesAllLanguages", "testRelativeDateTimeHoursAllLanguages", "testRelativeDateTimeYesterdayAllLanguages", "testRelativeDateTimeDaysAgoAllLanguages", "testRelativeDateTimeMonthDayAllLanguages", "testRelativeDateTimeYearMonthDayAllLanguages", "testRelativeDateTimeFutureTodayAllLanguages", "testRelativeDateTimeTomorrowAllLanguages", "testRelativeDateTimeFutureThisYearAllLanguages", "testRelativeDateTimeFutureCrossYearAllLanguages", "testAbsoluteDateTimeAllLanguages", "testImDateTimeTodayAllLanguages", "testImDateTimeYesterdayAllLanguages", "testImDateTimeHistoricalTimeAllLanguages", "testFromSecondsExtensionFunctions", "testEdgeCases", "equals", "other", "hashCode", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DateTimeFormatTest {
    private static final String TAG = "DateTimeFormatTest";
    private static int passedTests;
    private static int totalTests;
    public static final DateTimeFormatTest INSTANCE = new DateTimeFormatTest();
    private static final TimeZone timeZone = TimeZone.Companion.currentSystemDefault();
    public static final int $stable = 8;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateTimeFormatTest) {
            DateTimeFormatTest dateTimeFormatTest = (DateTimeFormatTest) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 1354627887;
    }

    public String toString() {
        return TAG;
    }

    private DateTimeFormatTest() {
    }

    public final void testAll() {
        totalTests = 0;
        passedTests = 0;
        testRelativeDateTimeJustNowAllLanguages();
        testRelativeDateTimeMinutesAllLanguages();
        testRelativeDateTimeHoursAllLanguages();
        testRelativeDateTimeYesterdayAllLanguages();
        testRelativeDateTimeDaysAgoAllLanguages();
        testRelativeDateTimeMonthDayAllLanguages();
        testRelativeDateTimeYearMonthDayAllLanguages();
        testRelativeDateTimeFutureTodayAllLanguages();
        testRelativeDateTimeTomorrowAllLanguages();
        testRelativeDateTimeFutureThisYearAllLanguages();
        testRelativeDateTimeFutureCrossYearAllLanguages();
        testAbsoluteDateTimeAllLanguages();
        testImDateTimeTodayAllLanguages();
        testImDateTimeYesterdayAllLanguages();
        testImDateTimeHistoricalTimeAllLanguages();
        testFromSecondsExtensionFunctions();
        testEdgeCases();
        printTestSummary();
    }

    static /* synthetic */ void recordTestResult$default(DateTimeFormatTest dateTimeFormatTest, String str, boolean z, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        dateTimeFormatTest.recordTestResult(str, z, str2, str3);
    }

    private final void recordTestResult(String testName, boolean isPassed, String expected, String actual) {
        totalTests++;
        if (!isPassed) {
            KLog_androidKt.getKLog().i(TAG, testName + " - ❌ expect: " + expected + ", got: " + actual);
            return;
        }
        passedTests++;
        KLog_androidKt.getKLog().i(TAG, testName + " - ✅");
    }

    private final void printTestSummary() {
        boolean allPassed = passedTests == totalTests;
        String status = allPassed ? "all passed" : "some failed";
        KLog_androidKt.getKLog().i(TAG, "\n=== Test Summary ===");
        KLog_androidKt.getKLog().i(TAG, "passed: " + passedTests + "/" + totalTests + ", " + status);
        if (!allPassed) {
            KLog_androidKt.getKLog().i(TAG, "Failed tests: " + (totalTests - passedTests));
        }
    }

    private final void testRelativeDateTimeJustNowAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(Locale.Companion.getSIMPLIFIED_CHINESE(), "刚刚"), TuplesKt.to(Locale.Companion.getTRADITIONAL_CHINESE(), "剛剛"), TuplesKt.to(Locale.Companion.getENGLISH(), "Just now"), TuplesKt.to(Locale.Companion.getJAPANESE(), "たった今"), TuplesKt.to(Locale.Companion.getTHAI(), "เมื่อกี้")});
        Duration.Companion companion = Duration.Companion;
        Duration.Companion companion2 = Duration.Companion;
        List<Instant> timeTests = CollectionsKt.listOf(new Instant[]{currentTime.minus-LRDsOJo(DurationKt.toDuration(30, DurationUnit.SECONDS)), currentTime.minus-LRDsOJo(DurationKt.toDuration(59, DurationUnit.SECONDS))});
        Map $this$forEach$iv = testCases;
        boolean z = false;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            Locale locale = (Locale) element$iv.getKey();
            String expected = (String) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            for (Instant targetTime : timeTests) {
                Instant currentTime2 = currentTime;
                String newResult = DateTimeFormatKt.formatRelativeDateTime(targetTime.toEpochMilliseconds());
                Map testCases2 = testCases;
                LegacyDateTimeFormat $this$testRelativeDateTimeJustNowAllLanguages_u24lambda_u240_u240_u240 = LegacyDateTimeFormat.INSTANCE;
                String legacyResult = $this$testRelativeDateTimeJustNowAllLanguages_u24lambda_u240_u240_u240.formatRelativeDateTime(targetTime.toEpochMilliseconds());
                INSTANCE.recordTestResult("JustNow format for " + locale, Intrinsics.areEqual(expected, newResult), expected, newResult);
                INSTANCE.recordTestResult("Legacy match for " + locale, Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
                testCases = testCases2;
                z = z;
                currentTime = currentTime2;
                timeTests = timeTests;
                $this$forEach$iv = $this$forEach$iv;
            }
        }
    }

    private final void testRelativeDateTimeMinutesAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        Locale simplified_chinese = Locale.Companion.getSIMPLIFIED_CHINESE();
        Duration.Companion companion = Duration.Companion;
        Duration.Companion companion2 = Duration.Companion;
        Duration.Companion companion3 = Duration.Companion;
        Duration.Companion companion4 = Duration.Companion;
        Pair[] pairArr = {TuplesKt.to(Duration.box-impl(DurationKt.toDuration(1, DurationUnit.MINUTES)), "1分钟前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(8, DurationUnit.MINUTES)), "8分钟前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(30, DurationUnit.MINUTES)), "30分钟前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(59, DurationUnit.MINUTES)), "59分钟前")};
        Locale traditional_chinese = Locale.Companion.getTRADITIONAL_CHINESE();
        Duration.Companion companion5 = Duration.Companion;
        Duration.Companion companion6 = Duration.Companion;
        Duration.Companion companion7 = Duration.Companion;
        Duration.Companion companion8 = Duration.Companion;
        Pair[] pairArr2 = {TuplesKt.to(Duration.box-impl(DurationKt.toDuration(1, DurationUnit.MINUTES)), "1分鐘前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(8, DurationUnit.MINUTES)), "8分鐘前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(30, DurationUnit.MINUTES)), "30分鐘前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(59, DurationUnit.MINUTES)), "59分鐘前")};
        Locale english = Locale.Companion.getENGLISH();
        Duration.Companion companion9 = Duration.Companion;
        Duration.Companion companion10 = Duration.Companion;
        Duration.Companion companion11 = Duration.Companion;
        Duration.Companion companion12 = Duration.Companion;
        Pair[] pairArr3 = {TuplesKt.to(Duration.box-impl(DurationKt.toDuration(1, DurationUnit.MINUTES)), "1 min ago"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(8, DurationUnit.MINUTES)), "8 mins ago"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(30, DurationUnit.MINUTES)), "30 mins ago"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(59, DurationUnit.MINUTES)), "59 mins ago")};
        Locale japanese = Locale.Companion.getJAPANESE();
        Duration.Companion companion13 = Duration.Companion;
        Duration.Companion companion14 = Duration.Companion;
        Duration.Companion companion15 = Duration.Companion;
        Duration.Companion companion16 = Duration.Companion;
        Pair[] pairArr4 = {TuplesKt.to(Duration.box-impl(DurationKt.toDuration(1, DurationUnit.MINUTES)), "1分前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(8, DurationUnit.MINUTES)), "8分前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(30, DurationUnit.MINUTES)), "30分前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(59, DurationUnit.MINUTES)), "59分前")};
        Locale thai = Locale.Companion.getTHAI();
        Duration.Companion companion17 = Duration.Companion;
        Duration.Companion companion18 = Duration.Companion;
        Duration.Companion companion19 = Duration.Companion;
        Duration.Companion companion20 = Duration.Companion;
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(simplified_chinese, MapsKt.mapOf(pairArr)), TuplesKt.to(traditional_chinese, MapsKt.mapOf(pairArr2)), TuplesKt.to(english, MapsKt.mapOf(pairArr3)), TuplesKt.to(japanese, MapsKt.mapOf(pairArr4)), TuplesKt.to(thai, MapsKt.mapOf(new Pair[]{TuplesKt.to(Duration.box-impl(DurationKt.toDuration(1, DurationUnit.MINUTES)), "1 นาทีก่อน"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(8, DurationUnit.MINUTES)), "8 นาทีก่อน"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(30, DurationUnit.MINUTES)), "30 นาทีก่อน"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(59, DurationUnit.MINUTES)), "59 นาทีก่อน")}))});
        Map $this$forEach$iv = testCases;
        boolean z = false;
        Iterator it = $this$forEach$iv.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry element$iv = (Map.Entry) it.next();
            boolean z2 = false;
            Locale locale = (Locale) element$iv.getKey();
            Map cases = (Map) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            for (Map.Entry element$iv2 : cases.entrySet()) {
                long duration = ((Duration) element$iv2.getKey()).unbox-impl();
                Map testCases2 = testCases;
                String expected = (String) element$iv2.getValue();
                Instant targetTime = currentTime.minus-LRDsOJo(duration);
                Instant currentTime2 = currentTime;
                String newResult = DateTimeFormatKt.formatRelativeDateTime(targetTime.toEpochMilliseconds());
                Map $this$forEach$iv2 = $this$forEach$iv;
                LegacyDateTimeFormat $this$testRelativeDateTimeMinutesAllLanguages_u24lambda_u240_u240_u240 = LegacyDateTimeFormat.INSTANCE;
                String legacyResult = $this$testRelativeDateTimeMinutesAllLanguages_u24lambda_u240_u240_u240.formatRelativeDateTime(targetTime.toEpochMilliseconds());
                INSTANCE.recordTestResult("Minutes ago format for " + locale + " (" + Duration.toString-impl(duration) + ")", Intrinsics.areEqual(expected, newResult), expected, newResult);
                INSTANCE.recordTestResult("Legacy match for " + locale + " (" + Duration.toString-impl(duration) + ")", Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
                testCases = testCases2;
                $this$forEach$iv = $this$forEach$iv2;
                element$iv = element$iv;
                currentTime = currentTime2;
                z = z;
                it = it;
                z2 = z2;
                cases = cases;
            }
        }
    }

    private final void testRelativeDateTimeHoursAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        Locale simplified_chinese = Locale.Companion.getSIMPLIFIED_CHINESE();
        Duration.Companion companion = Duration.Companion;
        Duration.Companion companion2 = Duration.Companion;
        Duration.Companion companion3 = Duration.Companion;
        Duration.Companion companion4 = Duration.Companion;
        Pair[] pairArr = {TuplesKt.to(Duration.box-impl(DurationKt.toDuration(1, DurationUnit.HOURS)), "1小时前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(2, DurationUnit.HOURS)), "2小时前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(8, DurationUnit.HOURS)), "8小时前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(23, DurationUnit.HOURS)), "23小时前")};
        Locale traditional_chinese = Locale.Companion.getTRADITIONAL_CHINESE();
        Duration.Companion companion5 = Duration.Companion;
        Duration.Companion companion6 = Duration.Companion;
        Duration.Companion companion7 = Duration.Companion;
        Duration.Companion companion8 = Duration.Companion;
        Pair[] pairArr2 = {TuplesKt.to(Duration.box-impl(DurationKt.toDuration(1, DurationUnit.HOURS)), "1小時前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(2, DurationUnit.HOURS)), "2小時前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(8, DurationUnit.HOURS)), "8小時前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(23, DurationUnit.HOURS)), "23小時前")};
        Locale english = Locale.Companion.getENGLISH();
        Duration.Companion companion9 = Duration.Companion;
        Duration.Companion companion10 = Duration.Companion;
        Duration.Companion companion11 = Duration.Companion;
        Duration.Companion companion12 = Duration.Companion;
        Pair[] pairArr3 = {TuplesKt.to(Duration.box-impl(DurationKt.toDuration(1, DurationUnit.HOURS)), "1 hr ago"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(2, DurationUnit.HOURS)), "2 hrs ago"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(8, DurationUnit.HOURS)), "8 hrs ago"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(23, DurationUnit.HOURS)), "23 hrs ago")};
        Locale japanese = Locale.Companion.getJAPANESE();
        Duration.Companion companion13 = Duration.Companion;
        Duration.Companion companion14 = Duration.Companion;
        Duration.Companion companion15 = Duration.Companion;
        Duration.Companion companion16 = Duration.Companion;
        Pair[] pairArr4 = {TuplesKt.to(Duration.box-impl(DurationKt.toDuration(1, DurationUnit.HOURS)), "1時間前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(2, DurationUnit.HOURS)), "2時間前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(8, DurationUnit.HOURS)), "8時間前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(23, DurationUnit.HOURS)), "23時間前")};
        Locale thai = Locale.Companion.getTHAI();
        Duration.Companion companion17 = Duration.Companion;
        Duration.Companion companion18 = Duration.Companion;
        Duration.Companion companion19 = Duration.Companion;
        Duration.Companion companion20 = Duration.Companion;
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(simplified_chinese, MapsKt.mapOf(pairArr)), TuplesKt.to(traditional_chinese, MapsKt.mapOf(pairArr2)), TuplesKt.to(english, MapsKt.mapOf(pairArr3)), TuplesKt.to(japanese, MapsKt.mapOf(pairArr4)), TuplesKt.to(thai, MapsKt.mapOf(new Pair[]{TuplesKt.to(Duration.box-impl(DurationKt.toDuration(1, DurationUnit.HOURS)), "1 ชั่วโมงก่อน"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(2, DurationUnit.HOURS)), "2 ชั่วโมงก่อน"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(8, DurationUnit.HOURS)), "8 ชั่วโมงก่อน"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(23, DurationUnit.HOURS)), "23 ชั่วโมงก่อน")}))});
        Map $this$forEach$iv = testCases;
        boolean z = false;
        Iterator it = $this$forEach$iv.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry element$iv = (Map.Entry) it.next();
            boolean z2 = false;
            Locale locale = (Locale) element$iv.getKey();
            Map cases = (Map) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            for (Map.Entry element$iv2 : cases.entrySet()) {
                long duration = ((Duration) element$iv2.getKey()).unbox-impl();
                Map testCases2 = testCases;
                String expected = (String) element$iv2.getValue();
                Instant targetTime = currentTime.minus-LRDsOJo(duration);
                Instant currentTime2 = currentTime;
                String newResult = DateTimeFormatKt.formatRelativeDateTime(targetTime.toEpochMilliseconds());
                Map $this$forEach$iv2 = $this$forEach$iv;
                LegacyDateTimeFormat $this$testRelativeDateTimeHoursAllLanguages_u24lambda_u240_u240_u240 = LegacyDateTimeFormat.INSTANCE;
                String legacyResult = $this$testRelativeDateTimeHoursAllLanguages_u24lambda_u240_u240_u240.formatRelativeDateTime(targetTime.toEpochMilliseconds());
                INSTANCE.recordTestResult("Hours ago format for " + locale + " (" + Duration.toString-impl(duration) + ")", Intrinsics.areEqual(expected, newResult), expected, newResult);
                INSTANCE.recordTestResult("Legacy match for " + locale + " (" + Duration.toString-impl(duration) + ")", Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
                testCases = testCases2;
                $this$forEach$iv = $this$forEach$iv2;
                element$iv = element$iv;
                currentTime = currentTime2;
                z = z;
                it = it;
                z2 = z2;
                cases = cases;
            }
        }
    }

    private final void testRelativeDateTimeYesterdayAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        Duration.Companion companion = Duration.Companion;
        Instant yesterday = currentTime.minus-LRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS));
        LocalTime yesterdayTime = TimeZoneKt.toLocalDateTime(yesterday, timeZone).getTime();
        String timeStr = StringsKt.padStart(String.valueOf(yesterdayTime.getHour()), 2, '0') + ":" + StringsKt.padStart(String.valueOf(yesterdayTime.getMinute()), 2, '0');
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(Locale.Companion.getSIMPLIFIED_CHINESE(), "昨天 " + timeStr), TuplesKt.to(Locale.Companion.getTRADITIONAL_CHINESE(), "昨天 " + timeStr), TuplesKt.to(Locale.Companion.getENGLISH(), "Yesterday " + timeStr), TuplesKt.to(Locale.Companion.getJAPANESE(), "昨日 " + timeStr), TuplesKt.to(Locale.Companion.getTHAI(), "เมื่อวาน " + timeStr)});
        for (Map.Entry element$iv : testCases.entrySet()) {
            Locale locale = (Locale) element$iv.getKey();
            String expected = (String) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            String newResult = DateTimeFormatKt.formatRelativeDateTime(yesterday.toEpochMilliseconds());
            LegacyDateTimeFormat $this$testRelativeDateTimeYesterdayAllLanguages_u24lambda_u240_u240 = LegacyDateTimeFormat.INSTANCE;
            Map testCases2 = testCases;
            String legacyResult = $this$testRelativeDateTimeYesterdayAllLanguages_u24lambda_u240_u240.formatRelativeDateTime(yesterday.toEpochMilliseconds());
            INSTANCE.recordTestResult("Yesterday format for " + locale, Intrinsics.areEqual(expected, newResult), expected, newResult);
            INSTANCE.recordTestResult("Legacy match for " + locale, Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
            yesterdayTime = yesterdayTime;
            testCases = testCases2;
        }
    }

    private final void testRelativeDateTimeDaysAgoAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        Locale simplified_chinese = Locale.Companion.getSIMPLIFIED_CHINESE();
        Duration.Companion companion = Duration.Companion;
        Duration.Companion companion2 = Duration.Companion;
        Pair[] pairArr = {TuplesKt.to(Duration.box-impl(DurationKt.toDuration(2, DurationUnit.DAYS)), "2天前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(3, DurationUnit.DAYS)), "3天前")};
        Locale traditional_chinese = Locale.Companion.getTRADITIONAL_CHINESE();
        Duration.Companion companion3 = Duration.Companion;
        Duration.Companion companion4 = Duration.Companion;
        Pair[] pairArr2 = {TuplesKt.to(Duration.box-impl(DurationKt.toDuration(2, DurationUnit.DAYS)), "2天前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(3, DurationUnit.DAYS)), "3天前")};
        Locale english = Locale.Companion.getENGLISH();
        Duration.Companion companion5 = Duration.Companion;
        Duration.Companion companion6 = Duration.Companion;
        Pair[] pairArr3 = {TuplesKt.to(Duration.box-impl(DurationKt.toDuration(2, DurationUnit.DAYS)), "2 days ago"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(3, DurationUnit.DAYS)), "3 days ago")};
        Locale japanese = Locale.Companion.getJAPANESE();
        Duration.Companion companion7 = Duration.Companion;
        Duration.Companion companion8 = Duration.Companion;
        Pair[] pairArr4 = {TuplesKt.to(Duration.box-impl(DurationKt.toDuration(2, DurationUnit.DAYS)), "2日前"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(3, DurationUnit.DAYS)), "3日前")};
        Locale thai = Locale.Companion.getTHAI();
        Duration.Companion companion9 = Duration.Companion;
        Duration.Companion companion10 = Duration.Companion;
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(simplified_chinese, MapsKt.mapOf(pairArr)), TuplesKt.to(traditional_chinese, MapsKt.mapOf(pairArr2)), TuplesKt.to(english, MapsKt.mapOf(pairArr3)), TuplesKt.to(japanese, MapsKt.mapOf(pairArr4)), TuplesKt.to(thai, MapsKt.mapOf(new Pair[]{TuplesKt.to(Duration.box-impl(DurationKt.toDuration(2, DurationUnit.DAYS)), "2 วันก่อน"), TuplesKt.to(Duration.box-impl(DurationKt.toDuration(3, DurationUnit.DAYS)), "3 วันก่อน")}))});
        Map $this$forEach$iv = testCases;
        boolean z = false;
        Iterator it = $this$forEach$iv.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry element$iv = (Map.Entry) it.next();
            boolean z2 = false;
            Locale locale = (Locale) element$iv.getKey();
            Map cases = (Map) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            for (Map.Entry element$iv2 : cases.entrySet()) {
                long duration = ((Duration) element$iv2.getKey()).unbox-impl();
                Map testCases2 = testCases;
                String expected = (String) element$iv2.getValue();
                Instant targetTime = currentTime.minus-LRDsOJo(duration);
                Instant currentTime2 = currentTime;
                String newResult = DateTimeFormatKt.formatRelativeDateTime(targetTime.toEpochMilliseconds());
                Map $this$forEach$iv2 = $this$forEach$iv;
                LegacyDateTimeFormat $this$testRelativeDateTimeDaysAgoAllLanguages_u24lambda_u240_u240_u240 = LegacyDateTimeFormat.INSTANCE;
                String legacyResult = $this$testRelativeDateTimeDaysAgoAllLanguages_u24lambda_u240_u240_u240.formatRelativeDateTime(targetTime.toEpochMilliseconds());
                INSTANCE.recordTestResult("Days ago format for " + locale + " (" + Duration.toString-impl(duration) + ")", Intrinsics.areEqual(expected, newResult), expected, newResult);
                INSTANCE.recordTestResult("Legacy match for " + locale + " (" + Duration.toString-impl(duration) + ")", Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
                testCases = testCases2;
                $this$forEach$iv = $this$forEach$iv2;
                element$iv = element$iv;
                currentTime = currentTime2;
                z = z;
                it = it;
                z2 = z2;
                cases = cases;
            }
        }
    }

    private final void testRelativeDateTimeMonthDayAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        int currentYear = TimeZoneKt.toLocalDateTime(currentTime, timeZone).getYear();
        Instant testTime = Instant.Companion.parse$default(Instant.Companion, currentYear + "-01-01T00:00:00Z", (DateTimeFormat) null, 2, (Object) null);
        LocalDateTime targetDateTime = TimeZoneKt.toLocalDateTime(testTime, timeZone);
        Locale simplified_chinese = Locale.Companion.getSIMPLIFIED_CHINESE();
        int monthNumber = targetDateTime.getMonthNumber();
        int dayOfMonth = targetDateTime.getDayOfMonth();
        Locale traditional_chinese = Locale.Companion.getTRADITIONAL_CHINESE();
        int monthNumber2 = targetDateTime.getMonthNumber();
        int dayOfMonth2 = targetDateTime.getDayOfMonth();
        Locale english = Locale.Companion.getENGLISH();
        int monthNumber3 = targetDateTime.getMonthNumber();
        int dayOfMonth3 = targetDateTime.getDayOfMonth();
        Locale japanese = Locale.Companion.getJAPANESE();
        int monthNumber4 = targetDateTime.getMonthNumber();
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(simplified_chinese, monthNumber + "月" + dayOfMonth + "日"), TuplesKt.to(traditional_chinese, monthNumber2 + "月" + dayOfMonth2 + "日"), TuplesKt.to(english, monthNumber3 + "-" + dayOfMonth3), TuplesKt.to(japanese, monthNumber4 + "月" + targetDateTime.getDayOfMonth() + "日"), TuplesKt.to(Locale.Companion.getTHAI(), targetDateTime.getMonthNumber() + "-" + targetDateTime.getDayOfMonth())});
        for (Map.Entry element$iv : testCases.entrySet()) {
            Locale locale = (Locale) element$iv.getKey();
            String expected = (String) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            String newResult = DateTimeFormatKt.formatRelativeDateTime(testTime.toEpochMilliseconds());
            LegacyDateTimeFormat $this$testRelativeDateTimeMonthDayAllLanguages_u24lambda_u240_u240 = LegacyDateTimeFormat.INSTANCE;
            Instant currentTime2 = currentTime;
            String legacyResult = $this$testRelativeDateTimeMonthDayAllLanguages_u24lambda_u240_u240.formatRelativeDateTime(testTime.toEpochMilliseconds());
            INSTANCE.recordTestResult("MonthDay format for " + locale, Intrinsics.areEqual(expected, newResult), expected, newResult);
            INSTANCE.recordTestResult("Legacy match for " + locale, Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
            currentTime = currentTime2;
            currentYear = currentYear;
        }
    }

    private final void testRelativeDateTimeYearMonthDayAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        int lastYear = TimeZoneKt.toLocalDateTime(currentTime, timeZone).getYear() - 1;
        Instant testTime = Instant.Companion.parse$default(Instant.Companion, lastYear + "-01-01T00:00:00Z", (DateTimeFormat) null, 2, (Object) null);
        LocalDateTime targetDateTime = TimeZoneKt.toLocalDateTime(testTime, timeZone);
        Locale simplified_chinese = Locale.Companion.getSIMPLIFIED_CHINESE();
        int year = targetDateTime.getYear();
        int monthNumber = targetDateTime.getMonthNumber();
        int dayOfMonth = targetDateTime.getDayOfMonth();
        Locale traditional_chinese = Locale.Companion.getTRADITIONAL_CHINESE();
        int year2 = targetDateTime.getYear();
        int monthNumber2 = targetDateTime.getMonthNumber();
        int dayOfMonth2 = targetDateTime.getDayOfMonth();
        Locale english = Locale.Companion.getENGLISH();
        int year3 = targetDateTime.getYear();
        int monthNumber3 = targetDateTime.getMonthNumber();
        int dayOfMonth3 = targetDateTime.getDayOfMonth();
        Locale japanese = Locale.Companion.getJAPANESE();
        int year4 = targetDateTime.getYear();
        int monthNumber4 = targetDateTime.getMonthNumber();
        int dayOfMonth4 = targetDateTime.getDayOfMonth();
        Locale thai = Locale.Companion.getTHAI();
        int year5 = targetDateTime.getYear();
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(simplified_chinese, year + "年" + monthNumber + "月" + dayOfMonth + "日"), TuplesKt.to(traditional_chinese, year2 + "年" + monthNumber2 + "月" + dayOfMonth2 + "日"), TuplesKt.to(english, year3 + "-" + monthNumber3 + "-" + dayOfMonth3), TuplesKt.to(japanese, year4 + "年" + monthNumber4 + "月" + dayOfMonth4 + "日"), TuplesKt.to(thai, year5 + "-" + targetDateTime.getMonthNumber() + "-" + targetDateTime.getDayOfMonth())});
        for (Map.Entry element$iv : testCases.entrySet()) {
            Locale locale = (Locale) element$iv.getKey();
            String expected = (String) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            String newResult = DateTimeFormatKt.formatRelativeDateTime(testTime.toEpochMilliseconds());
            LegacyDateTimeFormat $this$testRelativeDateTimeYearMonthDayAllLanguages_u24lambda_u240_u240 = LegacyDateTimeFormat.INSTANCE;
            Instant currentTime2 = currentTime;
            String legacyResult = $this$testRelativeDateTimeYearMonthDayAllLanguages_u24lambda_u240_u240.formatRelativeDateTime(testTime.toEpochMilliseconds());
            INSTANCE.recordTestResult("YearMonthDay format for " + locale, Intrinsics.areEqual(expected, newResult), expected, newResult);
            INSTANCE.recordTestResult("Legacy match for " + locale, Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
            currentTime = currentTime2;
            lastYear = lastYear;
        }
    }

    private final void testRelativeDateTimeFutureTodayAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        Duration.Companion companion = Duration.Companion;
        Instant futureToday = currentTime.plus-LRDsOJo(DurationKt.toDuration(2, DurationUnit.HOURS));
        LocalTime futureTime = TimeZoneKt.toLocalDateTime(futureToday, timeZone).getTime();
        String timeStr = StringsKt.padStart(String.valueOf(futureTime.getHour()), 2, '0') + ":" + StringsKt.padStart(String.valueOf(futureTime.getMinute()), 2, '0');
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(Locale.Companion.getSIMPLIFIED_CHINESE(), "今天 " + timeStr), TuplesKt.to(Locale.Companion.getTRADITIONAL_CHINESE(), "今天 " + timeStr), TuplesKt.to(Locale.Companion.getENGLISH(), "Today " + timeStr), TuplesKt.to(Locale.Companion.getJAPANESE(), "今日 " + timeStr), TuplesKt.to(Locale.Companion.getTHAI(), "วันนี้ " + timeStr)});
        for (Map.Entry element$iv : testCases.entrySet()) {
            Locale locale = (Locale) element$iv.getKey();
            String expected = (String) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            String newResult = DateTimeFormatKt.formatRelativeDateTime(futureToday.toEpochMilliseconds());
            LegacyDateTimeFormat $this$testRelativeDateTimeFutureTodayAllLanguages_u24lambda_u240_u240 = LegacyDateTimeFormat.INSTANCE;
            Map testCases2 = testCases;
            String legacyResult = $this$testRelativeDateTimeFutureTodayAllLanguages_u24lambda_u240_u240.formatRelativeDateTime(futureToday.toEpochMilliseconds());
            INSTANCE.recordTestResult("Future today format for " + locale, Intrinsics.areEqual(expected, newResult), expected, newResult);
            INSTANCE.recordTestResult("Legacy match for " + locale, Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
            futureTime = futureTime;
            testCases = testCases2;
        }
    }

    private final void testRelativeDateTimeTomorrowAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        Instant tomorrow = InstantJvmKt.plus(currentTime, 1, DateTimeUnit.Companion.getDAY(), timeZone);
        LocalTime tomorrowTime = TimeZoneKt.toLocalDateTime(tomorrow, timeZone).getTime();
        String timeStr = StringsKt.padStart(String.valueOf(tomorrowTime.getHour()), 2, '0') + ":" + StringsKt.padStart(String.valueOf(tomorrowTime.getMinute()), 2, '0');
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(Locale.Companion.getSIMPLIFIED_CHINESE(), "明天 " + timeStr), TuplesKt.to(Locale.Companion.getTRADITIONAL_CHINESE(), "明天 " + timeStr), TuplesKt.to(Locale.Companion.getENGLISH(), "Tomorrow " + timeStr), TuplesKt.to(Locale.Companion.getJAPANESE(), "明日 " + timeStr), TuplesKt.to(Locale.Companion.getTHAI(), "พรุ่งนี้ " + timeStr)});
        for (Map.Entry element$iv : testCases.entrySet()) {
            Locale locale = (Locale) element$iv.getKey();
            String expected = (String) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            String newResult = DateTimeFormatKt.formatRelativeDateTime(tomorrow.toEpochMilliseconds());
            LegacyDateTimeFormat $this$testRelativeDateTimeTomorrowAllLanguages_u24lambda_u240_u240 = LegacyDateTimeFormat.INSTANCE;
            LocalTime tomorrowTime2 = tomorrowTime;
            String legacyResult = $this$testRelativeDateTimeTomorrowAllLanguages_u24lambda_u240_u240.formatRelativeDateTime(tomorrow.toEpochMilliseconds());
            INSTANCE.recordTestResult("Tomorrow format for " + locale, Intrinsics.areEqual(expected, newResult), expected, newResult);
            INSTANCE.recordTestResult("Legacy match for " + locale, Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
            tomorrowTime = tomorrowTime2;
            testCases = testCases;
        }
    }

    private final void testRelativeDateTimeFutureThisYearAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        Instant futureThisYear = InstantJvmKt.plus(currentTime, 10, DateTimeUnit.Companion.getDAY(), timeZone);
        LocalDateTime futureDateTime = TimeZoneKt.toLocalDateTime(futureThisYear, timeZone);
        String timeStr = StringsKt.padStart(String.valueOf(futureDateTime.getHour()), 2, '0') + ":" + StringsKt.padStart(String.valueOf(futureDateTime.getMinute()), 2, '0');
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(Locale.Companion.getSIMPLIFIED_CHINESE(), futureDateTime.getMonthNumber() + "月" + futureDateTime.getDayOfMonth() + "日 " + timeStr), TuplesKt.to(Locale.Companion.getTRADITIONAL_CHINESE(), futureDateTime.getMonthNumber() + "月" + futureDateTime.getDayOfMonth() + "日 " + timeStr), TuplesKt.to(Locale.Companion.getENGLISH(), futureDateTime.getMonthNumber() + "-" + futureDateTime.getDayOfMonth() + " " + timeStr), TuplesKt.to(Locale.Companion.getJAPANESE(), futureDateTime.getMonthNumber() + "月" + futureDateTime.getDayOfMonth() + "日 " + timeStr), TuplesKt.to(Locale.Companion.getTHAI(), futureDateTime.getMonthNumber() + "-" + futureDateTime.getDayOfMonth() + " " + timeStr)});
        for (Map.Entry element$iv : testCases.entrySet()) {
            Locale locale = (Locale) element$iv.getKey();
            String expected = (String) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            String newResult = DateTimeFormatKt.formatRelativeDateTime(futureThisYear.toEpochMilliseconds());
            LegacyDateTimeFormat $this$testRelativeDateTimeFutureThisYearAllLanguages_u24lambda_u240_u240 = LegacyDateTimeFormat.INSTANCE;
            LocalDateTime futureDateTime2 = futureDateTime;
            String legacyResult = $this$testRelativeDateTimeFutureThisYearAllLanguages_u24lambda_u240_u240.formatRelativeDateTime(futureThisYear.toEpochMilliseconds());
            INSTANCE.recordTestResult("Future this year format for " + locale, Intrinsics.areEqual(expected, newResult), expected, newResult);
            INSTANCE.recordTestResult("Legacy match for " + locale, Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
            futureDateTime = futureDateTime2;
            timeStr = timeStr;
        }
    }

    private final void testRelativeDateTimeFutureCrossYearAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        int nextYear = TimeZoneKt.toLocalDateTime(currentTime, timeZone).getYear() + 1;
        Instant futureCrossYear = Instant.Companion.parse$default(Instant.Companion, nextYear + "-01-01T00:00:00Z", (DateTimeFormat) null, 2, (Object) null);
        LocalDateTime futureDateTime = TimeZoneKt.toLocalDateTime(futureCrossYear, timeZone);
        String timeStr = StringsKt.padStart(String.valueOf(futureDateTime.getHour()), 2, '0') + ":" + StringsKt.padStart(String.valueOf(futureDateTime.getMinute()), 2, '0');
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(Locale.Companion.getSIMPLIFIED_CHINESE(), futureDateTime.getYear() + "年" + futureDateTime.getMonthNumber() + "月" + futureDateTime.getDayOfMonth() + "日 " + timeStr), TuplesKt.to(Locale.Companion.getTRADITIONAL_CHINESE(), futureDateTime.getYear() + "年" + futureDateTime.getMonthNumber() + "月" + futureDateTime.getDayOfMonth() + "日 " + timeStr), TuplesKt.to(Locale.Companion.getENGLISH(), futureDateTime.getYear() + "-" + futureDateTime.getMonthNumber() + "-" + futureDateTime.getDayOfMonth() + " " + timeStr), TuplesKt.to(Locale.Companion.getJAPANESE(), futureDateTime.getYear() + "年" + futureDateTime.getMonthNumber() + "月" + futureDateTime.getDayOfMonth() + "日 " + timeStr), TuplesKt.to(Locale.Companion.getTHAI(), futureDateTime.getYear() + "-" + futureDateTime.getMonthNumber() + "-" + futureDateTime.getDayOfMonth() + " " + timeStr)});
        for (Map.Entry element$iv : testCases.entrySet()) {
            Locale locale = (Locale) element$iv.getKey();
            String expected = (String) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            String newResult = DateTimeFormatKt.formatRelativeDateTime(futureCrossYear.toEpochMilliseconds());
            LegacyDateTimeFormat $this$testRelativeDateTimeFutureCrossYearAllLanguages_u24lambda_u240_u240 = LegacyDateTimeFormat.INSTANCE;
            Instant currentTime2 = currentTime;
            String legacyResult = $this$testRelativeDateTimeFutureCrossYearAllLanguages_u24lambda_u240_u240.formatRelativeDateTime(futureCrossYear.toEpochMilliseconds());
            INSTANCE.recordTestResult("Future cross year format for " + locale, Intrinsics.areEqual(expected, newResult), expected, newResult);
            INSTANCE.recordTestResult("Legacy match for " + locale, Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
            currentTime = currentTime2;
            nextYear = nextYear;
        }
    }

    private final void testAbsoluteDateTimeAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        int lastYear = TimeZoneKt.toLocalDateTime(currentTime, timeZone).getYear() - 1;
        Instant testTime = Instant.Companion.parse$default(Instant.Companion, lastYear + "-01-01T12:02:00Z", (DateTimeFormat) null, 2, (Object) null);
        LocalDateTime testDateTime = TimeZoneKt.toLocalDateTime(testTime, timeZone);
        Locale simplified_chinese = Locale.Companion.getSIMPLIFIED_CHINESE();
        int year = testDateTime.getYear();
        int monthNumber = testDateTime.getMonthNumber();
        int dayOfMonth = testDateTime.getDayOfMonth();
        String padStart = StringsKt.padStart(String.valueOf(testDateTime.getHour()), 2, '0');
        String padStart2 = StringsKt.padStart(String.valueOf(testDateTime.getMinute()), 2, '0');
        Locale traditional_chinese = Locale.Companion.getTRADITIONAL_CHINESE();
        int year2 = testDateTime.getYear();
        int monthNumber2 = testDateTime.getMonthNumber();
        int dayOfMonth2 = testDateTime.getDayOfMonth();
        String padStart3 = StringsKt.padStart(String.valueOf(testDateTime.getHour()), 2, '0');
        String padStart4 = StringsKt.padStart(String.valueOf(testDateTime.getMinute()), 2, '0');
        Locale english = Locale.Companion.getENGLISH();
        int year3 = testDateTime.getYear();
        int monthNumber3 = testDateTime.getMonthNumber();
        int dayOfMonth3 = testDateTime.getDayOfMonth();
        String padStart5 = StringsKt.padStart(String.valueOf(testDateTime.getHour()), 2, '0');
        String padStart6 = StringsKt.padStart(String.valueOf(testDateTime.getMinute()), 2, '0');
        Locale japanese = Locale.Companion.getJAPANESE();
        int year4 = testDateTime.getYear();
        int monthNumber4 = testDateTime.getMonthNumber();
        int dayOfMonth4 = testDateTime.getDayOfMonth();
        String padStart7 = StringsKt.padStart(String.valueOf(testDateTime.getHour()), 2, '0');
        String padStart8 = StringsKt.padStart(String.valueOf(testDateTime.getMinute()), 2, '0');
        Locale thai = Locale.Companion.getTHAI();
        int year5 = testDateTime.getYear();
        int monthNumber5 = testDateTime.getMonthNumber();
        int dayOfMonth5 = testDateTime.getDayOfMonth();
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(simplified_chinese, year + "年" + monthNumber + "月" + dayOfMonth + "日 " + padStart + ":" + padStart2), TuplesKt.to(traditional_chinese, year2 + "年" + monthNumber2 + "月" + dayOfMonth2 + "日 " + padStart3 + ":" + padStart4), TuplesKt.to(english, year3 + "-" + monthNumber3 + "-" + dayOfMonth3 + " " + padStart5 + ":" + padStart6), TuplesKt.to(japanese, year4 + "年" + monthNumber4 + "月" + dayOfMonth4 + "日 " + padStart7 + ":" + padStart8), TuplesKt.to(thai, year5 + "-" + monthNumber5 + "-" + dayOfMonth5 + " " + StringsKt.padStart(String.valueOf(testDateTime.getHour()), 2, '0') + ":" + StringsKt.padStart(String.valueOf(testDateTime.getMinute()), 2, '0'))});
        for (Map.Entry element$iv : testCases.entrySet()) {
            Locale locale = (Locale) element$iv.getKey();
            String expected = (String) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            String newResult = DateTimeFormatKt.formatAbsoluteDateTime(testTime.toEpochMilliseconds());
            LegacyDateTimeFormat $this$testAbsoluteDateTimeAllLanguages_u24lambda_u240_u240 = LegacyDateTimeFormat.INSTANCE;
            String legacyResult = $this$testAbsoluteDateTimeAllLanguages_u24lambda_u240_u240.formatAbsoluteDateTime(testTime.toEpochMilliseconds());
            INSTANCE.recordTestResult("Absolute datetime format for " + locale, Intrinsics.areEqual(expected, newResult), expected, newResult);
            INSTANCE.recordTestResult("Legacy match for " + locale, Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
        }
    }

    private final void testImDateTimeTodayAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        LocalDateTime currentDateTime = TimeZoneKt.toLocalDateTime(currentTime, timeZone);
        String timeStr = StringsKt.padStart(String.valueOf(currentDateTime.getHour()), 2, '0') + ":" + StringsKt.padStart(String.valueOf(currentDateTime.getMinute()), 2, '0');
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(Locale.Companion.getSIMPLIFIED_CHINESE(), timeStr), TuplesKt.to(Locale.Companion.getTRADITIONAL_CHINESE(), timeStr), TuplesKt.to(Locale.Companion.getENGLISH(), timeStr), TuplesKt.to(Locale.Companion.getJAPANESE(), timeStr), TuplesKt.to(Locale.Companion.getTHAI(), timeStr)});
        for (Map.Entry element$iv : testCases.entrySet()) {
            Locale locale = (Locale) element$iv.getKey();
            String expected = (String) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            String newResult = DateTimeFormatKt.formatIMDateTime(currentTime.toEpochMilliseconds());
            LegacyDateTimeFormat $this$testImDateTimeTodayAllLanguages_u24lambda_u240_u240 = LegacyDateTimeFormat.INSTANCE;
            String legacyResult = $this$testImDateTimeTodayAllLanguages_u24lambda_u240_u240.formatIMDateTime(currentTime.toEpochMilliseconds());
            INSTANCE.recordTestResult("IM today format for " + locale, Intrinsics.areEqual(expected, newResult), expected, newResult);
            INSTANCE.recordTestResult("Legacy match for " + locale, Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
        }
    }

    private final void testImDateTimeYesterdayAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        Duration.Companion companion = Duration.Companion;
        Instant yesterday = currentTime.minus-LRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS));
        LocalTime yesterdayTime = TimeZoneKt.toLocalDateTime(yesterday, timeZone).getTime();
        String timeStr = StringsKt.padStart(String.valueOf(yesterdayTime.getHour()), 2, '0') + ":" + StringsKt.padStart(String.valueOf(yesterdayTime.getMinute()), 2, '0');
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(Locale.Companion.getSIMPLIFIED_CHINESE(), "昨天 " + timeStr), TuplesKt.to(Locale.Companion.getTRADITIONAL_CHINESE(), "昨天 " + timeStr), TuplesKt.to(Locale.Companion.getENGLISH(), "Yesterday " + timeStr), TuplesKt.to(Locale.Companion.getJAPANESE(), "昨日 " + timeStr), TuplesKt.to(Locale.Companion.getTHAI(), "เมื่อวาน " + timeStr)});
        for (Map.Entry element$iv : testCases.entrySet()) {
            Locale locale = (Locale) element$iv.getKey();
            String expected = (String) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            String newResult = DateTimeFormatKt.formatIMDateTime(yesterday.toEpochMilliseconds());
            LegacyDateTimeFormat $this$testImDateTimeYesterdayAllLanguages_u24lambda_u240_u240 = LegacyDateTimeFormat.INSTANCE;
            Map testCases2 = testCases;
            String legacyResult = $this$testImDateTimeYesterdayAllLanguages_u24lambda_u240_u240.formatIMDateTime(yesterday.toEpochMilliseconds());
            INSTANCE.recordTestResult("IM yesterday format for " + locale, Intrinsics.areEqual(expected, newResult), expected, newResult);
            INSTANCE.recordTestResult("Legacy match for " + locale, Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
            yesterdayTime = yesterdayTime;
            testCases = testCases2;
        }
    }

    private final void testImDateTimeHistoricalTimeAllLanguages() {
        Instant currentTime = Clock.System.INSTANCE.now();
        int historicalYear = TimeZoneKt.toLocalDateTime(currentTime, timeZone).getYear() - 5;
        Instant historicalTime = Instant.Companion.parse$default(Instant.Companion, historicalYear + "-01-01T00:00:00Z", (DateTimeFormat) null, 2, (Object) null);
        LocalDateTime historicalDateTime = TimeZoneKt.toLocalDateTime(historicalTime, timeZone);
        String expectedFormat = historicalDateTime.getYear() + "-" + historicalDateTime.getMonthNumber() + "-" + historicalDateTime.getDayOfMonth() + " " + StringsKt.padStart(String.valueOf(historicalDateTime.getHour()), 2, '0') + ":" + StringsKt.padStart(String.valueOf(historicalDateTime.getMinute()), 2, '0');
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(Locale.Companion.getSIMPLIFIED_CHINESE(), expectedFormat), TuplesKt.to(Locale.Companion.getTRADITIONAL_CHINESE(), expectedFormat), TuplesKt.to(Locale.Companion.getENGLISH(), expectedFormat), TuplesKt.to(Locale.Companion.getJAPANESE(), expectedFormat), TuplesKt.to(Locale.Companion.getTHAI(), expectedFormat)});
        for (Map.Entry element$iv : testCases.entrySet()) {
            Locale locale = (Locale) element$iv.getKey();
            String expected = (String) element$iv.getValue();
            Localization.INSTANCE.setCurrent(locale);
            String newResult = DateTimeFormatKt.formatIMDateTime(historicalTime.toEpochMilliseconds());
            LegacyDateTimeFormat $this$testImDateTimeHistoricalTimeAllLanguages_u24lambda_u240_u240 = LegacyDateTimeFormat.INSTANCE;
            Instant currentTime2 = currentTime;
            String legacyResult = $this$testImDateTimeHistoricalTimeAllLanguages_u24lambda_u240_u240.formatIMDateTime(historicalTime.toEpochMilliseconds());
            INSTANCE.recordTestResult("IM historical format for " + locale, Intrinsics.areEqual(expected, newResult), expected, newResult);
            INSTANCE.recordTestResult("Legacy match for " + locale, Intrinsics.areEqual(legacyResult, newResult), legacyResult, newResult);
            currentTime = currentTime2;
            historicalYear = historicalYear;
        }
    }

    private final void testFromSecondsExtensionFunctions() {
        Localization.INSTANCE.setCurrent(Locale.Companion.getSIMPLIFIED_CHINESE());
        String relativeNewResult = DateTimeFormatKt.formatRelativeDateTimeFromSeconds(1713164400L);
        LegacyDateTimeFormat $this$testFromSecondsExtensionFunctions_u24lambda_u240 = LegacyDateTimeFormat.INSTANCE;
        String relativeLegacyResult = $this$testFromSecondsExtensionFunctions_u24lambda_u240.formatRelativeDateTimeFromSeconds(1713164400L);
        recordTestResult("Seconds relative format", Intrinsics.areEqual(relativeLegacyResult, relativeNewResult), relativeLegacyResult, relativeNewResult);
        String absoluteNewResult = DateTimeFormatKt.formatAbsoluteDateTimeFromSeconds(1713168000L);
        LegacyDateTimeFormat $this$testFromSecondsExtensionFunctions_u24lambda_u241 = LegacyDateTimeFormat.INSTANCE;
        String absoluteLegacyResult = $this$testFromSecondsExtensionFunctions_u24lambda_u241.formatAbsoluteDateTimeFromSeconds(1713168000L);
        recordTestResult("Seconds absolute format", Intrinsics.areEqual(absoluteLegacyResult, absoluteNewResult), absoluteLegacyResult, absoluteNewResult);
        String imNewResult = DateTimeFormatKt.formatIMDateTimeFromSeconds(1713168000L);
        LegacyDateTimeFormat $this$testFromSecondsExtensionFunctions_u24lambda_u242 = LegacyDateTimeFormat.INSTANCE;
        String imLegacyResult = $this$testFromSecondsExtensionFunctions_u24lambda_u242.formatIMDateTimeFromSeconds(1713168000L);
        recordTestResult("Seconds IM format", Intrinsics.areEqual(imLegacyResult, imNewResult), imLegacyResult, imNewResult);
    }

    private final void testEdgeCases() {
        Localization.INSTANCE.setCurrent(Locale.Companion.getSIMPLIFIED_CHINESE());
        Instant currentTime = Clock.System.INSTANCE.now();
        Instant epochTime = Instant.Companion.fromEpochSeconds$default(Instant.Companion, 0L, 0L, 2, (Object) null);
        String epochNewResult = DateTimeFormatKt.formatRelativeDateTime(epochTime.toEpochMilliseconds());
        LegacyDateTimeFormat $this$testEdgeCases_u24lambda_u240 = LegacyDateTimeFormat.INSTANCE;
        String epochLegacyResult = $this$testEdgeCases_u24lambda_u240.formatRelativeDateTime(epochTime.toEpochMilliseconds());
        recordTestResult("Epoch time format", Intrinsics.areEqual(epochLegacyResult, epochNewResult), epochLegacyResult, epochNewResult);
        Instant futureTime = Instant.Companion.fromEpochSeconds$default(Instant.Companion, 2147483647L, 0L, 2, (Object) null);
        String futureNewResult = DateTimeFormatKt.formatAbsoluteDateTime(futureTime.toEpochMilliseconds());
        LegacyDateTimeFormat $this$testEdgeCases_u24lambda_u241 = LegacyDateTimeFormat.INSTANCE;
        String futureLegacyResult = $this$testEdgeCases_u24lambda_u241.formatAbsoluteDateTime(futureTime.toEpochMilliseconds());
        recordTestResult("Far future time format", Intrinsics.areEqual(futureLegacyResult, futureNewResult), futureLegacyResult, futureNewResult);
        Duration.Companion companion = Duration.Companion;
        Instant just59SecondsAgo = currentTime.minus-LRDsOJo(DurationKt.toDuration(59, DurationUnit.SECONDS));
        String justNowResult = DateTimeFormatKt.formatRelativeDateTime(just59SecondsAgo.toEpochMilliseconds());
        recordTestResult("59 seconds boundary for 刚刚", Intrinsics.areEqual("刚刚", justNowResult), "刚刚", justNowResult);
        Duration.Companion companion2 = Duration.Companion;
        Instant exactly1MinuteAgo = currentTime.minus-LRDsOJo(DurationKt.toDuration(1, DurationUnit.MINUTES));
        String oneMinuteResult = DateTimeFormatKt.formatRelativeDateTime(exactly1MinuteAgo.toEpochMilliseconds());
        recordTestResult("1 minute boundary", Intrinsics.areEqual("1分钟前", oneMinuteResult), "1分钟前", oneMinuteResult);
        Duration.Companion companion3 = Duration.Companion;
        Instant exactly1HourAgo = currentTime.minus-LRDsOJo(DurationKt.toDuration(1, DurationUnit.HOURS));
        String oneHourResult = DateTimeFormatKt.formatRelativeDateTime(exactly1HourAgo.toEpochMilliseconds());
        recordTestResult("1 hour boundary", Intrinsics.areEqual("1小时前", oneHourResult), "1小时前", oneHourResult);
        Duration.Companion companion4 = Duration.Companion;
        Instant exactly24HoursAgo = currentTime.minus-LRDsOJo(DurationKt.toDuration(24, DurationUnit.HOURS));
        String yesterdayResult = DateTimeFormatKt.formatRelativeDateTime(exactly24HoursAgo.toEpochMilliseconds());
        LocalTime yesterdayTime = TimeZoneKt.toLocalDateTime(exactly24HoursAgo, timeZone).getTime();
        String yesterdayExpected = "昨天 " + StringsKt.padStart(String.valueOf(yesterdayTime.getHour()), 2, '0') + ":" + StringsKt.padStart(String.valueOf(yesterdayTime.getMinute()), 2, '0');
        recordTestResult("24 hours boundary for 昨天", Intrinsics.areEqual(yesterdayExpected, yesterdayResult), yesterdayExpected, yesterdayResult);
    }
}