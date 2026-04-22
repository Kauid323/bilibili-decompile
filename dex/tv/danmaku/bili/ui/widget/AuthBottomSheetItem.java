package tv.danmaku.bili.ui.widget;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AuthBottomSheetItem.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/ui/widget/AuthBottomSheetItem;", "Landroid/os/Parcelable;", "text", "", "textColor", "", "<init>", "(Ljava/lang/String;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getText", "()Ljava/lang/String;", "getTextColor", "()I", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AuthBottomSheetItem implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    private final String text;
    private final int textColor;

    public AuthBottomSheetItem() {
        this(null, 0, 3, null);
    }

    public static /* synthetic */ AuthBottomSheetItem copy$default(AuthBottomSheetItem authBottomSheetItem, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = authBottomSheetItem.text;
        }
        if ((i2 & 2) != 0) {
            i = authBottomSheetItem.textColor;
        }
        return authBottomSheetItem.copy(str, i);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.textColor;
    }

    public final AuthBottomSheetItem copy(String str, int i) {
        return new AuthBottomSheetItem(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AuthBottomSheetItem) {
            AuthBottomSheetItem authBottomSheetItem = (AuthBottomSheetItem) obj;
            return Intrinsics.areEqual(this.text, authBottomSheetItem.text) && this.textColor == authBottomSheetItem.textColor;
        }
        return false;
    }

    public int hashCode() {
        return ((this.text == null ? 0 : this.text.hashCode()) * 31) + this.textColor;
    }

    public String toString() {
        String str = this.text;
        return "AuthBottomSheetItem(text=" + str + ", textColor=" + this.textColor + ")";
    }

    public AuthBottomSheetItem(String text, int textColor) {
        this.text = text;
        this.textColor = textColor;
    }

    public /* synthetic */ AuthBottomSheetItem(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : i);
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthBottomSheetItem(Parcel parcel) {
        this(parcel.readString(), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.text);
        parcel.writeInt(this.textColor);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* compiled from: AuthBottomSheetItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/widget/AuthBottomSheetItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/ui/widget/AuthBottomSheetItem;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/ui/widget/AuthBottomSheetItem;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CREATOR implements Parcelable.Creator<AuthBottomSheetItem> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public AuthBottomSheetItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AuthBottomSheetItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AuthBottomSheetItem[] newArray(int size) {
            return new AuthBottomSheetItem[size];
        }
    }
}