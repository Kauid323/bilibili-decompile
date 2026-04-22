package tv.danmaku.bili.appwidget.hotlist.model;

import ComposableSingletons$CustomBottomSheetKt$;
import android.net.Uri;
import com.bapis.bilibili.app.show.mixture.v1.RcmdReason;
import com.bapis.bilibili.app.show.mixture.v1.WidgetItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: HotListWidgetModel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0011\u0010\u0015J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\nHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010<\u001a\u00020\u000eHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jq\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u000eHÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006D"}, d2 = {"Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetItemModel;", "", ReportUtilKt.POS_COVER, "", "view", ReportUtilKt.POS_TITLE, ChannelRoutes.CHANNEL_NAME, AudioIntentHelper.ARGS_URI, "goto", "avid", "", "rcmdReason", "Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetRcmdModel;", "viewIcon", "", "coverFileUri", "Landroid/net/Uri;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLtv/danmaku/bili/appwidget/hotlist/model/HotListWidgetRcmdModel;ILandroid/net/Uri;)V", "widgetItem", "Lcom/bapis/bilibili/app/show/mixture/v1/WidgetItem;", "(Lcom/bapis/bilibili/app/show/mixture/v1/WidgetItem;)V", "getCover", "()Ljava/lang/String;", "setCover", "(Ljava/lang/String;)V", "getView", "setView", "getTitle", "setTitle", "getName", "setName", "getUri", "setUri", "getGoto", "setGoto", "getAvid", "()J", "setAvid", "(J)V", "getRcmdReason", "()Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetRcmdModel;", "setRcmdReason", "(Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetRcmdModel;)V", "getViewIcon", "()I", "setViewIcon", "(I)V", "getCoverFileUri", "()Landroid/net/Uri;", "setCoverFileUri", "(Landroid/net/Uri;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotListWidgetItemModel {
    public static final int $stable = 8;
    private long avid;
    private String cover;
    private Uri coverFileUri;

    /* renamed from: goto  reason: not valid java name */
    private String f2goto;
    private String name;
    private HotListWidgetRcmdModel rcmdReason;
    private String title;
    private String uri;
    private String view;
    private int viewIcon;

    public HotListWidgetItemModel() {
        this(null, null, null, null, null, null, 0L, null, 0, null, 1023, null);
    }

    public final String component1() {
        return this.cover;
    }

    public final Uri component10() {
        return this.coverFileUri;
    }

    public final String component2() {
        return this.view;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.uri;
    }

    public final String component6() {
        return this.f2goto;
    }

    public final long component7() {
        return this.avid;
    }

    public final HotListWidgetRcmdModel component8() {
        return this.rcmdReason;
    }

    public final int component9() {
        return this.viewIcon;
    }

    public final HotListWidgetItemModel copy(String str, String str2, String str3, String str4, String str5, String str6, long j, HotListWidgetRcmdModel hotListWidgetRcmdModel, int i, Uri uri) {
        Intrinsics.checkNotNullParameter(str, ReportUtilKt.POS_COVER);
        Intrinsics.checkNotNullParameter(str2, "view");
        Intrinsics.checkNotNullParameter(str3, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(str4, ChannelRoutes.CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(str5, AudioIntentHelper.ARGS_URI);
        Intrinsics.checkNotNullParameter(str6, "goto");
        return new HotListWidgetItemModel(str, str2, str3, str4, str5, str6, j, hotListWidgetRcmdModel, i, uri);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HotListWidgetItemModel) {
            HotListWidgetItemModel hotListWidgetItemModel = (HotListWidgetItemModel) obj;
            return Intrinsics.areEqual(this.cover, hotListWidgetItemModel.cover) && Intrinsics.areEqual(this.view, hotListWidgetItemModel.view) && Intrinsics.areEqual(this.title, hotListWidgetItemModel.title) && Intrinsics.areEqual(this.name, hotListWidgetItemModel.name) && Intrinsics.areEqual(this.uri, hotListWidgetItemModel.uri) && Intrinsics.areEqual(this.f2goto, hotListWidgetItemModel.f2goto) && this.avid == hotListWidgetItemModel.avid && Intrinsics.areEqual(this.rcmdReason, hotListWidgetItemModel.rcmdReason) && this.viewIcon == hotListWidgetItemModel.viewIcon && Intrinsics.areEqual(this.coverFileUri, hotListWidgetItemModel.coverFileUri);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.cover.hashCode() * 31) + this.view.hashCode()) * 31) + this.title.hashCode()) * 31) + this.name.hashCode()) * 31) + this.uri.hashCode()) * 31) + this.f2goto.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.avid)) * 31) + (this.rcmdReason == null ? 0 : this.rcmdReason.hashCode())) * 31) + this.viewIcon) * 31) + (this.coverFileUri != null ? this.coverFileUri.hashCode() : 0);
    }

    public String toString() {
        String str = this.cover;
        String str2 = this.view;
        String str3 = this.title;
        String str4 = this.name;
        String str5 = this.uri;
        String str6 = this.f2goto;
        long j = this.avid;
        HotListWidgetRcmdModel hotListWidgetRcmdModel = this.rcmdReason;
        int i = this.viewIcon;
        return "HotListWidgetItemModel(cover=" + str + ", view=" + str2 + ", title=" + str3 + ", name=" + str4 + ", uri=" + str5 + ", goto=" + str6 + ", avid=" + j + ", rcmdReason=" + hotListWidgetRcmdModel + ", viewIcon=" + i + ", coverFileUri=" + this.coverFileUri + ")";
    }

    public HotListWidgetItemModel(String cover, String view, String title, String name, String uri, String str, long avid, HotListWidgetRcmdModel rcmdReason, int viewIcon, Uri coverFileUri) {
        Intrinsics.checkNotNullParameter(cover, ReportUtilKt.POS_COVER);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(title, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(name, ChannelRoutes.CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(uri, AudioIntentHelper.ARGS_URI);
        Intrinsics.checkNotNullParameter(str, "goto");
        this.cover = cover;
        this.view = view;
        this.title = title;
        this.name = name;
        this.uri = uri;
        this.f2goto = str;
        this.avid = avid;
        this.rcmdReason = rcmdReason;
        this.viewIcon = viewIcon;
        this.coverFileUri = coverFileUri;
    }

    public /* synthetic */ HotListWidgetItemModel(String str, String str2, String str3, String str4, String str5, String str6, long j, HotListWidgetRcmdModel hotListWidgetRcmdModel, int i, Uri uri, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) == 0 ? str6 : "", (i2 & 64) != 0 ? 0L : j, (i2 & BR.cover) != 0 ? null : hotListWidgetRcmdModel, (i2 & BR.hallEnterHotText) != 0 ? 0 : i, (i2 & BR.roleType) == 0 ? uri : null);
    }

    public final String getCover() {
        return this.cover;
    }

    public final void setCover(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cover = str;
    }

    public final String getView() {
        return this.view;
    }

    public final void setView(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.view = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void setUri(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uri = str;
    }

    public final String getGoto() {
        return this.f2goto;
    }

    public final void setGoto(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f2goto = str;
    }

    public final long getAvid() {
        return this.avid;
    }

    public final void setAvid(long j) {
        this.avid = j;
    }

    public final HotListWidgetRcmdModel getRcmdReason() {
        return this.rcmdReason;
    }

    public final void setRcmdReason(HotListWidgetRcmdModel hotListWidgetRcmdModel) {
        this.rcmdReason = hotListWidgetRcmdModel;
    }

    public final int getViewIcon() {
        return this.viewIcon;
    }

    public final void setViewIcon(int i) {
        this.viewIcon = i;
    }

    public final Uri getCoverFileUri() {
        return this.coverFileUri;
    }

    public final void setCoverFileUri(Uri uri) {
        this.coverFileUri = uri;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HotListWidgetItemModel(WidgetItem widgetItem) {
        this(r3, r4, r5, r6, r7, r8, r9, r11, widgetItem.getViewIcon(), null, BR.roleType, null);
        HotListWidgetRcmdModel hotListWidgetRcmdModel;
        Intrinsics.checkNotNullParameter(widgetItem, "widgetItem");
        String cover = widgetItem.getCover();
        Intrinsics.checkNotNullExpressionValue(cover, "getCover(...)");
        String view = widgetItem.getView();
        Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
        String title = widgetItem.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
        String name = widgetItem.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String uri = widgetItem.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
        String str = widgetItem.getGoto();
        Intrinsics.checkNotNullExpressionValue(str, "getGoto(...)");
        long id = widgetItem.getId();
        if (widgetItem.hasRcmdReason()) {
            RcmdReason p0 = widgetItem.getRcmdReason();
            hotListWidgetRcmdModel = new HotListWidgetRcmdModel(p0);
        } else {
            hotListWidgetRcmdModel = null;
        }
    }
}