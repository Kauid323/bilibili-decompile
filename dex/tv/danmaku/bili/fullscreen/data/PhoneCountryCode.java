package tv.danmaku.bili.fullscreen.data;

import ComposableSingletons$CustomBottomSheetKt$;
import android.os.Parcel;
import android.os.Parcelable;
import com.bilibili.bson.common.Bson;
import com.bilibili.bus.IData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.CountryCodeSelectActivity;
import tv.danmaku.bili.fullscreen.service.SmsLoginService;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: CountryCode.kt */
@Bson
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "Lcom/bilibili/bus/IData;", "Landroid/os/Parcelable;", ChannelRoutes.CHANNEL_NAME, "", "countryCode", "id", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getCountryCode", "getId", "()J", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PhoneCountryCode implements IData, Parcelable {
    @SerializedName(CountryCodeSelectActivity.KEY_COUNTRY_CODE)
    private final String countryCode;
    @SerializedName("id")
    private final long id;
    @SerializedName("cname")
    private final String name;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<PhoneCountryCode> CREATOR = new Creator();
    public static final int $stable = 8;
    private static final PhoneCountryCode DefaultCountryCode = new PhoneCountryCode("中国大陆", SmsLoginService.AREA_CODE_MAINLAND, 1);

    /* compiled from: CountryCode.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Creator implements Parcelable.Creator<PhoneCountryCode> {
        @Override // android.os.Parcelable.Creator
        public final PhoneCountryCode createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PhoneCountryCode(parcel.readString(), parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneCountryCode[] newArray(int i) {
            return new PhoneCountryCode[i];
        }
    }

    public static /* synthetic */ PhoneCountryCode copy$default(PhoneCountryCode phoneCountryCode, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = phoneCountryCode.name;
        }
        if ((i & 2) != 0) {
            str2 = phoneCountryCode.countryCode;
        }
        if ((i & 4) != 0) {
            j = phoneCountryCode.id;
        }
        return phoneCountryCode.copy(str, str2, j);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.countryCode;
    }

    public final long component3() {
        return this.id;
    }

    public final PhoneCountryCode copy(String str, String str2, long j) {
        Intrinsics.checkNotNullParameter(str, ChannelRoutes.CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(str2, "countryCode");
        return new PhoneCountryCode(str, str2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PhoneCountryCode) {
            PhoneCountryCode phoneCountryCode = (PhoneCountryCode) obj;
            return Intrinsics.areEqual(this.name, phoneCountryCode.name) && Intrinsics.areEqual(this.countryCode, phoneCountryCode.countryCode) && this.id == phoneCountryCode.id;
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.countryCode.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.countryCode;
        return "PhoneCountryCode(name=" + str + ", countryCode=" + str2 + ", id=" + this.id + ")";
    }

    public PhoneCountryCode(String name, String countryCode, long id) {
        Intrinsics.checkNotNullParameter(name, ChannelRoutes.CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        this.name = name;
        this.countryCode = countryCode;
        this.id = id;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public /* synthetic */ PhoneCountryCode(String str, String str2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? -1L : j);
    }

    public final String getName() {
        return this.name;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final long getId() {
        return this.id;
    }

    /* compiled from: CountryCode.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode$Companion;", "", "<init>", "()V", "DefaultCountryCode", "Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "getDefaultCountryCode", "()Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PhoneCountryCode getDefaultCountryCode() {
            return PhoneCountryCode.DefaultCountryCode;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.name);
        dest.writeString(this.countryCode);
        dest.writeLong(this.id);
    }
}