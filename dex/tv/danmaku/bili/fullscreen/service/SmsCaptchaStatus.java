package tv.danmaku.bili.fullscreen.service;

import BottomSheetItemData$;
import com.bilibili.lib.accounts.AccountException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;

/* compiled from: SmsLoginService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JG\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012¨\u0006$"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "", "phone", "", "countryCode", "Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "isNewUser", "", "captchaKey", "captchaUrl", "loginError", "Lcom/bilibili/lib/accounts/AccountException;", "<init>", "(Ljava/lang/String;Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;ZLjava/lang/String;Ljava/lang/String;Lcom/bilibili/lib/accounts/AccountException;)V", "getPhone", "()Ljava/lang/String;", "getCountryCode", "()Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "()Z", "getCaptchaKey", "getCaptchaUrl", "getLoginError", "()Lcom/bilibili/lib/accounts/AccountException;", "isCaptchaFailed", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsCaptchaStatus {
    public static final int $stable = 8;
    private final String captchaKey;
    private final String captchaUrl;
    private final PhoneCountryCode countryCode;
    private final boolean isNewUser;
    private final AccountException loginError;
    private final String phone;

    public static /* synthetic */ SmsCaptchaStatus copy$default(SmsCaptchaStatus smsCaptchaStatus, String str, PhoneCountryCode phoneCountryCode, boolean z, String str2, String str3, AccountException accountException, int i, Object obj) {
        if ((i & 1) != 0) {
            str = smsCaptchaStatus.phone;
        }
        if ((i & 2) != 0) {
            phoneCountryCode = smsCaptchaStatus.countryCode;
        }
        PhoneCountryCode phoneCountryCode2 = phoneCountryCode;
        if ((i & 4) != 0) {
            z = smsCaptchaStatus.isNewUser;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str2 = smsCaptchaStatus.captchaKey;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            str3 = smsCaptchaStatus.captchaUrl;
        }
        String str5 = str3;
        if ((i & 32) != 0) {
            accountException = smsCaptchaStatus.loginError;
        }
        return smsCaptchaStatus.copy(str, phoneCountryCode2, z2, str4, str5, accountException);
    }

    public final String component1() {
        return this.phone;
    }

    public final PhoneCountryCode component2() {
        return this.countryCode;
    }

    public final boolean component3() {
        return this.isNewUser;
    }

    public final String component4() {
        return this.captchaKey;
    }

    public final String component5() {
        return this.captchaUrl;
    }

    public final AccountException component6() {
        return this.loginError;
    }

    public final SmsCaptchaStatus copy(String str, PhoneCountryCode phoneCountryCode, boolean z, String str2, String str3, AccountException accountException) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(phoneCountryCode, "countryCode");
        Intrinsics.checkNotNullParameter(str2, "captchaKey");
        Intrinsics.checkNotNullParameter(str3, "captchaUrl");
        return new SmsCaptchaStatus(str, phoneCountryCode, z, str2, str3, accountException);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SmsCaptchaStatus) {
            SmsCaptchaStatus smsCaptchaStatus = (SmsCaptchaStatus) obj;
            return Intrinsics.areEqual(this.phone, smsCaptchaStatus.phone) && Intrinsics.areEqual(this.countryCode, smsCaptchaStatus.countryCode) && this.isNewUser == smsCaptchaStatus.isNewUser && Intrinsics.areEqual(this.captchaKey, smsCaptchaStatus.captchaKey) && Intrinsics.areEqual(this.captchaUrl, smsCaptchaStatus.captchaUrl) && Intrinsics.areEqual(this.loginError, smsCaptchaStatus.loginError);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.phone.hashCode() * 31) + this.countryCode.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isNewUser)) * 31) + this.captchaKey.hashCode()) * 31) + this.captchaUrl.hashCode()) * 31) + (this.loginError == null ? 0 : this.loginError.hashCode());
    }

    public String toString() {
        String str = this.phone;
        PhoneCountryCode phoneCountryCode = this.countryCode;
        boolean z = this.isNewUser;
        String str2 = this.captchaKey;
        String str3 = this.captchaUrl;
        return "SmsCaptchaStatus(phone=" + str + ", countryCode=" + phoneCountryCode + ", isNewUser=" + z + ", captchaKey=" + str2 + ", captchaUrl=" + str3 + ", loginError=" + this.loginError + ")";
    }

    public SmsCaptchaStatus(String phone, PhoneCountryCode countryCode, boolean isNewUser, String captchaKey, String captchaUrl, AccountException loginError) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(captchaKey, "captchaKey");
        Intrinsics.checkNotNullParameter(captchaUrl, "captchaUrl");
        this.phone = phone;
        this.countryCode = countryCode;
        this.isNewUser = isNewUser;
        this.captchaKey = captchaKey;
        this.captchaUrl = captchaUrl;
        this.loginError = loginError;
    }

    public /* synthetic */ SmsCaptchaStatus(String str, PhoneCountryCode phoneCountryCode, boolean z, String str2, String str3, AccountException accountException, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, phoneCountryCode, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? null : accountException);
    }

    public final String getPhone() {
        return this.phone;
    }

    public final PhoneCountryCode getCountryCode() {
        return this.countryCode;
    }

    public final boolean isNewUser() {
        return this.isNewUser;
    }

    public final String getCaptchaKey() {
        return this.captchaKey;
    }

    public final String getCaptchaUrl() {
        return this.captchaUrl;
    }

    public final AccountException getLoginError() {
        return this.loginError;
    }

    public final boolean isCaptchaFailed() {
        AccountException accountException = this.loginError;
        return accountException != null && accountException.code() == -105;
    }
}