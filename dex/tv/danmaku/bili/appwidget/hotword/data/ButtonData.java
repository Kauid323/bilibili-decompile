package tv.danmaku.bili.appwidget.hotword.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: HotWordLocalWidgetData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/appwidget/hotword/data/ButtonData;", "", "text", "", "icon", "", "url", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "getIcon", "()I", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ButtonData {
    public static final int $stable = 0;
    private final int icon;
    private final String text;
    private final String url;

    public static /* synthetic */ ButtonData copy$default(ButtonData buttonData, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = buttonData.text;
        }
        if ((i2 & 2) != 0) {
            i = buttonData.icon;
        }
        if ((i2 & 4) != 0) {
            str2 = buttonData.url;
        }
        return buttonData.copy(str, i, str2);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.icon;
    }

    public final String component3() {
        return this.url;
    }

    public final ButtonData copy(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "url");
        return new ButtonData(str, i, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ButtonData) {
            ButtonData buttonData = (ButtonData) obj;
            return Intrinsics.areEqual(this.text, buttonData.text) && this.icon == buttonData.icon && Intrinsics.areEqual(this.url, buttonData.url);
        }
        return false;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + this.icon) * 31) + this.url.hashCode();
    }

    public String toString() {
        String str = this.text;
        int i = this.icon;
        return "ButtonData(text=" + str + ", icon=" + i + ", url=" + this.url + ")";
    }

    public ButtonData(String text, int icon, String url) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(url, "url");
        this.text = text;
        this.icon = icon;
        this.url = url;
    }

    public final String getText() {
        return this.text;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getUrl() {
        return this.url;
    }
}