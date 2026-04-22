package im.contact.di;

import dagger.BindsInstance;
import dagger.Subcomponent;
import im.contact.IMContactViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IMContactComponent.kt */
@Subcomponent(modules = {})
@IMContactScope
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lim/contact/di/IMContactComponent;", "", "viewModel", "Lim/contact/IMContactViewModel;", "Factory", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMContactComponent {

    /* compiled from: IMContactComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lim/contact/di/IMContactComponent$Factory;", "", "create", "Lim/contact/di/IMContactComponent;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface Factory {
        IMContactComponent create(@BindsInstance @IMContactCoroutineScope CoroutineScope coroutineScope);
    }

    IMContactViewModel viewModel();
}