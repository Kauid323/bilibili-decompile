package kntr.app.game.steam;

import androidx.lifecycle.ViewModelKt;
import com.bilibili.biligame.kntr.common.api.BiligameApiException;
import com.bilibili.biligame.kntr.common.api.BiligameHttpClientKt;
import com.bilibili.biligame.kntr.common.api.BiligameUrlBuilderKt;
import com.bilibili.ktor.KApiResponse;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.reflect.TypeInfo;
import java.util.Map;
import kntr.app.game.base.viewmodel.BaseViewModel;
import kntr.app.game.bean.GameAchievementsData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: SteamGameAchievementVM.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0002H\u0016J\u0018\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u00062\u0006\u0010%\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0012J\u000e\u0010(\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0012R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0017¨\u0006)"}, d2 = {"Lkntr/app/game/steam/SteamGameAchievementVM;", "Lkntr/app/game/base/viewmodel/BaseViewModel;", "Lkntr/app/game/bean/GameAchievementsData;", "<init>", "()V", "currentSteamId", RoomRecommendViewModel.EMPTY_CURSOR, "currentAppId", RoomRecommendViewModel.EMPTY_CURSOR, "toast", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "toastEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getToastEvent$annotations", "getToastEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "_unlockFilter", "Lkotlinx/coroutines/flow/MutableStateFlow;", RoomRecommendViewModel.EMPTY_CURSOR, "unlockFilter", "Lkotlinx/coroutines/flow/StateFlow;", "getUnlockFilter$annotations", "getUnlockFilter", "()Lkotlinx/coroutines/flow/StateFlow;", "_rareFilter", "rareFilter", "getRareFilter$annotations", "getRareFilter", "loadData", "refresh", RoomRecommendViewModel.EMPTY_CURSOR, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkEmpty", "data", "setParameters", RoomRecommendViewModel.EMPTY_CURSOR, "steamId", "appId", "setUnlockFilter", "filter", "setRareFilter", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SteamGameAchievementVM extends BaseViewModel<GameAchievementsData> {
    public static final int $stable = 8;
    private long currentAppId;
    private String currentSteamId;
    private final MutableSharedFlow<String> toast = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 4, (Object) null);
    private final SharedFlow<String> toastEvent = FlowKt.asSharedFlow(this.toast);
    private final MutableStateFlow<Integer> _unlockFilter = StateFlowKt.MutableStateFlow(0);
    private final StateFlow<Integer> unlockFilter = FlowKt.asStateFlow(this._unlockFilter);
    private final MutableStateFlow<Integer> _rareFilter = StateFlowKt.MutableStateFlow(0);
    private final StateFlow<Integer> rareFilter = FlowKt.asStateFlow(this._rareFilter);

    public static /* synthetic */ void getRareFilter$annotations() {
    }

    public static /* synthetic */ void getToastEvent$annotations() {
    }

    public static /* synthetic */ void getUnlockFilter$annotations() {
    }

    public final SharedFlow<String> getToastEvent() {
        return this.toastEvent;
    }

    public final StateFlow<Integer> getUnlockFilter() {
        return this.unlockFilter;
    }

    public final StateFlow<Integer> getRareFilter() {
        return this.rareFilter;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0186 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01d1  */
    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadData(boolean refresh, Continuation<? super GameAchievementsData> continuation) {
        SteamGameAchievementVM$loadData$1 steamGameAchievementVM$loadData$1;
        SteamGameAchievementVM$loadData$1 steamGameAchievementVM$loadData$12;
        boolean refresh2;
        Url url;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof SteamGameAchievementVM$loadData$1) {
            steamGameAchievementVM$loadData$1 = (SteamGameAchievementVM$loadData$1) continuation;
            if ((steamGameAchievementVM$loadData$1.label & Integer.MIN_VALUE) != 0) {
                steamGameAchievementVM$loadData$1.label -= Integer.MIN_VALUE;
                steamGameAchievementVM$loadData$12 = steamGameAchievementVM$loadData$1;
                Object $result = steamGameAchievementVM$loadData$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (steamGameAchievementVM$loadData$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl$default("api/game/steam/achievements", (Map) null, 2, (Object) null);
                        HttpClient $this$get$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        HttpRequestBuilder $this$get_u24lambda_u240$iv = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom($this$get_u24lambda_u240$iv.getUrl(), url2);
                        String str = this.currentSteamId;
                        if (str == null) {
                            str = RoomRecommendViewModel.EMPTY_CURSOR;
                        }
                        UtilsKt.parameter($this$get_u24lambda_u240$iv, "steam_id", str);
                        UtilsKt.parameter($this$get_u24lambda_u240$iv, "app_id", Boxing.boxLong(this.currentAppId));
                        UtilsKt.parameter($this$get_u24lambda_u240$iv, "unlock_filter", this._unlockFilter.getValue());
                        UtilsKt.parameter($this$get_u24lambda_u240$iv, "rare_filter", this._rareFilter.getValue());
                        $this$get_u24lambda_u240$iv.setMethod(HttpMethod.Companion.getGet());
                        HttpStatement httpStatement = new HttpStatement($this$get_u24lambda_u240$iv, $this$get$iv);
                        steamGameAchievementVM$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        steamGameAchievementVM$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                        steamGameAchievementVM$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                        steamGameAchievementVM$loadData$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                        steamGameAchievementVM$loadData$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                        steamGameAchievementVM$loadData$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get_u24lambda_u240$iv);
                        steamGameAchievementVM$loadData$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                        refresh2 = refresh;
                        steamGameAchievementVM$loadData$12.Z$0 = refresh2;
                        steamGameAchievementVM$loadData$12.I$0 = 0;
                        steamGameAchievementVM$loadData$12.I$1 = 0;
                        steamGameAchievementVM$loadData$12.I$2 = 0;
                        steamGameAchievementVM$loadData$12.I$3 = 0;
                        url = url2;
                        steamGameAchievementVM$loadData$12.label = 1;
                        Object execute = httpStatement.execute(steamGameAchievementVM$loadData$12);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = execute;
                        HttpResponse httpResponse = (HttpResponse) $result;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(GameAchievementsData.class)));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        steamGameAchievementVM$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        steamGameAchievementVM$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        steamGameAchievementVM$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        steamGameAchievementVM$loadData$12.L$3 = null;
                        steamGameAchievementVM$loadData$12.L$4 = null;
                        steamGameAchievementVM$loadData$12.L$5 = null;
                        steamGameAchievementVM$loadData$12.L$6 = null;
                        steamGameAchievementVM$loadData$12.Z$0 = refresh2;
                        steamGameAchievementVM$loadData$12.I$0 = 0;
                        steamGameAchievementVM$loadData$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, steamGameAchievementVM$loadData$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                return (GameAchievementsData) success.getData();
                            }
                            if (success instanceof KApiResponse.BusinessFailure) {
                                throw new BiligameApiException(((KApiResponse.BusinessFailure) success).getCode(), ((KApiResponse.BusinessFailure) success).getMessage());
                            }
                            if (success instanceof KApiResponse.ServiceUnavailable) {
                                throw new Throwable(((KApiResponse.ServiceUnavailable) success).getException().getMessage());
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.bean.GameAchievementsData>");
                    case 1:
                        int $i$f$body = steamGameAchievementVM$loadData$12.I$3;
                        int i = steamGameAchievementVM$loadData$12.I$2;
                        int i2 = steamGameAchievementVM$loadData$12.I$1;
                        int i3 = steamGameAchievementVM$loadData$12.I$0;
                        refresh2 = steamGameAchievementVM$loadData$12.Z$0;
                        HttpClient httpClient = (HttpClient) steamGameAchievementVM$loadData$12.L$6;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) steamGameAchievementVM$loadData$12.L$5;
                        HttpClient httpClient2 = (HttpClient) steamGameAchievementVM$loadData$12.L$4;
                        HttpClient httpClient3 = (HttpClient) steamGameAchievementVM$loadData$12.L$3;
                        Url url3 = (Url) steamGameAchievementVM$loadData$12.L$2;
                        HttpClient httpClient4 = (HttpClient) steamGameAchievementVM$loadData$12.L$1;
                        ResultKt.throwOnFailure($result);
                        url = (Url) steamGameAchievementVM$loadData$12.L$0;
                        HttpResponse httpResponse2 = (HttpResponse) $result;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(GameAchievementsData.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        steamGameAchievementVM$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        steamGameAchievementVM$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        steamGameAchievementVM$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        steamGameAchievementVM$loadData$12.L$3 = null;
                        steamGameAchievementVM$loadData$12.L$4 = null;
                        steamGameAchievementVM$loadData$12.L$5 = null;
                        steamGameAchievementVM$loadData$12.L$6 = null;
                        steamGameAchievementVM$loadData$12.Z$0 = refresh2;
                        steamGameAchievementVM$loadData$12.I$0 = 0;
                        steamGameAchievementVM$loadData$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, steamGameAchievementVM$loadData$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i4 = steamGameAchievementVM$loadData$12.I$0;
                        boolean z = steamGameAchievementVM$loadData$12.Z$0;
                        HttpResponse httpResponse3 = (HttpResponse) steamGameAchievementVM$loadData$12.L$2;
                        HttpResponse httpResponse4 = (HttpResponse) steamGameAchievementVM$loadData$12.L$1;
                        Url url4 = (Url) steamGameAchievementVM$loadData$12.L$0;
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
        steamGameAchievementVM$loadData$1 = new SteamGameAchievementVM$loadData$1(this, continuation);
        steamGameAchievementVM$loadData$12 = steamGameAchievementVM$loadData$1;
        Object $result2 = steamGameAchievementVM$loadData$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (steamGameAchievementVM$loadData$12.label) {
        }
    }

    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    public boolean checkEmpty(GameAchievementsData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.getAchievements().isEmpty();
    }

    public final void setParameters(String steamId, String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.currentSteamId = steamId;
        Long longOrNull = StringsKt.toLongOrNull(appId);
        this.currentAppId = longOrNull != null ? longOrNull.longValue() : 0L;
        KLog_androidKt.getKLog().d("SteamGameAchievementVM", "设置参数: steamId=" + this.currentSteamId + ", appId=" + this.currentAppId);
        if (this.currentAppId == 0) {
            KLog_androidKt.getKLog().w("SteamGameAchievementVM", "Invalid parameters: appId=" + this.currentAppId);
            this.toast.tryEmit("参数错误");
        }
    }

    public final void setUnlockFilter(int filter) {
        if (((Number) this._unlockFilter.getValue()).intValue() != filter) {
            this._unlockFilter.setValue(Integer.valueOf(filter));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SteamGameAchievementVM$setUnlockFilter$1(this, null), 3, (Object) null);
        }
    }

    public final void setRareFilter(int filter) {
        if (((Number) this._rareFilter.getValue()).intValue() != filter) {
            this._rareFilter.setValue(Integer.valueOf(filter));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SteamGameAchievementVM$setRareFilter$1(this, null), 3, (Object) null);
        }
    }
}