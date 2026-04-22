package io.ktor.http.parsing;

import kotlin.Metadata;

/* compiled from: Primitives.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\"\u0014\u0010\u0003\u001a\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0005\u001a\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0002\"\u0014\u0010\t\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0014\u0010\u000b\u001a\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0002\"\u0014\u0010\r\u001a\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0002\"\u0014\u0010\u000f\u001a\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0002\"\u0014\u0010\u0011\u001a\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0002¨\u0006\u0012"}, d2 = {"Lio/ktor/http/parsing/Grammar;", "getLowAlpha", "()Lio/ktor/http/parsing/Grammar;", "lowAlpha", "getAlpha", "alpha", "Lio/ktor/http/parsing/RawGrammar;", "getDigit", "()Lio/ktor/http/parsing/RawGrammar;", "digit", "getHex", "hex", "getAlphaDigit", "alphaDigit", "getAlphas", "alphas", "getDigits", "digits", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PrimitivesKt {
    public static final Grammar getLowAlpha() {
        return ParserDslKt.to('a', 'z');
    }

    public static final Grammar getAlpha() {
        return ParserDslKt.or(ParserDslKt.to('a', 'z'), ParserDslKt.to('A', 'Z'));
    }

    public static final RawGrammar getDigit() {
        return new RawGrammar("\\d");
    }

    public static final Grammar getHex() {
        return ParserDslKt.or(ParserDslKt.or(getDigit(), ParserDslKt.to('A', 'F')), ParserDslKt.to('a', 'f'));
    }

    public static final Grammar getAlphaDigit() {
        return ParserDslKt.or(getAlpha(), getDigit());
    }

    public static final Grammar getAlphas() {
        return ParserDslKt.atLeastOne(getAlpha());
    }

    public static final Grammar getDigits() {
        return ParserDslKt.atLeastOne(getDigit());
    }
}