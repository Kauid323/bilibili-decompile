package kntr.app.im.chat.ui.widget.sticky;

import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Confirmdialog.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦B¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/widget/sticky/OnConfirmDialogAction;", RoomRecommendViewModel.EMPTY_CURSOR, "invoke", RoomRecommendViewModel.EMPTY_CURSOR, "action", "Lkntr/app/im/chat/core/model/ChatAction;", "(Lkntr/app/im/chat/core/model/ChatAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OnConfirmDialogAction {
    Object invoke(ChatAction chatAction, Continuation<? super Unit> continuation);
}