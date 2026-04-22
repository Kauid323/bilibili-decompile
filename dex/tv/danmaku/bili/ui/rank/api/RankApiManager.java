package tv.danmaku.bili.ui.rank.api;

import com.bapis.bilibili.app.show.rank.v1.RankAllResultReq;
import com.bapis.bilibili.app.show.rank.v1.RankListReply;
import com.bapis.bilibili.app.show.rank.v1.RankMoss;
import com.bapis.bilibili.app.show.rank.v1.RankRegionListReply;
import com.bapis.bilibili.app.show.rank.v1.RankRegionListReq;
import com.bapis.bilibili.app.show.rank.v1.RankRegionResultReq;
import com.bilibili.lib.moss.api.MossResponseHandler;
import tv.danmaku.bili.ui.rank.view.ViewHolderUgcKt;

public class RankApiManager {
    public static final int TOP_ALL = 2;
    public static final int TOP_BANGUMI = 3;
    public static final int TOP_ORIGINAL = 1;

    public static void getCategoryVideoList(int tid, int size, MossResponseHandler<RankListReply> cb) {
        RankRegionResultReq rankRegionResultReq = RankRegionResultReq.newBuilder().setPn(1).setPs(size).setRid(tid).build();
        new RankMoss().rankRegion(rankRegionResultReq, cb);
    }

    public static void getOriginalVideoList(int type, int size, MossResponseHandler<RankListReply> handler) {
        String order;
        if (type == 1) {
            order = "origin";
        } else if (type == 2) {
            order = "all";
        } else if (type == 3) {
            order = ViewHolderUgcKt.GOTO_BANGUMI;
        } else {
            order = "";
        }
        RankAllResultReq rankAllResultReq = RankAllResultReq.newBuilder().setOrder(order).setPs(size).setPn(1).build();
        new RankMoss().rankAll(rankAllResultReq, handler);
    }

    public static void getRankTabList(MossResponseHandler<RankRegionListReply> handler) {
        RankRegionListReq rankRegionListReq = RankRegionListReq.newBuilder().build();
        new RankMoss().rankRegionList(rankRegionListReq, handler);
    }
}