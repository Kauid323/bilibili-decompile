package tv.danmaku.bili.growth;

import com.bilibili.login.GrowthLogConsumer;
import com.bilibili.login.GrowthLogData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;

/* compiled from: LogConsumer.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/growth/LogConsumer;", "Lcom/bilibili/login/GrowthLogConsumer;", "<init>", "()V", "_logs", "", "Lcom/bilibili/login/GrowthLogData;", "logs", "", "getLogs", "()Ljava/util/List;", "consume", "", AppConfig.HOST_TAG, "", "log", "level", "", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LogConsumer implements GrowthLogConsumer {
    private final List<GrowthLogData> _logs = new ArrayList();
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final LogConsumer instance = new LogConsumer();

    public List<GrowthLogData> getLogs() {
        return this._logs;
    }

    public void consume(String tag, String log, int level) {
        Intrinsics.checkNotNullParameter(tag, AppConfig.HOST_TAG);
        Intrinsics.checkNotNullParameter(log, "log");
        BLog.i(tag, log);
        this._logs.add(new GrowthLogData(Clock.System.INSTANCE.now().getEpochSeconds(), tag, log, level));
    }

    /* compiled from: LogConsumer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/growth/LogConsumer$Companion;", "", "<init>", "()V", "instance", "Ltv/danmaku/bili/growth/LogConsumer;", "getInstance", "()Ltv/danmaku/bili/growth/LogConsumer;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LogConsumer getInstance() {
            return LogConsumer.instance;
        }
    }
}