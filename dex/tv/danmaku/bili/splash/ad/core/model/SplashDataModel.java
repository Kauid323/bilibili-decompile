package tv.danmaku.bili.splash.ad.core.model;

import android.content.SharedPreferences;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: SplashDataModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010%\u001a\u00020&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Ltv/danmaku/bili/splash/ad/core/model/SplashDataModel;", "", "<init>", "()V", "data", "Ltv/danmaku/bili/splash/ad/core/model/SplashSelectData;", "getData", "()Ltv/danmaku/bili/splash/ad/core/model/SplashSelectData;", "setData", "(Ltv/danmaku/bili/splash/ad/core/model/SplashSelectData;)V", "preloadStartTime", "", "getPreloadStartTime", "()J", "setPreloadStartTime", "(J)V", "showRequestStartTime", "getShowRequestStartTime", "setShowRequestStartTime", "realtimeMaterialSplashDownloadStartTime", "getRealtimeMaterialSplashDownloadStartTime", "setRealtimeMaterialSplashDownloadStartTime", "realtimeShowSelectStartTime", "getRealtimeShowSelectStartTime", "setRealtimeShowSelectStartTime", "splashShowIntervalBeginTimeMs", "getSplashShowIntervalBeginTimeMs", "setSplashShowIntervalBeginTimeMs", "<set-?>", "", "splashHotShowInterval", "getSplashHotShowInterval", "()I", "setSplashHotShowInterval", "(I)V", "splashHotShowInterval$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "clean", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashDataModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SplashDataModel.class, "splashHotShowInterval", "getSplashHotShowInterval()I", 0))};
    public static final int $stable = 8;
    private long preloadStartTime;
    private long realtimeMaterialSplashDownloadStartTime;
    private long realtimeShowSelectStartTime;
    private long showRequestStartTime;
    private long splashShowIntervalBeginTimeMs;
    private SplashSelectData data = new SplashSelectData(null, null, null, null, false, null, null, null, BR.hallCover, null);
    private final SharedPreferencesField splashHotShowInterval$delegate = new SharedPreferencesField("splash_hot_show_interval", 900, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);

    public final SplashSelectData getData() {
        return this.data;
    }

    public final void setData(SplashSelectData splashSelectData) {
        Intrinsics.checkNotNullParameter(splashSelectData, "<set-?>");
        this.data = splashSelectData;
    }

    public final long getPreloadStartTime() {
        return this.preloadStartTime;
    }

    public final void setPreloadStartTime(long j) {
        this.preloadStartTime = j;
    }

    public final long getShowRequestStartTime() {
        return this.showRequestStartTime;
    }

    public final void setShowRequestStartTime(long j) {
        this.showRequestStartTime = j;
    }

    public final long getRealtimeMaterialSplashDownloadStartTime() {
        return this.realtimeMaterialSplashDownloadStartTime;
    }

    public final void setRealtimeMaterialSplashDownloadStartTime(long j) {
        this.realtimeMaterialSplashDownloadStartTime = j;
    }

    public final long getRealtimeShowSelectStartTime() {
        return this.realtimeShowSelectStartTime;
    }

    public final void setRealtimeShowSelectStartTime(long j) {
        this.realtimeShowSelectStartTime = j;
    }

    public final long getSplashShowIntervalBeginTimeMs() {
        return this.splashShowIntervalBeginTimeMs;
    }

    public final void setSplashShowIntervalBeginTimeMs(long j) {
        this.splashShowIntervalBeginTimeMs = j;
    }

    public final int getSplashHotShowInterval() {
        return ((Number) this.splashHotShowInterval$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final void setSplashHotShowInterval(int i) {
        this.splashHotShowInterval$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
    }

    public final void clean() {
        BLog.i("[Splash]SplashDataModel", "clean cache");
        this.data = new SplashSelectData(null, null, null, null, false, null, null, null, BR.hallCover, null);
    }
}