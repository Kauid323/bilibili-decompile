package io.ktor.http.auth;

import com.tencent.smtt.sdk.TbsVideoCacheTask;
import external.org.apache.commons.lang3.ClassUtils;
import io.ktor.http.CookieUtilsKt;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.parsing.ParseException;
import io.ktor.utils.io.InternalAPI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: HttpAuthHeader.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0002¢\u0006\u0004\b\u0003\u0010\f\u001a7\u0010\u000f\u001a\u0004\u0018\u00010\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a3\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a3\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014\u001a\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0013\u0010\u0018\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a#\u0010\u001c\u001a\u00020\b*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001b\u0010\u001e\u001a\u00020\b*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u0017\u001a\u0013\u0010 \u001a\u00020\u001f*\u00020\u001aH\u0002¢\u0006\u0004\b \u0010!\u001a\u0013\u0010\"\u001a\u00020\u001f*\u00020\u001aH\u0002¢\u0006\u0004\b\"\u0010!\"\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%\"\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010%\"\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)\"\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010)¨\u0006+"}, d2 = {"", "headerValue", "Lio/ktor/http/auth/HttpAuthHeader;", "parseAuthorizationHeader", "(Ljava/lang/String;)Lio/ktor/http/auth/HttpAuthHeader;", "", "parseAuthorizationHeaders", "(Ljava/lang/String;)Ljava/util/List;", "", "startIndex", "", "headers", "(Ljava/lang/String;ILjava/util/List;)I", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "index", "nextChallengeIndex", "(Ljava/util/List;Lio/ktor/http/auth/HttpAuthHeader;ILjava/lang/String;)Ljava/lang/Integer;", "", "parameters", "matchParameters", "(Ljava/lang/String;ILjava/util/Map;)I", "matchParameter", "matchToken68", "(Ljava/lang/String;I)I", "unescaped", "(Ljava/lang/String;)Ljava/lang/String;", "", "delimiter", "skipDelimiter", "(Ljava/lang/String;IC)I", "skipSpaces", "", "isToken68", "(C)Z", "isToken", "", "TOKEN_EXTRA", "Ljava/util/Set;", "TOKEN68_EXTRA", "Lkotlin/text/Regex;", "token68Pattern", "Lkotlin/text/Regex;", "escapeRegex", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpAuthHeaderKt {
    private static final Set<Character> TOKEN68_EXTRA;
    private static final Set<Character> TOKEN_EXTRA;
    private static final Regex escapeRegex;
    private static final Regex token68Pattern;

    static {
        Character valueOf = Character.valueOf(ClassUtils.INNER_CLASS_SEPARATOR_CHAR);
        Character valueOf2 = Character.valueOf(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        TOKEN_EXTRA = SetsKt.setOf(new Character[]{'!', '#', valueOf, '%', '&', '\'', '*', '+', '-', valueOf2, '^', '_', '`', '|', '~'});
        TOKEN68_EXTRA = SetsKt.setOf(new Character[]{'-', valueOf2, '_', '~', '+', '/'});
        token68Pattern = new Regex("[a-zA-Z0-9\\-._~+/]+=*");
        escapeRegex = new Regex("\\\\.");
    }

    public static final HttpAuthHeader parseAuthorizationHeader(String headerValue) {
        Intrinsics.checkNotNullParameter(headerValue, "headerValue");
        int index = skipSpaces(headerValue, 0);
        while (index < headerValue.length() && isToken(headerValue.charAt(index))) {
            index++;
        }
        String authScheme = StringsKt.substring(headerValue, RangesKt.until(index, index));
        int index2 = skipSpaces(headerValue, index);
        if (StringsKt.isBlank(authScheme)) {
            return null;
        }
        if (headerValue.length() == index2) {
            return new HttpAuthHeader.Parameterized(authScheme, CollectionsKt.emptyList(), (HeaderValueEncoding) null, 4, (DefaultConstructorMarker) null);
        }
        int token68EndIndex = matchToken68(headerValue, index2);
        String token68 = StringsKt.trim(StringsKt.substring(headerValue, RangesKt.until(index2, token68EndIndex))).toString();
        if ((token68.length() > 0) && token68EndIndex == headerValue.length()) {
            return new HttpAuthHeader.Single(authScheme, token68);
        }
        Map parameters = new LinkedHashMap();
        int endIndex = matchParameters(headerValue, index2, parameters);
        if (endIndex == -1) {
            return new HttpAuthHeader.Parameterized(authScheme, parameters, (HeaderValueEncoding) null, 4, (DefaultConstructorMarker) null);
        }
        throw new ParseException("Function parseAuthorizationHeader can parse only one header", null, 2, null);
    }

    @InternalAPI
    public static final List<HttpAuthHeader> parseAuthorizationHeaders(String headerValue) {
        Intrinsics.checkNotNullParameter(headerValue, "headerValue");
        int index = 0;
        List headers = new ArrayList();
        while (index != -1) {
            index = parseAuthorizationHeader(headerValue, index, headers);
        }
        return headers;
    }

    private static final int parseAuthorizationHeader(String headerValue, int startIndex, List<HttpAuthHeader> list) {
        Integer nextChallengeIndex;
        int index = skipSpaces(headerValue, startIndex);
        while (index < headerValue.length() && isToken(headerValue.charAt(index))) {
            index++;
        }
        String authScheme = StringsKt.substring(headerValue, RangesKt.until(index, index));
        if (StringsKt.isBlank(authScheme)) {
            throw new ParseException("Invalid authScheme value: it should be token, can't be blank", null, 2, null);
        }
        int index2 = skipSpaces(headerValue, index);
        Integer nextChallengeIndex2 = nextChallengeIndex(list, new HttpAuthHeader.Parameterized(authScheme, CollectionsKt.emptyList(), (HeaderValueEncoding) null, 4, (DefaultConstructorMarker) null), index2, headerValue);
        if (nextChallengeIndex2 != null) {
            int it = nextChallengeIndex2.intValue();
            return it;
        }
        int token68EndIndex = matchToken68(headerValue, index2);
        String token68 = StringsKt.trim(StringsKt.substring(headerValue, RangesKt.until(index2, token68EndIndex))).toString();
        if ((token68.length() > 0) && (nextChallengeIndex = nextChallengeIndex(list, new HttpAuthHeader.Single(authScheme, token68), token68EndIndex, headerValue)) != null) {
            int it2 = nextChallengeIndex.intValue();
            return it2;
        }
        Map parameters = new LinkedHashMap();
        int nextIndexChallenge = matchParameters(headerValue, index2, parameters);
        list.add(new HttpAuthHeader.Parameterized(authScheme, parameters, (HeaderValueEncoding) null, 4, (DefaultConstructorMarker) null));
        return nextIndexChallenge;
    }

    private static final Integer nextChallengeIndex(List<HttpAuthHeader> list, HttpAuthHeader header, int index, String headerValue) {
        if (index == headerValue.length() || headerValue.charAt(index) == ',') {
            list.add(header);
            if (index == headerValue.length()) {
                return -1;
            }
            if (headerValue.charAt(index) == ',') {
                return Integer.valueOf(index + 1);
            }
            throw new IllegalStateException("".toString());
        }
        return null;
    }

    private static final int matchParameters(String headerValue, int startIndex, Map<String, String> map) {
        int index = startIndex;
        while (index > 0 && index < headerValue.length()) {
            int nextIndex = matchParameter(headerValue, index, map);
            if (nextIndex == index) {
                return index;
            }
            index = skipDelimiter(headerValue, nextIndex, ',');
        }
        return index;
    }

    private static final int matchParameter(String headerValue, int startIndex, Map<String, String> map) {
        int keyStart = skipSpaces(headerValue, startIndex);
        int index = keyStart;
        while (index < headerValue.length() && isToken(headerValue.charAt(index))) {
            index++;
        }
        String key = StringsKt.substring(headerValue, RangesKt.until(keyStart, index));
        int index2 = skipSpaces(headerValue, index);
        if (index2 == headerValue.length() || headerValue.charAt(index2) != '=') {
            return startIndex;
        }
        int index3 = skipSpaces(headerValue, index2 + 1);
        boolean quoted = false;
        int valueStart = index3;
        if (headerValue.charAt(index3) == '\"') {
            quoted = true;
            index3++;
            valueStart = index3;
            boolean escaped = false;
            while (index3 < headerValue.length() && (headerValue.charAt(index3) != '\"' || escaped)) {
                escaped = !escaped && headerValue.charAt(index3) == '\\';
                index3++;
            }
            if (index3 == headerValue.length()) {
                throw new ParseException("Expected closing quote'\"' in parameter", null, 2, null);
            }
        } else {
            while (index3 < headerValue.length() && headerValue.charAt(index3) != ' ' && headerValue.charAt(index3) != ',') {
                index3++;
            }
        }
        String value = StringsKt.substring(headerValue, RangesKt.until(valueStart, index3));
        map.put(key, quoted ? unescaped(value) : value);
        return quoted ? index3 + 1 : index3;
    }

    private static final int matchToken68(String headerValue, int startIndex) {
        int index = skipSpaces(headerValue, startIndex);
        while (index < headerValue.length() && isToken68(headerValue.charAt(index))) {
            index++;
        }
        while (index < headerValue.length() && headerValue.charAt(index) == '=') {
            index++;
        }
        return skipSpaces(headerValue, index);
    }

    private static final String unescaped(String $this$unescaped) {
        return escapeRegex.replace($this$unescaped, new Function1() { // from class: io.ktor.http.auth.HttpAuthHeaderKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence unescaped$lambda$2;
                unescaped$lambda$2 = HttpAuthHeaderKt.unescaped$lambda$2((MatchResult) obj);
                return unescaped$lambda$2;
            }
        });
    }

    public static final CharSequence unescaped$lambda$2(MatchResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.takeLast(it.getValue(), 1);
    }

    private static final int skipDelimiter(String $this$skipDelimiter, int startIndex, char delimiter) {
        int index = skipSpaces($this$skipDelimiter, startIndex);
        if (index == $this$skipDelimiter.length()) {
            return -1;
        }
        if ($this$skipDelimiter.charAt(index) != delimiter) {
            throw new ParseException("Expected delimiter " + delimiter + " at position " + index, null, 2, null);
        }
        return skipSpaces($this$skipDelimiter, index + 1);
    }

    private static final int skipSpaces(String $this$skipSpaces, int startIndex) {
        int index = startIndex;
        while (index < $this$skipSpaces.length() && $this$skipSpaces.charAt(index) == ' ') {
            index++;
        }
        return index;
    }

    private static final boolean isToken68(char $this$isToken68) {
        if ('a' <= $this$isToken68 && $this$isToken68 < '{') {
            return true;
        }
        return ('A' <= $this$isToken68 && $this$isToken68 < '[') || CookieUtilsKt.isDigit($this$isToken68) || TOKEN68_EXTRA.contains(Character.valueOf($this$isToken68));
    }

    private static final boolean isToken(char $this$isToken) {
        if ('a' <= $this$isToken && $this$isToken < '{') {
            return true;
        }
        return ('A' <= $this$isToken && $this$isToken < '[') || CookieUtilsKt.isDigit($this$isToken) || TOKEN_EXTRA.contains(Character.valueOf($this$isToken));
    }
}