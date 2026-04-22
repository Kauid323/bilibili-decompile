package kntr.app.mall.product.details.page.api.model;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import java.util.List;
import kntr.app.mall.product.details.page.utils.ThemesKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: LabelObject.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 £\u00012\u00020\u0001:\u0004¢\u0001£\u0001B«\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b(\u0010)B\u0081\u0003\b\u0010\u0012\u0006\u0010*\u001a\u00020\u0015\u0012\u0006\u0010+\u001a\u00020\u0015\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0015\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010,\u001a\u0004\u0018\u00010-¢\u0006\u0004\b(\u0010.J\u0011\u0010W\u001a\u0004\u0018\u00010XH\u0001¢\u0006\u0004\bY\u0010ZJ\u0011\u0010[\u001a\u0004\u0018\u00010XH\u0001¢\u0006\u0004\b\\\u0010ZJ\u0011\u0010]\u001a\u0004\u0018\u00010XH\u0001¢\u0006\u0004\b^\u0010ZJ\u0015\u0010_\u001a\b\u0012\u0004\u0012\u00020X0`H\u0001¢\u0006\u0004\ba\u0010bJ\u000f\u0010c\u001a\u00020dH\u0001¢\u0006\u0004\be\u0010fJ\u0011\u0010g\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\bh\u0010iJ\u0011\u0010j\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\bk\u0010iJ\u0011\u0010l\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\bm\u0010iJ\u0011\u0010n\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\bo\u0010iJ\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010r\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010s\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010v\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010x\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010CJ\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010CJ\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010CJ\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010CJ\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010CJ\u0011\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010CJ\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00103J\u0011\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00103J´\u0003\u0010\u0093\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0003\u0010\u0094\u0001J\u0016\u0010\u0095\u0001\u001a\u00030\u0096\u00012\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0015HÖ\u0001J\n\u0010\u0099\u0001\u001a\u00020\u0003HÖ\u0001J-\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00002\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0001¢\u0006\u0003\b¡\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00104\u001a\u0004\b5\u00103R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u00100R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u00100R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00104\u001a\u0004\b8\u00103R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u00100R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00104\u001a\u0004\b:\u00103R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u00100R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u00100R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u00100R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u00100R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u00100R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u00100R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u00100R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010D\u001a\u0004\bB\u0010CR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010D\u001a\u0004\bE\u0010CR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u00100R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00100R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u00100R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u00100R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u00100R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010D\u001a\u0004\bK\u0010CR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u00100R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u00100R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u00100R\u0015\u0010 \u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010D\u001a\u0004\bO\u0010CR\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u00100R\u0015\u0010\"\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010D\u001a\u0004\bQ\u0010CR\u0015\u0010#\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010D\u001a\u0004\bR\u0010CR\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u00100R\u0013\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u00100R\u0015\u0010&\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00104\u001a\u0004\bU\u00103R\u0015\u0010'\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00104\u001a\u0004\bV\u00103¨\u0006¤\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/LabelObject;", "", "rightIconImgUrl", "", "rightIconNightImgUrl", "rightIconImgWidth", "", "rightIconImgHeight", "backDayColor1", "backDayColor2", "backImgHeight", "backImgUrl", "backImgWidth", "backNightColor1", "backNightColor2", "backNightImgUrl", "boardDayColor1", "boardDayColor2", "boardNightColor1", "boardNightColor2", "cornerRadius", "", "tagType", "title", "titleDayColor1", "titleDayColor2", "titleNightColor1", "titleNightColor2", "useBoard", "backImgUrlDay", "backImgUrlNight", "location", "priority", "tagId", "tagVersion", "actionType", "targetUrl", "showImgUrl", "showImgUrlHeight", "showImgUrlWidth", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRightIconImgUrl", "()Ljava/lang/String;", "getRightIconNightImgUrl", "getRightIconImgWidth", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getRightIconImgHeight", "getBackDayColor1", "getBackDayColor2", "getBackImgHeight", "getBackImgUrl", "getBackImgWidth", "getBackNightColor1", "getBackNightColor2", "getBackNightImgUrl", "getBoardDayColor1", "getBoardDayColor2", "getBoardNightColor1", "getBoardNightColor2", "getCornerRadius", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTagType", "getTitle", "getTitleDayColor1", "getTitleDayColor2", "getTitleNightColor1", "getTitleNightColor2", "getUseBoard", "getBackImgUrlDay", "getBackImgUrlNight", "getLocation", "getPriority", "getTagId", "getTagVersion", "getActionType", "getTargetUrl", "getShowImgUrl", "getShowImgUrlHeight", "getShowImgUrlWidth", "getTitleColor", "Landroidx/compose/ui/graphics/Color;", "getTitleColor-6MYuD4A$product_details_page_debug", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Color;", "getBgColor", "getBgColor-6MYuD4A$product_details_page_debug", "getBorderColor", "getBorderColor-6MYuD4A$product_details_page_debug", "getBgColors", "", "getBgColors$product_details_page_debug", "(Landroidx/compose/runtime/Composer;I)Ljava/util/List;", "getBorderWidth", "", "getBorderWidth$product_details_page_debug", "(Landroidx/compose/runtime/Composer;I)F", "getBgImg", "getBgImg$product_details_page_debug", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "getOriginVersionBgImgUrl", "getOriginVersionBgImgUrl$product_details_page_debug", "getVersion2BgImgUrl", "getVersion2BgImgUrl$product_details_page_debug", "getRightIconImg", "getRightIconImg$product_details_page_debug", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)Lkntr/app/mall/product/details/page/api/model/LabelObject;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class LabelObject {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Integer actionType;
    private final String backDayColor1;
    private final String backDayColor2;
    private final Double backImgHeight;
    private final String backImgUrl;
    private final String backImgUrlDay;
    private final String backImgUrlNight;
    private final Double backImgWidth;
    private final String backNightColor1;
    private final String backNightColor2;
    private final String backNightImgUrl;
    private final String boardDayColor1;
    private final String boardDayColor2;
    private final String boardNightColor1;
    private final String boardNightColor2;
    private final Integer cornerRadius;
    private final String location;
    private final Integer priority;
    private final Double rightIconImgHeight;
    private final String rightIconImgUrl;
    private final Double rightIconImgWidth;
    private final String rightIconNightImgUrl;
    private final String showImgUrl;
    private final Double showImgUrlHeight;
    private final Double showImgUrlWidth;
    private final String tagId;
    private final Integer tagType;
    private final Integer tagVersion;
    private final String targetUrl;
    private final String title;
    private final String titleDayColor1;
    private final String titleDayColor2;
    private final String titleNightColor1;
    private final String titleNightColor2;
    private final Integer useBoard;

    public LabelObject() {
        this((String) null, (String) null, (Double) null, (Double) null, (String) null, (String) null, (Double) null, (String) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Double) null, (Double) null, -1, 7, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.rightIconImgUrl;
    }

    public final String component10() {
        return this.backNightColor1;
    }

    public final String component11() {
        return this.backNightColor2;
    }

    public final String component12() {
        return this.backNightImgUrl;
    }

    public final String component13() {
        return this.boardDayColor1;
    }

    public final String component14() {
        return this.boardDayColor2;
    }

    public final String component15() {
        return this.boardNightColor1;
    }

    public final String component16() {
        return this.boardNightColor2;
    }

    public final Integer component17() {
        return this.cornerRadius;
    }

    public final Integer component18() {
        return this.tagType;
    }

    public final String component19() {
        return this.title;
    }

    public final String component2() {
        return this.rightIconNightImgUrl;
    }

    public final String component20() {
        return this.titleDayColor1;
    }

    public final String component21() {
        return this.titleDayColor2;
    }

    public final String component22() {
        return this.titleNightColor1;
    }

    public final String component23() {
        return this.titleNightColor2;
    }

    public final Integer component24() {
        return this.useBoard;
    }

    public final String component25() {
        return this.backImgUrlDay;
    }

    public final String component26() {
        return this.backImgUrlNight;
    }

    public final String component27() {
        return this.location;
    }

    public final Integer component28() {
        return this.priority;
    }

    public final String component29() {
        return this.tagId;
    }

    public final Double component3() {
        return this.rightIconImgWidth;
    }

    public final Integer component30() {
        return this.tagVersion;
    }

    public final Integer component31() {
        return this.actionType;
    }

    public final String component32() {
        return this.targetUrl;
    }

    public final String component33() {
        return this.showImgUrl;
    }

    public final Double component34() {
        return this.showImgUrlHeight;
    }

    public final Double component35() {
        return this.showImgUrlWidth;
    }

    public final Double component4() {
        return this.rightIconImgHeight;
    }

    public final String component5() {
        return this.backDayColor1;
    }

    public final String component6() {
        return this.backDayColor2;
    }

    public final Double component7() {
        return this.backImgHeight;
    }

    public final String component8() {
        return this.backImgUrl;
    }

    public final Double component9() {
        return this.backImgWidth;
    }

    public final LabelObject copy(String str, String str2, Double d, Double d2, String str3, String str4, Double d3, String str5, Double d4, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Integer num, Integer num2, String str13, String str14, String str15, String str16, String str17, Integer num3, String str18, String str19, String str20, Integer num4, String str21, Integer num5, Integer num6, String str22, String str23, Double d5, Double d6) {
        return new LabelObject(str, str2, d, d2, str3, str4, d3, str5, d4, str6, str7, str8, str9, str10, str11, str12, num, num2, str13, str14, str15, str16, str17, num3, str18, str19, str20, num4, str21, num5, num6, str22, str23, d5, d6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LabelObject) {
            LabelObject labelObject = (LabelObject) obj;
            return Intrinsics.areEqual(this.rightIconImgUrl, labelObject.rightIconImgUrl) && Intrinsics.areEqual(this.rightIconNightImgUrl, labelObject.rightIconNightImgUrl) && Intrinsics.areEqual(this.rightIconImgWidth, labelObject.rightIconImgWidth) && Intrinsics.areEqual(this.rightIconImgHeight, labelObject.rightIconImgHeight) && Intrinsics.areEqual(this.backDayColor1, labelObject.backDayColor1) && Intrinsics.areEqual(this.backDayColor2, labelObject.backDayColor2) && Intrinsics.areEqual(this.backImgHeight, labelObject.backImgHeight) && Intrinsics.areEqual(this.backImgUrl, labelObject.backImgUrl) && Intrinsics.areEqual(this.backImgWidth, labelObject.backImgWidth) && Intrinsics.areEqual(this.backNightColor1, labelObject.backNightColor1) && Intrinsics.areEqual(this.backNightColor2, labelObject.backNightColor2) && Intrinsics.areEqual(this.backNightImgUrl, labelObject.backNightImgUrl) && Intrinsics.areEqual(this.boardDayColor1, labelObject.boardDayColor1) && Intrinsics.areEqual(this.boardDayColor2, labelObject.boardDayColor2) && Intrinsics.areEqual(this.boardNightColor1, labelObject.boardNightColor1) && Intrinsics.areEqual(this.boardNightColor2, labelObject.boardNightColor2) && Intrinsics.areEqual(this.cornerRadius, labelObject.cornerRadius) && Intrinsics.areEqual(this.tagType, labelObject.tagType) && Intrinsics.areEqual(this.title, labelObject.title) && Intrinsics.areEqual(this.titleDayColor1, labelObject.titleDayColor1) && Intrinsics.areEqual(this.titleDayColor2, labelObject.titleDayColor2) && Intrinsics.areEqual(this.titleNightColor1, labelObject.titleNightColor1) && Intrinsics.areEqual(this.titleNightColor2, labelObject.titleNightColor2) && Intrinsics.areEqual(this.useBoard, labelObject.useBoard) && Intrinsics.areEqual(this.backImgUrlDay, labelObject.backImgUrlDay) && Intrinsics.areEqual(this.backImgUrlNight, labelObject.backImgUrlNight) && Intrinsics.areEqual(this.location, labelObject.location) && Intrinsics.areEqual(this.priority, labelObject.priority) && Intrinsics.areEqual(this.tagId, labelObject.tagId) && Intrinsics.areEqual(this.tagVersion, labelObject.tagVersion) && Intrinsics.areEqual(this.actionType, labelObject.actionType) && Intrinsics.areEqual(this.targetUrl, labelObject.targetUrl) && Intrinsics.areEqual(this.showImgUrl, labelObject.showImgUrl) && Intrinsics.areEqual(this.showImgUrlHeight, labelObject.showImgUrlHeight) && Intrinsics.areEqual(this.showImgUrlWidth, labelObject.showImgUrlWidth);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.rightIconImgUrl == null ? 0 : this.rightIconImgUrl.hashCode()) * 31) + (this.rightIconNightImgUrl == null ? 0 : this.rightIconNightImgUrl.hashCode())) * 31) + (this.rightIconImgWidth == null ? 0 : this.rightIconImgWidth.hashCode())) * 31) + (this.rightIconImgHeight == null ? 0 : this.rightIconImgHeight.hashCode())) * 31) + (this.backDayColor1 == null ? 0 : this.backDayColor1.hashCode())) * 31) + (this.backDayColor2 == null ? 0 : this.backDayColor2.hashCode())) * 31) + (this.backImgHeight == null ? 0 : this.backImgHeight.hashCode())) * 31) + (this.backImgUrl == null ? 0 : this.backImgUrl.hashCode())) * 31) + (this.backImgWidth == null ? 0 : this.backImgWidth.hashCode())) * 31) + (this.backNightColor1 == null ? 0 : this.backNightColor1.hashCode())) * 31) + (this.backNightColor2 == null ? 0 : this.backNightColor2.hashCode())) * 31) + (this.backNightImgUrl == null ? 0 : this.backNightImgUrl.hashCode())) * 31) + (this.boardDayColor1 == null ? 0 : this.boardDayColor1.hashCode())) * 31) + (this.boardDayColor2 == null ? 0 : this.boardDayColor2.hashCode())) * 31) + (this.boardNightColor1 == null ? 0 : this.boardNightColor1.hashCode())) * 31) + (this.boardNightColor2 == null ? 0 : this.boardNightColor2.hashCode())) * 31) + (this.cornerRadius == null ? 0 : this.cornerRadius.hashCode())) * 31) + (this.tagType == null ? 0 : this.tagType.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.titleDayColor1 == null ? 0 : this.titleDayColor1.hashCode())) * 31) + (this.titleDayColor2 == null ? 0 : this.titleDayColor2.hashCode())) * 31) + (this.titleNightColor1 == null ? 0 : this.titleNightColor1.hashCode())) * 31) + (this.titleNightColor2 == null ? 0 : this.titleNightColor2.hashCode())) * 31) + (this.useBoard == null ? 0 : this.useBoard.hashCode())) * 31) + (this.backImgUrlDay == null ? 0 : this.backImgUrlDay.hashCode())) * 31) + (this.backImgUrlNight == null ? 0 : this.backImgUrlNight.hashCode())) * 31) + (this.location == null ? 0 : this.location.hashCode())) * 31) + (this.priority == null ? 0 : this.priority.hashCode())) * 31) + (this.tagId == null ? 0 : this.tagId.hashCode())) * 31) + (this.tagVersion == null ? 0 : this.tagVersion.hashCode())) * 31) + (this.actionType == null ? 0 : this.actionType.hashCode())) * 31) + (this.targetUrl == null ? 0 : this.targetUrl.hashCode())) * 31) + (this.showImgUrl == null ? 0 : this.showImgUrl.hashCode())) * 31) + (this.showImgUrlHeight == null ? 0 : this.showImgUrlHeight.hashCode())) * 31) + (this.showImgUrlWidth != null ? this.showImgUrlWidth.hashCode() : 0);
    }

    public String toString() {
        String str = this.rightIconImgUrl;
        String str2 = this.rightIconNightImgUrl;
        Double d = this.rightIconImgWidth;
        Double d2 = this.rightIconImgHeight;
        String str3 = this.backDayColor1;
        String str4 = this.backDayColor2;
        Double d3 = this.backImgHeight;
        String str5 = this.backImgUrl;
        Double d4 = this.backImgWidth;
        String str6 = this.backNightColor1;
        String str7 = this.backNightColor2;
        String str8 = this.backNightImgUrl;
        String str9 = this.boardDayColor1;
        String str10 = this.boardDayColor2;
        String str11 = this.boardNightColor1;
        String str12 = this.boardNightColor2;
        Integer num = this.cornerRadius;
        Integer num2 = this.tagType;
        String str13 = this.title;
        String str14 = this.titleDayColor1;
        String str15 = this.titleDayColor2;
        String str16 = this.titleNightColor1;
        String str17 = this.titleNightColor2;
        Integer num3 = this.useBoard;
        String str18 = this.backImgUrlDay;
        String str19 = this.backImgUrlNight;
        String str20 = this.location;
        Integer num4 = this.priority;
        String str21 = this.tagId;
        Integer num5 = this.tagVersion;
        Integer num6 = this.actionType;
        String str22 = this.targetUrl;
        String str23 = this.showImgUrl;
        Double d5 = this.showImgUrlHeight;
        return "LabelObject(rightIconImgUrl=" + str + ", rightIconNightImgUrl=" + str2 + ", rightIconImgWidth=" + d + ", rightIconImgHeight=" + d2 + ", backDayColor1=" + str3 + ", backDayColor2=" + str4 + ", backImgHeight=" + d3 + ", backImgUrl=" + str5 + ", backImgWidth=" + d4 + ", backNightColor1=" + str6 + ", backNightColor2=" + str7 + ", backNightImgUrl=" + str8 + ", boardDayColor1=" + str9 + ", boardDayColor2=" + str10 + ", boardNightColor1=" + str11 + ", boardNightColor2=" + str12 + ", cornerRadius=" + num + ", tagType=" + num2 + ", title=" + str13 + ", titleDayColor1=" + str14 + ", titleDayColor2=" + str15 + ", titleNightColor1=" + str16 + ", titleNightColor2=" + str17 + ", useBoard=" + num3 + ", backImgUrlDay=" + str18 + ", backImgUrlNight=" + str19 + ", location=" + str20 + ", priority=" + num4 + ", tagId=" + str21 + ", tagVersion=" + num5 + ", actionType=" + num6 + ", targetUrl=" + str22 + ", showImgUrl=" + str23 + ", showImgUrlHeight=" + d5 + ", showImgUrlWidth=" + this.showImgUrlWidth + ")";
    }

    /* compiled from: LabelObject.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/LabelObject$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/LabelObject;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LabelObject> serializer() {
            return LabelObject$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ LabelObject(int seen0, int seen1, String rightIconImgUrl, String rightIconNightImgUrl, Double rightIconImgWidth, Double rightIconImgHeight, String backDayColor1, String backDayColor2, Double backImgHeight, String backImgUrl, Double backImgWidth, String backNightColor1, String backNightColor2, String backNightImgUrl, String boardDayColor1, String boardDayColor2, String boardNightColor1, String boardNightColor2, Integer cornerRadius, Integer tagType, String title, String titleDayColor1, String titleDayColor2, String titleNightColor1, String titleNightColor2, Integer useBoard, String backImgUrlDay, String backImgUrlNight, String location, Integer priority, String tagId, Integer tagVersion, Integer actionType, String targetUrl, String showImgUrl, Double showImgUrlHeight, Double showImgUrlWidth, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.rightIconImgUrl = null;
        } else {
            this.rightIconImgUrl = rightIconImgUrl;
        }
        if ((seen0 & 2) == 0) {
            this.rightIconNightImgUrl = null;
        } else {
            this.rightIconNightImgUrl = rightIconNightImgUrl;
        }
        if ((seen0 & 4) == 0) {
            this.rightIconImgWidth = null;
        } else {
            this.rightIconImgWidth = rightIconImgWidth;
        }
        if ((seen0 & 8) == 0) {
            this.rightIconImgHeight = null;
        } else {
            this.rightIconImgHeight = rightIconImgHeight;
        }
        if ((seen0 & 16) == 0) {
            this.backDayColor1 = null;
        } else {
            this.backDayColor1 = backDayColor1;
        }
        if ((seen0 & 32) == 0) {
            this.backDayColor2 = null;
        } else {
            this.backDayColor2 = backDayColor2;
        }
        if ((seen0 & 64) == 0) {
            this.backImgHeight = null;
        } else {
            this.backImgHeight = backImgHeight;
        }
        if ((seen0 & 128) == 0) {
            this.backImgUrl = null;
        } else {
            this.backImgUrl = backImgUrl;
        }
        if ((seen0 & 256) == 0) {
            this.backImgWidth = null;
        } else {
            this.backImgWidth = backImgWidth;
        }
        if ((seen0 & 512) == 0) {
            this.backNightColor1 = null;
        } else {
            this.backNightColor1 = backNightColor1;
        }
        if ((seen0 & 1024) == 0) {
            this.backNightColor2 = null;
        } else {
            this.backNightColor2 = backNightColor2;
        }
        if ((seen0 & 2048) == 0) {
            this.backNightImgUrl = null;
        } else {
            this.backNightImgUrl = backNightImgUrl;
        }
        if ((seen0 & 4096) == 0) {
            this.boardDayColor1 = null;
        } else {
            this.boardDayColor1 = boardDayColor1;
        }
        if ((seen0 & 8192) == 0) {
            this.boardDayColor2 = null;
        } else {
            this.boardDayColor2 = boardDayColor2;
        }
        if ((seen0 & 16384) == 0) {
            this.boardNightColor1 = null;
        } else {
            this.boardNightColor1 = boardNightColor1;
        }
        if ((seen0 & 32768) == 0) {
            this.boardNightColor2 = null;
        } else {
            this.boardNightColor2 = boardNightColor2;
        }
        if ((seen0 & 65536) == 0) {
            this.cornerRadius = null;
        } else {
            this.cornerRadius = cornerRadius;
        }
        if ((seen0 & 131072) == 0) {
            this.tagType = null;
        } else {
            this.tagType = tagType;
        }
        if ((seen0 & 262144) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 524288) == 0) {
            this.titleDayColor1 = null;
        } else {
            this.titleDayColor1 = titleDayColor1;
        }
        if ((seen0 & 1048576) == 0) {
            this.titleDayColor2 = null;
        } else {
            this.titleDayColor2 = titleDayColor2;
        }
        if ((seen0 & 2097152) == 0) {
            this.titleNightColor1 = null;
        } else {
            this.titleNightColor1 = titleNightColor1;
        }
        if ((seen0 & 4194304) == 0) {
            this.titleNightColor2 = null;
        } else {
            this.titleNightColor2 = titleNightColor2;
        }
        if ((seen0 & 8388608) == 0) {
            this.useBoard = null;
        } else {
            this.useBoard = useBoard;
        }
        if ((seen0 & 16777216) == 0) {
            this.backImgUrlDay = null;
        } else {
            this.backImgUrlDay = backImgUrlDay;
        }
        if ((seen0 & 33554432) == 0) {
            this.backImgUrlNight = null;
        } else {
            this.backImgUrlNight = backImgUrlNight;
        }
        if ((seen0 & 67108864) == 0) {
            this.location = null;
        } else {
            this.location = location;
        }
        if ((seen0 & 134217728) == 0) {
            this.priority = null;
        } else {
            this.priority = priority;
        }
        if ((seen0 & 268435456) == 0) {
            this.tagId = null;
        } else {
            this.tagId = tagId;
        }
        if ((seen0 & 536870912) == 0) {
            this.tagVersion = null;
        } else {
            this.tagVersion = tagVersion;
        }
        if ((seen0 & 1073741824) == 0) {
            this.actionType = null;
        } else {
            this.actionType = actionType;
        }
        if ((seen0 & Integer.MIN_VALUE) == 0) {
            this.targetUrl = null;
        } else {
            this.targetUrl = targetUrl;
        }
        if ((seen1 & 1) == 0) {
            this.showImgUrl = null;
        } else {
            this.showImgUrl = showImgUrl;
        }
        if ((seen1 & 2) == 0) {
            this.showImgUrlHeight = null;
        } else {
            this.showImgUrlHeight = showImgUrlHeight;
        }
        if ((seen1 & 4) == 0) {
            this.showImgUrlWidth = null;
        } else {
            this.showImgUrlWidth = showImgUrlWidth;
        }
    }

    public LabelObject(String rightIconImgUrl, String rightIconNightImgUrl, Double rightIconImgWidth, Double rightIconImgHeight, String backDayColor1, String backDayColor2, Double backImgHeight, String backImgUrl, Double backImgWidth, String backNightColor1, String backNightColor2, String backNightImgUrl, String boardDayColor1, String boardDayColor2, String boardNightColor1, String boardNightColor2, Integer cornerRadius, Integer tagType, String title, String titleDayColor1, String titleDayColor2, String titleNightColor1, String titleNightColor2, Integer useBoard, String backImgUrlDay, String backImgUrlNight, String location, Integer priority, String tagId, Integer tagVersion, Integer actionType, String targetUrl, String showImgUrl, Double showImgUrlHeight, Double showImgUrlWidth) {
        this.rightIconImgUrl = rightIconImgUrl;
        this.rightIconNightImgUrl = rightIconNightImgUrl;
        this.rightIconImgWidth = rightIconImgWidth;
        this.rightIconImgHeight = rightIconImgHeight;
        this.backDayColor1 = backDayColor1;
        this.backDayColor2 = backDayColor2;
        this.backImgHeight = backImgHeight;
        this.backImgUrl = backImgUrl;
        this.backImgWidth = backImgWidth;
        this.backNightColor1 = backNightColor1;
        this.backNightColor2 = backNightColor2;
        this.backNightImgUrl = backNightImgUrl;
        this.boardDayColor1 = boardDayColor1;
        this.boardDayColor2 = boardDayColor2;
        this.boardNightColor1 = boardNightColor1;
        this.boardNightColor2 = boardNightColor2;
        this.cornerRadius = cornerRadius;
        this.tagType = tagType;
        this.title = title;
        this.titleDayColor1 = titleDayColor1;
        this.titleDayColor2 = titleDayColor2;
        this.titleNightColor1 = titleNightColor1;
        this.titleNightColor2 = titleNightColor2;
        this.useBoard = useBoard;
        this.backImgUrlDay = backImgUrlDay;
        this.backImgUrlNight = backImgUrlNight;
        this.location = location;
        this.priority = priority;
        this.tagId = tagId;
        this.tagVersion = tagVersion;
        this.actionType = actionType;
        this.targetUrl = targetUrl;
        this.showImgUrl = showImgUrl;
        this.showImgUrlHeight = showImgUrlHeight;
        this.showImgUrlWidth = showImgUrlWidth;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(LabelObject self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.rightIconImgUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.rightIconImgUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.rightIconNightImgUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.rightIconNightImgUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.rightIconImgWidth != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, DoubleSerializer.INSTANCE, self.rightIconImgWidth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.rightIconImgHeight != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, DoubleSerializer.INSTANCE, self.rightIconImgHeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.backDayColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.backDayColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.backDayColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.backDayColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.backImgHeight != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, DoubleSerializer.INSTANCE, self.backImgHeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.backImgUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.backImgUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.backImgWidth != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, DoubleSerializer.INSTANCE, self.backImgWidth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.backNightColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.backNightColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.backNightColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.backNightColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.backNightImgUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.backNightImgUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.boardDayColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.boardDayColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.boardDayColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.boardDayColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.boardNightColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.boardNightColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.boardNightColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.boardNightColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.cornerRadius != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, IntSerializer.INSTANCE, self.cornerRadius);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.tagType != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, IntSerializer.INSTANCE, self.tagType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.titleDayColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.titleDayColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.titleDayColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.titleDayColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.titleNightColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.titleNightColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.titleNightColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.titleNightColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.useBoard != null) {
            output.encodeNullableSerializableElement(serialDesc, 23, IntSerializer.INSTANCE, self.useBoard);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 24) || self.backImgUrlDay != null) {
            output.encodeNullableSerializableElement(serialDesc, 24, StringSerializer.INSTANCE, self.backImgUrlDay);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 25) || self.backImgUrlNight != null) {
            output.encodeNullableSerializableElement(serialDesc, 25, StringSerializer.INSTANCE, self.backImgUrlNight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.location != null) {
            output.encodeNullableSerializableElement(serialDesc, 26, StringSerializer.INSTANCE, self.location);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 27) || self.priority != null) {
            output.encodeNullableSerializableElement(serialDesc, 27, IntSerializer.INSTANCE, self.priority);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 28) || self.tagId != null) {
            output.encodeNullableSerializableElement(serialDesc, 28, StringSerializer.INSTANCE, self.tagId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.tagVersion != null) {
            output.encodeNullableSerializableElement(serialDesc, 29, IntSerializer.INSTANCE, self.tagVersion);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 30) || self.actionType != null) {
            output.encodeNullableSerializableElement(serialDesc, 30, IntSerializer.INSTANCE, self.actionType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 31) || self.targetUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 31, StringSerializer.INSTANCE, self.targetUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 32) || self.showImgUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 32, StringSerializer.INSTANCE, self.showImgUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 33) || self.showImgUrlHeight != null) {
            output.encodeNullableSerializableElement(serialDesc, 33, DoubleSerializer.INSTANCE, self.showImgUrlHeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 34) || self.showImgUrlWidth != null) {
            output.encodeNullableSerializableElement(serialDesc, 34, DoubleSerializer.INSTANCE, self.showImgUrlWidth);
        }
    }

    public /* synthetic */ LabelObject(String str, String str2, Double d, Double d2, String str3, String str4, Double d3, String str5, Double d4, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Integer num, Integer num2, String str13, String str14, String str15, String str16, String str17, Integer num3, String str18, String str19, String str20, Integer num4, String str21, Integer num5, Integer num6, String str22, String str23, Double d5, Double d6, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : d2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : d3, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : d4, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : str9, (i & 8192) != 0 ? null : str10, (i & 16384) != 0 ? null : str11, (i & 32768) != 0 ? null : str12, (i & 65536) != 0 ? null : num, (i & 131072) != 0 ? null : num2, (i & 262144) != 0 ? null : str13, (i & 524288) != 0 ? null : str14, (i & 1048576) != 0 ? null : str15, (i & 2097152) != 0 ? null : str16, (i & 4194304) != 0 ? null : str17, (i & 8388608) != 0 ? null : num3, (i & 16777216) != 0 ? null : str18, (i & 33554432) != 0 ? null : str19, (i & 67108864) != 0 ? null : str20, (i & 134217728) != 0 ? null : num4, (i & 268435456) != 0 ? null : str21, (i & 536870912) != 0 ? null : num5, (i & 1073741824) != 0 ? null : num6, (i & Integer.MIN_VALUE) != 0 ? null : str22, (i2 & 1) != 0 ? null : str23, (i2 & 2) != 0 ? null : d5, (i2 & 4) != 0 ? null : d6);
    }

    public final String getRightIconImgUrl() {
        return this.rightIconImgUrl;
    }

    public final String getRightIconNightImgUrl() {
        return this.rightIconNightImgUrl;
    }

    public final Double getRightIconImgWidth() {
        return this.rightIconImgWidth;
    }

    public final Double getRightIconImgHeight() {
        return this.rightIconImgHeight;
    }

    public final String getBackDayColor1() {
        return this.backDayColor1;
    }

    public final String getBackDayColor2() {
        return this.backDayColor2;
    }

    public final Double getBackImgHeight() {
        return this.backImgHeight;
    }

    public final String getBackImgUrl() {
        return this.backImgUrl;
    }

    public final Double getBackImgWidth() {
        return this.backImgWidth;
    }

    public final String getBackNightColor1() {
        return this.backNightColor1;
    }

    public final String getBackNightColor2() {
        return this.backNightColor2;
    }

    public final String getBackNightImgUrl() {
        return this.backNightImgUrl;
    }

    public final String getBoardDayColor1() {
        return this.boardDayColor1;
    }

    public final String getBoardDayColor2() {
        return this.boardDayColor2;
    }

    public final String getBoardNightColor1() {
        return this.boardNightColor1;
    }

    public final String getBoardNightColor2() {
        return this.boardNightColor2;
    }

    public final Integer getCornerRadius() {
        return this.cornerRadius;
    }

    public final Integer getTagType() {
        return this.tagType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleDayColor1() {
        return this.titleDayColor1;
    }

    public final String getTitleDayColor2() {
        return this.titleDayColor2;
    }

    public final String getTitleNightColor1() {
        return this.titleNightColor1;
    }

    public final String getTitleNightColor2() {
        return this.titleNightColor2;
    }

    public final Integer getUseBoard() {
        return this.useBoard;
    }

    public final String getBackImgUrlDay() {
        return this.backImgUrlDay;
    }

    public final String getBackImgUrlNight() {
        return this.backImgUrlNight;
    }

    public final String getLocation() {
        return this.location;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final String getTagId() {
        return this.tagId;
    }

    public final Integer getTagVersion() {
        return this.tagVersion;
    }

    public final Integer getActionType() {
        return this.actionType;
    }

    public final String getTargetUrl() {
        return this.targetUrl;
    }

    public final String getShowImgUrl() {
        return this.showImgUrl;
    }

    public final Double getShowImgUrlHeight() {
        return this.showImgUrlHeight;
    }

    public final Double getShowImgUrlWidth() {
        return this.showImgUrlWidth;
    }

    /* renamed from: getTitleColor-6MYuD4A$product_details_page_debug  reason: not valid java name */
    public final Color m306getTitleColor6MYuD4A$product_details_page_debug(Composer $composer, int $changed) {
        String titleColorString;
        Color color;
        ComposerKt.sourceInformationMarkerStart($composer, 408455609, "C(getTitleColor)80@2393L21:LabelObject.kt#d5pv41");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(408455609, $changed, -1, "kntr.app.mall.product.details.page.api.model.LabelObject.getTitleColor (LabelObject.kt:79)");
        }
        boolean z = false;
        boolean isLight = ThemesKt.isCurrentThemeLight($composer, 0);
        if (isLight) {
            titleColorString = this.titleDayColor1;
            if (titleColorString == null) {
                titleColorString = this.titleDayColor2;
            }
        } else {
            titleColorString = this.titleNightColor1;
            if (titleColorString == null) {
                titleColorString = this.titleNightColor2;
            }
        }
        String str = titleColorString;
        if (!((str == null || str.length() == 0) ? true : true)) {
            color = Color.box-impl(ComposeColorParserKt.parseColor(titleColorString));
        } else {
            color = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return color;
    }

    /* renamed from: getBgColor-6MYuD4A$product_details_page_debug  reason: not valid java name */
    public final Color m304getBgColor6MYuD4A$product_details_page_debug(Composer $composer, int $changed) {
        String colorString;
        Color color;
        ComposerKt.sourceInformationMarkerStart($composer, -1618174628, "C(getBgColor)97@2838L21:LabelObject.kt#d5pv41");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1618174628, $changed, -1, "kntr.app.mall.product.details.page.api.model.LabelObject.getBgColor (LabelObject.kt:96)");
        }
        boolean z = false;
        boolean isLight = ThemesKt.isCurrentThemeLight($composer, 0);
        if (isLight) {
            colorString = this.backDayColor1;
            if (colorString == null) {
                colorString = this.backDayColor2;
            }
        } else {
            colorString = this.backNightColor1;
            if (colorString == null) {
                colorString = this.backNightColor2;
            }
        }
        String str = colorString;
        if (!((str == null || str.length() == 0) ? true : true)) {
            color = Color.box-impl(ComposeColorParserKt.parseColor(colorString));
        } else {
            color = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return color;
    }

    /* renamed from: getBorderColor-6MYuD4A$product_details_page_debug  reason: not valid java name */
    public final Color m305getBorderColor6MYuD4A$product_details_page_debug(Composer $composer, int $changed) {
        String colorString;
        Color color;
        ComposerKt.sourceInformationMarkerStart($composer, -174112747, "C(getBorderColor)114@3268L21:LabelObject.kt#d5pv41");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-174112747, $changed, -1, "kntr.app.mall.product.details.page.api.model.LabelObject.getBorderColor (LabelObject.kt:113)");
        }
        boolean z = false;
        boolean isLight = ThemesKt.isCurrentThemeLight($composer, 0);
        if (isLight) {
            colorString = this.boardDayColor1;
            if (colorString == null) {
                colorString = this.boardDayColor2;
            }
        } else {
            colorString = this.boardNightColor1;
            if (colorString == null) {
                colorString = this.boardNightColor2;
            }
        }
        String str = colorString;
        if (!((str == null || str.length() == 0) ? true : true)) {
            color = Color.box-impl(ComposeColorParserKt.parseColor(colorString));
        } else {
            color = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return color;
    }

    public final List<Color> getBgColors$product_details_page_debug(Composer $composer, int $changed) {
        List<Color> listOf;
        ComposerKt.sourceInformationMarkerStart($composer, 1450692300, "C(getBgColors)131@3704L21:LabelObject.kt#d5pv41");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1450692300, $changed, -1, "kntr.app.mall.product.details.page.api.model.LabelObject.getBgColors (LabelObject.kt:130)");
        }
        boolean isLight = ThemesKt.isCurrentThemeLight($composer, 0);
        if (isLight) {
            Color[] colorArr = new Color[2];
            String str = this.backDayColor1;
            colorArr[0] = Color.box-impl(str != null ? ComposeColorParserKt.parseColor(str) : Color.Companion.getTransparent-0d7_KjU());
            String str2 = this.backDayColor2;
            colorArr[1] = Color.box-impl(str2 != null ? ComposeColorParserKt.parseColor(str2) : Color.Companion.getTransparent-0d7_KjU());
            listOf = CollectionsKt.listOf(colorArr);
        } else {
            Color[] colorArr2 = new Color[2];
            String str3 = this.backNightColor1;
            colorArr2[0] = Color.box-impl(str3 != null ? ComposeColorParserKt.parseColor(str3) : Color.Companion.getTransparent-0d7_KjU());
            String str4 = this.backNightColor2;
            colorArr2[1] = Color.box-impl(str4 != null ? ComposeColorParserKt.parseColor(str4) : Color.Companion.getTransparent-0d7_KjU());
            listOf = CollectionsKt.listOf(colorArr2);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return listOf;
    }

    public final float getBorderWidth$product_details_page_debug(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1546691615, "C(getBorderWidth):LabelObject.kt#d5pv41");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1546691615, $changed, -1, "kntr.app.mall.product.details.page.api.model.LabelObject.getBorderWidth (LabelObject.kt:141)");
        }
        Integer num = this.useBoard;
        float f = (num != null && num.intValue() == 1) ? 0.5f : 0.0f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return f;
    }

    public final String getBgImg$product_details_page_debug(Composer $composer, int $changed) {
        $composer.startReplaceGroup(1925171840);
        ComposerKt.sourceInformation($composer, "C(getBgImg):LabelObject.kt#d5pv41");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1925171840, $changed, -1, "kntr.app.mall.product.details.page.api.model.LabelObject.getBgImg (LabelObject.kt:147)");
        }
        Integer num = this.tagVersion;
        if (num != null && num.intValue() == 2) {
            $composer.startReplaceGroup(2096055238);
            ComposerKt.sourceInformation($composer, "150@4299L21");
            String version2BgImgUrl$product_details_page_debug = getVersion2BgImgUrl$product_details_page_debug($composer, $changed & 14);
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return version2BgImgUrl$product_details_page_debug;
        }
        $composer.startReplaceGroup(2096135745);
        ComposerKt.sourceInformation($composer, "153@4380L26");
        String originVersionBgImgUrl$product_details_page_debug = getOriginVersionBgImgUrl$product_details_page_debug($composer, $changed & 14);
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return originVersionBgImgUrl$product_details_page_debug;
    }

    public final String getOriginVersionBgImgUrl$product_details_page_debug(Composer $composer, int $changed) {
        String str;
        ComposerKt.sourceInformationMarkerStart($composer, -803682597, "C(getOriginVersionBgImgUrl)160@4531L21:LabelObject.kt#d5pv41");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-803682597, $changed, -1, "kntr.app.mall.product.details.page.api.model.LabelObject.getOriginVersionBgImgUrl (LabelObject.kt:159)");
        }
        boolean isLight = ThemesKt.isCurrentThemeLight($composer, 0);
        if (isLight) {
            str = this.backImgUrl;
        } else {
            str = this.backNightImgUrl;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return str;
    }

    public final String getVersion2BgImgUrl$product_details_page_debug(Composer $composer, int $changed) {
        String str;
        ComposerKt.sourceInformationMarkerStart($composer, -427671293, "C(getVersion2BgImgUrl)170@4756L21:LabelObject.kt#d5pv41");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-427671293, $changed, -1, "kntr.app.mall.product.details.page.api.model.LabelObject.getVersion2BgImgUrl (LabelObject.kt:169)");
        }
        boolean isLight = ThemesKt.isCurrentThemeLight($composer, 0);
        if (isLight) {
            str = this.backImgUrlDay;
        } else {
            str = this.backImgUrlNight;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return str;
    }

    public final String getRightIconImg$product_details_page_debug(Composer $composer, int $changed) {
        String str;
        ComposerKt.sourceInformationMarkerStart($composer, -367667808, "C(getRightIconImg)180@4980L21:LabelObject.kt#d5pv41");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-367667808, $changed, -1, "kntr.app.mall.product.details.page.api.model.LabelObject.getRightIconImg (LabelObject.kt:179)");
        }
        boolean isLight = ThemesKt.isCurrentThemeLight($composer, 0);
        if (isLight) {
            str = this.rightIconImgUrl;
        } else {
            str = this.rightIconNightImgUrl;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return str;
    }
}