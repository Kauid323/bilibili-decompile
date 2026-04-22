package kntr.app.ad.common.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: AdSlot.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006$"}, d2 = {"Lkntr/app/ad/common/model/AdSlot;", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "PEGASUS_FEED", "PEGASUS_BANNER", "DETAIL_RELATE", "DETAIL_ENDPAGE", "DETAIL_UNDERFRAME", "DETAIL_MERCHANDISE", "DETAIL_DANMAKU", "DETAIL_COMMENT", "DETAIL_END_PAGE", "STORY_FEED", "STORY_COMMENT", "LIVE_ENTERPRICE", "LIVE_BIGCARD", "IAA", "SEARCH_FEED", "COMMENT_BLUELINK", "COMMENT_YELLOWSTRIP", "HOT_FEED", "IMAX", "FOLLOWING_FEED", "FOLLOWING_DETAIL", "FOLLOWING_COMMENT", "SPACE_SHOPENTRANCE", "SPACE_SHOPTAB", "SPALSH", "MALL_FEED", "MALL_TAB3", "OTHERS", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum AdSlot {
    PEGASUS_FEED("天马 - Feed"),
    PEGASUS_BANNER("天马 - Banner"),
    DETAIL_RELATE("播放页 - 相关推荐"),
    DETAIL_ENDPAGE("播放页 - 结束页"),
    DETAIL_UNDERFRAME("播放页 - 框下"),
    DETAIL_MERCHANDISE("播放页 - 楼层"),
    DETAIL_DANMAKU("播放页 - 弹幕"),
    DETAIL_COMMENT("播放页 - 评论"),
    DETAIL_END_PAGE("播放页 - 结束页"),
    STORY_FEED("Story - Feed"),
    STORY_COMMENT("Story - 评论"),
    LIVE_ENTERPRICE("直播间 - 经营号"),
    LIVE_BIGCARD("直播间 - 右下角大卡（品牌）"),
    IAA("IAA"),
    SEARCH_FEED("搜索 - Feed"),
    COMMENT_BLUELINK("评论 - 蓝链"),
    COMMENT_YELLOWSTRIP("评论 - 小黄条"),
    HOT_FEED("热门"),
    IMAX("巨幕"),
    FOLLOWING_FEED("动态 - Feed"),
    FOLLOWING_DETAIL("动态 - 详情"),
    FOLLOWING_COMMENT("动态 - 评论"),
    SPACE_SHOPENTRANCE("个人空间 - 商品入口"),
    SPACE_SHOPTAB("个人空间 - 商品Tab"),
    SPALSH("闪屏"),
    MALL_FEED("会员购 - Feed"),
    MALL_TAB3("会员购 - TAB3"),
    OTHERS("其它");
    
    private final String text;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<AdSlot> getEntries() {
        return $ENTRIES;
    }

    AdSlot(String text) {
        this.text = text;
    }

    public final String getText() {
        return this.text;
    }
}