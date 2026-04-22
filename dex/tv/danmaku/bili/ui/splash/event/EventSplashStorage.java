package tv.danmaku.bili.ui.splash.event;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.fastjson.JSON;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.resmanager.DownloadBizType;
import com.bilibili.lib.resmanager.ResCallback;
import com.bilibili.lib.resmanager.ResDownloadRequest;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.resmanager.ResRequest;
import com.bilibili.lib.resmanager.ResUpdateRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.utils.SplashUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: EventSplashStorage.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u0004\u0018\u00010\nJ\u000e\u0010#\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010%\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010&\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010'\u001a\u00020\u0005J\b\u0010(\u001a\u00020\u0005H\u0002J\b\u0010)\u001a\u00020\fH\u0002R\u0018\u0010 \u001a\u00020\u0011*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0018\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Ltv/danmaku/bili/ui/splash/event/EventSplashStorage;", "", "<init>", "()V", "loadEventSplashData", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "cacheEventSplashResource", "dataList", "Ltv/danmaku/bili/ui/splash/event/EventSplashDataList;", "allowDownload", "", "eventSplashData", "Ltv/danmaku/bili/ui/splash/event/EventSplashData;", "downloadRes", "url", "", "hash", "downloadBirthRes", "deleteRes", "splash", "deleteElementRes", "element", "Ltv/danmaku/bili/ui/splash/event/Element;", "downloadElementRes", "getOldResFromDiskAndModifyShowCount", "", "newData", "setLocalEventSplashData", "eventSplashDataList", "getLocalEventSplashData", "keyPostfix", "getKeyPostfix", "(Ltv/danmaku/bili/ui/splash/event/EventSplashData;)Ljava/lang/String;", "getEventSplashShowCount", "", "increaseEventSplashShowCount", "clearEventSplashShowCount", "clearBirthdaySplashShowCount", "markResourceTransfer", "isResourceTransfer", "sp", "Landroid/content/SharedPreferences;", "getSp", "()Landroid/content/SharedPreferences;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class EventSplashStorage {
    private static SharedPreferences sp;
    public static final EventSplashStorage INSTANCE = new EventSplashStorage();
    public static final int $stable = 8;

    private EventSplashStorage() {
    }

    public final void loadEventSplashData(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BLog.i("[EventSplash]EventSplashStorage", "loadEventSplashData");
        Context ctx = activity.getApplicationContext();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) activity), Dispatchers.getIO(), (CoroutineStart) null, new EventSplashStorage$loadEventSplashData$1(ctx, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cacheEventSplashResource(EventSplashDataList dataList) {
        Iterable willDownloadRes;
        List oldCache;
        List willDownloadRes2;
        List oldCache2;
        String str;
        List willDownloadRes3;
        String str2;
        Sequence asSequence;
        Sequence filterNotNull;
        Sequence filter;
        BLog.i("[EventSplash]EventSplashStorage", "start cacheEventSplashResource");
        final List oldCache3 = getOldResFromDiskAndModifyShowCount(dataList);
        List<EventSplashData> eventList = dataList.getEventList();
        if (eventList == null || (asSequence = CollectionsKt.asSequence(eventList)) == null || (filterNotNull = SequencesKt.filterNotNull(asSequence)) == null || (filter = SequencesKt.filter(filterNotNull, new Function1() { // from class: tv.danmaku.bili.ui.splash.event.EventSplashStorage$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean cacheEventSplashResource$lambda$0;
                cacheEventSplashResource$lambda$0 = EventSplashStorage.cacheEventSplashResource$lambda$0(oldCache3, (EventSplashData) obj);
                return Boolean.valueOf(cacheEventSplashResource$lambda$0);
            }
        })) == null) {
            willDownloadRes = null;
        } else {
            willDownloadRes = SequencesKt.toList(filter);
        }
        List $this$forEach$iv = oldCache3;
        for (Object element$iv : $this$forEach$iv) {
            INSTANCE.deleteRes((EventSplashData) element$iv);
        }
        if (willDownloadRes != null) {
            Iterable $this$forEach$iv2 = willDownloadRes;
            for (Object element$iv2 : $this$forEach$iv2) {
                EventSplashData splashItem = (EventSplashData) element$iv2;
                if (INSTANCE.allowDownload(splashItem)) {
                    Iterable resources = splashItem.getResources();
                    if (resources == null) {
                        oldCache = oldCache3;
                        willDownloadRes2 = willDownloadRes;
                    } else {
                        Iterable $this$forEach$iv3 = resources;
                        for (Object element$iv3 : $this$forEach$iv3) {
                            Resource it = (Resource) element$iv3;
                            EventSplashStorage eventSplashStorage = INSTANCE;
                            if (it != null) {
                                oldCache2 = oldCache3;
                                str = it.getResourceUrl();
                            } else {
                                oldCache2 = oldCache3;
                                str = null;
                            }
                            if (it != null) {
                                willDownloadRes3 = willDownloadRes;
                                str2 = it.getResourceHash();
                            } else {
                                willDownloadRes3 = willDownloadRes;
                                str2 = null;
                            }
                            eventSplashStorage.downloadRes(str, str2);
                            oldCache3 = oldCache2;
                            willDownloadRes = willDownloadRes3;
                        }
                        oldCache = oldCache3;
                        willDownloadRes2 = willDownloadRes;
                    }
                    Iterable oldCache4 = splashItem.getElements();
                    if (oldCache4 != null) {
                        Iterable $this$forEach$iv4 = oldCache4;
                        for (Object element$iv4 : $this$forEach$iv4) {
                            INSTANCE.downloadElementRes((Element) element$iv4);
                        }
                    }
                } else {
                    oldCache = oldCache3;
                    willDownloadRes2 = willDownloadRes;
                    BLog.i("[EventSplash]EventSplashStorage", "not allow mobile network download");
                }
                oldCache3 = oldCache;
                willDownloadRes = willDownloadRes2;
            }
        }
        BLog.i("[EventSplash]EventSplashStorage", "cacheEventSplashResource finish");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean cacheEventSplashResource$lambda$0(List $oldCache, EventSplashData newItem) {
        Object obj;
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        Iterator it = $oldCache.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            EventSplashData oldItem = (EventSplashData) obj;
            if (oldItem.hasSameResWith(newItem)) {
                break;
            }
        }
        EventSplashData hitCache = (EventSplashData) obj;
        if (hitCache != null) {
            $oldCache.remove(hitCache);
        }
        return hitCache == null;
    }

    private final boolean allowDownload(EventSplashData eventSplashData) {
        Integer wifiDownload;
        return SplashUtils.isWifiConnected() || (wifiDownload = eventSplashData.getWifiDownload()) == null || wifiDownload.intValue() != 1;
    }

    static /* synthetic */ void downloadRes$default(EventSplashStorage eventSplashStorage, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        eventSplashStorage.downloadRes(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0022, code lost:
        if ((r0 == null || kotlin.text.StringsKt.isBlank(r0)) == false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void downloadRes(String url, String hash) {
        String str = url;
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            String str2 = hash;
        }
        BLog.i("[EventSplash]EventSplashStorage", "download res url:" + url + " hash:" + hash);
        String str3 = url;
        if (str3 == null || StringsKt.isBlank(str3)) {
            return;
        }
        String str4 = hash;
        if (str4 == null || StringsKt.isBlank(str4)) {
            return;
        }
        String fetchResourceLocalPathByUrl = EventSplashStorageKt.fetchResourceLocalPathByUrl(url);
        if (fetchResourceLocalPathByUrl == null || fetchResourceLocalPathByUrl.length() == 0) {
            z = true;
        }
        if (!z) {
            EventSplashStorageKt.access$deleteResourceByUrl(url);
        }
        ResManager.downloadSync(new ResDownloadRequest(url, hash).md5(hash).downloadTag("event_splash").bizType(DownloadBizType.BrandSplash));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadBirthRes() {
        BLog.i("[EventSplash]EventSplashStorage", "downloadBirthRes");
        ResRequest downloadTag = new ResDownloadRequest(EventSplashStorageKt.getBackupBirthdayResourceUrl(), EventSplashStorageKt.getBackupBirthdayResourceKey()).bizType(DownloadBizType.BrandSplash).cleanable(false).downloadTag("event_splash_birth");
        if (!ResManager.isFileExist(downloadTag)) {
            ResManager.download$default(downloadTag, (ResCallback) null, 2, (Object) null);
        } else if (!isResourceTransfer()) {
            ResUpdateRequest updateRequest = new ResUpdateRequest(EventSplashStorageKt.getBackupBirthdayResourceUrl(), EventSplashStorageKt.getBackupBirthdayResourceKey(), DownloadBizType.BrandSplash, (Boolean) null, 8, (DefaultConstructorMarker) null);
            ResManager.update(updateRequest);
            markResourceTransfer();
        }
    }

    private final void deleteRes(EventSplashData splash) {
        Iterable $this$forEach$iv = splash.getResources();
        if ($this$forEach$iv != null) {
            for (Object element$iv : $this$forEach$iv) {
                Resource it = (Resource) element$iv;
                String str = null;
                EventSplashStorageKt.access$deleteResourceByUrl(it != null ? it.getResourceUrl() : null);
                if (it != null) {
                    str = it.getResourceHash();
                }
                EventSplashStorageKt.access$deleteResourceByHash(str);
            }
        }
        Iterable $this$forEach$iv2 = splash.getElements();
        if ($this$forEach$iv2 != null) {
            for (Object element$iv2 : $this$forEach$iv2) {
                INSTANCE.deleteElementRes((Element) element$iv2);
            }
        }
        BLog.i("[EventSplash]EventSplashStorage", "Delete splash res :" + splash);
    }

    private final void deleteElementRes(Element element) {
        Iterable elements;
        if (element == null) {
            return;
        }
        EventSplashStorageKt.access$deleteResourceByUrl(element.getImageUrl());
        EventSplashStorageKt.access$deleteResourceByHash(element.getImageUrlHash());
        EventSplashStorageKt.access$deleteResourceByUrl(element.getBgImage());
        EventSplashStorageKt.access$deleteResourceByHash(element.getBgImageHash());
        Action action = element.getAction();
        if (action == null || (elements = action.getElements()) == null) {
            return;
        }
        Iterable $this$forEach$iv = elements;
        for (Object element$iv : $this$forEach$iv) {
            Element it = (Element) element$iv;
            INSTANCE.deleteElementRes(it);
        }
    }

    private final void downloadElementRes(Element element) {
        Iterable elements;
        if (element == null) {
            return;
        }
        downloadRes(element.getImageUrl(), element.getImageUrlHash());
        downloadRes(element.getBgImage(), element.getBgImageHash());
        Action action = element.getAction();
        if (action == null || (elements = action.getElements()) == null) {
            return;
        }
        Iterable $this$forEach$iv = elements;
        for (Object element$iv : $this$forEach$iv) {
            Element it = (Element) element$iv;
            INSTANCE.downloadElementRes(it);
        }
    }

    private final List<EventSplashData> getOldResFromDiskAndModifyShowCount(EventSplashDataList newData) {
        Sequence asSequence;
        Sequence $this$forEach$iv;
        EventSplashData eventSplashData;
        Object obj;
        EventSplashData it;
        EventSplashDataList localEventSplashData = getLocalEventSplashData();
        List dataList = localEventSplashData != null ? localEventSplashData.getEventList() : null;
        if (dataList != null && (asSequence = CollectionsKt.asSequence(dataList)) != null && ($this$forEach$iv = SequencesKt.filterNotNull(asSequence)) != null) {
            for (Object element$iv : $this$forEach$iv) {
                EventSplashData old = (EventSplashData) element$iv;
                List<EventSplashData> eventList = newData.getEventList();
                if (eventList != null) {
                    Iterator<T> it2 = eventList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        EventSplashData it3 = (EventSplashData) obj;
                        if (it3 == null || it3.getId() != old.getId()) {
                            it = null;
                            continue;
                        } else {
                            it = 1;
                            continue;
                        }
                        if (it != null) {
                            break;
                        }
                    }
                    eventSplashData = (EventSplashData) obj;
                } else {
                    eventSplashData = null;
                }
                if (eventSplashData == null || !EventSplashManagerKt.isSplashMidValid(old)) {
                    INSTANCE.clearEventSplashShowCount(old);
                }
            }
        }
        List list = dataList;
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        Iterable $this$filter$iv = CollectionsKt.filterNotNull(dataList);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            EventSplashData it4 = (EventSplashData) element$iv$iv;
            boolean isValid = it4.isResValid() && it4.isElementResValid();
            if (!isValid) {
                INSTANCE.deleteRes(it4);
            }
            if (isValid) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return CollectionsKt.toMutableList((List) destination$iv$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLocalEventSplashData(EventSplashDataList eventSplashDataList) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        BLog.i("[EventSplash]EventSplashStorage", "setLocalEventSplashData :" + eventSplashDataList);
        try {
            String dataStr = JSON.toJSONString(eventSplashDataList);
            SharedPreferences sp2 = getSp();
            if (sp2 != null && (edit = sp2.edit()) != null && (putString = edit.putString("splash.event.list.data.list", dataStr)) != null) {
                putString.apply();
            }
        } catch (Throwable t) {
            BLog.i("[EventSplash]EventSplashStorage", "setLocalEventSplashData failed ", t);
        }
        BLog.i("[EventSplash]EventSplashStorage", "setLocalEventSplashData finish");
    }

    public final EventSplashDataList getLocalEventSplashData() {
        try {
            SharedPreferences sp2 = getSp();
            return (EventSplashDataList) JSON.parseObject(sp2 != null ? sp2.getString("splash.event.list.data.list", "") : null, EventSplashDataList.class);
        } catch (Throwable t) {
            BLog.i("[EventSplash]EventSplashStorage", "getLocalEventSplashData failed ", t);
            return null;
        }
    }

    private final String getKeyPostfix(EventSplashData $this$keyPostfix) {
        return $this$keyPostfix.isBirthdayData() ? "birthday" : String.valueOf($this$keyPostfix.getId());
    }

    public final int getEventSplashShowCount(EventSplashData eventSplashData) {
        Intrinsics.checkNotNullParameter(eventSplashData, "eventSplashData");
        SharedPreferences sp2 = getSp();
        if (sp2 != null) {
            return sp2.getInt("splash.event.show.time.prefix." + getKeyPostfix(eventSplashData), 0);
        }
        return 0;
    }

    public final void increaseEventSplashShowCount(EventSplashData eventSplashData) {
        SharedPreferences.Editor edit;
        Intrinsics.checkNotNullParameter(eventSplashData, "eventSplashData");
        int count = getEventSplashShowCount(eventSplashData) + 1;
        SharedPreferences sp2 = getSp();
        if (sp2 != null && (edit = sp2.edit()) != null) {
            SharedPreferences.Editor putInt = edit.putInt("splash.event.show.time.prefix." + getKeyPostfix(eventSplashData), count);
            if (putInt != null) {
                putInt.apply();
            }
        }
    }

    public final void clearEventSplashShowCount(EventSplashData eventSplashData) {
        SharedPreferences.Editor edit;
        Intrinsics.checkNotNullParameter(eventSplashData, "eventSplashData");
        BLog.i("[EventSplash]EventSplashStorage", "clear show count :" + getKeyPostfix(eventSplashData));
        SharedPreferences sp2 = getSp();
        if (sp2 == null || (edit = sp2.edit()) == null) {
            return;
        }
        SharedPreferences.Editor remove = edit.remove("splash.event.show.time.prefix." + getKeyPostfix(eventSplashData));
        if (remove != null) {
            remove.apply();
        }
    }

    public final void clearBirthdaySplashShowCount() {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor remove;
        SharedPreferences sp2 = getSp();
        if (sp2 == null || (edit = sp2.edit()) == null || (remove = edit.remove("splash.event.show.time.prefix.birthday")) == null) {
            return;
        }
        remove.apply();
    }

    private final void markResourceTransfer() {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        SharedPreferences sp2 = getSp();
        if (sp2 == null || (edit = sp2.edit()) == null || (putBoolean = edit.putBoolean("sp_backoff_birthday_image_transfer", true)) == null) {
            return;
        }
        putBoolean.apply();
    }

    private final boolean isResourceTransfer() {
        SharedPreferences sp2 = getSp();
        if (sp2 != null) {
            return sp2.getBoolean("sp_backoff_birthday_image_transfer", false);
        }
        return false;
    }

    private final SharedPreferences getSp() {
        if (sp == null) {
            Application application = BiliContext.application();
            sp = (SharedPreferences) (application != null ? BLKV.getBLSharedPreferences$default(application, "splash.event.splash.name", true, 0, 4, (Object) null) : null);
        }
        return sp;
    }
}