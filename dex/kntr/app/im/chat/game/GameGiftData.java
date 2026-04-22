package kntr.app.im.chat.game;

import BottomSheetItemData$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameButtonInject.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lkntr/app/im/chat/game/GameGiftData;", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "highLight", RoomRecommendViewModel.EMPTY_CURSOR, "onClick", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "getText", "()Ljava/lang/String;", "getHighLight", "()Z", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "game_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameGiftData {
    public static final int $stable = 0;
    private final boolean highLight;
    private final Function0<Unit> onClick;
    private final String text;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameGiftData copy$default(GameGiftData gameGiftData, String str, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gameGiftData.text;
        }
        if ((i & 2) != 0) {
            z = gameGiftData.highLight;
        }
        if ((i & 4) != 0) {
            function0 = gameGiftData.onClick;
        }
        return gameGiftData.copy(str, z, function0);
    }

    public final String component1() {
        return this.text;
    }

    public final boolean component2() {
        return this.highLight;
    }

    public final Function0<Unit> component3() {
        return this.onClick;
    }

    public final GameGiftData copy(String str, boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return new GameGiftData(str, z, function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameGiftData) {
            GameGiftData gameGiftData = (GameGiftData) obj;
            return Intrinsics.areEqual(this.text, gameGiftData.text) && this.highLight == gameGiftData.highLight && Intrinsics.areEqual(this.onClick, gameGiftData.onClick);
        }
        return false;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.highLight)) * 31) + this.onClick.hashCode();
    }

    public String toString() {
        String str = this.text;
        boolean z = this.highLight;
        return "GameGiftData(text=" + str + ", highLight=" + z + ", onClick=" + this.onClick + ")";
    }

    public GameGiftData(String text, boolean highLight, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.text = text;
        this.highLight = highLight;
        this.onClick = function0;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean getHighLight() {
        return this.highLight;
    }

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }
}