package im.base.config;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;

/* compiled from: IMConfigSetting.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000eJ8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e¨\u0006 "}, d2 = {"Lim/base/config/IMConfigSetting;", "", "bffSessionEnabled", "", "bffChatEnabled", "chatLoopFetchDuration", "Lkotlin/time/Duration;", "chatSendDelayDuration", "<init>", "(ZZJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBffSessionEnabled", "()Z", "getBffChatEnabled", "getChatLoopFetchDuration-UwyO8pc", "()J", "J", "getChatSendDelayDuration-UwyO8pc", "component1", "component2", "component3", "component3-UwyO8pc", "component4", "component4-UwyO8pc", "copy", "copy-VTINZ0E", "(ZZJJ)Lim/base/config/IMConfigSetting;", "equals", "other", "hashCode", "", "toString", "", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMConfigSetting {
    private final boolean bffChatEnabled;
    private final boolean bffSessionEnabled;
    private final long chatLoopFetchDuration;
    private final long chatSendDelayDuration;

    public /* synthetic */ IMConfigSetting(boolean z, boolean z2, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, j, j2);
    }

    /* renamed from: copy-VTINZ0E$default  reason: not valid java name */
    public static /* synthetic */ IMConfigSetting m3102copyVTINZ0E$default(IMConfigSetting iMConfigSetting, boolean z, boolean z2, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = iMConfigSetting.bffSessionEnabled;
        }
        if ((i2 & 2) != 0) {
            z2 = iMConfigSetting.bffChatEnabled;
        }
        boolean z3 = z2;
        if ((i2 & 4) != 0) {
            j = iMConfigSetting.chatLoopFetchDuration;
        }
        long j3 = j;
        if ((i2 & 8) != 0) {
            j2 = iMConfigSetting.chatSendDelayDuration;
        }
        return iMConfigSetting.m3105copyVTINZ0E(z, z3, j3, j2);
    }

    public final boolean component1() {
        return this.bffSessionEnabled;
    }

    public final boolean component2() {
        return this.bffChatEnabled;
    }

    /* renamed from: component3-UwyO8pc  reason: not valid java name */
    public final long m3103component3UwyO8pc() {
        return this.chatLoopFetchDuration;
    }

    /* renamed from: component4-UwyO8pc  reason: not valid java name */
    public final long m3104component4UwyO8pc() {
        return this.chatSendDelayDuration;
    }

    /* renamed from: copy-VTINZ0E  reason: not valid java name */
    public final IMConfigSetting m3105copyVTINZ0E(boolean z, boolean z2, long j, long j2) {
        return new IMConfigSetting(z, z2, j, j2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMConfigSetting) {
            IMConfigSetting iMConfigSetting = (IMConfigSetting) obj;
            return this.bffSessionEnabled == iMConfigSetting.bffSessionEnabled && this.bffChatEnabled == iMConfigSetting.bffChatEnabled && Duration.equals-impl0(this.chatLoopFetchDuration, iMConfigSetting.chatLoopFetchDuration) && Duration.equals-impl0(this.chatSendDelayDuration, iMConfigSetting.chatSendDelayDuration);
        }
        return false;
    }

    public int hashCode() {
        return (((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.bffSessionEnabled) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.bffChatEnabled)) * 31) + Duration.hashCode-impl(this.chatLoopFetchDuration)) * 31) + Duration.hashCode-impl(this.chatSendDelayDuration);
    }

    public String toString() {
        boolean z = this.bffSessionEnabled;
        boolean z2 = this.bffChatEnabled;
        String str = Duration.toString-impl(this.chatLoopFetchDuration);
        return "IMConfigSetting(bffSessionEnabled=" + z + ", bffChatEnabled=" + z2 + ", chatLoopFetchDuration=" + str + ", chatSendDelayDuration=" + Duration.toString-impl(this.chatSendDelayDuration) + ")";
    }

    private IMConfigSetting(boolean bffSessionEnabled, boolean bffChatEnabled, long chatLoopFetchDuration, long chatSendDelayDuration) {
        this.bffSessionEnabled = bffSessionEnabled;
        this.bffChatEnabled = bffChatEnabled;
        this.chatLoopFetchDuration = chatLoopFetchDuration;
        this.chatSendDelayDuration = chatSendDelayDuration;
    }

    public /* synthetic */ IMConfigSetting(boolean z, boolean z2, long j, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) == 0 ? z2 : true, (i2 & 4) != 0 ? Duration.Companion.getZERO-UwyO8pc() : j, (i2 & 8) != 0 ? Duration.Companion.getZERO-UwyO8pc() : j2, null);
    }

    public final boolean getBffSessionEnabled() {
        return this.bffSessionEnabled;
    }

    public final boolean getBffChatEnabled() {
        return this.bffChatEnabled;
    }

    /* renamed from: getChatLoopFetchDuration-UwyO8pc  reason: not valid java name */
    public final long m3106getChatLoopFetchDurationUwyO8pc() {
        return this.chatLoopFetchDuration;
    }

    /* renamed from: getChatSendDelayDuration-UwyO8pc  reason: not valid java name */
    public final long m3107getChatSendDelayDurationUwyO8pc() {
        return this.chatSendDelayDuration;
    }
}