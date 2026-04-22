package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: BiliNftTransfer.kt */
@Bson
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/BiliNftTransfer;", "", "status", "", "jumpUrl", "", ReportUtilKt.POS_TITLE, "contentTemplate", "highlightParams", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getStatus", "()I", "getJumpUrl", "()Ljava/lang/String;", "getTitle", "getContentTemplate", "getHighlightParams", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliNftTransfer {
    public static final int $stable = 8;
    @SerializedName("content_template")
    private final String contentTemplate;
    @SerializedName("highlight_params")
    private final List<String> highlightParams;
    @SerializedName("jump_url")
    private final String jumpUrl;
    @SerializedName("status")
    private final int status;
    @SerializedName(ReportUtilKt.POS_TITLE)
    private final String title;

    public static /* synthetic */ BiliNftTransfer copy$default(BiliNftTransfer biliNftTransfer, int i, String str, String str2, String str3, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = biliNftTransfer.status;
        }
        if ((i2 & 2) != 0) {
            str = biliNftTransfer.jumpUrl;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = biliNftTransfer.title;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = biliNftTransfer.contentTemplate;
        }
        String str6 = str3;
        List<String> list2 = list;
        if ((i2 & 16) != 0) {
            list2 = biliNftTransfer.highlightParams;
        }
        return biliNftTransfer.copy(i, str4, str5, str6, list2);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.jumpUrl;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.contentTemplate;
    }

    public final List<String> component5() {
        return this.highlightParams;
    }

    public final BiliNftTransfer copy(int i, String str, String str2, String str3, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "jumpUrl");
        Intrinsics.checkNotNullParameter(str2, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(str3, "contentTemplate");
        Intrinsics.checkNotNullParameter(list, "highlightParams");
        return new BiliNftTransfer(i, str, str2, str3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiliNftTransfer) {
            BiliNftTransfer biliNftTransfer = (BiliNftTransfer) obj;
            return this.status == biliNftTransfer.status && Intrinsics.areEqual(this.jumpUrl, biliNftTransfer.jumpUrl) && Intrinsics.areEqual(this.title, biliNftTransfer.title) && Intrinsics.areEqual(this.contentTemplate, biliNftTransfer.contentTemplate) && Intrinsics.areEqual(this.highlightParams, biliNftTransfer.highlightParams);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.status * 31) + this.jumpUrl.hashCode()) * 31) + this.title.hashCode()) * 31) + this.contentTemplate.hashCode()) * 31) + this.highlightParams.hashCode();
    }

    public String toString() {
        int i = this.status;
        String str = this.jumpUrl;
        String str2 = this.title;
        String str3 = this.contentTemplate;
        return "BiliNftTransfer(status=" + i + ", jumpUrl=" + str + ", title=" + str2 + ", contentTemplate=" + str3 + ", highlightParams=" + this.highlightParams + ")";
    }

    public BiliNftTransfer(int status, String jumpUrl, String title, String contentTemplate, List<String> list) {
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(title, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(contentTemplate, "contentTemplate");
        Intrinsics.checkNotNullParameter(list, "highlightParams");
        this.status = status;
        this.jumpUrl = jumpUrl;
        this.title = title;
        this.contentTemplate = contentTemplate;
        this.highlightParams = list;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getContentTemplate() {
        return this.contentTemplate;
    }

    public final List<String> getHighlightParams() {
        return this.highlightParams;
    }
}