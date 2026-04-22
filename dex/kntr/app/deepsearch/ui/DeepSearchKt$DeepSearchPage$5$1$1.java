package kntr.app.deepsearch.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearch.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.DeepSearchKt$DeepSearchPage$5$1$1", f = "DeepSearch.kt", i = {}, l = {242, 246}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchKt$DeepSearchPage$5$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<DeepSearchPageData> $data;
    final /* synthetic */ boolean $imeVisible;
    final /* synthetic */ MutableState<Boolean> $isShowingDialog$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchKt$DeepSearchPage$5$1$1(State<DeepSearchPageData> state, boolean z, MutableState<Boolean> mutableState, Continuation<? super DeepSearchKt$DeepSearchPage$5$1$1> continuation) {
        super(2, continuation);
        this.$data = state;
        this.$imeVisible = z;
        this.$isShowingDialog$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeepSearchKt$DeepSearchPage$5$1$1(this.$data, this.$imeVisible, this.$isShowingDialog$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean DeepSearchPage$lambda$6$1;
        boolean DeepSearchPage$lambda$6$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (((DeepSearchPageData) this.$data.getValue()).getTreadPopContent() != null) {
                    DeepSearchPage$lambda$6$12 = DeepSearchKt.DeepSearchPage$lambda$6$1(this.$isShowingDialog$delegate);
                    if (!DeepSearchPage$lambda$6$12) {
                        this.label = 1;
                        if (DelayKt.delay(30L, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        DeepSearchKt.DeepSearchPage$lambda$6$2(this.$isShowingDialog$delegate, true);
                        break;
                    }
                }
                if (((DeepSearchPageData) this.$data.getValue()).getTreadPopContent() == null) {
                    DeepSearchPage$lambda$6$1 = DeepSearchKt.DeepSearchPage$lambda$6$1(this.$isShowingDialog$delegate);
                    if (DeepSearchPage$lambda$6$1) {
                        if (!this.$imeVisible) {
                            DeepSearchKt.DeepSearchPage$lambda$6$2(this.$isShowingDialog$delegate, false);
                            break;
                        } else {
                            this.label = 2;
                            if (DelayKt.delay(750L, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            DeepSearchKt.DeepSearchPage$lambda$6$2(this.$isShowingDialog$delegate, false);
                            break;
                        }
                    }
                }
                DeepSearchKt.DeepSearchPage$lambda$6$2(this.$isShowingDialog$delegate, false);
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                DeepSearchKt.DeepSearchPage$lambda$6$2(this.$isShowingDialog$delegate, true);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                DeepSearchKt.DeepSearchPage$lambda$6$2(this.$isShowingDialog$delegate, false);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}