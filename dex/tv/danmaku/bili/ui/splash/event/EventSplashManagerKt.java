package tv.danmaku.bili.ui.splash.event;

import android.app.Application;
import android.util.Log;
import bolts.Task;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.resmanager.ResRequest;
import com.bilibili.lib.resmanager.ResResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.ad.util.SplashLocalInfoHelper;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: EventSplashManager.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\b\u0010\u000b\u001a\u00020\fH\u0007\u001a\n\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\n\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0007\u001a\n\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0003\u001a\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\b\u0010\u0014\u001a\u00020\u0010H\u0003\u001a\u0006\u0010\u0015\u001a\u00020\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"TAG", "", "mPreloadTask", "Ljava/util/concurrent/Future;", "Ltv/danmaku/bili/ui/splash/event/EventSplashData;", "preTime", "", "getPreTime", "()J", "setPreTime", "(J)V", "preloadEventSplash", "", "findEventSplashWithPreload", "findEventSplashForShow", "isSplashMidValid", "", "splash", "generateLocalBirthdayData", "isLoginAndHasSameMid", "isBirthday", "releaseEventSplashPreloadTask", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class EventSplashManagerKt {
    private static final String TAG = "[EventSplash]EventSplashManager";
    private static Future<EventSplashData> mPreloadTask;
    private static long preTime;

    public static final long getPreTime() {
        return preTime;
    }

    public static final void setPreTime(long j) {
        preTime = j;
    }

    public static final void preloadEventSplash() {
        preTime = System.currentTimeMillis();
        Log.d(TAG, "preloadEventSplash");
        mPreloadTask = Task.BACKGROUND_EXECUTOR.submit(new Callable() { // from class: tv.danmaku.bili.ui.splash.event.EventSplashManagerKt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                EventSplashData preloadEventSplash$lambda$0;
                preloadEventSplash$lambda$0 = EventSplashManagerKt.preloadEventSplash$lambda$0();
                return preloadEventSplash$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventSplashData preloadEventSplash$lambda$0() {
        return findEventSplashForShow();
    }

    public static final EventSplashData findEventSplashWithPreload() {
        Log.d(TAG, "findEventSplashWithPreload " + (System.currentTimeMillis() - preTime));
        Future it = mPreloadTask;
        if (it != null) {
            if (!(it.isDone() || !it.isCancelled())) {
                it = null;
            }
            if (it != null) {
                try {
                    BLog.i(TAG, "findEventSplashWithPreload get from preload");
                    Future<EventSplashData> future = mPreloadTask;
                    Intrinsics.checkNotNull(future);
                    return future.get();
                } catch (Exception e) {
                    BLog.e(TAG, "Preload error.", e);
                    return null;
                }
            }
        }
        return findEventSplashForShow();
    }

    public static final EventSplashData findEventSplashForShow() {
        Iterable eventList;
        Object obj;
        Object obj2;
        EventSplashData it;
        EventSplashData it2;
        List<EventSplashData> eventList2;
        boolean isStrictMode = RestrictedMode.isEnable(RestrictedType.TEENAGERS) || RestrictedMode.isEnable(RestrictedType.LESSONS);
        if (!SplashConfigKt.getEventSplashEnable() || isStrictMode) {
            return null;
        }
        EventSplashDataList splashData = EventSplashStorage.INSTANCE.getLocalEventSplashData();
        if (splashData == null || (eventList2 = splashData.getEventList()) == null || (eventList = CollectionsKt.filterNotNull(eventList2)) == null) {
            eventList = CollectionsKt.emptyList();
        }
        Iterator it3 = eventList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj = null;
                break;
            }
            obj = it3.next();
            EventSplashData it4 = (EventSplashData) obj;
            if (it4.getEventType() == 0 && it4.isResValid()) {
                it2 = 1;
                continue;
            } else {
                it2 = null;
                continue;
            }
            if (it2 != null) {
                break;
            }
        }
        EventSplashData eventSplashData = (EventSplashData) obj;
        if (eventSplashData == null) {
            eventSplashData = generateLocalBirthdayData();
        }
        EventSplashData birthdaySplash = eventSplashData;
        if (birthdaySplash != null) {
            birthdaySplash.setAccount(splashData != null ? splashData.getAccount() : null);
        }
        boolean isBirthday = isBirthday();
        if (!isBirthday) {
            EventSplashStorage.INSTANCE.clearBirthdaySplashShowCount();
        }
        if (isLoginAndHasSameMid(birthdaySplash)) {
            if ((birthdaySplash != null && true == birthdaySplash.isValid()) && isBirthday) {
                BLog.i(TAG, "findEventSplashForShow， get valid birthday splash, isLocal = " + birthdaySplash.isLocalBirthData());
                return birthdaySplash;
            }
        }
        Iterator it5 = eventList.iterator();
        while (true) {
            if (!it5.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it5.next();
            if (((EventSplashData) obj2).getEventType() == 1) {
                it = 1;
                continue;
            } else {
                it = null;
                continue;
            }
            if (it != null) {
                break;
            }
        }
        EventSplashData registerSplash = (EventSplashData) obj2;
        if (registerSplash != null) {
            registerSplash.setAccount(splashData != null ? splashData.getAccount() : null);
        }
        if (isLoginAndHasSameMid(registerSplash)) {
            if (registerSplash != null && registerSplash.isValid()) {
                BLog.i(TAG, "findEventSplashForShow, get registerSplash");
                return registerSplash;
            }
        }
        Iterable $this$filter$iv = eventList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (((EventSplashData) element$iv$iv).getEventType() == 2) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            EventSplashData it6 = (EventSplashData) element$iv;
            it6.setAccount(splashData != null ? splashData.getAccount() : null);
            if (it6.isValid() && isSplashMidValid(it6)) {
                BLog.i(TAG, "gfindEventSplashForShow, get operation splash");
                return it6;
            }
        }
        BLog.i(TAG, "not fount event splash birthdaySplash:" + birthdaySplash + " registerSplash:" + registerSplash);
        return null;
    }

    public static final boolean isSplashMidValid(EventSplashData splash) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        Account account = splash.getAccount();
        Long newMid = account != null ? Long.valueOf(account.getMid()) : null;
        long id = splash.getId();
        AccountInfo accountInfoFromCache = BiliAccountInfo.Companion.get().getAccountInfoFromCache();
        BLog.i(TAG, "isSplashMidValid false splash:" + id + " newMid:" + newMid + " login mid:" + (accountInfoFromCache != null ? Long.valueOf(accountInfoFromCache.getMid()) : null));
        if (newMid == null || newMid.longValue() == 0) {
            return true;
        }
        AccountInfo accountInfoFromCache2 = BiliAccountInfo.Companion.get().getAccountInfoFromCache();
        return accountInfoFromCache2 != null && newMid.longValue() == accountInfoFromCache2.getMid();
    }

    private static final EventSplashData generateLocalBirthdayData() {
        String str = null;
        if (isBirthday()) {
            BLog.i(TAG, "generateLocalBirthdayData");
            EventSplashData birthDayData = new EventSplashData();
            birthDayData.setId(Long.MIN_VALUE);
            birthDayData.setLocalBirthData(true);
            birthDayData.setEventType(0);
            birthDayData.setDuration(3000);
            birthDayData.setShowTimes(3);
            birthDayData.setShowCountdown(1);
            birthDayData.setShowSkip(1);
            Resource $this$generateLocalBirthdayData_u24lambda_u240_u240 = new Resource();
            ResResponse fetch = ResManager.fetch(new ResRequest(EventSplashStorageKt.getBackupBirthdayResourceUrl(), EventSplashStorageKt.getBackupBirthdayResourceKey()));
            File file = fetch != null ? fetch.getFile() : null;
            $this$generateLocalBirthdayData_u24lambda_u240_u240.setResourceType(0);
            if (file != null && file.exists()) {
                str = file.getAbsolutePath();
            }
            $this$generateLocalBirthdayData_u24lambda_u240_u240.setResourceUrl(str);
            $this$generateLocalBirthdayData_u24lambda_u240_u240.setLocalResourcePath($this$generateLocalBirthdayData_u24lambda_u240_u240.getResourceUrl());
            $this$generateLocalBirthdayData_u24lambda_u240_u240.setLocalBirthdayRes(true);
            birthDayData.setResources(CollectionsKt.listOf($this$generateLocalBirthdayData_u24lambda_u240_u240));
            return birthDayData;
        }
        return null;
    }

    private static final boolean isLoginAndHasSameMid(EventSplashData splash) {
        Account splashAccount = splash != null ? splash.getAccount() : null;
        Application context = BiliContext.application();
        if (context == null) {
            return false;
        }
        BiliAccounts account = BiliAccounts.get(context);
        if ((splash != null && true == splash.isLocalBirthData()) && account.isLogin()) {
            return true;
        }
        return splashAccount != null && splashAccount.getMid() != 0 && account.isLogin() && account.mid() == splashAccount.getMid();
    }

    private static final boolean isBirthday() {
        AccountInfo accountInfo = BiliAccountInfo.Companion.get().getAccountInfoFromCache();
        if (accountInfo == null) {
            return false;
        }
        if (!accountInfo.getIsSetBirthday()) {
            BLog.i(TAG, "isBirthday, user not set birthday");
            return false;
        }
        String birthday = accountInfo.getBirthday();
        BLog.i(TAG, "isBirthday:" + birthday);
        String str = birthday;
        if (str == null || StringsKt.isBlank(str)) {
            return false;
        }
        return SplashLocalInfoHelper.isBirthday(birthday);
    }

    public static final void releaseEventSplashPreloadTask() {
        Future<EventSplashData> future = mPreloadTask;
        if (future != null) {
            future.cancel(true);
        }
        mPreloadTask = null;
    }
}