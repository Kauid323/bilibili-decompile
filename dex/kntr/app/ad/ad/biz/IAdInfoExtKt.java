package kntr.app.ad.ad.biz;

import java.util.List;
import kntr.app.ad.common.model.AdButton;
import kntr.app.ad.common.model.AdCover;
import kntr.app.ad.common.model.AdRcmdReasonStyle;
import kntr.app.ad.common.model.AdTagStyle;
import kntr.app.ad.common.model.AdWhiteApk;
import kntr.app.ad.common.model.AdWxProgramInfo;
import kntr.app.ad.common.protocol.IAdInfo;
import kntr.app.ad.common.protocol.IExtraInfo;
import kntr.app.ad.common.protocol.IRenderable;
import kntr.app.ad.domain.click.ClickArg;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdInfoExt.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0002H\u0000\u001a\f\u0010\u0019\u001a\u00020\u0018*\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n\"\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u001a"}, d2 = {"title", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/protocol/IAdInfo;", "getTitle", "(Lkntr/app/ad/common/protocol/IAdInfo;)Ljava/lang/String;", "firstCoverUrl", "getFirstCoverUrl", "adTagStyle", "Lkntr/app/ad/common/model/AdTagStyle;", "getAdTagStyle", "(Lkntr/app/ad/common/protocol/IAdInfo;)Lkntr/app/ad/common/model/AdTagStyle;", "adTagStyleFullScreen", "getAdTagStyleFullScreen", "button", "Lkntr/app/ad/common/model/AdButton;", "getButton", "(Lkntr/app/ad/common/protocol/IAdInfo;)Lkntr/app/ad/common/model/AdButton;", "rcmdReasonStyle", "Lkntr/app/ad/common/model/AdRcmdReasonStyle;", "getRcmdReasonStyle", "(Lkntr/app/ad/common/protocol/IAdInfo;)Lkntr/app/ad/common/model/AdRcmdReasonStyle;", "desc", "getDesc", "asCardClickArg", "Lkntr/app/ad/domain/click/ClickArg;", "asButtonClickArg", "videodetail_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IAdInfoExtKt {
    public static final String getTitle(IAdInfo $this$title) {
        IRenderable card;
        Intrinsics.checkNotNullParameter($this$title, "<this>");
        IExtraInfo extra = $this$title.getExtra();
        if (extra == null || (card = extra.getCard()) == null) {
            return null;
        }
        return card.getTitle();
    }

    public static final String getFirstCoverUrl(IAdInfo $this$firstCoverUrl) {
        IRenderable card;
        List<AdCover> covers;
        AdCover adCover;
        Intrinsics.checkNotNullParameter($this$firstCoverUrl, "<this>");
        IExtraInfo extra = $this$firstCoverUrl.getExtra();
        if (extra == null || (card = extra.getCard()) == null || (covers = card.getCovers()) == null || (adCover = (AdCover) CollectionsKt.firstOrNull(covers)) == null) {
            return null;
        }
        return adCover.getUrl();
    }

    public static final AdTagStyle getAdTagStyle(IAdInfo $this$adTagStyle) {
        IRenderable card;
        Intrinsics.checkNotNullParameter($this$adTagStyle, "<this>");
        IExtraInfo extra = $this$adTagStyle.getExtra();
        if (extra == null || (card = extra.getCard()) == null) {
            return null;
        }
        return card.getAdTagStyle();
    }

    public static final AdTagStyle getAdTagStyleFullScreen(IAdInfo $this$adTagStyleFullScreen) {
        IRenderable card;
        Intrinsics.checkNotNullParameter($this$adTagStyleFullScreen, "<this>");
        IExtraInfo extra = $this$adTagStyleFullScreen.getExtra();
        if (extra == null || (card = extra.getCard()) == null) {
            return null;
        }
        return card.getAdTagStyleFullScreen();
    }

    public static final AdButton getButton(IAdInfo $this$button) {
        IRenderable card;
        Intrinsics.checkNotNullParameter($this$button, "<this>");
        IExtraInfo extra = $this$button.getExtra();
        if (extra == null || (card = extra.getCard()) == null) {
            return null;
        }
        return card.getButton();
    }

    public static final AdRcmdReasonStyle getRcmdReasonStyle(IAdInfo $this$rcmdReasonStyle) {
        IRenderable card;
        Intrinsics.checkNotNullParameter($this$rcmdReasonStyle, "<this>");
        IExtraInfo extra = $this$rcmdReasonStyle.getExtra();
        if (extra == null || (card = extra.getCard()) == null) {
            return null;
        }
        return card.getRcmdReasonStyle();
    }

    public static final String getDesc(IAdInfo $this$desc) {
        IRenderable card;
        Intrinsics.checkNotNullParameter($this$desc, "<this>");
        IExtraInfo extra = $this$desc.getExtra();
        if (extra == null || (card = extra.getCard()) == null) {
            return null;
        }
        return card.getDesc();
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ClickArg asCardClickArg(IAdInfo $this$asCardClickArg) {
        boolean z;
        IRenderable card;
        IRenderable card2;
        Intrinsics.checkNotNullParameter($this$asCardClickArg, "<this>");
        IExtraInfo extra = $this$asCardClickArg.getExtra();
        AdWxProgramInfo wxProgramInfo = extra != null ? extra.getWxProgramInfo() : null;
        IExtraInfo extra2 = $this$asCardClickArg.getExtra();
        String callUpUrl = (extra2 == null || (card2 = extra2.getCard()) == null) ? null : card2.getCallUpUrl();
        IExtraInfo extra3 = $this$asCardClickArg.getExtra();
        String jumpUrl = (extra3 == null || (card = extra3.getCard()) == null) ? null : card.getJumpUrl();
        IExtraInfo extra4 = $this$asCardClickArg.getExtra();
        String userCancelJumpUrl = extra4 != null ? extra4.getUserCancelJumpUrl() : null;
        IExtraInfo extra5 = $this$asCardClickArg.getExtra();
        boolean z2 = extra5 != null && extra5.getUserCancelJumpType() == 1;
        IExtraInfo extra6 = $this$asCardClickArg.getExtra();
        boolean enableDoubleJump = extra6 != null ? extra6.getEnableDoubleJump() : false;
        IExtraInfo extra7 = $this$asCardClickArg.getExtra();
        boolean useAdWebV2 = extra7 != null ? extra7.getUseAdWebV2() : false;
        IExtraInfo extra8 = $this$asCardClickArg.getExtra();
        List<String> openWhitelist = extra8 != null ? extra8.getOpenWhitelist() : null;
        IExtraInfo extra9 = $this$asCardClickArg.getExtra();
        List<AdWhiteApk> downloadWhitelist = extra9 != null ? extra9.getDownloadWhitelist() : null;
        IExtraInfo extra10 = $this$asCardClickArg.getExtra();
        if (extra10 != null && extra10.getEnableMarketDownloadWhenFirstJump()) {
            IExtraInfo extra11 = $this$asCardClickArg.getExtra();
            if (extra11 != null && extra11.getStoreDirectLaunch() == 1) {
                z = true;
                IExtraInfo extra12 = $this$asCardClickArg.getExtra();
                List<String> clickUrls = extra12 == null ? extra12.getClickUrls() : null;
                IExtraInfo extra13 = $this$asCardClickArg.getExtra();
                String marketDownloadUrlXM = extra13 == null ? extra13.getMarketDownloadUrlXM() : null;
                IExtraInfo extra14 = $this$asCardClickArg.getExtra();
                return new ClickArg(wxProgramInfo, callUpUrl, jumpUrl, userCancelJumpUrl, z2, enableDoubleJump, useAdWebV2, openWhitelist, downloadWhitelist, null, z, false, clickUrls, null, 0, marketDownloadUrlXM, extra14 == null ? extra14.getDownloadUrlType() : 0, true, 24576, null);
            }
        }
        z = false;
        IExtraInfo extra122 = $this$asCardClickArg.getExtra();
        if (extra122 == null) {
        }
        IExtraInfo extra132 = $this$asCardClickArg.getExtra();
        if (extra132 == null) {
        }
        IExtraInfo extra142 = $this$asCardClickArg.getExtra();
        return new ClickArg(wxProgramInfo, callUpUrl, jumpUrl, userCancelJumpUrl, z2, enableDoubleJump, useAdWebV2, openWhitelist, downloadWhitelist, null, z, false, clickUrls, null, 0, marketDownloadUrlXM, extra142 == null ? extra142.getDownloadUrlType() : 0, true, 24576, null);
    }

    public static final ClickArg asButtonClickArg(IAdInfo $this$asButtonClickArg) {
        ClickArg copy;
        IRenderable card;
        Intrinsics.checkNotNullParameter($this$asButtonClickArg, "<this>");
        IExtraInfo extra = $this$asButtonClickArg.getExtra();
        AdButton button = (extra == null || (card = extra.getCard()) == null) ? null : card.getButton();
        ClickArg asCardClickArg = asCardClickArg($this$asButtonClickArg);
        String callupUrl = button != null ? button.getCallupUrl() : null;
        String jumpUrl = button != null ? button.getJumpUrl() : null;
        String dlsucCallupUrl = button != null ? button.getDlsucCallupUrl() : null;
        boolean z = false;
        if (button != null && button.getType() == 3) {
            z = true;
        }
        copy = asCardClickArg.copy((r36 & 1) != 0 ? asCardClickArg.wxInfo : null, (r36 & 2) != 0 ? asCardClickArg.callUpUrl : callupUrl, (r36 & 4) != 0 ? asCardClickArg.jumpUrl : jumpUrl, (r36 & 8) != 0 ? asCardClickArg.cancelUrl : null, (r36 & 16) != 0 ? asCardClickArg.enableCallUpCancelToJumpUrl : false, (r36 & 32) != 0 ? asCardClickArg.enableDoubleJump : false, (r36 & 64) != 0 ? asCardClickArg.useAdWeb : false, (r36 & 128) != 0 ? asCardClickArg.openWhiteList : null, (r36 & 256) != 0 ? asCardClickArg.downloadWhiteList : null, (r36 & 512) != 0 ? asCardClickArg.dlSucCallUpUrl : dlsucCallupUrl, (r36 & 1024) != 0 ? asCardClickArg.enableAppStore : false, (r36 & 2048) != 0 ? asCardClickArg.enableAppDownload : z, (r36 & 4096) != 0 ? asCardClickArg.clickUrls : button != null ? button.getReportUrls() : null, (r36 & 8192) != 0 ? asCardClickArg.universalApp : null, (r36 & 16384) != 0 ? asCardClickArg.appStorePriority : 0, (r36 & 32768) != 0 ? asCardClickArg.storeLink : null, (r36 & 65536) != 0 ? asCardClickArg.downloadUrlType : 0, (r36 & 131072) != 0 ? asCardClickArg.isFirstJump : false);
        return copy;
    }
}