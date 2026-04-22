package tv.danmaku.bili.ui.favorites.adapter;

import android.content.Context;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegateImpl$;
import androidx.core.view.OneShotPreDrawListener;
import androidx.recyclerview.widget.RecyclerView;
import bili.resource.favorites.R;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.magicasakura.utils.ThemeUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesFolderBinding;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.favorites.card.BaseFavoritesHolder;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesFolderItem;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.util.FavoritesUtilsKt;
import tv.danmaku.bili.ui.favorites.widget.RoundBackgroundColorSpan;

/* compiled from: FolderListAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B·\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f0\u000e\u0012K\u0010\u000f\u001aG\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u001a\u001a\u00020\fH\u0014J\b\u0010\u001b\u001a\u00020\fH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R>\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000RS\u0010\u000f\u001aG\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FolderHolder;", "Ltv/danmaku/bili/ui/favorites/card/BaseFavoritesHolder;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesFolderItem;", "binding", "Ltv/danmaku/bili/databinding/BiliAppItemFavoritesFolderBinding;", "onItemClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "item", "", FavoritesConstsKt.POS, "", "onItemLongClick", "Lkotlin/Function1;", "onFolderItemClick", "Lkotlin/Function3;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "", "fid", "<init>", "(Ltv/danmaku/bili/databinding/BiliAppItemFavoritesFolderBinding;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppItemFavoritesFolderBinding;", "topString", "", "bind", "showGuidePopupWindow", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FolderHolder extends BaseFavoritesHolder<FavoritesFolderItem> {
    public static final int $stable = 8;
    private final BiliAppItemFavoritesFolderBinding binding;
    private final Function3<FavoritesMediasItem, Integer, Long, Unit> onFolderItemClick;
    private final Function2<FavoritesFolderItem, Integer, Unit> onItemClick;
    private final Function1<FavoritesFolderItem, Unit> onItemLongClick;
    private final String topString;

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

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FolderHolder(BiliAppItemFavoritesFolderBinding binding, Function2<? super FavoritesFolderItem, ? super Integer, Unit> function2, Function1<? super FavoritesFolderItem, Unit> function1, Function3<? super FavoritesMediasItem, ? super Integer, ? super Long, Unit> function3) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(function2, "onItemClick");
        Intrinsics.checkNotNullParameter(function1, "onItemLongClick");
        Intrinsics.checkNotNullParameter(function3, "onFolderItemClick");
        View root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = binding;
        this.onItemClick = function2;
        this.onItemLongClick = function1;
        this.onFolderItemClick = function3;
        String string = this.binding.getRoot().getContext().getString(R.string.favorites_global_string_222);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.topString = string;
    }

    public final BiliAppItemFavoritesFolderBinding getBinding() {
        return this.binding;
    }

    protected void bind() {
        final BiliAppItemFavoritesFolderBinding $this$bind_u24lambda_u240 = this.binding;
        $this$bind_u24lambda_u240.lock.setVisibility(ListExtentionsKt.toVisibility(((FavoritesFolderItem) getData()).isPrivate()));
        SpannableStringBuilder span = new SpannableStringBuilder(((FavoritesFolderItem) getData()).getTitle());
        if (((FavoritesFolderItem) getData()).isTop()) {
            $this$bind_u24lambda_u240.folderTitle.setEllipsize((TextUtils.TruncateAt) null);
            span.append((CharSequence) this.topString);
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            span.setSpan(new RoundBackgroundColorSpan(ListExtentionsKt.sp2Px(10, context), ListExtentionsKt.toPx(2), ThemeUtils.getColorById(this.itemView.getContext(), com.bilibili.lib.theme.R.color.Text3), ThemeUtils.getColorById(this.itemView.getContext(), com.bilibili.lib.theme.R.color.Bg3), 0, ListExtentionsKt.toPx(2), ListExtentionsKt.toPx(1), ListExtentionsKt.toPx(6), ListExtentionsKt.toPx(8)), ((FavoritesFolderItem) getData()).getTitle().length(), span.length(), 33);
            OneShotPreDrawListener.add($this$bind_u24lambda_u240.folderTitle, new Runnable() { // from class: tv.danmaku.bili.ui.favorites.adapter.FolderHolder$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    FolderHolder.bind$lambda$0$0(FolderHolder.this, $this$bind_u24lambda_u240);
                }
            });
        } else {
            $this$bind_u24lambda_u240.folderTitle.setEllipsize(TextUtils.TruncateAt.END);
        }
        $this$bind_u24lambda_u240.folderTitle.setText(span);
        $this$bind_u24lambda_u240.subtitle.setText(((FavoritesFolderItem) getData()).getAttrDesc());
        RecyclerView.Adapter folderHolderAdapter = new FolderHolderAdapter(((FavoritesFolderItem) getData()).isDefault(), new Function0() { // from class: tv.danmaku.bili.ui.favorites.adapter.FolderHolder$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit bind$lambda$0$1;
                bind$lambda$0$1 = FolderHolder.bind$lambda$0$1(FolderHolder.this);
                return bind$lambda$0$1;
            }
        }, new Function1() { // from class: tv.danmaku.bili.ui.favorites.adapter.FolderHolder$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit bind$lambda$0$2;
                bind$lambda$0$2 = FolderHolder.bind$lambda$0$2(FolderHolder.this, (FavoritesMediasItem) obj);
                return bind$lambda$0$2;
            }
        });
        $this$bind_u24lambda_u240.recyclerView.setAdapter(folderHolderAdapter);
        folderHolderAdapter.submitList(((FavoritesFolderItem) getData()).getRecentFav());
        $this$bind_u24lambda_u240.getRoot().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FolderHolder$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FolderHolder.bind$lambda$0$3(FolderHolder.this, view);
            }
        });
        if (((FavoritesFolderItem) getData()).isDefault()) {
            $this$bind_u24lambda_u240.getRoot().setOnLongClickListener((View.OnLongClickListener) null);
        } else {
            $this$bind_u24lambda_u240.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FolderHolder$$ExternalSyntheticLambda5
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean bind$lambda$0$4;
                    bind$lambda$0$4 = FolderHolder.bind$lambda$0$4(FolderHolder.this, view);
                    return bind$lambda$0$4;
                }
            });
        }
        if (((FavoritesFolderItem) getData()).getShowGuide() && !FavoritesConstsKt.getHasShowGuideWindow()) {
            final View $this$doOnPreDraw$iv = this.itemView;
            Intrinsics.checkNotNullExpressionValue($this$doOnPreDraw$iv, "itemView");
            OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.ui.favorites.adapter.FolderHolder$bind$lambda$0$$inlined$doOnPreDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    View view = $this$doOnPreDraw$iv;
                    this.showGuidePopupWindow();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$0(FolderHolder this$0, BiliAppItemFavoritesFolderBinding $this_run) {
        SpannableStringBuilder suffix = new SpannableStringBuilder("…");
        Context context = this$0.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        RoundBackgroundColorSpan roundSpan = new RoundBackgroundColorSpan(ListExtentionsKt.sp2Px(10, context), ListExtentionsKt.toPx(2), ThemeUtils.getColorById(this$0.itemView.getContext(), com.bilibili.lib.theme.R.color.Text3), ThemeUtils.getColorById(this$0.itemView.getContext(), com.bilibili.lib.theme.R.color.Bg3), 0, ListExtentionsKt.toPx(2), ListExtentionsKt.toPx(1), ListExtentionsKt.toPx(4), ListExtentionsKt.toPx(8));
        TextPaint paint = $this_run.folderTitle.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "getPaint(...)");
        int tagWidth = roundSpan.getSize(paint, this$0.topString, 0, this$0.topString.length(), $this_run.folderTitle.getPaint().getFontMetricsInt());
        suffix.append(this$0.topString, roundSpan, 33);
        TextView textView = $this_run.folderTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "folderTitle");
        CharSequence temp = FavoritesUtilsKt.calculateEllipsize(textView, ((FavoritesFolderItem) this$0.getData()).getTitle(), 2, suffix, tagWidth);
        if (!Intrinsics.areEqual(temp, ((FavoritesFolderItem) this$0.getData()).getTitle())) {
            $this_run.folderTitle.setText(temp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bind$lambda$0$1(FolderHolder this$0) {
        this$0.onItemLongClick.invoke(this$0.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bind$lambda$0$2(FolderHolder this$0, FavoritesMediasItem folderItem) {
        Intrinsics.checkNotNullParameter(folderItem, "folderItem");
        this$0.onFolderItemClick.invoke(folderItem, Integer.valueOf(this$0.getAbsoluteAdapterPosition()), Long.valueOf(((FavoritesFolderItem) this$0.getData()).getFid()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$3(FolderHolder this$0, View it) {
        this$0.onItemClick.invoke(this$0.getData(), Integer.valueOf(this$0.getAbsoluteAdapterPosition()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0$4(FolderHolder this$0, View it) {
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
        HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.ui.favorites.adapter.FolderHolder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FolderHolder.__Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(guideBubble);
            }
        }, 3000L);
        FavoritesConstsKt.setHasShowGuideWindow(true);
    }
}