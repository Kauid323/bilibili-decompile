package tv.danmaku.bili.ui.pandora;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PandoraBean.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR \u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR \u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR&\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006+"}, d2 = {"Ltv/danmaku/bili/ui/pandora/PandoraBean;", "", "<init>", "()V", LoginSceneProcessor.BIZ_KEY, "", "getBusiness", "()Ljava/lang/String;", "setBusiness", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "viewType", "", "getViewType", "()Ljava/lang/Integer;", "setViewType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "status", "getStatus", "setStatus", RankRouter.BundleKey.ACTION_PARAM_TITLE, "getTitle", "setTitle", "desc", "getDesc", "setDesc", "buttonConfirm", "getButtonConfirm", "setButtonConfirm", "buttonCancel", "getButtonCancel", "setButtonCancel", "guideRewards", "", "Ltv/danmaku/bili/ui/pandora/PandoraBean$GuideReward;", "getGuideRewards", "()Ljava/util/List;", "setGuideRewards", "(Ljava/util/List;)V", "GuideReward", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PandoraBean {
    public static final int $stable = 8;
    @JSONField(name = "rewards")
    private List<GuideReward> guideRewards;
    private String business = "";
    private String url = "";
    @JSONField(name = "view_type")
    private Integer viewType = 0;
    private String status = "";
    private String title = "";
    private String desc = "";
    @JSONField(name = "button_a")
    private String buttonConfirm = "";
    @JSONField(name = "button_b")
    private String buttonCancel = "";

    public final String getBusiness() {
        return this.business;
    }

    public final void setBusiness(String str) {
        this.business = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final Integer getViewType() {
        return this.viewType;
    }

    public final void setViewType(Integer num) {
        this.viewType = num;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
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

    public final String getButtonConfirm() {
        return this.buttonConfirm;
    }

    public final void setButtonConfirm(String str) {
        this.buttonConfirm = str;
    }

    public final String getButtonCancel() {
        return this.buttonCancel;
    }

    public final void setButtonCancel(String str) {
        this.buttonCancel = str;
    }

    public final List<GuideReward> getGuideRewards() {
        return this.guideRewards;
    }

    public final void setGuideRewards(List<GuideReward> list) {
        this.guideRewards = list;
    }

    /* compiled from: PandoraBean.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/pandora/PandoraBean$GuideReward;", "", "<init>", "()V", "image", "", "getImage", "()Ljava/lang/String;", "setImage", "(Ljava/lang/String;)V", "text", "getText", "setText", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class GuideReward {
        public static final int $stable = 8;
        private String image;
        private String text;

        public final String getImage() {
            return this.image;
        }

        public final void setImage(String str) {
            this.image = str;
        }

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            this.text = str;
        }
    }
}