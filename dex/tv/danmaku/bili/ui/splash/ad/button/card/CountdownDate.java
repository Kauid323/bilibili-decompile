package tv.danmaku.bili.ui.splash.ad.button.card;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashCountdownV2Card.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/button/card/CountdownDate;", "", "day", "", "hour", "minute", "second", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDay", "()Ljava/lang/String;", "getHour", "getMinute", "getSecond", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CountdownDate {
    private final String day;
    private final String hour;
    private final String minute;
    private final String second;

    public CountdownDate() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CountdownDate copy$default(CountdownDate countdownDate, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = countdownDate.day;
        }
        if ((i & 2) != 0) {
            str2 = countdownDate.hour;
        }
        if ((i & 4) != 0) {
            str3 = countdownDate.minute;
        }
        if ((i & 8) != 0) {
            str4 = countdownDate.second;
        }
        return countdownDate.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.day;
    }

    public final String component2() {
        return this.hour;
    }

    public final String component3() {
        return this.minute;
    }

    public final String component4() {
        return this.second;
    }

    public final CountdownDate copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "day");
        Intrinsics.checkNotNullParameter(str2, "hour");
        Intrinsics.checkNotNullParameter(str3, "minute");
        Intrinsics.checkNotNullParameter(str4, "second");
        return new CountdownDate(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CountdownDate) {
            CountdownDate countdownDate = (CountdownDate) obj;
            return Intrinsics.areEqual(this.day, countdownDate.day) && Intrinsics.areEqual(this.hour, countdownDate.hour) && Intrinsics.areEqual(this.minute, countdownDate.minute) && Intrinsics.areEqual(this.second, countdownDate.second);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.day.hashCode() * 31) + this.hour.hashCode()) * 31) + this.minute.hashCode()) * 31) + this.second.hashCode();
    }

    public String toString() {
        String str = this.day;
        String str2 = this.hour;
        String str3 = this.minute;
        return "CountdownDate(day=" + str + ", hour=" + str2 + ", minute=" + str3 + ", second=" + this.second + ")";
    }

    public CountdownDate(String day, String hour, String minute, String second) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(hour, "hour");
        Intrinsics.checkNotNullParameter(minute, "minute");
        Intrinsics.checkNotNullParameter(second, "second");
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public /* synthetic */ CountdownDate(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "00" : str, (i & 2) != 0 ? "00" : str2, (i & 4) != 0 ? "00" : str3, (i & 8) != 0 ? "00" : str4);
    }

    public final String getDay() {
        return this.day;
    }

    public final String getHour() {
        return this.hour;
    }

    public final String getMinute() {
        return this.minute;
    }

    public final String getSecond() {
        return this.second;
    }
}