package tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DmResource.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/AttentionCard;", "", "<init>", "()V", "showTimeList", "Ljava/util/ArrayList;", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ShowTime;", "Lkotlin/collections/ArrayList;", "getShowTimeList", "()Ljava/util/ArrayList;", "setShowTimeList", "(Ljava/util/ArrayList;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AttentionCard {
    private ArrayList<ShowTime> showTimeList = new ArrayList<>();

    public final ArrayList<ShowTime> getShowTimeList() {
        return this.showTimeList;
    }

    public final void setShowTimeList(ArrayList<ShowTime> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.showTimeList = arrayList;
    }
}