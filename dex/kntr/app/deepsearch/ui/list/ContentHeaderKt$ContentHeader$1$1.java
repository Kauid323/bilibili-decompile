package kntr.app.deepsearch.ui.list;

import kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
/* compiled from: ContentHeader.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.list.ContentHeaderKt$ContentHeader$1$1", f = "ContentHeader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ContentHeaderKt$ContentHeader$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeepSearchPageChatState $chatState;
    final /* synthetic */ String $queryId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentHeaderKt$ContentHeader$1$1(String str, DeepSearchPageChatState deepSearchPageChatState, Continuation<? super ContentHeaderKt$ContentHeader$1$1> continuation) {
        super(2, continuation);
        this.$queryId = str;
        this.$chatState = deepSearchPageChatState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ContentHeaderKt$ContentHeader$1$1(this.$queryId, this.$chatState, continuation);
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
                String str = this.$queryId;
                DeepSearchPageChatState deepSearchPageChatState = this.$chatState;
                kLog.d("content_header", "query_id=" + str + ", chat_state=" + deepSearchPageChatState + ", anim=" + this.$chatState.avatarAnimated(this.$queryId));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}