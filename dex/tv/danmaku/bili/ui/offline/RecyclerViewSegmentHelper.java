package tv.danmaku.bili.ui.offline;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashSet;
import tv.danmaku.android.log.BLog;

public class RecyclerViewSegmentHelper {
    private static final String TAG = "RecyclerViewSegmentHelper";
    private int length;
    private LinearLayoutManager linearLayoutManager;
    private onNewPageVisibleListener onNewPageVisibleListener;
    private int pageSize;
    private HashSet<Integer> workedSegmentIndex = new HashSet<>();

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface onNewPageVisibleListener {
        void onNewPageVisible(int i, int i2);
    }

    public RecyclerViewSegmentHelper(RecyclerView recyclerView, final int pageSize, onNewPageVisibleListener onNewPageVisibleListener2) {
        this.pageSize = pageSize;
        this.onNewPageVisibleListener = onNewPageVisibleListener2;
        this.linearLayoutManager = recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: tv.danmaku.bili.ui.offline.RecyclerViewSegmentHelper.1
            public void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                if (newState == 0) {
                    double firstVisibleItem = RecyclerViewSegmentHelper.this.linearLayoutManager.findFirstVisibleItemPosition();
                    double lastVisibleItem = RecyclerViewSegmentHelper.this.linearLayoutManager.findLastVisibleItemPosition();
                    BLog.v(RecyclerViewSegmentHelper.TAG, "onScrollStateChanged  firstVisibleItem:" + firstVisibleItem + " lastVisibleItem:" + lastVisibleItem);
                    int index1 = (int) Math.floor(firstVisibleItem / pageSize);
                    int index2 = (int) Math.floor(lastVisibleItem / pageSize);
                    RecyclerViewSegmentHelper.this.handleSegment(index1);
                    if (index1 != index2) {
                        RecyclerViewSegmentHelper.this.handleSegment(index2);
                    }
                }
            }
        });
    }

    public void start(int length) {
        this.length = length;
        this.workedSegmentIndex.clear();
        if (length != 0) {
            handleSegment(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSegment(int i) {
        if (i < 0) {
            BLog.w(TAG, "handleSegment " + i + "skip:i<0");
        } else if (this.workedSegmentIndex.contains(Integer.valueOf(i))) {
            BLog.i(TAG, "handleSegment " + i + " skip:already exist");
        } else {
            this.workedSegmentIndex.add(Integer.valueOf(i));
            if (this.onNewPageVisibleListener != null) {
                BLog.i(TAG, "handleSegment " + i + " start");
                int start = this.pageSize * i;
                int end = Math.min(this.pageSize + start, this.length);
                if (end <= start) {
                    BLog.w(TAG, "handleSegment error!:end <= start");
                } else {
                    this.onNewPageVisibleListener.onNewPageVisible(start, end);
                }
            }
        }
    }
}