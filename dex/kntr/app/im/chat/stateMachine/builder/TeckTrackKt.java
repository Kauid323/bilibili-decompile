package kntr.app.im.chat.stateMachine.builder;

import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TeckTrack.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u00020\u0001R\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"bindTechTrack", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/im/chat/core/model/ChatPageData;", "Lkntr/app/im/chat/core/model/ChatAction;", "builder", "(Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;)V", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TeckTrackKt {
    public static final void bindTechTrack(InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "builder");
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.TeckTrackKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean bindTechTrack$lambda$0;
                bindTechTrack$lambda$0 = TeckTrackKt.bindTechTrack$lambda$0((ChatPageData) obj);
                return Boolean.valueOf(bindTechTrack$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.TeckTrackKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindTechTrack$lambda$1;
                bindTechTrack$lambda$1 = TeckTrackKt.bindTechTrack$lambda$1((ConditionBuilderBlock) obj);
                return bindTechTrack$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindTechTrack$lambda$0(ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTrack().getReadyToReport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindTechTrack$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnterEffect(new TeckTrackKt$bindTechTrack$2$1(null));
        return Unit.INSTANCE;
    }
}