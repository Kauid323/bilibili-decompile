package tv.danmaku.biliplayerv2.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateUIMode;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IFunctionWidgetService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0012"}, d2 = {"Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "", "launchType", "", "forceNewInstance", "", "flag", "<init>", "(IZI)V", "getLaunchType", "()I", "getForceNewInstance", "()Z", "getFlag", "toString", "", "Companion", "Builder", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FunctionWidgetConfig {
    public static final Companion Companion = new Companion(null);
    public static final int FLAG_CHANGE_ORIENTATION_DISABLE_WHEN_SHOW = 64;
    public static final int FLAG_DISMISS_ACTIVITY_STOP = 4;
    public static final int FLAG_DISMISS_CHANGE_VIDEO = 2;
    public static final int FLAG_DISMISS_SCREEN_MODE_CHANGE = 1;
    public static final int FLAG_DISMISS_VIDEO_COMPLETED = 32;
    public static final int FLAG_PERSISTENT_WIDGET = 16;
    public static final int FLAG_REMOVE_CHANGE_VIDEO = 8;
    public static final int LAUNCH_TYPE_NORMAL = 2;
    public static final int LAUNCH_TYPE_SINGLETON = 1;
    private final int flag;
    private final boolean forceNewInstance;
    private final int launchType;

    public /* synthetic */ FunctionWidgetConfig(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2);
    }

    private FunctionWidgetConfig(int launchType, boolean forceNewInstance, int flag) {
        this.launchType = launchType;
        this.forceNewInstance = forceNewInstance;
        this.flag = flag;
    }

    public final int getLaunchType() {
        return this.launchType;
    }

    public final boolean getForceNewInstance() {
        return this.forceNewInstance;
    }

    public final int getFlag() {
        return this.flag;
    }

    /* compiled from: IFunctionWidgetService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig$Companion;", "", "<init>", "()V", "LAUNCH_TYPE_SINGLETON", "", "LAUNCH_TYPE_NORMAL", "FLAG_DISMISS_SCREEN_MODE_CHANGE", "FLAG_DISMISS_CHANGE_VIDEO", "FLAG_DISMISS_ACTIVITY_STOP", "FLAG_REMOVE_CHANGE_VIDEO", "FLAG_PERSISTENT_WIDGET", "FLAG_DISMISS_VIDEO_COMPLETED", "FLAG_CHANGE_ORIENTATION_DISABLE_WHEN_SHOW", "FunctionWidgetAttribute", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {

        /* compiled from: IFunctionWidgetService.kt */
        @Target({ElementType.PARAMETER})
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig$Companion$FunctionWidgetAttribute;", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public @interface FunctionWidgetAttribute {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public String toString() {
        String lt;
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("{");
        if (this.launchType == 2) {
            lt = UpdateUIMode.NORMAL;
        } else {
            lt = "singleton";
        }
        strBuilder.append("launchType=" + lt + "; forceNewInstance=" + this.forceNewInstance + ";flag=");
        if ((this.flag & 1) != 0) {
            strBuilder.append("DISMISS_SCREEN_MODE_CHANGE");
        }
        if ((2 & this.flag) != 0) {
            strBuilder.append("|DISMISS_CHANGE_VIDEO");
        }
        if ((this.flag & 4) != 0) {
            strBuilder.append("|DISMISS_ACTIVITY_STOP");
        }
        if ((this.flag & 8) != 0) {
            strBuilder.append("|REMOVE_CHANGE_VIDEO");
        }
        if ((this.flag & 16) != 0) {
            strBuilder.append("|PERSISTENT_WIDGET");
        }
        if ((this.flag & 32) != 0) {
            strBuilder.append("|DISMISS_VIDEO_COMPLETED");
        }
        if ((this.flag & 64) != 0) {
            strBuilder.append("|CHANGE_ORIENTATION_DISABLE_WHEN_SHOW");
        }
        strBuilder.append("}");
        String sb = strBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    /* compiled from: IFunctionWidgetService.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig$Builder;", "", "<init>", "()V", "launchType", "", "forceNewInstance", "", "flag", "type", "force", "dismissWhenVideoCompleted", "dismiss", "dismissWhenActivityStop", "dismissWhenScreenModeChange", "dismissWhenVideoChange", "removeWhenVideoChange", "remove", "persistent", "p", "changeOrientationDisableWhenShow", "disable", "build", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Builder {
        private int flag;
        private boolean forceNewInstance;
        private int launchType = 1;

        public final Builder launchType(int type) {
            this.launchType = type;
            return this;
        }

        public final Builder forceNewInstance(boolean force) {
            this.forceNewInstance = force;
            return this;
        }

        public final Builder dismissWhenVideoCompleted(boolean dismiss) {
            int i;
            if (dismiss) {
                i = this.flag | 32;
            } else {
                i = this.flag & (-33);
            }
            this.flag = i;
            return this;
        }

        public final Builder dismissWhenActivityStop(boolean dismiss) {
            int i;
            if (dismiss) {
                i = this.flag | 4;
            } else {
                i = this.flag & (-5);
            }
            this.flag = i;
            return this;
        }

        public final Builder dismissWhenScreenModeChange(boolean dismiss) {
            int i;
            if (dismiss) {
                i = this.flag | 1;
            } else {
                i = this.flag & (-2);
            }
            this.flag = i;
            return this;
        }

        public final Builder dismissWhenVideoChange(boolean dismiss) {
            int i;
            if (dismiss) {
                i = this.flag | 2;
            } else {
                i = this.flag & (-3);
            }
            this.flag = i;
            return this;
        }

        public final Builder removeWhenVideoChange(boolean remove) {
            int i;
            if (remove) {
                i = this.flag | 8;
            } else {
                i = this.flag & (-9);
            }
            this.flag = i;
            return this;
        }

        public final Builder persistent(boolean p) {
            int i;
            if (p) {
                i = this.flag | 16;
            } else {
                i = this.flag & (-17);
            }
            this.flag = i;
            return this;
        }

        public final Builder changeOrientationDisableWhenShow(boolean disable) {
            int i;
            if (disable) {
                i = this.flag | 64;
            } else {
                i = this.flag & (-65);
            }
            this.flag = i;
            return this;
        }

        public final FunctionWidgetConfig build() {
            return new FunctionWidgetConfig(this.launchType, this.forceNewInstance, this.flag, null);
        }
    }
}