package io.ktor.http;

import io.ktor.http.ContentDisposition;
import io.ktor.util.Base64Kt;
import io.ktor.util.TextKt;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: Cookie.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\f\u001a\u008d\u0001\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001d\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b \u0010\u001e\u001a\u0013\u0010!\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b!\u0010\"\u001a\u0013\u0010$\u001a\u00020\u0005*\u00020#H\u0002¢\u0006\u0004\b$\u0010%\u001a*\u0010'\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010&2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082\b¢\u0006\u0004\b'\u0010(\u001a\"\u0010)\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010&H\u0082\b¢\u0006\u0004\b)\u0010*\u001a \u0010+\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0005H\u0082\b¢\u0006\u0004\b+\u0010,\u001a\"\u0010-\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000H\u0082\b¢\u0006\u0004\b-\u0010.\u001a\u0013\u0010/\u001a\u00020\u0012*\u00020\u0000H\u0002¢\u0006\u0004\b/\u00100\"\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u0000018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103\"\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106\"\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020#018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00103¨\u00068"}, d2 = {"", "cookiesHeader", "Lio/ktor/http/Cookie;", "parseServerSetCookieHeader", "(Ljava/lang/String;)Lio/ktor/http/Cookie;", "", "skipEscaped", "", "parseClientCookiesHeader", "(Ljava/lang/String;Z)Ljava/util/Map;", "cookie", "renderSetCookieHeader", "(Lio/ktor/http/Cookie;)Ljava/lang/String;", "renderCookieHeader", ContentDisposition.Parameters.Name, "value", "Lio/ktor/http/CookieEncoding;", "encoding", "", "maxAge", "Lio/ktor/util/date/GMTDate;", "expires", "domain", "path", "secure", "httpOnly", "extensions", "includeEncoding", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/CookieEncoding;Ljava/lang/Integer;Lio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;Z)Ljava/lang/String;", "encodeCookieValue", "(Ljava/lang/String;Lio/ktor/http/CookieEncoding;)Ljava/lang/String;", "encodedValue", "decodeCookieValue", "assertCookieName", "(Ljava/lang/String;)Ljava/lang/String;", "", "shouldEscapeInCookies", "(C)Z", "", "cookiePart", "(Ljava/lang/String;Ljava/lang/Object;Lio/ktor/http/CookieEncoding;)Ljava/lang/String;", "cookiePartUnencoded", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;", "cookiePartFlag", "(Ljava/lang/String;Z)Ljava/lang/String;", "cookiePartExt", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "toIntClamping", "(Ljava/lang/String;)I", "", "loweredPartNames", "Ljava/util/Set;", "Lkotlin/text/Regex;", "clientCookieHeaderPattern", "Lkotlin/text/Regex;", "cookieCharsShouldBeEscaped", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CookieKt {
    private static final Set<String> loweredPartNames = SetsKt.setOf(new String[]{io.ktor.client.utils.CacheControl.MAX_AGE, "expires", "domain", "path", "secure", "httponly", "$x-enc"});
    private static final Regex clientCookieHeaderPattern = new Regex("(^|;)\\s*([^;=\\{\\}\\s]+)\\s*(=\\s*(\"[^\"]*\"|[^;]*))?");
    private static final Set<Character> cookieCharsShouldBeEscaped = SetsKt.setOf(new Character[]{';', ',', '\"'});

    /* compiled from: Cookie.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CookieEncoding.values().length];
            try {
                iArr[CookieEncoding.RAW.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CookieEncoding.DQUOTES.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[CookieEncoding.BASE64_ENCODING.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[CookieEncoding.URI_ENCODING.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Cookie parseServerSetCookieHeader(String cookiesHeader) {
        CookieEncoding encoding;
        Intrinsics.checkNotNullParameter(cookiesHeader, "cookiesHeader");
        boolean z = false;
        Map asMap = parseClientCookiesHeader(cookiesHeader, false);
        Iterable $this$first$iv = asMap.entrySet();
        for (Object element$iv : $this$first$iv) {
            if (!StringsKt.startsWith$default((String) ((Map.Entry) element$iv).getKey(), "$", z, 2, (Object) null)) {
                Map.Entry first = (Map.Entry) element$iv;
                String it = asMap.get("$x-enc");
                if (it == null || (encoding = CookieEncoding.valueOf(it)) == null) {
                    encoding = CookieEncoding.RAW;
                }
                Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity(asMap.size()));
                Iterable $this$associateByTo$iv$iv$iv = asMap.entrySet();
                for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
                    Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
                    destination$iv$iv.put(TextKt.toLowerCasePreservingASCIIRules((String) ((Map.Entry) element$iv$iv$iv).getKey()), it$iv$iv.getValue());
                }
                String str = (String) first.getKey();
                String decodeCookieValue = decodeCookieValue((String) first.getValue(), encoding);
                String str2 = (String) destination$iv$iv.get(io.ktor.client.utils.CacheControl.MAX_AGE);
                Integer valueOf = str2 != null ? Integer.valueOf(toIntClamping(str2)) : null;
                String str3 = (String) destination$iv$iv.get("expires");
                GMTDate fromCookieToGmtDate = str3 != null ? DateUtilsKt.fromCookieToGmtDate(str3) : null;
                String str4 = (String) destination$iv$iv.get("domain");
                String str5 = (String) destination$iv$iv.get("path");
                boolean containsKey = destination$iv$iv.containsKey("secure");
                boolean containsKey2 = destination$iv$iv.containsKey("httponly");
                LinkedHashMap result$iv = new LinkedHashMap();
                for (Map.Entry entry$iv : asMap.entrySet()) {
                    String it2 = entry$iv.getKey();
                    if ((loweredPartNames.contains(TextKt.toLowerCasePreservingASCIIRules(it2)) || Intrinsics.areEqual(it2, first.getKey())) ? false : true) {
                        result$iv.put(entry$iv.getKey(), entry$iv.getValue());
                    }
                }
                return new Cookie(str, decodeCookieValue, encoding, valueOf, fromCookieToGmtDate, str4, str5, containsKey, containsKey2, result$iv);
            }
            z = false;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static /* synthetic */ Map parseClientCookiesHeader$default(String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return parseClientCookiesHeader(str, z);
    }

    public static final Map<String, String> parseClientCookiesHeader(String cookiesHeader, final boolean skipEscaped) {
        Intrinsics.checkNotNullParameter(cookiesHeader, "cookiesHeader");
        return MapsKt.toMap(SequencesKt.map(SequencesKt.filter(SequencesKt.map(Regex.findAll$default(clientCookieHeaderPattern, cookiesHeader, 0, 2, (Object) null), new Function1() { // from class: io.ktor.http.CookieKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Pair parseClientCookiesHeader$lambda$4;
                parseClientCookiesHeader$lambda$4 = CookieKt.parseClientCookiesHeader$lambda$4((MatchResult) obj);
                return parseClientCookiesHeader$lambda$4;
            }
        }), new Function1() { // from class: io.ktor.http.CookieKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean parseClientCookiesHeader$lambda$5;
                parseClientCookiesHeader$lambda$5 = CookieKt.parseClientCookiesHeader$lambda$5(skipEscaped, (Pair) obj);
                return Boolean.valueOf(parseClientCookiesHeader$lambda$5);
            }
        }), new Function1() { // from class: io.ktor.http.CookieKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Pair parseClientCookiesHeader$lambda$6;
                parseClientCookiesHeader$lambda$6 = CookieKt.parseClientCookiesHeader$lambda$6((Pair) obj);
                return parseClientCookiesHeader$lambda$6;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair parseClientCookiesHeader$lambda$4(MatchResult it) {
        String value;
        Intrinsics.checkNotNullParameter(it, "it");
        MatchGroup matchGroup = it.getGroups().get(2);
        String str = "";
        String str2 = (matchGroup == null || (str2 = matchGroup.getValue()) == null) ? "" : "";
        MatchGroup matchGroup2 = it.getGroups().get(4);
        if (matchGroup2 != null && (value = matchGroup2.getValue()) != null) {
            str = value;
        }
        return TuplesKt.to(str2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseClientCookiesHeader$lambda$5(boolean $skipEscaped, Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ($skipEscaped && StringsKt.startsWith$default((String) it.getFirst(), "$", false, 2, (Object) null)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair parseClientCookiesHeader$lambda$6(Pair cookie) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        if (StringsKt.startsWith$default((String) cookie.getSecond(), "\"", false, 2, (Object) null) && StringsKt.endsWith$default((String) cookie.getSecond(), "\"", false, 2, (Object) null)) {
            return Pair.copy$default(cookie, (Object) null, StringsKt.removeSurrounding((String) cookie.getSecond(), "\""), 1, (Object) null);
        }
        return cookie;
    }

    public static final String renderSetCookieHeader(Cookie cookie) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        return renderSetCookieHeader$default(cookie.getName(), cookie.getValue(), cookie.getEncoding(), cookie.getMaxAgeInt(), cookie.getExpires(), cookie.getDomain(), cookie.getPath(), cookie.getSecure(), cookie.getHttpOnly(), cookie.getExtensions(), false, 1024, null);
    }

    public static final String renderCookieHeader(Cookie cookie) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        return cookie.getName() + '=' + encodeCookieValue(cookie.getValue(), cookie.getEncoding());
    }

    public static /* synthetic */ String renderSetCookieHeader$default(String str, String str2, CookieEncoding cookieEncoding, Integer num, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map map, boolean z3, int i2, Object obj) {
        return renderSetCookieHeader(str, str2, (i2 & 4) != 0 ? CookieEncoding.URI_ENCODING : cookieEncoding, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? null : gMTDate, (i2 & 32) != 0 ? null : str3, (i2 & 64) == 0 ? str4 : null, (i2 & 128) != 0 ? false : z, (i2 & 256) == 0 ? z2 : false, (i2 & 512) != 0 ? MapsKt.emptyMap() : map, (i2 & 1024) != 0 ? true : z3);
    }

    public static final String renderSetCookieHeader(String name, String value, CookieEncoding encoding, Integer maxAge, GMTDate expires, String domain, String path, boolean secure, boolean httpOnly, Map<String, String> map, boolean includeEncoding) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        Intrinsics.checkNotNullParameter(map, "extensions");
        String str7 = assertCookieName(name) + '=' + encodeCookieValue(value.toString(), encoding);
        String str8 = "";
        if (maxAge != null) {
            str = "Max-Age=" + maxAge;
        } else {
            str = "";
        }
        Object value$iv = expires != null ? DateUtilsKt.toHttpDate(expires) : null;
        String str9 = value$iv != null ? "Expires=" + value$iv : "";
        CookieEncoding encoding$iv = CookieEncoding.RAW;
        if (domain != null) {
            str2 = "Domain=" + encodeCookieValue(domain.toString(), encoding$iv);
        } else {
            str2 = "";
        }
        CookieEncoding encoding$iv2 = CookieEncoding.RAW;
        if (path != null) {
            str3 = "Path=" + encodeCookieValue(path.toString(), encoding$iv2);
        } else {
            str3 = "";
        }
        if (secure) {
            str4 = "Secure";
        } else {
            str4 = "";
        }
        if (httpOnly) {
            str5 = "HttpOnly";
        } else {
            str5 = "";
        }
        List listOf = CollectionsKt.listOf(new String[]{str7, str, str9, str2, str3, str4, str5});
        Collection destination$iv$iv = new ArrayList(map.size());
        for (Map.Entry item$iv$iv : map.entrySet()) {
            String name$iv = assertCookieName(item$iv$iv.getKey());
            String value$iv2 = item$iv$iv.getValue();
            if (value$iv2 != null) {
                CookieEncoding encoding$iv$iv = CookieEncoding.RAW;
                str6 = name$iv + '=' + encodeCookieValue(value$iv2.toString(), encoding$iv$iv);
            } else {
                str6 = name$iv;
            }
            destination$iv$iv.add(str6);
        }
        List plus = CollectionsKt.plus(listOf, (List) destination$iv$iv);
        if (includeEncoding) {
            String value$iv3 = encoding.name();
            if (value$iv3 != null) {
                CookieEncoding encoding$iv$iv2 = CookieEncoding.RAW;
                str8 = "$x-enc=" + encodeCookieValue(value$iv3.toString(), encoding$iv$iv2);
            } else {
                str8 = "$x-enc";
            }
        }
        Iterable $this$filter$iv = CollectionsKt.plus(plus, str8);
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            if (it.length() > 0) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv2, "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final String encodeCookieValue(String value, CookieEncoding encoding) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        boolean z = true;
        switch (WhenMappings.$EnumSwitchMapping$0[encoding.ordinal()]) {
            case 1:
                break;
            case 2:
                if (StringsKt.contains$default(value, '\"', false, 2, (Object) null)) {
                    throw new IllegalArgumentException("The cookie value contains characters that cannot be encoded in DQUOTES format. Consider URL_ENCODING mode");
                }
                String $this$any$iv = value;
                int i2 = 0;
                while (true) {
                    if (i2 < $this$any$iv.length()) {
                        char element$iv = $this$any$iv.charAt(i2);
                        if (!shouldEscapeInCookies(element$iv)) {
                            i2++;
                        }
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    return '\"' + value + '\"';
                }
                break;
            case 3:
                return Base64Kt.encodeBase64(value);
            case 4:
                return CodecsKt.encodeURLParameter(value, true);
            default:
                throw new NoWhenBranchMatchedException();
        }
        return value;
    }

    public static final String decodeCookieValue(String encodedValue, CookieEncoding encoding) {
        Intrinsics.checkNotNullParameter(encodedValue, "encodedValue");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        switch (WhenMappings.$EnumSwitchMapping$0[encoding.ordinal()]) {
            case 1:
            case 2:
                if (StringsKt.startsWith$default(StringsKt.trimStart(encodedValue).toString(), "\"", false, 2, (Object) null) && StringsKt.endsWith$default(StringsKt.trimEnd(encodedValue).toString(), "\"", false, 2, (Object) null)) {
                    return StringsKt.removeSurrounding(StringsKt.trim(encodedValue).toString(), "\"");
                }
                return encodedValue;
            case 3:
                return Base64Kt.decodeBase64String(encodedValue);
            case 4:
                return CodecsKt.decodeURLQueryComponent$default(encodedValue, 0, 0, true, null, 11, null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final String assertCookieName(String $this$assertCookieName) {
        String $this$any$iv = $this$assertCookieName;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= $this$any$iv.length()) {
                break;
            }
            char element$iv = $this$any$iv.charAt(i2);
            if (shouldEscapeInCookies(element$iv)) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            throw new IllegalArgumentException("Cookie name is not valid: " + $this$assertCookieName);
        }
        return $this$assertCookieName;
    }

    private static final boolean shouldEscapeInCookies(char $this$shouldEscapeInCookies) {
        return CharsKt.isWhitespace($this$shouldEscapeInCookies) || Intrinsics.compare($this$shouldEscapeInCookies, 32) < 0 || cookieCharsShouldBeEscaped.contains(Character.valueOf($this$shouldEscapeInCookies));
    }

    private static final String cookiePart(String name, Object value, CookieEncoding encoding) {
        return value != null ? name + '=' + encodeCookieValue(value.toString(), encoding) : "";
    }

    private static final String cookiePartUnencoded(String name, Object value) {
        return value != null ? name + '=' + value : "";
    }

    private static final String cookiePartFlag(String name, boolean value) {
        return value ? name : "";
    }

    private static final String cookiePartExt(String name, String value) {
        if (value != null) {
            CookieEncoding encoding$iv = CookieEncoding.RAW;
            return name + '=' + encodeCookieValue(value.toString(), encoding$iv);
        }
        return name;
    }

    private static final int toIntClamping(String $this$toIntClamping) {
        return (int) kotlin.ranges.RangesKt.coerceIn(Long.parseLong($this$toIntClamping), 0L, 2147483647L);
    }
}