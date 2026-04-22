package tv.danmaku.bili.stepbystep.sms;

import BottomSheetItemData$;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.AvailableCountryCode;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;

/* compiled from: StepByStepSmsLoginPageState.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;", "Landroid/os/Parcelable;", "phone", "", "availableCountryCode", "Ltv/danmaku/bili/fullscreen/data/AvailableCountryCode;", "selectedCountry", "Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "agreementChecked", "", "<init>", "(Ljava/lang/String;Ltv/danmaku/bili/fullscreen/data/AvailableCountryCode;Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;Z)V", "getPhone", "()Ljava/lang/String;", "getAvailableCountryCode", "()Ltv/danmaku/bili/fullscreen/data/AvailableCountryCode;", "getSelectedCountry", "()Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "getAgreementChecked", "()Z", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StepByStepSmsLoginPhoneInputState implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<StepByStepSmsLoginPhoneInputState> CREATOR = new Creator();
    private final boolean agreementChecked;
    private final AvailableCountryCode availableCountryCode;
    private final String phone;
    private final PhoneCountryCode selectedCountry;

    /* compiled from: StepByStepSmsLoginPageState.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Creator implements Parcelable.Creator<StepByStepSmsLoginPhoneInputState> {
        @Override // android.os.Parcelable.Creator
        public final StepByStepSmsLoginPhoneInputState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StepByStepSmsLoginPhoneInputState(parcel.readString(), AvailableCountryCode.CREATOR.createFromParcel(parcel), PhoneCountryCode.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final StepByStepSmsLoginPhoneInputState[] newArray(int i) {
            return new StepByStepSmsLoginPhoneInputState[i];
        }
    }

    public StepByStepSmsLoginPhoneInputState() {
        this(null, null, null, false, 15, null);
    }

    public static /* synthetic */ StepByStepSmsLoginPhoneInputState copy$default(StepByStepSmsLoginPhoneInputState stepByStepSmsLoginPhoneInputState, String str, AvailableCountryCode availableCountryCode, PhoneCountryCode phoneCountryCode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stepByStepSmsLoginPhoneInputState.phone;
        }
        if ((i & 2) != 0) {
            availableCountryCode = stepByStepSmsLoginPhoneInputState.availableCountryCode;
        }
        if ((i & 4) != 0) {
            phoneCountryCode = stepByStepSmsLoginPhoneInputState.selectedCountry;
        }
        if ((i & 8) != 0) {
            z = stepByStepSmsLoginPhoneInputState.agreementChecked;
        }
        return stepByStepSmsLoginPhoneInputState.copy(str, availableCountryCode, phoneCountryCode, z);
    }

    public final String component1() {
        return this.phone;
    }

    public final AvailableCountryCode component2() {
        return this.availableCountryCode;
    }

    public final PhoneCountryCode component3() {
        return this.selectedCountry;
    }

    public final boolean component4() {
        return this.agreementChecked;
    }

    public final StepByStepSmsLoginPhoneInputState copy(String str, AvailableCountryCode availableCountryCode, PhoneCountryCode phoneCountryCode, boolean z) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(availableCountryCode, "availableCountryCode");
        Intrinsics.checkNotNullParameter(phoneCountryCode, "selectedCountry");
        return new StepByStepSmsLoginPhoneInputState(str, availableCountryCode, phoneCountryCode, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StepByStepSmsLoginPhoneInputState) {
            StepByStepSmsLoginPhoneInputState stepByStepSmsLoginPhoneInputState = (StepByStepSmsLoginPhoneInputState) obj;
            return Intrinsics.areEqual(this.phone, stepByStepSmsLoginPhoneInputState.phone) && Intrinsics.areEqual(this.availableCountryCode, stepByStepSmsLoginPhoneInputState.availableCountryCode) && Intrinsics.areEqual(this.selectedCountry, stepByStepSmsLoginPhoneInputState.selectedCountry) && this.agreementChecked == stepByStepSmsLoginPhoneInputState.agreementChecked;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.phone.hashCode() * 31) + this.availableCountryCode.hashCode()) * 31) + this.selectedCountry.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.agreementChecked);
    }

    public String toString() {
        String str = this.phone;
        AvailableCountryCode availableCountryCode = this.availableCountryCode;
        PhoneCountryCode phoneCountryCode = this.selectedCountry;
        return "StepByStepSmsLoginPhoneInputState(phone=" + str + ", availableCountryCode=" + availableCountryCode + ", selectedCountry=" + phoneCountryCode + ", agreementChecked=" + this.agreementChecked + ")";
    }

    public StepByStepSmsLoginPhoneInputState(String phone, AvailableCountryCode availableCountryCode, PhoneCountryCode selectedCountry, boolean agreementChecked) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(availableCountryCode, "availableCountryCode");
        Intrinsics.checkNotNullParameter(selectedCountry, "selectedCountry");
        this.phone = phone;
        this.availableCountryCode = availableCountryCode;
        this.selectedCountry = selectedCountry;
        this.agreementChecked = agreementChecked;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ StepByStepSmsLoginPhoneInputState(String str, AvailableCountryCode availableCountryCode, PhoneCountryCode phoneCountryCode, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, availableCountryCode, (i & 4) != 0 ? availableCountryCode.getDefaultCountry() : phoneCountryCode, (i & 8) != 0 ? false : z);
        str = (i & 1) != 0 ? "" : str;
        availableCountryCode = (i & 2) != 0 ? new AvailableCountryCode(null, null, 3, null) : availableCountryCode;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final AvailableCountryCode getAvailableCountryCode() {
        return this.availableCountryCode;
    }

    public final PhoneCountryCode getSelectedCountry() {
        return this.selectedCountry;
    }

    public final boolean getAgreementChecked() {
        return this.agreementChecked;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.phone);
        this.availableCountryCode.writeToParcel(dest, flags);
        this.selectedCountry.writeToParcel(dest, flags);
        dest.writeInt(this.agreementChecked ? 1 : 0);
    }
}