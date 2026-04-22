package tv.danmaku.bili.ui.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AccountUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/ui/util/AccountUtils;", "", "<init>", "()V", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AccountUtils {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* compiled from: AccountUtils.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/util/AccountUtils$Companion;", "", "<init>", "()V", "getRouterFrom", "", "activity", "Landroid/app/Activity;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String getRouterFrom(Activity activity) {
            Bundle bundleExtra;
            if (activity == null) {
                return null;
            }
            Intent intent = activity.getIntent();
            String routeFromOrigin = intent != null ? intent.getStringExtra("router_from") : null;
            boolean z = false;
            if (routeFromOrigin != null && (!StringsKt.isBlank(routeFromOrigin))) {
                z = true;
            }
            if (z) {
                return routeFromOrigin;
            }
            if (intent == null || (bundleExtra = intent.getBundleExtra("blrouter.props")) == null) {
                return null;
            }
            return bundleExtra.getString("blrouter.from");
        }
    }

    @JvmStatic
    public static final String getRouterFrom(Activity activity) {
        return Companion.getRouterFrom(activity);
    }
}