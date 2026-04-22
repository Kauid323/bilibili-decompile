package tv.danmaku.bili.fullscreen.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LoginTypeRule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0081\u0002\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bj\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "Landroid/os/Parcelable;", "", "<init>", "(Ljava/lang/String;I)V", "None", "FastReLogin", "QuickLogin", "SmsLogin", "PwdLogin", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum ValidLoginType implements Parcelable {
    None,
    FastReLogin,
    QuickLogin,
    SmsLogin,
    PwdLogin;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ValidLoginType> CREATOR = new Parcelable.Creator<ValidLoginType>() { // from class: tv.danmaku.bili.fullscreen.route.ValidLoginType.Creator
        @Override // android.os.Parcelable.Creator
        public final ValidLoginType createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return ValidLoginType.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ValidLoginType[] newArray(int i) {
            return new ValidLoginType[i];
        }
    };
    private static final List<ValidLoginType> allValues = CollectionsKt.listOf(new ValidLoginType[]{FastReLogin, QuickLogin, SmsLogin, PwdLogin});

    public static EnumEntries<ValidLoginType> getEntries() {
        return $ENTRIES;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* compiled from: LoginTypeRule.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/fullscreen/route/ValidLoginType$Companion;", "", "<init>", "()V", "allValues", "", "Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "getAllValues", "()Ljava/util/List;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<ValidLoginType> getAllValues() {
            return ValidLoginType.allValues;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(name());
    }
}