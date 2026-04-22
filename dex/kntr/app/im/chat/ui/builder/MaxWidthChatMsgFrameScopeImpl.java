package kntr.app.im.chat.ui.builder;

import androidx.compose.ui.unit.Dp;
import kntr.app.im.chat.ui.neuron.CardReporter;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMsgFrameBuilder.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\tJ\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lkntr/app/im/chat/ui/builder/MaxWidthChatMsgFrameScopeImpl;", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;", "maxWidth", "Landroidx/compose/ui/unit/Dp;", "cardReporter", "Lkntr/app/im/chat/ui/neuron/CardReporter;", "<init>", "(FLkntr/app/im/chat/ui/neuron/CardReporter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMaxWidth-D9Ej5fM", "()F", "F", "getCardReporter", "()Lkntr/app/im/chat/ui/neuron/CardReporter;", "component1", "component1-D9Ej5fM", "component2", "copy", "copy-D5KLDUw", "(FLkntr/app/im/chat/ui/neuron/CardReporter;)Lkntr/app/im/chat/ui/builder/MaxWidthChatMsgFrameScopeImpl;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class MaxWidthChatMsgFrameScopeImpl implements ChatMsgFrameScope {
    private final CardReporter cardReporter;
    private final float maxWidth;

    public /* synthetic */ MaxWidthChatMsgFrameScopeImpl(float f, CardReporter cardReporter, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, cardReporter);
    }

    /* renamed from: copy-D5KLDUw$default  reason: not valid java name */
    public static /* synthetic */ MaxWidthChatMsgFrameScopeImpl m1729copyD5KLDUw$default(MaxWidthChatMsgFrameScopeImpl maxWidthChatMsgFrameScopeImpl, float f, CardReporter cardReporter, int i, Object obj) {
        if ((i & 1) != 0) {
            f = maxWidthChatMsgFrameScopeImpl.maxWidth;
        }
        if ((i & 2) != 0) {
            cardReporter = maxWidthChatMsgFrameScopeImpl.cardReporter;
        }
        return maxWidthChatMsgFrameScopeImpl.m1731copyD5KLDUw(f, cardReporter);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public final float m1730component1D9Ej5fM() {
        return this.maxWidth;
    }

    public final CardReporter component2() {
        return this.cardReporter;
    }

    /* renamed from: copy-D5KLDUw  reason: not valid java name */
    public final MaxWidthChatMsgFrameScopeImpl m1731copyD5KLDUw(float f, CardReporter cardReporter) {
        Intrinsics.checkNotNullParameter(cardReporter, "cardReporter");
        return new MaxWidthChatMsgFrameScopeImpl(f, cardReporter, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MaxWidthChatMsgFrameScopeImpl) {
            MaxWidthChatMsgFrameScopeImpl maxWidthChatMsgFrameScopeImpl = (MaxWidthChatMsgFrameScopeImpl) obj;
            return Dp.equals-impl0(this.maxWidth, maxWidthChatMsgFrameScopeImpl.maxWidth) && Intrinsics.areEqual(this.cardReporter, maxWidthChatMsgFrameScopeImpl.cardReporter);
        }
        return false;
    }

    public int hashCode() {
        return (Dp.hashCode-impl(this.maxWidth) * 31) + this.cardReporter.hashCode();
    }

    public String toString() {
        String str = Dp.toString-impl(this.maxWidth);
        return "MaxWidthChatMsgFrameScopeImpl(maxWidth=" + str + ", cardReporter=" + this.cardReporter + ")";
    }

    private MaxWidthChatMsgFrameScopeImpl(float maxWidth, CardReporter cardReporter) {
        Intrinsics.checkNotNullParameter(cardReporter, "cardReporter");
        this.maxWidth = maxWidth;
        this.cardReporter = cardReporter;
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgFrameScope
    /* renamed from: getMaxWidth-D9Ej5fM */
    public float mo1726getMaxWidthD9Ej5fM() {
        return this.maxWidth;
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgFrameScope
    public CardReporter getCardReporter() {
        return this.cardReporter;
    }
}