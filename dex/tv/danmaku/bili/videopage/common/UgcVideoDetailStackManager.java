package tv.danmaku.bili.videopage.common;

import java.util.Iterator;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UgcVideoDetailStackManager.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/videopage/common/UgcVideoDetailStackManager;", "", "<init>", "()V", "mUgcVideoStack", "Ljava/util/Stack;", "", "addActivity", "", "hashCode", "type", "Ltv/danmaku/bili/videopage/common/UgcVideoDetailStackManager$StackElementType;", "removeActivity", "clearStack", "getStackSize", "StackElementType", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UgcVideoDetailStackManager {
    public static final UgcVideoDetailStackManager INSTANCE = new UgcVideoDetailStackManager();
    private static final Stack<Integer> mUgcVideoStack = new Stack<>();

    /* compiled from: UgcVideoDetailStackManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/videopage/common/UgcVideoDetailStackManager$StackElementType;", "", "<init>", "(Ljava/lang/String;I)V", "UGC_VIDEO", "PLAYLIST_VIDEO", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum StackElementType {
        UGC_VIDEO,
        PLAYLIST_VIDEO;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<StackElementType> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: UgcVideoDetailStackManager.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StackElementType.values().length];
            try {
                iArr[StackElementType.UGC_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[StackElementType.PLAYLIST_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private UgcVideoDetailStackManager() {
    }

    public final void addActivity(int hashCode, StackElementType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        boolean hasActivity = false;
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                Iterator iterator = mUgcVideoStack.iterator();
                Intrinsics.checkNotNullExpressionValue(iterator, "iterator(...)");
                while (iterator.hasNext()) {
                    Object element$iv = iterator.next();
                    Integer it = (Integer) element$iv;
                    if (it != null && hashCode == it.intValue()) {
                        hasActivity = true;
                    }
                }
                if (!hasActivity) {
                    mUgcVideoStack.push(Integer.valueOf(hashCode));
                    return;
                }
                return;
            case 2:
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void removeActivity(int hashCode, StackElementType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                Iterator iterator = mUgcVideoStack.iterator();
                Intrinsics.checkNotNullExpressionValue(iterator, "iterator(...)");
                while (iterator.hasNext()) {
                    Object element$iv = iterator.next();
                    Integer it = (Integer) element$iv;
                    if (it != null && hashCode == it.intValue()) {
                        iterator.remove();
                    }
                }
                return;
            case 2:
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void clearStack(StackElementType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                mUgcVideoStack.clear();
                return;
            case 2:
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int getStackSize(StackElementType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return mUgcVideoStack.size();
            case 2:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}