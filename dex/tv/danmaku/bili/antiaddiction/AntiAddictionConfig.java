package tv.danmaku.bili.antiaddiction;

import android.app.Application;
import android.content.SharedPreferences;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.time.DateUtils;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.SharedPrefX;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.heartbeat.HeartBeatReport;
import com.bilibili.module.main.innerpush.BizParams;
import com.bilibili.module.main.innerpush.ISendPushMessage;
import com.bilibili.module.main.innerpush.InnerPush;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.antiaddiction.data.AddictionConfigData;
import tv.danmaku.bili.antiaddiction.data.AntiAddictionStatusData;
import tv.danmaku.bili.antiaddiction.data.Push;
import tv.danmaku.bili.antiaddiction.data.SleepRemindData;
import tv.danmaku.bili.antiaddiction.util.SleepRemindUtil;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

/* compiled from: AntiAddictionConfig.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u0004\u0018\u00010\u001aJ\u0012\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010#\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u001aH\u0002J\u0006\u0010$\u001a\u00020\u001cJ\u0016\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u0012\u0010*\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010+H\u0002J\u0015\u0010,\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020+H\u0000¢\u0006\u0002\b-JQ\u0010.\u001a\u00020\u001c2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005002\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u0002032\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u000203H\u0000¢\u0006\u0002\b8J(\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u000f2\u0006\u00105\u001a\u0002032\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0005H\u0002J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020\u001cH\u0002J\b\u0010B\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Ltv/danmaku/bili/antiaddiction/AntiAddictionConfig;", "", "<init>", "()V", "ANTI_ADDICTION_SP_NAME", "", "ANTI_ADDICTION_SP_KEY_TIME", "ANTI_ADDICTION_SP_KEY_TIME_BACKGROUND", "ANTI_ADDICTION_SP_FINAL_TIME", "ANTI_ADDICTION_NOTICE_SHOW_DATE", "ANTI_ADDICTION_NOTICE_VERSION_ID", "ANTI_ADDICTION_PUSH_MSG_SOURCE", ReportEvent.Tag.API, "Ltv/danmaku/bili/antiaddiction/AntiAddictionConfigService;", "preference", "Lcom/bilibili/lib/blkv/SharedPrefX;", "configRules", "Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules;", "heartBeatListener", "Lcom/bilibili/lib/heartbeat/HeartBeatReport$HeartBeatListener;", "KEY_TIME", "KEY_TIME_BACKGROUND", "FINAL_TIME", "NOTICE_SHOW_DATE", "NOTICE_VERSION_ID", "sleepRemindData", "Ltv/danmaku/bili/antiaddiction/data/SleepRemindData;", "initAntiAddictionConfig", "", "passportObserver", "Lcom/bilibili/lib/accounts/subscribe/PassportObserver;", "fetchAntiAddictionConfig", "getSleepRemindData", "sleepRemindMode", "data", "sleepRemind", "removeSleepRemindPushRunnable", "showSleepRemindPush", "startTime", "endTime", "sleepRemindPushRunnable", "Ljava/lang/Runnable;", "antiAddictionMode", "Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData;", "processAntiAddiction", "processAntiAddiction$antiaddiction_debug", "timeTriggerAntiAddition", "heartBeatInfo", "", "antiAddictionPreference", "interval", "", "maxDuration", "frequency", "version", "id", "timeTriggerAntiAddition$antiaddiction_debug", "showAlertPushMsg", "prefX", "pushMsg", "Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Control$Push$Message;", "verAndId", "sendPushMsg", "sleepRemindPushMsg", "Ltv/danmaku/bili/antiaddiction/data/Push;", "initBackgroundTime", "initSpKey", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AntiAddictionConfig {
    private static final String ANTI_ADDICTION_NOTICE_SHOW_DATE = "anti_addiction_notice_show_date";
    private static final String ANTI_ADDICTION_NOTICE_VERSION_ID = "anti_addiction_notice_ver";
    private static final String ANTI_ADDICTION_PUSH_MSG_SOURCE = "app_underage";
    private static final String ANTI_ADDICTION_SP_FINAL_TIME = "anti_addiction_time_final";
    private static final String ANTI_ADDICTION_SP_KEY_TIME = "anti_addiction_time";
    private static final String ANTI_ADDICTION_SP_KEY_TIME_BACKGROUND = "anti_addiction_time_background";
    private static final String ANTI_ADDICTION_SP_NAME = "anti_addiction_preference";
    private static String FINAL_TIME;
    public static final AntiAddictionConfig INSTANCE = new AntiAddictionConfig();
    private static String KEY_TIME;
    private static String KEY_TIME_BACKGROUND;
    private static String NOTICE_SHOW_DATE;
    private static String NOTICE_VERSION_ID;
    private static final AntiAddictionConfigService api;
    private static AddictionConfigData.Rules configRules;
    private static HeartBeatReport.HeartBeatListener heartBeatListener;
    private static final PassportObserver passportObserver;
    private static final SharedPrefX preference;
    private static SleepRemindData sleepRemindData;
    private static final Runnable sleepRemindPushRunnable;

    private AntiAddictionConfig() {
    }

    static {
        Object createService = ServiceGenerator.createService(AntiAddictionConfigService.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        api = (AntiAddictionConfigService) createService;
        Application application = BiliContext.application();
        preference = application != null ? BLKV.getBLSharedPreferences$default(application, ANTI_ADDICTION_SP_NAME, false, 0, 6, (Object) null) : null;
        KEY_TIME = "";
        KEY_TIME_BACKGROUND = "";
        FINAL_TIME = "";
        NOTICE_SHOW_DATE = "";
        NOTICE_VERSION_ID = "";
        passportObserver = new PassportObserver() { // from class: tv.danmaku.bili.antiaddiction.AntiAddictionConfig$$ExternalSyntheticLambda0
            public final void onChange(Topic topic) {
                AntiAddictionConfig.passportObserver$lambda$0(topic);
            }
        };
        sleepRemindPushRunnable = new Runnable() { // from class: tv.danmaku.bili.antiaddiction.AntiAddictionConfig$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AntiAddictionConfig.sleepRemindPushRunnable$lambda$0();
            }
        };
    }

    public final void initAntiAddictionConfig() {
        BiliAccounts.get(BiliContext.application()).subscribe(passportObserver, new Topic[]{Topic.SIGN_IN, Topic.SIGN_OUT});
        fetchAntiAddictionConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void passportObserver$lambda$0(Topic it) {
        if (it == Topic.SIGN_IN) {
            INSTANCE.fetchAntiAddictionConfig();
        } else if (it == Topic.SIGN_OUT) {
            HeartBeatReport heartBeatReport = HeartBeatReport.INSTANCE;
            HeartBeatReport.HeartBeatListener heartBeatListener2 = heartBeatListener;
            if (heartBeatListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("heartBeatListener");
                heartBeatListener2 = null;
            }
            heartBeatReport.unregisterHeartBeatListener(heartBeatListener2);
        }
    }

    private final void fetchAntiAddictionConfig() {
        api.getAntiAddictionStatus().enqueue(new BiliApiDataCallback<AntiAddictionStatusData>() { // from class: tv.danmaku.bili.antiaddiction.AntiAddictionConfig$fetchAntiAddictionConfig$1
            public void onDataSuccess(AntiAddictionStatusData data) {
                AntiAddictionConfig.INSTANCE.sleepRemindMode(data != null ? data.getSleepRemind() : null);
                AntiAddictionConfig.INSTANCE.antiAddictionMode(data != null ? data.getAntiAddiction() : null);
            }

            public void onError(Throwable t) {
                if (t != null) {
                    t.printStackTrace();
                }
            }
        });
        heartBeatListener = new HeartBeatReport.HeartBeatListener() { // from class: tv.danmaku.bili.antiaddiction.AntiAddictionConfig$fetchAntiAddictionConfig$2
            public void onHeartBeat(Map<String, String> map) {
                AddictionConfigData.Rules rules;
                SharedPrefX sharedPrefX;
                SharedPrefX sharedPrefX2;
                AddictionConfigData.Rules rules2;
                AddictionConfigData.Rules rules3;
                AddictionConfigData.Rules rules4;
                AddictionConfigData.Rules.Conditions.Series series;
                AddictionConfigData.Rules.Conditions.Series series2;
                Intrinsics.checkNotNullParameter(map, "params");
                super.onHeartBeat(map);
                if (!map.isEmpty()) {
                    rules = AntiAddictionConfig.configRules;
                    AddictionConfigData.Rules rules5 = null;
                    if (rules == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("configRules");
                        rules = null;
                    }
                    List<AddictionConfigData.Rules.Conditions> conditions = rules.getConditions();
                    AddictionConfigData.Rules.Conditions conditions2 = conditions != null ? (AddictionConfigData.Rules.Conditions) CollectionsKt.firstOrNull(conditions) : null;
                    sharedPrefX = AntiAddictionConfig.preference;
                    if (sharedPrefX != null) {
                        if ((conditions2 != null ? conditions2.getSeries() : null) != null) {
                            if (((conditions2 == null || (series2 = conditions2.getSeries()) == null) ? null : Integer.valueOf(series2.getInterval())) != null) {
                                if (((conditions2 == null || (series = conditions2.getSeries()) == null) ? null : Integer.valueOf(series.getMaxDuration())) != null) {
                                    AntiAddictionConfig antiAddictionConfig = AntiAddictionConfig.INSTANCE;
                                    sharedPrefX2 = AntiAddictionConfig.preference;
                                    AddictionConfigData.Rules.Conditions.Series series3 = conditions2.getSeries();
                                    Integer valueOf = series3 != null ? Integer.valueOf(series3.getInterval()) : null;
                                    Intrinsics.checkNotNull(valueOf);
                                    int intValue = valueOf.intValue();
                                    AddictionConfigData.Rules.Conditions.Series series4 = conditions2.getSeries();
                                    Integer valueOf2 = series4 != null ? Integer.valueOf(series4.getMaxDuration()) : null;
                                    Intrinsics.checkNotNull(valueOf2);
                                    int intValue2 = valueOf2.intValue();
                                    rules2 = AntiAddictionConfig.configRules;
                                    if (rules2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("configRules");
                                        rules2 = null;
                                    }
                                    int frequency = rules2.getFrequency();
                                    rules3 = AntiAddictionConfig.configRules;
                                    if (rules3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("configRules");
                                        rules3 = null;
                                    }
                                    String version = rules3.getVersion();
                                    rules4 = AntiAddictionConfig.configRules;
                                    if (rules4 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("configRules");
                                    } else {
                                        rules5 = rules4;
                                    }
                                    antiAddictionConfig.timeTriggerAntiAddition$antiaddiction_debug(map, sharedPrefX2, intValue, intValue2, frequency, version, rules5.getId());
                                }
                            }
                        }
                    }
                }
            }
        };
    }

    public final SleepRemindData getSleepRemindData() {
        return sleepRemindData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sleepRemindMode(SleepRemindData data) {
        sleepRemindData = data;
        if (data != null) {
            SleepRemindUtil.INSTANCE.setSleepRemindSwitch(data.getSwitch());
            String start = data.getStartTime();
            if (start != null) {
                SleepRemindUtil.INSTANCE.setSleepRemindStartTime(start);
            }
            String end = data.getEndTime();
            if (end != null) {
                SleepRemindUtil.INSTANCE.setSleepRemindEndTime(end);
            }
        }
        sleepRemind(data);
    }

    private final void sleepRemind(SleepRemindData data) {
        boolean z = true;
        if (data != null && data.getSwitch()) {
            String startTime = data.getStartTime();
            String endTime = data.getEndTime();
            String str = startTime;
            if (str == null || StringsKt.isBlank(str)) {
                return;
            }
            String str2 = endTime;
            if (str2 != null && !StringsKt.isBlank(str2)) {
                z = false;
            }
            if (!z) {
                showSleepRemindPush(startTime, endTime);
                return;
            }
            return;
        }
        SleepRemindUtil.INSTANCE.setSleepRemindPushShow(false);
    }

    public final void removeSleepRemindPushRunnable() {
        HandlerThreads.remove(0, sleepRemindPushRunnable);
    }

    public final void showSleepRemindPush(String startTime, String endTime) {
        int currentTimeExtraSecond;
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Date currentDate = new Date();
        String currentTime = SleepRemindUtil.INSTANCE.getSleepRemindFormat().format(currentDate);
        try {
            String format = SleepRemindUtil.INSTANCE.getCurrentExtraSecondFormat().format(currentDate);
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            int currentTimeExtraSecond2 = Integer.parseInt(format) * 1000;
            currentTimeExtraSecond = currentTimeExtraSecond2;
        } catch (NumberFormatException e) {
            currentTimeExtraSecond = 0;
        }
        SleepRemindUtil sleepRemindUtil = SleepRemindUtil.INSTANCE;
        Intrinsics.checkNotNull(currentTime);
        sleepRemindUtil.isClearSleepRemindPushFlag(startTime, endTime, currentTime);
        if (!SleepRemindUtil.INSTANCE.getSleepRemindPushShow()) {
            HandlerThreads.postDelayed(0, sleepRemindPushRunnable, SleepRemindUtil.showPushLeftTime$default(SleepRemindUtil.INSTANCE, startTime, endTime, currentTime, currentTimeExtraSecond, false, 16, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sleepRemindPushRunnable$lambda$0() {
        Push it;
        SleepRemindData sleepRemindData2 = sleepRemindData;
        if (sleepRemindData2 == null || (it = sleepRemindData2.getPush()) == null || !SleepRemindUtil.INSTANCE.finallyCheckValidBeforePush()) {
            return;
        }
        INSTANCE.sleepRemindPushMsg(it);
        SleepRemindUtil.INSTANCE.setSleepRemindPushShow(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void antiAddictionMode(AddictionConfigData data) {
        if (!BiliAccounts.get(BiliContext.application()).isLogin()) {
            return;
        }
        initSpKey();
        if (data != null) {
            INSTANCE.processAntiAddiction$antiaddiction_debug(data);
        }
    }

    public final void processAntiAddiction$antiaddiction_debug(AddictionConfigData data) {
        SharedPrefX sharedPrefX;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putLong;
        AddictionConfigData.Rules.Conditions conditions;
        AddictionConfigData.Rules.Conditions conditions2;
        AddictionConfigData.Rules.Conditions conditions3;
        Intrinsics.checkNotNullParameter(data, "data");
        AntiAddictionConfig $this$processAntiAddiction_u24lambda_u240 = this;
        Iterable rules = data.getRules();
        if (rules == null) {
            return;
        }
        Iterable $this$forEach$iv = rules;
        Iterator<T> it = $this$forEach$iv.iterator();
        if (it.hasNext()) {
            Object element$iv = it.next();
            AddictionConfigData.Rules rule = (AddictionConfigData.Rules) element$iv;
            List<AddictionConfigData.Rules.Conditions> conditions4 = rule.getConditions();
            if (conditions4 == null || conditions4.isEmpty()) {
                return;
            }
            List<AddictionConfigData.Rules.Conditions> conditions5 = rule.getConditions();
            if (((conditions5 == null || (conditions3 = (AddictionConfigData.Rules.Conditions) CollectionsKt.firstOrNull(conditions5)) == null) ? null : conditions3.getSeries()) == null) {
                return;
            }
            configRules = rule;
            SharedPrefX sharedPrefX2 = preference;
            Long lastSaveTime = sharedPrefX2 != null ? Long.valueOf(sharedPrefX2.getLong(FINAL_TIME, System.currentTimeMillis())) : null;
            if (lastSaveTime != null) {
                long it2 = lastSaveTime.longValue();
                long processInterval = System.currentTimeMillis() - it2;
                long savedBackgroundTime = 0;
                if (preference != null) {
                    savedBackgroundTime = preference.getLong(KEY_TIME_BACKGROUND, 0L);
                }
                AddictionConfigData.Rules rules2 = configRules;
                if (rules2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("configRules");
                    rules2 = null;
                }
                List<AddictionConfigData.Rules.Conditions> conditions6 = rules2.getConditions();
                if (((conditions6 == null || (conditions2 = (AddictionConfigData.Rules.Conditions) CollectionsKt.firstOrNull(conditions6)) == null) ? null : conditions2.getSeries()) != null) {
                    long j = (processInterval + savedBackgroundTime) / 1000;
                    AddictionConfigData.Rules rules3 = configRules;
                    if (rules3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("configRules");
                        rules3 = null;
                    }
                    List<AddictionConfigData.Rules.Conditions> conditions7 = rules3.getConditions();
                    AddictionConfigData.Rules.Conditions.Series series = (conditions7 == null || (conditions = (AddictionConfigData.Rules.Conditions) CollectionsKt.firstOrNull(conditions7)) == null) ? null : conditions.getSeries();
                    Intrinsics.checkNotNull(series);
                    if (j >= series.getInterval() && (sharedPrefX = preference) != null && (edit = sharedPrefX.edit()) != null && (putLong = edit.putLong(KEY_TIME, 0L)) != null) {
                        putLong.apply();
                    }
                }
            }
            $this$processAntiAddiction_u24lambda_u240.initBackgroundTime();
            HeartBeatReport heartBeatReport = HeartBeatReport.INSTANCE;
            HeartBeatReport.HeartBeatListener heartBeatListener2 = heartBeatListener;
            if (heartBeatListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("heartBeatListener");
                heartBeatListener2 = null;
            }
            heartBeatReport.registerHeartBeatListener(heartBeatListener2);
        }
    }

    public final void timeTriggerAntiAddition$antiaddiction_debug(Map<String, String> map, final SharedPrefX antiAddictionPreference, int interval, int maxDuration, final int frequency, final String version, final int id) {
        Intrinsics.checkNotNullParameter(map, "heartBeatInfo");
        Intrinsics.checkNotNullParameter(antiAddictionPreference, "antiAddictionPreference");
        Intrinsics.checkNotNullParameter(version, "version");
        if (!RestrictedMode.isRestrictedMode() && BiliAccounts.get(BiliContext.application()).isLogin()) {
            antiAddictionPreference.edit().putLong(FINAL_TIME, System.currentTimeMillis()).apply();
            Integer valueOf = Integer.valueOf(map.get("interval"));
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
            int heartBeatInterval = valueOf.intValue();
            if (Intrinsics.areEqual("1", map.get("foreground"))) {
                long time = antiAddictionPreference.getLong(KEY_TIME, 0L) + heartBeatInterval;
                antiAddictionPreference.edit().putLong(KEY_TIME, time).apply();
                antiAddictionPreference.edit().putLong(KEY_TIME_BACKGROUND, 0L).apply();
                if (time / 1000 >= maxDuration) {
                    api.getConfigData().enqueue(new BiliApiDataCallback<AddictionConfigData>() { // from class: tv.danmaku.bili.antiaddiction.AntiAddictionConfig$timeTriggerAntiAddition$1
                        public void onDataSuccess(AddictionConfigData data) {
                            Iterable rules;
                            AddictionConfigData.Rules rules2;
                            AddictionConfigData.Rules.Control.Push push;
                            AddictionConfigData.Rules.Control.Push.Message it;
                            AddictionConfigData.Rules.Control.Push push2;
                            AddictionConfigData.Rules.Control.Push.Message it2;
                            int i = id;
                            String str = version;
                            SharedPrefX sharedPrefX = antiAddictionPreference;
                            int i2 = frequency;
                            if (data == null || (rules = data.getRules()) == null) {
                                return;
                            }
                            Iterable $this$forEach$iv = rules;
                            Iterator<T> it3 = $this$forEach$iv.iterator();
                            if (it3.hasNext()) {
                                Object element$iv = it3.next();
                                AddictionConfigData.Rules rule = (AddictionConfigData.Rules) element$iv;
                                List<AddictionConfigData.Rules.Conditions> conditions = rule.getConditions();
                                AddictionConfigData.Rules rules3 = null;
                                if ((conditions != null ? (AddictionConfigData.Rules.Conditions) CollectionsKt.firstOrNull(conditions) : null) == null) {
                                    rules2 = AntiAddictionConfig.configRules;
                                    if (rules2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("configRules");
                                    } else {
                                        rules3 = rules2;
                                    }
                                    AddictionConfigData.Rules.Control control = rules3.getControl();
                                    if (control != null && (push = control.getPush()) != null && (it = push.getMessage()) != null) {
                                        AntiAddictionConfig.INSTANCE.showAlertPushMsg(sharedPrefX, i2, it, rule.getVersion() + rule.getId());
                                    }
                                } else if (i == rule.getId() && Intrinsics.areEqual(str, rule.getVersion())) {
                                    AddictionConfigData.Rules.Control control2 = rule.getControl();
                                    if (control2 != null && (push2 = control2.getPush()) != null && (it2 = push2.getMessage()) != null) {
                                        AntiAddictionConfig.INSTANCE.showAlertPushMsg(sharedPrefX, i2, it2, rule.getVersion() + rule.getId());
                                    }
                                } else {
                                    AntiAddictionConfig antiAddictionConfig = AntiAddictionConfig.INSTANCE;
                                    AntiAddictionConfig.configRules = rule;
                                }
                            }
                        }

                        public void onError(Throwable t) {
                            AddictionConfigData.Rules rules;
                            AddictionConfigData.Rules.Control.Push push;
                            AddictionConfigData.Rules.Control.Push.Message it;
                            AddictionConfigData.Rules rules2;
                            AddictionConfigData.Rules rules3;
                            if (t != null) {
                                t.printStackTrace();
                            }
                            rules = AntiAddictionConfig.configRules;
                            AddictionConfigData.Rules rules4 = null;
                            if (rules == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("configRules");
                                rules = null;
                            }
                            AddictionConfigData.Rules.Control control = rules.getControl();
                            if (control != null && (push = control.getPush()) != null && (it = push.getMessage()) != null) {
                                SharedPrefX sharedPrefX = antiAddictionPreference;
                                int i = frequency;
                                AntiAddictionConfig antiAddictionConfig = AntiAddictionConfig.INSTANCE;
                                rules2 = AntiAddictionConfig.configRules;
                                if (rules2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("configRules");
                                    rules2 = null;
                                }
                                String version2 = rules2.getVersion();
                                rules3 = AntiAddictionConfig.configRules;
                                if (rules3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("configRules");
                                } else {
                                    rules4 = rules3;
                                }
                                antiAddictionConfig.showAlertPushMsg(sharedPrefX, i, it, version2 + rules4.getId());
                            }
                        }
                    });
                    return;
                }
                return;
            }
            long timeBackground = antiAddictionPreference.getLong(KEY_TIME_BACKGROUND, 0L) + heartBeatInterval;
            antiAddictionPreference.edit().putLong(KEY_TIME_BACKGROUND, timeBackground).apply();
            if (timeBackground / 1000 >= interval) {
                antiAddictionPreference.edit().putLong(KEY_TIME, 0L).apply();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAlertPushMsg(SharedPrefX prefX, int frequency, AddictionConfigData.Rules.Control.Push.Message pushMsg, String verAndId) {
        long date = prefX.getLong(NOTICE_SHOW_DATE, 0L);
        String storageVerAndId = prefX.getString(NOTICE_VERSION_ID, "");
        long today = new Date().getTime();
        if (frequency == 0 || ((frequency != 0 && !Intrinsics.areEqual(storageVerAndId, verAndId)) || (frequency != 0 && !DateUtils.isSameDay(new Date(today), new Date(date))))) {
            String title = pushMsg.getTitle();
            if (title == null || StringsKt.isBlank(title)) {
                return;
            }
            sendPushMsg(pushMsg);
            if (!RestrictedMode.isRestrictedMode()) {
                prefX.edit().putLong(KEY_TIME, 0L).apply();
                prefX.edit().putLong(NOTICE_SHOW_DATE, today).apply();
            }
            prefX.edit().putString(NOTICE_VERSION_ID, verAndId).apply();
        }
    }

    private final void sendPushMsg(AddictionConfigData.Rules.Control.Push.Message pushMsg) {
        ISendPushMessage iSendPushMessage = (ISendPushMessage) BLRouter.INSTANCE.getServices(ISendPushMessage.class).get(MineReporter.MINE_ICON_TYPE_DEFAULT);
        if (iSendPushMessage != null) {
            String title = pushMsg.getTitle();
            String summary = pushMsg.getSummary();
            String img = pushMsg.getImg();
            iSendPushMessage.sendPushMessage(new InnerPush(0, 0, title, summary, (String) null, pushMsg.getDuration(), pushMsg.getExpire(), img, String.valueOf(System.currentTimeMillis()), 0, (String) null, 0, (List) null, (List) null, (BizParams) null, 0, 0, System.currentTimeMillis(), ANTI_ADDICTION_PUSH_MSG_SOURCE, pushMsg.getHideArrow(), 0, MapsKt.mapOf(TuplesKt.to("rule_id", "3")), 0, 0, false, 0L, (String) null, 0, 265420307, (DefaultConstructorMarker) null));
        }
    }

    private final void sleepRemindPushMsg(Push pushMsg) {
        long expireTimeSecond = (System.currentTimeMillis() / 1000) + 5;
        ISendPushMessage iSendPushMessage = (ISendPushMessage) BLRouter.INSTANCE.getServices(ISendPushMessage.class).get(MineReporter.MINE_ICON_TYPE_DEFAULT);
        if (iSendPushMessage != null) {
            String title = pushMsg.getTitle();
            String summary = pushMsg.getSummary();
            String img = pushMsg.getImg();
            iSendPushMessage.sendPushMessage(new InnerPush(0, 0, title, summary, pushMsg.getLink(), pushMsg.getDuration(), expireTimeSecond, img, String.valueOf(System.currentTimeMillis()), 0, (String) null, 0, (List) null, (List) null, (BizParams) null, 0, 0, System.currentTimeMillis(), pushMsg.getMsg_source(), pushMsg.getHide_arrow(), 0, MapsKt.mapOf(TuplesKt.to("rule_id", "3")), 0, 0, false, 0L, (String) null, 0, 265420291, (DefaultConstructorMarker) null));
        }
    }

    private final void initBackgroundTime() {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putLong;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor putLong2;
        SharedPrefX sharedPrefX = preference;
        if (sharedPrefX != null && (edit2 = sharedPrefX.edit()) != null && (putLong2 = edit2.putLong(KEY_TIME_BACKGROUND, 0L)) != null) {
            putLong2.apply();
        }
        SharedPrefX sharedPrefX2 = preference;
        if (sharedPrefX2 != null && (edit = sharedPrefX2.edit()) != null && (putLong = edit.putLong(FINAL_TIME, System.currentTimeMillis())) != null) {
            putLong.apply();
        }
    }

    private final void initSpKey() {
        KEY_TIME = ANTI_ADDICTION_SP_KEY_TIME + BiliAccounts.get(BiliContext.application()).mid();
        KEY_TIME_BACKGROUND = ANTI_ADDICTION_SP_KEY_TIME_BACKGROUND + BiliAccounts.get(BiliContext.application()).mid();
        FINAL_TIME = ANTI_ADDICTION_SP_FINAL_TIME + BiliAccounts.get(BiliContext.application()).mid();
        NOTICE_SHOW_DATE = ANTI_ADDICTION_NOTICE_SHOW_DATE + BiliAccounts.get(BiliContext.application()).mid();
        NOTICE_VERSION_ID = ANTI_ADDICTION_NOTICE_VERSION_ID + BiliAccounts.get(BiliContext.application()).mid();
    }
}