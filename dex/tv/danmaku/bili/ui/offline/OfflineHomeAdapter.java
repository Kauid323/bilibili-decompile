package tv.danmaku.bili.ui.offline;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineStatus;
import com.bilibili.offline.OfflineType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.offline.ItemActionCallback;
import tv.danmaku.bili.ui.offline.OfflineHomeHolder;
import tv.danmaku.bili.ui.offline.OfflineHomeSection;
import tv.danmaku.bili.widget.recycler.section.BaseSectionAdapter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineHomeAdapter.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 C2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u0001CB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\fJ\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0007J\u0016\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J \u0010(\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u001aH\u0002J\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020'J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020'H\u0002J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020'H\u0002J\b\u0010/\u001a\u00020\u0015H\u0016J\u000e\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0015J\u0010\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u0015H\u0007J\u0006\u00104\u001a\u00020\u001cJ\u0012\u00103\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010<\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010=\u001a\u00020\u00152\b\u0010)\u001a\u0004\u0018\u00010'H\u0016J\n\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020\u001cH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00105\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020'098F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0011\u0010>\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b?\u00107¨\u0006D"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineHomeAdapter;", "Ltv/danmaku/bili/widget/recycler/section/BaseSectionAdapter;", "Ltv/danmaku/bili/widget/recycler/section/BaseSectionAdapter$ViewHolder;", "Ltv/danmaku/bili/ui/offline/OfflineAdapter;", "mItemCallback", "Ltv/danmaku/bili/ui/offline/ItemActionCallback$Downloaded;", "<init>", "(Ltv/danmaku/bili/ui/offline/ItemActionCallback$Downloaded;)V", "getMItemCallback", "()Ltv/danmaku/bili/ui/offline/ItemActionCallback$Downloaded;", "setMItemCallback", "value", "Ltv/danmaku/bili/ui/offline/OfflineHomeSection;", "downloadingSection", "getDownloadingSection", "()Ltv/danmaku/bili/ui/offline/OfflineHomeSection;", "Ltv/danmaku/bili/ui/offline/OfflineHomeSection$Downloaded;", "downloadedSection", "getDownloadedSection", "()Ltv/danmaku/bili/ui/offline/OfflineHomeSection$Downloaded;", "mIsEditMode", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "addOfflineSection", "section", "expectPos", "clearData", "onItemDownloading", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "update", "Lcom/bilibili/offline/OfflineInfo;", "updateProgressInfo", "info", "adapterPosition", "onItemDownloaded", "offlineInfo", "updateDownloadingSection", "updateVideoSection", "isEditMode", "setEditMode", "editMode", "checkAll", "check", "deleteChecked", "sectionSize", "getSectionSize", "()I", "checkedInfo", "", "getCheckedInfo", "()Ljava/util/Collection;", "unCheck", "isChecked", "downloadedCount", "getDownloadedCount", "getPlayAction", "Ltv/danmaku/bili/ui/offline/ItemActionCallback$PlayAction;", "enterEditMode", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineHomeAdapter extends BaseSectionAdapter<BaseSectionAdapter.ViewHolder> implements OfflineAdapter {
    public static final int VIEW_TYPE_DOWNLOADED_VIDEO = 2;
    public static final int VIEW_TYPE_DOWNLOADED_VIDEO_HEADER = 3;
    public static final int VIEW_TYPE_DOWNLOADING = 1;
    private OfflineHomeSection.Downloaded downloadedSection;
    private OfflineHomeSection downloadingSection;
    private boolean mIsEditMode;
    private ItemActionCallback.Downloaded mItemCallback;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public OfflineHomeAdapter(ItemActionCallback.Downloaded mItemCallback) {
        Intrinsics.checkNotNullParameter(mItemCallback, "mItemCallback");
        this.mItemCallback = mItemCallback;
    }

    public final ItemActionCallback.Downloaded getMItemCallback() {
        return this.mItemCallback;
    }

    public final void setMItemCallback(ItemActionCallback.Downloaded downloaded) {
        Intrinsics.checkNotNullParameter(downloaded, "<set-?>");
        this.mItemCallback = downloaded;
    }

    public final OfflineHomeSection getDownloadingSection() {
        return this.downloadingSection;
    }

    public final OfflineHomeSection.Downloaded getDownloadedSection() {
        return this.downloadedSection;
    }

    public BaseSectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 1:
                return OfflineHomeHolder.OfflineDownloadingHolder.Companion.create(parent, this);
            case 2:
                return OfflineHomeHolder.DownloadedVideoHolder.Companion.create(parent, this, OfflineHomeHolder.DownloadedVideoHolder.HolderScene.DOWNLOAD_LIST);
            case 3:
                return OfflineHomeHolder.DownloadedTitleHolder.Companion.create(parent);
            default:
                throw new IllegalStateException("Unknown view type");
        }
    }

    @Override // tv.danmaku.bili.widget.recycler.section.BaseSectionAdapter
    public void onBindViewHolder(BaseSectionAdapter.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(getSection(position).data(position));
    }

    public final void addOfflineSection(OfflineHomeSection section) {
        Intrinsics.checkNotNullParameter(section, "section");
        if (section instanceof OfflineHomeSection.Downloading) {
            if (section.mInfoList == null || section.mInfoList.isEmpty()) {
                if (this.downloadingSection != null) {
                    removeSectionInternal(this.downloadingSection);
                }
            } else {
                this.downloadingSection = section;
                addOfflineSection(0, section);
            }
        } else if (section instanceof OfflineHomeSection.Downloaded) {
            if (section.mInfoList == null || section.mInfoList.isEmpty()) {
                if (this.downloadedSection != null) {
                    removeSectionInternal(this.downloadedSection);
                }
            } else {
                this.downloadedSection = (OfflineHomeSection.Downloaded) section;
                if (this.downloadingSection == null) {
                    addOfflineSection(0, section);
                } else {
                    addOfflineSection(1, section);
                }
            }
        }
        onSectionsChanged();
    }

    private final void addOfflineSection(int expectPos, OfflineHomeSection section) {
        if (expectPos < getSectionsSize()) {
            addSectionInternal(expectPos, section);
        } else {
            addSectionInternal(section);
        }
    }

    public final void clearData() {
        super.clear();
        this.downloadingSection = null;
        this.downloadedSection = null;
        this.mIsEditMode = false;
        notifyDataSetChanged();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r4 != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onItemDownloading(RecyclerView recyclerView, OfflineInfo update) {
        OfflineInfo info;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(update, "update");
        OfflineHomeSection section = this.downloadingSection;
        if (section == null || !(section instanceof OfflineHomeSection.Downloading) || (info = ((OfflineHomeSection.Downloading) section).mShowInfo) == null) {
            return;
        }
        int adapterPos = section.getStart();
        if (OfflineUtil.isEquals(update, info)) {
            OfflineUtil.updateData(update, info);
            updateProgressInfo(recyclerView, info, adapterPos);
            return;
        }
        OfflineStatus offlineStatus = info.offlineStatus;
        boolean z = true;
        if (!(offlineStatus != null && offlineStatus.code == 5)) {
            OfflineStatus offlineStatus2 = info.offlineStatus;
            if (offlineStatus2 == null || offlineStatus2.code != 3) {
                z = false;
            }
        }
        if (info.sortIndex <= update.sortIndex) {
            return;
        }
        update.setPageCount(section.mInfoList.size());
        ((OfflineHomeSection.Downloading) section).mShowInfo = update;
        notifyItemChanged(adapterPos);
    }

    private final void updateProgressInfo(RecyclerView recyclerView, OfflineInfo info, int adapterPosition) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        View view2 = layoutManager != null ? layoutManager.findViewByPosition(adapterPosition) : null;
        if (view2 != null) {
            RecyclerView.ViewHolder holder = recyclerView.findContainingViewHolder(view2);
            if (holder instanceof OfflineHomeHolder.OfflineDownloadingHolder) {
                ((OfflineHomeHolder.OfflineDownloadingHolder) holder).updateProgressInfo(info);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
        if (r1 != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onItemDownloaded(OfflineInfo offlineInfo) {
        Intrinsics.checkNotNullParameter(offlineInfo, "offlineInfo");
        updateDownloadingSection(offlineInfo);
        OfflineType offlineType = offlineInfo.offlineType;
        boolean z = true;
        if (!(offlineType != null && offlineType.type == OfflineType.TYPE_VIDEO)) {
            OfflineType offlineType2 = offlineInfo.offlineType;
            if (!(offlineType2 != null && offlineType2.type == OfflineType.TYPE_BANGUMI)) {
                OfflineType offlineType3 = offlineInfo.offlineType;
                if (offlineType3 == null || offlineType3.type != OfflineType.TYPE_DRAMA) {
                    z = false;
                }
            }
        }
        updateVideoSection(offlineInfo);
        this.mItemCallback.onItemCountChange(-1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
        if (r1.isEmpty() == true) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateDownloadingSection(OfflineInfo offlineInfo) {
        List<OfflineInfo> list;
        OfflineHomeSection section = this.downloadingSection;
        if (section != null && (section instanceof OfflineHomeSection.Downloading)) {
            Collection collection = section.mInfoList;
            if (collection != null) {
                Collection $this$toTypedArray$iv = collection;
                OfflineInfo[] offlineInfoArr = (OfflineInfo[]) $this$toTypedArray$iv.toArray(new OfflineInfo[0]);
                if (offlineInfoArr != null) {
                    for (OfflineInfo offlineInfo2 : offlineInfoArr) {
                        if (OfflineUtil.isEquals(offlineInfo, offlineInfo2) && (list = section.mInfoList) != null) {
                            list.remove(offlineInfo2);
                        }
                    }
                }
            }
            List<OfflineInfo> list2 = section.mInfoList;
            boolean z = list2 != null;
            if (z) {
                removeSection(0);
                this.downloadingSection = null;
                return;
            }
            ((OfflineHomeSection.Downloading) section).updateShowInfo();
        }
    }

    private final void updateVideoSection(OfflineInfo offlineInfo) {
        OfflineHomeSection.Downloaded section = this.downloadedSection;
        if (section == null) {
            if (offlineInfo.pages.isEmpty()) {
                offlineInfo.pages.add(offlineInfo);
            }
            List content = new ArrayList();
            content.add(offlineInfo);
            addOfflineSection(new OfflineHomeSection.Downloaded(content));
            return;
        }
        boolean hasGroup = false;
        Collection collection = section.mInfoList;
        if (collection != null) {
            Collection $this$toTypedArray$iv = collection;
            OfflineInfo[] offlineInfoArr = (OfflineInfo[]) $this$toTypedArray$iv.toArray(new OfflineInfo[0]);
            if (offlineInfoArr != null) {
                for (OfflineInfo offlineInfo2 : offlineInfoArr) {
                    if (offlineInfo2.id == offlineInfo.id) {
                        if (OfflineUtil.isEquals(offlineInfo2, offlineInfo)) {
                            return;
                        }
                        offlineInfo2.cover = offlineInfo.cover;
                        offlineInfo2.modifyTime = offlineInfo.modifyTime;
                        offlineInfo2.createTime = offlineInfo.createTime;
                        offlineInfo2.typeInfo = offlineInfo.typeInfo;
                        offlineInfo2.pages.add(offlineInfo);
                        hasGroup = true;
                    }
                }
            }
        }
        if (hasGroup) {
            List it = section.mInfoList;
            if (it != null) {
                Collections.sort(it, OfflineUtil.DECEND_BY_MODIFY_TIME);
            }
        } else {
            offlineInfo.pages = new ArrayList();
            offlineInfo.pages.add(offlineInfo);
            List<OfflineInfo> list = section.mInfoList;
            if (list != null) {
                list.add(0, offlineInfo);
            }
        }
        onSectionsChanged();
    }

    @Override // tv.danmaku.bili.ui.offline.OfflineAdapter
    public boolean isEditMode() {
        return this.mIsEditMode;
    }

    public final void setEditMode(boolean editMode) {
        this.mIsEditMode = editMode;
        OfflineHomeSection.Downloaded it = this.downloadedSection;
        if (it != null) {
            if (editMode) {
                this.mItemCallback.onCheckedItemCountChange(it.caclCheckedCount(), it.isAllChecked());
            } else {
                it.clearChecked();
            }
        }
        onSectionsChanged();
    }

    public final void checkAll(boolean check) {
        OfflineHomeSection.Downloaded it = this.downloadedSection;
        if (it != null) {
            it.checkAll(check);
            this.mItemCallback.onCheckedItemCountChange(it.caclCheckedCount(), it.isAllChecked());
            notifyDataSetChanged();
        }
    }

    public final void deleteChecked() {
        OfflineHomeSection.Downloaded it = this.downloadedSection;
        if (it != null) {
            it.deleteChecked();
            if (it.size() == 0) {
                removeSectionInternal(it);
                this.downloadedSection = null;
            }
        }
    }

    public final int getSectionSize() {
        return super.getSectionsSize();
    }

    public final Collection<OfflineInfo> getCheckedInfo() {
        Collection<OfflineInfo> checkedInfo;
        OfflineHomeSection.Downloaded downloaded = this.downloadedSection;
        return (downloaded == null || (checkedInfo = downloaded.getCheckedInfo()) == null) ? CollectionsKt.emptyList() : checkedInfo;
    }

    @Override // tv.danmaku.bili.ui.offline.OfflineAdapter
    public void check(OfflineInfo info) {
        OfflineHomeSection.Downloaded it = this.downloadedSection;
        if (it != null) {
            it.check(info);
            this.mItemCallback.onCheckedItemCountChange(it.caclCheckedCount(), it.isAllChecked());
        }
    }

    @Override // tv.danmaku.bili.ui.offline.OfflineAdapter
    public void unCheck(OfflineInfo info) {
        OfflineHomeSection.Downloaded it = this.downloadedSection;
        if (it != null) {
            it.unCheck(info);
            this.mItemCallback.onCheckedItemCountChange(it.caclCheckedCount(), it.isAllChecked());
        }
    }

    @Override // tv.danmaku.bili.ui.offline.OfflineAdapter
    public boolean isChecked(OfflineInfo info) {
        OfflineHomeSection.Downloaded downloaded = this.downloadedSection;
        return downloaded != null && downloaded.isChecked(info);
    }

    public final int getDownloadedCount() {
        List<OfflineInfo> list;
        OfflineHomeSection.Downloaded downloaded = this.downloadedSection;
        if (downloaded == null || (list = downloaded.mInfoList) == null) {
            return 0;
        }
        return list.size();
    }

    @Override // tv.danmaku.bili.ui.offline.OfflineAdapter
    public ItemActionCallback.PlayAction getPlayAction() {
        return this.mItemCallback;
    }

    @Override // tv.danmaku.bili.ui.offline.OfflineAdapter
    public void enterEditMode() {
        this.mItemCallback.enterEditMode();
    }

    /* compiled from: OfflineHomeAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineHomeAdapter$Companion;", "", "<init>", "()V", "VIEW_TYPE_DOWNLOADING", "", "VIEW_TYPE_DOWNLOADED_VIDEO", "VIEW_TYPE_DOWNLOADED_VIDEO_HEADER", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}