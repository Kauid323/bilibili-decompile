package tv.danmaku.bili.appwidget.guide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bapis.bilibili.app.show.mixture.v1.GuideCard;
import com.bilibili.app.comm.list.widget.swiper.SwiperBannerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.CommonMenuBottomSheetKt;

/* compiled from: SwipeImageWithTitleAdapter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/SwipeImageWithTitleAdapter;", "Lcom/bilibili/app/comm/list/widget/swiper/SwiperBannerAdapter;", "Lcom/bapis/bilibili/app/show/mixture/v1/GuideCard;", CommonMenuBottomSheetKt.KEY_ITEMS, "", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolderReal", "", "holder", "position", "payloads", "", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SwipeImageWithTitleAdapter extends SwiperBannerAdapter<GuideCard> {
    public static final int $stable = SwiperBannerAdapter.$stable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeImageWithTitleAdapter(List<GuideCard> list) {
        super(list);
        Intrinsics.checkNotNullParameter(list, CommonMenuBottomSheetKt.KEY_ITEMS);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_widget_guide_banner_item_layout, parent, false);
        Intrinsics.checkNotNull(itemView);
        return new ImageWithTitleHolder(itemView);
    }

    public void onBindViewHolderReal(RecyclerView.ViewHolder holder, int position, List<Object> list) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (holder instanceof ImageWithTitleHolder) {
            ((ImageWithTitleHolder) holder).bind((GuideCard) getMDataList().get(position));
        }
    }
}