package tv.danmaku.bili.ui.main2.api;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: VIPSectionData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J0\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Ltv/danmaku/bili/ui/main2/api/VIPSectionStyle;", "", "type", "", "value", "", "alpha", "", "<init>", "(ILjava/lang/String;Ljava/lang/Float;)V", "getType", "()I", "setType", "(I)V", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "getAlpha", "()Ljava/lang/Float;", "setAlpha", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getColor", "()Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Float;)Ltv/danmaku/bili/ui/main2/api/VIPSectionStyle;", "equals", "", "other", "hashCode", "toString", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class VIPSectionStyle {
    public static final int TYPE_COLOR = 0;
    public static final int TYPE_IMAGE = 1;
    @JSONField(name = "alpha")
    private Float alpha;
    @JSONField(name = "type")
    private int type;
    @JSONField(name = "value")
    private String value;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public VIPSectionStyle() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ VIPSectionStyle copy$default(VIPSectionStyle vIPSectionStyle, int i, String str, Float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = vIPSectionStyle.type;
        }
        if ((i2 & 2) != 0) {
            str = vIPSectionStyle.value;
        }
        if ((i2 & 4) != 0) {
            f = vIPSectionStyle.alpha;
        }
        return vIPSectionStyle.copy(i, str, f);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.value;
    }

    public final Float component3() {
        return this.alpha;
    }

    public final VIPSectionStyle copy(int i, String str, Float f) {
        return new VIPSectionStyle(i, str, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VIPSectionStyle) {
            VIPSectionStyle vIPSectionStyle = (VIPSectionStyle) obj;
            return this.type == vIPSectionStyle.type && Intrinsics.areEqual(this.value, vIPSectionStyle.value) && Intrinsics.areEqual(this.alpha, vIPSectionStyle.alpha);
        }
        return false;
    }

    public int hashCode() {
        return (((this.type * 31) + (this.value == null ? 0 : this.value.hashCode())) * 31) + (this.alpha != null ? this.alpha.hashCode() : 0);
    }

    public String toString() {
        int i = this.type;
        String str = this.value;
        return "VIPSectionStyle(type=" + i + ", value=" + str + ", alpha=" + this.alpha + ")";
    }

    public VIPSectionStyle(int type, String value, Float alpha) {
        this.type = type;
        this.value = value;
        this.alpha = alpha;
    }

    public /* synthetic */ VIPSectionStyle(int i, String str, Float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? Float.valueOf(1.0f) : f);
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final Float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(Float f) {
        this.alpha = f;
    }

    /* compiled from: VIPSectionData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/main2/api/VIPSectionStyle$Companion;", "", "<init>", "()V", "TYPE_COLOR", "", "TYPE_IMAGE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Integer getColor() {
        int i;
        try {
            int it = Color.parseColor(this.value);
            if (!Intrinsics.areEqual(this.alpha, 1.0f) && this.alpha != null) {
                int $this$alpha$iv = (it >> 24) & BR.hallCover;
                float f = $this$alpha$iv;
                Float f2 = this.alpha;
                if (f2 != null) {
                    i = ColorUtils.setAlphaComponent(it, (int) (f * f2.floatValue()));
                    it = i;
                }
                return Integer.valueOf(it);
            }
            i = it;
            it = i;
            return Integer.valueOf(it);
        } catch (Exception e) {
            return null;
        }
    }
}