package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: CookieUtils.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class CookieUtilsKt$tryParseDayOfMonth$2 implements Function1<Character, Boolean> {
    public static final CookieUtilsKt$tryParseDayOfMonth$2 INSTANCE = new CookieUtilsKt$tryParseDayOfMonth$2();

    public final Boolean invoke(char it) {
        return Boolean.valueOf(CookieUtilsKt.isOctet(it));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Character) p1).charValue());
    }
}