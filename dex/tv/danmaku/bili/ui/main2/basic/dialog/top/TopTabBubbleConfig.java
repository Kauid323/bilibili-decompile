package tv.danmaku.bili.ui.main2.basic.dialog.top;

import ComposableSingletons$CustomBottomSheetKt$;
import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: TopTabBubbleDialogWrapper.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006!"}, d2 = {"Ltv/danmaku/bili/ui/main2/basic/dialog/top/TopTabBubbleConfig;", "", "dialogShowTimeMillis", "", "dialogDelayShowTimeMillis", "dialogMaxShowTimes", "", "sameIdDialogMaxShowTimes", "<init>", "(JJII)V", "getDialogShowTimeMillis", "()J", "setDialogShowTimeMillis", "(J)V", "getDialogDelayShowTimeMillis", "setDialogDelayShowTimeMillis", "getDialogMaxShowTimes", "()I", "setDialogMaxShowTimes", "(I)V", "getSameIdDialogMaxShowTimes", "setSameIdDialogMaxShowTimes", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TopTabBubbleConfig {
    public static final int $stable = 8;
    @JSONField(name = "dialog_delay_show_time_millis")
    private long dialogDelayShowTimeMillis;
    @JSONField(name = "dialog_max_show_times")
    private int dialogMaxShowTimes;
    @JSONField(name = "dialog_show_time_millis")
    private long dialogShowTimeMillis;
    @JSONField(name = "same_id_dialog_max_show_times")
    private int sameIdDialogMaxShowTimes;

    public TopTabBubbleConfig() {
        this(0L, 0L, 0, 0, 15, null);
    }

    public static /* synthetic */ TopTabBubbleConfig copy$default(TopTabBubbleConfig topTabBubbleConfig, long j, long j2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = topTabBubbleConfig.dialogShowTimeMillis;
        }
        long j3 = j;
        if ((i3 & 2) != 0) {
            j2 = topTabBubbleConfig.dialogDelayShowTimeMillis;
        }
        long j4 = j2;
        if ((i3 & 4) != 0) {
            i = topTabBubbleConfig.dialogMaxShowTimes;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = topTabBubbleConfig.sameIdDialogMaxShowTimes;
        }
        return topTabBubbleConfig.copy(j3, j4, i4, i2);
    }

    public final long component1() {
        return this.dialogShowTimeMillis;
    }

    public final long component2() {
        return this.dialogDelayShowTimeMillis;
    }

    public final int component3() {
        return this.dialogMaxShowTimes;
    }

    public final int component4() {
        return this.sameIdDialogMaxShowTimes;
    }

    public final TopTabBubbleConfig copy(long j, long j2, int i, int i2) {
        return new TopTabBubbleConfig(j, j2, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TopTabBubbleConfig) {
            TopTabBubbleConfig topTabBubbleConfig = (TopTabBubbleConfig) obj;
            return this.dialogShowTimeMillis == topTabBubbleConfig.dialogShowTimeMillis && this.dialogDelayShowTimeMillis == topTabBubbleConfig.dialogDelayShowTimeMillis && this.dialogMaxShowTimes == topTabBubbleConfig.dialogMaxShowTimes && this.sameIdDialogMaxShowTimes == topTabBubbleConfig.sameIdDialogMaxShowTimes;
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.dialogShowTimeMillis) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.dialogDelayShowTimeMillis)) * 31) + this.dialogMaxShowTimes) * 31) + this.sameIdDialogMaxShowTimes;
    }

    public String toString() {
        long j = this.dialogShowTimeMillis;
        long j2 = this.dialogDelayShowTimeMillis;
        int i = this.dialogMaxShowTimes;
        return "TopTabBubbleConfig(dialogShowTimeMillis=" + j + ", dialogDelayShowTimeMillis=" + j2 + ", dialogMaxShowTimes=" + i + ", sameIdDialogMaxShowTimes=" + this.sameIdDialogMaxShowTimes + ")";
    }

    public TopTabBubbleConfig(long dialogShowTimeMillis, long dialogDelayShowTimeMillis, int dialogMaxShowTimes, int sameIdDialogMaxShowTimes) {
        this.dialogShowTimeMillis = dialogShowTimeMillis;
        this.dialogDelayShowTimeMillis = dialogDelayShowTimeMillis;
        this.dialogMaxShowTimes = dialogMaxShowTimes;
        this.sameIdDialogMaxShowTimes = sameIdDialogMaxShowTimes;
    }

    public /* synthetic */ TopTabBubbleConfig(long j, long j2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 5000L : j, (i3 & 2) != 0 ? 3000L : j2, (i3 & 4) != 0 ? 1 : i, (i3 & 8) != 0 ? 1 : i2);
    }

    public final long getDialogShowTimeMillis() {
        return this.dialogShowTimeMillis;
    }

    public final void setDialogShowTimeMillis(long j) {
        this.dialogShowTimeMillis = j;
    }

    public final long getDialogDelayShowTimeMillis() {
        return this.dialogDelayShowTimeMillis;
    }

    public final void setDialogDelayShowTimeMillis(long j) {
        this.dialogDelayShowTimeMillis = j;
    }

    public final int getDialogMaxShowTimes() {
        return this.dialogMaxShowTimes;
    }

    public final void setDialogMaxShowTimes(int i) {
        this.dialogMaxShowTimes = i;
    }

    public final int getSameIdDialogMaxShowTimes() {
        return this.sameIdDialogMaxShowTimes;
    }

    public final void setSameIdDialogMaxShowTimes(int i) {
        this.sameIdDialogMaxShowTimes = i;
    }
}