package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.apache.commons.codec.language.bm.Languages;
import org.apache.commons.io.FilenameUtils;

/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aJ\u0010\u0000\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00072\u001a\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\t\"\u0006\u0012\u0002\b\u00030\nH\u0001¢\u0006\u0002\u0010\u000b\u001a\u001e\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001aC\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u000e0\u00122\u001d\u0010\u0013\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\n\u0012\u0004\u0012\u0002H\u00110\u0001¢\u0006\u0002\b\u0014H\u0087\b¢\u0006\u0002\u0010\u0015\u001a2\u0010\u0016\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00122\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\u00060\u0001H\u0087H¢\u0006\u0002\u0010\u0018\u001a1\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007*\u0006\u0012\u0002\b\u00030\nH\u0001\u001a\u001e\u0010\u001a\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0007\u001aW\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u001e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\"\u0010!\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0001¢\u0006\u0002\u0010%\u001a0\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010'\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007\u001aQ\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\"\u0010)\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0007¢\u0006\u0002\u0010%\u001a&\u0010*\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010+\u001a\u00020\u001bH\u0087@¢\u0006\u0002\u0010,\u001a(\u0010-\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010+\u001a\u00020\u001bH\u0087@¢\u0006\u0002\u0010,\u001aQ\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\"\u0010)\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0001¢\u0006\u0002\u0010%\u001af\u0010/\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 27\u0010)\u001a3\b\u0001\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0#\u0012\u0006\u0012\u0004\u0018\u00010$00H\u0007¢\u0006\u0002\u00101\u001aQ\u00102\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\"\u0010)\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0007¢\u0006\u0002\u0010%\u001a$\u00103\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\b\b\u0000\u0010\u000e*\u00020$*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\nH\u0001\u001a>\u00104\u001a\u0002H5\"\b\b\u0000\u0010\u000e*\u00020$\"\u0010\b\u0001\u00105*\n\u0012\u0006\b\u0000\u0012\u0002H\u000e06*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\n2\u0006\u00107\u001a\u0002H5H\u0087@¢\u0006\u0002\u00108\u001a<\u00104\u001a\u0002H5\"\b\b\u0000\u0010\u000e*\u00020$\"\u000e\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e09*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\n2\u0006\u00107\u001a\u0002H5H\u0087@¢\u0006\u0002\u0010:\u001a\u001e\u0010;\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a \u0010<\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a]\u0010=\u001a\b\u0012\u0004\u0012\u0002H\u00110\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2(\u0010>\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\n0#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0007¢\u0006\u0002\u0010%\u001a&\u0010?\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010@\u001a\u0002H\u000eH\u0087@¢\u0006\u0002\u0010A\u001a\u001e\u0010B\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a&\u0010C\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010@\u001a\u0002H\u000eH\u0087@¢\u0006\u0002\u0010A\u001a \u0010D\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001aW\u0010E\u001a\b\u0012\u0004\u0012\u0002H\u00110\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\"\u0010>\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0001¢\u0006\u0002\u0010%\u001al\u0010F\u001a\b\u0012\u0004\u0012\u0002H\u00110\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 27\u0010>\u001a3\b\u0001\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110#\u0012\u0006\u0012\u0004\u0018\u00010$00H\u0001¢\u0006\u0002\u00101\u001ar\u0010G\u001a\b\u0012\u0004\u0012\u0002H\u00110\n\"\u0004\b\u0000\u0010\u000e\"\b\b\u0001\u0010\u0011*\u00020$*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 29\u0010>\u001a5\b\u0001\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110#\u0012\u0006\u0012\u0004\u0018\u00010$00H\u0007¢\u0006\u0002\u00101\u001a]\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u00110\n\"\u0004\b\u0000\u0010\u000e\"\b\b\u0001\u0010\u0011*\u00020$*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2$\u0010>\u001a \b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0007¢\u0006\u0002\u0010%\u001a<\u0010I\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u001a\u0010J\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0Kj\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`LH\u0087@¢\u0006\u0002\u0010M\u001a<\u0010N\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u001a\u0010J\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0Kj\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`LH\u0087@¢\u0006\u0002\u0010M\u001a\u001e\u0010O\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a$\u0010P\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\b\b\u0000\u0010\u000e*\u00020$*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\nH\u0007\u001a\u001e\u0010Q\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a \u0010R\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a0\u0010S\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010'\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007\u001aQ\u0010T\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\"\u0010)\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0007¢\u0006\u0002\u0010%\u001a6\u0010U\u001a\u0002H5\"\u0004\b\u0000\u0010\u000e\"\u000e\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e09*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u00107\u001a\u0002H5H\u0081@¢\u0006\u0002\u0010:\u001a8\u0010V\u001a\u0002H5\"\u0004\b\u0000\u0010\u000e\"\u0010\b\u0001\u00105*\n\u0012\u0006\b\u0000\u0012\u0002H\u000e06*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u00107\u001a\u0002H5H\u0081@¢\u0006\u0002\u00108\u001a<\u0010W\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002HY0X\"\u0004\b\u0000\u0010\u001e\"\u0004\b\u0001\u0010Y*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002HY0Z0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001aR\u0010W\u001a\u0002H[\"\u0004\b\u0000\u0010\u001e\"\u0004\b\u0001\u0010Y\"\u0018\b\u0002\u0010[*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u001e\u0012\u0006\b\u0000\u0012\u0002HY0\\*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002HY0Z0\n2\u0006\u00107\u001a\u0002H[H\u0081@¢\u0006\u0002\u0010]\u001a$\u0010^\u001a\b\u0012\u0004\u0012\u0002H\u000e0_\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a$\u0010`\u001a\b\u0012\u0004\u0012\u0002H\u000e0a\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0081@¢\u0006\u0002\u0010\u000f\u001a$\u0010b\u001a\b\u0012\u0004\u0012\u0002H\u000e0c\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a.\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007\u001a?\u0010f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u00110Z0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u000e0\n2\f\u0010g\u001a\b\u0012\u0004\u0012\u0002H\u00110\nH\u0087\u0004\u001az\u0010f\u001a\b\u0012\u0004\u0012\u0002HY0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010Y*\b\u0012\u0004\u0012\u0002H\u000e0\n2\f\u0010g\u001a\b\u0012\u0004\u0012\u0002H\u00110\n2\b\b\u0002\u0010\u001f\u001a\u00020 26\u0010>\u001a2\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(h\u0012\u0013\u0012\u0011H\u0011¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(i\u0012\u0004\u0012\u0002HY0\"H\u0001¨\u0006j"}, d2 = {"consumesAll", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "channels", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", Languages.ANY, "", "E", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consume", "R", "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "action", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumes", "count", "", "distinct", "distinctBy", "K", "context", "Lkotlin/coroutines/CoroutineContext;", "selector", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "drop", "n", "dropWhile", "predicate", "elementAt", "index", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function3;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filterNot", "filterNotNull", "filterNotNullTo", "C", "", "destination", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "first", "firstOrNull", "flatMap", "transform", "indexOf", "element", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapNotNull", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minWith", "none", "requireNoNulls", "single", "singleOrNull", "take", "takeWhile", "toChannel", "toCollection", "toMap", "", "V", "Lkotlin/Pair;", "M", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMutableList", "", "toMutableSet", "", "toSet", "", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
public final /* synthetic */ class ChannelsKt__DeprecatedKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E, R> R consume(BroadcastChannel<E> broadcastChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        ReceiveChannel channel = broadcastChannel.openSubscription();
        try {
            return function1.invoke(channel);
        } finally {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default(channel, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0080 A[Catch: all -> 0x009e, TryCatch #2 {all -> 0x009e, blocks: (B:66:0x0078, B:68:0x0080, B:69:0x008e), top: B:82:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x008e A[Catch: all -> 0x009e, TRY_LEAVE, TryCatch #2 {all -> 0x009e, blocks: (B:66:0x0078, B:68:0x0080, B:69:0x008e), top: B:82:0x0078 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0070 -> B:82:0x0078). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object consumeEach(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelsKt__DeprecatedKt$consumeEach$1 channelsKt__DeprecatedKt$consumeEach$1;
        ChannelsKt__DeprecatedKt$consumeEach$1 channelsKt__DeprecatedKt$consumeEach$12;
        ReceiveChannel channel$iv;
        Object $result;
        Function1 action;
        ReceiveChannel channel$iv2;
        ChannelIterator<E> channelIterator;
        int i;
        Object obj;
        if (continuation instanceof ChannelsKt__DeprecatedKt$consumeEach$1) {
            channelsKt__DeprecatedKt$consumeEach$1 = (ChannelsKt__DeprecatedKt$consumeEach$1) continuation;
            if ((channelsKt__DeprecatedKt$consumeEach$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$consumeEach$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$consumeEach$12 = channelsKt__DeprecatedKt$consumeEach$1;
                Object element = channelsKt__DeprecatedKt$consumeEach$12.result;
                Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$consumeEach$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(element);
                        channel$iv = broadcastChannel.openSubscription();
                        try {
                            int $i$f$consumeEach = 0;
                            Function1 action2 = function1;
                            ChannelIterator<E> it = channel$iv.iterator();
                            channelsKt__DeprecatedKt$consumeEach$12.L$0 = action2;
                            channelsKt__DeprecatedKt$consumeEach$12.L$1 = channel$iv;
                            channelsKt__DeprecatedKt$consumeEach$12.L$2 = it;
                            channelsKt__DeprecatedKt$consumeEach$12.label = 1;
                            Object hasNext = it.hasNext(channelsKt__DeprecatedKt$consumeEach$12);
                            if (hasNext != $result2) {
                                return $result2;
                            }
                            Object obj2 = $result2;
                            $result = element;
                            element = hasNext;
                            action = action2;
                            channel$iv2 = channel$iv;
                            channelIterator = it;
                            i = $i$f$consumeEach;
                            obj = obj2;
                            try {
                                if (((Boolean) element).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ReceiveChannel.DefaultImpls.cancel$default(channel$iv2, (CancellationException) null, 1, (Object) null);
                                    InlineMarker.finallyEnd(1);
                                    return Unit.INSTANCE;
                                }
                                action.invoke(channelIterator.next());
                                element = $result;
                                $result2 = obj;
                                $i$f$consumeEach = i;
                                it = channelIterator;
                                channel$iv = channel$iv2;
                                action2 = action;
                                channelsKt__DeprecatedKt$consumeEach$12.L$0 = action2;
                                channelsKt__DeprecatedKt$consumeEach$12.L$1 = channel$iv;
                                channelsKt__DeprecatedKt$consumeEach$12.L$2 = it;
                                channelsKt__DeprecatedKt$consumeEach$12.label = 1;
                                Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$consumeEach$12);
                                if (hasNext2 != $result2) {
                                }
                            } catch (Throwable th) {
                                channel$iv = channel$iv2;
                                th = th;
                                InlineMarker.finallyStart(1);
                                ReceiveChannel.DefaultImpls.cancel$default(channel$iv, (CancellationException) null, 1, (Object) null);
                                InlineMarker.finallyEnd(1);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            InlineMarker.finallyStart(1);
                            ReceiveChannel.DefaultImpls.cancel$default(channel$iv, (CancellationException) null, 1, (Object) null);
                            InlineMarker.finallyEnd(1);
                            throw th;
                        }
                    case 1:
                        ChannelIterator<E> channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$consumeEach$12.L$2;
                        channel$iv = (ReceiveChannel) channelsKt__DeprecatedKt$consumeEach$12.L$1;
                        Function1 action3 = (Function1) channelsKt__DeprecatedKt$consumeEach$12.L$0;
                        try {
                            ResultKt.throwOnFailure(element);
                            action = action3;
                            channel$iv2 = channel$iv;
                            channelIterator = channelIterator2;
                            i = 0;
                            obj = $result2;
                            $result = element;
                            if (((Boolean) element).booleanValue()) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            InlineMarker.finallyStart(1);
                            ReceiveChannel.DefaultImpls.cancel$default(channel$iv, (CancellationException) null, 1, (Object) null);
                            InlineMarker.finallyEnd(1);
                            throw th;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$consumeEach$1 = new ChannelsKt__DeprecatedKt$consumeEach$1(continuation);
        channelsKt__DeprecatedKt$consumeEach$12 = channelsKt__DeprecatedKt$consumeEach$1;
        Object element2 = channelsKt__DeprecatedKt$consumeEach$12.result;
        Object $result22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$consumeEach$12.label) {
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    private static final <E> Object consumeEach$$forInline(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel channel$iv = broadcastChannel.openSubscription();
        try {
            ReceiveChannel $this$consumeEach_u24lambda_u240 = channel$iv;
            ChannelIterator<E> it = $this$consumeEach_u24lambda_u240.iterator();
            while (true) {
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(null);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ReceiveChannel.DefaultImpls.cancel$default(channel$iv, (CancellationException) null, 1, (Object) null);
                    InlineMarker.finallyEnd(1);
                    return Unit.INSTANCE;
                }
                Object element = it.next();
                function1.invoke(element);
            }
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default(channel$iv, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public static final Function1<Throwable, Unit> consumesAll(final ReceiveChannel<?>... receiveChannelArr) {
        return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$consumesAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
            public final void invoke2(Throwable cause) {
                ReceiveChannel[] receiveChannelArr2;
                Throwable exception = null;
                for (ReceiveChannel channel : receiveChannelArr) {
                    try {
                        ChannelsKt.cancelConsumed(channel, cause);
                    } catch (Throwable e) {
                        if (exception == null) {
                            exception = e;
                        } else {
                            ExceptionsKt.addSuppressed(exception, e);
                        }
                    }
                }
                if (exception != null) {
                    Throwable it = exception;
                    throw it;
                }
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x008b A[Catch: all -> 0x00c3, TRY_LEAVE, TryCatch #1 {all -> 0x00c3, blocks: (B:89:0x0083, B:91:0x008b), top: B:117:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00a1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x007a -> B:117:0x0083). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object elementAt(ReceiveChannel $this$consume$iv, int index, Continuation continuation) {
        ChannelsKt__DeprecatedKt$elementAt$1 channelsKt__DeprecatedKt$elementAt$1;
        ChannelsKt__DeprecatedKt$elementAt$1 channelsKt__DeprecatedKt$elementAt$12;
        ReceiveChannel $this$consume$iv2;
        Object $result;
        Throwable th;
        ReceiveChannel $this$consume$iv3;
        ChannelIterator channelIterator;
        int index2;
        int index3;
        Object obj;
        if (continuation instanceof ChannelsKt__DeprecatedKt$elementAt$1) {
            channelsKt__DeprecatedKt$elementAt$1 = (ChannelsKt__DeprecatedKt$elementAt$1) continuation;
            if ((channelsKt__DeprecatedKt$elementAt$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$elementAt$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$elementAt$12 = channelsKt__DeprecatedKt$elementAt$1;
                Object $result2 = channelsKt__DeprecatedKt$elementAt$12.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$elementAt$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        try {
                            if (index < 0) {
                                throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + index + FilenameUtils.EXTENSION_SEPARATOR);
                            }
                            ChannelIterator it = $this$consume$iv.iterator();
                            ReceiveChannel $this$consume$iv4 = $this$consume$iv;
                            int $i$f$consume = 0;
                            Throwable cause$iv = null;
                            int index4 = index;
                            try {
                                channelsKt__DeprecatedKt$elementAt$12.L$0 = $this$consume$iv4;
                                channelsKt__DeprecatedKt$elementAt$12.L$1 = it;
                                channelsKt__DeprecatedKt$elementAt$12.I$0 = index4;
                                channelsKt__DeprecatedKt$elementAt$12.I$1 = $i$f$consume;
                                channelsKt__DeprecatedKt$elementAt$12.label = 1;
                                Object hasNext = it.hasNext(channelsKt__DeprecatedKt$elementAt$12);
                                if (hasNext != $result3) {
                                    return $result3;
                                }
                                Object obj2 = $result3;
                                $result = $result2;
                                $result2 = hasNext;
                                th = cause$iv;
                                $this$consume$iv3 = $this$consume$iv4;
                                channelIterator = it;
                                index2 = index4;
                                index3 = $i$f$consume;
                                obj = obj2;
                                try {
                                    if (((Boolean) $result2).booleanValue()) {
                                        ReceiveChannel $this$consume$iv5 = $this$consume$iv3;
                                        try {
                                            throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + index2 + FilenameUtils.EXTENSION_SEPARATOR);
                                        } catch (Throwable th2) {
                                            e$iv = th2;
                                            $this$consume$iv2 = $this$consume$iv5;
                                            Throwable cause$iv2 = e$iv;
                                            try {
                                                throw e$iv;
                                            } catch (Throwable e$iv) {
                                                ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv2);
                                                throw e$iv;
                                            }
                                        }
                                    }
                                    Object next = channelIterator.next();
                                    int count = index3 + 1;
                                    if (index2 != index3) {
                                        ReceiveChannel $this$consume$iv6 = $this$consume$iv3;
                                        cause$iv = th;
                                        index4 = index2;
                                        it = channelIterator;
                                        $this$consume$iv4 = $this$consume$iv6;
                                        $result2 = $result;
                                        $result3 = obj;
                                        $i$f$consume = count;
                                        channelsKt__DeprecatedKt$elementAt$12.L$0 = $this$consume$iv4;
                                        channelsKt__DeprecatedKt$elementAt$12.L$1 = it;
                                        channelsKt__DeprecatedKt$elementAt$12.I$0 = index4;
                                        channelsKt__DeprecatedKt$elementAt$12.I$1 = $i$f$consume;
                                        channelsKt__DeprecatedKt$elementAt$12.label = 1;
                                        Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$elementAt$12);
                                        if (hasNext2 != $result3) {
                                        }
                                    } else {
                                        ChannelsKt.cancelConsumed($this$consume$iv3, th);
                                        return next;
                                    }
                                } catch (Throwable th3) {
                                    e$iv = th3;
                                    $this$consume$iv2 = $this$consume$iv3;
                                }
                            } catch (Throwable th4) {
                                e$iv = th4;
                                $this$consume$iv2 = $this$consume$iv4;
                                Throwable cause$iv22 = e$iv;
                                throw e$iv;
                            }
                        } catch (Throwable th5) {
                            e$iv = th5;
                            $this$consume$iv2 = $this$consume$iv;
                            Throwable cause$iv222 = e$iv;
                            throw e$iv;
                        }
                    case 1:
                        int count2 = channelsKt__DeprecatedKt$elementAt$12.I$1;
                        int index5 = channelsKt__DeprecatedKt$elementAt$12.I$0;
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$elementAt$12.L$1;
                        ReceiveChannel receiveChannel = (ReceiveChannel) channelsKt__DeprecatedKt$elementAt$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            th = null;
                            $this$consume$iv3 = receiveChannel;
                            channelIterator = channelIterator2;
                            index2 = index5;
                            index3 = count2;
                            obj = $result3;
                            $result = $result2;
                            if (((Boolean) $result2).booleanValue()) {
                            }
                        } catch (Throwable th6) {
                            e$iv = th6;
                            $this$consume$iv2 = receiveChannel;
                            Throwable cause$iv2222 = e$iv;
                            throw e$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$elementAt$1 = new ChannelsKt__DeprecatedKt$elementAt$1(continuation);
        channelsKt__DeprecatedKt$elementAt$12 = channelsKt__DeprecatedKt$elementAt$1;
        Object $result22 = channelsKt__DeprecatedKt$elementAt$12.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$elementAt$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x008b A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #1 {all -> 0x00a5, blocks: (B:87:0x0083, B:89:0x008b), top: B:110:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00a0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x007b -> B:110:0x0083). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object elementAtOrNull(ReceiveChannel $this$consume$iv, int index, Continuation continuation) {
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 channelsKt__DeprecatedKt$elementAtOrNull$1;
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 channelsKt__DeprecatedKt$elementAtOrNull$12;
        ReceiveChannel $this$consume$iv2;
        Throwable e$iv;
        int index2;
        int $i$f$consume;
        ReceiveChannel $this$consume$iv3;
        ChannelIterator it;
        Object $result;
        Throwable th;
        ChannelIterator channelIterator;
        int index3;
        int index4;
        Object obj;
        if (continuation instanceof ChannelsKt__DeprecatedKt$elementAtOrNull$1) {
            channelsKt__DeprecatedKt$elementAtOrNull$1 = (ChannelsKt__DeprecatedKt$elementAtOrNull$1) continuation;
            if ((channelsKt__DeprecatedKt$elementAtOrNull$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$elementAtOrNull$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$elementAtOrNull$12 = channelsKt__DeprecatedKt$elementAtOrNull$1;
                Object $result2 = channelsKt__DeprecatedKt$elementAtOrNull$12.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$elementAtOrNull$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        if (index < 0) {
                            ChannelsKt.cancelConsumed($this$consume$iv, null);
                            return null;
                        }
                        Throwable cause$iv = null;
                        try {
                            index2 = index;
                            $i$f$consume = 0;
                            $this$consume$iv3 = $this$consume$iv;
                            it = $this$consume$iv.iterator();
                        } catch (Throwable th2) {
                            $this$consume$iv2 = $this$consume$iv;
                            e$iv = th2;
                            Throwable cause$iv2 = e$iv;
                            try {
                                throw e$iv;
                            } catch (Throwable e$iv2) {
                                ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv2);
                                throw e$iv2;
                            }
                        }
                        try {
                            channelsKt__DeprecatedKt$elementAtOrNull$12.L$0 = $this$consume$iv3;
                            channelsKt__DeprecatedKt$elementAtOrNull$12.L$1 = it;
                            channelsKt__DeprecatedKt$elementAtOrNull$12.I$0 = index2;
                            channelsKt__DeprecatedKt$elementAtOrNull$12.I$1 = $i$f$consume;
                            channelsKt__DeprecatedKt$elementAtOrNull$12.label = 1;
                            Object hasNext = it.hasNext(channelsKt__DeprecatedKt$elementAtOrNull$12);
                            if (hasNext != $result3) {
                                return $result3;
                            }
                            Object obj2 = $result3;
                            $result = $result2;
                            $result2 = hasNext;
                            th = cause$iv;
                            channelIterator = it;
                            index3 = index2;
                            index4 = $i$f$consume;
                            obj = obj2;
                            try {
                                if (((Boolean) $result2).booleanValue()) {
                                    ChannelsKt.cancelConsumed($this$consume$iv3, th);
                                    return null;
                                }
                                Object next = channelIterator.next();
                                int count = index4 + 1;
                                if (index3 == index4) {
                                    ChannelsKt.cancelConsumed($this$consume$iv3, th);
                                    return next;
                                }
                                index2 = index3;
                                it = channelIterator;
                                cause$iv = th;
                                $result2 = $result;
                                $result3 = obj;
                                $i$f$consume = count;
                                channelsKt__DeprecatedKt$elementAtOrNull$12.L$0 = $this$consume$iv3;
                                channelsKt__DeprecatedKt$elementAtOrNull$12.L$1 = it;
                                channelsKt__DeprecatedKt$elementAtOrNull$12.I$0 = index2;
                                channelsKt__DeprecatedKt$elementAtOrNull$12.I$1 = $i$f$consume;
                                channelsKt__DeprecatedKt$elementAtOrNull$12.label = 1;
                                Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$elementAtOrNull$12);
                                if (hasNext2 != $result3) {
                                }
                            } catch (Throwable th3) {
                                e$iv = th3;
                                $this$consume$iv2 = $this$consume$iv3;
                                Throwable cause$iv22 = e$iv;
                                throw e$iv;
                            }
                        } catch (Throwable th4) {
                            e$iv = th4;
                            $this$consume$iv2 = $this$consume$iv3;
                            Throwable cause$iv222 = e$iv;
                            throw e$iv;
                        }
                    case 1:
                        int count2 = channelsKt__DeprecatedKt$elementAtOrNull$12.I$1;
                        int index5 = channelsKt__DeprecatedKt$elementAtOrNull$12.I$0;
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$elementAtOrNull$12.L$1;
                        ReceiveChannel receiveChannel = (ReceiveChannel) channelsKt__DeprecatedKt$elementAtOrNull$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            th = null;
                            $this$consume$iv3 = receiveChannel;
                            channelIterator = channelIterator2;
                            index3 = index5;
                            index4 = count2;
                            obj = $result3;
                            $result = $result2;
                            if (((Boolean) $result2).booleanValue()) {
                            }
                        } catch (Throwable th5) {
                            e$iv = th5;
                            $this$consume$iv2 = receiveChannel;
                            Throwable cause$iv2222 = e$iv;
                            throw e$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$elementAtOrNull$1 = new ChannelsKt__DeprecatedKt$elementAtOrNull$1(continuation);
        channelsKt__DeprecatedKt$elementAtOrNull$12 = channelsKt__DeprecatedKt$elementAtOrNull$1;
        Object $result22 = channelsKt__DeprecatedKt$elementAtOrNull$12.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$elementAtOrNull$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0067 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #2 {all -> 0x003d, blocks: (B:54:0x0038, B:63:0x005f, B:65:0x0067, B:68:0x006f, B:69:0x0076), top: B:81:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x006f A[Catch: all -> 0x003d, TRY_ENTER, TryCatch #2 {all -> 0x003d, blocks: (B:54:0x0038, B:63:0x005f, B:65:0x0067, B:68:0x006f, B:69:0x0076), top: B:81:0x0038 }] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object first(ReceiveChannel $this$first, Continuation continuation) {
        ChannelsKt__DeprecatedKt$first$1 channelsKt__DeprecatedKt$first$1;
        ChannelsKt__DeprecatedKt$first$1 channelsKt__DeprecatedKt$first$12;
        ReceiveChannel $this$consume$iv;
        Throwable cause$iv;
        ReceiveChannel $this$consume$iv2;
        ChannelIterator iterator;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$first$1) {
            channelsKt__DeprecatedKt$first$1 = (ChannelsKt__DeprecatedKt$first$1) continuation;
            if ((channelsKt__DeprecatedKt$first$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$first$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$first$12 = channelsKt__DeprecatedKt$first$1;
                Object $result = channelsKt__DeprecatedKt$first$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$first$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$consume$iv = $this$first;
                        cause$iv = null;
                        try {
                            iterator = $this$consume$iv.iterator();
                            channelsKt__DeprecatedKt$first$12.L$0 = $this$consume$iv;
                            channelsKt__DeprecatedKt$first$12.L$1 = iterator;
                            channelsKt__DeprecatedKt$first$12.label = 1;
                            hasNext = iterator.hasNext(channelsKt__DeprecatedKt$first$12);
                            if (hasNext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (((Boolean) hasNext).booleanValue()) {
                                throw new NoSuchElementException("ReceiveChannel is empty.");
                            }
                            Object next = iterator.next();
                            ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                            return next;
                        } catch (Throwable th) {
                            e$iv = th;
                            $this$consume$iv2 = $this$consume$iv;
                            Throwable cause$iv2 = e$iv;
                            try {
                                throw e$iv;
                            } catch (Throwable e$iv) {
                                ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv2);
                                throw e$iv;
                            }
                        }
                    case 1:
                        iterator = (ChannelIterator) channelsKt__DeprecatedKt$first$12.L$1;
                        $this$consume$iv = (ReceiveChannel) channelsKt__DeprecatedKt$first$12.L$0;
                        cause$iv = null;
                        try {
                            ResultKt.throwOnFailure($result);
                            hasNext = $result;
                            if (((Boolean) hasNext).booleanValue()) {
                            }
                        } catch (Throwable th2) {
                            e$iv = th2;
                            $this$consume$iv2 = $this$consume$iv;
                            Throwable cause$iv22 = e$iv;
                            throw e$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$first$1 = new ChannelsKt__DeprecatedKt$first$1(continuation);
        channelsKt__DeprecatedKt$first$12 = channelsKt__DeprecatedKt$first$1;
        Object $result2 = channelsKt__DeprecatedKt$first$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$first$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x006d A[Catch: all -> 0x0072, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0072, blocks: (B:67:0x0060, B:71:0x006d), top: B:82:0x0060 }] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object firstOrNull(ReceiveChannel $this$firstOrNull, Continuation continuation) {
        ChannelsKt__DeprecatedKt$firstOrNull$1 channelsKt__DeprecatedKt$firstOrNull$1;
        ChannelsKt__DeprecatedKt$firstOrNull$1 channelsKt__DeprecatedKt$firstOrNull$12;
        ReceiveChannel $this$consume$iv;
        Throwable cause$iv;
        ReceiveChannel $this$consume$iv2;
        ChannelIterator iterator;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$firstOrNull$1) {
            channelsKt__DeprecatedKt$firstOrNull$1 = (ChannelsKt__DeprecatedKt$firstOrNull$1) continuation;
            if ((channelsKt__DeprecatedKt$firstOrNull$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$firstOrNull$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$firstOrNull$12 = channelsKt__DeprecatedKt$firstOrNull$1;
                Object $result = channelsKt__DeprecatedKt$firstOrNull$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$firstOrNull$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$consume$iv = $this$firstOrNull;
                        cause$iv = null;
                        try {
                            iterator = $this$consume$iv.iterator();
                            channelsKt__DeprecatedKt$firstOrNull$12.L$0 = $this$consume$iv;
                            channelsKt__DeprecatedKt$firstOrNull$12.L$1 = iterator;
                            channelsKt__DeprecatedKt$firstOrNull$12.label = 1;
                            hasNext = iterator.hasNext(channelsKt__DeprecatedKt$firstOrNull$12);
                            if (hasNext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            try {
                                Object next = ((Boolean) hasNext).booleanValue() ? iterator.next() : null;
                                ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                                return next;
                            } catch (Throwable th) {
                                e$iv = th;
                                $this$consume$iv2 = $this$consume$iv;
                                Throwable cause$iv2 = e$iv;
                                try {
                                    throw e$iv;
                                } catch (Throwable e$iv) {
                                    ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv2);
                                    throw e$iv;
                                }
                            }
                        } catch (Throwable th2) {
                            e$iv = th2;
                            $this$consume$iv2 = $this$consume$iv;
                            Throwable cause$iv22 = e$iv;
                            throw e$iv;
                        }
                    case 1:
                        ChannelIterator iterator2 = (ChannelIterator) channelsKt__DeprecatedKt$firstOrNull$12.L$1;
                        $this$consume$iv = (ReceiveChannel) channelsKt__DeprecatedKt$firstOrNull$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            hasNext = $result;
                            iterator = iterator2;
                            cause$iv = null;
                            if (((Boolean) hasNext).booleanValue()) {
                            }
                            ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                            return next;
                        } catch (Throwable th3) {
                            e$iv = th3;
                            $this$consume$iv2 = $this$consume$iv;
                            Throwable cause$iv222 = e$iv;
                            throw e$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$firstOrNull$1 = new ChannelsKt__DeprecatedKt$firstOrNull$1(continuation);
        channelsKt__DeprecatedKt$firstOrNull$12 = channelsKt__DeprecatedKt$firstOrNull$1;
        Object $result2 = channelsKt__DeprecatedKt$firstOrNull$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$firstOrNull$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x009e A[Catch: all -> 0x00ed, TryCatch #5 {all -> 0x00ed, blocks: (B:91:0x0096, B:93:0x009e, B:95:0x00aa), top: B:130:0x0096 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0089 -> B:130:0x0096). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object indexOf(ReceiveChannel $this$consume$iv$iv, Object element, Continuation continuation) {
        ChannelsKt__DeprecatedKt$indexOf$1 channelsKt__DeprecatedKt$indexOf$1;
        ReceiveChannel $this$consume$iv$iv2;
        Object element2;
        boolean z;
        ReceiveChannel $this$consume$iv$iv3;
        boolean z2;
        ChannelIterator it;
        Ref.IntRef index;
        int $i$f$consume;
        Throwable cause$iv$iv;
        Object hasNext;
        Object $result;
        Throwable th;
        Object element3;
        Ref.IntRef index2;
        ReceiveChannel receiveChannel;
        ChannelIterator channelIterator;
        int i;
        boolean z3;
        boolean z4;
        if (continuation instanceof ChannelsKt__DeprecatedKt$indexOf$1) {
            channelsKt__DeprecatedKt$indexOf$1 = (ChannelsKt__DeprecatedKt$indexOf$1) continuation;
            if ((channelsKt__DeprecatedKt$indexOf$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$indexOf$1.label -= IntCompanionObject.MIN_VALUE;
                Object $result2 = channelsKt__DeprecatedKt$indexOf$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$indexOf$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        Ref.IntRef index3 = new Ref.IntRef();
                        try {
                            element2 = element;
                            z = false;
                            $this$consume$iv$iv3 = $this$consume$iv$iv;
                            z2 = false;
                            it = $this$consume$iv$iv.iterator();
                            index = index3;
                            $i$f$consume = 0;
                            cause$iv$iv = null;
                            try {
                                channelsKt__DeprecatedKt$indexOf$1.L$0 = element2;
                                channelsKt__DeprecatedKt$indexOf$1.L$1 = index;
                                channelsKt__DeprecatedKt$indexOf$1.L$2 = $this$consume$iv$iv3;
                                channelsKt__DeprecatedKt$indexOf$1.L$3 = it;
                                channelsKt__DeprecatedKt$indexOf$1.label = 1;
                                hasNext = it.hasNext(channelsKt__DeprecatedKt$indexOf$1);
                            } catch (Throwable th2) {
                                e$iv$iv = th2;
                                $this$consume$iv$iv2 = $this$consume$iv$iv3;
                            }
                        } catch (Throwable th3) {
                            e$iv$iv = th3;
                            $this$consume$iv$iv2 = $this$consume$iv$iv;
                        }
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        boolean z5 = z2;
                        $result = $result2;
                        $result2 = hasNext;
                        th = cause$iv$iv;
                        element3 = element2;
                        index2 = index;
                        receiveChannel = $this$consume$iv$iv3;
                        channelIterator = it;
                        i = $i$f$consume;
                        z3 = z;
                        z4 = z5;
                        try {
                            if (((Boolean) $result2).booleanValue()) {
                                $this$consume$iv$iv2 = receiveChannel;
                                Throwable cause$iv$iv2 = th;
                                try {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv2);
                                    return Boxing.boxInt(-1);
                                } catch (Throwable th4) {
                                    e$iv$iv = th4;
                                }
                            } else {
                                Object e$iv = channelIterator.next();
                                if (Intrinsics.areEqual(element3, e$iv)) {
                                    Integer boxInt = Boxing.boxInt(index2.element);
                                    ChannelsKt.cancelConsumed(receiveChannel, th);
                                    return boxInt;
                                }
                                ReceiveChannel $this$consume$iv$iv4 = receiveChannel;
                                Throwable cause$iv$iv3 = th;
                                try {
                                    index2.element++;
                                    ChannelIterator channelIterator2 = channelIterator;
                                    $this$consume$iv$iv3 = $this$consume$iv$iv4;
                                    $result2 = $result;
                                    z2 = z4;
                                    z = z3;
                                    $i$f$consume = i;
                                    it = channelIterator2;
                                    Object obj = element3;
                                    cause$iv$iv = cause$iv$iv3;
                                    index = index2;
                                    element2 = obj;
                                    channelsKt__DeprecatedKt$indexOf$1.L$0 = element2;
                                    channelsKt__DeprecatedKt$indexOf$1.L$1 = index;
                                    channelsKt__DeprecatedKt$indexOf$1.L$2 = $this$consume$iv$iv3;
                                    channelsKt__DeprecatedKt$indexOf$1.L$3 = it;
                                    channelsKt__DeprecatedKt$indexOf$1.label = 1;
                                    hasNext = it.hasNext(channelsKt__DeprecatedKt$indexOf$1);
                                    if (hasNext != coroutine_suspended) {
                                    }
                                } catch (Throwable th5) {
                                    e$iv$iv = th5;
                                    $this$consume$iv$iv2 = $this$consume$iv$iv4;
                                }
                            }
                        } catch (Throwable th6) {
                            e$iv$iv = th6;
                            $this$consume$iv$iv2 = receiveChannel;
                        }
                        Throwable cause$iv$iv4 = e$iv$iv;
                        try {
                            throw e$iv$iv;
                        } catch (Throwable e$iv$iv) {
                            ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv4);
                            throw e$iv$iv;
                        }
                    case 1:
                        ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$indexOf$1.L$3;
                        ReceiveChannel receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$indexOf$1.L$2;
                        Ref.IntRef index4 = (Ref.IntRef) channelsKt__DeprecatedKt$indexOf$1.L$1;
                        Object element4 = channelsKt__DeprecatedKt$indexOf$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            th = null;
                            element3 = element4;
                            index2 = index4;
                            receiveChannel = receiveChannel2;
                            channelIterator = channelIterator3;
                            i = 0;
                            z3 = false;
                            z4 = false;
                            $result = $result2;
                            if (((Boolean) $result2).booleanValue()) {
                            }
                        } catch (Throwable th7) {
                            e$iv$iv = th7;
                            $this$consume$iv$iv2 = receiveChannel2;
                        }
                        Throwable cause$iv$iv42 = e$iv$iv;
                        throw e$iv$iv;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$indexOf$1 = new ChannelsKt__DeprecatedKt$indexOf$1(continuation);
        Object $result22 = channelsKt__DeprecatedKt$indexOf$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$indexOf$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00b7 A[Catch: all -> 0x00cb, TRY_LEAVE, TryCatch #4 {all -> 0x00cb, blocks: (B:103:0x00af, B:105:0x00b7), top: B:131:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00d6 A[Catch: all -> 0x00de, TRY_ENTER, TryCatch #5 {all -> 0x00de, blocks: (B:95:0x0083, B:97:0x008b, B:113:0x00d6, B:114:0x00dd), top: B:133:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x008b A[Catch: all -> 0x00de, TRY_LEAVE, TryCatch #5 {all -> 0x00de, blocks: (B:95:0x0083, B:97:0x008b, B:113:0x00d6, B:114:0x00dd), top: B:133:0x0083 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x00a6 -> B:131:0x00af). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object last(ReceiveChannel $this$last, Continuation continuation) {
        ChannelsKt__DeprecatedKt$last$1 channelsKt__DeprecatedKt$last$1;
        ChannelsKt__DeprecatedKt$last$1 channelsKt__DeprecatedKt$last$12;
        ReceiveChannel $this$consume$iv;
        Object $this$consume$iv2;
        Object hasNext;
        Throwable cause$iv;
        ChannelIterator iterator;
        Object $result;
        Throwable th;
        ReceiveChannel receiveChannel;
        ChannelIterator iterator2;
        Object obj;
        Object last;
        Object obj2;
        if (continuation instanceof ChannelsKt__DeprecatedKt$last$1) {
            channelsKt__DeprecatedKt$last$1 = (ChannelsKt__DeprecatedKt$last$1) continuation;
            if ((channelsKt__DeprecatedKt$last$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$last$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$last$12 = channelsKt__DeprecatedKt$last$1;
                Object last2 = channelsKt__DeprecatedKt$last$12.result;
                Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$last$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(last2);
                        $this$consume$iv = $this$last;
                        $this$consume$iv2 = null;
                        try {
                            ChannelIterator iterator3 = $this$consume$iv.iterator();
                            channelsKt__DeprecatedKt$last$12.L$0 = $this$consume$iv;
                            channelsKt__DeprecatedKt$last$12.L$1 = iterator3;
                            channelsKt__DeprecatedKt$last$12.label = 1;
                            hasNext = iterator3.hasNext(channelsKt__DeprecatedKt$last$12);
                            if (hasNext == $result2) {
                                return $result2;
                            }
                            cause$iv = null;
                            iterator = iterator3;
                            try {
                                if (((Boolean) hasNext).booleanValue()) {
                                    throw new NoSuchElementException("ReceiveChannel is empty.");
                                }
                                Object obj3 = $this$consume$iv2;
                                ReceiveChannel $this$consume$iv3 = $this$consume$iv;
                                Object $this$consume$iv4 = obj3;
                                Throwable th2 = cause$iv;
                                ChannelIterator iterator4 = iterator;
                                Object last3 = iterator.next();
                                Throwable cause$iv2 = th2;
                                try {
                                    channelsKt__DeprecatedKt$last$12.L$0 = $this$consume$iv3;
                                    channelsKt__DeprecatedKt$last$12.L$1 = iterator4;
                                    channelsKt__DeprecatedKt$last$12.L$2 = last3;
                                    channelsKt__DeprecatedKt$last$12.label = 2;
                                    Object hasNext2 = iterator4.hasNext(channelsKt__DeprecatedKt$last$12);
                                    if (hasNext2 != $result2) {
                                        return $result2;
                                    }
                                    Object obj4 = $result2;
                                    $result = last2;
                                    last2 = hasNext2;
                                    th = cause$iv2;
                                    receiveChannel = $this$consume$iv3;
                                    iterator2 = iterator4;
                                    obj = last3;
                                    last = $this$consume$iv4;
                                    obj2 = obj4;
                                    try {
                                        if (((Boolean) last2).booleanValue()) {
                                            ChannelsKt.cancelConsumed(receiveChannel, th);
                                            return obj;
                                        }
                                        ReceiveChannel $this$consume$iv5 = receiveChannel;
                                        cause$iv2 = th;
                                        Object obj5 = last;
                                        last3 = iterator2.next();
                                        last2 = $result;
                                        $result2 = obj2;
                                        $this$consume$iv4 = obj5;
                                        ChannelIterator channelIterator = iterator2;
                                        $this$consume$iv3 = $this$consume$iv5;
                                        iterator4 = channelIterator;
                                        channelsKt__DeprecatedKt$last$12.L$0 = $this$consume$iv3;
                                        channelsKt__DeprecatedKt$last$12.L$1 = iterator4;
                                        channelsKt__DeprecatedKt$last$12.L$2 = last3;
                                        channelsKt__DeprecatedKt$last$12.label = 2;
                                        Object hasNext22 = iterator4.hasNext(channelsKt__DeprecatedKt$last$12);
                                        if (hasNext22 != $result2) {
                                        }
                                    } catch (Throwable th3) {
                                        $this$consume$iv = receiveChannel;
                                        e$iv = th3;
                                        Throwable cause$iv3 = e$iv;
                                        try {
                                            throw e$iv;
                                        } catch (Throwable e$iv) {
                                            ChannelsKt.cancelConsumed($this$consume$iv, cause$iv3);
                                            throw e$iv;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    e$iv = th4;
                                    $this$consume$iv = $this$consume$iv3;
                                    Throwable cause$iv32 = e$iv;
                                    throw e$iv;
                                }
                            } catch (Throwable th5) {
                                e$iv = th5;
                                Throwable cause$iv322 = e$iv;
                                throw e$iv;
                            }
                        } catch (Throwable th6) {
                            e$iv = th6;
                            Throwable cause$iv3222 = e$iv;
                            throw e$iv;
                        }
                    case 1:
                        iterator = (ChannelIterator) channelsKt__DeprecatedKt$last$12.L$1;
                        cause$iv = null;
                        ReceiveChannel $this$consume$iv6 = (ReceiveChannel) channelsKt__DeprecatedKt$last$12.L$0;
                        try {
                            ResultKt.throwOnFailure(last2);
                            hasNext = last2;
                            $this$consume$iv2 = null;
                            $this$consume$iv = $this$consume$iv6;
                            if (((Boolean) hasNext).booleanValue()) {
                            }
                        } catch (Throwable th7) {
                            e$iv = th7;
                            $this$consume$iv = $this$consume$iv6;
                            Throwable cause$iv32222 = e$iv;
                            throw e$iv;
                        }
                        break;
                    case 2:
                        Object last4 = channelsKt__DeprecatedKt$last$12.L$2;
                        ChannelIterator iterator5 = (ChannelIterator) channelsKt__DeprecatedKt$last$12.L$1;
                        ReceiveChannel receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$last$12.L$0;
                        try {
                            ResultKt.throwOnFailure(last2);
                            th = null;
                            receiveChannel = receiveChannel2;
                            iterator2 = iterator5;
                            obj = last4;
                            last = null;
                            obj2 = $result2;
                            $result = last2;
                            if (((Boolean) last2).booleanValue()) {
                            }
                        } catch (Throwable th8) {
                            e$iv = th8;
                            $this$consume$iv = receiveChannel2;
                            Throwable cause$iv322222 = e$iv;
                            throw e$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$last$1 = new ChannelsKt__DeprecatedKt$last$1(continuation);
        channelsKt__DeprecatedKt$last$12 = channelsKt__DeprecatedKt$last$1;
        Object last22 = channelsKt__DeprecatedKt$last$12.result;
        Object $result22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$last$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00a9 A[Catch: all -> 0x00d9, TryCatch #3 {all -> 0x00d9, blocks: (B:74:0x00a1, B:76:0x00a9, B:78:0x00b4, B:79:0x00b8, B:80:0x00c9), top: B:98:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c9 A[Catch: all -> 0x00d9, TRY_LEAVE, TryCatch #3 {all -> 0x00d9, blocks: (B:74:0x00a1, B:76:0x00a9, B:78:0x00b4, B:79:0x00b8, B:80:0x00c9), top: B:98:0x00a1 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0093 -> B:98:0x00a1). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object lastIndexOf(ReceiveChannel $this$consumeEach$iv, Object element, Continuation continuation) {
        ChannelsKt__DeprecatedKt$lastIndexOf$1 channelsKt__DeprecatedKt$lastIndexOf$1;
        ReceiveChannel $this$consume$iv$iv;
        Object $result;
        Object element2;
        Ref.IntRef lastIndex;
        Ref.IntRef lastIndex2;
        ReceiveChannel $this$consume$iv$iv2;
        Throwable cause$iv$iv;
        ChannelIterator channelIterator;
        int i;
        boolean z;
        boolean z2;
        if (continuation instanceof ChannelsKt__DeprecatedKt$lastIndexOf$1) {
            channelsKt__DeprecatedKt$lastIndexOf$1 = (ChannelsKt__DeprecatedKt$lastIndexOf$1) continuation;
            if ((channelsKt__DeprecatedKt$lastIndexOf$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$lastIndexOf$1.label -= IntCompanionObject.MIN_VALUE;
                Object $result2 = channelsKt__DeprecatedKt$lastIndexOf$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$lastIndexOf$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        Ref.IntRef lastIndex3 = new Ref.IntRef();
                        lastIndex3.element = -1;
                        Ref.IntRef index = new Ref.IntRef();
                        $this$consume$iv$iv = $this$consumeEach$iv;
                        try {
                            Ref.IntRef index2 = lastIndex3;
                            int $i$f$consume = 0;
                            Object element3 = element;
                            boolean z3 = false;
                            boolean z4 = false;
                            Throwable cause$iv$iv2 = null;
                            Ref.IntRef index3 = index;
                            ChannelIterator it = $this$consume$iv$iv.iterator();
                            channelsKt__DeprecatedKt$lastIndexOf$1.L$0 = element3;
                            channelsKt__DeprecatedKt$lastIndexOf$1.L$1 = index2;
                            channelsKt__DeprecatedKt$lastIndexOf$1.L$2 = index3;
                            channelsKt__DeprecatedKt$lastIndexOf$1.L$3 = $this$consume$iv$iv;
                            channelsKt__DeprecatedKt$lastIndexOf$1.L$4 = it;
                            channelsKt__DeprecatedKt$lastIndexOf$1.label = 1;
                            Object hasNext = it.hasNext(channelsKt__DeprecatedKt$lastIndexOf$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            boolean z5 = z4;
                            $result = $result2;
                            $result2 = hasNext;
                            element2 = element3;
                            lastIndex = index2;
                            lastIndex2 = index3;
                            $this$consume$iv$iv2 = $this$consume$iv$iv;
                            cause$iv$iv = cause$iv$iv2;
                            channelIterator = it;
                            i = $i$f$consume;
                            z = z3;
                            z2 = z5;
                            try {
                                if (!((Boolean) $result2).booleanValue()) {
                                    Object it2 = channelIterator.next();
                                    if (Intrinsics.areEqual(element2, it2)) {
                                        lastIndex.element = lastIndex2.element;
                                    }
                                    lastIndex2.element++;
                                    $result2 = $result;
                                    z4 = z2;
                                    z3 = z;
                                    $i$f$consume = i;
                                    it = channelIterator;
                                    cause$iv$iv2 = cause$iv$iv;
                                    $this$consume$iv$iv = $this$consume$iv$iv2;
                                    index3 = lastIndex2;
                                    index2 = lastIndex;
                                    element3 = element2;
                                    channelsKt__DeprecatedKt$lastIndexOf$1.L$0 = element3;
                                    channelsKt__DeprecatedKt$lastIndexOf$1.L$1 = index2;
                                    channelsKt__DeprecatedKt$lastIndexOf$1.L$2 = index3;
                                    channelsKt__DeprecatedKt$lastIndexOf$1.L$3 = $this$consume$iv$iv;
                                    channelsKt__DeprecatedKt$lastIndexOf$1.L$4 = it;
                                    channelsKt__DeprecatedKt$lastIndexOf$1.label = 1;
                                    Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$lastIndexOf$1);
                                    if (hasNext2 != coroutine_suspended) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv);
                                    return Boxing.boxInt(lastIndex.element);
                                }
                            } catch (Throwable th) {
                                e$iv$iv = th;
                                $this$consume$iv$iv = $this$consume$iv$iv2;
                                Throwable cause$iv$iv3 = e$iv$iv;
                                try {
                                    throw e$iv$iv;
                                } catch (Throwable e$iv$iv) {
                                    ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv3);
                                    throw e$iv$iv;
                                }
                            }
                        } catch (Throwable th2) {
                            e$iv$iv = th2;
                            Throwable cause$iv$iv32 = e$iv$iv;
                            throw e$iv$iv;
                        }
                    case 1:
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$lastIndexOf$1.L$4;
                        $this$consume$iv$iv = (ReceiveChannel) channelsKt__DeprecatedKt$lastIndexOf$1.L$3;
                        Ref.IntRef index4 = (Ref.IntRef) channelsKt__DeprecatedKt$lastIndexOf$1.L$2;
                        Ref.IntRef lastIndex4 = (Ref.IntRef) channelsKt__DeprecatedKt$lastIndexOf$1.L$1;
                        Object element4 = channelsKt__DeprecatedKt$lastIndexOf$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            element2 = element4;
                            lastIndex = lastIndex4;
                            lastIndex2 = index4;
                            $this$consume$iv$iv2 = $this$consume$iv$iv;
                            cause$iv$iv = null;
                            channelIterator = channelIterator2;
                            i = 0;
                            z = false;
                            z2 = false;
                            $result = $result2;
                            if (!((Boolean) $result2).booleanValue()) {
                            }
                        } catch (Throwable th3) {
                            e$iv$iv = th3;
                            Throwable cause$iv$iv322 = e$iv$iv;
                            throw e$iv$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$lastIndexOf$1 = new ChannelsKt__DeprecatedKt$lastIndexOf$1(continuation);
        Object $result22 = channelsKt__DeprecatedKt$lastIndexOf$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$lastIndexOf$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00b6 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #5 {all -> 0x00ca, blocks: (B:115:0x00ae, B:117:0x00b6), top: B:146:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x005f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x00a5 -> B:146:0x00ae). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object lastOrNull(ReceiveChannel $this$consume$iv, Continuation continuation) {
        ChannelsKt__DeprecatedKt$lastOrNull$1 channelsKt__DeprecatedKt$lastOrNull$1;
        ChannelsKt__DeprecatedKt$lastOrNull$1 channelsKt__DeprecatedKt$lastOrNull$12;
        boolean z;
        Throwable cause$iv;
        ReceiveChannel $this$consume$iv2;
        Throwable e$iv;
        ChannelIterator iterator;
        Object hasNext;
        ReceiveChannel receiveChannel;
        Object $result;
        ReceiveChannel $this$consume$iv3;
        ChannelIterator iterator2;
        Object obj;
        Throwable th;
        boolean z2;
        Object obj2;
        if (continuation instanceof ChannelsKt__DeprecatedKt$lastOrNull$1) {
            channelsKt__DeprecatedKt$lastOrNull$1 = (ChannelsKt__DeprecatedKt$lastOrNull$1) continuation;
            if ((channelsKt__DeprecatedKt$lastOrNull$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$lastOrNull$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$lastOrNull$12 = channelsKt__DeprecatedKt$lastOrNull$1;
                Object last = channelsKt__DeprecatedKt$lastOrNull$12.result;
                Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$lastOrNull$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(last);
                        z = false;
                        cause$iv = null;
                        try {
                            iterator = $this$consume$iv.iterator();
                            channelsKt__DeprecatedKt$lastOrNull$12.L$0 = $this$consume$iv;
                            channelsKt__DeprecatedKt$lastOrNull$12.L$1 = iterator;
                            channelsKt__DeprecatedKt$lastOrNull$12.label = 1;
                            hasNext = iterator.hasNext(channelsKt__DeprecatedKt$lastOrNull$12);
                            if (hasNext == $result2) {
                                return $result2;
                            }
                            receiveChannel = $this$consume$iv;
                            try {
                                if (((Boolean) hasNext).booleanValue()) {
                                    ChannelsKt.cancelConsumed(receiveChannel, cause$iv);
                                    return null;
                                }
                                ReceiveChannel $this$consume$iv4 = receiveChannel;
                                try {
                                    ReceiveChannel $this$consume$iv5 = $this$consume$iv4;
                                    Throwable cause$iv2 = cause$iv;
                                    Object last2 = iterator.next();
                                    try {
                                        channelsKt__DeprecatedKt$lastOrNull$12.L$0 = $this$consume$iv5;
                                        channelsKt__DeprecatedKt$lastOrNull$12.L$1 = iterator;
                                        channelsKt__DeprecatedKt$lastOrNull$12.L$2 = last2;
                                        channelsKt__DeprecatedKt$lastOrNull$12.label = 2;
                                        Object hasNext2 = iterator.hasNext(channelsKt__DeprecatedKt$lastOrNull$12);
                                        if (hasNext2 != $result2) {
                                            return $result2;
                                        }
                                        Object obj3 = $result2;
                                        $result = last;
                                        last = hasNext2;
                                        $this$consume$iv3 = $this$consume$iv5;
                                        iterator2 = iterator;
                                        obj = last2;
                                        th = cause$iv2;
                                        z2 = z;
                                        obj2 = obj3;
                                        try {
                                            if (((Boolean) last).booleanValue()) {
                                                ChannelsKt.cancelConsumed($this$consume$iv3, th);
                                                return obj;
                                            }
                                            Throwable th2 = th;
                                            last2 = iterator2.next();
                                            last = $result;
                                            $result2 = obj2;
                                            z = z2;
                                            cause$iv2 = th2;
                                            ChannelIterator channelIterator = iterator2;
                                            $this$consume$iv5 = $this$consume$iv3;
                                            iterator = channelIterator;
                                            channelsKt__DeprecatedKt$lastOrNull$12.L$0 = $this$consume$iv5;
                                            channelsKt__DeprecatedKt$lastOrNull$12.L$1 = iterator;
                                            channelsKt__DeprecatedKt$lastOrNull$12.L$2 = last2;
                                            channelsKt__DeprecatedKt$lastOrNull$12.label = 2;
                                            Object hasNext22 = iterator.hasNext(channelsKt__DeprecatedKt$lastOrNull$12);
                                            if (hasNext22 != $result2) {
                                            }
                                        } catch (Throwable th3) {
                                            e$iv = th3;
                                            $this$consume$iv2 = $this$consume$iv3;
                                            Throwable cause$iv3 = e$iv;
                                            try {
                                                throw e$iv;
                                            } catch (Throwable e$iv2) {
                                                ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv3);
                                                throw e$iv2;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        e$iv = th4;
                                        $this$consume$iv2 = $this$consume$iv5;
                                        Throwable cause$iv32 = e$iv;
                                        throw e$iv;
                                    }
                                } catch (Throwable th5) {
                                    e$iv = th5;
                                    $this$consume$iv2 = $this$consume$iv4;
                                    Throwable cause$iv322 = e$iv;
                                    throw e$iv;
                                }
                            } catch (Throwable th6) {
                                e$iv = th6;
                                $this$consume$iv2 = receiveChannel;
                            }
                        } catch (Throwable th7) {
                            $this$consume$iv2 = $this$consume$iv;
                            e$iv = th7;
                            Throwable cause$iv3222 = e$iv;
                            throw e$iv;
                        }
                    case 1:
                        z = false;
                        ChannelIterator iterator3 = (ChannelIterator) channelsKt__DeprecatedKt$lastOrNull$12.L$1;
                        ReceiveChannel receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$lastOrNull$12.L$0;
                        try {
                            ResultKt.throwOnFailure(last);
                            hasNext = last;
                            receiveChannel = receiveChannel2;
                            iterator = iterator3;
                            cause$iv = null;
                            if (((Boolean) hasNext).booleanValue()) {
                            }
                        } catch (Throwable th8) {
                            e$iv = th8;
                            $this$consume$iv2 = receiveChannel2;
                            Throwable cause$iv32222 = e$iv;
                            throw e$iv;
                        }
                        break;
                    case 2:
                        Object last3 = channelsKt__DeprecatedKt$lastOrNull$12.L$2;
                        ChannelIterator iterator4 = (ChannelIterator) channelsKt__DeprecatedKt$lastOrNull$12.L$1;
                        ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$lastOrNull$12.L$0;
                        try {
                            ResultKt.throwOnFailure(last);
                            $this$consume$iv3 = receiveChannel3;
                            iterator2 = iterator4;
                            obj = last3;
                            th = null;
                            z2 = false;
                            obj2 = $result2;
                            $result = last;
                            if (((Boolean) last).booleanValue()) {
                            }
                        } catch (Throwable th9) {
                            e$iv = th9;
                            $this$consume$iv2 = receiveChannel3;
                            Throwable cause$iv322222 = e$iv;
                            throw e$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$lastOrNull$1 = new ChannelsKt__DeprecatedKt$lastOrNull$1(continuation);
        channelsKt__DeprecatedKt$lastOrNull$12 = channelsKt__DeprecatedKt$lastOrNull$1;
        Object last4 = channelsKt__DeprecatedKt$lastOrNull$12.result;
        Object $result22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$lastOrNull$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0080 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:72:0x004c, B:81:0x0078, B:83:0x0080, B:93:0x00aa, B:94:0x00b1), top: B:101:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00a2 A[Catch: all -> 0x003c, TRY_ENTER, TryCatch #3 {all -> 0x003c, blocks: (B:67:0x0036, B:87:0x0095, B:91:0x00a2, B:92:0x00a9), top: B:106:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00aa A[Catch: all -> 0x0051, TRY_ENTER, TryCatch #0 {all -> 0x0051, blocks: (B:72:0x004c, B:81:0x0078, B:83:0x0080, B:93:0x00aa, B:94:0x00b1), top: B:101:0x004c }] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object single(ReceiveChannel $this$single, Continuation continuation) {
        ChannelsKt__DeprecatedKt$single$1 channelsKt__DeprecatedKt$single$1;
        ChannelsKt__DeprecatedKt$single$1 channelsKt__DeprecatedKt$single$12;
        ReceiveChannel $this$consume$iv;
        Object hasNext;
        ReceiveChannel $this$consume$iv2;
        boolean z;
        Throwable cause$iv;
        ChannelIterator iterator;
        Object hasNext2;
        ReceiveChannel receiveChannel;
        Object obj;
        if (continuation instanceof ChannelsKt__DeprecatedKt$single$1) {
            channelsKt__DeprecatedKt$single$1 = (ChannelsKt__DeprecatedKt$single$1) continuation;
            if ((channelsKt__DeprecatedKt$single$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$single$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$single$12 = channelsKt__DeprecatedKt$single$1;
                Object $result = channelsKt__DeprecatedKt$single$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$single$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$consume$iv = $this$single;
                        try {
                            ChannelIterator iterator2 = $this$consume$iv.iterator();
                            channelsKt__DeprecatedKt$single$12.L$0 = $this$consume$iv;
                            channelsKt__DeprecatedKt$single$12.L$1 = iterator2;
                            channelsKt__DeprecatedKt$single$12.label = 1;
                            hasNext = iterator2.hasNext(channelsKt__DeprecatedKt$single$12);
                            if (hasNext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$consume$iv2 = $this$consume$iv;
                            z = false;
                            cause$iv = null;
                            iterator = iterator2;
                            if (((Boolean) hasNext).booleanValue()) {
                                throw new NoSuchElementException("ReceiveChannel is empty.");
                            }
                            Object single = iterator.next();
                            channelsKt__DeprecatedKt$single$12.L$0 = $this$consume$iv2;
                            channelsKt__DeprecatedKt$single$12.L$1 = single;
                            channelsKt__DeprecatedKt$single$12.label = 2;
                            hasNext2 = iterator.hasNext(channelsKt__DeprecatedKt$single$12);
                            if (hasNext2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel = $this$consume$iv2;
                            obj = single;
                            if (!((Boolean) hasNext2).booleanValue()) {
                                throw new IllegalArgumentException("ReceiveChannel has more than one element.");
                            }
                            ChannelsKt.cancelConsumed(receiveChannel, cause$iv);
                            return obj;
                        } catch (Throwable th) {
                            e$iv = th;
                            Throwable cause$iv2 = e$iv;
                            try {
                                throw e$iv;
                            } catch (Throwable e$iv) {
                                ChannelsKt.cancelConsumed($this$consume$iv, cause$iv2);
                                throw e$iv;
                            }
                        }
                    case 1:
                        z = false;
                        iterator = (ChannelIterator) channelsKt__DeprecatedKt$single$12.L$1;
                        cause$iv = null;
                        $this$consume$iv2 = (ReceiveChannel) channelsKt__DeprecatedKt$single$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            hasNext = $result;
                            if (((Boolean) hasNext).booleanValue()) {
                            }
                        } catch (Throwable th2) {
                            e$iv = th2;
                            $this$consume$iv = $this$consume$iv2;
                            Throwable cause$iv22 = e$iv;
                            throw e$iv;
                        }
                        break;
                    case 2:
                        obj = channelsKt__DeprecatedKt$single$12.L$1;
                        receiveChannel = (ReceiveChannel) channelsKt__DeprecatedKt$single$12.L$0;
                        cause$iv = null;
                        try {
                            ResultKt.throwOnFailure($result);
                            hasNext2 = $result;
                            if (!((Boolean) hasNext2).booleanValue()) {
                            }
                        } catch (Throwable th3) {
                            e$iv = th3;
                            $this$consume$iv = receiveChannel;
                            Throwable cause$iv222 = e$iv;
                            throw e$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$single$1 = new ChannelsKt__DeprecatedKt$single$1(continuation);
        channelsKt__DeprecatedKt$single$12 = channelsKt__DeprecatedKt$single$1;
        Object $result2 = channelsKt__DeprecatedKt$single$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$single$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0087  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object singleOrNull(ReceiveChannel $this$singleOrNull, Continuation continuation) {
        ChannelsKt__DeprecatedKt$singleOrNull$1 channelsKt__DeprecatedKt$singleOrNull$1;
        ChannelsKt__DeprecatedKt$singleOrNull$1 channelsKt__DeprecatedKt$singleOrNull$12;
        ReceiveChannel $this$consume$iv;
        Throwable cause$iv;
        Throwable e$iv;
        ChannelIterator iterator;
        Object hasNext;
        boolean z;
        ReceiveChannel $this$consume$iv2;
        Object hasNext2;
        Throwable th;
        ReceiveChannel receiveChannel;
        Object obj;
        if (continuation instanceof ChannelsKt__DeprecatedKt$singleOrNull$1) {
            channelsKt__DeprecatedKt$singleOrNull$1 = (ChannelsKt__DeprecatedKt$singleOrNull$1) continuation;
            if ((channelsKt__DeprecatedKt$singleOrNull$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$singleOrNull$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$singleOrNull$12 = channelsKt__DeprecatedKt$singleOrNull$1;
                Object $result = channelsKt__DeprecatedKt$singleOrNull$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$singleOrNull$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$consume$iv = $this$singleOrNull;
                        cause$iv = null;
                        try {
                            iterator = $this$consume$iv.iterator();
                            channelsKt__DeprecatedKt$singleOrNull$12.L$0 = $this$consume$iv;
                            channelsKt__DeprecatedKt$singleOrNull$12.L$1 = iterator;
                            channelsKt__DeprecatedKt$singleOrNull$12.label = 1;
                            hasNext = iterator.hasNext(channelsKt__DeprecatedKt$singleOrNull$12);
                            if (hasNext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z = false;
                            $this$consume$iv2 = $this$consume$iv;
                            try {
                                if (((Boolean) hasNext).booleanValue()) {
                                    ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv);
                                    return null;
                                }
                                try {
                                    Object single = iterator.next();
                                    channelsKt__DeprecatedKt$singleOrNull$12.L$0 = $this$consume$iv2;
                                    channelsKt__DeprecatedKt$singleOrNull$12.L$1 = single;
                                    channelsKt__DeprecatedKt$singleOrNull$12.label = 2;
                                    hasNext2 = iterator.hasNext(channelsKt__DeprecatedKt$singleOrNull$12);
                                    if (hasNext2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    th = cause$iv;
                                    receiveChannel = $this$consume$iv2;
                                    obj = single;
                                    try {
                                        if (((Boolean) hasNext2).booleanValue()) {
                                            ChannelsKt.cancelConsumed(receiveChannel, th);
                                            return obj;
                                        }
                                        ChannelsKt.cancelConsumed(receiveChannel, th);
                                        return null;
                                    } catch (Throwable th2) {
                                        e$iv = th2;
                                        $this$consume$iv = receiveChannel;
                                        Throwable cause$iv2 = e$iv;
                                        try {
                                            throw e$iv;
                                        } catch (Throwable e$iv2) {
                                            ChannelsKt.cancelConsumed($this$consume$iv, cause$iv2);
                                            throw e$iv2;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    e$iv = th3;
                                    $this$consume$iv = $this$consume$iv2;
                                    Throwable cause$iv22 = e$iv;
                                    throw e$iv;
                                }
                            } catch (Throwable th4) {
                                e$iv = th4;
                                $this$consume$iv = $this$consume$iv2;
                            }
                        } catch (Throwable th5) {
                            e$iv = th5;
                            Throwable cause$iv222 = e$iv;
                            throw e$iv;
                        }
                    case 1:
                        ChannelIterator iterator2 = (ChannelIterator) channelsKt__DeprecatedKt$singleOrNull$12.L$1;
                        ReceiveChannel receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$singleOrNull$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            hasNext = $result;
                            $this$consume$iv2 = receiveChannel2;
                            iterator = iterator2;
                            cause$iv = null;
                            z = false;
                            if (((Boolean) hasNext).booleanValue()) {
                            }
                        } catch (Throwable th6) {
                            $this$consume$iv = receiveChannel2;
                            e$iv = th6;
                            Throwable cause$iv2222 = e$iv;
                            throw e$iv;
                        }
                        break;
                    case 2:
                        obj = channelsKt__DeprecatedKt$singleOrNull$12.L$1;
                        receiveChannel = (ReceiveChannel) channelsKt__DeprecatedKt$singleOrNull$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            hasNext2 = $result;
                            th = null;
                            if (((Boolean) hasNext2).booleanValue()) {
                            }
                        } catch (Throwable th7) {
                            e$iv = th7;
                            $this$consume$iv = receiveChannel;
                            Throwable cause$iv22222 = e$iv;
                            throw e$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$singleOrNull$1 = new ChannelsKt__DeprecatedKt$singleOrNull$1(continuation);
        channelsKt__DeprecatedKt$singleOrNull$12 = channelsKt__DeprecatedKt$singleOrNull$1;
        Object $result2 = channelsKt__DeprecatedKt$singleOrNull$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$singleOrNull$12.label) {
        }
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        ReceiveChannel drop;
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        drop = drop(receiveChannel, i, coroutineContext);
        return drop;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel drop(ReceiveChannel $this$drop, int n, CoroutineContext context) {
        ReceiveChannel produce;
        produce = ProduceKt.produce(GlobalScope.INSTANCE, (r12 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (r12 & 2) != 0 ? 0 : 0, (r12 & 4) != 0 ? CoroutineStart.DEFAULT : null, (r12 & 8) != 0 ? null : ChannelsKt.consumes($this$drop), new ChannelsKt__DeprecatedKt$drop$1(n, $this$drop, null));
        return produce;
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel dropWhile;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        dropWhile = dropWhile(receiveChannel, coroutineContext, function2);
        return dropWhile;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel dropWhile(ReceiveChannel $this$dropWhile, CoroutineContext context, Function2 predicate) {
        ReceiveChannel produce;
        produce = ProduceKt.produce(GlobalScope.INSTANCE, (r12 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (r12 & 2) != 0 ? 0 : 0, (r12 & 4) != 0 ? CoroutineStart.DEFAULT : null, (r12 & 8) != 0 ? null : ChannelsKt.consumes($this$dropWhile), new ChannelsKt__DeprecatedKt$dropWhile$1($this$dropWhile, predicate, null));
        return produce;
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.filter(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> receiveChannel, CoroutineContext context, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        ReceiveChannel<E> produce;
        produce = ProduceKt.produce(GlobalScope.INSTANCE, (r12 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (r12 & 2) != 0 ? 0 : 0, (r12 & 4) != 0 ? CoroutineStart.DEFAULT : null, (r12 & 8) != 0 ? null : ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$filter$1(receiveChannel, function2, null));
        return produce;
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        ReceiveChannel filterIndexed;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        filterIndexed = filterIndexed(receiveChannel, coroutineContext, function3);
        return filterIndexed;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterIndexed(ReceiveChannel $this$filterIndexed, CoroutineContext context, Function3 predicate) {
        ReceiveChannel produce;
        produce = ProduceKt.produce(GlobalScope.INSTANCE, (r12 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (r12 & 2) != 0 ? 0 : 0, (r12 & 4) != 0 ? CoroutineStart.DEFAULT : null, (r12 & 8) != 0 ? null : ChannelsKt.consumes($this$filterIndexed), new ChannelsKt__DeprecatedKt$filterIndexed$1($this$filterIndexed, predicate, null));
        return produce;
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel filterNot;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        filterNot = filterNot(receiveChannel, coroutineContext, function2);
        return filterNot;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterNot(ReceiveChannel $this$filterNot, CoroutineContext context, Function2 predicate) {
        return ChannelsKt.filter($this$filterNot, context, new ChannelsKt__DeprecatedKt$filterNot$1(predicate, null));
    }

    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> receiveChannel) {
        ReceiveChannel<E> filter$default;
        filter$default = filter$default(receiveChannel, null, new ChannelsKt__DeprecatedKt$filterNotNull$1(null), 1, null);
        Intrinsics.checkNotNull(filter$default, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNull>");
        return filter$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0082 A[Catch: all -> 0x009f, TryCatch #3 {all -> 0x009f, blocks: (B:74:0x007a, B:76:0x0082, B:78:0x0089, B:80:0x0095), top: B:98:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0095 A[Catch: all -> 0x009f, TRY_LEAVE, TryCatch #3 {all -> 0x009f, blocks: (B:74:0x007a, B:76:0x0082, B:78:0x0089, B:80:0x0095), top: B:98:0x007a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0071 -> B:98:0x007a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel $this$consumeEach$iv, Collection destination, Continuation continuation) {
        ChannelsKt__DeprecatedKt$filterNotNullTo$1 channelsKt__DeprecatedKt$filterNotNullTo$1;
        ChannelsKt__DeprecatedKt$filterNotNullTo$1 channelsKt__DeprecatedKt$filterNotNullTo$12;
        ReceiveChannel $this$consume$iv$iv;
        Throwable cause$iv$iv;
        Object $result;
        Collection destination2;
        ReceiveChannel $this$consume$iv$iv2;
        Throwable cause$iv$iv2;
        ChannelIterator channelIterator;
        int i;
        Object obj;
        if (continuation instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$1) {
            channelsKt__DeprecatedKt$filterNotNullTo$1 = (ChannelsKt__DeprecatedKt$filterNotNullTo$1) continuation;
            if ((channelsKt__DeprecatedKt$filterNotNullTo$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$filterNotNullTo$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$filterNotNullTo$12 = channelsKt__DeprecatedKt$filterNotNullTo$1;
                Object $result2 = channelsKt__DeprecatedKt$filterNotNullTo$12.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$filterNotNullTo$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        $this$consume$iv$iv = $this$consumeEach$iv;
                        Throwable cause$iv$iv3 = null;
                        try {
                            ChannelIterator it = $this$consume$iv$iv.iterator();
                            int $i$f$consumeEach = 0;
                            Collection destination3 = destination;
                            channelsKt__DeprecatedKt$filterNotNullTo$12.L$0 = destination3;
                            channelsKt__DeprecatedKt$filterNotNullTo$12.L$1 = $this$consume$iv$iv;
                            channelsKt__DeprecatedKt$filterNotNullTo$12.L$2 = it;
                            channelsKt__DeprecatedKt$filterNotNullTo$12.label = 1;
                            Object hasNext = it.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$12);
                            if (hasNext != $result3) {
                                return $result3;
                            }
                            Object obj2 = $result3;
                            $result = $result2;
                            $result2 = hasNext;
                            destination2 = destination3;
                            $this$consume$iv$iv2 = $this$consume$iv$iv;
                            cause$iv$iv2 = cause$iv$iv3;
                            channelIterator = it;
                            i = $i$f$consumeEach;
                            obj = obj2;
                            try {
                                if (((Boolean) $result2).booleanValue()) {
                                    Object it2 = channelIterator.next();
                                    if (it2 != null) {
                                        destination2.add(it2);
                                    }
                                    $result2 = $result;
                                    $result3 = obj;
                                    $i$f$consumeEach = i;
                                    it = channelIterator;
                                    cause$iv$iv3 = cause$iv$iv;
                                    $this$consume$iv$iv = $this$consume$iv$iv;
                                    destination3 = destination2;
                                    channelsKt__DeprecatedKt$filterNotNullTo$12.L$0 = destination3;
                                    channelsKt__DeprecatedKt$filterNotNullTo$12.L$1 = $this$consume$iv$iv;
                                    channelsKt__DeprecatedKt$filterNotNullTo$12.L$2 = it;
                                    channelsKt__DeprecatedKt$filterNotNullTo$12.label = 1;
                                    Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$12);
                                    if (hasNext2 != $result3) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    return destination2;
                                }
                            } catch (Throwable th) {
                                $this$consume$iv$iv = $this$consume$iv$iv;
                                e$iv$iv = th;
                                cause$iv$iv = e$iv$iv;
                                try {
                                    throw e$iv$iv;
                                } finally {
                                    ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                                }
                            }
                        } catch (Throwable th2) {
                            e$iv$iv = th2;
                            cause$iv$iv = e$iv$iv;
                            throw e$iv$iv;
                        }
                    case 1:
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$12.L$2;
                        $this$consume$iv$iv = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$12.L$1;
                        Collection destination4 = (Collection) channelsKt__DeprecatedKt$filterNotNullTo$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            destination2 = destination4;
                            $this$consume$iv$iv2 = $this$consume$iv$iv;
                            cause$iv$iv2 = null;
                            channelIterator = channelIterator2;
                            i = 0;
                            obj = $result3;
                            $result = $result2;
                            if (((Boolean) $result2).booleanValue()) {
                            }
                        } catch (Throwable th3) {
                            e$iv$iv = th3;
                            cause$iv$iv = e$iv$iv;
                            throw e$iv$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$filterNotNullTo$1 = new ChannelsKt__DeprecatedKt$filterNotNullTo$1(continuation);
        channelsKt__DeprecatedKt$filterNotNullTo$12 = channelsKt__DeprecatedKt$filterNotNullTo$1;
        Object $result22 = channelsKt__DeprecatedKt$filterNotNullTo$12.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$filterNotNullTo$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0093 A[Catch: all -> 0x00c7, TryCatch #1 {all -> 0x00c7, blocks: (B:88:0x008b, B:90:0x0093, B:92:0x009a, B:99:0x00bd), top: B:115:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00bd A[Catch: all -> 0x00c7, TRY_LEAVE, TryCatch #1 {all -> 0x00c7, blocks: (B:88:0x008b, B:90:0x0093, B:92:0x009a, B:99:0x00bd), top: B:115:0x008b }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x00aa -> B:96:0x00af). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x00b8 -> B:98:0x00bc). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel $this$consumeEach$iv, SendChannel destination, Continuation continuation) {
        ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$3;
        ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$32;
        ReceiveChannel $this$consume$iv$iv;
        Throwable cause$iv$iv;
        int destination2;
        ChannelIterator it;
        boolean z;
        Object obj;
        Object $result;
        ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$33;
        boolean z2;
        ChannelIterator channelIterator;
        SendChannel destination3;
        int i;
        ChannelIterator channelIterator2;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$3) {
                channelsKt__DeprecatedKt$filterNotNullTo$3 = (ChannelsKt__DeprecatedKt$filterNotNullTo$3) continuation;
                if ((channelsKt__DeprecatedKt$filterNotNullTo$3.label & IntCompanionObject.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$filterNotNullTo$3.label -= IntCompanionObject.MIN_VALUE;
                    channelsKt__DeprecatedKt$filterNotNullTo$32 = channelsKt__DeprecatedKt$filterNotNullTo$3;
                    Object $result2 = channelsKt__DeprecatedKt$filterNotNullTo$32.result;
                    Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (channelsKt__DeprecatedKt$filterNotNullTo$32.label) {
                        case 0:
                            ResultKt.throwOnFailure($result2);
                            $this$consume$iv$iv = $this$consumeEach$iv;
                            cause$iv$iv = null;
                            destination2 = 0;
                            try {
                                it = $this$consume$iv$iv.iterator();
                                z = false;
                                obj = $result3;
                                $result = $result2;
                                channelsKt__DeprecatedKt$filterNotNullTo$33 = channelsKt__DeprecatedKt$filterNotNullTo$32;
                            } catch (Throwable th) {
                                e$iv$iv = th;
                                Throwable cause$iv$iv2 = e$iv$iv;
                                try {
                                    throw e$iv$iv;
                                } finally {
                                    ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv2);
                                }
                            }
                            try {
                                channelsKt__DeprecatedKt$filterNotNullTo$33.L$0 = destination;
                                channelsKt__DeprecatedKt$filterNotNullTo$33.L$1 = $this$consume$iv$iv;
                                channelsKt__DeprecatedKt$filterNotNullTo$33.L$2 = it;
                                channelsKt__DeprecatedKt$filterNotNullTo$33.label = 1;
                                hasNext = it.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$33);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                ChannelIterator channelIterator3 = it;
                                destination3 = destination;
                                z2 = z;
                                channelsKt__DeprecatedKt$filterNotNullTo$32 = channelsKt__DeprecatedKt$filterNotNullTo$33;
                                $result2 = hasNext;
                                channelIterator = channelIterator3;
                                try {
                                    if (!((Boolean) $result2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        return destination3;
                                    }
                                    Object it2 = channelIterator.next();
                                    if (it2 != null) {
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$0 = destination3;
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$1 = $this$consume$iv$iv;
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$2 = channelIterator;
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.label = 2;
                                        if (destination3.send(it2, channelsKt__DeprecatedKt$filterNotNullTo$32) == obj) {
                                            return obj;
                                        }
                                        $result2 = $result;
                                        $result3 = obj;
                                        i = destination2;
                                        channelIterator2 = channelIterator;
                                        ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$34 = channelsKt__DeprecatedKt$filterNotNullTo$32;
                                        z = z2;
                                        destination = destination3;
                                        it = channelIterator2;
                                        destination2 = i;
                                        obj = $result3;
                                        $result = $result2;
                                        channelsKt__DeprecatedKt$filterNotNullTo$33 = channelsKt__DeprecatedKt$filterNotNullTo$34;
                                        channelsKt__DeprecatedKt$filterNotNullTo$33.L$0 = destination;
                                        channelsKt__DeprecatedKt$filterNotNullTo$33.L$1 = $this$consume$iv$iv;
                                        channelsKt__DeprecatedKt$filterNotNullTo$33.L$2 = it;
                                        channelsKt__DeprecatedKt$filterNotNullTo$33.label = 1;
                                        hasNext = it.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$33);
                                        if (hasNext != obj) {
                                        }
                                    } else {
                                        channelsKt__DeprecatedKt$filterNotNullTo$33 = channelsKt__DeprecatedKt$filterNotNullTo$32;
                                        z = z2;
                                        destination = destination3;
                                        it = channelIterator;
                                        channelsKt__DeprecatedKt$filterNotNullTo$33.L$0 = destination;
                                        channelsKt__DeprecatedKt$filterNotNullTo$33.L$1 = $this$consume$iv$iv;
                                        channelsKt__DeprecatedKt$filterNotNullTo$33.L$2 = it;
                                        channelsKt__DeprecatedKt$filterNotNullTo$33.label = 1;
                                        hasNext = it.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$33);
                                        if (hasNext != obj) {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    e$iv$iv = th2;
                                    Throwable cause$iv$iv22 = e$iv$iv;
                                    throw e$iv$iv;
                                }
                            } catch (Throwable th3) {
                                e$iv$iv = th3;
                                Throwable cause$iv$iv222 = e$iv$iv;
                                throw e$iv$iv;
                            }
                        case 1:
                            z2 = false;
                            channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$32.L$2;
                            cause$iv$iv = null;
                            ReceiveChannel $this$consume$iv$iv2 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$32.L$1;
                            $this$consume$iv$iv = $this$consume$iv$iv2;
                            SendChannel destination4 = (SendChannel) channelsKt__DeprecatedKt$filterNotNullTo$32.L$0;
                            ResultKt.throwOnFailure($result2);
                            destination3 = destination4;
                            destination2 = 0;
                            obj = $result3;
                            $result = $result2;
                            if (!((Boolean) $result2).booleanValue()) {
                            }
                            break;
                        case 2:
                            z2 = false;
                            i = 0;
                            channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$32.L$2;
                            cause$iv$iv = null;
                            $this$consume$iv$iv = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$32.L$1;
                            destination3 = (SendChannel) channelsKt__DeprecatedKt$filterNotNullTo$32.L$0;
                            ResultKt.throwOnFailure($result2);
                            ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$342 = channelsKt__DeprecatedKt$filterNotNullTo$32;
                            z = z2;
                            destination = destination3;
                            it = channelIterator2;
                            destination2 = i;
                            obj = $result3;
                            $result = $result2;
                            channelsKt__DeprecatedKt$filterNotNullTo$33 = channelsKt__DeprecatedKt$filterNotNullTo$342;
                            channelsKt__DeprecatedKt$filterNotNullTo$33.L$0 = destination;
                            channelsKt__DeprecatedKt$filterNotNullTo$33.L$1 = $this$consume$iv$iv;
                            channelsKt__DeprecatedKt$filterNotNullTo$33.L$2 = it;
                            channelsKt__DeprecatedKt$filterNotNullTo$33.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$33);
                            if (hasNext != obj) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (channelsKt__DeprecatedKt$filterNotNullTo$32.label) {
            }
        } catch (Throwable th4) {
            e$iv$iv = th4;
        }
        channelsKt__DeprecatedKt$filterNotNullTo$3 = new ChannelsKt__DeprecatedKt$filterNotNullTo$3(continuation);
        channelsKt__DeprecatedKt$filterNotNullTo$32 = channelsKt__DeprecatedKt$filterNotNullTo$3;
        Object $result22 = channelsKt__DeprecatedKt$filterNotNullTo$32.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        ReceiveChannel take;
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        take = take(receiveChannel, i, coroutineContext);
        return take;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel take(ReceiveChannel $this$take, int n, CoroutineContext context) {
        ReceiveChannel produce;
        produce = ProduceKt.produce(GlobalScope.INSTANCE, (r12 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (r12 & 2) != 0 ? 0 : 0, (r12 & 4) != 0 ? CoroutineStart.DEFAULT : null, (r12 & 8) != 0 ? null : ChannelsKt.consumes($this$take), new ChannelsKt__DeprecatedKt$take$1(n, $this$take, null));
        return produce;
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel takeWhile;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        takeWhile = takeWhile(receiveChannel, coroutineContext, function2);
        return takeWhile;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel takeWhile(ReceiveChannel $this$takeWhile, CoroutineContext context, Function2 predicate) {
        ReceiveChannel produce;
        produce = ProduceKt.produce(GlobalScope.INSTANCE, (r12 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (r12 & 2) != 0 ? 0 : 0, (r12 & 4) != 0 ? CoroutineStart.DEFAULT : null, (r12 & 8) != 0 ? null : ChannelsKt.consumes($this$takeWhile), new ChannelsKt__DeprecatedKt$takeWhile$1($this$takeWhile, predicate, null));
        return produce;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x009b A[Catch: all -> 0x00c1, TryCatch #0 {all -> 0x00c1, blocks: (B:84:0x0093, B:86:0x009b, B:91:0x00b7), top: B:105:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b7 A[Catch: all -> 0x00c1, TRY_LEAVE, TryCatch #0 {all -> 0x00c1, blocks: (B:84:0x0093, B:86:0x009b, B:91:0x00b7), top: B:105:0x0093 }] */
    /* JADX WARN: Type inference failed for: r4v4, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v8, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x00b0 -> B:90:0x00b5). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__DeprecatedKt$toChannel$1 channelsKt__DeprecatedKt$toChannel$1;
        ChannelsKt__DeprecatedKt$toChannel$1 channelsKt__DeprecatedKt$toChannel$12;
        ReceiveChannel $this$consume$iv$iv;
        Throwable cause$iv$iv;
        ChannelIterator<E> it;
        boolean z;
        Object obj;
        Object $result;
        ChannelsKt__DeprecatedKt$toChannel$1 channelsKt__DeprecatedKt$toChannel$13;
        boolean z2;
        ChannelIterator<E> channelIterator;
        C c2;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__DeprecatedKt$toChannel$1) {
                channelsKt__DeprecatedKt$toChannel$1 = (ChannelsKt__DeprecatedKt$toChannel$1) continuation;
                if ((channelsKt__DeprecatedKt$toChannel$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$toChannel$1.label -= IntCompanionObject.MIN_VALUE;
                    channelsKt__DeprecatedKt$toChannel$12 = channelsKt__DeprecatedKt$toChannel$1;
                    Object $result2 = channelsKt__DeprecatedKt$toChannel$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (channelsKt__DeprecatedKt$toChannel$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result2);
                            $this$consume$iv$iv = receiveChannel;
                            cause$iv$iv = null;
                            try {
                                it = $this$consume$iv$iv.iterator();
                                z = false;
                                obj = coroutine_suspended;
                                $result = $result2;
                                channelsKt__DeprecatedKt$toChannel$13 = channelsKt__DeprecatedKt$toChannel$12;
                                try {
                                    channelsKt__DeprecatedKt$toChannel$13.L$0 = c;
                                    channelsKt__DeprecatedKt$toChannel$13.L$1 = $this$consume$iv$iv;
                                    channelsKt__DeprecatedKt$toChannel$13.L$2 = it;
                                    channelsKt__DeprecatedKt$toChannel$13.label = 1;
                                    hasNext = it.hasNext(channelsKt__DeprecatedKt$toChannel$13);
                                    if (hasNext == obj) {
                                        return obj;
                                    }
                                    ChannelIterator<E> channelIterator2 = it;
                                    c2 = c;
                                    z2 = z;
                                    channelsKt__DeprecatedKt$toChannel$12 = channelsKt__DeprecatedKt$toChannel$13;
                                    $result2 = hasNext;
                                    channelIterator = channelIterator2;
                                    try {
                                        if (((Boolean) $result2).booleanValue()) {
                                            Unit unit = Unit.INSTANCE;
                                            return c2;
                                        }
                                        E next = channelIterator.next();
                                        channelsKt__DeprecatedKt$toChannel$12.L$0 = c2;
                                        channelsKt__DeprecatedKt$toChannel$12.L$1 = $this$consume$iv$iv;
                                        channelsKt__DeprecatedKt$toChannel$12.L$2 = channelIterator;
                                        channelsKt__DeprecatedKt$toChannel$12.label = 2;
                                        if (c2.send(next, channelsKt__DeprecatedKt$toChannel$12) == obj) {
                                            return obj;
                                        }
                                        channelsKt__DeprecatedKt$toChannel$13 = channelsKt__DeprecatedKt$toChannel$12;
                                        z = z2;
                                        c = c2;
                                        it = channelIterator;
                                        channelsKt__DeprecatedKt$toChannel$13.L$0 = c;
                                        channelsKt__DeprecatedKt$toChannel$13.L$1 = $this$consume$iv$iv;
                                        channelsKt__DeprecatedKt$toChannel$13.L$2 = it;
                                        channelsKt__DeprecatedKt$toChannel$13.label = 1;
                                        hasNext = it.hasNext(channelsKt__DeprecatedKt$toChannel$13);
                                        if (hasNext == obj) {
                                        }
                                    } catch (Throwable th) {
                                        e$iv$iv = th;
                                        Throwable cause$iv$iv2 = e$iv$iv;
                                        try {
                                            throw e$iv$iv;
                                        } finally {
                                            ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv2);
                                        }
                                    }
                                } catch (Throwable th2) {
                                    e$iv$iv = th2;
                                    Throwable cause$iv$iv22 = e$iv$iv;
                                    throw e$iv$iv;
                                }
                            } catch (Throwable th3) {
                                e$iv$iv = th3;
                                Throwable cause$iv$iv222 = e$iv$iv;
                                throw e$iv$iv;
                            }
                        case 1:
                            z2 = false;
                            channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$toChannel$12.L$2;
                            cause$iv$iv = null;
                            ReceiveChannel $this$consume$iv$iv2 = (ReceiveChannel) channelsKt__DeprecatedKt$toChannel$12.L$1;
                            $this$consume$iv$iv = $this$consume$iv$iv2;
                            ?? r4 = (SendChannel) channelsKt__DeprecatedKt$toChannel$12.L$0;
                            ResultKt.throwOnFailure($result2);
                            c2 = r4;
                            obj = coroutine_suspended;
                            $result = $result2;
                            if (((Boolean) $result2).booleanValue()) {
                            }
                            break;
                        case 2:
                            ChannelIterator<E> channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$toChannel$12.L$2;
                            cause$iv$iv = null;
                            $this$consume$iv$iv = (ReceiveChannel) channelsKt__DeprecatedKt$toChannel$12.L$1;
                            ?? r7 = (SendChannel) channelsKt__DeprecatedKt$toChannel$12.L$0;
                            ResultKt.throwOnFailure($result2);
                            z = false;
                            c = r7;
                            it = channelIterator3;
                            obj = coroutine_suspended;
                            $result = $result2;
                            channelsKt__DeprecatedKt$toChannel$13 = channelsKt__DeprecatedKt$toChannel$12;
                            channelsKt__DeprecatedKt$toChannel$13.L$0 = c;
                            channelsKt__DeprecatedKt$toChannel$13.L$1 = $this$consume$iv$iv;
                            channelsKt__DeprecatedKt$toChannel$13.L$2 = it;
                            channelsKt__DeprecatedKt$toChannel$13.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$toChannel$13);
                            if (hasNext == obj) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (channelsKt__DeprecatedKt$toChannel$12.label) {
            }
        } catch (Throwable th4) {
            e$iv$iv = th4;
        }
        channelsKt__DeprecatedKt$toChannel$1 = new ChannelsKt__DeprecatedKt$toChannel$1(continuation);
        channelsKt__DeprecatedKt$toChannel$12 = channelsKt__DeprecatedKt$toChannel$1;
        Object $result22 = channelsKt__DeprecatedKt$toChannel$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0082 A[Catch: all -> 0x009e, TryCatch #3 {all -> 0x009e, blocks: (B:71:0x007a, B:73:0x0082, B:74:0x0094), top: B:92:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0094 A[Catch: all -> 0x009e, TRY_LEAVE, TryCatch #3 {all -> 0x009e, blocks: (B:71:0x007a, B:73:0x0082, B:74:0x0094), top: B:92:0x007a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0071 -> B:92:0x007a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__DeprecatedKt$toCollection$1 channelsKt__DeprecatedKt$toCollection$1;
        ChannelsKt__DeprecatedKt$toCollection$1 channelsKt__DeprecatedKt$toCollection$12;
        ReceiveChannel $this$consume$iv$iv;
        Throwable cause$iv$iv;
        Object $result;
        Collection destination;
        ReceiveChannel $this$consume$iv$iv2;
        Throwable cause$iv$iv2;
        ChannelIterator<E> channelIterator;
        int i;
        Object obj;
        if (continuation instanceof ChannelsKt__DeprecatedKt$toCollection$1) {
            channelsKt__DeprecatedKt$toCollection$1 = (ChannelsKt__DeprecatedKt$toCollection$1) continuation;
            if ((channelsKt__DeprecatedKt$toCollection$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$toCollection$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$toCollection$12 = channelsKt__DeprecatedKt$toCollection$1;
                Object e$iv = channelsKt__DeprecatedKt$toCollection$12.result;
                Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$toCollection$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(e$iv);
                        $this$consume$iv$iv = receiveChannel;
                        Throwable cause$iv$iv3 = null;
                        try {
                            ChannelIterator<E> it = $this$consume$iv$iv.iterator();
                            int $i$f$consumeEach = 0;
                            Collection destination2 = c;
                            channelsKt__DeprecatedKt$toCollection$12.L$0 = destination2;
                            channelsKt__DeprecatedKt$toCollection$12.L$1 = $this$consume$iv$iv;
                            channelsKt__DeprecatedKt$toCollection$12.L$2 = it;
                            channelsKt__DeprecatedKt$toCollection$12.label = 1;
                            Object hasNext = it.hasNext(channelsKt__DeprecatedKt$toCollection$12);
                            if (hasNext != $result2) {
                                return $result2;
                            }
                            Object obj2 = $result2;
                            $result = e$iv;
                            e$iv = hasNext;
                            destination = destination2;
                            $this$consume$iv$iv2 = $this$consume$iv$iv;
                            cause$iv$iv2 = cause$iv$iv3;
                            channelIterator = it;
                            i = $i$f$consumeEach;
                            obj = obj2;
                            try {
                                if (!((Boolean) e$iv).booleanValue()) {
                                    destination.add(channelIterator.next());
                                    e$iv = $result;
                                    $result2 = obj;
                                    $i$f$consumeEach = i;
                                    it = channelIterator;
                                    cause$iv$iv3 = cause$iv$iv;
                                    $this$consume$iv$iv = $this$consume$iv$iv;
                                    destination2 = destination;
                                    channelsKt__DeprecatedKt$toCollection$12.L$0 = destination2;
                                    channelsKt__DeprecatedKt$toCollection$12.L$1 = $this$consume$iv$iv;
                                    channelsKt__DeprecatedKt$toCollection$12.L$2 = it;
                                    channelsKt__DeprecatedKt$toCollection$12.label = 1;
                                    Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$toCollection$12);
                                    if (hasNext2 != $result2) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    return destination;
                                }
                            } catch (Throwable th) {
                                $this$consume$iv$iv = $this$consume$iv$iv;
                                e$iv$iv = th;
                                cause$iv$iv = e$iv$iv;
                                try {
                                    throw e$iv$iv;
                                } finally {
                                    ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                                }
                            }
                        } catch (Throwable th2) {
                            e$iv$iv = th2;
                            cause$iv$iv = e$iv$iv;
                            throw e$iv$iv;
                        }
                    case 1:
                        ChannelIterator<E> channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$toCollection$12.L$2;
                        $this$consume$iv$iv = (ReceiveChannel) channelsKt__DeprecatedKt$toCollection$12.L$1;
                        Collection destination3 = (Collection) channelsKt__DeprecatedKt$toCollection$12.L$0;
                        try {
                            ResultKt.throwOnFailure(e$iv);
                            destination = destination3;
                            $this$consume$iv$iv2 = $this$consume$iv$iv;
                            cause$iv$iv2 = null;
                            channelIterator = channelIterator2;
                            i = 0;
                            obj = $result2;
                            $result = e$iv;
                            if (!((Boolean) e$iv).booleanValue()) {
                            }
                        } catch (Throwable th3) {
                            e$iv$iv = th3;
                            cause$iv$iv = e$iv$iv;
                            throw e$iv$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$toCollection$1 = new ChannelsKt__DeprecatedKt$toCollection$1(continuation);
        channelsKt__DeprecatedKt$toCollection$12 = channelsKt__DeprecatedKt$toCollection$1;
        Object e$iv2 = channelsKt__DeprecatedKt$toCollection$12.result;
        Object $result22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$toCollection$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0082 A[Catch: all -> 0x00a8, TryCatch #1 {all -> 0x00a8, blocks: (B:71:0x007a, B:73:0x0082, B:74:0x009e), top: B:88:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x009e A[Catch: all -> 0x00a8, TRY_LEAVE, TryCatch #1 {all -> 0x00a8, blocks: (B:71:0x007a, B:73:0x0082, B:74:0x009e), top: B:88:0x007a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0071 -> B:88:0x007a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) {
        ChannelsKt__DeprecatedKt$toMap$2 channelsKt__DeprecatedKt$toMap$2;
        ChannelsKt__DeprecatedKt$toMap$2 channelsKt__DeprecatedKt$toMap$22;
        ReceiveChannel $this$consume$iv$iv;
        Throwable cause$iv$iv;
        Object $result;
        Map destination;
        ReceiveChannel $this$consume$iv$iv2;
        Throwable cause$iv$iv2;
        ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator;
        int i;
        Object obj;
        if (continuation instanceof ChannelsKt__DeprecatedKt$toMap$2) {
            channelsKt__DeprecatedKt$toMap$2 = (ChannelsKt__DeprecatedKt$toMap$2) continuation;
            if ((channelsKt__DeprecatedKt$toMap$2.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$toMap$2.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$toMap$22 = channelsKt__DeprecatedKt$toMap$2;
                Object e$iv = channelsKt__DeprecatedKt$toMap$22.result;
                Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$toMap$22.label) {
                    case 0:
                        ResultKt.throwOnFailure(e$iv);
                        $this$consume$iv$iv = receiveChannel;
                        Throwable cause$iv$iv3 = null;
                        try {
                            ChannelIterator<? extends Pair<? extends K, ? extends V>> it = $this$consume$iv$iv.iterator();
                            int $i$f$consumeEach = 0;
                            M m2 = m;
                            channelsKt__DeprecatedKt$toMap$22.L$0 = m2;
                            channelsKt__DeprecatedKt$toMap$22.L$1 = $this$consume$iv$iv;
                            channelsKt__DeprecatedKt$toMap$22.L$2 = it;
                            channelsKt__DeprecatedKt$toMap$22.label = 1;
                            Object hasNext = it.hasNext(channelsKt__DeprecatedKt$toMap$22);
                            if (hasNext != $result2) {
                                return $result2;
                            }
                            Object obj2 = $result2;
                            $result = e$iv;
                            e$iv = hasNext;
                            destination = m2;
                            $this$consume$iv$iv2 = $this$consume$iv$iv;
                            cause$iv$iv2 = cause$iv$iv3;
                            channelIterator = it;
                            i = $i$f$consumeEach;
                            obj = obj2;
                            try {
                                if (!((Boolean) e$iv).booleanValue()) {
                                    Pair it2 = channelIterator.next();
                                    destination.put(it2.getFirst(), it2.getSecond());
                                    e$iv = $result;
                                    $result2 = obj;
                                    $i$f$consumeEach = i;
                                    it = channelIterator;
                                    cause$iv$iv3 = cause$iv$iv;
                                    $this$consume$iv$iv = $this$consume$iv$iv;
                                    m2 = destination;
                                    channelsKt__DeprecatedKt$toMap$22.L$0 = m2;
                                    channelsKt__DeprecatedKt$toMap$22.L$1 = $this$consume$iv$iv;
                                    channelsKt__DeprecatedKt$toMap$22.L$2 = it;
                                    channelsKt__DeprecatedKt$toMap$22.label = 1;
                                    Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$toMap$22);
                                    if (hasNext2 != $result2) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    return destination;
                                }
                            } catch (Throwable th) {
                                $this$consume$iv$iv = $this$consume$iv$iv;
                                e$iv$iv = th;
                                cause$iv$iv = e$iv$iv;
                                try {
                                    throw e$iv$iv;
                                } finally {
                                    ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                                }
                            }
                        } catch (Throwable th2) {
                            e$iv$iv = th2;
                            cause$iv$iv = e$iv$iv;
                            throw e$iv$iv;
                        }
                    case 1:
                        ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$toMap$22.L$2;
                        $this$consume$iv$iv = (ReceiveChannel) channelsKt__DeprecatedKt$toMap$22.L$1;
                        Map destination2 = (Map) channelsKt__DeprecatedKt$toMap$22.L$0;
                        try {
                            ResultKt.throwOnFailure(e$iv);
                            destination = destination2;
                            $this$consume$iv$iv2 = $this$consume$iv$iv;
                            cause$iv$iv2 = null;
                            channelIterator = channelIterator2;
                            i = 0;
                            obj = $result2;
                            $result = e$iv;
                            if (!((Boolean) e$iv).booleanValue()) {
                            }
                        } catch (Throwable th3) {
                            e$iv$iv = th3;
                            cause$iv$iv = e$iv$iv;
                            throw e$iv$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$toMap$2 = new ChannelsKt__DeprecatedKt$toMap$2(continuation);
        channelsKt__DeprecatedKt$toMap$22 = channelsKt__DeprecatedKt$toMap$2;
        Object e$iv2 = channelsKt__DeprecatedKt$toMap$22.result;
        Object $result22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$toMap$22.label) {
        }
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel flatMap;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        flatMap = flatMap(receiveChannel, coroutineContext, function2);
        return flatMap;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel flatMap(ReceiveChannel $this$flatMap, CoroutineContext context, Function2 transform) {
        ReceiveChannel produce;
        produce = ProduceKt.produce(GlobalScope.INSTANCE, (r12 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (r12 & 2) != 0 ? 0 : 0, (r12 & 4) != 0 ? CoroutineStart.DEFAULT : null, (r12 & 8) != 0 ? null : ChannelsKt.consumes($this$flatMap), new ChannelsKt__DeprecatedKt$flatMap$1($this$flatMap, transform, null));
        return produce;
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.map(receiveChannel, coroutineContext, function2);
    }

    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> receiveChannel, CoroutineContext context, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        ReceiveChannel<R> produce;
        produce = ProduceKt.produce(GlobalScope.INSTANCE, (r12 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (r12 & 2) != 0 ? 0 : 0, (r12 & 4) != 0 ? CoroutineStart.DEFAULT : null, (r12 & 8) != 0 ? null : ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$map$1(receiveChannel, function2, null));
        return produce;
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext context, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        ReceiveChannel<R> produce;
        produce = ProduceKt.produce(GlobalScope.INSTANCE, (r12 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (r12 & 2) != 0 ? 0 : 0, (r12 & 4) != 0 ? CoroutineStart.DEFAULT : null, (r12 & 8) != 0 ? null : ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$mapIndexed$1(receiveChannel, function3, null));
        return produce;
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        ReceiveChannel mapIndexedNotNull;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        mapIndexedNotNull = mapIndexedNotNull(receiveChannel, coroutineContext, function3);
        return mapIndexedNotNull;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapIndexedNotNull(ReceiveChannel $this$mapIndexedNotNull, CoroutineContext context, Function3 transform) {
        return ChannelsKt.filterNotNull(ChannelsKt.mapIndexed($this$mapIndexedNotNull, context, transform));
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel mapNotNull;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        mapNotNull = mapNotNull(receiveChannel, coroutineContext, function2);
        return mapNotNull;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapNotNull(ReceiveChannel $this$mapNotNull, CoroutineContext context, Function2 transform) {
        return ChannelsKt.filterNotNull(ChannelsKt.map($this$mapNotNull, context, transform));
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int i, Object obj) {
        ReceiveChannel withIndex;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        withIndex = withIndex(receiveChannel, coroutineContext);
        return withIndex;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel withIndex(ReceiveChannel $this$withIndex, CoroutineContext context) {
        ReceiveChannel produce;
        produce = ProduceKt.produce(GlobalScope.INSTANCE, (r12 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (r12 & 2) != 0 ? 0 : 0, (r12 & 4) != 0 ? CoroutineStart.DEFAULT : null, (r12 & 8) != 0 ? null : ChannelsKt.consumes($this$withIndex), new ChannelsKt__DeprecatedKt$withIndex$1($this$withIndex, null));
        return produce;
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> receiveChannel, CoroutineContext context, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        ReceiveChannel<E> produce;
        produce = ProduceKt.produce(GlobalScope.INSTANCE, (r12 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (r12 & 2) != 0 ? 0 : 0, (r12 & 4) != 0 ? CoroutineStart.DEFAULT : null, (r12 & 8) != 0 ? null : ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$distinctBy$1(receiveChannel, function2, null));
        return produce;
    }

    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<E>> continuation) {
        return ChannelsKt.toCollection(receiveChannel, new LinkedHashSet(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x003b  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object any(ReceiveChannel $this$any, Continuation continuation) {
        ChannelsKt__DeprecatedKt$any$1 channelsKt__DeprecatedKt$any$1;
        ChannelsKt__DeprecatedKt$any$1 channelsKt__DeprecatedKt$any$12;
        ReceiveChannel $this$consume$iv;
        Throwable cause$iv;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$any$1) {
            channelsKt__DeprecatedKt$any$1 = (ChannelsKt__DeprecatedKt$any$1) continuation;
            if ((channelsKt__DeprecatedKt$any$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$any$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$any$12 = channelsKt__DeprecatedKt$any$1;
                Object $result = channelsKt__DeprecatedKt$any$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$any$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$consume$iv = $this$any;
                        cause$iv = null;
                        try {
                            ChannelIterator it = $this$consume$iv.iterator();
                            channelsKt__DeprecatedKt$any$12.L$0 = $this$consume$iv;
                            channelsKt__DeprecatedKt$any$12.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$any$12);
                            if (hasNext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return hasNext;
                        } catch (Throwable th) {
                            e$iv = th;
                            Throwable cause$iv2 = e$iv;
                            try {
                                throw e$iv;
                            } finally {
                                ChannelsKt.cancelConsumed($this$consume$iv, cause$iv2);
                            }
                        }
                    case 1:
                        $this$consume$iv = (ReceiveChannel) channelsKt__DeprecatedKt$any$12.L$0;
                        cause$iv = null;
                        try {
                            ResultKt.throwOnFailure($result);
                            hasNext = $result;
                            return hasNext;
                        } catch (Throwable th2) {
                            e$iv = th2;
                            Throwable cause$iv22 = e$iv;
                            throw e$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$any$1 = new ChannelsKt__DeprecatedKt$any$1(continuation);
        channelsKt__DeprecatedKt$any$12 = channelsKt__DeprecatedKt$any$1;
        Object $result2 = channelsKt__DeprecatedKt$any$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$any$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0089 A[Catch: all -> 0x00ac, TryCatch #3 {all -> 0x00ac, blocks: (B:71:0x0081, B:73:0x0089, B:74:0x009c), top: B:92:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x009c A[Catch: all -> 0x00ac, TRY_LEAVE, TryCatch #3 {all -> 0x00ac, blocks: (B:71:0x0081, B:73:0x0089, B:74:0x009c), top: B:92:0x0081 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0077 -> B:92:0x0081). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object count(ReceiveChannel $this$consumeEach$iv, Continuation continuation) {
        ChannelsKt__DeprecatedKt$count$1 channelsKt__DeprecatedKt$count$1;
        ChannelsKt__DeprecatedKt$count$1 channelsKt__DeprecatedKt$count$12;
        ReceiveChannel $this$consume$iv$iv;
        Object $result;
        Ref.IntRef count;
        ReceiveChannel $this$consume$iv$iv2;
        Throwable cause$iv$iv;
        ChannelIterator channelIterator;
        int i;
        boolean z;
        Object obj;
        if (continuation instanceof ChannelsKt__DeprecatedKt$count$1) {
            channelsKt__DeprecatedKt$count$1 = (ChannelsKt__DeprecatedKt$count$1) continuation;
            if ((channelsKt__DeprecatedKt$count$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$count$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$count$12 = channelsKt__DeprecatedKt$count$1;
                Object e$iv = channelsKt__DeprecatedKt$count$12.result;
                Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$count$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(e$iv);
                        Ref.IntRef count2 = new Ref.IntRef();
                        $this$consume$iv$iv = $this$consumeEach$iv;
                        Throwable cause$iv$iv2 = null;
                        try {
                            ChannelIterator it = $this$consume$iv$iv.iterator();
                            boolean z2 = false;
                            int $i$f$consume = 0;
                            Ref.IntRef count3 = count2;
                            channelsKt__DeprecatedKt$count$12.L$0 = count3;
                            channelsKt__DeprecatedKt$count$12.L$1 = $this$consume$iv$iv;
                            channelsKt__DeprecatedKt$count$12.L$2 = it;
                            channelsKt__DeprecatedKt$count$12.label = 1;
                            Object hasNext = it.hasNext(channelsKt__DeprecatedKt$count$12);
                            if (hasNext != $result2) {
                                return $result2;
                            }
                            Object obj2 = $result2;
                            $result = e$iv;
                            e$iv = hasNext;
                            count = count3;
                            $this$consume$iv$iv2 = $this$consume$iv$iv;
                            cause$iv$iv = cause$iv$iv2;
                            channelIterator = it;
                            i = $i$f$consume;
                            z = z2;
                            obj = obj2;
                            try {
                                if (!((Boolean) e$iv).booleanValue()) {
                                    channelIterator.next();
                                    count.element++;
                                    e$iv = $result;
                                    $result2 = obj;
                                    z2 = z;
                                    $i$f$consume = i;
                                    it = channelIterator;
                                    cause$iv$iv2 = cause$iv$iv;
                                    $this$consume$iv$iv = $this$consume$iv$iv2;
                                    count3 = count;
                                    channelsKt__DeprecatedKt$count$12.L$0 = count3;
                                    channelsKt__DeprecatedKt$count$12.L$1 = $this$consume$iv$iv;
                                    channelsKt__DeprecatedKt$count$12.L$2 = it;
                                    channelsKt__DeprecatedKt$count$12.label = 1;
                                    Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$count$12);
                                    if (hasNext2 != $result2) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv);
                                    int $i$f$consumeEach = count.element;
                                    return Boxing.boxInt($i$f$consumeEach);
                                }
                            } catch (Throwable th) {
                                $this$consume$iv$iv = $this$consume$iv$iv2;
                                e$iv$iv = th;
                                Throwable cause$iv$iv3 = e$iv$iv;
                                try {
                                    throw e$iv$iv;
                                } catch (Throwable e$iv$iv) {
                                    ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv3);
                                    throw e$iv$iv;
                                }
                            }
                        } catch (Throwable th2) {
                            e$iv$iv = th2;
                            Throwable cause$iv$iv32 = e$iv$iv;
                            throw e$iv$iv;
                        }
                    case 1:
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$count$12.L$2;
                        $this$consume$iv$iv = (ReceiveChannel) channelsKt__DeprecatedKt$count$12.L$1;
                        Ref.IntRef count4 = (Ref.IntRef) channelsKt__DeprecatedKt$count$12.L$0;
                        try {
                            ResultKt.throwOnFailure(e$iv);
                            count = count4;
                            $this$consume$iv$iv2 = $this$consume$iv$iv;
                            cause$iv$iv = null;
                            channelIterator = channelIterator2;
                            i = 0;
                            z = false;
                            obj = $result2;
                            $result = e$iv;
                            if (!((Boolean) e$iv).booleanValue()) {
                            }
                        } catch (Throwable th3) {
                            e$iv$iv = th3;
                            Throwable cause$iv$iv322 = e$iv$iv;
                            throw e$iv$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$count$1 = new ChannelsKt__DeprecatedKt$count$1(continuation);
        channelsKt__DeprecatedKt$count$12 = channelsKt__DeprecatedKt$count$1;
        Object e$iv2 = channelsKt__DeprecatedKt$count$12.result;
        Object $result22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$count$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00c7 A[Catch: all -> 0x00eb, TRY_LEAVE, TryCatch #6 {all -> 0x00eb, blocks: (B:115:0x00bf, B:117:0x00c7), top: B:150:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x006b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x00b6 -> B:150:0x00bf). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object maxWith(ReceiveChannel $this$consume$iv, Comparator comparator, Continuation continuation) {
        ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$1;
        ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$12;
        Throwable cause$iv;
        ReceiveChannel $this$consume$iv2;
        Throwable e$iv;
        ChannelIterator iterator;
        Object hasNext;
        ReceiveChannel receiveChannel;
        Comparator comparator2;
        Object $result;
        Comparator comparator3;
        ReceiveChannel $this$consume$iv3;
        ChannelIterator iterator2;
        Throwable th;
        Object max;
        Object max2;
        if (continuation instanceof ChannelsKt__DeprecatedKt$maxWith$1) {
            channelsKt__DeprecatedKt$maxWith$1 = (ChannelsKt__DeprecatedKt$maxWith$1) continuation;
            if ((channelsKt__DeprecatedKt$maxWith$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$maxWith$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$maxWith$12 = channelsKt__DeprecatedKt$maxWith$1;
                Object max3 = channelsKt__DeprecatedKt$maxWith$12.result;
                Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$maxWith$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(max3);
                        cause$iv = null;
                        try {
                            iterator = $this$consume$iv.iterator();
                            channelsKt__DeprecatedKt$maxWith$12.L$0 = comparator;
                            channelsKt__DeprecatedKt$maxWith$12.L$1 = $this$consume$iv;
                            channelsKt__DeprecatedKt$maxWith$12.L$2 = iterator;
                            channelsKt__DeprecatedKt$maxWith$12.label = 1;
                            hasNext = iterator.hasNext(channelsKt__DeprecatedKt$maxWith$12);
                            if (hasNext == $result2) {
                                return $result2;
                            }
                            receiveChannel = $this$consume$iv;
                            comparator2 = comparator;
                            try {
                                if (((Boolean) hasNext).booleanValue()) {
                                    ChannelsKt.cancelConsumed(receiveChannel, cause$iv);
                                    return null;
                                }
                                ReceiveChannel $this$consume$iv4 = receiveChannel;
                                try {
                                    Throwable cause$iv2 = cause$iv;
                                    Object max4 = iterator.next();
                                    ReceiveChannel $this$consume$iv5 = $this$consume$iv4;
                                    try {
                                        channelsKt__DeprecatedKt$maxWith$12.L$0 = comparator2;
                                        channelsKt__DeprecatedKt$maxWith$12.L$1 = $this$consume$iv5;
                                        channelsKt__DeprecatedKt$maxWith$12.L$2 = iterator;
                                        channelsKt__DeprecatedKt$maxWith$12.L$3 = max4;
                                        channelsKt__DeprecatedKt$maxWith$12.label = 2;
                                        Object hasNext2 = iterator.hasNext(channelsKt__DeprecatedKt$maxWith$12);
                                        if (hasNext2 != $result2) {
                                            return $result2;
                                        }
                                        Object obj = $result2;
                                        $result = max3;
                                        max3 = hasNext2;
                                        comparator3 = comparator2;
                                        $this$consume$iv3 = $this$consume$iv5;
                                        iterator2 = iterator;
                                        th = cause$iv2;
                                        max = max4;
                                        max2 = obj;
                                        try {
                                            if (((Boolean) max3).booleanValue()) {
                                                ChannelsKt.cancelConsumed($this$consume$iv3, th);
                                                return max;
                                            }
                                            Object e = iterator2.next();
                                            if (comparator3.compare(max, e) < 0) {
                                                ReceiveChannel $this$consume$iv6 = $this$consume$iv3;
                                                comparator2 = comparator3;
                                                Object obj2 = max2;
                                                max4 = e;
                                                max3 = $result;
                                                $result2 = obj2;
                                                ChannelIterator channelIterator = iterator2;
                                                $this$consume$iv5 = $this$consume$iv6;
                                                cause$iv2 = th;
                                                iterator = channelIterator;
                                            } else {
                                                ReceiveChannel $this$consume$iv7 = $this$consume$iv3;
                                                comparator2 = comparator3;
                                                ChannelIterator channelIterator2 = iterator2;
                                                $this$consume$iv5 = $this$consume$iv7;
                                                max3 = $result;
                                                $result2 = max2;
                                                max4 = max;
                                                cause$iv2 = th;
                                                iterator = channelIterator2;
                                            }
                                            channelsKt__DeprecatedKt$maxWith$12.L$0 = comparator2;
                                            channelsKt__DeprecatedKt$maxWith$12.L$1 = $this$consume$iv5;
                                            channelsKt__DeprecatedKt$maxWith$12.L$2 = iterator;
                                            channelsKt__DeprecatedKt$maxWith$12.L$3 = max4;
                                            channelsKt__DeprecatedKt$maxWith$12.label = 2;
                                            Object hasNext22 = iterator.hasNext(channelsKt__DeprecatedKt$maxWith$12);
                                            if (hasNext22 != $result2) {
                                            }
                                        } catch (Throwable th2) {
                                            e$iv = th2;
                                            $this$consume$iv2 = $this$consume$iv3;
                                            Throwable cause$iv3 = e$iv;
                                            try {
                                                throw e$iv;
                                            } catch (Throwable e$iv2) {
                                                ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv3);
                                                throw e$iv2;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        e$iv = th3;
                                        $this$consume$iv2 = $this$consume$iv5;
                                        Throwable cause$iv32 = e$iv;
                                        throw e$iv;
                                    }
                                } catch (Throwable th4) {
                                    e$iv = th4;
                                    $this$consume$iv2 = $this$consume$iv4;
                                    Throwable cause$iv322 = e$iv;
                                    throw e$iv;
                                }
                            } catch (Throwable th5) {
                                e$iv = th5;
                                $this$consume$iv2 = receiveChannel;
                            }
                        } catch (Throwable th6) {
                            $this$consume$iv2 = $this$consume$iv;
                            e$iv = th6;
                            Throwable cause$iv3222 = e$iv;
                            throw e$iv;
                        }
                    case 1:
                        ChannelIterator iterator3 = (ChannelIterator) channelsKt__DeprecatedKt$maxWith$12.L$2;
                        ReceiveChannel receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$maxWith$12.L$1;
                        Comparator comparator4 = (Comparator) channelsKt__DeprecatedKt$maxWith$12.L$0;
                        try {
                            ResultKt.throwOnFailure(max3);
                            hasNext = max3;
                            comparator2 = comparator4;
                            receiveChannel = receiveChannel2;
                            iterator = iterator3;
                            cause$iv = null;
                            if (((Boolean) hasNext).booleanValue()) {
                            }
                        } catch (Throwable th7) {
                            e$iv = th7;
                            $this$consume$iv2 = receiveChannel2;
                            Throwable cause$iv32222 = e$iv;
                            throw e$iv;
                        }
                        break;
                    case 2:
                        Object max5 = channelsKt__DeprecatedKt$maxWith$12.L$3;
                        ChannelIterator iterator4 = (ChannelIterator) channelsKt__DeprecatedKt$maxWith$12.L$2;
                        ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$maxWith$12.L$1;
                        Comparator comparator5 = (Comparator) channelsKt__DeprecatedKt$maxWith$12.L$0;
                        try {
                            ResultKt.throwOnFailure(max3);
                            comparator3 = comparator5;
                            $this$consume$iv3 = receiveChannel3;
                            iterator2 = iterator4;
                            th = null;
                            max = max5;
                            max2 = $result2;
                            $result = max3;
                            if (((Boolean) max3).booleanValue()) {
                            }
                        } catch (Throwable th8) {
                            e$iv = th8;
                            $this$consume$iv2 = receiveChannel3;
                            Throwable cause$iv322222 = e$iv;
                            throw e$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$maxWith$1 = new ChannelsKt__DeprecatedKt$maxWith$1(continuation);
        channelsKt__DeprecatedKt$maxWith$12 = channelsKt__DeprecatedKt$maxWith$1;
        Object max32 = channelsKt__DeprecatedKt$maxWith$12.result;
        Object $result22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$maxWith$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00c7 A[Catch: all -> 0x00eb, TRY_LEAVE, TryCatch #6 {all -> 0x00eb, blocks: (B:115:0x00bf, B:117:0x00c7), top: B:150:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x006b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x00b6 -> B:150:0x00bf). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object minWith(ReceiveChannel $this$consume$iv, Comparator comparator, Continuation continuation) {
        ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$1;
        ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$12;
        Throwable cause$iv;
        ReceiveChannel $this$consume$iv2;
        Throwable e$iv;
        ChannelIterator iterator;
        Object hasNext;
        ReceiveChannel receiveChannel;
        Comparator comparator2;
        Object $result;
        Comparator comparator3;
        ReceiveChannel $this$consume$iv3;
        ChannelIterator iterator2;
        Throwable th;
        Object min;
        Object min2;
        if (continuation instanceof ChannelsKt__DeprecatedKt$minWith$1) {
            channelsKt__DeprecatedKt$minWith$1 = (ChannelsKt__DeprecatedKt$minWith$1) continuation;
            if ((channelsKt__DeprecatedKt$minWith$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$minWith$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$minWith$12 = channelsKt__DeprecatedKt$minWith$1;
                Object min3 = channelsKt__DeprecatedKt$minWith$12.result;
                Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelsKt__DeprecatedKt$minWith$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(min3);
                        cause$iv = null;
                        try {
                            iterator = $this$consume$iv.iterator();
                            channelsKt__DeprecatedKt$minWith$12.L$0 = comparator;
                            channelsKt__DeprecatedKt$minWith$12.L$1 = $this$consume$iv;
                            channelsKt__DeprecatedKt$minWith$12.L$2 = iterator;
                            channelsKt__DeprecatedKt$minWith$12.label = 1;
                            hasNext = iterator.hasNext(channelsKt__DeprecatedKt$minWith$12);
                            if (hasNext == $result2) {
                                return $result2;
                            }
                            receiveChannel = $this$consume$iv;
                            comparator2 = comparator;
                            try {
                                if (((Boolean) hasNext).booleanValue()) {
                                    ChannelsKt.cancelConsumed(receiveChannel, cause$iv);
                                    return null;
                                }
                                ReceiveChannel $this$consume$iv4 = receiveChannel;
                                try {
                                    Throwable cause$iv2 = cause$iv;
                                    Object min4 = iterator.next();
                                    ReceiveChannel $this$consume$iv5 = $this$consume$iv4;
                                    try {
                                        channelsKt__DeprecatedKt$minWith$12.L$0 = comparator2;
                                        channelsKt__DeprecatedKt$minWith$12.L$1 = $this$consume$iv5;
                                        channelsKt__DeprecatedKt$minWith$12.L$2 = iterator;
                                        channelsKt__DeprecatedKt$minWith$12.L$3 = min4;
                                        channelsKt__DeprecatedKt$minWith$12.label = 2;
                                        Object hasNext2 = iterator.hasNext(channelsKt__DeprecatedKt$minWith$12);
                                        if (hasNext2 != $result2) {
                                            return $result2;
                                        }
                                        Object obj = $result2;
                                        $result = min3;
                                        min3 = hasNext2;
                                        comparator3 = comparator2;
                                        $this$consume$iv3 = $this$consume$iv5;
                                        iterator2 = iterator;
                                        th = cause$iv2;
                                        min = min4;
                                        min2 = obj;
                                        try {
                                            if (((Boolean) min3).booleanValue()) {
                                                ChannelsKt.cancelConsumed($this$consume$iv3, th);
                                                return min;
                                            }
                                            Object e = iterator2.next();
                                            if (comparator3.compare(min, e) > 0) {
                                                ReceiveChannel $this$consume$iv6 = $this$consume$iv3;
                                                comparator2 = comparator3;
                                                Object obj2 = min2;
                                                min4 = e;
                                                min3 = $result;
                                                $result2 = obj2;
                                                ChannelIterator channelIterator = iterator2;
                                                $this$consume$iv5 = $this$consume$iv6;
                                                cause$iv2 = th;
                                                iterator = channelIterator;
                                            } else {
                                                ReceiveChannel $this$consume$iv7 = $this$consume$iv3;
                                                comparator2 = comparator3;
                                                ChannelIterator channelIterator2 = iterator2;
                                                $this$consume$iv5 = $this$consume$iv7;
                                                min3 = $result;
                                                $result2 = min2;
                                                min4 = min;
                                                cause$iv2 = th;
                                                iterator = channelIterator2;
                                            }
                                            channelsKt__DeprecatedKt$minWith$12.L$0 = comparator2;
                                            channelsKt__DeprecatedKt$minWith$12.L$1 = $this$consume$iv5;
                                            channelsKt__DeprecatedKt$minWith$12.L$2 = iterator;
                                            channelsKt__DeprecatedKt$minWith$12.L$3 = min4;
                                            channelsKt__DeprecatedKt$minWith$12.label = 2;
                                            Object hasNext22 = iterator.hasNext(channelsKt__DeprecatedKt$minWith$12);
                                            if (hasNext22 != $result2) {
                                            }
                                        } catch (Throwable th2) {
                                            e$iv = th2;
                                            $this$consume$iv2 = $this$consume$iv3;
                                            Throwable cause$iv3 = e$iv;
                                            try {
                                                throw e$iv;
                                            } catch (Throwable e$iv2) {
                                                ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv3);
                                                throw e$iv2;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        e$iv = th3;
                                        $this$consume$iv2 = $this$consume$iv5;
                                        Throwable cause$iv32 = e$iv;
                                        throw e$iv;
                                    }
                                } catch (Throwable th4) {
                                    e$iv = th4;
                                    $this$consume$iv2 = $this$consume$iv4;
                                    Throwable cause$iv322 = e$iv;
                                    throw e$iv;
                                }
                            } catch (Throwable th5) {
                                e$iv = th5;
                                $this$consume$iv2 = receiveChannel;
                            }
                        } catch (Throwable th6) {
                            $this$consume$iv2 = $this$consume$iv;
                            e$iv = th6;
                            Throwable cause$iv3222 = e$iv;
                            throw e$iv;
                        }
                    case 1:
                        ChannelIterator iterator3 = (ChannelIterator) channelsKt__DeprecatedKt$minWith$12.L$2;
                        ReceiveChannel receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$minWith$12.L$1;
                        Comparator comparator4 = (Comparator) channelsKt__DeprecatedKt$minWith$12.L$0;
                        try {
                            ResultKt.throwOnFailure(min3);
                            hasNext = min3;
                            comparator2 = comparator4;
                            receiveChannel = receiveChannel2;
                            iterator = iterator3;
                            cause$iv = null;
                            if (((Boolean) hasNext).booleanValue()) {
                            }
                        } catch (Throwable th7) {
                            e$iv = th7;
                            $this$consume$iv2 = receiveChannel2;
                            Throwable cause$iv32222 = e$iv;
                            throw e$iv;
                        }
                        break;
                    case 2:
                        Object min5 = channelsKt__DeprecatedKt$minWith$12.L$3;
                        ChannelIterator iterator4 = (ChannelIterator) channelsKt__DeprecatedKt$minWith$12.L$2;
                        ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$minWith$12.L$1;
                        Comparator comparator5 = (Comparator) channelsKt__DeprecatedKt$minWith$12.L$0;
                        try {
                            ResultKt.throwOnFailure(min3);
                            comparator3 = comparator5;
                            $this$consume$iv3 = receiveChannel3;
                            iterator2 = iterator4;
                            th = null;
                            min = min5;
                            min2 = $result2;
                            $result = min3;
                            if (((Boolean) min3).booleanValue()) {
                            }
                        } catch (Throwable th8) {
                            e$iv = th8;
                            $this$consume$iv2 = receiveChannel3;
                            Throwable cause$iv322222 = e$iv;
                            throw e$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$minWith$1 = new ChannelsKt__DeprecatedKt$minWith$1(continuation);
        channelsKt__DeprecatedKt$minWith$12 = channelsKt__DeprecatedKt$minWith$1;
        Object min32 = channelsKt__DeprecatedKt$minWith$12.result;
        Object $result22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelsKt__DeprecatedKt$minWith$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0060  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object none(ReceiveChannel $this$none, Continuation continuation) {
        ChannelsKt__DeprecatedKt$none$1 channelsKt__DeprecatedKt$none$1;
        ChannelsKt__DeprecatedKt$none$1 channelsKt__DeprecatedKt$none$12;
        ReceiveChannel $this$consume$iv;
        Throwable cause$iv;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$none$1) {
            channelsKt__DeprecatedKt$none$1 = (ChannelsKt__DeprecatedKt$none$1) continuation;
            if ((channelsKt__DeprecatedKt$none$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$none$1.label -= IntCompanionObject.MIN_VALUE;
                channelsKt__DeprecatedKt$none$12 = channelsKt__DeprecatedKt$none$1;
                Object $result = channelsKt__DeprecatedKt$none$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (channelsKt__DeprecatedKt$none$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$consume$iv = $this$none;
                        cause$iv = null;
                        try {
                            ChannelIterator it = $this$consume$iv.iterator();
                            channelsKt__DeprecatedKt$none$12.L$0 = $this$consume$iv;
                            channelsKt__DeprecatedKt$none$12.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$none$12);
                            if (hasNext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (!((Boolean) hasNext).booleanValue()) {
                                z = false;
                            }
                            Boolean boxBoolean = Boxing.boxBoolean(z);
                            ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                            return boxBoolean;
                        } catch (Throwable th) {
                            e$iv = th;
                            Throwable cause$iv2 = e$iv;
                            try {
                                throw e$iv;
                            } catch (Throwable e$iv) {
                                ChannelsKt.cancelConsumed($this$consume$iv, cause$iv2);
                                throw e$iv;
                            }
                        }
                    case 1:
                        $this$consume$iv = (ReceiveChannel) channelsKt__DeprecatedKt$none$12.L$0;
                        cause$iv = null;
                        try {
                            ResultKt.throwOnFailure($result);
                            hasNext = $result;
                            if (!((Boolean) hasNext).booleanValue()) {
                            }
                            Boolean boxBoolean2 = Boxing.boxBoolean(z);
                            ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                            return boxBoolean2;
                        } catch (Throwable th2) {
                            e$iv = th2;
                            Throwable cause$iv22 = e$iv;
                            throw e$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__DeprecatedKt$none$1 = new ChannelsKt__DeprecatedKt$none$1(continuation);
        channelsKt__DeprecatedKt$none$12 = channelsKt__DeprecatedKt$none$1;
        Object $result2 = channelsKt__DeprecatedKt$none$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        switch (channelsKt__DeprecatedKt$none$12.label) {
        }
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2, CoroutineContext context, Function2<? super E, ? super R, ? extends V> function2) {
        ReceiveChannel<V> produce;
        produce = ProduceKt.produce(GlobalScope.INSTANCE, (r12 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (r12 & 2) != 0 ? 0 : 0, (r12 & 4) != 0 ? CoroutineStart.DEFAULT : null, (r12 & 8) != 0 ? null : ChannelsKt.consumesAll(receiveChannel, receiveChannel2), new ChannelsKt__DeprecatedKt$zip$2(receiveChannel2, receiveChannel, function2, null));
        return produce;
    }

    public static final Function1<Throwable, Unit> consumes(final ReceiveChannel<?> receiveChannel) {
        return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$consumes$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
            public final void invoke2(Throwable cause) {
                ChannelsKt.cancelConsumed(receiveChannel, cause);
            }
        };
    }
}