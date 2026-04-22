package tv.danmaku.bili.report.startup;

import android.util.Log;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.report.startup.v2.BootTracer;
import tv.danmaku.bili.report.startup.v2.StartShowRecorder;
import tv.danmaku.bili.report.startup.v2.StartUpUtilsKt;
import tv.danmaku.bili.report.startup.v3.BootTracerV2;

public class StartupApm {
    public static final int DEFAULT_OPTION = 0;
    public static final int WEAKEN_UP_OPTION = 1;
    private static Builder sBuilder = new Builder();

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public @interface Option {
    }

    public static void setLaunchOption(int option) {
        StartUpUtilsKt.startUpTrace("setLaunchOption = " + option);
        sBuilder.launchOption(option);
    }

    public static void setSplashTime(long ts) {
        StartUpUtilsKt.startUpTrace("setSplashTime = " + ts);
        sBuilder.splashTime(ts);
    }

    public static void setLayoutTime(long ts) {
        StartUpUtilsKt.startUpTrace("setLayoutTime = " + ts);
        sBuilder.layoutTime(ts);
    }

    public static void setStartupTime(long ts) {
        StartUpUtilsKt.startUpTrace("setStartupTime = " + ts);
        sBuilder.startupTime(ts);
    }

    public static void setStartShowTime(long ts) {
        StartUpUtilsKt.startUpTrace("setStartShowTime = " + ts);
        sBuilder.startShowTime(ts);
    }

    public static void setAppTime(long ts) {
        StartUpUtilsKt.startUpTrace("setAppTime = " + ts);
        sBuilder.appTime(ts);
    }

    public static void setBizBootTime(long ts) {
        StartUpUtilsKt.startUpTrace("setBizBootTime = " + ts);
        sBuilder.appBizBootTime(ts);
    }

    public static void setBizInitTime(long ts) {
        sBuilder.appBizInitTime(ts);
    }

    public static void doReport() {
        Map<String, String> map = sBuilder.buildReportParam();
        StartUpUtilsKt.startUpTrace("final doReport map = " + map.toString());
        if (!BootTracerV2.INSTANCE.getNewReportSwitch()) {
            Neurons.trackT(false, "ops.misaka.app-launcher", sBuilder.buildReportParam(), 1, new Function0() { // from class: tv.danmaku.bili.report.startup.StartupApm$$ExternalSyntheticLambda0
                public final Object invoke() {
                    boolean sample;
                    sample = StartupApm.sample();
                    return Boolean.valueOf(sample);
                }
            });
        }
        Log.d(BootTracerV2.TAG, "origin report = " + map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean sample() {
        return ConfigManager.ab2().getWithDefault("boot.time.sample.v1", true);
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Builder {
        private long mAppBizBootTime;
        private long mAppTime;
        private long mLayoutTime;
        private int mOption;
        private long mSplashBizInitTime;
        private long mSplashTime;
        private long mStartShowTime;
        private long mStartupTime;

        void launchOption(int option) {
            this.mOption = option;
        }

        void splashTime(long ts) {
            this.mSplashTime = ts;
        }

        void layoutTime(long ts) {
            this.mLayoutTime = ts;
        }

        void startupTime(long ts) {
            this.mStartupTime = ts;
        }

        void appTime(long ts) {
            this.mAppTime = ts;
        }

        void startShowTime(long ts) {
            this.mStartShowTime = ts;
        }

        void appBizBootTime(long ts) {
            this.mAppBizBootTime = ts;
        }

        void appBizInitTime(long ts) {
            this.mSplashBizInitTime = ts;
        }

        Map<String, String> buildReportParam() {
            Map<String, String> params = new HashMap<>();
            StartShowRecorder startShowRecorder = StartShowRecorder.INSTANCE;
            params.put("launch_state", StartShowRecorder.isSelfStart() ? "1" : "0");
            params.put("launch_option", String.valueOf(this.mOption));
            params.put("first_launch", BootTracer.getFirstLaunch().get() ? "1" : "0");
            params.put("has_privacy", BootTracer.getHasPrivacy().get() ? "1" : "0");
            if (this.mAppTime > 0) {
                params.put("main_time", String.valueOf(this.mAppTime));
            }
            if (this.mSplashTime > 0) {
                params.put("splash_time", String.valueOf(this.mSplashTime));
            }
            if (this.mLayoutTime > 0) {
                params.put("layout_time", String.valueOf(this.mLayoutTime));
            }
            if (this.mStartupTime > 0) {
                params.put("visited_time", String.valueOf(this.mStartupTime));
            }
            if (this.mStartShowTime > 0) {
                params.put("visable_time", String.valueOf(this.mStartShowTime));
            }
            if (this.mAppBizBootTime > 0) {
                params.put("module_time", String.valueOf(this.mAppBizBootTime));
            }
            if (this.mSplashBizInitTime > 0) {
                params.put("biz_init_time", String.valueOf(this.mSplashBizInitTime));
            }
            return params;
        }
    }
}