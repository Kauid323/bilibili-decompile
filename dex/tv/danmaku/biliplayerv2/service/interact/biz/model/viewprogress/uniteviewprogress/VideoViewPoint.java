package tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoGuide.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/VideoViewPoint;", "", "<init>", "()V", "videoPointList", "Ljava/util/ArrayList;", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/VideoPoint;", "Lkotlin/collections/ArrayList;", "getVideoPointList", "()Ljava/util/ArrayList;", "setVideoPointList", "(Ljava/util/ArrayList;)V", "pointMaterial", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/PointMaterial;", "getPointMaterial", "()Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/PointMaterial;", "setPointMaterial", "(Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/PointMaterial;)V", "pointPermanent", "", "getPointPermanent", "()Z", "setPointPermanent", "(Z)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoViewPoint {
    private PointMaterial pointMaterial;
    private boolean pointPermanent;
    private ArrayList<VideoPoint> videoPointList = new ArrayList<>();

    public final ArrayList<VideoPoint> getVideoPointList() {
        return this.videoPointList;
    }

    public final void setVideoPointList(ArrayList<VideoPoint> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.videoPointList = arrayList;
    }

    public final PointMaterial getPointMaterial() {
        return this.pointMaterial;
    }

    public final void setPointMaterial(PointMaterial pointMaterial) {
        this.pointMaterial = pointMaterial;
    }

    public final boolean getPointPermanent() {
        return this.pointPermanent;
    }

    public final void setPointPermanent(boolean z) {
        this.pointPermanent = z;
    }
}