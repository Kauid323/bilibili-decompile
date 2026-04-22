package tv.danmaku.bili.ui.videodownload.diagnosis;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bili.resource.settings.R;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import tv.danmaku.bili.ui.videodownload.widgets.TagSpan;
import tv.danmaku.bili.widget.LoadingImageView;
import tv.danmaku.bili.widget.recycler.DividerDecoration;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class VideoDownloadTestActivity extends BaseToolbarActivity {
    private Adapter mAdapter;
    private LoadingImageView mLoadingView;
    private RecyclerView mRecyclerView;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        showBackButton();
        getSupportActionBar().setTitle(R.string.settings_global_string_163);
        this.mLoadingView.setRefreshing();
        this.mAdapter = new Adapter(this);
        this.mRecyclerView.setAdapter(this.mAdapter);
        loadEntries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initView() {
        setContentView(com.bilibili.lib.basecomponent.R.layout.bili_app_activity_with_toolbar);
        setSupportActionBar(this.mToolbar);
        FrameLayout content = (FrameLayout) findViewById(tv.danmaku.bili.R.id.content_layout);
        LayoutInflater.from(this).inflate(com.bilibili.lib.ui.R.layout.bili_app_layout_recyclerview, content);
        this.mRecyclerView = content.findViewById(tv.danmaku.bili.R.id.recycler);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.addItemDecoration(new DividerDecoration(com.bilibili.lib.theme.R.color.Ga2));
        this.mLoadingView = LoadingImageView.attachTo(content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addData(List<ScanEntry> list) {
        if (list != null && list.size() > 0) {
            this.mAdapter.addData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataCompleted() {
        this.mLoadingView.setRefreshComplete();
        if (this.mAdapter.getItemCount() > 0) {
            this.mAdapter.notifyDataSetChanged();
        } else {
            this.mLoadingView.showEmptyTips();
        }
    }

    public void showResolveTestFragment(ScanEntry entry) {
        getSupportFragmentManager().beginTransaction().add(tv.danmaku.bili.R.id.content_layout, VideoDownloadResolveTestFragment.create(entry), VideoDownloadResolveTestFragment.TAG).addToBackStack("resolve").commit();
    }

    public void loadEntries() {
        Task.callInBackground(new Callable<ArrayList<ScanEntry>>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.VideoDownloadTestActivity.2
            @Override // java.util.concurrent.Callable
            public ArrayList<ScanEntry> call() throws Exception {
                return VideoEntryScanner.scan(VideoDownloadTestActivity.this.getApplicationContext());
            }
        }).continueWith(new Continuation<ArrayList<ScanEntry>, Void>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.VideoDownloadTestActivity.1
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1746then((Task<ArrayList<ScanEntry>>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1746then(Task<ArrayList<ScanEntry>> task) throws Exception {
                VideoDownloadTestActivity.this.addData((List) task.getResult());
                VideoDownloadTestActivity.this.notifyDataCompleted();
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Adapter extends RecyclerView.Adapter<DownloadItem> {
        private ArrayList<ScanEntry> mData = new ArrayList<>();
        private View.OnClickListener mItemClickListener = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.VideoDownloadTestActivity.Adapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Object o = v.getTag();
                if (Adapter.this.mWef.get() != null && (o instanceof ScanEntry)) {
                    ((VideoDownloadTestActivity) Adapter.this.mWef.get()).showResolveTestFragment((ScanEntry) o);
                }
            }
        };
        private WeakReference<VideoDownloadTestActivity> mWef;

        public Adapter(VideoDownloadTestActivity activity) {
            this.mWef = new WeakReference<>(activity);
        }

        public DownloadItem onCreateViewHolder(ViewGroup parent, int viewType) {
            DownloadItem item = DownloadItem.create(parent);
            item.itemView.setOnClickListener(this.mItemClickListener);
            return item;
        }

        public void onBindViewHolder(DownloadItem holder, int position) {
            int resId;
            ScanEntry scanEntry = this.mData.get(position);
            Context context = holder.itemView.getContext();
            if (scanEntry.isValid()) {
                if (scanEntry.isCompleted()) {
                    resId = bili.resource.common.R.string.common_global_string_254;
                } else {
                    resId = bili.resource.playerbaseres.R.string.playerbaseres_global_string_2188;
                }
            } else {
                resId = bili.resource.playerbaseres.R.string.playerbaseres_global_string_2245;
            }
            SpannableStringBuilder builder = new SpannableStringBuilder();
            builder.append((CharSequence) context.getString(resId));
            TagSpan span = new TagSpan(context);
            builder.setSpan(span, 0, builder.length(), 33);
            builder.append((CharSequence) scanEntry.getTitle(context));
            holder.mTitle.setText(builder);
            holder.itemView.setTag(scanEntry);
        }

        public int getItemCount() {
            return this.mData.size();
        }

        void addData(List<ScanEntry> data) {
            this.mData.addAll(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class DownloadItem extends RecyclerView.ViewHolder {
        TextView mTitle;

        DownloadItem(View itemView) {
            super(itemView);
            this.mTitle = (TextView) itemView.findViewById(tv.danmaku.bili.R.id.title1);
        }

        public static DownloadItem create(ViewGroup parent) {
            int padding = parent.getResources().getDimensionPixelOffset(com.bilibili.app.comm.baseres.R.dimen.item_spacing);
            TextView title = new TextView(parent.getContext());
            title.setId(tv.danmaku.bili.R.id.title1);
            title.setGravity(16);
            title.setPadding(padding, padding, padding, padding);
            title.setTextColor(parent.getResources().getColor(com.bilibili.lib.theme.R.color.Ga9));
            title.setTextSize(15.0f);
            title.setMaxLines(2);
            title.setLineSpacing(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.2f);
            title.setBackgroundResource(com.bilibili.lib.basecomponent.R.drawable.item_background);
            title.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return new DownloadItem(title);
        }
    }
}