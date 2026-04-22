package kntr.app.im.chat.frame.rounded;

import com.bapis.bilibili.app.im.v1.KRoundCornerFrame;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.frame.rounded.RoundedCornerFrame;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoundedCornerFrameLens.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"0\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\t0\u0015\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u0010\u0012\u0004\u0012\u0002H\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018\"H\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0015\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u0010\u0012\u0004\u0012\u0002H\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0018\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\t0\u0015\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001b\u001a\u0004\b\u000b\u0010\u001c\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0015\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u0010\u0010\u001c¨\u0006\u001d"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/im/chat/frame/rounded/RoundedCornerFrame;", "Lkntr/app/im/chat/frame/rounded/RoundedCornerFrame$Companion;", "getLens$annotations", "(Lkntr/app/im/chat/frame/rounded/RoundedCornerFrame$Companion;)V", "getLens", "(Lkntr/app/im/chat/frame/rounded/RoundedCornerFrame$Companion;)Lcom/bilibili/blens/BSimpleLens;", "value", "Lcom/bapis/bilibili/app/im/v1/KRoundCornerFrame;", "getValue$annotations", "getValue", "modules", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MsgModule;", "getModules$annotations", "getModules", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "valueNullable$annotations", "valueNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "modulesNullable$annotations", "modulesNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RoundedCornerFrameLensKt {
    public static /* synthetic */ void getLens$annotations(RoundedCornerFrame.Companion companion) {
    }

    public static /* synthetic */ void getModules$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getModules$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getModules$annotations(RoundedCornerFrame.Companion companion) {
    }

    public static /* synthetic */ void getValue$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getValue$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getValue$annotations(RoundedCornerFrame.Companion companion) {
    }

    public static /* synthetic */ void modulesNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void valueNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<RoundedCornerFrame, RoundedCornerFrame> getLens(RoundedCornerFrame.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RoundedCornerFrame, RoundedCornerFrame>() { // from class: kntr.app.im.chat.frame.rounded.RoundedCornerFrameLensKt$special$$inlined$invoke$1
            public RoundedCornerFrame get(RoundedCornerFrame roundedCornerFrame) {
                RoundedCornerFrame it = roundedCornerFrame;
                return it;
            }

            public RoundedCornerFrame set(RoundedCornerFrame roundedCornerFrame, RoundedCornerFrame roundedCornerFrame2) {
                RoundedCornerFrame it = roundedCornerFrame2;
                return it;
            }

            public RoundedCornerFrame modify(RoundedCornerFrame roundedCornerFrame, Function1<? super RoundedCornerFrame, ? extends RoundedCornerFrame> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RoundedCornerFrame it = roundedCornerFrame;
                return (RoundedCornerFrame) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<RoundedCornerFrame, KRoundCornerFrame> getValue(RoundedCornerFrame.Companion $this$value) {
        Intrinsics.checkNotNullParameter($this$value, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RoundedCornerFrame, KRoundCornerFrame>() { // from class: kntr.app.im.chat.frame.rounded.RoundedCornerFrameLensKt$special$$inlined$invoke$2
            public KRoundCornerFrame get(RoundedCornerFrame roundedCornerFrame) {
                RoundedCornerFrame it = roundedCornerFrame;
                return it.getValue();
            }

            public RoundedCornerFrame set(RoundedCornerFrame roundedCornerFrame, KRoundCornerFrame kRoundCornerFrame) {
                KRoundCornerFrame value = kRoundCornerFrame;
                RoundedCornerFrame it = roundedCornerFrame;
                return RoundedCornerFrame.copy$default(it, value, null, 2, null);
            }

            public RoundedCornerFrame modify(RoundedCornerFrame roundedCornerFrame, Function1<? super KRoundCornerFrame, ? extends KRoundCornerFrame> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RoundedCornerFrame it = roundedCornerFrame;
                KRoundCornerFrame value = (KRoundCornerFrame) function1.invoke(it.getValue());
                RoundedCornerFrame it2 = roundedCornerFrame;
                return RoundedCornerFrame.copy$default(it2, value, null, 2, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<RoundedCornerFrame, List<MsgModule>> getModules(RoundedCornerFrame.Companion $this$modules) {
        Intrinsics.checkNotNullParameter($this$modules, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RoundedCornerFrame, List<? extends MsgModule>>() { // from class: kntr.app.im.chat.frame.rounded.RoundedCornerFrameLensKt$special$$inlined$invoke$3
            public List<? extends MsgModule> get(RoundedCornerFrame roundedCornerFrame) {
                RoundedCornerFrame it = roundedCornerFrame;
                return it.getModules();
            }

            public RoundedCornerFrame set(RoundedCornerFrame roundedCornerFrame, List<? extends MsgModule> list) {
                List<? extends MsgModule> modules = list;
                RoundedCornerFrame it = roundedCornerFrame;
                return RoundedCornerFrame.copy$default(it, null, modules, 1, null);
            }

            public RoundedCornerFrame modify(RoundedCornerFrame roundedCornerFrame, Function1<? super List<? extends MsgModule>, ? extends List<? extends MsgModule>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RoundedCornerFrame it = roundedCornerFrame;
                List modules = (List) function1.invoke(it.getModules());
                RoundedCornerFrame it2 = roundedCornerFrame;
                return RoundedCornerFrame.copy$default(it2, null, modules, 1, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, KRoundCornerFrame> getValue(BSimpleLens<T, RoundedCornerFrame> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getValue(RoundedCornerFrame.Companion));
    }

    public static final <T> BSimpleLens<T, List<MsgModule>> getModules(BSimpleLens<T, RoundedCornerFrame> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getModules(RoundedCornerFrame.Companion));
    }

    public static final <T> BNullableLens<T, KRoundCornerFrame> valueNullable(BSimpleLens<T, RoundedCornerFrame> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getValue(RoundedCornerFrame.Companion));
    }

    public static final <T> BNullableLens<T, List<MsgModule>> modulesNullable(BSimpleLens<T, RoundedCornerFrame> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getModules(RoundedCornerFrame.Companion));
    }

    public static final <T> BNullableLens<T, KRoundCornerFrame> getValue(BNullableLens<T, RoundedCornerFrame> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getValue(RoundedCornerFrame.Companion));
    }

    public static final <T> BNullableLens<T, List<MsgModule>> getModules(BNullableLens<T, RoundedCornerFrame> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getModules(RoundedCornerFrame.Companion));
    }
}