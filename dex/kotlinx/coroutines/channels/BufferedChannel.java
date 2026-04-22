package kotlinx.coroutines.channels;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;

/* compiled from: BufferedChannel.kt */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b$\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0004à\u0001á\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b¢\u0006\u0002\u0010\tJ\u0010\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u0010H\u0002J\u0006\u0010R\u001a\u00020\u0007J\u0010\u0010R\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016J\u0016\u0010R\u001a\u00020\u00072\u000e\u0010S\u001a\n\u0018\u00010Tj\u0004\u0018\u0001`UJ\u0017\u0010V\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0010¢\u0006\u0002\bWJ\u001e\u0010X\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010K\u001a\u00020\u0010H\u0002J\u0006\u0010Z\u001a\u00020\u0007J\u0012\u0010[\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001a\u0010]\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u00162\u0006\u0010R\u001a\u00020\u001cH\u0014J\u0010\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0010H\u0002J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010_\u001a\u00020\u0010H\u0002J\b\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0010H\u0004J\b\u0010d\u001a\u00020\u0007H\u0002J.\u0010e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010h\u001a\u00020\u0010H\u0002J&\u0010i\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J&\u0010j\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\r\u0010k\u001a\u00020\u001cH\u0000¢\u0006\u0002\blJ\u0012\u0010m\u001a\u00020\u00072\b\b\u0002\u0010n\u001a\u00020\u0010H\u0002J\b\u0010o\u001a\u00020\u0007H\u0002J-\u0010p\u001a\u00020\u00072#\u0010q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J&\u0010r\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0010H\u0002J\u0018\u0010v\u001a\u00020\u001c2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000f\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00000yH\u0096\u0002J\u0016\u0010z\u001a\u00020\u00102\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010{\u001a\u00020\u0007H\u0002J\b\u0010|\u001a\u00020\u0007H\u0002J\b\u0010}\u001a\u00020\u0007H\u0002J\u001e\u0010~\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010\u007f\u001a\u00020\u0007H\u0014J\u001f\u0010\u0080\u0001\u001a\u00020\u00072\u0014\u0010\u0081\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0\u0082\u0001H\u0002J\u0019\u0010\u0083\u0001\u001a\u00020\u00072\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0082\u0001H\u0002J\u0015\u0010\u0084\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002J$\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u00002\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002¢\u0006\u0003\u0010\u0087\u0001J\u0019\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0082@¢\u0006\u0003\u0010\u0089\u0001J(\u0010\u008a\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0082\u0001H\u0002¢\u0006\u0003\u0010\u008b\u0001J\t\u0010\u008c\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u008d\u0001\u001a\u00020\u0007H\u0014J!\u0010\u008e\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0091\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0092\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0093\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0094\u0001\u001a\u00028\u0000H\u0096@¢\u0006\u0003\u0010\u0095\u0001J\u001f\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0097\u0001\u0010\u0095\u0001J>\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u008c\u0002\u0010\u009c\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0001\u0010\u009d\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2$\u0010\u009f\u0001\u001a\u001f\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0005\u0012\u0003H\u009d\u00010\u00062V\u0010 \u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0099\u0001\u0012\u0005\u0012\u0003H\u009d\u0001082\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012X\b\u0002\u0010¥\u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0099\u0001\u0012\u0005\u0012\u0003H\u009d\u000108H\u0082\b¢\u0006\u0003\u0010¦\u0001Jh\u0010§\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\b\u0010\u009e\u0001\u001a\u00030¨\u00012#\u0010\u009f\u0001\u001a\u001e\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\u0082\bJ/\u0010©\u0001\u001a\u00028\u00002\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0082@¢\u0006\u0003\u0010\u009b\u0001J \u0010ª\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\fH\u0002J \u0010«\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\fH\u0014J\u0017\u0010¬\u0001\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u0019\u0010\u00ad\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0096@¢\u0006\u0003\u0010\u0089\u0001J\u001c\u0010®\u0001\u001a\u00020\u001c2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0090@¢\u0006\u0006\b¯\u0001\u0010\u0089\u0001J\u0082\u0002\u0010°\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0001\u0010\u009d\u00012\u0007\u0010\u0086\u0001\u001a\u00028\u00002\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u000f\u0010±\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012A\u0010 \u0001\u001a<\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0005\u0012\u0003H\u009d\u00010²\u00012\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012o\b\u0002\u0010¥\u0001\u001ah\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(´\u0001\u0012\u0005\u0012\u0003H\u009d\u00010³\u0001H\u0082\b¢\u0006\u0003\u0010µ\u0001Jb\u0010¶\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\b\u0010\u009e\u0001\u001a\u00030¨\u00012\u000e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u00012\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\u0082\b¢\u0006\u0003\u0010·\u0001J8\u0010¸\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u0010H\u0082@¢\u0006\u0003\u0010¹\u0001J\u000f\u0010º\u0001\u001a\u00020\u001cH\u0010¢\u0006\u0003\b»\u0001J\u0012\u0010º\u0001\u001a\u00020\u001c2\u0007\u0010¼\u0001\u001a\u00020\u0010H\u0003J\n\u0010½\u0001\u001a\u00030¾\u0001H\u0016J\u0010\u0010¿\u0001\u001a\u00030¾\u0001H\u0000¢\u0006\u0003\bÀ\u0001J\u001e\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J'\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070,2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J'\u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070,2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÈ\u0001\u0010Æ\u0001J(\u0010É\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010Ê\u0001\u001a\u00020\u0010H\u0002J(\u0010Ë\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010Ê\u0001\u001a\u00020\u0010H\u0002J5\u0010Ì\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\fH\u0002J5\u0010Í\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\fH\u0002JK\u0010Î\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ï\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Ð\u0001JK\u0010Ñ\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ï\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Ð\u0001J\u0012\u0010Ò\u0001\u001a\u00020\u00072\u0007\u0010Ó\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010Ô\u0001\u001a\u00020\u00072\u0007\u0010Ó\u0001\u001a\u00020\u0010H\u0002J\u0017\u0010Õ\u0001\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0010H\u0000¢\u0006\u0003\bÖ\u0001J$\u0010×\u0001\u001a\u00020\u0007*\u00030¨\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J$\u0010Ø\u0001\u001a\u00020\u0007*\u00030¨\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J\u000e\u0010Ù\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u000e\u0010Ú\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u0017\u0010Û\u0001\u001a\u00020\u0007*\u00030¨\u00012\u0007\u0010Ü\u0001\u001a\u00020\u001cH\u0002J\u001c\u0010Ý\u0001\u001a\u00020\u001c*\u00020\f2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010Þ\u0001J#\u0010ß\u0001\u001a\u00020\u001c*\u00020\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\t\u0010\u001a\u001a\u00020\u000eX\u0082\u0004R\u001a\u0010\u001b\u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001fR\u001a\u0010 \u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001e\u001a\u0004\b \u0010\u001fR\u0014\u0010\"\u001a\u00020\u001c8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001e\u001a\u0004\b#\u0010\u001fR\u0014\u0010%\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'8VX\u0096\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010*R&\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0'8VX\u0096\u0004¢\u0006\f\u0012\u0004\b-\u0010\u001e\u001a\u0004\b.\u0010*R\"\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000'8VX\u0096\u0004¢\u0006\f\u0012\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010*R,\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000038VX\u0096\u0004¢\u0006\f\u0012\u0004\b4\u0010\u001e\u001a\u0004\b5\u00106R*\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000Ru\u00107\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u000309¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u000108j\u0004\u0018\u0001`?X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b@\u0010\u001eR\u0014\u0010A\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0018R\u0015\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\t\u0010D\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010E\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0012R\u0014\u0010G\u001a\u00020\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0018R\u0015\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\t\u0010J\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010K\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0012R\u0018\u0010M\u001a\u00020\u001c*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0018\u0010O\u001a\u00020\u001c*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010N\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006â\u0001"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "capacity", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlin/jvm/functions/Function1;)V", "_closeCause", "Lkotlinx/atomicfu/AtomicRef;", "", "bufferEnd", "Lkotlinx/atomicfu/AtomicLong;", "bufferEndCounter", "", "getBufferEndCounter", "()J", "bufferEndSegment", "Lkotlinx/coroutines/channels/ChannelSegment;", "closeCause", "", "getCloseCause", "()Ljava/lang/Throwable;", "closeHandler", "completedExpandBuffersAndPauseFlag", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isClosedForSend", "isClosedForSend$annotations", "isConflatedDropOldest", "isEmpty", "isEmpty$annotations", "isRendezvousOrUnlimited", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching$annotations", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onUndeliveredElementReceiveCancellationConstructor", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", "name", "select", "param", "internalResult", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "receiveException", "getReceiveException", "receiveSegment", "receivers", "receiversCounter", "getReceiversCounter$kotlinx_coroutines_core", "sendException", "getSendException", "sendSegment", "sendersAndCloseStatus", "sendersCounter", "getSendersCounter$kotlinx_coroutines_core", "isClosedForReceive0", "(J)Z", "isClosedForSend0", "bufferOrRendezvousSend", "curSenders", "cancel", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelSuspendedReceiveRequests", "lastSegment", "checkSegmentStructureInvariants", "close", "closeLinkedList", "closeOrCancelImpl", "completeCancel", "sendersCur", "completeClose", "completeCloseOrCancel", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "globalCellIndex", "expandBuffer", "findSegmentBufferEnd", "id", "startFrom", "currentBufferEndCounter", "findSegmentReceive", "findSegmentSend", "hasElements", "hasElements$kotlinx_coroutines_core", "incCompletedExpandBufferAttempts", "nAttempts", "invokeCloseHandler", "invokeOnClose", "handler", "isCellNonEmpty", "segment", "index", "globalIndex", "isClosed", "sendersAndCloseStatusCur", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "markAllEmptyCellsAsClosed", "markCancellationStarted", "markCancelled", "markClosed", "moveSegmentBufferEndToSpecifiedOrLast", "onClosedIdempotent", "onClosedReceiveCatchingOnNoWaiterSuspend", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "onClosedReceiveOnNoWaiterSuspend", "onClosedSelectOnReceive", "onClosedSelectOnSend", "element", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "onClosedSend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSendOnNoWaiterSuspend", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "onReceiveDequeued", "onReceiveEnqueued", "processResultSelectReceive", "ignoredParam", "selectResult", "processResultSelectReceiveCatching", "processResultSelectReceiveOrNull", "processResultSelectSend", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveCatchingOnNoWaiterSuspend", "r", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveImpl", "R", "waiter", "onElementRetrieved", "onSuspend", "segm", "i", "onClosed", "Lkotlin/Function0;", "onNoWaiterSuspend", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "receiveImplOnNoWaiter", "Lkotlinx/coroutines/Waiter;", "receiveOnNoWaiterSuspend", "registerSelectForReceive", "registerSelectForSend", "removeUnprocessedElements", "send", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "sendImpl", "onRendezvousOrBuffered", "Lkotlin/Function2;", "Lkotlin/Function4;", "s", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "sendOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "curSendersAndCloseStatus", "toString", "", "toStringDebug", "toStringDebug$kotlinx_coroutines_core", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "trySend", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySendDropOldest", "trySendDropOldest-JP2dKIU", "updateCellExpandBuffer", "b", "updateCellExpandBufferSlow", "updateCellReceive", "updateCellReceiveSlow", "updateCellSend", "closed", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "updateReceiversCounterIfLower", "value", "updateSendersCounterIfLower", "waitExpandBufferCompletion", "waitExpandBufferCompletion$kotlinx_coroutines_core", "prepareReceiverForSuspension", "prepareSenderForSuspension", "resumeReceiverOnClosedChannel", "resumeSenderOnCancelledChannel", "resumeWaiterOnClosedChannel", "receiver", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "tryResumeSender", "BufferedChannelIterator", "SendBroadcast", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class BufferedChannel<E> implements Channel<E> {
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private final int capacity;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    public final Function1<E, Unit> onUndeliveredElement;
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onUndeliveredElementReceiveCancellationConstructor;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;
    private static final /* synthetic */ AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater receivers$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater bufferEnd$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater sendSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater receiveSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closeCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater closeHandler$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");

    private final /* synthetic */ Object getAndUpdate$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, obj, obj2, function1.invoke(obj2)));
        return obj2;
    }

    private final /* synthetic */ long getBufferEnd$volatile() {
        return this.bufferEnd$volatile;
    }

    private final /* synthetic */ Object getBufferEndSegment$volatile() {
        return this.bufferEndSegment$volatile;
    }

    private final /* synthetic */ Object getCloseHandler$volatile() {
        return this.closeHandler$volatile;
    }

    private final /* synthetic */ long getCompletedExpandBuffersAndPauseFlag$volatile() {
        return this.completedExpandBuffersAndPauseFlag$volatile;
    }

    public static /* synthetic */ void getOnReceive$annotations() {
    }

    public static /* synthetic */ void getOnReceiveCatching$annotations() {
    }

    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private static /* synthetic */ void getOnUndeliveredElementReceiveCancellationConstructor$annotations() {
    }

    private final /* synthetic */ Object getReceiveSegment$volatile() {
        return this.receiveSegment$volatile;
    }

    private final /* synthetic */ long getReceivers$volatile() {
        return this.receivers$volatile;
    }

    private final /* synthetic */ Object getSendSegment$volatile() {
        return this.sendSegment$volatile;
    }

    private final /* synthetic */ long getSendersAndCloseStatus$volatile() {
        return this.sendersAndCloseStatus$volatile;
    }

    private final /* synthetic */ Object get_closeCause$volatile() {
        return this._closeCause$volatile;
    }

    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    public static /* synthetic */ void isEmpty$annotations() {
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function1) {
        while (true) {
            function1.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final /* synthetic */ void setBufferEnd$volatile(long j) {
        this.bufferEnd$volatile = j;
    }

    private final /* synthetic */ void setBufferEndSegment$volatile(Object obj) {
        this.bufferEndSegment$volatile = obj;
    }

    private final /* synthetic */ void setCloseHandler$volatile(Object obj) {
        this.closeHandler$volatile = obj;
    }

    private final /* synthetic */ void setCompletedExpandBuffersAndPauseFlag$volatile(long j) {
        this.completedExpandBuffersAndPauseFlag$volatile = j;
    }

    private final /* synthetic */ void setReceiveSegment$volatile(Object obj) {
        this.receiveSegment$volatile = obj;
    }

    private final /* synthetic */ void setReceivers$volatile(long j) {
        this.receivers$volatile = j;
    }

    private final /* synthetic */ void setSendSegment$volatile(Object obj) {
        this.sendSegment$volatile = obj;
    }

    private final /* synthetic */ void setSendersAndCloseStatus$volatile(long j) {
        this.sendersAndCloseStatus$volatile = j;
    }

    private final /* synthetic */ void set_closeCause$volatile(Object obj) {
        this._closeCause$volatile = obj;
    }

    private final /* synthetic */ void update$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1) {
        long j;
        do {
            j = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j, function1.invoke(Long.valueOf(j)).longValue()));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation<? super E> continuation) {
        return receive$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU  reason: not valid java name */
    public Object mo1403receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        return m1401receiveCatchingJP2dKIU$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e, continuation);
    }

    public Object sendBroadcast$kotlinx_coroutines_core(E e, Continuation<? super Boolean> continuation) {
        return sendBroadcast$suspendImpl(this, e, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BufferedChannel(int capacity, Function1<? super E, Unit> function1) {
        ChannelSegment channelSegment;
        this.capacity = capacity;
        this.onUndeliveredElement = function1;
        if (!(this.capacity >= 0)) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + this.capacity + ", should be >=0").toString());
        }
        this.bufferEnd$volatile = BufferedChannelKt.access$initialBufferEnd(this.capacity);
        this.completedExpandBuffersAndPauseFlag$volatile = getBufferEndCounter();
        ChannelSegment firstSegment = new ChannelSegment(0L, null, this, 3);
        this.sendSegment$volatile = firstSegment;
        this.receiveSegment$volatile = firstSegment;
        if (isRendezvousOrUnlimited()) {
            channelSegment = BufferedChannelKt.access$getNULL_SEGMENT$p();
            Intrinsics.checkNotNull(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        } else {
            channelSegment = firstSegment;
        }
        this.bufferEndSegment$volatile = channelSegment;
        this.onUndeliveredElementReceiveCancellationConstructor = this.onUndeliveredElement != null ? (Function3) new Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>(this) { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1
            final /* synthetic */ BufferedChannel<E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Function1<Throwable, Unit> invoke(final SelectInstance<?> selectInstance, Object obj, final Object element) {
                final BufferedChannel<E> bufferedChannel = this.this$0;
                return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        if (element != BufferedChannelKt.getCHANNEL_CLOSED()) {
                            OnUndeliveredElementKt.callUndeliveredElement(bufferedChannel.onUndeliveredElement, element, selectInstance.getContext());
                        }
                    }
                };
            }
        } : null;
        this._closeCause$volatile = BufferedChannelKt.access$getNO_CLOSE_CAUSE$p();
    }

    public /* synthetic */ BufferedChannel(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : function1);
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater access$getReceiveSegment$volatile$FU() {
        return receiveSegment$volatile$FU;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater access$getReceivers$volatile$FU() {
        return receivers$volatile$FU;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return Channel.DefaultImpls.offer(this, e);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public E poll() {
        return (E) Channel.DefaultImpls.poll(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public Object receiveOrNull(Continuation<? super E> continuation) {
        return Channel.DefaultImpls.receiveOrNull(this, continuation);
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        long $this$sendersCounter$iv = sendersAndCloseStatus$volatile$FU.get(this);
        return $this$sendersCounter$iv & 1152921504606846975L;
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$volatile$FU.get(this);
    }

    private final long getBufferEndCounter() {
        return bufferEnd$volatile$FU.get(this);
    }

    private final boolean isRendezvousOrUnlimited() {
        long it = getBufferEndCounter();
        return it == 0 || it == LongCompanionObject.MAX_VALUE;
    }

    static /* synthetic */ <E> Object send$suspendImpl(BufferedChannel<E> bufferedChannel, E e, Continuation<? super Unit> continuation) {
        ChannelSegment segment$iv;
        ChannelSegment segment$iv2 = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long sendersAndCloseStatusCur$iv = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long $this$sendersCounter$iv$iv = sendersAndCloseStatusCur$iv & 1152921504606846975L;
            boolean closed$iv = bufferedChannel.isClosedForSend0(sendersAndCloseStatusCur$iv);
            long id$iv = $this$sendersCounter$iv$iv / BufferedChannelKt.SEGMENT_SIZE;
            int i$iv = (int) ($this$sendersCounter$iv$iv % BufferedChannelKt.SEGMENT_SIZE);
            if (segment$iv2.id != id$iv) {
                ChannelSegment segment$iv3 = bufferedChannel.findSegmentSend(id$iv, segment$iv2);
                if (segment$iv3 != null) {
                    segment$iv = segment$iv3;
                } else if (closed$iv) {
                    Object onClosedSend = bufferedChannel.onClosedSend(e, continuation);
                    if (onClosedSend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return onClosedSend;
                    }
                }
            } else {
                segment$iv = segment$iv2;
            }
            switch (bufferedChannel.updateCellSend(segment$iv, i$iv, e, $this$sendersCounter$iv$iv, null, closed$iv)) {
                case 0:
                    segment$iv.cleanPrev();
                    break;
                case 2:
                    if (!closed$iv) {
                        if (DebugKt.getASSERTIONS_ENABLED()) {
                            throw new AssertionError();
                        }
                    } else {
                        segment$iv.onSlotCleaned();
                        Object onClosedSend2 = bufferedChannel.onClosedSend(e, continuation);
                        if (onClosedSend2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            return onClosedSend2;
                        }
                    }
                    break;
                case 3:
                    ChannelSegment segm = segment$iv;
                    Object sendOnNoWaiterSuspend = bufferedChannel.sendOnNoWaiterSuspend(segm, i$iv, e, $this$sendersCounter$iv$iv, continuation);
                    if (sendOnNoWaiterSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return sendOnNoWaiterSuspend;
                    }
                    break;
                case 4:
                    if ($this$sendersCounter$iv$iv < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                        segment$iv.cleanPrev();
                    }
                    Object onClosedSend3 = bufferedChannel.onClosedSend(e, continuation);
                    if (onClosedSend3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return onClosedSend3;
                    }
                    break;
                case 5:
                    segment$iv.cleanPrev();
                    break;
            }
            segment$iv2 = segment$iv;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object onClosedSend(E e, Continuation<? super Unit> continuation) {
        Throwable th;
        UndeliveredElementException it;
        UndeliveredElementException undeliveredElementException;
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl continuation2 = cancellable$iv;
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null && (it = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, null, 2, null)) != null) {
            ExceptionsKt.addSuppressed(it, getSendException());
            CancellableContinuationImpl $this$resumeWithStackTrace$iv = continuation2;
            Result.Companion companion = Result.Companion;
            if (DebugKt.getRECOVER_STACK_TRACES() && ($this$resumeWithStackTrace$iv instanceof CoroutineStackFrame)) {
                undeliveredElementException = StackTraceRecoveryKt.recoverFromStackFrame(it, $this$resumeWithStackTrace$iv);
            } else {
                undeliveredElementException = it;
            }
            $this$resumeWithStackTrace$iv.resumeWith(Result.constructor-impl(ResultKt.createFailure(undeliveredElementException)));
        } else {
            CancellableContinuationImpl $this$resumeWithStackTrace$iv2 = continuation2;
            Throwable exception$iv = getSendException();
            Result.Companion companion2 = Result.Companion;
            if (DebugKt.getRECOVER_STACK_TRACES() && ($this$resumeWithStackTrace$iv2 instanceof CoroutineStackFrame)) {
                th = StackTraceRecoveryKt.recoverFromStackFrame(exception$iv, $this$resumeWithStackTrace$iv2);
            } else {
                th = exception$iv;
            }
            $this$resumeWithStackTrace$iv2.resumeWith(Result.constructor-impl(ResultKt.createFailure(th)));
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int index, E e, long s, Continuation<? super Unit> continuation) {
        ChannelSegment segment$iv$iv;
        ChannelSegment segment$iv$iv2;
        Continuation<? super Unit> continuation2 = continuation;
        CancellableContinuationImpl cancellable$iv = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation2));
        try {
            try {
                try {
                    try {
                        switch (updateCellSend(channelSegment, index, e, s, cancellable$iv, false)) {
                            case 0:
                                channelSegment.cleanPrev();
                                Result.Companion companion = Result.Companion;
                                cancellable$iv.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                                break;
                            case 1:
                                Result.Companion companion2 = Result.Companion;
                                cancellable$iv.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                                break;
                            case 2:
                                prepareSenderForSuspension(cancellable$iv, channelSegment, index);
                                break;
                            case 3:
                            default:
                                throw new IllegalStateException("unexpected".toString());
                            case 4:
                                if (s < getReceiversCounter$kotlinx_coroutines_core()) {
                                    channelSegment.cleanPrev();
                                }
                                onClosedSendOnNoWaiterSuspend(e, cancellable$iv);
                                break;
                            case 5:
                                try {
                                    channelSegment.cleanPrev();
                                    ChannelSegment segment$iv$iv3 = (ChannelSegment) sendSegment$volatile$FU.get(this);
                                    while (true) {
                                        long $this$sendersCounter$iv$iv$iv = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
                                        long $this$sendersCounter$iv$iv$iv2 = $this$sendersCounter$iv$iv$iv & 1152921504606846975L;
                                        boolean closed$iv$iv = isClosedForSend0($this$sendersCounter$iv$iv$iv);
                                        long id$iv$iv = $this$sendersCounter$iv$iv$iv2 / BufferedChannelKt.SEGMENT_SIZE;
                                        int i$iv$iv = (int) ($this$sendersCounter$iv$iv$iv2 % BufferedChannelKt.SEGMENT_SIZE);
                                        if (segment$iv$iv3.id != id$iv$iv) {
                                            try {
                                                ChannelSegment segment$iv$iv4 = findSegmentSend(id$iv$iv, segment$iv$iv3);
                                                if (segment$iv$iv4 != null) {
                                                    segment$iv$iv = segment$iv$iv4;
                                                } else if (closed$iv$iv) {
                                                    onClosedSendOnNoWaiterSuspend(e, cancellable$iv);
                                                    break;
                                                }
                                            } catch (Throwable th) {
                                                e$iv = th;
                                                cancellable$iv.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                                                throw e$iv;
                                            }
                                        } else {
                                            segment$iv$iv = segment$iv$iv3;
                                        }
                                        ChannelSegment segment$iv$iv5 = segment$iv$iv;
                                        Continuation<? super Unit> continuation3 = continuation2;
                                        switch (updateCellSend(segment$iv$iv, i$iv$iv, e, $this$sendersCounter$iv$iv$iv2, cancellable$iv, closed$iv$iv)) {
                                            case 0:
                                                segment$iv$iv5.cleanPrev();
                                                Result.Companion companion3 = Result.Companion;
                                                cancellable$iv.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                                                break;
                                            case 1:
                                                Result.Companion companion4 = Result.Companion;
                                                cancellable$iv.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                                                break;
                                            case 2:
                                                if (!closed$iv$iv) {
                                                    CancellableContinuationImpl cancellableContinuationImpl = cancellable$iv instanceof Waiter ? cancellable$iv : null;
                                                    if (cancellableContinuationImpl != null) {
                                                        prepareSenderForSuspension(cancellableContinuationImpl, segment$iv$iv5, i$iv$iv);
                                                    }
                                                    break;
                                                } else {
                                                    segment$iv$iv5.onSlotCleaned();
                                                    onClosedSendOnNoWaiterSuspend(e, cancellable$iv);
                                                    break;
                                                }
                                            case 3:
                                                throw new IllegalStateException("unexpected".toString());
                                            case 4:
                                                if ($this$sendersCounter$iv$iv$iv2 < getReceiversCounter$kotlinx_coroutines_core()) {
                                                    segment$iv$iv5.cleanPrev();
                                                }
                                                onClosedSendOnNoWaiterSuspend(e, cancellable$iv);
                                                break;
                                            case 5:
                                                segment$iv$iv5.cleanPrev();
                                                segment$iv$iv2 = segment$iv$iv5;
                                                break;
                                            default:
                                                segment$iv$iv2 = segment$iv$iv5;
                                                break;
                                        }
                                        segment$iv$iv3 = segment$iv$iv2;
                                        continuation2 = continuation3;
                                    }
                                } catch (Throwable th2) {
                                    e$iv = th2;
                                }
                        }
                        Object result = cancellable$iv.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(continuation);
                        }
                        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
                    } catch (Throwable th3) {
                        e$iv = th3;
                    }
                } catch (Throwable th4) {
                    e$iv = th4;
                }
            } catch (Throwable th5) {
                e$iv = th5;
            }
        } catch (Throwable th6) {
            e$iv = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareSenderForSuspension(Waiter $this$prepareSenderForSuspension, ChannelSegment<E> channelSegment, int index) {
        $this$prepareSenderForSuspension.invokeOnCancellation(channelSegment, BufferedChannelKt.SEGMENT_SIZE + index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedSendOnNoWaiterSuspend(E e, CancellableContinuation<? super Unit> cancellableContinuation) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, e, cancellableContinuation.getContext());
        }
        CancellableContinuation<? super Unit> cancellableContinuation2 = cancellableContinuation;
        Throwable exception$iv = getSendException();
        if (DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuation instanceof CoroutineStackFrame)) {
            exception$iv = StackTraceRecoveryKt.recoverFromStackFrame(exception$iv, (CoroutineStackFrame) cancellableContinuation);
        }
        Result.Companion companion = Result.Companion;
        cancellableContinuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(exception$iv)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo1399trySendJP2dKIU(E e) {
        ChannelSegment segment$iv;
        ChannelSegment segment$iv2;
        if (shouldSendSuspend(sendersAndCloseStatus$volatile$FU.get(this))) {
            return ChannelResult.Companion.m1424failurePtdJZtk();
        }
        Object waiter$iv = BufferedChannelKt.access$getINTERRUPTED_SEND$p();
        int $i$f$sendImpl = 0;
        ChannelSegment segment$iv3 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long sendersAndCloseStatusCur$iv = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long $this$sendersCounter$iv$iv = sendersAndCloseStatusCur$iv & 1152921504606846975L;
            boolean closed$iv = isClosedForSend0(sendersAndCloseStatusCur$iv);
            long id$iv = $this$sendersCounter$iv$iv / BufferedChannelKt.SEGMENT_SIZE;
            int i$iv = (int) ($this$sendersCounter$iv$iv % BufferedChannelKt.SEGMENT_SIZE);
            if (segment$iv3.id != id$iv) {
                ChannelSegment segment$iv4 = findSegmentSend(id$iv, segment$iv3);
                if (segment$iv4 != null) {
                    segment$iv = segment$iv4;
                } else if (closed$iv) {
                    return ChannelResult.Companion.m1423closedJP2dKIU(getSendException());
                }
            } else {
                segment$iv = segment$iv3;
            }
            ChannelSegment segment$iv5 = segment$iv;
            int $i$f$sendImpl2 = $i$f$sendImpl;
            switch (updateCellSend(segment$iv, i$iv, e, $this$sendersCounter$iv$iv, waiter$iv, closed$iv)) {
                case 0:
                    segment$iv5.cleanPrev();
                    return ChannelResult.Companion.m1425successJP2dKIU(Unit.INSTANCE);
                case 1:
                    return ChannelResult.Companion.m1425successJP2dKIU(Unit.INSTANCE);
                case 2:
                    if (closed$iv) {
                        segment$iv5.onSlotCleaned();
                        return ChannelResult.Companion.m1423closedJP2dKIU(getSendException());
                    }
                    Waiter waiter = waiter$iv instanceof Waiter ? (Waiter) waiter$iv : null;
                    if (waiter != null) {
                        segment$iv2 = segment$iv5;
                        prepareSenderForSuspension(waiter, segment$iv2, i$iv);
                    } else {
                        segment$iv2 = segment$iv5;
                    }
                    ChannelSegment segm = segment$iv2;
                    segm.onSlotCleaned();
                    return ChannelResult.Companion.m1424failurePtdJZtk();
                case 3:
                    throw new IllegalStateException("unexpected".toString());
                case 4:
                    if ($this$sendersCounter$iv$iv < getReceiversCounter$kotlinx_coroutines_core()) {
                        segment$iv5.cleanPrev();
                    }
                    return ChannelResult.Companion.m1423closedJP2dKIU(getSendException());
                case 5:
                    segment$iv5.cleanPrev();
                    break;
            }
            segment$iv3 = segment$iv5;
            $i$f$sendImpl = $i$f$sendImpl2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ <E> Object sendBroadcast$suspendImpl(BufferedChannel<E> bufferedChannel, E e, Continuation<? super Boolean> continuation) {
        CancellableContinuationImpl cancellable$iv;
        ChannelSegment segment$iv;
        boolean z = false;
        CancellableContinuationImpl cancellable$iv2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv2.initCancellability();
        CancellableContinuation cont = cancellable$iv2;
        if (!(bufferedChannel.onUndeliveredElement == null)) {
            throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`".toString());
        }
        Object waiter$iv = new SendBroadcast(cont);
        ChannelSegment segment$iv2 = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long sendersAndCloseStatusCur$iv = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long $this$sendersCounter$iv$iv = sendersAndCloseStatusCur$iv & 1152921504606846975L;
            boolean closed$iv = bufferedChannel.isClosedForSend0(sendersAndCloseStatusCur$iv);
            long id$iv = $this$sendersCounter$iv$iv / BufferedChannelKt.SEGMENT_SIZE;
            cancellable$iv = cancellable$iv2;
            int i$iv = (int) ($this$sendersCounter$iv$iv % BufferedChannelKt.SEGMENT_SIZE);
            if (segment$iv2.id != id$iv) {
                ChannelSegment segment$iv3 = bufferedChannel.findSegmentSend(id$iv, segment$iv2);
                if (segment$iv3 != null) {
                    segment$iv = segment$iv3;
                } else if (closed$iv) {
                    Result.Companion companion = Result.Companion;
                    cont.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
                } else {
                    cancellable$iv2 = cancellable$iv;
                }
            } else {
                segment$iv = segment$iv2;
            }
            boolean z2 = z;
            Object waiter$iv2 = waiter$iv;
            switch (bufferedChannel.updateCellSend(segment$iv, i$iv, e, $this$sendersCounter$iv$iv, waiter$iv, closed$iv)) {
                case 0:
                    segment$iv.cleanPrev();
                    Result.Companion companion2 = Result.Companion;
                    cont.resumeWith(Result.constructor-impl(Boxing.boxBoolean(true)));
                    break;
                case 1:
                    Result.Companion companion3 = Result.Companion;
                    cont.resumeWith(Result.constructor-impl(Boxing.boxBoolean(true)));
                    break;
                case 2:
                    if (closed$iv) {
                        segment$iv.onSlotCleaned();
                        Result.Companion companion4 = Result.Companion;
                        cont.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
                        break;
                    } else {
                        SendBroadcast sendBroadcast = waiter$iv2 instanceof Waiter ? (Waiter) waiter$iv2 : null;
                        if (sendBroadcast != null) {
                            bufferedChannel.prepareSenderForSuspension(sendBroadcast, segment$iv, i$iv);
                        }
                        break;
                    }
                case 3:
                    throw new IllegalStateException("unexpected".toString());
                case 4:
                    if ($this$sendersCounter$iv$iv < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                        segment$iv.cleanPrev();
                    }
                    Result.Companion companion5 = Result.Companion;
                    cont.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
                    break;
                case 5:
                    segment$iv.cleanPrev();
                    break;
            }
            waiter$iv = waiter$iv2;
            segment$iv2 = segment$iv;
            cancellable$iv2 = cancellable$iv;
            z = z2;
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BufferedChannel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001d\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CancellableContinuation;)V", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "invokeOnCancellation", "", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class SendBroadcast implements Waiter {
        private final /* synthetic */ CancellableContinuationImpl<Boolean> $$delegate_0;
        private final CancellableContinuation<Boolean> cont;

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(Segment<?> segment, int i) {
            this.$$delegate_0.invokeOnCancellation(segment, i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SendBroadcast(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.cont = cancellableContinuation;
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.$$delegate_0 = (CancellableContinuationImpl) cancellableContinuation;
        }

        public final CancellableContinuation<Boolean> getCont() {
            return this.cont;
        }
    }

    static /* synthetic */ Object sendImpl$default(BufferedChannel $this, Object element, Object waiter, Function0 onRendezvousOrBuffered, Function2 onSuspend, Function0 onClosed, Function4 onNoWaiterSuspend, int i, Object obj) {
        Function4 onNoWaiterSuspend2;
        ChannelSegment segment;
        int i2;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
        if ((i & 32) == 0) {
            onNoWaiterSuspend2 = onNoWaiterSuspend;
        } else {
            onNoWaiterSuspend2 = new Function4() { // from class: kotlinx.coroutines.channels.BufferedChannel$sendImpl$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                    return invoke((ChannelSegment<int>) p1, ((Number) p2).intValue(), (int) p3, ((Number) p4).longValue());
                }

                public final Void invoke(ChannelSegment<E> channelSegment, int i3, E e, long j) {
                    throw new IllegalStateException("unexpected".toString());
                }
            };
        }
        ChannelSegment segment2 = (ChannelSegment) sendSegment$volatile$FU.get($this);
        while (true) {
            long sendersAndCloseStatusCur = sendersAndCloseStatus$volatile$FU.getAndIncrement($this);
            long $this$sendersCounter$iv = sendersAndCloseStatusCur & 1152921504606846975L;
            boolean closed = $this.isClosedForSend0(sendersAndCloseStatusCur);
            long id = $this$sendersCounter$iv / BufferedChannelKt.SEGMENT_SIZE;
            int i3 = (int) ($this$sendersCounter$iv % BufferedChannelKt.SEGMENT_SIZE);
            if (segment2.id != id) {
                ChannelSegment segment3 = $this.findSegmentSend(id, segment2);
                if (segment3 != null) {
                    segment = segment3;
                } else if (closed) {
                    return onClosed.invoke();
                }
            } else {
                segment = segment2;
            }
            ChannelSegment segment4 = segment;
            switch ($this.updateCellSend(segment, i3, element, $this$sendersCounter$iv, waiter, closed)) {
                case 0:
                    segment4.cleanPrev();
                    return onRendezvousOrBuffered.invoke();
                case 1:
                    return onRendezvousOrBuffered.invoke();
                case 2:
                    if (closed) {
                        segment4.onSlotCleaned();
                        return onClosed.invoke();
                    }
                    Waiter waiter2 = waiter instanceof Waiter ? (Waiter) waiter : null;
                    if (waiter2 != null) {
                        i2 = i3;
                        $this.prepareSenderForSuspension(waiter2, segment4, i2);
                    } else {
                        i2 = i3;
                    }
                    return onSuspend.invoke(segment4, Integer.valueOf(i2));
                case 3:
                    return onNoWaiterSuspend2.invoke(segment4, Integer.valueOf(i3), element, Long.valueOf($this$sendersCounter$iv));
                case 4:
                    if ($this$sendersCounter$iv < $this.getReceiversCounter$kotlinx_coroutines_core()) {
                        segment4.cleanPrev();
                    }
                    return onClosed.invoke();
                case 5:
                    segment4.cleanPrev();
                    break;
            }
            segment2 = segment4;
        }
    }

    private final <R> R sendImpl(E e, Object waiter, Function0<? extends R> function0, Function2<? super ChannelSegment<E>, ? super Integer, ? extends R> function2, Function0<? extends R> function02, Function4<? super ChannelSegment<E>, ? super Integer, ? super E, ? super Long, ? extends R> function4) {
        ChannelSegment segment;
        int i;
        ChannelSegment segment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long sendersAndCloseStatusCur = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long $this$sendersCounter$iv = sendersAndCloseStatusCur & 1152921504606846975L;
            boolean closed = isClosedForSend0(sendersAndCloseStatusCur);
            long id = $this$sendersCounter$iv / BufferedChannelKt.SEGMENT_SIZE;
            int i2 = (int) ($this$sendersCounter$iv % BufferedChannelKt.SEGMENT_SIZE);
            if (segment2.id != id) {
                ChannelSegment segment3 = findSegmentSend(id, segment2);
                if (segment3 != null) {
                    segment = segment3;
                } else if (closed) {
                    return function02.invoke();
                }
            } else {
                segment = segment2;
            }
            ChannelSegment segment4 = segment;
            switch (updateCellSend(segment, i2, e, $this$sendersCounter$iv, waiter, closed)) {
                case 0:
                    segment4.cleanPrev();
                    return function0.invoke();
                case 1:
                    return function0.invoke();
                case 2:
                    if (closed) {
                        segment4.onSlotCleaned();
                        return function02.invoke();
                    }
                    Waiter waiter2 = waiter instanceof Waiter ? (Waiter) waiter : null;
                    if (waiter2 != null) {
                        i = i2;
                        prepareSenderForSuspension(waiter2, segment4, i);
                    } else {
                        i = i2;
                    }
                    return function2.invoke(segment4, Integer.valueOf(i));
                case 3:
                    return function4.invoke(segment4, Integer.valueOf(i2), e, Long.valueOf($this$sendersCounter$iv));
                case 4:
                    if ($this$sendersCounter$iv < getReceiversCounter$kotlinx_coroutines_core()) {
                        segment4.cleanPrev();
                    }
                    return function02.invoke();
                case 5:
                    segment4.cleanPrev();
                    break;
            }
            segment2 = segment4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
        return kotlinx.coroutines.channels.ChannelResult.Companion.m1423closedJP2dKIU(getSendException());
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d3, code lost:
        return kotlinx.coroutines.channels.ChannelResult.Companion.m1425successJP2dKIU(kotlin.Unit.INSTANCE);
     */
    /* renamed from: trySendDropOldest-JP2dKIU  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1405trySendDropOldestJP2dKIU(E e) {
        ChannelSegment segment$iv;
        ChannelSegment segment$iv2;
        Object waiter$iv = BufferedChannelKt.BUFFERED;
        int $i$f$sendImpl = 0;
        ChannelSegment segment$iv3 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long sendersAndCloseStatusCur$iv = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long $this$sendersCounter$iv$iv = sendersAndCloseStatusCur$iv & 1152921504606846975L;
            boolean closed$iv = isClosedForSend0(sendersAndCloseStatusCur$iv);
            long id$iv = $this$sendersCounter$iv$iv / BufferedChannelKt.SEGMENT_SIZE;
            int i$iv = (int) ($this$sendersCounter$iv$iv % BufferedChannelKt.SEGMENT_SIZE);
            if (segment$iv3.id != id$iv) {
                ChannelSegment segment$iv4 = findSegmentSend(id$iv, segment$iv3);
                if (segment$iv4 != null) {
                    segment$iv = segment$iv4;
                } else if (closed$iv) {
                    return ChannelResult.Companion.m1423closedJP2dKIU(getSendException());
                }
            } else {
                segment$iv = segment$iv3;
            }
            ChannelSegment segment$iv5 = segment$iv;
            int $i$f$sendImpl2 = $i$f$sendImpl;
            switch (updateCellSend(segment$iv, i$iv, e, $this$sendersCounter$iv$iv, waiter$iv, closed$iv)) {
                case 0:
                    segment$iv5.cleanPrev();
                    break;
                case 2:
                    if (closed$iv) {
                        segment$iv5.onSlotCleaned();
                        break;
                    } else {
                        Waiter waiter = waiter$iv instanceof Waiter ? (Waiter) waiter$iv : null;
                        if (waiter != null) {
                            segment$iv2 = segment$iv5;
                            prepareSenderForSuspension(waiter, segment$iv2, i$iv);
                        } else {
                            segment$iv2 = segment$iv5;
                        }
                        ChannelSegment segm = segment$iv2;
                        dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((segm.id * BufferedChannelKt.SEGMENT_SIZE) + i$iv);
                        return ChannelResult.Companion.m1425successJP2dKIU(Unit.INSTANCE);
                    }
                case 3:
                    throw new IllegalStateException("unexpected".toString());
                case 4:
                    if ($this$sendersCounter$iv$iv < getReceiversCounter$kotlinx_coroutines_core()) {
                        segment$iv5.cleanPrev();
                    }
                    break;
                case 5:
                    segment$iv5.cleanPrev();
                    break;
            }
            segment$iv3 = segment$iv5;
            $i$f$sendImpl = $i$f$sendImpl2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final void sendImplOnNoWaiter(ChannelSegment<E> channelSegment, int index, E e, long s, Waiter waiter, Function0<Unit> function0, Function0<Unit> function02) {
        ChannelSegment segment$iv;
        Unit unit;
        boolean z = false;
        switch (updateCellSend(channelSegment, index, e, s, waiter, false)) {
            case 0:
                channelSegment.cleanPrev();
                function0.invoke();
                return;
            case 1:
                function0.invoke();
                return;
            case 2:
                prepareSenderForSuspension(waiter, channelSegment, index);
                return;
            case 3:
            default:
                throw new IllegalStateException("unexpected".toString());
            case 4:
                if (s < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                function02.invoke();
                return;
            case 5:
                channelSegment.cleanPrev();
                ChannelSegment segment$iv2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
                while (true) {
                    long sendersAndCloseStatusCur$iv = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
                    long $this$sendersCounter$iv$iv = sendersAndCloseStatusCur$iv & 1152921504606846975L;
                    boolean closed$iv = isClosedForSend0(sendersAndCloseStatusCur$iv);
                    long id$iv = $this$sendersCounter$iv$iv / BufferedChannelKt.SEGMENT_SIZE;
                    int i$iv = (int) ($this$sendersCounter$iv$iv % BufferedChannelKt.SEGMENT_SIZE);
                    if (segment$iv2.id != id$iv) {
                        ChannelSegment segment$iv3 = findSegmentSend(id$iv, segment$iv2);
                        if (segment$iv3 != null) {
                            segment$iv = segment$iv3;
                        } else if (closed$iv) {
                            unit = function02.invoke();
                        }
                    } else {
                        segment$iv = segment$iv2;
                    }
                    ChannelSegment segment$iv4 = segment$iv;
                    boolean z2 = z;
                    switch (updateCellSend(segment$iv, i$iv, e, $this$sendersCounter$iv$iv, waiter, closed$iv)) {
                        case 0:
                            segment$iv4.cleanPrev();
                            unit = function0.invoke();
                            break;
                        case 1:
                            unit = function0.invoke();
                            break;
                        case 2:
                            if (!closed$iv) {
                                Waiter waiter2 = waiter instanceof Waiter ? waiter : null;
                                if (waiter2 != null) {
                                    prepareSenderForSuspension(waiter2, segment$iv4, i$iv);
                                }
                                unit = Unit.INSTANCE;
                                break;
                            } else {
                                segment$iv4.onSlotCleaned();
                                unit = function02.invoke();
                                break;
                            }
                        case 3:
                            throw new IllegalStateException("unexpected".toString());
                        case 4:
                            if ($this$sendersCounter$iv$iv < getReceiversCounter$kotlinx_coroutines_core()) {
                                segment$iv4.cleanPrev();
                            }
                            unit = function02.invoke();
                            break;
                        case 5:
                            segment$iv4.cleanPrev();
                            break;
                    }
                    segment$iv2 = segment$iv4;
                    z = z2;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int updateCellSend(ChannelSegment<E> channelSegment, int index, E e, long s, Object waiter, boolean closed) {
        channelSegment.storeElement$kotlinx_coroutines_core(index, e);
        if (closed) {
            return updateCellSendSlow(channelSegment, index, e, s, waiter, closed);
        }
        Object state = channelSegment.getState$kotlinx_coroutines_core(index);
        if (state == null) {
            if (bufferOrRendezvousSend(s)) {
                if (channelSegment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (waiter == null) {
                return 3;
            } else {
                if (channelSegment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                    return 2;
                }
            }
        } else if (state instanceof Waiter) {
            channelSegment.cleanElement$kotlinx_coroutines_core(index);
            if (tryResumeReceiver(state, e)) {
                channelSegment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getDONE_RCV$p());
                onReceiveDequeued();
                return 0;
            }
            if (channelSegment.getAndSetState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) != BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                channelSegment.onCancelledRequest(index, true);
            }
            return 5;
        }
        return updateCellSendSlow(channelSegment, index, e, s, waiter, closed);
    }

    private final int updateCellSendSlow(ChannelSegment<E> channelSegment, int index, E e, long s, Object waiter, boolean closed) {
        while (true) {
            Object state = channelSegment.getState$kotlinx_coroutines_core(index);
            if (state == null) {
                if (bufferOrRendezvousSend(s) && !closed) {
                    if (channelSegment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.BUFFERED)) {
                        return 1;
                    }
                } else if (closed) {
                    if (channelSegment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.access$getINTERRUPTED_SEND$p())) {
                        channelSegment.onCancelledRequest(index, false);
                        return 4;
                    }
                } else if (waiter == null) {
                    return 3;
                } else {
                    if (channelSegment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                        return 2;
                    }
                }
            } else if (state == BufferedChannelKt.access$getIN_BUFFER$p()) {
                if (channelSegment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (state == BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                channelSegment.cleanElement$kotlinx_coroutines_core(index);
                return 5;
            } else if (state == BufferedChannelKt.access$getPOISONED$p()) {
                channelSegment.cleanElement$kotlinx_coroutines_core(index);
                return 5;
            } else if (state == BufferedChannelKt.getCHANNEL_CLOSED()) {
                channelSegment.cleanElement$kotlinx_coroutines_core(index);
                completeCloseOrCancel();
                return 4;
            } else {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if ((((state instanceof Waiter) || (state instanceof WaiterEB)) ? 1 : 0) == 0) {
                        throw new AssertionError();
                    }
                }
                channelSegment.cleanElement$kotlinx_coroutines_core(index);
                Object receiver = state instanceof WaiterEB ? ((WaiterEB) state).waiter : state;
                if (tryResumeReceiver(receiver, e)) {
                    channelSegment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getDONE_RCV$p());
                    onReceiveDequeued();
                    return 0;
                }
                if (channelSegment.getAndSetState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) != BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                    channelSegment.onCancelledRequest(index, true);
                }
                return 5;
            }
        }
    }

    private final boolean shouldSendSuspend(long curSendersAndCloseStatus) {
        if (isClosedForSend0(curSendersAndCloseStatus)) {
            return false;
        }
        long $this$sendersCounter$iv = curSendersAndCloseStatus & 1152921504606846975L;
        return !bufferOrRendezvousSend($this$sendersCounter$iv);
    }

    private final boolean bufferOrRendezvousSend(long curSenders) {
        return curSenders < getBufferEndCounter() || curSenders < getReceiversCounter$kotlinx_coroutines_core() + ((long) this.capacity);
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return shouldSendSuspend(sendersAndCloseStatus$volatile$FU.get(this));
    }

    private final boolean tryResumeReceiver(Object $this$tryResumeReceiver, E e) {
        if ($this$tryResumeReceiver instanceof SelectInstance) {
            return ((SelectInstance) $this$tryResumeReceiver).trySelect(this, e);
        }
        if ($this$tryResumeReceiver instanceof ReceiveCatching) {
            Intrinsics.checkNotNull($this$tryResumeReceiver, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            ReceiveCatching receiveCatching = (ReceiveCatching) $this$tryResumeReceiver;
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = ((ReceiveCatching) $this$tryResumeReceiver).cont;
            ChannelResult m1410boximpl = ChannelResult.m1410boximpl(ChannelResult.Companion.m1425successJP2dKIU(e));
            Function1<E, Unit> function1 = this.onUndeliveredElement;
            return BufferedChannelKt.access$tryResume0(cancellableContinuationImpl, m1410boximpl, function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, e, ((ReceiveCatching) $this$tryResumeReceiver).cont.getContext()) : null);
        } else if ($this$tryResumeReceiver instanceof BufferedChannelIterator) {
            Intrinsics.checkNotNull($this$tryResumeReceiver, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            BufferedChannelIterator bufferedChannelIterator = (BufferedChannelIterator) $this$tryResumeReceiver;
            return ((BufferedChannelIterator) $this$tryResumeReceiver).tryResumeHasNext(e);
        } else if ($this$tryResumeReceiver instanceof CancellableContinuation) {
            Intrinsics.checkNotNull($this$tryResumeReceiver, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) $this$tryResumeReceiver;
            CancellableContinuation cancellableContinuation2 = (CancellableContinuation) $this$tryResumeReceiver;
            Function1<E, Unit> function12 = this.onUndeliveredElement;
            return BufferedChannelKt.access$tryResume0(cancellableContinuation2, e, function12 != null ? OnUndeliveredElementKt.bindCancellationFun(function12, e, ((CancellableContinuation) $this$tryResumeReceiver).getContext()) : null);
        } else {
            throw new IllegalStateException(("Unexpected receiver type: " + $this$tryResumeReceiver).toString());
        }
    }

    protected void onReceiveEnqueued() {
    }

    protected void onReceiveDequeued() {
    }

    static /* synthetic */ <E> Object receive$suspendImpl(BufferedChannel<E> bufferedChannel, Continuation<? super E> continuation) {
        ChannelSegment segment$iv;
        ChannelSegment segment$iv2 = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long r$iv = access$getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
            long id$iv = r$iv / BufferedChannelKt.SEGMENT_SIZE;
            int i$iv = (int) (r$iv % BufferedChannelKt.SEGMENT_SIZE);
            if (segment$iv2.id != id$iv) {
                ChannelSegment segment$iv3 = bufferedChannel.findSegmentReceive(id$iv, segment$iv2);
                if (segment$iv3 == null) {
                    continue;
                } else {
                    segment$iv = segment$iv3;
                }
            } else {
                segment$iv = segment$iv2;
            }
            Object updCellResult$iv = bufferedChannel.updateCellReceive(segment$iv, i$iv, r$iv, null);
            if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (updCellResult$iv == BufferedChannelKt.access$getFAILED$p()) {
                if (r$iv < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                    segment$iv.cleanPrev();
                }
                segment$iv2 = segment$iv;
            } else if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                ChannelSegment segm = segment$iv;
                return bufferedChannel.receiveOnNoWaiterSuspend(segm, i$iv, r$iv, continuation);
            } else {
                segment$iv.cleanPrev();
                return updCellResult$iv;
            }
        }
        throw StackTraceRecoveryKt.recoverStackTrace(bufferedChannel.getReceiveException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object receiveOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int index, long r, Continuation<? super E> continuation) {
        ChannelSegment segment$iv$iv;
        boolean z = false;
        Continuation<? super E> continuation2 = continuation;
        boolean z2 = false;
        CancellableContinuationImpl cancellable$iv = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation2));
        try {
            Object updCellResult$iv = updateCellReceive(channelSegment, index, r, cancellable$iv);
            try {
                if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                    try {
                        prepareReceiverForSuspension(cancellable$iv, channelSegment, index);
                    } catch (Throwable th) {
                        e$iv = th;
                        cancellable$iv.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                        throw e$iv;
                    }
                } else {
                    try {
                        if (updCellResult$iv != BufferedChannelKt.access$getFAILED$p()) {
                            channelSegment.cleanPrev();
                            Function1<E, Unit> function1 = this.onUndeliveredElement;
                            Function1 onCancellation = function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, updCellResult$iv, cancellable$iv.getContext()) : null;
                            cancellable$iv.resume(updCellResult$iv, onCancellation);
                        } else {
                            if (r < getSendersCounter$kotlinx_coroutines_core()) {
                                channelSegment.cleanPrev();
                            }
                            ChannelSegment segment$iv$iv2 = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
                            while (!isClosedForReceive()) {
                                long r$iv$iv = access$getReceivers$volatile$FU().getAndIncrement(this);
                                long id$iv$iv = r$iv$iv / BufferedChannelKt.SEGMENT_SIZE;
                                boolean z3 = z;
                                Continuation<? super E> continuation3 = continuation2;
                                try {
                                    int i$iv$iv = (int) (r$iv$iv % BufferedChannelKt.SEGMENT_SIZE);
                                    boolean z4 = z2;
                                    if (segment$iv$iv2.id != id$iv$iv) {
                                        segment$iv$iv = findSegmentReceive(id$iv$iv, segment$iv$iv2);
                                        if (segment$iv$iv == null) {
                                            z = z3;
                                            continuation2 = continuation3;
                                            z2 = z4;
                                        }
                                    } else {
                                        segment$iv$iv = segment$iv$iv2;
                                    }
                                    Object updCellResult$iv$iv = updateCellReceive(segment$iv$iv, i$iv$iv, r$iv$iv, cancellable$iv);
                                    if (updCellResult$iv$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                                        CancellableContinuationImpl cancellableContinuationImpl = cancellable$iv instanceof Waiter ? cancellable$iv : null;
                                        if (cancellableContinuationImpl != null) {
                                            prepareReceiverForSuspension(cancellableContinuationImpl, segment$iv$iv, i$iv$iv);
                                        }
                                    } else if (updCellResult$iv$iv == BufferedChannelKt.access$getFAILED$p()) {
                                        if (r$iv$iv < getSendersCounter$kotlinx_coroutines_core()) {
                                            segment$iv$iv.cleanPrev();
                                        }
                                        segment$iv$iv2 = segment$iv$iv;
                                        z = z3;
                                        continuation2 = continuation3;
                                        z2 = z4;
                                    } else if (updCellResult$iv$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                                        throw new IllegalStateException("unexpected".toString());
                                    } else {
                                        segment$iv$iv.cleanPrev();
                                        Function1<E, Unit> function12 = this.onUndeliveredElement;
                                        Function1 onCancellation2 = function12 != null ? OnUndeliveredElementKt.bindCancellationFun(function12, updCellResult$iv$iv, cancellable$iv.getContext()) : null;
                                        cancellable$iv.resume(updCellResult$iv$iv, onCancellation2);
                                    }
                                } catch (Throwable th2) {
                                    e$iv = th2;
                                    cancellable$iv.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                                    throw e$iv;
                                }
                            }
                            onClosedReceiveOnNoWaiterSuspend(cancellable$iv);
                        }
                    } catch (Throwable th3) {
                        e$iv = th3;
                    }
                }
                Object result = cancellable$iv.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return result;
            } catch (Throwable th4) {
                e$iv = th4;
            }
        } catch (Throwable th5) {
            e$iv = th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareReceiverForSuspension(Waiter $this$prepareReceiverForSuspension, ChannelSegment<E> channelSegment, int index) {
        onReceiveEnqueued();
        $this$prepareReceiverForSuspension.invokeOnCancellation(channelSegment, index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation<? super E> cancellableContinuation) {
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(getReceiveException())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* renamed from: receiveCatching-JP2dKIU$suspendImpl  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <E> Object m1401receiveCatchingJP2dKIU$suspendImpl(BufferedChannel<E> bufferedChannel, Continuation<? super ChannelResult<? extends E>> continuation) {
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$1;
        Object m1402receiveCatchingOnNoWaiterSuspendGKJJFZk;
        boolean z;
        if (continuation instanceof BufferedChannel$receiveCatching$1) {
            BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$12 = (BufferedChannel$receiveCatching$1) continuation;
            if ((bufferedChannel$receiveCatching$12.label & IntCompanionObject.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatching$12.label -= IntCompanionObject.MIN_VALUE;
                bufferedChannel$receiveCatching$1 = bufferedChannel$receiveCatching$12;
                Object $result = bufferedChannel$receiveCatching$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (bufferedChannel$receiveCatching$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        ChannelSegment segment$iv = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(bufferedChannel);
                        while (!bufferedChannel.isClosedForReceive()) {
                            long r$iv = access$getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                            long id$iv = r$iv / BufferedChannelKt.SEGMENT_SIZE;
                            int i$iv = (int) (r$iv % BufferedChannelKt.SEGMENT_SIZE);
                            if (segment$iv.id != id$iv) {
                                ChannelSegment findSegmentReceive = bufferedChannel.findSegmentReceive(id$iv, segment$iv);
                                if (findSegmentReceive == null) {
                                    continue;
                                } else {
                                    segment$iv = findSegmentReceive;
                                }
                            }
                            Object updCellResult$iv = bufferedChannel.updateCellReceive(segment$iv, i$iv, r$iv, null);
                            if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                                throw new IllegalStateException("unexpected".toString());
                            }
                            if (updCellResult$iv == BufferedChannelKt.access$getFAILED$p()) {
                                if (r$iv < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                    segment$iv.cleanPrev();
                                }
                            } else if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                                ChannelSegment segm = segment$iv;
                                bufferedChannel$receiveCatching$1.label = 1;
                                m1402receiveCatchingOnNoWaiterSuspendGKJJFZk = bufferedChannel.m1402receiveCatchingOnNoWaiterSuspendGKJJFZk(segm, i$iv, r$iv, bufferedChannel$receiveCatching$1);
                                if (m1402receiveCatchingOnNoWaiterSuspendGKJJFZk == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                z = false;
                                break;
                            } else {
                                segment$iv.cleanPrev();
                                return ChannelResult.Companion.m1425successJP2dKIU(updCellResult$iv);
                            }
                        }
                        return ChannelResult.Companion.m1423closedJP2dKIU(bufferedChannel.getCloseCause());
                    case 1:
                        z = false;
                        ResultKt.throwOnFailure($result);
                        m1402receiveCatchingOnNoWaiterSuspendGKJJFZk = ((ChannelResult) $result).m1422unboximpl();
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return m1402receiveCatchingOnNoWaiterSuspendGKJJFZk;
            }
        }
        bufferedChannel$receiveCatching$1 = new BufferedChannel$receiveCatching$1(bufferedChannel, continuation);
        Object $result2 = bufferedChannel$receiveCatching$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (bufferedChannel$receiveCatching$1.label) {
        }
        return m1402receiveCatchingOnNoWaiterSuspendGKJJFZk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1402receiveCatchingOnNoWaiterSuspendGKJJFZk(ChannelSegment<E> channelSegment, int index, long r, Continuation<? super ChannelResult<? extends E>> continuation) {
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 bufferedChannel$receiveCatchingOnNoWaiterSuspend$1;
        Object result;
        if (continuation instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) continuation;
            if ((bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label -= IntCompanionObject.MIN_VALUE;
                Object $result = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.L$0 = this;
                        bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.L$1 = channelSegment;
                        bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.I$0 = index;
                        bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.J$0 = r;
                        bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label = 1;
                        Continuation uCont$iv = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1;
                        CancellableContinuationImpl cancellable$iv = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(uCont$iv));
                        try {
                            Intrinsics.checkNotNull(cancellable$iv, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$38>>");
                            ReceiveCatching waiter = new ReceiveCatching(cancellable$iv);
                            try {
                                Object updCellResult$iv = updateCellReceive(channelSegment, index, r, waiter);
                                if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                                    prepareReceiverForSuspension(waiter, channelSegment, index);
                                } else {
                                    if (updCellResult$iv == BufferedChannelKt.access$getFAILED$p()) {
                                        if (r < getSendersCounter$kotlinx_coroutines_core()) {
                                            channelSegment.cleanPrev();
                                        }
                                        ChannelSegment segment$iv$iv = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
                                        while (!isClosedForReceive()) {
                                            long r$iv$iv = access$getReceivers$volatile$FU().getAndIncrement(this);
                                            long id$iv$iv = r$iv$iv / BufferedChannelKt.SEGMENT_SIZE;
                                            int i$iv$iv = (int) (r$iv$iv % BufferedChannelKt.SEGMENT_SIZE);
                                            if (segment$iv$iv.id != id$iv$iv) {
                                                ChannelSegment findSegmentReceive = findSegmentReceive(id$iv$iv, segment$iv$iv);
                                                if (findSegmentReceive != null) {
                                                    segment$iv$iv = findSegmentReceive;
                                                }
                                            }
                                            Object updCellResult$iv$iv = updateCellReceive(segment$iv$iv, i$iv$iv, r$iv$iv, waiter);
                                            if (updCellResult$iv$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                                                ReceiveCatching receiveCatching = waiter instanceof Waiter ? waiter : null;
                                                if (receiveCatching != null) {
                                                    prepareReceiverForSuspension(receiveCatching, segment$iv$iv, i$iv$iv);
                                                }
                                            } else if (updCellResult$iv$iv == BufferedChannelKt.access$getFAILED$p()) {
                                                if (r$iv$iv < getSendersCounter$kotlinx_coroutines_core()) {
                                                    segment$iv$iv.cleanPrev();
                                                }
                                            } else if (updCellResult$iv$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                                                throw new IllegalStateException("unexpected".toString());
                                            } else {
                                                segment$iv$iv.cleanPrev();
                                                ChannelResult m1410boximpl = ChannelResult.m1410boximpl(ChannelResult.Companion.m1425successJP2dKIU(updCellResult$iv$iv));
                                                Function1<E, Unit> function1 = this.onUndeliveredElement;
                                                cancellable$iv.resume(m1410boximpl, function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, updCellResult$iv$iv, cancellable$iv.getContext()) : null);
                                            }
                                        }
                                        onClosedReceiveCatchingOnNoWaiterSuspend(cancellable$iv);
                                    } else {
                                        channelSegment.cleanPrev();
                                        ChannelResult m1410boximpl2 = ChannelResult.m1410boximpl(ChannelResult.Companion.m1425successJP2dKIU(updCellResult$iv));
                                        Function1<E, Unit> function12 = this.onUndeliveredElement;
                                        cancellable$iv.resume(m1410boximpl2, function12 != null ? OnUndeliveredElementKt.bindCancellationFun(function12, updCellResult$iv, cancellable$iv.getContext()) : null);
                                    }
                                }
                                result = cancellable$iv.getResult();
                                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                    DebugProbesKt.probeCoroutineSuspended(bufferedChannel$receiveCatchingOnNoWaiterSuspend$1);
                                }
                                if (result != coroutine_suspended) {
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            } catch (Throwable th) {
                                e$iv = th;
                                cancellable$iv.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                                throw e$iv;
                            }
                        } catch (Throwable th2) {
                            e$iv = th2;
                        }
                    case 1:
                        long j = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.J$0;
                        int i = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.I$0;
                        ChannelSegment channelSegment2 = (ChannelSegment) bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.L$1;
                        BufferedChannel bufferedChannel = (BufferedChannel) bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.L$0;
                        ResultKt.throwOnFailure($result);
                        result = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((ChannelResult) result).m1422unboximpl();
            }
        }
        bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, continuation);
        Object $result2 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label) {
        }
        return ((ChannelResult) result).m1422unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super ChannelResult<? extends E>> cancellableContinuation) {
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.constructor-impl(ChannelResult.m1410boximpl(ChannelResult.Companion.m1423closedJP2dKIU(getCloseCause()))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk  reason: not valid java name */
    public Object mo1404tryReceivePtdJZtk() {
        ChannelSegment segment$iv;
        long r = receivers$volatile$FU.get(this);
        long sendersAndCloseStatusCur = sendersAndCloseStatus$volatile$FU.get(this);
        if (isClosedForReceive0(sendersAndCloseStatusCur)) {
            return ChannelResult.Companion.m1423closedJP2dKIU(getCloseCause());
        }
        long $this$sendersCounter$iv = sendersAndCloseStatusCur & 1152921504606846975L;
        if (r >= $this$sendersCounter$iv) {
            return ChannelResult.Companion.m1424failurePtdJZtk();
        }
        Object waiter$iv = BufferedChannelKt.access$getINTERRUPTED_RCV$p();
        ChannelSegment segment$iv2 = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long r$iv = access$getReceivers$volatile$FU().getAndIncrement(this);
            long id$iv = r$iv / BufferedChannelKt.SEGMENT_SIZE;
            int i$iv = (int) (r$iv % BufferedChannelKt.SEGMENT_SIZE);
            if (segment$iv2.id != id$iv) {
                ChannelSegment segment$iv3 = findSegmentReceive(id$iv, segment$iv2);
                if (segment$iv3 == null) {
                    continue;
                } else {
                    segment$iv = segment$iv3;
                }
            } else {
                segment$iv = segment$iv2;
            }
            long r2 = r;
            ChannelSegment segment$iv4 = segment$iv;
            Object updCellResult$iv = updateCellReceive(segment$iv, i$iv, r$iv, waiter$iv);
            if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                Waiter waiter = waiter$iv instanceof Waiter ? (Waiter) waiter$iv : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, segment$iv4, i$iv);
                }
                waitExpandBufferCompletion$kotlinx_coroutines_core(r$iv);
                segment$iv4.onSlotCleaned();
                return ChannelResult.Companion.m1424failurePtdJZtk();
            } else if (updCellResult$iv == BufferedChannelKt.access$getFAILED$p()) {
                if (r$iv < getSendersCounter$kotlinx_coroutines_core()) {
                    segment$iv4.cleanPrev();
                }
                segment$iv2 = segment$iv4;
                r = r2;
            } else if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                throw new IllegalStateException("unexpected".toString());
            } else {
                segment$iv4.cleanPrev();
                return ChannelResult.Companion.m1425successJP2dKIU(updCellResult$iv);
            }
        }
        return ChannelResult.Companion.m1423closedJP2dKIU(getCloseCause());
    }

    protected final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long globalCellIndex) {
        UndeliveredElementException it;
        if (DebugKt.getASSERTIONS_ENABLED() && !isConflatedDropOldest()) {
            throw new AssertionError();
        }
        ChannelSegment segment = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        while (true) {
            long r = receivers$volatile$FU.get(this);
            if (globalCellIndex < Math.max(this.capacity + r, getBufferEndCounter())) {
                return;
            }
            if (receivers$volatile$FU.compareAndSet(this, r, r + 1)) {
                long id = r / BufferedChannelKt.SEGMENT_SIZE;
                int i = (int) (r % BufferedChannelKt.SEGMENT_SIZE);
                if (segment.id != id) {
                    ChannelSegment findSegmentReceive = findSegmentReceive(id, segment);
                    if (findSegmentReceive == null) {
                        continue;
                    } else {
                        segment = findSegmentReceive;
                    }
                }
                Object updCellResult = updateCellReceive(segment, i, r, null);
                if (updCellResult == BufferedChannelKt.access$getFAILED$p()) {
                    if (r < getSendersCounter$kotlinx_coroutines_core()) {
                        segment.cleanPrev();
                    }
                } else {
                    segment.cleanPrev();
                    Function1<E, Unit> function1 = this.onUndeliveredElement;
                    if (function1 != null && (it = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, updCellResult, null, 2, null)) != null) {
                        throw it;
                    }
                }
            }
        }
    }

    static /* synthetic */ Object receiveImpl$default(BufferedChannel $this, Object waiter, Function1 onElementRetrieved, Function3 onSuspend, Function0 onClosed, Function3 onNoWaiterSuspend, int i, Object obj) {
        Function3 onNoWaiterSuspend2;
        ChannelSegment segment;
        if (obj == null) {
            if ((i & 16) == 0) {
                onNoWaiterSuspend2 = onNoWaiterSuspend;
            } else {
                onNoWaiterSuspend2 = new Function3() { // from class: kotlinx.coroutines.channels.BufferedChannel$receiveImpl$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                        return invoke((ChannelSegment) p1, ((Number) p2).intValue(), ((Number) p3).longValue());
                    }

                    public final Void invoke(ChannelSegment<E> channelSegment, int i2, long j) {
                        throw new IllegalStateException("unexpected".toString());
                    }
                };
            }
            ChannelSegment segment2 = (ChannelSegment) access$getReceiveSegment$volatile$FU().get($this);
            while (!$this.isClosedForReceive()) {
                long r = access$getReceivers$volatile$FU().getAndIncrement($this);
                long id = r / BufferedChannelKt.SEGMENT_SIZE;
                int i2 = (int) (r % BufferedChannelKt.SEGMENT_SIZE);
                if (segment2.id != id) {
                    ChannelSegment segment3 = $this.findSegmentReceive(id, segment2);
                    if (segment3 == null) {
                        continue;
                    } else {
                        segment = segment3;
                    }
                } else {
                    segment = segment2;
                }
                Object updCellResult = $this.updateCellReceive(segment, i2, r, waiter);
                if (updCellResult == BufferedChannelKt.access$getSUSPEND$p()) {
                    Waiter waiter2 = waiter instanceof Waiter ? (Waiter) waiter : null;
                    if (waiter2 != null) {
                        $this.prepareReceiverForSuspension(waiter2, segment, i2);
                    }
                    return onSuspend.invoke(segment, Integer.valueOf(i2), Long.valueOf(r));
                } else if (updCellResult == BufferedChannelKt.access$getFAILED$p()) {
                    if (r < $this.getSendersCounter$kotlinx_coroutines_core()) {
                        segment.cleanPrev();
                    }
                    segment2 = segment;
                } else if (updCellResult == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                    return onNoWaiterSuspend2.invoke(segment, Integer.valueOf(i2), Long.valueOf(r));
                } else {
                    segment.cleanPrev();
                    return onElementRetrieved.invoke(updCellResult);
                }
            }
            return onClosed.invoke();
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
    }

    private final <R> R receiveImpl(Object waiter, Function1<? super E, ? extends R> function1, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> function3, Function0<? extends R> function0, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> function32) {
        ChannelSegment segment;
        ChannelSegment segment2 = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long r = access$getReceivers$volatile$FU().getAndIncrement(this);
            long id = r / BufferedChannelKt.SEGMENT_SIZE;
            int i = (int) (r % BufferedChannelKt.SEGMENT_SIZE);
            if (segment2.id != id) {
                ChannelSegment segment3 = findSegmentReceive(id, segment2);
                if (segment3 == null) {
                    continue;
                } else {
                    segment = segment3;
                }
            } else {
                segment = segment2;
            }
            Object updCellResult = (Object) updateCellReceive(segment, i, r, waiter);
            if (updCellResult == BufferedChannelKt.access$getSUSPEND$p()) {
                Waiter waiter2 = waiter instanceof Waiter ? (Waiter) waiter : null;
                if (waiter2 != null) {
                    prepareReceiverForSuspension(waiter2, segment, i);
                }
                return function3.invoke(segment, Integer.valueOf(i), Long.valueOf(r));
            } else if (updCellResult == BufferedChannelKt.access$getFAILED$p()) {
                if (r < getSendersCounter$kotlinx_coroutines_core()) {
                    segment.cleanPrev();
                }
                segment2 = segment;
            } else if (updCellResult == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                return function32.invoke(segment, Integer.valueOf(i), Long.valueOf(r));
            } else {
                segment.cleanPrev();
                return function1.invoke(updCellResult);
            }
        }
        return function0.invoke();
    }

    private final void receiveImplOnNoWaiter(ChannelSegment<E> channelSegment, int index, long r, Waiter waiter, Function1<? super E, Unit> function1, Function0<Unit> function0) {
        ChannelSegment segment$iv;
        boolean z = false;
        Object updCellResult = (Object) updateCellReceive(channelSegment, index, r, waiter);
        if (updCellResult == BufferedChannelKt.access$getSUSPEND$p()) {
            prepareReceiverForSuspension(waiter, channelSegment, index);
        } else if (updCellResult == BufferedChannelKt.access$getFAILED$p()) {
            if (r < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            ChannelSegment segment$iv2 = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
            while (!isClosedForReceive()) {
                long r$iv = access$getReceivers$volatile$FU().getAndIncrement(this);
                long id$iv = r$iv / BufferedChannelKt.SEGMENT_SIZE;
                int i$iv = (int) (r$iv % BufferedChannelKt.SEGMENT_SIZE);
                if (segment$iv2.id != id$iv) {
                    ChannelSegment segment$iv3 = findSegmentReceive(id$iv, segment$iv2);
                    if (segment$iv3 == null) {
                        continue;
                    } else {
                        segment$iv = segment$iv3;
                    }
                } else {
                    segment$iv = segment$iv2;
                }
                boolean z2 = z;
                ChannelSegment segment$iv4 = segment$iv;
                Object updCellResult$iv = (Object) updateCellReceive(segment$iv, i$iv, r$iv, waiter);
                if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                    Waiter waiter2 = waiter instanceof Waiter ? waiter : null;
                    if (waiter2 != null) {
                        prepareReceiverForSuspension(waiter2, segment$iv4, i$iv);
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                } else if (updCellResult$iv == BufferedChannelKt.access$getFAILED$p()) {
                    if (r$iv < getSendersCounter$kotlinx_coroutines_core()) {
                        segment$iv4.cleanPrev();
                    }
                    segment$iv2 = segment$iv4;
                    z = z2;
                } else if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                    throw new IllegalStateException("unexpected".toString());
                } else {
                    segment$iv4.cleanPrev();
                    function1.invoke(updCellResult$iv);
                    return;
                }
            }
            function0.invoke();
        } else {
            channelSegment.cleanPrev();
            function1.invoke(updCellResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateCellReceive(ChannelSegment<E> channelSegment, int index, long r, Object waiter) {
        Object state = channelSegment.getState$kotlinx_coroutines_core(index);
        if (state == null) {
            long $this$sendersCounter$iv = sendersAndCloseStatus$volatile$FU.get(this);
            long senders = $this$sendersCounter$iv & 1152921504606846975L;
            if (r >= senders) {
                if (waiter == null) {
                    return BufferedChannelKt.access$getSUSPEND_NO_WAITER$p();
                }
                if (channelSegment.casState$kotlinx_coroutines_core(index, state, waiter)) {
                    expandBuffer();
                    return BufferedChannelKt.access$getSUSPEND$p();
                }
            }
        } else if (state == BufferedChannelKt.BUFFERED && channelSegment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getDONE_RCV$p())) {
            expandBuffer();
            return channelSegment.retrieveElement$kotlinx_coroutines_core(index);
        }
        return updateCellReceiveSlow(channelSegment, index, r, waiter);
    }

    private final Object updateCellReceiveSlow(ChannelSegment<E> channelSegment, int index, long r, Object waiter) {
        while (true) {
            Object state = channelSegment.getState$kotlinx_coroutines_core(index);
            if (state == null || state == BufferedChannelKt.access$getIN_BUFFER$p()) {
                long $this$sendersCounter$iv = sendersAndCloseStatus$volatile$FU.get(this);
                long senders = $this$sendersCounter$iv & 1152921504606846975L;
                if (r < senders) {
                    if (channelSegment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getPOISONED$p())) {
                        expandBuffer();
                        return BufferedChannelKt.access$getFAILED$p();
                    }
                } else if (waiter == null) {
                    return BufferedChannelKt.access$getSUSPEND_NO_WAITER$p();
                } else {
                    if (channelSegment.casState$kotlinx_coroutines_core(index, state, waiter)) {
                        expandBuffer();
                        return BufferedChannelKt.access$getSUSPEND$p();
                    }
                }
            } else if (state != BufferedChannelKt.BUFFERED) {
                if (state != BufferedChannelKt.access$getINTERRUPTED_SEND$p() && state != BufferedChannelKt.access$getPOISONED$p()) {
                    if (state == BufferedChannelKt.getCHANNEL_CLOSED()) {
                        expandBuffer();
                        return BufferedChannelKt.access$getFAILED$p();
                    } else if (state != BufferedChannelKt.access$getRESUMING_BY_EB$p() && channelSegment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getRESUMING_BY_RCV$p())) {
                        boolean helpExpandBuffer = state instanceof WaiterEB;
                        Object sender = state instanceof WaiterEB ? ((WaiterEB) state).waiter : state;
                        if (tryResumeSender(sender, channelSegment, index)) {
                            channelSegment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getDONE_RCV$p());
                            expandBuffer();
                            return channelSegment.retrieveElement$kotlinx_coroutines_core(index);
                        }
                        channelSegment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                        channelSegment.onCancelledRequest(index, false);
                        if (helpExpandBuffer) {
                            expandBuffer();
                        }
                        return BufferedChannelKt.access$getFAILED$p();
                    }
                }
                return BufferedChannelKt.access$getFAILED$p();
            } else if (channelSegment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getDONE_RCV$p())) {
                expandBuffer();
                return channelSegment.retrieveElement$kotlinx_coroutines_core(index);
            }
        }
    }

    private final boolean tryResumeSender(Object $this$tryResumeSender, ChannelSegment<E> channelSegment, int index) {
        if ($this$tryResumeSender instanceof CancellableContinuation) {
            Intrinsics.checkNotNull($this$tryResumeSender, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) $this$tryResumeSender;
            return BufferedChannelKt.tryResume0$default((CancellableContinuation) $this$tryResumeSender, Unit.INSTANCE, null, 2, null);
        } else if ($this$tryResumeSender instanceof SelectInstance) {
            Intrinsics.checkNotNull($this$tryResumeSender, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            SelectImplementation selectImplementation = (SelectImplementation) $this$tryResumeSender;
            TrySelectDetailedResult trySelectResult = ((SelectImplementation) $this$tryResumeSender).trySelectDetailed(this, Unit.INSTANCE);
            if (trySelectResult == TrySelectDetailedResult.REREGISTER) {
                channelSegment.cleanElement$kotlinx_coroutines_core(index);
            }
            return trySelectResult == TrySelectDetailedResult.SUCCESSFUL;
        } else if ($this$tryResumeSender instanceof SendBroadcast) {
            return BufferedChannelKt.tryResume0$default(((SendBroadcast) $this$tryResumeSender).getCont(), true, null, 2, null);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + $this$tryResumeSender).toString());
        }
    }

    private final void expandBuffer() {
        long id;
        if (isRendezvousOrUnlimited()) {
            return;
        }
        ChannelSegment segment = (ChannelSegment) bufferEndSegment$volatile$FU.get(this);
        while (true) {
            long b = bufferEnd$volatile$FU.getAndIncrement(this);
            long id2 = b / BufferedChannelKt.SEGMENT_SIZE;
            long s = getSendersCounter$kotlinx_coroutines_core();
            if (s <= b) {
                if (segment.id < id2 && segment.getNext() != 0) {
                    moveSegmentBufferEndToSpecifiedOrLast(id2, segment);
                }
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            if (segment.id != id2) {
                id = 0;
                ChannelSegment findSegmentBufferEnd = findSegmentBufferEnd(id2, segment, b);
                if (findSegmentBufferEnd == null) {
                    continue;
                } else {
                    segment = findSegmentBufferEnd;
                }
            } else {
                id = 0;
            }
            int i = (int) (b % BufferedChannelKt.SEGMENT_SIZE);
            if (updateCellExpandBuffer(segment, i, b)) {
                incCompletedExpandBufferAttempts$default(this, id, 1, null);
                return;
            }
            incCompletedExpandBufferAttempts$default(this, id, 1, null);
        }
    }

    private final boolean updateCellExpandBuffer(ChannelSegment<E> channelSegment, int index, long b) {
        Object state = channelSegment.getState$kotlinx_coroutines_core(index);
        if ((state instanceof Waiter) && b >= receivers$volatile$FU.get(this) && channelSegment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getRESUMING_BY_EB$p())) {
            if (tryResumeSender(state, channelSegment, index)) {
                channelSegment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
                return true;
            }
            channelSegment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
            channelSegment.onCancelledRequest(index, false);
            return false;
        }
        return updateCellExpandBufferSlow(channelSegment, index, b);
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment<E> channelSegment, int index, long b) {
        while (true) {
            Object state = channelSegment.getState$kotlinx_coroutines_core(index);
            if (state instanceof Waiter) {
                if (b < receivers$volatile$FU.get(this)) {
                    if (channelSegment.casState$kotlinx_coroutines_core(index, state, new WaiterEB((Waiter) state))) {
                        return true;
                    }
                } else if (channelSegment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getRESUMING_BY_EB$p())) {
                    if (tryResumeSender(state, channelSegment, index)) {
                        channelSegment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
                        return true;
                    }
                    channelSegment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                    channelSegment.onCancelledRequest(index, false);
                    return false;
                }
            } else if (state == BufferedChannelKt.access$getINTERRUPTED_SEND$p()) {
                return false;
            } else {
                if (state == null) {
                    if (channelSegment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getIN_BUFFER$p())) {
                        return true;
                    }
                } else if (state == BufferedChannelKt.BUFFERED || state == BufferedChannelKt.access$getPOISONED$p() || state == BufferedChannelKt.access$getDONE_RCV$p() || state == BufferedChannelKt.access$getINTERRUPTED_RCV$p() || state == BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return true;
                } else {
                    if (state != BufferedChannelKt.access$getRESUMING_BY_RCV$p()) {
                        throw new IllegalStateException(("Unexpected cell state: " + state).toString());
                    }
                }
            }
        }
    }

    static /* synthetic */ void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i & 1) != 0) {
            j = 1;
        }
        bufferedChannel.incCompletedExpandBufferAttempts(j);
    }

    private final void incCompletedExpandBufferAttempts(long nAttempts) {
        boolean z;
        long it = completedExpandBuffersAndPauseFlag$volatile$FU.addAndGet(this, nAttempts);
        if ((it & 4611686018427387904L) != 0) {
            do {
                long $this$ebPauseExpandBuffers$iv = completedExpandBuffersAndPauseFlag$volatile$FU.get(this);
                if (($this$ebPauseExpandBuffers$iv & 4611686018427387904L) != 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } while (z);
        }
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long globalIndex) {
        long ebCompleted;
        if (isRendezvousOrUnlimited()) {
            return;
        }
        do {
        } while (getBufferEndCounter() <= globalIndex);
        int access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p = BufferedChannelKt.access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p();
        boolean z = false;
        int i = 0;
        while (true) {
            long j = DurationKt.MAX_MILLIS;
            if (i >= access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p) {
                AtomicLongFieldUpdater handler$atomicfu$iv = completedExpandBuffersAndPauseFlag$volatile$FU;
                while (true) {
                    long it = handler$atomicfu$iv.get(this);
                    long $this$ebCompletedCounter$iv = it & j;
                    if (handler$atomicfu$iv.compareAndSet(this, it, BufferedChannelKt.access$constructEBCompletedAndPauseFlag($this$ebCompletedCounter$iv, true))) {
                        break;
                    }
                    z = false;
                    j = DurationKt.MAX_MILLIS;
                }
                while (true) {
                    long b = getBufferEndCounter();
                    long ebCompletedAndBit = completedExpandBuffersAndPauseFlag$volatile$FU.get(this);
                    long $this$ebCompletedCounter$iv2 = ebCompletedAndBit & j;
                    ebCompleted = $this$ebCompletedCounter$iv2;
                    boolean pauseExpandBuffers = (4611686018427387904L & ebCompletedAndBit) != 0 ? true : z;
                    if (b == ebCompleted && b == getBufferEndCounter()) {
                        break;
                    } else if (pauseExpandBuffers) {
                        z = false;
                        j = DurationKt.MAX_MILLIS;
                    } else {
                        completedExpandBuffersAndPauseFlag$volatile$FU.compareAndSet(this, ebCompletedAndBit, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(ebCompleted, true));
                        z = false;
                        j = DurationKt.MAX_MILLIS;
                    }
                }
                AtomicLongFieldUpdater handler$atomicfu$iv2 = completedExpandBuffersAndPauseFlag$volatile$FU;
                while (true) {
                    long it2 = handler$atomicfu$iv2.get(this);
                    long access$constructEBCompletedAndPauseFlag = BufferedChannelKt.access$constructEBCompletedAndPauseFlag(it2 & j, z);
                    long ebCompleted2 = ebCompleted;
                    if (!handler$atomicfu$iv2.compareAndSet(this, it2, access$constructEBCompletedAndPauseFlag)) {
                        ebCompleted = ebCompleted2;
                        z = false;
                        j = DurationKt.MAX_MILLIS;
                    } else {
                        return;
                    }
                }
            } else {
                long b2 = getBufferEndCounter();
                long $this$ebCompletedCounter$iv3 = completedExpandBuffersAndPauseFlag$volatile$FU.get(this);
                if (b2 == (DurationKt.MAX_MILLIS & $this$ebCompletedCounter$iv3) && b2 == getBufferEndCounter()) {
                    return;
                }
                i++;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, BufferedChannel<E>> getOnSend() {
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$1, 3);
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$2, 3), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    public void registerSelectForSend(SelectInstance<?> selectInstance, Object element) {
        ChannelSegment segment$iv;
        int $i$f$sendImpl = 0;
        ChannelSegment segment$iv2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long sendersAndCloseStatusCur$iv = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long $this$sendersCounter$iv$iv = sendersAndCloseStatusCur$iv & 1152921504606846975L;
            boolean closed$iv = isClosedForSend0(sendersAndCloseStatusCur$iv);
            long id$iv = $this$sendersCounter$iv$iv / BufferedChannelKt.SEGMENT_SIZE;
            int i$iv = (int) ($this$sendersCounter$iv$iv % BufferedChannelKt.SEGMENT_SIZE);
            if (segment$iv2.id != id$iv) {
                ChannelSegment segment$iv3 = findSegmentSend(id$iv, segment$iv2);
                if (segment$iv3 != null) {
                    segment$iv = segment$iv3;
                } else if (closed$iv) {
                    onClosedSelectOnSend(element, selectInstance);
                    return;
                }
            } else {
                segment$iv = segment$iv2;
            }
            ChannelSegment segment$iv4 = segment$iv;
            int $i$f$sendImpl2 = $i$f$sendImpl;
            switch (updateCellSend(segment$iv, i$iv, element, $this$sendersCounter$iv$iv, selectInstance, closed$iv)) {
                case 0:
                    segment$iv4.cleanPrev();
                    selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
                    return;
                case 1:
                    selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
                    return;
                case 2:
                    if (closed$iv) {
                        segment$iv4.onSlotCleaned();
                        onClosedSelectOnSend(element, selectInstance);
                        return;
                    }
                    Waiter waiter = selectInstance instanceof Waiter ? (Waiter) selectInstance : null;
                    if (waiter != null) {
                        prepareSenderForSuspension(waiter, segment$iv4, i$iv);
                    }
                    return;
                case 3:
                    throw new IllegalStateException("unexpected".toString());
                case 4:
                    if ($this$sendersCounter$iv$iv < getReceiversCounter$kotlinx_coroutines_core()) {
                        segment$iv4.cleanPrev();
                    }
                    onClosedSelectOnSend(element, selectInstance);
                    return;
                case 5:
                    segment$iv4.cleanPrev();
                    break;
            }
            segment$iv2 = segment$iv4;
            $i$f$sendImpl = $i$f$sendImpl2;
        }
    }

    private final void onClosedSelectOnSend(E e, SelectInstance<?> selectInstance) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, e, selectInstance.getContext());
        }
        selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectSend(Object ignoredParam, Object selectResult) {
        if (selectResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
            throw getSendException();
        }
        return this;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceive() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceiveOrNull() {
        BufferedChannel$onReceiveOrNull$1 bufferedChannel$onReceiveOrNull$1 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onReceiveOrNull$2 bufferedChannel$onReceiveOrNull$2 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForReceive(SelectInstance<?> selectInstance, Object ignoredParam) {
        ChannelSegment segment$iv = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long r$iv = access$getReceivers$volatile$FU().getAndIncrement(this);
            long id$iv = r$iv / BufferedChannelKt.SEGMENT_SIZE;
            int i$iv = (int) (r$iv % BufferedChannelKt.SEGMENT_SIZE);
            if (segment$iv.id != id$iv) {
                ChannelSegment findSegmentReceive = findSegmentReceive(id$iv, segment$iv);
                if (findSegmentReceive == null) {
                    continue;
                } else {
                    segment$iv = findSegmentReceive;
                }
            }
            Object updCellResult$iv = updateCellReceive(segment$iv, i$iv, r$iv, selectInstance);
            if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                Waiter waiter = selectInstance instanceof Waiter ? (Waiter) selectInstance : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, segment$iv, i$iv);
                }
                return;
            } else if (updCellResult$iv == BufferedChannelKt.access$getFAILED$p()) {
                if (r$iv < getSendersCounter$kotlinx_coroutines_core()) {
                    segment$iv.cleanPrev();
                }
            } else if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                throw new IllegalStateException("unexpected".toString());
            } else {
                segment$iv.cleanPrev();
                selectInstance.selectInRegistrationPhase(updCellResult$iv);
                return;
            }
        }
        onClosedSelectOnReceive(selectInstance);
    }

    private final void onClosedSelectOnReceive(SelectInstance<?> selectInstance) {
        selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectReceive(Object ignoredParam, Object selectResult) {
        if (selectResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
            throw getReceiveException();
        }
        return selectResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectReceiveOrNull(Object ignoredParam, Object selectResult) {
        if (selectResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
            if (getCloseCause() == null) {
                return null;
            }
            throw getReceiveException();
        }
        return selectResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectReceiveCatching(Object ignoredParam, Object selectResult) {
        return ChannelResult.m1410boximpl(selectResult == BufferedChannelKt.getCHANNEL_CLOSED() ? ChannelResult.Companion.m1423closedJP2dKIU(getCloseCause()) : ChannelResult.Companion.m1425successJP2dKIU(selectResult));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return new BufferedChannelIterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BufferedChannel.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u0006H\u0096B¢\u0006\u0002\u0010\nJ,\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0013\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "receiveResult", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", "index", "", "r", "", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", "", "Lkotlinx/coroutines/internal/Segment;", "next", "()Ljava/lang/Object;", "onClosedHasNext", "onClosedHasNextNoWaiterSuspend", "tryResumeHasNext", "element", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {
        private CancellableContinuationImpl<? super Boolean> continuation;
        private Object receiveResult = BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();

        public BufferedChannelIterator() {
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public /* synthetic */ Object next(Continuation $completion) {
            return ChannelIterator.DefaultImpls.next(this, $completion);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object hasNext(Continuation<? super Boolean> continuation) {
            ChannelSegment segment$iv;
            BufferedChannel this_$iv = BufferedChannel.this;
            ChannelSegment segment$iv2 = (ChannelSegment) BufferedChannel.access$getReceiveSegment$volatile$FU().get(this_$iv);
            while (!this_$iv.isClosedForReceive()) {
                long r$iv = BufferedChannel.access$getReceivers$volatile$FU().getAndIncrement(this_$iv);
                long id$iv = r$iv / BufferedChannelKt.SEGMENT_SIZE;
                int i$iv = (int) (r$iv % BufferedChannelKt.SEGMENT_SIZE);
                if (segment$iv2.id != id$iv) {
                    ChannelSegment segment$iv3 = this_$iv.findSegmentReceive(id$iv, segment$iv2);
                    if (segment$iv3 == null) {
                        continue;
                    } else {
                        segment$iv = segment$iv3;
                    }
                } else {
                    segment$iv = segment$iv2;
                }
                Object updCellResult$iv = this_$iv.updateCellReceive(segment$iv, i$iv, r$iv, null);
                if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                    throw new IllegalStateException("unreachable".toString());
                }
                if (updCellResult$iv == BufferedChannelKt.access$getFAILED$p()) {
                    if (r$iv < this_$iv.getSendersCounter$kotlinx_coroutines_core()) {
                        segment$iv.cleanPrev();
                    }
                    segment$iv2 = segment$iv;
                } else if (updCellResult$iv != BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                    segment$iv.cleanPrev();
                    this.receiveResult = updCellResult$iv;
                    return Boxing.boxBoolean(true);
                } else {
                    ChannelSegment segm = segment$iv;
                    return hasNextOnNoWaiterSuspend(segm, i$iv, r$iv, continuation);
                }
            }
            return Boxing.boxBoolean(onClosedHasNext());
        }

        private final boolean onClosedHasNext() {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable cause = BufferedChannel.this.getCloseCause();
            if (cause == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(cause);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object hasNextOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int index, long r, Continuation<? super Boolean> continuation) {
            ChannelSegment segment$iv$iv;
            BufferedChannel this_$iv = BufferedChannel.this;
            boolean z = false;
            Continuation<? super Boolean> continuation2 = continuation;
            boolean z2 = false;
            CancellableContinuationImpl cancellable$iv = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation2));
            boolean z3 = false;
            try {
                this.continuation = cancellable$iv;
                Object updCellResult$iv = this_$iv.updateCellReceive(channelSegment, index, r, this);
                try {
                    if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                        try {
                            this_$iv.prepareReceiverForSuspension(this, channelSegment, index);
                        } catch (Throwable th) {
                            e$iv = th;
                            cancellable$iv.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                            throw e$iv;
                        }
                    } else {
                        try {
                            if (updCellResult$iv != BufferedChannelKt.access$getFAILED$p()) {
                                channelSegment.cleanPrev();
                                this.receiveResult = updCellResult$iv;
                                this.continuation = null;
                                Boolean boxBoolean = Boxing.boxBoolean(true);
                                Function1<E, Unit> function1 = this_$iv.onUndeliveredElement;
                                cancellable$iv.resume(boxBoolean, function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, updCellResult$iv, cancellable$iv.getContext()) : null);
                            } else {
                                if (r < this_$iv.getSendersCounter$kotlinx_coroutines_core()) {
                                    channelSegment.cleanPrev();
                                }
                                ChannelSegment segment$iv$iv2 = (ChannelSegment) BufferedChannel.access$getReceiveSegment$volatile$FU().get(this_$iv);
                                while (!this_$iv.isClosedForReceive()) {
                                    long r$iv$iv = BufferedChannel.access$getReceivers$volatile$FU().getAndIncrement(this_$iv);
                                    long id$iv$iv = r$iv$iv / BufferedChannelKt.SEGMENT_SIZE;
                                    boolean z4 = z;
                                    Continuation<? super Boolean> continuation3 = continuation2;
                                    try {
                                        int i$iv$iv = (int) (r$iv$iv % BufferedChannelKt.SEGMENT_SIZE);
                                        boolean z5 = z2;
                                        if (segment$iv$iv2.id != id$iv$iv) {
                                            segment$iv$iv = this_$iv.findSegmentReceive(id$iv$iv, segment$iv$iv2);
                                            if (segment$iv$iv == null) {
                                                z = z4;
                                                continuation2 = continuation3;
                                                z2 = z5;
                                            }
                                        } else {
                                            segment$iv$iv = segment$iv$iv2;
                                        }
                                        boolean z6 = z3;
                                        Object updCellResult$iv2 = updCellResult$iv;
                                        Object updCellResult$iv$iv = this_$iv.updateCellReceive(segment$iv$iv, i$iv$iv, r$iv$iv, this);
                                        if (updCellResult$iv$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                                            BufferedChannelIterator bufferedChannelIterator = this instanceof Waiter ? this : null;
                                            if (bufferedChannelIterator != null) {
                                                this_$iv.prepareReceiverForSuspension(bufferedChannelIterator, segment$iv$iv, i$iv$iv);
                                            }
                                        } else if (updCellResult$iv$iv == BufferedChannelKt.access$getFAILED$p()) {
                                            if (r$iv$iv < this_$iv.getSendersCounter$kotlinx_coroutines_core()) {
                                                segment$iv$iv.cleanPrev();
                                            }
                                            segment$iv$iv2 = segment$iv$iv;
                                            z3 = z6;
                                            z = z4;
                                            continuation2 = continuation3;
                                            z2 = z5;
                                            updCellResult$iv = updCellResult$iv2;
                                        } else if (updCellResult$iv$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                                            throw new IllegalStateException("unexpected".toString());
                                        } else {
                                            segment$iv$iv.cleanPrev();
                                            this.receiveResult = updCellResult$iv$iv;
                                            this.continuation = null;
                                            Boolean boxBoolean2 = Boxing.boxBoolean(true);
                                            Function1<E, Unit> function12 = this_$iv.onUndeliveredElement;
                                            cancellable$iv.resume(boxBoolean2, function12 != null ? OnUndeliveredElementKt.bindCancellationFun(function12, updCellResult$iv$iv, cancellable$iv.getContext()) : null);
                                        }
                                    } catch (Throwable th2) {
                                        e$iv = th2;
                                        cancellable$iv.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                                        throw e$iv;
                                    }
                                }
                                onClosedHasNextNoWaiterSuspend();
                            }
                        } catch (Throwable th3) {
                            e$iv = th3;
                        }
                    }
                    Object result = cancellable$iv.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation);
                    }
                    return result;
                } catch (Throwable th4) {
                    e$iv = th4;
                }
            } catch (Throwable th5) {
                e$iv = th5;
            }
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(Segment<?> segment, int index) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, index);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void onClosedHasNextNoWaiterSuspend() {
            Throwable th;
            CancellableContinuationImpl cont = this.continuation;
            Intrinsics.checkNotNull(cont);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable cause = BufferedChannel.this.getCloseCause();
            if (cause == null) {
                Result.Companion companion = Result.Companion;
                cont.resumeWith(Result.constructor-impl(false));
                return;
            }
            CancellableContinuationImpl cancellableContinuationImpl = cont;
            if (DebugKt.getRECOVER_STACK_TRACES() && (cont instanceof CoroutineStackFrame)) {
                th = StackTraceRecoveryKt.recoverFromStackFrame(cause, cont);
            } else {
                th = cause;
            }
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.constructor-impl(ResultKt.createFailure(th)));
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E e = (E) this.receiveResult;
            if (e != BufferedChannelKt.access$getNO_RECEIVE_RESULT$p()) {
                this.receiveResult = BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();
                if (e == BufferedChannelKt.getCHANNEL_CLOSED()) {
                    throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.this.getReceiveException());
                }
                return e;
            }
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }

        public final boolean tryResumeHasNext(E e) {
            CancellableContinuationImpl cont = this.continuation;
            Intrinsics.checkNotNull(cont);
            this.continuation = null;
            this.receiveResult = e;
            CancellableContinuationImpl cancellableContinuationImpl = cont;
            Function1<E, Unit> function1 = BufferedChannel.this.onUndeliveredElement;
            return BufferedChannelKt.access$tryResume0(cancellableContinuationImpl, true, function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, e, cont.getContext()) : null);
        }

        public final void tryResumeHasNextOnClosedChannel() {
            Throwable th;
            CancellableContinuationImpl cont = this.continuation;
            Intrinsics.checkNotNull(cont);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable cause = BufferedChannel.this.getCloseCause();
            if (cause == null) {
                Result.Companion companion = Result.Companion;
                cont.resumeWith(Result.constructor-impl(false));
                return;
            }
            CancellableContinuationImpl cancellableContinuationImpl = cont;
            if (DebugKt.getRECOVER_STACK_TRACES() && (cont instanceof CoroutineStackFrame)) {
                th = StackTraceRecoveryKt.recoverFromStackFrame(cause, cont);
            } else {
                th = cause;
            }
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.constructor-impl(ResultKt.createFailure(th)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Throwable getCloseCause() {
        return (Throwable) _closeCause$volatile$FU.get(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable getReceiveException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    protected void onClosedIdempotent() {
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        return closeOrCancelImpl(cause, false);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean cancel(Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        cancelImpl$kotlinx_coroutines_core(null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cause) {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable cause) {
        return closeOrCancelImpl(cause == null ? new CancellationException("Channel was cancelled") : cause, true);
    }

    protected boolean closeOrCancelImpl(Throwable cause, boolean cancel) {
        if (cancel) {
            markCancellationStarted();
        }
        boolean closedByThisOperation = AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_closeCause$volatile$FU, this, BufferedChannelKt.access$getNO_CLOSE_CAUSE$p(), cause);
        if (cancel) {
            markCancelled();
        } else {
            markClosed();
        }
        completeCloseOrCancel();
        onClosedIdempotent();
        if (closedByThisOperation) {
            invokeCloseHandler();
        }
        return closedByThisOperation;
    }

    private final void invokeCloseHandler() {
        Object it;
        Symbol access$getCLOSE_HANDLER_INVOKED$p;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = closeHandler$volatile$FU;
        do {
            it = handler$atomicfu$iv.get(this);
            if (it == null) {
                access$getCLOSE_HANDLER_INVOKED$p = BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p();
            } else {
                access$getCLOSE_HANDLER_INVOKED$p = BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p();
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(handler$atomicfu$iv, this, it, access$getCLOSE_HANDLER_INVOKED$p));
        if (it != null) {
            Function1 function1 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(it, 1);
            ((Function1) it).invoke(getCloseCause());
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: invokeOnClose */
    public void mo1469invokeOnClose(Function1<? super Throwable, Unit> function1) {
        if (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(closeHandler$volatile$FU, this, (Object) null, function1)) {
            AtomicReferenceFieldUpdater handler$atomicfu$iv = closeHandler$volatile$FU;
            do {
                Object cur = handler$atomicfu$iv.get(this);
                if (cur != BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p()) {
                    if (cur != BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p()) {
                        throw new IllegalStateException(("Another handler is already registered: " + cur).toString());
                    }
                    throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                }
            } while (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(closeHandler$volatile$FU, this, BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p(), BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p()));
            function1.invoke(getCloseCause());
        }
    }

    private final void markClosed() {
        long cur;
        long access$constructSendersAndCloseStatus;
        AtomicLongFieldUpdater handler$atomicfu$iv = sendersAndCloseStatus$volatile$FU;
        do {
            cur = handler$atomicfu$iv.get(this);
            int $i$f$getSendersCloseStatus = (int) (cur >> 60);
            switch ($i$f$getSendersCloseStatus) {
                case 0:
                    access$constructSendersAndCloseStatus = BufferedChannelKt.access$constructSendersAndCloseStatus(1152921504606846975L & cur, 2);
                    break;
                case 1:
                    access$constructSendersAndCloseStatus = BufferedChannelKt.access$constructSendersAndCloseStatus(1152921504606846975L & cur, 3);
                    break;
                default:
                    return;
            }
        } while (!handler$atomicfu$iv.compareAndSet(this, cur, access$constructSendersAndCloseStatus));
    }

    private final void markCancelled() {
        long cur;
        long $this$sendersCounter$iv;
        AtomicLongFieldUpdater handler$atomicfu$iv = sendersAndCloseStatus$volatile$FU;
        do {
            cur = handler$atomicfu$iv.get(this);
            $this$sendersCounter$iv = cur & 1152921504606846975L;
        } while (!handler$atomicfu$iv.compareAndSet(this, cur, BufferedChannelKt.access$constructSendersAndCloseStatus($this$sendersCounter$iv, 3)));
    }

    private final void markCancellationStarted() {
        long cur;
        long $this$sendersCounter$iv;
        AtomicLongFieldUpdater handler$atomicfu$iv = sendersAndCloseStatus$volatile$FU;
        do {
            cur = handler$atomicfu$iv.get(this);
            int $i$f$getSendersCloseStatus = (int) (cur >> 60);
            if ($i$f$getSendersCloseStatus == 0) {
                $this$sendersCounter$iv = cur & 1152921504606846975L;
            } else {
                return;
            }
        } while (!handler$atomicfu$iv.compareAndSet(this, cur, BufferedChannelKt.access$constructSendersAndCloseStatus($this$sendersCounter$iv, 1)));
    }

    private final void completeCloseOrCancel() {
        isClosedForSend();
    }

    protected boolean isConflatedDropOldest() {
        return false;
    }

    private final ChannelSegment<E> completeClose(long sendersCur) {
        ChannelSegment lastSegment = closeLinkedList();
        if (isConflatedDropOldest()) {
            long lastBufferedCellGlobalIndex = markAllEmptyCellsAsClosed(lastSegment);
            if (lastBufferedCellGlobalIndex != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(lastBufferedCellGlobalIndex);
            }
        }
        cancelSuspendedReceiveRequests(lastSegment, sendersCur);
        return lastSegment;
    }

    private final void completeCancel(long sendersCur) {
        ChannelSegment lastSegment = completeClose(sendersCur);
        removeUnprocessedElements(lastSegment);
    }

    private final ChannelSegment<E> closeLinkedList() {
        Object lastSegment = bufferEndSegment$volatile$FU.get(this);
        ChannelSegment it = (ChannelSegment) sendSegment$volatile$FU.get(this);
        if (it.id > ((ChannelSegment) lastSegment).id) {
            lastSegment = it;
        }
        ChannelSegment it2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        if (it2.id > ((ChannelSegment) lastSegment).id) {
            lastSegment = it2;
        }
        return (ChannelSegment) ConcurrentLinkedListKt.close((ConcurrentLinkedListNode) lastSegment);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
        r1 = (kotlinx.coroutines.channels.ChannelSegment) r0.getPrev();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
        if (r1 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long markAllEmptyCellsAsClosed(ChannelSegment<E> channelSegment) {
        ChannelSegment channelSegment2;
        ChannelSegment segment = channelSegment;
        while (true) {
            int index = BufferedChannelKt.SEGMENT_SIZE;
            while (true) {
                index--;
                if (-1 >= index) {
                    break;
                }
                long globalIndex = (segment.id * BufferedChannelKt.SEGMENT_SIZE) + index;
                if (globalIndex < getReceiversCounter$kotlinx_coroutines_core()) {
                    return -1L;
                }
                while (true) {
                    Object state = segment.getState$kotlinx_coroutines_core(index);
                    if (state == null || state == BufferedChannelKt.access$getIN_BUFFER$p()) {
                        if (segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            segment.onSlotCleaned();
                            break;
                        }
                    } else if (state == BufferedChannelKt.BUFFERED) {
                        return globalIndex;
                    }
                }
            }
            segment = channelSegment2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ba, code lost:
        r5 = (kotlinx.coroutines.channels.ChannelSegment) r4.getPrev();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c0, code lost:
        if (r5 != null) goto L87;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void removeUnprocessedElements(ChannelSegment<E> channelSegment) {
        ChannelSegment channelSegment2;
        Function1 onUndeliveredElement = this.onUndeliveredElement;
        UndeliveredElementException undeliveredElementException = null;
        Object suspendedSenders = InlineList.m1447constructorimpl$default(null, 1, null);
        ChannelSegment segment = channelSegment;
        loop0: while (true) {
            int index = BufferedChannelKt.SEGMENT_SIZE - 1;
            while (true) {
                if (-1 >= index) {
                    break;
                }
                long globalIndex = (segment.id * BufferedChannelKt.SEGMENT_SIZE) + index;
                while (true) {
                    Object state = segment.getState$kotlinx_coroutines_core(index);
                    if (state == BufferedChannelKt.access$getDONE_RCV$p()) {
                        break loop0;
                    } else if (state == BufferedChannelKt.BUFFERED) {
                        if (globalIndex < getReceiversCounter$kotlinx_coroutines_core()) {
                            break loop0;
                        } else if (segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            if (onUndeliveredElement != null) {
                                Object element = segment.getElement$kotlinx_coroutines_core(index);
                                undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(onUndeliveredElement, element, undeliveredElementException);
                            }
                            segment.cleanElement$kotlinx_coroutines_core(index);
                            segment.onSlotCleaned();
                        }
                    } else if (state == BufferedChannelKt.access$getIN_BUFFER$p() || state == null) {
                        if (segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            segment.onSlotCleaned();
                            break;
                        }
                    } else if ((state instanceof Waiter) || (state instanceof WaiterEB)) {
                        if (globalIndex < getReceiversCounter$kotlinx_coroutines_core()) {
                            break loop0;
                        }
                        Waiter sender = state instanceof WaiterEB ? ((WaiterEB) state).waiter : (Waiter) state;
                        if (segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            if (onUndeliveredElement != null) {
                                Object element2 = segment.getElement$kotlinx_coroutines_core(index);
                                undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(onUndeliveredElement, element2, undeliveredElementException);
                            }
                            suspendedSenders = InlineList.m1452plusFjFbRPM(suspendedSenders, sender);
                            segment.cleanElement$kotlinx_coroutines_core(index);
                            segment.onSlotCleaned();
                        }
                    } else if (state == BufferedChannelKt.access$getRESUMING_BY_EB$p() || state == BufferedChannelKt.access$getRESUMING_BY_RCV$p()) {
                        break loop0;
                    } else if (state != BufferedChannelKt.access$getRESUMING_BY_EB$p()) {
                        break;
                    }
                }
                index--;
            }
            segment = channelSegment2;
        }
        if (suspendedSenders != null) {
            if (!(suspendedSenders instanceof ArrayList)) {
                Waiter it = (Waiter) suspendedSenders;
                resumeSenderOnCancelledChannel(it);
            } else {
                Intrinsics.checkNotNull(suspendedSenders, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                ArrayList list$iv = (ArrayList) suspendedSenders;
                for (int i$iv = list$iv.size() - 1; -1 < i$iv; i$iv--) {
                    Waiter it2 = (Waiter) list$iv.get(i$iv);
                    resumeSenderOnCancelledChannel(it2);
                }
            }
        }
        if (undeliveredElementException != null) {
            UndeliveredElementException it3 = undeliveredElementException;
            throw it3;
        }
    }

    private final void cancelSuspendedReceiveRequests(ChannelSegment<E> channelSegment, long sendersCounter) {
        Object suspendedReceivers = InlineList.m1447constructorimpl$default(null, 1, null);
        loop0: for (ChannelSegment segment = channelSegment; segment != null; segment = (ChannelSegment) segment.getPrev()) {
            for (int index = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < index; index--) {
                if ((segment.id * BufferedChannelKt.SEGMENT_SIZE) + index < sendersCounter) {
                    break loop0;
                }
                while (true) {
                    Object state = segment.getState$kotlinx_coroutines_core(index);
                    if (state == null || state == BufferedChannelKt.access$getIN_BUFFER$p()) {
                        if (segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            segment.onSlotCleaned();
                            break;
                        }
                    } else if (state instanceof WaiterEB) {
                        if (segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            suspendedReceivers = InlineList.m1452plusFjFbRPM(suspendedReceivers, ((WaiterEB) state).waiter);
                            segment.onCancelledRequest(index, true);
                            break;
                        }
                    } else if (!(state instanceof Waiter)) {
                        break;
                    } else if (segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.getCHANNEL_CLOSED())) {
                        suspendedReceivers = InlineList.m1452plusFjFbRPM(suspendedReceivers, state);
                        segment.onCancelledRequest(index, true);
                        break;
                    }
                }
            }
        }
        if (suspendedReceivers == null) {
            return;
        }
        if (!(suspendedReceivers instanceof ArrayList)) {
            Waiter it = (Waiter) suspendedReceivers;
            resumeReceiverOnClosedChannel(it);
            return;
        }
        Intrinsics.checkNotNull(suspendedReceivers, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList list$iv = (ArrayList) suspendedReceivers;
        for (int i$iv = list$iv.size() - 1; -1 < i$iv; i$iv--) {
            Waiter it2 = (Waiter) list$iv.get(i$iv);
            resumeReceiverOnClosedChannel(it2);
        }
    }

    private final void resumeReceiverOnClosedChannel(Waiter $this$resumeReceiverOnClosedChannel) {
        resumeWaiterOnClosedChannel($this$resumeReceiverOnClosedChannel, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter $this$resumeSenderOnCancelledChannel) {
        resumeWaiterOnClosedChannel($this$resumeSenderOnCancelledChannel, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter $this$resumeWaiterOnClosedChannel, boolean receiver) {
        if (!($this$resumeWaiterOnClosedChannel instanceof SendBroadcast)) {
            if (!($this$resumeWaiterOnClosedChannel instanceof CancellableContinuation)) {
                if (!($this$resumeWaiterOnClosedChannel instanceof ReceiveCatching)) {
                    if (!($this$resumeWaiterOnClosedChannel instanceof BufferedChannelIterator)) {
                        if (!($this$resumeWaiterOnClosedChannel instanceof SelectInstance)) {
                            throw new IllegalStateException(("Unexpected waiter: " + $this$resumeWaiterOnClosedChannel).toString());
                        }
                        ((SelectInstance) $this$resumeWaiterOnClosedChannel).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
                        return;
                    }
                    ((BufferedChannelIterator) $this$resumeWaiterOnClosedChannel).tryResumeHasNextOnClosedChannel();
                    return;
                }
                Result.Companion companion = Result.Companion;
                ((ReceiveCatching) $this$resumeWaiterOnClosedChannel).cont.resumeWith(Result.constructor-impl(ChannelResult.m1410boximpl(ChannelResult.Companion.m1423closedJP2dKIU(getCloseCause()))));
                return;
            }
            Continuation continuation = (Continuation) $this$resumeWaiterOnClosedChannel;
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(receiver ? getReceiveException() : getSendException())));
            return;
        }
        Result.Companion companion3 = Result.Companion;
        ((SendBroadcast) $this$resumeWaiterOnClosedChannel).getCont().resumeWith(Result.constructor-impl(false));
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return isClosedForSend0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isClosedForSend0(long $this$isClosedForSend0) {
        return isClosed($this$isClosedForSend0, false);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return isClosedForReceive0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    private final boolean isClosedForReceive0(long $this$isClosedForReceive0) {
        return isClosed($this$isClosedForReceive0, true);
    }

    private final boolean isClosed(long sendersAndCloseStatusCur, boolean isClosedForReceive) {
        long $this$sendersCloseStatus$iv = (int) (sendersAndCloseStatusCur >> 60);
        switch ($this$sendersCloseStatus$iv) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                completeClose(sendersAndCloseStatusCur & 1152921504606846975L);
                return (isClosedForReceive && hasElements$kotlinx_coroutines_core()) ? false : true;
            case 3:
                completeCancel(sendersAndCloseStatusCur & 1152921504606846975L);
                return true;
            default:
                throw new IllegalStateException(("unexpected close status: " + ((int) (sendersAndCloseStatusCur >> 60))).toString());
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        if (isClosedForReceive() || hasElements$kotlinx_coroutines_core()) {
            return false;
        }
        return !isClosedForReceive();
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            ChannelSegment segment = (ChannelSegment) receiveSegment$volatile$FU.get(this);
            long r = getReceiversCounter$kotlinx_coroutines_core();
            long s = getSendersCounter$kotlinx_coroutines_core();
            if (s <= r) {
                return false;
            }
            long id = r / BufferedChannelKt.SEGMENT_SIZE;
            if (segment.id != id) {
                ChannelSegment findSegmentReceive = findSegmentReceive(id, segment);
                if (findSegmentReceive != null) {
                    segment = findSegmentReceive;
                } else if (((ChannelSegment) receiveSegment$volatile$FU.get(this)).id < id) {
                    return false;
                }
            }
            segment.cleanPrev();
            int i = (int) (r % BufferedChannelKt.SEGMENT_SIZE);
            if (isCellNonEmpty(segment, i, r)) {
                return true;
            }
            receivers$volatile$FU.compareAndSet(this, r, r + 1);
        }
    }

    private final boolean isCellNonEmpty(ChannelSegment<E> channelSegment, int index, long globalIndex) {
        Object state;
        do {
            state = channelSegment.getState$kotlinx_coroutines_core(index);
            if (state != null && state != BufferedChannelKt.access$getIN_BUFFER$p()) {
                if (state == BufferedChannelKt.BUFFERED) {
                    return true;
                }
                if (state == BufferedChannelKt.access$getINTERRUPTED_SEND$p() || state == BufferedChannelKt.getCHANNEL_CLOSED() || state == BufferedChannelKt.access$getDONE_RCV$p() || state == BufferedChannelKt.access$getPOISONED$p()) {
                    return false;
                }
                if (state == BufferedChannelKt.access$getRESUMING_BY_EB$p()) {
                    return true;
                }
                return state != BufferedChannelKt.access$getRESUMING_BY_RCV$p() && globalIndex == getReceiversCounter$kotlinx_coroutines_core();
            }
        } while (!channelSegment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getPOISONED$p()));
        expandBuffer();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentSend(long id, ChannelSegment<E> channelSegment) {
        Object s$iv;
        Segment to$iv$iv;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = sendSegment$volatile$FU;
        Function2 createNewSegment$iv = (Function2) BufferedChannelKt.createSegmentFunction();
        do {
            s$iv = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, id, createNewSegment$iv);
            if (SegmentOrClosed.m1464isClosedimpl(s$iv)) {
                break;
            }
            Segment to$iv$iv2 = SegmentOrClosed.m1462getSegmentimpl(s$iv);
            while (true) {
                Segment cur$iv$iv = (Segment) handler$atomicfu$iv.get(this);
                if (cur$iv$iv.id >= to$iv$iv2.id) {
                    to$iv$iv = 1;
                    continue;
                    break;
                } else if (!to$iv$iv2.tryIncPointers$kotlinx_coroutines_core()) {
                    to$iv$iv = null;
                    continue;
                    break;
                } else if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(handler$atomicfu$iv, this, cur$iv$iv, to$iv$iv2)) {
                    if (cur$iv$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv$iv.remove();
                    }
                    to$iv$iv = 1;
                    continue;
                } else if (to$iv$iv2.decPointers$kotlinx_coroutines_core()) {
                    to$iv$iv2.remove();
                }
            }
        } while (to$iv$iv == null);
        if (SegmentOrClosed.m1464isClosedimpl(s$iv)) {
            completeCloseOrCancel();
            if (channelSegment.id * BufferedChannelKt.SEGMENT_SIZE < getReceiversCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
                return null;
            }
            return null;
        }
        ChannelSegment segment = (ChannelSegment) SegmentOrClosed.m1462getSegmentimpl(s$iv);
        if (segment.id > id) {
            updateSendersCounterIfLower(segment.id * BufferedChannelKt.SEGMENT_SIZE);
            if (segment.id * BufferedChannelKt.SEGMENT_SIZE < getReceiversCounter$kotlinx_coroutines_core()) {
                segment.cleanPrev();
                return null;
            }
            return null;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(segment.id == id)) {
                throw new AssertionError();
            }
        }
        return segment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentReceive(long id, ChannelSegment<E> channelSegment) {
        Object s$iv;
        Segment to$iv$iv;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = receiveSegment$volatile$FU;
        Function2 createNewSegment$iv = (Function2) BufferedChannelKt.createSegmentFunction();
        do {
            s$iv = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, id, createNewSegment$iv);
            if (SegmentOrClosed.m1464isClosedimpl(s$iv)) {
                break;
            }
            Segment to$iv$iv2 = SegmentOrClosed.m1462getSegmentimpl(s$iv);
            while (true) {
                Segment cur$iv$iv = (Segment) handler$atomicfu$iv.get(this);
                if (cur$iv$iv.id >= to$iv$iv2.id) {
                    to$iv$iv = 1;
                    continue;
                    break;
                } else if (!to$iv$iv2.tryIncPointers$kotlinx_coroutines_core()) {
                    to$iv$iv = null;
                    continue;
                    break;
                } else if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(handler$atomicfu$iv, this, cur$iv$iv, to$iv$iv2)) {
                    if (cur$iv$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv$iv.remove();
                    }
                    to$iv$iv = 1;
                    continue;
                } else if (to$iv$iv2.decPointers$kotlinx_coroutines_core()) {
                    to$iv$iv2.remove();
                }
            }
        } while (to$iv$iv == null);
        if (SegmentOrClosed.m1464isClosedimpl(s$iv)) {
            completeCloseOrCancel();
            if (channelSegment.id * BufferedChannelKt.SEGMENT_SIZE < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            return null;
        }
        ChannelSegment segment = (ChannelSegment) SegmentOrClosed.m1462getSegmentimpl(s$iv);
        if (!isRendezvousOrUnlimited() && id <= getBufferEndCounter() / BufferedChannelKt.SEGMENT_SIZE) {
            AtomicReferenceFieldUpdater handler$atomicfu$iv2 = bufferEndSegment$volatile$FU;
            while (true) {
                Segment cur$iv = (Segment) handler$atomicfu$iv2.get(this);
                if (cur$iv.id >= segment.id || !segment.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                } else if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(handler$atomicfu$iv2, this, cur$iv, segment)) {
                    if (cur$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv.remove();
                    }
                } else if (segment.decPointers$kotlinx_coroutines_core()) {
                    segment.remove();
                }
            }
        }
        if (segment.id > id) {
            updateReceiversCounterIfLower(segment.id * BufferedChannelKt.SEGMENT_SIZE);
            if (segment.id * BufferedChannelKt.SEGMENT_SIZE < getSendersCounter$kotlinx_coroutines_core()) {
                segment.cleanPrev();
            }
            return null;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(segment.id == id)) {
                throw new AssertionError();
            }
        }
        return segment;
    }

    private final ChannelSegment<E> findSegmentBufferEnd(long id, ChannelSegment<E> channelSegment, long currentBufferEndCounter) {
        Object s$iv;
        Segment to$iv$iv;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = bufferEndSegment$volatile$FU;
        Function2 createNewSegment$iv = (Function2) BufferedChannelKt.createSegmentFunction();
        do {
            s$iv = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, id, createNewSegment$iv);
            if (SegmentOrClosed.m1464isClosedimpl(s$iv)) {
                break;
            }
            Segment to$iv$iv2 = SegmentOrClosed.m1462getSegmentimpl(s$iv);
            while (true) {
                Segment cur$iv$iv = (Segment) handler$atomicfu$iv.get(this);
                if (cur$iv$iv.id >= to$iv$iv2.id) {
                    to$iv$iv = 1;
                    continue;
                    break;
                } else if (!to$iv$iv2.tryIncPointers$kotlinx_coroutines_core()) {
                    to$iv$iv = null;
                    continue;
                    break;
                } else if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(handler$atomicfu$iv, this, cur$iv$iv, to$iv$iv2)) {
                    if (cur$iv$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv$iv.remove();
                    }
                    to$iv$iv = 1;
                    continue;
                } else if (to$iv$iv2.decPointers$kotlinx_coroutines_core()) {
                    to$iv$iv2.remove();
                }
            }
        } while (to$iv$iv == null);
        if (SegmentOrClosed.m1464isClosedimpl(s$iv)) {
            completeCloseOrCancel();
            moveSegmentBufferEndToSpecifiedOrLast(id, channelSegment);
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            return null;
        }
        ChannelSegment segment = (ChannelSegment) SegmentOrClosed.m1462getSegmentimpl(s$iv);
        if (segment.id > id) {
            if (bufferEnd$volatile$FU.compareAndSet(this, currentBufferEndCounter + 1, segment.id * BufferedChannelKt.SEGMENT_SIZE)) {
                incCompletedExpandBufferAttempts((segment.id * BufferedChannelKt.SEGMENT_SIZE) - currentBufferEndCounter);
                return null;
            }
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            return null;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(segment.id == id)) {
                throw new AssertionError();
            }
        }
        return segment;
    }

    private final void moveSegmentBufferEndToSpecifiedOrLast(long id, ChannelSegment<E> channelSegment) {
        boolean z;
        ChannelSegment channelSegment2;
        ChannelSegment channelSegment3;
        ChannelSegment segment = channelSegment;
        while (segment.id < id && (channelSegment3 = (ChannelSegment) segment.getNext()) != null) {
            segment = channelSegment3;
        }
        while (true) {
            if (!segment.isRemoved() || (channelSegment2 = (ChannelSegment) segment.getNext()) == null) {
                AtomicReferenceFieldUpdater handler$atomicfu$iv = bufferEndSegment$volatile$FU;
                while (true) {
                    Segment cur$iv = (Segment) handler$atomicfu$iv.get(this);
                    z = true;
                    if (cur$iv.id >= segment.id) {
                        break;
                    } else if (!segment.tryIncPointers$kotlinx_coroutines_core()) {
                        z = false;
                        break;
                    } else if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(handler$atomicfu$iv, this, cur$iv, segment)) {
                        if (cur$iv.decPointers$kotlinx_coroutines_core()) {
                            cur$iv.remove();
                        }
                    } else if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                }
                if (z) {
                    return;
                }
            } else {
                segment = channelSegment2;
            }
        }
    }

    private final void updateSendersCounterIfLower(long value) {
        long cur;
        long update;
        AtomicLongFieldUpdater handler$atomicfu$iv = sendersAndCloseStatus$volatile$FU;
        do {
            cur = handler$atomicfu$iv.get(this);
            long $this$sendersCounter$iv = cur & 1152921504606846975L;
            if ($this$sendersCounter$iv >= value) {
                return;
            }
            update = BufferedChannelKt.access$constructSendersAndCloseStatus($this$sendersCounter$iv, (int) (cur >> 60));
        } while (!sendersAndCloseStatus$volatile$FU.compareAndSet(this, cur, update));
    }

    private final void updateReceiversCounterIfLower(long value) {
        long cur;
        AtomicLongFieldUpdater handler$atomicfu$iv = receivers$volatile$FU;
        do {
            cur = handler$atomicfu$iv.get(this);
            if (cur >= value) {
                return;
            }
        } while (!receivers$volatile$FU.compareAndSet(this, cur, value));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        String obj;
        StringBuilder sb = new StringBuilder();
        long $this$sendersCloseStatus$iv = sendersAndCloseStatus$volatile$FU.get(this);
        switch ((int) ($this$sendersCloseStatus$iv >> 60)) {
            case 2:
                sb.append("closed,");
                break;
            case 3:
                sb.append("cancelled,");
                break;
        }
        sb.append("capacity=" + this.capacity + AbstractJsonLexerKt.COMMA);
        sb.append("data=[");
        Iterable $this$filter$iv = CollectionsKt.listOf((Object[]) new ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            ChannelSegment it = (ChannelSegment) element$iv$iv;
            ChannelSegment it2 = it != BufferedChannelKt.access$getNULL_SEGMENT$p() ? 1 : null;
            if (it2 != null) {
                arrayList.add(element$iv$iv);
            }
        }
        ArrayList $this$minBy$iv = arrayList;
        Iterator iterator$iv = $this$minBy$iv.iterator();
        if (iterator$iv.hasNext()) {
            Object minElem$iv = iterator$iv.next();
            if (iterator$iv.hasNext()) {
                ChannelSegment it3 = (ChannelSegment) minElem$iv;
                long minValue$iv = it3.id;
                while (true) {
                    Object e$iv = iterator$iv.next();
                    ChannelSegment it4 = (ChannelSegment) e$iv;
                    long v$iv = it4.id;
                    if (minValue$iv > v$iv) {
                        minElem$iv = e$iv;
                        minValue$iv = v$iv;
                    }
                    if (!iterator$iv.hasNext()) {
                    }
                }
            }
            ChannelSegment firstSegment = (ChannelSegment) minElem$iv;
            long r = getReceiversCounter$kotlinx_coroutines_core();
            long s = getSendersCounter$kotlinx_coroutines_core();
            ChannelSegment segment = firstSegment;
            while (true) {
                int i = 0;
                int i2 = BufferedChannelKt.SEGMENT_SIZE;
                while (true) {
                    if (i < i2) {
                        ChannelSegment firstSegment2 = firstSegment;
                        long globalCellIndex = (segment.id * BufferedChannelKt.SEGMENT_SIZE) + i;
                        if (globalCellIndex < s || globalCellIndex < r) {
                            Object cellState = segment.getState$kotlinx_coroutines_core(i);
                            Object element = segment.getElement$kotlinx_coroutines_core(i);
                            if (cellState instanceof CancellableContinuation) {
                                obj = (globalCellIndex >= r || globalCellIndex < s) ? (globalCellIndex >= s || globalCellIndex < r) ? "cont" : "send" : "receive";
                            } else if (cellState instanceof SelectInstance) {
                                obj = (globalCellIndex >= r || globalCellIndex < s) ? (globalCellIndex >= s || globalCellIndex < r) ? "select" : "onSend" : "onReceive";
                            } else if (cellState instanceof ReceiveCatching) {
                                obj = "receiveCatching";
                            } else if (cellState instanceof SendBroadcast) {
                                obj = "sendBroadcast";
                            } else if (cellState instanceof WaiterEB) {
                                obj = "EB(" + cellState + ')';
                            } else if (Intrinsics.areEqual(cellState, BufferedChannelKt.access$getRESUMING_BY_RCV$p()) ? true : Intrinsics.areEqual(cellState, BufferedChannelKt.access$getRESUMING_BY_EB$p())) {
                                obj = "resuming_sender";
                            } else if (cellState == null ? true : Intrinsics.areEqual(cellState, BufferedChannelKt.access$getIN_BUFFER$p()) ? true : Intrinsics.areEqual(cellState, BufferedChannelKt.access$getDONE_RCV$p()) ? true : Intrinsics.areEqual(cellState, BufferedChannelKt.access$getPOISONED$p()) ? true : Intrinsics.areEqual(cellState, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) ? true : Intrinsics.areEqual(cellState, BufferedChannelKt.access$getINTERRUPTED_SEND$p()) ? true : Intrinsics.areEqual(cellState, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                i++;
                                firstSegment = firstSegment2;
                            } else {
                                obj = cellState.toString();
                            }
                            String cellStateString = obj;
                            if (element != null) {
                                sb.append('(' + cellStateString + AbstractJsonLexerKt.COMMA + element + "),");
                            } else {
                                sb.append(cellStateString + AbstractJsonLexerKt.COMMA);
                            }
                            i++;
                            firstSegment = firstSegment2;
                        }
                    } else {
                        ChannelSegment firstSegment3 = firstSegment;
                        ChannelSegment channelSegment = (ChannelSegment) segment.getNext();
                        if (channelSegment != null) {
                            segment = channelSegment;
                            firstSegment = firstSegment3;
                        }
                    }
                }
            }
            if (StringsKt.last(sb) == ',') {
                Intrinsics.checkNotNullExpressionValue(sb.deleteCharAt(sb.length() - 1), "deleteCharAt(...)");
            }
            sb.append("]");
            return sb.toString();
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0290 A[LOOP:2: B:32:0x0189->B:66:0x0290, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x028b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String toStringDebug$kotlinx_coroutines_core() {
        ChannelSegment channelSegment;
        int i;
        int i2;
        ChannelSegment channelSegment2;
        StringBuilder sb = new StringBuilder();
        StringBuilder append = new StringBuilder().append("S=").append(getSendersCounter$kotlinx_coroutines_core()).append(",R=").append(getReceiversCounter$kotlinx_coroutines_core()).append(",B=").append(getBufferEndCounter()).append(",B'=").append(completedExpandBuffersAndPauseFlag$volatile$FU.get(this)).append(",C=");
        long $this$sendersCloseStatus$iv = sendersAndCloseStatus$volatile$FU.get(this);
        sb.append(append.append((int) ($this$sendersCloseStatus$iv >> 60)).append(AbstractJsonLexerKt.COMMA).toString());
        long $this$sendersCloseStatus$iv2 = sendersAndCloseStatus$volatile$FU.get(this);
        int $i$f$getSendersCloseStatus = (int) ($this$sendersCloseStatus$iv2 >> 60);
        switch ($i$f$getSendersCloseStatus) {
            case 1:
                sb.append("CANCELLATION_STARTED,");
                break;
            case 2:
                sb.append("CLOSED,");
                break;
            case 3:
                sb.append("CANCELLED,");
                break;
        }
        sb.append("SEND_SEGM=" + DebugStringsKt.getHexAddress(sendSegment$volatile$FU.get(this)) + ",RCV_SEGM=" + DebugStringsKt.getHexAddress(receiveSegment$volatile$FU.get(this)));
        if (!isRendezvousOrUnlimited()) {
            sb.append(",EB_SEGM=" + DebugStringsKt.getHexAddress(bufferEndSegment$volatile$FU.get(this)));
        }
        sb.append("  ");
        Iterable $this$filter$iv = CollectionsKt.listOf((Object[]) new ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            ChannelSegment it = (ChannelSegment) element$iv$iv;
            ChannelSegment it2 = it != BufferedChannelKt.access$getNULL_SEGMENT$p() ? 1 : null;
            if (it2 != null) {
                arrayList.add(element$iv$iv);
            }
        }
        ArrayList $this$minBy$iv = arrayList;
        Iterator iterator$iv = $this$minBy$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new NoSuchElementException();
        }
        Object minElem$iv = iterator$iv.next();
        if (iterator$iv.hasNext()) {
            ChannelSegment it3 = (ChannelSegment) minElem$iv;
            long minValue$iv = it3.id;
            do {
                Object e$iv = iterator$iv.next();
                ChannelSegment it4 = (ChannelSegment) e$iv;
                long v$iv = it4.id;
                if (minValue$iv > v$iv) {
                    minElem$iv = e$iv;
                    minValue$iv = v$iv;
                }
            } while (iterator$iv.hasNext());
            ChannelSegment firstSegment = (ChannelSegment) minElem$iv;
            channelSegment = firstSegment;
            while (true) {
                StringBuilder append2 = new StringBuilder().append(DebugStringsKt.getHexAddress(channelSegment)).append("=[").append(!channelSegment.isRemoved() ? Marker.ANY_MARKER : "").append(channelSegment.id).append(",prev=");
                ChannelSegment channelSegment3 = (ChannelSegment) channelSegment.getPrev();
                sb.append(append2.append(channelSegment3 == null ? DebugStringsKt.getHexAddress(channelSegment3) : null).append(AbstractJsonLexerKt.COMMA).toString());
                i = BufferedChannelKt.SEGMENT_SIZE;
                while (i2 < i) {
                }
                StringBuilder append3 = new StringBuilder().append("next=");
                ChannelSegment channelSegment4 = (ChannelSegment) channelSegment.getNext();
                sb.append(append3.append(channelSegment4 != null ? DebugStringsKt.getHexAddress(channelSegment4) : null).append("]  ").toString());
                channelSegment2 = (ChannelSegment) channelSegment.getNext();
                if (channelSegment2 != null) {
                }
                channelSegment = channelSegment2;
            }
        } else {
            ChannelSegment firstSegment2 = (ChannelSegment) minElem$iv;
            channelSegment = firstSegment2;
            while (true) {
                StringBuilder append22 = new StringBuilder().append(DebugStringsKt.getHexAddress(channelSegment)).append("=[").append(!channelSegment.isRemoved() ? Marker.ANY_MARKER : "").append(channelSegment.id).append(",prev=");
                ChannelSegment channelSegment32 = (ChannelSegment) channelSegment.getPrev();
                sb.append(append22.append(channelSegment32 == null ? DebugStringsKt.getHexAddress(channelSegment32) : null).append(AbstractJsonLexerKt.COMMA).toString());
                i = BufferedChannelKt.SEGMENT_SIZE;
                for (i2 = 0; i2 < i; i2++) {
                    int i3 = i2;
                    Object cellState = channelSegment.getState$kotlinx_coroutines_core(i3);
                    Object element = channelSegment.getElement$kotlinx_coroutines_core(i3);
                    String cellStateString = cellState instanceof CancellableContinuation ? "cont" : cellState instanceof SelectInstance ? "select" : cellState instanceof ReceiveCatching ? "receiveCatching" : cellState instanceof SendBroadcast ? "send(broadcast)" : cellState instanceof WaiterEB ? "EB(" + cellState + ')' : String.valueOf(cellState);
                    sb.append(AbstractJsonLexerKt.BEGIN_LIST + i3 + "]=(" + cellStateString + AbstractJsonLexerKt.COMMA + element + "),");
                }
                StringBuilder append32 = new StringBuilder().append("next=");
                ChannelSegment channelSegment42 = (ChannelSegment) channelSegment.getNext();
                sb.append(append32.append(channelSegment42 != null ? DebugStringsKt.getHexAddress(channelSegment42) : null).append("]  ").toString());
                channelSegment2 = (ChannelSegment) channelSegment.getNext();
                if (channelSegment2 != null) {
                    return sb.toString();
                }
                channelSegment = channelSegment2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0221 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void checkSegmentStructureInvariants() {
        ChannelSegment firstSegment;
        boolean z;
        if (isRendezvousOrUnlimited()) {
            if (!(bufferEndSegment$volatile$FU.get(this) == BufferedChannelKt.access$getNULL_SEGMENT$p())) {
                throw new IllegalStateException(("bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: " + this).toString());
            }
        } else if (!(((ChannelSegment) receiveSegment$volatile$FU.get(this)).id <= ((ChannelSegment) bufferEndSegment$volatile$FU.get(this)).id)) {
            throw new IllegalStateException(("bufferEndSegment should not have lower id than receiveSegment.\nChannel state: " + this).toString());
        }
        Iterable $this$filter$iv = CollectionsKt.listOf((Object[]) new ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        Collection arrayList = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            ChannelSegment it = (ChannelSegment) element$iv$iv;
            ChannelSegment it2 = it != BufferedChannelKt.access$getNULL_SEGMENT$p() ? 1 : null;
            if (it2 != null) {
                arrayList.add(element$iv$iv);
            }
        }
        Iterable destination$iv$iv = (List) arrayList;
        Iterable $this$minBy$iv = destination$iv$iv;
        Iterator iterator$iv = $this$minBy$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new NoSuchElementException();
        }
        Object minElem$iv = iterator$iv.next();
        if (!iterator$iv.hasNext()) {
            firstSegment = (ChannelSegment) minElem$iv;
            if (firstSegment.getPrev() != 0) {
                throw new IllegalStateException(("All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: " + this).toString());
            }
            ChannelSegment segment = firstSegment;
            while (segment.getNext() != 0) {
                S next = segment.getNext();
                Intrinsics.checkNotNull(next);
                if (((ChannelSegment) next).getPrev() != 0) {
                    S next2 = segment.getNext();
                    Intrinsics.checkNotNull(next2);
                    if (((ChannelSegment) next2).getPrev() != segment) {
                        z = false;
                        if (z) {
                            throw new IllegalStateException(("The `segment.next.prev === segment` invariant is violated.\nChannel state: " + this).toString());
                        }
                        int interruptedOrClosedCells = 0;
                        int i = BufferedChannelKt.SEGMENT_SIZE;
                        for (int i2 = 0; i2 < i; i2++) {
                            Object state = segment.getState$kotlinx_coroutines_core(i2);
                            if (!Intrinsics.areEqual(state, BufferedChannelKt.BUFFERED) && !(state instanceof Waiter)) {
                                if (Intrinsics.areEqual(state, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) ? true : Intrinsics.areEqual(state, BufferedChannelKt.access$getINTERRUPTED_SEND$p()) ? true : Intrinsics.areEqual(state, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                    if (!(segment.getElement$kotlinx_coroutines_core(i2) == null)) {
                                        throw new IllegalStateException("Check failed.".toString());
                                    }
                                    interruptedOrClosedCells++;
                                } else {
                                    if (!(Intrinsics.areEqual(state, BufferedChannelKt.access$getPOISONED$p()) ? true : Intrinsics.areEqual(state, BufferedChannelKt.access$getDONE_RCV$p()))) {
                                        throw new IllegalStateException(("Unexpected segment cell state: " + state + ".\nChannel state: " + this).toString());
                                    }
                                    if (!(segment.getElement$kotlinx_coroutines_core(i2) == null)) {
                                        throw new IllegalStateException("Check failed.".toString());
                                    }
                                }
                            }
                        }
                        int i3 = BufferedChannelKt.SEGMENT_SIZE;
                        if (interruptedOrClosedCells == i3) {
                            if (!(segment == receiveSegment$volatile$FU.get(this) || segment == sendSegment$volatile$FU.get(this) || segment == bufferEndSegment$volatile$FU.get(this))) {
                                throw new IllegalStateException(("Logically removed segment is reachable.\nChannel state: " + this).toString());
                            }
                        }
                        S next3 = segment.getNext();
                        Intrinsics.checkNotNull(next3);
                        segment = (ChannelSegment) next3;
                    }
                }
                z = true;
                if (z) {
                }
            }
            return;
        }
        ChannelSegment it3 = (ChannelSegment) minElem$iv;
        long minValue$iv = it3.id;
        do {
            Object e$iv = iterator$iv.next();
            ChannelSegment it4 = (ChannelSegment) e$iv;
            long v$iv = it4.id;
            if (minValue$iv > v$iv) {
                minElem$iv = e$iv;
                minValue$iv = v$iv;
            }
        } while (iterator$iv.hasNext());
        firstSegment = (ChannelSegment) minElem$iv;
        if (firstSegment.getPrev() != 0) {
        }
    }
}