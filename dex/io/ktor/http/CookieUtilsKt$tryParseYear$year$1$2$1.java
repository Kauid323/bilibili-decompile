package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: CookieUtils.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class CookieUtilsKt$tryParseYear$year$1$2$1 implements Function1<Character, Boolean> {
    public static final CookieUtilsKt$tryParseYear$year$1$2$1 INSTANCE = new CookieUtilsKt$tryParseYear$year$1$2$1();

    public final Boolean invoke(char it) {
        return Boolean.valueOf(CookieUtilsKt.isDigit(it));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Character) p1).charValue());
    }
}