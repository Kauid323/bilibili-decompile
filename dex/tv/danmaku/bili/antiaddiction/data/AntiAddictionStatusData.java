package tv.danmaku.bili.antiaddiction.data;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: AntiAddictionStatusData.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/antiaddiction/data/AntiAddictionStatusData;", "", "<init>", "()V", "antiAddiction", "Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData;", "getAntiAddiction", "()Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData;", "setAntiAddiction", "(Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData;)V", "sleepRemind", "Ltv/danmaku/bili/antiaddiction/data/SleepRemindData;", "getSleepRemind", "()Ltv/danmaku/bili/antiaddiction/data/SleepRemindData;", "setSleepRemind", "(Ltv/danmaku/bili/antiaddiction/data/SleepRemindData;)V", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AntiAddictionStatusData {
    @JSONField(name = "anti_addiction")
    private AddictionConfigData antiAddiction;
    @JSONField(name = "sleep_remind")
    private SleepRemindData sleepRemind;

    public final AddictionConfigData getAntiAddiction() {
        return this.antiAddiction;
    }

    public final void setAntiAddiction(AddictionConfigData addictionConfigData) {
        this.antiAddiction = addictionConfigData;
    }

    public final SleepRemindData getSleepRemind() {
        return this.sleepRemind;
    }

    public final void setSleepRemind(SleepRemindData sleepRemindData) {
        this.sleepRemind = sleepRemindData;
    }
}