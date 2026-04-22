package kntr.app.upper.entrance.bubble2.service;

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
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.bubble.bean.BlacklistBean;
import kntr.app.upper.entrance.utils.LogUtils;
import kntr.base.net.comm.imp.InitHttpsWorldKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: BubbleBlacklistService.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/upper/entrance/bubble2/service/BubbleBlacklistService;", "", "<init>", "()V", "TAG", "", "blacklistCache", "", "", "checkInBlacklist", "", "mid", "resourceId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestBlacklist", "Lkntr/app/upper/entrance/bubble/bean/BlacklistBean;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BubbleBlacklistService {
    public static final BubbleBlacklistService INSTANCE = new BubbleBlacklistService();
    private static final String TAG = "BubbleBlacklistService";
    private static List<Integer> blacklistCache;

    private BubbleBlacklistService() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|8|19|(2:21|22)(6:23|(3:26|(3:28|29|30)|24)|31|32|33|34)))|45|6|7|8|19|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b9, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ba, code lost:
        r3 = kotlin.Result.Companion;
        kotlin.Result.m2636constructorimpl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063 A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:13:0x003a, B:22:0x005f, B:24:0x0063, B:26:0x0069, B:27:0x006c, B:29:0x0070, B:31:0x0075, B:32:0x0093, B:34:0x0099, B:36:0x00ad, B:38:0x00b2, B:16:0x0042, B:18:0x0049), top: B:44:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0070 A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:13:0x003a, B:22:0x005f, B:24:0x0063, B:26:0x0069, B:27:0x006c, B:29:0x0070, B:31:0x0075, B:32:0x0093, B:34:0x0099, B:36:0x00ad, B:38:0x00b2, B:16:0x0042, B:18:0x0049), top: B:44:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0075 A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:13:0x003a, B:22:0x005f, B:24:0x0063, B:26:0x0069, B:27:0x006c, B:29:0x0070, B:31:0x0075, B:32:0x0093, B:34:0x0099, B:36:0x00ad, B:38:0x00b2, B:16:0x0042, B:18:0x0049), top: B:44:0x0023 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkInBlacklist(String mid, String resourceId, Continuation<? super Boolean> continuation) {
        BubbleBlacklistService$checkInBlacklist$1 bubbleBlacklistService$checkInBlacklist$1;
        Object requestBlacklist;
        int i;
        List<Integer> blacklist;
        if (continuation instanceof BubbleBlacklistService$checkInBlacklist$1) {
            bubbleBlacklistService$checkInBlacklist$1 = (BubbleBlacklistService$checkInBlacklist$1) continuation;
            if ((bubbleBlacklistService$checkInBlacklist$1.label & Integer.MIN_VALUE) != 0) {
                bubbleBlacklistService$checkInBlacklist$1.label -= Integer.MIN_VALUE;
                Object $result = bubbleBlacklistService$checkInBlacklist$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (bubbleBlacklistService$checkInBlacklist$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.Companion;
                        if (blacklistCache == null) {
                            BubbleBlacklistService bubbleBlacklistService = INSTANCE;
                            bubbleBlacklistService$checkInBlacklist$1.L$0 = SpillingKt.nullOutSpilledVariable(mid);
                            bubbleBlacklistService$checkInBlacklist$1.L$1 = resourceId;
                            bubbleBlacklistService$checkInBlacklist$1.I$0 = 0;
                            bubbleBlacklistService$checkInBlacklist$1.label = 1;
                            requestBlacklist = bubbleBlacklistService.requestBlacklist(mid, bubbleBlacklistService$checkInBlacklist$1);
                            if (requestBlacklist == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i = 0;
                            BlacklistBean blacklistBean = (BlacklistBean) requestBlacklist;
                            blacklistCache = blacklistBean == null ? blacklistBean.getBlacklist() : null;
                            break;
                        }
                        break;
                    case 1:
                        i = bubbleBlacklistService$checkInBlacklist$1.I$0;
                        resourceId = (String) bubbleBlacklistService$checkInBlacklist$1.L$1;
                        String str = (String) bubbleBlacklistService$checkInBlacklist$1.L$0;
                        ResultKt.throwOnFailure($result);
                        requestBlacklist = $result;
                        BlacklistBean blacklistBean2 = (BlacklistBean) requestBlacklist;
                        blacklistCache = blacklistBean2 == null ? blacklistBean2.getBlacklist() : null;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                blacklist = blacklistCache;
                if (blacklist != null) {
                    return Boxing.boxBoolean(false);
                }
                LogUtils.INSTANCE.i(TAG, "black list:" + blacklist);
                for (Integer num : blacklist) {
                    int b = num.intValue();
                    if (Intrinsics.areEqual(String.valueOf(b), resourceId)) {
                        return Boxing.boxBoolean(true);
                    }
                }
                Result.m2636constructorimpl(Unit.INSTANCE);
                return Boxing.boxBoolean(false);
            }
        }
        bubbleBlacklistService$checkInBlacklist$1 = new BubbleBlacklistService$checkInBlacklist$1(this, continuation);
        Object $result2 = bubbleBlacklistService$checkInBlacklist$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (bubbleBlacklistService$checkInBlacklist$1.label) {
        }
        blacklist = blacklistCache;
        if (blacklist != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0195 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x021a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestBlacklist(String mid, Continuation<? super BlacklistBean> continuation) {
        BubbleBlacklistService$requestBlacklist$1 bubbleBlacklistService$requestBlacklist$1;
        BubbleBlacklistService$requestBlacklist$1 bubbleBlacklistService$requestBlacklist$12;
        String mid2;
        Object execute;
        Url url;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof BubbleBlacklistService$requestBlacklist$1) {
            bubbleBlacklistService$requestBlacklist$1 = (BubbleBlacklistService$requestBlacklist$1) continuation;
            if ((bubbleBlacklistService$requestBlacklist$1.label & Integer.MIN_VALUE) != 0) {
                bubbleBlacklistService$requestBlacklist$1.label -= Integer.MIN_VALUE;
                bubbleBlacklistService$requestBlacklist$12 = bubbleBlacklistService$requestBlacklist$1;
                Object $result = bubbleBlacklistService$requestBlacklist$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (bubbleBlacklistService$requestBlacklist$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        mid2 = mid;
                        if (Intrinsics.areEqual(mid2, "")) {
                            return null;
                        }
                        URLBuilder $this$requestBlacklist_u24lambda_u240 = new URLBuilder(URLProtocol.Companion.getHTTPS(), InitHttpsWorldKt.HOST_MEMBER_BILIBILI_COM, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 508, (DefaultConstructorMarker) null);
                        URLBuilderKt.setEncodedPath($this$requestBlacklist_u24lambda_u240, "/x/app/operation/conf");
                        Url url2 = $this$requestBlacklist_u24lambda_u240.build();
                        HttpClient $this$get_u24default$iv = KtorClientKt.getKtorHttpClient();
                        HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url2);
                        builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                        HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                        bubbleBlacklistService$requestBlacklist$12.L$0 = SpillingKt.nullOutSpilledVariable(mid);
                        bubbleBlacklistService$requestBlacklist$12.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        bubbleBlacklistService$requestBlacklist$12.L$2 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        bubbleBlacklistService$requestBlacklist$12.L$3 = SpillingKt.nullOutSpilledVariable(url2);
                        bubbleBlacklistService$requestBlacklist$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        bubbleBlacklistService$requestBlacklist$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        bubbleBlacklistService$requestBlacklist$12.L$6 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                        bubbleBlacklistService$requestBlacklist$12.L$7 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        bubbleBlacklistService$requestBlacklist$12.I$0 = 0;
                        bubbleBlacklistService$requestBlacklist$12.I$1 = 0;
                        bubbleBlacklistService$requestBlacklist$12.I$2 = 0;
                        bubbleBlacklistService$requestBlacklist$12.I$3 = 0;
                        bubbleBlacklistService$requestBlacklist$12.label = 1;
                        execute = httpStatement.execute(bubbleBlacklistService$requestBlacklist$12);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url = url2;
                        HttpResponse $this$body$iv = (HttpResponse) execute;
                        HttpClientCall call = $this$body$iv.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(BlacklistBean.class)));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        bubbleBlacklistService$requestBlacklist$12.L$0 = SpillingKt.nullOutSpilledVariable(mid2);
                        bubbleBlacklistService$requestBlacklist$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        bubbleBlacklistService$requestBlacklist$12.L$2 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                        bubbleBlacklistService$requestBlacklist$12.L$3 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                        bubbleBlacklistService$requestBlacklist$12.L$4 = null;
                        bubbleBlacklistService$requestBlacklist$12.L$5 = null;
                        bubbleBlacklistService$requestBlacklist$12.L$6 = null;
                        bubbleBlacklistService$requestBlacklist$12.L$7 = null;
                        bubbleBlacklistService$requestBlacklist$12.I$0 = 0;
                        bubbleBlacklistService$requestBlacklist$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, bubbleBlacklistService$requestBlacklist$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                return (BlacklistBean) success.getData();
                            }
                            if (success instanceof KApiResponse.BusinessFailure) {
                                throw new Throwable("KResponse.Failure(" + ((KApiResponse.BusinessFailure) success).getCode() + ", " + ((KApiResponse.BusinessFailure) success).getMessage() + ")");
                            } else if (success instanceof KApiResponse.ServiceUnavailable) {
                                throw new Throwable("KResponse.Unavailable(" + ((KApiResponse.ServiceUnavailable) success).getException().getMessage() + ")");
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.upper.entrance.bubble.bean.BlacklistBean>");
                    case 1:
                        int $i$f$body = bubbleBlacklistService$requestBlacklist$12.I$3;
                        int i = bubbleBlacklistService$requestBlacklist$12.I$2;
                        int i2 = bubbleBlacklistService$requestBlacklist$12.I$1;
                        int i3 = bubbleBlacklistService$requestBlacklist$12.I$0;
                        HttpClient httpClient = (HttpClient) bubbleBlacklistService$requestBlacklist$12.L$7;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) bubbleBlacklistService$requestBlacklist$12.L$6;
                        HttpClient httpClient2 = (HttpClient) bubbleBlacklistService$requestBlacklist$12.L$5;
                        HttpClient httpClient3 = (HttpClient) bubbleBlacklistService$requestBlacklist$12.L$4;
                        Url url3 = (Url) bubbleBlacklistService$requestBlacklist$12.L$3;
                        HttpClient httpClient4 = (HttpClient) bubbleBlacklistService$requestBlacklist$12.L$2;
                        ResultKt.throwOnFailure($result);
                        execute = $result;
                        url = (Url) bubbleBlacklistService$requestBlacklist$12.L$1;
                        mid2 = (String) bubbleBlacklistService$requestBlacklist$12.L$0;
                        HttpResponse $this$body$iv2 = (HttpResponse) execute;
                        HttpClientCall call2 = $this$body$iv2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(BlacklistBean.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        bubbleBlacklistService$requestBlacklist$12.L$0 = SpillingKt.nullOutSpilledVariable(mid2);
                        bubbleBlacklistService$requestBlacklist$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        bubbleBlacklistService$requestBlacklist$12.L$2 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                        bubbleBlacklistService$requestBlacklist$12.L$3 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                        bubbleBlacklistService$requestBlacklist$12.L$4 = null;
                        bubbleBlacklistService$requestBlacklist$12.L$5 = null;
                        bubbleBlacklistService$requestBlacklist$12.L$6 = null;
                        bubbleBlacklistService$requestBlacklist$12.L$7 = null;
                        bubbleBlacklistService$requestBlacklist$12.I$0 = 0;
                        bubbleBlacklistService$requestBlacklist$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, bubbleBlacklistService$requestBlacklist$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i4 = bubbleBlacklistService$requestBlacklist$12.I$0;
                        HttpResponse httpResponse = (HttpResponse) bubbleBlacklistService$requestBlacklist$12.L$3;
                        HttpResponse httpResponse2 = (HttpResponse) bubbleBlacklistService$requestBlacklist$12.L$2;
                        Url url4 = (Url) bubbleBlacklistService$requestBlacklist$12.L$1;
                        String str = (String) bubbleBlacklistService$requestBlacklist$12.L$0;
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        if (bodyNullable == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        bubbleBlacklistService$requestBlacklist$1 = new BubbleBlacklistService$requestBlacklist$1(this, continuation);
        bubbleBlacklistService$requestBlacklist$12 = bubbleBlacklistService$requestBlacklist$1;
        Object $result2 = bubbleBlacklistService$requestBlacklist$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (bubbleBlacklistService$requestBlacklist$12.label) {
        }
    }
}