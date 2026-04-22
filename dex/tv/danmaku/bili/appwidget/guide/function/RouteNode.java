package tv.danmaku.bili.appwidget.guide.function;

import BottomSheetItemData$;
import com.bilibili.moduleservice.appwidget.GuideScene;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;

/* compiled from: RouteTraceManager.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/function/RouteNode;", "", AppConfig.HOST_TAG, "", "isFunction", "", "scene", "Lcom/bilibili/moduleservice/appwidget/GuideScene;", "<init>", "(Ljava/lang/String;ZLcom/bilibili/moduleservice/appwidget/GuideScene;)V", "getTag", "()Ljava/lang/String;", "()Z", "getScene", "()Lcom/bilibili/moduleservice/appwidget/GuideScene;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RouteNode {
    public static final int $stable = 8;
    private final boolean isFunction;
    private final GuideScene scene;
    private final String tag;

    public static /* synthetic */ RouteNode copy$default(RouteNode routeNode, String str, boolean z, GuideScene guideScene, int i, Object obj) {
        if ((i & 1) != 0) {
            str = routeNode.tag;
        }
        if ((i & 2) != 0) {
            z = routeNode.isFunction;
        }
        if ((i & 4) != 0) {
            guideScene = routeNode.scene;
        }
        return routeNode.copy(str, z, guideScene);
    }

    public final String component1() {
        return this.tag;
    }

    public final boolean component2() {
        return this.isFunction;
    }

    public final GuideScene component3() {
        return this.scene;
    }

    public final RouteNode copy(String str, boolean z, GuideScene guideScene) {
        Intrinsics.checkNotNullParameter(str, AppConfig.HOST_TAG);
        return new RouteNode(str, z, guideScene);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RouteNode) {
            RouteNode routeNode = (RouteNode) obj;
            return Intrinsics.areEqual(this.tag, routeNode.tag) && this.isFunction == routeNode.isFunction && Intrinsics.areEqual(this.scene, routeNode.scene);
        }
        return false;
    }

    public int hashCode() {
        return (((this.tag.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isFunction)) * 31) + (this.scene == null ? 0 : this.scene.hashCode());
    }

    public String toString() {
        String str = this.tag;
        boolean z = this.isFunction;
        return "RouteNode(tag=" + str + ", isFunction=" + z + ", scene=" + this.scene + ")";
    }

    public RouteNode(String tag, boolean isFunction, GuideScene scene) {
        Intrinsics.checkNotNullParameter(tag, AppConfig.HOST_TAG);
        this.tag = tag;
        this.isFunction = isFunction;
        this.scene = scene;
    }

    public /* synthetic */ RouteNode(String str, boolean z, GuideScene guideScene, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? null : guideScene);
    }

    public final String getTag() {
        return this.tag;
    }

    public final boolean isFunction() {
        return this.isFunction;
    }

    public final GuideScene getScene() {
        return this.scene;
    }
}