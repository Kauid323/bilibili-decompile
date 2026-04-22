package kntr.app.tribee.consume.page;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.State;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kntr.app.tribee.consume.page.model.TribeeDynListState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.page.TribeeHomePageKt$TribeeHomePage$onUIAction$1$1$2", f = "TribeeHomePage.kt", i = {}, l = {173, 181}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeHomePageKt$TribeeHomePage$onUIAction$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ScrollState $pageScrollState;
    final /* synthetic */ State<TribeeHomeState> $pageState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeHomePageKt$TribeeHomePage$onUIAction$1$1$2(ScrollState scrollState, State<? extends TribeeHomeState> state, Continuation<? super TribeeHomePageKt$TribeeHomePage$onUIAction$1$1$2> continuation) {
        super(2, continuation);
        this.$pageScrollState = scrollState;
        this.$pageState = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeHomePageKt$TribeeHomePage$onUIAction$1$1$2(this.$pageScrollState, this.$pageState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        TribeeHomeContentState tribeeHomeContentState;
        Map<KTribeeCategory, TribeeDynListState> categoryList;
        Set<Map.Entry<KTribeeCategory, TribeeDynListState>> entrySet;
        Iterator<T> it;
        Object obj;
        Map.Entry entry;
        TribeeDynListState tribeeDynListState;
        LazyListState lazyListState;
        Map.Entry entry2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (ScrollState.animateScrollTo$default(this.$pageScrollState, 0, (AnimationSpec) null, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Object value = this.$pageState.getValue();
                tribeeHomeContentState = !(value instanceof TribeeHomeContentState) ? (TribeeHomeContentState) value : null;
                if (tribeeHomeContentState != null && (categoryList = tribeeHomeContentState.getCategoryList()) != null && (entrySet = categoryList.entrySet()) != null) {
                    State<TribeeHomeState> state = this.$pageState;
                    it = entrySet.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            Object next = it.next();
                            Map.Entry entry3 = (Map.Entry) next;
                            if (((KTribeeCategory) entry3.getKey()).getId() == ((TribeeHomeState) state.getValue()).getCategoryId()) {
                                entry2 = 1;
                                continue;
                            } else {
                                entry2 = null;
                                continue;
                            }
                            obj = entry2 != null ? next : null;
                        }
                    }
                    entry = (Map.Entry) obj;
                    if (entry != null && (tribeeDynListState = (TribeeDynListState) entry.getValue()) != null && (lazyListState = tribeeDynListState.getLazyListState()) != null) {
                        this.label = 2;
                        if (lazyListState.animateScrollToItem(0, 0, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                Object value2 = this.$pageState.getValue();
                if (!(value2 instanceof TribeeHomeContentState)) {
                }
                if (tribeeHomeContentState != null) {
                    State<TribeeHomeState> state2 = this.$pageState;
                    it = entrySet.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                        }
                        obj = entry2 != null ? next : null;
                        break;
                    }
                    entry = (Map.Entry) obj;
                    if (entry != null) {
                        this.label = 2;
                        if (lazyListState.animateScrollToItem(0, 0, (Continuation) this) == coroutine_suspended) {
                        }
                        break;
                    }
                    break;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}