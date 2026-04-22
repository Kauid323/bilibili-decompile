package tv.danmaku.bili.ui.garb.digital.base.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DigitalCardDetailRouterInfo.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0004\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u000f\u0010\u0013J\b\u0010,\u001a\u00020\u0003H\u0016J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0003H\u0016J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\fH\u0002J\u0006\u00104\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010'R\u001a\u0010\u000e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)¨\u00066"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;", "Landroid/os/Parcelable;", "useScene", "", "mid", "", "cardId", "pendantTitle", "", "pendantUrl", "digitalText", "showDigital", "", "isMe", "showArchiveEntrance", "<init>", "(IJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getUseScene", "()I", "setUseScene", "(I)V", "getMid", "()J", "setMid", "(J)V", "getCardId", "setCardId", "getPendantTitle", "()Ljava/lang/String;", "setPendantTitle", "(Ljava/lang/String;)V", "getPendantUrl", "setPendantUrl", "getDigitalText", "setDigitalText", "getShowDigital", "()Z", "setShowDigital", "(Z)V", "getShowArchiveEntrance", "setShowArchiveEntrance", "describeContents", "writeToParcel", "", "dest", "flags", "booleanToByte", "", "result", "hasPendant", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalCardDetailRouterInfo implements Parcelable {
    private long cardId;
    private String digitalText;
    private final boolean isMe;
    private long mid;
    private String pendantTitle;
    private String pendantUrl;
    private boolean showArchiveEntrance;
    private boolean showDigital;
    private int useScene;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    public static final Parcelable.Creator<DigitalCardDetailRouterInfo> CREATOR = new Parcelable.Creator<DigitalCardDetailRouterInfo>() { // from class: tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRouterInfo$Companion$CREATOR$1
        @Override // android.os.Parcelable.Creator
        public DigitalCardDetailRouterInfo createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new DigitalCardDetailRouterInfo(source);
        }

        @Override // android.os.Parcelable.Creator
        public DigitalCardDetailRouterInfo[] newArray(int size) {
            return new DigitalCardDetailRouterInfo[size];
        }
    };

    public DigitalCardDetailRouterInfo(int useScene, long mid, long cardId, String pendantTitle, String pendantUrl, String digitalText, boolean showDigital, boolean isMe, boolean showArchiveEntrance) {
        this.useScene = useScene;
        this.mid = mid;
        this.cardId = cardId;
        this.pendantTitle = pendantTitle;
        this.pendantUrl = pendantUrl;
        this.digitalText = digitalText;
        this.showDigital = showDigital;
        this.isMe = isMe;
        this.showArchiveEntrance = showArchiveEntrance;
    }

    public /* synthetic */ DigitalCardDetailRouterInfo(int i, long j, long j2, String str, String str2, String str3, boolean z, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? 0L : j2, str, str2, str3, z, z2, z3);
    }

    public final int getUseScene() {
        return this.useScene;
    }

    public final void setUseScene(int i) {
        this.useScene = i;
    }

    public final long getMid() {
        return this.mid;
    }

    public final void setMid(long j) {
        this.mid = j;
    }

    public final long getCardId() {
        return this.cardId;
    }

    public final void setCardId(long j) {
        this.cardId = j;
    }

    public final String getPendantTitle() {
        return this.pendantTitle;
    }

    public final void setPendantTitle(String str) {
        this.pendantTitle = str;
    }

    public final String getPendantUrl() {
        return this.pendantUrl;
    }

    public final void setPendantUrl(String str) {
        this.pendantUrl = str;
    }

    public final String getDigitalText() {
        return this.digitalText;
    }

    public final void setDigitalText(String str) {
        this.digitalText = str;
    }

    public final boolean getShowDigital() {
        return this.showDigital;
    }

    public final void setShowDigital(boolean z) {
        this.showDigital = z;
    }

    public final boolean isMe() {
        return this.isMe;
    }

    public final boolean getShowArchiveEntrance() {
        return this.showArchiveEntrance;
    }

    public final void setShowArchiveEntrance(boolean z) {
        this.showArchiveEntrance = z;
    }

    /* compiled from: DigitalCardDetailRouterInfo.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo$Companion;", "", "<init>", "()V", "isTrue", "", "source", "Landroid/os/Parcel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isTrue(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return source.readByte() != 0;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DigitalCardDetailRouterInfo(Parcel source) {
        this(source.readInt(), source.readLong(), source.readLong(), source.readString(), source.readString(), source.readString(), Companion.isTrue(source), Companion.isTrue(source), Companion.isTrue(source));
        Intrinsics.checkNotNullParameter(source, "source");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.useScene);
        dest.writeLong(this.mid);
        dest.writeLong(this.cardId);
        dest.writeString(this.pendantTitle);
        dest.writeString(this.pendantUrl);
        dest.writeString(this.digitalText);
        dest.writeByte(booleanToByte(this.showDigital));
        dest.writeByte(booleanToByte(this.isMe));
        dest.writeByte(booleanToByte(this.showArchiveEntrance));
    }

    private final byte booleanToByte(boolean result) {
        return result ? (byte) 1 : (byte) 0;
    }

    public final boolean hasPendant() {
        return (TextUtils.isEmpty(this.pendantTitle) || TextUtils.isEmpty(this.pendantUrl)) ? false : true;
    }
}