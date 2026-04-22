package tv.danmaku.biliplayerimpl.toast.left;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ToastItemAnimator.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 <2\u00020\u0001:\u00049:;<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J0\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eH\u0016J0\u0010\"\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eH\u0002J:\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\fH\u0002J\u001e\u0010(\u001a\u00020\u00152\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0*2\u0006\u0010+\u001a\u00020\u0006H\u0002J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\fH\u0002J\u001a\u0010,\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010-\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0006H\u0016J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010/\u001a\u00020\u0017H\u0016J\b\u00100\u001a\u00020\u0015H\u0002J\b\u00101\u001a\u00020\u0015H\u0016J\u0018\u00102\u001a\u00020\u00152\u000e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000604H\u0002J\u001e\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u00062\f\u00107\u001a\b\u0012\u0004\u0012\u00020804H\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00020\n`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0005j\b\u0012\u0004\u0012\u00020\f`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\r\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00070\u0005j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u000e\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00020\n`\u00070\u0005j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00020\n`\u0007`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u000f\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u0005j\b\u0012\u0004\u0012\u00020\f`\u00070\u0005j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u0005j\b\u0012\u0004\u0012\u00020\f`\u0007`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/ToastItemAnimator;", "Landroidx/recyclerview/widget/SimpleItemAnimator;", "<init>", "()V", "mPendingRemovals", "Ljava/util/ArrayList;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/collections/ArrayList;", "mPendingAdditions", "mPendingMoves", "Ltv/danmaku/biliplayerimpl/toast/left/ToastItemAnimator$MoveInfo;", "mPendingChanges", "Ltv/danmaku/biliplayerimpl/toast/left/ToastItemAnimator$ChangeInfo;", "mAdditionsList", "mMovesList", "mChangesList", "mAddAnimations", "mMoveAnimations", "mRemoveAnimations", "mChangeAnimations", "runPendingAnimations", "", "animateRemove", "", "holder", "animateRemoveImpl", "animateAdd", "animateAddImpl", "animateMove", "fromX", "", "fromY", "toX", "toY", "animateMoveImpl", "animateChange", "oldHolder", "newHolder", "animateChangeImpl", "changeInfo", "endChangeAnimation", "infoList", "", "item", "endChangeAnimationIfNecessary", "endAnimation", "resetAnimation", "isRunning", "dispatchFinishedWhenDone", "endAnimations", "cancelAll", "viewHolders", "", "canReuseUpdatedViewHolder", "viewHolder", "payloads", "", "MoveInfo", "ChangeInfo", "ViewHelper", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ToastItemAnimator extends SimpleItemAnimator {
    public static final Companion Companion = new Companion(null);
    private static TimeInterpolator sDefaultInterpolator;
    private final ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList<>();
    private final ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList<>();
    private final ArrayList<MoveInfo> mPendingMoves = new ArrayList<>();
    private final ArrayList<ChangeInfo> mPendingChanges = new ArrayList<>();
    private final ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList<>();
    private final ArrayList<ArrayList<MoveInfo>> mMovesList = new ArrayList<>();
    private final ArrayList<ArrayList<ChangeInfo>> mChangesList = new ArrayList<>();
    private final ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList<>();
    private final ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList<>();
    private final ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList<>();
    private final ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToastItemAnimator.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u0019"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/ToastItemAnimator$MoveInfo;", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fromX", "", "fromY", "toX", "toY", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)V", "getHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "getFromX", "()I", "setFromX", "(I)V", "getFromY", "setFromY", "getToX", "setToX", "getToY", "setToY", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class MoveInfo {
        private int fromX;
        private int fromY;
        private RecyclerView.ViewHolder holder;
        private int toX;
        private int toY;

        public MoveInfo(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            this.holder = holder;
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }

        public final RecyclerView.ViewHolder getHolder() {
            return this.holder;
        }

        public final void setHolder(RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "<set-?>");
            this.holder = viewHolder;
        }

        public final int getFromX() {
            return this.fromX;
        }

        public final void setFromX(int i) {
            this.fromX = i;
        }

        public final int getFromY() {
            return this.fromY;
        }

        public final void setFromY(int i) {
            this.fromY = i;
        }

        public final int getToX() {
            return this.toX;
        }

        public final void setToX(int i) {
            this.toX = i;
        }

        public final int getToY() {
            return this.toY;
        }

        public final void setToY(int i) {
            this.toY = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToastItemAnimator.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006\u001f"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/ToastItemAnimator$ChangeInfo;", "", "oldHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "newHolder", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "fromX", "", "fromY", "toX", "toY", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)V", "getOldHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setOldHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "getNewHolder", "setNewHolder", "getFromX", "()I", "setFromX", "(I)V", "getFromY", "setFromY", "getToX", "setToX", "getToY", "setToY", "toString", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ChangeInfo {
        private int fromX;
        private int fromY;
        private RecyclerView.ViewHolder newHolder;
        private RecyclerView.ViewHolder oldHolder;
        private int toX;
        private int toY;

        private ChangeInfo(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder) {
            this.oldHolder = oldHolder;
            this.newHolder = newHolder;
        }

        public final RecyclerView.ViewHolder getOldHolder() {
            return this.oldHolder;
        }

        public final void setOldHolder(RecyclerView.ViewHolder viewHolder) {
            this.oldHolder = viewHolder;
        }

        public final RecyclerView.ViewHolder getNewHolder() {
            return this.newHolder;
        }

        public final void setNewHolder(RecyclerView.ViewHolder viewHolder) {
            this.newHolder = viewHolder;
        }

        public final int getFromX() {
            return this.fromX;
        }

        public final void setFromX(int i) {
            this.fromX = i;
        }

        public final int getFromY() {
            return this.fromY;
        }

        public final void setFromY(int i) {
            this.fromY = i;
        }

        public final int getToX() {
            return this.toX;
        }

        public final void setToX(int i) {
            this.toX = i;
        }

        public final int getToY() {
            return this.toY;
        }

        public final void setToY(int i) {
            this.toY = i;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ChangeInfo(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int fromX, int fromY, int toX, int toY) {
            this(oldHolder, newHolder);
            Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }

        public String toString() {
            RecyclerView.ViewHolder viewHolder = this.oldHolder;
            RecyclerView.ViewHolder viewHolder2 = this.newHolder;
            int i = this.fromX;
            int i2 = this.fromY;
            int i3 = this.toX;
            return "ChangeInfo{oldHolder=" + viewHolder + ", newHolder=" + viewHolder2 + ", romX=" + i + ", fromY=" + i2 + ", toX=" + i3 + ", toY=" + this.toY + "}";
        }
    }

    public void runPendingAnimations() {
        boolean removalsPending = !this.mPendingRemovals.isEmpty();
        boolean movesPending = !this.mPendingMoves.isEmpty();
        boolean changesPending = !this.mPendingChanges.isEmpty();
        boolean additionsPending = !this.mPendingAdditions.isEmpty();
        if (!removalsPending && !movesPending && !additionsPending && !changesPending) {
            return;
        }
        Iterator<RecyclerView.ViewHolder> it = this.mPendingRemovals.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RecyclerView.ViewHolder holder = it.next();
            Intrinsics.checkNotNullExpressionValue(holder, "next(...)");
            animateRemoveImpl(holder);
        }
        this.mPendingRemovals.clear();
        if (movesPending) {
            final ArrayList moves = new ArrayList(this.mPendingMoves);
            this.mMovesList.add(moves);
            this.mPendingMoves.clear();
            Runnable mover = new Runnable() { // from class: tv.danmaku.biliplayerimpl.toast.left.ToastItemAnimator$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ToastItemAnimator.runPendingAnimations$lambda$0(moves, this);
                }
            };
            if (removalsPending) {
                View view2 = moves.get(0).getHolder().itemView;
                Intrinsics.checkNotNullExpressionValue(view2, "itemView");
                ViewCompat.postOnAnimationDelayed(view2, mover, getRemoveDuration());
            } else {
                mover.run();
            }
        }
        if (changesPending) {
            final ArrayList changes = new ArrayList(this.mPendingChanges);
            this.mChangesList.add(changes);
            this.mPendingChanges.clear();
            Runnable changer = new Runnable() { // from class: tv.danmaku.biliplayerimpl.toast.left.ToastItemAnimator$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ToastItemAnimator.runPendingAnimations$lambda$1(changes, this);
                }
            };
            if (removalsPending) {
                RecyclerView.ViewHolder holder2 = changes.get(0).getOldHolder();
                Intrinsics.checkNotNull(holder2);
                ViewCompat.postOnAnimationDelayed(holder2.itemView, changer, getRemoveDuration());
            } else {
                changer.run();
            }
        }
        if (additionsPending) {
            final ArrayList additions = new ArrayList(this.mPendingAdditions);
            this.mAdditionsList.add(additions);
            this.mPendingAdditions.clear();
            Runnable adder = new Runnable() { // from class: tv.danmaku.biliplayerimpl.toast.left.ToastItemAnimator$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    ToastItemAnimator.runPendingAnimations$lambda$2(additions, this);
                }
            };
            if (removalsPending || movesPending || changesPending) {
                long removeDuration = removalsPending ? getRemoveDuration() : 0L;
                long moveDuration = movesPending ? getMoveDuration() : 0L;
                long changeDuration = changesPending ? getChangeDuration() : 0L;
                long totalDelay = removeDuration + Math.max(moveDuration, changeDuration);
                View view3 = additions.get(0).itemView;
                Intrinsics.checkNotNullExpressionValue(view3, "itemView");
                ViewCompat.postOnAnimationDelayed(view3, adder, totalDelay);
                return;
            }
            adder.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runPendingAnimations$lambda$0(ArrayList $moves, ToastItemAnimator this$0) {
        Iterator it = $moves.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            MoveInfo moveInfo = (MoveInfo) it.next();
            this$0.animateMoveImpl(moveInfo.getHolder(), moveInfo.getFromX(), moveInfo.getFromY(), moveInfo.getToX(), moveInfo.getToY());
        }
        $moves.clear();
        this$0.mMovesList.remove($moves);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runPendingAnimations$lambda$1(ArrayList $changes, ToastItemAnimator this$0) {
        Iterator it = $changes.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ChangeInfo change = (ChangeInfo) it.next();
            Intrinsics.checkNotNull(change);
            this$0.animateChangeImpl(change);
        }
        $changes.clear();
        this$0.mChangesList.remove($changes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runPendingAnimations$lambda$2(ArrayList $additions, ToastItemAnimator this$0) {
        Iterator it = $additions.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RecyclerView.ViewHolder holder = (RecyclerView.ViewHolder) it.next();
            Intrinsics.checkNotNull(holder);
            this$0.animateAddImpl(holder);
        }
        $additions.clear();
        this$0.mAdditionsList.remove($additions);
    }

    public boolean animateRemove(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        resetAnimation(holder);
        this.mPendingRemovals.add(holder);
        return true;
    }

    private final void animateRemoveImpl(final RecyclerView.ViewHolder holder) {
        final View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        final ViewPropertyAnimator animation = view2.animate();
        this.mRemoveAnimations.add(holder);
        animation.setDuration(getRemoveDuration()).alpha(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN).setListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.biliplayerimpl.toast.left.ToastItemAnimator$animateRemoveImpl$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ToastItemAnimator.this.dispatchRemoveStarting(holder);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(animator, "animator");
                animation.setListener(null);
                view2.setAlpha(1.0f);
                ToastItemAnimator.this.dispatchRemoveFinished(holder);
                arrayList = ToastItemAnimator.this.mRemoveAnimations;
                arrayList.remove(holder);
                ToastItemAnimator.this.dispatchFinishedWhenDone();
            }
        }).start();
    }

    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        resetAnimation(holder);
        holder.itemView.setAlpha(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mPendingAdditions.add(holder);
        return true;
    }

    private final void animateAddImpl(final RecyclerView.ViewHolder holder) {
        final View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        final ViewPropertyAnimator animation = view2.animate();
        this.mAddAnimations.add(holder);
        animation.alpha(1.0f).setDuration(getAddDuration()).setListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.biliplayerimpl.toast.left.ToastItemAnimator$animateAddImpl$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ToastItemAnimator.this.dispatchAddStarting(holder);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                view2.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(animator, "animator");
                animation.setListener(null);
                try {
                    ToastItemAnimator.this.dispatchAddFinished(holder);
                } catch (IllegalArgumentException e) {
                    BLog.e(e.toString());
                }
                arrayList = ToastItemAnimator.this.mAddAnimations;
                arrayList.remove(holder);
                ToastItemAnimator.this.dispatchFinishedWhenDone();
            }
        }).start();
    }

    public boolean animateMove(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        int fX = fromX + ((int) holder.itemView.getTranslationX());
        int fY = fromY + ((int) holder.itemView.getTranslationY());
        resetAnimation(holder);
        int deltaX = toX - fX;
        int deltaY = toY - fY;
        if (deltaX == 0 && deltaY == 0) {
            dispatchMoveFinished(holder);
            return false;
        }
        if (deltaX != 0) {
            view2.setTranslationX(-deltaX);
        }
        if (deltaY != 0) {
            view2.setTranslationY(-deltaY);
        }
        this.mPendingMoves.add(new MoveInfo(holder, fX, fY, toX, toY));
        return true;
    }

    private final void animateMoveImpl(final RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        final View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        final int deltaX = toX - fromX;
        final int deltaY = toY - fromY;
        if (deltaX != 0) {
            view2.animate().translationX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        }
        if (deltaY != 0) {
            view2.animate().translationY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        }
        final ViewPropertyAnimator animation = view2.animate();
        this.mMoveAnimations.add(holder);
        animation.setDuration(getMoveDuration()).setListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.biliplayerimpl.toast.left.ToastItemAnimator$animateMoveImpl$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ToastItemAnimator.this.dispatchMoveStarting(holder);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                if (deltaX != 0) {
                    view2.setTranslationX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                }
                if (deltaY != 0) {
                    view2.setTranslationY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(animator, "animator");
                animation.setListener(null);
                try {
                    ToastItemAnimator.this.dispatchMoveFinished(holder);
                } catch (IllegalArgumentException e) {
                    BLog.e(e.toString());
                }
                arrayList = ToastItemAnimator.this.mMoveAnimations;
                arrayList.remove(holder);
                ToastItemAnimator.this.dispatchFinishedWhenDone();
            }
        }).start();
    }

    public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int fromX, int fromY, int toX, int toY) {
        Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
        if (oldHolder == newHolder) {
            return animateMove(oldHolder, fromX, fromY, toX, toY);
        }
        float prevTranslationX = oldHolder.itemView.getTranslationX();
        float prevTranslationY = oldHolder.itemView.getTranslationY();
        float prevAlpha = oldHolder.itemView.getAlpha();
        resetAnimation(oldHolder);
        int deltaX = (int) ((toX - fromX) - prevTranslationX);
        int deltaY = (int) ((toY - fromY) - prevTranslationY);
        oldHolder.itemView.setTranslationX(prevTranslationX);
        oldHolder.itemView.setTranslationY(prevTranslationY);
        oldHolder.itemView.setAlpha(prevAlpha);
        if (newHolder != null) {
            resetAnimation(newHolder);
            newHolder.itemView.setTranslationX(-deltaX);
            newHolder.itemView.setTranslationY(-deltaY);
            newHolder.itemView.setAlpha(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        }
        this.mPendingChanges.add(new ChangeInfo(oldHolder, newHolder, fromX, fromY, toX, toY));
        return true;
    }

    private final void animateChangeImpl(final ChangeInfo changeInfo) {
        RecyclerView.ViewHolder holder = changeInfo.getOldHolder();
        final View view2 = holder != null ? holder.itemView : null;
        final IChangeAnimatorImpl newHolder = changeInfo.getNewHolder();
        final View newView = newHolder != null ? ((RecyclerView.ViewHolder) newHolder).itemView : null;
        if (view2 != null) {
            final ViewPropertyAnimator oldViewAnim = view2.animate().setDuration(getChangeDuration());
            Intrinsics.checkNotNullExpressionValue(oldViewAnim, "setDuration(...)");
            this.mChangeAnimations.add(changeInfo.getOldHolder());
            oldViewAnim.translationX(changeInfo.getToX() - changeInfo.getFromX());
            oldViewAnim.translationY(changeInfo.getToY() - changeInfo.getFromY());
            oldViewAnim.alpha(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN).setListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.biliplayerimpl.toast.left.ToastItemAnimator$animateChangeImpl$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    ToastItemAnimator.this.dispatchChangeStarting(changeInfo.getOldHolder(), true);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ArrayList arrayList;
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    oldViewAnim.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                    view2.setTranslationY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                    ToastItemAnimator.this.dispatchChangeFinished(changeInfo.getOldHolder(), true);
                    arrayList = ToastItemAnimator.this.mChangeAnimations;
                    arrayList.remove(changeInfo.getOldHolder());
                    ToastItemAnimator.this.dispatchFinishedWhenDone();
                }
            }).start();
        }
        if (newView != null) {
            boolean customAnimation = false;
            if (newHolder instanceof IChangeAnimatorImpl) {
                final ValueAnimator valueAnimator = newHolder.getValueAnimator();
                ViewHelper.INSTANCE.clear(newView);
                customAnimation = true;
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.biliplayerimpl.toast.left.ToastItemAnimator$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        ToastItemAnimator.animateChangeImpl$lambda$0(newHolder, valueAnimator2);
                    }
                });
                valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.biliplayerimpl.toast.left.ToastItemAnimator$animateChangeImpl$3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        ArrayList arrayList;
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        IChangeAnimatorImpl iChangeAnimatorImpl = newHolder;
                        Intrinsics.checkNotNull(iChangeAnimatorImpl, "null cannot be cast to non-null type tv.danmaku.biliplayerimpl.toast.left.IChangeAnimatorImpl");
                        iChangeAnimatorImpl.onAnimationEnd(animation);
                        valueAnimator.removeAllUpdateListeners();
                        this.dispatchChangeFinished(changeInfo.getNewHolder(), false);
                        arrayList = this.mChangeAnimations;
                        arrayList.remove(changeInfo.getNewHolder());
                        this.dispatchFinishedWhenDone();
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        IChangeAnimatorImpl iChangeAnimatorImpl = newHolder;
                        Intrinsics.checkNotNull(iChangeAnimatorImpl, "null cannot be cast to non-null type tv.danmaku.biliplayerimpl.toast.left.IChangeAnimatorImpl");
                        iChangeAnimatorImpl.onAnimationStart(animation);
                        this.dispatchChangeStarting(changeInfo.getNewHolder(), false);
                    }
                });
                valueAnimator.setInterpolator(new DecelerateInterpolator());
                valueAnimator.setDuration(newHolder.getDuration()).start();
            }
            if (!customAnimation) {
                final ViewPropertyAnimator newViewAnimation = newView.animate();
                this.mChangeAnimations.add(changeInfo.getNewHolder());
                newViewAnimation.translationX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN).translationY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN).setDuration(getChangeDuration()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.biliplayerimpl.toast.left.ToastItemAnimator$animateChangeImpl$4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        Intrinsics.checkNotNullParameter(animator, "animator");
                        ToastItemAnimator.this.dispatchChangeStarting(changeInfo.getNewHolder(), false);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ArrayList arrayList;
                        Intrinsics.checkNotNullParameter(animator, "animator");
                        newViewAnimation.setListener(null);
                        newView.setAlpha(1.0f);
                        newView.setTranslationX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                        newView.setTranslationY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                        ToastItemAnimator.this.dispatchChangeFinished(changeInfo.getNewHolder(), false);
                        arrayList = ToastItemAnimator.this.mChangeAnimations;
                        arrayList.remove(changeInfo.getNewHolder());
                        ToastItemAnimator.this.dispatchFinishedWhenDone();
                    }
                }).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateChangeImpl$lambda$0(RecyclerView.ViewHolder $newHolder, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNull($newHolder, "null cannot be cast to non-null type tv.danmaku.biliplayerimpl.toast.left.IChangeAnimatorImpl");
        ((IChangeAnimatorImpl) $newHolder).onAnimationUpdate(animation);
    }

    private final void endChangeAnimation(List<ChangeInfo> list, RecyclerView.ViewHolder item) {
        int size = list.size() - 1;
        if (size >= 0) {
            do {
                int i = size;
                size--;
                ChangeInfo changeInfo = list.get(i);
                if (endChangeAnimationIfNecessary(changeInfo, item) && changeInfo.getOldHolder() == null && changeInfo.getNewHolder() == null) {
                    list.remove(changeInfo);
                    continue;
                }
            } while (size >= 0);
        }
    }

    private final void endChangeAnimationIfNecessary(ChangeInfo changeInfo) {
        if (changeInfo.getOldHolder() != null) {
            endChangeAnimationIfNecessary(changeInfo, changeInfo.getOldHolder());
        }
        if (changeInfo.getNewHolder() != null) {
            endChangeAnimationIfNecessary(changeInfo, changeInfo.getNewHolder());
        }
    }

    private final boolean endChangeAnimationIfNecessary(ChangeInfo changeInfo, RecyclerView.ViewHolder item) {
        boolean oldItem = false;
        if (changeInfo.getNewHolder() == item) {
            changeInfo.setNewHolder(null);
        } else if (changeInfo.getOldHolder() == item) {
            changeInfo.setOldHolder(null);
            oldItem = true;
        } else {
            return false;
        }
        Intrinsics.checkNotNull(item);
        item.itemView.setAlpha(1.0f);
        item.itemView.setTranslationX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        item.itemView.setTranslationY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        dispatchChangeFinished(item, oldItem);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e9, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0077 A[LOOP:1: B:16:0x0077->B:19:0x0096, LOOP_START, PHI: r1 
      PHI: (r1v28 int) = (r1v15 int), (r1v29 int) binds: [B:15:0x0075, B:19:0x0096] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4 A[LOOP:2: B:22:0x00a4->B:31:0x00e9, LOOP_START, PHI: r1 
      PHI: (r1v26 int) = (r1v19 int), (r1v27 int) binds: [B:21:0x00a2, B:31:0x00e9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f7 A[LOOP:4: B:34:0x00f7->B:39:0x011c, LOOP_START, PHI: r1 
      PHI: (r1v24 int) = (r1v23 int), (r1v25 int) binds: [B:33:0x00f5, B:39:0x011c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void endAnimation(RecyclerView.ViewHolder item) {
        int size;
        int size2;
        int size3;
        Intrinsics.checkNotNullParameter(item, "item");
        View view2 = item.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        view2.animate().cancel();
        int size4 = this.mPendingMoves.size() - 1;
        if (size4 >= 0) {
            do {
                int i = size4;
                size4--;
                MoveInfo moveInfo = this.mPendingMoves.get(i);
                Intrinsics.checkNotNullExpressionValue(moveInfo, "get(...)");
                MoveInfo moveInfo2 = moveInfo;
                if (moveInfo2.getHolder() == item) {
                    view2.setTranslationY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                    view2.setTranslationX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                    dispatchMoveFinished(item);
                    this.mPendingMoves.remove(i);
                    continue;
                }
            } while (size4 >= 0);
            endChangeAnimation(this.mPendingChanges, item);
            if (this.mPendingRemovals.remove(item)) {
                view2.setAlpha(1.0f);
                dispatchRemoveFinished(item);
            }
            if (this.mPendingAdditions.remove(item)) {
                view2.setAlpha(1.0f);
                dispatchAddFinished(item);
            }
            size = this.mChangesList.size() - 1;
            if (size < 0) {
                do {
                    int i2 = size;
                    size--;
                    ArrayList arrayList = this.mChangesList.get(i2);
                    Intrinsics.checkNotNullExpressionValue(arrayList, "get(...)");
                    ArrayList changes = arrayList;
                    endChangeAnimation(changes, item);
                    if (changes.isEmpty()) {
                        this.mChangesList.remove(i2);
                        continue;
                    }
                } while (size >= 0);
                size2 = this.mMovesList.size() - 1;
                if (size2 < 0) {
                    do {
                        int i3 = size2;
                        size2--;
                        ArrayList arrayList2 = this.mMovesList.get(i3);
                        Intrinsics.checkNotNullExpressionValue(arrayList2, "get(...)");
                        ArrayList moves = arrayList2;
                        int size5 = moves.size() - 1;
                        if (size5 >= 0) {
                            while (true) {
                                int j = size5;
                                size5--;
                                MoveInfo moveInfo3 = moves.get(j);
                                Intrinsics.checkNotNullExpressionValue(moveInfo3, "get(...)");
                                MoveInfo moveInfo4 = moveInfo3;
                                if (moveInfo4.getHolder() != item) {
                                    if (size5 < 0) {
                                        break;
                                    }
                                } else {
                                    view2.setTranslationY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                                    view2.setTranslationX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                                    dispatchMoveFinished(item);
                                    moves.remove(j);
                                    if (moves.isEmpty()) {
                                        this.mMovesList.remove(i3);
                                        continue;
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        }
                    } while (size2 >= 0);
                    size3 = this.mAdditionsList.size() - 1;
                    if (size3 < 0) {
                        do {
                            int i4 = size3;
                            size3--;
                            ArrayList arrayList3 = this.mAdditionsList.get(i4);
                            Intrinsics.checkNotNullExpressionValue(arrayList3, "get(...)");
                            ArrayList additions = arrayList3;
                            if (additions.remove(item)) {
                                view2.setAlpha(1.0f);
                                dispatchAddFinished(item);
                                if (additions.isEmpty()) {
                                    this.mAdditionsList.remove(i4);
                                    continue;
                                } else {
                                    continue;
                                }
                            }
                        } while (size3 >= 0);
                        dispatchFinishedWhenDone();
                        return;
                    }
                    dispatchFinishedWhenDone();
                    return;
                }
                size3 = this.mAdditionsList.size() - 1;
                if (size3 < 0) {
                }
            } else {
                size2 = this.mMovesList.size() - 1;
                if (size2 < 0) {
                }
            }
        } else {
            endChangeAnimation(this.mPendingChanges, item);
            if (this.mPendingRemovals.remove(item)) {
            }
            if (this.mPendingAdditions.remove(item)) {
            }
            size = this.mChangesList.size() - 1;
            if (size < 0) {
            }
        }
    }

    private final void resetAnimation(RecyclerView.ViewHolder holder) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new AccelerateDecelerateInterpolator();
        }
        holder.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(holder);
    }

    public boolean isRunning() {
        return (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    public void endAnimations() {
        int count = this.mPendingMoves.size();
        for (int i = count - 1; -1 < i; i--) {
            MoveInfo moveInfo = this.mPendingMoves.get(i);
            Intrinsics.checkNotNullExpressionValue(moveInfo, "get(...)");
            MoveInfo item = moveInfo;
            View view2 = item.getHolder().itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "itemView");
            view2.setTranslationY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            view2.setTranslationX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            dispatchMoveFinished(item.getHolder());
            this.mPendingMoves.remove(i);
        }
        int count2 = this.mPendingRemovals.size();
        for (int i2 = count2 - 1; -1 < i2; i2--) {
            RecyclerView.ViewHolder item2 = this.mPendingRemovals.get(i2);
            Intrinsics.checkNotNullExpressionValue(item2, "get(...)");
            dispatchRemoveFinished(item2);
            this.mPendingRemovals.remove(i2);
        }
        int count3 = this.mPendingAdditions.size();
        for (int i3 = count3 - 1; -1 < i3; i3--) {
            RecyclerView.ViewHolder viewHolder = this.mPendingAdditions.get(i3);
            Intrinsics.checkNotNullExpressionValue(viewHolder, "get(...)");
            RecyclerView.ViewHolder item3 = viewHolder;
            item3.itemView.setAlpha(1.0f);
            dispatchAddFinished(item3);
            this.mPendingAdditions.remove(i3);
        }
        int count4 = this.mPendingChanges.size();
        for (int i4 = count4 - 1; -1 < i4; i4--) {
            ChangeInfo changeInfo = this.mPendingChanges.get(i4);
            Intrinsics.checkNotNullExpressionValue(changeInfo, "get(...)");
            endChangeAnimationIfNecessary(changeInfo);
        }
        this.mPendingChanges.clear();
        if (!isRunning()) {
            return;
        }
        int listCount = this.mMovesList.size();
        for (int i5 = listCount - 1; -1 < i5; i5--) {
            ArrayList arrayList = this.mMovesList.get(i5);
            Intrinsics.checkNotNullExpressionValue(arrayList, "get(...)");
            ArrayList moves = arrayList;
            int count5 = moves.size();
            for (int j = count5 - 1; -1 < j; j--) {
                MoveInfo moveInfo2 = moves.get(j);
                Intrinsics.checkNotNullExpressionValue(moveInfo2, "get(...)");
                MoveInfo moveInfo3 = moveInfo2;
                View view3 = moveInfo3.getHolder().itemView;
                Intrinsics.checkNotNullExpressionValue(view3, "itemView");
                view3.setTranslationY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                view3.setTranslationX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                dispatchMoveFinished(moveInfo3.getHolder());
                moves.remove(j);
                if (moves.isEmpty()) {
                    this.mMovesList.remove(moves);
                }
            }
        }
        int listCount2 = this.mAdditionsList.size();
        for (int i6 = listCount2 - 1; -1 < i6; i6--) {
            ArrayList arrayList2 = this.mAdditionsList.get(i6);
            Intrinsics.checkNotNullExpressionValue(arrayList2, "get(...)");
            ArrayList additions = arrayList2;
            int count6 = additions.size();
            for (int j2 = count6 - 1; -1 < j2; j2--) {
                RecyclerView.ViewHolder viewHolder2 = additions.get(j2);
                Intrinsics.checkNotNullExpressionValue(viewHolder2, "get(...)");
                RecyclerView.ViewHolder item4 = viewHolder2;
                View view4 = item4.itemView;
                Intrinsics.checkNotNullExpressionValue(view4, "itemView");
                view4.setAlpha(1.0f);
                dispatchAddFinished(item4);
                additions.remove(j2);
                if (additions.isEmpty()) {
                    this.mAdditionsList.remove(additions);
                }
            }
        }
        int listCount3 = this.mChangesList.size();
        for (int i7 = listCount3 - 1; -1 < i7; i7--) {
            ArrayList arrayList3 = this.mChangesList.get(i7);
            Intrinsics.checkNotNullExpressionValue(arrayList3, "get(...)");
            ArrayList changes = arrayList3;
            int count7 = changes.size();
            for (int j3 = count7 - 1; -1 < j3; j3--) {
                ChangeInfo changeInfo2 = changes.get(j3);
                Intrinsics.checkNotNullExpressionValue(changeInfo2, "get(...)");
                endChangeAnimationIfNecessary(changeInfo2);
                if (changes.isEmpty()) {
                    this.mChangesList.remove(changes);
                }
            }
        }
        cancelAll(this.mRemoveAnimations);
        cancelAll(this.mMoveAnimations);
        cancelAll(this.mAddAnimations);
        cancelAll(this.mChangeAnimations);
        dispatchAnimationsFinished();
    }

    private final void cancelAll(List<? extends RecyclerView.ViewHolder> list) {
        View view2;
        ViewPropertyAnimator animate;
        List viewHolders = EnhancedUnmodifiabilityKt.unmodifiable(list);
        int size = viewHolders.size() - 1;
        if (size >= 0) {
            do {
                int i = size;
                size--;
                RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) viewHolders.get(i);
                if (viewHolder != null && (view2 = viewHolder.itemView) != null && (animate = view2.animate()) != null) {
                    animate.cancel();
                    continue;
                }
            } while (size >= 0);
        }
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder, List<? extends Object> list) {
        List payloads = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        return !payloads.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, payloads);
    }

    /* compiled from: ToastItemAnimator.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/ToastItemAnimator$ViewHelper;", "", "<init>", "()V", "clear", "", "v", "Landroid/view/View;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ViewHelper {
        public static final ViewHelper INSTANCE = new ViewHelper();

        private ViewHelper() {
        }

        public final void clear(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            v.setAlpha(1.0f);
            v.setScaleY(1.0f);
            v.setScaleX(1.0f);
            v.setTranslationY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            v.setTranslationX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            v.setRotation(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            v.setRotationY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            v.setRotationX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            v.setPivotY(v.getMeasuredHeight() / 2);
            v.setPivotX(v.getMeasuredWidth() / 2);
            ViewCompat.animate(v).setInterpolator((Interpolator) null).setStartDelay(0L);
        }
    }

    /* compiled from: ToastItemAnimator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/ToastItemAnimator$Companion;", "", "<init>", "()V", "sDefaultInterpolator", "Landroid/animation/TimeInterpolator;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}