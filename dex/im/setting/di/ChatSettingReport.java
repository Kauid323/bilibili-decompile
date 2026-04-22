package im.setting.di;

import com.bapis.bilibili.app.im.v1.KSessionId;
import dagger.Module;
import dagger.Provides;
import im.setting.service.ChatSettingReportService;
import im.setting.service.SettingReportService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatSettingModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lim/setting/di/ChatSettingReport;", "", "<init>", "()V", "provideChatSettingReportService", "Lim/setting/service/SettingReportService;", "id", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class ChatSettingReport {
    public static final int $stable = 0;
    public static final ChatSettingReport INSTANCE = new ChatSettingReport();

    private ChatSettingReport() {
    }

    @Provides
    public final SettingReportService provideChatSettingReportService(KSessionId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new ChatSettingReportService(id);
    }
}