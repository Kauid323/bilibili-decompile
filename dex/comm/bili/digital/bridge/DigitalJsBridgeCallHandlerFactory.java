package comm.bili.digital.bridge;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DigitalJsBridgeCallHandler.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcomm/bili/digital/bridge/DigitalJsBridgeCallHandlerFactory;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerFactoryV2;", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroid/app/Activity;Landroidx/fragment/app/Fragment;)V", "getActivity", "()Landroid/app/Activity;", "getFragment", "()Landroidx/fragment/app/Fragment;", "create", "Lcomm/bili/digital/bridge/DigitalJsBridgeCallHandler;", "digital-bridge_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DigitalJsBridgeCallHandlerFactory implements JsBridgeCallHandlerFactoryV2 {
    private final Activity activity;
    private final Fragment fragment;

    public DigitalJsBridgeCallHandlerFactory(Activity activity, Fragment fragment) {
        this.activity = activity;
        this.fragment = fragment;
    }

    public /* synthetic */ DigitalJsBridgeCallHandlerFactory(Activity activity, Fragment fragment, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i2 & 2) != 0 ? null : fragment);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public DigitalJsBridgeCallHandler create() {
        return new DigitalJsBridgeCallHandler(this.activity, this.fragment);
    }
}