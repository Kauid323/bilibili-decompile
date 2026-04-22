package tv.danmaku.bili.ui.offline;

import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.ugc.offline.drama.DramaVideo;
import com.bilibili.videodownloader.model.av.Page;
import com.bilibili.videodownloader.model.season.Episode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import tv.danmaku.bili.ui.offline.ItemActionCallback;
import tv.danmaku.bili.ui.offline.OfflineHomeHolder;

public class DownloadedPageAdapter extends RecyclerView.Adapter<OfflineHomeHolder.DownloadedVideoHolder> implements OfflineAdapter {
    private Map<String, OfflineInfo> mCheckedInfos;
    private boolean mEditMode;
    private ItemActionCallback.Downloaded mItemActionCallback;
    private List<OfflineInfo> mPageList = new ArrayList();

    public DownloadedPageAdapter(List<OfflineInfo> pageList, ItemActionCallback.Downloaded listener) {
        if (pageList != null) {
            this.mPageList.addAll(pageList);
        }
        this.mItemActionCallback = listener;
        this.mCheckedInfos = new ArrayMap(this.mPageList.size());
    }

    public OfflineHomeHolder.DownloadedVideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return OfflineHomeHolder.DownloadedVideoHolder.create(parent, this, OfflineHomeHolder.DownloadedVideoHolder.HolderScene.DOWNLOAD_PAGE);
    }

    public void onBindViewHolder(OfflineHomeHolder.DownloadedVideoHolder holder, int position) {
        OfflineInfo info = this.mPageList.get(position);
        if (info != null) {
            holder.bind(info);
            holder.getMTitle().setText(OfflineUtil.getPageTitle(info));
        }
    }

    public int getItemCount() {
        return this.mPageList.size();
    }

    private String getKey(OfflineInfo info) {
        return OfflineUtil.createKey(info);
    }

    public void setEditMode(boolean editMode) {
        this.mEditMode = editMode;
        if (this.mEditMode) {
            this.mItemActionCallback.onCheckedItemCountChange(caclCheckedCount(), isAllChecked());
        } else {
            this.mCheckedInfos.clear();
        }
        notifyDataSetChanged();
    }

    public Collection<OfflineInfo> getCheckedInfo() {
        return this.mCheckedInfos.values();
    }

    public void checkAll(boolean check) {
        this.mCheckedInfos.clear();
        if (check) {
            for (OfflineInfo info : this.mPageList) {
                this.mCheckedInfos.put(getKey(info), info);
            }
        }
        this.mItemActionCallback.onCheckedItemCountChange(caclCheckedCount(), isAllChecked());
        notifyDataSetChanged();
    }

    public void removeChecked(boolean notifyChange) {
        this.mPageList.removeAll(this.mCheckedInfos.values());
        if (notifyChange) {
            notifyDataSetChanged();
        }
        this.mItemActionCallback.onItemCountChange(this.mPageList.size());
    }

    private int caclCheckedCount() {
        return this.mCheckedInfos.size();
    }

    private boolean isAllChecked() {
        return this.mCheckedInfos.size() == this.mPageList.size();
    }

    public void addData(OfflineInfo downloaded) {
        int pos = getInsertPos(downloaded);
        if (pos != -1) {
            this.mPageList.add(pos, downloaded);
            notifyItemInserted(pos);
        }
    }

    private int getInsertPos(OfflineInfo downloaded) {
        int size = this.mPageList.size();
        for (int i = 0; i < size; i++) {
            OfflineInfo info = this.mPageList.get(i);
            if (isEquals(downloaded, info)) {
                return -1;
            }
            if (info.sortIndex >= downloaded.sortIndex) {
                return i;
            }
        }
        return size;
    }

    private boolean isEquals(OfflineInfo downloaded, OfflineInfo old) {
        if ((downloaded.typeInfo instanceof DramaVideo) && (old.typeInfo instanceof DramaVideo) && ((DramaVideo) downloaded.typeInfo).avid == ((DramaVideo) old.typeInfo).avid) {
            return true;
        }
        if ((downloaded.typeInfo instanceof Page) && (old.typeInfo instanceof Page) && ((Page) downloaded.typeInfo).cid == ((Page) old.typeInfo).cid) {
            return true;
        }
        return (downloaded.typeInfo instanceof Episode) && (old.typeInfo instanceof Episode) && ((Episode) downloaded.typeInfo).id == ((Episode) old.typeInfo).id;
    }

    public void clear() {
        this.mPageList.clear();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<OfflineInfo> getInfo() {
        return this.mPageList;
    }

    @Override // tv.danmaku.bili.ui.offline.OfflineAdapter
    public boolean isEditMode() {
        return this.mEditMode;
    }

    @Override // tv.danmaku.bili.ui.offline.OfflineAdapter
    public boolean isChecked(OfflineInfo info) {
        if (info == null) {
            return false;
        }
        return this.mCheckedInfos.containsKey(getKey(info));
    }

    @Override // tv.danmaku.bili.ui.offline.OfflineAdapter
    public ItemActionCallback.PlayAction getPlayAction() {
        return this.mItemActionCallback;
    }

    @Override // tv.danmaku.bili.ui.offline.OfflineAdapter
    public void enterEditMode() {
        setEditMode(true);
        if (this.mItemActionCallback != null) {
            this.mItemActionCallback.enterEditMode();
        }
    }

    @Override // tv.danmaku.bili.ui.offline.OfflineAdapter
    public void check(OfflineInfo info) {
        this.mCheckedInfos.put(getKey(info), info);
        this.mItemActionCallback.onCheckedItemCountChange(caclCheckedCount(), isAllChecked());
    }

    @Override // tv.danmaku.bili.ui.offline.OfflineAdapter
    public void unCheck(OfflineInfo info) {
        this.mCheckedInfos.remove(getKey(info));
        this.mItemActionCallback.onCheckedItemCountChange(caclCheckedCount(), isAllChecked());
    }
}