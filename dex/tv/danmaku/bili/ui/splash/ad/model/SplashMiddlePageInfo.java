package tv.danmaku.bili.ui.splash.ad.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashMiddlePageInfo.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/SplashMiddlePageInfo;", "", "<init>", "()V", "logo", "", "getLogo", "()Ljava/lang/String;", "setLogo", "(Ljava/lang/String;)V", RankRouter.BundleKey.ACTION_PARAM_TITLE, "getTitle", "setTitle", "desc", "getDesc", "setDesc", "showLive", "", "getShowLive", "()I", "setShowLive", "(I)V", "btnText", "getBtnText", "setBtnText", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashMiddlePageInfo {
    public static final int $stable = 8;
    @JSONField(name = "btn_text")
    private String btnText;
    @JSONField(name = "desc")
    private String desc;
    @JSONField(name = "logo")
    private String logo;
    @JSONField(name = "show_live")
    private int showLive;
    @JSONField(name = RankRouter.BundleKey.ACTION_PARAM_TITLE)
    private String title;

    public final String getLogo() {
        return this.logo;
    }

    public final void setLogo(String str) {
        this.logo = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final int getShowLive() {
        return this.showLive;
    }

    public final void setShowLive(int i) {
        this.showLive = i;
    }

    public final String getBtnText() {
        return this.btnText;
    }

    public final void setBtnText(String str) {
        this.btnText = str;
    }
}