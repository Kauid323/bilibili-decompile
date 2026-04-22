package tv.danmaku.bili.report.startup.v3;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.bilibili.base.BiliContext;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.gripper.api.base.GBootExp;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.RawKV;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.foundation.Foundation;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.foundation.util.Objects;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.performance.BootOpt;
import com.bilibili.lifeevent.LifeEventLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.report.startup.v2.BootTracer;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonReportKt;
import tv.danmaku.bili.utils.ChannelNameUtil;

/* compiled from: BootTracerV2.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001KB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\n*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0003J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u001bR\u0014\u0010%\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u001bR\u0014\u0010&\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\u001bR\u0014\u0010'\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\u001bR\u0014\u0010(\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\u001bR\u0014\u0010)\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010\u001bR\u0014\u0010*\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010\u001bR\u0014\u0010+\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010\u001bR\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010\u001bR\u0014\u00103\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u0010\u001bR\u0014\u00104\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010\u001bR\u0014\u00105\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u0010\u001bR\u0014\u00106\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u0010\u001bR\u0014\u00107\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u0010\u001bR\u0014\u00108\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u0010\u001bR\u0014\u00109\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u0010\u001bR\u0014\u0010:\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u0010\u001bR\u0014\u0010;\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u0010\u001bR\"\u0010<\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010=R\u0014\u0010D\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010?R\u0014\u0010F\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010?R\u0011\u0010J\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bH\u0010I¨\u0006L"}, d2 = {"Ltv/danmaku/bili/report/startup/v3/BootTracerV2;", "", "<init>", "()V", "", "start", "end", "", "format", "(Ljava/lang/Long;Ljava/lang/Long;)Ljava/lang/String;", "", "filterData", "(Ljava/util/Map;)Ljava/util/Map;", "", "reportUnifiedLog", "", "networkType", "getNetworkType", "(I)Ljava/lang/String;", "key", "time", "recordTime", "(Ljava/lang/String;J)V", "report", "lastStartRecord", "(Ljava/lang/String;)J", "TAG", "Ljava/lang/String;", "KV_FILE", "j$/util/concurrent/ConcurrentHashMap", "recordMap", "Lj$/util/concurrent/ConcurrentHashMap;", "fragmentConsumeMap", "Lcom/bilibili/lib/blkv/RawKV;", "prefs", "Lcom/bilibili/lib/blkv/RawKV;", "SPLASH_START", "SPLASH_END", "FRAGMENT_ATTACH_SUFFIX", "FRAGMENT_VIEW_CREATED_SUFFIX", "BOOT_START", "BOOT_ATTACH_END", "GRIPPER_START", "GRIPPER_END", "gripperTotalTime", "J", "getGripperTotalTime", "()J", "setGripperTotalTime", "(J)V", "BOOT_CREATE_START", "BOOT_CREATE_END", "ENTRY_ACTIVITY_CREATE_START", "ENTRY_ACTIVITY_CREATE_END", "ENTRY_ACTIVITY_START_START", "ENTRY_ACTIVITY_START_END", "ENTRY_ACTIVITY_RESUME_START", "ENTRY_ACTIVITY_RESUME_END", "ENTRY_FRAGMENT_CREATED_START", "BOOT_END", "launchOption", "I", "getLaunchOption", "()I", "setLaunchOption", "(I)V", "PLATFORM_ANDROID", "getFirstLaunch", "firstLaunch", "getHasPrivacy", "hasPrivacy", "", "getNewReportSwitch", "()Z", "newReportSwitch", "TaskInfo", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BootTracerV2 {
    public static final String BOOT_ATTACH_END = "boot_attach_end";
    public static final String BOOT_CREATE_END = "boot_create_end";
    public static final String BOOT_CREATE_START = "boot_create_start";
    public static final String BOOT_END = "boot_end";
    public static final String BOOT_START = "boot_start";
    public static final String ENTRY_ACTIVITY_CREATE_END = "entry_activity_create_end";
    public static final String ENTRY_ACTIVITY_CREATE_START = "entry_activity_create_start";
    public static final String ENTRY_ACTIVITY_RESUME_END = "entry_activity_resume_end";
    public static final String ENTRY_ACTIVITY_RESUME_START = "entry_activity_resume_start";
    public static final String ENTRY_ACTIVITY_START_END = "entry_activity_start_end";
    public static final String ENTRY_ACTIVITY_START_START = "entry_activity_start_start";
    public static final String ENTRY_FRAGMENT_CREATED_START = "entry_fragment_created_start";
    public static final String FRAGMENT_ATTACH_SUFFIX = "_fragment_attach";
    public static final String FRAGMENT_VIEW_CREATED_SUFFIX = "_fragment_created";
    public static final String GRIPPER_END = "gripper_end";
    public static final String GRIPPER_START = "gripper_start";
    public static final String KV_FILE = "boot_tracer_v2";
    private static final int PLATFORM_ANDROID = 3;
    public static final String SPLASH_END = "splash_end";
    public static final String SPLASH_START = "splash_start";
    public static final String TAG = "BootTracerV2_";
    private static int launchOption;
    private static RawKV prefs;
    public static final BootTracerV2 INSTANCE = new BootTracerV2();
    private static final ConcurrentHashMap<String, Long> recordMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Long> fragmentConsumeMap = new ConcurrentHashMap<>();
    private static long gripperTotalTime = -1;
    public static final int $stable = 8;

    public final void recordTime(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        recordTime$default(this, str, 0L, 2, null);
    }

    private BootTracerV2() {
    }

    public final long getGripperTotalTime() {
        return gripperTotalTime;
    }

    public final void setGripperTotalTime(long j) {
        gripperTotalTime = j;
    }

    public final int getLaunchOption() {
        return launchOption;
    }

    public final void setLaunchOption(int i) {
        launchOption = i;
    }

    private final int getFirstLaunch() {
        return BootTracer.getFirstLaunch().get() ? 1 : 0;
    }

    private final int getHasPrivacy() {
        return BootTracer.getHasPrivacy().get() ? 1 : 0;
    }

    private final String format(Long start, Long end) {
        if (start == null || end == null || end.longValue() < 0 || start.longValue() < 0) {
            return LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR;
        }
        long time = end.longValue() - start.longValue();
        if (time <= 0) {
            return LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR;
        }
        return String.valueOf(time);
    }

    public final boolean getNewReportSwitch() {
        return DeviceDecision.INSTANCE.getBoolean("dd.launch.apm.enable-v3-report", true);
    }

    public static /* synthetic */ void recordTime$default(BootTracerV2 bootTracerV2, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = SystemClock.uptimeMillis();
        }
        bootTracerV2.recordTime(str, j);
    }

    public final void recordTime(String key, long time) {
        Intrinsics.checkNotNullParameter(key, "key");
        BLog.d(TAG, "recordTime key:" + key + " time:" + time);
        BootOpt.INSTANCE.recordBootTracer(key);
        if (StringsKt.endsWith$default(key, FRAGMENT_ATTACH_SUFFIX, false, 2, (Object) null)) {
            fragmentConsumeMap.put(StringsKt.removeSuffix(key, FRAGMENT_ATTACH_SUFFIX), Long.valueOf(time));
        } else if (StringsKt.endsWith$default(key, FRAGMENT_VIEW_CREATED_SUFFIX, false, 2, (Object) null)) {
            String name = StringsKt.removeSuffix(key, FRAGMENT_VIEW_CREATED_SUFFIX);
            Map map = fragmentConsumeMap;
            Long l = (Long) map.get(name);
            if (l != null) {
                long it = l.longValue();
                map.put(name, Long.valueOf(time - it));
                return;
            }
            BootTracerV2 bootTracerV2 = INSTANCE;
            map.put(name, -1L);
        } else {
            recordMap.put(key, Long.valueOf(time));
        }
    }

    private final Map<String, Long> filterData(Map<String, Long> map) {
        LinkedHashMap result$iv = new LinkedHashMap();
        for (Map.Entry entry$iv : map.entrySet()) {
            long it = entry$iv.getValue().longValue();
            if (it <= 30000) {
                result$iv.put(entry$iv.getKey(), entry$iv.getValue());
            }
        }
        LinkedHashMap $this$filterValues$iv = result$iv;
        return $this$filterValues$iv;
    }

    public final void report() {
        GBootExp it;
        if (!BiliContext.isMainProcess()) {
            return;
        }
        HashMap map = new HashMap();
        Map mapV3 = new LinkedHashMap();
        ConcurrentHashMap it2 = recordMap;
        map.put("launch_option", String.valueOf(launchOption));
        map.put("first_launch", String.valueOf(INSTANCE.getFirstLaunch()));
        map.put("has_privacy", String.valueOf(INSTANCE.getHasPrivacy()));
        map.put("main_time", INSTANCE.format((Long) it2.get(BOOT_START), (Long) it2.get(BOOT_CREATE_END)));
        map.put("layout_time", INSTANCE.format((Long) it2.get(ENTRY_ACTIVITY_CREATE_START), (Long) it2.get(BOOT_END)));
        map.put("splash_time", INSTANCE.format((Long) it2.get(SPLASH_START), (Long) it2.get(SPLASH_END)));
        map.put("pre_gripper_init", INSTANCE.format((Long) it2.get(BOOT_START), (Long) it2.get(GRIPPER_START)));
        map.put("gripper_time", INSTANCE.format((Long) it2.get(GRIPPER_START), (Long) it2.get(GRIPPER_END)));
        map.put("gripper_task_time", String.valueOf(gripperTotalTime));
        map.put("app_attach_time", INSTANCE.format((Long) it2.get(BOOT_START), (Long) it2.get(BOOT_ATTACH_END)));
        map.put("app_attach_to_create", INSTANCE.format((Long) it2.get(BOOT_ATTACH_END), (Long) it2.get(BOOT_CREATE_START)));
        map.put("app_create_time", INSTANCE.format((Long) it2.get(BOOT_CREATE_START), (Long) it2.get(BOOT_CREATE_END)));
        map.put("app_create_later", INSTANCE.format((Long) it2.get(BOOT_CREATE_END), (Long) it2.get(ENTRY_ACTIVITY_CREATE_START)));
        map.put("entry_activity_create_time", INSTANCE.format((Long) it2.get(ENTRY_ACTIVITY_CREATE_START), (Long) it2.get(ENTRY_ACTIVITY_CREATE_END)));
        map.put("entry_activity_start_time", INSTANCE.format((Long) it2.get(ENTRY_ACTIVITY_START_START), (Long) it2.get(ENTRY_ACTIVITY_START_END)));
        map.put("entry_activity_resume_time", INSTANCE.format((Long) it2.get(ENTRY_ACTIVITY_RESUME_START), (Long) it2.get(ENTRY_ACTIVITY_RESUME_END)));
        map.put("visable_time", INSTANCE.format((Long) it2.get(BOOT_START), (Long) it2.get(ENTRY_FRAGMENT_CREATED_START)));
        map.put("visited_time", INSTANCE.format((Long) it2.get(BOOT_START), (Long) it2.get(BOOT_END)));
        map.put("fragment_extra_data", Objects.toJsonString(INSTANCE.filterData((Map) fragmentConsumeMap)));
        Context applicationContext = FoundationAlias.getFapp().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(applicationContext).getContainer(), GBootExp.class, (String) null, 2, (Object) null);
        if (suspendProducer != null && (it = (GBootExp) suspendProducer.getOrNull()) != null) {
            map.put("opt_exp", it.getEnable() ? "1" : "0");
        }
        mapV3.put("launch_option", String.valueOf(launchOption));
        mapV3.put("first_launch", String.valueOf(INSTANCE.getFirstLaunch()));
        mapV3.put("has_privacy", String.valueOf(INSTANCE.getHasPrivacy()));
        mapV3.put("splash_time", INSTANCE.format((Long) it2.get(SPLASH_START), (Long) it2.get(SPLASH_END)));
        mapV3.put("gripper_time", INSTANCE.format((Long) it2.get(GRIPPER_START), (Long) it2.get(GRIPPER_END)));
        mapV3.put("visited_time", INSTANCE.format((Long) it2.get(BOOT_START), (Long) it2.get(BOOT_END)));
        List taskInfoList = new ArrayList();
        taskInfoList.add(new TaskInfo("main_time", INSTANCE.format((Long) it2.get(BOOT_START), (Long) it2.get(BOOT_CREATE_END))));
        taskInfoList.add(new TaskInfo("layout_time", INSTANCE.format((Long) it2.get(ENTRY_ACTIVITY_CREATE_START), (Long) it2.get(BOOT_END))));
        taskInfoList.add(new TaskInfo("pre_gripper_init", INSTANCE.format((Long) it2.get(BOOT_START), (Long) it2.get(GRIPPER_START))));
        taskInfoList.add(new TaskInfo("gripper_task_time", String.valueOf(gripperTotalTime)));
        taskInfoList.add(new TaskInfo("app_attach_time", INSTANCE.format((Long) it2.get(BOOT_START), (Long) it2.get(BOOT_ATTACH_END))));
        taskInfoList.add(new TaskInfo("app_attach_to_create", INSTANCE.format((Long) it2.get(BOOT_ATTACH_END), (Long) it2.get(BOOT_CREATE_START))));
        taskInfoList.add(new TaskInfo("app_create_time", INSTANCE.format((Long) it2.get(BOOT_CREATE_START), (Long) it2.get(BOOT_CREATE_END))));
        taskInfoList.add(new TaskInfo("app_create_later", INSTANCE.format((Long) it2.get(BOOT_CREATE_END), (Long) it2.get(ENTRY_ACTIVITY_CREATE_START))));
        taskInfoList.add(new TaskInfo("entry_activity_create_time", INSTANCE.format((Long) it2.get(ENTRY_ACTIVITY_CREATE_START), (Long) it2.get(ENTRY_ACTIVITY_CREATE_END))));
        taskInfoList.add(new TaskInfo("entry_activity_start_time", INSTANCE.format((Long) it2.get(ENTRY_ACTIVITY_START_START), (Long) it2.get(ENTRY_ACTIVITY_START_END))));
        taskInfoList.add(new TaskInfo("entry_activity_resume_time", INSTANCE.format((Long) it2.get(ENTRY_ACTIVITY_RESUME_START), (Long) it2.get(ENTRY_ACTIVITY_RESUME_END))));
        taskInfoList.add(new TaskInfo("visable_time", INSTANCE.format((Long) it2.get(BOOT_START), (Long) it2.get(ENTRY_FRAGMENT_CREATED_START))));
        mapV3.put("tasks_info", Objects.toJsonString(taskInfoList));
        BLog.i(TAG, "report record time = " + map);
        BLog.e(TAG, "visited time = " + map.get("visited_time"));
        reportUnifiedLog();
        Neurons.trackT(false, "ops.misaka.app-launcher.v2", map, 1, new Function0() { // from class: tv.danmaku.bili.report.startup.v3.BootTracerV2$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean report$lambda$1;
                report$lambda$1 = BootTracerV2.report$lambda$1();
                return Boolean.valueOf(report$lambda$1);
            }
        });
        if (getNewReportSwitch()) {
            Neurons.trackT(false, "ops.misaka.app-launcher", mapV3, 1, new Function0() { // from class: tv.danmaku.bili.report.startup.v3.BootTracerV2$$ExternalSyntheticLambda1
                public final Object invoke() {
                    boolean report$lambda$2;
                    report$lambda$2 = BootTracerV2.report$lambda$2();
                    return Boolean.valueOf(report$lambda$2);
                }
            });
        }
        prefs = BLKV.getKvs(FoundationAlias.getFapp(), KV_FILE, true, (int) MisakaHelper.MAX_REPORT_SIZE);
        RawKV rawKV = prefs;
        if (rawKV == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            rawKV = null;
        }
        mapV3.put("main_time", INSTANCE.format((Long) recordMap.get(BOOT_START), (Long) recordMap.get(BOOT_CREATE_END)));
        Unit unit = Unit.INSTANCE;
        rawKV.putMap("record", mapV3);
        BootOpt.INSTANCE.recordOpsMisakaAppLauncherV2(com.bilibili.ogv.infra.util.StringsKt.toIntOrZero((String) mapV3.get("visited_time")), launchOption != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean report$lambda$1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean report$lambda$2() {
        return true;
    }

    public final long lastStartRecord(String key) {
        String obj;
        Intrinsics.checkNotNullParameter(key, "key");
        prefs = BLKV.getKvs(FoundationAlias.getFapp(), KV_FILE, true, (int) MisakaHelper.MAX_REPORT_SIZE);
        RawKV rawKV = prefs;
        if (rawKV == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            rawKV = null;
        }
        Map map = rawKV.getMap("record", MapsKt.emptyMap());
        Object obj2 = map.get(key);
        if (obj2 == null || (obj = obj2.toString()) == null) {
            return 0L;
        }
        return Long.parseLong(obj);
    }

    private final void reportUnifiedLog() {
        Map infoMap = new HashMap();
        String str = Build.BRAND;
        if (str == null) {
            str = "";
        }
        infoMap.put("brand", str);
        String str2 = Build.MODEL;
        if (str2 == null) {
            str2 = "";
        }
        infoMap.put("model", str2);
        infoMap.put("platform", "3");
        infoMap.put("version_code", String.valueOf(Foundation.Companion.instance().getApps().getInternalVersionCode()));
        String str3 = Build.VERSION.RELEASE;
        infoMap.put("osver", str3 != null ? str3 : "");
        infoMap.put("ff_version", String.valueOf(ConfigManager.Companion.ab().getVersion()));
        infoMap.put("config_version", String.valueOf(ConfigManager.Companion.config().getVersion()));
        infoMap.put(DeepLinkButtonReportKt.REPORT_EXTRA_CHANNEL, ChannelNameUtil.Companion.getPackageChannel());
        infoMap.put("mid", String.valueOf(BiliAccounts.get(FoundationAlias.getFapp()).mid()));
        infoMap.put("buvid", BuvidHelper.getBuvid());
        infoMap.put("network", getNetworkType(ConnectivityMonitor.getInstance().getNetwork()));
        LifeEventLog.report("startup", infoMap);
    }

    private final String getNetworkType(int networkType) {
        switch (networkType) {
            case 1:
                return "WIFI";
            case 2:
                return "Mobile";
            case 3:
                return "Disconnect";
            case 4:
                return "Other";
            case 5:
                return "Ethernet";
            default:
                return "Unknown";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BootTracerV2.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/report/startup/v3/BootTracerV2$TaskInfo;", "", ChannelRoutes.CHANNEL_NAME, "", "duration", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getDuration", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class TaskInfo {
        private final String duration;
        private final String name;

        public static /* synthetic */ TaskInfo copy$default(TaskInfo taskInfo, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = taskInfo.name;
            }
            if ((i & 2) != 0) {
                str2 = taskInfo.duration;
            }
            return taskInfo.copy(str, str2);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.duration;
        }

        public final TaskInfo copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, ChannelRoutes.CHANNEL_NAME);
            Intrinsics.checkNotNullParameter(str2, "duration");
            return new TaskInfo(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TaskInfo) {
                TaskInfo taskInfo = (TaskInfo) obj;
                return Intrinsics.areEqual(this.name, taskInfo.name) && Intrinsics.areEqual(this.duration, taskInfo.duration);
            }
            return false;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.duration.hashCode();
        }

        public String toString() {
            String str = this.name;
            return "TaskInfo(name=" + str + ", duration=" + this.duration + ")";
        }

        public TaskInfo(String name, String duration) {
            Intrinsics.checkNotNullParameter(name, ChannelRoutes.CHANNEL_NAME);
            Intrinsics.checkNotNullParameter(duration, "duration");
            this.name = name;
            this.duration = duration;
        }

        public final String getName() {
            return this.name;
        }

        public final String getDuration() {
            return this.duration;
        }
    }
}