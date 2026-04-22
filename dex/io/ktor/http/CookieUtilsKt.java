package io.ktor.http;

import io.ktor.util.date.Month;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CookieUtils.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0013\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a%\u0010\u000b\u001a\u00020\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a7\u0010\u0011\u001a\u00020\t*\u00020\r2\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000eH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a+\u0010\u0015\u001a\u00020\t*\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u0013H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a+\u0010\u0017\u001a\u00020\t*\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0013H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0016\u001a+\u0010\u0018\u001a\u00020\t*\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0013H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u001b\u0010\u001b\u001a\u00020\t*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"", "", "isDelimiter", "(C)Z", "isNonDelimiter", "isOctet", "isNonDigit", "isDigit", "Lkotlin/Function0;", "", "block", "otherwise", "(ZLkotlin/jvm/functions/Function0;)V", "", "Lkotlin/Function3;", "", "success", "tryParseTime", "(Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/Function1;", "Lio/ktor/util/date/Month;", "tryParseMonth", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "tryParseDayOfMonth", "tryParseYear", "Lio/ktor/http/CookieDateBuilder;", "token", "handleToken", "(Lio/ktor/http/CookieDateBuilder;Ljava/lang/String;)V", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CookieUtilsKt {
    public static final boolean isDelimiter(char $this$isDelimiter) {
        if ($this$isDelimiter != '\t') {
            if (' ' <= $this$isDelimiter && $this$isDelimiter < '0') {
                return true;
            }
            if (';' <= $this$isDelimiter && $this$isDelimiter < 'A') {
                return true;
            }
            if ('[' <= $this$isDelimiter && $this$isDelimiter < 'a') {
                return true;
            }
            return '{' <= $this$isDelimiter && $this$isDelimiter < 127;
        }
        return true;
    }

    public static final boolean isNonDelimiter(char $this$isNonDelimiter) {
        if ($this$isNonDelimiter >= 0 && $this$isNonDelimiter < '\t') {
            return true;
        }
        if ('\n' <= $this$isNonDelimiter && $this$isNonDelimiter < ' ') {
            return true;
        }
        if (('0' <= $this$isNonDelimiter && $this$isNonDelimiter < ':') || $this$isNonDelimiter == ':') {
            return true;
        }
        if ('a' <= $this$isNonDelimiter && $this$isNonDelimiter < '{') {
            return true;
        }
        if ('A' <= $this$isNonDelimiter && $this$isNonDelimiter < '[') {
            return true;
        }
        return 127 <= $this$isNonDelimiter && $this$isNonDelimiter < 256;
    }

    public static final boolean isOctet(char $this$isOctet) {
        return $this$isOctet >= 0 && $this$isOctet < 256;
    }

    public static final boolean isNonDigit(char $this$isNonDigit) {
        if ($this$isNonDigit >= 0 && $this$isNonDigit < '0') {
            return true;
        }
        return 'J' <= $this$isNonDigit && $this$isNonDigit < 256;
    }

    public static final boolean isDigit(char $this$isDigit) {
        return '0' <= $this$isDigit && $this$isDigit < ':';
    }

    public static final void otherwise(boolean $this$otherwise, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (!$this$otherwise) {
            function0.invoke();
        }
    }

    public static final void tryParseTime(String $this$tryParseTime, Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter($this$tryParseTime, "<this>");
        Intrinsics.checkNotNullParameter(function3, "success");
        StringLexer lexer = new StringLexer($this$tryParseTime);
        int start$iv = lexer.getIndex();
        boolean $this$otherwise$iv = lexer.accept(CookieUtilsKt$tryParseTime$hour$1$1.INSTANCE);
        if (!$this$otherwise$iv) {
            return;
        }
        lexer.accept(CookieUtilsKt$tryParseTime$hour$1$3.INSTANCE);
        String substring = lexer.getSource().substring(start$iv, lexer.getIndex());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        int hour = Integer.parseInt(substring);
        boolean $this$otherwise$iv2 = lexer.accept(CookieUtilsKt$tryParseTime$1.INSTANCE);
        if (!$this$otherwise$iv2) {
            return;
        }
        int start$iv2 = lexer.getIndex();
        boolean $this$otherwise$iv3 = lexer.accept(CookieUtilsKt$tryParseTime$minute$1$1.INSTANCE);
        if (!$this$otherwise$iv3) {
            return;
        }
        lexer.accept(CookieUtilsKt$tryParseTime$minute$1$3.INSTANCE);
        String substring2 = lexer.getSource().substring(start$iv2, lexer.getIndex());
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        int minute = Integer.parseInt(substring2);
        boolean $this$otherwise$iv4 = lexer.accept(CookieUtilsKt$tryParseTime$3.INSTANCE);
        if (!$this$otherwise$iv4) {
            return;
        }
        int start$iv3 = lexer.getIndex();
        boolean $this$otherwise$iv5 = lexer.accept(CookieUtilsKt$tryParseTime$second$1$1.INSTANCE);
        if (!$this$otherwise$iv5) {
            return;
        }
        lexer.accept(CookieUtilsKt$tryParseTime$second$1$3.INSTANCE);
        String substring3 = lexer.getSource().substring(start$iv3, lexer.getIndex());
        Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
        int second = Integer.parseInt(substring3);
        if (lexer.accept(CookieUtilsKt$tryParseTime$5.INSTANCE)) {
            lexer.acceptWhile(CookieUtilsKt$tryParseTime$6.INSTANCE);
        }
        function3.invoke(Integer.valueOf(hour), Integer.valueOf(minute), Integer.valueOf(second));
    }

    public static final void tryParseMonth(String $this$tryParseMonth, Function1<? super Month, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$tryParseMonth, "<this>");
        Intrinsics.checkNotNullParameter(function1, "success");
        if ($this$tryParseMonth.length() < 3) {
            return;
        }
        for (Month month : Month.getEntries()) {
            if (StringsKt.startsWith($this$tryParseMonth, month.getValue(), true)) {
                function1.invoke(month);
                return;
            }
        }
    }

    public static final void tryParseDayOfMonth(String $this$tryParseDayOfMonth, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$tryParseDayOfMonth, "<this>");
        Intrinsics.checkNotNullParameter(function1, "success");
        StringLexer lexer = new StringLexer($this$tryParseDayOfMonth);
        int start$iv = lexer.getIndex();
        boolean $this$otherwise$iv = lexer.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$1.INSTANCE);
        if (!$this$otherwise$iv) {
            return;
        }
        lexer.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$3.INSTANCE);
        String substring = lexer.getSource().substring(start$iv, lexer.getIndex());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        int day = Integer.parseInt(substring);
        if (lexer.accept(CookieUtilsKt$tryParseDayOfMonth$1.INSTANCE)) {
            lexer.acceptWhile(CookieUtilsKt$tryParseDayOfMonth$2.INSTANCE);
        }
        function1.invoke(Integer.valueOf(day));
    }

    public static final void tryParseYear(String $this$tryParseYear, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$tryParseYear, "<this>");
        Intrinsics.checkNotNullParameter(function1, "success");
        StringLexer lexer = new StringLexer($this$tryParseYear);
        int start$iv = lexer.getIndex();
        for (int i2 = 0; i2 < 2; i2++) {
            boolean $this$otherwise$iv = lexer.accept(CookieUtilsKt$tryParseYear$year$1$1$1.INSTANCE);
            if (!$this$otherwise$iv) {
                return;
            }
        }
        for (int i3 = 0; i3 < 2; i3++) {
            lexer.accept(CookieUtilsKt$tryParseYear$year$1$2$1.INSTANCE);
        }
        String substring = lexer.getSource().substring(start$iv, lexer.getIndex());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        int year = Integer.parseInt(substring);
        if (lexer.accept(CookieUtilsKt$tryParseYear$1.INSTANCE)) {
            lexer.acceptWhile(CookieUtilsKt$tryParseYear$2.INSTANCE);
        }
        function1.invoke(Integer.valueOf(year));
    }

    public static final void handleToken(CookieDateBuilder $this$handleToken, String token) {
        Intrinsics.checkNotNullParameter($this$handleToken, "<this>");
        Intrinsics.checkNotNullParameter(token, "token");
        if ($this$handleToken.getHours() == null || $this$handleToken.getMinutes() == null || $this$handleToken.getSeconds() == null) {
            StringLexer lexer$iv = new StringLexer(token);
            int start$iv$iv = lexer$iv.getIndex();
            boolean $this$otherwise$iv$iv = lexer$iv.accept(CookieUtilsKt$tryParseTime$hour$1$1.INSTANCE);
            if ($this$otherwise$iv$iv) {
                lexer$iv.accept(CookieUtilsKt$tryParseTime$hour$1$3.INSTANCE);
                String substring = lexer$iv.getSource().substring(start$iv$iv, lexer$iv.getIndex());
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                int hour$iv = Integer.parseInt(substring);
                boolean $this$otherwise$iv$iv2 = lexer$iv.accept(CookieUtilsKt$tryParseTime$1.INSTANCE);
                if ($this$otherwise$iv$iv2) {
                    int start$iv$iv2 = lexer$iv.getIndex();
                    boolean $this$otherwise$iv$iv3 = lexer$iv.accept(CookieUtilsKt$tryParseTime$minute$1$1.INSTANCE);
                    if ($this$otherwise$iv$iv3) {
                        lexer$iv.accept(CookieUtilsKt$tryParseTime$minute$1$3.INSTANCE);
                        String substring2 = lexer$iv.getSource().substring(start$iv$iv2, lexer$iv.getIndex());
                        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                        int minute$iv = Integer.parseInt(substring2);
                        boolean $this$otherwise$iv$iv4 = lexer$iv.accept(CookieUtilsKt$tryParseTime$3.INSTANCE);
                        if ($this$otherwise$iv$iv4) {
                            int start$iv$iv3 = lexer$iv.getIndex();
                            boolean $this$otherwise$iv$iv5 = lexer$iv.accept(CookieUtilsKt$tryParseTime$second$1$1.INSTANCE);
                            if ($this$otherwise$iv$iv5) {
                                lexer$iv.accept(CookieUtilsKt$tryParseTime$second$1$3.INSTANCE);
                                String substring3 = lexer$iv.getSource().substring(start$iv$iv3, lexer$iv.getIndex());
                                Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                                int second$iv = Integer.parseInt(substring3);
                                if (lexer$iv.accept(CookieUtilsKt$tryParseTime$5.INSTANCE)) {
                                    lexer$iv.acceptWhile(CookieUtilsKt$tryParseTime$6.INSTANCE);
                                }
                                $this$handleToken.setHours(Integer.valueOf(hour$iv));
                                $this$handleToken.setMinutes(Integer.valueOf(minute$iv));
                                $this$handleToken.setSeconds(Integer.valueOf(second$iv));
                                return;
                            }
                        }
                    }
                }
            }
        }
        if ($this$handleToken.getDayOfMonth() == null) {
            StringLexer lexer$iv2 = new StringLexer(token);
            int start$iv$iv4 = lexer$iv2.getIndex();
            boolean $this$otherwise$iv$iv6 = lexer$iv2.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$1.INSTANCE);
            if ($this$otherwise$iv$iv6) {
                lexer$iv2.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$3.INSTANCE);
                String substring4 = lexer$iv2.getSource().substring(start$iv$iv4, lexer$iv2.getIndex());
                Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
                int day$iv = Integer.parseInt(substring4);
                if (lexer$iv2.accept(CookieUtilsKt$tryParseDayOfMonth$1.INSTANCE)) {
                    lexer$iv2.acceptWhile(CookieUtilsKt$tryParseDayOfMonth$2.INSTANCE);
                }
                $this$handleToken.setDayOfMonth(Integer.valueOf(day$iv));
                return;
            }
        }
        if ($this$handleToken.getMonth() == null && token.length() >= 3) {
            for (Month month$iv : Month.getEntries()) {
                if (StringsKt.startsWith(token, month$iv.getValue(), true)) {
                    $this$handleToken.setMonth(month$iv);
                    return;
                }
            }
        }
        if ($this$handleToken.getYear() == null) {
            StringLexer lexer$iv3 = new StringLexer(token);
            int start$iv$iv5 = lexer$iv3.getIndex();
            for (int i2 = 0; i2 < 2; i2++) {
                boolean $this$otherwise$iv$iv7 = lexer$iv3.accept(CookieUtilsKt$tryParseYear$year$1$1$1.INSTANCE);
                if (!$this$otherwise$iv$iv7) {
                    return;
                }
            }
            for (int i3 = 0; i3 < 2; i3++) {
                lexer$iv3.accept(CookieUtilsKt$tryParseYear$year$1$2$1.INSTANCE);
            }
            String substring5 = lexer$iv3.getSource().substring(start$iv$iv5, lexer$iv3.getIndex());
            Intrinsics.checkNotNullExpressionValue(substring5, "substring(...)");
            int year$iv = Integer.parseInt(substring5);
            if (lexer$iv3.accept(CookieUtilsKt$tryParseYear$1.INSTANCE)) {
                lexer$iv3.acceptWhile(CookieUtilsKt$tryParseYear$2.INSTANCE);
            }
            $this$handleToken.setYear(Integer.valueOf(year$iv));
        }
    }
}