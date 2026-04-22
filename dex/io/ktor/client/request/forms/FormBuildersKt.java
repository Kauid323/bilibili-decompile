package io.ktor.client.request.forms;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.PartData;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: formBuilders.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\u000b\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086H¢\u0006\u0004\b\u000b\u0010\f\u001aK\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086@¢\u0006\u0004\b\u000b\u0010\u000f\u001a=\u0010\u0013\u001a\u00020\n*\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086H¢\u0006\u0004\b\u0013\u0010\u0014\u001aE\u0010\u0013\u001a\u00020\n*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086H¢\u0006\u0004\b\u0013\u0010\u0015\u001aC\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086H¢\u0006\u0004\b\u0017\u0010\f\u001aK\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086@¢\u0006\u0004\b\u0017\u0010\u000f\u001a=\u0010\u0018\u001a\u00020\u0016*\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0019\b\u0006\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086H¢\u0006\u0004\b\u0018\u0010\u0014\u001aE\u0010\u0018\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0019\b\u0006\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086H¢\u0006\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Lio/ktor/client/HttpClient;", "Lio/ktor/http/Parameters;", "formParameters", "", "encodeInQuery", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lio/ktor/client/statement/HttpResponse;", "submitForm", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Parameters;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "url", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lio/ktor/http/Parameters;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lio/ktor/http/content/PartData;", "formData", "submitFormWithBinaryData", "(Lio/ktor/client/HttpClient;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpStatement;", "prepareForm", "prepareFormWithBinaryData", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FormBuildersKt {
    public static /* synthetic */ Object submitForm$default(HttpClient $this$submitForm_u24default, Parameters formParameters, boolean encodeInQuery, Function1 block, Continuation $completion, int i2, Object obj) {
        Parameters formParameters2 = (i2 & 1) != 0 ? Parameters.Companion.getEmpty() : formParameters;
        boolean encodeInQuery2 = (i2 & 2) != 0 ? false : encodeInQuery;
        Function1 block2 = (i2 & 4) != 0 ? new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.forms.FormBuildersKt$submitForm$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((HttpRequestBuilder) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
            }
        } : block;
        HttpRequestBuilder $this$submitForm_u24lambda_u240 = new HttpRequestBuilder();
        if (encodeInQuery2) {
            $this$submitForm_u24lambda_u240.setMethod(HttpMethod.Companion.getGet());
            $this$submitForm_u24lambda_u240.getUrl().getParameters().appendAll(formParameters2);
        } else {
            $this$submitForm_u24lambda_u240.setMethod(HttpMethod.Companion.getPost());
            Object body$iv = new FormDataContent(formParameters2);
            KType kType = null;
            if (body$iv instanceof OutgoingContent) {
                $this$submitForm_u24lambda_u240.setBody(body$iv);
                $this$submitForm_u24lambda_u240.setBodyType(null);
            } else {
                $this$submitForm_u24lambda_u240.setBody(body$iv);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kType = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable th) {
                }
                $this$submitForm_u24lambda_u240.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
            }
        }
        block2.invoke($this$submitForm_u24lambda_u240);
        HttpStatement httpStatement = new HttpStatement($this$submitForm_u24lambda_u240, $this$submitForm_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object submitForm(HttpClient $this$submitForm, Parameters formParameters, boolean encodeInQuery, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder $this$submitForm_u24lambda_u240 = new HttpRequestBuilder();
        if (encodeInQuery) {
            $this$submitForm_u24lambda_u240.setMethod(HttpMethod.Companion.getGet());
            $this$submitForm_u24lambda_u240.getUrl().getParameters().appendAll(formParameters);
        } else {
            $this$submitForm_u24lambda_u240.setMethod(HttpMethod.Companion.getPost());
            Object body$iv = new FormDataContent(formParameters);
            KType kType = null;
            if (body$iv instanceof OutgoingContent) {
                $this$submitForm_u24lambda_u240.setBody(body$iv);
                $this$submitForm_u24lambda_u240.setBodyType(null);
            } else {
                $this$submitForm_u24lambda_u240.setBody(body$iv);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kType = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable th) {
                }
                $this$submitForm_u24lambda_u240.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
            }
        }
        function1.invoke($this$submitForm_u24lambda_u240);
        return new HttpStatement($this$submitForm_u24lambda_u240, $this$submitForm).execute(continuation);
    }

    private static final Object submitForm$$forInline(HttpClient $this$submitForm, Parameters formParameters, boolean encodeInQuery, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$submitForm_u24lambda_u240 = httpRequestBuilder;
        if (encodeInQuery) {
            $this$submitForm_u24lambda_u240.setMethod(HttpMethod.Companion.getGet());
            $this$submitForm_u24lambda_u240.getUrl().getParameters().appendAll(formParameters);
        } else {
            $this$submitForm_u24lambda_u240.setMethod(HttpMethod.Companion.getPost());
            Object body$iv = new FormDataContent(formParameters);
            KType kType = null;
            if (body$iv instanceof OutgoingContent) {
                $this$submitForm_u24lambda_u240.setBody(body$iv);
                $this$submitForm_u24lambda_u240.setBodyType(null);
            } else {
                $this$submitForm_u24lambda_u240.setBody(body$iv);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kType = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable th) {
                }
                $this$submitForm_u24lambda_u240.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
            }
        }
        function1.invoke($this$submitForm_u24lambda_u240);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$submitForm);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object submitForm$default(HttpClient httpClient, String str, Parameters parameters, boolean z, Function1 function1, Continuation continuation, int i2, Object obj) {
        return submitForm(httpClient, str, (i2 & 2) != 0 ? Parameters.Companion.getEmpty() : parameters, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? new Function1() { // from class: io.ktor.client.request.forms.FormBuildersKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj2) {
                Unit submitForm$lambda$1;
                submitForm$lambda$1 = FormBuildersKt.submitForm$lambda$1((HttpRequestBuilder) obj2);
                return submitForm$lambda$1;
            }
        } : function1, continuation);
    }

    public static final Unit submitForm$lambda$1(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object submitForm(HttpClient $this$submitForm, String url, Parameters formParameters, boolean encodeInQuery, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder $this$submitForm_u24lambda_u240$iv = new HttpRequestBuilder();
        if (encodeInQuery) {
            $this$submitForm_u24lambda_u240$iv.setMethod(HttpMethod.Companion.getGet());
            $this$submitForm_u24lambda_u240$iv.getUrl().getParameters().appendAll(formParameters);
        } else {
            $this$submitForm_u24lambda_u240$iv.setMethod(HttpMethod.Companion.getPost());
            Object body$iv$iv = new FormDataContent(formParameters);
            KType kType = null;
            if (body$iv$iv instanceof OutgoingContent) {
                $this$submitForm_u24lambda_u240$iv.setBody(body$iv$iv);
                $this$submitForm_u24lambda_u240$iv.setBodyType(null);
            } else {
                $this$submitForm_u24lambda_u240$iv.setBody(body$iv$iv);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kType = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable th) {
                }
                $this$submitForm_u24lambda_u240$iv.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
            }
        }
        HttpRequestKt.url($this$submitForm_u24lambda_u240$iv, url);
        function1.invoke($this$submitForm_u24lambda_u240$iv);
        return new HttpStatement($this$submitForm_u24lambda_u240$iv, $this$submitForm).execute(continuation);
    }

    public static /* synthetic */ Object submitFormWithBinaryData$default(HttpClient $this$submitFormWithBinaryData_u24default, List formData, Function1 block, Continuation $completion, int i2, Object obj) {
        Function1 block2;
        if ((i2 & 2) == 0) {
            block2 = block;
        } else {
            block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.forms.FormBuildersKt$submitFormWithBinaryData$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
        }
        HttpRequestBuilder $this$submitFormWithBinaryData_u24lambda_u243 = new HttpRequestBuilder();
        $this$submitFormWithBinaryData_u24lambda_u243.setMethod(HttpMethod.Companion.getPost());
        KType kType = null;
        Object body$iv = new MultiPartFormDataContent(formData, null, null, 6, null);
        if (body$iv instanceof OutgoingContent) {
            $this$submitFormWithBinaryData_u24lambda_u243.setBody(body$iv);
            $this$submitFormWithBinaryData_u24lambda_u243.setBodyType(null);
        } else {
            $this$submitFormWithBinaryData_u24lambda_u243.setBody(body$iv);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kType = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable th) {
            }
            $this$submitFormWithBinaryData_u24lambda_u243.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
        }
        block2.invoke($this$submitFormWithBinaryData_u24lambda_u243);
        HttpStatement httpStatement = new HttpStatement($this$submitFormWithBinaryData_u24lambda_u243, $this$submitFormWithBinaryData_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object submitFormWithBinaryData(HttpClient $this$submitFormWithBinaryData, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder $this$submitFormWithBinaryData_u24lambda_u243 = new HttpRequestBuilder();
        $this$submitFormWithBinaryData_u24lambda_u243.setMethod(HttpMethod.Companion.getPost());
        KType kType = null;
        Object body$iv = new MultiPartFormDataContent(list, null, null, 6, null);
        if (body$iv instanceof OutgoingContent) {
            $this$submitFormWithBinaryData_u24lambda_u243.setBody(body$iv);
            $this$submitFormWithBinaryData_u24lambda_u243.setBodyType(null);
        } else {
            $this$submitFormWithBinaryData_u24lambda_u243.setBody(body$iv);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kType = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable th) {
            }
            $this$submitFormWithBinaryData_u24lambda_u243.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
        }
        function1.invoke($this$submitFormWithBinaryData_u24lambda_u243);
        return new HttpStatement($this$submitFormWithBinaryData_u24lambda_u243, $this$submitFormWithBinaryData).execute(continuation);
    }

    private static final Object submitFormWithBinaryData$$forInline(HttpClient $this$submitFormWithBinaryData, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$submitFormWithBinaryData_u24lambda_u243 = httpRequestBuilder;
        $this$submitFormWithBinaryData_u24lambda_u243.setMethod(HttpMethod.Companion.getPost());
        Object body$iv = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kType = null;
        if (body$iv instanceof OutgoingContent) {
            $this$submitFormWithBinaryData_u24lambda_u243.setBody(body$iv);
            $this$submitFormWithBinaryData_u24lambda_u243.setBodyType(null);
        } else {
            $this$submitFormWithBinaryData_u24lambda_u243.setBody(body$iv);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kType = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable th) {
            }
            $this$submitFormWithBinaryData_u24lambda_u243.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
        }
        function1.invoke($this$submitFormWithBinaryData_u24lambda_u243);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$submitFormWithBinaryData);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object submitFormWithBinaryData$default(HttpClient $this$submitFormWithBinaryData_u24default, String url, List formData, Function1 block, Continuation $completion, int i2, Object obj) {
        Function1 block2;
        if ((i2 & 4) == 0) {
            block2 = block;
        } else {
            block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.forms.FormBuildersKt$submitFormWithBinaryData$5
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
        }
        HttpRequestBuilder $this$submitFormWithBinaryData_u24lambda_u243$iv = new HttpRequestBuilder();
        $this$submitFormWithBinaryData_u24lambda_u243$iv.setMethod(HttpMethod.Companion.getPost());
        KType kType = null;
        Object body$iv$iv = new MultiPartFormDataContent(formData, null, null, 6, null);
        if (body$iv$iv instanceof OutgoingContent) {
            $this$submitFormWithBinaryData_u24lambda_u243$iv.setBody(body$iv$iv);
            $this$submitFormWithBinaryData_u24lambda_u243$iv.setBodyType(null);
        } else {
            $this$submitFormWithBinaryData_u24lambda_u243$iv.setBody(body$iv$iv);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kType = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable th) {
            }
            $this$submitFormWithBinaryData_u24lambda_u243$iv.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
        }
        HttpRequestKt.url($this$submitFormWithBinaryData_u24lambda_u243$iv, url);
        block2.invoke($this$submitFormWithBinaryData_u24lambda_u243$iv);
        HttpStatement httpStatement = new HttpStatement($this$submitFormWithBinaryData_u24lambda_u243$iv, $this$submitFormWithBinaryData_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object submitFormWithBinaryData(HttpClient $this$submitFormWithBinaryData, String url, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder $this$submitFormWithBinaryData_u24lambda_u243$iv = new HttpRequestBuilder();
        $this$submitFormWithBinaryData_u24lambda_u243$iv.setMethod(HttpMethod.Companion.getPost());
        KType kType = null;
        Object body$iv$iv = new MultiPartFormDataContent(list, null, null, 6, null);
        if (body$iv$iv instanceof OutgoingContent) {
            $this$submitFormWithBinaryData_u24lambda_u243$iv.setBody(body$iv$iv);
            $this$submitFormWithBinaryData_u24lambda_u243$iv.setBodyType(null);
        } else {
            $this$submitFormWithBinaryData_u24lambda_u243$iv.setBody(body$iv$iv);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kType = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable th) {
            }
            $this$submitFormWithBinaryData_u24lambda_u243$iv.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
        }
        HttpRequestKt.url($this$submitFormWithBinaryData_u24lambda_u243$iv, url);
        function1.invoke($this$submitFormWithBinaryData_u24lambda_u243$iv);
        return new HttpStatement($this$submitFormWithBinaryData_u24lambda_u243$iv, $this$submitFormWithBinaryData).execute(continuation);
    }

    private static final Object submitFormWithBinaryData$$forInline(HttpClient $this$submitFormWithBinaryData, String url, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$submitFormWithBinaryData_u24lambda_u243$iv = httpRequestBuilder;
        $this$submitFormWithBinaryData_u24lambda_u243$iv.setMethod(HttpMethod.Companion.getPost());
        Object body$iv$iv = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kType = null;
        if (body$iv$iv instanceof OutgoingContent) {
            $this$submitFormWithBinaryData_u24lambda_u243$iv.setBody(body$iv$iv);
            $this$submitFormWithBinaryData_u24lambda_u243$iv.setBodyType(null);
        } else {
            $this$submitFormWithBinaryData_u24lambda_u243$iv.setBody(body$iv$iv);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kType = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable th) {
            }
            $this$submitFormWithBinaryData_u24lambda_u243$iv.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
        }
        HttpRequestBuilder $this$submitFormWithBinaryData_u24lambda_u244 = $this$submitFormWithBinaryData_u24lambda_u243$iv;
        HttpRequestKt.url($this$submitFormWithBinaryData_u24lambda_u244, url);
        function1.invoke($this$submitFormWithBinaryData_u24lambda_u244);
        Unit unit = Unit.INSTANCE;
        Unit unit2 = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv$iv = httpRequestBuilder;
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$submitFormWithBinaryData);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object prepareForm$default(HttpClient $this$prepareForm_u24default, Parameters formParameters, boolean encodeInQuery, Function1 block, Continuation $completion, int i2, Object obj) {
        Parameters formParameters2 = (i2 & 1) != 0 ? Parameters.Companion.getEmpty() : formParameters;
        boolean encodeInQuery2 = (i2 & 2) != 0 ? false : encodeInQuery;
        Function1 block2 = (i2 & 4) != 0 ? new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.forms.FormBuildersKt$prepareForm$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((HttpRequestBuilder) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
            }
        } : block;
        HttpRequestBuilder $this$prepareForm_u24lambda_u245 = new HttpRequestBuilder();
        if (encodeInQuery2) {
            $this$prepareForm_u24lambda_u245.setMethod(HttpMethod.Companion.getGet());
            $this$prepareForm_u24lambda_u245.getUrl().getParameters().appendAll(formParameters2);
        } else {
            $this$prepareForm_u24lambda_u245.setMethod(HttpMethod.Companion.getPost());
            Object body$iv = new FormDataContent(formParameters2);
            KType kType = null;
            if (body$iv instanceof OutgoingContent) {
                $this$prepareForm_u24lambda_u245.setBody(body$iv);
                $this$prepareForm_u24lambda_u245.setBodyType(null);
            } else {
                $this$prepareForm_u24lambda_u245.setBody(body$iv);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kType = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable th) {
                }
                $this$prepareForm_u24lambda_u245.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
            }
        }
        block2.invoke($this$prepareForm_u24lambda_u245);
        return new HttpStatement($this$prepareForm_u24lambda_u245, $this$prepareForm_u24default);
    }

    public static final Object prepareForm(HttpClient $this$prepareForm, Parameters formParameters, boolean encodeInQuery, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder $this$prepareForm_u24lambda_u245 = new HttpRequestBuilder();
        if (encodeInQuery) {
            $this$prepareForm_u24lambda_u245.setMethod(HttpMethod.Companion.getGet());
            $this$prepareForm_u24lambda_u245.getUrl().getParameters().appendAll(formParameters);
        } else {
            $this$prepareForm_u24lambda_u245.setMethod(HttpMethod.Companion.getPost());
            Object body$iv = new FormDataContent(formParameters);
            KType kType = null;
            if (body$iv instanceof OutgoingContent) {
                $this$prepareForm_u24lambda_u245.setBody(body$iv);
                $this$prepareForm_u24lambda_u245.setBodyType(null);
            } else {
                $this$prepareForm_u24lambda_u245.setBody(body$iv);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kType = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable th) {
                }
                $this$prepareForm_u24lambda_u245.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
            }
        }
        function1.invoke($this$prepareForm_u24lambda_u245);
        return new HttpStatement($this$prepareForm_u24lambda_u245, $this$prepareForm);
    }

    private static final Object prepareForm$$forInline(HttpClient $this$prepareForm, Parameters formParameters, boolean encodeInQuery, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$prepareForm_u24lambda_u245 = httpRequestBuilder;
        if (encodeInQuery) {
            $this$prepareForm_u24lambda_u245.setMethod(HttpMethod.Companion.getGet());
            $this$prepareForm_u24lambda_u245.getUrl().getParameters().appendAll(formParameters);
        } else {
            $this$prepareForm_u24lambda_u245.setMethod(HttpMethod.Companion.getPost());
            Object body$iv = new FormDataContent(formParameters);
            KType kType = null;
            if (body$iv instanceof OutgoingContent) {
                $this$prepareForm_u24lambda_u245.setBody(body$iv);
                $this$prepareForm_u24lambda_u245.setBodyType(null);
            } else {
                $this$prepareForm_u24lambda_u245.setBody(body$iv);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kType = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable th) {
                }
                $this$prepareForm_u24lambda_u245.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
            }
        }
        function1.invoke($this$prepareForm_u24lambda_u245);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        return new HttpStatement(builder$iv$iv, $this$prepareForm);
    }

    public static final Unit prepareForm$lambda$6(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object prepareForm(HttpClient $this$prepareForm, String url, Parameters formParameters, boolean encodeInQuery, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder $this$prepareForm_u24lambda_u245$iv = new HttpRequestBuilder();
        if (encodeInQuery) {
            $this$prepareForm_u24lambda_u245$iv.setMethod(HttpMethod.Companion.getGet());
            $this$prepareForm_u24lambda_u245$iv.getUrl().getParameters().appendAll(formParameters);
        } else {
            $this$prepareForm_u24lambda_u245$iv.setMethod(HttpMethod.Companion.getPost());
            Object body$iv$iv = new FormDataContent(formParameters);
            KType kType = null;
            if (body$iv$iv instanceof OutgoingContent) {
                $this$prepareForm_u24lambda_u245$iv.setBody(body$iv$iv);
                $this$prepareForm_u24lambda_u245$iv.setBodyType(null);
            } else {
                $this$prepareForm_u24lambda_u245$iv.setBody(body$iv$iv);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kType = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable th) {
                }
                $this$prepareForm_u24lambda_u245$iv.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
            }
        }
        HttpRequestKt.url($this$prepareForm_u24lambda_u245$iv, url);
        function1.invoke($this$prepareForm_u24lambda_u245$iv);
        return new HttpStatement($this$prepareForm_u24lambda_u245$iv, $this$prepareForm);
    }

    public static /* synthetic */ Object prepareFormWithBinaryData$default(HttpClient $this$prepareFormWithBinaryData_u24default, List formData, Function1 block, Continuation $completion, int i2, Object obj) {
        Function1 block2;
        if ((i2 & 2) == 0) {
            block2 = block;
        } else {
            block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.forms.FormBuildersKt$prepareFormWithBinaryData$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
        }
        HttpRequestBuilder $this$prepareFormWithBinaryData_u24lambda_u248 = new HttpRequestBuilder();
        $this$prepareFormWithBinaryData_u24lambda_u248.setMethod(HttpMethod.Companion.getPost());
        KType kType = null;
        Object body$iv = new MultiPartFormDataContent(formData, null, null, 6, null);
        if (body$iv instanceof OutgoingContent) {
            $this$prepareFormWithBinaryData_u24lambda_u248.setBody(body$iv);
            $this$prepareFormWithBinaryData_u24lambda_u248.setBodyType(null);
        } else {
            $this$prepareFormWithBinaryData_u24lambda_u248.setBody(body$iv);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kType = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable th) {
            }
            $this$prepareFormWithBinaryData_u24lambda_u248.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
        }
        block2.invoke($this$prepareFormWithBinaryData_u24lambda_u248);
        return new HttpStatement($this$prepareFormWithBinaryData_u24lambda_u248, $this$prepareFormWithBinaryData_u24default);
    }

    public static final Object prepareFormWithBinaryData(HttpClient $this$prepareFormWithBinaryData, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder $this$prepareFormWithBinaryData_u24lambda_u248 = new HttpRequestBuilder();
        $this$prepareFormWithBinaryData_u24lambda_u248.setMethod(HttpMethod.Companion.getPost());
        KType kType = null;
        Object body$iv = new MultiPartFormDataContent(list, null, null, 6, null);
        if (body$iv instanceof OutgoingContent) {
            $this$prepareFormWithBinaryData_u24lambda_u248.setBody(body$iv);
            $this$prepareFormWithBinaryData_u24lambda_u248.setBodyType(null);
        } else {
            $this$prepareFormWithBinaryData_u24lambda_u248.setBody(body$iv);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kType = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable th) {
            }
            $this$prepareFormWithBinaryData_u24lambda_u248.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
        }
        function1.invoke($this$prepareFormWithBinaryData_u24lambda_u248);
        return new HttpStatement($this$prepareFormWithBinaryData_u24lambda_u248, $this$prepareFormWithBinaryData);
    }

    private static final Object prepareFormWithBinaryData$$forInline(HttpClient $this$prepareFormWithBinaryData, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$prepareFormWithBinaryData_u24lambda_u248 = httpRequestBuilder;
        $this$prepareFormWithBinaryData_u24lambda_u248.setMethod(HttpMethod.Companion.getPost());
        Object body$iv = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kType = null;
        if (body$iv instanceof OutgoingContent) {
            $this$prepareFormWithBinaryData_u24lambda_u248.setBody(body$iv);
            $this$prepareFormWithBinaryData_u24lambda_u248.setBodyType(null);
        } else {
            $this$prepareFormWithBinaryData_u24lambda_u248.setBody(body$iv);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kType = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable th) {
            }
            $this$prepareFormWithBinaryData_u24lambda_u248.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
        }
        function1.invoke($this$prepareFormWithBinaryData_u24lambda_u248);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        return new HttpStatement(builder$iv$iv, $this$prepareFormWithBinaryData);
    }

    public static /* synthetic */ Object prepareFormWithBinaryData$default(HttpClient $this$prepareFormWithBinaryData_u24default, String url, List formData, Function1 block, Continuation $completion, int i2, Object obj) {
        Function1 block2;
        if ((i2 & 4) == 0) {
            block2 = block;
        } else {
            block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.forms.FormBuildersKt$prepareFormWithBinaryData$5
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
        }
        HttpRequestBuilder $this$prepareFormWithBinaryData_u24lambda_u248$iv = new HttpRequestBuilder();
        $this$prepareFormWithBinaryData_u24lambda_u248$iv.setMethod(HttpMethod.Companion.getPost());
        KType kType = null;
        Object body$iv$iv = new MultiPartFormDataContent(formData, null, null, 6, null);
        if (body$iv$iv instanceof OutgoingContent) {
            $this$prepareFormWithBinaryData_u24lambda_u248$iv.setBody(body$iv$iv);
            $this$prepareFormWithBinaryData_u24lambda_u248$iv.setBodyType(null);
        } else {
            $this$prepareFormWithBinaryData_u24lambda_u248$iv.setBody(body$iv$iv);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kType = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable th) {
            }
            $this$prepareFormWithBinaryData_u24lambda_u248$iv.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
        }
        HttpRequestKt.url($this$prepareFormWithBinaryData_u24lambda_u248$iv, url);
        block2.invoke($this$prepareFormWithBinaryData_u24lambda_u248$iv);
        return new HttpStatement($this$prepareFormWithBinaryData_u24lambda_u248$iv, $this$prepareFormWithBinaryData_u24default);
    }

    public static final Object prepareFormWithBinaryData(HttpClient $this$prepareFormWithBinaryData, String url, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder $this$prepareFormWithBinaryData_u24lambda_u248$iv = new HttpRequestBuilder();
        $this$prepareFormWithBinaryData_u24lambda_u248$iv.setMethod(HttpMethod.Companion.getPost());
        KType kType = null;
        Object body$iv$iv = new MultiPartFormDataContent(list, null, null, 6, null);
        if (body$iv$iv instanceof OutgoingContent) {
            $this$prepareFormWithBinaryData_u24lambda_u248$iv.setBody(body$iv$iv);
            $this$prepareFormWithBinaryData_u24lambda_u248$iv.setBodyType(null);
        } else {
            $this$prepareFormWithBinaryData_u24lambda_u248$iv.setBody(body$iv$iv);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kType = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable th) {
            }
            $this$prepareFormWithBinaryData_u24lambda_u248$iv.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
        }
        HttpRequestKt.url($this$prepareFormWithBinaryData_u24lambda_u248$iv, url);
        function1.invoke($this$prepareFormWithBinaryData_u24lambda_u248$iv);
        return new HttpStatement($this$prepareFormWithBinaryData_u24lambda_u248$iv, $this$prepareFormWithBinaryData);
    }

    private static final Object prepareFormWithBinaryData$$forInline(HttpClient $this$prepareFormWithBinaryData, String url, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$prepareFormWithBinaryData_u24lambda_u248$iv = httpRequestBuilder;
        $this$prepareFormWithBinaryData_u24lambda_u248$iv.setMethod(HttpMethod.Companion.getPost());
        Object body$iv$iv = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kType = null;
        if (body$iv$iv instanceof OutgoingContent) {
            $this$prepareFormWithBinaryData_u24lambda_u248$iv.setBody(body$iv$iv);
            $this$prepareFormWithBinaryData_u24lambda_u248$iv.setBodyType(null);
        } else {
            $this$prepareFormWithBinaryData_u24lambda_u248$iv.setBody(body$iv$iv);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kType = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable th) {
            }
            $this$prepareFormWithBinaryData_u24lambda_u248$iv.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
        }
        HttpRequestBuilder $this$prepareFormWithBinaryData_u24lambda_u249 = $this$prepareFormWithBinaryData_u24lambda_u248$iv;
        HttpRequestKt.url($this$prepareFormWithBinaryData_u24lambda_u249, url);
        function1.invoke($this$prepareFormWithBinaryData_u24lambda_u249);
        Unit unit = Unit.INSTANCE;
        Unit unit2 = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv$iv = httpRequestBuilder;
        return new HttpStatement(builder$iv$iv$iv, $this$prepareFormWithBinaryData);
    }
}