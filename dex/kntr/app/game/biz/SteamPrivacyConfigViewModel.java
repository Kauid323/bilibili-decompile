package kntr.app.game.biz;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.bilibili.biligame.kntr.common.api.BiligameHttpClientKt;
import com.bilibili.biligame.kntr.common.api.BiligameUrlBuilderKt;
import com.bilibili.ktor.KApiResponse;
import com.bilibili.lib.brouter.uri.Uri;
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
import io.ktor.http.ParametersKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import java.util.Map;
import kntr.app.game.base.bridge.KntrGameReportService;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.viewmodel.BaseViewModel;
import kntr.app.game.base.viewmodel.event.PageEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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

/* compiled from: SteamPrivacyConfig.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u000e\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR/\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u001f"}, d2 = {"Lkntr/app/game/biz/SteamPrivacyConfigViewModel;", "Lkntr/app/game/base/viewmodel/BaseViewModel;", "Lkntr/app/game/biz/SteamPrivacyResponse;", "<init>", "()V", "_toastEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", RoomRecommendViewModel.EMPTY_CURSOR, "toastEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getToastEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "<set-?>", "_currentData", "get_currentData", "()Lkntr/app/game/biz/SteamPrivacyResponse;", "set_currentData", "(Lkntr/app/game/biz/SteamPrivacyResponse;)V", "_currentData$delegate", "Landroidx/compose/runtime/MutableState;", "currentData", "getCurrentData", "loadData", "refresh", RoomRecommendViewModel.EMPTY_CURSOR, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkEmpty", "data", "makePublic", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SteamPrivacyConfigViewModel extends BaseViewModel<SteamPrivacyResponse> {
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
        SteamPrivacyConfigViewModel$loadData$1 steamPrivacyConfigViewModel$loadData$1;
        SteamPrivacyConfigViewModel$loadData$1 steamPrivacyConfigViewModel$loadData$12;
        SteamPrivacyResponse steamPrivacyResponse;
        boolean refresh2;
        Url url;
        Object execute;
        KType kType;
        Object bodyNullable;
        SteamPrivacyResponse steamPrivacyResponse2;
        if (continuation instanceof SteamPrivacyConfigViewModel$loadData$1) {
            steamPrivacyConfigViewModel$loadData$1 = (SteamPrivacyConfigViewModel$loadData$1) continuation;
            if ((steamPrivacyConfigViewModel$loadData$1.label & Integer.MIN_VALUE) != 0) {
                steamPrivacyConfigViewModel$loadData$1.label -= Integer.MIN_VALUE;
                steamPrivacyConfigViewModel$loadData$12 = steamPrivacyConfigViewModel$loadData$1;
                Object $result = steamPrivacyConfigViewModel$loadData$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (steamPrivacyConfigViewModel$loadData$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            Url url2 = BiligameUrlBuilderKt.buildGameUrl$default("/api/game/steam/detail_info", (Map) null, 2, (Object) null);
                            try {
                                System.out.println((Object) ("SteamPrivacyConfig: 请求URL: " + url2));
                                HttpClient $this$get_u24default$iv = BiligameHttpClientKt.getBiligameHttpClient();
                                HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                                URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url2);
                                builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                                HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                                try {
                                    steamPrivacyConfigViewModel$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                    steamPrivacyConfigViewModel$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                                    steamPrivacyConfigViewModel$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                                    steamPrivacyConfigViewModel$loadData$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                                    steamPrivacyConfigViewModel$loadData$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                                    steamPrivacyConfigViewModel$loadData$12.L$5 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                                    steamPrivacyConfigViewModel$loadData$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                                    refresh2 = refresh;
                                } catch (Exception e) {
                                    e = e;
                                    steamPrivacyResponse = null;
                                }
                                try {
                                    steamPrivacyConfigViewModel$loadData$12.Z$0 = refresh2;
                                    steamPrivacyConfigViewModel$loadData$12.I$0 = 0;
                                    steamPrivacyConfigViewModel$loadData$12.I$1 = 0;
                                    steamPrivacyConfigViewModel$loadData$12.I$2 = 0;
                                    steamPrivacyConfigViewModel$loadData$12.I$3 = 0;
                                    url = url2;
                                    steamPrivacyConfigViewModel$loadData$12.label = 1;
                                    execute = httpStatement.execute(steamPrivacyConfigViewModel$loadData$12);
                                    if (execute == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    try {
                                        HttpResponse httpResponse = (HttpResponse) execute;
                                        System.out.println((Object) ("SteamPrivacyConfig: HTTP状态码: " + httpResponse.getStatus()));
                                        HttpClientCall call = httpResponse.getCall();
                                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                                        try {
                                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SteamPrivacyResponse.class)));
                                        } catch (Throwable th) {
                                            kType = null;
                                        }
                                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                        steamPrivacyConfigViewModel$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                                        steamPrivacyConfigViewModel$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                        steamPrivacyConfigViewModel$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                        steamPrivacyResponse = null;
                                        try {
                                            steamPrivacyConfigViewModel$loadData$12.L$3 = null;
                                            steamPrivacyConfigViewModel$loadData$12.L$4 = null;
                                            steamPrivacyConfigViewModel$loadData$12.L$5 = null;
                                            steamPrivacyConfigViewModel$loadData$12.L$6 = null;
                                            steamPrivacyConfigViewModel$loadData$12.Z$0 = refresh2;
                                            steamPrivacyConfigViewModel$loadData$12.I$0 = 0;
                                            steamPrivacyConfigViewModel$loadData$12.label = 2;
                                            bodyNullable = call.bodyNullable(typeInfo, steamPrivacyConfigViewModel$loadData$12);
                                            if (bodyNullable == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            if (bodyNullable != null) {
                                                KApiResponse.Success success = (KApiResponse) bodyNullable;
                                                if (success instanceof KApiResponse.Success) {
                                                    System.out.println((Object) ("SteamPrivacyConfig: API成功响应，数据: " + success.getData()));
                                                    set_currentData((SteamPrivacyResponse) success.getData());
                                                    steamPrivacyResponse2 = (SteamPrivacyResponse) success.getData();
                                                } else if (success instanceof KApiResponse.BusinessFailure) {
                                                    System.out.println((Object) ("SteamPrivacyConfig: 业务失败: " + ((KApiResponse.BusinessFailure) success).getMessage()));
                                                    steamPrivacyResponse2 = steamPrivacyResponse;
                                                } else if (success instanceof KApiResponse.ServiceUnavailable) {
                                                    System.out.println((Object) "SteamPrivacyConfig: 服务不可用");
                                                    steamPrivacyResponse2 = steamPrivacyResponse;
                                                } else {
                                                    System.out.println((Object) ("SteamPrivacyConfig: 未知响应类型: " + success));
                                                    steamPrivacyResponse2 = steamPrivacyResponse;
                                                }
                                                return steamPrivacyResponse2;
                                            }
                                            throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.biz.SteamPrivacyResponse>");
                                        } catch (Exception e2) {
                                            e = e2;
                                            System.out.println((Object) ("SteamPrivacyConfig: 请求异常: " + e.getMessage()));
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
                                    System.out.println((Object) ("SteamPrivacyConfig: 请求异常: " + e.getMessage()));
                                    e.printStackTrace();
                                    return steamPrivacyResponse;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                steamPrivacyResponse = null;
                                System.out.println((Object) ("SteamPrivacyConfig: 请求异常: " + e.getMessage()));
                                e.printStackTrace();
                                return steamPrivacyResponse;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            steamPrivacyResponse = null;
                        }
                    case 1:
                        int i = steamPrivacyConfigViewModel$loadData$12.I$3;
                        int i2 = steamPrivacyConfigViewModel$loadData$12.I$2;
                        int i3 = steamPrivacyConfigViewModel$loadData$12.I$1;
                        int i4 = steamPrivacyConfigViewModel$loadData$12.I$0;
                        boolean refresh3 = steamPrivacyConfigViewModel$loadData$12.Z$0;
                        HttpClient httpClient = (HttpClient) steamPrivacyConfigViewModel$loadData$12.L$6;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) steamPrivacyConfigViewModel$loadData$12.L$5;
                        HttpClient httpClient2 = (HttpClient) steamPrivacyConfigViewModel$loadData$12.L$4;
                        HttpClient httpClient3 = (HttpClient) steamPrivacyConfigViewModel$loadData$12.L$3;
                        Url url3 = (Url) steamPrivacyConfigViewModel$loadData$12.L$2;
                        HttpClient httpClient4 = (HttpClient) steamPrivacyConfigViewModel$loadData$12.L$1;
                        Url url4 = (Url) steamPrivacyConfigViewModel$loadData$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            url = url4;
                            execute = $result;
                            refresh2 = refresh3;
                            HttpResponse httpResponse2 = (HttpResponse) execute;
                            System.out.println((Object) ("SteamPrivacyConfig: HTTP状态码: " + httpResponse2.getStatus()));
                            HttpClientCall call2 = httpResponse2.getCall();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SteamPrivacyResponse.class)));
                            TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                            steamPrivacyConfigViewModel$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                            steamPrivacyConfigViewModel$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                            steamPrivacyConfigViewModel$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                            steamPrivacyResponse = null;
                            steamPrivacyConfigViewModel$loadData$12.L$3 = null;
                            steamPrivacyConfigViewModel$loadData$12.L$4 = null;
                            steamPrivacyConfigViewModel$loadData$12.L$5 = null;
                            steamPrivacyConfigViewModel$loadData$12.L$6 = null;
                            steamPrivacyConfigViewModel$loadData$12.Z$0 = refresh2;
                            steamPrivacyConfigViewModel$loadData$12.I$0 = 0;
                            steamPrivacyConfigViewModel$loadData$12.label = 2;
                            bodyNullable = call2.bodyNullable(typeInfo2, steamPrivacyConfigViewModel$loadData$12);
                            if (bodyNullable == coroutine_suspended) {
                            }
                            if (bodyNullable != null) {
                            }
                        } catch (Exception e7) {
                            e = e7;
                            steamPrivacyResponse = null;
                            System.out.println((Object) ("SteamPrivacyConfig: 请求异常: " + e.getMessage()));
                            e.printStackTrace();
                            return steamPrivacyResponse;
                        }
                        break;
                    case 2:
                        int i5 = steamPrivacyConfigViewModel$loadData$12.I$0;
                        boolean z = steamPrivacyConfigViewModel$loadData$12.Z$0;
                        HttpResponse httpResponse3 = (HttpResponse) steamPrivacyConfigViewModel$loadData$12.L$2;
                        HttpResponse httpResponse4 = (HttpResponse) steamPrivacyConfigViewModel$loadData$12.L$1;
                        Url url5 = (Url) steamPrivacyConfigViewModel$loadData$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            bodyNullable = $result;
                            steamPrivacyResponse = null;
                            if (bodyNullable != null) {
                            }
                        } catch (Exception e8) {
                            e = e8;
                            steamPrivacyResponse = null;
                            System.out.println((Object) ("SteamPrivacyConfig: 请求异常: " + e.getMessage()));
                            e.printStackTrace();
                            return steamPrivacyResponse;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        steamPrivacyConfigViewModel$loadData$1 = new SteamPrivacyConfigViewModel$loadData$1(this, continuation);
        steamPrivacyConfigViewModel$loadData$12 = steamPrivacyConfigViewModel$loadData$1;
        Object $result2 = steamPrivacyConfigViewModel$loadData$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (steamPrivacyConfigViewModel$loadData$12.label) {
        }
    }

    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    public boolean checkEmpty(SteamPrivacyResponse data) {
        Intrinsics.checkNotNullParameter(data, "data");
        int bindStatus = data.getBindStatus();
        System.out.println((Object) ("SteamPrivacyConfig: 检查数据是否为空 - bindStatus: " + bindStatus + ", steamId: " + data.getSteamId()));
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|183|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x03c0, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0120, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0121, code lost:
        r2 = r5;
        r5 = "公开失败";
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x035d A[Catch: Exception -> 0x04f1, TryCatch #11 {Exception -> 0x04f1, blocks: (B:101:0x035d, B:103:0x0364, B:105:0x0373, B:89:0x02e4, B:96:0x0327), top: B:185:0x02e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x04e2 A[Catch: Exception -> 0x04ef, TryCatch #3 {Exception -> 0x04ef, blocks: (B:119:0x03e5, B:124:0x03ef, B:126:0x03f7, B:128:0x0432, B:129:0x045b, B:134:0x047c, B:136:0x0480, B:141:0x04a8, B:146:0x04e2, B:147:0x04ee), top: B:170:0x035b }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x054f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0358 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0359  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object makePublic(Continuation<? super Unit> continuation) {
        SteamPrivacyConfigViewModel$makePublic$1 steamPrivacyConfigViewModel$makePublic$1;
        SteamPrivacyConfigViewModel$makePublic$1 steamPrivacyConfigViewModel$makePublic$12;
        HttpClientCall httpClientCall;
        MutableSharedFlow<String> mutableSharedFlow;
        Object obj;
        Url url;
        KType kType;
        Object execute;
        KType kType2;
        HttpClientCall call;
        KType kType3;
        Object bodyNullable;
        Url url2;
        SteamPrivacyConfigViewModel steamPrivacyConfigViewModel;
        KApiResponse response;
        Url url3;
        SteamPrivacyConfigViewModel steamPrivacyConfigViewModel2 = this;
        Continuation<? super Unit> continuation2 = continuation;
        if (continuation2 instanceof SteamPrivacyConfigViewModel$makePublic$1) {
            steamPrivacyConfigViewModel$makePublic$1 = (SteamPrivacyConfigViewModel$makePublic$1) continuation2;
            if ((steamPrivacyConfigViewModel$makePublic$1.label & Integer.MIN_VALUE) != 0) {
                steamPrivacyConfigViewModel$makePublic$1.label -= Integer.MIN_VALUE;
                steamPrivacyConfigViewModel$makePublic$12 = steamPrivacyConfigViewModel$makePublic$1;
                Object $result = steamPrivacyConfigViewModel$makePublic$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (steamPrivacyConfigViewModel$makePublic$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            url = BiligameUrlBuilderKt.buildGameUrl$default("/api/game/steam/privacy/public", (Map) null, 2, (Object) null);
                            System.out.println((Object) ("SteamPrivacyConfig: 调用公开接口: " + url));
                            HttpClient $this$postFormUrlEncode$iv = BiligameHttpClientKt.getBiligameHttpClient();
                            Map params$iv = MapsKt.emptyMap();
                            HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                            URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
                            try {
                                HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getFormUrlEncoded());
                                Parameters.Companion companion = Parameters.Companion;
                                boolean z = false;
                                boolean z2 = true;
                                obj = "公开失败";
                                try {
                                    Continuation<? super Unit> ParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                                    BiligameHttpClientKt.addCommonParamsToBody(ParametersBuilder$default);
                                    for (Map.Entry element$iv$iv : params$iv.entrySet()) {
                                        String it$iv = (String) element$iv$iv.getValue();
                                        if (it$iv != null) {
                                            if (!(it$iv.length() > 0 ? z2 : z)) {
                                                it$iv = null;
                                            }
                                            if (it$iv != null) {
                                                String value$iv = it$iv;
                                                BiligameHttpClientKt.put(ParametersBuilder$default, (String) element$iv$iv.getKey(), value$iv);
                                            }
                                        }
                                        z = false;
                                        z2 = true;
                                    }
                                    Object body$iv$iv = HttpUrlEncodedKt.formUrlEncode(ParametersBuilder$default.build());
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
                                                ParametersBuilder$default = coroutine_suspended;
                                                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
                                            } catch (Exception e) {
                                                e = e;
                                                ParametersBuilder$default = coroutine_suspended;
                                                steamPrivacyConfigViewModel2 = this;
                                                httpClientCall = obj;
                                                continuation2 = ParametersBuilder$default;
                                                System.out.println((Object) ("SteamPrivacyConfig: 公开接口异常: " + e.getMessage()));
                                                e.printStackTrace();
                                                mutableSharedFlow = steamPrivacyConfigViewModel2._toastEvent;
                                                steamPrivacyConfigViewModel$makePublic$12.L$0 = SpillingKt.nullOutSpilledVariable(e);
                                                steamPrivacyConfigViewModel$makePublic$12.L$1 = null;
                                                steamPrivacyConfigViewModel$makePublic$12.L$2 = null;
                                                steamPrivacyConfigViewModel$makePublic$12.L$3 = null;
                                                steamPrivacyConfigViewModel$makePublic$12.L$4 = null;
                                                steamPrivacyConfigViewModel$makePublic$12.L$5 = null;
                                                steamPrivacyConfigViewModel$makePublic$12.L$6 = null;
                                                steamPrivacyConfigViewModel$makePublic$12.L$7 = null;
                                                steamPrivacyConfigViewModel$makePublic$12.L$8 = null;
                                                steamPrivacyConfigViewModel$makePublic$12.L$9 = null;
                                                steamPrivacyConfigViewModel$makePublic$12.label = 9;
                                                if (mutableSharedFlow.emit(httpClientCall, steamPrivacyConfigViewModel$makePublic$12) == continuation2) {
                                                }
                                            }
                                        } else {
                                            ParametersBuilder$default = coroutine_suspended;
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
                                        steamPrivacyConfigViewModel$makePublic$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                                        steamPrivacyConfigViewModel$makePublic$12.L$1 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                        steamPrivacyConfigViewModel$makePublic$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                                        steamPrivacyConfigViewModel$makePublic$12.L$3 = SpillingKt.nullOutSpilledVariable(params$iv);
                                        steamPrivacyConfigViewModel$makePublic$12.L$4 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                        steamPrivacyConfigViewModel$makePublic$12.L$5 = SpillingKt.nullOutSpilledVariable(url);
                                        steamPrivacyConfigViewModel$makePublic$12.L$6 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                        steamPrivacyConfigViewModel$makePublic$12.L$7 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                        steamPrivacyConfigViewModel$makePublic$12.L$8 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                        steamPrivacyConfigViewModel$makePublic$12.L$9 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                        steamPrivacyConfigViewModel$makePublic$12.I$0 = 0;
                                        steamPrivacyConfigViewModel$makePublic$12.I$1 = 0;
                                        steamPrivacyConfigViewModel$makePublic$12.I$2 = 0;
                                        steamPrivacyConfigViewModel$makePublic$12.I$3 = 0;
                                        steamPrivacyConfigViewModel$makePublic$12.I$4 = 0;
                                        steamPrivacyConfigViewModel$makePublic$12.label = 1;
                                        execute = httpStatement.execute(steamPrivacyConfigViewModel$makePublic$12);
                                        continuation2 = ParametersBuilder$default;
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    continuation2 = coroutine_suspended;
                                    httpClientCall = obj;
                                    System.out.println((Object) ("SteamPrivacyConfig: 公开接口异常: " + e.getMessage()));
                                    e.printStackTrace();
                                    mutableSharedFlow = steamPrivacyConfigViewModel2._toastEvent;
                                    steamPrivacyConfigViewModel$makePublic$12.L$0 = SpillingKt.nullOutSpilledVariable(e);
                                    steamPrivacyConfigViewModel$makePublic$12.L$1 = null;
                                    steamPrivacyConfigViewModel$makePublic$12.L$2 = null;
                                    steamPrivacyConfigViewModel$makePublic$12.L$3 = null;
                                    steamPrivacyConfigViewModel$makePublic$12.L$4 = null;
                                    steamPrivacyConfigViewModel$makePublic$12.L$5 = null;
                                    steamPrivacyConfigViewModel$makePublic$12.L$6 = null;
                                    steamPrivacyConfigViewModel$makePublic$12.L$7 = null;
                                    steamPrivacyConfigViewModel$makePublic$12.L$8 = null;
                                    steamPrivacyConfigViewModel$makePublic$12.L$9 = null;
                                    steamPrivacyConfigViewModel$makePublic$12.label = 9;
                                    if (mutableSharedFlow.emit(httpClientCall, steamPrivacyConfigViewModel$makePublic$12) == continuation2) {
                                        return continuation2;
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                continuation2 = coroutine_suspended;
                                httpClientCall = "公开失败";
                            }
                        } catch (Exception e5) {
                            e = e5;
                            continuation2 = coroutine_suspended;
                            httpClientCall = "公开失败";
                        }
                        if (execute == continuation2) {
                            return continuation2;
                        }
                        try {
                            steamPrivacyConfigViewModel2 = (HttpResponse) execute;
                            System.out.println((Object) ("SteamPrivacyConfig: 公开接口HTTP状态码: " + steamPrivacyConfigViewModel2.getStatus()));
                            call = steamPrivacyConfigViewModel2.getCall();
                            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            try {
                                kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(ActionResult.class)));
                            } catch (Throwable th3) {
                                kType3 = null;
                            }
                            TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                            steamPrivacyConfigViewModel$makePublic$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                            steamPrivacyConfigViewModel$makePublic$12.L$1 = SpillingKt.nullOutSpilledVariable(steamPrivacyConfigViewModel2);
                            steamPrivacyConfigViewModel$makePublic$12.L$2 = SpillingKt.nullOutSpilledVariable(steamPrivacyConfigViewModel2);
                            steamPrivacyConfigViewModel$makePublic$12.L$3 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$4 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$5 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$6 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$7 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$8 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$9 = null;
                            steamPrivacyConfigViewModel$makePublic$12.I$0 = 0;
                            steamPrivacyConfigViewModel$makePublic$12.label = 2;
                            bodyNullable = call.bodyNullable(typeInfo, steamPrivacyConfigViewModel$makePublic$12);
                        } catch (Exception e6) {
                            e = e6;
                            steamPrivacyConfigViewModel2 = this;
                            httpClientCall = obj;
                            System.out.println((Object) ("SteamPrivacyConfig: 公开接口异常: " + e.getMessage()));
                            e.printStackTrace();
                            mutableSharedFlow = steamPrivacyConfigViewModel2._toastEvent;
                            steamPrivacyConfigViewModel$makePublic$12.L$0 = SpillingKt.nullOutSpilledVariable(e);
                            steamPrivacyConfigViewModel$makePublic$12.L$1 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$2 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$3 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$4 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$5 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$6 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$7 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$8 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$9 = null;
                            steamPrivacyConfigViewModel$makePublic$12.label = 9;
                            if (mutableSharedFlow.emit(httpClientCall, steamPrivacyConfigViewModel$makePublic$12) == continuation2) {
                            }
                        }
                        if (bodyNullable != continuation2) {
                            return continuation2;
                        }
                        url2 = url;
                        steamPrivacyConfigViewModel = steamPrivacyConfigViewModel2;
                        httpClientCall = call;
                        try {
                        } catch (Exception e7) {
                            e = e7;
                            System.out.println((Object) ("SteamPrivacyConfig: 公开接口异常: " + e.getMessage()));
                            e.printStackTrace();
                            mutableSharedFlow = steamPrivacyConfigViewModel2._toastEvent;
                            steamPrivacyConfigViewModel$makePublic$12.L$0 = SpillingKt.nullOutSpilledVariable(e);
                            steamPrivacyConfigViewModel$makePublic$12.L$1 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$2 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$3 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$4 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$5 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$6 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$7 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$8 = null;
                            steamPrivacyConfigViewModel$makePublic$12.L$9 = null;
                            steamPrivacyConfigViewModel$makePublic$12.label = 9;
                            if (mutableSharedFlow.emit(httpClientCall, steamPrivacyConfigViewModel$makePublic$12) == continuation2) {
                            }
                        }
                        if (bodyNullable != null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.biz.ActionResult>");
                        }
                        response = (KApiResponse) bodyNullable;
                        if (response instanceof KApiResponse.Success) {
                            if (!((ActionResult) ((KApiResponse.Success) response).getData()).getSuccess()) {
                                System.out.println((Object) "SteamPrivacyConfig: 公开失败 - success为false");
                                MutableSharedFlow<String> mutableSharedFlow2 = this._toastEvent;
                                steamPrivacyConfigViewModel$makePublic$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                steamPrivacyConfigViewModel$makePublic$12.L$1 = SpillingKt.nullOutSpilledVariable(steamPrivacyConfigViewModel);
                                steamPrivacyConfigViewModel$makePublic$12.L$2 = SpillingKt.nullOutSpilledVariable(response);
                                steamPrivacyConfigViewModel$makePublic$12.label = 5;
                                return mutableSharedFlow2.emit(obj, steamPrivacyConfigViewModel$makePublic$12) == continuation2 ? continuation2 : Unit.INSTANCE;
                            }
                            System.out.println((Object) "SteamPrivacyConfig: 公开成功");
                            steamPrivacyConfigViewModel2 = this;
                            MutableSharedFlow<String> mutableSharedFlow3 = steamPrivacyConfigViewModel2._toastEvent;
                            steamPrivacyConfigViewModel$makePublic$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            steamPrivacyConfigViewModel$makePublic$12.L$1 = SpillingKt.nullOutSpilledVariable(steamPrivacyConfigViewModel);
                            steamPrivacyConfigViewModel$makePublic$12.L$2 = SpillingKt.nullOutSpilledVariable(response);
                            steamPrivacyConfigViewModel$makePublic$12.label = 3;
                            if (mutableSharedFlow3.emit("公开成功", steamPrivacyConfigViewModel$makePublic$12) == continuation2) {
                                return continuation2;
                            }
                            url3 = url2;
                            steamPrivacyConfigViewModel$makePublic$12.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            steamPrivacyConfigViewModel$makePublic$12.L$1 = SpillingKt.nullOutSpilledVariable(steamPrivacyConfigViewModel);
                            steamPrivacyConfigViewModel$makePublic$12.L$2 = SpillingKt.nullOutSpilledVariable(response);
                            steamPrivacyConfigViewModel$makePublic$12.label = 4;
                            if (steamPrivacyConfigViewModel2.dispatch((PageEvent) PageEvent.Refresh.INSTANCE, (Continuation<? super Unit>) steamPrivacyConfigViewModel$makePublic$12) == continuation2) {
                                return continuation2;
                            }
                        }
                        Object obj2 = obj;
                        if (response instanceof KApiResponse.BusinessFailure) {
                            System.out.println((Object) ("SteamPrivacyConfig: 公开失败 - 业务错误: " + ((KApiResponse.BusinessFailure) response).getMessage() + ", 错误码: " + ((KApiResponse.BusinessFailure) response).getCode()));
                            if (((KApiResponse.BusinessFailure) response).getCode() == -13016) {
                                RouterHelperKt.openUrl$default(Uri.Companion.parse("https://gmds.biligame.com/?bound_source=2").buildUpon().appendQueryParameter("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom()).build().toString(), null, 2, null);
                            }
                            MutableSharedFlow<String> mutableSharedFlow4 = this._toastEvent;
                            steamPrivacyConfigViewModel$makePublic$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            steamPrivacyConfigViewModel$makePublic$12.L$1 = SpillingKt.nullOutSpilledVariable(steamPrivacyConfigViewModel);
                            steamPrivacyConfigViewModel$makePublic$12.L$2 = SpillingKt.nullOutSpilledVariable(response);
                            steamPrivacyConfigViewModel$makePublic$12.label = 6;
                            if (mutableSharedFlow4.emit(obj2, steamPrivacyConfigViewModel$makePublic$12) == continuation2) {
                                return continuation2;
                            }
                        } else if (response instanceof KApiResponse.ServiceUnavailable) {
                            System.out.println((Object) "SteamPrivacyConfig: 公开失败 - 服务不可用");
                            MutableSharedFlow<String> mutableSharedFlow5 = this._toastEvent;
                            steamPrivacyConfigViewModel$makePublic$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            steamPrivacyConfigViewModel$makePublic$12.L$1 = SpillingKt.nullOutSpilledVariable(steamPrivacyConfigViewModel);
                            steamPrivacyConfigViewModel$makePublic$12.L$2 = SpillingKt.nullOutSpilledVariable(response);
                            steamPrivacyConfigViewModel$makePublic$12.label = 7;
                            if (mutableSharedFlow5.emit(obj2, steamPrivacyConfigViewModel$makePublic$12) == continuation2) {
                                return continuation2;
                            }
                        } else {
                            System.out.println((Object) ("SteamPrivacyConfig: 公开失败 - 未知响应类型: " + response));
                            MutableSharedFlow<String> mutableSharedFlow6 = this._toastEvent;
                            steamPrivacyConfigViewModel$makePublic$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            steamPrivacyConfigViewModel$makePublic$12.L$1 = SpillingKt.nullOutSpilledVariable(steamPrivacyConfigViewModel);
                            steamPrivacyConfigViewModel$makePublic$12.L$2 = SpillingKt.nullOutSpilledVariable(response);
                            steamPrivacyConfigViewModel$makePublic$12.label = 8;
                            if (mutableSharedFlow6.emit(obj2, steamPrivacyConfigViewModel$makePublic$12) == continuation2) {
                                return continuation2;
                            }
                        }
                    case 1:
                        int $i$f$body = steamPrivacyConfigViewModel$makePublic$12.I$4;
                        int i = steamPrivacyConfigViewModel$makePublic$12.I$3;
                        int i2 = steamPrivacyConfigViewModel$makePublic$12.I$2;
                        int i3 = steamPrivacyConfigViewModel$makePublic$12.I$1;
                        int i4 = steamPrivacyConfigViewModel$makePublic$12.I$0;
                        HttpClient httpClient = (HttpClient) steamPrivacyConfigViewModel$makePublic$12.L$9;
                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) steamPrivacyConfigViewModel$makePublic$12.L$8;
                        HttpClient httpClient2 = (HttpClient) steamPrivacyConfigViewModel$makePublic$12.L$7;
                        HttpClient httpClient3 = (HttpClient) steamPrivacyConfigViewModel$makePublic$12.L$6;
                        Url url4 = (Url) steamPrivacyConfigViewModel$makePublic$12.L$5;
                        HttpClient httpClient4 = (HttpClient) steamPrivacyConfigViewModel$makePublic$12.L$4;
                        Map map = (Map) steamPrivacyConfigViewModel$makePublic$12.L$3;
                        Url url5 = (Url) steamPrivacyConfigViewModel$makePublic$12.L$2;
                        HttpClient httpClient5 = (HttpClient) steamPrivacyConfigViewModel$makePublic$12.L$1;
                        Url url6 = (Url) steamPrivacyConfigViewModel$makePublic$12.L$0;
                        ResultKt.throwOnFailure($result);
                        execute = $result;
                        continuation2 = coroutine_suspended;
                        obj = "公开失败";
                        url = url6;
                        steamPrivacyConfigViewModel2 = (HttpResponse) execute;
                        System.out.println((Object) ("SteamPrivacyConfig: 公开接口HTTP状态码: " + steamPrivacyConfigViewModel2.getStatus()));
                        call = steamPrivacyConfigViewModel2.getCall();
                        KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(ActionResult.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass32, kType3);
                        steamPrivacyConfigViewModel$makePublic$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        steamPrivacyConfigViewModel$makePublic$12.L$1 = SpillingKt.nullOutSpilledVariable(steamPrivacyConfigViewModel2);
                        steamPrivacyConfigViewModel$makePublic$12.L$2 = SpillingKt.nullOutSpilledVariable(steamPrivacyConfigViewModel2);
                        steamPrivacyConfigViewModel$makePublic$12.L$3 = null;
                        steamPrivacyConfigViewModel$makePublic$12.L$4 = null;
                        steamPrivacyConfigViewModel$makePublic$12.L$5 = null;
                        steamPrivacyConfigViewModel$makePublic$12.L$6 = null;
                        steamPrivacyConfigViewModel$makePublic$12.L$7 = null;
                        steamPrivacyConfigViewModel$makePublic$12.L$8 = null;
                        steamPrivacyConfigViewModel$makePublic$12.L$9 = null;
                        steamPrivacyConfigViewModel$makePublic$12.I$0 = 0;
                        steamPrivacyConfigViewModel$makePublic$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo2, steamPrivacyConfigViewModel$makePublic$12);
                        if (bodyNullable != continuation2) {
                        }
                        break;
                    case 2:
                        int i5 = steamPrivacyConfigViewModel$makePublic$12.I$0;
                        HttpResponse httpResponse = (HttpResponse) steamPrivacyConfigViewModel$makePublic$12.L$2;
                        SteamPrivacyConfigViewModel steamPrivacyConfigViewModel3 = (HttpResponse) steamPrivacyConfigViewModel$makePublic$12.L$1;
                        url2 = (Url) steamPrivacyConfigViewModel$makePublic$12.L$0;
                        ResultKt.throwOnFailure($result);
                        continuation2 = coroutine_suspended;
                        obj = "公开失败";
                        steamPrivacyConfigViewModel = steamPrivacyConfigViewModel3;
                        bodyNullable = $result;
                        httpClientCall = coroutine_suspended;
                        if (bodyNullable != null) {
                        }
                        break;
                    case 3:
                        response = (KApiResponse) steamPrivacyConfigViewModel$makePublic$12.L$2;
                        steamPrivacyConfigViewModel = (HttpResponse) steamPrivacyConfigViewModel$makePublic$12.L$1;
                        url3 = (Url) steamPrivacyConfigViewModel$makePublic$12.L$0;
                        ResultKt.throwOnFailure($result);
                        continuation2 = coroutine_suspended;
                        steamPrivacyConfigViewModel$makePublic$12.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        steamPrivacyConfigViewModel$makePublic$12.L$1 = SpillingKt.nullOutSpilledVariable(steamPrivacyConfigViewModel);
                        steamPrivacyConfigViewModel$makePublic$12.L$2 = SpillingKt.nullOutSpilledVariable(response);
                        steamPrivacyConfigViewModel$makePublic$12.label = 4;
                        if (steamPrivacyConfigViewModel2.dispatch((PageEvent) PageEvent.Refresh.INSTANCE, (Continuation<? super Unit>) steamPrivacyConfigViewModel$makePublic$12) == continuation2) {
                        }
                    case 4:
                        KApiResponse kApiResponse = (KApiResponse) steamPrivacyConfigViewModel$makePublic$12.L$2;
                        HttpResponse httpResponse2 = (HttpResponse) steamPrivacyConfigViewModel$makePublic$12.L$1;
                        Url url7 = (Url) steamPrivacyConfigViewModel$makePublic$12.L$0;
                        ResultKt.throwOnFailure($result);
                    case 5:
                        KApiResponse kApiResponse2 = (KApiResponse) steamPrivacyConfigViewModel$makePublic$12.L$2;
                        HttpResponse httpResponse3 = (HttpResponse) steamPrivacyConfigViewModel$makePublic$12.L$1;
                        Url url8 = (Url) steamPrivacyConfigViewModel$makePublic$12.L$0;
                        ResultKt.throwOnFailure($result);
                    case 6:
                        KApiResponse kApiResponse3 = (KApiResponse) steamPrivacyConfigViewModel$makePublic$12.L$2;
                        HttpResponse httpResponse4 = (HttpResponse) steamPrivacyConfigViewModel$makePublic$12.L$1;
                        Url url9 = (Url) steamPrivacyConfigViewModel$makePublic$12.L$0;
                        ResultKt.throwOnFailure($result);
                    case 7:
                        KApiResponse kApiResponse4 = (KApiResponse) steamPrivacyConfigViewModel$makePublic$12.L$2;
                        HttpResponse httpResponse5 = (HttpResponse) steamPrivacyConfigViewModel$makePublic$12.L$1;
                        Url url10 = (Url) steamPrivacyConfigViewModel$makePublic$12.L$0;
                        ResultKt.throwOnFailure($result);
                    case 8:
                        KApiResponse kApiResponse5 = (KApiResponse) steamPrivacyConfigViewModel$makePublic$12.L$2;
                        HttpResponse httpResponse6 = (HttpResponse) steamPrivacyConfigViewModel$makePublic$12.L$1;
                        Url url11 = (Url) steamPrivacyConfigViewModel$makePublic$12.L$0;
                        ResultKt.throwOnFailure($result);
                    case 9:
                        Exception exc = (Exception) steamPrivacyConfigViewModel$makePublic$12.L$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        steamPrivacyConfigViewModel$makePublic$1 = new SteamPrivacyConfigViewModel$makePublic$1(steamPrivacyConfigViewModel2, continuation2);
        steamPrivacyConfigViewModel$makePublic$12 = steamPrivacyConfigViewModel$makePublic$1;
        Object $result2 = steamPrivacyConfigViewModel$makePublic$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (steamPrivacyConfigViewModel$makePublic$12.label) {
        }
    }
}