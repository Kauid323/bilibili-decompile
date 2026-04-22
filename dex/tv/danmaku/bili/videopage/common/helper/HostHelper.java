package tv.danmaku.bili.videopage.common.helper;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.foundation.IActivityHost;
import tv.danmaku.bili.videopage.foundation.IFragmentHost;
import tv.danmaku.bili.videopage.foundation.IHost;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: HostHelper.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/HostHelper;", "", "<init>", "()V", "getContext", "Landroid/content/Context;", "host", "Ltv/danmaku/bili/videopage/foundation/IHost;", "getFragmentManager", "Landroidx/fragment/app/FragmentManager;", "isHostAlive", "", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getFragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class HostHelper {
    public static final HostHelper INSTANCE = new HostHelper();

    private HostHelper() {
    }

    public final Context getContext(IHost host) {
        Intrinsics.checkNotNullParameter(host, "host");
        if (host instanceof IActivityHost) {
            return ((IActivityHost) host).getActivity();
        }
        if (host instanceof IFragmentHost) {
            return ((IFragmentHost) host).getFragment().getContext();
        }
        return null;
    }

    public final FragmentManager getFragmentManager(IHost host) {
        Intrinsics.checkNotNullParameter(host, "host");
        if (host instanceof IActivityHost) {
            return ((IActivityHost) host).getActivity().getSupportFragmentManager();
        }
        if (host instanceof IFragmentHost) {
            return ((IFragmentHost) host).getFragment().getChildFragmentManager();
        }
        return null;
    }

    public final boolean isHostAlive(IHost host) {
        Intrinsics.checkNotNullParameter(host, "host");
        if (host instanceof IFragmentHost) {
            return (((IFragmentHost) host).getFragment().isRemoving() || ((IFragmentHost) host).getFragment().isDetached() || !((IFragmentHost) host).getFragment().isAdded()) ? false : true;
        } else if (host instanceof IActivityHost) {
            return (((IActivityHost) host).getActivity().isFinishing() || ((IActivityHost) host).getActivity().isDestroyed()) ? false : true;
        } else {
            return false;
        }
    }

    public final LifecycleOwner getLifecycleOwner(IHost host) {
        Intrinsics.checkNotNullParameter(host, "host");
        if (host instanceof IActivityHost) {
            return ((IActivityHost) host).getActivity();
        }
        if (host instanceof IFragmentHost) {
            return ((IFragmentHost) host).getFragment();
        }
        return null;
    }

    public final FragmentActivity getFragmentActivity(IHost host) {
        Intrinsics.checkNotNullParameter(host, "host");
        if (host instanceof IActivityHost) {
            return ((IActivityHost) host).getActivity();
        }
        if (host instanceof IFragmentHost) {
            return ((IFragmentHost) host).getFragment().getActivity();
        }
        return null;
    }
}