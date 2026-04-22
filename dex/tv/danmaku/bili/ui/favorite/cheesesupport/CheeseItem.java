package tv.danmaku.bili.ui.favorite.cheesesupport;

import com.alibaba.fastjson.annotation.JSONField;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

public class CheeseItem implements ICheeseItemProxy {
    @JSONField(name = "cooperation_mark")
    public String coMark;
    @JSONField(name = ReportUtilKt.POS_COVER)
    public String cover;
    @JSONField(name = "cooperated")
    public boolean isCooperation;
    @JSONField(name = "link")
    public String link;
    @JSONField(name = "play")
    public long play;
    @JSONField(name = "release_info")
    public String releaseInfo;
    @JSONField(name = "season_id")
    public long seasonId;
    @JSONField(name = "show_vt")
    public boolean showVt;
    @JSONField(name = "status")
    public String status;
    @JSONField(name = "subtitle")
    public String subtitle;
    @JSONField(name = ReportUtilKt.POS_TITLE)
    public String title;
    @JSONField(name = "vt_desc")
    public String vtDesc;
    @JSONField(name = "vt")
    public String vtNum;

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.ICheeseItemProxy
    public long getSeasonId() {
        return this.seasonId;
    }

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.ICheeseItemProxy
    public String getStatus() {
        return this.status;
    }

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.ICheeseItemProxy
    public String getCover() {
        return this.cover;
    }

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.ICheeseItemProxy
    public String getReleaseInfo() {
        return this.releaseInfo;
    }

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.ICheeseItemProxy
    public String getTitle() {
        return this.title;
    }

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.ICheeseItemProxy
    public String getSubtitle() {
        return this.subtitle;
    }

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.ICheeseItemProxy
    public String getLink() {
        return this.link;
    }

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.ICheeseItemProxy
    public long getPlay() {
        return this.play;
    }

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.ICheeseItemProxy
    public String getCooperationMark() {
        return this.coMark;
    }

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.ICheeseItemProxy
    public boolean isCooperation() {
        return this.isCooperation;
    }

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.ICheeseItemProxy
    public boolean showVt() {
        return this.showVt;
    }

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.ICheeseItemProxy
    public String getVtDesc() {
        return this.vtDesc;
    }

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.ICheeseItemProxy
    public String getVtNum() {
        return this.vtNum;
    }
}