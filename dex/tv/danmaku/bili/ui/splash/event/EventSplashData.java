package tv.danmaku.bili.ui.splash.event;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.app.comm.realtime.RealTime;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.common.CachedResource;
import tv.danmaku.bili.ui.splash.mod.SplashModHelper;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: EventSplashData.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00109\u001a\u00020:H\u0016J\u0006\u0010;\u001a\u00020:J\u0006\u0010>\u001a\u00020:J\u0006\u0010?\u001a\u00020:J\b\u0010@\u001a\u00020\u000bH\u0002J\b\u0010A\u001a\u00020\u000bH\u0002J\u000e\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020\u0000R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001e\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\u001e\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR(\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u001e\u0010$\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR\u001e\u0010'\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR\u001e\u0010*\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000fR \u0010-\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0019\u0010<\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b=\u0010\u0014R\u001a\u0010D\u001a\u00020:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0011\u0010H\u001a\u00020:8F¢\u0006\u0006\u001a\u0004\bH\u0010E¨\u0006I"}, d2 = {"Ltv/danmaku/bili/ui/splash/event/EventSplashData;", "Ltv/danmaku/bili/ui/splash/common/CachedResource;", "<init>", "()V", "beginTime", "", "getBeginTime", "()J", "setBeginTime", "(J)V", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "elements", "", "Ltv/danmaku/bili/ui/splash/event/Element;", "getElements", "()Ljava/util/List;", "setElements", "(Ljava/util/List;)V", "endTime", "getEndTime", "setEndTime", "eventType", "getEventType", "setEventType", "id", "getId", "setId", "resources", "Ltv/danmaku/bili/ui/splash/event/Resource;", "getResources", "setResources", "showCountdown", "getShowCountdown", "setShowCountdown", "showSkip", "getShowSkip", "setShowSkip", "showTimes", "getShowTimes", "setShowTimes", "account", "Ltv/danmaku/bili/ui/splash/event/Account;", "getAccount", "()Ltv/danmaku/bili/ui/splash/event/Account;", "setAccount", "(Ltv/danmaku/bili/ui/splash/event/Account;)V", "wifiDownload", "getWifiDownload", "()Ljava/lang/Integer;", "setWifiDownload", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isResValid", "", "isElementResValid", "phoneResource", "getPhoneResource", "isValid", "isTimeValid", "getResourceHash", "getElementHash", "hasSameResWith", "other", "isLocalBirthData", "()Z", "setLocalBirthData", "(Z)V", "isBirthdayData", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class EventSplashData implements CachedResource {
    public static final int $stable = 8;
    @JSONField(name = "account")
    private Account account;
    @JSONField(name = "begin_time")
    private long beginTime;
    @JSONField(name = "duration")
    private int duration;
    @JSONField(name = "elements")
    private List<Element> elements;
    @JSONField(name = ChronosDanmakuSender.KEY_CMTIME_END)
    private long endTime;
    @JSONField(name = "event_type")
    private int eventType;
    @JSONField(name = "id")
    private long id;
    private boolean isLocalBirthData;
    @JSONField(name = "resources")
    private List<Resource> resources;
    @JSONField(name = "show_countdown")
    private int showCountdown;
    @JSONField(name = "show_skip")
    private int showSkip;
    @JSONField(name = "show_times")
    private int showTimes;
    @JSONField(name = "wifi_download")
    private Integer wifiDownload = 1;

    public final long getBeginTime() {
        return this.beginTime;
    }

    public final void setBeginTime(long j) {
        this.beginTime = j;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final void setDuration(int i) {
        this.duration = i;
    }

    public final List<Element> getElements() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.elements);
    }

    public final void setElements(List<Element> list) {
        this.elements = list;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final int getEventType() {
        return this.eventType;
    }

    public final void setEventType(int i) {
        this.eventType = i;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final List<Resource> getResources() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.resources);
    }

    public final void setResources(List<Resource> list) {
        this.resources = list;
    }

    public final int getShowCountdown() {
        return this.showCountdown;
    }

    public final void setShowCountdown(int i) {
        this.showCountdown = i;
    }

    public final int getShowSkip() {
        return this.showSkip;
    }

    public final void setShowSkip(int i) {
        this.showSkip = i;
    }

    public final int getShowTimes() {
        return this.showTimes;
    }

    public final void setShowTimes(int i) {
        this.showTimes = i;
    }

    public final Account getAccount() {
        return this.account;
    }

    public final void setAccount(Account account) {
        this.account = account;
    }

    public final Integer getWifiDownload() {
        return this.wifiDownload;
    }

    public final void setWifiDownload(Integer num) {
        this.wifiDownload = num;
    }

    @Override // tv.danmaku.bili.ui.splash.common.CachedResource
    public boolean isResValid() {
        Iterable $this$all$iv;
        Resource it;
        Iterable phoneResource = getPhoneResource();
        if (phoneResource != null) {
            Iterable $this$all$iv2 = phoneResource;
            if (!($this$all$iv2 instanceof Collection) || !((Collection) $this$all$iv2).isEmpty()) {
                Iterator<T> it2 = $this$all$iv2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Object element$iv = it2.next();
                        Resource it3 = (Resource) element$iv;
                        if (it3.getResourceType() == 3 || it3.isResValid()) {
                            it = 1;
                            continue;
                        } else {
                            it = null;
                            continue;
                        }
                        if (it == null) {
                            $this$all$iv = null;
                            break;
                        }
                    } else {
                        $this$all$iv = 1;
                        break;
                    }
                }
            } else {
                $this$all$iv = 1;
            }
            return $this$all$iv == 1;
        }
        return false;
    }

    public final boolean isElementResValid() {
        Element it;
        List<Element> list = this.elements;
        Object obj = null;
        if (list != null) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Element it3 = (Element) next;
                if (it3 == null || it3.isResValid()) {
                    it = null;
                    continue;
                } else {
                    it = 1;
                    continue;
                }
                if (it != null) {
                    obj = next;
                    break;
                }
            }
            obj = (Element) obj;
        }
        return obj == null;
    }

    public final List<Resource> getPhoneResource() {
        ArrayList arrayList;
        Iterable filterNotNull;
        List<Resource> list = this.resources;
        if (list == null || (filterNotNull = CollectionsKt.filterNotNull(list)) == null) {
            arrayList = null;
        } else {
            Iterable $this$filter$iv = filterNotNull;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Resource it = (Resource) element$iv$iv;
                if (it.getResourceType() != 2) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            arrayList = (List) destination$iv$iv;
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(arrayList);
    }

    public final boolean isValid() {
        List res = getPhoneResource();
        if ((res != null && res.size() == 1) && res.get(0).getResourceType() == 1 && SplashModHelper.getSIsX86Device()) {
            BLog.i("[EventSplash]EventSplashData", "sIsX86Device splash:" + this.id);
            return false;
        } else if (EventSplashStorage.INSTANCE.getEventSplashShowCount(this) >= this.showTimes) {
            BLog.i("[EventSplash]EventSplashData", "show times limited splash:" + this.id);
            return false;
        } else {
            boolean resValid = isResValid();
            boolean timeValid = isTimeValid() || this.isLocalBirthData;
            BLog.i("[EventSplash]EventSplashData", "check valid id:" + this.id + " resValid:" + resValid + " timeValid:" + timeValid);
            return resValid && timeValid;
        }
    }

    public final boolean isTimeValid() {
        long now = RealTime.unreliableNow();
        return now <= this.endTime && this.beginTime <= now;
    }

    private final int getResourceHash() {
        Iterable filterNotNull;
        int hash = 0;
        List<Resource> list = this.resources;
        if (list != null && (filterNotNull = CollectionsKt.filterNotNull(list)) != null) {
            Iterable $this$forEach$iv = filterNotNull;
            for (Object element$iv : $this$forEach$iv) {
                Resource it = (Resource) element$iv;
                String resourceHash = it.getResourceHash();
                hash ^= resourceHash != null ? resourceHash.hashCode() : 0;
            }
        }
        return hash;
    }

    private final int getElementHash() {
        Iterable filterNotNull;
        int hash = 0;
        List<Element> list = this.elements;
        if (list != null && (filterNotNull = CollectionsKt.filterNotNull(list)) != null) {
            Iterable $this$forEach$iv = filterNotNull;
            for (Object element$iv : $this$forEach$iv) {
                Element it = (Element) element$iv;
                hash ^= it.getResourceHash();
            }
        }
        return hash;
    }

    public final boolean hasSameResWith(EventSplashData other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return getResourceHash() == other.getResourceHash() && getElementHash() == other.getElementHash();
    }

    public final boolean isLocalBirthData() {
        return this.isLocalBirthData;
    }

    public final void setLocalBirthData(boolean z) {
        this.isLocalBirthData = z;
    }

    public final boolean isBirthdayData() {
        return this.eventType == 0;
    }
}