package tv.danmaku.bili.update.internal.binder;

import android.app.Activity;
import com.bilibili.app.updateapi.ButtonClickListener;
import com.bilibili.app.updateapi.applet.DialogOptions;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BinderParams.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u000f\u0010\u0011\u0012B\u001f\b\u0004\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0004\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/update/internal/binder/BinderParams;", "", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "biliUpgradeInfo", "Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "<init>", "(Ljava/lang/ref/WeakReference;Ltv/danmaku/bili/update/model/BiliUpgradeInfo;)V", "getActivityRef", "()Ljava/lang/ref/WeakReference;", "getBiliUpgradeInfo", "()Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "isInvalid", "", "ManualUpdate", "StartupUpdate", "WifeAutoUpdate", "AppletUpdate", "Ltv/danmaku/bili/update/internal/binder/BinderParams$AppletUpdate;", "Ltv/danmaku/bili/update/internal/binder/BinderParams$ManualUpdate;", "Ltv/danmaku/bili/update/internal/binder/BinderParams$StartupUpdate;", "Ltv/danmaku/bili/update/internal/binder/BinderParams$WifeAutoUpdate;", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class BinderParams {
    private final WeakReference<Activity> activityRef;
    private final BiliUpgradeInfo biliUpgradeInfo;

    public /* synthetic */ BinderParams(WeakReference weakReference, BiliUpgradeInfo biliUpgradeInfo, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference, biliUpgradeInfo);
    }

    private BinderParams(WeakReference<Activity> weakReference, BiliUpgradeInfo biliUpgradeInfo) {
        this.activityRef = weakReference;
        this.biliUpgradeInfo = biliUpgradeInfo;
    }

    public final WeakReference<Activity> getActivityRef() {
        return this.activityRef;
    }

    public final BiliUpgradeInfo getBiliUpgradeInfo() {
        return this.biliUpgradeInfo;
    }

    public final boolean isInvalid() {
        if (this.activityRef != null && this.biliUpgradeInfo != null && this.activityRef.get() != null) {
            Activity activity = this.activityRef.get();
            Intrinsics.checkNotNull(activity);
            if (!activity.isFinishing()) {
                return false;
            }
        }
        return true;
    }

    /* compiled from: BinderParams.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/update/internal/binder/BinderParams$ManualUpdate;", "Ltv/danmaku/bili/update/internal/binder/BinderParams;", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "biliUpgradeInfo", "Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "isManual", "", "<init>", "(Ljava/lang/ref/WeakReference;Ltv/danmaku/bili/update/model/BiliUpgradeInfo;Z)V", "()Z", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class ManualUpdate extends BinderParams {
        private final boolean isManual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ManualUpdate(WeakReference<Activity> weakReference, BiliUpgradeInfo biliUpgradeInfo, boolean isManual) {
            super(weakReference, biliUpgradeInfo, null);
            Intrinsics.checkNotNullParameter(weakReference, "activityRef");
            Intrinsics.checkNotNullParameter(biliUpgradeInfo, "biliUpgradeInfo");
            this.isManual = isManual;
        }

        public final boolean isManual() {
            return this.isManual;
        }
    }

    /* compiled from: BinderParams.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000b¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/update/internal/binder/BinderParams$StartupUpdate;", "Ltv/danmaku/bili/update/internal/binder/BinderParams;", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "biliUpgradeInfo", "Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "isManual", "", "<init>", "(Ljava/lang/ref/WeakReference;Ltv/danmaku/bili/update/model/BiliUpgradeInfo;Z)V", "()Z", "asManualUpdate", "Ltv/danmaku/bili/update/internal/binder/BinderParams$ManualUpdate;", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class StartupUpdate extends BinderParams {
        private final boolean isManual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartupUpdate(WeakReference<Activity> weakReference, BiliUpgradeInfo biliUpgradeInfo, boolean isManual) {
            super(weakReference, biliUpgradeInfo, null);
            Intrinsics.checkNotNullParameter(weakReference, "activityRef");
            Intrinsics.checkNotNullParameter(biliUpgradeInfo, "biliUpgradeInfo");
            this.isManual = isManual;
        }

        public final boolean isManual() {
            return this.isManual;
        }

        public final ManualUpdate asManualUpdate() {
            return new ManualUpdate(getActivityRef(), getBiliUpgradeInfo(), this.isManual);
        }
    }

    /* compiled from: BinderParams.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/update/internal/binder/BinderParams$WifeAutoUpdate;", "Ltv/danmaku/bili/update/internal/binder/BinderParams;", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "biliUpgradeInfo", "Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "<init>", "(Ljava/lang/ref/WeakReference;Ltv/danmaku/bili/update/model/BiliUpgradeInfo;)V", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class WifeAutoUpdate extends BinderParams {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WifeAutoUpdate(WeakReference<Activity> weakReference, BiliUpgradeInfo biliUpgradeInfo) {
            super(weakReference, biliUpgradeInfo, null);
            Intrinsics.checkNotNullParameter(weakReference, "activityRef");
            Intrinsics.checkNotNullParameter(biliUpgradeInfo, "biliUpgradeInfo");
        }
    }

    /* compiled from: BinderParams.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/update/internal/binder/BinderParams$AppletUpdate;", "Ltv/danmaku/bili/update/internal/binder/BinderParams;", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "biliUpgradeInfo", "Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "dialogOptions", "Lcom/bilibili/app/updateapi/applet/DialogOptions;", "buttonClickListener", "Lcom/bilibili/app/updateapi/ButtonClickListener;", "<init>", "(Ljava/lang/ref/WeakReference;Ltv/danmaku/bili/update/model/BiliUpgradeInfo;Lcom/bilibili/app/updateapi/applet/DialogOptions;Lcom/bilibili/app/updateapi/ButtonClickListener;)V", "getDialogOptions", "()Lcom/bilibili/app/updateapi/applet/DialogOptions;", "getButtonClickListener", "()Lcom/bilibili/app/updateapi/ButtonClickListener;", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AppletUpdate extends BinderParams {
        private final ButtonClickListener buttonClickListener;
        private final DialogOptions dialogOptions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppletUpdate(WeakReference<Activity> weakReference, BiliUpgradeInfo biliUpgradeInfo, DialogOptions dialogOptions, ButtonClickListener buttonClickListener) {
            super(weakReference, biliUpgradeInfo, null);
            Intrinsics.checkNotNullParameter(weakReference, "activityRef");
            Intrinsics.checkNotNullParameter(biliUpgradeInfo, "biliUpgradeInfo");
            this.dialogOptions = dialogOptions;
            this.buttonClickListener = buttonClickListener;
        }

        public final DialogOptions getDialogOptions() {
            return this.dialogOptions;
        }

        public final ButtonClickListener getButtonClickListener() {
            return this.buttonClickListener;
        }
    }
}