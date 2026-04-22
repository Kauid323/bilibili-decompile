package tv.danmaku.bili.ui.splash.event;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: EventSplashData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/splash/event/Account;", "", "<init>", "()V", "level", "", "getLevel", "()I", "setLevel", "(I)V", RankRouter.BundleKey.AUTHOR_SPACE_MID, "", "getMid", "()J", "setMid", "(J)V", "uimage", "", "getUimage", "()Ljava/lang/String;", "setUimage", "(Ljava/lang/String;)V", "uname", "getUname", "setUname", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Account {
    public static final int $stable = 8;
    @JSONField(name = "level")
    private int level;
    @JSONField(name = RankRouter.BundleKey.AUTHOR_SPACE_MID)
    private long mid;
    @JSONField(name = "uimage")
    private String uimage;
    @JSONField(name = "uname")
    private String uname;

    public final int getLevel() {
        return this.level;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final long getMid() {
        return this.mid;
    }

    public final void setMid(long j) {
        this.mid = j;
    }

    public final String getUimage() {
        return this.uimage;
    }

    public final void setUimage(String str) {
        this.uimage = str;
    }

    public final String getUname() {
        return this.uname;
    }

    public final void setUname(String str) {
        this.uname = str;
    }
}