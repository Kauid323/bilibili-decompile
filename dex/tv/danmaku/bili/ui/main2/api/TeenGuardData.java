package tv.danmaku.bili.ui.main2.api;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: TeenGuardData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/main2/api/TeenGuardData;", "", "url", "", "relationType", "", "<init>", "(Ljava/lang/String;I)V", "()V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getRelationType", "()I", "setRelationType", "(I)V", "requireUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TeenGuardData {
    public static final int $stable = 8;
    @JSONField(name = "relation_type")
    private int relationType;
    @JSONField(name = "url")
    private String url;

    public static /* synthetic */ TeenGuardData copy$default(TeenGuardData teenGuardData, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = teenGuardData.url;
        }
        if ((i2 & 2) != 0) {
            i = teenGuardData.relationType;
        }
        return teenGuardData.copy(str, i);
    }

    public final String component1() {
        return this.url;
    }

    public final int component2() {
        return this.relationType;
    }

    public final TeenGuardData copy(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "url");
        return new TeenGuardData(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TeenGuardData) {
            TeenGuardData teenGuardData = (TeenGuardData) obj;
            return Intrinsics.areEqual(this.url, teenGuardData.url) && this.relationType == teenGuardData.relationType;
        }
        return false;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.relationType;
    }

    public String toString() {
        String str = this.url;
        return "TeenGuardData(url=" + str + ", relationType=" + this.relationType + ")";
    }

    public TeenGuardData(String url, int relationType) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.relationType = relationType;
    }

    public /* synthetic */ TeenGuardData(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final int getRelationType() {
        return this.relationType;
    }

    public final void setRelationType(int i) {
        this.relationType = i;
    }

    public TeenGuardData() {
        this("", 0);
    }

    public final String requireUrl() {
        if (!StringsKt.isBlank(this.url)) {
            return this.url;
        }
        throw new NullPointerException("Url is blank");
    }
}