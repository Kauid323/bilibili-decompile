package tv.danmaku.bili.ui.topic.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TopicModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, d2 = {"isIllegalList", "", "Ltv/danmaku/bili/ui/topic/api/BiliTopicList;", "(Ltv/danmaku/bili/ui/topic/api/BiliTopicList;)Z", "topic_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TopicModelKt {
    public static final boolean isIllegalList(BiliTopicList $this$isIllegalList) {
        Intrinsics.checkNotNullParameter($this$isIllegalList, "<this>");
        return $this$isIllegalList.topics != null && $this$isIllegalList.topics.size() <= 3;
    }
}