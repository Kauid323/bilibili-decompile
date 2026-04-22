package kntr.base.localization.preview;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.localization.Locale;
import kntr.base.localization.Localization;
import kntr.base.localization.NumberFormatKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NumberFormatTest.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ0\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002J8\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0002J8\u0010\u001c\u001a\u00020\u000e2$\u0010\u001d\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00050\u001f0\n0\u001e2\b\b\u0002\u0010 \u001a\u00020\u0005H\u0002J\u001f\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0$H\u0082\bJ\b\u0010%\u001a\u00020\u000eH\u0002J\b\u0010&\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u000eH\u0002J\b\u0010)\u001a\u00020\u000eH\u0002J\b\u0010*\u001a\u00020\u000eH\u0002J\b\u0010+\u001a\u00020\u000eH\u0002J\u0088\u0001\u0010,\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00050\u001f0\n0\u001e2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0002J\b\u00104\u001a\u00020\u000eH\u0002J\b\u00105\u001a\u00020\u000eH\u0002J\b\u00106\u001a\u00020\u000eH\u0002J\b\u00107\u001a\u00020\u000eH\u0002J\b\u00108\u001a\u00020\u000eH\u0002J\b\u00109\u001a\u00020\u000eH\u0002J\u0013\u0010:\u001a\u00020\u00122\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0007HÖ\u0001J\t\u0010=\u001a\u00020\u0005HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lkntr/base/localization/preview/NumberFormatTest;", "", "<init>", "()V", "TAG", "", "totalTests", "", "passedTests", "ALL_LOCALES", "", "Lkntr/base/localization/Locale;", "BASIC_TEST_LOCALES", "testAll", "", "recordTestResult", "testName", "isPassed", "", "expected", "actual", "testNumberWithLegacyComparison", "number", "", "digits", "trimEnd", "testNamePrefix", "expectedValue", "runTestForLocales", "testCases", "", "Lkotlin/Pair;", "testDescription", "withLocale", "locale", "block", "Lkotlin/Function0;", "printTestSummary", "testBasicNumberFormatAllLanguages", "testRangeZeroToTenK", "testRangeTenKToNinetyNineNineK", "testOneMillion", "testRangeHundredMToBillion", "testBillionPlus", "createLocaleSpecificTestCases", "numbers", "chineseFormats", "traditionalChineseFormats", "englishFormats", "japaneseFormats", "thaiFormats", "arabicFormats", "testLegacyCompatibility", "testEdgeCases", "testCarryRule", "testChineseCarryRule", "testEnglishCarryRule", "testBasicCarryRule", "equals", "other", "hashCode", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NumberFormatTest {
    private static final String TAG = "NumberFormatTest";
    private static int passedTests;
    private static int totalTests;
    public static final NumberFormatTest INSTANCE = new NumberFormatTest();
    private static final List<Locale> ALL_LOCALES = CollectionsKt.listOf(new Locale[]{Locale.Companion.getSIMPLIFIED_CHINESE(), Locale.Companion.getTRADITIONAL_CHINESE(), Locale.Companion.getENGLISH(), Locale.Companion.getJAPANESE(), Locale.Companion.getTHAI(), Locale.Companion.getARABIC()});
    private static final List<Locale> BASIC_TEST_LOCALES = CollectionsKt.listOf(new Locale[]{Locale.Companion.getSIMPLIFIED_CHINESE(), Locale.Companion.getTRADITIONAL_CHINESE(), Locale.Companion.getENGLISH()});
    public static final int $stable = 8;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NumberFormatTest) {
            NumberFormatTest numberFormatTest = (NumberFormatTest) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return -333452259;
    }

    public String toString() {
        return TAG;
    }

    private NumberFormatTest() {
    }

    public final void testAll() {
        totalTests = 0;
        passedTests = 0;
        testBasicNumberFormatAllLanguages();
        testLegacyCompatibility();
        testEdgeCases();
        testCarryRule();
        printTestSummary();
    }

    static /* synthetic */ void recordTestResult$default(NumberFormatTest numberFormatTest, String str, boolean z, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        numberFormatTest.recordTestResult(str, z, str2, str3);
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

    static /* synthetic */ void testNumberWithLegacyComparison$default(NumberFormatTest numberFormatTest, long j, int i, boolean z, String str, String str2, int i2, Object obj) {
        numberFormatTest.testNumberWithLegacyComparison(j, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? true : z, str, (i2 & 16) != 0 ? null : str2);
    }

    private final void testNumberWithLegacyComparison(long number, int digits, boolean trimEnd, String testNamePrefix, String expectedValue) {
        String newResult = NumberFormatKt.formatNumber(number, digits, trimEnd);
        String legacyResult = LegacyNumberFormatKt.formatNumber(number, digits, trimEnd);
        boolean legacyCompatible = Intrinsics.areEqual(newResult, legacyResult);
        String legacyTestName = testNamePrefix + "[Legacy比较] " + number;
        recordTestResult(legacyTestName, legacyCompatible, legacyResult, newResult);
        if (expectedValue != null) {
            boolean expectationMet = Intrinsics.areEqual(newResult, expectedValue);
            String expectationTestName = testNamePrefix + "[期望值] " + number + " -> " + expectedValue;
            recordTestResult(expectationTestName, expectationMet, expectedValue, newResult);
        }
    }

    static /* synthetic */ void runTestForLocales$default(NumberFormatTest numberFormatTest, Map map, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        numberFormatTest.runTestForLocales(map, str);
    }

    private final void runTestForLocales(Map<Locale, ? extends List<Pair<Long, String>>> map, String testDescription) {
        Map<Locale, ? extends List<Pair<Long, String>>> map2 = map;
        Iterator<Map.Entry<Locale, ? extends List<Pair<Long, String>>>> it = map2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry element$iv = it.next();
            Locale locale = element$iv.getKey();
            List<Pair<Long, String>> cases = element$iv.getValue();
            NumberFormatTest numberFormatTest = INSTANCE;
            Locale originalLocale$iv = Localization.INSTANCE.getCurrent();
            try {
                Localization.INSTANCE.setCurrent(locale);
                List<Pair<Long, String>> $this$forEach$iv = cases;
                Iterator<T> it2 = $this$forEach$iv.iterator();
                while (it2.hasNext()) {
                    Pair pair = (Pair) it2.next();
                    long number = ((Number) pair.component1()).longValue();
                    String expected = (String) pair.component2();
                    Iterator<Map.Entry<Locale, ? extends List<Pair<Long, String>>>> it3 = it;
                    Map<Locale, ? extends List<Pair<Long, String>>> map3 = map2;
                    try {
                        INSTANCE.testNumberWithLegacyComparison(number, 1, true, testDescription + "[" + locale + "]", expected);
                        it = it3;
                        map2 = map3;
                    } catch (Throwable th) {
                        th = th;
                        Localization.INSTANCE.setCurrent(originalLocale$iv);
                        throw th;
                    }
                }
                Localization.INSTANCE.setCurrent(originalLocale$iv);
                it = it;
                map2 = map2;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private final void withLocale(Locale locale, Function0<Unit> function0) {
        Locale originalLocale = Localization.INSTANCE.getCurrent();
        try {
            Localization.INSTANCE.setCurrent(locale);
            function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            Localization.INSTANCE.setCurrent(originalLocale);
            InlineMarker.finallyEnd(1);
        }
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

    private final void testBasicNumberFormatAllLanguages() {
        KLog_androidKt.getKLog().i(TAG, "\n=== 基础数值格式化测试 ===");
        testRangeZeroToTenK();
        testRangeTenKToNinetyNineNineK();
        testOneMillion();
        testRangeHundredMToBillion();
        testBillionPlus();
    }

    private final void testRangeZeroToTenK() {
        List testCases = CollectionsKt.listOf(new Pair[]{TuplesKt.to(0L, "0"), TuplesKt.to(1L, "1"), TuplesKt.to(100L, "100"), TuplesKt.to(1000L, "1000"), TuplesKt.to(3500L, "3500"), TuplesKt.to(9999L, "9999")});
        Iterable $this$forEach$iv = ALL_LOCALES;
        Iterator it = $this$forEach$iv.iterator();
        while (it.hasNext()) {
            Object element$iv = it.next();
            Locale locale = (Locale) element$iv;
            NumberFormatTest numberFormatTest = INSTANCE;
            Locale originalLocale$iv = Localization.INSTANCE.getCurrent();
            try {
                Localization.INSTANCE.setCurrent(locale);
                Iterable $this$forEach$iv2 = testCases;
                for (Object element$iv2 : $this$forEach$iv2) {
                    Pair pair = (Pair) element$iv2;
                    long number = ((Number) pair.component1()).longValue();
                    String expected = (String) pair.component2();
                    Iterator it2 = it;
                    List testCases2 = testCases;
                    try {
                        INSTANCE.testNumberWithLegacyComparison(number, 1, true, "[0-10K][" + locale + "]", expected);
                        it = it2;
                        testCases = testCases2;
                    } catch (Throwable th) {
                        th = th;
                        Localization.INSTANCE.setCurrent(originalLocale$iv);
                        throw th;
                    }
                }
                Localization.INSTANCE.setCurrent(originalLocale$iv);
                it = it;
                testCases = testCases;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private final void testRangeTenKToNinetyNineNineK() {
        Map testCases = createLocaleSpecificTestCases(CollectionsKt.listOf(new Long[]{12000L, 25000L, 150000L, 500000L, 999000L}), CollectionsKt.listOf(new String[]{"1.2万", "2.5万", "15万", "50万", "99.9万"}), CollectionsKt.listOf(new String[]{"1.2萬", "2.5萬", "15萬", "50萬", "99.9萬"}), CollectionsKt.listOf(new String[]{"12K", "25K", "150K", "500K", "999K"}), CollectionsKt.listOf(new String[]{"1.2万", "2.5万", "15万", "50万", "99.9万"}), CollectionsKt.listOf(new String[]{"12 พัน", "25 พัน", "150 พัน", "500 พัน", "999 พัน"}), CollectionsKt.listOf(new String[]{"12 ألف", "25 ألف", "150 ألف", "500 ألف", "999 ألف"}));
        runTestForLocales(testCases, "[10K-999K]");
    }

    private final void testOneMillion() {
        Map testCases = MapsKt.mapOf(new Pair[]{TuplesKt.to(Locale.Companion.getSIMPLIFIED_CHINESE(), CollectionsKt.listOf(TuplesKt.to(1000000L, "100万"))), TuplesKt.to(Locale.Companion.getTRADITIONAL_CHINESE(), CollectionsKt.listOf(TuplesKt.to(1000000L, "100萬"))), TuplesKt.to(Locale.Companion.getENGLISH(), CollectionsKt.listOf(TuplesKt.to(1000000L, "1M"))), TuplesKt.to(Locale.Companion.getJAPANESE(), CollectionsKt.listOf(TuplesKt.to(1000000L, "100万"))), TuplesKt.to(Locale.Companion.getTHAI(), CollectionsKt.listOf(TuplesKt.to(1000000L, "1 ล้าน"))), TuplesKt.to(Locale.Companion.getARABIC(), CollectionsKt.listOf(TuplesKt.to(1000000L, "1 مليون")))});
        runTestForLocales(testCases, "[1M]");
    }

    private final void testRangeHundredMToBillion() {
        Map testCases = createLocaleSpecificTestCases(CollectionsKt.listOf(new Long[]{100000000L, 150000000L, 500000000L}), CollectionsKt.listOf(new String[]{"1亿", "1.5亿", "5亿"}), CollectionsKt.listOf(new String[]{"1億", "1.5億", "5億"}), CollectionsKt.listOf(new String[]{"100M", "150M", "500M"}), CollectionsKt.listOf(new String[]{"1億", "1.5億", "5億"}), CollectionsKt.listOf(new String[]{"100 ล้าน", "150 ล้าน", "500 ล้าน"}), CollectionsKt.listOf(new String[]{"100 مليون", "150 مليون", "500 مليون"}));
        runTestForLocales(testCases, "[100M-1B)");
    }

    private final void testBillionPlus() {
        Map testCases = createLocaleSpecificTestCases(CollectionsKt.listOf(new Long[]{1000000000L, 2500000000L}), CollectionsKt.listOf(new String[]{"10亿", "25亿"}), CollectionsKt.listOf(new String[]{"10億", "25億"}), CollectionsKt.listOf(new String[]{"1B", "2.5B"}), CollectionsKt.listOf(new String[]{"10億", "25億"}), CollectionsKt.listOf(new String[]{"1000 ล้าน", "2500 ล้าน"}), CollectionsKt.listOf(new String[]{"1 مليار", "2.5 مليار"}));
        runTestForLocales(testCases, "[1B+]");
    }

    private final Map<Locale, List<Pair<Long, String>>> createLocaleSpecificTestCases(List<Long> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, List<String> list7) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Locale.Companion.getSIMPLIFIED_CHINESE(), CollectionsKt.zip(list, list2)), TuplesKt.to(Locale.Companion.getTRADITIONAL_CHINESE(), CollectionsKt.zip(list, list3)), TuplesKt.to(Locale.Companion.getENGLISH(), CollectionsKt.zip(list, list4)), TuplesKt.to(Locale.Companion.getJAPANESE(), CollectionsKt.zip(list, list5)), TuplesKt.to(Locale.Companion.getTHAI(), CollectionsKt.zip(list, list6)), TuplesKt.to(Locale.Companion.getARABIC(), CollectionsKt.zip(list, list7))});
    }

    private final void testLegacyCompatibility() {
        KLog_androidKt.getKLog().i(TAG, "\n=== 新旧实现对比测试 ===");
        List testNumbers = CollectionsKt.listOf(new Long[]{0L, 1L, 100L, 1000L, 3500L, 9999L, 12000L, 25000L, 150000L, 500000L, 999000L, 1000000L, 2500000L, 10000000L, 100000000L, 150000000L, 500000000L, 1000000000L, 2500000000L, 10000000000L});
        Iterable $this$forEach$iv = BASIC_TEST_LOCALES;
        Iterator it = $this$forEach$iv.iterator();
        while (it.hasNext()) {
            Object element$iv = it.next();
            Locale locale = (Locale) element$iv;
            NumberFormatTest numberFormatTest = INSTANCE;
            Locale originalLocale$iv = Localization.INSTANCE.getCurrent();
            try {
                Localization.INSTANCE.setCurrent(locale);
                Iterable $this$forEach$iv2 = testNumbers;
                for (Object element$iv2 : $this$forEach$iv2) {
                    long number = ((Number) element$iv2).longValue();
                    Iterator it2 = it;
                    List testNumbers2 = testNumbers;
                    try {
                        testNumberWithLegacyComparison$default(INSTANCE, number, 1, true, "[Legacy兼容性][" + locale + "]", null, 16, null);
                        it = it2;
                        testNumbers = testNumbers2;
                    } catch (Throwable th) {
                        th = th;
                        Localization.INSTANCE.setCurrent(originalLocale$iv);
                        throw th;
                    }
                }
                Localization.INSTANCE.setCurrent(originalLocale$iv);
                it = it;
                testNumbers = testNumbers;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private final void testEdgeCases() {
        KLog_androidKt.getKLog().i(TAG, "\n=== 边界情况测试 ===");
        Locale locale$iv = Locale.Companion.getSIMPLIFIED_CHINESE();
        Locale originalLocale$iv = Localization.INSTANCE.getCurrent();
        try {
            Localization.INSTANCE.setCurrent(locale$iv);
            INSTANCE.testNumberWithLegacyComparison(-12000L, 1, true, "[边界情况]", "-1.2万");
            INSTANCE.testNumberWithLegacyComparison(0L, 1, true, "[边界情况]", "0");
            INSTANCE.testNumberWithLegacyComparison(12345L, 2, false, "[精度参数]", "1.23万");
            INSTANCE.testNumberWithLegacyComparison(12000L, 2, false, "[trimEnd=false]", "1.20万");
            INSTANCE.testNumberWithLegacyComparison(12000L, 2, true, "[trimEnd=true]", "1.2万");
            testNumberWithLegacyComparison$default(INSTANCE, Long.MAX_VALUE, 1, true, "[极值]Long.MAX_VALUE", null, 16, null);
            testNumberWithLegacyComparison$default(INSTANCE, Long.MIN_VALUE, 1, true, "[极值]Long.MIN_VALUE", null, 16, null);
        } finally {
            Localization.INSTANCE.setCurrent(originalLocale$iv);
        }
    }

    private final void testCarryRule() {
        KLog_androidKt.getKLog().i(TAG, "\n=== Carry Rule 测试 ===");
        testChineseCarryRule();
        testEnglishCarryRule();
        testBasicCarryRule();
    }

    private final void testChineseCarryRule() {
        Iterable carryTestCases = CollectionsKt.listOf(new Pair[]{TuplesKt.to(9950L, "9950"), TuplesKt.to(9999L, "9999"), TuplesKt.to(10000L, "1万"), TuplesKt.to(99950L, "9.995万"), TuplesKt.to(999500L, "99.95万"), TuplesKt.to(999950L, "99.995万")});
        Locale locale$iv = Locale.Companion.getSIMPLIFIED_CHINESE();
        Locale originalLocale$iv = Localization.INSTANCE.getCurrent();
        try {
            Localization.INSTANCE.setCurrent(locale$iv);
            Iterable $this$forEach$iv = carryTestCases;
            for (Object element$iv : $this$forEach$iv) {
                Pair pair = (Pair) element$iv;
                long number = ((Number) pair.component1()).longValue();
                String expected = (String) pair.component2();
                INSTANCE.testNumberWithLegacyComparison(number, 3, true, "[Carry-CN]", expected);
            }
        } finally {
            Localization.INSTANCE.setCurrent(originalLocale$iv);
        }
    }

    private final void testEnglishCarryRule() {
        KLog_androidKt.getKLog().i(TAG, "\n--- 英文进位规则专项测试 ---");
        Locale locale$iv = Locale.Companion.getENGLISH();
        Locale originalLocale$iv = Localization.INSTANCE.getCurrent();
        try {
            Localization.INSTANCE.setCurrent(locale$iv);
            Iterable englishCarryTestCases = CollectionsKt.listOf(new Pair[]{TuplesKt.to(9999L, "9999"), TuplesKt.to(10000L, "10K"), TuplesKt.to(10500L, "10.5K"), TuplesKt.to(10950L, "10.95K"), TuplesKt.to(10999L, "11K"), TuplesKt.to(14950L, "14.95K"), TuplesKt.to(14990L, "14.99K"), TuplesKt.to(14995L, "15K"), TuplesKt.to(19950L, "19.95K"), TuplesKt.to(19990L, "19.99K"), TuplesKt.to(19995L, "20K"), TuplesKt.to(99500L, "99.5K"), TuplesKt.to(99900L, "99.9K"), TuplesKt.to(99950L, "99.95K"), TuplesKt.to(995000L, "995K"), TuplesKt.to(999000L, "999K"), TuplesKt.to(999500L, "999.5K"), TuplesKt.to(999900L, "999.9K"), TuplesKt.to(999950L, "999.95K"), TuplesKt.to(1000000L, "1M"), TuplesKt.to(1500000L, "1.5M"), TuplesKt.to(1950000L, "1.95M"), TuplesKt.to(1990000L, "1.99M"), TuplesKt.to(1999000L, "1.99M"), TuplesKt.to(1000000000L, "1B"), TuplesKt.to(1500000000L, "1.5B"), TuplesKt.to(1950000000L, "1.95B")});
            Iterable $this$forEach$iv = englishCarryTestCases;
            for (Object element$iv : $this$forEach$iv) {
                Pair pair = (Pair) element$iv;
                long number = ((Number) pair.component1()).longValue();
                String expected = (String) pair.component2();
                INSTANCE.testNumberWithLegacyComparison(number, 2, true, "[Carry-EN]", expected);
            }
            INSTANCE.testNumberWithLegacyComparison(10999L, 3, true, "[Carry-EN-3digits]", "10.999K");
        } finally {
            Localization.INSTANCE.setCurrent(originalLocale$iv);
        }
    }

    private final void testBasicCarryRule() {
        Map multiLangCarryTest = MapsKt.mapOf(new Pair[]{TuplesKt.to(Locale.Companion.getSIMPLIFIED_CHINESE(), TuplesKt.to(10000L, "1万")), TuplesKt.to(Locale.Companion.getTRADITIONAL_CHINESE(), TuplesKt.to(10000L, "1萬")), TuplesKt.to(Locale.Companion.getENGLISH(), TuplesKt.to(10000L, "10K")), TuplesKt.to(Locale.Companion.getJAPANESE(), TuplesKt.to(10000L, "1万"))});
        Iterator it = multiLangCarryTest.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry element$iv = (Map.Entry) it.next();
            Locale locale = (Locale) element$iv.getKey();
            Pair pair = (Pair) element$iv.getValue();
            NumberFormatTest numberFormatTest = INSTANCE;
            Locale originalLocale$iv = Localization.INSTANCE.getCurrent();
            try {
                Localization.INSTANCE.setCurrent(locale);
                long number = ((Number) pair.component1()).longValue();
                String expected = (String) pair.component2();
                Iterator it2 = it;
                INSTANCE.testNumberWithLegacyComparison(number, 1, true, "[Carry-Basic][" + locale + "]", expected);
                Localization.INSTANCE.setCurrent(originalLocale$iv);
                it = it2;
            } catch (Throwable th) {
                Localization.INSTANCE.setCurrent(originalLocale$iv);
                throw th;
            }
        }
    }
}