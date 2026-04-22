package kntr.app.im.chat.core.model;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import kntr.app.im.chat.core.model.Messages;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessagesLens.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"0\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"0\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"0\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"F\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0016\u001a\u0004\b\f\u0010\u0017\"F\u0010\r\u001a\u0014\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017\"F\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017\"H\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001b\"H\u0010\r\u001a\u0014\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001b\"H\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u001b\"F\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010 \u001a\u0004\b\f\u0010!\"F\u0010\r\u001a\u0014\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010 \u001a\u0004\b\u0010\u0010!\"F\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010 \u001a\u0004\b\u0013\u0010!¨\u0006\""}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/im/chat/core/model/Messages;", "Lkntr/app/im/chat/core/model/Messages$Companion;", "getLens$annotations", "(Lkntr/app/im/chat/core/model/Messages$Companion;)V", "getLens", "(Lkntr/app/im/chat/core/model/Messages$Companion;)Lcom/bilibili/blens/BSimpleLens;", "entityMessages", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/EntityMessage;", "getEntityMessages$annotations", "getEntityMessages", "ghostMessages", "Lkntr/app/im/chat/core/model/GhostMessage;", "getGhostMessages$annotations", "getGhostMessages", "sendingMessages", "getSendingMessages$annotations", "getSendingMessages", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "entityMessagesNullable$annotations", "entityMessagesNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "ghostMessagesNullable$annotations", "ghostMessagesNullable", "sendingMessagesNullable$annotations", "sendingMessagesNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MessagesLensKt {
    public static /* synthetic */ void entityMessagesNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getEntityMessages$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getEntityMessages$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getEntityMessages$annotations(Messages.Companion companion) {
    }

    public static /* synthetic */ void getGhostMessages$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getGhostMessages$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getGhostMessages$annotations(Messages.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(Messages.Companion companion) {
    }

    public static /* synthetic */ void getSendingMessages$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSendingMessages$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSendingMessages$annotations(Messages.Companion companion) {
    }

    public static /* synthetic */ void ghostMessagesNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sendingMessagesNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<Messages, Messages> getLens(Messages.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<Messages, Messages>() { // from class: kntr.app.im.chat.core.model.MessagesLensKt$special$$inlined$invoke$1
            public Messages get(Messages messages) {
                Messages it = messages;
                return it;
            }

            public Messages set(Messages messages, Messages messages2) {
                Messages it = messages2;
                return it;
            }

            public Messages modify(Messages messages, Function1<? super Messages, ? extends Messages> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                Messages it = messages;
                return (Messages) function1.invoke(it);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<Messages, List<EntityMessage>> getEntityMessages(Messages.Companion $this$entityMessages) {
        Intrinsics.checkNotNullParameter($this$entityMessages, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<Messages, List<? extends EntityMessage>>() { // from class: kntr.app.im.chat.core.model.MessagesLensKt$special$$inlined$invoke$2
            public List<? extends EntityMessage> get(Messages messages) {
                Messages it = messages;
                return it.getEntityMessages();
            }

            public Messages set(Messages messages, List<? extends EntityMessage> list) {
                List<? extends EntityMessage> entityMessages = list;
                Messages it = messages;
                return Messages.copy$default(it, entityMessages, null, null, 6, null);
            }

            public Messages modify(Messages messages, Function1<? super List<? extends EntityMessage>, ? extends List<? extends EntityMessage>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                Messages it = messages;
                List entityMessages = (List) function1.invoke(it.getEntityMessages());
                Messages it2 = messages;
                return Messages.copy$default(it2, entityMessages, null, null, 6, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<Messages, List<GhostMessage>> getGhostMessages(Messages.Companion $this$ghostMessages) {
        Intrinsics.checkNotNullParameter($this$ghostMessages, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<Messages, List<? extends GhostMessage>>() { // from class: kntr.app.im.chat.core.model.MessagesLensKt$special$$inlined$invoke$3
            public List<? extends GhostMessage> get(Messages messages) {
                Messages it = messages;
                return it.getGhostMessages();
            }

            public Messages set(Messages messages, List<? extends GhostMessage> list) {
                List<? extends GhostMessage> ghostMessages = list;
                Messages it = messages;
                return Messages.copy$default(it, null, ghostMessages, null, 5, null);
            }

            public Messages modify(Messages messages, Function1<? super List<? extends GhostMessage>, ? extends List<? extends GhostMessage>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                Messages it = messages;
                List ghostMessages = (List) function1.invoke(it.getGhostMessages());
                Messages it2 = messages;
                return Messages.copy$default(it2, null, ghostMessages, null, 5, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<Messages, List<EntityMessage>> getSendingMessages(Messages.Companion $this$sendingMessages) {
        Intrinsics.checkNotNullParameter($this$sendingMessages, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<Messages, List<? extends EntityMessage>>() { // from class: kntr.app.im.chat.core.model.MessagesLensKt$special$$inlined$invoke$4
            public List<? extends EntityMessage> get(Messages messages) {
                Messages it = messages;
                return it.getSendingMessages();
            }

            public Messages set(Messages messages, List<? extends EntityMessage> list) {
                List<? extends EntityMessage> sendingMessages = list;
                Messages it = messages;
                return Messages.copy$default(it, null, null, sendingMessages, 3, null);
            }

            public Messages modify(Messages messages, Function1<? super List<? extends EntityMessage>, ? extends List<? extends EntityMessage>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                Messages it = messages;
                List sendingMessages = (List) function1.invoke(it.getSendingMessages());
                Messages it2 = messages;
                return Messages.copy$default(it2, null, null, sendingMessages, 3, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, List<EntityMessage>> getEntityMessages(BSimpleLens<T, Messages> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getEntityMessages(Messages.Companion));
    }

    public static final <T> BSimpleLens<T, List<GhostMessage>> getGhostMessages(BSimpleLens<T, Messages> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getGhostMessages(Messages.Companion));
    }

    public static final <T> BSimpleLens<T, List<EntityMessage>> getSendingMessages(BSimpleLens<T, Messages> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSendingMessages(Messages.Companion));
    }

    public static final <T> BNullableLens<T, List<EntityMessage>> entityMessagesNullable(BSimpleLens<T, Messages> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getEntityMessages(Messages.Companion));
    }

    public static final <T> BNullableLens<T, List<GhostMessage>> ghostMessagesNullable(BSimpleLens<T, Messages> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getGhostMessages(Messages.Companion));
    }

    public static final <T> BNullableLens<T, List<EntityMessage>> sendingMessagesNullable(BSimpleLens<T, Messages> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSendingMessages(Messages.Companion));
    }

    public static final <T> BNullableLens<T, List<EntityMessage>> getEntityMessages(BNullableLens<T, Messages> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getEntityMessages(Messages.Companion));
    }

    public static final <T> BNullableLens<T, List<GhostMessage>> getGhostMessages(BNullableLens<T, Messages> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getGhostMessages(Messages.Companion));
    }

    public static final <T> BNullableLens<T, List<EntityMessage>> getSendingMessages(BNullableLens<T, Messages> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSendingMessages(Messages.Companion));
    }
}