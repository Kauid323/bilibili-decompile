package tv.danmaku.bili.fullscreen.exp;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: IFullscreenLoginExp.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0081\u0002\u0018\u0000 \u001e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001eB1\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fj\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/fullscreen/exp/LoginExpType;", "Landroid/os/Parcelable;", "", "reportName", "", "showOnepass", "", "showSms", "smsSkippable", "quickReloginSkippable", "<init>", "(Ljava/lang/String;ILjava/lang/String;ZZZZ)V", "getReportName", "()Ljava/lang/String;", "getShowOnepass", "()Z", "getShowSms", "getSmsSkippable", "getQuickReloginSkippable", "A_PHONE", "B_PHONE_SMS", "C_PHONE_SMS_STRONG", "CONTROL", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum LoginExpType implements Parcelable {
    A_PHONE("A", true, false, true, false),
    B_PHONE_SMS("B", true, true, true, false),
    C_PHONE_SMS_STRONG("C", true, true, false, false),
    CONTROL("CONTROL", false, false, true, true);
    
    private final boolean quickReloginSkippable;
    private final String reportName;
    private final boolean showOnepass;
    private final boolean showSms;
    private final boolean smsSkippable;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<LoginExpType> CREATOR = new Parcelable.Creator<LoginExpType>() { // from class: tv.danmaku.bili.fullscreen.exp.LoginExpType.Creator
        @Override // android.os.Parcelable.Creator
        public final LoginExpType createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return LoginExpType.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final LoginExpType[] newArray(int i) {
            return new LoginExpType[i];
        }
    };

    public static EnumEntries<LoginExpType> getEntries() {
        return $ENTRIES;
    }

    LoginExpType(String reportName, boolean showOnepass, boolean showSms, boolean smsSkippable, boolean quickReloginSkippable) {
        this.reportName = reportName;
        this.showOnepass = showOnepass;
        this.showSms = showSms;
        this.smsSkippable = smsSkippable;
        this.quickReloginSkippable = quickReloginSkippable;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getReportName() {
        return this.reportName;
    }

    public final boolean getShowOnepass() {
        return this.showOnepass;
    }

    public final boolean getShowSms() {
        return this.showSms;
    }

    public final boolean getSmsSkippable() {
        return this.smsSkippable;
    }

    public final boolean getQuickReloginSkippable() {
        return this.quickReloginSkippable;
    }

    /* compiled from: IFullscreenLoginExp.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/fullscreen/exp/LoginExpType$Companion;", "", "<init>", "()V", "parse", "Ltv/danmaku/bili/fullscreen/exp/LoginExpType;", ChannelRoutes.CHANNEL_NAME, "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoginExpType parse(String name) {
            try {
                return LoginExpType.valueOf(name == null ? "CONTROL" : name);
            } catch (Exception e) {
                return LoginExpType.CONTROL;
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(name());
    }
}