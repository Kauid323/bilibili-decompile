package kntr.app.ad.common.protocol;

import java.util.List;
import kntr.app.ad.common.model.AdButton;
import kntr.app.ad.common.model.AdWhiteApk;
import kntr.app.ad.common.model.AdWxProgramInfo;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IClickable.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0005R\u0012\u0010!\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0005R\u0012\u0010#\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0005R\u0012\u0010%\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0014\u0010'\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\tR\u0012\u0010)\u001a\u00020*X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0012\u0010-\u001a\u00020*X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010,R\u0014\u0010/\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0005¨\u00061À\u0006\u0003"}, d2 = {"Lkntr/app/ad/common/protocol/IClickable;", RoomRecommendViewModel.EMPTY_CURSOR, "useAdWebV2", RoomRecommendViewModel.EMPTY_CURSOR, "getUseAdWebV2", "()Z", "callUpUrl", RoomRecommendViewModel.EMPTY_CURSOR, "getCallUpUrl", "()Ljava/lang/String;", "jumpUrl", "getJumpUrl", "callUpCancelUrl", "getCallUpCancelUrl", "enableCallUpCancelToH5", "getEnableCallUpCancelToH5", "wxProgramInfo", "Lkntr/app/ad/common/model/AdWxProgramInfo;", "getWxProgramInfo", "()Lkntr/app/ad/common/model/AdWxProgramInfo;", "openWhitelist", RoomRecommendViewModel.EMPTY_CURSOR, "getOpenWhitelist", "()Ljava/util/List;", "downloadWhitelist", "Lkntr/app/ad/common/model/AdWhiteApk;", "getDownloadWhitelist", "button", "Lkntr/app/ad/common/model/AdButton;", "getButton", "()Lkntr/app/ad/common/model/AdButton;", "enableDoubleJump", "getEnableDoubleJump", "enableDownloadDialog", "getEnableDownloadDialog", "enableMarketDownload", "getEnableMarketDownload", "enableMarketDownloadWhenFirstJump", "getEnableMarketDownloadWhenFirstJump", "marketDownloadUrlXM", "getMarketDownloadUrlXM", "downloadUrlType", RoomRecommendViewModel.EMPTY_CURSOR, "getDownloadUrlType", "()I", "landingPageDownloadStyle", "getLandingPageDownloadStyle", "enableOpenApkDialog", "getEnableOpenApkDialog", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IClickable {
    AdButton getButton();

    String getCallUpCancelUrl();

    String getCallUpUrl();

    int getDownloadUrlType();

    List<AdWhiteApk> getDownloadWhitelist();

    boolean getEnableCallUpCancelToH5();

    boolean getEnableDoubleJump();

    boolean getEnableDownloadDialog();

    boolean getEnableMarketDownload();

    boolean getEnableMarketDownloadWhenFirstJump();

    boolean getEnableOpenApkDialog();

    String getJumpUrl();

    int getLandingPageDownloadStyle();

    String getMarketDownloadUrlXM();

    List<String> getOpenWhitelist();

    boolean getUseAdWebV2();

    AdWxProgramInfo getWxProgramInfo();

    /* compiled from: IClickable.kt */
    /* renamed from: kntr.app.ad.common.protocol.IClickable$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$getEnableOpenApkDialog(IClickable _this) {
            return false;
        }
    }

    /* compiled from: IClickable.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean getEnableOpenApkDialog(IClickable $this) {
            return CC.$default$getEnableOpenApkDialog($this);
        }
    }
}