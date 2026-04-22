package tv.danmaku.bili.ui.rank.model;

import kotlin.Metadata;
import tv.danmaku.bili.ui.rank.api.RankApiManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RankBRpcModel.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/rank/model/RankBRpcCategoryModel;", "Ltv/danmaku/bili/ui/rank/model/BaseRankBRpcModel;", "tid", "", "<init>", "(I)V", "doLoad", "", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RankBRpcCategoryModel extends BaseRankBRpcModel {
    public static final int $stable = 8;
    private final int tid;

    public RankBRpcCategoryModel(int tid) {
        this.tid = tid;
    }

    @Override // tv.danmaku.bili.ui.rank.model.BaseRankBRpcModel
    protected void doLoad() {
        RankApiManager.getCategoryVideoList(this.tid, 100, getCallback());
    }
}