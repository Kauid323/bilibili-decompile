package tv.danmaku.biliplayerv2.service.resolve;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import bili.resource.playerbaseres.R;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.dd.DeviceDecision;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.player.plugin.IPluginResolverListener;
import tv.danmaku.player.plugin.PluginParams;
import tv.danmaku.player.plugin.PluginResult;
import tv.danmaku.player.plugin.mod.IjkX86Helper;
import tv.danmaku.player.plugin.mod.ModPluginResolver;

/* compiled from: CommonResolveTasks.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/ResolvePlayerSDKTask;", "Ltv/danmaku/biliplayerv2/service/resolve/Task;", "", "<init>", "()V", "mErrorMsg", "mSucceedMsg", "description", "getDescription", "()Ljava/lang/String;", "getError", "getResult", "run", "", SplashCustomReporterKt.STATE_CANCEL, "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ResolvePlayerSDKTask extends Task<String, String> {
    public static final Companion Companion = new Companion(null);
    private static boolean loadSdkSucceed;
    private String mErrorMsg;
    private String mSucceedMsg;

    public ResolvePlayerSDKTask() {
        setPrimary(true);
        this.mErrorMsg = "no error";
        this.mSucceedMsg = "succeed";
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    public String getDescription() {
        return "ResolvePlayerSDKTask";
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    public String getError() {
        return this.mErrorMsg;
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    public String getResult() {
        return this.mSucceedMsg;
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    public void run() {
        Context applicationContext;
        if (loadSdkSucceed) {
            BLog.i("plugin load sdk success");
        } else if (DeviceDecision.INSTANCE.getBoolean("player.disable_x86_sdk", false)) {
            String str = Build.FINGERPRINT;
            BLog.i("disable x86 sdk, FINGERPRINT:" + str + " MODEL:" + Build.MODEL + " BRAND:" + Build.BRAND + " MANUFACTURER:" + Build.MANUFACTURER);
            loadSdkSucceed = true;
        } else {
            dispatchTaskStart();
            if (IjkX86Helper.isX86Device()) {
                ModPluginResolver modPluginResolver = new ModPluginResolver();
                Application application = BiliContext.application();
                boolean initPlayerSdk = modPluginResolver.resolvePlugin(application != null ? application.getApplicationContext() : null, new PluginParams(), new IPluginResolverListener() { // from class: tv.danmaku.biliplayerv2.service.resolve.ResolvePlayerSDKTask$run$initPlayerSdk$1
                    @Override // tv.danmaku.player.plugin.IPluginResolverListener
                    public void onPostResolve(PluginResult result) {
                    }

                    @Override // tv.danmaku.player.plugin.IPluginResolverListener
                    public void onProgress(float progress) {
                        ResolvePlayerSDKTask.this.setProgress(progress);
                        ResolvePlayerSDKTask.this.dispatchTaskProgress();
                    }

                    @Override // tv.danmaku.player.plugin.IPluginResolverListener
                    public void onPreResolve() {
                        ResolvePlayerSDKTask.this.setProgress(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                        ResolvePlayerSDKTask.this.dispatchTaskProgress();
                    }

                    @Override // tv.danmaku.player.plugin.IPluginResolverListener
                    public void onError(Throwable throwable) {
                    }
                });
                if (initPlayerSdk) {
                    this.mSucceedMsg = "plugin load success";
                    dispatchTaskSucceed();
                    loadSdkSucceed = true;
                    return;
                }
                Application application2 = BiliContext.application();
                this.mErrorMsg = (application2 == null || (applicationContext = application2.getApplicationContext()) == null || (r1 = applicationContext.getString(R.string.playerbaseres_global_string_710)) == null) ? "plugin load failed." : "plugin load failed.";
                dispatchTaskError();
                return;
            }
            dispatchTaskSucceed();
        }
    }

    /* compiled from: CommonResolveTasks.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/ResolvePlayerSDKTask$Companion;", "", "<init>", "()V", "loadSdkSucceed", "", "getLoadSdkSucceed", "()Z", "setLoadSdkSucceed", "(Z)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getLoadSdkSucceed() {
            return ResolvePlayerSDKTask.loadSdkSucceed;
        }

        public final void setLoadSdkSucceed(boolean z) {
            ResolvePlayerSDKTask.loadSdkSucceed = z;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    public void cancel() {
    }
}