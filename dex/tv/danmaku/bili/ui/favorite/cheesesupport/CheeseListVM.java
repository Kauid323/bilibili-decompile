package tv.danmaku.bili.ui.favorite.cheesesupport;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bilibili.api.BiliApiException;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.okretro.call.rxjava.DisposableHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: CheeseListVM.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0005\b'\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001eH&J\u0010\u0010 \u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\"\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u001eJ\b\u0010'\u001a\u00020\u001eH\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R'\u0010\u0012\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0015`\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "isLoading", "", "()Z", "setLoading", "(Z)V", "hasMoreData", "getHasMoreData", "setHasMoreData", LoginReporterV2.PAGE_FROM_KEY, "", "getPage", "()I", "setPage", "(I)V", "itemList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bilibili/lib/arch/lifecycle/Resource;", "Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseList;", "Lcom/bilibili/lib/arch/lifecycle/MutableLiveResource;", "getItemList", "()Landroidx/lifecycle/MutableLiveData;", "disposableHelper", "Lcom/bilibili/okretro/call/rxjava/DisposableHelper;", "getDisposableHelper", "()Lcom/bilibili/okretro/call/rxjava/DisposableHelper;", "loadNextPage", "", "doRequest", "onRequestSuccess", "data", "onRequestError", "t", "", "isFirstPage", "resetRequestParam", "onCleared", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class CheeseListVM extends ViewModel {
    public static final int PAGE_SIZE = 20;
    private final DisposableHelper disposableHelper;
    private boolean isLoading;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private boolean hasMoreData = true;
    private int page = 1;
    private final MutableLiveData<Resource<CheeseList>> itemList = new MutableLiveData<>();

    public abstract void doRequest();

    public CheeseListVM() {
        DisposableHelper $this$disposableHelper_u24lambda_u240 = new DisposableHelper();
        $this$disposableHelper_u24lambda_u240.activate();
        this.disposableHelper = $this$disposableHelper_u24lambda_u240;
    }

    protected final boolean isLoading() {
        return this.isLoading;
    }

    protected final void setLoading(boolean z) {
        this.isLoading = z;
    }

    protected final boolean getHasMoreData() {
        return this.hasMoreData;
    }

    protected final void setHasMoreData(boolean z) {
        this.hasMoreData = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getPage() {
        return this.page;
    }

    protected final void setPage(int i) {
        this.page = i;
    }

    public final MutableLiveData<Resource<CheeseList>> getItemList() {
        return this.itemList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DisposableHelper getDisposableHelper() {
        return this.disposableHelper;
    }

    public final boolean hasMoreData() {
        return this.hasMoreData;
    }

    public final void loadNextPage() {
        if (this.isLoading || !this.hasMoreData) {
            return;
        }
        MutableLiveData<Resource<CheeseList>> mutableLiveData = this.itemList;
        Resource.Companion companion = Resource.Companion;
        Resource resource = (Resource) this.itemList.getValue();
        mutableLiveData.setValue(companion.loading(resource != null ? (CheeseList) resource.getData() : null));
        if (ConnectivityMonitor.getInstance().isNetworkActive()) {
            this.isLoading = true;
            doRequest();
            return;
        }
        this.isLoading = false;
        this.itemList.setValue(Resource.Companion.error(new BiliApiException()));
    }

    public final void onRequestSuccess(CheeseList data) {
        CheesePageInfo cheesePageInfo;
        boolean z = false;
        this.isLoading = false;
        if (data != null && (cheesePageInfo = data.page) != null && cheesePageInfo.hasNextPage) {
            z = true;
        }
        this.hasMoreData = z;
        this.itemList.setValue(Resource.Companion.success(data));
        this.page++;
    }

    public final void onRequestError(Throwable t) {
        this.isLoading = false;
        this.itemList.setValue(Resource.Companion.error(new BiliApiException()));
    }

    public final boolean isFirstPage() {
        return this.page == 1;
    }

    public final void resetRequestParam() {
        this.page = 1;
        this.hasMoreData = true;
    }

    /* compiled from: CheeseListVM.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListVM$Companion;", "", "<init>", "()V", "PAGE_SIZE", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onCleared() {
        super.onCleared();
        this.disposableHelper.deactivate();
    }
}