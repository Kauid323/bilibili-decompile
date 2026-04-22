package kntr.app.tribee.steam.service;

import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KThreeDot;
import com.bapis.bilibili.app.dynamic.v2.KTipsFootCard;
import com.bapis.bilibili.app.dynamic.v2.KTribeeGameStatsStatus;
import com.bapis.bilibili.app.dynamic.v2.KTribeeMoss;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamGameAchievementReq;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamGameAchievementResp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievement;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievementSuccess;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeBindAccountAbnormal;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeBindAccountNormal;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeBindResp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGame;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGameItem;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeNotBindResp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeReq;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeResp;
import com.bapis.bilibili.entitle.hub.common.KPlatformType;
import com.bapis.bilibili.entitle.hub.interfaces.KEntitleHubMoss;
import com.bapis.bilibili.entitle.hub.interfaces.KGetShareGameDataUrlReq;
import com.bapis.bilibili.entitle.hub.interfaces.KGetShareGameDataUrlRsp;
import com.bapis.bilibili.entitle.hub.interfaces.KUnbindEntitlementReq;
import com.bapis.bilibili.entitle.hub.interfaces.KUnbindEntitlementRsp;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.tribee.steam.state.TribeeSteamGameAchievementState;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.tribee.steam.viewmodel.SelectedGameId;
import kntr.app.tribee.steam.viewmodel.Signature;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStoreKt;
import kntr.base.account.model.UserInfo;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kntr.common.paragraph.qrcode.QrCodeProvider;
import kntr.common.screenshot.ScreenshotProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: TribeeSteamDataService.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0015J*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010#J \u0010$\u001a\u00020%2\b\b\u0002\u0010!\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lkntr/app/tribee/steam/service/TribeeSteamDataService;", "", "hostId", "", "selectedGameId", "", "signature", "qrCodeProvider", "Lkntr/common/paragraph/qrcode/QrCodeProvider;", "screenshotProvider", "Lkntr/common/screenshot/ScreenshotProvider;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lkntr/common/paragraph/qrcode/QrCodeProvider;Lkntr/common/screenshot/ScreenshotProvider;)V", "initialState", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "fetchNew", "", "count", "(ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pollingState", "fromState", "(Lkntr/app/tribee/steam/state/TribeeSteamState;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchGameAchievementState", "Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState;", "game", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "games", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "achievements", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unbindSteamEntitlement", "Lcom/bapis/bilibili/entitle/hub/interfaces/KUnbindEntitlementRsp;", "platform", "Lcom/bapis/bilibili/entitle/hub/common/KPlatformType;", "(Lcom/bapis/bilibili/entitle/hub/common/KPlatformType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getShareGameDataUrl", "Lcom/bapis/bilibili/entitle/hub/interfaces/KGetShareGameDataUrlRsp;", "appId", "(Lcom/bapis/bilibili/entitle/hub/common/KPlatformType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamDataService {
    public static final int $stable = 8;
    private final long hostId;
    private final QrCodeProvider qrCodeProvider;
    private final ScreenshotProvider screenshotProvider;
    private final String selectedGameId;
    private final String signature;

    @Inject
    public TribeeSteamDataService(long hostId, @SelectedGameId String selectedGameId, @Signature String signature, QrCodeProvider qrCodeProvider, ScreenshotProvider screenshotProvider) {
        Intrinsics.checkNotNullParameter(qrCodeProvider, "qrCodeProvider");
        Intrinsics.checkNotNullParameter(screenshotProvider, "screenshotProvider");
        this.hostId = hostId;
        this.selectedGameId = selectedGameId;
        this.signature = signature;
        this.qrCodeProvider = qrCodeProvider;
        this.screenshotProvider = screenshotProvider;
    }

    public static /* synthetic */ Object initialState$default(TribeeSteamDataService tribeeSteamDataService, boolean z, long j, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            j = 0;
        }
        return tribeeSteamDataService.initialState(z, j, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae A[Catch: Exception -> 0x0042, TRY_ENTER, TryCatch #3 {Exception -> 0x0042, blocks: (B:13:0x003d, B:39:0x00ae, B:41:0x00b6, B:44:0x00bc, B:47:0x00c4, B:48:0x00d0, B:54:0x0100, B:57:0x0106, B:60:0x010e, B:64:0x0123, B:67:0x0129, B:72:0x0137, B:75:0x013d, B:81:0x0152, B:87:0x017b, B:91:0x018f, B:96:0x01b1, B:100:0x01be, B:107:0x01ec), top: B:155:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f0 A[Catch: Exception -> 0x029b, TRY_ENTER, TryCatch #1 {Exception -> 0x029b, blocks: (B:36:0x009d, B:50:0x00f0, B:52:0x00f8, B:62:0x011b, B:70:0x012f, B:78:0x0143, B:83:0x016f, B:93:0x01a6, B:102:0x01d6, B:105:0x01e0), top: B:152:0x009d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object initialState(boolean fetchNew, long count, Continuation<? super TribeeSteamState> continuation) {
        TribeeSteamDataService$initialState$1 tribeeSteamDataService$initialState$1;
        TribeeSteamDataService$initialState$1 tribeeSteamDataService$initialState$12;
        Object tribeeSteamHome;
        KTribeeGameStatsStatus stats;
        KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem;
        TribeeSteamGameAchievementState gameAchievementState;
        KTribeeSteamHomeBindAccountNormal value;
        KTribeeSteamHomeAchievementSuccess value2;
        boolean fetchNew2 = fetchNew;
        if (continuation instanceof TribeeSteamDataService$initialState$1) {
            tribeeSteamDataService$initialState$1 = (TribeeSteamDataService$initialState$1) continuation;
            if ((tribeeSteamDataService$initialState$1.label & Integer.MIN_VALUE) != 0) {
                tribeeSteamDataService$initialState$1.label -= Integer.MIN_VALUE;
                tribeeSteamDataService$initialState$12 = tribeeSteamDataService$initialState$1;
                Object $result = tribeeSteamDataService$initialState$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeeSteamDataService$initialState$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().d("TribeeSteamDataService", "initial page , fetchNew = " + fetchNew2);
                        try {
                            KTribeeMoss kTribeeMoss = new KTribeeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            long j = this.hostId;
                            String str = this.selectedGameId;
                            String str2 = str == null ? "" : str;
                            long j2 = fetchNew2 ? 1L : 0L;
                            String str3 = this.signature;
                            KTribeeSteamHomeReq kTribeeSteamHomeReq = new KTribeeSteamHomeReq(j, str2, count, j2, str3 == null ? "" : str3);
                            tribeeSteamDataService$initialState$12.Z$0 = fetchNew2;
                            try {
                                tribeeSteamDataService$initialState$12.J$0 = count;
                                tribeeSteamDataService$initialState$12.label = 1;
                                tribeeSteamHome = kTribeeMoss.tribeeSteamHome(kTribeeSteamHomeReq, tribeeSteamDataService$initialState$12);
                                if (tribeeSteamHome == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                try {
                                    KTribeeSteamHomeResp data = (KTribeeSteamHomeResp) tribeeSteamHome;
                                    stats = data.getStats();
                                    if (!Intrinsics.areEqual(stats, KTribeeGameStatsStatus.TRIBEE_GAME_STATS_NOT_BIND.INSTANCE)) {
                                        KTribeeSteamHomeResp.KNotBind data2 = data.getData();
                                        KTribeeSteamHomeResp.KNotBind kNotBind = data2 instanceof KTribeeSteamHomeResp.KNotBind ? data2 : null;
                                        KTribeeSteamHomeNotBindResp notBindData = kNotBind != null ? kNotBind.getValue() : null;
                                        if (notBindData == null) {
                                            return new TribeeSteamState.InitialErrorState(null, null, 3, null);
                                        }
                                        return new TribeeSteamState.UnbindSteamState(null, null, notBindData, data.getGoToBindTips(), data.isMaster(), 3, null);
                                    }
                                    try {
                                        if (Intrinsics.areEqual(stats, KTribeeGameStatsStatus.TRIBEE_GAME_STATS_BINDED.INSTANCE)) {
                                            KTribeeSteamHomeResp.KBind data3 = data.getData();
                                            KTribeeSteamHomeResp.KBind kBind = data3 instanceof KTribeeSteamHomeResp.KBind ? data3 : null;
                                            KTribeeSteamHomeBindResp boundData = kBind != null ? kBind.getValue() : null;
                                            if (boundData == null) {
                                                return new TribeeSteamState.InitialErrorState(null, null, 3, null);
                                            }
                                            KTribeeSteamHomeBindResp.KNormal data4 = boundData.getData();
                                            KTribeeSteamHomeBindResp.KNormal kNormal = data4 instanceof KTribeeSteamHomeBindResp.KNormal ? data4 : null;
                                            KTribeeSteamHomeBindAccountNormal normalData = kNormal != null ? kNormal.getValue() : null;
                                            KTribeeSteamHomeBindResp.KAbnormal data5 = boundData.getData();
                                            KTribeeSteamHomeBindResp.KAbnormal kAbnormal = data5 instanceof KTribeeSteamHomeBindResp.KAbnormal ? data5 : null;
                                            KTribeeSteamHomeBindAccountAbnormal abnormalData = kAbnormal != null ? kAbnormal.getValue() : null;
                                            KTribeeSteamHomeBindResp.KAccountStatus accountStatus = boundData.getAccountStatus();
                                            if (Intrinsics.areEqual(accountStatus, KTribeeSteamHomeBindResp.KAccountStatus.ACCOUNT_STATUS_SYNCING.INSTANCE) && normalData != null) {
                                                return new TribeeSteamState.HasBoundAndSyncingState(null, null, normalData, data.isMaster(), 3, null);
                                            }
                                            if (Intrinsics.areEqual(accountStatus, KTribeeSteamHomeBindResp.KAccountStatus.ACCOUNT_STATUS_PRIVATE.INSTANCE) && abnormalData != null) {
                                                return new TribeeSteamState.HasBoundButPrivacyState(null, null, abnormalData, data.getGoToBindTips(), data.isMaster(), 3, null);
                                            } else if (Intrinsics.areEqual(accountStatus, KTribeeSteamHomeBindResp.KAccountStatus.ACCOUNT_STATUS_FAILED.INSTANCE) && abnormalData != null) {
                                                return new TribeeSteamState.HasBoundButDataFetchFailedState(null, null, data.isMaster(), abnormalData, 3, null);
                                            } else {
                                                if (Intrinsics.areEqual(accountStatus, KTribeeSteamHomeBindResp.KAccountStatus.ACCOUNT_STATUS_SUCCESS.INSTANCE) && normalData != null) {
                                                    boolean isMaster = data.isMaster();
                                                    KTribeeSteamHomeAchievement steamAchievement = normalData.getSteamAchievement();
                                                    KTribeeSteamHomeAchievement.KSuccess data6 = steamAchievement != null ? steamAchievement.getData() : null;
                                                    boolean fetchNew3 = data6 instanceof KTribeeSteamHomeAchievement.KSuccess;
                                                    KTribeeSteamHomeAchievement.KSuccess kSuccess = fetchNew3 ? data6 : null;
                                                    if (kSuccess == null || (value2 = kSuccess.getValue()) == null) {
                                                        kTribeeSteamHomeGameItem = null;
                                                    } else {
                                                        kTribeeSteamHomeGameItem = value2.getGame();
                                                    }
                                                    gameAchievementState = TribeeSteamDataServiceKt.getGameAchievementState(kTribeeSteamHomeGameItem, normalData.getGames(), normalData.getSteamAchievement());
                                                    KTipsFootCard goToBindTips = data.getGoToBindTips();
                                                    KTribeeSteamHomeBindResp.KNormal data7 = boundData.getData();
                                                    KTribeeSteamHomeBindResp.KNormal kNormal2 = data7 instanceof KTribeeSteamHomeBindResp.KNormal ? data7 : null;
                                                    KThreeDot threeDot = (kNormal2 == null || (value = kNormal2.getValue()) == null) ? null : value.getThreeDot();
                                                    return new TribeeSteamState.SteamInfoState(null, null, normalData.getUserInfo(), normalData.getSteamData(), normalData.getShareConfig(), gameAchievementState, null, null, goToBindTips, threeDot, isMaster, this.qrCodeProvider, this.screenshotProvider, 195, null);
                                                }
                                                return new TribeeSteamState.InitialErrorState(null, null, 3, null);
                                            }
                                        }
                                        return new TribeeSteamState.InitialErrorState(null, null, 3, null);
                                    } catch (Exception e) {
                                        e = e;
                                        KLog_androidKt.getKLog().e("TribeeSteamDataService", "initial page has error", e);
                                        return new TribeeSteamState.InitialErrorState(new TribeeSteamUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, e, null, 2, null), null, 2, null), null, 2, null);
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                KLog_androidKt.getKLog().e("TribeeSteamDataService", "initial page has error", e);
                                return new TribeeSteamState.InitialErrorState(new TribeeSteamUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, e, null, 2, null), null, 2, null), null, 2, null);
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                        break;
                    case 1:
                        long j3 = tribeeSteamDataService$initialState$12.J$0;
                        fetchNew2 = tribeeSteamDataService$initialState$12.Z$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            tribeeSteamHome = $result;
                            KTribeeSteamHomeResp data8 = (KTribeeSteamHomeResp) tribeeSteamHome;
                            stats = data8.getStats();
                            if (!Intrinsics.areEqual(stats, KTribeeGameStatsStatus.TRIBEE_GAME_STATS_NOT_BIND.INSTANCE)) {
                            }
                        } catch (Exception e5) {
                            e = e5;
                            KLog_androidKt.getKLog().e("TribeeSteamDataService", "initial page has error", e);
                            return new TribeeSteamState.InitialErrorState(new TribeeSteamUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, e, null, 2, null), null, 2, null), null, 2, null);
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tribeeSteamDataService$initialState$1 = new TribeeSteamDataService$initialState$1(this, continuation);
        tribeeSteamDataService$initialState$12 = tribeeSteamDataService$initialState$1;
        Object $result2 = tribeeSteamDataService$initialState$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeeSteamDataService$initialState$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pollingState(TribeeSteamState fromState, long count, Continuation<? super TribeeSteamState> continuation) {
        TribeeSteamDataService$pollingState$1 tribeeSteamDataService$pollingState$1;
        TribeeSteamState fromState2;
        Object initialState;
        Iterable requestingActions;
        ArrayList arrayList;
        List listOf;
        List listOf2;
        Object string;
        TribeeSteamState newState;
        ArrayList arrayList2;
        TribeeSteamStateAction.LaunchPolling nextPollingAction;
        TribeeSteamState fromState3;
        Object string2;
        TribeeSteamStateAction.LaunchPolling nextPollingAction2;
        TribeeSteamState fromState4;
        TribeeSteamState newState2;
        List<? extends TribeeSteamStateAction> list;
        List listOf3;
        Object string3;
        TribeeSteamStateAction.LaunchPolling nextPollingAction3;
        TribeeSteamState fromState5;
        TribeeSteamState newState3;
        List<? extends TribeeSteamStateAction> list2;
        List listOf4;
        ArrayList list$iv;
        long count2 = count;
        if (continuation instanceof TribeeSteamDataService$pollingState$1) {
            tribeeSteamDataService$pollingState$1 = (TribeeSteamDataService$pollingState$1) continuation;
            if ((tribeeSteamDataService$pollingState$1.label & Integer.MIN_VALUE) != 0) {
                tribeeSteamDataService$pollingState$1.label -= Integer.MIN_VALUE;
                Object $result = tribeeSteamDataService$pollingState$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeeSteamDataService$pollingState$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        boolean z = count2 == 1;
                        fromState2 = fromState;
                        tribeeSteamDataService$pollingState$1.L$0 = fromState2;
                        tribeeSteamDataService$pollingState$1.J$0 = count2;
                        tribeeSteamDataService$pollingState$1.label = 1;
                        initialState = initialState(z, count2, tribeeSteamDataService$pollingState$1);
                        if (initialState == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        TribeeSteamState newState4 = (TribeeSteamState) initialState;
                        requestingActions = fromState2.getRequestingActions();
                        if (requestingActions == null) {
                            Iterable $this$dropWhile$iv = requestingActions;
                            boolean yielding$iv = false;
                            ArrayList list$iv2 = new ArrayList();
                            for (Object item$iv : $this$dropWhile$iv) {
                                if (yielding$iv) {
                                    list$iv = list$iv2;
                                    list$iv.add(item$iv);
                                } else {
                                    list$iv = list$iv2;
                                    TribeeSteamStateAction it = (TribeeSteamStateAction) item$iv;
                                    if (!(it instanceof TribeeSteamStateAction.LaunchPolling)) {
                                        list$iv.add(item$iv);
                                        yielding$iv = true;
                                        list$iv2 = list$iv;
                                    }
                                }
                                list$iv2 = list$iv;
                            }
                            arrayList = list$iv2;
                        } else {
                            arrayList = null;
                        }
                        TribeeSteamStateAction.LaunchPolling nextPollingAction4 = new TribeeSteamStateAction.LaunchPolling((int) (1 + count2));
                        if (!(fromState2 instanceof TribeeSteamState.HasBoundAndSyncingState)) {
                            if (newState4 instanceof TribeeSteamState.HasBoundAndSyncingState) {
                                TribeeSteamState.HasBoundAndSyncingState hasBoundAndSyncingState = (TribeeSteamState.HasBoundAndSyncingState) fromState2;
                                if (arrayList == null || (listOf4 = CollectionsKt.plus(arrayList, nextPollingAction4)) == null) {
                                    listOf4 = CollectionsKt.listOf(nextPollingAction4);
                                }
                                return TribeeSteamState.HasBoundAndSyncingState.copy$default(hasBoundAndSyncingState, null, listOf4, null, false, 13, null);
                            }
                            return newState4.copyBy(newState4.getUiAction(), arrayList);
                        } else if (!(fromState2 instanceof TribeeSteamState.SteamInfoState)) {
                            if (!(fromState2 instanceof TribeeSteamState.HasBoundButPrivacyState)) {
                                if (newState4 instanceof TribeeSteamState.HasBoundAndSyncingState) {
                                    TribeeSteamState.HasBoundAndSyncingState hasBoundAndSyncingState2 = (TribeeSteamState.HasBoundAndSyncingState) newState4;
                                    if (arrayList == null || (listOf = CollectionsKt.plus(arrayList, nextPollingAction4)) == null) {
                                        listOf = CollectionsKt.listOf(nextPollingAction4);
                                    }
                                    return TribeeSteamState.HasBoundAndSyncingState.copy$default(hasBoundAndSyncingState2, null, listOf, null, false, 13, null);
                                }
                                return newState4.copyBy(newState4.getUiAction(), arrayList);
                            } else if ((newState4 instanceof TribeeSteamState.SteamInfoState) || (newState4 instanceof TribeeSteamState.UnbindSteamState)) {
                                return newState4.copyBy(newState4.getUiAction(), arrayList);
                            } else {
                                if (newState4 instanceof TribeeSteamState.HasBoundButPrivacyState) {
                                    return TribeeSteamState.HasBoundButPrivacyState.copy$default((TribeeSteamState.HasBoundButPrivacyState) fromState2, null, arrayList, null, null, false, 29, null);
                                }
                                if (!(newState4 instanceof TribeeSteamState.HasBoundButDataFetchFailedState)) {
                                    if (newState4 instanceof TribeeSteamState.InitialErrorState) {
                                        return TribeeSteamState.HasBoundButPrivacyState.copy$default((TribeeSteamState.HasBoundButPrivacyState) fromState2, ((TribeeSteamState.InitialErrorState) newState4).getUiAction(), arrayList, null, null, false, 28, null);
                                    }
                                    if (newState4 instanceof TribeeSteamState.HasBoundAndSyncingState) {
                                        TribeeSteamState.HasBoundButPrivacyState hasBoundButPrivacyState = (TribeeSteamState.HasBoundButPrivacyState) fromState2;
                                        if (arrayList == null || (listOf2 = CollectionsKt.plus(arrayList, nextPollingAction4)) == null) {
                                            listOf2 = CollectionsKt.listOf(nextPollingAction4);
                                        }
                                        return TribeeSteamState.HasBoundButPrivacyState.copy$default(hasBoundButPrivacyState, null, listOf2, null, null, false, 29, null);
                                    }
                                    return TribeeSteamState.HasBoundButPrivacyState.copy$default((TribeeSteamState.HasBoundButPrivacyState) fromState2, null, arrayList, null, null, false, 29, null);
                                }
                                StringResource tribee_global_string_38 = String0_commonMainKt.getTribee_global_string_38(TribeeRes.INSTANCE.getString());
                                tribeeSteamDataService$pollingState$1.L$0 = fromState2;
                                tribeeSteamDataService$pollingState$1.L$1 = SpillingKt.nullOutSpilledVariable(newState4);
                                tribeeSteamDataService$pollingState$1.L$2 = arrayList;
                                tribeeSteamDataService$pollingState$1.L$3 = SpillingKt.nullOutSpilledVariable(nextPollingAction4);
                                tribeeSteamDataService$pollingState$1.J$0 = count2;
                                tribeeSteamDataService$pollingState$1.label = 4;
                                string = StringResourcesKt.getString(tribee_global_string_38, tribeeSteamDataService$pollingState$1);
                                if (string == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                newState = newState4;
                                arrayList2 = arrayList;
                                nextPollingAction = nextPollingAction4;
                                fromState3 = fromState2;
                                String resultTips = (String) string;
                                return TribeeSteamState.HasBoundButPrivacyState.copy$default((TribeeSteamState.HasBoundButPrivacyState) fromState3, new TribeeSteamUIAction.ToastTips(TribeeToast.Companion.create(resultTips), null, 2, null), arrayList2, null, null, false, 28, null);
                            }
                        } else if ((newState4 instanceof TribeeSteamState.SteamInfoState) || (newState4 instanceof TribeeSteamState.HasBoundButPrivacyState) || (newState4 instanceof TribeeSteamState.UnbindSteamState)) {
                            StringResource tribee_global_string_34 = String0_commonMainKt.getTribee_global_string_34(TribeeRes.INSTANCE.getString());
                            tribeeSteamDataService$pollingState$1.L$0 = SpillingKt.nullOutSpilledVariable(fromState2);
                            tribeeSteamDataService$pollingState$1.L$1 = newState4;
                            tribeeSteamDataService$pollingState$1.L$2 = arrayList;
                            tribeeSteamDataService$pollingState$1.L$3 = SpillingKt.nullOutSpilledVariable(nextPollingAction4);
                            tribeeSteamDataService$pollingState$1.J$0 = count2;
                            tribeeSteamDataService$pollingState$1.label = 2;
                            string2 = StringResourcesKt.getString(tribee_global_string_34, tribeeSteamDataService$pollingState$1);
                            if (string2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            nextPollingAction2 = nextPollingAction4;
                            fromState4 = fromState2;
                            ArrayList arrayList3 = arrayList;
                            newState2 = newState4;
                            list = arrayList3;
                            String resultTips2 = (String) string2;
                            return newState2.copyBy(new TribeeSteamUIAction.ToastTips(TribeeToast.Companion.create(resultTips2), null, 2, null), list);
                        } else if (!(newState4 instanceof TribeeSteamState.HasBoundButDataFetchFailedState)) {
                            if (newState4 instanceof TribeeSteamState.InitialErrorState) {
                                return TribeeSteamState.SteamInfoState.copy$default((TribeeSteamState.SteamInfoState) fromState2, ((TribeeSteamState.InitialErrorState) newState4).getUiAction(), arrayList, null, null, null, null, null, null, null, null, false, null, null, 8188, null);
                            }
                            if (newState4 instanceof TribeeSteamState.HasBoundAndSyncingState) {
                                TribeeSteamState.SteamInfoState steamInfoState = (TribeeSteamState.SteamInfoState) fromState2;
                                if (arrayList == null || (listOf3 = CollectionsKt.plus(arrayList, nextPollingAction4)) == null) {
                                    listOf3 = CollectionsKt.listOf(nextPollingAction4);
                                }
                                return TribeeSteamState.SteamInfoState.copy$default(steamInfoState, null, listOf3, null, null, null, null, null, null, null, null, false, null, null, 8189, null);
                            }
                            return TribeeSteamState.SteamInfoState.copy$default((TribeeSteamState.SteamInfoState) fromState2, null, arrayList, null, null, null, null, null, null, null, null, false, null, null, 8189, null);
                        } else {
                            StringResource tribee_global_string_382 = String0_commonMainKt.getTribee_global_string_38(TribeeRes.INSTANCE.getString());
                            tribeeSteamDataService$pollingState$1.L$0 = fromState2;
                            tribeeSteamDataService$pollingState$1.L$1 = SpillingKt.nullOutSpilledVariable(newState4);
                            tribeeSteamDataService$pollingState$1.L$2 = arrayList;
                            tribeeSteamDataService$pollingState$1.L$3 = SpillingKt.nullOutSpilledVariable(nextPollingAction4);
                            tribeeSteamDataService$pollingState$1.J$0 = count2;
                            tribeeSteamDataService$pollingState$1.label = 3;
                            string3 = StringResourcesKt.getString(tribee_global_string_382, tribeeSteamDataService$pollingState$1);
                            if (string3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            nextPollingAction3 = nextPollingAction4;
                            fromState5 = fromState2;
                            ArrayList arrayList4 = arrayList;
                            newState3 = newState4;
                            list2 = arrayList4;
                            String resultTips3 = (String) string3;
                            return TribeeSteamState.SteamInfoState.copy$default((TribeeSteamState.SteamInfoState) fromState5, new TribeeSteamUIAction.ToastTips(TribeeToast.Companion.create(resultTips3), null, 2, null), list2, null, null, null, null, null, null, null, null, false, null, null, 8188, null);
                        }
                    case 1:
                        count2 = tribeeSteamDataService$pollingState$1.J$0;
                        TribeeSteamState fromState6 = (TribeeSteamState) tribeeSteamDataService$pollingState$1.L$0;
                        ResultKt.throwOnFailure($result);
                        fromState2 = fromState6;
                        initialState = $result;
                        TribeeSteamState newState42 = (TribeeSteamState) initialState;
                        requestingActions = fromState2.getRequestingActions();
                        if (requestingActions == null) {
                        }
                        TribeeSteamStateAction.LaunchPolling nextPollingAction42 = new TribeeSteamStateAction.LaunchPolling((int) (1 + count2));
                        if (!(fromState2 instanceof TribeeSteamState.HasBoundAndSyncingState)) {
                        }
                        break;
                    case 2:
                        long count3 = tribeeSteamDataService$pollingState$1.J$0;
                        nextPollingAction2 = (TribeeSteamStateAction.LaunchPolling) tribeeSteamDataService$pollingState$1.L$3;
                        list = (List) tribeeSteamDataService$pollingState$1.L$2;
                        newState2 = (TribeeSteamState) tribeeSteamDataService$pollingState$1.L$1;
                        fromState4 = (TribeeSteamState) tribeeSteamDataService$pollingState$1.L$0;
                        ResultKt.throwOnFailure($result);
                        string2 = $result;
                        String resultTips22 = (String) string2;
                        return newState2.copyBy(new TribeeSteamUIAction.ToastTips(TribeeToast.Companion.create(resultTips22), null, 2, null), list);
                    case 3:
                        long count4 = tribeeSteamDataService$pollingState$1.J$0;
                        nextPollingAction3 = (TribeeSteamStateAction.LaunchPolling) tribeeSteamDataService$pollingState$1.L$3;
                        list2 = (List) tribeeSteamDataService$pollingState$1.L$2;
                        newState3 = (TribeeSteamState) tribeeSteamDataService$pollingState$1.L$1;
                        fromState5 = (TribeeSteamState) tribeeSteamDataService$pollingState$1.L$0;
                        ResultKt.throwOnFailure($result);
                        string3 = $result;
                        String resultTips32 = (String) string3;
                        return TribeeSteamState.SteamInfoState.copy$default((TribeeSteamState.SteamInfoState) fromState5, new TribeeSteamUIAction.ToastTips(TribeeToast.Companion.create(resultTips32), null, 2, null), list2, null, null, null, null, null, null, null, null, false, null, null, 8188, null);
                    case 4:
                        long j = tribeeSteamDataService$pollingState$1.J$0;
                        nextPollingAction = (TribeeSteamStateAction.LaunchPolling) tribeeSteamDataService$pollingState$1.L$3;
                        TribeeSteamState fromState7 = (TribeeSteamState) tribeeSteamDataService$pollingState$1.L$0;
                        ResultKt.throwOnFailure($result);
                        string = $result;
                        arrayList2 = (List) tribeeSteamDataService$pollingState$1.L$2;
                        newState = (TribeeSteamState) tribeeSteamDataService$pollingState$1.L$1;
                        fromState3 = fromState7;
                        String resultTips4 = (String) string;
                        return TribeeSteamState.HasBoundButPrivacyState.copy$default((TribeeSteamState.HasBoundButPrivacyState) fromState3, new TribeeSteamUIAction.ToastTips(TribeeToast.Companion.create(resultTips4), null, 2, null), arrayList2, null, null, false, 28, null);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tribeeSteamDataService$pollingState$1 = new TribeeSteamDataService$pollingState$1(this, continuation);
        Object $result2 = tribeeSteamDataService$pollingState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeeSteamDataService$pollingState$1.label) {
        }
    }

    public static /* synthetic */ Object switchGameAchievementState$default(TribeeSteamDataService tribeeSteamDataService, KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, KTribeeSteamHomeGame kTribeeSteamHomeGame, KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            kTribeeSteamHomeAchievement = null;
        }
        return tribeeSteamDataService.switchGameAchievementState(kTribeeSteamHomeGameItem, kTribeeSteamHomeGame, kTribeeSteamHomeAchievement, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object switchGameAchievementState(KTribeeSteamHomeGameItem game, KTribeeSteamHomeGame games, KTribeeSteamHomeAchievement achievements, Continuation<? super TribeeSteamGameAchievementState> continuation) {
        TribeeSteamDataService$switchGameAchievementState$1 tribeeSteamDataService$switchGameAchievementState$1;
        TribeeSteamDataService$switchGameAchievementState$1 tribeeSteamDataService$switchGameAchievementState$12;
        KTribeeSteamHomeGameItem game2;
        KTribeeSteamHomeGame games2;
        KTribeeSteamHomeAchievement achievements2;
        KTribeeSteamHomeAchievement achievements3;
        Object tribeeSteamGameAchievement;
        KTribeeSteamHomeGameItem game3;
        KTribeeSteamHomeGame games3;
        TribeeSteamGameAchievementState gameAchievementState;
        if (continuation instanceof TribeeSteamDataService$switchGameAchievementState$1) {
            tribeeSteamDataService$switchGameAchievementState$1 = (TribeeSteamDataService$switchGameAchievementState$1) continuation;
            if ((tribeeSteamDataService$switchGameAchievementState$1.label & Integer.MIN_VALUE) != 0) {
                tribeeSteamDataService$switchGameAchievementState$1.label -= Integer.MIN_VALUE;
                tribeeSteamDataService$switchGameAchievementState$12 = tribeeSteamDataService$switchGameAchievementState$1;
                Object $result = tribeeSteamDataService$switchGameAchievementState$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeeSteamDataService$switchGameAchievementState$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            KTribeeMoss kTribeeMoss = new KTribeeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            KTribeeSteamGameAchievementReq kTribeeSteamGameAchievementReq = new KTribeeSteamGameAchievementReq(this.hostId, game.getAppId());
                            game2 = game;
                            try {
                                tribeeSteamDataService$switchGameAchievementState$12.L$0 = game2;
                                games2 = games;
                                try {
                                    tribeeSteamDataService$switchGameAchievementState$12.L$1 = games2;
                                    achievements3 = achievements;
                                } catch (Exception e) {
                                    achievements2 = achievements;
                                }
                            } catch (Exception e2) {
                                games2 = games;
                                achievements2 = achievements;
                            }
                            try {
                                tribeeSteamDataService$switchGameAchievementState$12.L$2 = achievements3;
                                tribeeSteamDataService$switchGameAchievementState$12.label = 1;
                                tribeeSteamGameAchievement = kTribeeMoss.tribeeSteamGameAchievement(kTribeeSteamGameAchievementReq, tribeeSteamDataService$switchGameAchievementState$12);
                                if (tribeeSteamGameAchievement == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                game3 = game2;
                                games3 = games2;
                                try {
                                    KTribeeSteamGameAchievementResp data = (KTribeeSteamGameAchievementResp) tribeeSteamGameAchievement;
                                    gameAchievementState = TribeeSteamDataServiceKt.getGameAchievementState(game3, games3, data.getAchievements());
                                    return gameAchievementState;
                                } catch (Exception e3) {
                                    games2 = games3;
                                    game2 = game3;
                                    achievements2 = achievements3;
                                    return new TribeeSteamGameAchievementState.ErrorGameAchievementState(achievements2 != null ? KTribeeSteamHomeAchievement.copy$default(achievements2, (KTribeeSteamHomeAchievement.KTribeeSteamHomeAchievementType) null, (String) null, (String) null, (KTribeeSteamHomeAchievement.IData) null, 7, (Object) null) : null, game2, games2);
                                }
                            } catch (Exception e4) {
                                achievements2 = achievements3;
                                return new TribeeSteamGameAchievementState.ErrorGameAchievementState(achievements2 != null ? KTribeeSteamHomeAchievement.copy$default(achievements2, (KTribeeSteamHomeAchievement.KTribeeSteamHomeAchievementType) null, (String) null, (String) null, (KTribeeSteamHomeAchievement.IData) null, 7, (Object) null) : null, game2, games2);
                            }
                        } catch (Exception e5) {
                            game2 = game;
                            games2 = games;
                            achievements2 = achievements;
                        }
                    case 1:
                        achievements2 = (KTribeeSteamHomeAchievement) tribeeSteamDataService$switchGameAchievementState$12.L$2;
                        games3 = (KTribeeSteamHomeGame) tribeeSteamDataService$switchGameAchievementState$12.L$1;
                        game3 = (KTribeeSteamHomeGameItem) tribeeSteamDataService$switchGameAchievementState$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            achievements3 = achievements2;
                            tribeeSteamGameAchievement = $result;
                            KTribeeSteamGameAchievementResp data2 = (KTribeeSteamGameAchievementResp) tribeeSteamGameAchievement;
                            gameAchievementState = TribeeSteamDataServiceKt.getGameAchievementState(game3, games3, data2.getAchievements());
                            return gameAchievementState;
                        } catch (Exception e6) {
                            games2 = games3;
                            game2 = game3;
                            return new TribeeSteamGameAchievementState.ErrorGameAchievementState(achievements2 != null ? KTribeeSteamHomeAchievement.copy$default(achievements2, (KTribeeSteamHomeAchievement.KTribeeSteamHomeAchievementType) null, (String) null, (String) null, (KTribeeSteamHomeAchievement.IData) null, 7, (Object) null) : null, game2, games2);
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tribeeSteamDataService$switchGameAchievementState$1 = new TribeeSteamDataService$switchGameAchievementState$1(this, continuation);
        tribeeSteamDataService$switchGameAchievementState$12 = tribeeSteamDataService$switchGameAchievementState$1;
        Object $result2 = tribeeSteamDataService$switchGameAchievementState$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeeSteamDataService$switchGameAchievementState$12.label) {
        }
    }

    public static /* synthetic */ Object unbindSteamEntitlement$default(TribeeSteamDataService tribeeSteamDataService, KPlatformType kPlatformType, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            kPlatformType = (KPlatformType) KPlatformType.STEAM.INSTANCE;
        }
        return tribeeSteamDataService.unbindSteamEntitlement(kPlatformType, continuation);
    }

    public final Object unbindSteamEntitlement(KPlatformType platform, Continuation<? super KUnbindEntitlementRsp> continuation) {
        return new KEntitleHubMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).unbindEntitlement(new KUnbindEntitlementReq(platform), continuation);
    }

    public static /* synthetic */ Object getShareGameDataUrl$default(TribeeSteamDataService tribeeSteamDataService, KPlatformType kPlatformType, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            kPlatformType = (KPlatformType) KPlatformType.STEAM.INSTANCE;
        }
        return tribeeSteamDataService.getShareGameDataUrl(kPlatformType, str, continuation);
    }

    public final Object getShareGameDataUrl(KPlatformType platform, String appId, Continuation<? super KGetShareGameDataUrlRsp> continuation) {
        UserInfo userInfo;
        Long l = null;
        KEntitleHubMoss kEntitleHubMoss = new KEntitleHubMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
        Long boxLong = Boxing.boxLong(this.hostId);
        long it = boxLong.longValue();
        long j = 0;
        if (!(it != 0)) {
            boxLong = null;
        }
        if (boxLong != null) {
            j = boxLong.longValue();
        } else {
            Object value = KAccountStoreKt.getAccountHolder().getState().getValue();
            AccountState.Logged logged = value instanceof AccountState.Logged ? (AccountState.Logged) value : null;
            if (logged != null && (userInfo = logged.getUserInfo()) != null) {
                l = Boxing.boxLong(userInfo.getMid());
            }
            if (l != null) {
                j = l.longValue();
            }
        }
        return kEntitleHubMoss.getShareGameDataUrl(new KGetShareGameDataUrlReq(platform, appId, j), continuation);
    }
}