package tv.danmaku.bili.appwidget.guide;

import android.os.Parcel;
import android.os.Parcelable;
import com.bilibili.bus.IInterProcData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: AutoAddResult.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0010HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006 "}, d2 = {"Ltv/danmaku/bili/appwidget/guide/AutoAddResult;", "Lcom/bilibili/bus/IInterProcData;", FavoritesConstsKt.SPMID, "", "type", "contentId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getSpmid", "()Ljava/lang/String;", "getType", "getContentId", "describeContents", "", "writeToParcel", "", "dest", "flags", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AutoAddResult implements IInterProcData {
    public static final int $stable = 0;
    public static final CREATOR CREATOR = new CREATOR(null);
    private final String contentId;
    private final String spmid;
    private final String type;

    public static /* synthetic */ AutoAddResult copy$default(AutoAddResult autoAddResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = autoAddResult.spmid;
        }
        if ((i & 2) != 0) {
            str2 = autoAddResult.type;
        }
        if ((i & 4) != 0) {
            str3 = autoAddResult.contentId;
        }
        return autoAddResult.copy(str, str2, str3);
    }

    public final String component1() {
        return this.spmid;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.contentId;
    }

    public final AutoAddResult copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(str2, "type");
        return new AutoAddResult(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AutoAddResult) {
            AutoAddResult autoAddResult = (AutoAddResult) obj;
            return Intrinsics.areEqual(this.spmid, autoAddResult.spmid) && Intrinsics.areEqual(this.type, autoAddResult.type) && Intrinsics.areEqual(this.contentId, autoAddResult.contentId);
        }
        return false;
    }

    public int hashCode() {
        return (((this.spmid.hashCode() * 31) + this.type.hashCode()) * 31) + (this.contentId == null ? 0 : this.contentId.hashCode());
    }

    public String toString() {
        String str = this.spmid;
        String str2 = this.type;
        return "AutoAddResult(spmid=" + str + ", type=" + str2 + ", contentId=" + this.contentId + ")";
    }

    public AutoAddResult(String spmid, String type, String contentId) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(type, "type");
        this.spmid = spmid;
        this.type = type;
        this.contentId = contentId;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getSpmid() {
        return this.spmid;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AutoAddResult(Parcel parcel) {
        this(r0, r2 != null ? r2 : "", parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        readString = readString == null ? "" : readString;
        String readString2 = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.spmid);
        dest.writeString(this.type);
        dest.writeString(this.contentId);
    }

    /* compiled from: AutoAddResult.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/AutoAddResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/appwidget/guide/AutoAddResult;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/appwidget/guide/AutoAddResult;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CREATOR implements Parcelable.Creator<AutoAddResult> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public AutoAddResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AutoAddResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AutoAddResult[] newArray(int size) {
            return new AutoAddResult[size];
        }
    }
}