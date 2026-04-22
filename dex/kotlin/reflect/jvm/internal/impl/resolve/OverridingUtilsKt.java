package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* compiled from: overridingUtils.kt */
public final class OverridingUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> collection, Function1<? super H, ? extends CallableDescriptor> descriptorByHandle) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(descriptorByHandle, "descriptorByHandle");
        int i = 1;
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList queue = new LinkedList(collection);
        SmartSet result = SmartSet.Companion.create();
        while (!queue.isEmpty()) {
            Object nextHandle = CollectionsKt.first((List<? extends Object>) queue);
            final SmartSet conflictedHandles = SmartSet.Companion.create();
            Collection overridableGroup = OverridingUtil.extractMembersOverridableInBothWays(nextHandle, queue, descriptorByHandle, new Function1(conflictedHandles) { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt$$Lambda$1
                private final SmartSet arg$0;

                {
                    this.arg$0 = conflictedHandles;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    Unit selectMostSpecificInEachOverridableGroup$lambda$0;
                    selectMostSpecificInEachOverridableGroup$lambda$0 = OverridingUtilsKt.selectMostSpecificInEachOverridableGroup$lambda$0(this.arg$0, obj);
                    return selectMostSpecificInEachOverridableGroup$lambda$0;
                }
            });
            Intrinsics.checkNotNullExpressionValue(overridableGroup, "extractMembersOverridableInBothWays(...)");
            if (overridableGroup.size() == i && conflictedHandles.isEmpty()) {
                Object single = CollectionsKt.single(overridableGroup);
                Intrinsics.checkNotNullExpressionValue(single, "single(...)");
                result.add(single);
            } else {
                Object mostSpecific = (Object) OverridingUtil.selectMostSpecificMember(overridableGroup, descriptorByHandle);
                CallableDescriptor mostSpecificDescriptor = descriptorByHandle.invoke(mostSpecific);
                Collection<Object> $this$filterNotTo$iv = overridableGroup;
                SmartSet destination$iv = conflictedHandles;
                for (Object element$iv : $this$filterNotTo$iv) {
                    Intrinsics.checkNotNull(element$iv);
                    if (!OverridingUtil.isMoreSpecific(mostSpecificDescriptor, descriptorByHandle.invoke(element$iv))) {
                        destination$iv.add(element$iv);
                    }
                }
                if (!conflictedHandles.isEmpty()) {
                    result.addAll(conflictedHandles);
                }
                result.add(mostSpecific);
                i = 1;
            }
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit selectMostSpecificInEachOverridableGroup$lambda$0(SmartSet $conflictedHandles, Object it) {
        Intrinsics.checkNotNull(it);
        $conflictedHandles.add(it);
        return Unit.INSTANCE;
    }
}