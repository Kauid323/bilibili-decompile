package im.session.di;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import dagger.BindsInstance;
import dagger.Subcomponent;
import im.session.IMSessionViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IMSecondaryComponent.kt */
@IMSessionScope
@Subcomponent(modules = {SecondaryDataSourceServiceModule.class, SecondaryComponentModule.class, IMSessionViewModelModule.class})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lim/session/di/SecondaryComponent;", "", "viewModel", "Lim/session/IMSessionViewModel;", "Builder", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SecondaryComponent {

    /* compiled from: IMSecondaryComponent.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lim/session/di/SecondaryComponent$Builder;", "", "build", "Lim/session/di/SecondaryComponent;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "type", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface Builder {
        SecondaryComponent build(@BindsInstance @IMSessionCoroutineScope CoroutineScope coroutineScope, @BindsInstance KSessionPageType kSessionPageType);
    }

    IMSessionViewModel viewModel();
}