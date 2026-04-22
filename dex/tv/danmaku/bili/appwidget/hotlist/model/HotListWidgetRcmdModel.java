package tv.danmaku.bili.appwidget.hotlist.model;

import com.bapis.bilibili.app.show.mixture.v1.RcmdReason;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: HotListWidgetModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetRcmdModel;", "", "content", "", "<init>", "(Ljava/lang/String;)V", "rcmdReason", "Lcom/bapis/bilibili/app/show/mixture/v1/RcmdReason;", "(Lcom/bapis/bilibili/app/show/mixture/v1/RcmdReason;)V", "getContent", "()Ljava/lang/String;", "setContent", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotListWidgetRcmdModel {
    public static final int $stable = 8;
    private String content;

    public HotListWidgetRcmdModel() {
        this(null, 1, null);
    }

    public static /* synthetic */ HotListWidgetRcmdModel copy$default(HotListWidgetRcmdModel hotListWidgetRcmdModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hotListWidgetRcmdModel.content;
        }
        return hotListWidgetRcmdModel.copy(str);
    }

    public final String component1() {
        return this.content;
    }

    public final HotListWidgetRcmdModel copy(String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        return new HotListWidgetRcmdModel(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HotListWidgetRcmdModel) && Intrinsics.areEqual(this.content, ((HotListWidgetRcmdModel) obj).content);
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public String toString() {
        return "HotListWidgetRcmdModel(content=" + this.content + ")";
    }

    public HotListWidgetRcmdModel(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
    }

    public /* synthetic */ HotListWidgetRcmdModel(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HotListWidgetRcmdModel(RcmdReason rcmdReason) {
        this(r0);
        Intrinsics.checkNotNullParameter(rcmdReason, "rcmdReason");
        String content = rcmdReason.getContent();
        Intrinsics.checkNotNullExpressionValue(content, "getContent(...)");
    }
}