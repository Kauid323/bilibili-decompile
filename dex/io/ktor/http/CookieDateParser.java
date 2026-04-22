package io.ktor.http;

import com.tencent.matrix.report.Issue;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import io.ktor.http.ContentDisposition;
import io.ktor.util.date.GMTDate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: CookieUtils.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/http/CookieDateParser;", "", "<init>", "()V", "T", "", SocialConstants.PARAM_SOURCE, ContentDisposition.Parameters.Name, "field", "", "checkFieldNotNull", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "", "requirement", "Lkotlin/Function0;", SocialConstants.PARAM_SEND_MSG, "checkRequirement", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "Lio/ktor/util/date/GMTDate;", "parse", "(Ljava/lang/String;)Lio/ktor/util/date/GMTDate;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CookieDateParser {
    private final <T> void checkFieldNotNull(String source, String name, T t) {
        if (t == null) {
            throw new InvalidCookieDateException(source, "Could not find " + name);
        }
    }

    private final void checkRequirement(String source, boolean requirement, Function0<String> function0) {
        if (!requirement) {
            throw new InvalidCookieDateException(source, (String) function0.invoke());
        }
    }

    public final GMTDate parse(String source) {
        Intrinsics.checkNotNullParameter(source, SocialConstants.PARAM_SOURCE);
        StringLexer lexer = new StringLexer(source);
        CookieDateBuilder builder = new CookieDateBuilder();
        lexer.acceptWhile(new Function1() { // from class: io.ktor.http.CookieDateParser$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean isDelimiter;
                isDelimiter = CookieUtilsKt.isDelimiter(((Character) obj).charValue());
                return Boolean.valueOf(isDelimiter);
            }
        });
        while (lexer.getHasRemaining()) {
            if (lexer.test(new Function1() { // from class: io.ktor.http.CookieDateParser$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    boolean isNonDelimiter;
                    isNonDelimiter = CookieUtilsKt.isNonDelimiter(((Character) obj).charValue());
                    return Boolean.valueOf(isNonDelimiter);
                }
            })) {
                int start$iv = lexer.getIndex();
                lexer.acceptWhile(new Function1() { // from class: io.ktor.http.CookieDateParser$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        boolean isNonDelimiter;
                        isNonDelimiter = CookieUtilsKt.isNonDelimiter(((Character) obj).charValue());
                        return Boolean.valueOf(isNonDelimiter);
                    }
                });
                String token = lexer.getSource().substring(start$iv, lexer.getIndex());
                Intrinsics.checkNotNullExpressionValue(token, "substring(...)");
                CookieUtilsKt.handleToken(builder, token);
                lexer.acceptWhile(new Function1() { // from class: io.ktor.http.CookieDateParser$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        boolean isDelimiter;
                        isDelimiter = CookieUtilsKt.isDelimiter(((Character) obj).charValue());
                        return Boolean.valueOf(isDelimiter);
                    }
                });
            }
        }
        Integer year = builder.getYear();
        if (year != null && new IntRange(70, 99).contains(year.intValue())) {
            Integer year2 = builder.getYear();
            Intrinsics.checkNotNull(year2);
            builder.setYear(Integer.valueOf(year2.intValue() + 1900));
        } else {
            if (year != null && new IntRange(0, 69).contains(year.intValue())) {
                Integer year3 = builder.getYear();
                Intrinsics.checkNotNull(year3);
                builder.setYear(Integer.valueOf(year3.intValue() + Constants.ASSEMBLE_PUSH_RETRY_INTERVAL));
            }
        }
        checkFieldNotNull(source, "day-of-month", builder.getDayOfMonth());
        checkFieldNotNull(source, "month", builder.getMonth());
        checkFieldNotNull(source, "year", builder.getYear());
        checkFieldNotNull(source, Issue.ISSUE_REPORT_TIME, builder.getHours());
        checkFieldNotNull(source, Issue.ISSUE_REPORT_TIME, builder.getMinutes());
        checkFieldNotNull(source, Issue.ISSUE_REPORT_TIME, builder.getSeconds());
        IntRange intRange = new IntRange(1, 31);
        Integer dayOfMonth = builder.getDayOfMonth();
        checkRequirement(source, dayOfMonth != null && intRange.contains(dayOfMonth.intValue()), new Function0() { // from class: io.ktor.http.CookieDateParser$$ExternalSyntheticLambda4
            public final Object invoke() {
                String parse$lambda$5;
                parse$lambda$5 = CookieDateParser.parse$lambda$5();
                return parse$lambda$5;
            }
        });
        Integer year4 = builder.getYear();
        Intrinsics.checkNotNull(year4);
        checkRequirement(source, year4.intValue() >= 1601, new Function0() { // from class: io.ktor.http.CookieDateParser$$ExternalSyntheticLambda5
            public final Object invoke() {
                String parse$lambda$6;
                parse$lambda$6 = CookieDateParser.parse$lambda$6();
                return parse$lambda$6;
            }
        });
        Integer hours = builder.getHours();
        Intrinsics.checkNotNull(hours);
        checkRequirement(source, hours.intValue() <= 23, new Function0() { // from class: io.ktor.http.CookieDateParser$$ExternalSyntheticLambda6
            public final Object invoke() {
                String parse$lambda$7;
                parse$lambda$7 = CookieDateParser.parse$lambda$7();
                return parse$lambda$7;
            }
        });
        Integer minutes = builder.getMinutes();
        Intrinsics.checkNotNull(minutes);
        checkRequirement(source, minutes.intValue() <= 59, new Function0() { // from class: io.ktor.http.CookieDateParser$$ExternalSyntheticLambda7
            public final Object invoke() {
                String parse$lambda$8;
                parse$lambda$8 = CookieDateParser.parse$lambda$8();
                return parse$lambda$8;
            }
        });
        Integer seconds = builder.getSeconds();
        Intrinsics.checkNotNull(seconds);
        checkRequirement(source, seconds.intValue() <= 59, new Function0() { // from class: io.ktor.http.CookieDateParser$$ExternalSyntheticLambda8
            public final Object invoke() {
                String parse$lambda$9;
                parse$lambda$9 = CookieDateParser.parse$lambda$9();
                return parse$lambda$9;
            }
        });
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$5() {
        return "day-of-month not in [1,31]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$6() {
        return "year >= 1601";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$7() {
        return "hours > 23";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$8() {
        return "minutes > 59";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$9() {
        return "seconds > 59";
    }
}