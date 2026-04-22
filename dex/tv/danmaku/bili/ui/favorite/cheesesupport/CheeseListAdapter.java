package tv.danmaku.bili.ui.favorite.cheesesupport;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bilibili.app.comm.list.widget.tag.TagView;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import java.util.ArrayList;
import java.util.List;
import kntr.base.localization.NumberFormat_androidKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.util.AppBuildConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.widget.VectorTextView;
import tv.danmaku.bili.widget.section.adapter.BaseAdapter;
import tv.danmaku.bili.widget.section.holder.BaseViewHolder;

/* compiled from: CheeseListAdapter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u000e\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\fJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\"\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListAdapter;", "Ltv/danmaku/bili/widget/section/adapter/BaseAdapter;", "<init>", "()V", "datas", "", "Ltv/danmaku/bili/ui/favorite/cheesesupport/ICheeseItemProxy;", "appendData", "", "cheeseList", "", "indexOf", "", "cheeseItem", "setData", "getItem", FavoritesConstsKt.POS, "removeItem", "createHolder", "Ltv/danmaku/bili/widget/section/holder/BaseViewHolder;", "parent", "Landroid/view/ViewGroup;", "getItemCount", "bindHolder", "holder", "itemView", "Landroid/view/View;", "CheeseHolder", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class CheeseListAdapter extends BaseAdapter {
    public static final int $stable = 8;
    private List<ICheeseItemProxy> datas = new ArrayList();

    public final void appendData(List<? extends ICheeseItemProxy> list) {
        if (list != null) {
            int count = getItemCount();
            List<ICheeseItemProxy> list2 = this.datas;
            if (list2 != null) {
                list2.addAll(list);
            }
            notifyItemRangeInserted(count, list.size());
        }
    }

    public final int indexOf(ICheeseItemProxy cheeseItem) {
        List<ICheeseItemProxy> list = this.datas;
        if (list != null) {
            return CollectionsKt.indexOf(list, cheeseItem);
        }
        return -1;
    }

    public final void setData(List<? extends ICheeseItemProxy> list) {
        if (list != null) {
            List<ICheeseItemProxy> list2 = this.datas;
            if (list2 != null) {
                list2.clear();
            }
            List<ICheeseItemProxy> list3 = this.datas;
            if (list3 != null) {
                list3.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public final ICheeseItemProxy getItem(int pos) {
        List<ICheeseItemProxy> list;
        boolean z = false;
        if (pos >= 0 && pos < getItemCount()) {
            z = true;
        }
        if (!z || (list = this.datas) == null) {
            return null;
        }
        return list.get(pos);
    }

    public final void removeItem(int pos) {
        boolean z = false;
        if (pos >= 0 && pos < getItemCount()) {
            z = true;
        }
        if (z) {
            List<ICheeseItemProxy> list = this.datas;
            if (list != null) {
                list.remove(pos);
            }
            notifyItemRemoved(pos);
        }
    }

    public BaseViewHolder createHolder(ViewGroup parent, int pos) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return CheeseHolder.Companion.create(parent, this);
    }

    public int getItemCount() {
        List<ICheeseItemProxy> list = this.datas;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void bindHolder(BaseViewHolder holder, int pos, View itemView) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CheeseHolder cheeseHolder = (CheeseHolder) holder;
        List<ICheeseItemProxy> list = this.datas;
        cheeseHolder.onBind(list != null ? list.get(pos) : null);
    }

    /* compiled from: CheeseListAdapter.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListAdapter$CheeseHolder;", "Ltv/danmaku/bili/widget/section/holder/BaseViewHolder;", "itemView", "Landroid/view/View;", "adapter", "Ltv/danmaku/bili/widget/section/adapter/BaseAdapter;", "<init>", "(Landroid/view/View;Ltv/danmaku/bili/widget/section/adapter/BaseAdapter;)V", "mCover", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mTitle", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "mPlayNum", "Ltv/danmaku/bili/widget/VectorTextView;", "mStatus", "mPlayIcon", "Landroid/widget/ImageView;", "tagView", "Lcom/bilibili/app/comm/list/widget/tag/TagView;", "getTagView", "()Lcom/bilibili/app/comm/list/widget/tag/TagView;", "setTagView", "(Lcom/bilibili/app/comm/list/widget/tag/TagView;)V", "onBind", "", "data", "Ltv/danmaku/bili/ui/favorite/cheesesupport/ICheeseItemProxy;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CheeseHolder extends BaseViewHolder {
        private BiliImageView mCover;
        private ImageView mPlayIcon;
        private VectorTextView mPlayNum;
        private TintTextView mStatus;
        private TintTextView mTitle;
        private TagView tagView;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheeseHolder(View itemView, BaseAdapter adapter) {
            super(itemView, adapter);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.mCover = itemView.findViewById(R.id.cover);
            this.mTitle = itemView.findViewById(R.id.title);
            this.mPlayNum = itemView.findViewById(R.id.play_num);
            this.mStatus = itemView.findViewById(R.id.status);
            this.mPlayIcon = (ImageView) itemView.findViewById(R.id.img_play);
            this.tagView = itemView.findViewById(R.id.tag);
        }

        public final TagView getTagView() {
            return this.tagView;
        }

        public final void setTagView(TagView tagView) {
            this.tagView = tagView;
        }

        public final void onBind(ICheeseItemProxy data) {
            int drawableRes;
            Drawable mutate;
            String str;
            BiliImageView it = this.mCover;
            Drawable it2 = null;
            if (it != null) {
                BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
                Context context = it.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                biliImageLoader.with(context).url(data != null ? data.getCover() : null).into(it);
            }
            TintTextView $this$onBind_u24lambda_u241 = this.mTitle;
            if ($this$onBind_u24lambda_u241 != null) {
                $this$onBind_u24lambda_u241.setText(data != null ? data.getTitle() : null);
            }
            TintTextView $this$onBind_u24lambda_u242 = this.mStatus;
            if ($this$onBind_u24lambda_u242 != null) {
                $this$onBind_u24lambda_u242.setText(data != null ? data.getStatus() : null);
            }
            int textColor = AppBuildConfig.Companion.isHDApp() ? com.bilibili.lib.theme.R.color.Wh0_u : com.bilibili.lib.theme.R.color.Ga5;
            if (data != null && data.showVt()) {
                VectorTextView it3 = this.mPlayNum;
                if (it3 != null) {
                    String num = data.getVtNum();
                    if (num != null) {
                        if (!Boolean.valueOf(true ^ StringsKt.isBlank(num)).booleanValue()) {
                            num = null;
                        }
                        if (num != null) {
                            str = num;
                            it3.setText(str);
                        }
                    }
                    it3.setText(str);
                }
                drawableRes = com.bilibili.app.comm.baseres.R.drawable.ic_info_play_duration;
            } else {
                VectorTextView it4 = this.mPlayNum;
                if (it4 != null) {
                    it4.setText(NumberFormat_androidKt.format$default(data != null ? Long.valueOf(data.getPlay()) : null, (String) null, 0, 3, (Object) null));
                }
                drawableRes = com.bilibili.app.comm.baseres.R.drawable.ic_vector_play_number_v2;
            }
            Drawable drawable = AppCompatResources.getDrawable(this.itemView.getContext(), drawableRes);
            if (drawable != null && (mutate = drawable.mutate()) != null) {
                it2 = mutate;
                DrawableCompat.setTint(it2, ContextCompat.getColor(this.itemView.getContext(), textColor));
            }
            ImageView imageView = this.mPlayIcon;
            if (imageView != null) {
                imageView.setImageDrawable(it2);
            }
        }

        /* compiled from: CheeseListAdapter.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListAdapter$CheeseHolder$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListAdapter$CheeseHolder;", "parent", "Landroid/view/ViewGroup;", "adapter", "Ltv/danmaku/bili/widget/section/adapter/BaseAdapter;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final CheeseHolder create(ViewGroup parent, BaseAdapter adapter) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(adapter, "adapter");
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_list_cheese_favorite, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                return new CheeseHolder(inflate, adapter);
            }
        }
    }
}