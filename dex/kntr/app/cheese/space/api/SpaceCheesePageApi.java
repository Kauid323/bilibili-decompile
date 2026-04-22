package kntr.app.cheese.space.api;

import com.bilibili.ktor.KApiResponse;
import com.bilibili.ogv.bpf.server.ApiExceptionKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.URLBuilder;
import io.ktor.util.reflect.TypeInfo;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: SpaceCheesePageApi.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJV\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkntr/app/cheese/space/api/SpaceCheesePageApi;", RoomRecommendViewModel.EMPTY_CURSOR, "httpClient", "Lio/ktor/client/HttpClient;", "baseUrl", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lio/ktor/client/HttpClient;Ljava/lang/String;)V", "requestSpacePageData", "Lcom/bilibili/ktor/KApiResponse;", "Lkntr/app/cheese/space/api/PageData;", "upId", RoomRecommendViewModel.EMPTY_CURSOR, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestSpaceCourseSortedData", "Lkntr/app/cheese/space/api/SeasonFeed;", "classification_id", "cond", RoomRecommendViewModel.EMPTY_CURSOR, "sort_type", "filter_type", "pn", "ps", "(JLjava/lang/String;ILjava/lang/String;IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SpaceCheesePageApi {
    public static final int $stable = 8;
    private final String baseUrl;
    private final HttpClient httpClient;

    @Inject
    public SpaceCheesePageApi(HttpClient httpClient, @BaseUrl String baseUrl) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        this.httpClient = httpClient;
        this.baseUrl = baseUrl;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01bf A[Catch: Exception -> 0x01c3, CancellationException -> 0x01c5, TRY_ENTER, TryCatch #8 {CancellationException -> 0x01c5, Exception -> 0x01c3, blocks: (B:47:0x01bf, B:52:0x01c7, B:53:0x01ce), top: B:82:0x01bd }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c7 A[Catch: Exception -> 0x01c3, CancellationException -> 0x01c5, TryCatch #8 {CancellationException -> 0x01c5, Exception -> 0x01c3, blocks: (B:47:0x01bf, B:52:0x01c7, B:53:0x01ce), top: B:82:0x01bd }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestSpacePageData(long upId, Continuation<? super KApiResponse<PageData>> continuation) {
        SpaceCheesePageApi$requestSpacePageData$1 spaceCheesePageApi$requestSpacePageData$1;
        SpaceCheesePageApi$requestSpacePageData$1 spaceCheesePageApi$requestSpacePageData$12;
        HttpClient $this$get$iv;
        String urlString$iv;
        HttpRequestBuilder $this$get_u24lambda_u244$iv;
        Object obj;
        int $i$f$handleApiException;
        int $i$f$request;
        KType kType;
        Object bodyNullable;
        final long upId2 = upId;
        if (continuation instanceof SpaceCheesePageApi$requestSpacePageData$1) {
            spaceCheesePageApi$requestSpacePageData$1 = (SpaceCheesePageApi$requestSpacePageData$1) continuation;
            if ((spaceCheesePageApi$requestSpacePageData$1.label & Integer.MIN_VALUE) != 0) {
                spaceCheesePageApi$requestSpacePageData$1.label -= Integer.MIN_VALUE;
                spaceCheesePageApi$requestSpacePageData$12 = spaceCheesePageApi$requestSpacePageData$1;
                Object $result = spaceCheesePageApi$requestSpacePageData$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (spaceCheesePageApi$requestSpacePageData$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            $this$get$iv = this.httpClient;
                            urlString$iv = this.baseUrl + "/pugv/app/space/course/page";
                            $this$get_u24lambda_u244$iv = new HttpRequestBuilder();
                            HttpRequestKt.url($this$get_u24lambda_u244$iv, urlString$iv);
                            $this$get_u24lambda_u244$iv.url(new Function2() { // from class: kntr.app.cheese.space.api.SpaceCheesePageApi$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit requestSpacePageData$lambda$0$0$0;
                                    requestSpacePageData$lambda$0$0$0 = SpaceCheesePageApi.requestSpacePageData$lambda$0$0$0(upId2, (URLBuilder) obj2, (URLBuilder) obj3);
                                    return requestSpacePageData$lambda$0$0$0;
                                }
                            });
                        } catch (CancellationException e$iv) {
                            throw e$iv;
                        } catch (Exception e) {
                            e$iv = e;
                        }
                        try {
                            $this$get_u24lambda_u244$iv.setMethod(HttpMethod.Companion.getGet());
                            HttpStatement httpStatement = new HttpStatement($this$get_u24lambda_u244$iv, $this$get$iv);
                            spaceCheesePageApi$requestSpacePageData$12.L$0 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                            spaceCheesePageApi$requestSpacePageData$12.L$1 = SpillingKt.nullOutSpilledVariable(urlString$iv);
                            spaceCheesePageApi$requestSpacePageData$12.L$2 = SpillingKt.nullOutSpilledVariable(spaceCheesePageApi$requestSpacePageData$12);
                            spaceCheesePageApi$requestSpacePageData$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                            spaceCheesePageApi$requestSpacePageData$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                            spaceCheesePageApi$requestSpacePageData$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get_u24lambda_u244$iv);
                            spaceCheesePageApi$requestSpacePageData$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                            spaceCheesePageApi$requestSpacePageData$12.J$0 = upId2;
                            spaceCheesePageApi$requestSpacePageData$12.I$0 = 0;
                            spaceCheesePageApi$requestSpacePageData$12.I$1 = 0;
                            spaceCheesePageApi$requestSpacePageData$12.I$2 = 0;
                            spaceCheesePageApi$requestSpacePageData$12.I$3 = 0;
                            spaceCheesePageApi$requestSpacePageData$12.I$4 = 0;
                            spaceCheesePageApi$requestSpacePageData$12.I$5 = 0;
                            spaceCheesePageApi$requestSpacePageData$12.label = 1;
                            Object execute = httpStatement.execute(spaceCheesePageApi$requestSpacePageData$12);
                            obj = coroutine_suspended;
                            if (execute == obj) {
                                return obj;
                            }
                            $i$f$handleApiException = 0;
                            $result = execute;
                            $i$f$request = 0;
                            try {
                                HttpResponse $this$body$iv = (HttpResponse) $result;
                                HttpClientCall call = $this$body$iv.getCall();
                                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                                try {
                                    kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PageData.class)));
                                } catch (Throwable th) {
                                    kType = null;
                                }
                                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                spaceCheesePageApi$requestSpacePageData$12.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                                spaceCheesePageApi$requestSpacePageData$12.L$1 = SpillingKt.nullOutSpilledVariable(spaceCheesePageApi$requestSpacePageData$12);
                                spaceCheesePageApi$requestSpacePageData$12.L$2 = null;
                                spaceCheesePageApi$requestSpacePageData$12.L$3 = null;
                                spaceCheesePageApi$requestSpacePageData$12.L$4 = null;
                                spaceCheesePageApi$requestSpacePageData$12.L$5 = null;
                                spaceCheesePageApi$requestSpacePageData$12.L$6 = null;
                                spaceCheesePageApi$requestSpacePageData$12.J$0 = upId2;
                                spaceCheesePageApi$requestSpacePageData$12.I$0 = $i$f$handleApiException;
                                spaceCheesePageApi$requestSpacePageData$12.I$1 = $i$f$request;
                                spaceCheesePageApi$requestSpacePageData$12.I$2 = 0;
                                spaceCheesePageApi$requestSpacePageData$12.label = 2;
                                bodyNullable = call.bodyNullable(typeInfo, spaceCheesePageApi$requestSpacePageData$12);
                                if (bodyNullable != obj) {
                                    return obj;
                                }
                                try {
                                    if (bodyNullable == null) {
                                        return (KApiResponse) bodyNullable;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.cheese.space.api.PageData>");
                                } catch (CancellationException e$iv2) {
                                    throw e$iv2;
                                } catch (Exception e2) {
                                    e$iv = e2;
                                    ApiExceptionKt.logApiException(e$iv);
                                    return new KApiResponse.ServiceUnavailable(e$iv);
                                }
                            } catch (CancellationException e$iv3) {
                                throw e$iv3;
                            } catch (Exception e3) {
                                e$iv = e3;
                                ApiExceptionKt.logApiException(e$iv);
                                return new KApiResponse.ServiceUnavailable(e$iv);
                            }
                        } catch (CancellationException e$iv4) {
                            throw e$iv4;
                        } catch (Exception e4) {
                            e$iv = e4;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                    case 1:
                        int i = spaceCheesePageApi$requestSpacePageData$12.I$5;
                        int i2 = spaceCheesePageApi$requestSpacePageData$12.I$4;
                        int i3 = spaceCheesePageApi$requestSpacePageData$12.I$3;
                        int i4 = spaceCheesePageApi$requestSpacePageData$12.I$2;
                        int i5 = spaceCheesePageApi$requestSpacePageData$12.I$1;
                        $i$f$handleApiException = spaceCheesePageApi$requestSpacePageData$12.I$0;
                        upId2 = spaceCheesePageApi$requestSpacePageData$12.J$0;
                        HttpClient httpClient = (HttpClient) spaceCheesePageApi$requestSpacePageData$12.L$6;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) spaceCheesePageApi$requestSpacePageData$12.L$5;
                        HttpClient httpClient2 = (HttpClient) spaceCheesePageApi$requestSpacePageData$12.L$4;
                        HttpClient httpClient3 = (HttpClient) spaceCheesePageApi$requestSpacePageData$12.L$3;
                        SpaceCheesePageApi$requestSpacePageData$1 spaceCheesePageApi$requestSpacePageData$13 = (SpaceCheesePageApi$requestSpacePageData$1) spaceCheesePageApi$requestSpacePageData$12.L$2;
                        String str = (String) spaceCheesePageApi$requestSpacePageData$12.L$1;
                        HttpClient httpClient4 = (HttpClient) spaceCheesePageApi$requestSpacePageData$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            obj = coroutine_suspended;
                            $i$f$request = i5;
                            HttpResponse $this$body$iv2 = (HttpResponse) $result;
                            HttpClientCall call2 = $this$body$iv2.getCall();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PageData.class)));
                            TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                            spaceCheesePageApi$requestSpacePageData$12.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                            spaceCheesePageApi$requestSpacePageData$12.L$1 = SpillingKt.nullOutSpilledVariable(spaceCheesePageApi$requestSpacePageData$12);
                            spaceCheesePageApi$requestSpacePageData$12.L$2 = null;
                            spaceCheesePageApi$requestSpacePageData$12.L$3 = null;
                            spaceCheesePageApi$requestSpacePageData$12.L$4 = null;
                            spaceCheesePageApi$requestSpacePageData$12.L$5 = null;
                            spaceCheesePageApi$requestSpacePageData$12.L$6 = null;
                            spaceCheesePageApi$requestSpacePageData$12.J$0 = upId2;
                            spaceCheesePageApi$requestSpacePageData$12.I$0 = $i$f$handleApiException;
                            spaceCheesePageApi$requestSpacePageData$12.I$1 = $i$f$request;
                            spaceCheesePageApi$requestSpacePageData$12.I$2 = 0;
                            spaceCheesePageApi$requestSpacePageData$12.label = 2;
                            bodyNullable = call2.bodyNullable(typeInfo2, spaceCheesePageApi$requestSpacePageData$12);
                            if (bodyNullable != obj) {
                            }
                        } catch (CancellationException e$iv5) {
                            throw e$iv5;
                        } catch (Exception e5) {
                            e$iv = e5;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    case 2:
                        int i6 = spaceCheesePageApi$requestSpacePageData$12.I$2;
                        int i7 = spaceCheesePageApi$requestSpacePageData$12.I$1;
                        int i8 = spaceCheesePageApi$requestSpacePageData$12.I$0;
                        long j2 = spaceCheesePageApi$requestSpacePageData$12.J$0;
                        SpaceCheesePageApi$requestSpacePageData$1 spaceCheesePageApi$requestSpacePageData$14 = (SpaceCheesePageApi$requestSpacePageData$1) spaceCheesePageApi$requestSpacePageData$12.L$1;
                        HttpResponse httpResponse = (HttpResponse) spaceCheesePageApi$requestSpacePageData$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            bodyNullable = $result;
                            if (bodyNullable == null) {
                            }
                        } catch (CancellationException e$iv6) {
                            throw e$iv6;
                        } catch (Exception e6) {
                            e$iv = e6;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        spaceCheesePageApi$requestSpacePageData$1 = new SpaceCheesePageApi$requestSpacePageData$1(this, continuation);
        spaceCheesePageApi$requestSpacePageData$12 = spaceCheesePageApi$requestSpacePageData$1;
        Object $result2 = spaceCheesePageApi$requestSpacePageData$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (spaceCheesePageApi$requestSpacePageData$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestSpacePageData$lambda$0$0$0(long $upId, URLBuilder $this$url, URLBuilder it) {
        Intrinsics.checkNotNullParameter($this$url, "$this$url");
        Intrinsics.checkNotNullParameter(it, "it");
        ParametersBuilder $this$requestSpacePageData_u24lambda_u240_u240_u240_u240 = $this$url.getParameters();
        $this$requestSpacePageData_u24lambda_u240_u240_u240_u240.append("upId", String.valueOf($upId));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x026b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0279 A[Catch: Exception -> 0x027e, CancellationException -> 0x028a, TRY_ENTER, TryCatch #11 {CancellationException -> 0x028a, Exception -> 0x027e, blocks: (B:57:0x0279, B:62:0x0296, B:63:0x029d), top: B:110:0x0277 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0296 A[Catch: Exception -> 0x027e, CancellationException -> 0x028a, TryCatch #11 {CancellationException -> 0x028a, Exception -> 0x027e, blocks: (B:57:0x0279, B:62:0x0296, B:63:0x029d), top: B:110:0x0277 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestSpaceCourseSortedData(final long upId, final String classification_id, final int cond, final String sort_type, final int filter_type, final int pn, final int ps, Continuation<? super KApiResponse<SeasonFeed>> continuation) {
        SpaceCheesePageApi$requestSpaceCourseSortedData$1 spaceCheesePageApi$requestSpaceCourseSortedData$1;
        SpaceCheesePageApi$requestSpaceCourseSortedData$1 spaceCheesePageApi$requestSpaceCourseSortedData$12;
        int filter_type2;
        int ps2;
        String classification_id2;
        int cond2;
        String sort_type2;
        int pn2;
        int cond3;
        HttpStatement httpStatement;
        Object $result;
        Object obj;
        int filter_type3;
        int $i$f$handleApiException;
        int ps3;
        int i;
        long upId2;
        HttpClientCall call;
        Object obj2;
        HttpClientCall httpClientCall;
        KType kType;
        Object bodyNullable;
        int cond4;
        String sort_type3;
        String classification_id3;
        int filter_type4;
        int pn3;
        if (continuation instanceof SpaceCheesePageApi$requestSpaceCourseSortedData$1) {
            spaceCheesePageApi$requestSpaceCourseSortedData$1 = (SpaceCheesePageApi$requestSpaceCourseSortedData$1) continuation;
            if ((spaceCheesePageApi$requestSpaceCourseSortedData$1.label & Integer.MIN_VALUE) != 0) {
                spaceCheesePageApi$requestSpaceCourseSortedData$1.label -= Integer.MIN_VALUE;
                spaceCheesePageApi$requestSpaceCourseSortedData$12 = spaceCheesePageApi$requestSpaceCourseSortedData$1;
                Object $result2 = spaceCheesePageApi$requestSpaceCourseSortedData$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (spaceCheesePageApi$requestSpaceCourseSortedData$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        try {
                            HttpClient $this$get$iv = this.httpClient;
                            String urlString$iv = this.baseUrl + "/pugv/app/space/course/page/sort";
                            HttpRequestBuilder $this$get_u24lambda_u244$iv = new HttpRequestBuilder();
                            HttpRequestKt.url($this$get_u24lambda_u244$iv, urlString$iv);
                            $this$get_u24lambda_u244$iv.url(new Function2() { // from class: kntr.app.cheese.space.api.SpaceCheesePageApi$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj3, Object obj4) {
                                    Unit requestSpaceCourseSortedData$lambda$0$0$0;
                                    requestSpaceCourseSortedData$lambda$0$0$0 = SpaceCheesePageApi.requestSpaceCourseSortedData$lambda$0$0$0(upId, classification_id, cond, sort_type, filter_type, pn, ps, (URLBuilder) obj3, (URLBuilder) obj4);
                                    return requestSpaceCourseSortedData$lambda$0$0$0;
                                }
                            });
                            $this$get_u24lambda_u244$iv.setMethod(HttpMethod.Companion.getGet());
                            try {
                                httpStatement = new HttpStatement($this$get_u24lambda_u244$iv, $this$get$iv);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$0 = SpillingKt.nullOutSpilledVariable(classification_id);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$1 = SpillingKt.nullOutSpilledVariable(sort_type);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$2 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$3 = SpillingKt.nullOutSpilledVariable(urlString$iv);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$4 = SpillingKt.nullOutSpilledVariable(spaceCheesePageApi$requestSpaceCourseSortedData$12);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$7 = SpillingKt.nullOutSpilledVariable($this$get_u24lambda_u244$iv);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$8 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.J$0 = upId;
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.I$0 = cond;
                                filter_type2 = filter_type;
                                try {
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.I$1 = filter_type2;
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.I$2 = pn;
                                    ps2 = ps;
                                } catch (CancellationException e) {
                                    e$iv = e;
                                    throw e$iv;
                                } catch (Exception e2) {
                                    e$iv = e2;
                                    ps2 = ps;
                                    classification_id2 = classification_id;
                                    cond2 = cond;
                                    sort_type2 = sort_type;
                                    pn2 = pn;
                                    cond3 = 0;
                                    ApiExceptionKt.logApiException(e$iv);
                                    return new KApiResponse.ServiceUnavailable(e$iv);
                                }
                            } catch (CancellationException e3) {
                                e$iv = e3;
                            } catch (Exception e4) {
                                e$iv = e4;
                                filter_type2 = filter_type;
                            }
                        } catch (CancellationException e5) {
                            e$iv = e5;
                        } catch (Exception e6) {
                            e$iv = e6;
                            filter_type2 = filter_type;
                            ps2 = ps;
                            classification_id2 = classification_id;
                            cond2 = cond;
                            sort_type2 = sort_type;
                            pn2 = pn;
                            cond3 = 0;
                        }
                        try {
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.I$3 = ps2;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.I$4 = 0;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.I$5 = 0;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.I$6 = 0;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.I$7 = 0;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.I$8 = 0;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.I$9 = 0;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.label = 1;
                            Object execute = httpStatement.execute(spaceCheesePageApi$requestSpaceCourseSortedData$12);
                            $result = coroutine_suspended;
                            if (execute == $result) {
                                return $result;
                            }
                            classification_id2 = classification_id;
                            pn2 = pn;
                            obj = execute;
                            filter_type3 = filter_type2;
                            $i$f$handleApiException = 0;
                            cond2 = cond;
                            sort_type2 = sort_type;
                            ps3 = ps2;
                            i = 0;
                            upId2 = upId;
                            try {
                                HttpResponse $this$body$iv = (HttpResponse) obj;
                                call = $this$body$iv.getCall();
                                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                                obj2 = $result;
                                try {
                                    httpClientCall = call;
                                } catch (Throwable th) {
                                    httpClientCall = call;
                                }
                                try {
                                    kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SeasonFeed.class)));
                                } catch (Throwable th2) {
                                    kType = null;
                                    TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.L$0 = SpillingKt.nullOutSpilledVariable(classification_id2);
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.L$1 = SpillingKt.nullOutSpilledVariable(sort_type2);
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.L$2 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.L$3 = SpillingKt.nullOutSpilledVariable(spaceCheesePageApi$requestSpaceCourseSortedData$12);
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.L$4 = null;
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.L$5 = null;
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.L$6 = null;
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.L$7 = null;
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.L$8 = null;
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.J$0 = upId2;
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.I$0 = cond2;
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.I$1 = filter_type3;
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.I$2 = pn2;
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.I$3 = ps3;
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.I$4 = $i$f$handleApiException;
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.I$5 = i;
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.I$6 = 0;
                                    spaceCheesePageApi$requestSpaceCourseSortedData$12.label = 2;
                                    bodyNullable = httpClientCall.bodyNullable(typeInfo, spaceCheesePageApi$requestSpaceCourseSortedData$12);
                                    if (bodyNullable == obj2) {
                                    }
                                }
                                TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass, kType);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$0 = SpillingKt.nullOutSpilledVariable(classification_id2);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$1 = SpillingKt.nullOutSpilledVariable(sort_type2);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$2 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$3 = SpillingKt.nullOutSpilledVariable(spaceCheesePageApi$requestSpaceCourseSortedData$12);
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$4 = null;
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$5 = null;
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$6 = null;
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$7 = null;
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.L$8 = null;
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.J$0 = upId2;
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.I$0 = cond2;
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.I$1 = filter_type3;
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.I$2 = pn2;
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.I$3 = ps3;
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.I$4 = $i$f$handleApiException;
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.I$5 = i;
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.I$6 = 0;
                                spaceCheesePageApi$requestSpaceCourseSortedData$12.label = 2;
                                bodyNullable = httpClientCall.bodyNullable(typeInfo2, spaceCheesePageApi$requestSpaceCourseSortedData$12);
                                if (bodyNullable == obj2) {
                                    return obj2;
                                }
                                cond4 = cond2;
                                sort_type3 = sort_type2;
                                classification_id3 = classification_id2;
                                filter_type4 = filter_type3;
                                pn3 = pn2;
                                try {
                                    if (bodyNullable == null) {
                                        return (KApiResponse) bodyNullable;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.cheese.space.api.SeasonFeed>");
                                } catch (CancellationException e7) {
                                    e$iv = e7;
                                    throw e$iv;
                                } catch (Exception e8) {
                                    e$iv = e8;
                                    pn2 = pn3;
                                    cond2 = cond4;
                                    ps2 = ps3;
                                    sort_type2 = sort_type3;
                                    classification_id2 = classification_id3;
                                    cond3 = $i$f$handleApiException;
                                    filter_type2 = filter_type4;
                                    ApiExceptionKt.logApiException(e$iv);
                                    return new KApiResponse.ServiceUnavailable(e$iv);
                                }
                            } catch (CancellationException e9) {
                                e$iv = e9;
                                throw e$iv;
                            } catch (Exception e10) {
                                e$iv = e10;
                                cond3 = $i$f$handleApiException;
                                ps2 = ps3;
                                filter_type2 = filter_type3;
                                ApiExceptionKt.logApiException(e$iv);
                                return new KApiResponse.ServiceUnavailable(e$iv);
                            }
                        } catch (CancellationException e11) {
                            e$iv = e11;
                            throw e$iv;
                        } catch (Exception e12) {
                            e$iv = e12;
                            classification_id2 = classification_id;
                            cond2 = cond;
                            sort_type2 = sort_type;
                            pn2 = pn;
                            cond3 = 0;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                    case 1:
                        int i2 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$9;
                        int i3 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$8;
                        int i4 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$7;
                        int i5 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$6;
                        int i6 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$5;
                        cond3 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$4;
                        ps3 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$3;
                        pn2 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$2;
                        filter_type3 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$1;
                        cond2 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$0;
                        upId2 = spaceCheesePageApi$requestSpaceCourseSortedData$12.J$0;
                        HttpClient httpClient = (HttpClient) spaceCheesePageApi$requestSpaceCourseSortedData$12.L$8;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) spaceCheesePageApi$requestSpaceCourseSortedData$12.L$7;
                        HttpClient httpClient2 = (HttpClient) spaceCheesePageApi$requestSpaceCourseSortedData$12.L$6;
                        HttpClient httpClient3 = (HttpClient) spaceCheesePageApi$requestSpaceCourseSortedData$12.L$5;
                        SpaceCheesePageApi$requestSpaceCourseSortedData$1 spaceCheesePageApi$requestSpaceCourseSortedData$13 = (SpaceCheesePageApi$requestSpaceCourseSortedData$1) spaceCheesePageApi$requestSpaceCourseSortedData$12.L$4;
                        String str = (String) spaceCheesePageApi$requestSpaceCourseSortedData$12.L$3;
                        HttpClient httpClient4 = (HttpClient) spaceCheesePageApi$requestSpaceCourseSortedData$12.L$2;
                        sort_type2 = (String) spaceCheesePageApi$requestSpaceCourseSortedData$12.L$1;
                        classification_id2 = (String) spaceCheesePageApi$requestSpaceCourseSortedData$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            i = i6;
                            $i$f$handleApiException = cond3;
                            obj = $result2;
                            $result = coroutine_suspended;
                            HttpResponse $this$body$iv2 = (HttpResponse) obj;
                            call = $this$body$iv2.getCall();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            obj2 = $result;
                            httpClientCall = call;
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SeasonFeed.class)));
                            TypeInfo typeInfo22 = new TypeInfo(orCreateKotlinClass2, kType);
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.L$0 = SpillingKt.nullOutSpilledVariable(classification_id2);
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.L$1 = SpillingKt.nullOutSpilledVariable(sort_type2);
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.L$2 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.L$3 = SpillingKt.nullOutSpilledVariable(spaceCheesePageApi$requestSpaceCourseSortedData$12);
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.L$4 = null;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.L$5 = null;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.L$6 = null;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.L$7 = null;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.L$8 = null;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.J$0 = upId2;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.I$0 = cond2;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.I$1 = filter_type3;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.I$2 = pn2;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.I$3 = ps3;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.I$4 = $i$f$handleApiException;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.I$5 = i;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.I$6 = 0;
                            spaceCheesePageApi$requestSpaceCourseSortedData$12.label = 2;
                            bodyNullable = httpClientCall.bodyNullable(typeInfo22, spaceCheesePageApi$requestSpaceCourseSortedData$12);
                            if (bodyNullable == obj2) {
                            }
                        } catch (CancellationException e13) {
                            e$iv = e13;
                            throw e$iv;
                        } catch (Exception e14) {
                            e$iv = e14;
                            ps2 = ps3;
                            filter_type2 = filter_type3;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    case 2:
                        int i7 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$6;
                        int i8 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$5;
                        int $i$f$handleApiException2 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$4;
                        int ps4 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$3;
                        pn3 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$2;
                        filter_type4 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$1;
                        cond4 = spaceCheesePageApi$requestSpaceCourseSortedData$12.I$0;
                        long j2 = spaceCheesePageApi$requestSpaceCourseSortedData$12.J$0;
                        SpaceCheesePageApi$requestSpaceCourseSortedData$1 spaceCheesePageApi$requestSpaceCourseSortedData$14 = (SpaceCheesePageApi$requestSpaceCourseSortedData$1) spaceCheesePageApi$requestSpaceCourseSortedData$12.L$3;
                        HttpResponse httpResponse = (HttpResponse) spaceCheesePageApi$requestSpaceCourseSortedData$12.L$2;
                        sort_type3 = (String) spaceCheesePageApi$requestSpaceCourseSortedData$12.L$1;
                        classification_id3 = (String) spaceCheesePageApi$requestSpaceCourseSortedData$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            bodyNullable = $result2;
                            $i$f$handleApiException = $i$f$handleApiException2;
                            ps3 = ps4;
                            if (bodyNullable == null) {
                            }
                        } catch (CancellationException e15) {
                            e$iv = e15;
                            throw e$iv;
                        } catch (Exception e16) {
                            e$iv = e16;
                            ps2 = ps4;
                            filter_type2 = filter_type4;
                            cond2 = cond4;
                            sort_type2 = sort_type3;
                            classification_id2 = classification_id3;
                            cond3 = $i$f$handleApiException2;
                            pn2 = pn3;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        spaceCheesePageApi$requestSpaceCourseSortedData$1 = new SpaceCheesePageApi$requestSpaceCourseSortedData$1(this, continuation);
        spaceCheesePageApi$requestSpaceCourseSortedData$12 = spaceCheesePageApi$requestSpaceCourseSortedData$1;
        Object $result22 = spaceCheesePageApi$requestSpaceCourseSortedData$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (spaceCheesePageApi$requestSpaceCourseSortedData$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestSpaceCourseSortedData$lambda$0$0$0(long $upId, String $classification_id, int $cond, String $sort_type, int $filter_type, int $pn, int $ps, URLBuilder $this$url, URLBuilder it) {
        Intrinsics.checkNotNullParameter($this$url, "$this$url");
        Intrinsics.checkNotNullParameter(it, "it");
        ParametersBuilder $this$requestSpaceCourseSortedData_u24lambda_u240_u240_u240_u240 = $this$url.getParameters();
        $this$requestSpaceCourseSortedData_u24lambda_u240_u240_u240_u240.append("upId", String.valueOf($upId));
        $this$requestSpaceCourseSortedData_u24lambda_u240_u240_u240_u240.append("classification_id", $classification_id);
        $this$requestSpaceCourseSortedData_u24lambda_u240_u240_u240_u240.append("cond", String.valueOf($cond));
        $this$requestSpaceCourseSortedData_u24lambda_u240_u240_u240_u240.append("sort_type", $sort_type);
        $this$requestSpaceCourseSortedData_u24lambda_u240_u240_u240_u240.append("filter_type", String.valueOf($filter_type));
        $this$requestSpaceCourseSortedData_u24lambda_u240_u240_u240_u240.append("pn", String.valueOf($pn));
        $this$requestSpaceCourseSortedData_u24lambda_u240_u240_u240_u240.append("ps", String.valueOf($ps));
        return Unit.INSTANCE;
    }
}