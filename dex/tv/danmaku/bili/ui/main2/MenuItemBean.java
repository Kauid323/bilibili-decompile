package tv.danmaku.bili.ui.main2;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: CommonMenuBottomSheet.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Ltv/danmaku/bili/ui/main2/MenuItemBean;", "Landroid/os/Parcelable;", "id", "", "iconResId", "menuText", "", "<init>", "(IILjava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getId", "()I", "setId", "(I)V", "getIconResId", "setIconResId", "getMenuText", "()Ljava/lang/String;", "setMenuText", "(Ljava/lang/String;)V", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MenuItemBean implements Parcelable {
    private int iconResId;
    private int id;
    private String menuText;
    public static final CREATOR CREATOR = new CREATOR(null);
    public static final int $stable = 8;

    public static /* synthetic */ MenuItemBean copy$default(MenuItemBean menuItemBean, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = menuItemBean.id;
        }
        if ((i3 & 2) != 0) {
            i2 = menuItemBean.iconResId;
        }
        if ((i3 & 4) != 0) {
            str = menuItemBean.menuText;
        }
        return menuItemBean.copy(i, i2, str);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.iconResId;
    }

    public final String component3() {
        return this.menuText;
    }

    public final MenuItemBean copy(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "menuText");
        return new MenuItemBean(i, i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MenuItemBean) {
            MenuItemBean menuItemBean = (MenuItemBean) obj;
            return this.id == menuItemBean.id && this.iconResId == menuItemBean.iconResId && Intrinsics.areEqual(this.menuText, menuItemBean.menuText);
        }
        return false;
    }

    public int hashCode() {
        return (((this.id * 31) + this.iconResId) * 31) + this.menuText.hashCode();
    }

    public String toString() {
        int i = this.id;
        int i2 = this.iconResId;
        return "MenuItemBean(id=" + i + ", iconResId=" + i2 + ", menuText=" + this.menuText + ")";
    }

    public MenuItemBean(int id, int iconResId, String menuText) {
        Intrinsics.checkNotNullParameter(menuText, "menuText");
        this.id = id;
        this.iconResId = iconResId;
        this.menuText = menuText;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final int getId() {
        return this.id;
    }

    public final String getMenuText() {
        return this.menuText;
    }

    public final void setIconResId(int i) {
        this.iconResId = i;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setMenuText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.menuText = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MenuItemBean(Parcel parcel) {
        this(r0, r1, r2 == null ? "" : r2);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        String readString = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeInt(this.iconResId);
        parcel.writeString(this.menuText);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* compiled from: CommonMenuBottomSheet.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/main2/MenuItemBean$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/ui/main2/MenuItemBean;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/ui/main2/MenuItemBean;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CREATOR implements Parcelable.Creator<MenuItemBean> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public MenuItemBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MenuItemBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MenuItemBean[] newArray(int size) {
            return new MenuItemBean[size];
        }
    }
}