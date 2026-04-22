package tv.danmaku.bili.ui.main2.mine.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bilibili.app.comm.list.widget.utils.LifecycleExtentionsKt;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.RoundingParams;
import com.bilibili.lib.image2.view.BiliImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.mine.IMineItemClickListener;
import tv.danmaku.bili.ui.main2.mine.MineExtentionsKt;

public class InnerMineModulePortViewHolder extends BaseMineItemViewHolder {
    private BiliImageView mIcon;
    private TextView mTitle;

    public InnerMineModulePortViewHolder(View itemView, IMineItemClickListener clickListener) {
        super(itemView, clickListener);
        this.mIcon = itemView.findViewById(R.id.icon);
        this.mTitle = (TextView) itemView.findViewById(R.id.title);
    }

    public static InnerMineModulePortViewHolder create(ViewGroup parent, IMineItemClickListener clickListener) {
        return new InnerMineModulePortViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_layout_main_user_center_port_item, parent, false), clickListener);
    }

    @Override // tv.danmaku.bili.ui.main2.mine.holder.BaseMineItemViewHolder
    public void bind(MenuGroup.Item item, MenuGroup menuGroup) {
        super.bind(item, menuGroup);
        bindImage(item);
        this.mTitle.setText(item.title);
    }

    @Override // tv.danmaku.bili.ui.main2.mine.holder.BaseMineItemViewHolder, android.view.View.OnClickListener
    public void onClick(View v) {
        super.onClick(v);
        if (MineExtentionsKt.isShowLocalIcon(this.mItem)) {
            this.mItem.tempIcon = null;
            FragmentActivity findFragmentActivityOrNull = ContextUtilKt.findFragmentActivityOrNull(v.getContext());
            if (findFragmentActivityOrNull != null) {
                LifecycleExtentionsKt.onNextEvent(findFragmentActivityOrNull, Lifecycle.Event.ON_RESUME, new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.holder.InnerMineModulePortViewHolder$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return InnerMineModulePortViewHolder.this.m2089lambda$onClick$0$tvdanmakubiliuimain2mineholderInnerMineModulePortViewHolder();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onClick$0$tv-danmaku-bili-ui-main2-mine-holder-InnerMineModulePortViewHolder  reason: not valid java name */
    public /* synthetic */ Unit m2089lambda$onClick$0$tvdanmakubiliuimain2mineholderInnerMineModulePortViewHolder() {
        bindImage(this.mItem);
        return null;
    }

    private void bindImage(MenuGroup.Item item) {
        if (MineExtentionsKt.isShowLocalIcon(item)) {
            updateImage(item.tempIcon, RoundingParams.fromCornersRadius(ScreenUtil.dip2px(this.itemView.getContext(), 6.0f)));
        } else if (MineExtentionsKt.isShowMngResource(item)) {
            updateImage(item.itemMngResource.icon, null);
            tryShowBadge(null);
        } else if (item.cornerPixel > 0) {
            updateImage(item.icon, RoundingParams.fromCornersRadius(item.cornerPixel));
        } else {
            updateImage(item.icon, null);
        }
    }

    private void updateImage(String icon, RoundingParams roundingParams) {
        ImageRequestBuilder builder = BiliImageLoader.INSTANCE.with(this.itemView.getContext()).placeholderImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), this.mItem.iconResId != 0 ? this.mItem.iconResId : com.bilibili.app.comm.baseres.R.drawable.bili_default_image_tv)).url(icon);
        if (roundingParams != null) {
            builder.roundingParams(roundingParams);
        }
        builder.into(this.mIcon);
    }

    @Override // tv.danmaku.bili.ui.main2.mine.holder.BaseMineItemViewHolder
    protected void resetMngResource() {
        updateImage(this.mItem.icon, null);
    }
}