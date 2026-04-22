package tv.danmaku.bili.report.startup;

import android.view.View;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bilibili.lib.blconfig.ConfigManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.report.startup.v3.BootTracerV2;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: FragmentTracer.kt */
@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0004\u001a\u001d\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0082\b\u001a\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"mTrackingFragments", "", "Landroidx/fragment/app/Fragment;", "mFragmentOnAttachListener", "tv/danmaku/bili/report/startup/FragmentTracerKt$mFragmentOnAttachListener$1", "Ltv/danmaku/bili/report/startup/FragmentTracerKt$mFragmentOnAttachListener$1;", "onViewCreated", "", "action", "Lkotlin/Function0;", "trackFragmentCreateTime", AudioIntentHelper.FROM_ACTIVITY, "Ltv/danmaku/bili/MainActivityV2;", "isColdStart", "", "TAG", "", "trackFragmentTimeEnable", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FragmentTracerKt {
    private static final String TAG = "FragmentTracer";
    private static final boolean trackFragmentTimeEnable;
    private static final List<Fragment> mTrackingFragments = new ArrayList();
    private static final FragmentTracerKt$mFragmentOnAttachListener$1 mFragmentOnAttachListener = new FragmentOnAttachListener() { // from class: tv.danmaku.bili.report.startup.FragmentTracerKt$mFragmentOnAttachListener$1
        public void onAttachFragment(FragmentManager fragmentManager, final Fragment fragment) {
            List list;
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            list = FragmentTracerKt.mTrackingFragments;
            list.add(fragment);
            fragment.getChildFragmentManager().addFragmentOnAttachListener(this);
            BootTracerV2.recordTime$default(BootTracerV2.INSTANCE, fragment.getClass().getSimpleName() + BootTracerV2.FRAGMENT_ATTACH_SUFFIX, 0L, 2, null);
            if (fragment.getView() == null) {
                fragment.getViewLifecycleOwnerLiveData().observe((LifecycleOwner) fragment, new Observer<LifecycleOwner>() { // from class: tv.danmaku.bili.report.startup.FragmentTracerKt$mFragmentOnAttachListener$1$onAttachFragment$$inlined$onViewCreated$1
                    public void onChanged(LifecycleOwner value) {
                        if (value != null) {
                            BootTracerV2.recordTime$default(BootTracerV2.INSTANCE, fragment.getClass().getSimpleName() + BootTracerV2.FRAGMENT_VIEW_CREATED_SUFFIX, 0L, 2, null);
                        }
                        fragment.getViewLifecycleOwnerLiveData().removeObserver(this);
                    }
                });
            } else {
                BLog.w("FragmentTracer", "fragment's view already initialized");
            }
        }
    };
    private static boolean isColdStart = true;

    /* JADX WARN: Type inference failed for: r0v2, types: [tv.danmaku.bili.report.startup.FragmentTracerKt$mFragmentOnAttachListener$1] */
    static {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("startup_track_fragment_time", true);
        trackFragmentTimeEnable = bool != null ? bool.booleanValue() : true;
    }

    private static final void onViewCreated(final Fragment $this$onViewCreated, final Function0<Unit> function0) {
        if ($this$onViewCreated.getView() != null) {
            BLog.w(TAG, "fragment's view already initialized");
        } else {
            $this$onViewCreated.getViewLifecycleOwnerLiveData().observe((LifecycleOwner) $this$onViewCreated, new Observer<LifecycleOwner>() { // from class: tv.danmaku.bili.report.startup.FragmentTracerKt$onViewCreated$1
                public void onChanged(LifecycleOwner value) {
                    if (value != null) {
                        function0.invoke();
                    }
                    $this$onViewCreated.getViewLifecycleOwnerLiveData().removeObserver(this);
                }
            });
        }
    }

    public static final void trackFragmentCreateTime(final MainActivityV2 activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (!trackFragmentTimeEnable) {
            BLog.w(TAG, "track fragment time disable");
        } else if (!isColdStart) {
        } else {
            isColdStart = false;
            if (activity.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                BLog.w(TAG, "track fragment is late, activity is resumed");
                return;
            }
            activity.getSupportFragmentManager().addFragmentOnAttachListener(mFragmentOnAttachListener);
            activity.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: tv.danmaku.bili.report.startup.FragmentTracerKt$trackFragmentCreateTime$1
                public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (event == Lifecycle.Event.ON_RESUME) {
                        final View $this$doOnPreDraw$iv = MainActivityV2.this.getWindow().getDecorView();
                        Intrinsics.checkNotNullExpressionValue($this$doOnPreDraw$iv, "getDecorView(...)");
                        final MainActivityV2 mainActivityV2 = MainActivityV2.this;
                        OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.report.startup.FragmentTracerKt$trackFragmentCreateTime$1$onStateChanged$$inlined$doOnPreDraw$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                FragmentTracerKt$mFragmentOnAttachListener$1 fragmentTracerKt$mFragmentOnAttachListener$1;
                                Iterable iterable;
                                List list;
                                FragmentTracerKt$mFragmentOnAttachListener$1 fragmentTracerKt$mFragmentOnAttachListener$12;
                                View view = $this$doOnPreDraw$iv;
                                FragmentManager supportFragmentManager = mainActivityV2.getSupportFragmentManager();
                                fragmentTracerKt$mFragmentOnAttachListener$1 = FragmentTracerKt.mFragmentOnAttachListener;
                                supportFragmentManager.removeFragmentOnAttachListener(fragmentTracerKt$mFragmentOnAttachListener$1);
                                iterable = FragmentTracerKt.mTrackingFragments;
                                Iterable $this$forEach$iv = iterable;
                                for (Object element$iv : $this$forEach$iv) {
                                    Fragment it = (Fragment) element$iv;
                                    if (it.getHost() != null) {
                                        FragmentManager childFragmentManager = it.getChildFragmentManager();
                                        fragmentTracerKt$mFragmentOnAttachListener$12 = FragmentTracerKt.mFragmentOnAttachListener;
                                        childFragmentManager.removeFragmentOnAttachListener(fragmentTracerKt$mFragmentOnAttachListener$12);
                                    }
                                }
                                list = FragmentTracerKt.mTrackingFragments;
                                list.clear();
                            }
                        });
                    }
                }
            });
        }
    }
}