package im.setting.di;

import im.setting.di.ChatSettingComponent;
import im.setting.di.IMSettingComponent;
import kotlin.Metadata;

/* compiled from: SettingModule.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lim/setting/di/SettingEntryPoint;", "", "getIMSettingComponentFactory", "Lim/setting/di/IMSettingComponent$Builder;", "getChatSettingComponentFactory", "Lim/setting/di/ChatSettingComponent$Builder;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SettingEntryPoint {
    ChatSettingComponent.Builder getChatSettingComponentFactory();

    IMSettingComponent.Builder getIMSettingComponentFactory();
}