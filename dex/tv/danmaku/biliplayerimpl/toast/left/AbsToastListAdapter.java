package tv.danmaku.biliplayerimpl.toast.left;

import android.os.Handler;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageWithAnimationVH;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;

/* compiled from: AbsToastListAdapter.kt */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f*\u0001\u001d\b&\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019H\u0016J\u001e\u0010%\u001a\u00020\u00162\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010'\u001a\u00020\tH&J \u0010(\u001a\u00020\u00162\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010'\u001a\u0004\u0018\u00010\tH&J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019H&J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\tH\u0007J\u001a\u0010+\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\t2\b\b\u0002\u0010,\u001a\u00020-H\u0007J\u0006\u0010.\u001a\u00020\u0016J\u0018\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\tH\u0004J\u0018\u00101\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\tH\u0004J\u0010\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u0010H\u0016J\u0010\u00104\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u0010H\u0016J\u0010\u00105\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u00106\u001a\u00020\u0016H\u0004J\b\u00107\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/AbsToastListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/biliplayerimpl/toast/left/AbsToastViewHolder;", "mHandler", "Landroid/os/Handler;", "<init>", "(Landroid/os/Handler;)V", "mToastQueue", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "mFinalTime", "", "mToastLink", "Ljava/util/concurrent/LinkedBlockingQueue;", "mTempToast", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tag", "", "getTag", "()Ljava/lang/String;", "onBindViewHolder", "", "holder", "position", "", "getItemCount", "getItemViewType", "mLoopRunnable", "tv/danmaku/biliplayerimpl/toast/left/AbsToastListAdapter$mLoopRunnable$1", "Ltv/danmaku/biliplayerimpl/toast/left/AbsToastListAdapter$mLoopRunnable$1;", "mDelayAddRunnable", "Ljava/lang/Runnable;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "loopToastState", "toastList", "toast", "dispatchToastAdd", "createToastViewHolder", "addToast", "removeToast", "checkTempToast", "", "removeAll", "insertToastToQueue", "index", "refreshToastItem", "onAttachedToRecyclerView", "recyclerView", "onDetachedFromRecyclerView", "onViewRecycled", "removeForeverToastTemporary", "restoreForeverToastIfNeed", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class AbsToastListAdapter extends RecyclerView.Adapter<AbsToastViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final long MAX_QUEUE_TIME = 3000;
    protected static final int MAX_SIZE = 3;
    private static final long REFRESH_INTERVAL = 1000;
    private static final String TAG = "ToastListAdapter";
    private static final long TOAST_BETWEEN_TIME = 300;
    private final Runnable mDelayAddRunnable;
    private long mFinalTime;
    private final Handler mHandler;
    private final AbsToastListAdapter$mLoopRunnable$1 mLoopRunnable;
    private RecyclerView mRecyclerView;
    private PlayerToast mTempToast;
    private final LinkedBlockingQueue<PlayerToast> mToastLink;
    private final CopyOnWriteArrayList<PlayerToast> mToastQueue;

    public abstract AbsToastViewHolder createToastViewHolder(ViewGroup viewGroup, int i);

    public abstract void dispatchToastAdd(CopyOnWriteArrayList<PlayerToast> copyOnWriteArrayList, PlayerToast playerToast);

    public abstract void loopToastState(CopyOnWriteArrayList<PlayerToast> copyOnWriteArrayList, PlayerToast playerToast);

    public final void removeToast(PlayerToast playerToast) {
        Intrinsics.checkNotNullParameter(playerToast, "toast");
        removeToast$default(this, playerToast, false, 2, null);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [tv.danmaku.biliplayerimpl.toast.left.AbsToastListAdapter$mLoopRunnable$1] */
    public AbsToastListAdapter(Handler mHandler) {
        Intrinsics.checkNotNullParameter(mHandler, "mHandler");
        this.mHandler = mHandler;
        this.mToastQueue = new CopyOnWriteArrayList<>();
        this.mToastLink = new LinkedBlockingQueue<>();
        this.mLoopRunnable = new Runnable() { // from class: tv.danmaku.biliplayerimpl.toast.left.AbsToastListAdapter$mLoopRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                CopyOnWriteArrayList copyOnWriteArrayList;
                CopyOnWriteArrayList copyOnWriteArrayList2;
                Handler handler;
                CopyOnWriteArrayList<PlayerToast> copyOnWriteArrayList3;
                copyOnWriteArrayList = AbsToastListAdapter.this.mToastQueue;
                Iterator iterator = copyOnWriteArrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(iterator, "iterator(...)");
                while (iterator.hasNext()) {
                    PlayerToast next = (PlayerToast) iterator.next();
                    AbsToastListAdapter absToastListAdapter = AbsToastListAdapter.this;
                    copyOnWriteArrayList3 = AbsToastListAdapter.this.mToastQueue;
                    Intrinsics.checkNotNull(next);
                    absToastListAdapter.loopToastState(copyOnWriteArrayList3, next);
                }
                copyOnWriteArrayList2 = AbsToastListAdapter.this.mToastQueue;
                if (copyOnWriteArrayList2.size() > 0) {
                    handler = AbsToastListAdapter.this.mHandler;
                    handler.postDelayed(this, 1000L);
                }
            }
        };
        this.mDelayAddRunnable = new Runnable() { // from class: tv.danmaku.biliplayerimpl.toast.left.AbsToastListAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbsToastListAdapter.mDelayAddRunnable$lambda$0(AbsToastListAdapter.this);
            }
        };
    }

    public final String getTag() {
        return TAG;
    }

    public void onBindViewHolder(AbsToastViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PlayerToast playerToast = this.mToastQueue.get(position);
        Intrinsics.checkNotNullExpressionValue(playerToast, "get(...)");
        holder.bindPlayerToast(playerToast, this);
    }

    public int getItemCount() {
        return this.mToastQueue.size();
    }

    public int getItemViewType(int position) {
        PlayerToast toast = this.mToastQueue.get(position);
        if (toast != null) {
            return toast.getToastType();
        }
        return 17;
    }

    public static final void mDelayAddRunnable$lambda$0(AbsToastListAdapter this$0) {
        PlayerToast target = this$0.mToastLink.poll();
        if (this$0.mToastLink.size() == 0) {
            this$0.mFinalTime = 0L;
        }
        if (target != null) {
            this$0.dispatchToastAdd(this$0.mToastQueue, target);
        }
    }

    public AbsToastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return createToastViewHolder(parent, viewType);
    }

    public final void addToast(PlayerToast toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        this.mHandler.removeCallbacks(this.mLoopRunnable);
        this.mHandler.postDelayed(this.mLoopRunnable, 1000L);
        if (toast.getLevel() != 1 || 3000 == this.mFinalTime) {
            dispatchToastAdd(this.mToastQueue, toast);
            return;
        }
        if (this.mToastLink.size() != 0) {
            this.mFinalTime += TOAST_BETWEEN_TIME;
        }
        this.mToastLink.add(toast);
        this.mHandler.postDelayed(this.mDelayAddRunnable, this.mFinalTime);
    }

    public static /* synthetic */ void removeToast$default(AbsToastListAdapter absToastListAdapter, PlayerToast playerToast, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeToast");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        absToastListAdapter.removeToast(playerToast, z);
    }

    public final void removeToast(PlayerToast toast, boolean checkTempToast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        int position = this.mToastQueue.indexOf(toast);
        if (position >= 0) {
            this.mToastQueue.remove(position);
            notifyItemRemoved(position);
            if (checkTempToast) {
                restoreForeverToastIfNeed();
            }
        }
    }

    public final void removeAll() {
        this.mToastQueue.clear();
        notifyDataSetChanged();
        this.mToastLink.clear();
        this.mFinalTime = 0L;
    }

    public final void insertToastToQueue(int index, PlayerToast toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        if (index < 0 || index > this.mToastQueue.size()) {
            PlayerLog.e(PlayerLogModule.Toast, "insert index is out of bound!");
            return;
        }
        this.mToastQueue.add(index, toast);
        notifyItemInserted(index);
    }

    public final void refreshToastItem(int index, PlayerToast toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        if (index < 0 || index > this.mToastQueue.size()) {
            PlayerLog.e(PlayerLogModule.Toast, "refresh index is out of bound!");
            return;
        }
        this.mToastQueue.set(index, toast);
        RecyclerView it = this.mRecyclerView;
        if (it != null) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = it.findViewHolderForAdapterPosition(index);
            ActionMessageWithAnimationVH actionMessageWithAnimationVH = findViewHolderForAdapterPosition instanceof ActionMessageWithAnimationVH ? (ActionMessageWithAnimationVH) findViewHolderForAdapterPosition : null;
            if (actionMessageWithAnimationVH != null) {
                actionMessageWithAnimationVH.bindPlayerToast(toast, this);
            }
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.mRecyclerView = null;
    }

    public void onViewRecycled(AbsToastViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        holder.onViewRecycled();
    }

    public final void removeForeverToastTemporary() {
        if (this.mToastQueue.size() == 0) {
            PlayerLog.e(PlayerLogModule.Toast, "remove temp index is out of bound!");
            return;
        }
        PlayerToast removedToast = this.mToastQueue.get(0);
        if (removedToast.getDuration() == PlayerToastConfig.DURATION_FOREVER) {
            this.mTempToast = removedToast;
            this.mToastQueue.remove(0);
            notifyItemRemoved(0);
        }
    }

    private final void restoreForeverToastIfNeed() {
        if (this.mToastQueue.size() < 3 && this.mTempToast != null) {
            PlayerToast playerToast = this.mTempToast;
            Intrinsics.checkNotNull(playerToast);
            PlayerToast restoreToast = playerToast.clone();
            if (this.mToastQueue.size() == 0) {
                this.mToastQueue.add(0, restoreToast);
                notifyItemInserted(0);
            }
            this.mTempToast = null;
        }
    }

    /* compiled from: AbsToastListAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0083T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/AbsToastListAdapter$Companion;", "", "<init>", "()V", "TAG", "", "MAX_SIZE", "", "REFRESH_INTERVAL", "", "TOAST_BETWEEN_TIME", "MAX_QUEUE_TIME", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}