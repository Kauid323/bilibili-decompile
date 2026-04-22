package io.ktor.http;

import faceverify.q;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HeaderValueWithParameters.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lio/ktor/http/HeaderValueWithParameters;", "", "", q.KEY_RES_9_CONTENT, "", "Lio/ktor/http/HeaderValueParam;", "parameters", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", ContentDisposition.Parameters.Name, "parameter", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getContent", "Ljava/util/List;", "getParameters", "()Ljava/util/List;", "Companion", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class HeaderValueWithParameters {
    public static final Companion Companion = new Companion(null);
    private final String content;
    private final List<HeaderValueParam> parameters;

    public HeaderValueWithParameters(String content, List<HeaderValueParam> list) {
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        Intrinsics.checkNotNullParameter(list, "parameters");
        this.content = content;
        this.parameters = list;
    }

    public /* synthetic */ HeaderValueWithParameters(String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getContent() {
        return this.content;
    }

    public final List<HeaderValueParam> getParameters() {
        return this.parameters;
    }

    public final String parameter(String name) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        int index = 0;
        int lastIndex = CollectionsKt.getLastIndex(this.parameters);
        if (0 > lastIndex) {
            return null;
        }
        while (true) {
            HeaderValueParam parameter = this.parameters.get(index);
            if (!StringsKt.equals(parameter.getName(), name, true)) {
                if (index == lastIndex) {
                    return null;
                }
                index++;
            } else {
                return parameter.getValue();
            }
        }
    }

    public String toString() {
        if (this.parameters.isEmpty()) {
            return this.content;
        }
        int length = this.content.length();
        int i2 = 0;
        for (HeaderValueParam it : this.parameters) {
            i2 += it.getName().length() + it.getValue().length() + 3;
        }
        int size = length + i2;
        StringBuilder $this$toString_u24lambda_u241 = new StringBuilder(size);
        $this$toString_u24lambda_u241.append(this.content);
        int index = 0;
        int lastIndex = CollectionsKt.getLastIndex(this.parameters);
        if (0 <= lastIndex) {
            while (true) {
                HeaderValueParam element = this.parameters.get(index);
                $this$toString_u24lambda_u241.append("; ");
                $this$toString_u24lambda_u241.append(element.getName());
                $this$toString_u24lambda_u241.append("=");
                String $this$escapeIfNeededTo$iv = element.getValue();
                if (HeaderValueWithParametersKt.access$needQuotes($this$escapeIfNeededTo$iv)) {
                    $this$toString_u24lambda_u241.append(HeaderValueWithParametersKt.quote($this$escapeIfNeededTo$iv));
                } else {
                    $this$toString_u24lambda_u241.append($this$escapeIfNeededTo$iv);
                }
                if (index == lastIndex) {
                    break;
                }
                index++;
            }
        }
        String sb = $this$toString_u24lambda_u241.toString();
        Intrinsics.checkNotNull(sb);
        return sb;
    }

    /* compiled from: HeaderValueWithParameters.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lio/ktor/http/HeaderValueWithParameters$Companion;", "", "<init>", "()V", "R", "", "value", "Lkotlin/Function2;", "", "Lio/ktor/http/HeaderValueParam;", "init", "parse", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <R> R parse(String value, Function2<? super String, ? super List<HeaderValueParam>, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(function2, "init");
            HeaderValue headerValue = (HeaderValue) CollectionsKt.last(HttpHeaderValueParserKt.parseHeaderValue(value));
            return (R) function2.invoke(headerValue.getValue(), headerValue.getParams());
        }
    }
}