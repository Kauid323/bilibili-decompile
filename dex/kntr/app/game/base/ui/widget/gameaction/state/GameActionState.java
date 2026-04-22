package kntr.app.game.base.ui.widget.gameaction.state;

import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.bilibili.biligame.kntr.common.util.NumberExtKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameActionState.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u00106\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR+\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u0012R+\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\u0018R+\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u001a\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R+\u0010\"\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u001a\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\u0018R+\u0010&\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\u001a\u001a\u0004\b'\u0010\n\"\u0004\b(\u0010\u0018R+\u0010*\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u0014\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u0012R+\u0010.\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0014\u001a\u0004\b/\u0010\f\"\u0004\b0\u0010\u0012R+\u00102\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\u001a\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 ¨\u00067"}, d2 = {"Lkntr/app/game/base/ui/widget/gameaction/state/GameActionState;", RoomRecommendViewModel.EMPTY_CURSOR, "gameBaseId", RoomRecommendViewModel.EMPTY_CURSOR, "pkgVer", RoomRecommendViewModel.EMPTY_CURSOR, "pkgName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getGameBaseId", "()Ljava/lang/String;", "getPkgVer", "()I", "getPkgName", "<set-?>", "action", "getAction", "setAction", "(I)V", "action$delegate", "Landroidx/compose/runtime/MutableIntState;", "mainText", "getMainText", "setMainText", "(Ljava/lang/String;)V", "mainText$delegate", "Landroidx/compose/runtime/MutableState;", RoomRecommendViewModel.EMPTY_CURSOR, "disable", "getDisable", "()Z", "setDisable", "(Z)V", "disable$delegate", "originPrice", "getOriginPrice", "setOriginPrice", "originPrice$delegate", "discountPrice", "getDiscountPrice", "setDiscountPrice", "discountPrice$delegate", "discount", "getDiscount", "setDiscount", "discount$delegate", "progress", "getProgress", "setProgress", "progress$delegate", "inDownload", "getInDownload", "setInDownload", "inDownload$delegate", "getButtonName", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameActionState {
    public static final int $stable = 0;
    private final MutableIntState action$delegate;
    private final MutableState disable$delegate;
    private final MutableIntState discount$delegate;
    private final MutableState discountPrice$delegate;
    private final String gameBaseId;
    private final MutableState inDownload$delegate;
    private final MutableState mainText$delegate;
    private final MutableState originPrice$delegate;
    private final String pkgName;
    private final int pkgVer;
    private final MutableIntState progress$delegate;

    public GameActionState(String gameBaseId, int pkgVer, String pkgName) {
        Intrinsics.checkNotNullParameter(gameBaseId, "gameBaseId");
        this.gameBaseId = gameBaseId;
        this.pkgVer = pkgVer;
        this.pkgName = pkgName;
        this.action$delegate = SnapshotIntStateKt.mutableIntStateOf(-1);
        this.mainText$delegate = SnapshotStateKt.mutableStateOf$default(RoomRecommendViewModel.EMPTY_CURSOR, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.disable$delegate = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.originPrice$delegate = SnapshotStateKt.mutableStateOf$default(RoomRecommendViewModel.EMPTY_CURSOR, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.discountPrice$delegate = SnapshotStateKt.mutableStateOf$default(RoomRecommendViewModel.EMPTY_CURSOR, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.discount$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.progress$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.inDownload$delegate = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final String getGameBaseId() {
        return this.gameBaseId;
    }

    public final int getPkgVer() {
        return this.pkgVer;
    }

    public final String getPkgName() {
        return this.pkgName;
    }

    public final int getAction() {
        IntState $this$getValue$iv = this.action$delegate;
        return $this$getValue$iv.getIntValue();
    }

    public final void setAction(int i) {
        MutableIntState $this$setValue$iv = this.action$delegate;
        $this$setValue$iv.setIntValue(i);
    }

    public final String getMainText() {
        State $this$getValue$iv = this.mainText$delegate;
        return (String) $this$getValue$iv.getValue();
    }

    public final void setMainText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        MutableState $this$setValue$iv = this.mainText$delegate;
        $this$setValue$iv.setValue(str);
    }

    public final boolean getDisable() {
        State $this$getValue$iv = this.disable$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setDisable(boolean z) {
        MutableState $this$setValue$iv = this.disable$delegate;
        Object value$iv = Boolean.valueOf(z);
        $this$setValue$iv.setValue(value$iv);
    }

    public final String getOriginPrice() {
        State $this$getValue$iv = this.originPrice$delegate;
        return (String) $this$getValue$iv.getValue();
    }

    public final void setOriginPrice(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        MutableState $this$setValue$iv = this.originPrice$delegate;
        $this$setValue$iv.setValue(str);
    }

    public final String getDiscountPrice() {
        State $this$getValue$iv = this.discountPrice$delegate;
        return (String) $this$getValue$iv.getValue();
    }

    public final void setDiscountPrice(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        MutableState $this$setValue$iv = this.discountPrice$delegate;
        $this$setValue$iv.setValue(str);
    }

    public final int getDiscount() {
        IntState $this$getValue$iv = this.discount$delegate;
        return $this$getValue$iv.getIntValue();
    }

    public final void setDiscount(int i) {
        MutableIntState $this$setValue$iv = this.discount$delegate;
        $this$setValue$iv.setIntValue(i);
    }

    public final int getProgress() {
        IntState $this$getValue$iv = this.progress$delegate;
        return $this$getValue$iv.getIntValue();
    }

    public final void setProgress(int i) {
        MutableIntState $this$setValue$iv = this.progress$delegate;
        $this$setValue$iv.setIntValue(i);
    }

    public final boolean getInDownload() {
        State $this$getValue$iv = this.inDownload$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setInDownload(boolean z) {
        MutableState $this$setValue$iv = this.inDownload$delegate;
        Object value$iv = Boolean.valueOf(z);
        $this$setValue$iv.setValue(value$iv);
    }

    public final String getButtonName() {
        if (getAction() == 5) {
            if (NumberExtKt.parseDouble$default(getDiscountPrice(), 0.0d, 1, (Object) null) == 0.0d) {
                return "限免";
            }
            return "¥" + getDiscountPrice();
        }
        return getMainText();
    }
}