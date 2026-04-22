package dev.chrisbanes.snapper;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: LazyList.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00126\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J&\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0.2\u0006\u0010/\u001a\u00020,H\u0016J\u0010\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000bH\u0016J\b\u00102\u001a\u00020,H\u0002R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R+\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0015R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u00063"}, d2 = {"Ldev/chrisbanes/snapper/LazyListSnapperLayoutInfo;", "Ldev/chrisbanes/snapper/SnapperLayoutInfo;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "snapOffsetForItem", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, "layoutInfo", "Ldev/chrisbanes/snapper/SnapperLayoutItemInfo;", "item", "", "endContentPadding", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function2;I)V", "currentItem", "getCurrentItem", "()Ldev/chrisbanes/snapper/SnapperLayoutItemInfo;", "currentItem$delegate", "Landroidx/compose/runtime/State;", "<set-?>", "getEndContentPadding$lib_release", "()I", "setEndContentPadding$lib_release", "(I)V", "endContentPadding$delegate", "Landroidx/compose/runtime/MutableState;", "endScrollOffset", "getEndScrollOffset", "itemCount", "getItemCount", "startScrollOffset", "getStartScrollOffset", "totalItemsCount", "getTotalItemsCount", "visibleItems", "Lkotlin/sequences/Sequence;", "getVisibleItems", "()Lkotlin/sequences/Sequence;", "calculateItemSpacing", "canScrollTowardsEnd", "", "canScrollTowardsStart", "determineTargetIndex", "velocity", "", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "maximumFlingDistance", "distanceToIndexSnap", "index", "estimateDistancePerItem", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LazyListSnapperLayoutInfo extends SnapperLayoutInfo {
    public static final int $stable = 0;
    private final State currentItem$delegate;
    private final MutableState endContentPadding$delegate;
    private final LazyListState lazyListState;
    private final Function2<SnapperLayoutInfo, SnapperLayoutItemInfo, Integer> snapOffsetForItem;
    private final int startScrollOffset;

    public /* synthetic */ LazyListSnapperLayoutInfo(LazyListState lazyListState, Function2 function2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyListState, function2, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyListSnapperLayoutInfo(LazyListState lazyListState, Function2<? super SnapperLayoutInfo, ? super SnapperLayoutItemInfo, Integer> function2, int endContentPadding) {
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(function2, "snapOffsetForItem");
        this.lazyListState = lazyListState;
        this.snapOffsetForItem = function2;
        this.endContentPadding$delegate = SnapshotStateKt.mutableStateOf$default(Integer.valueOf(endContentPadding), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.currentItem$delegate = SnapshotStateKt.derivedStateOf(new Function0<SnapperLayoutItemInfo>() { // from class: dev.chrisbanes.snapper.LazyListSnapperLayoutInfo$currentItem$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke */
            public final SnapperLayoutItemInfo m808invoke() {
                Function2 function22;
                Sequence $this$lastOrNull$iv = LazyListSnapperLayoutInfo.this.getVisibleItems();
                LazyListSnapperLayoutInfo lazyListSnapperLayoutInfo = LazyListSnapperLayoutInfo.this;
                SnapperLayoutItemInfo snapperLayoutItemInfo = null;
                for (Object element$iv : $this$lastOrNull$iv) {
                    SnapperLayoutItemInfo it = (SnapperLayoutItemInfo) element$iv;
                    int offset = it.getOffset();
                    function22 = lazyListSnapperLayoutInfo.snapOffsetForItem;
                    if (offset <= ((Number) function22.invoke(lazyListSnapperLayoutInfo, it)).intValue()) {
                        snapperLayoutItemInfo = element$iv;
                    }
                }
                return snapperLayoutItemInfo;
            }
        });
    }

    @Override // dev.chrisbanes.snapper.SnapperLayoutInfo
    public int getStartScrollOffset() {
        return this.startScrollOffset;
    }

    public final int getEndContentPadding$lib_release() {
        State $this$getValue$iv = this.endContentPadding$delegate;
        return ((Number) $this$getValue$iv.getValue()).intValue();
    }

    public final void setEndContentPadding$lib_release(int i2) {
        MutableState $this$setValue$iv = this.endContentPadding$delegate;
        Object value$iv = Integer.valueOf(i2);
        $this$setValue$iv.setValue(value$iv);
    }

    @Override // dev.chrisbanes.snapper.SnapperLayoutInfo
    public int getEndScrollOffset() {
        return this.lazyListState.getLayoutInfo().getViewportEndOffset() - getEndContentPadding$lib_release();
    }

    private final int getItemCount() {
        return this.lazyListState.getLayoutInfo().getTotalItemsCount();
    }

    @Override // dev.chrisbanes.snapper.SnapperLayoutInfo
    public int getTotalItemsCount() {
        return this.lazyListState.getLayoutInfo().getTotalItemsCount();
    }

    @Override // dev.chrisbanes.snapper.SnapperLayoutInfo
    public SnapperLayoutItemInfo getCurrentItem() {
        State $this$getValue$iv = this.currentItem$delegate;
        return (SnapperLayoutItemInfo) $this$getValue$iv.getValue();
    }

    @Override // dev.chrisbanes.snapper.SnapperLayoutInfo
    public Sequence<SnapperLayoutItemInfo> getVisibleItems() {
        return SequencesKt.map(CollectionsKt.asSequence(this.lazyListState.getLayoutInfo().getVisibleItemsInfo()), LazyListSnapperLayoutInfo$visibleItems$1.INSTANCE);
    }

    @Override // dev.chrisbanes.snapper.SnapperLayoutInfo
    public int distanceToIndexSnap(int index) {
        Object element$iv;
        boolean z;
        Sequence $this$firstOrNull$iv = getVisibleItems();
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                SnapperLayoutItemInfo it2 = (SnapperLayoutItemInfo) element$iv;
                if (it2.getIndex() == index) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        SnapperLayoutItemInfo itemInfo = (SnapperLayoutItemInfo) element$iv;
        if (itemInfo != null) {
            return itemInfo.getOffset() - ((Number) this.snapOffsetForItem.invoke(this, itemInfo)).intValue();
        }
        SnapperLayoutItemInfo currentItem = getCurrentItem();
        if (currentItem == null) {
            return 0;
        }
        return (MathKt.roundToInt((index - currentItem.getIndex()) * estimateDistancePerItem()) + currentItem.getOffset()) - ((Number) this.snapOffsetForItem.invoke(this, currentItem)).intValue();
    }

    @Override // dev.chrisbanes.snapper.SnapperLayoutInfo
    public boolean canScrollTowardsStart() {
        LazyListItemInfo it = (LazyListItemInfo) CollectionsKt.firstOrNull(this.lazyListState.getLayoutInfo().getVisibleItemsInfo());
        if (it == null) {
            return false;
        }
        return it.getIndex() > 0 || it.getOffset() < getStartScrollOffset();
    }

    @Override // dev.chrisbanes.snapper.SnapperLayoutInfo
    public boolean canScrollTowardsEnd() {
        LazyListItemInfo it = (LazyListItemInfo) CollectionsKt.lastOrNull(this.lazyListState.getLayoutInfo().getVisibleItemsInfo());
        if (it == null) {
            return false;
        }
        return it.getIndex() < getItemCount() - 1 || it.getOffset() + it.getSize() > getEndScrollOffset();
    }

    @Override // dev.chrisbanes.snapper.SnapperLayoutInfo
    public int determineTargetIndex(float velocity, DecayAnimationSpec<Float> decayAnimationSpec, float maximumFlingDistance) {
        Intrinsics.checkNotNullParameter(decayAnimationSpec, "decayAnimationSpec");
        SnapperLayoutItemInfo curr = getCurrentItem();
        if (curr == null) {
            return -1;
        }
        float distancePerItem = estimateDistancePerItem();
        if (distancePerItem <= CropImageView.DEFAULT_ASPECT_RATIO) {
            return curr.getIndex();
        }
        int distanceToCurrent = distanceToIndexSnap(curr.getIndex());
        int distanceToNext = distanceToIndexSnap(curr.getIndex() + 1);
        if (Math.abs(velocity) < 0.5f) {
            return RangesKt.coerceIn(Math.abs(distanceToCurrent) < Math.abs(distanceToNext) ? curr.getIndex() : curr.getIndex() + 1, 0, getItemCount() - 1);
        }
        float distance = RangesKt.coerceIn(DecayAnimationSpecKt.calculateTargetValue(decayAnimationSpec, (float) CropImageView.DEFAULT_ASPECT_RATIO, velocity), -maximumFlingDistance, maximumFlingDistance);
        float flingDistance = velocity < CropImageView.DEFAULT_ASPECT_RATIO ? RangesKt.coerceAtMost(distanceToNext + distance, (float) CropImageView.DEFAULT_ASPECT_RATIO) : RangesKt.coerceAtLeast(distanceToCurrent + distance, (float) CropImageView.DEFAULT_ASPECT_RATIO);
        double flingIndexDelta = flingDistance / distancePerItem;
        double currentItemOffsetRatio = distanceToCurrent / distancePerItem;
        int indexOffset = MathKt.roundToInt(flingIndexDelta - currentItemOffsetRatio);
        int coerceIn = RangesKt.coerceIn(curr.getIndex() + indexOffset, 0, getItemCount() - 1);
        SnapperLog snapperLog = SnapperLog.INSTANCE;
        return coerceIn;
    }

    private final int calculateItemSpacing() {
        LazyListLayoutInfo $this$calculateItemSpacing_u24lambda_u2d6 = this.lazyListState.getLayoutInfo();
        if ($this$calculateItemSpacing_u24lambda_u2d6.getVisibleItemsInfo().size() >= 2) {
            LazyListItemInfo first = (LazyListItemInfo) $this$calculateItemSpacing_u24lambda_u2d6.getVisibleItemsInfo().get(0);
            LazyListItemInfo second = (LazyListItemInfo) $this$calculateItemSpacing_u24lambda_u2d6.getVisibleItemsInfo().get(1);
            return second.getOffset() - (first.getSize() + first.getOffset());
        }
        return 0;
    }

    private final float estimateDistancePerItem() {
        Object minElem$iv;
        LazyListLayoutInfo $this$estimateDistancePerItem_u24lambda_u2d9 = this.lazyListState.getLayoutInfo();
        if ($this$estimateDistancePerItem_u24lambda_u2d9.getVisibleItemsInfo().isEmpty()) {
            return -1.0f;
        }
        Iterable $this$minByOrNull$iv = $this$estimateDistancePerItem_u24lambda_u2d9.getVisibleItemsInfo();
        Iterator iterator$iv = $this$minByOrNull$iv.iterator();
        Object maxElem$iv = null;
        if (iterator$iv.hasNext()) {
            minElem$iv = iterator$iv.next();
            if (iterator$iv.hasNext()) {
                LazyListItemInfo it = (LazyListItemInfo) minElem$iv;
                int minValue$iv = it.getOffset();
                do {
                    Object e$iv = iterator$iv.next();
                    LazyListItemInfo it2 = (LazyListItemInfo) e$iv;
                    int v$iv = it2.getOffset();
                    if (minValue$iv > v$iv) {
                        minElem$iv = e$iv;
                        minValue$iv = v$iv;
                    }
                } while (iterator$iv.hasNext());
            }
        } else {
            minElem$iv = null;
        }
        LazyListItemInfo minPosView = (LazyListItemInfo) minElem$iv;
        if (minPosView == null) {
            return -1.0f;
        }
        Iterable $this$maxByOrNull$iv = $this$estimateDistancePerItem_u24lambda_u2d9.getVisibleItemsInfo();
        Iterator iterator$iv2 = $this$maxByOrNull$iv.iterator();
        if (iterator$iv2.hasNext()) {
            maxElem$iv = iterator$iv2.next();
            if (iterator$iv2.hasNext()) {
                LazyListItemInfo it3 = (LazyListItemInfo) maxElem$iv;
                int maxValue$iv = it3.getOffset() + it3.getSize();
                do {
                    Object e$iv2 = iterator$iv2.next();
                    LazyListItemInfo it4 = (LazyListItemInfo) e$iv2;
                    int v$iv2 = it4.getOffset() + it4.getSize();
                    if (maxValue$iv < v$iv2) {
                        maxValue$iv = v$iv2;
                        maxElem$iv = e$iv2;
                    }
                } while (iterator$iv2.hasNext());
            }
        }
        LazyListItemInfo maxPosView = (LazyListItemInfo) maxElem$iv;
        if (maxPosView == null) {
            return -1.0f;
        }
        int start = Math.min(minPosView.getOffset(), maxPosView.getOffset());
        int end = Math.max(minPosView.getOffset() + minPosView.getSize(), maxPosView.getOffset() + maxPosView.getSize());
        int distance = end - start;
        if (distance == 0) {
            return -1.0f;
        }
        return (calculateItemSpacing() + distance) / $this$estimateDistancePerItem_u24lambda_u2d9.getVisibleItemsInfo().size();
    }
}