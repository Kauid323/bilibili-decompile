package tv.danmaku.bili.ui.offline;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import bili.resource.others.R;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineStatus;
import com.bilibili.offline.OfflineType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.offline.ItemActionCallback;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DownloadingAdapter.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0017\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004<=>?B/\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0012\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u000fJ\u000e\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u000fJ\u000e\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u000fJ\b\u00102\u001a\u00020\u0014H\u0002J\u000e\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0005J\u0010\u00109\u001a\u00020\u00162\b\u00109\u001a\u0004\u0018\u00010\u0005J\u0012\u0010:\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010;\u001a\u00020\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0011\u00100\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00103\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00101R\u0019\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001a8F¢\u0006\u0006\u001a\u0004\b5\u00106¨\u0006@"}, d2 = {"Ltv/danmaku/bili/ui/offline/DownloadingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/ui/offline/DownloadingAdapter$BaseDownloadingHolder;", "mOfflineInfos", "", "Lcom/bilibili/offline/OfflineInfo;", "mDownloadingInfos", "mItemActionCallback", "Ltv/danmaku/bili/ui/offline/ItemActionCallback$Downloading;", "<init>", "(Ljava/util/List;Ljava/util/List;Ltv/danmaku/bili/ui/offline/ItemActionCallback$Downloading;)V", "mCheckedInfos", "Landroidx/collection/ArrayMap;", "", "mEditMode", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "mCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mLongClickListener", "Landroid/view/View$OnLongClickListener;", "getItemCount", "getItemViewType", "getKey", "info", "setEditMode", "editMode", "checkedInfo", "", "getCheckedInfo", "()Ljava/util/Collection;", "checkAll", "check", "removeChecked", "notifyChange", "isAllStopped", "()Z", "caclCheckedCount", "isAllChecked", "offlineInfo", "getOfflineInfo", "()Ljava/util/List;", "updateStatus", "update", "remove", "tryUpdateDownloadingList", "clear", "BaseDownloadingHolder", "DownloadingVideoHolder", "DownloadingAudioHolder", "Payload", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DownloadingAdapter extends RecyclerView.Adapter<BaseDownloadingHolder> {
    public static final int $stable = 8;
    private final CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    private final ArrayMap<String, OfflineInfo> mCheckedInfos;
    private final List<OfflineInfo> mDownloadingInfos;
    private boolean mEditMode;
    private final ItemActionCallback.Downloading mItemActionCallback;
    private final View.OnLongClickListener mLongClickListener;
    private final List<OfflineInfo> mOfflineInfos;
    private final View.OnClickListener mOnClickListener;

    /* compiled from: DownloadingAdapter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/ui/offline/DownloadingAdapter$Payload;", "", "<init>", "(Ljava/lang/String;I)V", "UPDATE_PROGRESS", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum Payload {
        UPDATE_PROGRESS;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Payload> getEntries() {
            return $ENTRIES;
        }
    }

    public DownloadingAdapter(List<OfflineInfo> list, List<OfflineInfo> list2, ItemActionCallback.Downloading mItemActionCallback) {
        Intrinsics.checkNotNullParameter(list, "mOfflineInfos");
        Intrinsics.checkNotNullParameter(list2, "mDownloadingInfos");
        Intrinsics.checkNotNullParameter(mItemActionCallback, "mItemActionCallback");
        this.mOfflineInfos = list;
        this.mDownloadingInfos = list2;
        this.mItemActionCallback = mItemActionCallback;
        this.mCheckedInfos = new ArrayMap<>(this.mOfflineInfos.size());
        this.mCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingAdapter$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DownloadingAdapter.mCheckedChangeListener$lambda$0(DownloadingAdapter.this, compoundButton, z);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DownloadingAdapter.mOnClickListener$lambda$0(DownloadingAdapter.this, view2);
            }
        };
        this.mLongClickListener = new View.OnLongClickListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean mLongClickListener$lambda$0;
                mLongClickListener$lambda$0 = DownloadingAdapter.mLongClickListener$lambda$0(DownloadingAdapter.this, view2);
                return mLongClickListener$lambda$0;
            }
        };
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder p0, int p1, List p2) {
        onBindViewHolder((BaseDownloadingHolder) p0, p1, (List<? extends Object>) p2);
    }

    public BaseDownloadingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == OfflineType.TYPE_AUDIO) {
            return DownloadingAudioHolder.Companion.create(parent);
        }
        return DownloadingVideoHolder.Companion.create(parent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0125, code lost:
        if ((r8.length() > 0) == true) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(BaseDownloadingHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        OfflineInfo info = this.mOfflineInfos.get(position);
        if (info == null) {
            return;
        }
        holder.setMInfo(info);
        holder.itemView.setTag(holder);
        holder.itemView.setOnClickListener(this.mOnClickListener);
        holder.itemView.setOnLongClickListener(this.mLongClickListener);
        holder.getMCover().setTag(holder);
        holder.getMCover().setOnClickListener(this.mOnClickListener);
        if (this.mEditMode) {
            holder.getMCheckBox().setVisibility(0);
            holder.getMCheckBox().setTag(info);
            holder.getMCheckBox().setOnCheckedChangeListener(null);
            holder.getMCheckBox().setChecked(this.mCheckedInfos.containsKey(getKey(info)));
            holder.getMCheckBox().setOnCheckedChangeListener(this.mCheckedChangeListener);
        } else {
            holder.getMCheckBox().setVisibility(8);
            holder.getMCheckBox().setOnCheckedChangeListener(null);
        }
        BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
        Context context = holder.getMCover().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        biliImageLoader.with(context).url(info.cover).into(holder.getMCover());
        holder.getMTitle().setText(info.title);
        holder.updateProgressInfo(info);
        if (holder instanceof DownloadingVideoHolder) {
            String subTitle = OfflineUtil.getPageTitle(info);
            boolean z = true;
            if (StringsKt.equals(subTitle, info.title, true)) {
                ((DownloadingVideoHolder) holder).getMSubtitle().setText("");
            } else {
                ((DownloadingVideoHolder) holder).getMSubtitle().setText(subTitle);
            }
            TextView label = ((DownloadingVideoHolder) holder).getMLabel();
            if (info.isChargeVideo()) {
                TextView $this$isVisible$iv = label;
                $this$isVisible$iv.setVisibility(0);
                label.setText(label.getContext().getString(R.string.others_global_string_364));
                label.setCompoundDrawablesRelativeWithIntrinsicBounds(AppCompatResources.getDrawable(label.getContext(), com.bilibili.playerbizcommonv2.R.drawable.bili_app_offline_charge_label), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            OfflineType offlineType = info.offlineType;
            if (offlineType != null && (r8 = offlineType.typeName) != null) {
            }
            z = false;
            if (z) {
                TextView $this$isVisible$iv2 = label;
                $this$isVisible$iv2.setVisibility(0);
                OfflineType offlineType2 = info.offlineType;
                label.setText(offlineType2 != null ? offlineType2.typeName : null);
                label.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            TextView $this$isVisible$iv3 = label;
            $this$isVisible$iv3.setVisibility(8);
            label.setText("");
            label.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void onBindViewHolder(BaseDownloadingHolder holder, int position, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (list.isEmpty()) {
            onBindViewHolder(holder, position);
            return;
        }
        OfflineInfo info = this.mOfflineInfos.get(position);
        for (Object payload : list) {
            if (payload == Payload.UPDATE_PROGRESS && info != null) {
                holder.updateProgressInfo(info);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mCheckedChangeListener$lambda$0(DownloadingAdapter this$0, CompoundButton buttonView, boolean isChecked) {
        Object tag = buttonView.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.bilibili.offline.OfflineInfo");
        OfflineInfo info = (OfflineInfo) tag;
        String key = this$0.getKey(info);
        if (isChecked) {
            this$0.mCheckedInfos.put(key, info);
        } else {
            this$0.mCheckedInfos.remove(key);
        }
        this$0.mItemActionCallback.onCheckedItemCountChange(this$0.caclCheckedCount(), this$0.isAllChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
        if (r2.canPlayInAdvance == true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void mOnClickListener$lambda$0(DownloadingAdapter this$0, View v) {
        boolean z;
        Intrinsics.checkNotNullParameter(v, "v");
        int viewId = v.getId();
        if (viewId == tv.danmaku.bili.R.id.cover) {
            Object tag = v.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type tv.danmaku.bili.ui.offline.DownloadingAdapter.BaseDownloadingHolder");
            BaseDownloadingHolder holder = (BaseDownloadingHolder) tag;
            if (this$0.mEditMode) {
                holder.getMCheckBox().toggle();
                return;
            }
            OfflineInfo mInfo = holder.getMInfo();
            if (mInfo != null) {
                z = true;
            }
            z = false;
            if (z) {
                Neurons.reportClick$default(false, OfflineReportHelper.CLICK_PLAY_IN_ADVANCE, (Map) null, 4, (Object) null);
                this$0.mItemActionCallback.play(v.getContext(), holder.getMInfo());
                return;
            }
            this$0.mItemActionCallback.pauseResume(holder.getMInfo());
            return;
        }
        Object tag2 = v.getTag();
        Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type tv.danmaku.bili.ui.offline.DownloadingAdapter.BaseDownloadingHolder");
        BaseDownloadingHolder holder2 = (BaseDownloadingHolder) tag2;
        if (this$0.mEditMode) {
            holder2.getMCheckBox().toggle();
        } else {
            this$0.mItemActionCallback.pauseResume(holder2.getMInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mLongClickListener$lambda$0(DownloadingAdapter this$0, View v) {
        if (!this$0.mEditMode) {
            Object tag = v.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type tv.danmaku.bili.ui.offline.DownloadingAdapter.BaseDownloadingHolder");
            BaseDownloadingHolder holder = (BaseDownloadingHolder) tag;
            this$0.mCheckedInfos.put(this$0.getKey(holder.getMInfo()), holder.getMInfo());
            this$0.mItemActionCallback.enterEditMode();
            return false;
        }
        return false;
    }

    public int getItemCount() {
        return this.mOfflineInfos.size();
    }

    public int getItemViewType(int position) {
        OfflineType offlineType;
        OfflineInfo offlineInfo = this.mOfflineInfos.get(position);
        return (offlineInfo == null || (offlineType = offlineInfo.offlineType) == null) ? OfflineType.TYPE_VIDEO : offlineType.type;
    }

    private final String getKey(OfflineInfo info) {
        return info == null ? "" : OfflineUtil.createKey(info);
    }

    public final void setEditMode(boolean editMode) {
        this.mEditMode = editMode;
        if (this.mEditMode) {
            this.mItemActionCallback.onCheckedItemCountChange(caclCheckedCount(), isAllChecked());
        } else {
            this.mCheckedInfos.clear();
        }
        notifyDataSetChanged();
    }

    public final Collection<OfflineInfo> getCheckedInfo() {
        return this.mCheckedInfos.values();
    }

    public final void checkAll(boolean check) {
        this.mCheckedInfos.clear();
        if (check) {
            for (OfflineInfo info : this.mOfflineInfos) {
                this.mCheckedInfos.put(getKey(info), info);
            }
        }
        this.mItemActionCallback.onCheckedItemCountChange(caclCheckedCount(), isAllChecked());
        notifyDataSetChanged();
    }

    public final void removeChecked(boolean notifyChange) {
        this.mOfflineInfos.removeAll(this.mCheckedInfos.values());
        this.mDownloadingInfos.removeAll(this.mCheckedInfos.values());
        if (notifyChange) {
            notifyDataSetChanged();
        }
        this.mItemActionCallback.onItemCountChange(this.mOfflineInfos.size());
    }

    public final boolean isAllStopped() {
        return this.mDownloadingInfos.size() == 0;
    }

    private final int caclCheckedCount() {
        return this.mCheckedInfos.size();
    }

    private final boolean isAllChecked() {
        return this.mCheckedInfos.size() == this.mOfflineInfos.size();
    }

    public final List<OfflineInfo> getOfflineInfo() {
        return this.mOfflineInfos;
    }

    public final void updateStatus(OfflineInfo update) {
        Intrinsics.checkNotNullParameter(update, "update");
        int size = this.mOfflineInfos.size();
        for (int i = 0; i < size; i++) {
            OfflineInfo info = this.mOfflineInfos.get(i);
            if (OfflineUtil.isEquals(update, info)) {
                boolean z = false;
                if (info != null && info.canPlayInAdvance == update.canPlayInAdvance) {
                    z = true;
                }
                if (!z && update.canPlayInAdvance) {
                    Neurons.reportExposure$default(false, OfflineReportHelper.SHOW_PLAY_IN_ADVANCE, (Map) null, (List) null, 12, (Object) null);
                }
                OfflineUtil.updateData(update, info);
                tryUpdateDownloadingList(info);
                notifyItemChanged(i, Payload.UPDATE_PROGRESS);
                return;
            }
        }
    }

    public final void remove(OfflineInfo remove) {
        Collection $this$toTypedArray$iv = this.mOfflineInfos;
        int i = 0;
        Object[] $this$forEachIndexed$iv = $this$toTypedArray$iv.toArray(new OfflineInfo[0]);
        int index$iv = 0;
        int length = $this$forEachIndexed$iv.length;
        while (i < length) {
            Object item$iv = $this$forEachIndexed$iv[i];
            int index$iv2 = index$iv + 1;
            OfflineInfo offlineInfo = (OfflineInfo) item$iv;
            if (OfflineUtil.isEquals(remove, offlineInfo)) {
                this.mOfflineInfos.remove(offlineInfo);
                notifyItemRemoved(index$iv);
            }
            i++;
            index$iv = index$iv2;
        }
        tryUpdateDownloadingList(remove);
    }

    private final void tryUpdateDownloadingList(OfflineInfo info) {
        boolean z;
        OfflineInfo downloading;
        if (info == null) {
            return;
        }
        Iterator it = this.mDownloadingInfos.iterator();
        do {
            z = true;
            if (it.hasNext()) {
                downloading = it.next();
            } else {
                OfflineStatus offlineStatus = info.offlineStatus;
                if (!(offlineStatus != null && offlineStatus.code == 1)) {
                    OfflineStatus offlineStatus2 = info.offlineStatus;
                    if (!(offlineStatus2 != null && offlineStatus2.code == 5)) {
                        OfflineStatus offlineStatus3 = info.offlineStatus;
                        if (offlineStatus3 == null || offlineStatus3.code != 3) {
                            z = false;
                        }
                        if (!z) {
                            return;
                        }
                    }
                }
                this.mDownloadingInfos.add(info);
                return;
            }
        } while (!OfflineUtil.isEquals(downloading, info));
        OfflineStatus offlineStatus4 = info.offlineStatus;
        if (offlineStatus4 != null && offlineStatus4.code == 1) {
            return;
        }
        OfflineStatus offlineStatus5 = info.offlineStatus;
        if (offlineStatus5 != null && offlineStatus5.code == 5) {
            return;
        }
        OfflineStatus offlineStatus6 = info.offlineStatus;
        if (offlineStatus6 == null || offlineStatus6.code != 3) {
            z = false;
        }
        if (!z) {
            it.remove();
        }
    }

    public final void clear() {
        this.mDownloadingInfos.clear();
        notifyDataSetChanged();
    }

    /* compiled from: DownloadingAdapter.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\"J\u0010\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020\"H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006+"}, d2 = {"Ltv/danmaku/bili/ui/offline/DownloadingAdapter$BaseDownloadingHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mCheckBox", "Landroid/widget/CheckBox;", "getMCheckBox", "()Landroid/widget/CheckBox;", "setMCheckBox", "(Landroid/widget/CheckBox;)V", "mCover", "Lcom/bilibili/lib/image2/view/legacy/StaticImageView2;", "getMCover", "()Lcom/bilibili/lib/image2/view/legacy/StaticImageView2;", "setMCover", "(Lcom/bilibili/lib/image2/view/legacy/StaticImageView2;)V", "mTitle", "Landroid/widget/TextView;", "getMTitle", "()Landroid/widget/TextView;", "setMTitle", "(Landroid/widget/TextView;)V", "mTip", "getMTip", "setMTip", "mProgressBar", "Ltv/danmaku/bili/ui/offline/OfflineProgress;", "getMProgressBar", "()Ltv/danmaku/bili/ui/offline/OfflineProgress;", "setMProgressBar", "(Ltv/danmaku/bili/ui/offline/OfflineProgress;)V", "mInfo", "Lcom/bilibili/offline/OfflineInfo;", "getMInfo", "()Lcom/bilibili/offline/OfflineInfo;", "setMInfo", "(Lcom/bilibili/offline/OfflineInfo;)V", "setTipMessage", "", "info", "updateProgressInfo", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class BaseDownloadingHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private CheckBox mCheckBox;
        private StaticImageView2 mCover;
        private OfflineInfo mInfo;
        private OfflineProgress mProgressBar;
        private TextView mTip;
        private TextView mTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseDownloadingHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(tv.danmaku.bili.R.id.checkbox);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.mCheckBox = (CheckBox) findViewById;
            StaticImageView2 findViewById2 = itemView.findViewById(tv.danmaku.bili.R.id.cover);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.mCover = findViewById2;
            View findViewById3 = itemView.findViewById(tv.danmaku.bili.R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.mTitle = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(tv.danmaku.bili.R.id.tip);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.mTip = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(tv.danmaku.bili.R.id.progress);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.mProgressBar = (OfflineProgress) findViewById5;
        }

        public final CheckBox getMCheckBox() {
            return this.mCheckBox;
        }

        public final void setMCheckBox(CheckBox checkBox) {
            Intrinsics.checkNotNullParameter(checkBox, "<set-?>");
            this.mCheckBox = checkBox;
        }

        public final StaticImageView2 getMCover() {
            return this.mCover;
        }

        public final void setMCover(StaticImageView2 staticImageView2) {
            Intrinsics.checkNotNullParameter(staticImageView2, "<set-?>");
            this.mCover = staticImageView2;
        }

        public final TextView getMTitle() {
            return this.mTitle;
        }

        public final void setMTitle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTitle = textView;
        }

        public final TextView getMTip() {
            return this.mTip;
        }

        public final void setMTip(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTip = textView;
        }

        public final OfflineProgress getMProgressBar() {
            return this.mProgressBar;
        }

        public final void setMProgressBar(OfflineProgress offlineProgress) {
            Intrinsics.checkNotNullParameter(offlineProgress, "<set-?>");
            this.mProgressBar = offlineProgress;
        }

        public final OfflineInfo getMInfo() {
            return this.mInfo;
        }

        public final void setMInfo(OfflineInfo offlineInfo) {
            this.mInfo = offlineInfo;
        }

        public final void setTipMessage(OfflineInfo info) {
            String str;
            OfflineStatus offlineStatus;
            OfflineStatus offlineStatus2;
            SpannableString tip = (info == null || (offlineStatus2 = info.offlineStatus) == null) ? null : offlineStatus2.message;
            if ((info == null || (offlineStatus = info.offlineStatus) == null || offlineStatus.code != 2) ? false : true) {
                int color = ThemeUtils.getColorById(this.itemView.getContext(), com.bilibili.app.comm.baseres.R.color.theme_color_secondary);
                OfflineStatus offlineStatus3 = info.offlineStatus;
                SpannableString spannableString = SpannableString.valueOf(offlineStatus3 != null ? offlineStatus3.message : null);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
                OfflineStatus offlineStatus4 = info.offlineStatus;
                spannableString.setSpan(foregroundColorSpan, 0, (offlineStatus4 == null || (str = offlineStatus4.message) == null) ? 0 : str.length(), 17);
                tip = spannableString;
            }
            this.mTip.setText(tip);
        }

        public void updateProgressInfo(OfflineInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            setTipMessage(info);
            OfflineStatus offlineStatus = info.offlineStatus;
            boolean z = true;
            if (!(offlineStatus != null && offlineStatus.code == 5)) {
                OfflineStatus offlineStatus2 = info.offlineStatus;
                if (!(offlineStatus2 != null && offlineStatus2.code == 6)) {
                    OfflineStatus offlineStatus3 = info.offlineStatus;
                    if (!(offlineStatus3 != null && offlineStatus3.code == 7)) {
                        this.mProgressBar.setIndeterminate(false);
                        OfflineProgress offlineProgress = this.mProgressBar;
                        OfflineStatus offlineStatus4 = info.offlineStatus;
                        if (offlineStatus4 == null || offlineStatus4.code != 3) {
                            z = false;
                        }
                        offlineProgress.updateStatus(z);
                        this.mProgressBar.setProgress(OfflineUtil.INSTANCE.caclProgress(info));
                        return;
                    }
                }
            }
            this.mProgressBar.setIndeterminate(true);
        }
    }

    /* compiled from: DownloadingAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/offline/DownloadingAdapter$DownloadingVideoHolder;", "Ltv/danmaku/bili/ui/offline/DownloadingAdapter$BaseDownloadingHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mLabel", "Landroid/widget/TextView;", "getMLabel", "()Landroid/widget/TextView;", "setMLabel", "(Landroid/widget/TextView;)V", "mSubtitle", "getMSubtitle", "setMSubtitle", "mPlayInAdvance", "Landroid/widget/ImageView;", "getMPlayInAdvance", "()Landroid/widget/ImageView;", "setMPlayInAdvance", "(Landroid/widget/ImageView;)V", "updateProgressInfo", "", "info", "Lcom/bilibili/offline/OfflineInfo;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DownloadingVideoHolder extends BaseDownloadingHolder {
        private TextView mLabel;
        private ImageView mPlayInAdvance;
        private TextView mSubtitle;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadingVideoHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(tv.danmaku.bili.R.id.label);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.mLabel = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(tv.danmaku.bili.R.id.subtitle);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.mSubtitle = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(tv.danmaku.bili.R.id.play_in_advance);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.mPlayInAdvance = (ImageView) findViewById3;
        }

        public final TextView getMLabel() {
            return this.mLabel;
        }

        public final void setMLabel(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mLabel = textView;
        }

        public final TextView getMSubtitle() {
            return this.mSubtitle;
        }

        public final void setMSubtitle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mSubtitle = textView;
        }

        public final ImageView getMPlayInAdvance() {
            return this.mPlayInAdvance;
        }

        public final void setMPlayInAdvance(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mPlayInAdvance = imageView;
        }

        @Override // tv.danmaku.bili.ui.offline.DownloadingAdapter.BaseDownloadingHolder
        public void updateProgressInfo(OfflineInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            super.updateProgressInfo(info);
            if (info.canPlayInAdvance) {
                this.mPlayInAdvance.setVisibility(0);
            } else {
                this.mPlayInAdvance.setVisibility(8);
            }
        }

        /* compiled from: DownloadingAdapter.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/offline/DownloadingAdapter$DownloadingVideoHolder$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/ui/offline/DownloadingAdapter$DownloadingVideoHolder;", "parent", "Landroid/view/ViewGroup;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final DownloadingVideoHolder create(ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                View itemView = LayoutInflater.from(parent.getContext()).inflate(tv.danmaku.bili.R.layout.bili_app_list_item_offline_downloading_video, parent, false);
                Intrinsics.checkNotNull(itemView);
                return new DownloadingVideoHolder(itemView);
            }
        }
    }

    /* compiled from: DownloadingAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/offline/DownloadingAdapter$DownloadingAudioHolder;", "Ltv/danmaku/bili/ui/offline/DownloadingAdapter$BaseDownloadingHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DownloadingAudioHolder extends BaseDownloadingHolder {
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        /* compiled from: DownloadingAdapter.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/offline/DownloadingAdapter$DownloadingAudioHolder$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/ui/offline/DownloadingAdapter$DownloadingAudioHolder;", "parent", "Landroid/view/ViewGroup;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final DownloadingAudioHolder create(ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                View itemView = LayoutInflater.from(parent.getContext()).inflate(tv.danmaku.bili.R.layout.bili_app_list_item_offline_downloading_audio, parent, false);
                Intrinsics.checkNotNull(itemView);
                return new DownloadingAudioHolder(itemView);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadingAudioHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }
}