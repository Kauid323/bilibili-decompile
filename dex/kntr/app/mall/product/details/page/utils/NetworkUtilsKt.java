package kntr.app.mall.product.details.page.utils;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkUtils.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0001¨\u0006\u0002"}, d2 = {"getNetworkType", "", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NetworkUtilsKt {
    public static final String getNetworkType() {
        if (!(Gripper_component_holder_androidKt.getRootGripperComponent() instanceof Application)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Object rootGripperComponent = Gripper_component_holder_androidKt.getRootGripperComponent();
        Intrinsics.checkNotNull(rootGripperComponent, "null cannot be cast to non-null type android.app.Application");
        Context appContext = ((Application) rootGripperComponent).getApplicationContext();
        Object systemService = appContext.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network network = connectivityManager.getActiveNetwork();
        if (network == null) {
            return "No Network";
        }
        NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(network);
        return capabilities == null ? "Unknown" : capabilities.hasTransport(1) ? "WiFi" : capabilities.hasTransport(0) ? "Cellular" : capabilities.hasTransport(3) ? "Ethernet" : "Unknown";
    }
}