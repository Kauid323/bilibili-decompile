package im.contact;

import androidx.compose.foundation.pager.PagerState;
import im.contact.model.IMContactActionTabChange;
import im.contact.model.IMContactPageData;
import io.ktor.sse.ServerSentEventKt;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
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
/* compiled from: IMContactPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.IMContactPageKt$IMContactPage$4$2$2$1", f = "IMContactPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMContactPageKt$IMContactPage$4$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMContactPageData $page;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ IMContactPageState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMContactPageKt$IMContactPage$4$2$2$1(PagerState pagerState, IMContactPageData iMContactPageData, IMContactPageState iMContactPageState, Continuation<? super IMContactPageKt$IMContactPage$4$2$2$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$page = iMContactPageData;
        this.$state = iMContactPageState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMContactPageKt$IMContactPage$4$2$2$1(this.$pagerState, this.$page, this.$state, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ILogger kLog = KLog_androidKt.getKLog();
                int currentPage = this.$pagerState.getCurrentPage();
                kLog.i(IMContactPageKt.TAG_PAGE, "Tab change to " + currentPage + ServerSentEventKt.SPACE + this.$page.getTabList().get(this.$pagerState.getCurrentPage()).getCurrentTab());
                this.$state.getEventHandler().getActionHandler().invoke(new IMContactActionTabChange(this.$page.getTabList().get(this.$pagerState.getCurrentPage()).getCurrentTab()));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}