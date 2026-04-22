package io.ktor.http;

import external.org.apache.commons.lang3.CharUtils;
import io.ktor.http.ContentDisposition;
import io.ktor.util.StringValuesBuilder;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HeaderValueWithParameters.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\f\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0001¢\u0006\u0004\b\b\u0010\t\u001a \u0010\r\u001a\u00020\u0005*\u00020\u00012\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0082\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u00020\u000f*\u00020\u0001H\u0002¢\u0006\u0004\b\u0012\u0010\u0011\u001a\u0011\u0010\u0013\u001a\u00020\u0001*\u00020\u0001¢\u0006\u0004\b\u0013\u0010\t\u001a\u001f\u0010\u0014\u001a\u00020\u0005*\u00020\u00012\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u000e\"\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/util/StringValuesBuilder;", "", ContentDisposition.Parameters.Name, "Lio/ktor/http/HeaderValueWithParameters;", "value", "", "append", "(Lio/ktor/util/StringValuesBuilder;Ljava/lang/String;Lio/ktor/http/HeaderValueWithParameters;)V", "escapeIfNeeded", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "escapeIfNeededTo", "(Ljava/lang/String;Ljava/lang/StringBuilder;)V", "", "needQuotes", "(Ljava/lang/String;)Z", "isQuoted", "quote", "quoteTo", "", "", "HeaderFieldValueSeparators", "Ljava/util/Set;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HeaderValueWithParametersKt {
    private static final Set<Character> HeaderFieldValueSeparators = SetsKt.setOf(new Character[]{'(', ')', '<', '>', '@', ',', ';', ':', '\\', '\"', '/', '[', ']', '?', '=', '{', '}', ' ', '\t', '\n', Character.valueOf(CharUtils.CR)});

    public static final /* synthetic */ boolean access$needQuotes(String $receiver) {
        return needQuotes($receiver);
    }

    public static final void append(StringValuesBuilder $this$append, String name, HeaderValueWithParameters value) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(value, "value");
        $this$append.append(name, value.toString());
    }

    public static final String escapeIfNeeded(String $this$escapeIfNeeded) {
        Intrinsics.checkNotNullParameter($this$escapeIfNeeded, "<this>");
        return needQuotes($this$escapeIfNeeded) ? quote($this$escapeIfNeeded) : $this$escapeIfNeeded;
    }

    private static final void escapeIfNeededTo(String $this$escapeIfNeededTo, StringBuilder out) {
        if (!needQuotes($this$escapeIfNeededTo)) {
            out.append($this$escapeIfNeededTo);
        } else {
            out.append(quote($this$escapeIfNeededTo));
        }
    }

    public static final boolean needQuotes(String $this$needQuotes) {
        if ($this$needQuotes.length() == 0) {
            return true;
        }
        if (isQuoted($this$needQuotes)) {
            return false;
        }
        int length = $this$needQuotes.length();
        for (int i2 = 0; i2 < length; i2++) {
            char element = $this$needQuotes.charAt(i2);
            if (HeaderFieldValueSeparators.contains(Character.valueOf(element))) {
                return true;
            }
        }
        return false;
    }

    private static final boolean isQuoted(String $this$isQuoted) {
        if ($this$isQuoted.length() >= 2 && StringsKt.first($this$isQuoted) == '\"' && StringsKt.last($this$isQuoted) == '\"') {
            int startIndex = 1;
            do {
                int index = StringsKt.indexOf$default($this$isQuoted, '\"', startIndex, false, 4, (Object) null);
                if (index != StringsKt.getLastIndex($this$isQuoted)) {
                    int slashesCount = 0;
                    for (int slashIndex = index - 1; $this$isQuoted.charAt(slashIndex) == '\\'; slashIndex--) {
                        slashesCount++;
                    }
                    if (slashesCount % 2 == 0) {
                        return false;
                    }
                    startIndex = index + 1;
                } else {
                    return true;
                }
            } while (startIndex < $this$isQuoted.length());
            return true;
        }
        return false;
    }

    public static final String quote(String $this$quote) {
        Intrinsics.checkNotNullParameter($this$quote, "<this>");
        StringBuilder $this$quote_u24lambda_u240 = new StringBuilder();
        quoteTo($this$quote, $this$quote_u24lambda_u240);
        String sb = $this$quote_u24lambda_u240.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    private static final void quoteTo(String $this$quoteTo, StringBuilder out) {
        out.append("\"");
        int length = $this$quoteTo.length();
        for (int i2 = 0; i2 < length; i2++) {
            char element = $this$quoteTo.charAt(i2);
            switch (element) {
                case '\t':
                    out.append("\\t");
                    break;
                case '\n':
                    out.append("\\n");
                    break;
                case '\r':
                    out.append("\\r");
                    break;
                case '\"':
                    out.append("\\\"");
                    break;
                case '\\':
                    out.append("\\\\");
                    break;
                default:
                    out.append(element);
                    break;
            }
        }
        out.append("\"");
    }
}