package video.biz.offline.list.logic.model;

import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MaxConcurrentModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"maxConcurrentModels", "", "Lvideo/biz/offline/list/logic/model/MaxConcurrentModel;", "max", "", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MaxConcurrentModelKt {
    public static final List<MaxConcurrentModel> maxConcurrentModels(int max) {
        MaxConcurrentModel[] maxConcurrentModelArr = new MaxConcurrentModel[3];
        maxConcurrentModelArr[0] = new MaxConcurrentModel(1, "", max == 1);
        maxConcurrentModelArr[1] = new MaxConcurrentModel(2, PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2200(PlayerbaseresRes.INSTANCE.getString())), max == 2);
        maxConcurrentModelArr[2] = new MaxConcurrentModel(3, PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2200(PlayerbaseresRes.INSTANCE.getString())), max == 3);
        List maxConcurrentList = CollectionsKt.listOf(maxConcurrentModelArr);
        return maxConcurrentList;
    }
}