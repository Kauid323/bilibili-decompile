package leakcanary;

import kotlin.Metadata;

/* compiled from: ReachabilityWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lleakcanary/ReachabilityWatcher;", "", "expectWeaklyReachable", "", "watchedObject", "description", "", "leakcanary-object-watcher"}, k = 1, mv = {1, 4, 1})
public interface ReachabilityWatcher {
    void expectWeaklyReachable(Object obj, String str);
}