package kntr.app.game.base.ui.util;

import androidx.compose.ui.platform.ClipboardManager;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: ClipBoard.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/game/base/ui/util/AndroidClipboardManagerImpl;", "Lkntr/app/game/base/ui/util/GameClipboardManager;", "context", "Landroidx/compose/ui/platform/ClipboardManager;", "<init>", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "copyText", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AndroidClipboardManagerImpl implements GameClipboardManager {
    public static final int $stable = 8;
    private final ClipboardManager context;

    public AndroidClipboardManagerImpl(ClipboardManager context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // kntr.app.game.base.ui.util.GameClipboardManager
    public Object copyText(String text, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new AndroidClipboardManagerImpl$copyText$2(this, text, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}