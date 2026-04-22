package tv.danmaku.bili.ui.offline;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.lib.router.Router;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineType;
import com.bilibili.playerbizcommonv2.utils.NumberExtensionKt;
import com.bilibili.ugc.offline.drama.DramaVideo;
import com.bilibili.videodownloader.model.OfflinePermissionCode;
import com.bilibili.videodownloader.model.PermissionCheckKt;
import com.bilibili.videodownloader.model.av.Page;
import com.bilibili.videodownloader.model.season.Episode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.offline.ItemActionCallback;
import tv.danmaku.bili.ui.offline.OfflineSearchAdapter;
import tv.danmaku.bili.videopage.common.helper.BangumiRoutes;
import tv.danmaku.bili.videopage.common.helper.IntentHelper;

/* JADX INFO: Access modifiers changed from: package-private */
public class OfflineSearchAdapter extends RecyclerView.Adapter<SearchHolder> {
    private static final int VIEW_TYPE_AUDIO = 1;
    private static final int VIEW_TYPE_VIDEO = 0;
    private Map<String, OfflineInfo> mCheckedInfos;
    private boolean mEditMode;
    private ItemActionCallback.Downloaded mItemActionCallback;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.OfflineSearchAdapter$$ExternalSyntheticLambda0
        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            OfflineSearchAdapter.this.m1365lambda$new$1$tvdanmakubiliuiofflineOfflineSearchAdapter(view2);
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: tv.danmaku.bili.ui.offline.OfflineSearchAdapter.1
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            if (!OfflineSearchAdapter.this.mEditMode) {
                SearchHolder holder = (SearchHolder) v.getTag();
                OfflineSearchAdapter.this.mCheckedInfos.put(OfflineSearchAdapter.this.getKey(holder.mInfo), holder.mInfo);
                OfflineSearchAdapter.this.mItemActionCallback.enterEditMode();
                return false;
            }
            return false;
        }
    };
    private CompoundButton.OnCheckedChangeListener mCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.ui.offline.OfflineSearchAdapter.2
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            OfflineInfo info = (OfflineInfo) buttonView.getTag();
            String key = OfflineSearchAdapter.this.getKey(info);
            if (isChecked) {
                OfflineSearchAdapter.this.mCheckedInfos.put(key, info);
            } else {
                OfflineSearchAdapter.this.mCheckedInfos.remove(key);
            }
            OfflineSearchAdapter.this.mItemActionCallback.onCheckedItemCountChange(OfflineSearchAdapter.this.caclCheckedCount(), OfflineSearchAdapter.this.isAllChecked());
        }
    };
    private List<OfflineInfo> mOfflineInfos = new ArrayList();

    public OfflineSearchAdapter(List<OfflineInfo> offlineInfos, ItemActionCallback.Downloaded listener) {
        if (offlineInfos != null) {
            this.mOfflineInfos.addAll(offlineInfos);
        }
        this.mItemActionCallback = listener;
        this.mCheckedInfos = new ArrayMap(this.mOfflineInfos.size());
    }

    public SearchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return VideoHolder.create(parent);
        }
        return AudioHolder.create(parent);
    }

    public void onBindViewHolder(SearchHolder holder, int position) {
        OfflineInfo info = this.mOfflineInfos.get(position);
        holder.mInfo = info;
        holder.itemView.setTag(holder);
        holder.itemView.setOnClickListener(this.mOnClickListener);
        holder.itemView.setOnLongClickListener(this.mOnLongClickListener);
        if (this.mEditMode) {
            holder.mCheckBox.setVisibility(0);
            holder.mCheckBox.setTag(info);
            holder.mCheckBox.setOnCheckedChangeListener(null);
            holder.mCheckBox.setChecked(this.mCheckedInfos.containsKey(getKey(info)));
            holder.mCheckBox.setOnCheckedChangeListener(this.mCheckedChangeListener);
        } else {
            holder.mCheckBox.setVisibility(8);
            holder.mCheckBox.setOnCheckedChangeListener(null);
        }
        BiliImageLoader.INSTANCE.with(holder.mCover.getContext()).url(info.cover).into(holder.mCover);
        holder.mTitle.setText(info.title);
        if (holder instanceof VideoHolder) {
            VideoHolder videoHolder = (VideoHolder) holder;
            String subTitle = OfflineUtil.getPageTitle(info);
            if (subTitle.equalsIgnoreCase(info.title)) {
                videoHolder.mSubtitle.setText("");
            } else {
                videoHolder.mSubtitle.setText(subTitle);
            }
            int childCount = info.getPageCount();
            if (childCount == 1) {
                videoHolder.mPageCount.setVisibility(8);
                videoHolder.mSubtitle.setVisibility(0);
            } else {
                videoHolder.mPageCount.setVisibility(0);
                videoHolder.mPageCount.setText(holder.itemView.getResources().getString(R.string.video_download_page_count, String.valueOf(childCount)));
                videoHolder.mSubtitle.setVisibility(4);
            }
            if (TextUtils.isEmpty(info.offlineType.typeName)) {
                videoHolder.mLabel.setVisibility(8);
            } else {
                videoHolder.mLabel.setVisibility(0);
                videoHolder.mLabel.setText(info.offlineType.typeName);
            }
            if (childCount == 1) {
                if (info.playedTime == -2) {
                    videoHolder.mWatchProgress.setText("");
                } else if (info.playedTime == 0) {
                    videoHolder.mWatchProgress.setText(OfflineUtil.buildColorString(holder.itemView.getContext(), holder.itemView.getContext().getString(bili.resource.others.R.string.others_global_string_316)));
                } else if (info.playedTime == info.duration || info.playedTime == -1) {
                    videoHolder.mWatchProgress.setText(holder.itemView.getContext().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_2043));
                } else {
                    videoHolder.mWatchProgress.setText(OfflineUtil.playedTime(holder.itemView.getContext(), info));
                }
                if (PermissionCheckKt.isAccessToPlay(info) != OfflinePermissionCode.Pass) {
                    videoHolder.mDanmakuSize.setVisibility(4);
                    videoHolder.mVipHint.setVisibility(0);
                    return;
                }
                videoHolder.mDanmakuSize.setVisibility(0);
                videoHolder.mVipHint.setVisibility(8);
                videoHolder.mDanmakuSize.setText(holder.itemView.getResources().getQuantityString(bili.resource.homepage.R.plurals.homepage_global_string_444, info.danmaku, String.valueOf(info.danmaku), NumberExtensionKt.toFileSize(info.totalBytes)));
                return;
            }
            videoHolder.mDanmakuSize.setVisibility(0);
            videoHolder.mVipHint.setVisibility(8);
            if (info.playedChildCount == -1) {
                videoHolder.mWatchProgress.setText("");
            } else if (info.playedChildCount == 0) {
                videoHolder.mWatchProgress.setText(OfflineUtil.buildColorString(holder.itemView.getContext(), holder.itemView.getContext().getString(bili.resource.others.R.string.others_global_string_316)));
            } else {
                videoHolder.mWatchProgress.setText(holder.itemView.getContext().getResources().getQuantityString(bili.resource.homepage.R.plurals.homepage_global_string_445, info.playedChildCount, Integer.valueOf(info.playedChildCount)));
            }
        } else if (holder instanceof AudioHolder) {
            AudioHolder audioHolder = (AudioHolder) holder;
            audioHolder.author.setText(info.typeInfo.toString());
            audioHolder.size.setText(NumberExtensionKt.toFileSize(info.totalBytes));
        }
    }

    private boolean isUgcCardOfflineVCEnable(Object typeInfo, int type) {
        return type == OfflineType.TYPE_VIDEO || type == OfflineType.TYPE_DRAMA || (type == OfflineType.TYPE_PAGE && ((typeInfo instanceof Page) || (typeInfo instanceof DramaVideo)));
    }

    public int getItemCount() {
        return this.mOfflineInfos.size();
    }

    public int getItemViewType(int position) {
        OfflineInfo info = this.mOfflineInfos.get(position);
        if (info.offlineType.type == OfflineType.TYPE_AUDIO) {
            return 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$tv-danmaku-bili-ui-offline-OfflineSearchAdapter  reason: not valid java name */
    public /* synthetic */ void m1365lambda$new$1$tvdanmakubiliuiofflineOfflineSearchAdapter(View v) {
        Episode episode;
        int id = v.getId();
        if (id == R.id.detail) {
            OfflineInfo info = (OfflineInfo) v.getTag();
            if (info.offlineType.type == OfflineType.TYPE_VIDEO) {
                long avid = info.id;
                Uri.Builder builder = new Uri.Builder().scheme("bilibili").authority("video").appendPath(String.valueOf(avid)).appendQueryParameter("jumpFrom", String.valueOf(105));
                if (info.getPageCount() == 1) {
                    int index = ((Page) info.typeInfo).page - 1;
                    builder.appendQueryParameter("page", String.valueOf(index));
                }
                Router.global().with(v.getContext()).open(builder.build());
                return;
            } else if (info.offlineType.type == OfflineType.TYPE_DRAMA) {
                if (info.getPageCount() == 1) {
                    long avid2 = ((DramaVideo) info.typeInfo).avid;
                    Router.global().with(v.getContext()).with("avid", String.valueOf(avid2)).with("jumpFrom", String.valueOf(105)).open(IntentHelper.ROUTE_URI_BILI_VIDEO_DETAIL);
                    return;
                }
                return;
            } else if (info.offlineType.type != OfflineType.TYPE_BANGUMI || (episode = (Episode) info.typeInfo) == null) {
                return;
            } else {
                String epId = null;
                if (info.getPageCount() == 1) {
                    epId = String.valueOf(episode.id);
                }
                BangumiRoutes.goToDetail(v.getContext(), String.valueOf(info.id), epId, 13, BangumiRoutes.SPMID_MAIN_CACHE, episode.link);
                return;
            }
        }
        final SearchHolder holder = (SearchHolder) v.getTag();
        if (this.mEditMode) {
            holder.mCheckBox.toggle();
            return;
        }
        Context context = v.getContext();
        if (holder.mInfo.getPageCount() == 1) {
            this.mItemActionCallback.play(context, holder.mInfo);
            return;
        }
        final long scene = holder.mInfo.typeInfo instanceof DramaVideo ? 1L : 0L;
        RouteRequest request = new RouteRequest.Builder("bilibili://offline/downloaded-page").extras(new Function1() { // from class: tv.danmaku.bili.ui.offline.OfflineSearchAdapter$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return OfflineSearchAdapter.lambda$new$0(OfflineSearchAdapter.SearchHolder.this, scene, (MutableBundleLike) obj);
            }
        }).build();
        BLRouter.routeTo(request, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$new$0(SearchHolder holder, long scene, MutableBundleLike mutableBundleLike) {
        mutableBundleLike.put(DownloadedPageActivity.KEY_VIDEO_ID, String.valueOf(holder.mInfo.id));
        mutableBundleLike.put(DownloadedPageActivity.KEY_VIDEO_TITLE, String.valueOf(holder.mInfo.title));
        mutableBundleLike.put(DownloadedPageActivity.KEY_PAGE_SCENE, String.valueOf(scene));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getKey(OfflineInfo info) {
        return OfflineUtil.createKey(info);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEditMode(boolean editMode) {
        this.mEditMode = editMode;
        if (this.mEditMode) {
            this.mItemActionCallback.onCheckedItemCountChange(caclCheckedCount(), isAllChecked());
        } else {
            this.mCheckedInfos.clear();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int caclCheckedCount() {
        int count = 0;
        for (OfflineInfo info : this.mCheckedInfos.values()) {
            count += info.getPageCount();
        }
        return count;
    }

    boolean isAllChecked() {
        return this.mCheckedInfos.size() == this.mOfflineInfos.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkAll(boolean check) {
        this.mCheckedInfos.clear();
        if (check) {
            for (OfflineInfo info : this.mOfflineInfos) {
                this.mCheckedInfos.put(getKey(info), info);
            }
        }
        this.mItemActionCallback.onCheckedItemCountChange(caclCheckedCount(), isAllChecked());
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeChecked(boolean notifyChange) {
        this.mOfflineInfos.removeAll(this.mCheckedInfos.values());
        if (notifyChange) {
            notifyDataSetChanged();
        }
        this.mItemActionCallback.onItemCountChange(this.mOfflineInfos.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<OfflineInfo> getCheckedInfo() {
        return this.mCheckedInfos.values();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<OfflineInfo> getInfo() {
        return this.mOfflineInfos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class SearchHolder extends RecyclerView.ViewHolder {
        CheckBox mCheckBox;
        StaticImageView2 mCover;
        OfflineInfo mInfo;
        TextView mTitle;

        public SearchHolder(View itemView) {
            super(itemView);
            this.mCover = itemView.findViewById(R.id.cover);
            this.mTitle = (TextView) itemView.findViewById(R.id.title);
            this.mCheckBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class VideoHolder extends SearchHolder {
        TextView mDanmakuSize;
        TextView mLabel;
        TextView mPageCount;
        TextView mSubtitle;
        TextView mVipHint;
        TextView mWatchProgress;

        public VideoHolder(View itemView) {
            super(itemView);
            this.mSubtitle = (TextView) itemView.findViewById(R.id.subtitle);
            this.mPageCount = (TextView) itemView.findViewById(R.id.count);
            this.mLabel = (TextView) itemView.findViewById(R.id.label);
            this.mDanmakuSize = (TextView) itemView.findViewById(R.id.danmaku_size);
            this.mVipHint = (TextView) itemView.findViewById(R.id.vip_hint);
            this.mWatchProgress = (TextView) itemView.findViewById(R.id.watch_progress);
        }

        public static VideoHolder create(ViewGroup parent) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_list_item_offline_search_video, parent, false);
            return new VideoHolder(itemView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class AudioHolder extends SearchHolder {
        public TextView author;
        public TextView size;

        public AudioHolder(View itemView) {
            super(itemView);
            this.author = (TextView) itemView.findViewById(R.id.author);
            this.size = (TextView) itemView.findViewById(R.id.size);
        }

        public static AudioHolder create(ViewGroup parent) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_list_item_offline_search_audio, parent, false);
            return new AudioHolder(itemView);
        }
    }
}