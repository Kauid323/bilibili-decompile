package io.ktor.client.request;

import com.tencent.open.SocialConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsJvmKt;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: buildersJvm.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u001a7\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\u000b\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\u000b\u0010\n\u001a7\u0010\f\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\f\u0010\n\u001a7\u0010\r\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\r\u0010\n\u001a7\u0010\u000e\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\u000e\u0010\n\u001a7\u0010\u000f\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\u000f\u0010\n\u001a7\u0010\u0010\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\u0010\u0010\n\u001a7\u0010\u0011\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\u0011\u0010\n\u001a7\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\u0013\u0010\n\u001a7\u0010\u0014\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\u0014\u0010\n\u001a7\u0010\u0015\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\u0015\u0010\n\u001a7\u0010\u0016\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\u0016\u0010\n\u001a7\u0010\u0017\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\u0017\u0010\n\u001a7\u0010\u0018\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\u0018\u0010\n\u001a7\u0010\u0019\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\u0019\u0010\n\u001a7\u0010\u001a\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086@¢\u0006\u0004\b\u001a\u0010\n¨\u0006\u001b"}, d2 = {"Lio/ktor/client/HttpClient;", "Ljava/net/URL;", "url", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lio/ktor/client/statement/HttpResponse;", SocialConstants.TYPE_REQUEST, "(Lio/ktor/client/HttpClient;Ljava/net/URL;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "post", "put", "patch", "options", "head", "delete", "Lio/ktor/client/statement/HttpStatement;", "prepareRequest", "prepareGet", "preparePost", "preparePut", "preparePatch", "prepareOptions", "prepareHead", "prepareDelete", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BuildersJvmKt {
    public static /* synthetic */ Object request$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj2) {
                    Unit request$lambda$0;
                    request$lambda$0 = BuildersJvmKt.request$lambda$0((HttpRequestBuilder) obj2);
                    return request$lambda$0;
                }
            };
        }
        return request(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit request$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object request(HttpClient $this$request, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder $this$request_u24lambda_u241 = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom($this$request_u24lambda_u241.getUrl(), url);
        function1.invoke($this$request_u24lambda_u241);
        return new HttpStatement($this$request_u24lambda_u241, $this$request).execute(continuation);
    }

    public static /* synthetic */ Object get$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj2) {
                    Unit unit;
                    unit = BuildersJvmKt.get$lambda$2((HttpRequestBuilder) obj2);
                    return unit;
                }
            };
        }
        return get(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit get$lambda$2(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object get(HttpClient $this$get, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder$iv$iv, $this$get).execute(continuation);
    }

    public static /* synthetic */ Object post$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj2) {
                    Unit post$lambda$4;
                    post$lambda$4 = BuildersJvmKt.post$lambda$4((HttpRequestBuilder) obj2);
                    return post$lambda$4;
                }
            };
        }
        return post(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit post$lambda$4(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object post(HttpClient $this$post, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder$iv$iv, $this$post).execute(continuation);
    }

    public static /* synthetic */ Object put$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj2) {
                    Unit put$lambda$6;
                    put$lambda$6 = BuildersJvmKt.put$lambda$6((HttpRequestBuilder) obj2);
                    return put$lambda$6;
                }
            };
        }
        return put(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit put$lambda$6(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object put(HttpClient $this$put, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder$iv$iv, $this$put).execute(continuation);
    }

    public static /* synthetic */ Object patch$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj2) {
                    Unit patch$lambda$8;
                    patch$lambda$8 = BuildersJvmKt.patch$lambda$8((HttpRequestBuilder) obj2);
                    return patch$lambda$8;
                }
            };
        }
        return patch(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit patch$lambda$8(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object patch(HttpClient $this$patch, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder$iv$iv, $this$patch).execute(continuation);
    }

    public static /* synthetic */ Object options$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj2) {
                    Unit options$lambda$10;
                    options$lambda$10 = BuildersJvmKt.options$lambda$10((HttpRequestBuilder) obj2);
                    return options$lambda$10;
                }
            };
        }
        return options(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit options$lambda$10(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object options(HttpClient $this$options, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder$iv$iv, $this$options).execute(continuation);
    }

    public static /* synthetic */ Object head$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj2) {
                    Unit head$lambda$12;
                    head$lambda$12 = BuildersJvmKt.head$lambda$12((HttpRequestBuilder) obj2);
                    return head$lambda$12;
                }
            };
        }
        return head(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit head$lambda$12(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object head(HttpClient $this$head, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder$iv$iv, $this$head).execute(continuation);
    }

    public static /* synthetic */ Object delete$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    Unit delete$lambda$14;
                    delete$lambda$14 = BuildersJvmKt.delete$lambda$14((HttpRequestBuilder) obj2);
                    return delete$lambda$14;
                }
            };
        }
        return delete(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit delete$lambda$14(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object delete(HttpClient $this$delete, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder$iv$iv, $this$delete).execute(continuation);
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj2) {
                    Unit prepareRequest$lambda$16;
                    prepareRequest$lambda$16 = BuildersJvmKt.prepareRequest$lambda$16((HttpRequestBuilder) obj2);
                    return prepareRequest$lambda$16;
                }
            };
        }
        return prepareRequest(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepareRequest$lambda$16(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object prepareRequest(HttpClient $this$prepareRequest, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder $this$prepareRequest_u24lambda_u2417 = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom($this$prepareRequest_u24lambda_u2417.getUrl(), url);
        function1.invoke($this$prepareRequest_u24lambda_u2417);
        return new HttpStatement($this$prepareRequest_u24lambda_u2417, $this$prepareRequest);
    }

    public static /* synthetic */ Object prepareGet$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj2) {
                    Unit prepareGet$lambda$18;
                    prepareGet$lambda$18 = BuildersJvmKt.prepareGet$lambda$18((HttpRequestBuilder) obj2);
                    return prepareGet$lambda$18;
                }
            };
        }
        return prepareGet(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepareGet$lambda$18(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object prepareGet(HttpClient $this$prepareGet, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder$iv$iv, $this$prepareGet);
    }

    public static /* synthetic */ Object preparePost$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj2) {
                    Unit preparePost$lambda$20;
                    preparePost$lambda$20 = BuildersJvmKt.preparePost$lambda$20((HttpRequestBuilder) obj2);
                    return preparePost$lambda$20;
                }
            };
        }
        return preparePost(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preparePost$lambda$20(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object preparePost(HttpClient $this$preparePost, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder$iv$iv, $this$preparePost);
    }

    public static /* synthetic */ Object preparePut$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj2) {
                    Unit preparePut$lambda$22;
                    preparePut$lambda$22 = BuildersJvmKt.preparePut$lambda$22((HttpRequestBuilder) obj2);
                    return preparePut$lambda$22;
                }
            };
        }
        return preparePut(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preparePut$lambda$22(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object preparePut(HttpClient $this$preparePut, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder$iv$iv, $this$preparePut);
    }

    public static /* synthetic */ Object preparePatch$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit preparePatch$lambda$24;
                    preparePatch$lambda$24 = BuildersJvmKt.preparePatch$lambda$24((HttpRequestBuilder) obj2);
                    return preparePatch$lambda$24;
                }
            };
        }
        return preparePatch(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preparePatch$lambda$24(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object preparePatch(HttpClient $this$preparePatch, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder$iv$iv, $this$preparePatch);
    }

    public static /* synthetic */ Object prepareOptions$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj2) {
                    Unit prepareOptions$lambda$26;
                    prepareOptions$lambda$26 = BuildersJvmKt.prepareOptions$lambda$26((HttpRequestBuilder) obj2);
                    return prepareOptions$lambda$26;
                }
            };
        }
        return prepareOptions(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepareOptions$lambda$26(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object prepareOptions(HttpClient $this$prepareOptions, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder$iv$iv, $this$prepareOptions);
    }

    public static /* synthetic */ Object prepareHead$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj2) {
                    Unit prepareHead$lambda$28;
                    prepareHead$lambda$28 = BuildersJvmKt.prepareHead$lambda$28((HttpRequestBuilder) obj2);
                    return prepareHead$lambda$28;
                }
            };
        }
        return prepareHead(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepareHead$lambda$28(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object prepareHead(HttpClient $this$prepareHead, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder$iv$iv, $this$prepareHead);
    }

    public static /* synthetic */ Object prepareDelete$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersJvmKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj2) {
                    Unit prepareDelete$lambda$30;
                    prepareDelete$lambda$30 = BuildersJvmKt.prepareDelete$lambda$30((HttpRequestBuilder) obj2);
                    return prepareDelete$lambda$30;
                }
            };
        }
        return prepareDelete(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepareDelete$lambda$30(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object prepareDelete(HttpClient $this$prepareDelete, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(builder$iv$iv.getUrl(), url);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder$iv$iv, $this$prepareDelete);
    }
}