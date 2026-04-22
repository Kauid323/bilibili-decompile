package kntr.app.im.chat.core.service;

import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: FusionChatInfoService.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010R0\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00040\u0003X¦\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/FusionChatInfoService;", RoomRecommendViewModel.EMPTY_CURSOR, "dataFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Pair;", "Lkotlin/Result;", "Lkntr/app/im/chat/core/model/ChatInfo;", "Lkntr/app/im/chat/core/service/LoadType;", "getDataFlow$annotations", "()V", "getDataFlow", "()Lkotlinx/coroutines/flow/Flow;", "load", RoomRecommendViewModel.EMPTY_CURSOR, "refresh", RoomRecommendViewModel.EMPTY_CURSOR, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FusionChatInfoService {
    Flow<Pair<Result<ChatInfo>, LoadType>> getDataFlow();

    Object load(boolean z, Continuation<? super Unit> continuation);

    /* compiled from: FusionChatInfoService.kt */
    /* renamed from: kntr.app.im.chat.core.service.FusionChatInfoService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object load$default(FusionChatInfoService fusionChatInfoService, boolean z, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                return fusionChatInfoService.load(z, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: load");
        }
    }

    /* compiled from: FusionChatInfoService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getDataFlow$annotations() {
        }
    }
}