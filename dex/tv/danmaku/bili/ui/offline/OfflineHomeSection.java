package tv.danmaku.bili.ui.offline;

import androidx.collection.ArrayMap;
import com.bilibili.offline.OfflineInfo;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import tv.danmaku.bili.widget.recycler.section.BaseSection;

public abstract class OfflineHomeSection extends BaseSection {
    public List<OfflineInfo> mInfoList;

    public OfflineHomeSection(List<OfflineInfo> content) {
        this.mInfoList = content;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Downloading extends OfflineHomeSection {
        public OfflineInfo mShowInfo;

        public Downloading(List<OfflineInfo> content) {
            super(content);
            updateShowInfo();
        }

        @Override // tv.danmaku.bili.widget.recycler.section.Section
        public int getItemViewType(int adapterPosition) {
            return 1;
        }

        @Override // tv.danmaku.bili.widget.recycler.section.Section
        public int size() {
            return 1;
        }

        @Override // tv.danmaku.bili.widget.recycler.section.Section
        public Object data(int adapterPosition) {
            return this.mShowInfo;
        }

        public void updateShowInfo() {
            if (this.mInfoList != null && !this.mInfoList.isEmpty()) {
                this.mShowInfo = this.mInfoList.get(0);
                this.mShowInfo.setPageCount(this.mInfoList.size());
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Downloaded extends OfflineHomeSection {
        Map<String, OfflineInfo> mCheckedInfos;

        public Downloaded(List<OfflineInfo> content) {
            super(content);
            this.mCheckedInfos = new ArrayMap(content.size());
        }

        @Override // tv.danmaku.bili.widget.recycler.section.Section
        public int getItemViewType(int adapterPosition) {
            if (convertAdapterPosition(adapterPosition) == 0) {
                return 3;
            }
            return 2;
        }

        @Override // tv.danmaku.bili.widget.recycler.section.Section
        public int size() {
            if (this.mInfoList == null || this.mInfoList.isEmpty()) {
                return 0;
            }
            return this.mInfoList.size() + 1;
        }

        @Override // tv.danmaku.bili.widget.recycler.section.Section
        public Object data(int adapterPosition) {
            int secPos = convertAdapterPosition(adapterPosition) - 1;
            if (secPos < 0 || secPos >= this.mInfoList.size()) {
                return null;
            }
            return this.mInfoList.get(secPos);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clearChecked() {
            this.mCheckedInfos.clear();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void checkAll(boolean check) {
            this.mCheckedInfos.clear();
            if (check) {
                for (OfflineInfo info : this.mInfoList) {
                    this.mCheckedInfos.put(OfflineUtil.createKey(info), info);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void deleteChecked() {
            this.mInfoList.removeAll(this.mCheckedInfos.values());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Collection<OfflineInfo> getCheckedInfo() {
            return this.mCheckedInfos.values();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int caclCheckedCount() {
            int count = 0;
            for (OfflineInfo info : this.mCheckedInfos.values()) {
                int childCount = info.getPageCount();
                count += childCount == 0 ? 1 : childCount;
            }
            return count;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isAllChecked() {
            return this.mCheckedInfos.size() == this.mInfoList.size();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void check(OfflineInfo info) {
            this.mCheckedInfos.put(getKey(info), info);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void unCheck(OfflineInfo info) {
            this.mCheckedInfos.remove(getKey(info));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isChecked(OfflineInfo info) {
            return this.mCheckedInfos.containsKey(getKey(info));
        }

        private String getKey(OfflineInfo info) {
            return OfflineUtil.createKey(info);
        }
    }
}