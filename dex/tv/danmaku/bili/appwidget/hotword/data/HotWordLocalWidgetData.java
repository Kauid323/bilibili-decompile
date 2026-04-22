package tv.danmaku.bili.appwidget.hotword.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: HotWordLocalWidgetData.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/appwidget/hotword/data/HotWordLocalWidgetData;", "", "hotWord", "", "buttons", "", "Ltv/danmaku/bili/appwidget/hotword/data/ButtonData;", "searchJumpLink", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getHotWord", "()Ljava/lang/String;", "getButtons", "()Ljava/util/List;", "getSearchJumpLink", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotWordLocalWidgetData {
    public static final int $stable = 8;
    private final List<ButtonData> buttons;
    private final String hotWord;
    private final String searchJumpLink;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HotWordLocalWidgetData copy$default(HotWordLocalWidgetData hotWordLocalWidgetData, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hotWordLocalWidgetData.hotWord;
        }
        if ((i & 2) != 0) {
            list = hotWordLocalWidgetData.buttons;
        }
        if ((i & 4) != 0) {
            str2 = hotWordLocalWidgetData.searchJumpLink;
        }
        return hotWordLocalWidgetData.copy(str, list, str2);
    }

    public final String component1() {
        return this.hotWord;
    }

    public final List<ButtonData> component2() {
        return this.buttons;
    }

    public final String component3() {
        return this.searchJumpLink;
    }

    public final HotWordLocalWidgetData copy(String str, List<ButtonData> list, String str2) {
        Intrinsics.checkNotNullParameter(str, "hotWord");
        Intrinsics.checkNotNullParameter(list, "buttons");
        return new HotWordLocalWidgetData(str, list, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HotWordLocalWidgetData) {
            HotWordLocalWidgetData hotWordLocalWidgetData = (HotWordLocalWidgetData) obj;
            return Intrinsics.areEqual(this.hotWord, hotWordLocalWidgetData.hotWord) && Intrinsics.areEqual(this.buttons, hotWordLocalWidgetData.buttons) && Intrinsics.areEqual(this.searchJumpLink, hotWordLocalWidgetData.searchJumpLink);
        }
        return false;
    }

    public int hashCode() {
        return (((this.hotWord.hashCode() * 31) + this.buttons.hashCode()) * 31) + (this.searchJumpLink == null ? 0 : this.searchJumpLink.hashCode());
    }

    public String toString() {
        String str = this.hotWord;
        List<ButtonData> list = this.buttons;
        return "HotWordLocalWidgetData(hotWord=" + str + ", buttons=" + list + ", searchJumpLink=" + this.searchJumpLink + ")";
    }

    public HotWordLocalWidgetData(String hotWord, List<ButtonData> list, String searchJumpLink) {
        Intrinsics.checkNotNullParameter(hotWord, "hotWord");
        Intrinsics.checkNotNullParameter(list, "buttons");
        this.hotWord = hotWord;
        this.buttons = list;
        this.searchJumpLink = searchJumpLink;
    }

    public /* synthetic */ HotWordLocalWidgetData(String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i & 4) != 0 ? null : str2);
    }

    public final String getHotWord() {
        return this.hotWord;
    }

    public final List<ButtonData> getButtons() {
        return this.buttons;
    }

    public final String getSearchJumpLink() {
        return this.searchJumpLink;
    }
}