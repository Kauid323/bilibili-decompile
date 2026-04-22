package tv.danmaku.bili.ui.topic;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.okretro.ServiceGenerator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import tv.danmaku.bili.ui.topic.api.BiliTopicList;
import tv.danmaku.bili.ui.topic.api.TopicApiService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ServiceLocator.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a6\u0010\u0000\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0005`\u00060\u0001j\u0002`\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a6\u0010\n\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0005`\u00060\u0001j\u0002`\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a6\u0010\u000b\u001a\u00020\f2,\u0010\r\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0005`\u00060\u0001j\u0002`\u0007H\u0000\"\u001a\u0010\u000e\u001a\u00020\u000f8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"getActivityList", "Lkotlin/Function1;", "", "Landroidx/lifecycle/LiveData;", "Lcom/bilibili/lib/arch/lifecycle/Resource;", "Ltv/danmaku/bili/ui/topic/api/BiliTopicList;", "Lcom/bilibili/lib/arch/lifecycle/LiveResource;", "Ltv/danmaku/bili/ui/topic/UseCase;", "application", "Landroid/app/Application;", "getTopicList", "getViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "useCase", "apiService", "Ltv/danmaku/bili/ui/topic/api/TopicApiService;", "getApiService$annotations", "()V", "getApiService", "()Ltv/danmaku/bili/ui/topic/api/TopicApiService;", "topic_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ServiceLocator {
    public static /* synthetic */ void getApiService$annotations() {
    }

    public static final Function1<Integer, LiveData<Resource<BiliTopicList>>> getActivityList(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        return new ServiceLocator$getActivityList$1(new TopicRepository(application, getApiService()));
    }

    public static final Function1<Integer, LiveData<Resource<BiliTopicList>>> getTopicList(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        return new ServiceLocator$getTopicList$1(new TopicRepository(application, getApiService()));
    }

    public static final ViewModelProvider.Factory getViewModelFactory(final Function1<? super Integer, ? extends LiveData<Resource<BiliTopicList>>> function1) {
        Intrinsics.checkNotNullParameter(function1, "useCase");
        return new ViewModelProvider.Factory() { // from class: tv.danmaku.bili.ui.topic.ServiceLocator$getViewModelFactory$1
            public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                return ViewModelProvider.Factory.-CC.$default$create(this, cls, creationExtras);
            }

            public /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
                return ViewModelProvider.Factory.-CC.$default$create(this, kClass, creationExtras);
            }

            public <T extends ViewModel> T create(Class<T> cls) {
                Intrinsics.checkNotNullParameter(cls, "modelClass");
                if (Intrinsics.areEqual(cls, TopicViewModel.class)) {
                    return new TopicViewModel(function1);
                }
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final TopicApiService getApiService() {
        Object createService = ServiceGenerator.createService(TopicApiService.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        return (TopicApiService) createService;
    }
}