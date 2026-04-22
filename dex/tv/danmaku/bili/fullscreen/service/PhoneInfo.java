package tv.danmaku.bili.fullscreen.service;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: PhoneService.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Ltv/danmaku/bili/fullscreen/service/PhoneInfo;", "Landroid/os/Parcelable;", "resultCode", "", "securePhone", AuthResultCbHelper.ARGS_MSG, "ispCode", "Ltv/danmaku/bili/fullscreen/service/IspCode;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/fullscreen/service/IspCode;)V", "getResultCode", "()Ljava/lang/String;", "getSecurePhone", "getMsg", "getIspCode", "()Ltv/danmaku/bili/fullscreen/service/IspCode;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PhoneInfo implements Parcelable {
    private final IspCode ispCode;
    private final String msg;
    private final String resultCode;
    private final String securePhone;
    public static final Parcelable.Creator<PhoneInfo> CREATOR = new Creator();
    public static final int $stable = 8;

    /* compiled from: PhoneService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Creator implements Parcelable.Creator<PhoneInfo> {
        @Override // android.os.Parcelable.Creator
        public final PhoneInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PhoneInfo(parcel.readString(), parcel.readString(), parcel.readString(), IspCode.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneInfo[] newArray(int i) {
            return new PhoneInfo[i];
        }
    }

    public PhoneInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PhoneInfo copy$default(PhoneInfo phoneInfo, String str, String str2, String str3, IspCode ispCode, int i, Object obj) {
        if ((i & 1) != 0) {
            str = phoneInfo.resultCode;
        }
        if ((i & 2) != 0) {
            str2 = phoneInfo.securePhone;
        }
        if ((i & 4) != 0) {
            str3 = phoneInfo.msg;
        }
        if ((i & 8) != 0) {
            ispCode = phoneInfo.ispCode;
        }
        return phoneInfo.copy(str, str2, str3, ispCode);
    }

    public final String component1() {
        return this.resultCode;
    }

    public final String component2() {
        return this.securePhone;
    }

    public final String component3() {
        return this.msg;
    }

    public final IspCode component4() {
        return this.ispCode;
    }

    public final PhoneInfo copy(String str, String str2, String str3, IspCode ispCode) {
        Intrinsics.checkNotNullParameter(str, "resultCode");
        Intrinsics.checkNotNullParameter(str2, "securePhone");
        Intrinsics.checkNotNullParameter(str3, AuthResultCbHelper.ARGS_MSG);
        Intrinsics.checkNotNullParameter(ispCode, "ispCode");
        return new PhoneInfo(str, str2, str3, ispCode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PhoneInfo) {
            PhoneInfo phoneInfo = (PhoneInfo) obj;
            return Intrinsics.areEqual(this.resultCode, phoneInfo.resultCode) && Intrinsics.areEqual(this.securePhone, phoneInfo.securePhone) && Intrinsics.areEqual(this.msg, phoneInfo.msg) && this.ispCode == phoneInfo.ispCode;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.resultCode.hashCode() * 31) + this.securePhone.hashCode()) * 31) + this.msg.hashCode()) * 31) + this.ispCode.hashCode();
    }

    public String toString() {
        String str = this.resultCode;
        String str2 = this.securePhone;
        String str3 = this.msg;
        return "PhoneInfo(resultCode=" + str + ", securePhone=" + str2 + ", msg=" + str3 + ", ispCode=" + this.ispCode + ")";
    }

    public PhoneInfo(String resultCode, String securePhone, String msg, IspCode ispCode) {
        Intrinsics.checkNotNullParameter(resultCode, "resultCode");
        Intrinsics.checkNotNullParameter(securePhone, "securePhone");
        Intrinsics.checkNotNullParameter(msg, AuthResultCbHelper.ARGS_MSG);
        Intrinsics.checkNotNullParameter(ispCode, "ispCode");
        this.resultCode = resultCode;
        this.securePhone = securePhone;
        this.msg = msg;
        this.ispCode = ispCode;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public /* synthetic */ PhoneInfo(String str, String str2, String str3, IspCode ispCode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? IspCode.Unknown : ispCode);
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final String getSecurePhone() {
        return this.securePhone;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final IspCode getIspCode() {
        return this.ispCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.resultCode);
        dest.writeString(this.securePhone);
        dest.writeString(this.msg);
        dest.writeString(this.ispCode.name());
    }
}