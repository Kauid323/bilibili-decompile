package kntr.app.im.chat.core.service;

import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.db.entity.MessageEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.ranges.LongRange;
import kotlinx.coroutines.flow.Flow;
import kotlinx.datetime.Instant;

/* compiled from: DatabaseServices.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J(\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\bH&J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0096@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0096@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH¦@¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0019J\u001c\u0010$\u001a\u00020\u00162\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d0\tH¦@¢\u0006\u0002\u0010\u0018¨\u0006&À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/MessageDatabaseService;", RoomRecommendViewModel.EMPTY_CURSOR, "convertMessageToEntity", "Lkntr/app/im/chat/db/entity/MessageEntity;", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "queryInRangeAsList", "Lkotlin/Pair;", "Lkotlinx/datetime/Instant;", RoomRecommendViewModel.EMPTY_CURSOR, "range", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryInRangeAsFlow", "Lkotlinx/coroutines/flow/Flow;", "baselineTime", "querySequenceNumberInRange", RoomRecommendViewModel.EMPTY_CURSOR, "limit", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlin/ranges/LongRange;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "add", RoomRecommendViewModel.EMPTY_CURSOR, "messages", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkntr/app/im/chat/core/model/EntityMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateContent", "resend", "messageId", "Lkntr/app/im/chat/core/model/MessageId;", "newValue", "(Lkntr/app/im/chat/core/model/MessageId;Lkntr/app/im/chat/core/model/EntityMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendFailed", "(Lkntr/app/im/chat/core/model/MessageId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSuccess", "server", "batchSoftDeleteMessages", "messageIds", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MessageDatabaseService {
    Object add(List<EntityMessage> list, Continuation<? super Unit> continuation);

    Object add(EntityMessage entityMessage, Continuation<? super Unit> continuation);

    Object batchSoftDeleteMessages(List<MessageId> list, Continuation<? super Unit> continuation);

    MessageEntity convertMessageToEntity(EntityMessage entityMessage);

    Flow<List<EntityMessage>> queryInRangeAsFlow(LongRange longRange, Instant instant);

    Object queryInRangeAsList(LongRange longRange, Continuation<? super Pair<Instant, ? extends List<EntityMessage>>> continuation);

    Object querySequenceNumberInRange(LongRange longRange, int i, Continuation<? super List<Long>> continuation);

    Object resend(MessageId messageId, EntityMessage entityMessage, Continuation<? super Unit> continuation);

    Object sendFailed(MessageId messageId, Continuation<? super Unit> continuation);

    Object sendSuccess(EntityMessage entityMessage, Continuation<? super Unit> continuation);

    Object updateContent(List<EntityMessage> list, Continuation<? super Unit> continuation);

    Object updateContent(EntityMessage entityMessage, Continuation<? super Unit> continuation);

    /* compiled from: DatabaseServices.kt */
    /* renamed from: kntr.app.im.chat.core.service.MessageDatabaseService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ Object add$suspendImpl(MessageDatabaseService $this, List<EntityMessage> list, Continuation<? super Unit> continuation) {
            MessageDatabaseService$add$1 messageDatabaseService$add$1;
            int $i$f$forEach;
            Iterable $this$forEach$iv;
            Iterator it;
            if (continuation instanceof MessageDatabaseService$add$1) {
                messageDatabaseService$add$1 = (MessageDatabaseService$add$1) continuation;
                if ((messageDatabaseService$add$1.label & Integer.MIN_VALUE) != 0) {
                    messageDatabaseService$add$1.label -= Integer.MIN_VALUE;
                    Object $result = messageDatabaseService$add$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (messageDatabaseService$add$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            List<EntityMessage> $this$forEach$iv2 = list;
                            $i$f$forEach = 0;
                            $this$forEach$iv = $this$forEach$iv2;
                            it = $this$forEach$iv2.iterator();
                            break;
                        case 1:
                            int i = messageDatabaseService$add$1.I$1;
                            $i$f$forEach = messageDatabaseService$add$1.I$0;
                            EntityMessage entityMessage = (EntityMessage) messageDatabaseService$add$1.L$5;
                            Object obj = messageDatabaseService$add$1.L$4;
                            it = (Iterator) messageDatabaseService$add$1.L$3;
                            $this$forEach$iv = (Iterable) messageDatabaseService$add$1.L$2;
                            list = (List) messageDatabaseService$add$1.L$1;
                            $this = (MessageDatabaseService) messageDatabaseService$add$1.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    while (it.hasNext()) {
                        Object element$iv = it.next();
                        EntityMessage it2 = (EntityMessage) element$iv;
                        messageDatabaseService$add$1.L$0 = $this;
                        messageDatabaseService$add$1.L$1 = SpillingKt.nullOutSpilledVariable(list);
                        messageDatabaseService$add$1.L$2 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                        messageDatabaseService$add$1.L$3 = it;
                        messageDatabaseService$add$1.L$4 = SpillingKt.nullOutSpilledVariable(element$iv);
                        messageDatabaseService$add$1.L$5 = SpillingKt.nullOutSpilledVariable(it2);
                        messageDatabaseService$add$1.I$0 = $i$f$forEach;
                        messageDatabaseService$add$1.I$1 = 0;
                        messageDatabaseService$add$1.label = 1;
                        if ($this.add(it2, (Continuation<? super Unit>) messageDatabaseService$add$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            messageDatabaseService$add$1 = new MessageDatabaseService$add$1($this, continuation);
            Object $result2 = messageDatabaseService$add$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (messageDatabaseService$add$1.label) {
            }
            while (it.hasNext()) {
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ Object updateContent$suspendImpl(MessageDatabaseService $this, List<EntityMessage> list, Continuation<? super Unit> continuation) {
            MessageDatabaseService$updateContent$1 messageDatabaseService$updateContent$1;
            int $i$f$forEach;
            Iterable $this$forEach$iv;
            Iterator it;
            if (continuation instanceof MessageDatabaseService$updateContent$1) {
                messageDatabaseService$updateContent$1 = (MessageDatabaseService$updateContent$1) continuation;
                if ((messageDatabaseService$updateContent$1.label & Integer.MIN_VALUE) != 0) {
                    messageDatabaseService$updateContent$1.label -= Integer.MIN_VALUE;
                    Object $result = messageDatabaseService$updateContent$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (messageDatabaseService$updateContent$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            List<EntityMessage> $this$forEach$iv2 = list;
                            $i$f$forEach = 0;
                            $this$forEach$iv = $this$forEach$iv2;
                            it = $this$forEach$iv2.iterator();
                            break;
                        case 1:
                            int i = messageDatabaseService$updateContent$1.I$1;
                            $i$f$forEach = messageDatabaseService$updateContent$1.I$0;
                            EntityMessage entityMessage = (EntityMessage) messageDatabaseService$updateContent$1.L$5;
                            Object obj = messageDatabaseService$updateContent$1.L$4;
                            it = (Iterator) messageDatabaseService$updateContent$1.L$3;
                            $this$forEach$iv = (Iterable) messageDatabaseService$updateContent$1.L$2;
                            list = (List) messageDatabaseService$updateContent$1.L$1;
                            $this = (MessageDatabaseService) messageDatabaseService$updateContent$1.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    while (it.hasNext()) {
                        Object element$iv = it.next();
                        EntityMessage it2 = (EntityMessage) element$iv;
                        messageDatabaseService$updateContent$1.L$0 = $this;
                        messageDatabaseService$updateContent$1.L$1 = SpillingKt.nullOutSpilledVariable(list);
                        messageDatabaseService$updateContent$1.L$2 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                        messageDatabaseService$updateContent$1.L$3 = it;
                        messageDatabaseService$updateContent$1.L$4 = SpillingKt.nullOutSpilledVariable(element$iv);
                        messageDatabaseService$updateContent$1.L$5 = SpillingKt.nullOutSpilledVariable(it2);
                        messageDatabaseService$updateContent$1.I$0 = $i$f$forEach;
                        messageDatabaseService$updateContent$1.I$1 = 0;
                        messageDatabaseService$updateContent$1.label = 1;
                        if ($this.updateContent(it2, (Continuation<? super Unit>) messageDatabaseService$updateContent$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            messageDatabaseService$updateContent$1 = new MessageDatabaseService$updateContent$1($this, continuation);
            Object $result2 = messageDatabaseService$updateContent$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (messageDatabaseService$updateContent$1.label) {
            }
            while (it.hasNext()) {
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: DatabaseServices.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Object add(MessageDatabaseService $this, List<EntityMessage> list, Continuation<? super Unit> continuation) {
            return CC.add$suspendImpl($this, list, continuation);
        }

        @Deprecated
        public static Object updateContent(MessageDatabaseService $this, List<EntityMessage> list, Continuation<? super Unit> continuation) {
            return CC.updateContent$suspendImpl($this, list, continuation);
        }
    }
}