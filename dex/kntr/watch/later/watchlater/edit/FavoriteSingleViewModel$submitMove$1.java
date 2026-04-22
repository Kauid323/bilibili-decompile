package kntr.watch.later.watchlater.edit;

import bili.resource.favorites.FavoritesRes;
import bili.resource.favorites.String0_commonMainKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.api.FavoritesApiKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoriteSingleViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.edit.FavoriteSingleViewModel$submitMove$1", f = "FavoriteSingleViewModel.kt", i = {0}, l = {151}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
public final class FavoriteSingleViewModel$submitMove$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FavFolder $folder;
    final /* synthetic */ Function0<Unit> $onRequestDismiss;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ String $resources;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FavoriteSingleViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoriteSingleViewModel$submitMove$1(FavoriteSingleViewModel favoriteSingleViewModel, String str, FavFolder favFolder, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super FavoriteSingleViewModel$submitMove$1> continuation) {
        super(2, continuation);
        this.this$0 = favoriteSingleViewModel;
        this.$resources = str;
        this.$folder = favFolder;
        this.$onSuccess = function0;
        this.$onRequestDismiss = function02;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> favoriteSingleViewModel$submitMove$1 = new FavoriteSingleViewModel$submitMove$1(this.this$0, this.$resources, this.$folder, this.$onSuccess, this.$onRequestDismiss, continuation);
        favoriteSingleViewModel$submitMove$1.L$0 = obj;
        return favoriteSingleViewModel$submitMove$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        MutableStateFlow mutableStateFlow5;
        CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        mutableStateFlow4 = this.this$0._isFavoriting;
                        mutableStateFlow4.setValue(Boxing.boxBoolean(true));
                        this.L$0 = $this$launch;
                        this.label = 1;
                        if (FavoritesApiKt.batchMoveResource(this.$resources, this.$folder.getId(), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                CoroutineScopeKt.ensureActive($this$launch);
                mutableStateFlow5 = this.this$0._toastMessage;
                mutableStateFlow5.setValue(FavoritesRes.INSTANCE.getString(String0_commonMainKt.getFavorites_global_string_48(FavoritesRes.INSTANCE.getString())));
                this.$onSuccess.invoke();
            } catch (Exception e) {
                CoroutineScopeKt.ensureActive($this$launch);
                this.$onRequestDismiss.invoke();
                mutableStateFlow2 = this.this$0._toastMessage;
                mutableStateFlow2.setValue(FavoritesRes.INSTANCE.getString(String0_commonMainKt.getFavorites_global_string_120(FavoritesRes.INSTANCE.getString())));
            }
            mutableStateFlow3 = this.this$0._isFavoriting;
            mutableStateFlow3.setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutableStateFlow = this.this$0._isFavoriting;
            mutableStateFlow.setValue(Boxing.boxBoolean(false));
            throw th;
        }
    }
}