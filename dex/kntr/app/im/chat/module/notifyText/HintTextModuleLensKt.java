package kntr.app.im.chat.module.notifyText;

import com.bapis.bilibili.app.im.v1.KMsgModule;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.im.chat.core.model.MessageSequence;
import kntr.app.im.chat.module.notifyText.HintTextModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: HintTextModuleLens.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\",\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\",\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0016\u001a\u0004\b\u000b\u0010\u0017\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017\"B\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\t0\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001b\"D\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0017\"D\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0017\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\t0\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010 \u001a\u0004\b\u000b\u0010!\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010 \u001a\u0004\b\u000f\u0010\"\"B\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010 \u001a\u0004\b\u0013\u0010\"¨\u0006#"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/im/chat/module/notifyText/HintTextModule;", "Lkntr/app/im/chat/module/notifyText/HintTextModule$Companion;", "getLens$annotations", "(Lkntr/app/im/chat/module/notifyText/HintTextModule$Companion;)V", "getLens", "(Lkntr/app/im/chat/module/notifyText/HintTextModule$Companion;)Lcom/bilibili/blens/BSimpleLens;", "value", "Lcom/bapis/bilibili/app/im/v1/KMsgModule$KHintTextModule;", "getValue$annotations", "getValue", "relatedMessage", "Lkntr/app/im/chat/core/model/MessageSequence;", "getRelatedMessage$annotations", "getRelatedMessage", "relatedTimeStamp", "Lkotlinx/datetime/Instant;", "getRelatedTimeStamp$annotations", "getRelatedTimeStamp", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "valueNullable$annotations", "valueNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "relatedMessageNullable$annotations", "relatedMessageNullable", "relatedTimeStampNullable$annotations", "relatedTimeStampNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HintTextModuleLensKt {
    public static /* synthetic */ void getLens$annotations(HintTextModule.Companion companion) {
    }

    public static /* synthetic */ void getRelatedMessage$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRelatedMessage$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRelatedMessage$annotations(HintTextModule.Companion companion) {
    }

    public static /* synthetic */ void getRelatedTimeStamp$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRelatedTimeStamp$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRelatedTimeStamp$annotations(HintTextModule.Companion companion) {
    }

    public static /* synthetic */ void getValue$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getValue$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getValue$annotations(HintTextModule.Companion companion) {
    }

    public static /* synthetic */ void relatedMessageNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void relatedTimeStampNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void valueNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<HintTextModule, HintTextModule> getLens(HintTextModule.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<HintTextModule, HintTextModule>() { // from class: kntr.app.im.chat.module.notifyText.HintTextModuleLensKt$special$$inlined$invoke$1
            public HintTextModule get(HintTextModule hintTextModule) {
                HintTextModule it = hintTextModule;
                return it;
            }

            public HintTextModule set(HintTextModule hintTextModule, HintTextModule hintTextModule2) {
                HintTextModule it = hintTextModule2;
                return it;
            }

            public HintTextModule modify(HintTextModule hintTextModule, Function1<? super HintTextModule, ? extends HintTextModule> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                HintTextModule it = hintTextModule;
                return (HintTextModule) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<HintTextModule, KMsgModule.KHintTextModule> getValue(HintTextModule.Companion $this$value) {
        Intrinsics.checkNotNullParameter($this$value, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<HintTextModule, KMsgModule.KHintTextModule>() { // from class: kntr.app.im.chat.module.notifyText.HintTextModuleLensKt$special$$inlined$invoke$2
            public KMsgModule.KHintTextModule get(HintTextModule hintTextModule) {
                HintTextModule it = hintTextModule;
                return it.getValue();
            }

            public HintTextModule set(HintTextModule hintTextModule, KMsgModule.KHintTextModule kHintTextModule) {
                KMsgModule.KHintTextModule value = kHintTextModule;
                HintTextModule it = hintTextModule;
                return HintTextModule.copy$default(it, value, null, null, 6, null);
            }

            public HintTextModule modify(HintTextModule hintTextModule, Function1<? super KMsgModule.KHintTextModule, ? extends KMsgModule.KHintTextModule> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                HintTextModule it = hintTextModule;
                KMsgModule.KHintTextModule value = (KMsgModule.KHintTextModule) function1.invoke(it.getValue());
                HintTextModule it2 = hintTextModule;
                return HintTextModule.copy$default(it2, value, null, null, 6, null);
            }
        };
    }

    public static final BSimpleLens<HintTextModule, MessageSequence> getRelatedMessage(HintTextModule.Companion $this$relatedMessage) {
        Intrinsics.checkNotNullParameter($this$relatedMessage, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<HintTextModule, MessageSequence>() { // from class: kntr.app.im.chat.module.notifyText.HintTextModuleLensKt$special$$inlined$invoke$3
            public MessageSequence get(HintTextModule hintTextModule) {
                HintTextModule it = hintTextModule;
                return it.getRelatedMessage();
            }

            public HintTextModule set(HintTextModule hintTextModule, MessageSequence messageSequence) {
                MessageSequence relatedMessage = messageSequence;
                HintTextModule it = hintTextModule;
                return HintTextModule.copy$default(it, null, relatedMessage, null, 5, null);
            }

            public HintTextModule modify(HintTextModule hintTextModule, Function1<? super MessageSequence, ? extends MessageSequence> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                HintTextModule it = hintTextModule;
                MessageSequence relatedMessage = (MessageSequence) function1.invoke(it.getRelatedMessage());
                HintTextModule it2 = hintTextModule;
                return HintTextModule.copy$default(it2, null, relatedMessage, null, 5, null);
            }
        };
    }

    public static final BSimpleLens<HintTextModule, Instant> getRelatedTimeStamp(HintTextModule.Companion $this$relatedTimeStamp) {
        Intrinsics.checkNotNullParameter($this$relatedTimeStamp, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<HintTextModule, Instant>() { // from class: kntr.app.im.chat.module.notifyText.HintTextModuleLensKt$special$$inlined$invoke$4
            public Instant get(HintTextModule hintTextModule) {
                HintTextModule it = hintTextModule;
                return it.getRelatedTimeStamp();
            }

            public HintTextModule set(HintTextModule hintTextModule, Instant instant) {
                Instant relatedTimeStamp = instant;
                HintTextModule it = hintTextModule;
                return HintTextModule.copy$default(it, null, null, relatedTimeStamp, 3, null);
            }

            public HintTextModule modify(HintTextModule hintTextModule, Function1<? super Instant, ? extends Instant> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                HintTextModule it = hintTextModule;
                Instant relatedTimeStamp = (Instant) function1.invoke(it.getRelatedTimeStamp());
                HintTextModule it2 = hintTextModule;
                return HintTextModule.copy$default(it2, null, null, relatedTimeStamp, 3, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, KMsgModule.KHintTextModule> getValue(BSimpleLens<T, HintTextModule> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getValue(HintTextModule.Companion));
    }

    public static final <T> BSimpleLens<T, MessageSequence> getRelatedMessage(BSimpleLens<T, HintTextModule> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getRelatedMessage(HintTextModule.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getRelatedTimeStamp(BSimpleLens<T, HintTextModule> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getRelatedTimeStamp(HintTextModule.Companion));
    }

    public static final <T> BNullableLens<T, KMsgModule.KHintTextModule> valueNullable(BSimpleLens<T, HintTextModule> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getValue(HintTextModule.Companion));
    }

    public static final <T> BSimpleLens<T, MessageSequence> relatedMessageNullable(BSimpleLens<T, HintTextModule> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getRelatedMessage(HintTextModule.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> relatedTimeStampNullable(BSimpleLens<T, HintTextModule> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getRelatedTimeStamp(HintTextModule.Companion));
    }

    public static final <T> BNullableLens<T, KMsgModule.KHintTextModule> getValue(BNullableLens<T, HintTextModule> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getValue(HintTextModule.Companion));
    }

    public static final <T> BSimpleLens<T, MessageSequence> getRelatedMessage(BNullableLens<T, HintTextModule> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getRelatedMessage(HintTextModule.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getRelatedTimeStamp(BNullableLens<T, HintTextModule> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getRelatedTimeStamp(HintTextModule.Companion));
    }
}