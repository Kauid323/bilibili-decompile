package im.setting.di;

import dagger.Module;
import dagger.Provides;
import im.setting.service.IMSettingReportService;
import im.setting.service.SettingReportService;
import kotlin.Metadata;

/* compiled from: IMSettingModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lim/setting/di/IMSettingReportModule;", "", "<init>", "()V", "provideIMSettingReportService", "Lim/setting/service/SettingReportService;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class IMSettingReportModule {
    public static final int $stable = 0;
    public static final IMSettingReportModule INSTANCE = new IMSettingReportModule();

    private IMSettingReportModule() {
    }

    @Provides
    public final SettingReportService provideIMSettingReportService() {
        return new IMSettingReportService();
    }
}