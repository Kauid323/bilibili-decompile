package io.ktor.http;

import com.tencent.open.log.TraceLevel;
import faceverify.q;
import host.R;
import io.ktor.util.CharsetKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: URLParser.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a3\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a+\u0010\r\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a+\u0010\u000f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0011\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u000e\u001a+\u0010\u0012\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u000e\u001a'\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a/\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u0019\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0014\u001a\u0013\u0010\u001b\u001a\u00020\u001a*\u00020\u0015H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\" \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lio/ktor/http/URLBuilder;", "", "urlString", "takeFrom", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;)Lio/ktor/http/URLBuilder;", "takeFromUnsafe", "", "startIndex", "endIndex", "slashCount", "", "parseFile", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;III)V", "parseMailto", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;II)V", "parseQuery", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;II)I", "parseFragment", "fillHost", "findScheme", "(Ljava/lang/String;II)I", "", "char", "count", "(Ljava/lang/String;IIC)I", "indexOfColonInHostPort", "", "isLetter", "(C)Z", "", "ROOT_PATH", "Ljava/util/List;", "getROOT_PATH", "()Ljava/util/List;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class URLParserKt {
    private static final List<String> ROOT_PATH = CollectionsKt.listOf("");

    public static final List<String> getROOT_PATH() {
        return ROOT_PATH;
    }

    public static final URLBuilder takeFrom(URLBuilder $this$takeFrom, String urlString) {
        Intrinsics.checkNotNullParameter($this$takeFrom, "<this>");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        if (StringsKt.isBlank(urlString)) {
            return $this$takeFrom;
        }
        try {
            return takeFromUnsafe($this$takeFrom, urlString);
        } catch (Throwable cause) {
            throw new URLParserException(urlString, cause);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final URLBuilder takeFromUnsafe(URLBuilder $this$takeFromUnsafe, String urlString) {
        int index$iv;
        List<String> emptyList;
        List<String> encodedPathSegments;
        int delimiter;
        Intrinsics.checkNotNullParameter($this$takeFromUnsafe, "<this>");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        String $this$indexOfFirst$iv = urlString;
        int index$iv2 = 0;
        int length = $this$indexOfFirst$iv.length();
        while (true) {
            if (index$iv2 < length) {
                char it = $this$indexOfFirst$iv.charAt(index$iv2);
                if (!CharsKt.isWhitespace(it)) {
                    break;
                }
                index$iv2++;
            } else {
                index$iv2 = -1;
                break;
            }
        }
        int startIndex = index$iv2;
        String $this$indexOfLast$iv = urlString;
        int length2 = $this$indexOfLast$iv.length() - 1;
        if (length2 >= 0) {
            do {
                index$iv = length2;
                length2--;
                char it2 = $this$indexOfLast$iv.charAt(index$iv);
                if (!CharsKt.isWhitespace(it2)) {
                    break;
                }
            } while (length2 >= 0);
            index$iv = -1;
        } else {
            index$iv = -1;
        }
        int endIndex = index$iv + 1;
        int schemeLength = findScheme(urlString, startIndex, endIndex);
        if (schemeLength > 0) {
            String scheme = urlString.substring(startIndex, startIndex + schemeLength);
            Intrinsics.checkNotNullExpressionValue(scheme, "substring(...)");
            $this$takeFromUnsafe.setProtocol(URLProtocol.Companion.createOrDefault(scheme));
            startIndex += schemeLength + 1;
        }
        int slashCount = count(urlString, startIndex, endIndex, '/');
        int startIndex2 = startIndex + slashCount;
        if (Intrinsics.areEqual($this$takeFromUnsafe.getProtocol().getName(), "file")) {
            parseFile($this$takeFromUnsafe, urlString, startIndex2, endIndex, slashCount);
            return $this$takeFromUnsafe;
        } else if (Intrinsics.areEqual($this$takeFromUnsafe.getProtocol().getName(), "mailto")) {
            if (!(slashCount == 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            parseMailto($this$takeFromUnsafe, urlString, startIndex2, endIndex);
            return $this$takeFromUnsafe;
        } else if (Intrinsics.areEqual($this$takeFromUnsafe.getProtocol().getName(), "about")) {
            if (!(slashCount == 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            String substring = urlString.substring(startIndex2, endIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            $this$takeFromUnsafe.setHost(substring);
            return $this$takeFromUnsafe;
        } else {
            if (slashCount >= 2) {
                while (true) {
                    Integer valueOf = Integer.valueOf(StringsKt.indexOfAny$default(urlString, CharsetKt.toCharArray("@/\\?#"), startIndex2, false, 4, (Object) null));
                    int it3 = valueOf.intValue();
                    int it4 = it3 > 0 ? 1 : 0;
                    if (it4 == 0) {
                        valueOf = null;
                    }
                    delimiter = valueOf != null ? valueOf.intValue() : endIndex;
                    if (delimiter >= endIndex || urlString.charAt(delimiter) != '@') {
                        break;
                    }
                    int passwordIndex = indexOfColonInHostPort(urlString, startIndex2, delimiter);
                    if (passwordIndex != -1) {
                        String substring2 = urlString.substring(startIndex2, passwordIndex);
                        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                        $this$takeFromUnsafe.setEncodedUser(substring2);
                        String substring3 = urlString.substring(passwordIndex + 1, delimiter);
                        Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                        $this$takeFromUnsafe.setEncodedPassword(substring3);
                    } else {
                        String substring4 = urlString.substring(startIndex2, delimiter);
                        Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
                        $this$takeFromUnsafe.setEncodedUser(substring4);
                    }
                    startIndex2 = delimiter + 1;
                }
                fillHost($this$takeFromUnsafe, urlString, startIndex2, delimiter);
                startIndex2 = delimiter;
            }
            if (startIndex2 >= endIndex) {
                $this$takeFromUnsafe.setEncodedPathSegments(urlString.charAt(endIndex + (-1)) == '/' ? ROOT_PATH : CollectionsKt.emptyList());
                return $this$takeFromUnsafe;
            }
            if (slashCount == 0) {
                emptyList = CollectionsKt.dropLast($this$takeFromUnsafe.getEncodedPathSegments(), 1);
            } else {
                emptyList = CollectionsKt.emptyList();
            }
            $this$takeFromUnsafe.setEncodedPathSegments(emptyList);
            Integer valueOf2 = Integer.valueOf(StringsKt.indexOfAny$default(urlString, CharsetKt.toCharArray("?#"), startIndex2, false, 4, (Object) null));
            int it5 = valueOf2.intValue();
            int it6 = it5 > 0 ? 1 : 0;
            Integer num = it6 != 0 ? valueOf2 : null;
            int pathEnd = num != null ? num.intValue() : endIndex;
            if (pathEnd > startIndex2) {
                String rawPath = urlString.substring(startIndex2, pathEnd);
                Intrinsics.checkNotNullExpressionValue(rawPath, "substring(...)");
                if ($this$takeFromUnsafe.getEncodedPathSegments().size() == 1) {
                    if (((CharSequence) CollectionsKt.first($this$takeFromUnsafe.getEncodedPathSegments())).length() == 0) {
                        encodedPathSegments = CollectionsKt.emptyList();
                        List relativePath = CollectionsKt.plus(slashCount != 1 ? ROOT_PATH : CollectionsKt.emptyList(), !Intrinsics.areEqual(rawPath, "/") ? ROOT_PATH : StringsKt.split$default(rawPath, new char[]{'/'}, false, 0, 6, (Object) null));
                        $this$takeFromUnsafe.setEncodedPathSegments(CollectionsKt.plus(encodedPathSegments, relativePath));
                        startIndex2 = pathEnd;
                    }
                }
                encodedPathSegments = $this$takeFromUnsafe.getEncodedPathSegments();
                if (!Intrinsics.areEqual(rawPath, "/")) {
                }
                List relativePath2 = CollectionsKt.plus(slashCount != 1 ? ROOT_PATH : CollectionsKt.emptyList(), !Intrinsics.areEqual(rawPath, "/") ? ROOT_PATH : StringsKt.split$default(rawPath, new char[]{'/'}, false, 0, 6, (Object) null));
                $this$takeFromUnsafe.setEncodedPathSegments(CollectionsKt.plus(encodedPathSegments, relativePath2));
                startIndex2 = pathEnd;
            }
            if (startIndex2 < endIndex && urlString.charAt(startIndex2) == '?') {
                startIndex2 = parseQuery($this$takeFromUnsafe, urlString, startIndex2, endIndex);
            }
            parseFragment($this$takeFromUnsafe, urlString, startIndex2, endIndex);
            return $this$takeFromUnsafe;
        }
    }

    private static final void parseFile(URLBuilder $this$parseFile, String urlString, int startIndex, int endIndex, int slashCount) {
        switch (slashCount) {
            case 2:
                int nextSlash = StringsKt.indexOf$default(urlString, '/', startIndex, false, 4, (Object) null);
                if (nextSlash == -1 || nextSlash == endIndex) {
                    String substring = urlString.substring(startIndex, endIndex);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    $this$parseFile.setHost(substring);
                    return;
                }
                String substring2 = urlString.substring(startIndex, nextSlash);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                $this$parseFile.setHost(substring2);
                String substring3 = urlString.substring(nextSlash, endIndex);
                Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                URLBuilderKt.setEncodedPath($this$parseFile, substring3);
                return;
            case 3:
                $this$parseFile.setHost("");
                StringBuilder append = new StringBuilder().append('/');
                String substring4 = urlString.substring(startIndex, endIndex);
                Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
                URLBuilderKt.setEncodedPath($this$parseFile, append.append(substring4).toString());
                return;
            default:
                throw new IllegalArgumentException("Invalid file url: " + urlString);
        }
    }

    private static final void parseMailto(URLBuilder $this$parseMailto, String urlString, int startIndex, int endIndex) {
        int delimiter = StringsKt.indexOf$default(urlString, "@", startIndex, false, 4, (Object) null);
        if (delimiter == -1) {
            throw new IllegalArgumentException("Invalid mailto url: " + urlString + ", it should contain '@'.");
        }
        String substring = urlString.substring(startIndex, delimiter);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        $this$parseMailto.setUser(CodecsKt.decodeURLPart$default(substring, 0, 0, null, 7, null));
        String substring2 = urlString.substring(delimiter + 1, endIndex);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        $this$parseMailto.setHost(substring2);
    }

    private static final int parseQuery(final URLBuilder $this$parseQuery, String urlString, int startIndex, int endIndex) {
        if (startIndex + 1 == endIndex) {
            $this$parseQuery.setTrailingQuery(true);
            return endIndex;
        }
        Integer valueOf = Integer.valueOf(StringsKt.indexOf$default(urlString, '#', startIndex + 1, false, 4, (Object) null));
        int it = valueOf.intValue();
        if (!(it > 0)) {
            valueOf = null;
        }
        int fragmentStart = valueOf != null ? valueOf.intValue() : endIndex;
        String substring = urlString.substring(startIndex + 1, fragmentStart);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        Parameters rawParameters = QueryKt.parseQueryString$default(substring, 0, 0, false, 6, null);
        rawParameters.forEach(new Function2() { // from class: io.ktor.http.URLParserKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit parseQuery$lambda$5;
                parseQuery$lambda$5 = URLParserKt.parseQuery$lambda$5(URLBuilder.this, (String) obj, (List) obj2);
                return parseQuery$lambda$5;
            }
        });
        return fragmentStart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit parseQuery$lambda$5(URLBuilder $this_parseQuery, String key, List values) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(values, "values");
        $this_parseQuery.getEncodedParameters().appendAll(key, values);
        return Unit.INSTANCE;
    }

    private static final void parseFragment(URLBuilder $this$parseFragment, String urlString, int startIndex, int endIndex) {
        if (startIndex < endIndex && urlString.charAt(startIndex) == '#') {
            String substring = urlString.substring(startIndex + 1, endIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            $this$parseFragment.setEncodedFragment(substring);
        }
    }

    private static final void fillHost(URLBuilder $this$fillHost, String urlString, int startIndex, int endIndex) {
        Integer valueOf = Integer.valueOf(indexOfColonInHostPort(urlString, startIndex, endIndex));
        int it = valueOf.intValue();
        int i2 = 0;
        if (!(it > 0)) {
            valueOf = null;
        }
        int colonIndex = valueOf != null ? valueOf.intValue() : endIndex;
        String substring = urlString.substring(startIndex, colonIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        $this$fillHost.setHost(substring);
        if (colonIndex + 1 < endIndex) {
            String substring2 = urlString.substring(colonIndex + 1, endIndex);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            i2 = Integer.parseInt(substring2);
        }
        $this$fillHost.setPort(i2);
    }

    private static final int findScheme(String urlString, int startIndex, int endIndex) {
        int current = startIndex;
        int incorrectSchemePosition = -1;
        char firstChar = urlString.charAt(current);
        if (!('a' <= firstChar && firstChar < '{')) {
            if (!('A' <= firstChar && firstChar < '[')) {
                incorrectSchemePosition = current;
            }
        }
        while (current < endIndex) {
            char charAt = urlString.charAt(current);
            if (charAt != ':') {
                switch (charAt) {
                    case '#':
                    case R.styleable.CameraView_cameraVideoSizeAspectRatio /* 47 */:
                    case TraceLevel.ALL /* 63 */:
                        return -1;
                    default:
                        if (incorrectSchemePosition == -1) {
                            if (!('a' <= charAt && charAt < '{')) {
                                if (!('A' <= charAt && charAt < '[')) {
                                    if (!('0' <= charAt && charAt < ':') && charAt != '.' && charAt != '+' && charAt != '-') {
                                        incorrectSchemePosition = current;
                                    }
                                }
                            }
                        }
                        current++;
                        break;
                }
            } else if (incorrectSchemePosition != -1) {
                throw new IllegalArgumentException("Illegal character in scheme at position " + incorrectSchemePosition);
            } else {
                return current - startIndex;
            }
        }
        return -1;
    }

    private static final int count(String urlString, int startIndex, int endIndex, char c) {
        int result = 0;
        while (startIndex + result < endIndex && urlString.charAt(startIndex + result) == c) {
            result++;
        }
        return result;
    }

    private static final int indexOfColonInHostPort(String $this$indexOfColonInHostPort, int startIndex, int endIndex) {
        boolean skip = false;
        for (int index = startIndex; index < endIndex; index++) {
            switch ($this$indexOfColonInHostPort.charAt(index)) {
                case ':':
                    if (skip) {
                        break;
                    } else {
                        return index;
                    }
                case '[':
                    skip = true;
                    break;
                case ']':
                    skip = false;
                    break;
            }
        }
        return -1;
    }

    private static final boolean isLetter(char $this$isLetter) {
        char lowerCase = Character.toLowerCase($this$isLetter);
        return 'a' <= lowerCase && lowerCase < '{';
    }
}