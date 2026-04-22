package kotlin.io.path;

import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PathTreeWalk.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {191, 197}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded"}, nl = {193, 199}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
public final class PathTreeWalk$bfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ PathTreeWalk this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathTreeWalk$bfsIterator$1(PathTreeWalk pathTreeWalk, Continuation<? super PathTreeWalk$bfsIterator$1> continuation) {
        super(2, continuation);
        this.this$0 = pathTreeWalk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PathTreeWalk$bfsIterator$1 pathTreeWalk$bfsIterator$1 = new PathTreeWalk$bfsIterator$1(this.this$0, continuation);
        pathTreeWalk$bfsIterator$1.L$0 = obj;
        return pathTreeWalk$bfsIterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
        return ((PathTreeWalk$bfsIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x013a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0148 -> B:9:0x00b1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x01a3 -> B:36:0x01ae). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        boolean followLinks;
        Path path;
        Path path2;
        Object keyOf;
        ArrayDeque queue;
        DirectoryEntriesReader entriesReader;
        PathTreeWalk$bfsIterator$1 pathTreeWalk$bfsIterator$1;
        Object obj;
        SequenceScope $this$iterator;
        DirectoryEntriesReader entriesReader$iv;
        PathNode node$iv;
        PathTreeWalk this_$iv;
        Path path$iv;
        LinkOption[] linkOptionArr;
        boolean createsCycle;
        Object obj2;
        ArrayDeque queue2;
        DirectoryEntriesReader entriesReader2;
        PathTreeWalk$bfsIterator$1 pathTreeWalk$bfsIterator$12;
        SequenceScope $this$iterator2 = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ArrayDeque queue3 = new ArrayDeque();
                followLinks = this.this$0.getFollowLinks();
                DirectoryEntriesReader entriesReader3 = new DirectoryEntriesReader(followLinks);
                path = this.this$0.start;
                path2 = this.this$0.start;
                keyOf = PathTreeWalkKt.keyOf(path2, this.this$0.getLinkOptions());
                queue3.addLast(new PathNode(path, keyOf, null));
                queue = queue3;
                entriesReader = entriesReader3;
                pathTreeWalk$bfsIterator$1 = this;
                obj = coroutine_suspended;
                $this$iterator = $this$iterator2;
                break;
            case 1:
                int $i$f$yieldIfNeeded = this.I$0;
                Path path$iv2 = (Path) this.L$8;
                entriesReader$iv = (DirectoryEntriesReader) this.L$7;
                node$iv = (PathNode) this.L$6;
                SequenceScope sequenceScope = (SequenceScope) this.L$5;
                this_$iv = (PathTreeWalk) this.L$4;
                PathNode pathNode = (PathNode) this.L$3;
                entriesReader = (DirectoryEntriesReader) this.L$2;
                queue = (ArrayDeque) this.L$1;
                ResultKt.throwOnFailure($result);
                path$iv = path$iv2;
                pathTreeWalk$bfsIterator$1 = this;
                obj = coroutine_suspended;
                $this$iterator = $this$iterator2;
                LinkOption[] linkOptions = this_$iv.getLinkOptions();
                linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
                if (Files.isDirectory(path$iv, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                    List entries = entriesReader$iv.readEntries(node$iv);
                    queue.addAll(entries);
                }
                break;
            case 2:
                int i = this.I$0;
                Path path3 = (Path) this.L$8;
                DirectoryEntriesReader directoryEntriesReader = (DirectoryEntriesReader) this.L$7;
                PathNode pathNode2 = (PathNode) this.L$6;
                SequenceScope sequenceScope2 = (SequenceScope) this.L$5;
                PathTreeWalk pathTreeWalk = (PathTreeWalk) this.L$4;
                PathNode pathNode3 = (PathNode) this.L$3;
                DirectoryEntriesReader entriesReader4 = (DirectoryEntriesReader) this.L$2;
                ResultKt.throwOnFailure($result);
                queue2 = (ArrayDeque) this.L$1;
                entriesReader2 = entriesReader4;
                pathTreeWalk$bfsIterator$12 = this;
                obj2 = coroutine_suspended;
                $this$iterator = $this$iterator2;
                obj = obj2;
                pathTreeWalk$bfsIterator$1 = pathTreeWalk$bfsIterator$12;
                entriesReader = entriesReader2;
                queue = queue2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (!queue.isEmpty()) {
            PathNode pathNode4 = (PathNode) queue.removeFirst();
            this_$iv = pathTreeWalk$bfsIterator$1.this$0;
            entriesReader$iv = entriesReader;
            node$iv = pathNode4;
            SequenceScope $this$yieldIfNeeded$iv = $this$iterator;
            path$iv = node$iv.getPath();
            if (node$iv.getParent() != null) {
                PathsKt.checkFileName(path$iv);
            }
            LinkOption[] linkOptions2 = this_$iv.getLinkOptions();
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
            if (Files.isDirectory(path$iv, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                createsCycle = PathTreeWalkKt.createsCycle(node$iv);
                if (!createsCycle) {
                    if (this_$iv.getIncludeDirectories()) {
                        pathTreeWalk$bfsIterator$1.L$0 = $this$iterator;
                        pathTreeWalk$bfsIterator$1.L$1 = queue;
                        pathTreeWalk$bfsIterator$1.L$2 = entriesReader;
                        pathTreeWalk$bfsIterator$1.L$3 = SpillingKt.nullOutSpilledVariable(pathNode4);
                        pathTreeWalk$bfsIterator$1.L$4 = this_$iv;
                        pathTreeWalk$bfsIterator$1.L$5 = SpillingKt.nullOutSpilledVariable($this$yieldIfNeeded$iv);
                        pathTreeWalk$bfsIterator$1.L$6 = node$iv;
                        pathTreeWalk$bfsIterator$1.L$7 = entriesReader$iv;
                        pathTreeWalk$bfsIterator$1.L$8 = path$iv;
                        pathTreeWalk$bfsIterator$1.I$0 = 0;
                        pathTreeWalk$bfsIterator$1.label = 1;
                        if ($this$yieldIfNeeded$iv.yield(path$iv, pathTreeWalk$bfsIterator$1) == obj) {
                            return obj;
                        }
                    }
                    LinkOption[] linkOptions3 = this_$iv.getLinkOptions();
                    linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions3, linkOptions3.length);
                    if (Files.isDirectory(path$iv, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                    }
                    while (!queue.isEmpty()) {
                    }
                } else {
                    throw new FileSystemLoopException(path$iv.toString());
                }
            } else if (Files.exists(path$iv, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                pathTreeWalk$bfsIterator$1.L$0 = $this$iterator;
                pathTreeWalk$bfsIterator$1.L$1 = queue;
                pathTreeWalk$bfsIterator$1.L$2 = entriesReader;
                pathTreeWalk$bfsIterator$1.L$3 = SpillingKt.nullOutSpilledVariable(pathNode4);
                pathTreeWalk$bfsIterator$1.L$4 = SpillingKt.nullOutSpilledVariable(this_$iv);
                pathTreeWalk$bfsIterator$1.L$5 = SpillingKt.nullOutSpilledVariable($this$yieldIfNeeded$iv);
                pathTreeWalk$bfsIterator$1.L$6 = SpillingKt.nullOutSpilledVariable(node$iv);
                pathTreeWalk$bfsIterator$1.L$7 = SpillingKt.nullOutSpilledVariable(entriesReader$iv);
                pathTreeWalk$bfsIterator$1.L$8 = SpillingKt.nullOutSpilledVariable(path$iv);
                pathTreeWalk$bfsIterator$1.I$0 = 0;
                pathTreeWalk$bfsIterator$1.label = 2;
                if ($this$yieldIfNeeded$iv.yield(path$iv, pathTreeWalk$bfsIterator$1) == obj) {
                    return obj;
                }
                obj2 = obj;
                queue2 = queue;
                entriesReader2 = entriesReader;
                pathTreeWalk$bfsIterator$12 = pathTreeWalk$bfsIterator$1;
                obj = obj2;
                pathTreeWalk$bfsIterator$1 = pathTreeWalk$bfsIterator$12;
                entriesReader = entriesReader2;
                queue = queue2;
                while (!queue.isEmpty()) {
                }
            }
        }
        return Unit.INSTANCE;
    }
}