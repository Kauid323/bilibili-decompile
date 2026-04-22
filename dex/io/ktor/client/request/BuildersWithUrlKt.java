package io.ktor.client.request;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: buildersWithUrl.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a7\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\f\u0010\n\u001a7\u0010\r\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\r\u0010\n\u001a7\u0010\u000e\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u000e\u0010\n\u001a7\u0010\u000f\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u000f\u0010\n\u001a7\u0010\u0010\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0010\u0010\n\u001a7\u0010\u0011\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0011\u0010\n\u001a7\u0010\u0012\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0012\u0010\n\u001a7\u0010\u0013\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0013\u0010\n\u001a7\u0010\u0014\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0014\u0010\n\u001a7\u0010\u0015\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0015\u0010\n\u001a7\u0010\u0016\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0016\u0010\n\u001a7\u0010\u0017\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0017\u0010\n\u001a7\u0010\u0018\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0018\u0010\n\u001a\u0019\u0010\u0002\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/client/HttpClient;", "Lio/ktor/http/Url;", "url", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lio/ktor/client/statement/HttpResponse;", "get", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Url;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpStatement;", "prepareGet", "post", "preparePost", "put", "preparePut", "patch", "preparePatch", "options", "prepareOptions", "head", "prepareHead", "delete", "prepareDelete", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/http/Url;)V", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BuildersWithUrlKt {
    public static /* synthetic */ Object get$default(HttpClient $this$get_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt$get$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getGet());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$get_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object get(HttpClient $this$get, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder$iv$iv, $this$get).execute(continuation);
    }

    private static final Object get$$forInline(HttpClient $this$get, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$get_u24lambda_u240 = httpRequestBuilder;
        URLUtilsKt.takeFrom($this$get_u24lambda_u240.getUrl(), url);
        function1.invoke($this$get_u24lambda_u240);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getGet());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$get);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object prepareGet$default(HttpClient $this$prepareGet_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt$prepareGet$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder$iv$iv, $this$prepareGet_u24default);
    }

    public static final Object prepareGet(HttpClient $this$prepareGet, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder$iv$iv, $this$prepareGet);
    }

    private static final Object prepareGet$$forInline(HttpClient $this$prepareGet, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$prepareGet_u24lambda_u241 = httpRequestBuilder;
        URLUtilsKt.takeFrom($this$prepareGet_u24lambda_u241.getUrl(), url);
        function1.invoke($this$prepareGet_u24lambda_u241);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder$iv$iv, $this$prepareGet);
    }

    public static /* synthetic */ Object post$default(HttpClient $this$post_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt$post$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPost());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$post_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object post(HttpClient $this$post, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder$iv$iv, $this$post).execute(continuation);
    }

    private static final Object post$$forInline(HttpClient $this$post, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$post_u24lambda_u242 = httpRequestBuilder;
        URLUtilsKt.takeFrom($this$post_u24lambda_u242.getUrl(), url);
        function1.invoke($this$post_u24lambda_u242);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getPost());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$post);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object preparePost$default(HttpClient $this$preparePost_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt$preparePost$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder$iv$iv, $this$preparePost_u24default);
    }

    public static final Object preparePost(HttpClient $this$preparePost, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder$iv$iv, $this$preparePost);
    }

    private static final Object preparePost$$forInline(HttpClient $this$preparePost, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$preparePost_u24lambda_u243 = httpRequestBuilder;
        URLUtilsKt.takeFrom($this$preparePost_u24lambda_u243.getUrl(), url);
        function1.invoke($this$preparePost_u24lambda_u243);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder$iv$iv, $this$preparePost);
    }

    public static /* synthetic */ Object put$default(HttpClient $this$put_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt$put$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPut());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$put_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object put(HttpClient $this$put, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder$iv$iv, $this$put).execute(continuation);
    }

    private static final Object put$$forInline(HttpClient $this$put, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$put_u24lambda_u244 = httpRequestBuilder;
        URLUtilsKt.takeFrom($this$put_u24lambda_u244.getUrl(), url);
        function1.invoke($this$put_u24lambda_u244);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getPut());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$put);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object preparePut$default(HttpClient $this$preparePut_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt$preparePut$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder$iv$iv, $this$preparePut_u24default);
    }

    public static final Object preparePut(HttpClient $this$preparePut, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder$iv$iv, $this$preparePut);
    }

    private static final Object preparePut$$forInline(HttpClient $this$preparePut, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$preparePut_u24lambda_u245 = httpRequestBuilder;
        URLUtilsKt.takeFrom($this$preparePut_u24lambda_u245.getUrl(), url);
        function1.invoke($this$preparePut_u24lambda_u245);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder$iv$iv, $this$preparePut);
    }

    public static /* synthetic */ Object patch$default(HttpClient $this$patch_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt$patch$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$patch_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object patch(HttpClient $this$patch, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder$iv$iv, $this$patch).execute(continuation);
    }

    private static final Object patch$$forInline(HttpClient $this$patch, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$patch_u24lambda_u246 = httpRequestBuilder;
        URLUtilsKt.takeFrom($this$patch_u24lambda_u246.getUrl(), url);
        function1.invoke($this$patch_u24lambda_u246);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$patch);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object preparePatch$default(HttpClient $this$preparePatch_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt$preparePatch$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder$iv$iv, $this$preparePatch_u24default);
    }

    public static final Object preparePatch(HttpClient $this$preparePatch, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder$iv$iv, $this$preparePatch);
    }

    private static final Object preparePatch$$forInline(HttpClient $this$preparePatch, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$preparePatch_u24lambda_u247 = httpRequestBuilder;
        URLUtilsKt.takeFrom($this$preparePatch_u24lambda_u247.getUrl(), url);
        function1.invoke($this$preparePatch_u24lambda_u247);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder$iv$iv, $this$preparePatch);
    }

    public static /* synthetic */ Object options$default(HttpClient $this$options_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt$options$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$options_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object options(HttpClient $this$options, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder$iv$iv, $this$options).execute(continuation);
    }

    private static final Object options$$forInline(HttpClient $this$options, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$options_u24lambda_u248 = httpRequestBuilder;
        URLUtilsKt.takeFrom($this$options_u24lambda_u248.getUrl(), url);
        function1.invoke($this$options_u24lambda_u248);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$options);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object prepareOptions$default(HttpClient $this$prepareOptions_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt$prepareOptions$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder$iv$iv, $this$prepareOptions_u24default);
    }

    public static final Object prepareOptions(HttpClient $this$prepareOptions, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder$iv$iv, $this$prepareOptions);
    }

    private static final Object prepareOptions$$forInline(HttpClient $this$prepareOptions, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$prepareOptions_u24lambda_u249 = httpRequestBuilder;
        URLUtilsKt.takeFrom($this$prepareOptions_u24lambda_u249.getUrl(), url);
        function1.invoke($this$prepareOptions_u24lambda_u249);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder$iv$iv, $this$prepareOptions);
    }

    public static /* synthetic */ Object head$default(HttpClient $this$head_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt$head$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getHead());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$head_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object head(HttpClient $this$head, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder$iv$iv, $this$head).execute(continuation);
    }

    private static final Object head$$forInline(HttpClient $this$head, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$head_u24lambda_u2410 = httpRequestBuilder;
        URLUtilsKt.takeFrom($this$head_u24lambda_u2410.getUrl(), url);
        function1.invoke($this$head_u24lambda_u2410);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getHead());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$head);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object prepareHead$default(HttpClient $this$prepareHead_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt$prepareHead$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder$iv$iv, $this$prepareHead_u24default);
    }

    public static final Object prepareHead(HttpClient $this$prepareHead, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder$iv$iv, $this$prepareHead);
    }

    private static final Object prepareHead$$forInline(HttpClient $this$prepareHead, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$prepareHead_u24lambda_u2411 = httpRequestBuilder;
        URLUtilsKt.takeFrom($this$prepareHead_u24lambda_u2411.getUrl(), url);
        function1.invoke($this$prepareHead_u24lambda_u2411);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder$iv$iv, $this$prepareHead);
    }

    public static /* synthetic */ Object delete$default(HttpClient $this$delete_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt$delete$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$delete_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object delete(HttpClient $this$delete, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder$iv$iv, $this$delete).execute(continuation);
    }

    private static final Object delete$$forInline(HttpClient $this$delete, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$delete_u24lambda_u2412 = httpRequestBuilder;
        URLUtilsKt.takeFrom($this$delete_u24lambda_u2412.getUrl(), url);
        function1.invoke($this$delete_u24lambda_u2412);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$delete);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object prepareDelete$default(HttpClient $this$prepareDelete_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt$prepareDelete$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder$iv$iv, $this$prepareDelete_u24default);
    }

    public static final Object prepareDelete(HttpClient $this$prepareDelete, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder$iv$iv, $this$prepareDelete);
    }

    private static final Object prepareDelete$$forInline(HttpClient $this$prepareDelete, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$prepareDelete_u24lambda_u2413 = httpRequestBuilder;
        URLUtilsKt.takeFrom($this$prepareDelete_u24lambda_u2413.getUrl(), url);
        function1.invoke($this$prepareDelete_u24lambda_u2413);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder$iv$iv, $this$prepareDelete);
    }

    public static final void url(HttpRequestBuilder $this$url, Url url) {
        Intrinsics.checkNotNullParameter($this$url, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        URLUtilsKt.takeFrom($this$url.getUrl(), url);
    }
}