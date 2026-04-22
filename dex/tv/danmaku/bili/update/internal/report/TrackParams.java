package tv.danmaku.bili.update.internal.report;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import androidx.collection.ArrayMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NeuronReporter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0015J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006!"}, d2 = {"Ltv/danmaku/bili/update/internal/report/TrackParams;", "", "version", "", "silent", "", "state", "", "trigger", "md5", "<init>", "(JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVersion", "()J", "getSilent", "()Z", "getState", "()Ljava/lang/String;", "getTrigger", "getMd5", "toMap", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TrackParams {
    private final String md5;
    private final boolean silent;
    private final String state;
    private final String trigger;
    private final long version;

    public static /* synthetic */ TrackParams copy$default(TrackParams trackParams, long j, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = trackParams.version;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            z = trackParams.silent;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str = trackParams.state;
        }
        String str4 = str;
        if ((i & 8) != 0) {
            str2 = trackParams.trigger;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = trackParams.md5;
        }
        return trackParams.copy(j2, z2, str4, str5, str3);
    }

    public final long component1() {
        return this.version;
    }

    public final boolean component2() {
        return this.silent;
    }

    public final String component3() {
        return this.state;
    }

    public final String component4() {
        return this.trigger;
    }

    public final String component5() {
        return this.md5;
    }

    public final TrackParams copy(long j, boolean z, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "state");
        Intrinsics.checkNotNullParameter(str2, "trigger");
        Intrinsics.checkNotNullParameter(str3, "md5");
        return new TrackParams(j, z, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TrackParams) {
            TrackParams trackParams = (TrackParams) obj;
            return this.version == trackParams.version && this.silent == trackParams.silent && Intrinsics.areEqual(this.state, trackParams.state) && Intrinsics.areEqual(this.trigger, trackParams.trigger) && Intrinsics.areEqual(this.md5, trackParams.md5);
        }
        return false;
    }

    public int hashCode() {
        return (((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.version) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.silent)) * 31) + this.state.hashCode()) * 31) + this.trigger.hashCode()) * 31) + this.md5.hashCode();
    }

    public String toString() {
        long j = this.version;
        boolean z = this.silent;
        String str = this.state;
        String str2 = this.trigger;
        return "TrackParams(version=" + j + ", silent=" + z + ", state=" + str + ", trigger=" + str2 + ", md5=" + this.md5 + ")";
    }

    public TrackParams(long version, boolean silent, String state, String trigger, String md5) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(md5, "md5");
        this.version = version;
        this.silent = silent;
        this.state = state;
        this.trigger = trigger;
        this.md5 = md5;
    }

    public final long getVersion() {
        return this.version;
    }

    public final boolean getSilent() {
        return this.silent;
    }

    public final String getState() {
        return this.state;
    }

    public final String getTrigger() {
        return this.trigger;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final Map<String, String> toMap() {
        String silentToValue;
        Map<String, String> arrayMap = new ArrayMap<>();
        silentToValue = NeuronReporterKt.silentToValue(this.silent);
        arrayMap.put("silent", silentToValue);
        arrayMap.put("state", this.state);
        arrayMap.put("target_version", String.valueOf(this.version));
        arrayMap.put("trigger", this.trigger);
        arrayMap.put("info_md5", this.md5);
        arrayMap.put("is32_to_64", String.valueOf(RuntimeHelper.INSTANCE.is32To64Int$updater_debug()));
        return arrayMap;
    }
}