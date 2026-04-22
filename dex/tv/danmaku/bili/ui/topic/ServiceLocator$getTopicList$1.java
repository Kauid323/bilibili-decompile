package tv.danmaku.bili.ui.topic;

import androidx.lifecycle.LiveData;
import com.bilibili.lib.arch.lifecycle.Resource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import tv.danmaku.bili.ui.topic.api.BiliTopicList;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServiceLocator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final /* synthetic */ class ServiceLocator$getTopicList$1 extends FunctionReferenceImpl implements Function1<Integer, LiveData<Resource<? extends BiliTopicList>>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceLocator$getTopicList$1(Object obj) {
        super(1, obj, TopicRepository.class, "loadTopicList", "loadTopicList$topic_debug(I)Landroidx/lifecycle/LiveData;", 0);
    }

    public final LiveData<Resource<BiliTopicList>> invoke(int p0) {
        return ((TopicRepository) this.receiver).loadTopicList$topic_debug(p0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).intValue());
    }
}