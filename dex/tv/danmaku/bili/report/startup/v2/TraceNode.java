package tv.danmaku.bili.report.startup.v2;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
public class TraceNode {
    private static final String TAG = "BootTracer-TraceNode";
    private String mTag;
    private long mStart = -1;
    private long mEnd = -1;
    private TraceNode mParent = null;
    private final FakeStack mSubNodes = new FakeStack();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface INodeFilter {
        boolean dropCurrent(TraceNode traceNode);
    }

    private TraceNode() {
    }

    public List<TraceNode> getSubNodes() {
        return this.mSubNodes.getElements();
    }

    public long getStart() {
        return this.mStart;
    }

    public long getEnd() {
        return this.mEnd;
    }

    public long getDuration() {
        if (this.mEnd > 0 && this.mStart > 0) {
            return this.mEnd - this.mStart;
        }
        return -1L;
    }

    public String getTag() {
        return this.mTag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beginInsert(TraceNode node) {
        TraceNode anchorNode = findAnchorNode();
        StartUpUtilsKt.startUpTrace("beginInsert anchorNode = " + anchorNode + "\ncurrent node = " + node);
        if (anchorNode != null) {
            node.mParent = anchorNode;
            anchorNode.mSubNodes.push(node);
            return;
        }
        StartUpUtilsKt.startUpTrace("begin insert anchor node of [" + this.mTag + "] not found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endUpdate(TraceNode node) {
        TraceNode anchorNode = findAnchorNode();
        StartUpUtilsKt.startUpTrace("endUpdate anchorNode = " + anchorNode + "\ncurrent node = " + node);
        if (anchorNode != null) {
            if (TextUtils.equals(anchorNode.getTag(), node.getTag())) {
                anchorNode.mEnd = node.mEnd;
                return;
            } else {
                StartUpUtilsKt.startUpTrace(" end error [" + anchorNode.getTag() + "] - [" + node.getTag() + "] not match ");
                return;
            }
        }
        StartUpUtilsKt.startUpTrace("end update anchor node of [" + this.mTag + "] not found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insertDirectly(TraceNode node) {
        TraceNode anchorNode = findAnchorNode();
        StartUpUtilsKt.startUpTrace("insertDirectly anchorNode = " + anchorNode + "\ncurrent node = " + node);
        if (anchorNode != null && node != null) {
            node.mParent = anchorNode;
            anchorNode.mSubNodes.push(node);
        }
    }

    private TraceNode findAnchorNode() {
        if (isFinish()) {
            StartUpUtilsKt.startUpTrace("findAnchorNode current node is finished");
            if (this.mSubNodes.size() == 0) {
                return this.mParent;
            }
            TraceNode subTopNode = this.mSubNodes.peek();
            if (subTopNode == null) {
                StartUpUtilsKt.startUpTrace(" sub node of [" + this.mTag + "] is null ");
                return null;
            } else if (subTopNode.isFinish()) {
                return this.mParent;
            } else {
                return subTopNode.findAnchorNode();
            }
        } else if (this.mSubNodes.size() == 0) {
            return this;
        } else {
            TraceNode subTopNode2 = this.mSubNodes.peek();
            if (subTopNode2 == null) {
                StartUpUtilsKt.startUpTrace(" sub node of [" + this.mTag + "] is null ");
                return null;
            }
            return subTopNode2.findAnchorNode();
        }
    }

    private long getTime() {
        return SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFinish() {
        return this.mStart > 0 && this.mEnd > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.mStart = -1L;
        this.mEnd = -1L;
        this.mParent = null;
        if (this.mSubNodes != null) {
            this.mSubNodes.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TraceNode createBeginNode(String tag) {
        TraceNode node = new TraceNode();
        node.mTag = tag;
        node.mStart = node.getTime();
        return node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TraceNode createEndNode(String tag) {
        TraceNode node = new TraceNode();
        node.mTag = tag;
        node.mEnd = node.getTime();
        return node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TraceNode createDurationNode(String tag, long duration) {
        if (TextUtils.isEmpty(tag) || duration <= 0) {
            return null;
        }
        TraceNode node = new TraceNode();
        node.mTag = tag;
        node.mStart = node.getTime();
        node.mEnd = node.mStart + duration;
        return node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TraceNode createDurationNode(String tag, long start, long duration) {
        if (TextUtils.isEmpty(tag) || duration <= 0) {
            return null;
        }
        TraceNode node = new TraceNode();
        node.mTag = tag;
        node.mStart = start;
        node.mEnd = node.mStart + duration;
        return node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class FakeStack {
        List<TraceNode> mElements = new ArrayList(5);

        FakeStack() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void push(TraceNode node) {
            this.mElements.add(node);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public TraceNode peek() {
            int size = this.mElements.size();
            if (size == 0) {
                return null;
            }
            return this.mElements.get(size - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.mElements = new ArrayList(5);
        }

        int size() {
            return this.mElements.size();
        }

        List<TraceNode> getElements() {
            return this.mElements;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (TraceNode item : this.mElements) {
                sb.append("element = ").append(item).append(" ");
            }
            return "FakeStack{" + ((Object) sb) + '}';
        }
    }

    public String toString() {
        return "TraceNode{mTag='" + (this.mTag == null ? "" : this.mTag) + ", mStart=" + this.mStart + ", mEnd=" + this.mEnd + ", mParent=" + (this.mParent != null ? this.mParent : "") + '}';
    }
}