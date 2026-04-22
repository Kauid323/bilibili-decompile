package im.setting.di;

import dagger.Binds;
import dagger.Module;
import im.setting.service.IMSettingChangeServiceImpl;
import im.setting.service.IMSettingNotifyServiceImpl;
import im.setting.service.IMSettingRequestServiceImpl;
import im.setting.service.SettingChangeService;
import im.setting.service.SettingNotifyService;
import im.setting.service.SettingRequestService;
import kotlin.Metadata;

/* compiled from: IMSettingModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lim/setting/di/IMSettingModule;", "", "imSettingRequestService", "Lim/setting/service/SettingRequestService;", "impl", "Lim/setting/service/IMSettingRequestServiceImpl;", "imSettingChangeService", "Lim/setting/service/SettingChangeService;", "Lim/setting/service/IMSettingChangeServiceImpl;", "imSettingNotifyService", "Lim/setting/service/SettingNotifyService;", "Lim/setting/service/IMSettingNotifyServiceImpl;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public interface IMSettingModule {
    @Binds
    SettingChangeService imSettingChangeService(IMSettingChangeServiceImpl iMSettingChangeServiceImpl);

    @Binds
    SettingNotifyService imSettingNotifyService(IMSettingNotifyServiceImpl iMSettingNotifyServiceImpl);

    @Binds
    SettingRequestService imSettingRequestService(IMSettingRequestServiceImpl iMSettingRequestServiceImpl);
}