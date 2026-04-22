package io.ktor.http;

import io.ktor.http.Parameters;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: Query.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0005\u001a3\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a3\u0010\f\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0011\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"", "query", "", "startIndex", "limit", "", "decode", "Lio/ktor/http/Parameters;", "parseQueryString", "(Ljava/lang/String;IIZ)Lio/ktor/http/Parameters;", "Lio/ktor/http/ParametersBuilder;", "", "parse", "(Lio/ktor/http/ParametersBuilder;Ljava/lang/String;IIZ)V", "nameIndex", "equalIndex", "endIndex", "appendParam", "(Lio/ktor/http/ParametersBuilder;Ljava/lang/String;IIIZ)V", "start", "end", "", "text", "trimEnd", "(IILjava/lang/CharSequence;)I", "trimStart", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class QueryKt {
    public static /* synthetic */ Parameters parseQueryString$default(String str, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 1000;
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        return parseQueryString(str, i2, i3, z);
    }

    public static final Parameters parseQueryString(String query, int startIndex, int limit, boolean decode) {
        Intrinsics.checkNotNullParameter(query, "query");
        if (startIndex > StringsKt.getLastIndex(query)) {
            return Parameters.Companion.getEmpty();
        }
        Parameters.Companion companion = Parameters.Companion;
        ParametersBuilder $this$parseQueryString_u24lambda_u240 = ParametersKt.ParametersBuilder$default(0, 1, null);
        parse($this$parseQueryString_u24lambda_u240, query, startIndex, limit, decode);
        return $this$parseQueryString_u24lambda_u240.build();
    }

    private static final void parse(ParametersBuilder $this$parse, String query, int startIndex, int limit, boolean decode) {
        int count = 0;
        int nameIndex = startIndex;
        int equalIndex = -1;
        int index = startIndex;
        int lastIndex = StringsKt.getLastIndex(query);
        if (index <= lastIndex) {
            while (count != limit) {
                switch (query.charAt(index)) {
                    case '&':
                        appendParam($this$parse, query, nameIndex, equalIndex, index, decode);
                        nameIndex = index + 1;
                        equalIndex = -1;
                        count++;
                        break;
                    case '=':
                        if (equalIndex == -1) {
                            equalIndex = index;
                            break;
                        }
                        break;
                }
                if (index != lastIndex) {
                    index++;
                }
            }
            return;
        }
        int nameIndex2 = nameIndex;
        int equalIndex2 = equalIndex;
        if (count == limit) {
            return;
        }
        appendParam($this$parse, query, nameIndex2, equalIndex2, query.length(), decode);
    }

    private static final void appendParam(ParametersBuilder $this$appendParam, String query, int nameIndex, int equalIndex, int endIndex, boolean decode) {
        String substring;
        String value;
        String name;
        if (equalIndex == -1) {
            int spaceNameIndex = trimStart(nameIndex, endIndex, query);
            int spaceEndIndex = trimEnd(spaceNameIndex, endIndex, query);
            if (spaceEndIndex > spaceNameIndex) {
                if (decode) {
                    name = CodecsKt.decodeURLQueryComponent$default(query, spaceNameIndex, spaceEndIndex, false, null, 12, null);
                } else {
                    name = query.substring(spaceNameIndex, spaceEndIndex);
                    Intrinsics.checkNotNullExpressionValue(name, "substring(...)");
                }
                $this$appendParam.appendAll(name, CollectionsKt.emptyList());
                return;
            }
            return;
        }
        int spaceNameIndex2 = trimStart(nameIndex, equalIndex, query);
        int spaceEqualIndex = trimEnd(spaceNameIndex2, equalIndex, query);
        if (spaceEqualIndex > spaceNameIndex2) {
            if (decode) {
                substring = CodecsKt.decodeURLQueryComponent$default(query, spaceNameIndex2, spaceEqualIndex, false, null, 12, null);
            } else {
                substring = query.substring(spaceNameIndex2, spaceEqualIndex);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            }
            String name2 = substring;
            int spaceValueIndex = trimStart(equalIndex + 1, endIndex, query);
            int spaceEndIndex2 = trimEnd(spaceValueIndex, endIndex, query);
            if (decode) {
                value = CodecsKt.decodeURLQueryComponent$default(query, spaceValueIndex, spaceEndIndex2, true, null, 8, null);
            } else {
                value = query.substring(spaceValueIndex, spaceEndIndex2);
                Intrinsics.checkNotNullExpressionValue(value, "substring(...)");
            }
            $this$appendParam.append(name2, value);
        }
    }

    private static final int trimEnd(int start, int end, CharSequence text) {
        int spaceIndex = end;
        while (spaceIndex > start && CharsKt.isWhitespace(text.charAt(spaceIndex - 1))) {
            spaceIndex--;
        }
        return spaceIndex;
    }

    private static final int trimStart(int start, int end, CharSequence query) {
        int spaceIndex = start;
        while (spaceIndex < end && CharsKt.isWhitespace(query.charAt(spaceIndex))) {
            spaceIndex++;
        }
        return spaceIndex;
    }
}