package tv.danmaku.bili.quick.core;

import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseStatus;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;

/* compiled from: OnePassLoginPathLinkManager.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014J&\u0010\u0015\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\f0\u0017J\u0018\u0010\u0018\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u0006J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u000fJ\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u000fR#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginPathLinkManager;", "", "<init>", "()V", "pathLinkMap", "", "", "Ljava/util/LinkedList;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseStatus;", "getPathLinkMap", "()Ljava/util/Map;", "data", "Ltv/danmaku/bili/quick/core/OnePassLoginPhoneData;", "phaseStatusListeners", "", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseStatusListener;", "onPhase", "", "spmId", "phaseType", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "updateData", "block", "Lkotlin/Function1;", "stopWithReason", "reason", "passLastPhase", "key", "registerPhaseStatusListener", "listener", "removePhaseStatusListener", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OnePassLoginPathLinkManager {
    public static final OnePassLoginPathLinkManager INSTANCE = new OnePassLoginPathLinkManager();
    private static final Map<String, LinkedList<OnePassLoginPhaseStatus>> pathLinkMap = new LinkedHashMap();
    private static final Map<String, OnePassLoginPhoneData> data = new LinkedHashMap();
    private static final Set<OnePassLoginPhaseStatusListener> phaseStatusListeners = new LinkedHashSet();
    public static final int $stable = 8;

    private OnePassLoginPathLinkManager() {
    }

    public final Map<String, LinkedList<OnePassLoginPhaseStatus>> getPathLinkMap() {
        return pathLinkMap;
    }

    public static /* synthetic */ void onPhase$default(OnePassLoginPathLinkManager onePassLoginPathLinkManager, String str, OnePassLoginPhaseType onePassLoginPhaseType, int i, Object obj) {
        if ((i & 2) != 0) {
            onePassLoginPhaseType = OnePassLoginPhaseType.Trigger.INSTANCE;
        }
        onePassLoginPathLinkManager.onPhase(str, onePassLoginPhaseType);
    }

    public final void onPhase(String spmId, OnePassLoginPhaseType phaseType) {
        String key;
        Intrinsics.checkNotNullParameter(phaseType, "phaseType");
        if (spmId == null || (key = ListExtentionsKt.takeIfNotBlank(spmId)) == null) {
            key = OnePassLoginPathLinkManagerKt.NAMELESS;
        }
        if (Intrinsics.areEqual(phaseType, OnePassLoginPhaseType.Trigger.INSTANCE)) {
            pathLinkMap.remove(key);
        }
        LinkedList<OnePassLoginPhaseStatus> linkedList = pathLinkMap.get(key);
        OnePassLoginPhaseStatus lastPhase = linkedList != null ? (OnePassLoginPhaseStatus) CollectionsKt.lastOrNull(linkedList) : null;
        if (lastPhase == null) {
            Map<String, LinkedList<OnePassLoginPhaseStatus>> map = pathLinkMap;
            LinkedList $this$onPhase_u24lambda_u240 = new LinkedList();
            $this$onPhase_u24lambda_u240.add(new OnePassLoginPhaseStatus.Going(phaseType));
            map.put(key, $this$onPhase_u24lambda_u240);
            Iterable $this$forEach$iv = phaseStatusListeners;
            for (Object element$iv : $this$forEach$iv) {
                OnePassLoginPhaseStatusListener it = (OnePassLoginPhaseStatusListener) element$iv;
                it.onChange(key, new OnePassLoginPhaseStatus.Going(phaseType), data.get(key));
            }
        } else if (!Intrinsics.areEqual(lastPhase.getPhaseType(), phaseType)) {
            if (lastPhase instanceof OnePassLoginPhaseStatus.Going) {
                lastPhase = passLastPhase(key);
            }
            if (lastPhase instanceof OnePassLoginPhaseStatus.Passed) {
                LinkedList<OnePassLoginPhaseStatus> linkedList2 = pathLinkMap.get(key);
                if (linkedList2 != null) {
                    linkedList2.add(new OnePassLoginPhaseStatus.Going(phaseType));
                }
                Iterable $this$forEach$iv2 = phaseStatusListeners;
                for (Object element$iv2 : $this$forEach$iv2) {
                    OnePassLoginPhaseStatusListener it2 = (OnePassLoginPhaseStatusListener) element$iv2;
                    it2.onChange(key, new OnePassLoginPhaseStatus.Going(phaseType), data.get(key));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateData(String spmId, Function1<? super OnePassLoginPhoneData, OnePassLoginPhoneData> function1) {
        String key;
        Intrinsics.checkNotNullParameter(function1, "block");
        if (spmId == null || (key = ListExtentionsKt.takeIfNotBlank(spmId)) == null) {
            key = OnePassLoginPathLinkManagerKt.NAMELESS;
        }
        data.put(key, function1.invoke(data.get(key)));
    }

    public final void stopWithReason(String spmId, String reason) {
        String key;
        OnePassLoginPhaseStatus it;
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (spmId == null || (key = ListExtentionsKt.takeIfNotBlank(spmId)) == null) {
            key = OnePassLoginPathLinkManagerKt.NAMELESS;
        }
        LinkedList pathLink = pathLinkMap.get(key);
        if (((pathLink != null ? (OnePassLoginPhaseStatus) CollectionsKt.lastOrNull(pathLink) : null) instanceof OnePassLoginPhaseStatus.Going) && (it = (OnePassLoginPhaseStatus) CollectionsKt.removeLastOrNull(pathLink)) != null) {
            OnePassLoginPhaseStatus.Failed status = new OnePassLoginPhaseStatus.Failed(it.getPhaseType(), reason);
            pathLink.addLast(status);
            Iterable $this$forEach$iv = phaseStatusListeners;
            for (Object element$iv : $this$forEach$iv) {
                OnePassLoginPhaseStatusListener listener = (OnePassLoginPhaseStatusListener) element$iv;
                listener.onChange(key, status, data.get(key));
            }
        }
    }

    public final OnePassLoginPhaseStatus passLastPhase(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        LinkedList pathLink = pathLinkMap.get(key);
        OnePassLoginPhaseStatus it = null;
        OnePassLoginPhaseStatus last = pathLink != null ? (OnePassLoginPhaseStatus) CollectionsKt.lastOrNull(pathLink) : null;
        if (last instanceof OnePassLoginPhaseStatus.Going) {
            OnePassLoginPhaseStatus it2 = (OnePassLoginPhaseStatus) CollectionsKt.removeLastOrNull(pathLink);
            if (it2 != null) {
                OnePassLoginPhaseStatus.Passed status = new OnePassLoginPhaseStatus.Passed(it2.getPhaseType());
                pathLink.addLast(status);
                Iterable $this$forEach$iv = phaseStatusListeners;
                for (Object element$iv : $this$forEach$iv) {
                    OnePassLoginPhaseStatusListener listener = (OnePassLoginPhaseStatusListener) element$iv;
                    listener.onChange(key, status, data.get(key));
                }
                it = status;
            }
            return it;
        }
        return last;
    }

    public final void registerPhaseStatusListener(OnePassLoginPhaseStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        phaseStatusListeners.add(listener);
    }

    public final void removePhaseStatusListener(OnePassLoginPhaseStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        phaseStatusListeners.remove(listener);
    }
}