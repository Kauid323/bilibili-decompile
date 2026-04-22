package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AdDanmakuEvent.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/BallAnswerState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INITIAL", "RIGHT", "WRONG", "GOTED", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum BallAnswerState {
    INITIAL(1),
    RIGHT(2),
    WRONG(3),
    GOTED(4);
    
    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<BallAnswerState> getEntries() {
        return $ENTRIES;
    }

    BallAnswerState(int value) {
        this.value = value;
    }

    public final int getValue() {
        return this.value;
    }
}