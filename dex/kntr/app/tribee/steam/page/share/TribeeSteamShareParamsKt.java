package kntr.app.tribee.steam.page.share;

import bili.resource.common.CommonRes;
import bili.resource.tribee.Res;
import bili.resource.tribee.String0_commonMainKt;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGameItem;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeShareConfig;
import kntr.app.tribee.share.ProviderDynamicShareContent_androidKt;
import kntr.app.tribee.share.ProviderIMShareContent_androidKt;
import kntr.app.tribee.steam.state.TribeeSteamGameAchievementState;
import kntr.app.tribee.steam.state.TribeeSteamShareState;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.tribee.steam.track.SteamTrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStoreKt;
import kntr.base.account.model.UserInfo;
import kntr.base.log.KLog_androidKt;
import kntr.common.share.common.ShareContent;
import kntr.common.share.common.ShareDynamicContent;
import kntr.common.share.common.ShareImage;
import kntr.common.share.common.ShareMode;
import kntr.common.share.common.ShareParams;
import kntr.common.share.common.ShareTarget;
import kntr.common.share.common.ui.ShareMenuVM;
import kntr.common.share.domain.model.ShareSession;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;

/* compiled from: TribeeSteamShareParams.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u001a(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b\u001aD\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002\u001aL\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0002¨\u0006#"}, d2 = {"getShareMenuViewModel", "Lkntr/common/share/common/ui/ShareMenuVM;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "steamInfoState", "Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;", "shareState", "Lkntr/app/tribee/steam/state/TribeeSteamShareState;", "hostMid", "", "fromSpmid", "", "tribeeId", "updateShareMenuVMContentProvider", "", "viewModel", "Lkntr/app/tribee/steam/state/TribeeSteamShareState$MaterialLoadedSuccessState;", "getTribeeSteamShareParams", "Lkntr/common/share/common/ShareParams;", "appId", "isScreenShotSource", "", "isShareAllGame", "getSteamShareContent", "Lkntr/common/share/common/ShareContent;", "link", "shareConfig", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeShareConfig;", "shareImage", "Lkntr/common/share/common/ShareImage;", "target", "Lkntr/common/share/common/ShareTarget;", "shareTitle", "shareDesc", "shareSubtitleWithLink", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamShareParamsKt {
    public static final ShareMenuVM getShareMenuViewModel(CoroutineScope scope, TribeeSteamState.SteamInfoState steamInfoState, final TribeeSteamShareState shareState, long hostMid, String fromSpmid, final String tribeeId) {
        String str;
        UserInfo userInfo;
        TribeeSteamGameAchievementState achievementState;
        KTribeeSteamHomeGameItem selectedGame;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(shareState, "shareState");
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        if (steamInfoState == null || (achievementState = steamInfoState.getAchievementState()) == null || (selectedGame = achievementState.getSelectedGame()) == null) {
            str = null;
        } else {
            str = selectedGame.getAppId();
        }
        if (str == null) {
            str = "";
        }
        String appId = str;
        Object value = KAccountStoreKt.getAccountHolder().getState().getValue();
        AccountState.Logged logged = value instanceof AccountState.Logged ? (AccountState.Logged) value : null;
        long useId = (logged == null || (userInfo = logged.getUserInfo()) == null) ? 0L : userInfo.getMid();
        Long longOrNull = StringsKt.toLongOrNull(tribeeId);
        long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
        Long longOrNull2 = StringsKt.toLongOrNull(appId);
        long longValue2 = longOrNull2 != null ? longOrNull2.longValue() : 0L;
        Long valueOf = Long.valueOf(hostMid);
        long it = valueOf.longValue();
        if (!(it != 0)) {
            valueOf = null;
        }
        ShareParams shareParams = getTribeeSteamShareParams(fromSpmid, longValue, longValue2, valueOf != null ? valueOf.longValue() : useId, shareState.isFromScreenShot(), shareState.isShareAllGame());
        final KTribeeSteamHomeShareConfig shareConfig = steamInfoState != null ? steamInfoState.getShareConfig() : null;
        return new ShareMenuVM(new ShareSession(shareParams, null, null, null, 14, null), scope, null, null, new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareParamsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                ShareContent shareMenuViewModel$lambda$1;
                shareMenuViewModel$lambda$1 = TribeeSteamShareParamsKt.getShareMenuViewModel$lambda$1(TribeeSteamShareState.this, shareConfig, tribeeId, (ShareTarget) obj);
                return shareMenuViewModel$lambda$1;
            }
        }, new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareParamsKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean shareMenuViewModel$lambda$2;
                shareMenuViewModel$lambda$2 = TribeeSteamShareParamsKt.getShareMenuViewModel$lambda$2((ShareTarget) obj);
                return Boolean.valueOf(shareMenuViewModel$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareParamsKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean shareMenuViewModel$lambda$3;
                shareMenuViewModel$lambda$3 = TribeeSteamShareParamsKt.getShareMenuViewModel$lambda$3((ShareTarget) obj);
                return Boolean.valueOf(shareMenuViewModel$lambda$3);
            }
        }, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShareContent getShareMenuViewModel$lambda$1(TribeeSteamShareState $shareState, KTribeeSteamHomeShareConfig $shareConfig, String $tribeeId, ShareTarget target) {
        String string;
        Intrinsics.checkNotNullParameter(target, "target");
        String shareLink = $shareState.getShareLink();
        if (shareLink == null) {
            shareLink = "";
        }
        String str = shareLink;
        ShareImage shareImage = $shareState.getShareImage();
        String string2 = CommonRes.INSTANCE.getString(String0_commonMainKt.getTribee_global_string_22(Res.string.INSTANCE));
        String string3 = CommonRes.INSTANCE.getString(String0_commonMainKt.getTribee_global_string_21(Res.string.INSTANCE), new Object[]{String.valueOf($shareConfig != null ? $shareConfig.getJumpUrl() : null)});
        if ($shareConfig == null || (string = $shareConfig.getText()) == null) {
            string = CommonRes.INSTANCE.getString(String0_commonMainKt.getTribee_global_string_23(Res.string.INSTANCE));
        }
        return getSteamShareContent($tribeeId, str, $shareConfig, shareImage, target, string2, string, string3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getShareMenuViewModel$lambda$2(ShareTarget it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getShareMenuViewModel$lambda$3(ShareTarget it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return false;
    }

    public static final void updateShareMenuVMContentProvider(ShareMenuVM viewModel, TribeeSteamState.SteamInfoState steamInfoState, final TribeeSteamShareState.MaterialLoadedSuccessState shareState, final String tribeeId) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(shareState, "shareState");
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        final KTribeeSteamHomeShareConfig shareConfig = steamInfoState != null ? steamInfoState.getShareConfig() : null;
        viewModel.updateContentProvider(new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareParamsKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                ShareContent updateShareMenuVMContentProvider$lambda$0;
                updateShareMenuVMContentProvider$lambda$0 = TribeeSteamShareParamsKt.updateShareMenuVMContentProvider$lambda$0(TribeeSteamShareState.MaterialLoadedSuccessState.this, shareConfig, tribeeId, (ShareTarget) obj);
                return updateShareMenuVMContentProvider$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShareContent updateShareMenuVMContentProvider$lambda$0(TribeeSteamShareState.MaterialLoadedSuccessState $shareState, KTribeeSteamHomeShareConfig $shareConfig, String $tribeeId, ShareTarget target) {
        String string;
        Intrinsics.checkNotNullParameter(target, "target");
        String shareLink = $shareState.getShareLink();
        if (shareLink == null) {
            shareLink = "";
        }
        String str = shareLink;
        ShareImage shareImage = $shareState.getShareImage();
        String string2 = CommonRes.INSTANCE.getString(String0_commonMainKt.getTribee_global_string_22(Res.string.INSTANCE));
        String string3 = CommonRes.INSTANCE.getString(String0_commonMainKt.getTribee_global_string_21(Res.string.INSTANCE), new Object[]{String.valueOf($shareConfig != null ? $shareConfig.getJumpUrl() : null)});
        if ($shareConfig == null || (string = $shareConfig.getText()) == null) {
            string = CommonRes.INSTANCE.getString(String0_commonMainKt.getTribee_global_string_23(Res.string.INSTANCE));
        }
        return getSteamShareContent($tribeeId, str, $shareConfig, shareImage, target, string2, string, string3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShareParams getTribeeSteamShareParams(String fromSpmid, long tribeeId, long appId, long hostMid, boolean isScreenShotSource, boolean isShareAllGame) {
        String shareOrigin;
        if (isScreenShotSource) {
            shareOrigin = "screenshot";
        } else {
            shareOrigin = "";
        }
        StringFormat $this$encodeToString$iv = Json.Default;
        Object value$iv = new TribeeSteamShareSid(tribeeId, String.valueOf(appId), hostMid, isShareAllGame ? 1 : 0);
        $this$encodeToString$iv.getSerializersModule();
        String sid = $this$encodeToString$iv.encodeToString(TribeeSteamShareSid.Companion.serializer(), value$iv);
        KLog_androidKt.getKLog().i("TribeeSteamShareParams", "getTribeeSteamShareParams: fromSpmid=" + fromSpmid + ", tribeeId=" + tribeeId + ", appId=" + appId + ", isScreenShotSource=" + isScreenShotSource + ", shareOrigin=" + shareOrigin + ", sid=" + sid);
        return new ShareParams(SteamTrackerKt.STEAM_PAGE_SHARE_ID, "1", shareOrigin, sid, new ShareParams.PageInfo(SteamTrackerKt.STEAM_PAGE_SPMID, null, fromSpmid, MapsKt.mapOf(TuplesKt.to("handler", "tribee_platform")), null, 18, null), null, 32, null);
    }

    private static final ShareContent getSteamShareContent(String tribeeId, String link, KTribeeSteamHomeShareConfig shareConfig, ShareImage shareImage, ShareTarget target, String shareTitle, String shareDesc, String shareSubtitleWithLink) {
        String str;
        String str2;
        String logoUrl;
        ShareImage shareImage2;
        KLog_androidKt.getKLog().i("TribeeSteamShareContent", "getSteamShareContent: tribeeId=" + tribeeId + ", link=" + link + ", target=" + target + ", shareTitle=" + shareTitle + ", shareDesc=" + shareDesc);
        ShareMode shareMode = target instanceof ShareTarget.SaveImage ? ShareMode.Image : ShareMode.Link;
        if (target instanceof ShareTarget.Dynamic) {
            str = shareConfig != null ? shareConfig.getDynamicTitle() : null;
        } else if (target instanceof ShareTarget.IM) {
            str = shareConfig != null ? shareConfig.getMessageTitle() : null;
        } else {
            str = shareTitle;
        }
        if (target instanceof ShareTarget.WeiBo) {
            str2 = shareSubtitleWithLink;
        } else {
            str2 = shareDesc;
        }
        if (target instanceof ShareTarget.SaveImage) {
            logoUrl = null;
        } else {
            logoUrl = shareConfig != null ? shareConfig.getLogoUrl() : null;
        }
        if (target instanceof ShareTarget.SaveImage) {
            shareImage2 = shareImage;
        } else {
            shareImage2 = null;
        }
        KTribeeSteamHomeShareConfig kTribeeSteamHomeShareConfig = shareConfig == null ? new KTribeeSteamHomeShareConfig((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null) : shareConfig;
        Long longOrNull = StringsKt.toLongOrNull(tribeeId);
        ShareDynamicContent steamShareDynamicContent = ProviderDynamicShareContent_androidKt.getSteamShareDynamicContent(kTribeeSteamHomeShareConfig, longOrNull != null ? longOrNull.longValue() : 0L, link);
        KTribeeSteamHomeShareConfig kTribeeSteamHomeShareConfig2 = shareConfig == null ? new KTribeeSteamHomeShareConfig((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null) : shareConfig;
        Long longOrNull2 = StringsKt.toLongOrNull(tribeeId);
        return new ShareContent(shareMode, str, str2, link, shareImage2, logoUrl, null, null, null, ProviderIMShareContent_androidKt.getSteamShareIMContent(kTribeeSteamHomeShareConfig2, longOrNull2 != null ? longOrNull2.longValue() : 0L, link), steamShareDynamicContent, null, 2496, null);
    }
}