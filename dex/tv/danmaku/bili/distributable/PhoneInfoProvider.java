package tv.danmaku.bili.distributable;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.IPhoneService;
import tv.danmaku.bili.fullscreen.service.PhoneInfo;

/* compiled from: DistributableLogin.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u0004H\u0096@¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/distributable/PhoneInfoProvider;", "Ltv/danmaku/bili/fullscreen/service/IPhoneService;", "Landroid/os/Parcelable;", "pf", "Ltv/danmaku/bili/fullscreen/service/PhoneInfo;", "<init>", "(Ltv/danmaku/bili/fullscreen/service/PhoneInfo;)V", "getPhoneInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PhoneInfoProvider implements IPhoneService, Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<PhoneInfoProvider> CREATOR = new Creator();
    private final PhoneInfo pf;

    /* compiled from: DistributableLogin.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Creator implements Parcelable.Creator<PhoneInfoProvider> {
        @Override // android.os.Parcelable.Creator
        public final PhoneInfoProvider createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PhoneInfoProvider(PhoneInfo.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneInfoProvider[] newArray(int i) {
            return new PhoneInfoProvider[i];
        }
    }

    private final PhoneInfo component1() {
        return this.pf;
    }

    public static /* synthetic */ PhoneInfoProvider copy$default(PhoneInfoProvider phoneInfoProvider, PhoneInfo phoneInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            phoneInfo = phoneInfoProvider.pf;
        }
        return phoneInfoProvider.copy(phoneInfo);
    }

    public final PhoneInfoProvider copy(PhoneInfo phoneInfo) {
        Intrinsics.checkNotNullParameter(phoneInfo, "pf");
        return new PhoneInfoProvider(phoneInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PhoneInfoProvider) && Intrinsics.areEqual(this.pf, ((PhoneInfoProvider) obj).pf);
    }

    public int hashCode() {
        return this.pf.hashCode();
    }

    public String toString() {
        return "PhoneInfoProvider(pf=" + this.pf + ")";
    }

    public PhoneInfoProvider(PhoneInfo pf) {
        Intrinsics.checkNotNullParameter(pf, "pf");
        this.pf = pf;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // tv.danmaku.bili.fullscreen.service.IPhoneService
    public Object getPhoneInfo(Continuation<? super PhoneInfo> continuation) {
        return this.pf;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        this.pf.writeToParcel(dest, flags);
    }
}