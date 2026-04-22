package tv.danmaku.bili.ui.rank;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.bilibili.lib.arch.lifecycle.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.model.IRankLoadModel;
import tv.danmaku.bili.ui.rank.model.RankModel;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RankVideoListViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R3\u0010\t\u001a$\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/rank/RankVideoListViewModel;", "Landroidx/lifecycle/ViewModel;", "type", "", "tid", "loadModel", "Ltv/danmaku/bili/ui/rank/model/IRankLoadModel;", "<init>", "(IILtv/danmaku/bili/ui/rank/model/IRankLoadModel;)V", "rankList", "Landroidx/lifecycle/LiveData;", "Lcom/bilibili/lib/arch/lifecycle/Resource;", "", "Ltv/danmaku/bili/ui/rank/model/RankModel;", "Lcom/bilibili/lib/arch/lifecycle/LiveResource;", "getRankList", "()Landroidx/lifecycle/LiveData;", "load", "", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RankVideoListViewModel extends ViewModel {
    public static final int $stable = 8;
    private final IRankLoadModel loadModel;
    private final LiveData<Resource<List<RankModel>>> rankList;
    private final int tid;
    private final int type;

    public RankVideoListViewModel(int type, int tid, IRankLoadModel loadModel) {
        Intrinsics.checkNotNullParameter(loadModel, "loadModel");
        this.type = type;
        this.tid = tid;
        this.loadModel = loadModel;
        this.rankList = Transformations.map(this.loadModel.getLiveResp(), new Function1() { // from class: tv.danmaku.bili.ui.rank.RankVideoListViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return RankVideoListViewModel.rankList$lambda$0((Resource) obj);
            }
        });
        if (this.rankList.getValue() != null) {
            return;
        }
        load();
    }

    public final LiveData<Resource<List<RankModel>>> getRankList() {
        return this.rankList;
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bilibili.lib.arch.lifecycle.Resource rankList$lambda$0(com.bilibili.lib.arch.lifecycle.Resource r1) {
        /*
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.bili.ui.rank.RankVideoListViewModel.rankList$lambda$0(com.bilibili.lib.arch.lifecycle.Resource):com.bilibili.lib.arch.lifecycle.Resource");
    }

    public final void load() {
        this.loadModel.load();
    }
}