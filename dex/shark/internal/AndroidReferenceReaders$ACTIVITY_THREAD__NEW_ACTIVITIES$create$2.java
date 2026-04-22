package shark.internal;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapField;
import shark.HeapObject;
import shark.HeapValue;
import shark.LibraryLeakReferenceMatcher;
import shark.ReferencePattern;
import shark.internal.AndroidReferenceReaders;
import shark.internal.ChainingInstanceReferenceReader;
import shark.internal.Reference;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: AndroidReferenceReaders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"shark/internal/AndroidReferenceReaders$ACTIVITY_THREAD__NEW_ACTIVITIES$create$2", "Lshark/internal/ChainingInstanceReferenceReader$VirtualInstanceReferenceReader;", "matches", "", "instance", "Lshark/HeapObject$HeapInstance;", "read", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", "source", "shark"}, k = 1, mv = {1, 4, 1})
public final class AndroidReferenceReaders$ACTIVITY_THREAD__NEW_ACTIVITIES$create$2 implements ChainingInstanceReferenceReader.VirtualInstanceReferenceReader {
    final /* synthetic */ long $activityClientRecordClassId;
    final /* synthetic */ long $activityThreadClassId;
    final /* synthetic */ AndroidReferenceReaders.ACTIVITY_THREAD__NEW_ACTIVITIES this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidReferenceReaders$ACTIVITY_THREAD__NEW_ACTIVITIES$create$2(AndroidReferenceReaders.ACTIVITY_THREAD__NEW_ACTIVITIES this$0, long $captured_local_variable$1, long $captured_local_variable$2) {
        this.this$0 = this$0;
        this.$activityThreadClassId = $captured_local_variable$1;
        this.$activityClientRecordClassId = $captured_local_variable$2;
    }

    @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader
    public boolean matches(HeapObject.HeapInstance instance) {
        Intrinsics.checkParameterIsNotNull(instance, "instance");
        return instance.getInstanceClassId() == this.$activityThreadClassId || instance.getInstanceClassId() == this.$activityClientRecordClassId;
    }

    @Override // shark.internal.ReferenceReader
    public Sequence<Reference> read(HeapObject.HeapInstance source) {
        Intrinsics.checkParameterIsNotNull(source, "source");
        if (source.getInstanceClassId() == this.$activityThreadClassId) {
            HeapField heapField = source.get("android.app.ActivityThread", "mNewActivities");
            if (heapField == null) {
                Intrinsics.throwNpe();
            }
            Long asObjectId = heapField.getValue().getAsObjectId();
            if (asObjectId == null) {
                Intrinsics.throwNpe();
            }
            long mNewActivities = asObjectId.longValue();
            if (mNewActivities == 0) {
                return SequencesKt.emptySequence();
            }
            source.getGraph().getContext().set(this.this$0.name(), Long.valueOf(mNewActivities));
            return SequencesKt.sequenceOf(new Reference[]{new Reference(mNewActivities, false, new Reference.LazyDetails.Resolver() { // from class: shark.internal.AndroidReferenceReaders$ACTIVITY_THREAD__NEW_ACTIVITIES$create$2$read$1
                @Override // shark.internal.Reference.LazyDetails.Resolver
                public final Reference.LazyDetails resolve() {
                    return new Reference.LazyDetails("mNewActivities", AndroidReferenceReaders$ACTIVITY_THREAD__NEW_ACTIVITIES$create$2.this.$activityThreadClassId, ReferenceLocationType.INSTANCE_FIELD, new LibraryLeakReferenceMatcher(new ReferencePattern.InstanceFieldPattern("android.app.ActivityThread", "mNewActivities"), "New activities are leaked by ActivityThread until the main thread becomes idle.\nTracked here: https://issuetracker.google.com/issues/258390457", null, 4, null), false);
                }
            })});
        }
        Long mNewActivities2 = (Long) source.getGraph().getContext().get(this.this$0.name());
        if (mNewActivities2 == null || source.getObjectId() != mNewActivities2.longValue()) {
            return SequencesKt.emptySequence();
        }
        return SequencesKt.mapNotNull(SequencesKt.withIndex(SequencesKt.generateSequence(source, new Function1<HeapObject.HeapInstance, HeapObject.HeapInstance>() { // from class: shark.internal.AndroidReferenceReaders$ACTIVITY_THREAD__NEW_ACTIVITIES$create$2$read$2
            public final HeapObject.HeapInstance invoke(HeapObject.HeapInstance node) {
                Intrinsics.checkParameterIsNotNull(node, "node");
                HeapField heapField2 = node.get("android.app.ActivityThread$ActivityClientRecord", "nextIdle");
                if (heapField2 == null) {
                    Intrinsics.throwNpe();
                }
                return heapField2.getValueAsInstance();
            }
        })), new Function1<IndexedValue<? extends HeapObject.HeapInstance>, Reference>() { // from class: shark.internal.AndroidReferenceReaders$ACTIVITY_THREAD__NEW_ACTIVITIES$create$2$read$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Reference invoke(IndexedValue<HeapObject.HeapInstance> indexedValue) {
                HeapValue value;
                Intrinsics.checkParameterIsNotNull(indexedValue, "<name for destructuring parameter 0>");
                final int index = indexedValue.component1();
                HeapObject.HeapInstance node = (HeapObject.HeapInstance) indexedValue.component2();
                HeapField heapField2 = node.get("android.app.ActivityThread$ActivityClientRecord", AudioIntentHelper.FROM_ACTIVITY);
                if (heapField2 == null) {
                    Intrinsics.throwNpe();
                }
                HeapObject.HeapInstance activity = heapField2.getValueAsInstance();
                if (activity != null) {
                    HeapField heapField3 = activity.get("android.app.Activity", "mDestroyed");
                    if (!Intrinsics.areEqual((heapField3 == null || (value = heapField3.getValue()) == null) ? null : value.getAsBoolean(), true)) {
                        return null;
                    }
                    return new Reference(activity.getObjectId(), false, new Reference.LazyDetails.Resolver() { // from class: shark.internal.AndroidReferenceReaders$ACTIVITY_THREAD__NEW_ACTIVITIES$create$2$read$3.1
                        @Override // shark.internal.Reference.LazyDetails.Resolver
                        public final Reference.LazyDetails resolve() {
                            return new Reference.LazyDetails(String.valueOf(index), AndroidReferenceReaders$ACTIVITY_THREAD__NEW_ACTIVITIES$create$2.this.$activityClientRecordClassId, ReferenceLocationType.ARRAY_ENTRY, null, true);
                        }
                    });
                }
                return null;
            }
        });
    }
}