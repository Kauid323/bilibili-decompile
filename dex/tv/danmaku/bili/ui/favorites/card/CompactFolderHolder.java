package tv.danmaku.bili.ui.favorites.card;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.appcompat.app.AppCompatDelegateImpl$;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.DimenUtilsKt;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.iconfont.KtxKt;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.bean.ThumbnailUrlTransformStrategy;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.theme.R;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesCompactFolderBinding;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesFolderItem;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;

/* compiled from: CompactFolderHolder.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B¢\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f0\u000e\u00126\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J\b\u0010\u0016\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/favorites/card/CompactFolderHolder;", "Ltv/danmaku/bili/ui/favorites/card/BaseFavoritesHolder;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesFolderItem;", "binding", "Ltv/danmaku/bili/databinding/BiliAppItemFavoritesCompactFolderBinding;", "onItemClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "item", "", FavoritesConstsKt.POS, "", "onItemLongClick", "Lkotlin/Function1;", "onPlayItemClick", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "", "fid", "<init>", "(Ltv/danmaku/bili/databinding/BiliAppItemFavoritesCompactFolderBinding;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "bind", "showGuidePopupWindow", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CompactFolderHolder extends BaseFavoritesHolder<FavoritesFolderItem> {
    public static final int $stable = 8;
    private final BiliAppItemFavoritesCompactFolderBinding binding;
    private final Function2<FavoritesFolderItem, Integer, Unit> onItemClick;
    private final Function1<FavoritesFolderItem, Unit> onItemLongClick;
    private final Function2<FavoritesMediasItem, Long, Unit> onPlayItemClick;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CompactFolderHolder(BiliAppItemFavoritesCompactFolderBinding binding, Function2<? super FavoritesFolderItem, ? super Integer, Unit> function2, Function1<? super FavoritesFolderItem, Unit> function1, Function2<? super FavoritesMediasItem, ? super Long, Unit> function22) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(function2, "onItemClick");
        Intrinsics.checkNotNullParameter(function1, "onItemLongClick");
        Intrinsics.checkNotNullParameter(function22, "onPlayItemClick");
        View root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = binding;
        this.onItemClick = function2;
        this.onItemLongClick = function1;
        this.onPlayItemClick = function22;
    }

    protected void bind() {
        int color;
        final FavoritesMediasItem item;
        FavoritesMediasItem item2;
        final BiliAppItemFavoritesCompactFolderBinding $this$bind_u24lambda_u240 = this.binding;
        $this$bind_u24lambda_u240.lock.setVisibility(ListExtentionsKt.toVisibility(((FavoritesFolderItem) getData()).isPrivate()));
        $this$bind_u24lambda_u240.title.setText(((FavoritesFolderItem) getData()).getTitle());
        $this$bind_u24lambda_u240.subtitle.setText(((FavoritesFolderItem) getData()).getAttrDesc());
        String cover = ((FavoritesFolderItem) getData()).getCover();
        if (cover == null || cover.length() == 0) {
            List<FavoritesMediasItem> recentFav = ((FavoritesFolderItem) getData()).getRecentFav();
            if (recentFav != null && (item2 = (FavoritesMediasItem) CollectionsKt.getOrNull(recentFav, 0)) != null) {
                if (item2.isAudioCard()) {
                    ListExtentionsKt.visible($this$bind_u24lambda_u240.cover11);
                    BiliImageView biliImageView = $this$bind_u24lambda_u240.cover11;
                    Intrinsics.checkNotNullExpressionValue(biliImageView, "cover11");
                    ImageExtentionKt.displayImage$default(biliImageView, item2.getCover(), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1022, (Object) null);
                    BiliImageView biliImageView2 = $this$bind_u24lambda_u240.cover;
                    Intrinsics.checkNotNullExpressionValue(biliImageView2, ReportUtilKt.POS_COVER);
                    ImageExtentionKt.displayImage$default(biliImageView2, (String) null, (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1022, (Object) null);
                } else {
                    BiliImageView biliImageView3 = $this$bind_u24lambda_u240.cover;
                    Intrinsics.checkNotNullExpressionValue(biliImageView3, ReportUtilKt.POS_COVER);
                    ImageExtentionKt.displayImage$default(biliImageView3, item2.getCover(), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1022, (Object) null);
                    ListExtentionsKt.gone($this$bind_u24lambda_u240.cover11);
                }
            }
        } else {
            BiliImageView biliImageView4 = $this$bind_u24lambda_u240.cover;
            Intrinsics.checkNotNullExpressionValue(biliImageView4, ReportUtilKt.POS_COVER);
            ImageExtentionKt.displayImage$default(biliImageView4, ((FavoritesFolderItem) getData()).getCover(), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, ScaleType.CENTER_CROP, (BitmapTransformation) null, false, 894, (Object) null);
        }
        if (((FavoritesFolderItem) getData()).getMediaCount() == 0) {
            color = R.color.Text4;
        } else {
            color = R.color.Text2;
        }
        $this$bind_u24lambda_u240.playText.setTextColor(ContextCompat.getColor(this.itemView.getContext(), color));
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Drawable it = KtxKt.getAppCompatDrawable(context, com.bilibili.iconfont.R.drawable.ref_play_fill_500);
        if (it != null) {
            $this$bind_u24lambda_u240.play.setImageDrawable(it);
            $this$bind_u24lambda_u240.play.setImageTintList(color);
        }
        $this$bind_u24lambda_u240.playText.post(new Runnable() { // from class: tv.danmaku.bili.ui.favorites.card.CompactFolderHolder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CompactFolderHolder.bind$lambda$0$2(BiliAppItemFavoritesCompactFolderBinding.this);
            }
        });
        List<FavoritesMediasItem> recentFav2 = ((FavoritesFolderItem) getData()).getRecentFav();
        if (recentFav2 != null && (item = (FavoritesMediasItem) CollectionsKt.getOrNull(recentFav2, 0)) != null) {
            $this$bind_u24lambda_u240.playContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.card.CompactFolderHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CompactFolderHolder.bind$lambda$0$3$0(CompactFolderHolder.this, item, view);
                }
            });
        } else {
            $this$bind_u24lambda_u240.playContainer.setOnClickListener(null);
        }
        $this$bind_u24lambda_u240.getRoot().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.card.CompactFolderHolder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompactFolderHolder.bind$lambda$0$5(CompactFolderHolder.this, view);
            }
        });
        if (!((FavoritesFolderItem) getData()).isDefault()) {
            $this$bind_u24lambda_u240.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: tv.danmaku.bili.ui.favorites.card.CompactFolderHolder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean bind$lambda$0$6;
                    bind$lambda$0$6 = CompactFolderHolder.bind$lambda$0$6(CompactFolderHolder.this, view);
                    return bind$lambda$0$6;
                }
            });
            $this$bind_u24lambda_u240.playContainer.setOnLongClickListener(new View.OnLongClickListener() { // from class: tv.danmaku.bili.ui.favorites.card.CompactFolderHolder$$ExternalSyntheticLambda4
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean bind$lambda$0$7;
                    bind$lambda$0$7 = CompactFolderHolder.bind$lambda$0$7(CompactFolderHolder.this, view);
                    return bind$lambda$0$7;
                }
            });
        } else {
            $this$bind_u24lambda_u240.getRoot().setOnLongClickListener((View.OnLongClickListener) null);
            $this$bind_u24lambda_u240.playContainer.setOnLongClickListener(null);
        }
        if (((FavoritesFolderItem) getData()).getShowGuide() && !FavoritesConstsKt.getHasShowGuideWindow()) {
            final View $this$doOnPreDraw$iv = this.itemView;
            Intrinsics.checkNotNullExpressionValue($this$doOnPreDraw$iv, "itemView");
            OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.ui.favorites.card.CompactFolderHolder$bind$lambda$0$$inlined$doOnPreDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    View view = $this$doOnPreDraw$iv;
                    this.showGuidePopupWindow();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(Object popup) {
        Intrinsics.checkNotNullParameter(popup, "popup");
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
            Thread thread = Thread.currentThread();
            if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                IllegalStateException exp = new IllegalStateException("PopupWindow.dismiss() called from non-UI thread: " + thread + ", 请联系 Jackin");
                BLog.e("BgThreadUIAccess", "PopupWindow.dismiss() called from non-UI thread: " + thread, exp);
                Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new AppCompatDelegateImpl$.ExternalSyntheticLambda0());
                if (BuildConfig.DEBUG) {
                    throw exp;
                }
            }
        }
        ((PopupWindow) popup).dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$2(BiliAppItemFavoritesCompactFolderBinding $this_run) {
        float textWidth = $this_run.playText.getPaint().measureText($this_run.playText.getText().toString());
        float threshold = DimenUtilsKt.dpToPx(40);
        if (textWidth > threshold) {
            ListExtentionsKt.gone($this_run.playText);
        } else {
            ListExtentionsKt.visible($this_run.playText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$3$0(CompactFolderHolder this$0, FavoritesMediasItem $item, View it) {
        this$0.onPlayItemClick.invoke($item, Long.valueOf(((FavoritesFolderItem) this$0.getData()).getFid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$5(CompactFolderHolder this$0, View it) {
        this$0.onItemClick.invoke(this$0.getData(), Integer.valueOf(this$0.getAbsoluteAdapterPosition()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0$6(CompactFolderHolder this$0, View it) {
        this$0.onItemLongClick.invoke(this$0.getData());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0$7(CompactFolderHolder this$0, View it) {
        this$0.onItemLongClick.invoke(this$0.getData());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showGuidePopupWindow() {
        View contentView = LayoutInflater.from(this.itemView.getContext()).inflate(tv.danmaku.bili.R.layout.bili_app_favorite_folder_guide_bubble, (ViewGroup) null);
        final PopupWindow guideBubble = new PopupWindow(contentView, -1, -2);
        guideBubble.setOutsideTouchable(true);
        contentView.measure(0, 0);
        guideBubble.showAsDropDown(this.itemView, 0, (-this.itemView.getHeight()) - contentView.getMeasuredHeight());
        HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.ui.favorites.card.CompactFolderHolder$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                CompactFolderHolder.__Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(guideBubble);
            }
        }, 3000L);
        FavoritesConstsKt.setHasShowGuideWindow(true);
    }
}