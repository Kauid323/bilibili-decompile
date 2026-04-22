package kntr.base.net.freedata;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GFreeData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0087\b\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lkntr/base/net/freedata/Result;", "", "provider", "", "tftype", "", "errorCode", "url", "tf", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;Z)V", "getProvider", "()Ljava/lang/String;", "setProvider", "(Ljava/lang/String;)V", "getTftype", "()I", "setTftype", "(I)V", "getErrorCode", "setErrorCode", "getUrl", "setUrl", "getTf", "()Z", "setTf", "(Z)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "freedata_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Result {
    private int errorCode;
    private String provider;
    private boolean tf;
    private int tftype;
    private String url;

    public static /* synthetic */ Result copy$default(Result result, String str, int i, int i2, String str2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = result.provider;
        }
        if ((i3 & 2) != 0) {
            i = result.tftype;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = result.errorCode;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            str2 = result.url;
        }
        String str3 = str2;
        if ((i3 & 16) != 0) {
            z = result.tf;
        }
        return result.copy(str, i4, i5, str3, z);
    }

    public final String component1() {
        return this.provider;
    }

    public final int component2() {
        return this.tftype;
    }

    public final int component3() {
        return this.errorCode;
    }

    public final String component4() {
        return this.url;
    }

    public final boolean component5() {
        return this.tf;
    }

    public final Result copy(String str, int i, int i2, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "provider");
        Intrinsics.checkNotNullParameter(str2, "url");
        return new Result(str, i, i2, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Result) {
            Result result = (Result) obj;
            return Intrinsics.areEqual(this.provider, result.provider) && this.tftype == result.tftype && this.errorCode == result.errorCode && Intrinsics.areEqual(this.url, result.url) && this.tf == result.tf;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.provider.hashCode() * 31) + this.tftype) * 31) + this.errorCode) * 31) + this.url.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.tf);
    }

    public String toString() {
        String str = this.provider;
        int i = this.tftype;
        int i2 = this.errorCode;
        String str2 = this.url;
        return "Result(provider=" + str + ", tftype=" + i + ", errorCode=" + i2 + ", url=" + str2 + ", tf=" + this.tf + ")";
    }

    public Result(String provider, int tftype, int errorCode, String url, boolean tf) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(url, "url");
        this.provider = provider;
        this.tftype = tftype;
        this.errorCode = errorCode;
        this.url = url;
        this.tf = tf;
    }

    public final String getProvider() {
        return this.provider;
    }

    public final void setProvider(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.provider = str;
    }

    public final int getTftype() {
        return this.tftype;
    }

    public final void setTftype(int i) {
        this.tftype = i;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final boolean getTf() {
        return this.tf;
    }

    public final void setTf(boolean z) {
        this.tf = z;
    }
}