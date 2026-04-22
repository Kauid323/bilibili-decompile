package im.setting.service;

import com.bapis.bilibili.app.im.v1.KSessionId;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingReportService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lim/setting/service/ChatSettingReportService;", "Lim/setting/service/SettingReportService;", "session", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;)V", "reportParam", "", "", "getReportParam", "()Ljava/util/Map;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatSettingReportService implements SettingReportService {
    public static final int $stable = 0;
    private final Map<String, String> reportParam;

    public ChatSettingReportService(KSessionId session) {
        String type;
        String name;
        Intrinsics.checkNotNullParameter(session, "session");
        KSessionId.IId id = session.getId();
        if (id instanceof KSessionId.KPrivateId) {
            type = "SESSION_TYPE_PRIVATE";
        } else {
            type = id instanceof KSessionId.KAssistantId ? "SESSION_TYPE_ASSISTANT_ID" : "";
        }
        KSessionId.KPrivateId id2 = session.getId();
        if (id2 instanceof KSessionId.KPrivateId) {
            name = String.valueOf(id2.getValue().getTalkerUid());
        } else {
            name = id2 instanceof KSessionId.KAssistantId ? ((KSessionId.KAssistantId) id2).getValue().getType().getName() : "";
        }
        String primaryId = name;
        KSessionId.KAssistantId id3 = session.getId();
        String secondaryId = id3 instanceof KSessionId.KAssistantId ? String.valueOf(id3.getValue().getTalkerUid()) : "";
        this.reportParam = MapsKt.mapOf(new Pair[]{TuplesKt.to("chat_type", type), TuplesKt.to("primary_id", primaryId), TuplesKt.to("secondary_id", secondaryId)});
    }

    @Override // im.setting.service.SettingReportService
    public Map<String, String> getReportParam() {
        return this.reportParam;
    }
}