package tv.danmaku.bili.ui.topic;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.arch.lifecycle.BiliCallWrapper;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.topic.api.BiliTopicList;
import tv.danmaku.bili.ui.topic.api.TopicApiService;
import tv.danmaku.bili.ui.topic.api.TopicModelKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TopicRepository.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u0010\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J+\u0010\u0018\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0019J2\u0010\u001a\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001d0\u001cH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/topic/TopicRepository;", "", "app", "Landroid/app/Application;", "apiService", "Ltv/danmaku/bili/ui/topic/api/TopicApiService;", "<init>", "(Landroid/app/Application;Ltv/danmaku/bili/ui/topic/api/TopicApiService;)V", "getApiService", "()Ltv/danmaku/bili/ui/topic/api/TopicApiService;", "_accessKey", "", "get_accessKey", "()Ljava/lang/String;", "_accessKey$delegate", "Lkotlin/Lazy;", "loadActivityList", "Landroidx/lifecycle/LiveData;", "Lcom/bilibili/lib/arch/lifecycle/Resource;", "Ltv/danmaku/bili/ui/topic/api/BiliTopicList;", "Lcom/bilibili/lib/arch/lifecycle/LiveResource;", "page", "", "loadActivityList$topic_debug", "loadTopicList", "loadTopicList$topic_debug", "topicListResource", "call", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Companion", "topic_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TopicRepository {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final int PAGE_LIMIT = 20;
    private final Lazy _accessKey$delegate;
    private final TopicApiService apiService;

    public TopicRepository(final Application app, TopicApiService apiService) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        this.apiService = apiService;
        this._accessKey$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.topic.TopicRepository$$ExternalSyntheticLambda1
            public final Object invoke() {
                String _accessKey_delegate$lambda$0;
                _accessKey_delegate$lambda$0 = TopicRepository._accessKey_delegate$lambda$0(app);
                return _accessKey_delegate$lambda$0;
            }
        });
    }

    public final TopicApiService getApiService() {
        return this.apiService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _accessKey_delegate$lambda$0(Application $app) {
        return BiliAccounts.get($app).getAccessKey();
    }

    private final String get_accessKey() {
        return (String) this._accessKey$delegate.getValue();
    }

    public final LiveData<Resource<BiliTopicList>> loadActivityList$topic_debug(int page) {
        BiliCall<GeneralResponse<BiliTopicList>> parser = this.apiService.loadActivity(get_accessKey(), page, 20).setParser(TopicParser.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(parser, "setParser(...)");
        return topicListResource(parser);
    }

    public final LiveData<Resource<BiliTopicList>> loadTopicList$topic_debug(int page) {
        BiliCall<GeneralResponse<BiliTopicList>> parser = this.apiService.loadTopics(get_accessKey(), page, 20).setParser(TopicParser.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(parser, "setParser(...)");
        return topicListResource(parser);
    }

    /* compiled from: TopicRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/topic/TopicRepository$Companion;", "", "<init>", "()V", "PAGE_LIMIT", "", "topic_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final LiveData<Resource<BiliTopicList>> topicListResource(BiliCall<GeneralResponse<BiliTopicList>> biliCall) {
        return BiliCallWrapper.liveGeneralResource$default(biliCall, new Function1() { // from class: tv.danmaku.bili.ui.topic.TopicRepository$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Resource resource;
                resource = TopicRepository.topicListResource$lambda$0((BiliTopicList) obj);
                return resource;
            }
        }, (Function1) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Resource topicListResource$lambda$0(BiliTopicList data) {
        return (data != null ? data.topics : null) == null ? Resource.Companion.error(new NullPointerException()) : TopicModelKt.isIllegalList(data) ? Resource.Companion.error(new IndexOutOfBoundsException()) : Resource.Companion.success(data);
    }
}