package kntr.base.dd.preview;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DDDebuggerPreview.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lkntr/base/dd/preview/ClickEvent;", "", "desc", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "ChangeEnv", "UpdateVersion", "FallbackVersion", "QueryDecideValue", "QueryPropertyValue", "ObserveKeyUpdate", "MockDecideValue", "MockPropertyValue", "ClearAllMockValue", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum ClickEvent {
    ChangeEnv("环境切换"),
    UpdateVersion("版本升级"),
    FallbackVersion("版本回滚"),
    QueryDecideValue("查询决策值"),
    QueryPropertyValue("查询设备指标值"),
    ObserveKeyUpdate("订阅决策值变化"),
    MockDecideValue("MOCK 决策值"),
    MockPropertyValue("MOCK 指标值"),
    ClearAllMockValue("清空所有Mock值");
    
    private final String desc;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<ClickEvent> getEntries() {
        return $ENTRIES;
    }

    ClickEvent(String desc) {
        this.desc = desc;
    }

    public final String getDesc() {
        return this.desc;
    }
}