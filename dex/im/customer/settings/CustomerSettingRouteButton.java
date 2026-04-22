package im.customer.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomerSettingState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lim/customer/settings/CustomerSettingRouteButton;", "Lim/customer/settings/ICustomerSettingButton;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl$annotations", "()V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomerSettingRouteButton implements ICustomerSettingButton {
    private final String url;

    public static /* synthetic */ CustomerSettingRouteButton copy$default(CustomerSettingRouteButton customerSettingRouteButton, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = customerSettingRouteButton.url;
        }
        return customerSettingRouteButton.copy(str);
    }

    public static /* synthetic */ void getUrl$annotations() {
    }

    public final String component1() {
        return this.url;
    }

    public final CustomerSettingRouteButton copy(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return new CustomerSettingRouteButton(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CustomerSettingRouteButton) && Intrinsics.areEqual(this.url, ((CustomerSettingRouteButton) obj).url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "CustomerSettingRouteButton(url=" + this.url + ")";
    }

    public CustomerSettingRouteButton(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }

    public final String getUrl() {
        return this.url;
    }
}