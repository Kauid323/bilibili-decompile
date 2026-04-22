package kntr.app.upper.entrance.ab;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppLaunchAB.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003JQ\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u001dHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006)"}, d2 = {"Lkntr/app/upper/entrance/ab/AppLaunchAB;", "", "key", "", "values", "", "default", "defaultDynamicKey", "defaultCacheValidTime", "", "expectCacheValue", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getKey", "()Ljava/lang/String;", "getValues", "()Ljava/util/List;", "getDefault", "getDefaultDynamicKey", "getDefaultCacheValidTime", "()J", "getExpectCacheValue", "is0", "", "value", "is1", "checkCache", "mid", "valueIndex", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AppLaunchAB {

    /* renamed from: default  reason: not valid java name */
    private final String f36default;
    private final long defaultCacheValidTime;
    private final String defaultDynamicKey;
    private final List<String> expectCacheValue;
    private final String key;
    private final List<String> values;

    public static /* synthetic */ AppLaunchAB copy$default(AppLaunchAB appLaunchAB, String str, List list, String str2, String str3, long j, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appLaunchAB.key;
        }
        List<String> list3 = list;
        if ((i & 2) != 0) {
            list3 = appLaunchAB.values;
        }
        List list4 = list3;
        if ((i & 4) != 0) {
            str2 = appLaunchAB.f36default;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = appLaunchAB.defaultDynamicKey;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            j = appLaunchAB.defaultCacheValidTime;
        }
        long j2 = j;
        List<String> list5 = list2;
        if ((i & 32) != 0) {
            list5 = appLaunchAB.expectCacheValue;
        }
        return appLaunchAB.copy(str, list4, str4, str5, j2, list5);
    }

    public final String component1() {
        return this.key;
    }

    public final List<String> component2() {
        return this.values;
    }

    public final String component3() {
        return this.f36default;
    }

    public final String component4() {
        return this.defaultDynamicKey;
    }

    public final long component5() {
        return this.defaultCacheValidTime;
    }

    public final List<String> component6() {
        return this.expectCacheValue;
    }

    public final AppLaunchAB copy(String str, List<String> list, String str2, String str3, long j, List<String> list2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(list, "values");
        Intrinsics.checkNotNullParameter(str2, "default");
        Intrinsics.checkNotNullParameter(str3, "defaultDynamicKey");
        Intrinsics.checkNotNullParameter(list2, "expectCacheValue");
        return new AppLaunchAB(str, list, str2, str3, j, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AppLaunchAB) {
            AppLaunchAB appLaunchAB = (AppLaunchAB) obj;
            return Intrinsics.areEqual(this.key, appLaunchAB.key) && Intrinsics.areEqual(this.values, appLaunchAB.values) && Intrinsics.areEqual(this.f36default, appLaunchAB.f36default) && Intrinsics.areEqual(this.defaultDynamicKey, appLaunchAB.defaultDynamicKey) && this.defaultCacheValidTime == appLaunchAB.defaultCacheValidTime && Intrinsics.areEqual(this.expectCacheValue, appLaunchAB.expectCacheValue);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.key.hashCode() * 31) + this.values.hashCode()) * 31) + this.f36default.hashCode()) * 31) + this.defaultDynamicKey.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.defaultCacheValidTime)) * 31) + this.expectCacheValue.hashCode();
    }

    public String toString() {
        String str = this.key;
        List<String> list = this.values;
        String str2 = this.f36default;
        String str3 = this.defaultDynamicKey;
        long j = this.defaultCacheValidTime;
        return "AppLaunchAB(key=" + str + ", values=" + list + ", default=" + str2 + ", defaultDynamicKey=" + str3 + ", defaultCacheValidTime=" + j + ", expectCacheValue=" + this.expectCacheValue + ")";
    }

    public AppLaunchAB(String key, List<String> list, String str, String defaultDynamicKey, long defaultCacheValidTime, List<String> list2) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(list, "values");
        Intrinsics.checkNotNullParameter(str, "default");
        Intrinsics.checkNotNullParameter(defaultDynamicKey, "defaultDynamicKey");
        Intrinsics.checkNotNullParameter(list2, "expectCacheValue");
        this.key = key;
        this.values = list;
        this.f36default = str;
        this.defaultDynamicKey = defaultDynamicKey;
        this.defaultCacheValidTime = defaultCacheValidTime;
        this.expectCacheValue = list2;
    }

    public /* synthetic */ AppLaunchAB(String str, List list, String str2, String str3, long j, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i & 4) != 0 ? "" : str2, str3, (i & 16) != 0 ? 86400L : j, (i & 32) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final String getKey() {
        return this.key;
    }

    public final List<String> getValues() {
        return this.values;
    }

    public final String getDefault() {
        return this.f36default;
    }

    public final String getDefaultDynamicKey() {
        return this.defaultDynamicKey;
    }

    public final long getDefaultCacheValidTime() {
        return this.defaultCacheValidTime;
    }

    public final List<String> getExpectCacheValue() {
        return this.expectCacheValue;
    }

    public final boolean is0(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return Intrinsics.areEqual(CollectionsKt.getOrNull(this.values, 0), value);
    }

    public final boolean is1(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return Intrinsics.areEqual(CollectionsKt.getOrNull(this.values, 1), value);
    }

    public final boolean checkCache(String mid, int valueIndex) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        return Intrinsics.areEqual(AppLaunchABManager.INSTANCE.getCache$entrance_debug(this, mid), CollectionsKt.getOrNull(this.values, valueIndex));
    }
}