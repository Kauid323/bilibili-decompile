package kntr.app.ad.domain.report.internal.upload;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLParserException;
import io.ktor.http.URLParserKt;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.ad.common.model.CompressType;
import kntr.app.ad.domain.config.AdConfigKt;
import kntr.app.ad.domain.platformspec.AdPlatformSpec;
import kntr.app.ad.domain.report.internal.ReportExtraHandler;
import kntr.app.ad.domain.report.internal.ReportRecord;
import kntr.app.ad.domain.report.internal.ReportUtilKt;
import kntr.app.ad.domain.report.internal.ReportUtil_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.brotli.KBrotli;
import kntr.base.utils.foundation.Gzip_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: ReportUploader.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002JM\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fH\u0004JY\u0010\u0016\u001a\u00020\u00052\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u00122\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00192\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001bH\u0080@¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0005H\u0014¨\u0006 "}, d2 = {"Lkntr/app/ad/domain/report/internal/upload/ReportUploader;", "Lkntr/app/ad/domain/report/internal/upload/IReportUploader;", "<init>", "()V", "upload", RoomRecommendViewModel.EMPTY_CURSOR, "records", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/report/internal/ReportRecord;", "needRetry", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseToJson", "Lkotlinx/serialization/json/JsonObject;", "record", "buildRequest", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ExtensionFunctionType;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "startAction", "commit", "requestAction", "successAction", "Lkotlin/Function0;", "failureAction", "Lkotlin/Function2;", RoomRecommendViewModel.EMPTY_CURSOR, "commit$report_debug", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "watchBizCode", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ReportUploader implements IReportUploader {

    /* compiled from: ReportUploader.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CompressType.values().length];
            try {
                iArr[CompressType.BR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CompressType.GZIP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CompressType.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // kntr.app.ad.domain.report.internal.upload.IReportUploader
    public Object upload(List<ReportRecord> list, boolean z, Continuation<? super Boolean> continuation) {
        return upload$suspendImpl(this, list, z, continuation);
    }

    static /* synthetic */ Object upload$suspendImpl(ReportUploader $this, List<ReportRecord> list, boolean needRetry, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(false);
    }

    private final JsonObject parseToJson(ReportRecord record) {
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        JsonElementBuildersKt.put(builder$iv, "ts", record.getTs());
        JsonElementBuildersKt.put(builder$iv, "fail_count", Integer.valueOf(record.getRetryCount()));
        Function1<ReportExtraHandler, Unit> baseInfo = record.getBaseInfo();
        if (baseInfo != null) {
            baseInfo.invoke(new ReportExtraHandler(builder$iv));
        }
        Function1<ReportExtraHandler, Unit> adInfo = record.getAdInfo();
        if (adInfo != null) {
            adInfo.invoke(new ReportExtraHandler(builder$iv));
        }
        Function1<ReportExtraHandler, Unit> extraInfo = record.getExtraInfo();
        if (extraInfo != null) {
            extraInfo.invoke(new ReportExtraHandler(builder$iv));
        }
        return builder$iv.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Function1 buildRequest$default(ReportUploader reportUploader, String str, List list, Function1 function1, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                list = null;
            }
            if ((i & 4) != 0) {
                function1 = null;
            }
            return reportUploader.buildRequest(str, list, function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildRequest");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Function1<HttpRequestBuilder, Unit> buildRequest(final String url, final List<ReportRecord> list, final Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new Function1() { // from class: kntr.app.ad.domain.report.internal.upload.ReportUploader$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit buildRequest$lambda$0;
                buildRequest$lambda$0 = ReportUploader.buildRequest$lambda$0(list, function1, url, this, (HttpRequestBuilder) obj);
                return buildRequest$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fc, code lost:
        if ((r5.length == 0) != false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit buildRequest$lambda$0(List $records, Function1 $startAction, final String $url, ReportUploader this$0, HttpRequestBuilder httpRequestBuilder) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        List list = $records;
        if (list == null || list.isEmpty()) {
            if ($startAction != null) {
                $startAction.invoke($url);
            }
            httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
            HttpRequestKt.headers((HttpMessageBuilder) httpRequestBuilder, new Function1() { // from class: kntr.app.ad.domain.report.internal.upload.ReportUploader$$ExternalSyntheticLambda2
                public final Object invoke(Object obj3) {
                    Unit buildRequest$lambda$0$4;
                    buildRequest$lambda$0$4 = ReportUploader.buildRequest$lambda$0$4((HeadersBuilder) obj3);
                    return buildRequest$lambda$0$4;
                }
            });
        } else {
            byte[] requestBody = null;
            final Ref.ObjectRef contentEncoding = new Ref.ObjectRef();
            JsonObjectBuilder builder$iv = new JsonObjectBuilder();
            List $this$map$iv = $records;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                ReportRecord p0 = (ReportRecord) item$iv$iv;
                destination$iv$iv.add(this$0.parseToJson(p0));
            }
            builder$iv.put("uploads", new JsonArray((List) destination$iv$iv));
            String jsonString = builder$iv.build().toString();
            if ($startAction != null) {
                $startAction.invoke(jsonString);
            }
            KType kType = null;
            switch (WhenMappings.$EnumSwitchMapping$0[AdConfigKt.getHttpCompressType().ordinal()]) {
                case 1:
                    contentEncoding.element = "br";
                    try {
                        Result.Companion companion = Result.Companion;
                        obj = Result.constructor-impl(KBrotli.Companion.compress(StringsKt.toByteArray$default(jsonString, (Charset) null, 1, (Object) null)));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    requestBody = (byte[]) obj;
                    break;
                case 2:
                    contentEncoding.element = "gzip";
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj2 = Result.constructor-impl(Gzip_androidKt.zip(StringsKt.toByteArray$default(jsonString, (Charset) null, 1, (Object) null)));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    if (Result.isFailure-impl(obj2)) {
                        obj2 = null;
                    }
                    requestBody = (byte[]) obj2;
                    break;
                case 3:
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (requestBody != null) {
            }
            requestBody = StringsKt.toByteArray$default(jsonString, (Charset) null, 1, (Object) null);
            contentEncoding.element = null;
            httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
            HttpRequestKt.headers((HttpMessageBuilder) httpRequestBuilder, new Function1() { // from class: kntr.app.ad.domain.report.internal.upload.ReportUploader$$ExternalSyntheticLambda1
                public final Object invoke(Object obj3) {
                    Unit buildRequest$lambda$0$3;
                    buildRequest$lambda$0$3 = ReportUploader.buildRequest$lambda$0$3(contentEncoding, (HeadersBuilder) obj3);
                    return buildRequest$lambda$0$3;
                }
            });
            Object body$iv = requestBody;
            if (body$iv == null) {
                httpRequestBuilder.setBody(NullBody.INSTANCE);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(byte[].class);
                try {
                    kType = Reflection.typeOf(byte[].class);
                } catch (Throwable th3) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
            } else if (body$iv instanceof OutgoingContent) {
                httpRequestBuilder.setBody(body$iv);
                httpRequestBuilder.setBodyType((TypeInfo) null);
            } else {
                httpRequestBuilder.setBody(body$iv);
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(byte[].class);
                try {
                    kType = Reflection.typeOf(byte[].class);
                } catch (Throwable th4) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kType));
            }
        }
        httpRequestBuilder.url(new Function2() { // from class: kntr.app.ad.domain.report.internal.upload.ReportUploader$$ExternalSyntheticLambda3
            public final Object invoke(Object obj3, Object obj4) {
                Unit buildRequest$lambda$0$5;
                buildRequest$lambda$0$5 = ReportUploader.buildRequest$lambda$0$5($url, (URLBuilder) obj3, (URLBuilder) obj4);
                return buildRequest$lambda$0$5;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildRequest$lambda$0$3(Ref.ObjectRef $contentEncoding, HeadersBuilder $this$headers) {
        Intrinsics.checkNotNullParameter($this$headers, "$this$headers");
        $this$headers.append("Content-Type", "application/json");
        String uaWeb = AdPlatformSpec.INSTANCE.getUaWeb();
        if (uaWeb == null) {
            uaWeb = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        $this$headers.append("User-Agent", uaWeb);
        if ($contentEncoding.element != null) {
            $this$headers.append("Content-Encoding", (String) $contentEncoding.element);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildRequest$lambda$0$4(HeadersBuilder $this$headers) {
        Intrinsics.checkNotNullParameter($this$headers, "$this$headers");
        String uaWeb = AdPlatformSpec.INSTANCE.getUaWeb();
        if (uaWeb == null) {
            uaWeb = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        $this$headers.append("User-Agent", uaWeb);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildRequest$lambda$0$5(String $url, URLBuilder $this$url, URLBuilder it) {
        Intrinsics.checkNotNullParameter($this$url, "$this$url");
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            URLParserKt.takeFrom($this$url, $url);
        } catch (URLParserException e) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object commit$report_debug$default(ReportUploader reportUploader, Function1 function1, Function0 function0, Function2 function2, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            if ((i & 4) != 0) {
                function2 = null;
            }
            return reportUploader.commit$report_debug(function1, function0, function2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: commit");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00df A[Catch: all -> 0x007e, TRY_LEAVE, TryCatch #5 {all -> 0x007e, blocks: (B:18:0x0079, B:32:0x00d2, B:34:0x00df, B:41:0x00fa, B:82:0x01c1, B:84:0x01cb, B:85:0x01e5), top: B:109:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012e A[Catch: all -> 0x01b6, TRY_ENTER, TryCatch #0 {all -> 0x01b6, blocks: (B:46:0x012e, B:48:0x0137, B:51:0x0143, B:52:0x014d, B:54:0x0153, B:56:0x0160, B:58:0x0165, B:62:0x0174, B:67:0x0180, B:68:0x0183, B:71:0x018b, B:72:0x01a5, B:75:0x01ad, B:76:0x01b0, B:80:0x01b9, B:81:0x01c0), top: B:100:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b9 A[Catch: all -> 0x01b6, TryCatch #0 {all -> 0x01b6, blocks: (B:46:0x012e, B:48:0x0137, B:51:0x0143, B:52:0x014d, B:54:0x0153, B:56:0x0160, B:58:0x0165, B:62:0x0174, B:67:0x0180, B:68:0x0183, B:71:0x018b, B:72:0x01a5, B:75:0x01ad, B:76:0x01b0, B:80:0x01b9, B:81:0x01c0), top: B:100:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c1 A[Catch: all -> 0x007e, TRY_ENTER, TryCatch #5 {all -> 0x007e, blocks: (B:18:0x0079, B:32:0x00d2, B:34:0x00df, B:41:0x00fa, B:82:0x01c1, B:84:0x01cb, B:85:0x01e5), top: B:109:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object commit$report_debug(Function1<? super HttpRequestBuilder, Unit> function1, Function0<Unit> function0, Function2<? super Integer, ? super String, Unit> function2, Continuation<? super Boolean> continuation) {
        ReportUploader$commit$1 reportUploader$commit$1;
        ReportUploader$commit$1 reportUploader$commit$12;
        Function0 function02;
        Function2 function22;
        Function2 failureAction;
        Object execute;
        Function0 successAction;
        Function1<? super HttpRequestBuilder, Unit> function12;
        HttpRequestBuilder request;
        Function2 failureAction2;
        HttpResponse response;
        KType kType;
        Object bodyNullable;
        HttpRequestBuilder request2;
        Function0 successAction2;
        int bizCode;
        if (continuation instanceof ReportUploader$commit$1) {
            reportUploader$commit$1 = (ReportUploader$commit$1) continuation;
            if ((reportUploader$commit$1.label & Integer.MIN_VALUE) != 0) {
                reportUploader$commit$1.label -= Integer.MIN_VALUE;
                reportUploader$commit$12 = reportUploader$commit$1;
                Object $result = reportUploader$commit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (reportUploader$commit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        HttpRequestBuilder request3 = new HttpRequestBuilder();
                        function1.invoke(request3);
                        try {
                            HttpClient $this$request$iv = ReportUtilKt.getHttpClient();
                            HttpStatement httpStatement = new HttpStatement(request3, $this$request$iv);
                            reportUploader$commit$12.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                            function02 = function0;
                            try {
                                reportUploader$commit$12.L$1 = function02;
                                function22 = function2;
                                try {
                                    reportUploader$commit$12.L$2 = function22;
                                    reportUploader$commit$12.L$3 = SpillingKt.nullOutSpilledVariable(request3);
                                    reportUploader$commit$12.L$4 = SpillingKt.nullOutSpilledVariable($this$request$iv);
                                    reportUploader$commit$12.L$5 = SpillingKt.nullOutSpilledVariable(request3);
                                    reportUploader$commit$12.I$0 = 0;
                                    reportUploader$commit$12.label = 1;
                                    execute = httpStatement.execute(reportUploader$commit$12);
                                    if (execute == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    successAction = function02;
                                    function12 = function1;
                                    request = request3;
                                    failureAction2 = function22;
                                    response = (HttpResponse) execute;
                                    if (HttpStatusCodeKt.isSuccess(response.getStatus())) {
                                        int code = response.getStatus().getValue();
                                        if (failureAction2 != null) {
                                            failureAction2.invoke(Boxing.boxInt(code), "server error: " + code);
                                        }
                                        return Boxing.boxBoolean(false);
                                    }
                                    HttpClientCall call = response.getCall();
                                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                                    try {
                                        kType = Reflection.typeOf(String.class);
                                    } catch (Throwable th) {
                                        kType = null;
                                    }
                                    TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                    reportUploader$commit$12.L$0 = SpillingKt.nullOutSpilledVariable(function12);
                                    reportUploader$commit$12.L$1 = successAction;
                                    reportUploader$commit$12.L$2 = failureAction2;
                                    reportUploader$commit$12.L$3 = SpillingKt.nullOutSpilledVariable(request);
                                    reportUploader$commit$12.L$4 = SpillingKt.nullOutSpilledVariable(response);
                                    reportUploader$commit$12.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                    reportUploader$commit$12.I$0 = 0;
                                    reportUploader$commit$12.label = 2;
                                    bodyNullable = call.bodyNullable(typeInfo, reportUploader$commit$12);
                                    if (bodyNullable == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    request2 = request;
                                    failureAction = failureAction2;
                                    successAction2 = successAction;
                                    try {
                                        if (bodyNullable != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        String responseData = (String) bodyNullable;
                                        if (!watchBizCode()) {
                                            if (successAction2 != null) {
                                                successAction2.invoke();
                                            }
                                            return Boxing.boxBoolean(true);
                                        }
                                        JsonObject parseToJsonElement = Json.Default.parseToJsonElement(responseData);
                                        if (!(parseToJsonElement instanceof JsonObject)) {
                                            if (failureAction != null) {
                                                failureAction.invoke(Boxing.boxInt(-4), "error json");
                                            }
                                            return Boxing.boxBoolean(false);
                                        }
                                        JsonPrimitive jsonPrimitive = (JsonElement) parseToJsonElement.get("code");
                                        if (jsonPrimitive != null) {
                                            Integer intOrNull = jsonPrimitive instanceof JsonPrimitive ? JsonElementKt.getIntOrNull(jsonPrimitive) : null;
                                            if (intOrNull != null) {
                                                bizCode = intOrNull.intValue();
                                                if (bizCode != 0) {
                                                    if (successAction2 != null) {
                                                        successAction2.invoke();
                                                    }
                                                    return Boxing.boxBoolean(true);
                                                }
                                                if (failureAction != null) {
                                                    failureAction.invoke(Boxing.boxInt(bizCode), "business error: " + bizCode);
                                                }
                                                return Boxing.boxBoolean(false);
                                            }
                                        }
                                        bizCode = -1;
                                        if (bizCode != 0) {
                                        }
                                    } catch (Throwable th2) {
                                        t = th2;
                                        Pair error = ReportUtil_androidKt.handleReportError(t);
                                        if (failureAction != null) {
                                            failureAction.invoke(error.getFirst(), error.getSecond());
                                        }
                                        return Boxing.boxBoolean(false);
                                    }
                                } catch (Throwable th3) {
                                    t = th3;
                                    failureAction = function22;
                                    Pair error2 = ReportUtil_androidKt.handleReportError(t);
                                    if (failureAction != null) {
                                    }
                                    return Boxing.boxBoolean(false);
                                }
                            } catch (Throwable th4) {
                                t = th4;
                                function22 = function2;
                                failureAction = function22;
                                Pair error22 = ReportUtil_androidKt.handleReportError(t);
                                if (failureAction != null) {
                                }
                                return Boxing.boxBoolean(false);
                            }
                        } catch (Throwable th5) {
                            t = th5;
                            function02 = function0;
                        }
                    case 1:
                        int i = reportUploader$commit$12.I$0;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) reportUploader$commit$12.L$5;
                        HttpClient httpClient = (HttpClient) reportUploader$commit$12.L$4;
                        request = (HttpRequestBuilder) reportUploader$commit$12.L$3;
                        failureAction2 = (Function2) reportUploader$commit$12.L$2;
                        successAction = (Function0) reportUploader$commit$12.L$1;
                        function12 = (Function1) reportUploader$commit$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            execute = $result;
                            response = (HttpResponse) execute;
                            if (HttpStatusCodeKt.isSuccess(response.getStatus())) {
                            }
                        } catch (Throwable th6) {
                            t = th6;
                            failureAction = failureAction2;
                            Pair error222 = ReportUtil_androidKt.handleReportError(t);
                            if (failureAction != null) {
                            }
                            return Boxing.boxBoolean(false);
                        }
                        break;
                    case 2:
                        int i2 = reportUploader$commit$12.I$0;
                        HttpResponse httpResponse = (HttpResponse) reportUploader$commit$12.L$5;
                        HttpResponse httpResponse2 = (HttpResponse) reportUploader$commit$12.L$4;
                        HttpRequestBuilder request4 = (HttpRequestBuilder) reportUploader$commit$12.L$3;
                        failureAction = (Function2) reportUploader$commit$12.L$2;
                        successAction2 = (Function0) reportUploader$commit$12.L$1;
                        Function1 function13 = (Function1) reportUploader$commit$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            request2 = request4;
                            bodyNullable = $result;
                            if (bodyNullable != null) {
                            }
                        } catch (Throwable th7) {
                            t = th7;
                            Pair error2222 = ReportUtil_androidKt.handleReportError(t);
                            if (failureAction != null) {
                            }
                            return Boxing.boxBoolean(false);
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        reportUploader$commit$1 = new ReportUploader$commit$1(this, continuation);
        reportUploader$commit$12 = reportUploader$commit$1;
        Object $result2 = reportUploader$commit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (reportUploader$commit$12.label) {
        }
    }

    protected boolean watchBizCode() {
        return true;
    }
}