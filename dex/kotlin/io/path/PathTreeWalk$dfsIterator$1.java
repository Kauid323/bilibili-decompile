package kotlin.io.path;

import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PathTreeWalk.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {191, 197, 210, 216}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "topNode", "topIterator", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "topNode", "topIterator", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded"}, nl = {193, 199, 212, 218}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0"}, v = 2)
public final class PathTreeWalk$dfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ PathTreeWalk this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathTreeWalk$dfsIterator$1(PathTreeWalk pathTreeWalk, Continuation<? super PathTreeWalk$dfsIterator$1> continuation) {
        super(2, continuation);
        this.this$0 = pathTreeWalk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PathTreeWalk$dfsIterator$1 pathTreeWalk$dfsIterator$1 = new PathTreeWalk$dfsIterator$1(this.this$0, continuation);
        pathTreeWalk$dfsIterator$1.L$0 = obj;
        return pathTreeWalk$dfsIterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
        return ((PathTreeWalk$dfsIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02e7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x02e9 -> B:36:0x0209). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0360 -> B:68:0x0369). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ArrayDeque stack;
        boolean followLinks;
        DirectoryEntriesReader entriesReader;
        Path path;
        Path path2;
        Object keyOf;
        PathNode startNode;
        PathTreeWalk this_$iv;
        PathNode node$iv;
        DirectoryEntriesReader entriesReader$iv;
        Path path$iv;
        PathTreeWalk$dfsIterator$1 pathTreeWalk$dfsIterator$1;
        Object obj;
        PathNode startNode2;
        DirectoryEntriesReader entriesReader2;
        ArrayDeque stack2;
        SequenceScope $this$iterator;
        Object $result2;
        boolean createsCycle;
        LinkOption[] linkOptionArr;
        int $i$f$yieldIfNeeded;
        Path path$iv2;
        ArrayDeque stack3;
        PathNode pathNode;
        PathTreeWalk this_$iv2;
        PathNode node$iv2;
        DirectoryEntriesReader entriesReader$iv2;
        Object $result3;
        Object $result4;
        Path path$iv3;
        LinkOption[] linkOptionArr2;
        Object $result5;
        boolean createsCycle2;
        Object obj2;
        PathTreeWalk$dfsIterator$1 pathTreeWalk$dfsIterator$12;
        SequenceScope $this$iterator2 = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                stack = new ArrayDeque();
                followLinks = this.this$0.getFollowLinks();
                entriesReader = new DirectoryEntriesReader(followLinks);
                path = this.this$0.start;
                path2 = this.this$0.start;
                keyOf = PathTreeWalkKt.keyOf(path2, this.this$0.getLinkOptions());
                startNode = new PathNode(path, keyOf, null);
                this_$iv = this.this$0;
                node$iv = startNode;
                entriesReader$iv = entriesReader;
                path$iv = node$iv.getPath();
                if (node$iv.getParent() != null) {
                    PathsKt.checkFileName(path$iv);
                }
                LinkOption[] linkOptions = this_$iv.getLinkOptions();
                LinkOption[] linkOptionArr3 = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
                if (!Files.isDirectory(path$iv, (LinkOption[]) Arrays.copyOf(linkOptionArr3, linkOptionArr3.length))) {
                    if (!Files.exists(path$iv, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                        pathTreeWalk$dfsIterator$1 = this;
                        obj = coroutine_suspended;
                        startNode2 = startNode;
                        entriesReader2 = entriesReader;
                        stack2 = stack;
                        $this$iterator = $this$iterator2;
                        $result2 = $result;
                        break;
                    } else {
                        this.L$0 = $this$iterator2;
                        this.L$1 = stack;
                        this.L$2 = entriesReader;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(startNode);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(this_$iv);
                        this.L$5 = SpillingKt.nullOutSpilledVariable($this$iterator2);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(node$iv);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(entriesReader$iv);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(path$iv);
                        this.I$0 = 0;
                        this.label = 2;
                        if ($this$iterator2.yield(path$iv, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pathTreeWalk$dfsIterator$1 = this;
                        obj = coroutine_suspended;
                        startNode2 = startNode;
                        entriesReader2 = entriesReader;
                        stack2 = stack;
                        $this$iterator = $this$iterator2;
                        $result2 = $result;
                        break;
                    }
                } else {
                    createsCycle = PathTreeWalkKt.createsCycle(node$iv);
                    if (!createsCycle) {
                        if (this_$iv.getIncludeDirectories()) {
                            this.L$0 = $this$iterator2;
                            this.L$1 = stack;
                            this.L$2 = entriesReader;
                            this.L$3 = startNode;
                            this.L$4 = this_$iv;
                            this.L$5 = SpillingKt.nullOutSpilledVariable($this$iterator2);
                            this.L$6 = node$iv;
                            this.L$7 = entriesReader$iv;
                            this.L$8 = path$iv;
                            this.I$0 = 0;
                            this.label = 1;
                            if ($this$iterator2.yield(path$iv, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        LinkOption[] linkOptions2 = this_$iv.getLinkOptions();
                        linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
                        if (Files.isDirectory(path$iv, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                            List entries = entriesReader$iv.readEntries(node$iv);
                            startNode.setContentIterator(entries.iterator());
                            stack.addLast(startNode);
                        }
                        pathTreeWalk$dfsIterator$1 = this;
                        obj = coroutine_suspended;
                        startNode2 = startNode;
                        entriesReader2 = entriesReader;
                        stack2 = stack;
                        $this$iterator = $this$iterator2;
                        $result2 = $result;
                        break;
                    } else {
                        throw new FileSystemLoopException(path$iv.toString());
                    }
                }
            case 1:
                int $i$f$yieldIfNeeded2 = this.I$0;
                path$iv = (Path) this.L$8;
                entriesReader$iv = (DirectoryEntriesReader) this.L$7;
                node$iv = (PathNode) this.L$6;
                SequenceScope sequenceScope = (SequenceScope) this.L$5;
                this_$iv = (PathTreeWalk) this.L$4;
                startNode = (PathNode) this.L$3;
                entriesReader = (DirectoryEntriesReader) this.L$2;
                stack = (ArrayDeque) this.L$1;
                ResultKt.throwOnFailure($result);
                LinkOption[] linkOptions22 = this_$iv.getLinkOptions();
                linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions22, linkOptions22.length);
                if (Files.isDirectory(path$iv, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                }
                pathTreeWalk$dfsIterator$1 = this;
                obj = coroutine_suspended;
                startNode2 = startNode;
                entriesReader2 = entriesReader;
                stack2 = stack;
                $this$iterator = $this$iterator2;
                $result2 = $result;
                break;
            case 2:
                int $i$f$yieldIfNeeded3 = this.I$0;
                Path path3 = (Path) this.L$8;
                DirectoryEntriesReader directoryEntriesReader = (DirectoryEntriesReader) this.L$7;
                PathNode pathNode2 = (PathNode) this.L$6;
                SequenceScope sequenceScope2 = (SequenceScope) this.L$5;
                PathTreeWalk pathTreeWalk = (PathTreeWalk) this.L$4;
                startNode = (PathNode) this.L$3;
                entriesReader = (DirectoryEntriesReader) this.L$2;
                stack = (ArrayDeque) this.L$1;
                ResultKt.throwOnFailure($result);
                pathTreeWalk$dfsIterator$1 = this;
                obj = coroutine_suspended;
                startNode2 = startNode;
                entriesReader2 = entriesReader;
                stack2 = stack;
                $this$iterator = $this$iterator2;
                $result2 = $result;
                break;
            case 3:
                $i$f$yieldIfNeeded = this.I$0;
                path$iv2 = (Path) this.L$11;
                SequenceScope sequenceScope3 = (SequenceScope) this.L$8;
                PathNode pathNode3 = (PathNode) this.L$6;
                Iterator it = (Iterator) this.L$5;
                PathNode pathNode4 = (PathNode) this.L$4;
                ResultKt.throwOnFailure($result);
                stack3 = (ArrayDeque) this.L$1;
                entriesReader2 = (DirectoryEntriesReader) this.L$2;
                startNode2 = (PathNode) this.L$3;
                pathNode = pathNode3;
                this_$iv2 = (PathTreeWalk) this.L$7;
                node$iv2 = (PathNode) this.L$9;
                entriesReader$iv2 = (DirectoryEntriesReader) this.L$10;
                pathTreeWalk$dfsIterator$1 = this;
                $result3 = $result;
                SequenceScope sequenceScope4 = $this$iterator2;
                $result4 = $result3;
                path$iv3 = path$iv2;
                stack2 = stack3;
                obj = coroutine_suspended;
                $this$iterator = sequenceScope4;
                Object $result6 = $result4;
                LinkOption[] linkOptions3 = this_$iv2.getLinkOptions();
                SequenceScope $this$iterator3 = $this$iterator;
                linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions3, linkOptions3.length);
                if (Files.isDirectory(path$iv3, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                    List entries2 = entriesReader$iv2.readEntries(node$iv2);
                    pathNode.setContentIterator(entries2.iterator());
                    stack2.addLast(pathNode);
                }
                $result2 = $result6;
                $this$iterator = $this$iterator3;
                break;
            case 4:
                int i = this.I$0;
                Path path4 = (Path) this.L$11;
                DirectoryEntriesReader directoryEntriesReader2 = (DirectoryEntriesReader) this.L$10;
                PathNode pathNode5 = (PathNode) this.L$9;
                SequenceScope sequenceScope5 = (SequenceScope) this.L$8;
                PathTreeWalk pathTreeWalk2 = (PathTreeWalk) this.L$7;
                PathNode pathNode6 = (PathNode) this.L$6;
                Iterator it2 = (Iterator) this.L$5;
                PathNode pathNode7 = (PathNode) this.L$4;
                startNode2 = (PathNode) this.L$3;
                entriesReader2 = (DirectoryEntriesReader) this.L$2;
                stack2 = (ArrayDeque) this.L$1;
                ResultKt.throwOnFailure($result);
                pathTreeWalk$dfsIterator$12 = this;
                obj2 = coroutine_suspended;
                $this$iterator = $this$iterator2;
                $result2 = $result;
                obj = obj2;
                pathTreeWalk$dfsIterator$1 = pathTreeWalk$dfsIterator$12;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (!stack2.isEmpty()) {
            PathNode topNode = (PathNode) stack2.last();
            Iterator topIterator = topNode.getContentIterator();
            Intrinsics.checkNotNull(topIterator);
            if (topIterator.hasNext()) {
                pathNode = topIterator.next();
                this_$iv2 = pathTreeWalk$dfsIterator$1.this$0;
                entriesReader$iv2 = entriesReader2;
                node$iv2 = pathNode;
                SequenceScope $this$yieldIfNeeded$iv = $this$iterator;
                path$iv3 = node$iv2.getPath();
                if (node$iv2.getParent() != null) {
                    PathsKt.checkFileName(path$iv3);
                }
                $result5 = $result2;
                LinkOption[] linkOptions4 = this_$iv2.getLinkOptions();
                Object obj3 = obj;
                LinkOption[] linkOptionArr4 = (LinkOption[]) Arrays.copyOf(linkOptions4, linkOptions4.length);
                if (Files.isDirectory(path$iv3, (LinkOption[]) Arrays.copyOf(linkOptionArr4, linkOptionArr4.length))) {
                    createsCycle2 = PathTreeWalkKt.createsCycle(node$iv2);
                    if (createsCycle2) {
                        throw new FileSystemLoopException(path$iv3.toString());
                    }
                    if (this_$iv2.getIncludeDirectories()) {
                        pathTreeWalk$dfsIterator$1.L$0 = $this$iterator;
                        pathTreeWalk$dfsIterator$1.L$1 = stack2;
                        pathTreeWalk$dfsIterator$1.L$2 = entriesReader2;
                        pathTreeWalk$dfsIterator$1.L$3 = SpillingKt.nullOutSpilledVariable(startNode2);
                        pathTreeWalk$dfsIterator$1.L$4 = SpillingKt.nullOutSpilledVariable(topNode);
                        pathTreeWalk$dfsIterator$1.L$5 = SpillingKt.nullOutSpilledVariable(topIterator);
                        pathTreeWalk$dfsIterator$1.L$6 = pathNode;
                        pathTreeWalk$dfsIterator$1.L$7 = this_$iv2;
                        pathTreeWalk$dfsIterator$1.L$8 = SpillingKt.nullOutSpilledVariable($this$yieldIfNeeded$iv);
                        pathTreeWalk$dfsIterator$1.L$9 = node$iv2;
                        pathTreeWalk$dfsIterator$1.L$10 = entriesReader$iv2;
                        pathTreeWalk$dfsIterator$1.L$11 = path$iv3;
                        pathTreeWalk$dfsIterator$1.I$0 = 0;
                        pathTreeWalk$dfsIterator$1.label = 3;
                        if ($this$yieldIfNeeded$iv.yield(path$iv3, pathTreeWalk$dfsIterator$1) == obj3) {
                            return obj3;
                        }
                        $this$iterator2 = $this$iterator;
                        coroutine_suspended = obj3;
                        $i$f$yieldIfNeeded = 0;
                        stack3 = stack2;
                        path$iv2 = path$iv3;
                        $result3 = $result5;
                        SequenceScope sequenceScope42 = $this$iterator2;
                        $result4 = $result3;
                        path$iv3 = path$iv2;
                        stack2 = stack3;
                        obj = coroutine_suspended;
                        $this$iterator = sequenceScope42;
                        Object $result62 = $result4;
                        LinkOption[] linkOptions32 = this_$iv2.getLinkOptions();
                        SequenceScope $this$iterator32 = $this$iterator;
                        linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions32, linkOptions32.length);
                        if (Files.isDirectory(path$iv3, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                        }
                        $result2 = $result62;
                        $this$iterator = $this$iterator32;
                        while (!stack2.isEmpty()) {
                        }
                    } else {
                        obj = obj3;
                        $result4 = $result5;
                        Object $result622 = $result4;
                        LinkOption[] linkOptions322 = this_$iv2.getLinkOptions();
                        SequenceScope $this$iterator322 = $this$iterator;
                        linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions322, linkOptions322.length);
                        if (Files.isDirectory(path$iv3, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                        }
                        $result2 = $result622;
                        $this$iterator = $this$iterator322;
                        while (!stack2.isEmpty()) {
                        }
                    }
                } else if (Files.exists(path$iv3, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                    pathTreeWalk$dfsIterator$1.L$0 = $this$iterator;
                    pathTreeWalk$dfsIterator$1.L$1 = stack2;
                    pathTreeWalk$dfsIterator$1.L$2 = entriesReader2;
                    pathTreeWalk$dfsIterator$1.L$3 = SpillingKt.nullOutSpilledVariable(startNode2);
                    pathTreeWalk$dfsIterator$1.L$4 = SpillingKt.nullOutSpilledVariable(topNode);
                    pathTreeWalk$dfsIterator$1.L$5 = SpillingKt.nullOutSpilledVariable(topIterator);
                    pathTreeWalk$dfsIterator$1.L$6 = SpillingKt.nullOutSpilledVariable(pathNode);
                    pathTreeWalk$dfsIterator$1.L$7 = SpillingKt.nullOutSpilledVariable(this_$iv2);
                    pathTreeWalk$dfsIterator$1.L$8 = SpillingKt.nullOutSpilledVariable($this$yieldIfNeeded$iv);
                    pathTreeWalk$dfsIterator$1.L$9 = SpillingKt.nullOutSpilledVariable(node$iv2);
                    pathTreeWalk$dfsIterator$1.L$10 = SpillingKt.nullOutSpilledVariable(entriesReader$iv2);
                    pathTreeWalk$dfsIterator$1.L$11 = SpillingKt.nullOutSpilledVariable(path$iv3);
                    pathTreeWalk$dfsIterator$1.I$0 = 0;
                    pathTreeWalk$dfsIterator$1.label = 4;
                    if ($this$yieldIfNeeded$iv.yield(path$iv3, pathTreeWalk$dfsIterator$1) == obj3) {
                        return obj3;
                    }
                    $result2 = $result5;
                    obj2 = obj3;
                    pathTreeWalk$dfsIterator$12 = pathTreeWalk$dfsIterator$1;
                    obj = obj2;
                    pathTreeWalk$dfsIterator$1 = pathTreeWalk$dfsIterator$12;
                    while (!stack2.isEmpty()) {
                    }
                } else {
                    obj = obj3;
                }
            } else {
                $result5 = $result2;
                stack2.removeLast();
            }
            $result2 = $result5;
        }
        return Unit.INSTANCE;
    }
}