package tv.danmaku.bili.ui.main.event;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bapis.bilibili.broadcast.message.main.ResourceMoss;
import com.bapis.bilibili.broadcast.message.main.TopActivityReply;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.badge.Badge;
import com.bilibili.lib.badge.BadgeManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.homepage.util.BottomTabSelectedHelper;
import com.bilibili.lib.homepage.util.UriUtils;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.okretro.ServiceGenerator;
import com.google.protobuf.Empty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.DigitsUtil;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.ui.garb.model.GarbData;
import tv.danmaku.bili.ui.main.event.model.EventEntranceModel;
import tv.danmaku.bili.ui.main2.MainFragment;
import tv.danmaku.bili.ui.main2.event.EventMenuAction;

/* compiled from: EventEntranceHelper.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u0016H\u0007J\u001a\u0010\u001a\u001a\u00020\u00162\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0007J\u0006\u0010\u001c\u001a\u00020\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0007J\u0006\u0010\u001e\u001a\u00020\u0012J\b\u0010\u001f\u001a\u00020\u0016H\u0007J\b\u0010 \u001a\u00020\u0016H\u0002J\u0014\u0010!\u001a\u0004\u0018\u00010\n2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010'\u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020\u0016H\u0007J\u0018\u0010)\u001a\u00020\u00162\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0007J\b\u0010*\u001a\u00020\u0016H\u0007J\b\u0010+\u001a\u00020\fH\u0007J\b\u0010,\u001a\u00020\u0005H\u0002J\u0010\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\f2\u0006\u0010.\u001a\u00020/H\u0007J\u0010\u00101\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/H\u0007J\u0010\u00102\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/H\u0007J\b\u00103\u001a\u00020\u0016H\u0002J\b\u00104\u001a\u00020\u0016H\u0007J\b\u00105\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Ltv/danmaku/bili/ui/main/event/EventEntranceHelper;", "", "<init>", "()V", "PREF_KEY_ANIM_SHOW_TIMES", "", EventEntranceHelper.PREF_KEY_ENTRANCE_CACHE, "ANIM_NAME", "TAG", "entranceInfo", "Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel;", "isChanged", "", "animExecuted", "isChecked", "needUpdate", "mHasInitBroadcast", "mLastLoopInterval", "", "Ljava/lang/Long;", "mListener", "Lkotlin/Function0;", "", "mApi", "Ltv/danmaku/bili/ui/main/event/EventEntranceApi;", "init", "checkActivityEntrance", "listener", "saveCache", "initCache", "getInterval", "initBroadcast", GarbData.ColorDetail.LOOP_ANIMATE, "mapping", "value", "Lcom/bapis/bilibili/broadcast/message/main/TopActivityReply;", "loopCheckRunnable", "Ljava/lang/Runnable;", "loopCheck", "isMain", "showRetDot", "registerListener", "unregisterListener", "hasEntrance", "getAnimShowTimeKey", "checkAnim", "context", "Landroid/content/Context;", "animValid", "onAnimShow", "onEntranceClick", "reportEntranceClick", "reportEntranceShow", "reportEntranceAnimShow", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class EventEntranceHelper {
    public static final int $stable;
    private static final String ANIM_NAME = "activity_entrance_menu_anim";
    private static final String PREF_KEY_ANIM_SHOW_TIMES = "fission.activity_entrance_show_times";
    private static final String PREF_KEY_ENTRANCE_CACHE = "PREF_KEY_ENTRANCE_CACHE";
    private static final String TAG = "EventEntranceHelper";
    public static boolean animExecuted;
    public static EventEntranceModel entranceInfo;
    public static boolean isChanged;
    public static boolean isChecked;
    private static final Runnable loopCheckRunnable;
    private static final EventEntranceApi mApi;
    private static boolean mHasInitBroadcast;
    private static Function0<Unit> mListener;
    public static boolean needUpdate;
    public static final EventEntranceHelper INSTANCE = new EventEntranceHelper();
    private static Long mLastLoopInterval = -1L;

    private EventEntranceHelper() {
    }

    static {
        Object createService = ServiceGenerator.createService(EventEntranceApi.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        mApi = (EventEntranceApi) createService;
        loopCheckRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                EventEntranceHelper.loopCheckRunnable$lambda$0();
            }
        };
        $stable = 8;
    }

    @JvmStatic
    public static final void init() {
        if (RestrictedMode.isRestrictedMode()) {
            return;
        }
        BLog.i(TAG, "init");
        initCache();
        initBroadcast();
        checkActivityEntrance$default(null, 1, null);
    }

    public static /* synthetic */ void checkActivityEntrance$default(Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        checkActivityEntrance(function0);
    }

    @JvmStatic
    public static final void checkActivityEntrance(Function0<Unit> function0) {
        if (RestrictedMode.isRestrictedMode() || Intrinsics.areEqual(ConfigManager.Companion.ab().get("activity.home.entrance.request", true), false)) {
            return;
        }
        BLog.i(TAG, "checkActivityEntrance");
        mApi.fetchTopEventEntrance().enqueue(new EventEntranceHelper$checkActivityEntrance$1(function0));
    }

    public final void saveCache() {
        EventEntranceModel eventEntranceModel = entranceInfo;
        BLog.i(TAG, "save cache: " + (eventEntranceModel != null ? eventEntranceModel.toString() : null));
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        SharedPreferences sp = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        if (entranceInfo == null) {
            sp.edit().putString(PREF_KEY_ENTRANCE_CACHE, "").apply();
            return;
        }
        String string = JSONObject.toJSONString(entranceInfo);
        sp.edit().putString(PREF_KEY_ENTRANCE_CACHE, string).apply();
    }

    @JvmStatic
    public static final void initCache() {
        Application context;
        EventEntranceModel data;
        EventEntranceModel eventEntranceModel;
        EventEntranceModel.Online online;
        if (RestrictedMode.isRestrictedMode() || Intrinsics.areEqual(ConfigManager.Companion.ab().get("activity.home.entrance.request", true), false) || (context = BiliContext.application()) == null) {
            return;
        }
        SharedPreferences sp = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        String string = sp.getString(PREF_KEY_ENTRANCE_CACHE, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                data = (EventEntranceModel) JSONObject.parseObject(string, EventEntranceModel.class);
            } catch (Exception e) {
                BLog.e(TAG, "read cache error", e);
                data = null;
            }
            if (data != null) {
                entranceInfo = data;
                EventEntranceModel eventEntranceModel2 = entranceInfo;
                mLastLoopInterval = (eventEntranceModel2 == null || (online = eventEntranceModel2.getOnline()) == null) ? null : online.getInterval();
                BLog.i(TAG, "read cache :" + (entranceInfo != null ? eventEntranceModel.toString() : null));
                animExecuted = true;
            }
        }
    }

    public final long getInterval() {
        Long l = mLastLoopInterval;
        if ((l != null ? l.longValue() : -1L) < 0) {
            return DigitsUtil.parseLong((CharSequence) Contract.-CC.get$default(ConfigManager.Companion.config(), "activity.home_entrance_loop_interval", (Object) null, 2, (Object) null)) * 1000;
        }
        Long l2 = mLastLoopInterval;
        return (l2 != null ? l2.longValue() : 0L) * 1000;
    }

    @JvmStatic
    public static final void initBroadcast() {
        if (RestrictedMode.isRestrictedMode() || mHasInitBroadcast || Intrinsics.areEqual(false, ConfigManager.Companion.ab().get("activity.home.entrance.broadcast", true))) {
            return;
        }
        BLog.i(TAG, "init broadcast");
        mHasInitBroadcast = true;
        ResourceMoss resourceMoss = new ResourceMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
        Empty build = Empty.newBuilder().build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        resourceMoss.topActivity(build, new EventEntranceHelper$initBroadcast$1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loop() {
        long interval = getInterval();
        BLog.i(TAG, "loop interval = " + interval);
        if (interval > 0) {
            HandlerThreads.remove(0, loopCheckRunnable);
            HandlerThreads.postDelayed(0, loopCheckRunnable, interval);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventEntranceModel mapping(TopActivityReply value) {
        if (value != null) {
            EventEntranceModel model = new EventEntranceModel();
            model.setHash(value.getHash());
            if (value.getOnline() != null) {
                model.setOnline(new EventEntranceModel.Online());
                EventEntranceModel.Online online = model.getOnline();
                Intrinsics.checkNotNull(online);
                online.setIcon(value.getOnline().getIcon());
                EventEntranceModel.Online online2 = model.getOnline();
                Intrinsics.checkNotNull(online2);
                online2.setInterval(Long.valueOf(value.getOnline().getInterval()));
                EventEntranceModel.Online online3 = model.getOnline();
                Intrinsics.checkNotNull(online3);
                online3.setName(value.getOnline().getName());
                EventEntranceModel.Online online4 = model.getOnline();
                Intrinsics.checkNotNull(online4);
                online4.setUri(value.getOnline().getUri());
                EventEntranceModel.Online online5 = model.getOnline();
                Intrinsics.checkNotNull(online5);
                online5.setUniqueId(value.getOnline().getUniqueId());
                EventEntranceModel.Online online6 = model.getOnline();
                Intrinsics.checkNotNull(online6);
                online6.setType(Integer.valueOf(value.getOnline().getType()));
                if (value.getOnline().getAnimate() != null) {
                    EventEntranceModel.Online online7 = model.getOnline();
                    Intrinsics.checkNotNull(online7);
                    online7.setAnimate(new EventEntranceModel.Animate());
                    EventEntranceModel.Online online8 = model.getOnline();
                    Intrinsics.checkNotNull(online8);
                    EventEntranceModel.Animate animate = online8.getAnimate();
                    Intrinsics.checkNotNull(animate);
                    animate.setIcon(value.getOnline().getAnimate().getIcon());
                    EventEntranceModel.Online online9 = model.getOnline();
                    Intrinsics.checkNotNull(online9);
                    EventEntranceModel.Animate animate2 = online9.getAnimate();
                    Intrinsics.checkNotNull(animate2);
                    animate2.setLoop(value.getOnline().getAnimate().getLoop());
                    EventEntranceModel.Online online10 = model.getOnline();
                    Intrinsics.checkNotNull(online10);
                    EventEntranceModel.Animate animate3 = online10.getAnimate();
                    Intrinsics.checkNotNull(animate3);
                    animate3.setJson(value.getOnline().getAnimate().getJson());
                    EventEntranceModel.Online online11 = model.getOnline();
                    Intrinsics.checkNotNull(online11);
                    EventEntranceModel.Animate animate4 = online11.getAnimate();
                    Intrinsics.checkNotNull(animate4);
                    animate4.setSvg(value.getOnline().getAnimate().getSvg());
                }
                if (value.getOnline().getRedDot() != null) {
                    EventEntranceModel.Online online12 = model.getOnline();
                    Intrinsics.checkNotNull(online12);
                    online12.setRedDot(new EventEntranceModel.RedDot());
                    EventEntranceModel.Online online13 = model.getOnline();
                    Intrinsics.checkNotNull(online13);
                    EventEntranceModel.RedDot redDot = online13.getRedDot();
                    Intrinsics.checkNotNull(redDot);
                    redDot.setNumber(value.getOnline().getRedDot().getNumber());
                    EventEntranceModel.Online online14 = model.getOnline();
                    Intrinsics.checkNotNull(online14);
                    EventEntranceModel.RedDot redDot2 = online14.getRedDot();
                    Intrinsics.checkNotNull(redDot2);
                    redDot2.setType(value.getOnline().getRedDot().getType());
                }
            }
            return model;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loopCheckRunnable$lambda$0() {
        INSTANCE.loopCheck();
    }

    private final void loopCheck() {
        if (isMain()) {
            checkActivityEntrance(new Function0() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit loopCheck$lambda$0;
                    loopCheck$lambda$0 = EventEntranceHelper.loopCheck$lambda$0();
                    return loopCheck$lambda$0;
                }
            });
            return;
        }
        needUpdate = true;
        BLog.i(TAG, "back to main need update");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loopCheck$lambda$0() {
        if ((BiliContext.topActivitiy() instanceof MainActivityV2) && isChanged) {
            Activity activity = BiliContext.topActivitiy();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type tv.danmaku.bili.MainActivityV2");
            MainActivityV2 activityV2 = (MainActivityV2) activity;
            MainFragment mainFragment = activityV2.getMainFragment();
            if (mainFragment != null) {
                mainFragment.updateEntranceMenu(0);
            }
            BLog.i(TAG, "time to update top menu");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMain() {
        return (BiliContext.topActivitiy() instanceof MainActivityV2) && UriUtils.equals(BottomTabSelectedHelper.INSTANCE.getCurrentBottomTabUrl(), "bilibili://main/home");
    }

    @JvmStatic
    public static final void showRetDot() {
        EventEntranceModel.Online online;
        EventEntranceModel eventEntranceModel = entranceInfo;
        EventEntranceModel.RedDot redDot = (eventEntranceModel == null || (online = eventEntranceModel.getOnline()) == null) ? null : online.getRedDot();
        boolean z = true;
        if (redDot != null && redDot.getType() == 1) {
            BadgeManager.getInstance().update(EventMenuAction.ACTION, Badge.obtainMole());
            return;
        }
        if (redDot == null || redDot.getType() != 2) {
            z = false;
        }
        if (z && redDot.getNumber() > 0) {
            BadgeManager.getInstance().update(EventMenuAction.ACTION, Badge.obtainNumber(redDot.getNumber()));
        }
    }

    @JvmStatic
    public static final void registerListener(Function0<Unit> function0) {
        mListener = function0;
    }

    @JvmStatic
    public static final void unregisterListener() {
        mListener = null;
    }

    @JvmStatic
    public static final boolean hasEntrance() {
        if (entranceInfo != null) {
            EventEntranceModel eventEntranceModel = entranceInfo;
            Intrinsics.checkNotNull(eventEntranceModel);
            if (eventEntranceModel.checkParams() && !RestrictedMode.isRestrictedMode()) {
                return true;
            }
        }
        return false;
    }

    private final String getAnimShowTimeKey() {
        EventEntranceModel.Online online;
        EventEntranceModel.Online online2;
        EventEntranceModel eventEntranceModel = entranceInfo;
        String str = null;
        String uniqueId = (eventEntranceModel == null || (online2 = eventEntranceModel.getOnline()) == null) ? null : online2.getUniqueId();
        EventEntranceModel eventEntranceModel2 = entranceInfo;
        if (eventEntranceModel2 != null && (online = eventEntranceModel2.getOnline()) != null) {
            str = online.getName();
        }
        return PREF_KEY_ANIM_SHOW_TIMES + uniqueId + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkAnim(Context context) {
        EventEntranceModel.Online online;
        EventEntranceModel.Animate animate;
        EventEntranceModel.Online online2;
        EventEntranceModel.Animate animate2;
        EventEntranceModel eventEntranceModel = entranceInfo;
        if (((eventEntranceModel == null || (online2 = eventEntranceModel.getOnline()) == null || (animate2 = online2.getAnimate()) == null) ? 0 : animate2.getLoop()) == 0) {
            return true;
        }
        int currentTimes = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getInt(getAnimShowTimeKey(), 0);
        EventEntranceModel eventEntranceModel2 = entranceInfo;
        return currentTimes < ((eventEntranceModel2 == null || (online = eventEntranceModel2.getOnline()) == null || (animate = online.getAnimate()) == null) ? 0 : animate.getLoop());
    }

    @JvmStatic
    public static final boolean animValid(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.checkAnim(context);
    }

    @JvmStatic
    public static final void onAnimShow(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sp = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        int times = sp.getInt(INSTANCE.getAnimShowTimeKey(), 0);
        sp.edit().putInt(INSTANCE.getAnimShowTimeKey(), times + 1).apply();
        INSTANCE.reportEntranceAnimShow();
    }

    @JvmStatic
    public static final void onEntranceClick(Context context) {
        EventEntranceModel.Online online;
        EventEntranceModel.Animate animate;
        EventEntranceModel.Online online2;
        EventEntranceModel.Online online3;
        EventEntranceModel.Online online4;
        Intrinsics.checkNotNullParameter(context, "context");
        EventEntranceModel eventEntranceModel = entranceInfo;
        BLog.i(TAG, "onClick : " + ((eventEntranceModel == null || (online4 = eventEntranceModel.getOnline()) == null) ? null : online4.toString()));
        BadgeManager.getInstance().update(EventMenuAction.ACTION, Badge.NONE);
        EventEntranceModel eventEntranceModel2 = entranceInfo;
        EventEntranceModel.RedDot redDot = (eventEntranceModel2 == null || (online3 = eventEntranceModel2.getOnline()) == null) ? null : online3.getRedDot();
        EventEntranceModel eventEntranceModel3 = entranceInfo;
        if (eventEntranceModel3 != null && (online2 = eventEntranceModel3.getOnline()) != null) {
            online2.setRedDot(null);
        }
        if (redDot != null) {
            INSTANCE.saveCache();
        }
        SharedPreferences.Editor edit = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit();
        String animShowTimeKey = INSTANCE.getAnimShowTimeKey();
        EventEntranceModel eventEntranceModel4 = entranceInfo;
        edit.putInt(animShowTimeKey, (eventEntranceModel4 == null || (online = eventEntranceModel4.getOnline()) == null || (animate = online.getAnimate()) == null) ? 0 : animate.getLoop()).apply();
        INSTANCE.reportEntranceClick();
    }

    private final void reportEntranceClick() {
        EventEntranceModel.Online online;
        EventEntranceModel.Online online2;
        EventEntranceModel.Online online3;
        Integer type;
        EventEntranceModel eventEntranceModel = entranceInfo;
        String str = null;
        if (((eventEntranceModel == null || (online3 = eventEntranceModel.getOnline()) == null || (type = online3.getType()) == null) ? 0 : type.intValue()) == 1) {
            Neurons.reportClick$default(false, "traffic.growth.newuser-backflow.0.click", (Map) null, 4, (Object) null);
        }
        HashMap extra = new HashMap();
        HashMap hashMap = extra;
        EventEntranceModel eventEntranceModel2 = entranceInfo;
        hashMap.put("unique_id", (eventEntranceModel2 == null || (online2 = eventEntranceModel2.getOnline()) == null) ? null : online2.getUniqueId());
        HashMap hashMap2 = extra;
        EventEntranceModel eventEntranceModel3 = entranceInfo;
        if (eventEntranceModel3 != null && (online = eventEntranceModel3.getOnline()) != null) {
            str = online.getName();
        }
        hashMap2.put("activity_name", str);
        Neurons.reportClick(false, "main.homepage.big-event.0.click", extra);
    }

    @JvmStatic
    public static final void reportEntranceShow() {
        EventEntranceModel.Online online;
        EventEntranceModel.Online online2;
        EventEntranceModel.Online online3;
        Integer type;
        EventEntranceModel eventEntranceModel = entranceInfo;
        if (((eventEntranceModel == null || (online3 = eventEntranceModel.getOnline()) == null || (type = online3.getType()) == null) ? 0 : type.intValue()) == 1) {
            Neurons.reportExposure$default(false, "traffic.growth.newuser-backflow.0.show", (Map) null, (List) null, 12, (Object) null);
        }
        HashMap extra = new HashMap();
        HashMap hashMap = extra;
        EventEntranceModel eventEntranceModel2 = entranceInfo;
        String str = null;
        hashMap.put("unique_id", (eventEntranceModel2 == null || (online2 = eventEntranceModel2.getOnline()) == null) ? null : online2.getUniqueId());
        HashMap hashMap2 = extra;
        EventEntranceModel eventEntranceModel3 = entranceInfo;
        if (eventEntranceModel3 != null && (online = eventEntranceModel3.getOnline()) != null) {
            str = online.getName();
        }
        hashMap2.put("activity_name", str);
        Neurons.reportExposure$default(false, "main.homepage.big-event.0.show", extra, (List) null, 8, (Object) null);
    }

    private final void reportEntranceAnimShow() {
        Neurons.reportExposure$default(false, "traffic.growth.newuser-dynamic.0.show", (Map) null, (List) null, 12, (Object) null);
    }
}