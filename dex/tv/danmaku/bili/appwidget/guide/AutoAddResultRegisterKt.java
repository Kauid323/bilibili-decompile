package tv.danmaku.bili.appwidget.guide;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import bili.resource.homepage.R;
import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.base.BiliContext;
import com.bilibili.moduleservice.appwidget.GuideScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.guide.utils.AutoAddWidgetSceneExtKt;
import tv.danmaku.bili.appwidget.guide.utils.ReportHelperKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: AutoAddResultRegister.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"registerAutoAddWidgetResult", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "scene", "Lcom/bilibili/moduleservice/appwidget/GuideScene;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AutoAddResultRegisterKt {
    public static final void registerAutoAddWidgetResult(final FragmentActivity activity, final GuideScene scene) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(scene, "scene");
        activity.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: tv.danmaku.bili.appwidget.guide.AutoAddResultRegisterKt$registerAutoAddWidgetResult$lifecycleObserver$1
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_RESUME) {
                    if (AutoAddWidgetSceneExtKt.widgetAdded(scene, activity)) {
                        PromoToast.showMidToast(BiliContext.application(), R.string.homepage_global_string_381);
                        ReportHelperKt.reportAutoAddSuccess(AutoAddWidgetSceneExtKt.spmid(scene), AutoAddWidgetSceneExtKt.type(scene), AutoAddWidgetSceneExtKt.contentId(scene));
                        activity.getLifecycle().removeObserver((LifecycleObserver) this);
                    }
                    activity.getLifecycle().removeObserver((LifecycleObserver) this);
                } else if (event == Lifecycle.Event.ON_DESTROY) {
                    activity.getLifecycle().removeObserver((LifecycleObserver) this);
                }
            }
        });
    }
}