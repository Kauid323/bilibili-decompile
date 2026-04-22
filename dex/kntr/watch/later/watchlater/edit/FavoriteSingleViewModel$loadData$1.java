package kntr.watch.later.watchlater.edit;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import bili.resource.favorites.FavoritesRes;
import bili.resource.favorites.String0_commonMainKt;
import com.bilibili.ktor.KApiResponse;
import com.bilibili.ktor.KApiResponseKt;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.api.FavoritesApiKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoriteSingleViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.edit.FavoriteSingleViewModel$loadData$1", f = "FavoriteSingleViewModel.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FavoriteSingleViewModel$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onFailed;
    final /* synthetic */ boolean $refresh;
    int label;
    final /* synthetic */ FavoriteSingleViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoriteSingleViewModel$loadData$1(FavoriteSingleViewModel favoriteSingleViewModel, Function0<Unit> function0, boolean z, Continuation<? super FavoriteSingleViewModel$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = favoriteSingleViewModel;
        this.$onFailed = function0;
        this.$refresh = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoriteSingleViewModel$loadData$1(this.this$0, this.$onFailed, this.$refresh, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        int i;
        Object createdPlaySetAll;
        Object response;
        SnapshotStateList snapshotStateList;
        int i2;
        SnapshotStateList snapshotStateList2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        mutableStateFlow3 = this.this$0._isLoading;
                        mutableStateFlow3.setValue(Boxing.boxBoolean(true));
                        i = this.this$0.pageIndex;
                        this.label = 1;
                        createdPlaySetAll = FavoritesApiKt.getCreatedPlaySetAll(i, 100, (Continuation) this);
                        if (createdPlaySetAll == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        createdPlaySetAll = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                response = KApiResponseKt.asResult((KApiResponse) createdPlaySetAll);
            } catch (Exception e) {
                mutableStateFlow2 = this.this$0._toastMessage;
                mutableStateFlow2.setValue(FavoritesRes.INSTANCE.getString(String0_commonMainKt.getFavorites_global_string_18(FavoritesRes.INSTANCE.getString())));
                Function0<Unit> function0 = this.$onFailed;
                if (function0 != null) {
                    function0.invoke();
                }
            }
            if (!Result.m2643isSuccessimpl(response)) {
                throw new IllegalStateException("Check failed.");
            }
            PlaySetPageData it = (PlaySetPageData) (Result.m2642isFailureimpl(response) ? null : response);
            if (it != null) {
                FavoriteSingleViewModel favoriteSingleViewModel = this.this$0;
                boolean z = this.$refresh;
                favoriteSingleViewModel.setTotalCount(it.getTotalCount());
                if (z) {
                    snapshotStateList2 = favoriteSingleViewModel._folders;
                    snapshotStateList2.clear();
                }
                snapshotStateList = favoriteSingleViewModel._folders;
                List<FavFolder> list = it.getList();
                if (list == null) {
                    list = CollectionsKt.emptyList();
                }
                snapshotStateList.addAll(list);
                favoriteSingleViewModel.checkNewCreate();
                i2 = favoriteSingleViewModel.pageIndex;
                favoriteSingleViewModel.pageIndex = i2 + 1;
            }
            return Unit.INSTANCE;
        } finally {
            mutableStateFlow = this.this$0._isLoading;
            mutableStateFlow.setValue(Boxing.boxBoolean(false));
        }
    }
}