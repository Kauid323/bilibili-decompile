package tv.danmaku.bili.appwidget.guide.function;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.moduleservice.appwidget.GuideScene;
import com.bilibili.moduleservice.appwidget.IFunctionWidgetGuide;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: RouteTraceManager.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/function/RouteTraceManager;", "", "<init>", "()V", "routeNodes", "Ljava/util/LinkedList;", "Ltv/danmaku/bili/appwidget/guide/function/RouteNode;", "create", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "scene", "Lcom/bilibili/moduleservice/appwidget/GuideScene;", "push", "pop", "peek", "destroy", "size", "", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RouteTraceManager {
    private static final String TAG = "RouteTraceManager";
    private final LinkedList<RouteNode> routeNodes = new LinkedList<>();
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public final void create(Activity activity, GuideScene scene) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (!(activity instanceof FragmentActivity) || !this.routeNodes.isEmpty()) {
            return;
        }
        Fragment fragment = ((FragmentActivity) activity).getSupportFragmentManager().findFragmentById(16908290);
        if (fragment instanceof IFunctionWidgetGuide) {
            LinkedList<RouteNode> linkedList = this.routeNodes;
            String className = ((FragmentActivity) activity).getComponentName().getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
            linkedList.push(new RouteNode(className, true, scene));
        } else if (activity instanceof IFunctionWidgetGuide) {
            LinkedList<RouteNode> linkedList2 = this.routeNodes;
            String className2 = activity.getComponentName().getClassName();
            Intrinsics.checkNotNullExpressionValue(className2, "getClassName(...)");
            linkedList2.push(new RouteNode(className2, true, scene));
        }
    }

    public final void push(Activity activity) {
        RouteNode node;
        String tag;
        String tag2;
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (!(activity instanceof FragmentActivity)) {
            return;
        }
        Fragment fragment = ((FragmentActivity) activity).getSupportFragmentManager().findFragmentById(16908290);
        String str = "";
        if (fragment instanceof IFunctionWidgetGuide) {
            String className = ((FragmentActivity) activity).getComponentName().getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
            node = new RouteNode(className, true, null);
        } else if (activity instanceof IFunctionWidgetGuide) {
            String className2 = activity.getComponentName().getClassName();
            Intrinsics.checkNotNullExpressionValue(className2, "getClassName(...)");
            node = new RouteNode(className2, true, null);
        } else {
            node = new RouteNode((fragment == null || (tag = fragment.getTag()) == null) ? "" : tag, false, null, 4, null);
        }
        if (!node.isFunction() && this.routeNodes.isEmpty()) {
            BLog.i(TAG, "push invalid node");
            return;
        }
        String className3 = ((FragmentActivity) activity).getComponentName().getClassName();
        RouteNode peek = this.routeNodes.peek();
        if (peek != null && (tag2 = peek.getTag()) != null) {
            str = tag2;
        }
        if (Intrinsics.areEqual(className3, str)) {
            BLog.i(TAG, "push same node -> node = " + this.routeNodes.peek());
        } else {
            this.routeNodes.push(node);
        }
    }

    public final RouteNode pop(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (!(activity instanceof FragmentActivity) || this.routeNodes.isEmpty() || this.routeNodes.size() == 1) {
            return null;
        }
        return this.routeNodes.pop();
    }

    public final RouteNode peek(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if ((activity instanceof FragmentActivity) && !this.routeNodes.isEmpty()) {
            return this.routeNodes.peek();
        }
        return null;
    }

    public final void destroy() {
        this.routeNodes.clear();
    }

    public final int size() {
        return this.routeNodes.size();
    }

    /* compiled from: RouteTraceManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/function/RouteTraceManager$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}