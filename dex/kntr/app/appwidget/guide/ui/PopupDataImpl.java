package kntr.app.appwidget.guide.ui;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppWidgetGuidePopupState.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001Ba\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\bH\u0016R\u001e\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\r\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0014\u0010\u000e\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lkntr/app/appwidget/guide/ui/PopupDataImpl;", "Lkntr/app/appwidget/guide/ui/PopupData;", "avatar", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "title", "subtitle", "forceDark", RoomRecommendViewModel.EMPTY_CURSOR, "offset", RoomRecommendViewModel.EMPTY_CURSOR, "durationms", RoomRecommendViewModel.EMPTY_CURSOR, "style", "outsideTouchable", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Lkntr/app/appwidget/guide/ui/PopupResult;", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZIJIZLkotlinx/coroutines/CancellableContinuation;)V", "getAvatar", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getSubtitle", "getForceDark", "()Z", "getOffset", "()I", "getDurationms", "()J", "getStyle", "getOutsideTouchable", "performAction", RoomRecommendViewModel.EMPTY_CURSOR, "dismiss", "auto", "guide_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PopupDataImpl implements PopupData {
    private final List<String> avatar;
    private final CancellableContinuation<PopupResult> continuation;
    private final long durationms;
    private final boolean forceDark;
    private final int offset;
    private final boolean outsideTouchable;
    private final int style;
    private final String subtitle;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public PopupDataImpl(List<String> list, String title, String subtitle, boolean forceDark, int offset, long durationms, int style, boolean outsideTouchable, CancellableContinuation<? super PopupResult> cancellableContinuation) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(cancellableContinuation, "continuation");
        this.avatar = list;
        this.title = title;
        this.subtitle = subtitle;
        this.forceDark = forceDark;
        this.offset = offset;
        this.durationms = durationms;
        this.style = style;
        this.outsideTouchable = outsideTouchable;
        this.continuation = cancellableContinuation;
    }

    @Override // kntr.app.appwidget.guide.ui.PopupData
    public List<String> getAvatar() {
        return this.avatar;
    }

    @Override // kntr.app.appwidget.guide.ui.PopupData
    public String getTitle() {
        return this.title;
    }

    @Override // kntr.app.appwidget.guide.ui.PopupData
    public String getSubtitle() {
        return this.subtitle;
    }

    @Override // kntr.app.appwidget.guide.ui.PopupData
    public boolean getForceDark() {
        return this.forceDark;
    }

    @Override // kntr.app.appwidget.guide.ui.PopupData
    public int getOffset() {
        return this.offset;
    }

    @Override // kntr.app.appwidget.guide.ui.PopupData
    public long getDurationms() {
        return this.durationms;
    }

    @Override // kntr.app.appwidget.guide.ui.PopupData
    public int getStyle() {
        return this.style;
    }

    @Override // kntr.app.appwidget.guide.ui.PopupData
    public boolean getOutsideTouchable() {
        return this.outsideTouchable;
    }

    @Override // kntr.app.appwidget.guide.ui.PopupData
    public void performAction() {
        if (this.continuation.isActive()) {
            Result.Companion companion = Result.Companion;
            this.continuation.resumeWith(Result.constructor-impl(PopupResult.ActionPerformed));
        }
    }

    @Override // kntr.app.appwidget.guide.ui.PopupData
    public void dismiss(boolean auto) {
        if (this.continuation.isActive()) {
            Continuation continuation = this.continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl(auto ? PopupResult.AutoDismissed : PopupResult.Dismissed));
        }
    }
}