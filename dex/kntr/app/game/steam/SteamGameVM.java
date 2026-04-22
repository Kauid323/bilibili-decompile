package kntr.app.game.steam;

import com.bilibili.biligame.kntr.common.api.BiligameApiException;
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
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.game.base.viewmodel.BaseViewModel;
import kntr.app.game.base.viewmodel.event.PageEvent;
import kntr.app.game.bean.GameDLCsData;
import kntr.app.game.bean.SteamGameDetailData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: SteamGameVM.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020&H\u0087@¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u0002H\u0016J\u0018\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u00062\u0006\u00100\u001a\u00020\u0006J\u000e\u00101\u001a\u00020\u0017H\u0087@¢\u0006\u0002\u0010(R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00198\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u000fR\u001e\u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00062"}, d2 = {"Lkntr/app/game/steam/SteamGameVM;", "Lkntr/app/game/base/viewmodel/BaseViewModel;", "Lkntr/app/game/bean/SteamGameDetailData;", "<init>", "()V", "currentSteamId", RoomRecommendViewModel.EMPTY_CURSOR, "currentAppId", RoomRecommendViewModel.EMPTY_CURSOR, "toast", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "toastEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getToastEvent$annotations", "getToastEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "_dlcRefreshEvent", "Lkntr/app/game/bean/GameDLCsData;", "dlcRefreshEvent", "getDlcRefreshEvent$annotations", "getDlcRefreshEvent", "_refreshingDLC", "Lkotlinx/coroutines/flow/MutableStateFlow;", RoomRecommendViewModel.EMPTY_CURSOR, "refreshingDLC", "Lkotlinx/coroutines/flow/StateFlow;", "getRefreshingDLC$annotations", "getRefreshingDLC", "()Lkotlinx/coroutines/flow/StateFlow;", "_navigateToSteamLogin", "navigateToSteamLogin", "getNavigateToSteamLogin$annotations", "getNavigateToSteamLogin", "value", "needsRefreshOnResume", "getNeedsRefreshOnResume", "()Z", "markNavigatedToSteamLogin", RoomRecommendViewModel.EMPTY_CURSOR, "checkAndRefreshIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadData", "refresh", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkEmpty", "data", "setParameters", "steamId", "appId", "refreshDLC", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SteamGameVM extends BaseViewModel<SteamGameDetailData> {
    public static final int $stable = 8;
    private long currentAppId;
    private String currentSteamId;
    private boolean needsRefreshOnResume;
    private final MutableSharedFlow<String> toast = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 4, (Object) null);
    private final SharedFlow<String> toastEvent = FlowKt.asSharedFlow(this.toast);
    private final MutableSharedFlow<GameDLCsData> _dlcRefreshEvent = SharedFlowKt.MutableSharedFlow$default(0, 1, (BufferOverflow) null, 4, (Object) null);
    private final SharedFlow<GameDLCsData> dlcRefreshEvent = FlowKt.asSharedFlow(this._dlcRefreshEvent);
    private final MutableStateFlow<Boolean> _refreshingDLC = StateFlowKt.MutableStateFlow(false);
    private final StateFlow<Boolean> refreshingDLC = FlowKt.asStateFlow(this._refreshingDLC);
    private final MutableSharedFlow<String> _navigateToSteamLogin = SharedFlowKt.MutableSharedFlow$default(0, 1, (BufferOverflow) null, 4, (Object) null);
    private final SharedFlow<String> navigateToSteamLogin = FlowKt.asSharedFlow(this._navigateToSteamLogin);

    public static /* synthetic */ void getDlcRefreshEvent$annotations() {
    }

    public static /* synthetic */ void getNavigateToSteamLogin$annotations() {
    }

    public static /* synthetic */ void getRefreshingDLC$annotations() {
    }

    public static /* synthetic */ void getToastEvent$annotations() {
    }

    public final SharedFlow<String> getToastEvent() {
        return this.toastEvent;
    }

    public final SharedFlow<GameDLCsData> getDlcRefreshEvent() {
        return this.dlcRefreshEvent;
    }

    public final StateFlow<Boolean> getRefreshingDLC() {
        return this.refreshingDLC;
    }

    public final SharedFlow<String> getNavigateToSteamLogin() {
        return this.navigateToSteamLogin;
    }

    public final boolean getNeedsRefreshOnResume() {
        return this.needsRefreshOnResume;
    }

    public final void markNavigatedToSteamLogin() {
        this.needsRefreshOnResume = true;
    }

    public final Object checkAndRefreshIfNeeded(Continuation<? super Unit> continuation) {
        if (this.needsRefreshOnResume) {
            this.needsRefreshOnResume = false;
            Object dispatch = dispatch((PageEvent) PageEvent.Refresh.INSTANCE, continuation);
            return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0320  */
    /* JADX WARN: Type inference failed for: r0v55, types: [java.util.Map] */
    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadData(boolean refresh, Continuation<? super SteamGameDetailData> continuation) {
        SteamGameVM$loadData$1 steamGameVM$loadData$1;
        SteamGameVM$loadData$1 steamGameVM$loadData$12;
        int $i$f$typeOfOrNull;
        Object obj;
        KType kType;
        boolean refresh2;
        Object execute;
        Object obj2;
        LinkedHashMap linkedHashMap;
        Url url;
        KType kType2;
        KType kType3;
        Object bodyNullable;
        if (continuation instanceof SteamGameVM$loadData$1) {
            steamGameVM$loadData$1 = (SteamGameVM$loadData$1) continuation;
            if ((steamGameVM$loadData$1.label & Integer.MIN_VALUE) != 0) {
                steamGameVM$loadData$1.label -= Integer.MIN_VALUE;
                steamGameVM$loadData$12 = steamGameVM$loadData$1;
                Object $result = steamGameVM$loadData$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (steamGameVM$loadData$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl$default("api/game/steam/game/detail_page", (Map) null, 2, (Object) null);
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap2.put("app_id", String.valueOf(this.currentAppId));
                        String it = this.currentSteamId;
                        if (it != null) {
                            linkedHashMap2.put("steam_id", it);
                        }
                        HttpClient $this$postFormUrlEncode$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url2);
                        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getFormUrlEncoded());
                        Parameters.Companion companion = Parameters.Companion;
                        int i = 0;
                        int $i$f$build = 1;
                        ParametersBuilder $this$postFormUrlEncode_u24lambda_u240_u240$iv = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                        BiligameHttpClientKt.addCommonParamsToBody($this$postFormUrlEncode_u24lambda_u240_u240$iv);
                        for (Map.Entry element$iv$iv : linkedHashMap2.entrySet()) {
                            String it$iv = (String) element$iv$iv.getValue();
                            if (it$iv != null) {
                                if ((it$iv.length() > 0 ? $i$f$build : i) == 0) {
                                    it$iv = null;
                                }
                                if (it$iv != null) {
                                    String value$iv = it$iv;
                                    BiligameHttpClientKt.put($this$postFormUrlEncode_u24lambda_u240_u240$iv, (String) element$iv$iv.getKey(), value$iv);
                                }
                            }
                            i = 0;
                            $i$f$build = 1;
                        }
                        Object body$iv$iv = HttpUrlEncodedKt.formUrlEncode($this$postFormUrlEncode_u24lambda_u240_u240$iv.build());
                        if (body$iv$iv == null) {
                            httpRequestBuilder.setBody(NullBody.INSTANCE);
                            obj = coroutine_suspended;
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                            try {
                                kType2 = Reflection.typeOf(String.class);
                            } catch (Throwable th) {
                                kType2 = null;
                            }
                            $i$f$typeOfOrNull = 0;
                            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                        } else {
                            $i$f$typeOfOrNull = 0;
                            obj = coroutine_suspended;
                            if (body$iv$iv instanceof OutgoingContent) {
                                httpRequestBuilder.setBody(body$iv$iv);
                                httpRequestBuilder.setBodyType((TypeInfo) null);
                            } else {
                                httpRequestBuilder.setBody(body$iv$iv);
                                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                                try {
                                    kType = Reflection.typeOf(String.class);
                                } catch (Throwable th2) {
                                    kType = null;
                                }
                                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kType));
                            }
                        }
                        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$postFormUrlEncode$iv);
                        steamGameVM$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        steamGameVM$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable(linkedHashMap2);
                        steamGameVM$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        steamGameVM$loadData$12.L$3 = SpillingKt.nullOutSpilledVariable(url2);
                        steamGameVM$loadData$12.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap2);
                        steamGameVM$loadData$12.L$5 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        steamGameVM$loadData$12.L$6 = SpillingKt.nullOutSpilledVariable(url2);
                        steamGameVM$loadData$12.L$7 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        steamGameVM$loadData$12.L$8 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        steamGameVM$loadData$12.L$9 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                        steamGameVM$loadData$12.L$10 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        refresh2 = refresh;
                        steamGameVM$loadData$12.Z$0 = refresh2;
                        steamGameVM$loadData$12.I$0 = 0;
                        steamGameVM$loadData$12.I$1 = 0;
                        int $i$f$post = $i$f$typeOfOrNull;
                        steamGameVM$loadData$12.I$2 = $i$f$post;
                        steamGameVM$loadData$12.I$3 = 0;
                        steamGameVM$loadData$12.I$4 = 0;
                        steamGameVM$loadData$12.label = 1;
                        execute = httpStatement.execute(steamGameVM$loadData$12);
                        obj2 = obj;
                        if (execute == obj2) {
                            return obj2;
                        }
                        linkedHashMap = linkedHashMap2;
                        url = url2;
                        HttpResponse httpResponse = (HttpResponse) execute;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SteamGameDetailData.class)));
                        } catch (Throwable th3) {
                            kType3 = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                        steamGameVM$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        steamGameVM$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                        steamGameVM$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        steamGameVM$loadData$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        steamGameVM$loadData$12.L$4 = null;
                        steamGameVM$loadData$12.L$5 = null;
                        steamGameVM$loadData$12.L$6 = null;
                        steamGameVM$loadData$12.L$7 = null;
                        steamGameVM$loadData$12.L$8 = null;
                        steamGameVM$loadData$12.L$9 = null;
                        steamGameVM$loadData$12.L$10 = null;
                        steamGameVM$loadData$12.Z$0 = refresh2;
                        steamGameVM$loadData$12.I$0 = 0;
                        steamGameVM$loadData$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, steamGameVM$loadData$12);
                        if (bodyNullable != obj2) {
                            return obj2;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                return (SteamGameDetailData) success.getData();
                            }
                            if (success instanceof KApiResponse.BusinessFailure) {
                                throw new BiligameApiException(((KApiResponse.BusinessFailure) success).getCode(), ((KApiResponse.BusinessFailure) success).getMessage());
                            }
                            if (success instanceof KApiResponse.ServiceUnavailable) {
                                throw new Throwable(((KApiResponse.ServiceUnavailable) success).getException().getMessage());
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.bean.SteamGameDetailData>");
                    case 1:
                        int $i$f$body = steamGameVM$loadData$12.I$4;
                        int i2 = steamGameVM$loadData$12.I$3;
                        int i3 = steamGameVM$loadData$12.I$2;
                        int i4 = steamGameVM$loadData$12.I$1;
                        int i5 = steamGameVM$loadData$12.I$0;
                        boolean refresh3 = steamGameVM$loadData$12.Z$0;
                        HttpClient httpClient = (HttpClient) steamGameVM$loadData$12.L$10;
                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) steamGameVM$loadData$12.L$9;
                        HttpClient httpClient2 = (HttpClient) steamGameVM$loadData$12.L$8;
                        HttpClient httpClient3 = (HttpClient) steamGameVM$loadData$12.L$7;
                        Url url3 = (Url) steamGameVM$loadData$12.L$6;
                        HttpClient httpClient4 = (HttpClient) steamGameVM$loadData$12.L$5;
                        Map map = (Map) steamGameVM$loadData$12.L$4;
                        Url url4 = (Url) steamGameVM$loadData$12.L$3;
                        HttpClient httpClient5 = (HttpClient) steamGameVM$loadData$12.L$2;
                        linkedHashMap = (Map) steamGameVM$loadData$12.L$1;
                        ResultKt.throwOnFailure($result);
                        execute = $result;
                        obj2 = coroutine_suspended;
                        refresh2 = refresh3;
                        url = (Url) steamGameVM$loadData$12.L$0;
                        HttpResponse httpResponse2 = (HttpResponse) execute;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SteamGameDetailData.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass32, kType3);
                        steamGameVM$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        steamGameVM$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                        steamGameVM$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        steamGameVM$loadData$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        steamGameVM$loadData$12.L$4 = null;
                        steamGameVM$loadData$12.L$5 = null;
                        steamGameVM$loadData$12.L$6 = null;
                        steamGameVM$loadData$12.L$7 = null;
                        steamGameVM$loadData$12.L$8 = null;
                        steamGameVM$loadData$12.L$9 = null;
                        steamGameVM$loadData$12.L$10 = null;
                        steamGameVM$loadData$12.Z$0 = refresh2;
                        steamGameVM$loadData$12.I$0 = 0;
                        steamGameVM$loadData$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, steamGameVM$loadData$12);
                        if (bodyNullable != obj2) {
                        }
                        break;
                    case 2:
                        int i6 = steamGameVM$loadData$12.I$0;
                        boolean z = steamGameVM$loadData$12.Z$0;
                        HttpResponse httpResponse3 = (HttpResponse) steamGameVM$loadData$12.L$3;
                        HttpResponse httpResponse4 = (HttpResponse) steamGameVM$loadData$12.L$2;
                        Map map2 = (Map) steamGameVM$loadData$12.L$1;
                        Url url5 = (Url) steamGameVM$loadData$12.L$0;
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
        steamGameVM$loadData$1 = new SteamGameVM$loadData$1(this, continuation);
        steamGameVM$loadData$12 = steamGameVM$loadData$1;
        Object $result2 = steamGameVM$loadData$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (steamGameVM$loadData$12.label) {
        }
    }

    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    public boolean checkEmpty(SteamGameDetailData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.getGameInfo() == null && data.getPlayerInfo() == null && data.getPlayData() == null && data.getAchievementProgress() == null && data.getRecentAchievements() == null && data.getDlcModule() == null;
    }

    public final void setParameters(String steamId, String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.currentSteamId = steamId;
        Long longOrNull = StringsKt.toLongOrNull(appId);
        this.currentAppId = longOrNull != null ? longOrNull.longValue() : 0L;
        KLog_androidKt.getKLog().d("SteamGameVM", "设置参数: steamId=" + this.currentSteamId + ", appId=" + this.currentAppId);
        if (this.currentAppId == 0) {
            KLog_androidKt.getKLog().w("SteamGameVM", "Invalid parameters: appId=" + this.currentAppId);
            this.toast.tryEmit("参数错误");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(2:3|(4:5|6|7|8))|7|8) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|211|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x040a, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x040b, code lost:
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0430, code lost:
        if (r5 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x04f5, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x014e, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x014f, code lost:
        r2 = r5;
        r4 = r36;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x039f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03a4 A[Catch: all -> 0x050c, Exception -> 0x0511, TRY_LEAVE, TryCatch #13 {all -> 0x050c, blocks: (B:107:0x03a4, B:95:0x0341, B:102:0x0368, B:49:0x01cf, B:50:0x01e4, B:52:0x01ea, B:54:0x01fc, B:62:0x0216, B:65:0x0239, B:68:0x024d, B:75:0x026b, B:89:0x02ae, B:78:0x027b, B:80:0x0283, B:81:0x028d, B:88:0x02a6), top: B:208:0x01cf }] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03fc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x046a A[Catch: Exception -> 0x040a, all -> 0x0586, TryCatch #6 {Exception -> 0x040a, blocks: (B:143:0x0498, B:137:0x045f, B:139:0x046a, B:117:0x03fd, B:114:0x03d7, B:110:0x03ad, B:120:0x040d, B:122:0x0413, B:124:0x041c, B:133:0x0434, B:144:0x04a4, B:146:0x04a8), top: B:199:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04ff A[Catch: Exception -> 0x04f5, all -> 0x0586, TryCatch #7 {all -> 0x0586, blocks: (B:185:0x055d, B:152:0x04cf, B:182:0x0535, B:143:0x0498, B:137:0x045f, B:139:0x046a, B:117:0x03fd, B:114:0x03d7, B:110:0x03ad, B:120:0x040d, B:122:0x0413, B:124:0x041c, B:133:0x0434, B:144:0x04a4, B:146:0x04a8, B:148:0x04c7, B:161:0x04f9, B:162:0x04fe, B:163:0x04ff, B:164:0x050b), top: B:199:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x055c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0155  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v3, types: [kntr.app.game.steam.SteamGameVM] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v5, types: [kntr.app.game.steam.SteamGameVM] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshDLC(Continuation<? super Boolean> continuation) {
        SteamGameVM$refreshDLC$1 steamGameVM$refreshDLC$1;
        SteamGameVM$refreshDLC$1 steamGameVM$refreshDLC$12;
        ?? r4;
        MutableSharedFlow<String> mutableSharedFlow;
        String str;
        boolean z;
        SteamGameVM steamGameVM;
        Url updateUrl;
        Map params;
        HttpClient $this$postFormUrlEncode$iv;
        HttpMessageBuilder httpRequestBuilder;
        KType kType;
        Object execute;
        KType kType2;
        Parameters.Companion this_$iv$iv;
        boolean z2;
        HttpResponse httpResponse;
        KType kType3;
        Object bodyNullable;
        Url updateUrl2;
        KApiResponse.BusinessFailure businessFailure;
        SteamGameVM steamGameVM2;
        KApiResponse.BusinessFailure businessFailure2;
        String toastMessage;
        Url updateUrl3;
        Map params2;
        HttpResponse httpResponse2;
        HttpResponse httpResponse3;
        Url updateUrl4;
        Map params3;
        boolean z3;
        Continuation<? super Boolean> continuation2 = continuation;
        try {
            try {
                if (continuation2 instanceof SteamGameVM$refreshDLC$1) {
                    steamGameVM$refreshDLC$1 = (SteamGameVM$refreshDLC$1) continuation2;
                    if ((steamGameVM$refreshDLC$1.label & Integer.MIN_VALUE) != 0) {
                        steamGameVM$refreshDLC$1.label -= Integer.MIN_VALUE;
                        steamGameVM$refreshDLC$12 = steamGameVM$refreshDLC$1;
                        r4 = steamGameVM$refreshDLC$12.result;
                        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        String str2 = "更新失败";
                        switch (steamGameVM$refreshDLC$12.label) {
                            case 0:
                                ResultKt.throwOnFailure((Object) r4);
                                try {
                                    this._refreshingDLC.setValue(Boxing.boxBoolean(true));
                                    updateUrl = BiligameUrlBuilderKt.buildGameUrl$default("api/game/steam/dlc/update", (Map) null, 2, (Object) null);
                                    Map $this$refreshDLC_u24lambda_u240 = new LinkedHashMap();
                                    String it = this.currentSteamId;
                                    if (it != null) {
                                        String str3 = (String) $this$refreshDLC_u24lambda_u240.put("steam_id", it);
                                    }
                                    $this$refreshDLC_u24lambda_u240.put("app_id", String.valueOf(this.currentAppId));
                                    params = $this$refreshDLC_u24lambda_u240;
                                    $this$postFormUrlEncode$iv = BiligameHttpClientKt.getBiligameHttpClient();
                                    httpRequestBuilder = new HttpRequestBuilder();
                                    URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), updateUrl);
                                } catch (Exception e) {
                                    e = e;
                                    continuation2 = coroutine_suspended;
                                    r4 = this;
                                } catch (Throwable th) {
                                    th = th;
                                    r4 = this;
                                }
                                try {
                                    HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getFormUrlEncoded());
                                    Parameters.Companion this_$iv$iv2 = Parameters.Companion;
                                    str = "更新失败";
                                    try {
                                        try {
                                            ParametersBuilder $this$postFormUrlEncode_u24lambda_u240_u240$iv = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                                            boolean z4 = false;
                                            BiligameHttpClientKt.addCommonParamsToBody($this$postFormUrlEncode_u24lambda_u240_u240$iv);
                                            Continuation<? super Boolean> continuation3 = null;
                                            for (Map.Entry element$iv$iv : params.entrySet()) {
                                                String it$iv = (String) element$iv$iv.getValue();
                                                if (it$iv != null) {
                                                    if (!(it$iv.length() > 0)) {
                                                        it$iv = null;
                                                    }
                                                    if (it$iv != null) {
                                                        String value$iv = it$iv;
                                                        this_$iv$iv = this_$iv$iv2;
                                                        z2 = z4;
                                                        BiligameHttpClientKt.put($this$postFormUrlEncode_u24lambda_u240_u240$iv, (String) element$iv$iv.getKey(), value$iv);
                                                        Unit unit = Unit.INSTANCE;
                                                        z4 = z2;
                                                        this_$iv$iv2 = this_$iv$iv;
                                                    }
                                                }
                                                this_$iv$iv = this_$iv$iv2;
                                                z2 = z4;
                                                z4 = z2;
                                                this_$iv$iv2 = this_$iv$iv;
                                            }
                                            Object body$iv$iv = HttpUrlEncodedKt.formUrlEncode($this$postFormUrlEncode_u24lambda_u240_u240$iv.build());
                                            try {
                                                if (body$iv$iv == null) {
                                                    try {
                                                        httpRequestBuilder.setBody(NullBody.INSTANCE);
                                                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                                                        try {
                                                            kType = Reflection.typeOf(String.class);
                                                        } catch (Throwable th2) {
                                                            kType = null;
                                                        }
                                                        continuation3 = coroutine_suspended;
                                                        httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        continuation3 = coroutine_suspended;
                                                        r4 = this;
                                                        str2 = str;
                                                        continuation2 = continuation3;
                                                        mutableSharedFlow = r4.toast;
                                                        steamGameVM$refreshDLC$12.L$0 = SpillingKt.nullOutSpilledVariable(e);
                                                        steamGameVM$refreshDLC$12.L$1 = null;
                                                        steamGameVM$refreshDLC$12.L$2 = null;
                                                        steamGameVM$refreshDLC$12.L$3 = null;
                                                        steamGameVM$refreshDLC$12.L$4 = null;
                                                        steamGameVM$refreshDLC$12.L$5 = null;
                                                        steamGameVM$refreshDLC$12.L$6 = null;
                                                        steamGameVM$refreshDLC$12.L$7 = null;
                                                        steamGameVM$refreshDLC$12.L$8 = null;
                                                        steamGameVM$refreshDLC$12.L$9 = null;
                                                        steamGameVM$refreshDLC$12.L$10 = null;
                                                        steamGameVM$refreshDLC$12.label = 8;
                                                        steamGameVM = r4;
                                                        if (mutableSharedFlow.emit(str2, steamGameVM$refreshDLC$12) == continuation2) {
                                                            return continuation2;
                                                        }
                                                        steamGameVM._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                                        if (((Boolean) steamGameVM._refreshingDLC.getValue()).booleanValue()) {
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
                                                        } catch (Throwable th3) {
                                                            kType2 = null;
                                                        }
                                                        httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kType2));
                                                    }
                                                }
                                                httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$postFormUrlEncode$iv);
                                                steamGameVM$refreshDLC$12.L$0 = SpillingKt.nullOutSpilledVariable(updateUrl);
                                                steamGameVM$refreshDLC$12.L$1 = SpillingKt.nullOutSpilledVariable(params);
                                                steamGameVM$refreshDLC$12.L$2 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                                steamGameVM$refreshDLC$12.L$3 = SpillingKt.nullOutSpilledVariable(updateUrl);
                                                steamGameVM$refreshDLC$12.L$4 = SpillingKt.nullOutSpilledVariable(params);
                                                steamGameVM$refreshDLC$12.L$5 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                                steamGameVM$refreshDLC$12.L$6 = SpillingKt.nullOutSpilledVariable(updateUrl);
                                                steamGameVM$refreshDLC$12.L$7 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                                steamGameVM$refreshDLC$12.L$8 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                                steamGameVM$refreshDLC$12.L$9 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                                steamGameVM$refreshDLC$12.L$10 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                                                steamGameVM$refreshDLC$12.I$0 = 0;
                                                steamGameVM$refreshDLC$12.I$1 = 0;
                                                steamGameVM$refreshDLC$12.I$2 = 0;
                                                steamGameVM$refreshDLC$12.I$3 = 0;
                                                steamGameVM$refreshDLC$12.I$4 = 0;
                                                steamGameVM$refreshDLC$12.label = 1;
                                                execute = httpStatement.execute(steamGameVM$refreshDLC$12);
                                                continuation2 = continuation3;
                                            } catch (Exception e3) {
                                                e = e3;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            r4 = this;
                                            if (((Boolean) r4._refreshingDLC.getValue()).booleanValue()) {
                                                r4._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        r4 = this;
                                        continuation2 = coroutine_suspended;
                                        str2 = str;
                                        mutableSharedFlow = r4.toast;
                                        steamGameVM$refreshDLC$12.L$0 = SpillingKt.nullOutSpilledVariable(e);
                                        steamGameVM$refreshDLC$12.L$1 = null;
                                        steamGameVM$refreshDLC$12.L$2 = null;
                                        steamGameVM$refreshDLC$12.L$3 = null;
                                        steamGameVM$refreshDLC$12.L$4 = null;
                                        steamGameVM$refreshDLC$12.L$5 = null;
                                        steamGameVM$refreshDLC$12.L$6 = null;
                                        steamGameVM$refreshDLC$12.L$7 = null;
                                        steamGameVM$refreshDLC$12.L$8 = null;
                                        steamGameVM$refreshDLC$12.L$9 = null;
                                        steamGameVM$refreshDLC$12.L$10 = null;
                                        steamGameVM$refreshDLC$12.label = 8;
                                        steamGameVM = r4;
                                        if (mutableSharedFlow.emit(str2, steamGameVM$refreshDLC$12) == continuation2) {
                                        }
                                        steamGameVM._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                        if (((Boolean) steamGameVM._refreshingDLC.getValue()).booleanValue()) {
                                        }
                                        z = false;
                                        return Boxing.boxBoolean(z);
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    r4 = this;
                                    continuation2 = coroutine_suspended;
                                } catch (Throwable th5) {
                                    th = th5;
                                    r4 = this;
                                    if (((Boolean) r4._refreshingDLC.getValue()).booleanValue()) {
                                    }
                                    throw th;
                                }
                                if (execute == continuation2) {
                                    return continuation2;
                                }
                                try {
                                    httpResponse = (HttpResponse) execute;
                                    HttpClientCall call = httpResponse.getCall();
                                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                                    try {
                                        kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(UpdateDLCResponse.class)));
                                    } catch (Throwable th6) {
                                        kType3 = null;
                                    }
                                    TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                                    steamGameVM$refreshDLC$12.L$0 = SpillingKt.nullOutSpilledVariable(updateUrl);
                                    steamGameVM$refreshDLC$12.L$1 = SpillingKt.nullOutSpilledVariable(params);
                                    steamGameVM$refreshDLC$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                    steamGameVM$refreshDLC$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                    steamGameVM$refreshDLC$12.L$4 = null;
                                    steamGameVM$refreshDLC$12.L$5 = null;
                                    steamGameVM$refreshDLC$12.L$6 = null;
                                    steamGameVM$refreshDLC$12.L$7 = null;
                                    steamGameVM$refreshDLC$12.L$8 = null;
                                    steamGameVM$refreshDLC$12.L$9 = null;
                                    steamGameVM$refreshDLC$12.L$10 = null;
                                    steamGameVM$refreshDLC$12.I$0 = 0;
                                    steamGameVM$refreshDLC$12.label = 2;
                                    bodyNullable = call.bodyNullable(typeInfo, steamGameVM$refreshDLC$12);
                                } catch (Exception e6) {
                                    e = e6;
                                    r4 = this;
                                    str2 = str;
                                    mutableSharedFlow = r4.toast;
                                    steamGameVM$refreshDLC$12.L$0 = SpillingKt.nullOutSpilledVariable(e);
                                    steamGameVM$refreshDLC$12.L$1 = null;
                                    steamGameVM$refreshDLC$12.L$2 = null;
                                    steamGameVM$refreshDLC$12.L$3 = null;
                                    steamGameVM$refreshDLC$12.L$4 = null;
                                    steamGameVM$refreshDLC$12.L$5 = null;
                                    steamGameVM$refreshDLC$12.L$6 = null;
                                    steamGameVM$refreshDLC$12.L$7 = null;
                                    steamGameVM$refreshDLC$12.L$8 = null;
                                    steamGameVM$refreshDLC$12.L$9 = null;
                                    steamGameVM$refreshDLC$12.L$10 = null;
                                    steamGameVM$refreshDLC$12.label = 8;
                                    steamGameVM = r4;
                                    if (mutableSharedFlow.emit(str2, steamGameVM$refreshDLC$12) == continuation2) {
                                    }
                                    steamGameVM._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                    if (((Boolean) steamGameVM._refreshingDLC.getValue()).booleanValue()) {
                                    }
                                    z = false;
                                    return Boxing.boxBoolean(z);
                                }
                                if (bodyNullable != continuation2) {
                                    return continuation2;
                                }
                                updateUrl2 = updateUrl;
                                if (bodyNullable == null) {
                                    businessFailure = (KApiResponse) bodyNullable;
                                    if (businessFailure instanceof KApiResponse.Success) {
                                        steamGameVM2 = this;
                                        MutableSharedFlow<String> mutableSharedFlow2 = steamGameVM2.toast;
                                        steamGameVM$refreshDLC$12.L$0 = SpillingKt.nullOutSpilledVariable(updateUrl2);
                                        steamGameVM$refreshDLC$12.L$1 = SpillingKt.nullOutSpilledVariable(params);
                                        steamGameVM$refreshDLC$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                        steamGameVM$refreshDLC$12.L$3 = SpillingKt.nullOutSpilledVariable(businessFailure);
                                        steamGameVM$refreshDLC$12.label = 3;
                                        if (mutableSharedFlow2.emit("更新成功", steamGameVM$refreshDLC$12) == continuation2) {
                                            return continuation2;
                                        }
                                        httpResponse3 = httpResponse;
                                        updateUrl4 = updateUrl2;
                                        params3 = params;
                                        steamGameVM$refreshDLC$12.L$0 = SpillingKt.nullOutSpilledVariable(updateUrl4);
                                        steamGameVM$refreshDLC$12.L$1 = SpillingKt.nullOutSpilledVariable(params3);
                                        steamGameVM$refreshDLC$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse3);
                                        steamGameVM$refreshDLC$12.L$3 = SpillingKt.nullOutSpilledVariable(businessFailure);
                                        steamGameVM$refreshDLC$12.label = 4;
                                        if (steamGameVM2.dispatch((PageEvent) PageEvent.Refresh.INSTANCE, (Continuation<? super Unit>) steamGameVM$refreshDLC$12) == continuation2) {
                                            return continuation2;
                                        }
                                        steamGameVM2._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                        z3 = true;
                                        if (((Boolean) steamGameVM2._refreshingDLC.getValue()).booleanValue()) {
                                            steamGameVM2._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                        }
                                        z = z3;
                                        return Boxing.boxBoolean(z);
                                    }
                                    steamGameVM2 = this;
                                    if (!(businessFailure instanceof KApiResponse.BusinessFailure)) {
                                        if (businessFailure instanceof KApiResponse.ServiceUnavailable) {
                                            MutableSharedFlow<String> mutableSharedFlow3 = steamGameVM2.toast;
                                            steamGameVM$refreshDLC$12.L$0 = SpillingKt.nullOutSpilledVariable(updateUrl2);
                                            steamGameVM$refreshDLC$12.L$1 = SpillingKt.nullOutSpilledVariable(params);
                                            steamGameVM$refreshDLC$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                            steamGameVM$refreshDLC$12.L$3 = SpillingKt.nullOutSpilledVariable(businessFailure);
                                            steamGameVM$refreshDLC$12.label = 7;
                                            if (mutableSharedFlow3.emit(str, steamGameVM$refreshDLC$12) == continuation2) {
                                                return continuation2;
                                            }
                                            steamGameVM2._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                            z3 = false;
                                            if (((Boolean) steamGameVM2._refreshingDLC.getValue()).booleanValue()) {
                                            }
                                            z = z3;
                                            return Boxing.boxBoolean(z);
                                        }
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    String toastMessage2 = businessFailure.getMessage();
                                    if (toastMessage2 != null) {
                                        if (toastMessage2.length() > 0) {
                                            break;
                                        } else {
                                            toastMessage2 = null;
                                            break;
                                        }
                                    }
                                    toastMessage2 = str;
                                    MutableSharedFlow<String> mutableSharedFlow4 = steamGameVM2.toast;
                                    steamGameVM$refreshDLC$12.L$0 = SpillingKt.nullOutSpilledVariable(updateUrl2);
                                    steamGameVM$refreshDLC$12.L$1 = SpillingKt.nullOutSpilledVariable(params);
                                    steamGameVM$refreshDLC$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                    steamGameVM$refreshDLC$12.L$3 = businessFailure;
                                    steamGameVM$refreshDLC$12.L$4 = SpillingKt.nullOutSpilledVariable(toastMessage2);
                                    steamGameVM$refreshDLC$12.label = 5;
                                    if (mutableSharedFlow4.emit(toastMessage2, steamGameVM$refreshDLC$12) == continuation2) {
                                        return continuation2;
                                    }
                                    businessFailure2 = businessFailure;
                                    toastMessage = toastMessage2;
                                    updateUrl3 = updateUrl2;
                                    params2 = params;
                                    httpResponse2 = httpResponse;
                                    if (businessFailure2.getCode() == -13006) {
                                        MutableSharedFlow<String> mutableSharedFlow5 = steamGameVM2._navigateToSteamLogin;
                                        steamGameVM$refreshDLC$12.L$0 = SpillingKt.nullOutSpilledVariable(updateUrl3);
                                        steamGameVM$refreshDLC$12.L$1 = SpillingKt.nullOutSpilledVariable(params2);
                                        steamGameVM$refreshDLC$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                                        steamGameVM$refreshDLC$12.L$3 = SpillingKt.nullOutSpilledVariable(businessFailure2);
                                        steamGameVM$refreshDLC$12.L$4 = SpillingKt.nullOutSpilledVariable(toastMessage);
                                        steamGameVM$refreshDLC$12.label = 6;
                                        if (mutableSharedFlow5.emit("session_expired", steamGameVM$refreshDLC$12) == continuation2) {
                                            return continuation2;
                                        }
                                    }
                                    steamGameVM2._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                    z3 = false;
                                    if (((Boolean) steamGameVM2._refreshingDLC.getValue()).booleanValue()) {
                                    }
                                    z = z3;
                                    return Boxing.boxBoolean(z);
                                }
                                throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.steam.UpdateDLCResponse>");
                            case 1:
                                int $i$f$body = steamGameVM$refreshDLC$12.I$4;
                                int i = steamGameVM$refreshDLC$12.I$3;
                                int i2 = steamGameVM$refreshDLC$12.I$2;
                                int i3 = steamGameVM$refreshDLC$12.I$1;
                                int i4 = steamGameVM$refreshDLC$12.I$0;
                                HttpClient httpClient = (HttpClient) steamGameVM$refreshDLC$12.L$10;
                                HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) steamGameVM$refreshDLC$12.L$9;
                                HttpClient httpClient2 = (HttpClient) steamGameVM$refreshDLC$12.L$8;
                                HttpClient httpClient3 = (HttpClient) steamGameVM$refreshDLC$12.L$7;
                                Url url = (Url) steamGameVM$refreshDLC$12.L$6;
                                HttpClient httpClient4 = (HttpClient) steamGameVM$refreshDLC$12.L$5;
                                Map map = (Map) steamGameVM$refreshDLC$12.L$4;
                                Url url2 = (Url) steamGameVM$refreshDLC$12.L$3;
                                HttpClient httpClient5 = (HttpClient) steamGameVM$refreshDLC$12.L$2;
                                Map params4 = (Map) steamGameVM$refreshDLC$12.L$1;
                                Url updateUrl5 = (Url) steamGameVM$refreshDLC$12.L$0;
                                ResultKt.throwOnFailure((Object) r4);
                                execute = r4;
                                continuation2 = coroutine_suspended;
                                str = "更新失败";
                                updateUrl = updateUrl5;
                                params = params4;
                                httpResponse = (HttpResponse) execute;
                                HttpClientCall call2 = httpResponse.getCall();
                                KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                                kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(UpdateDLCResponse.class)));
                                TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass32, kType3);
                                steamGameVM$refreshDLC$12.L$0 = SpillingKt.nullOutSpilledVariable(updateUrl);
                                steamGameVM$refreshDLC$12.L$1 = SpillingKt.nullOutSpilledVariable(params);
                                steamGameVM$refreshDLC$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                steamGameVM$refreshDLC$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                steamGameVM$refreshDLC$12.L$4 = null;
                                steamGameVM$refreshDLC$12.L$5 = null;
                                steamGameVM$refreshDLC$12.L$6 = null;
                                steamGameVM$refreshDLC$12.L$7 = null;
                                steamGameVM$refreshDLC$12.L$8 = null;
                                steamGameVM$refreshDLC$12.L$9 = null;
                                steamGameVM$refreshDLC$12.L$10 = null;
                                steamGameVM$refreshDLC$12.I$0 = 0;
                                steamGameVM$refreshDLC$12.label = 2;
                                bodyNullable = call2.bodyNullable(typeInfo2, steamGameVM$refreshDLC$12);
                                if (bodyNullable != continuation2) {
                                }
                                break;
                            case 2:
                                int i5 = steamGameVM$refreshDLC$12.I$0;
                                HttpResponse httpResponse4 = (HttpResponse) steamGameVM$refreshDLC$12.L$3;
                                HttpResponse httpResponse5 = (HttpResponse) steamGameVM$refreshDLC$12.L$2;
                                Map params5 = (Map) steamGameVM$refreshDLC$12.L$1;
                                Url updateUrl6 = (Url) steamGameVM$refreshDLC$12.L$0;
                                ResultKt.throwOnFailure((Object) r4);
                                continuation2 = coroutine_suspended;
                                str = "更新失败";
                                httpResponse = httpResponse5;
                                params = params5;
                                updateUrl2 = updateUrl6;
                                bodyNullable = r4;
                                if (bodyNullable == null) {
                                }
                                break;
                            case 3:
                                businessFailure = (KApiResponse) steamGameVM$refreshDLC$12.L$3;
                                httpResponse3 = (HttpResponse) steamGameVM$refreshDLC$12.L$2;
                                params3 = (Map) steamGameVM$refreshDLC$12.L$1;
                                updateUrl4 = (Url) steamGameVM$refreshDLC$12.L$0;
                                ResultKt.throwOnFailure((Object) r4);
                                continuation2 = coroutine_suspended;
                                steamGameVM2 = this;
                                steamGameVM$refreshDLC$12.L$0 = SpillingKt.nullOutSpilledVariable(updateUrl4);
                                steamGameVM$refreshDLC$12.L$1 = SpillingKt.nullOutSpilledVariable(params3);
                                steamGameVM$refreshDLC$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse3);
                                steamGameVM$refreshDLC$12.L$3 = SpillingKt.nullOutSpilledVariable(businessFailure);
                                steamGameVM$refreshDLC$12.label = 4;
                                if (steamGameVM2.dispatch((PageEvent) PageEvent.Refresh.INSTANCE, (Continuation<? super Unit>) steamGameVM$refreshDLC$12) == continuation2) {
                                }
                                steamGameVM2._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                z3 = true;
                                if (((Boolean) steamGameVM2._refreshingDLC.getValue()).booleanValue()) {
                                }
                                z = z3;
                                return Boxing.boxBoolean(z);
                            case 4:
                                KApiResponse kApiResponse = (KApiResponse) steamGameVM$refreshDLC$12.L$3;
                                HttpResponse httpResponse6 = (HttpResponse) steamGameVM$refreshDLC$12.L$2;
                                Map map2 = (Map) steamGameVM$refreshDLC$12.L$1;
                                Url url3 = (Url) steamGameVM$refreshDLC$12.L$0;
                                ResultKt.throwOnFailure((Object) r4);
                                steamGameVM2 = this;
                                steamGameVM2._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                z3 = true;
                                if (((Boolean) steamGameVM2._refreshingDLC.getValue()).booleanValue()) {
                                }
                                z = z3;
                                return Boxing.boxBoolean(z);
                            case 5:
                                toastMessage = (String) steamGameVM$refreshDLC$12.L$4;
                                businessFailure2 = (KApiResponse) steamGameVM$refreshDLC$12.L$3;
                                httpResponse2 = (HttpResponse) steamGameVM$refreshDLC$12.L$2;
                                params2 = (Map) steamGameVM$refreshDLC$12.L$1;
                                updateUrl3 = (Url) steamGameVM$refreshDLC$12.L$0;
                                ResultKt.throwOnFailure((Object) r4);
                                continuation2 = coroutine_suspended;
                                steamGameVM2 = this;
                                if (businessFailure2.getCode() == -13006) {
                                }
                                steamGameVM2._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                z3 = false;
                                if (((Boolean) steamGameVM2._refreshingDLC.getValue()).booleanValue()) {
                                }
                                z = z3;
                                return Boxing.boxBoolean(z);
                            case 6:
                                String str4 = (String) steamGameVM$refreshDLC$12.L$4;
                                KApiResponse kApiResponse2 = (KApiResponse) steamGameVM$refreshDLC$12.L$3;
                                HttpResponse httpResponse7 = (HttpResponse) steamGameVM$refreshDLC$12.L$2;
                                Map map3 = (Map) steamGameVM$refreshDLC$12.L$1;
                                Url url4 = (Url) steamGameVM$refreshDLC$12.L$0;
                                ResultKt.throwOnFailure((Object) r4);
                                steamGameVM2 = this;
                                steamGameVM2._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                z3 = false;
                                if (((Boolean) steamGameVM2._refreshingDLC.getValue()).booleanValue()) {
                                }
                                z = z3;
                                return Boxing.boxBoolean(z);
                            case 7:
                                KApiResponse kApiResponse3 = (KApiResponse) steamGameVM$refreshDLC$12.L$3;
                                HttpResponse httpResponse8 = (HttpResponse) steamGameVM$refreshDLC$12.L$2;
                                Map map4 = (Map) steamGameVM$refreshDLC$12.L$1;
                                Url url5 = (Url) steamGameVM$refreshDLC$12.L$0;
                                ResultKt.throwOnFailure((Object) r4);
                                steamGameVM2 = this;
                                steamGameVM2._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                z3 = false;
                                if (((Boolean) steamGameVM2._refreshingDLC.getValue()).booleanValue()) {
                                }
                                z = z3;
                                return Boxing.boxBoolean(z);
                            case 8:
                                Exception exc = (Exception) steamGameVM$refreshDLC$12.L$0;
                                ResultKt.throwOnFailure((Object) r4);
                                steamGameVM = this;
                                steamGameVM._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                if (((Boolean) steamGameVM._refreshingDLC.getValue()).booleanValue()) {
                                    steamGameVM._refreshingDLC.setValue(Boxing.boxBoolean(false));
                                }
                                z = false;
                                return Boxing.boxBoolean(z);
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                switch (steamGameVM$refreshDLC$12.label) {
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Throwable th8) {
            th = th8;
            r4 = this;
        }
        steamGameVM$refreshDLC$1 = new SteamGameVM$refreshDLC$1(this, continuation2);
        steamGameVM$refreshDLC$12 = steamGameVM$refreshDLC$1;
        r4 = steamGameVM$refreshDLC$12.result;
        ?? coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str22 = "更新失败";
    }
}