package im.session.base;

import com.bapis.bilibili.app.im.v1.KSessionId;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IMConversationDraftService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lim/session/base/IMConversationDraftService;", "", "observe", "Lkotlinx/coroutines/flow/Flow;", "Lim/session/base/ConversationDraftHolder;", "sessionID", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMConversationDraftService {
    Flow<ConversationDraftHolder> observe(KSessionId kSessionId);
}