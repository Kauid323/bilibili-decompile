package tv.danmaku.bili.antiaddiction.data;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: SleepRemindData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/antiaddiction/data/SleepRemindData;", "", "<init>", "()V", "switch", "", "getSwitch", "()Z", "setSwitch", "(Z)V", "startTime", "", "getStartTime", "()Ljava/lang/String;", "setStartTime", "(Ljava/lang/String;)V", "endTime", "getEndTime", "setEndTime", "push", "Ltv/danmaku/bili/antiaddiction/data/Push;", "getPush", "()Ltv/danmaku/bili/antiaddiction/data/Push;", "setPush", "(Ltv/danmaku/bili/antiaddiction/data/Push;)V", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SleepRemindData {
    @JSONField(name = "etime")
    private String endTime;
    @JSONField(name = "push")
    private Push push;
    @JSONField(name = "stime")
    private String startTime;
    @JSONField(name = "switch")

    /* renamed from: switch  reason: not valid java name */
    private boolean f0switch;

    public final boolean getSwitch() {
        return this.f0switch;
    }

    public final void setSwitch(boolean z) {
        this.f0switch = z;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(String str) {
        this.startTime = str;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(String str) {
        this.endTime = str;
    }

    public final Push getPush() {
        return this.push;
    }

    public final void setPush(Push push) {
        this.push = push;
    }
}