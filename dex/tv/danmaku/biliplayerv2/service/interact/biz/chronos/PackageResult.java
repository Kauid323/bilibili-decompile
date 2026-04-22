package tv.danmaku.biliplayerv2.service.interact.biz.chronos;

import com.bilibili.cron.ChronosPackage;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosApiResolver.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/PackageResult;", "", "<init>", "()V", "viewProgressDetail", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "getViewProgressDetail", "()Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "setViewProgressDetail", "(Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;)V", "chronosPackage", "Lcom/bilibili/cron/ChronosPackage;", "getChronosPackage", "()Lcom/bilibili/cron/ChronosPackage;", "setChronosPackage", "(Lcom/bilibili/cron/ChronosPackage;)V", "md5", "", "getMd5", "()Ljava/lang/String;", "setMd5", "(Ljava/lang/String;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PackageResult {
    private ChronosPackage chronosPackage;
    private String md5;
    private ViewProgressDetail viewProgressDetail;

    public final ViewProgressDetail getViewProgressDetail() {
        return this.viewProgressDetail;
    }

    public final void setViewProgressDetail(ViewProgressDetail viewProgressDetail) {
        this.viewProgressDetail = viewProgressDetail;
    }

    public final ChronosPackage getChronosPackage() {
        return this.chronosPackage;
    }

    public final void setChronosPackage(ChronosPackage chronosPackage) {
        this.chronosPackage = chronosPackage;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final void setMd5(String str) {
        this.md5 = str;
    }
}