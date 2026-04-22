package tv.danmaku.bili.appwidget.hotword.router;

import android.app.Activity;
import android.content.Intent;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.teenagersmode.TeenagersMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.appwidget.IAppWidgetRouter;
import tv.danmaku.bili.appwidget.WidgetTransparentActivityKt;
import tv.danmaku.bili.appwidget.hotlist.utils.IVKFrom;
import tv.danmaku.bili.appwidget.hotlist.utils.ReportUtilKt;
import tv.danmaku.bili.appwidget.hotlist.utils.RouterUtilKt;
import tv.danmaku.bili.appwidget.hotword.HotWordAppWidgetUpdaterKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: HotWordAppWidgetRouter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/appwidget/hotword/router/HotWordAppWidgetRouter;", "Ltv/danmaku/bili/appwidget/IAppWidgetRouter;", "<init>", "()V", "handleOnCreate", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "handleNewIntent", "handleWidgetIntent", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotWordAppWidgetRouter implements IAppWidgetRouter {
    public static final int $stable = 0;

    @Override // tv.danmaku.bili.appwidget.IAppWidgetRouter
    public void handleOnCreate(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(intent, "intent");
        boolean booleanExtra = intent.getBooleanExtra(HotWordAppWidgetUpdaterKt.FROM_WIDGET, false);
        String stringExtra = intent.getStringExtra(WidgetTransparentActivityKt.APP_WIDGET_ROUTER);
        BLog.i("HotWordAppWidgetRouter", "handleBiliWidgetIntent" + booleanExtra + " " + stringExtra + " , pkgName == " + activity.getPackageName());
        handleWidgetIntent(activity, intent);
    }

    @Override // tv.danmaku.bili.appwidget.IAppWidgetRouter
    public void handleNewIntent(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(intent, "intent");
        BLog.i("HotWordAppWidgetRouter", "onNewIntent");
        if (!DelayTaskController.shouldBlock()) {
            handleWidgetIntent(activity, intent);
        }
    }

    private final void handleWidgetIntent(Activity activity, Intent intent) {
        boolean z = false;
        if (intent.getBooleanExtra(HotWordAppWidgetUpdaterKt.FROM_WIDGET, false)) {
            String moduleTitle = intent.getStringExtra(HotWordAppWidgetUpdaterKt.WIDGET_MODULE_TITLE);
            ReportUtilKt.reportWidgetClick$default("widget", moduleTitle == null ? "" : moduleTitle, null, null, null, 28, null);
            if (DelayTaskController.shouldBlock()) {
                if (BuildConfig.DEBUG) {
                    ToastHelper.showToast(activity, "DEBUG: WIDGET未同意隐私协议", 0);
                }
                RouterUtilKt.openMain(activity, IVKFrom.WIDGET);
                return;
            }
            Pair[] pairArr = new Pair[1];
            pairArr[0] = new Pair("module_title", moduleTitle != null ? moduleTitle : "");
            Neurons.report$default(false, 4, "app.widgets.module.sys", MapsKt.hashMapOf(pairArr), (String) null, 0, 48, (Object) null);
            String router = intent.getStringExtra(WidgetTransparentActivityKt.APP_WIDGET_ROUTER);
            String str = router;
            if (str == null || StringsKt.isBlank(str)) {
                z = true;
            }
            if (z) {
                RouterUtilKt.openMain(activity, IVKFrom.WIDGET);
                return;
            }
            RouteRequest build = new RouteRequest.Builder(RouterUtilKt.appendIvkFromIfNotExist(router, IVKFrom.WIDGET)).build();
            if (ListExtentionsKt.getInt(build.getExtras(), "blockInTeen") == 1 && RestrictedMode.isEnable(RestrictedType.TEENAGERS)) {
                TeenagersMode.getInstance().intentToInteceptPage(activity);
            } else {
                BLRouter.routeTo(build, activity);
            }
        }
    }
}