package tv.danmaku.bili.widget.dialog;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CustomButtonInfo.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/widget/dialog/CustomButtonInfo;", "", "textColor", "", "btnBackground", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getTextColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBtnBackground", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Ltv/danmaku/bili/widget/dialog/CustomButtonInfo;", "equals", "", "other", "hashCode", "toString", "", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CustomButtonInfo {
    private final Integer btnBackground;
    private final Integer textColor;

    public CustomButtonInfo() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ CustomButtonInfo copy$default(CustomButtonInfo customButtonInfo, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = customButtonInfo.textColor;
        }
        if ((i & 2) != 0) {
            num2 = customButtonInfo.btnBackground;
        }
        return customButtonInfo.copy(num, num2);
    }

    public final Integer component1() {
        return this.textColor;
    }

    public final Integer component2() {
        return this.btnBackground;
    }

    public final CustomButtonInfo copy(Integer num, Integer num2) {
        return new CustomButtonInfo(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CustomButtonInfo) {
            CustomButtonInfo customButtonInfo = (CustomButtonInfo) obj;
            return Intrinsics.areEqual(this.textColor, customButtonInfo.textColor) && Intrinsics.areEqual(this.btnBackground, customButtonInfo.btnBackground);
        }
        return false;
    }

    public int hashCode() {
        return ((this.textColor == null ? 0 : this.textColor.hashCode()) * 31) + (this.btnBackground != null ? this.btnBackground.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.textColor;
        return "CustomButtonInfo(textColor=" + num + ", btnBackground=" + this.btnBackground + ")";
    }

    public CustomButtonInfo(Integer textColor, Integer btnBackground) {
        this.textColor = textColor;
        this.btnBackground = btnBackground;
    }

    public /* synthetic */ CustomButtonInfo(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    public final Integer getTextColor() {
        return this.textColor;
    }

    public final Integer getBtnBackground() {
        return this.btnBackground;
    }
}