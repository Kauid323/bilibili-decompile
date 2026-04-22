package tv.danmaku.biliplayerimpl.toast.left.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bilibili.magicasakura.utils.ThemeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.R;
import tv.danmaku.biliplayerimpl.toast.left.AbsToastListAdapter;
import tv.danmaku.biliplayerimpl.toast.left.AbsToastViewHolder;
import tv.danmaku.biliplayerv2.utils.DpUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ActionMessageVH.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/viewholder/ActionMessageVH;", "Ltv/danmaku/biliplayerimpl/toast/left/AbsToastViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "closeImg", "Landroid/widget/ImageView;", "titleTv", "Landroid/widget/TextView;", "actionTv", "bindPlayerToast", "", "toast", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "adapter", "Ltv/danmaku/biliplayerimpl/toast/left/AbsToastListAdapter;", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ActionMessageVH extends AbsToastViewHolder {
    public static final Companion Companion = new Companion(null);
    private final TextView actionTv;
    private final ImageView closeImg;
    private final TextView titleTv;

    public /* synthetic */ ActionMessageVH(View view2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view2);
    }

    private ActionMessageVH(View itemView) {
        super(itemView);
        View findViewById = itemView.findViewById(R.id.close);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.closeImg = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.titleTv = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.action);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.actionTv = (TextView) findViewById3;
    }

    @Override // tv.danmaku.biliplayerimpl.toast.left.AbsToastViewHolder
    public void bindPlayerToast(final PlayerToast toast, final AbsToastListAdapter adapter) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.titleTv.setText(PlayerToastConfig.getTitle(toast));
        this.actionTv.setText(toast.getExtraString(PlayerToastConfig.EXTRA_ACTION_TEXT));
        this.actionTv.setTextColor(ThemeUtils.getColorById(this.itemView.getContext(), com.bilibili.app.comm.baseres.R.color.pink));
        this.actionTv.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageVH$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActionMessageVH.bindPlayerToast$lambda$0(AbsToastListAdapter.this, toast, view2);
            }
        });
        this.titleTv.setPadding(0, 0, (int) DpUtils.dp2px(this.titleTv.getContext(), 12.0f), 0);
        boolean needClose = toast.getExtraBooleanValue(PlayerToastConfig.EXTRA_ACTION_NEED_CLOSE, true);
        if (needClose) {
            this.closeImg.setVisibility(0);
            this.closeImg.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageVH$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ActionMessageVH.bindPlayerToast$lambda$1(AbsToastListAdapter.this, toast, view2);
                }
            });
        } else {
            this.closeImg.setVisibility(8);
            CharSequence text = this.titleTv.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            if (text.length() > 0) {
                this.titleTv.setPadding((int) DpUtils.dp2px(this.titleTv.getContext(), 12.0f), 0, (int) DpUtils.dp2px(this.titleTv.getContext(), 12.0f), 0);
            }
        }
        toast.setToastView(this.itemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPlayerToast$lambda$0(AbsToastListAdapter $adapter, PlayerToast $toast, View v) {
        AbsToastListAdapter.removeToast$default($adapter, $toast, false, 2, null);
        PlayerToast.MessageClickListener listener = $toast.getClickListener();
        if (listener != null) {
            listener.onActionWithCollapse(PlayerToast.MessageClickListener.Companion.getCLICK_ID1(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPlayerToast$lambda$1(AbsToastListAdapter $adapter, PlayerToast $toast, View v) {
        AbsToastListAdapter.removeToast$default($adapter, $toast, false, 2, null);
        PlayerToast.MessageClickListener listener = $toast.getClickListener();
        if (listener != null) {
            listener.onDismiss();
        }
    }

    /* compiled from: ActionMessageVH.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/viewholder/ActionMessageVH$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/biliplayerimpl/toast/left/viewholder/ActionMessageVH;", "parent", "Landroid/view/ViewGroup;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ActionMessageVH create(ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_player_toast_message_action, parent, false);
            Intrinsics.checkNotNull(view2);
            return new ActionMessageVH(view2, null);
        }
    }
}