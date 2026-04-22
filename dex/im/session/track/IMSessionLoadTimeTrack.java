package im.session.track;

import BottomSheetItemData$;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.bilibili.blens.Lens;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* compiled from: TechTracker.kt */
@Lens
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0001@Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002000/J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\rHÆ\u0003Jg\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010;\u001a\u00020\u000b2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u000200HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001aR\u0014\u0010 \u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001aR\u0011\u0010\"\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001aR\u0014\u0010$\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010'¨\u0006A"}, d2 = {"Lim/session/track/IMSessionLoadTimeTrack;", "", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "start", "Lkotlinx/datetime/Instant;", "cacheLoad", "mossLoad", "cacheViewReady", "mossViewReady", "startFromNotLogin", "", "firstCacheError", "", "firstMossError", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Lkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;ZLjava/lang/Throwable;Ljava/lang/Throwable;)V", "getPageType", "()Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "getStart", "()Lkotlinx/datetime/Instant;", "getCacheLoad", "getMossLoad", "getCacheViewReady", "getMossViewReady", "getStartFromNotLogin", "()Z", "getFirstCacheError", "()Ljava/lang/Throwable;", "getFirstMossError", "cacheReady", "getCacheReady", "mossReady", "getMossReady", "readyToReport", "getReadyToReport", "cacheLoadMs", "", "getCacheLoadMs", "()J", "mossLoadMs", "getMossLoadMs", "cacheViewReadyMs", "getCacheViewReadyMs", "mossViewReadyMs", "getMossViewReadyMs", "buildReportMap", "", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionLoadTimeTrack {
    public static final Companion Companion = new Companion(null);
    private final Instant cacheLoad;
    private final Instant cacheViewReady;
    private final Throwable firstCacheError;
    private final Throwable firstMossError;
    private final Instant mossLoad;
    private final Instant mossViewReady;
    private final KSessionPageType pageType;
    private final Instant start;
    private final boolean startFromNotLogin;

    public final KSessionPageType component1() {
        return this.pageType;
    }

    public final Instant component2() {
        return this.start;
    }

    public final Instant component3() {
        return this.cacheLoad;
    }

    public final Instant component4() {
        return this.mossLoad;
    }

    public final Instant component5() {
        return this.cacheViewReady;
    }

    public final Instant component6() {
        return this.mossViewReady;
    }

    public final boolean component7() {
        return this.startFromNotLogin;
    }

    public final Throwable component8() {
        return this.firstCacheError;
    }

    public final Throwable component9() {
        return this.firstMossError;
    }

    public final IMSessionLoadTimeTrack copy(KSessionPageType kSessionPageType, Instant instant, Instant instant2, Instant instant3, Instant instant4, Instant instant5, boolean z, Throwable th, Throwable th2) {
        Intrinsics.checkNotNullParameter(kSessionPageType, "pageType");
        Intrinsics.checkNotNullParameter(instant, "start");
        Intrinsics.checkNotNullParameter(instant2, "cacheLoad");
        Intrinsics.checkNotNullParameter(instant3, "mossLoad");
        Intrinsics.checkNotNullParameter(instant4, "cacheViewReady");
        Intrinsics.checkNotNullParameter(instant5, "mossViewReady");
        return new IMSessionLoadTimeTrack(kSessionPageType, instant, instant2, instant3, instant4, instant5, z, th, th2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMSessionLoadTimeTrack) {
            IMSessionLoadTimeTrack iMSessionLoadTimeTrack = (IMSessionLoadTimeTrack) obj;
            return Intrinsics.areEqual(this.pageType, iMSessionLoadTimeTrack.pageType) && Intrinsics.areEqual(this.start, iMSessionLoadTimeTrack.start) && Intrinsics.areEqual(this.cacheLoad, iMSessionLoadTimeTrack.cacheLoad) && Intrinsics.areEqual(this.mossLoad, iMSessionLoadTimeTrack.mossLoad) && Intrinsics.areEqual(this.cacheViewReady, iMSessionLoadTimeTrack.cacheViewReady) && Intrinsics.areEqual(this.mossViewReady, iMSessionLoadTimeTrack.mossViewReady) && this.startFromNotLogin == iMSessionLoadTimeTrack.startFromNotLogin && Intrinsics.areEqual(this.firstCacheError, iMSessionLoadTimeTrack.firstCacheError) && Intrinsics.areEqual(this.firstMossError, iMSessionLoadTimeTrack.firstMossError);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.pageType.hashCode() * 31) + this.start.hashCode()) * 31) + this.cacheLoad.hashCode()) * 31) + this.mossLoad.hashCode()) * 31) + this.cacheViewReady.hashCode()) * 31) + this.mossViewReady.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.startFromNotLogin)) * 31) + (this.firstCacheError == null ? 0 : this.firstCacheError.hashCode())) * 31) + (this.firstMossError != null ? this.firstMossError.hashCode() : 0);
    }

    public String toString() {
        KSessionPageType kSessionPageType = this.pageType;
        Instant instant = this.start;
        Instant instant2 = this.cacheLoad;
        Instant instant3 = this.mossLoad;
        Instant instant4 = this.cacheViewReady;
        Instant instant5 = this.mossViewReady;
        boolean z = this.startFromNotLogin;
        Throwable th = this.firstCacheError;
        return "IMSessionLoadTimeTrack(pageType=" + kSessionPageType + ", start=" + instant + ", cacheLoad=" + instant2 + ", mossLoad=" + instant3 + ", cacheViewReady=" + instant4 + ", mossViewReady=" + instant5 + ", startFromNotLogin=" + z + ", firstCacheError=" + th + ", firstMossError=" + this.firstMossError + ")";
    }

    public IMSessionLoadTimeTrack(KSessionPageType pageType, Instant start, Instant cacheLoad, Instant mossLoad, Instant cacheViewReady, Instant mossViewReady, boolean startFromNotLogin, Throwable firstCacheError, Throwable firstMossError) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(cacheLoad, "cacheLoad");
        Intrinsics.checkNotNullParameter(mossLoad, "mossLoad");
        Intrinsics.checkNotNullParameter(cacheViewReady, "cacheViewReady");
        Intrinsics.checkNotNullParameter(mossViewReady, "mossViewReady");
        this.pageType = pageType;
        this.start = start;
        this.cacheLoad = cacheLoad;
        this.mossLoad = mossLoad;
        this.cacheViewReady = cacheViewReady;
        this.mossViewReady = mossViewReady;
        this.startFromNotLogin = startFromNotLogin;
        this.firstCacheError = firstCacheError;
        this.firstMossError = firstMossError;
    }

    public /* synthetic */ IMSessionLoadTimeTrack(KSessionPageType kSessionPageType, Instant instant, Instant instant2, Instant instant3, Instant instant4, Instant instant5, boolean z, Throwable th, Throwable th2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSessionPageType, (i2 & 2) != 0 ? Clock.System.INSTANCE.now() : instant, (i2 & 4) != 0 ? Instant.Companion.getDISTANT_PAST() : instant2, (i2 & 8) != 0 ? Instant.Companion.getDISTANT_PAST() : instant3, (i2 & 16) != 0 ? Instant.Companion.getDISTANT_PAST() : instant4, (i2 & 32) != 0 ? Instant.Companion.getDISTANT_PAST() : instant5, (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? null : th, (i2 & 256) == 0 ? th2 : null);
    }

    public final KSessionPageType getPageType() {
        return this.pageType;
    }

    public final Instant getStart() {
        return this.start;
    }

    public final Instant getCacheLoad() {
        return this.cacheLoad;
    }

    public final Instant getMossLoad() {
        return this.mossLoad;
    }

    public final Instant getCacheViewReady() {
        return this.cacheViewReady;
    }

    public final Instant getMossViewReady() {
        return this.mossViewReady;
    }

    public final boolean getStartFromNotLogin() {
        return this.startFromNotLogin;
    }

    public final Throwable getFirstCacheError() {
        return this.firstCacheError;
    }

    public final Throwable getFirstMossError() {
        return this.firstMossError;
    }

    /* compiled from: TechTracker.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/session/track/IMSessionLoadTimeTrack$Companion;", "", "<init>", "()V", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final boolean getCacheReady() {
        return ((Intrinsics.areEqual(this.cacheLoad, Instant.Companion.getDISTANT_PAST()) || Intrinsics.areEqual(this.cacheViewReady, Instant.Companion.getDISTANT_PAST())) && this.firstCacheError == null) ? false : true;
    }

    private final boolean getMossReady() {
        return ((Intrinsics.areEqual(this.mossLoad, Instant.Companion.getDISTANT_PAST()) || Intrinsics.areEqual(this.mossViewReady, Instant.Companion.getDISTANT_PAST())) && this.firstMossError == null) ? false : true;
    }

    public final boolean getReadyToReport() {
        return getMossReady() && !this.startFromNotLogin;
    }

    private final long getCacheLoadMs() {
        if (Intrinsics.areEqual(this.cacheLoad, Instant.Companion.getDISTANT_PAST())) {
            return -1L;
        }
        return Duration.getInWholeMilliseconds-impl(this.cacheLoad.minus-5sfh64U(this.start));
    }

    private final long getMossLoadMs() {
        if (Intrinsics.areEqual(this.mossLoad, Instant.Companion.getDISTANT_PAST())) {
            return -1L;
        }
        return Duration.getInWholeMilliseconds-impl(this.mossLoad.minus-5sfh64U(this.start));
    }

    private final long getCacheViewReadyMs() {
        if (Intrinsics.areEqual(this.cacheViewReady, Instant.Companion.getDISTANT_PAST())) {
            return -1L;
        }
        return Duration.getInWholeMilliseconds-impl(this.cacheViewReady.minus-5sfh64U(this.start));
    }

    private final long getMossViewReadyMs() {
        if (Intrinsics.areEqual(this.mossViewReady, Instant.Companion.getDISTANT_PAST())) {
            return -1L;
        }
        return Duration.getInWholeMilliseconds-impl(this.mossViewReady.minus-5sfh64U(this.start));
    }

    public final Map<String, String> buildReportMap() {
        String message;
        Pair[] pairArr = new Pair[10];
        pairArr[0] = TuplesKt.to("cache_load_ms", String.valueOf(getCacheLoadMs()));
        pairArr[1] = TuplesKt.to("moss_load_ms", String.valueOf(getMossLoadMs()));
        pairArr[2] = TuplesKt.to("cache_view_ready_ms", String.valueOf(getCacheViewReadyMs()));
        pairArr[3] = TuplesKt.to("moss_view_ready_ms", String.valueOf(getMossViewReadyMs()));
        Throwable th = this.firstCacheError;
        String str = "";
        pairArr[4] = TuplesKt.to("first_cache_error_type", (th == null || (r1 = TechTrackerKt.access$errorType(th)) == null) ? "" : "");
        Throwable th2 = this.firstCacheError;
        pairArr[5] = TuplesKt.to("first_cache_error_code", (th2 == null || (r1 = TechTrackerKt.access$errorCode(th2)) == null) ? "" : "");
        Throwable th3 = this.firstCacheError;
        pairArr[6] = TuplesKt.to("first_cache_error_message", (th3 == null || (r1 = th3.getMessage()) == null) ? "" : "");
        Throwable th4 = this.firstMossError;
        pairArr[7] = TuplesKt.to("first_moss_error_type", (th4 == null || (r1 = TechTrackerKt.access$errorType(th4)) == null) ? "" : "");
        Throwable th5 = this.firstMossError;
        pairArr[8] = TuplesKt.to("first_moss_error_code", (th5 == null || (r1 = TechTrackerKt.access$errorCode(th5)) == null) ? "" : "");
        Throwable th6 = this.firstMossError;
        if (th6 != null && (message = th6.getMessage()) != null) {
            str = message;
        }
        pairArr[9] = TuplesKt.to("first_moss_error_message", str);
        return MapsKt.mapOf(pairArr);
    }
}