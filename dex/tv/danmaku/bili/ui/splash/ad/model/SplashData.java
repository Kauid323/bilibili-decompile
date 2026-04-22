package tv.danmaku.bili.ui.splash.ad.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashData.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010+\u001a\u00020&H\u0016J\u0016\u00104\u001a\u0002052\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001eJ\u0006\u00107\u001a\u000205R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR&\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR \u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0011\u0010,\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b1\u0010\u0007R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00180\u001e8G¢\u0006\u0006\u001a\u0004\b3\u0010\u001a¨\u00068"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/SplashData;", "", "<init>", "()V", "maxCount", "", "getMaxCount", "()I", "setMaxCount", "(I)V", "intervalForShow", "getIntervalForShow", "setIntervalForShow", "intervalForUpdate", "getIntervalForUpdate", "setIntervalForUpdate", "disperseInterval", "", "getDisperseInterval", "()J", "setDisperseInterval", "(J)V", "splashList", "", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "getSplashList", "()Ljava/util/List;", "setSplashList", "(Ljava/util/List;)V", "strategyList", "", "Ltv/danmaku/bili/ui/splash/ad/model/SplashShowStrategy;", "getStrategyList", "setStrategyList", "keepIds", "getKeepIds", "setKeepIds", "splashRequestId", "", "getSplashRequestId", "()Ljava/lang/String;", "setSplashRequestId", "(Ljava/lang/String;)V", "toString", "validMaxCount", "getValidMaxCount", "validIntervalForUpdate", "getValidIntervalForUpdate", "validIntervalForShow", "getValidIntervalForShow", "encryptedData", "getEncryptedData", "addSplashData", "", "splashData", "trimEncryptedData", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashData {
    public static final int $stable = 8;
    @JSONField(name = "disperse_interval")
    private long disperseInterval;
    @JSONField(name = "min_interval")
    private int intervalForShow;
    @JSONField(name = "pull_interval")
    private int intervalForUpdate;
    @JSONField(name = "keep_ids")
    private List<Long> keepIds;
    @JSONField(name = "max_time")
    private int maxCount;
    @JSONField(name = "list")
    private List<Splash> splashList;
    @JSONField(name = "splash_request_id")
    private String splashRequestId;
    @JSONField(name = "show")
    private List<SplashShowStrategy> strategyList;

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final void setMaxCount(int i) {
        this.maxCount = i;
    }

    public final int getIntervalForShow() {
        return this.intervalForShow;
    }

    public final void setIntervalForShow(int i) {
        this.intervalForShow = i;
    }

    public final int getIntervalForUpdate() {
        return this.intervalForUpdate;
    }

    public final void setIntervalForUpdate(int i) {
        this.intervalForUpdate = i;
    }

    public final long getDisperseInterval() {
        return this.disperseInterval;
    }

    public final void setDisperseInterval(long j) {
        this.disperseInterval = j;
    }

    public final List<Splash> getSplashList() {
        return this.splashList;
    }

    public final void setSplashList(List<Splash> list) {
        this.splashList = list;
    }

    public final List<SplashShowStrategy> getStrategyList() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.strategyList);
    }

    public final void setStrategyList(List<SplashShowStrategy> list) {
        this.strategyList = list;
    }

    public final List<Long> getKeepIds() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.keepIds);
    }

    public final void setKeepIds(List<Long> list) {
        this.keepIds = list;
    }

    public final String getSplashRequestId() {
        return this.splashRequestId;
    }

    public final void setSplashRequestId(String str) {
        this.splashRequestId = str;
    }

    public String toString() {
        int i = this.maxCount;
        int i2 = this.intervalForShow;
        int i3 = this.intervalForUpdate;
        List<Splash> list = this.splashList;
        List<SplashShowStrategy> list2 = this.strategyList;
        List<Long> list3 = this.keepIds;
        return "SplashData(maxCount=" + i + ", intervalForShow=" + i2 + ", intervalForUpdate=" + i3 + ", splashList=" + list + ", strategyList=" + list2 + ", keepIds=" + list3 + ", splashRequestId=" + this.splashRequestId + ")";
    }

    @JSONField(deserialize = false, serialize = false)
    public final int getValidMaxCount() {
        if (this.maxCount > 0) {
            return this.maxCount;
        }
        return 6;
    }

    @JSONField(deserialize = false, serialize = false)
    public final int getValidIntervalForUpdate() {
        if (this.intervalForUpdate > 0) {
            return this.intervalForUpdate;
        }
        return 900;
    }

    @JSONField(deserialize = false, serialize = false)
    public final int getValidIntervalForShow() {
        if (this.intervalForShow > 0) {
            return this.intervalForShow;
        }
        return 900;
    }

    @JSONField(deserialize = false, serialize = false)
    public final List<Splash> getEncryptedData() {
        ArrayList arrayList;
        Iterable iterable = this.splashList;
        if (iterable != null) {
            Iterable $this$filter$iv = iterable;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Splash it = (Splash) element$iv$iv;
                if (it.isEncrypted()) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            arrayList = (List) destination$iv$iv;
        } else {
            arrayList = new ArrayList();
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(arrayList);
    }

    public final void addSplashData(List<? extends Splash> list) {
        List splashData = EnhancedUnmodifiabilityKt.unmodifiable(list);
        if (splashData == null) {
            return;
        }
        if (this.splashList == null) {
            this.splashList = new ArrayList();
        }
        List<Splash> list2 = this.splashList;
        if (list2 != null) {
            list2.addAll(splashData);
        }
    }

    public final void trimEncryptedData() {
        Iterator iterator;
        List<Splash> list = this.splashList;
        if (list == null || (iterator = list.iterator()) == null) {
            return;
        }
        while (iterator.hasNext()) {
            Splash splash = iterator.next();
            if (splash.isEncrypted()) {
                iterator.remove();
            }
        }
    }
}