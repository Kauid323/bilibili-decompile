package tv.danmaku.bili.push.pushsetting.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.push.pushsetting.model.PushNotice;

/* compiled from: PushSettingOptionAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/push/pushsetting/ui/adapter/PushSettingOptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/push/pushsetting/ui/adapter/PushSettingOptionViewHolder;", "list", "", "Ltv/danmaku/bili/push/pushsetting/model/PushNotice;", "isLarge", "", "<init>", "(Ljava/util/List;Z)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "ensureUnique", "checkedPos", "adjustOptionWidth", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PushSettingOptionAdapter extends RecyclerView.Adapter<PushSettingOptionViewHolder> {
    public static final int $stable = 8;
    private final boolean isLarge;
    private final List<PushNotice> list;

    public PushSettingOptionAdapter(List<PushNotice> list, boolean isLarge) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.isLarge = isLarge;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder p0, int p1, List p2) {
        onBindViewHolder((PushSettingOptionViewHolder) p0, p1, (List<Object>) p2);
    }

    public PushSettingOptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View container = LayoutInflater.from(parent.getContext()).inflate(R.layout.push_setting_option_item, parent, false);
        Intrinsics.checkNotNull(container);
        return new PushSettingOptionViewHolder(container, this.isLarge);
    }

    public int getItemCount() {
        return this.list.size();
    }

    public void onBindViewHolder(PushSettingOptionViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final PushNotice item = this.list.get(position);
        TintTextView tvItemTitle = holder.getTvItemTitle();
        if (tvItemTitle != null) {
            tvItemTitle.setText(item.getText());
        }
        BiliImageView ivSelect = holder.getIvSelect();
        if (ivSelect != null) {
            ivSelect.setImageResource(item.isChecked() ? R.drawable.radio_button_checked : R.drawable.radio_button_unchecked);
        }
        holder.getContainer().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.push.pushsetting.ui.adapter.PushSettingOptionAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingOptionAdapter.onBindViewHolder$lambda$0(PushNotice.this, this, position, view);
            }
        });
        String tag = item.getTag();
        if (tag == null || StringsKt.isBlank(tag)) {
            TintTextView tag2 = holder.getTag();
            if (tag2 != null) {
                tag2.setVisibility(8);
            }
        } else {
            TintTextView tag3 = holder.getTag();
            if (tag3 != null) {
                tag3.setVisibility(0);
            }
            TintTextView tag4 = holder.getTag();
            if (tag4 != null) {
                tag4.setText(item.getTag());
            }
        }
        adjustOptionWidth(holder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(PushNotice $item, PushSettingOptionAdapter this$0, int $position, View it) {
        if (!$item.isChecked()) {
            this$0.ensureUnique($position);
        }
    }

    public void onBindViewHolder(PushSettingOptionViewHolder holder, int position, List<Object> list) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        super.onBindViewHolder(holder, position, list);
        if (list.contains("check_state_changed_payload")) {
            PushNotice item = this.list.get(position);
            BiliImageView ivSelect = holder.getIvSelect();
            if (ivSelect != null) {
                ivSelect.setImageResource(item.isChecked() ? R.drawable.radio_button_checked : R.drawable.radio_button_unchecked);
            }
        }
    }

    private final void ensureUnique(int checkedPos) {
        Iterable $this$forEachIndexed$iv = this.list;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            PushNotice pushItem = (PushNotice) item$iv;
            pushItem.setChecked(checkedPos == index);
            notifyItemChanged(index, "check_state_changed_payload");
            index = index$iv;
        }
    }

    private final void adjustOptionWidth(PushSettingOptionViewHolder holder) {
        TintTextView tvItemTitle;
        ViewGroup.LayoutParams $this$adjustOptionWidth_u24lambda_u240;
        TextView tag = holder.getTag();
        int tagWidth = tag != null ? PushSettingOptionAdapterKt.access$getTagWidth(tag) : 0;
        TextView tvItemTitle2 = holder.getTvItemTitle();
        int optionWidth = tvItemTitle2 != null ? PushSettingOptionAdapterKt.access$getPreWidth(tvItemTitle2) : 0;
        int screenWidth = ScreenUtil.getScreenWidth(holder.getContainer().getContext());
        int maxWidth = screenWidth - ListExtentionsKt.toPx(this.isLarge ? 70 : BR.disable);
        if (tagWidth + optionWidth <= maxWidth || (tvItemTitle = holder.getTvItemTitle()) == null) {
            return;
        }
        TintTextView tvItemTitle3 = holder.getTvItemTitle();
        if (tvItemTitle3 == null || ($this$adjustOptionWidth_u24lambda_u240 = tvItemTitle3.getLayoutParams()) == null) {
            $this$adjustOptionWidth_u24lambda_u240 = null;
        } else {
            $this$adjustOptionWidth_u24lambda_u240.width = maxWidth - tagWidth;
        }
        tvItemTitle.setLayoutParams($this$adjustOptionWidth_u24lambda_u240);
    }
}