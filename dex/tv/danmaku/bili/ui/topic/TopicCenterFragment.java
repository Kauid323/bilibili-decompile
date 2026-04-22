package tv.danmaku.bili.ui.topic;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import bili.resource.homepage.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TopicFragments.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\r\u0010\n\u001a\u00020\u000bH\u0010¢\u0006\u0002\b\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/topic/TopicCenterFragment;", "Ltv/danmaku/bili/ui/topic/BaseTopicCenterFragment;", "<init>", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "createAdapter", "Ltv/danmaku/bili/ui/topic/TopicListAdapter;", "createAdapter$topic_debug", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "application", "Landroid/app/Application;", "topic_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TopicCenterFragment extends BaseTopicCenterFragment {
    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        setTitle(getString(R.string.homepage_global_string_169));
    }

    @Override // tv.danmaku.bili.ui.topic.BaseTopicCenterFragment
    public TopicListAdapter createAdapter$topic_debug() {
        return new TopicListAdapter(1111);
    }

    @Override // tv.danmaku.bili.ui.topic.BaseTopicCenterFragment
    public ViewModelProvider.Factory factory(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        return ServiceLocator.getViewModelFactory(ServiceLocator.getTopicList(application));
    }
}