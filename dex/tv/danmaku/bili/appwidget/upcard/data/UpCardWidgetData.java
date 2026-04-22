package tv.danmaku.bili.appwidget.upcard.data;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: UpCardWidgetData.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR \u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR \u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR \u0010&\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\tR(\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006/"}, d2 = {"Ltv/danmaku/bili/appwidget/upcard/data/UpCardWidgetData;", "", "<init>", "()V", ReportUtilKt.POS_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "style", "", "getStyle", "()I", "setStyle", "(I)V", "widgetUpCards", "", "Ltv/danmaku/bili/appwidget/upcard/data/WidgetUpCard;", "getWidgetUpCards", "()Ljava/util/List;", "setWidgetUpCards", "(Ljava/util/List;)V", "widgetMore", "Ltv/danmaku/bili/appwidget/upcard/data/WidgetMore;", "getWidgetMore", "()Ltv/danmaku/bili/appwidget/upcard/data/WidgetMore;", "setWidgetMore", "(Ltv/danmaku/bili/appwidget/upcard/data/WidgetMore;)V", "content", "getContent", "setContent", "desc", "getDesc", "setDesc", "onlineViewersCnt", "getOnlineViewersCnt", "setOnlineViewersCnt", "dynUnreadCnt", "getDynUnreadCnt", "setDynUnreadCnt", "size", "Lkotlin/Pair;", "getSize", "()Lkotlin/Pair;", "setSize", "(Lkotlin/Pair;)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UpCardWidgetData {
    public static final int $stable = 8;
    @JSONField(name = "content")
    private String content;
    @JSONField(name = "desc")
    private String desc;
    @JSONField(name = "dyn_unread_cnt")
    private String dynUnreadCnt;
    @JSONField(name = "online_viewers_cnt")
    private String onlineViewersCnt;
    private Pair<Integer, Integer> size;
    @JSONField(name = "style")
    private int style;
    @JSONField(name = ReportUtilKt.POS_TITLE)
    private String title;
    @JSONField(name = "widget_more")
    private WidgetMore widgetMore;
    @JSONField(name = "widget_cards")
    private List<WidgetUpCard> widgetUpCards;

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final int getStyle() {
        return this.style;
    }

    public final void setStyle(int i) {
        this.style = i;
    }

    public final List<WidgetUpCard> getWidgetUpCards() {
        return this.widgetUpCards;
    }

    public final void setWidgetUpCards(List<WidgetUpCard> list) {
        this.widgetUpCards = list;
    }

    public final WidgetMore getWidgetMore() {
        return this.widgetMore;
    }

    public final void setWidgetMore(WidgetMore widgetMore) {
        this.widgetMore = widgetMore;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final String getOnlineViewersCnt() {
        return this.onlineViewersCnt;
    }

    public final void setOnlineViewersCnt(String str) {
        this.onlineViewersCnt = str;
    }

    public final String getDynUnreadCnt() {
        return this.dynUnreadCnt;
    }

    public final void setDynUnreadCnt(String str) {
        this.dynUnreadCnt = str;
    }

    public final Pair<Integer, Integer> getSize() {
        return this.size;
    }

    public final void setSize(Pair<Integer, Integer> pair) {
        this.size = pair;
    }
}