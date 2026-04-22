package io.ktor.http;

import com.tencent.smtt.sdk.TbsVideoCacheTask;
import host.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HttpHeaderValueParser.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\b\u0010\u0005\u001a%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\b\u0010\u000b\u001a)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\r0\f¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0011*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001aE\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u001c\u0010\u001c\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u001aj\b\u0012\u0004\u0012\u00020\u0003`\u001b0\u00122\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001a=\u0010 \u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u001c\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\u001aj\b\u0012\u0004\u0012\u00020\u000e`\u001b0\u0012H\u0002¢\u0006\u0004\b \u0010!\u001a+\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00000\r2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b#\u0010$\u001a+\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00000\r2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b%\u0010$\u001a\u001b\u0010&\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "", "Lio/ktor/http/HeaderValue;", "parseAndSortHeader", "(Ljava/lang/String;)Ljava/util/List;", "parseAndSortContentTypeHeader", "text", "parseHeaderValue", "", "parametersOnly", "(Ljava/lang/String;Z)Ljava/util/List;", "", "Lkotlin/Pair;", "Lio/ktor/http/HeaderValueParam;", "toHeaderParamsList", "(Ljava/lang/Iterable;)Ljava/util/List;", "T", "Lkotlin/Lazy;", "valueOrEmpty", "(Lkotlin/Lazy;)Ljava/util/List;", "", "start", "end", "subtrim", "(Ljava/lang/String;II)Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "items", "parseHeaderValueItem", "(Ljava/lang/String;ILkotlin/Lazy;Z)I", "parameters", "parseHeaderValueParameter", "(Ljava/lang/String;ILkotlin/Lazy;)I", "value", "parseHeaderValueParameterValue", "(Ljava/lang/String;I)Lkotlin/Pair;", "parseHeaderValueParameterValueQuoted", "nextIsSemicolonOrEnd", "(Ljava/lang/String;I)Z", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpHeaderValueParserKt {
    public static final List<HeaderValue> parseAndSortHeader(String header) {
        Iterable $this$sortedByDescending$iv = parseHeaderValue(header);
        return CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseAndSortHeader$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                HeaderValue it = (HeaderValue) t2;
                HeaderValue it2 = (HeaderValue) t;
                return ComparisonsKt.compareValues(Double.valueOf(it.getQuality()), Double.valueOf(it2.getQuality()));
            }
        });
    }

    public static final List<HeaderValue> parseAndSortContentTypeHeader(String header) {
        final Comparator comparator = new Comparator() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$compareByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                HeaderValue it = (HeaderValue) t2;
                HeaderValue it2 = (HeaderValue) t;
                return ComparisonsKt.compareValues(Double.valueOf(it.getQuality()), Double.valueOf(it2.getQuality()));
            }
        };
        final Comparator comparator2 = new Comparator() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$thenBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = comparator.compare(t, t2);
                if (previousCompare != 0) {
                    return previousCompare;
                }
                HeaderValue it = (HeaderValue) t;
                ContentType contentType = ContentType.Companion.parse(it.getValue());
                int asterisks = 0;
                if (Intrinsics.areEqual(contentType.getContentType(), "*")) {
                    asterisks = 0 + 2;
                }
                if (Intrinsics.areEqual(contentType.getContentSubtype(), "*")) {
                    asterisks++;
                }
                Integer valueOf = Integer.valueOf(asterisks);
                HeaderValue it2 = (HeaderValue) t2;
                ContentType contentType2 = ContentType.Companion.parse(it2.getValue());
                int asterisks2 = 0;
                if (Intrinsics.areEqual(contentType2.getContentType(), "*")) {
                    asterisks2 = 0 + 2;
                }
                if (Intrinsics.areEqual(contentType2.getContentSubtype(), "*")) {
                    asterisks2++;
                }
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(asterisks2));
            }
        };
        return CollectionsKt.sortedWith(parseHeaderValue(header), new Comparator() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$thenByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = comparator2.compare(t, t2);
                if (previousCompare != 0) {
                    return previousCompare;
                }
                HeaderValue it = (HeaderValue) t2;
                HeaderValue it2 = (HeaderValue) t;
                return ComparisonsKt.compareValues(Integer.valueOf(it.getParams().size()), Integer.valueOf(it2.getParams().size()));
            }
        });
    }

    public static final List<HeaderValue> parseHeaderValue(String text) {
        return parseHeaderValue(text, false);
    }

    public static final List<HeaderValue> parseHeaderValue(String text, boolean parametersOnly) {
        if (text == null) {
            return CollectionsKt.emptyList();
        }
        int position = 0;
        Lazy items = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: io.ktor.http.HttpHeaderValueParserKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                ArrayList parseHeaderValue$lambda$4;
                parseHeaderValue$lambda$4 = HttpHeaderValueParserKt.parseHeaderValue$lambda$4();
                return parseHeaderValue$lambda$4;
            }
        });
        while (position <= StringsKt.getLastIndex(text)) {
            position = parseHeaderValueItem(text, position, items, parametersOnly);
        }
        return valueOrEmpty(items);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList parseHeaderValue$lambda$4() {
        return new ArrayList();
    }

    public static final List<HeaderValueParam> toHeaderParamsList(Iterable<Pair<String, String>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Pair item$iv$iv : iterable) {
            Pair it = item$iv$iv;
            destination$iv$iv.add(new HeaderValueParam((String) it.getFirst(), (String) it.getSecond()));
        }
        return (List) destination$iv$iv;
    }

    private static final <T> List<T> valueOrEmpty(Lazy<? extends List<? extends T>> lazy) {
        return lazy.isInitialized() ? (List) lazy.getValue() : CollectionsKt.emptyList();
    }

    private static final String subtrim(String $this$subtrim, int start, int end) {
        String substring = $this$subtrim.substring(start, end);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return StringsKt.trim(substring).toString();
    }

    private static final int parseHeaderValueItem(String text, int start, Lazy<? extends ArrayList<HeaderValue>> lazy, boolean parametersOnly) {
        int i2;
        int position = start;
        Lazy parameters = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: io.ktor.http.HttpHeaderValueParserKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                ArrayList parseHeaderValueItem$lambda$6;
                parseHeaderValueItem$lambda$6 = HttpHeaderValueParserKt.parseHeaderValueItem$lambda$6();
                return parseHeaderValueItem$lambda$6;
            }
        });
        Integer valueEnd = parametersOnly ? Integer.valueOf(position) : null;
        while (position <= StringsKt.getLastIndex(text)) {
            switch (text.charAt(position)) {
                case R.styleable.CameraView_cameraVideoCodec /* 44 */:
                    ((ArrayList) lazy.getValue()).add(new HeaderValue(subtrim(text, start, valueEnd != null ? valueEnd.intValue() : position), valueOrEmpty(parameters)));
                    return position + 1;
                case ';':
                    if (valueEnd == null) {
                        valueEnd = Integer.valueOf(position);
                    }
                    position = parseHeaderValueParameter(text, position + 1, parameters);
                    break;
                default:
                    if (parametersOnly) {
                        i2 = parseHeaderValueParameter(text, position, parameters);
                    } else {
                        i2 = position + 1;
                    }
                    position = i2;
                    break;
            }
        }
        ((ArrayList) lazy.getValue()).add(new HeaderValue(subtrim(text, start, valueEnd != null ? valueEnd.intValue() : position), valueOrEmpty(parameters)));
        return position;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList parseHeaderValueItem$lambda$6() {
        return new ArrayList();
    }

    private static final void parseHeaderValueParameter$addParam(Lazy<? extends ArrayList<HeaderValueParam>> lazy, String text, int start, int end, String value) {
        String name = subtrim(text, start, end);
        if (name.length() == 0) {
            return;
        }
        ((ArrayList) lazy.getValue()).add(new HeaderValueParam(name, value));
    }

    private static final int parseHeaderValueParameter(String text, int start, Lazy<? extends ArrayList<HeaderValueParam>> lazy) {
        int position = start;
        while (position <= StringsKt.getLastIndex(text)) {
            switch (text.charAt(position)) {
                case R.styleable.CameraView_cameraVideoCodec /* 44 */:
                case ';':
                    parseHeaderValueParameter$addParam(lazy, text, start, position, "");
                    return position;
                case '=':
                    Pair<Integer, String> parseHeaderValueParameterValue = parseHeaderValueParameterValue(text, position + 1);
                    int paramEnd = ((Number) parseHeaderValueParameterValue.component1()).intValue();
                    String paramValue = (String) parseHeaderValueParameterValue.component2();
                    parseHeaderValueParameter$addParam(lazy, text, start, position, paramValue);
                    return paramEnd;
                default:
                    position++;
            }
        }
        parseHeaderValueParameter$addParam(lazy, text, start, position, "");
        return position;
    }

    private static final Pair<Integer, String> parseHeaderValueParameterValue(String value, int start) {
        if (value.length() == start) {
            return TuplesKt.to(Integer.valueOf(start), "");
        }
        int position = start;
        if (value.charAt(start) == '\"') {
            return parseHeaderValueParameterValueQuoted(value, position + 1);
        }
        while (position <= StringsKt.getLastIndex(value)) {
            switch (value.charAt(position)) {
                case R.styleable.CameraView_cameraVideoCodec /* 44 */:
                case ';':
                    return TuplesKt.to(Integer.valueOf(position), subtrim(value, start, position));
                default:
                    position++;
            }
        }
        return TuplesKt.to(Integer.valueOf(position), subtrim(value, start, position));
    }

    private static final Pair<Integer, String> parseHeaderValueParameterValueQuoted(String value, int start) {
        int position = start;
        StringBuilder builder = new StringBuilder();
        while (position <= StringsKt.getLastIndex(value)) {
            char currentChar = value.charAt(position);
            if (currentChar == '\"' && nextIsSemicolonOrEnd(value, position)) {
                return TuplesKt.to(Integer.valueOf(position + 1), builder.toString());
            }
            if (currentChar == '\\' && position < StringsKt.getLastIndex(value) - 2) {
                builder.append(value.charAt(position + 1));
                position += 2;
            } else {
                builder.append(currentChar);
                position++;
            }
        }
        Integer valueOf = Integer.valueOf(position);
        String sb = builder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return TuplesKt.to(valueOf, '\"' + sb);
    }

    private static final boolean nextIsSemicolonOrEnd(String $this$nextIsSemicolonOrEnd, int start) {
        int position = start + 1;
        while (position < $this$nextIsSemicolonOrEnd.length() && $this$nextIsSemicolonOrEnd.charAt(position) == ' ') {
            position++;
        }
        return position == $this$nextIsSemicolonOrEnd.length() || $this$nextIsSemicolonOrEnd.charAt(position) == ';';
    }
}