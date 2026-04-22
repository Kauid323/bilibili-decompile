package tv.danmaku.bili.videopage.common.watchlater.api;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import java.math.BigDecimal;
import tv.danmaku.bili.ui.rank.router.RankRouter;

public class WatchLaterItem {
    @JSONField(name = "aid")
    public long avid;
    @JSONField(name = "cid")
    public long cid;
    @JSONField(name = "count")
    public int count;
    @JSONField(name = "pic")
    public String cover;
    @JSONField(name = "desc")
    public String description;
    @JSONField(name = "duration")
    public int duration;
    @JSONField(name = "enable_vt")
    public int enableVt;
    @JSONField(name = "owner")
    public Owner owner;
    @JSONField(name = "page")
    public Page page;
    @JSONField(name = "progress")
    public int progress;
    @JSONField(name = "stat")
    public Stat stat;
    @JSONField(name = "state")
    public int state;
    @JSONField(name = "tid")
    public long tid;
    @JSONField(name = RankRouter.BundleKey.ACTION_PARAM_TITLE)
    public String title;
    @JSONField(name = "uri")
    public String uri;
    @JSONField(name = "view_text_1")
    public String viewText1;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Owner {
        @JSONField(name = "face")
        public String face = "";
        @JSONField(name = RankRouter.BundleKey.AUTHOR_SPACE_MID)
        public long mid;
        @JSONField(name = "name")
        public String name;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Page {
        @JSONField(name = "cid")
        public long cid;
        @JSONField(name = "duration")
        public int duration;
        @JSONField(name = "from")
        public String from;
        @JSONField(name = "page")
        public int pageNumber;
        @JSONField(name = "weblink")
        public String webLink;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Stat {
        @JSONField(name = "danmaku")
        public long danMaKu;
        @JSONField(name = "view")

        /* renamed from: view  reason: collision with root package name */
        public long f26view;
        @JSONField(name = "vt")
        public long vt;
    }

    public boolean isVideoWatched() {
        return this.progress > 0 || this.progress == -1;
    }

    public String getReadableProgress() {
        if (this.page == null || this.page.duration <= 0 || this.progress < 0) {
            return "";
        }
        String percent = String.valueOf((this.progress / this.page.duration) * 100.0f);
        String progress = new BigDecimal(percent).setScale(0, 4).toString();
        return progress + "%";
    }

    public boolean isInvalidVideo() {
        return this.state < 0 && this.state != -6;
    }

    public boolean isPageVideo() {
        return this.count > 1;
    }

    public boolean isWatchFinished() {
        return this.progress == -1;
    }

    public boolean isWebLinkVideo() {
        return (this.page == null || TextUtils.isEmpty(this.page.webLink)) ? false : true;
    }

    public void update(WatchLaterItem newItem) {
        this.title = newItem.title;
        this.state = newItem.state;
        this.cover = newItem.cover;
        this.description = newItem.description;
        this.progress = newItem.progress;
    }
}