package kntr.app.upper.entrance.bubble2.service;

import BottomSheetItemData$;
import com.bilibili.ktor.KApiResponse;
import com.bilibili.ktor.KtorClientKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.reflect.TypeInfo;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.bubble2.bean.BubbleBean;
import kntr.app.upper.entrance.bubble2.bean.FansShow;
import kntr.app.upper.entrance.bubble2.service.UperCenterPlusBubbleService;
import kntr.app.upper.entrance.utils.LogUtils;
import kntr.app.upper.entrance.utils.TrackUtils;
import kntr.base.config.SerializableSharedPreferencesProperty;
import kntr.base.net.comm.imp.InitHttpsWorldKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.serialization.builtins.BuiltinSerializersKt;

/* compiled from: UperCenterPlusBubbleService.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0007H\u0080@¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0014J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkntr/app/upper/entrance/bubble2/service/UperCenterPlusBubbleService;", "", "<init>", "()V", "client", "Lio/ktor/client/HttpClient;", "TAG", "", "requestBubble", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean;", "mid", "requestBubble$entrance_debug", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchFromLocal", "Lkntr/app/upper/entrance/bubble2/service/UperCenterPlusBubbleService$BubbleLocal;", "bubble", "zeroTs", "", "shouldFetchBubble", "", "shouldFetchBubble$entrance_debug", "checkFansChanged", "", "old", "new", "getCache", "Lkntr/app/upper/entrance/bubble2/service/UperCenterPlusBubbleService$CacheDelegate;", "removeQueryParameter", "url", "key", "CacheDelegate", "BubbleLocal", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UperCenterPlusBubbleService {
    private static final String TAG = "UperCenterPlusBubbleServiceB";
    public static final UperCenterPlusBubbleService INSTANCE = new UperCenterPlusBubbleService();
    private static final HttpClient client = KtorClientKt.getKtorHttpClient();

    private UperCenterPlusBubbleService() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0232 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x030c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestBubble$entrance_debug(String mid, Continuation<? super BubbleBean> continuation) {
        UperCenterPlusBubbleService$requestBubble$1 uperCenterPlusBubbleService$requestBubble$1;
        long zeroTs;
        Url url;
        Object execute;
        Object obj;
        Instant now;
        CacheDelegate bubbleCache;
        BubbleBean bubble;
        String mid2;
        BubbleLocal localInfo;
        Object obj2;
        KType kType;
        Object bodyNullable;
        Object obj3;
        BubbleBean bubble2;
        CacheDelegate bubbleCache2;
        long zeroTs2;
        if (continuation instanceof UperCenterPlusBubbleService$requestBubble$1) {
            uperCenterPlusBubbleService$requestBubble$1 = (UperCenterPlusBubbleService$requestBubble$1) continuation;
            if ((uperCenterPlusBubbleService$requestBubble$1.label & Integer.MIN_VALUE) != 0) {
                uperCenterPlusBubbleService$requestBubble$1.label -= Integer.MIN_VALUE;
                Object $result = uperCenterPlusBubbleService$requestBubble$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (uperCenterPlusBubbleService$requestBubble$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Instant now2 = Clock.System.INSTANCE.now();
                        zeroTs = now2.toEpochMilliseconds();
                        CacheDelegate bubbleCache3 = getCache(mid);
                        BubbleBean bubble3 = bubbleCache3.getValue();
                        BubbleLocal localInfo2 = fetchFromLocal(mid, bubble3, zeroTs);
                        if (localInfo2.getLimit()) {
                            return localInfo2.getBubble();
                        }
                        URLBuilder $this$requestBubble_u24lambda_u240 = new URLBuilder(URLProtocol.Companion.getHTTPS(), InitHttpsWorldKt.HOST_MEMBER_BILIBILI_COM, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 508, (DefaultConstructorMarker) null);
                        URLBuilderKt.setEncodedPath($this$requestBubble_u24lambda_u240, "/x/app/archive/resource/bubble");
                        url = $this$requestBubble_u24lambda_u240.build();
                        HttpClient $this$get_u24default$iv = client;
                        HttpRequestBuilder $this$get_u24lambda_u240$iv = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom($this$get_u24lambda_u240$iv.getUrl(), url);
                        $this$get_u24lambda_u240$iv.setMethod(HttpMethod.Companion.getGet());
                        HttpStatement httpStatement = new HttpStatement($this$get_u24lambda_u240$iv, $this$get_u24default$iv);
                        uperCenterPlusBubbleService$requestBubble$1.L$0 = mid;
                        uperCenterPlusBubbleService$requestBubble$1.L$1 = SpillingKt.nullOutSpilledVariable(now2);
                        uperCenterPlusBubbleService$requestBubble$1.L$2 = bubbleCache3;
                        uperCenterPlusBubbleService$requestBubble$1.L$3 = bubble3;
                        uperCenterPlusBubbleService$requestBubble$1.L$4 = SpillingKt.nullOutSpilledVariable(localInfo2);
                        uperCenterPlusBubbleService$requestBubble$1.L$5 = SpillingKt.nullOutSpilledVariable(url);
                        uperCenterPlusBubbleService$requestBubble$1.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        uperCenterPlusBubbleService$requestBubble$1.L$7 = SpillingKt.nullOutSpilledVariable(url);
                        uperCenterPlusBubbleService$requestBubble$1.L$8 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        uperCenterPlusBubbleService$requestBubble$1.L$9 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        uperCenterPlusBubbleService$requestBubble$1.L$10 = SpillingKt.nullOutSpilledVariable($this$get_u24lambda_u240$iv);
                        uperCenterPlusBubbleService$requestBubble$1.L$11 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        uperCenterPlusBubbleService$requestBubble$1.J$0 = zeroTs;
                        uperCenterPlusBubbleService$requestBubble$1.I$0 = 0;
                        uperCenterPlusBubbleService$requestBubble$1.I$1 = 0;
                        uperCenterPlusBubbleService$requestBubble$1.I$2 = 0;
                        uperCenterPlusBubbleService$requestBubble$1.I$3 = 0;
                        uperCenterPlusBubbleService$requestBubble$1.label = 1;
                        execute = httpStatement.execute(uperCenterPlusBubbleService$requestBubble$1);
                        obj = coroutine_suspended;
                        if (execute == obj) {
                            return obj;
                        }
                        now = now2;
                        bubbleCache = bubbleCache3;
                        bubble = bubble3;
                        mid2 = mid;
                        localInfo = localInfo2;
                        HttpResponse httpResponse = (HttpResponse) execute;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            obj2 = obj;
                            try {
                                kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(BubbleBean.class)));
                            } catch (Throwable th) {
                                kType = null;
                                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                uperCenterPlusBubbleService$requestBubble$1.L$0 = mid2;
                                uperCenterPlusBubbleService$requestBubble$1.L$1 = SpillingKt.nullOutSpilledVariable(now);
                                uperCenterPlusBubbleService$requestBubble$1.L$2 = bubbleCache;
                                uperCenterPlusBubbleService$requestBubble$1.L$3 = bubble;
                                uperCenterPlusBubbleService$requestBubble$1.L$4 = SpillingKt.nullOutSpilledVariable(localInfo);
                                uperCenterPlusBubbleService$requestBubble$1.L$5 = SpillingKt.nullOutSpilledVariable(url);
                                uperCenterPlusBubbleService$requestBubble$1.L$6 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                uperCenterPlusBubbleService$requestBubble$1.L$7 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                uperCenterPlusBubbleService$requestBubble$1.L$8 = null;
                                uperCenterPlusBubbleService$requestBubble$1.L$9 = null;
                                uperCenterPlusBubbleService$requestBubble$1.L$10 = null;
                                uperCenterPlusBubbleService$requestBubble$1.L$11 = null;
                                uperCenterPlusBubbleService$requestBubble$1.J$0 = zeroTs;
                                uperCenterPlusBubbleService$requestBubble$1.I$0 = 0;
                                uperCenterPlusBubbleService$requestBubble$1.label = 2;
                                bodyNullable = call.bodyNullable(typeInfo, uperCenterPlusBubbleService$requestBubble$1);
                                obj3 = obj2;
                                if (bodyNullable == obj3) {
                                }
                            }
                        } catch (Throwable th2) {
                            obj2 = obj;
                        }
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass, kType);
                        uperCenterPlusBubbleService$requestBubble$1.L$0 = mid2;
                        uperCenterPlusBubbleService$requestBubble$1.L$1 = SpillingKt.nullOutSpilledVariable(now);
                        uperCenterPlusBubbleService$requestBubble$1.L$2 = bubbleCache;
                        uperCenterPlusBubbleService$requestBubble$1.L$3 = bubble;
                        uperCenterPlusBubbleService$requestBubble$1.L$4 = SpillingKt.nullOutSpilledVariable(localInfo);
                        uperCenterPlusBubbleService$requestBubble$1.L$5 = SpillingKt.nullOutSpilledVariable(url);
                        uperCenterPlusBubbleService$requestBubble$1.L$6 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        uperCenterPlusBubbleService$requestBubble$1.L$7 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        uperCenterPlusBubbleService$requestBubble$1.L$8 = null;
                        uperCenterPlusBubbleService$requestBubble$1.L$9 = null;
                        uperCenterPlusBubbleService$requestBubble$1.L$10 = null;
                        uperCenterPlusBubbleService$requestBubble$1.L$11 = null;
                        uperCenterPlusBubbleService$requestBubble$1.J$0 = zeroTs;
                        uperCenterPlusBubbleService$requestBubble$1.I$0 = 0;
                        uperCenterPlusBubbleService$requestBubble$1.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo2, uperCenterPlusBubbleService$requestBubble$1);
                        obj3 = obj2;
                        if (bodyNullable == obj3) {
                            return obj3;
                        }
                        bubble2 = bubble;
                        bubbleCache2 = bubbleCache;
                        zeroTs2 = zeroTs;
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (!(success instanceof KApiResponse.Success)) {
                                if (success instanceof KApiResponse.BusinessFailure) {
                                    throw new Throwable("KResponse.Failure(" + ((KApiResponse.BusinessFailure) success).getCode() + ", " + ((KApiResponse.BusinessFailure) success).getMessage() + ")");
                                } else if (success instanceof KApiResponse.ServiceUnavailable) {
                                    throw new Throwable("KResponse.Unavailable(" + ((KApiResponse.ServiceUnavailable) success).getException().getMessage() + ")");
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                            BubbleBean data = (BubbleBean) success.getData();
                            checkFansChanged(mid2, bubble2, data);
                            data.setZeroTs(zeroTs2);
                            bubbleCache2.setValue(data);
                            List<BubbleBean.Resource> resourceList = data.getResourceList();
                            boolean isNullOrEmpty = resourceList == null || resourceList.isEmpty();
                            if (isNullOrEmpty) {
                                TrackUtils.INSTANCE.trackBubbleRequestInfo(TiredType2.EMPTY_DATA.getValue(), (r21 & 2) != 0 ? "" : null, (r21 & 4) != 0 ? "" : null, (r21 & 8) != 0 ? "" : null, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? "" : mid2, (r21 & 256) != 0 ? "" : null, (r21 & 512) == 0 ? null : "");
                                BubbleTiredService.INSTANCE.recordBubbleRequestEmpty(mid2);
                            }
                            return data;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.upper.entrance.bubble2.bean.BubbleBean>");
                    case 1:
                        int i = uperCenterPlusBubbleService$requestBubble$1.I$3;
                        int i2 = uperCenterPlusBubbleService$requestBubble$1.I$2;
                        int i3 = uperCenterPlusBubbleService$requestBubble$1.I$1;
                        int i4 = uperCenterPlusBubbleService$requestBubble$1.I$0;
                        long zeroTs3 = uperCenterPlusBubbleService$requestBubble$1.J$0;
                        HttpClient httpClient = (HttpClient) uperCenterPlusBubbleService$requestBubble$1.L$11;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) uperCenterPlusBubbleService$requestBubble$1.L$10;
                        HttpClient httpClient2 = (HttpClient) uperCenterPlusBubbleService$requestBubble$1.L$9;
                        HttpClient httpClient3 = (HttpClient) uperCenterPlusBubbleService$requestBubble$1.L$8;
                        Url url2 = (Url) uperCenterPlusBubbleService$requestBubble$1.L$7;
                        HttpClient httpClient4 = (HttpClient) uperCenterPlusBubbleService$requestBubble$1.L$6;
                        Url url3 = (Url) uperCenterPlusBubbleService$requestBubble$1.L$5;
                        BubbleLocal localInfo3 = (BubbleLocal) uperCenterPlusBubbleService$requestBubble$1.L$4;
                        BubbleBean bubble4 = (BubbleBean) uperCenterPlusBubbleService$requestBubble$1.L$3;
                        CacheDelegate bubbleCache4 = (CacheDelegate) uperCenterPlusBubbleService$requestBubble$1.L$2;
                        now = (Instant) uperCenterPlusBubbleService$requestBubble$1.L$1;
                        ResultKt.throwOnFailure($result);
                        mid2 = (String) uperCenterPlusBubbleService$requestBubble$1.L$0;
                        execute = $result;
                        obj = coroutine_suspended;
                        zeroTs = zeroTs3;
                        url = url3;
                        localInfo = localInfo3;
                        bubbleCache = bubbleCache4;
                        bubble = bubble4;
                        HttpResponse httpResponse2 = (HttpResponse) execute;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        obj2 = obj;
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(BubbleBean.class)));
                        TypeInfo typeInfo22 = new TypeInfo(orCreateKotlinClass2, kType);
                        uperCenterPlusBubbleService$requestBubble$1.L$0 = mid2;
                        uperCenterPlusBubbleService$requestBubble$1.L$1 = SpillingKt.nullOutSpilledVariable(now);
                        uperCenterPlusBubbleService$requestBubble$1.L$2 = bubbleCache;
                        uperCenterPlusBubbleService$requestBubble$1.L$3 = bubble;
                        uperCenterPlusBubbleService$requestBubble$1.L$4 = SpillingKt.nullOutSpilledVariable(localInfo);
                        uperCenterPlusBubbleService$requestBubble$1.L$5 = SpillingKt.nullOutSpilledVariable(url);
                        uperCenterPlusBubbleService$requestBubble$1.L$6 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        uperCenterPlusBubbleService$requestBubble$1.L$7 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        uperCenterPlusBubbleService$requestBubble$1.L$8 = null;
                        uperCenterPlusBubbleService$requestBubble$1.L$9 = null;
                        uperCenterPlusBubbleService$requestBubble$1.L$10 = null;
                        uperCenterPlusBubbleService$requestBubble$1.L$11 = null;
                        uperCenterPlusBubbleService$requestBubble$1.J$0 = zeroTs;
                        uperCenterPlusBubbleService$requestBubble$1.I$0 = 0;
                        uperCenterPlusBubbleService$requestBubble$1.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo22, uperCenterPlusBubbleService$requestBubble$1);
                        obj3 = obj2;
                        if (bodyNullable == obj3) {
                        }
                        break;
                    case 2:
                        int i5 = uperCenterPlusBubbleService$requestBubble$1.I$0;
                        zeroTs2 = uperCenterPlusBubbleService$requestBubble$1.J$0;
                        HttpResponse httpResponse3 = (HttpResponse) uperCenterPlusBubbleService$requestBubble$1.L$7;
                        HttpResponse httpResponse4 = (HttpResponse) uperCenterPlusBubbleService$requestBubble$1.L$6;
                        Url url4 = (Url) uperCenterPlusBubbleService$requestBubble$1.L$5;
                        BubbleLocal bubbleLocal = (BubbleLocal) uperCenterPlusBubbleService$requestBubble$1.L$4;
                        bubble2 = (BubbleBean) uperCenterPlusBubbleService$requestBubble$1.L$3;
                        bubbleCache2 = (CacheDelegate) uperCenterPlusBubbleService$requestBubble$1.L$2;
                        Instant instant = (Instant) uperCenterPlusBubbleService$requestBubble$1.L$1;
                        ResultKt.throwOnFailure($result);
                        mid2 = (String) uperCenterPlusBubbleService$requestBubble$1.L$0;
                        bodyNullable = $result;
                        if (bodyNullable == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        uperCenterPlusBubbleService$requestBubble$1 = new UperCenterPlusBubbleService$requestBubble$1(this, continuation);
        Object $result2 = uperCenterPlusBubbleService$requestBubble$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (uperCenterPlusBubbleService$requestBubble$1.label) {
        }
    }

    private final BubbleLocal fetchFromLocal(String mid, BubbleBean bubble, long zeroTs) {
        if (bubble != null) {
            List<BubbleBean.Resource> resourceList = bubble.getResourceList();
            if (!(resourceList == null || resourceList.isEmpty()) && zeroTs - bubble.getZeroTs() < 86400000) {
                LogUtils.INSTANCE.i(TAG, "requestBubble use cache new");
                return new BubbleLocal(true, bubble);
            }
        }
        if (BubbleTiredService.INSTANCE.bubbleRequestTimeLimit(zeroTs)) {
            LogUtils.INSTANCE.e(TAG, "频次命中时间段限流");
            TrackUtils.INSTANCE.trackBubbleRequestInfo(TiredType2.LIMIT_TIME.getValue(), (r21 & 2) != 0 ? "" : null, (r21 & 4) != 0 ? "" : null, (r21 & 8) != 0 ? "" : null, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? "" : mid, (r21 & 256) != 0 ? "" : null, (r21 & 512) == 0 ? null : "");
            return new BubbleLocal(true, null, 2, null);
        } else if (BubbleTiredService.INSTANCE.checkBubbleRequestEmptyTimes(mid)) {
            LogUtils.INSTANCE.e(TAG, "频次命中空数据");
            TrackUtils.INSTANCE.trackBubbleRequestInfo(TiredType2.NULL_DATA.getValue(), (r21 & 2) != 0 ? "" : null, (r21 & 4) != 0 ? "" : null, (r21 & 8) != 0 ? "" : null, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? "" : mid, (r21 & 256) != 0 ? "" : null, (r21 & 512) == 0 ? null : "");
            return new BubbleLocal(true, null, 2, null);
        } else {
            return new BubbleLocal(false, null, 2, null);
        }
    }

    public final boolean shouldFetchBubble$entrance_debug(String mid) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        Instant now = Clock.System.INSTANCE.now();
        long zeroTs = now.toEpochMilliseconds();
        CacheDelegate bubbleCache = getCache(mid);
        BubbleBean bubble = bubbleCache.getValue();
        BubbleLocal localInfo = fetchFromLocal(mid, bubble, zeroTs);
        return !localInfo.getLimit();
    }

    private final void checkFansChanged(String mid, BubbleBean old, BubbleBean bubbleBean) {
        Object obj;
        Object obj2;
        FansShow it;
        FansShow it2;
        if (old == null) {
            return;
        }
        Iterator<T> it3 = BubbleTiredService.INSTANCE.getConfig().getBubbleFansShow().iterator();
        while (true) {
            obj = null;
            if (!it3.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it3.next();
            FansShow it4 = (FansShow) obj2;
            if (old.getFans() < it4.getFanStart() || old.getFans() > it4.getFanEnd()) {
                it2 = null;
                continue;
            } else {
                it2 = 1;
                continue;
            }
            if (it2 != null) {
                break;
            }
        }
        FansShow fansShowConfigOld = (FansShow) obj2;
        Iterator<T> it5 = BubbleTiredService.INSTANCE.getConfig().getBubbleFansShow().iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            FansShow it6 = (FansShow) next;
            if (bubbleBean.getFans() < it6.getFanStart() || bubbleBean.getFans() > it6.getFanEnd()) {
                it = null;
                continue;
            } else {
                it = 1;
                continue;
            }
            if (it != null) {
                obj = next;
                break;
            }
        }
        FansShow fansShowConfigNew = (FansShow) obj;
        LogUtils.INSTANCE.i(TAG, "old.fans=" + old.getFans() + ", new.fans=" + bubbleBean.getFans() + ", configOld.fans=" + (fansShowConfigOld != null ? fansShowConfigOld.getFanStart() : 0) + "~" + (fansShowConfigOld != null ? fansShowConfigOld.getFanEnd() : 0) + ", configNew.fans=" + (fansShowConfigNew != null ? fansShowConfigNew.getFanStart() : 0) + "~" + (fansShowConfigNew != null ? fansShowConfigNew.getFanEnd() : 0));
        if (fansShowConfigOld != null && fansShowConfigNew != null && !Intrinsics.areEqual(fansShowConfigOld, fansShowConfigNew)) {
            BubbleTiredService.INSTANCE.clearData(mid);
        }
    }

    private final CacheDelegate getCache(String mid) {
        return new CacheDelegate("UpperCenterPlusBubbleRequestB.pref", mid + "_uper_bubble_data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UperCenterPlusBubbleService.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bR/\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lkntr/app/upper/entrance/bubble2/service/UperCenterPlusBubbleService$CacheDelegate;", "", "spName", "", "key", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "<set-?>", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean;", "delegate", "getDelegate", "()Lkntr/app/upper/entrance/bubble2/bean/BubbleBean;", "setDelegate", "(Lkntr/app/upper/entrance/bubble2/bean/BubbleBean;)V", "delegate$delegate", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "getValue", "setValue", "", "bubbleBean", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CacheDelegate {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(CacheDelegate.class, "delegate", "getDelegate()Lkntr/app/upper/entrance/bubble2/bean/BubbleBean;", 0))};
        private final SerializableSharedPreferencesProperty delegate$delegate;

        public CacheDelegate(String spName, String key) {
            Intrinsics.checkNotNullParameter(spName, "spName");
            Intrinsics.checkNotNullParameter(key, "key");
            Function0 initializer$iv = new Function0() { // from class: kntr.app.upper.entrance.bubble2.service.UperCenterPlusBubbleService$CacheDelegate$$ExternalSyntheticLambda0
                public final Object invoke() {
                    BubbleBean delegate_delegate$lambda$0;
                    delegate_delegate$lambda$0 = UperCenterPlusBubbleService.CacheDelegate.delegate_delegate$lambda$0();
                    return delegate_delegate$lambda$0;
                }
            };
            this.delegate$delegate = new SerializableSharedPreferencesProperty(spName, false, BuiltinSerializersKt.getNullable(BubbleBean.Companion.serializer()), key, initializer$iv, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BubbleBean delegate_delegate$lambda$0() {
            return null;
        }

        private final BubbleBean getDelegate() {
            return (BubbleBean) this.delegate$delegate.getValue(this, $$delegatedProperties[0]);
        }

        private final void setDelegate(BubbleBean bubbleBean) {
            this.delegate$delegate.setValue(this, $$delegatedProperties[0], bubbleBean);
        }

        public final BubbleBean getValue() {
            return getDelegate();
        }

        public final void setValue(BubbleBean bubbleBean) {
            Intrinsics.checkNotNullParameter(bubbleBean, "bubbleBean");
            setDelegate(bubbleBean);
        }
    }

    public final String removeQueryParameter(String url, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String str = url;
        if (str == null || str.length() == 0) {
            return url;
        }
        URLBuilder urlBuilder = URLUtilsKt.URLBuilder(url);
        urlBuilder.getParameters().remove(key);
        return urlBuilder.buildString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UperCenterPlusBubbleService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/app/upper/entrance/bubble2/service/UperCenterPlusBubbleService$BubbleLocal;", "", "limit", "", "bubble", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean;", "<init>", "(ZLkntr/app/upper/entrance/bubble2/bean/BubbleBean;)V", "getLimit", "()Z", "getBubble", "()Lkntr/app/upper/entrance/bubble2/bean/BubbleBean;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class BubbleLocal {
        private final BubbleBean bubble;
        private final boolean limit;

        public static /* synthetic */ BubbleLocal copy$default(BubbleLocal bubbleLocal, boolean z, BubbleBean bubbleBean, int i, Object obj) {
            if ((i & 1) != 0) {
                z = bubbleLocal.limit;
            }
            if ((i & 2) != 0) {
                bubbleBean = bubbleLocal.bubble;
            }
            return bubbleLocal.copy(z, bubbleBean);
        }

        public final boolean component1() {
            return this.limit;
        }

        public final BubbleBean component2() {
            return this.bubble;
        }

        public final BubbleLocal copy(boolean z, BubbleBean bubbleBean) {
            return new BubbleLocal(z, bubbleBean);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BubbleLocal) {
                BubbleLocal bubbleLocal = (BubbleLocal) obj;
                return this.limit == bubbleLocal.limit && Intrinsics.areEqual(this.bubble, bubbleLocal.bubble);
            }
            return false;
        }

        public int hashCode() {
            return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.limit) * 31) + (this.bubble == null ? 0 : this.bubble.hashCode());
        }

        public String toString() {
            boolean z = this.limit;
            return "BubbleLocal(limit=" + z + ", bubble=" + this.bubble + ")";
        }

        public BubbleLocal(boolean limit, BubbleBean bubble) {
            this.limit = limit;
            this.bubble = bubble;
        }

        public /* synthetic */ BubbleLocal(boolean z, BubbleBean bubbleBean, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : bubbleBean);
        }

        public final boolean getLimit() {
            return this.limit;
        }

        public final BubbleBean getBubble() {
            return this.bubble;
        }
    }
}