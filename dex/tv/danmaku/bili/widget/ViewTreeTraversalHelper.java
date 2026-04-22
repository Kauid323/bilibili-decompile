package tv.danmaku.bili.widget;

import android.view.View;
import android.view.ViewGroup;
import com.bilibili.lib.blconfig.ConfigManager;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.tree.VideoFile;

/* compiled from: ViewTreeTraversalHelper.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J0\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0017j\b\u0012\u0004\u0012\u00020\u0006`\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002Rh\u0010\u0004\u001aP\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012/\u0012-\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\nj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/widget/ViewTreeTraversalHelper;", "", "<init>", "()V", "reporter", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "eventId", "Ljava/util/HashMap;", "map", "Lkotlin/collections/HashMap;", "", "getReporter", "()Lkotlin/jvm/functions/Function2;", "setReporter", "(Lkotlin/jvm/functions/Function2;)V", "reportViewTreeIfNeed", "view", "Landroid/view/View;", "traversalViewGroup", "result", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "depth", "", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ViewTreeTraversalHelper {
    public static final ViewTreeTraversalHelper INSTANCE = new ViewTreeTraversalHelper();
    private static Function2<? super String, ? super HashMap<String, String>, Unit> reporter;

    private ViewTreeTraversalHelper() {
    }

    public final Function2<String, HashMap<String, String>, Unit> getReporter() {
        return reporter;
    }

    public final void setReporter(Function2<? super String, ? super HashMap<String, String>, Unit> function2) {
        reporter = function2;
    }

    public final void reportViewTreeIfNeed(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("ff_report_pinned_illegal", true), true)) {
            ArrayList result = new ArrayList();
            traversalViewGroup(view2, result, 0);
            StringBuilder sb = new StringBuilder();
            ArrayList $this$forEach$iv = result;
            for (Object element$iv : $this$forEach$iv) {
                String it = (String) element$iv;
                sb.append(it).append(VideoFile.TREE_END);
            }
            HashMap map = new HashMap();
            map.put("view_tree", sb.toString());
            Function2<? super String, ? super HashMap<String, String>, Unit> function2 = reporter;
            if (function2 != null) {
                function2.invoke("app.pinned.illegal.exception", map);
            }
        }
    }

    private final void traversalViewGroup(View view2, ArrayList<String> arrayList, int depth) {
        int i = depth;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i2 = i - 1;
            if (i < 0) {
                break;
            }
            sb.append("   ");
            i = i2;
        }
        sb.append("->");
        arrayList.add(((Object) sb) + " " + view2);
        if (view2 instanceof ViewGroup) {
            int j = 0;
            int childCount = ((ViewGroup) view2).getChildCount();
            if (0 > childCount) {
                return;
            }
            while (true) {
                View it = ((ViewGroup) view2).getChildAt(j);
                if (it != null) {
                    INSTANCE.traversalViewGroup(it, arrayList, depth + 1);
                }
                if (j == childCount) {
                    return;
                }
                j++;
            }
        }
    }
}