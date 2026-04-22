package tv.danmaku.bili.fullscreen.route;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LoginPageType.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007j\u0002\b\u0005¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/fullscreen/route/PhoneBindingFrom;", "Landroid/os/Parcelable;", "", "<init>", "(Ljava/lang/String;I)V", "NetCode", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum PhoneBindingFrom implements Parcelable {
    NetCode;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Parcelable.Creator<PhoneBindingFrom> CREATOR = new Parcelable.Creator<PhoneBindingFrom>() { // from class: tv.danmaku.bili.fullscreen.route.PhoneBindingFrom.Creator
        @Override // android.os.Parcelable.Creator
        public final PhoneBindingFrom createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return PhoneBindingFrom.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneBindingFrom[] newArray(int i) {
            return new PhoneBindingFrom[i];
        }
    };

    public static EnumEntries<PhoneBindingFrom> getEntries() {
        return $ENTRIES;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(name());
    }
}