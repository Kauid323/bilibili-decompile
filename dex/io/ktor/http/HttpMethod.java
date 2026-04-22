package io.ktor.http;

import io.grpc.internal.GrpcUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpMethod.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0015"}, d2 = {"Lio/ktor/http/HttpMethod;", "", "", "value", "<init>", "(Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "copy", "(Ljava/lang/String;)Lio/ktor/http/HttpMethod;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getValue", "Companion", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpMethod {
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final HttpMethod Get = new HttpMethod("GET");
    private static final HttpMethod Post = new HttpMethod(GrpcUtil.HTTP_METHOD);
    private static final HttpMethod Put = new HttpMethod("PUT");
    private static final HttpMethod Patch = new HttpMethod("PATCH");
    private static final HttpMethod Delete = new HttpMethod("DELETE");
    private static final HttpMethod Head = new HttpMethod("HEAD");
    private static final HttpMethod Options = new HttpMethod("OPTIONS");
    private static final List<HttpMethod> DefaultMethods = CollectionsKt.listOf(new HttpMethod[]{Get, Post, Put, Patch, Delete, Head, Options});

    public static /* synthetic */ HttpMethod copy$default(HttpMethod httpMethod, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = httpMethod.value;
        }
        return httpMethod.copy(str);
    }

    public final String component1() {
        return this.value;
    }

    public final HttpMethod copy(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new HttpMethod(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HttpMethod) && Intrinsics.areEqual(this.value, ((HttpMethod) obj).value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "HttpMethod(value=" + this.value + ')';
    }

    /* compiled from: HttpMethod.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lio/ktor/http/HttpMethod$Companion;", "", "<init>", "()V", "", "method", "Lio/ktor/http/HttpMethod;", "parse", "(Ljava/lang/String;)Lio/ktor/http/HttpMethod;", "Get", "Lio/ktor/http/HttpMethod;", "getGet", "()Lio/ktor/http/HttpMethod;", "Post", "getPost", "Put", "getPut", "Patch", "getPatch", "Delete", "getDelete", "Head", "getHead", "Options", "getOptions", "", "DefaultMethods", "Ljava/util/List;", "getDefaultMethods", "()Ljava/util/List;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HttpMethod getGet() {
            return HttpMethod.Get;
        }

        public final HttpMethod getPost() {
            return HttpMethod.Post;
        }

        public final HttpMethod getPut() {
            return HttpMethod.Put;
        }

        public final HttpMethod getPatch() {
            return HttpMethod.Patch;
        }

        public final HttpMethod getDelete() {
            return HttpMethod.Delete;
        }

        public final HttpMethod getHead() {
            return HttpMethod.Head;
        }

        public final HttpMethod getOptions() {
            return HttpMethod.Options;
        }

        public final HttpMethod parse(String method) {
            Intrinsics.checkNotNullParameter(method, "method");
            return Intrinsics.areEqual(method, getGet().getValue()) ? getGet() : Intrinsics.areEqual(method, getPost().getValue()) ? getPost() : Intrinsics.areEqual(method, getPut().getValue()) ? getPut() : Intrinsics.areEqual(method, getPatch().getValue()) ? getPatch() : Intrinsics.areEqual(method, getDelete().getValue()) ? getDelete() : Intrinsics.areEqual(method, getHead().getValue()) ? getHead() : Intrinsics.areEqual(method, getOptions().getValue()) ? getOptions() : new HttpMethod(method);
        }

        public final List<HttpMethod> getDefaultMethods() {
            return HttpMethod.DefaultMethods;
        }
    }

    public HttpMethod(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public final String getValue() {
        return this.value;
    }
}