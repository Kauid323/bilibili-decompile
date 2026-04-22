package im.setting.di;

import dagger.BindsInstance;
import dagger.Subcomponent;
import im.setting.SettingViewModel;
import im.setting.model.param.IMSettingInitializeParam;
import im.setting.service.SettingReportService;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IMSettingModule.kt */
@Subcomponent(modules = {IMSettingModule.class, IMSettingReportModule.class})
@SettingScope
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lim/setting/di/IMSettingComponent;", "", "viewModel", "Lim/setting/SettingViewModel;", "reportService", "Lim/setting/service/SettingReportService;", "Builder", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMSettingComponent {

    /* compiled from: IMSettingModule.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lim/setting/di/IMSettingComponent$Builder;", "", "build", "Lim/setting/di/IMSettingComponent;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "param", "Lim/setting/model/param/IMSettingInitializeParam;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface Builder {
        IMSettingComponent build(@BindsInstance @SettingCoroutineScope CoroutineScope coroutineScope, @BindsInstance IMSettingInitializeParam iMSettingInitializeParam);
    }

    SettingReportService reportService();

    SettingViewModel viewModel();
}