package tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoGuide.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/VideoGuide;", "", "<init>", "()V", "materialList", "Ljava/util/ArrayList;", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/Material;", "Lkotlin/collections/ArrayList;", "getMaterialList", "()Ljava/util/ArrayList;", "setMaterialList", "(Ljava/util/ArrayList;)V", "videoPoint", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/VideoViewPoint;", "getVideoPoint", "()Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/VideoViewPoint;", "setVideoPoint", "(Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/VideoViewPoint;)V", "rightMaterial", "getRightMaterial", "()Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/Material;", "setRightMaterial", "(Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/Material;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoGuide {
    private ArrayList<Material> materialList = new ArrayList<>();
    private Material rightMaterial;
    private VideoViewPoint videoPoint;

    public final ArrayList<Material> getMaterialList() {
        return this.materialList;
    }

    public final void setMaterialList(ArrayList<Material> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.materialList = arrayList;
    }

    public final VideoViewPoint getVideoPoint() {
        return this.videoPoint;
    }

    public final void setVideoPoint(VideoViewPoint videoViewPoint) {
        this.videoPoint = videoViewPoint;
    }

    public final Material getRightMaterial() {
        return this.rightMaterial;
    }

    public final void setRightMaterial(Material material) {
        this.rightMaterial = material;
    }
}