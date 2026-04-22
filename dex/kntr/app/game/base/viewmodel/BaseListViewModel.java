package kntr.app.game.base.viewmodel;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseListViewModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u0017R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lkntr/app/game/base/viewmodel/BaseListViewModel;", "Data", "Lkntr/app/game/base/viewmodel/BaseViewModel;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "value", RoomRecommendViewModel.EMPTY_CURSOR, "page", "getPage", "()I", "mergeData", "old", "new", "loadData", "refresh", RoomRecommendViewModel.EMPTY_CURSOR, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkEmpty", "data", "onDataSuccess", RoomRecommendViewModel.EMPTY_CURSOR, "loadPage", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BaseListViewModel<Data> extends BaseViewModel<List<? extends Data>> {
    public static final int $stable = 8;
    private int page = 1;

    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    public Object loadData(boolean z, Continuation<? super List<? extends Data>> continuation) {
        return loadData$suspendImpl(this, z, continuation);
    }

    public abstract Object loadPage(int i, Continuation<? super List<? extends Data>> continuation);

    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    public /* bridge */ /* synthetic */ boolean checkEmpty(Object data) {
        return checkEmpty((List) ((List) data));
    }

    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    public /* bridge */ /* synthetic */ Object mergeData(Object old, Object obj) {
        return mergeData((List) ((List) old), (List) ((List) obj));
    }

    protected final int getPage() {
        return this.page;
    }

    protected List<Data> mergeData(List<? extends Data> list, List<? extends Data> list2) {
        Intrinsics.checkNotNullParameter(list, "old");
        Intrinsics.checkNotNullParameter(list2, "new");
        return CollectionsKt.plus(list, list2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <Data> Object loadData$suspendImpl(BaseListViewModel<Data> baseListViewModel, boolean refresh, Continuation<? super List<? extends Data>> continuation) {
        BaseListViewModel$loadData$1 baseListViewModel$loadData$1;
        Object loadPage;
        if (continuation instanceof BaseListViewModel$loadData$1) {
            baseListViewModel$loadData$1 = (BaseListViewModel$loadData$1) continuation;
            if ((baseListViewModel$loadData$1.label & Integer.MIN_VALUE) != 0) {
                baseListViewModel$loadData$1.label -= Integer.MIN_VALUE;
                Object $result = baseListViewModel$loadData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (baseListViewModel$loadData$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (refresh) {
                            ((BaseListViewModel) baseListViewModel).page = 1;
                        }
                        int i = ((BaseListViewModel) baseListViewModel).page;
                        baseListViewModel$loadData$1.L$0 = SpillingKt.nullOutSpilledVariable(baseListViewModel);
                        baseListViewModel$loadData$1.Z$0 = refresh;
                        baseListViewModel$loadData$1.label = 1;
                        loadPage = baseListViewModel.loadPage(i, baseListViewModel$loadData$1);
                        if (loadPage == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        boolean refresh2 = baseListViewModel$loadData$1.Z$0;
                        BaseListViewModel baseListViewModel2 = (BaseListViewModel) baseListViewModel$loadData$1.L$0;
                        ResultKt.throwOnFailure($result);
                        loadPage = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List data = (List) loadPage;
                return data;
            }
        }
        baseListViewModel$loadData$1 = new BaseListViewModel$loadData$1(baseListViewModel, continuation);
        Object $result2 = baseListViewModel$loadData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (baseListViewModel$loadData$1.label) {
        }
        List data2 = (List) loadPage;
        return data2;
    }

    public boolean checkEmpty(List<? extends Data> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        return list.isEmpty();
    }

    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    protected void onDataSuccess() {
        this.page++;
    }
}