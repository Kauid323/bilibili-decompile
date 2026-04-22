package tv.danmaku.bili.ui.topic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.arch.lifecycle.Status;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.topic.api.BiliTopic;
import tv.danmaku.bili.ui.topic.api.BiliTopicList;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TopicViewModel.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0016B5\u0012,\u0010\u0002\u001a(\u0012\u0004\u0012\u00020\u0004\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0003j\u0002`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\u0013H\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/topic/TopicViewModel;", "Landroidx/lifecycle/ViewModel;", "useCase", "Lkotlin/Function1;", "", "Landroidx/lifecycle/LiveData;", "Lcom/bilibili/lib/arch/lifecycle/Resource;", "Ltv/danmaku/bili/ui/topic/api/BiliTopicList;", "Lcom/bilibili/lib/arch/lifecycle/LiveResource;", "Ltv/danmaku/bili/ui/topic/UseCase;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "nextPageHandler", "Ltv/danmaku/bili/ui/topic/TopicViewModel$NextPageHandler;", "viewState", "Ltv/danmaku/bili/ui/topic/ViewState;", "getViewState", "()Landroidx/lifecycle/LiveData;", "refresh", "", "nextPage", "onCleared", "NextPageHandler", "topic_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TopicViewModel extends ViewModel {
    private final NextPageHandler nextPageHandler;

    public TopicViewModel(Function1<? super Integer, ? extends LiveData<Resource<BiliTopicList>>> function1) {
        Intrinsics.checkNotNullParameter(function1, "useCase");
        this.nextPageHandler = new NextPageHandler(function1);
    }

    public final LiveData<ViewState> getViewState() {
        return this.nextPageHandler.getLoadState();
    }

    public final void refresh() {
        this.nextPageHandler.loadFirstPage();
    }

    public final void nextPage() {
        this.nextPageHandler.loadNextPage();
    }

    protected void onCleared() {
        this.nextPageHandler.reset();
    }

    /* compiled from: TopicViewModel.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B5\u0012,\u0010\u0004\u001a(\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b0\u0005j\u0002`\t¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0014\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0006\u0010\u001c\u001a\u00020\u0017R4\u0010\u0004\u001a(\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b0\u0005j\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/ui/topic/TopicViewModel$NextPageHandler;", "Landroidx/lifecycle/Observer;", "Lcom/bilibili/lib/arch/lifecycle/Resource;", "Ltv/danmaku/bili/ui/topic/api/BiliTopicList;", "useCase", "Lkotlin/Function1;", "", "Landroidx/lifecycle/LiveData;", "Lcom/bilibili/lib/arch/lifecycle/LiveResource;", "Ltv/danmaku/bili/ui/topic/UseCase;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "loadState", "Landroidx/lifecycle/MutableLiveData;", "Ltv/danmaku/bili/ui/topic/ViewState;", "getLoadState", "()Landroidx/lifecycle/MutableLiveData;", "currentPage", "totalPage", "pageData", "getData", "page", "loadFirstPage", "", "loadNextPage", "onChanged", "result", "unregister", "reset", "topic_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class NextPageHandler implements Observer<Resource<? extends BiliTopicList>> {
        private int currentPage;
        private final MutableLiveData<ViewState> loadState;
        private LiveData<Resource<BiliTopicList>> pageData;
        private int totalPage;
        private final Function1<Integer, LiveData<Resource<BiliTopicList>>> useCase;

        /* compiled from: TopicViewModel.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Status.values().length];
                try {
                    iArr[Status.LOADING.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Status.ERROR.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[Status.SUCCESS.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public NextPageHandler(Function1<? super Integer, ? extends LiveData<Resource<BiliTopicList>>> function1) {
            Intrinsics.checkNotNullParameter(function1, "useCase");
            this.useCase = function1;
            this.loadState = new MutableLiveData<>();
            this.currentPage = 1;
            this.totalPage = 1;
        }

        public final MutableLiveData<ViewState> getLoadState() {
            return this.loadState;
        }

        private final LiveData<Resource<BiliTopicList>> getData(int page) {
            return (LiveData) this.useCase.invoke(Integer.valueOf(page));
        }

        public final void loadFirstPage() {
            this.currentPage = 1;
            LiveData it = getData(this.currentPage);
            it.observeForever(this);
            this.pageData = it;
        }

        public final void loadNextPage() {
            ViewState viewState = (ViewState) this.loadState.getValue();
            boolean z = false;
            if (viewState != null && viewState.isLoading()) {
                z = true;
            }
            if (z) {
                return;
            }
            this.currentPage++;
            if (this.totalPage < this.currentPage) {
                this.currentPage--;
                MutableLiveData<ViewState> mutableLiveData = this.loadState;
                ViewState viewState2 = (ViewState) this.loadState.getValue();
                mutableLiveData.setValue(viewState2 != null ? ViewState.copy$default(viewState2, false, false, null, new NoMoreData(), 6, null) : null);
                return;
            }
            LiveData it = getData(this.currentPage);
            it.observeForever(this);
            this.pageData = it;
        }

        public void onChanged(Resource<BiliTopicList> resource) {
            ViewState state;
            ViewState state2;
            List<BiliTopic> emptyList;
            List topics;
            Intrinsics.checkNotNullParameter(resource, "result");
            switch (WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()]) {
                case 1:
                    boolean isFirstPage = this.currentPage == 1;
                    ViewState viewState = (ViewState) this.loadState.getValue();
                    if (viewState == null || (state = ViewState.copy$default(viewState, true, isFirstPage, null, null, 4, null)) == null) {
                        state = new ViewState(true, isFirstPage, null, null, 12, null);
                    }
                    this.loadState.setValue(state);
                    return;
                case 2:
                    unregister();
                    boolean isFirstPage2 = this.currentPage == 1;
                    ViewState viewState2 = (ViewState) this.loadState.getValue();
                    if (viewState2 == null || (state2 = ViewState.copy$default(viewState2, false, isFirstPage2, null, resource.getError(), 4, null)) == null) {
                        state2 = new ViewState(false, isFirstPage2, null, resource.getError(), 4, null);
                    }
                    this.loadState.setValue(state2);
                    if (this.currentPage > 1) {
                        this.currentPage--;
                        return;
                    }
                    return;
                case 3:
                    unregister();
                    Object data = resource.getData();
                    Intrinsics.checkNotNull(data);
                    BiliTopicList list = (BiliTopicList) data;
                    boolean isFirstPage3 = this.currentPage == 1;
                    this.totalPage = list.pages;
                    if (isFirstPage3) {
                        List list2 = list.topics;
                        if (list2 == null) {
                            list2 = CollectionsKt.emptyList();
                        }
                        topics = list2;
                    } else {
                        ViewState viewState3 = (ViewState) this.loadState.getValue();
                        if (viewState3 == null || (emptyList = viewState3.getData()) == null) {
                            emptyList = CollectionsKt.emptyList();
                        }
                        List<BiliTopic> list3 = list.topics;
                        Intrinsics.checkNotNull(list3);
                        topics = CollectionsKt.plus(emptyList, list3);
                    }
                    ViewState state3 = new ViewState(false, isFirstPage3, topics, null, 8, null);
                    this.loadState.setValue(state3);
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        private final void unregister() {
            LiveData<Resource<BiliTopicList>> liveData = this.pageData;
            if (liveData != null) {
                liveData.removeObserver(this);
            }
            this.pageData = null;
        }

        public final void reset() {
            unregister();
            this.loadState.setValue(new ViewState(false, false, CollectionsKt.emptyList(), null, 8, null));
        }
    }
}