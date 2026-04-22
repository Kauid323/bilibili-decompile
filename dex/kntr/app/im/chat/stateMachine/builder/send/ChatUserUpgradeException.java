package kntr.app.im.chat.stateMachine.builder.send;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KBusinessException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ChatUserUpgradeException.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \t2\u00060\u0001j\u0002`\u0002:\u0001\tB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lkntr/app/im/chat/stateMachine/builder/send/ChatUserUpgradeException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "cause", "Lkntr/base/moss/api/KBusinessException;", "<init>", "(Lkntr/base/moss/api/KBusinessException;)V", "getCause", "()Lkntr/base/moss/api/KBusinessException;", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatUserUpgradeException extends IllegalStateException {
    public static final int ERROR_CODE = 21016;
    private final KBusinessException cause;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ChatUserUpgradeException(KBusinessException cause) {
        super((Throwable) cause);
        this.cause = cause;
    }

    @Override // java.lang.Throwable
    public KBusinessException getCause() {
        return this.cause;
    }

    /* compiled from: ChatUserUpgradeException.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/app/im/chat/stateMachine/builder/send/ChatUserUpgradeException$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "ERROR_CODE", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}