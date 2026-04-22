package tv.danmaku.bili.ui.rank.reporter;

import android.net.Uri;
import com.bilibili.commons.ArrayUtils;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import tv.danmaku.bili.ui.rank.model.RankModel;

public class RankingReport {
    public static final String ARGS_MORE_CLICK_LATER_PLAY = "2";
    public static final String ARGS_MORE_CLICK_POP_MENU = "1";
    public static final String ARGS_MORE_CLICK_WINDOW_PLAY = "3";

    public static void reportDiscoverTotalRankingClick() {
        RankingEvent event = new RankingEvent();
        event.eventId = "ranking_find_total_click";
        event.eventType = "click";
        InfoEyesManager.getInstance().report2(false, "000225", event.asArgs());
    }

    public static void reportDiscoverOriginRankingClick() {
        RankingEvent event = new RankingEvent();
        event.eventId = "ranking_find_original_click";
        event.eventType = "click";
        InfoEyesManager.getInstance().report2(false, "000225", event.asArgs());
    }

    public static void reportRankingTabClick(String name) {
        RankingEvent event = new RankingEvent();
        event.eventId = "ranking_tab_click";
        event.eventType = "click";
        event.putArgAt(name, 1);
        InfoEyesManager.getInstance().report2(false, "000225", event.asArgs());
    }

    public static void reportRankingVideoClick(String rankingName, String avid, String rankingIndex) {
        RankingEvent event = new RankingEvent();
        event.eventId = "ranking_video_click";
        event.eventType = "click";
        event.putArgAt(rankingName, 1);
        event.putArgAt(avid, 2);
        event.putArgAt(rankingIndex, 3);
        InfoEyesManager.getInstance().report2(false, "000225", event.asArgs());
    }

    public static void reportRankingPageShow(String pageName) {
        RankingEvent event = new RankingEvent();
        event.eventId = "ranking";
        event.eventType = pageName;
        InfoEyesManager.getInstance().report2(false, TaskIdConst.TABLE_H5_AUTOPLAY, event.asArgs());
    }

    public static void reportRankingHeadClick(String rankingName, String uid) {
        RankingEvent event = new RankingEvent();
        event.eventId = "ranking_head_click";
        event.eventType = "click";
        event.putArgAt(rankingName, 1);
        event.putArgAt(uid, 2);
        InfoEyesManager.getInstance().report2(false, "000225", event.asArgs());
    }

    public static void reportRankingFollowClick(RankModel rank, boolean follow) {
        if (rank == null) {
            return;
        }
        RankingEvent event = new RankingEvent();
        event.eventId = follow ? "ranking_follow_click" : "ranking_unfollow_click";
        event.eventType = "click";
        event.putArgAt(rank.getTitle(), 1);
        event.putArgAt(String.valueOf(rank.getMid()), 2);
        event.putArgAt("98", 3);
        event.putArgAt(rank.getParam(), 4);
        event.putArgAt(rank.getCid() > 0 ? String.valueOf(rank.getCid()) : "", 5);
        InfoEyesManager.getInstance().report2(false, "000225", event.asArgs());
    }

    public static void reportRankingMoreClick(String rankingName, String from) {
        RankingEvent event = new RankingEvent();
        event.eventId = "ranking_more_click";
        event.eventType = "click";
        event.putArgAt(rankingName, 1);
        event.putArgAt(from, 2);
        InfoEyesManager.getInstance().report2(false, "000225", event.asArgs());
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static class RankingEvent {
        private static final int ARGS_COUNT = 5;
        private String[] args = new String[5];
        public String eventId;
        public String eventType;

        public RankingEvent() {
            for (int i = 0; i < 5; i++) {
                this.args[i] = "";
            }
        }

        public String[] asArgs() {
            String[] array1 = {Uri.encode(this.eventId), Uri.encode(this.eventType)};
            return (String[]) ArrayUtils.addAll(array1, this.args);
        }

        public void putArgAt(String arg, int pos) {
            this.args[pos - 1] = Uri.encode(arg);
        }
    }
}