package im.setting.di;

import dagger.Binds;
import dagger.Module;
import im.setting.service.ChatSettingChangeServiceImpl;
import im.setting.service.ChatSettingNotifyServiceImpl;
import im.setting.service.ChatSettingRequestServiceImpl;
import im.setting.service.SettingChangeService;
import im.setting.service.SettingNotifyService;
import im.setting.service.SettingRequestService;
import kotlin.Metadata;

/* compiled from: ChatSettingModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lim/setting/di/ChatSettingModule;", "", "chatSettingRequestService", "Lim/setting/service/SettingRequestService;", "impl", "Lim/setting/service/ChatSettingRequestServiceImpl;", "chatSettingChangeService", "Lim/setting/service/SettingChangeService;", "Lim/setting/service/ChatSettingChangeServiceImpl;", "chatSettingNotifyService", "Lim/setting/service/SettingNotifyService;", "Lim/setting/service/ChatSettingNotifyServiceImpl;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public interface ChatSettingModule {
    @Binds
    SettingChangeService chatSettingChangeService(ChatSettingChangeServiceImpl chatSettingChangeServiceImpl);

    @Binds
    SettingNotifyService chatSettingNotifyService(ChatSettingNotifyServiceImpl chatSettingNotifyServiceImpl);

    @Binds
    SettingRequestService chatSettingRequestService(ChatSettingRequestServiceImpl chatSettingRequestServiceImpl);
}