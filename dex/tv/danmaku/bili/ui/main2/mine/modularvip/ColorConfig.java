package tv.danmaku.bili.ui.main2.mine.modularvip;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: ColorConfig.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0012HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorConfig;", "", "alpha", "", "value", "", "<init>", "(Ljava/lang/Float;Ljava/lang/String;)V", "getAlpha", "()Ljava/lang/Float;", "setAlpha", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "getColor", "", "()Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Float;Ljava/lang/String;)Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorConfig;", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ColorConfig {
    public static final int $stable = 8;
    @JSONField(name = "alpha")
    private Float alpha;
    @JSONField(name = "value")
    private String value;

    public ColorConfig() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ ColorConfig copy$default(ColorConfig colorConfig, Float f, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            f = colorConfig.alpha;
        }
        if ((i & 2) != 0) {
            str = colorConfig.value;
        }
        return colorConfig.copy(f, str);
    }

    public final Float component1() {
        return this.alpha;
    }

    public final String component2() {
        return this.value;
    }

    public final ColorConfig copy(Float f, String str) {
        return new ColorConfig(f, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ColorConfig) {
            ColorConfig colorConfig = (ColorConfig) obj;
            return Intrinsics.areEqual(this.alpha, colorConfig.alpha) && Intrinsics.areEqual(this.value, colorConfig.value);
        }
        return false;
    }

    public int hashCode() {
        return ((this.alpha == null ? 0 : this.alpha.hashCode()) * 31) + (this.value != null ? this.value.hashCode() : 0);
    }

    public String toString() {
        Float f = this.alpha;
        return "ColorConfig(alpha=" + f + ", value=" + this.value + ")";
    }

    public ColorConfig(Float alpha, String value) {
        this.alpha = alpha;
        this.value = value;
    }

    public /* synthetic */ ColorConfig(Float f, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : f, (i & 2) != 0 ? null : str);
    }

    public final Float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(Float f) {
        this.alpha = f;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final Integer getColor() {
        String colorValue;
        int i;
        String str = this.value;
        if (str == null || (colorValue = ListExtentionsKt.takeIfNotBlank(str)) == null) {
            return null;
        }
        try {
            int it = Color.parseColor(colorValue);
            if (!Intrinsics.areEqual(this.alpha, 1.0f) && this.alpha != null) {
                int $this$alpha$iv = (it >> 24) & BR.hallCover;
                Float f = this.alpha;
                Intrinsics.checkNotNull(f);
                i = ColorUtils.setAlphaComponent(it, (int) ($this$alpha$iv * f.floatValue()));
                return Integer.valueOf(i);
            }
            i = it;
            return Integer.valueOf(i);
        } catch (Exception e) {
            return null;
        }
    }
}