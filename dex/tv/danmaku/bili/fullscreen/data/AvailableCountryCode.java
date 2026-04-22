package tv.danmaku.bili.fullscreen.data;

import android.os.Parcel;
import android.os.Parcelable;
import bili.resource.account.R;
import com.bilibili.bson.common.Bson;
import com.bilibili.lib.foundation.FoundationAlias;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.SmsLoginService;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

/* compiled from: CountryCode.kt */
@Bson
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/fullscreen/data/AvailableCountryCode;", "Landroid/os/Parcelable;", "defaultCountry", "Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "list", "", "<init>", "(Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;Ljava/util/List;)V", "getDefaultCountry", "()Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "getList", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AvailableCountryCode implements Parcelable {
    public static final int $stable = 0;
    @SerializedName(MineReporter.MINE_ICON_TYPE_DEFAULT)
    private final PhoneCountryCode defaultCountry;
    @SerializedName("list")
    private final List<PhoneCountryCode> list;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<AvailableCountryCode> CREATOR = new Creator();

    /* compiled from: CountryCode.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Creator implements Parcelable.Creator<AvailableCountryCode> {
        @Override // android.os.Parcelable.Creator
        public final AvailableCountryCode createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            PhoneCountryCode createFromParcel = PhoneCountryCode.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(PhoneCountryCode.CREATOR.createFromParcel(parcel));
            }
            return new AvailableCountryCode(createFromParcel, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final AvailableCountryCode[] newArray(int i) {
            return new AvailableCountryCode[i];
        }
    }

    public AvailableCountryCode() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AvailableCountryCode copy$default(AvailableCountryCode availableCountryCode, PhoneCountryCode phoneCountryCode, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            phoneCountryCode = availableCountryCode.defaultCountry;
        }
        if ((i & 2) != 0) {
            list = availableCountryCode.list;
        }
        return availableCountryCode.copy(phoneCountryCode, list);
    }

    public final PhoneCountryCode component1() {
        return this.defaultCountry;
    }

    public final List<PhoneCountryCode> component2() {
        return this.list;
    }

    public final AvailableCountryCode copy(PhoneCountryCode phoneCountryCode, List<PhoneCountryCode> list) {
        Intrinsics.checkNotNullParameter(phoneCountryCode, "defaultCountry");
        Intrinsics.checkNotNullParameter(list, "list");
        return new AvailableCountryCode(phoneCountryCode, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AvailableCountryCode) {
            AvailableCountryCode availableCountryCode = (AvailableCountryCode) obj;
            return Intrinsics.areEqual(this.defaultCountry, availableCountryCode.defaultCountry) && Intrinsics.areEqual(this.list, availableCountryCode.list);
        }
        return false;
    }

    public int hashCode() {
        return (this.defaultCountry.hashCode() * 31) + this.list.hashCode();
    }

    public String toString() {
        PhoneCountryCode phoneCountryCode = this.defaultCountry;
        return "AvailableCountryCode(defaultCountry=" + phoneCountryCode + ", list=" + this.list + ")";
    }

    public AvailableCountryCode(PhoneCountryCode defaultCountry, List<PhoneCountryCode> list) {
        Intrinsics.checkNotNullParameter(defaultCountry, "defaultCountry");
        Intrinsics.checkNotNullParameter(list, "list");
        this.defaultCountry = defaultCountry;
        this.list = list;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public /* synthetic */ AvailableCountryCode(PhoneCountryCode phoneCountryCode, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new PhoneCountryCode("", "", 0L, 4, null) : phoneCountryCode, (i & 2) != 0 ? new ArrayList() : arrayList);
    }

    public final PhoneCountryCode getDefaultCountry() {
        return this.defaultCountry;
    }

    public final List<PhoneCountryCode> getList() {
        return this.list;
    }

    /* compiled from: CountryCode.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/fullscreen/data/AvailableCountryCode$Companion;", "", "<init>", "()V", "getDefaultCode", "Ltv/danmaku/bili/fullscreen/data/AvailableCountryCode;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AvailableCountryCode getDefaultCode() {
            String string = FoundationAlias.getFapp().getString(R.string.account_global_string_145);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            PhoneCountryCode defaultCountry = new PhoneCountryCode(string, SmsLoginService.AREA_CODE_MAINLAND, 1L);
            return new AvailableCountryCode(defaultCountry, CollectionsKt.listOf(defaultCountry));
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        this.defaultCountry.writeToParcel(dest, flags);
        List<PhoneCountryCode> list = this.list;
        dest.writeInt(list.size());
        for (PhoneCountryCode phoneCountryCode : list) {
            phoneCountryCode.writeToParcel(dest, flags);
        }
    }
}