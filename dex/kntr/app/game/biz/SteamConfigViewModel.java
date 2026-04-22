package kntr.app.game.biz;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.bilibili.biligame.kntr.common.api.BiligameHttpClientKt;
import com.bilibili.biligame.kntr.common.api.BiligameUrlBuilderKt;
import com.bilibili.ktor.KApiResponse;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpUrlEncodedKt;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import java.util.Map;
import kntr.app.game.base.viewmodel.BaseViewModel;
import kntr.app.game.base.viewmodel.event.PageEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: SteamConfig.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR/\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000f¨\u0006 "}, d2 = {"Lkntr/app/game/biz/SteamConfigViewModel;", "Lkntr/app/game/base/viewmodel/BaseViewModel;", "Lkntr/app/game/biz/SteamPrivacyResponse;", "<init>", "()V", "_toastEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", RoomRecommendViewModel.EMPTY_CURSOR, "toastEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getToastEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "<set-?>", "_currentData", "get_currentData", "()Lkntr/app/game/biz/SteamPrivacyResponse;", "set_currentData", "(Lkntr/app/game/biz/SteamPrivacyResponse;)V", "_currentData$delegate", "Landroidx/compose/runtime/MutableState;", "currentData", "getCurrentData", "loadData", "refresh", RoomRecommendViewModel.EMPTY_CURSOR, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unbindSteam", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleFriendCode", "showFriendCode", "checkEmpty", "data", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SteamConfigViewModel extends BaseViewModel<SteamPrivacyResponse> {
    public static final int $stable = 8;
    private final MutableSharedFlow<String> _toastEvent = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    private final SharedFlow<String> toastEvent = FlowKt.asSharedFlow(this._toastEvent);
    private final MutableState _currentData$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    public final SharedFlow<String> getToastEvent() {
        return this.toastEvent;
    }

    private final SteamPrivacyResponse get_currentData() {
        State $this$getValue$iv = this._currentData$delegate;
        return (SteamPrivacyResponse) $this$getValue$iv.getValue();
    }

    private final void set_currentData(SteamPrivacyResponse steamPrivacyResponse) {
        MutableState $this$setValue$iv = this._currentData$delegate;
        $this$setValue$iv.setValue(steamPrivacyResponse);
    }

    public final SteamPrivacyResponse getCurrentData() {
        return get_currentData();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a3 A[Catch: Exception -> 0x022c, TryCatch #3 {Exception -> 0x022c, blocks: (B:48:0x01a3, B:50:0x01aa, B:51:0x01e0, B:53:0x01e4, B:54:0x0205, B:56:0x0209, B:57:0x0212, B:61:0x022e, B:62:0x0236, B:44:0x018b), top: B:82:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x022e A[Catch: Exception -> 0x022c, TryCatch #3 {Exception -> 0x022c, blocks: (B:48:0x01a3, B:50:0x01aa, B:51:0x01e0, B:53:0x01e4, B:54:0x0205, B:56:0x0209, B:57:0x0212, B:61:0x022e, B:62:0x0236, B:44:0x018b), top: B:82:0x018b }] */
    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadData(boolean refresh, Continuation<? super SteamPrivacyResponse> continuation) {
        SteamConfigViewModel$loadData$1 steamConfigViewModel$loadData$1;
        SteamConfigViewModel$loadData$1 steamConfigViewModel$loadData$12;
        SteamPrivacyResponse steamPrivacyResponse;
        boolean refresh2;
        Url url;
        Object execute;
        KType kType;
        Object bodyNullable;
        SteamPrivacyResponse steamPrivacyResponse2;
        if (continuation instanceof SteamConfigViewModel$loadData$1) {
            steamConfigViewModel$loadData$1 = (SteamConfigViewModel$loadData$1) continuation;
            if ((steamConfigViewModel$loadData$1.label & Integer.MIN_VALUE) != 0) {
                steamConfigViewModel$loadData$1.label -= Integer.MIN_VALUE;
                steamConfigViewModel$loadData$12 = steamConfigViewModel$loadData$1;
                Object $result = steamConfigViewModel$loadData$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (steamConfigViewModel$loadData$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            Url url2 = BiligameUrlBuilderKt.buildGameUrl$default("/api/game/steam/detail_info", (Map) null, 2, (Object) null);
                            try {
                                System.out.println((Object) ("SteamConfig: 请求URL: " + url2));
                                HttpClient $this$get_u24default$iv = BiligameHttpClientKt.getBiligameHttpClient();
                                HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                                URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url2);
                                builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                                HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                                try {
                                    steamConfigViewModel$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                    steamConfigViewModel$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                                    steamConfigViewModel$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                                    steamConfigViewModel$loadData$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                                    steamConfigViewModel$loadData$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                                    steamConfigViewModel$loadData$12.L$5 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                                    steamConfigViewModel$loadData$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                                    refresh2 = refresh;
                                } catch (Exception e) {
                                    e = e;
                                    steamPrivacyResponse = null;
                                }
                                try {
                                    steamConfigViewModel$loadData$12.Z$0 = refresh2;
                                    steamConfigViewModel$loadData$12.I$0 = 0;
                                    steamConfigViewModel$loadData$12.I$1 = 0;
                                    steamConfigViewModel$loadData$12.I$2 = 0;
                                    steamConfigViewModel$loadData$12.I$3 = 0;
                                    url = url2;
                                    steamConfigViewModel$loadData$12.label = 1;
                                    execute = httpStatement.execute(steamConfigViewModel$loadData$12);
                                    if (execute == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    try {
                                        HttpResponse httpResponse = (HttpResponse) execute;
                                        System.out.println((Object) ("SteamConfig: HTTP状态码: " + httpResponse.getStatus()));
                                        HttpClientCall call = httpResponse.getCall();
                                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                                        try {
                                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SteamPrivacyResponse.class)));
                                        } catch (Throwable th) {
                                            kType = null;
                                        }
                                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                        steamConfigViewModel$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                                        steamConfigViewModel$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                        steamConfigViewModel$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                        steamPrivacyResponse = null;
                                        try {
                                            steamConfigViewModel$loadData$12.L$3 = null;
                                            steamConfigViewModel$loadData$12.L$4 = null;
                                            steamConfigViewModel$loadData$12.L$5 = null;
                                            steamConfigViewModel$loadData$12.L$6 = null;
                                            steamConfigViewModel$loadData$12.Z$0 = refresh2;
                                            steamConfigViewModel$loadData$12.I$0 = 0;
                                            steamConfigViewModel$loadData$12.label = 2;
                                            bodyNullable = call.bodyNullable(typeInfo, steamConfigViewModel$loadData$12);
                                            if (bodyNullable == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            if (bodyNullable != null) {
                                                KApiResponse.Success success = (KApiResponse) bodyNullable;
                                                if (success instanceof KApiResponse.Success) {
                                                    System.out.println((Object) ("SteamConfig: API成功响应，数据: " + success.getData()));
                                                    set_currentData((SteamPrivacyResponse) success.getData());
                                                    steamPrivacyResponse2 = (SteamPrivacyResponse) success.getData();
                                                } else if (success instanceof KApiResponse.BusinessFailure) {
                                                    System.out.println((Object) ("SteamConfig: 业务失败: " + ((KApiResponse.BusinessFailure) success).getMessage()));
                                                    steamPrivacyResponse2 = steamPrivacyResponse;
                                                } else if (success instanceof KApiResponse.ServiceUnavailable) {
                                                    System.out.println((Object) "SteamConfig: 服务不可用");
                                                    steamPrivacyResponse2 = steamPrivacyResponse;
                                                } else {
                                                    System.out.println((Object) ("SteamConfig: 未知响应类型: " + success));
                                                    steamPrivacyResponse2 = steamPrivacyResponse;
                                                }
                                                return steamPrivacyResponse2;
                                            }
                                            throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.biz.SteamPrivacyResponse>");
                                        } catch (Exception e2) {
                                            e = e2;
                                            System.out.println((Object) ("SteamConfig: 请求异常: " + e.getMessage()));
                                            e.printStackTrace();
                                            return steamPrivacyResponse;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        steamPrivacyResponse = null;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    steamPrivacyResponse = null;
                                    System.out.println((Object) ("SteamConfig: 请求异常: " + e.getMessage()));
                                    e.printStackTrace();
                                    return steamPrivacyResponse;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                steamPrivacyResponse = null;
                                System.out.println((Object) ("SteamConfig: 请求异常: " + e.getMessage()));
                                e.printStackTrace();
                                return steamPrivacyResponse;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            steamPrivacyResponse = null;
                        }
                    case 1:
                        int i = steamConfigViewModel$loadData$12.I$3;
                        int i2 = steamConfigViewModel$loadData$12.I$2;
                        int i3 = steamConfigViewModel$loadData$12.I$1;
                        int i4 = steamConfigViewModel$loadData$12.I$0;
                        boolean refresh3 = steamConfigViewModel$loadData$12.Z$0;
                        HttpClient httpClient = (HttpClient) steamConfigViewModel$loadData$12.L$6;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) steamConfigViewModel$loadData$12.L$5;
                        HttpClient httpClient2 = (HttpClient) steamConfigViewModel$loadData$12.L$4;
                        HttpClient httpClient3 = (HttpClient) steamConfigViewModel$loadData$12.L$3;
                        Url url3 = (Url) steamConfigViewModel$loadData$12.L$2;
                        HttpClient httpClient4 = (HttpClient) steamConfigViewModel$loadData$12.L$1;
                        Url url4 = (Url) steamConfigViewModel$loadData$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            url = url4;
                            execute = $result;
                            refresh2 = refresh3;
                            HttpResponse httpResponse2 = (HttpResponse) execute;
                            System.out.println((Object) ("SteamConfig: HTTP状态码: " + httpResponse2.getStatus()));
                            HttpClientCall call2 = httpResponse2.getCall();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SteamPrivacyResponse.class)));
                            TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                            steamConfigViewModel$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                            steamConfigViewModel$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                            steamConfigViewModel$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                            steamPrivacyResponse = null;
                            steamConfigViewModel$loadData$12.L$3 = null;
                            steamConfigViewModel$loadData$12.L$4 = null;
                            steamConfigViewModel$loadData$12.L$5 = null;
                            steamConfigViewModel$loadData$12.L$6 = null;
                            steamConfigViewModel$loadData$12.Z$0 = refresh2;
                            steamConfigViewModel$loadData$12.I$0 = 0;
                            steamConfigViewModel$loadData$12.label = 2;
                            bodyNullable = call2.bodyNullable(typeInfo2, steamConfigViewModel$loadData$12);
                            if (bodyNullable == coroutine_suspended) {
                            }
                            if (bodyNullable != null) {
                            }
                        } catch (Exception e7) {
                            e = e7;
                            steamPrivacyResponse = null;
                            System.out.println((Object) ("SteamConfig: 请求异常: " + e.getMessage()));
                            e.printStackTrace();
                            return steamPrivacyResponse;
                        }
                        break;
                    case 2:
                        int i5 = steamConfigViewModel$loadData$12.I$0;
                        boolean z = steamConfigViewModel$loadData$12.Z$0;
                        HttpResponse httpResponse3 = (HttpResponse) steamConfigViewModel$loadData$12.L$2;
                        HttpResponse httpResponse4 = (HttpResponse) steamConfigViewModel$loadData$12.L$1;
                        Url url5 = (Url) steamConfigViewModel$loadData$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            bodyNullable = $result;
                            steamPrivacyResponse = null;
                            if (bodyNullable != null) {
                            }
                        } catch (Exception e8) {
                            e = e8;
                            steamPrivacyResponse = null;
                            System.out.println((Object) ("SteamConfig: 请求异常: " + e.getMessage()));
                            e.printStackTrace();
                            return steamPrivacyResponse;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        steamConfigViewModel$loadData$1 = new SteamConfigViewModel$loadData$1(this, continuation);
        steamConfigViewModel$loadData$12 = steamConfigViewModel$loadData$1;
        Object $result2 = steamConfigViewModel$loadData$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (steamConfigViewModel$loadData$12.label) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|151|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0337, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0338, code lost:
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00de, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00df, code lost:
        r2 = r5;
        r4 = r35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0334 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x035d A[Catch: Exception -> 0x036a, TryCatch #5 {Exception -> 0x036a, blocks: (B:108:0x0351, B:114:0x035d, B:115:0x0369), top: B:144:0x02f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02f2 A[Catch: Exception -> 0x036c, TRY_LEAVE, TryCatch #3 {Exception -> 0x036c, blocks: (B:93:0x02f2, B:81:0x0295, B:88:0x02bc), top: B:140:0x0295 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object unbindSteam(Continuation<? super Boolean> continuation) {
        SteamConfigViewModel$unbindSteam$1 steamConfigViewModel$unbindSteam$1;
        SteamConfigViewModel$unbindSteam$1 steamConfigViewModel$unbindSteam$12;
        SteamConfigViewModel steamConfigViewModel;
        MutableSharedFlow<String> mutableSharedFlow;
        String str;
        boolean z;
        Url url;
        Parameters.Companion this_$iv$iv;
        boolean z2;
        KType kType;
        Object execute;
        KType kType2;
        Parameters.Companion this_$iv$iv2;
        SteamConfigViewModel steamConfigViewModel2;
        SteamConfigViewModel steamConfigViewModel3;
        KType kType3;
        Object bodyNullable;
        Url url2;
        SteamConfigViewModel steamConfigViewModel4;
        SteamConfigViewModel steamConfigViewModel5;
        Url url3;
        boolean z3;
        Continuation<? super Boolean> continuation2 = continuation;
        if (continuation2 instanceof SteamConfigViewModel$unbindSteam$1) {
            steamConfigViewModel$unbindSteam$1 = (SteamConfigViewModel$unbindSteam$1) continuation2;
            if ((steamConfigViewModel$unbindSteam$1.label & Integer.MIN_VALUE) != 0) {
                steamConfigViewModel$unbindSteam$1.label -= Integer.MIN_VALUE;
                steamConfigViewModel$unbindSteam$12 = steamConfigViewModel$unbindSteam$1;
                Object $result = steamConfigViewModel$unbindSteam$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                String str2 = "解绑失败";
                switch (steamConfigViewModel$unbindSteam$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            url = BiligameUrlBuilderKt.buildGameUrl$default("/api/game/steam/unbind", (Map) null, 2, (Object) null);
                            HttpClient $this$postFormUrlEncode$iv = BiligameHttpClientKt.getBiligameHttpClient();
                            Continuation<? super Boolean> emptyMap = MapsKt.emptyMap();
                            HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                            URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
                            try {
                                HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getFormUrlEncoded());
                                this_$iv$iv = Parameters.Companion;
                                str = "解绑失败";
                                z2 = false;
                            } catch (Exception e) {
                                e = e;
                                steamConfigViewModel = this;
                                continuation2 = coroutine_suspended;
                            }
                            try {
                                ParametersBuilder $this$postFormUrlEncode_u24lambda_u240_u240$iv = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                                BiligameHttpClientKt.addCommonParamsToBody($this$postFormUrlEncode_u24lambda_u240_u240$iv);
                                Continuation<? super Boolean> continuation3 = emptyMap;
                                for (Map.Entry element$iv$iv : continuation3.entrySet()) {
                                    String it$iv = (String) element$iv$iv.getValue();
                                    if (it$iv != null) {
                                        if (!(it$iv.length() > 0 ? true : z2)) {
                                            it$iv = null;
                                        }
                                        if (it$iv != null) {
                                            String value$iv = it$iv;
                                            this_$iv$iv2 = this_$iv$iv;
                                            BiligameHttpClientKt.put($this$postFormUrlEncode_u24lambda_u240_u240$iv, (String) element$iv$iv.getKey(), value$iv);
                                            this_$iv$iv = this_$iv$iv2;
                                            z2 = false;
                                        }
                                    }
                                    this_$iv$iv2 = this_$iv$iv;
                                    this_$iv$iv = this_$iv$iv2;
                                    z2 = false;
                                }
                                Object body$iv$iv = HttpUrlEncodedKt.formUrlEncode($this$postFormUrlEncode_u24lambda_u240_u240$iv.build());
                                try {
                                    if (body$iv$iv == null) {
                                        try {
                                            httpRequestBuilder.setBody(NullBody.INSTANCE);
                                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                                            try {
                                                kType = Reflection.typeOf(String.class);
                                            } catch (Throwable th) {
                                                kType = null;
                                            }
                                            continuation3 = coroutine_suspended;
                                            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
                                        } catch (Exception e2) {
                                            e = e2;
                                            continuation3 = coroutine_suspended;
                                            steamConfigViewModel = this;
                                            str2 = str;
                                            continuation2 = continuation3;
                                            mutableSharedFlow = steamConfigViewModel._toastEvent;
                                            steamConfigViewModel$unbindSteam$12.L$0 = SpillingKt.nullOutSpilledVariable(e);
                                            steamConfigViewModel$unbindSteam$12.L$1 = null;
                                            steamConfigViewModel$unbindSteam$12.L$2 = null;
                                            steamConfigViewModel$unbindSteam$12.L$3 = null;
                                            steamConfigViewModel$unbindSteam$12.L$4 = null;
                                            steamConfigViewModel$unbindSteam$12.L$5 = null;
                                            steamConfigViewModel$unbindSteam$12.L$6 = null;
                                            steamConfigViewModel$unbindSteam$12.L$7 = null;
                                            steamConfigViewModel$unbindSteam$12.L$8 = null;
                                            steamConfigViewModel$unbindSteam$12.L$9 = null;
                                            steamConfigViewModel$unbindSteam$12.label = 6;
                                            if (mutableSharedFlow.emit(str2, steamConfigViewModel$unbindSteam$12) == continuation2) {
                                            }
                                            z = false;
                                            return Boxing.boxBoolean(z);
                                        }
                                    } else {
                                        continuation3 = coroutine_suspended;
                                        if (body$iv$iv instanceof OutgoingContent) {
                                            httpRequestBuilder.setBody(body$iv$iv);
                                            httpRequestBuilder.setBodyType((TypeInfo) null);
                                        } else {
                                            httpRequestBuilder.setBody(body$iv$iv);
                                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                                            try {
                                                kType2 = Reflection.typeOf(String.class);
                                            } catch (Throwable th2) {
                                                kType2 = null;
                                            }
                                            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kType2));
                                        }
                                    }
                                    httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                    HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$postFormUrlEncode$iv);
                                    steamConfigViewModel$unbindSteam$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                                    steamConfigViewModel$unbindSteam$12.L$1 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                    steamConfigViewModel$unbindSteam$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                                    steamConfigViewModel$unbindSteam$12.L$3 = SpillingKt.nullOutSpilledVariable(emptyMap);
                                    steamConfigViewModel$unbindSteam$12.L$4 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                    steamConfigViewModel$unbindSteam$12.L$5 = SpillingKt.nullOutSpilledVariable(url);
                                    steamConfigViewModel$unbindSteam$12.L$6 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                    steamConfigViewModel$unbindSteam$12.L$7 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                    steamConfigViewModel$unbindSteam$12.L$8 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                    steamConfigViewModel$unbindSteam$12.L$9 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                    steamConfigViewModel$unbindSteam$12.I$0 = 0;
                                    steamConfigViewModel$unbindSteam$12.I$1 = 0;
                                    steamConfigViewModel$unbindSteam$12.I$2 = 0;
                                    steamConfigViewModel$unbindSteam$12.I$3 = 0;
                                    steamConfigViewModel$unbindSteam$12.I$4 = 0;
                                    steamConfigViewModel$unbindSteam$12.label = 1;
                                    execute = httpStatement.execute(steamConfigViewModel$unbindSteam$12);
                                    continuation2 = continuation3;
                                } catch (Exception e3) {
                                    e = e3;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                steamConfigViewModel = this;
                                continuation2 = coroutine_suspended;
                                str2 = str;
                                mutableSharedFlow = steamConfigViewModel._toastEvent;
                                steamConfigViewModel$unbindSteam$12.L$0 = SpillingKt.nullOutSpilledVariable(e);
                                steamConfigViewModel$unbindSteam$12.L$1 = null;
                                steamConfigViewModel$unbindSteam$12.L$2 = null;
                                steamConfigViewModel$unbindSteam$12.L$3 = null;
                                steamConfigViewModel$unbindSteam$12.L$4 = null;
                                steamConfigViewModel$unbindSteam$12.L$5 = null;
                                steamConfigViewModel$unbindSteam$12.L$6 = null;
                                steamConfigViewModel$unbindSteam$12.L$7 = null;
                                steamConfigViewModel$unbindSteam$12.L$8 = null;
                                steamConfigViewModel$unbindSteam$12.L$9 = null;
                                steamConfigViewModel$unbindSteam$12.label = 6;
                                if (mutableSharedFlow.emit(str2, steamConfigViewModel$unbindSteam$12) == continuation2) {
                                }
                                z = false;
                                return Boxing.boxBoolean(z);
                            }
                        } catch (Exception e5) {
                            e = e5;
                            continuation2 = coroutine_suspended;
                            steamConfigViewModel = this;
                        }
                        if (execute == continuation2) {
                            return continuation2;
                        }
                        try {
                            steamConfigViewModel2 = (HttpResponse) execute;
                            steamConfigViewModel3 = steamConfigViewModel2;
                            str2 = steamConfigViewModel3.getCall();
                            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            try {
                                kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Boolean.TYPE)));
                            } catch (Throwable th3) {
                                kType3 = null;
                            }
                            TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                            steamConfigViewModel$unbindSteam$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                            steamConfigViewModel$unbindSteam$12.L$1 = SpillingKt.nullOutSpilledVariable(steamConfigViewModel2);
                            steamConfigViewModel$unbindSteam$12.L$2 = SpillingKt.nullOutSpilledVariable(steamConfigViewModel3);
                            steamConfigViewModel$unbindSteam$12.L$3 = null;
                            steamConfigViewModel$unbindSteam$12.L$4 = null;
                            steamConfigViewModel$unbindSteam$12.L$5 = null;
                            steamConfigViewModel$unbindSteam$12.L$6 = null;
                            steamConfigViewModel$unbindSteam$12.L$7 = null;
                            steamConfigViewModel$unbindSteam$12.L$8 = null;
                            steamConfigViewModel$unbindSteam$12.L$9 = null;
                            steamConfigViewModel$unbindSteam$12.I$0 = 0;
                            steamConfigViewModel$unbindSteam$12.label = 2;
                            bodyNullable = str2.bodyNullable(typeInfo, steamConfigViewModel$unbindSteam$12);
                        } catch (Exception e6) {
                            e = e6;
                            steamConfigViewModel = this;
                            str2 = str;
                            mutableSharedFlow = steamConfigViewModel._toastEvent;
                            steamConfigViewModel$unbindSteam$12.L$0 = SpillingKt.nullOutSpilledVariable(e);
                            steamConfigViewModel$unbindSteam$12.L$1 = null;
                            steamConfigViewModel$unbindSteam$12.L$2 = null;
                            steamConfigViewModel$unbindSteam$12.L$3 = null;
                            steamConfigViewModel$unbindSteam$12.L$4 = null;
                            steamConfigViewModel$unbindSteam$12.L$5 = null;
                            steamConfigViewModel$unbindSteam$12.L$6 = null;
                            steamConfigViewModel$unbindSteam$12.L$7 = null;
                            steamConfigViewModel$unbindSteam$12.L$8 = null;
                            steamConfigViewModel$unbindSteam$12.L$9 = null;
                            steamConfigViewModel$unbindSteam$12.label = 6;
                            if (mutableSharedFlow.emit(str2, steamConfigViewModel$unbindSteam$12) == continuation2) {
                                return continuation2;
                            }
                            z = false;
                            return Boxing.boxBoolean(z);
                        }
                        if (bodyNullable != continuation2) {
                            return continuation2;
                        }
                        url2 = url;
                        steamConfigViewModel = steamConfigViewModel3;
                        try {
                        } catch (Exception e7) {
                            e = e7;
                            mutableSharedFlow = steamConfigViewModel._toastEvent;
                            steamConfigViewModel$unbindSteam$12.L$0 = SpillingKt.nullOutSpilledVariable(e);
                            steamConfigViewModel$unbindSteam$12.L$1 = null;
                            steamConfigViewModel$unbindSteam$12.L$2 = null;
                            steamConfigViewModel$unbindSteam$12.L$3 = null;
                            steamConfigViewModel$unbindSteam$12.L$4 = null;
                            steamConfigViewModel$unbindSteam$12.L$5 = null;
                            steamConfigViewModel$unbindSteam$12.L$6 = null;
                            steamConfigViewModel$unbindSteam$12.L$7 = null;
                            steamConfigViewModel$unbindSteam$12.L$8 = null;
                            steamConfigViewModel$unbindSteam$12.L$9 = null;
                            steamConfigViewModel$unbindSteam$12.label = 6;
                            if (mutableSharedFlow.emit(str2, steamConfigViewModel$unbindSteam$12) == continuation2) {
                            }
                            z = false;
                            return Boxing.boxBoolean(z);
                        }
                        if (bodyNullable == null) {
                            if (!(((KApiResponse) bodyNullable) instanceof KApiResponse.Success)) {
                                MutableSharedFlow<String> mutableSharedFlow2 = this._toastEvent;
                                steamConfigViewModel$unbindSteam$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                steamConfigViewModel$unbindSteam$12.L$1 = SpillingKt.nullOutSpilledVariable(steamConfigViewModel2);
                                steamConfigViewModel$unbindSteam$12.L$2 = null;
                                steamConfigViewModel$unbindSteam$12.label = 5;
                                if (mutableSharedFlow2.emit(str, steamConfigViewModel$unbindSteam$12) == continuation2) {
                                    return continuation2;
                                }
                                z3 = false;
                                z = z3;
                                return Boxing.boxBoolean(z);
                            }
                            steamConfigViewModel4 = this;
                            MutableSharedFlow<String> mutableSharedFlow3 = steamConfigViewModel4._toastEvent;
                            steamConfigViewModel$unbindSteam$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            steamConfigViewModel$unbindSteam$12.L$1 = SpillingKt.nullOutSpilledVariable(steamConfigViewModel2);
                            steamConfigViewModel$unbindSteam$12.L$2 = null;
                            steamConfigViewModel$unbindSteam$12.label = 3;
                            if (mutableSharedFlow3.emit("解绑成功", steamConfigViewModel$unbindSteam$12) == continuation2) {
                                return continuation2;
                            }
                            steamConfigViewModel5 = steamConfigViewModel2;
                            url3 = url2;
                            steamConfigViewModel$unbindSteam$12.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            steamConfigViewModel$unbindSteam$12.L$1 = SpillingKt.nullOutSpilledVariable(steamConfigViewModel5);
                            steamConfigViewModel$unbindSteam$12.label = 4;
                            if (steamConfigViewModel4.dispatch((PageEvent) PageEvent.Refresh.INSTANCE, (Continuation<? super Unit>) steamConfigViewModel$unbindSteam$12) == continuation2) {
                                return continuation2;
                            }
                            z3 = true;
                            z = z3;
                            return Boxing.boxBoolean(z);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kotlin.Boolean>");
                    case 1:
                        int $i$f$body = steamConfigViewModel$unbindSteam$12.I$4;
                        int i = steamConfigViewModel$unbindSteam$12.I$3;
                        int i2 = steamConfigViewModel$unbindSteam$12.I$2;
                        int i3 = steamConfigViewModel$unbindSteam$12.I$1;
                        int i4 = steamConfigViewModel$unbindSteam$12.I$0;
                        HttpClient httpClient = (HttpClient) steamConfigViewModel$unbindSteam$12.L$9;
                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) steamConfigViewModel$unbindSteam$12.L$8;
                        HttpClient httpClient2 = (HttpClient) steamConfigViewModel$unbindSteam$12.L$7;
                        HttpClient httpClient3 = (HttpClient) steamConfigViewModel$unbindSteam$12.L$6;
                        Url url4 = (Url) steamConfigViewModel$unbindSteam$12.L$5;
                        HttpClient httpClient4 = (HttpClient) steamConfigViewModel$unbindSteam$12.L$4;
                        Map map = (Map) steamConfigViewModel$unbindSteam$12.L$3;
                        Url url5 = (Url) steamConfigViewModel$unbindSteam$12.L$2;
                        HttpClient httpClient5 = (HttpClient) steamConfigViewModel$unbindSteam$12.L$1;
                        Url url6 = (Url) steamConfigViewModel$unbindSteam$12.L$0;
                        ResultKt.throwOnFailure($result);
                        execute = $result;
                        continuation2 = coroutine_suspended;
                        str = "解绑失败";
                        url = url6;
                        steamConfigViewModel2 = (HttpResponse) execute;
                        steamConfigViewModel3 = steamConfigViewModel2;
                        str2 = steamConfigViewModel3.getCall();
                        KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Boolean.TYPE)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass32, kType3);
                        steamConfigViewModel$unbindSteam$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        steamConfigViewModel$unbindSteam$12.L$1 = SpillingKt.nullOutSpilledVariable(steamConfigViewModel2);
                        steamConfigViewModel$unbindSteam$12.L$2 = SpillingKt.nullOutSpilledVariable(steamConfigViewModel3);
                        steamConfigViewModel$unbindSteam$12.L$3 = null;
                        steamConfigViewModel$unbindSteam$12.L$4 = null;
                        steamConfigViewModel$unbindSteam$12.L$5 = null;
                        steamConfigViewModel$unbindSteam$12.L$6 = null;
                        steamConfigViewModel$unbindSteam$12.L$7 = null;
                        steamConfigViewModel$unbindSteam$12.L$8 = null;
                        steamConfigViewModel$unbindSteam$12.L$9 = null;
                        steamConfigViewModel$unbindSteam$12.I$0 = 0;
                        steamConfigViewModel$unbindSteam$12.label = 2;
                        bodyNullable = str2.bodyNullable(typeInfo2, steamConfigViewModel$unbindSteam$12);
                        if (bodyNullable != continuation2) {
                        }
                        break;
                    case 2:
                        int i5 = steamConfigViewModel$unbindSteam$12.I$0;
                        HttpResponse httpResponse = (HttpResponse) steamConfigViewModel$unbindSteam$12.L$2;
                        SteamConfigViewModel steamConfigViewModel6 = (HttpResponse) steamConfigViewModel$unbindSteam$12.L$1;
                        url2 = (Url) steamConfigViewModel$unbindSteam$12.L$0;
                        ResultKt.throwOnFailure($result);
                        continuation2 = coroutine_suspended;
                        str = "解绑失败";
                        steamConfigViewModel2 = steamConfigViewModel6;
                        bodyNullable = $result;
                        steamConfigViewModel = $result;
                        if (bodyNullable == null) {
                        }
                        break;
                    case 3:
                        steamConfigViewModel5 = (HttpResponse) steamConfigViewModel$unbindSteam$12.L$1;
                        url3 = (Url) steamConfigViewModel$unbindSteam$12.L$0;
                        ResultKt.throwOnFailure($result);
                        continuation2 = coroutine_suspended;
                        steamConfigViewModel4 = this;
                        steamConfigViewModel$unbindSteam$12.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        steamConfigViewModel$unbindSteam$12.L$1 = SpillingKt.nullOutSpilledVariable(steamConfigViewModel5);
                        steamConfigViewModel$unbindSteam$12.label = 4;
                        if (steamConfigViewModel4.dispatch((PageEvent) PageEvent.Refresh.INSTANCE, (Continuation<? super Unit>) steamConfigViewModel$unbindSteam$12) == continuation2) {
                        }
                        z3 = true;
                        z = z3;
                        return Boxing.boxBoolean(z);
                    case 4:
                        HttpResponse httpResponse2 = (HttpResponse) steamConfigViewModel$unbindSteam$12.L$1;
                        Url url7 = (Url) steamConfigViewModel$unbindSteam$12.L$0;
                        ResultKt.throwOnFailure($result);
                        z3 = true;
                        z = z3;
                        return Boxing.boxBoolean(z);
                    case 5:
                        HttpResponse httpResponse3 = (HttpResponse) steamConfigViewModel$unbindSteam$12.L$1;
                        Url url8 = (Url) steamConfigViewModel$unbindSteam$12.L$0;
                        ResultKt.throwOnFailure($result);
                        z3 = false;
                        z = z3;
                        return Boxing.boxBoolean(z);
                    case 6:
                        Exception exc = (Exception) steamConfigViewModel$unbindSteam$12.L$0;
                        ResultKt.throwOnFailure($result);
                        z = false;
                        return Boxing.boxBoolean(z);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        steamConfigViewModel$unbindSteam$1 = new SteamConfigViewModel$unbindSteam$1(this, continuation2);
        steamConfigViewModel$unbindSteam$12 = steamConfigViewModel$unbindSteam$1;
        Object $result2 = steamConfigViewModel$unbindSteam$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str22 = "解绑失败";
        switch (steamConfigViewModel$unbindSteam$12.label) {
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:32:0x011d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final java.lang.Object toggleFriendCode(boolean r39, kotlin.coroutines.Continuation<? super java.lang.Boolean> r40) {
        /*
            Method dump skipped, instructions count: 1186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.game.biz.SteamConfigViewModel.toggleFriendCode(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    public boolean checkEmpty(SteamPrivacyResponse data) {
        Intrinsics.checkNotNullParameter(data, "data");
        int bindStatus = data.getBindStatus();
        System.out.println((Object) ("SteamConfig: 检查数据是否为空 - bindStatus: " + bindStatus + ", steamId: " + data.getSteamId()));
        System.out.println((Object) ("SteamConfig: checkEmpty返回: false"));
        return false;
    }
}