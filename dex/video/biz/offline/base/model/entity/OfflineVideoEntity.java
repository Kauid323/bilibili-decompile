package video.biz.offline.base.model.entity;

import ComposableSingletons$CustomBottomSheetKt$;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.DurationSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;
import video.base.utils.VBNumberExtKt;
import video.base.utils.VBStriingExtKt;
import video.biz.offline.base.infra.utils.EntryScannerKt;
import video.biz.offline.base.model.ext.OfflineConfigKt;
import video.biz.offline.base.model.model.AuthCodeKt;
import video.biz.offline.base.model.model.VideoPlayInfo;
import video.biz.offline.base.model.model.VideoPlayInfo$$serializer;

/* compiled from: OfflineVideoEntity.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b{\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\b\u0018\u0000 §\u00022\u00020\u0001:\u0010§\u0002¨\u0002©\u0002ª\u0002«\u0002¬\u0002\u00ad\u0002®\u0002Bï\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020%\u0012\b\b\u0002\u0010&\u001a\u00020\u000e\u0012\b\b\u0002\u0010'\u001a\u00020\u000e\u0012\b\b\u0002\u0010(\u001a\u00020\u0003\u0012\b\b\u0002\u0010)\u001a\u00020\u0003\u0012\b\b\u0002\u0010*\u001a\u00020\u0005\u0012\b\b\u0002\u0010+\u001a\u00020\u0003\u0012\b\b\u0002\u0010,\u001a\u00020\u0003\u0012\b\b\u0002\u0010-\u001a\u00020\u0003\u0012\b\b\u0002\u0010.\u001a\u00020\u0003\u0012\b\b\u0002\u0010/\u001a\u000200\u0012\b\b\u0002\u00101\u001a\u00020\u0005\u0012\b\b\u0002\u00102\u001a\u00020\u000e\u0012\b\b\u0002\u00103\u001a\u00020\u0005\u0012\b\b\u0002\u00104\u001a\u00020\u000e\u0012\b\b\u0002\u00105\u001a\u00020\u0005\u0012\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020\u000307\u0012\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u000307\u0012\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u000307¢\u0006\u0004\b:\u0010;B\u008b\u0004\b\u0010\u0012\u0006\u0010<\u001a\u00020\u000e\u0012\u0006\u0010=\u001a\u00020\u000e\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u000e\u0012\u0006\u0010\u001e\u001a\u00020\u000e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\b\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\u0006\u0010&\u001a\u00020\u000e\u0012\u0006\u0010'\u001a\u00020\u000e\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\b\u0010/\u001a\u0004\u0018\u000100\u0012\b\u00101\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u00102\u001a\u00020\u000e\u0012\b\u00103\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u00104\u001a\u00020\u000e\u0012\b\u00105\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u000107\u0012\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u000107\u0012\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u000107\u0012\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010?\u0012\u0006\u0010@\u001a\u00020\u000e\u0012\b\u0010A\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010B\u001a\u00020\u000e\u0012\u0006\u0010C\u001a\u00020\u000e\u0012\b\u0010D\u001a\u0004\u0018\u00010E¢\u0006\u0004\b:\u0010FJ\u0010\u0010É\u0001\u001a\u00020\u0005H\u0087@¢\u0006\u0003\u0010Ê\u0001J\u0016\u0010Ï\u0001\u001a\u00030Ð\u00012\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010å\u0001\u001a\u00030Ð\u0001J\u0012\u0010æ\u0001\u001a\u00030Ð\u00012\b\u0010ç\u0001\u001a\u00030è\u0001J\u0012\u0010é\u0001\u001a\u00030ê\u00012\b\u0010ç\u0001\u001a\u00030è\u0001J\t\u0010ë\u0001\u001a\u00020\u000eH\u0016J\t\u0010ì\u0001\u001a\u00020\u0005H\u0016J\n\u0010í\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010î\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010ï\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ð\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ñ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ò\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ó\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010ô\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010õ\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010ö\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010÷\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010ø\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ù\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010ú\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010û\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010ü\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ý\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010þ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ÿ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0080\u0002\u001a\u00020\u0003HÆ\u0003J\u0012\u0010\u0081\u0002\u001a\u00020\u001bHÆ\u0003¢\u0006\u0005\b\u0082\u0002\u0010HJ\n\u0010\u0083\u0002\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0084\u0002\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0085\u0002\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0086\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0087\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0088\u0002\u001a\u00020\"HÆ\u0003J\n\u0010\u0089\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008a\u0002\u001a\u00020%HÆ\u0003J\n\u0010\u008b\u0002\u001a\u00020\u000eHÆ\u0003J\n\u0010\u008c\u0002\u001a\u00020\u000eHÆ\u0003J\n\u0010\u008d\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008e\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008f\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0090\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0091\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0092\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0093\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0094\u0002\u001a\u000200HÆ\u0003J\n\u0010\u0095\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0096\u0002\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0097\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0098\u0002\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0099\u0002\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u009a\u0002\u001a\b\u0012\u0004\u0012\u00020\u000307HÆ\u0003J\u0010\u0010\u009b\u0002\u001a\b\u0012\u0004\u0012\u00020\u000307HÆ\u0003J\u0010\u0010\u009c\u0002\u001a\b\u0012\u0004\u0012\u00020\u000307HÆ\u0003Jû\u0003\u0010\u009d\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u00052\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020\u0003072\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u0003072\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u000307HÆ\u0001¢\u0006\u0006\b\u009e\u0002\u0010\u009f\u0002J-\u0010 \u0002\u001a\u00030ê\u00012\u0007\u0010¡\u0002\u001a\u00020\u00002\b\u0010¢\u0002\u001a\u00030£\u00022\b\u0010¤\u0002\u001a\u00030¥\u0002H\u0001¢\u0006\u0003\b¦\u0002R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010H\"\u0004\bP\u0010JR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010H\"\u0004\bR\u0010JR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010H\"\u0004\bT\u0010JR\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010H\"\u0004\bV\u0010JR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010L\"\u0004\b\\\u0010NR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010H\"\u0004\bb\u0010JR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010L\"\u0004\bd\u0010NR\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010H\"\u0004\bf\u0010JR\u001e\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010L\"\u0004\bh\u0010NR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010L\"\u0004\bj\u0010NR\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010L\"\u0004\bl\u0010NR\u001e\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010H\"\u0004\bn\u0010JR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010L\"\u0004\bp\u0010NR\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010H\"\u0004\br\u0010JR\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010H\"\u0004\bt\u0010JR\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010H\"\u0004\bv\u0010JR\u001c\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010y\u001a\u0004\bw\u0010H\"\u0004\bx\u0010JR\u001e\u0010\u001c\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010^\"\u0004\b{\u0010`R\u001e\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010^\"\u0004\b}\u0010`R\u001e\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010^\"\u0004\b\u007f\u0010`R \u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010L\"\u0005\b\u0081\u0001\u0010NR \u0010 \u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010L\"\u0005\b\u0083\u0001\u0010NR\"\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R \u0010#\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010L\"\u0005\b\u0089\u0001\u0010NR\"\u0010$\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R \u0010&\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010^\"\u0005\b\u008f\u0001\u0010`R \u0010'\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010^\"\u0005\b\u0091\u0001\u0010`R \u0010(\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010H\"\u0005\b\u0093\u0001\u0010JR \u0010)\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010H\"\u0005\b\u0095\u0001\u0010JR \u0010*\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010L\"\u0005\b\u0097\u0001\u0010NR \u0010+\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010H\"\u0005\b\u0099\u0001\u0010JR \u0010,\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010H\"\u0005\b\u009b\u0001\u0010JR\u001c\u0010-\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010H\"\u0005\b\u009d\u0001\u0010JR\u001c\u0010.\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010H\"\u0005\b\u009f\u0001\u0010JR\"\u0010/\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\u001c\u00101\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010L\"\u0005\b¥\u0001\u0010NR \u00102\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010^\"\u0005\b§\u0001\u0010`R\u001c\u00103\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010L\"\u0005\b©\u0001\u0010NR \u00104\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bª\u0001\u0010^\"\u0005\b«\u0001\u0010`R\u001c\u00105\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010L\"\u0005\b\u00ad\u0001\u0010NR$\u00106\u001a\b\u0012\u0004\u0012\u00020\u000307X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R$\u00108\u001a\b\u0012\u0004\u0012\u00020\u000307X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b²\u0001\u0010¯\u0001\"\u0006\b³\u0001\u0010±\u0001R$\u00109\u001a\b\u0012\u0004\u0012\u00020\u000307X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0001\u0010¯\u0001\"\u0006\bµ\u0001\u0010±\u0001R(\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00050?8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¶\u0001\u0010¯\u0001\"\u0006\b·\u0001\u0010±\u0001R \u0010@\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¸\u0001\u0010^\"\u0005\b¹\u0001\u0010`R \u0010A\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u0010L\"\u0005\b»\u0001\u0010NR \u0010B\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0001\u0010^\"\u0005\b½\u0001\u0010`R \u0010C\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¾\u0001\u0010^\"\u0005\b¿\u0001\u0010`R,\u0010Â\u0001\u001a\u00030Á\u00012\b\u0010À\u0001\u001a\u00030Á\u00018G@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R\u0013\u0010Ç\u0001\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\bÈ\u0001\u0010HR\u0013\u0010Ë\u0001\u001a\u00020\u00058F¢\u0006\u0007\u001a\u0005\bÌ\u0001\u0010LR\u0013\u0010Í\u0001\u001a\u00020\u00058F¢\u0006\u0007\u001a\u0005\bÎ\u0001\u0010LR\u0015\u0010Ò\u0001\u001a\u00030Ð\u00018F¢\u0006\b\u001a\u0006\bÓ\u0001\u0010Ô\u0001R\u0013\u0010Õ\u0001\u001a\u00020\u000e8F¢\u0006\u0007\u001a\u0005\bÖ\u0001\u0010^R\u0013\u0010×\u0001\u001a\u00020\u00058F¢\u0006\u0007\u001a\u0005\bØ\u0001\u0010LR\u0015\u0010Ù\u0001\u001a\u00030Ð\u00018F¢\u0006\b\u001a\u0006\bÚ\u0001\u0010Ô\u0001R\u0015\u0010Û\u0001\u001a\u00030Ð\u00018F¢\u0006\b\u001a\u0006\bÛ\u0001\u0010Ô\u0001R\u0015\u0010Ü\u0001\u001a\u00030Ð\u00018F¢\u0006\b\u001a\u0006\bÜ\u0001\u0010Ô\u0001R\u0015\u0010Ý\u0001\u001a\u00030Ð\u00018F¢\u0006\b\u001a\u0006\bÝ\u0001\u0010Ô\u0001R\u0015\u0010Þ\u0001\u001a\u00030Ð\u00018F¢\u0006\b\u001a\u0006\bÞ\u0001\u0010Ô\u0001R\u0013\u0010ß\u0001\u001a\u00020\u00058F¢\u0006\u0007\u001a\u0005\bà\u0001\u0010LR\u0013\u0010á\u0001\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\bâ\u0001\u0010HR\u0013\u0010ã\u0001\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\bä\u0001\u0010H¨\u0006¯\u0002"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "", "groupId", "", "groupTitle", "", "aid", "cid", "seasonId", "episodeId", "bizType", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;", "key", "videoAttr", "", "videoId", "videoTitle", "pageId", "pageTitle", RankRouter.BundleKey.VIDEO_DETAIL_COVER, "author", "authorMid", "bvid", "width", "height", "rotate", "duration", "Lkotlin/time/Duration;", "danmakuCount", "realVideoQuality", "preferredVideoQuality", "qualityDisplay", "qualityName", "mediaType", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$MediaType;", "qnPath", "videoInfo", "Lvideo/biz/offline/base/model/model/VideoPlayInfo;", "stateValue", "errorCode", "totalSize", "downloadedSize", "storagePath", "createTime", "updateTime", "videoIndex", "pageIndex", "seasonType", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;", "from", "appVersion", "extended", "authCode", "link", "sectionsLengthList", "", "sectionsContentTime", "sectionsDownloadedList", "<init>", "(JLjava/lang/String;JJJJLvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;Ljava/lang/String;IJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJJIIILjava/lang/String;Ljava/lang/String;Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$MediaType;Ljava/lang/String;Lvideo/biz/offline/base/model/model/VideoPlayInfo;IIJJLjava/lang/String;JJJJLvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "seen0", "seen1", "epSortedIds", "", "sections", "indexTitle", "epStatus", "triedCount", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIJLjava/lang/String;JJJJLvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;Ljava/lang/String;IJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLkotlin/time/Duration;IIILjava/lang/String;Ljava/lang/String;Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$MediaType;Ljava/lang/String;Lvideo/biz/offline/base/model/model/VideoPlayInfo;IIJJLjava/lang/String;JJJJLvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ILjava/lang/String;IILkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getGroupId", "()J", "setGroupId", "(J)V", "getGroupTitle", "()Ljava/lang/String;", "setGroupTitle", "(Ljava/lang/String;)V", "getAid", "setAid", "getCid", "setCid", "getSeasonId", "setSeasonId", "getEpisodeId", "setEpisodeId", "getBizType", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;", "setBizType", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;)V", "getKey", "setKey", "getVideoAttr", "()I", "setVideoAttr", "(I)V", "getVideoId", "setVideoId", "getVideoTitle", "setVideoTitle", "getPageId", "setPageId", "getPageTitle", "setPageTitle", "getCover", "setCover", "getAuthor", "setAuthor", "getAuthorMid", "setAuthorMid", "getBvid", "setBvid", "getWidth", "setWidth", "getHeight", "setHeight", "getRotate", "setRotate", "getDuration-UwyO8pc", "setDuration-LRDsOJo", "J", "getDanmakuCount", "setDanmakuCount", "getRealVideoQuality", "setRealVideoQuality", "getPreferredVideoQuality", "setPreferredVideoQuality", "getQualityDisplay", "setQualityDisplay", "getQualityName", "setQualityName", "getMediaType", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$MediaType;", "setMediaType", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$MediaType;)V", "getQnPath", "setQnPath", "getVideoInfo", "()Lvideo/biz/offline/base/model/model/VideoPlayInfo;", "setVideoInfo", "(Lvideo/biz/offline/base/model/model/VideoPlayInfo;)V", "getStateValue", "setStateValue", "getErrorCode", "setErrorCode", "getTotalSize", "setTotalSize", "getDownloadedSize", "setDownloadedSize", "getStoragePath", "setStoragePath", "getCreateTime", "setCreateTime", "getUpdateTime", "setUpdateTime", "getVideoIndex", "setVideoIndex", "getPageIndex", "setPageIndex", "getSeasonType", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;", "setSeasonType", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;)V", "getFrom", "setFrom", "getAppVersion", "setAppVersion", "getExtended", "setExtended", "getAuthCode", "setAuthCode", "getLink", "setLink", "getSectionsLengthList", "()Ljava/util/List;", "setSectionsLengthList", "(Ljava/util/List;)V", "getSectionsContentTime", "setSectionsContentTime", "getSectionsDownloadedList", "setSectionsDownloadedList", "getEpSortedIds", "setEpSortedIds", "getSections", "setSections", "getIndexTitle", "setIndexTitle", "getEpStatus", "setEpStatus", "getTriedCount", "setTriedCount", "value", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "state", "getState", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "setState", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;)V", "durationInSeconds", "getDurationInSeconds", "getDisplaySubtitle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "progressDesc", "getProgressDesc", "linkStr", "getLinkStr", "equals", "", "other", "canPlay", "getCanPlay", "()Z", "progressPercentage", "getProgressPercentage", "downloadDesc", "getDownloadDesc", "downloaded", "getDownloaded", "isDownloading", "isVipQuality", "isDolbyAudio", "isVip", "notifyBody", "getNotifyBody", "videoSize", "getVideoSize", "audioSize", "getAudioSize", "isValid", "hitAttr", "attr", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$VideoAttr;", "addAttr", "", "hashCode", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component21-UwyO8pc", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "copy", "copy-QZD5vYk", "(JLjava/lang/String;JJJJLvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;Ljava/lang/String;IJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJJIIILjava/lang/String;Ljava/lang/String;Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$MediaType;Ljava/lang/String;Lvideo/biz/offline/base/model/model/VideoPlayInfo;IIJJLjava/lang/String;JJJJLvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$model_debug", "Companion", "MediaType", "BizType", "State", "SeasonType", "VideoAttr", "DolbyType", "$serializer", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class OfflineVideoEntity {
    private long aid;
    private int appVersion;
    private int authCode;
    private String author;
    private long authorMid;
    private BizType bizType;
    private String bvid;
    private long cid;
    private String cover;
    private long createTime;
    private int danmakuCount;
    private long downloadedSize;
    private long duration;
    private List<String> epSortedIds;
    private int epStatus;
    private long episodeId;
    private int errorCode;
    private String extended;
    private String from;
    private long groupId;
    private String groupTitle;
    private long height;
    private String indexTitle;
    private String key;
    private String link;
    private MediaType mediaType;
    private long pageId;
    private long pageIndex;
    private String pageTitle;
    private int preferredVideoQuality;
    private String qnPath;
    private String qualityDisplay;
    private String qualityName;
    private int realVideoQuality;
    private long rotate;
    private long seasonId;
    private SeasonType seasonType;
    private int sections;
    private List<Long> sectionsContentTime;
    private List<Long> sectionsDownloadedList;
    private List<Long> sectionsLengthList;
    private int stateValue;
    private String storagePath;
    private long totalSize;
    private int triedCount;
    private long updateTime;
    private int videoAttr;
    private long videoId;
    private long videoIndex;
    private VideoPlayInfo videoInfo;
    private String videoTitle;
    private long width;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.model.entity.OfflineVideoEntity$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = OfflineVideoEntity._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.model.entity.OfflineVideoEntity$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = OfflineVideoEntity._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.model.entity.OfflineVideoEntity$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = OfflineVideoEntity._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.model.entity.OfflineVideoEntity$$ExternalSyntheticLambda3
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = OfflineVideoEntity._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.model.entity.OfflineVideoEntity$$ExternalSyntheticLambda4
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$3;
            _childSerializers$_anonymous_$3 = OfflineVideoEntity._childSerializers$_anonymous_$3();
            return _childSerializers$_anonymous_$3;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.model.entity.OfflineVideoEntity$$ExternalSyntheticLambda5
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$4;
            _childSerializers$_anonymous_$4 = OfflineVideoEntity._childSerializers$_anonymous_$4();
            return _childSerializers$_anonymous_$4;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.model.entity.OfflineVideoEntity$$ExternalSyntheticLambda6
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$5;
            _childSerializers$_anonymous_$5 = OfflineVideoEntity._childSerializers$_anonymous_$5();
            return _childSerializers$_anonymous_$5;
        }
    }), null, null, null, null};

    /* compiled from: OfflineVideoEntity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;", "", "<init>", "(Ljava/lang/String;I)V", "UGC", "OGV", "PUGV", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum BizType {
        UGC,
        OGV,
        PUGV;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<BizType> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: OfflineVideoEntity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$MediaType;", "", "<init>", "(Ljava/lang/String;I)V", "DASH", "FLV", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum MediaType {
        DASH,
        FLV;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<MediaType> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: OfflineVideoEntity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BizType.values().length];
            try {
                iArr[BizType.UGC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[BizType.OGV.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ OfflineVideoEntity(int i, int i2, long j, String str, long j2, long j3, long j4, long j5, BizType bizType, String str2, int i3, long j6, String str3, long j7, String str4, String str5, String str6, long j8, String str7, long j9, long j10, long j11, Duration duration, int i4, int i5, int i6, String str8, String str9, MediaType mediaType, String str10, VideoPlayInfo videoPlayInfo, int i7, int i8, long j12, long j13, String str11, long j14, long j15, long j16, long j17, SeasonType seasonType, String str12, int i9, String str13, int i10, String str14, List list, List list2, List list3, List list4, int i11, String str15, int i12, int i13, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j, str, j2, j3, j4, j5, bizType, str2, i3, j6, str3, j7, str4, str5, str6, j8, str7, j9, j10, j11, duration, i4, i5, i6, str8, str9, mediaType, str10, videoPlayInfo, i7, i8, j12, j13, str11, j14, j15, j16, j17, seasonType, str12, i9, str13, i10, str14, list, list2, list3, list4, i11, str15, i12, i13, serializationConstructorMarker);
    }

    public /* synthetic */ OfflineVideoEntity(long j, String str, long j2, long j3, long j4, long j5, BizType bizType, String str2, int i, long j6, String str3, long j7, String str4, String str5, String str6, long j8, String str7, long j9, long j10, long j11, long j12, int i2, int i3, int i4, String str8, String str9, MediaType mediaType, String str10, VideoPlayInfo videoPlayInfo, int i5, int i6, long j13, long j14, String str11, long j15, long j16, long j17, long j18, SeasonType seasonType, String str12, int i7, String str13, int i8, String str14, List list, List list2, List list3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, j2, j3, j4, j5, bizType, str2, i, j6, str3, j7, str4, str5, str6, j8, str7, j9, j10, j11, j12, i2, i3, i4, str8, str9, mediaType, str10, videoPlayInfo, i5, i6, j13, j14, str11, j15, j16, j17, j18, seasonType, str12, i7, str13, i8, str14, list, list2, list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-QZD5vYk$default  reason: not valid java name */
    public static /* synthetic */ OfflineVideoEntity m2770copyQZD5vYk$default(OfflineVideoEntity offlineVideoEntity, long j, String str, long j2, long j3, long j4, long j5, BizType bizType, String str2, int i, long j6, String str3, long j7, String str4, String str5, String str6, long j8, String str7, long j9, long j10, long j11, long j12, int i2, int i3, int i4, String str8, String str9, MediaType mediaType, String str10, VideoPlayInfo videoPlayInfo, int i5, int i6, long j13, long j14, String str11, long j15, long j16, long j17, long j18, SeasonType seasonType, String str12, int i7, String str13, int i8, String str14, List list, List list2, List list3, int i9, int i10, Object obj) {
        long j19 = (i9 & 1) != 0 ? offlineVideoEntity.groupId : j;
        String str15 = (i9 & 2) != 0 ? offlineVideoEntity.groupTitle : str;
        long j20 = (i9 & 4) != 0 ? offlineVideoEntity.aid : j2;
        long j21 = (i9 & 8) != 0 ? offlineVideoEntity.cid : j3;
        long j22 = (i9 & 16) != 0 ? offlineVideoEntity.seasonId : j4;
        long j23 = (i9 & 32) != 0 ? offlineVideoEntity.episodeId : j5;
        BizType bizType2 = (i9 & 64) != 0 ? offlineVideoEntity.bizType : bizType;
        String str16 = (i9 & 128) != 0 ? offlineVideoEntity.key : str2;
        int i11 = (i9 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? offlineVideoEntity.videoAttr : i;
        BizType bizType3 = bizType2;
        long j24 = (i9 & 512) != 0 ? offlineVideoEntity.videoId : j6;
        String str17 = (i9 & 1024) != 0 ? offlineVideoEntity.videoTitle : str3;
        long j25 = (i9 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? offlineVideoEntity.pageId : j7;
        String str18 = (i9 & 4096) != 0 ? offlineVideoEntity.pageTitle : str4;
        String str19 = (i9 & 8192) != 0 ? offlineVideoEntity.cover : str5;
        String str20 = str18;
        String str21 = (i9 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? offlineVideoEntity.author : str6;
        long j26 = (i9 & 32768) != 0 ? offlineVideoEntity.authorMid : j8;
        String str22 = (i9 & 65536) != 0 ? offlineVideoEntity.bvid : str7;
        long j27 = (131072 & i9) != 0 ? offlineVideoEntity.width : j9;
        long j28 = (i9 & 262144) != 0 ? offlineVideoEntity.height : j10;
        long j29 = (i9 & 524288) != 0 ? offlineVideoEntity.rotate : j11;
        long j30 = (i9 & 1048576) != 0 ? offlineVideoEntity.duration : j12;
        int i12 = (i9 & 2097152) != 0 ? offlineVideoEntity.danmakuCount : i2;
        return offlineVideoEntity.m2772copyQZD5vYk(j19, str15, j20, j21, j22, j23, bizType3, str16, i11, j24, str17, j25, str20, str19, str21, j26, str22, j27, j28, j29, j30, i12, (4194304 & i9) != 0 ? offlineVideoEntity.realVideoQuality : i3, (i9 & 8388608) != 0 ? offlineVideoEntity.preferredVideoQuality : i4, (i9 & 16777216) != 0 ? offlineVideoEntity.qualityDisplay : str8, (i9 & 33554432) != 0 ? offlineVideoEntity.qualityName : str9, (i9 & 67108864) != 0 ? offlineVideoEntity.mediaType : mediaType, (i9 & 134217728) != 0 ? offlineVideoEntity.qnPath : str10, (i9 & 268435456) != 0 ? offlineVideoEntity.videoInfo : videoPlayInfo, (i9 & 536870912) != 0 ? offlineVideoEntity.stateValue : i5, (i9 & 1073741824) != 0 ? offlineVideoEntity.errorCode : i6, (i9 & Integer.MIN_VALUE) != 0 ? offlineVideoEntity.totalSize : j13, (i10 & 1) != 0 ? offlineVideoEntity.downloadedSize : j14, (i10 & 2) != 0 ? offlineVideoEntity.storagePath : str11, (i10 & 4) != 0 ? offlineVideoEntity.createTime : j15, (i10 & 8) != 0 ? offlineVideoEntity.updateTime : j16, (i10 & 16) != 0 ? offlineVideoEntity.videoIndex : j17, (i10 & 32) != 0 ? offlineVideoEntity.pageIndex : j18, (i10 & 64) != 0 ? offlineVideoEntity.seasonType : seasonType, (i10 & 128) != 0 ? offlineVideoEntity.from : str12, (i10 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? offlineVideoEntity.appVersion : i7, (i10 & 512) != 0 ? offlineVideoEntity.extended : str13, (i10 & 1024) != 0 ? offlineVideoEntity.authCode : i8, (i10 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? offlineVideoEntity.link : str14, (i10 & 4096) != 0 ? offlineVideoEntity.sectionsLengthList : list, (i10 & 8192) != 0 ? offlineVideoEntity.sectionsContentTime : list2, (i10 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? offlineVideoEntity.sectionsDownloadedList : list3);
    }

    public final long component1() {
        return this.groupId;
    }

    public final long component10() {
        return this.videoId;
    }

    public final String component11() {
        return this.videoTitle;
    }

    public final long component12() {
        return this.pageId;
    }

    public final String component13() {
        return this.pageTitle;
    }

    public final String component14() {
        return this.cover;
    }

    public final String component15() {
        return this.author;
    }

    public final long component16() {
        return this.authorMid;
    }

    public final String component17() {
        return this.bvid;
    }

    public final long component18() {
        return this.width;
    }

    public final long component19() {
        return this.height;
    }

    public final String component2() {
        return this.groupTitle;
    }

    public final long component20() {
        return this.rotate;
    }

    /* renamed from: component21-UwyO8pc  reason: not valid java name */
    public final long m2771component21UwyO8pc() {
        return this.duration;
    }

    public final int component22() {
        return this.danmakuCount;
    }

    public final int component23() {
        return this.realVideoQuality;
    }

    public final int component24() {
        return this.preferredVideoQuality;
    }

    public final String component25() {
        return this.qualityDisplay;
    }

    public final String component26() {
        return this.qualityName;
    }

    public final MediaType component27() {
        return this.mediaType;
    }

    public final String component28() {
        return this.qnPath;
    }

    public final VideoPlayInfo component29() {
        return this.videoInfo;
    }

    public final long component3() {
        return this.aid;
    }

    public final int component30() {
        return this.stateValue;
    }

    public final int component31() {
        return this.errorCode;
    }

    public final long component32() {
        return this.totalSize;
    }

    public final long component33() {
        return this.downloadedSize;
    }

    public final String component34() {
        return this.storagePath;
    }

    public final long component35() {
        return this.createTime;
    }

    public final long component36() {
        return this.updateTime;
    }

    public final long component37() {
        return this.videoIndex;
    }

    public final long component38() {
        return this.pageIndex;
    }

    public final SeasonType component39() {
        return this.seasonType;
    }

    public final long component4() {
        return this.cid;
    }

    public final String component40() {
        return this.from;
    }

    public final int component41() {
        return this.appVersion;
    }

    public final String component42() {
        return this.extended;
    }

    public final int component43() {
        return this.authCode;
    }

    public final String component44() {
        return this.link;
    }

    public final List<Long> component45() {
        return this.sectionsLengthList;
    }

    public final List<Long> component46() {
        return this.sectionsContentTime;
    }

    public final List<Long> component47() {
        return this.sectionsDownloadedList;
    }

    public final long component5() {
        return this.seasonId;
    }

    public final long component6() {
        return this.episodeId;
    }

    public final BizType component7() {
        return this.bizType;
    }

    public final String component8() {
        return this.key;
    }

    public final int component9() {
        return this.videoAttr;
    }

    /* renamed from: copy-QZD5vYk  reason: not valid java name */
    public final OfflineVideoEntity m2772copyQZD5vYk(long j, String str, long j2, long j3, long j4, long j5, BizType bizType, String str2, int i, long j6, String str3, long j7, String str4, String str5, String str6, long j8, String str7, long j9, long j10, long j11, long j12, int i2, int i3, int i4, String str8, String str9, MediaType mediaType, String str10, VideoPlayInfo videoPlayInfo, int i5, int i6, long j13, long j14, String str11, long j15, long j16, long j17, long j18, SeasonType seasonType, String str12, int i7, String str13, int i8, String str14, List<Long> list, List<Long> list2, List<Long> list3) {
        Intrinsics.checkNotNullParameter(str, "groupTitle");
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(str2, "key");
        Intrinsics.checkNotNullParameter(str3, "videoTitle");
        Intrinsics.checkNotNullParameter(str4, "pageTitle");
        Intrinsics.checkNotNullParameter(str5, RankRouter.BundleKey.VIDEO_DETAIL_COVER);
        Intrinsics.checkNotNullParameter(str6, "author");
        Intrinsics.checkNotNullParameter(str7, "bvid");
        Intrinsics.checkNotNullParameter(str8, "qualityDisplay");
        Intrinsics.checkNotNullParameter(str9, "qualityName");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(str10, "qnPath");
        Intrinsics.checkNotNullParameter(videoPlayInfo, "videoInfo");
        Intrinsics.checkNotNullParameter(str11, "storagePath");
        Intrinsics.checkNotNullParameter(seasonType, "seasonType");
        Intrinsics.checkNotNullParameter(str12, "from");
        Intrinsics.checkNotNullParameter(str13, "extended");
        Intrinsics.checkNotNullParameter(str14, "link");
        Intrinsics.checkNotNullParameter(list, "sectionsLengthList");
        Intrinsics.checkNotNullParameter(list2, "sectionsContentTime");
        Intrinsics.checkNotNullParameter(list3, "sectionsDownloadedList");
        return new OfflineVideoEntity(j, str, j2, j3, j4, j5, bizType, str2, i, j6, str3, j7, str4, str5, str6, j8, str7, j9, j10, j11, j12, i2, i3, i4, str8, str9, mediaType, str10, videoPlayInfo, i5, i6, j13, j14, str11, j15, j16, j17, j18, seasonType, str12, i7, str13, i8, str14, list, list2, list3, null);
    }

    private /* synthetic */ OfflineVideoEntity(int seen0, int seen1, long groupId, String groupTitle, long aid, long cid, long seasonId, long episodeId, BizType bizType, String key, int videoAttr, long videoId, String videoTitle, long pageId, String pageTitle, String cover, String author, long authorMid, String bvid, long width, long height, long rotate, Duration duration, int danmakuCount, int realVideoQuality, int preferredVideoQuality, String qualityDisplay, String qualityName, MediaType mediaType, String qnPath, VideoPlayInfo videoInfo, int stateValue, int errorCode, long totalSize, long downloadedSize, String storagePath, long createTime, long updateTime, long videoIndex, long pageIndex, SeasonType seasonType, String from, int appVersion, String extended, int authCode, String link, List sectionsLengthList, List sectionsContentTime, List sectionsDownloadedList, List epSortedIds, int sections, String indexTitle, int epStatus, int triedCount, SerializationConstructorMarker serializationConstructorMarker) {
        int i;
        long j;
        long j2;
        long j3;
        long j4;
        StringBuilder sb;
        StringBuilder append;
        if ((seen0 & 1) == 0) {
            this.groupId = 0L;
        } else {
            this.groupId = groupId;
        }
        if ((seen0 & 2) == 0) {
            this.groupTitle = "";
        } else {
            this.groupTitle = groupTitle;
        }
        if ((seen0 & 4) == 0) {
            this.aid = 0L;
        } else {
            this.aid = aid;
        }
        if ((seen0 & 8) == 0) {
            this.cid = 0L;
        } else {
            this.cid = cid;
        }
        if ((seen0 & 16) == 0) {
            this.seasonId = 0L;
        } else {
            this.seasonId = seasonId;
        }
        if ((seen0 & 32) == 0) {
            this.episodeId = 0L;
        } else {
            this.episodeId = episodeId;
        }
        if ((seen0 & 64) == 0) {
            this.bizType = BizType.UGC;
        } else {
            this.bizType = bizType;
        }
        if ((seen0 & 128) == 0) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.bizType.ordinal()]) {
                case 1:
                    j3 = this.aid;
                    j4 = this.cid;
                    sb = new StringBuilder();
                    append = sb.append("av_").append(j3).append("_").append(j4);
                    break;
                case 2:
                    append = new StringBuilder().append("ep_").append(this.seasonId).append("_").append(this.episodeId);
                    break;
                default:
                    j3 = this.aid;
                    j4 = this.cid;
                    sb = new StringBuilder();
                    append = sb.append("av_").append(j3).append("_").append(j4);
                    break;
            }
            this.key = append.toString();
        } else {
            this.key = key;
        }
        if ((seen0 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
            this.videoAttr = 0;
        } else {
            this.videoAttr = videoAttr;
        }
        if ((seen0 & 512) == 0) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.bizType.ordinal()]) {
                case 1:
                default:
                    j2 = this.aid;
                    break;
                case 2:
                    j2 = this.seasonId;
                    break;
            }
            this.videoId = j2;
        } else {
            this.videoId = videoId;
        }
        if ((seen0 & 1024) == 0) {
            this.videoTitle = "";
        } else {
            this.videoTitle = videoTitle;
        }
        if ((seen0 & IjkMediaMeta.FF_PROFILE_H264_INTRA) == 0) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.bizType.ordinal()]) {
                case 1:
                default:
                    j = this.cid;
                    break;
                case 2:
                    j = this.episodeId;
                    break;
            }
            this.pageId = j;
        } else {
            this.pageId = pageId;
        }
        if ((seen0 & 4096) == 0) {
            this.pageTitle = "";
        } else {
            this.pageTitle = pageTitle;
        }
        if ((seen0 & 8192) == 0) {
            this.cover = "";
        } else {
            this.cover = cover;
        }
        if ((seen0 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) == 0) {
            this.author = "";
        } else {
            this.author = author;
        }
        if ((seen0 & 32768) == 0) {
            this.authorMid = 0L;
        } else {
            this.authorMid = authorMid;
        }
        if ((seen0 & 65536) == 0) {
            this.bvid = "";
        } else {
            this.bvid = bvid;
        }
        if ((seen0 & 131072) == 0) {
            this.width = 0L;
        } else {
            this.width = width;
        }
        if ((seen0 & 262144) == 0) {
            this.height = 0L;
        } else {
            this.height = height;
        }
        if ((seen0 & 524288) == 0) {
            this.rotate = 0L;
        } else {
            this.rotate = rotate;
        }
        this.duration = (seen0 & 1048576) == 0 ? Duration.Companion.getZERO-UwyO8pc() : duration.unbox-impl();
        if ((2097152 & seen0) == 0) {
            i = 0;
            this.danmakuCount = 0;
        } else {
            i = 0;
            this.danmakuCount = danmakuCount;
        }
        if ((seen0 & 4194304) == 0) {
            this.realVideoQuality = i;
        } else {
            this.realVideoQuality = realVideoQuality;
        }
        if ((seen0 & 8388608) == 0) {
            this.preferredVideoQuality = 0;
        } else {
            this.preferredVideoQuality = preferredVideoQuality;
        }
        if ((seen0 & 16777216) == 0) {
            this.qualityDisplay = "";
        } else {
            this.qualityDisplay = qualityDisplay;
        }
        if ((seen0 & 33554432) == 0) {
            this.qualityName = "";
        } else {
            this.qualityName = qualityName;
        }
        if ((seen0 & 67108864) == 0) {
            this.mediaType = MediaType.DASH;
        } else {
            this.mediaType = mediaType;
        }
        if ((seen0 & 134217728) == 0) {
            this.qnPath = "";
        } else {
            this.qnPath = qnPath;
        }
        if ((seen0 & 268435456) == 0) {
            this.videoInfo = new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null);
        } else {
            this.videoInfo = videoInfo;
        }
        if ((seen0 & 536870912) == 0) {
            this.stateValue = 0;
        } else {
            this.stateValue = stateValue;
        }
        if ((seen0 & 1073741824) == 0) {
            this.errorCode = 0;
        } else {
            this.errorCode = errorCode;
        }
        if ((seen0 & Integer.MIN_VALUE) == 0) {
            this.totalSize = 0L;
        } else {
            this.totalSize = totalSize;
        }
        if ((seen1 & 1) == 0) {
            this.downloadedSize = 0L;
        } else {
            this.downloadedSize = downloadedSize;
        }
        if ((seen1 & 2) == 0) {
            this.storagePath = "";
        } else {
            this.storagePath = storagePath;
        }
        if ((seen1 & 4) == 0) {
            this.createTime = 0L;
        } else {
            this.createTime = createTime;
        }
        if ((seen1 & 8) == 0) {
            this.updateTime = 0L;
        } else {
            this.updateTime = updateTime;
        }
        if ((seen1 & 16) == 0) {
            this.videoIndex = 0L;
        } else {
            this.videoIndex = videoIndex;
        }
        if ((seen1 & 32) == 0) {
            this.pageIndex = 0L;
        } else {
            this.pageIndex = pageIndex;
        }
        if ((seen1 & 64) == 0) {
            this.seasonType = SeasonType.UNKNOWN;
        } else {
            this.seasonType = seasonType;
        }
        if ((seen1 & 128) == 0) {
            this.from = "";
        } else {
            this.from = from;
        }
        if ((seen1 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
            this.appVersion = 0;
        } else {
            this.appVersion = appVersion;
        }
        if ((seen1 & 512) == 0) {
            this.extended = "";
        } else {
            this.extended = extended;
        }
        if ((seen1 & 1024) == 0) {
            this.authCode = 0;
        } else {
            this.authCode = authCode;
        }
        if ((seen1 & IjkMediaMeta.FF_PROFILE_H264_INTRA) == 0) {
            this.link = "";
        } else {
            this.link = link;
        }
        if ((seen1 & 4096) == 0) {
            this.sectionsLengthList = new ArrayList();
        } else {
            this.sectionsLengthList = sectionsLengthList;
        }
        if ((seen1 & 8192) == 0) {
            this.sectionsContentTime = new ArrayList();
        } else {
            this.sectionsContentTime = sectionsContentTime;
        }
        if ((seen1 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) == 0) {
            this.sectionsDownloadedList = new ArrayList();
        } else {
            this.sectionsDownloadedList = sectionsDownloadedList;
        }
        if ((seen1 & 32768) == 0) {
            this.epSortedIds = CollectionsKt.emptyList();
        } else {
            this.epSortedIds = epSortedIds;
        }
        if ((seen1 & 65536) == 0) {
            this.sections = 0;
        } else {
            this.sections = sections;
        }
        if ((seen1 & 131072) == 0) {
            this.indexTitle = "";
        } else {
            this.indexTitle = indexTitle;
        }
        if ((seen1 & 262144) == 0) {
            this.epStatus = 0;
        } else {
            this.epStatus = epStatus;
        }
        if ((seen1 & 524288) == 0) {
            this.triedCount = 0;
        } else {
            this.triedCount = triedCount;
        }
    }

    private OfflineVideoEntity(long groupId, String groupTitle, long aid, long cid, long seasonId, long episodeId, BizType bizType, String key, int videoAttr, long videoId, String videoTitle, long pageId, String pageTitle, String cover, String author, long authorMid, String bvid, long width, long height, long rotate, long duration, int danmakuCount, int realVideoQuality, int preferredVideoQuality, String qualityDisplay, String qualityName, MediaType mediaType, String qnPath, VideoPlayInfo videoInfo, int stateValue, int errorCode, long totalSize, long downloadedSize, String storagePath, long createTime, long updateTime, long videoIndex, long pageIndex, SeasonType seasonType, String from, int appVersion, String extended, int authCode, String link, List<Long> list, List<Long> list2, List<Long> list3) {
        Intrinsics.checkNotNullParameter(groupTitle, "groupTitle");
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(videoTitle, "videoTitle");
        Intrinsics.checkNotNullParameter(pageTitle, "pageTitle");
        Intrinsics.checkNotNullParameter(cover, RankRouter.BundleKey.VIDEO_DETAIL_COVER);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(bvid, "bvid");
        Intrinsics.checkNotNullParameter(qualityDisplay, "qualityDisplay");
        Intrinsics.checkNotNullParameter(qualityName, "qualityName");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(qnPath, "qnPath");
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        Intrinsics.checkNotNullParameter(storagePath, "storagePath");
        Intrinsics.checkNotNullParameter(seasonType, "seasonType");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(extended, "extended");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(list, "sectionsLengthList");
        Intrinsics.checkNotNullParameter(list2, "sectionsContentTime");
        Intrinsics.checkNotNullParameter(list3, "sectionsDownloadedList");
        this.groupId = groupId;
        this.groupTitle = groupTitle;
        this.aid = aid;
        this.cid = cid;
        this.seasonId = seasonId;
        this.episodeId = episodeId;
        this.bizType = bizType;
        this.key = key;
        this.videoAttr = videoAttr;
        this.videoId = videoId;
        this.videoTitle = videoTitle;
        this.pageId = pageId;
        this.pageTitle = pageTitle;
        this.cover = cover;
        this.author = author;
        this.authorMid = authorMid;
        this.bvid = bvid;
        this.width = width;
        this.height = height;
        this.rotate = rotate;
        this.duration = duration;
        this.danmakuCount = danmakuCount;
        this.realVideoQuality = realVideoQuality;
        this.preferredVideoQuality = preferredVideoQuality;
        this.qualityDisplay = qualityDisplay;
        this.qualityName = qualityName;
        this.mediaType = mediaType;
        this.qnPath = qnPath;
        this.videoInfo = videoInfo;
        this.stateValue = stateValue;
        this.errorCode = errorCode;
        this.totalSize = totalSize;
        this.downloadedSize = downloadedSize;
        this.storagePath = storagePath;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.videoIndex = videoIndex;
        this.pageIndex = pageIndex;
        this.seasonType = seasonType;
        this.from = from;
        this.appVersion = appVersion;
        this.extended = extended;
        this.authCode = authCode;
        this.link = link;
        this.sectionsLengthList = list;
        this.sectionsContentTime = list2;
        this.sectionsDownloadedList = list3;
        this.epSortedIds = CollectionsKt.emptyList();
        this.indexTitle = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("video.biz.offline.base.model.entity.OfflineVideoEntity.BizType", BizType.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return EnumsKt.createSimpleEnumSerializer("video.biz.offline.base.model.entity.OfflineVideoEntity.MediaType", MediaType.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return EnumsKt.createSimpleEnumSerializer("video.biz.offline.base.model.entity.OfflineVideoEntity.SeasonType", SeasonType.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(LongSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new ArrayListSerializer(LongSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new ArrayListSerializer(LongSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$5() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0546  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x05b4  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x0659  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0672  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x06a9  */
    /* JADX WARN: Removed duplicated region for block: B:485:0x06b1  */
    /* JADX WARN: Removed duplicated region for block: B:487:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void write$Self$model_debug(OfflineVideoEntity self, CompositeEncoder output, SerialDescriptor serialDesc) {
        long j;
        boolean z;
        long j2;
        boolean z2;
        StringBuilder append;
        long j3;
        StringBuilder append2;
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        boolean z3 = true;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.groupId != 0) {
            output.encodeLongElement(serialDesc, 0, self.groupId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.groupTitle, "")) {
            output.encodeStringElement(serialDesc, 1, self.groupTitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.aid != 0) {
            output.encodeLongElement(serialDesc, 2, self.aid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.cid != 0) {
            output.encodeLongElement(serialDesc, 3, self.cid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.seasonId != 0) {
            output.encodeLongElement(serialDesc, 4, self.seasonId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.episodeId != 0) {
            output.encodeLongElement(serialDesc, 5, self.episodeId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.bizType != BizType.UGC) {
            output.encodeSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.bizType);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7)) {
            String str = self.key;
            switch (WhenMappings.$EnumSwitchMapping$0[self.bizType.ordinal()]) {
                case 1:
                    append = new StringBuilder().append("av_").append(self.aid).append("_").append(self.cid);
                    break;
                case 2:
                    long j4 = self.seasonId;
                    j3 = self.episodeId;
                    append2 = new StringBuilder().append("ep_").append(j4);
                    append = append2.append("_").append(j3);
                    break;
                default:
                    long j5 = self.aid;
                    j3 = self.cid;
                    append2 = new StringBuilder().append("av_").append(j5);
                    append = append2.append("_").append(j3);
                    break;
            }
            z3 = !Intrinsics.areEqual(str, append.toString());
        }
        if (z3) {
            output.encodeStringElement(serialDesc, 7, self.key);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.videoAttr != 0) {
            output.encodeIntElement(serialDesc, 8, self.videoAttr);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 9)) {
            long j6 = self.videoId;
            switch (WhenMappings.$EnumSwitchMapping$0[self.bizType.ordinal()]) {
                case 1:
                default:
                    j = self.aid;
                    break;
                case 2:
                    j = self.seasonId;
                    break;
            }
            if (j6 == j) {
                z = false;
                if (z) {
                    output.encodeLongElement(serialDesc, 9, self.videoId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.videoTitle, "")) {
                    output.encodeStringElement(serialDesc, 10, self.videoTitle);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 11)) {
                    long j7 = self.pageId;
                    switch (WhenMappings.$EnumSwitchMapping$0[self.bizType.ordinal()]) {
                        case 1:
                        default:
                            j2 = self.cid;
                            break;
                        case 2:
                            j2 = self.episodeId;
                            break;
                    }
                    if (j7 == j2) {
                        z2 = false;
                        if (z2) {
                            output.encodeLongElement(serialDesc, 11, self.pageId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 12) || !Intrinsics.areEqual(self.pageTitle, "")) {
                            output.encodeStringElement(serialDesc, 12, self.pageTitle);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 13) || !Intrinsics.areEqual(self.cover, "")) {
                            output.encodeStringElement(serialDesc, 13, self.cover);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 14) || !Intrinsics.areEqual(self.author, "")) {
                            output.encodeStringElement(serialDesc, 14, self.author);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.authorMid != 0) {
                            output.encodeLongElement(serialDesc, 15, self.authorMid);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 16) || !Intrinsics.areEqual(self.bvid, "")) {
                            output.encodeStringElement(serialDesc, 16, self.bvid);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.width != 0) {
                            output.encodeLongElement(serialDesc, 17, self.width);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.height != 0) {
                            output.encodeLongElement(serialDesc, 18, self.height);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.rotate != 0) {
                            output.encodeLongElement(serialDesc, 19, self.rotate);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 20) || !Duration.equals-impl0(self.duration, Duration.Companion.getZERO-UwyO8pc())) {
                            output.encodeSerializableElement(serialDesc, 20, DurationSerializer.INSTANCE, Duration.box-impl(self.duration));
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.danmakuCount != 0) {
                            output.encodeIntElement(serialDesc, 21, self.danmakuCount);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
                            output.encodeIntElement(serialDesc, 22, self.realVideoQuality);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
                            output.encodeIntElement(serialDesc, 23, self.preferredVideoQuality);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                            output.encodeStringElement(serialDesc, 24, self.qualityDisplay);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                            output.encodeStringElement(serialDesc, 25, self.qualityName);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                            output.encodeSerializableElement(serialDesc, 26, (SerializationStrategy) lazyArr[26].getValue(), self.mediaType);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                            output.encodeStringElement(serialDesc, 27, self.qnPath);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                            output.encodeSerializableElement(serialDesc, 28, VideoPlayInfo$$serializer.INSTANCE, self.videoInfo);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                            output.encodeIntElement(serialDesc, 29, self.stateValue);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                            output.encodeIntElement(serialDesc, 30, self.errorCode);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                            output.encodeLongElement(serialDesc, 31, self.totalSize);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                            output.encodeLongElement(serialDesc, 32, self.downloadedSize);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                            output.encodeStringElement(serialDesc, 33, self.storagePath);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                            output.encodeLongElement(serialDesc, 34, self.createTime);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                            output.encodeLongElement(serialDesc, 35, self.updateTime);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                            output.encodeLongElement(serialDesc, 36, self.videoIndex);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                            output.encodeLongElement(serialDesc, 37, self.pageIndex);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                            output.encodeSerializableElement(serialDesc, 38, (SerializationStrategy) lazyArr[38].getValue(), self.seasonType);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                            output.encodeStringElement(serialDesc, 39, self.from);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                            output.encodeIntElement(serialDesc, 40, self.appVersion);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                            output.encodeStringElement(serialDesc, 41, self.extended);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                            output.encodeIntElement(serialDesc, 42, self.authCode);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                            output.encodeStringElement(serialDesc, 43, self.link);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                            output.encodeSerializableElement(serialDesc, 44, (SerializationStrategy) lazyArr[44].getValue(), self.sectionsLengthList);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                            output.encodeSerializableElement(serialDesc, 45, (SerializationStrategy) lazyArr[45].getValue(), self.sectionsContentTime);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                            output.encodeSerializableElement(serialDesc, 46, (SerializationStrategy) lazyArr[46].getValue(), self.sectionsDownloadedList);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                            output.encodeSerializableElement(serialDesc, 47, (SerializationStrategy) lazyArr[47].getValue(), self.epSortedIds);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                            output.encodeIntElement(serialDesc, 48, self.sections);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                            output.encodeStringElement(serialDesc, 49, self.indexTitle);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                            output.encodeIntElement(serialDesc, 50, self.epStatus);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                            return;
                        }
                        output.encodeIntElement(serialDesc, 51, self.triedCount);
                        return;
                    }
                }
                z2 = true;
                if (z2) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 12)) {
                    if (output.shouldEncodeElementDefault(serialDesc, 12) || !Intrinsics.areEqual(self.pageTitle, "")) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 13)) {
                        if (output.shouldEncodeElementDefault(serialDesc, 13) || !Intrinsics.areEqual(self.cover, "")) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 14)) {
                            if (output.shouldEncodeElementDefault(serialDesc, 14) || !Intrinsics.areEqual(self.author, "")) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 15)) {
                                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.authorMid != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 16)) {
                                    if (output.shouldEncodeElementDefault(serialDesc, 16) || !Intrinsics.areEqual(self.bvid, "")) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 17)) {
                                        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.width != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 18)) {
                                            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.height != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 19)) {
                                                if (output.shouldEncodeElementDefault(serialDesc, 19) || self.rotate != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 20)) {
                                                    if (output.shouldEncodeElementDefault(serialDesc, 20) || !Duration.equals-impl0(self.duration, Duration.Companion.getZERO-UwyO8pc())) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 21)) {
                                                        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.danmakuCount != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 22)) {
                                                            if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 23)) {
                                                                if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 24)) {
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 25)) {
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 26)) {
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 27)) {
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 28)) {
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 29)) {
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 30)) {
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 31)) {
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 32)) {
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 33)) {
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 34)) {
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 35)) {
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 36)) {
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 37)) {
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 38)) {
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                                                                            }
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 39)) {
                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                                                                                }
                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 40)) {
                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                                                                                    }
                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 41)) {
                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                                                                        }
                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 42)) {
                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                                                                            }
                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 43)) {
                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                                                                                }
                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 44)) {
                                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                                                                                    }
                                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 45)) {
                                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                                                                        }
                                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 46)) {
                                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                                                                            }
                                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 47)) {
                                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                                                                                }
                                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 48)) {
                                                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                                                                                    }
                                                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 49)) {
                                                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                                                                        }
                                                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 50)) {
                                                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                                                                            }
                                                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 51)) {
                                                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                                                                        }
                                                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                                                                    }
                                                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                                                                    }
                                                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                                                                                }
                                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                                                                }
                                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                                                                }
                                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                                                                            }
                                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                                                                            }
                                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                                                            }
                                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                                                            }
                                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                                                                        }
                                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                                                                        }
                                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                                                                        }
                                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                                                        }
                                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                                                        }
                                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                                                                    }
                                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                                                                    }
                                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                                                                    }
                                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                                                                    }
                                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                                                    }
                                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                                                    }
                                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                                                                                }
                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                                                                }
                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                                                                }
                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                                                                }
                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                                                                }
                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                                                }
                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                                                }
                                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                                                                            }
                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                                                                            }
                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                                                            }
                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                                                            }
                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                                                            }
                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                                                            }
                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                                            }
                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                                            }
                                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                                                                        }
                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                                                                        }
                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                                                                        }
                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                                                        }
                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                                                        }
                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                                                        }
                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                                                        }
                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                                        }
                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                                        }
                                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                                                                    }
                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                                                                    }
                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                                                                    }
                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                                                                    }
                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                                                    }
                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                                                    }
                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                                                    }
                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                                                    }
                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                                    }
                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                                    }
                                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                                                                                }
                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                                                                }
                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                                                                }
                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                                                                }
                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                                                                }
                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                                                }
                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                                                }
                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                                                }
                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                                                }
                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                                }
                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                                }
                                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                                }
                                                                                                                            }
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                                                                            }
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                                                                            }
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                                                            }
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                                                            }
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                                                            }
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                                                            }
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                                            }
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                                            }
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                                            }
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                                            }
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                            }
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                            }
                                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                        }
                                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                        }
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                    }
                                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                    }
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                                }
                                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                                }
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                            }
                                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                            }
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                        }
                                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                        }
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                    }
                                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                    }
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                                }
                                                                                                if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                                }
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                            }
                                                                                            if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                            }
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                        }
                                                                                        if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                        }
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                    }
                                                                                    if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                    }
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                                }
                                                                                if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                                }
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                            }
                                                                            if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                            }
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                        }
                                                                        if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                        }
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                    }
                                                                    if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                    }
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                                }
                                                                if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                                }
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                            }
                                                            if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                            }
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                        }
                                                        if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                        }
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 21) || self.danmakuCount != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                    }
                                                    if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                    }
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 20) || !Duration.equals-impl0(self.duration, Duration.Companion.getZERO-UwyO8pc())) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 21) || self.danmakuCount != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                                }
                                                if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                                }
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.rotate != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 20) || !Duration.equals-impl0(self.duration, Duration.Companion.getZERO-UwyO8pc())) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 21) || self.danmakuCount != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                            }
                                            if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                            }
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.height != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.rotate != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 20) || !Duration.equals-impl0(self.duration, Duration.Companion.getZERO-UwyO8pc())) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.danmakuCount != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                        }
                                        if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                        }
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 17) || self.width != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 18) || self.height != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 19) || self.rotate != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 20) || !Duration.equals-impl0(self.duration, Duration.Companion.getZERO-UwyO8pc())) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 21) || self.danmakuCount != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                    }
                                    if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                    }
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 16) || !Intrinsics.areEqual(self.bvid, "")) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 17) || self.width != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 18) || self.height != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 19) || self.rotate != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 20) || !Duration.equals-impl0(self.duration, Duration.Companion.getZERO-UwyO8pc())) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 21) || self.danmakuCount != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                                }
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.authorMid != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 16) || !Intrinsics.areEqual(self.bvid, "")) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.width != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.height != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.rotate != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 20) || !Duration.equals-impl0(self.duration, Duration.Companion.getZERO-UwyO8pc())) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 21) || self.danmakuCount != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                            }
                            if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                            }
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 14) || !Intrinsics.areEqual(self.author, "")) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.authorMid != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 16) || !Intrinsics.areEqual(self.bvid, "")) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.width != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.height != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.rotate != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 20) || !Duration.equals-impl0(self.duration, Duration.Companion.getZERO-UwyO8pc())) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.danmakuCount != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                        }
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 13) || !Intrinsics.areEqual(self.cover, "")) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 14) || !Intrinsics.areEqual(self.author, "")) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 15) || self.authorMid != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 16) || !Intrinsics.areEqual(self.bvid, "")) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 17) || self.width != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 18) || self.height != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 19) || self.rotate != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 20) || !Duration.equals-impl0(self.duration, Duration.Companion.getZERO-UwyO8pc())) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 21) || self.danmakuCount != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                    }
                }
                if (output.shouldEncodeElementDefault(serialDesc, 12) || !Intrinsics.areEqual(self.pageTitle, "")) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 13) || !Intrinsics.areEqual(self.cover, "")) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 14) || !Intrinsics.areEqual(self.author, "")) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.authorMid != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 16) || !Intrinsics.areEqual(self.bvid, "")) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 17) || self.width != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 18) || self.height != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 19) || self.rotate != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 20) || !Duration.equals-impl0(self.duration, Duration.Companion.getZERO-UwyO8pc())) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 21) || self.danmakuCount != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
                }
            }
        }
        z = true;
        if (z) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10)) {
            if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.videoTitle, "")) {
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 11)) {
            }
            z2 = true;
            if (z2) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || !Intrinsics.areEqual(self.pageTitle, "")) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || !Intrinsics.areEqual(self.cover, "")) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || !Intrinsics.areEqual(self.author, "")) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.authorMid != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || !Intrinsics.areEqual(self.bvid, "")) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.width != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.height != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.rotate != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 20) || !Duration.equals-impl0(self.duration, Duration.Companion.getZERO-UwyO8pc())) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 21) || self.danmakuCount != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
            }
            if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.videoTitle, "")) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 11)) {
        }
        z2 = true;
        if (z2) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || !Intrinsics.areEqual(self.pageTitle, "")) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || !Intrinsics.areEqual(self.cover, "")) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || !Intrinsics.areEqual(self.author, "")) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.authorMid != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || !Intrinsics.areEqual(self.bvid, "")) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.width != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.height != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.rotate != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || !Duration.equals-impl0(self.duration, Duration.Companion.getZERO-UwyO8pc())) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.danmakuCount != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.realVideoQuality != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.preferredVideoQuality != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.qualityDisplay, "")) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 25) || !Intrinsics.areEqual(self.qualityName, "")) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.mediaType != MediaType.DASH) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 27) || !Intrinsics.areEqual(self.qnPath, "")) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.videoInfo, new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null))) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.stateValue != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 30) || self.errorCode != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 31) || self.totalSize != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 32) || self.downloadedSize != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.storagePath, "")) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 34) || self.createTime != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 35) || self.updateTime != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 36) || self.videoIndex != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 37) || self.pageIndex != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 38) || self.seasonType != SeasonType.UNKNOWN) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 39) || !Intrinsics.areEqual(self.from, "")) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 40) || self.appVersion != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 41) || !Intrinsics.areEqual(self.extended, "")) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 42) || self.authCode != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 43) || !Intrinsics.areEqual(self.link, "")) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 44) || !Intrinsics.areEqual(self.sectionsLengthList, new ArrayList())) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 45) || !Intrinsics.areEqual(self.sectionsContentTime, new ArrayList())) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 46) || !Intrinsics.areEqual(self.sectionsDownloadedList, new ArrayList())) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 47) || !Intrinsics.areEqual(self.epSortedIds, CollectionsKt.emptyList())) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 48) || self.sections != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 49) || !Intrinsics.areEqual(self.indexTitle, "")) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 50) || self.epStatus != 0) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 51) || self.triedCount != 0) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ OfflineVideoEntity(long j, String str, long j2, long j3, long j4, long j5, BizType bizType, String str2, int i, long j6, String str3, long j7, String str4, String str5, String str6, long j8, String str7, long j9, long j10, long j11, long j12, int i2, int i3, int i4, String str8, String str9, MediaType mediaType, String str10, VideoPlayInfo videoPlayInfo, int i5, int i6, long j13, long j14, String str11, long j15, long j16, long j17, long j18, SeasonType seasonType, String str12, int i7, String str13, int i8, String str14, List list, List list2, List list3, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(r5, r2, r8, r10, r12, r14, r16, r3, r4, r19, r132, r21, (i9 & 4096) != 0 ? r65 : str4, (i9 & 8192) != 0 ? r65 : str5, (i9 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? r65 : str6, (i9 & 32768) != 0 ? 0L : j8, (i9 & 65536) != 0 ? r65 : str7, (i9 & 131072) != 0 ? 0L : j9, (i9 & 262144) != 0 ? 0L : j10, (i9 & 524288) != 0 ? 0L : j11, (i9 & 1048576) != 0 ? Duration.Companion.getZERO-UwyO8pc() : j12, (i9 & 2097152) != 0 ? 0 : i2, (i9 & 4194304) != 0 ? 0 : i3, (i9 & 8388608) != 0 ? 0 : i4, (i9 & 16777216) != 0 ? r65 : str8, (i9 & 33554432) != 0 ? r65 : str9, (i9 & 67108864) != 0 ? MediaType.DASH : mediaType, (i9 & 134217728) != 0 ? r65 : str10, (i9 & 268435456) != 0 ? new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null) : videoPlayInfo, (i9 & 536870912) != 0 ? 0 : i5, (i9 & 1073741824) != 0 ? 0 : i6, (i9 & Integer.MIN_VALUE) != 0 ? 0L : j13, (i10 & 1) != 0 ? 0L : j14, (i10 & 2) != 0 ? r65 : str11, (i10 & 4) != 0 ? 0L : j15, (i10 & 8) != 0 ? 0L : j16, (i10 & 16) != 0 ? 0L : j17, (i10 & 32) != 0 ? 0L : j18, (i10 & 64) != 0 ? SeasonType.UNKNOWN : seasonType, (i10 & 128) != 0 ? r65 : str12, (i10 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? 0 : i7, (i10 & 512) != 0 ? r65 : str13, (i10 & 1024) != 0 ? 0 : i8, (i10 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? r65 : str14, (i10 & 4096) != 0 ? new ArrayList() : list, (i10 & 8192) != 0 ? new ArrayList() : list2, (i10 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? new ArrayList() : list3, null);
        String str15;
        String str16;
        long j19;
        long j20;
        long j21 = (i9 & 1) != 0 ? 0L : j;
        String str17 = (i9 & 2) != 0 ? "" : str;
        long j22 = (i9 & 4) != 0 ? 0L : j2;
        long j23 = (i9 & 8) != 0 ? 0L : j3;
        long j24 = (i9 & 16) != 0 ? 0L : j4;
        long j25 = (i9 & 32) != 0 ? 0L : j5;
        BizType bizType2 = (i9 & 64) != 0 ? BizType.UGC : bizType;
        if ((i9 & 128) != 0) {
            str15 = "";
            switch (WhenMappings.$EnumSwitchMapping$0[bizType2.ordinal()]) {
                case 1:
                    str16 = "av_" + j22 + "_" + j23;
                    break;
                case 2:
                    str16 = "ep_" + j24 + "_" + j25;
                    break;
                default:
                    str16 = "av_" + j22 + "_" + j23;
                    break;
            }
        } else {
            str15 = "";
            str16 = str2;
        }
        int i11 = (i9 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? 0 : i;
        if ((i9 & 512) != 0) {
            switch (WhenMappings.$EnumSwitchMapping$0[bizType2.ordinal()]) {
                case 1:
                default:
                    j19 = j22;
                    break;
                case 2:
                    j19 = j24;
                    break;
            }
        } else {
            j19 = j6;
        }
        String str18 = (i9 & 1024) != 0 ? str15 : str3;
        if ((i9 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0) {
            switch (WhenMappings.$EnumSwitchMapping$0[bizType2.ordinal()]) {
                case 1:
                default:
                    j20 = j23;
                    break;
                case 2:
                    j20 = j25;
                    break;
            }
        } else {
            j20 = j7;
        }
    }

    public final long getGroupId() {
        return this.groupId;
    }

    public final void setGroupId(long j) {
        this.groupId = j;
    }

    public final String getGroupTitle() {
        return this.groupTitle;
    }

    public final void setGroupTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupTitle = str;
    }

    public final long getAid() {
        return this.aid;
    }

    public final void setAid(long j) {
        this.aid = j;
    }

    public final long getCid() {
        return this.cid;
    }

    public final void setCid(long j) {
        this.cid = j;
    }

    public final long getSeasonId() {
        return this.seasonId;
    }

    public final void setSeasonId(long j) {
        this.seasonId = j;
    }

    public final long getEpisodeId() {
        return this.episodeId;
    }

    public final void setEpisodeId(long j) {
        this.episodeId = j;
    }

    public final BizType getBizType() {
        return this.bizType;
    }

    public final void setBizType(BizType bizType) {
        Intrinsics.checkNotNullParameter(bizType, "<set-?>");
        this.bizType = bizType;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public final int getVideoAttr() {
        return this.videoAttr;
    }

    public final void setVideoAttr(int i) {
        this.videoAttr = i;
    }

    public final long getVideoId() {
        return this.videoId;
    }

    public final void setVideoId(long j) {
        this.videoId = j;
    }

    public final String getVideoTitle() {
        return this.videoTitle;
    }

    public final void setVideoTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoTitle = str;
    }

    public final long getPageId() {
        return this.pageId;
    }

    public final void setPageId(long j) {
        this.pageId = j;
    }

    public final String getPageTitle() {
        return this.pageTitle;
    }

    public final void setPageTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pageTitle = str;
    }

    public final String getCover() {
        return this.cover;
    }

    public final void setCover(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cover = str;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final void setAuthor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.author = str;
    }

    public final long getAuthorMid() {
        return this.authorMid;
    }

    public final void setAuthorMid(long j) {
        this.authorMid = j;
    }

    public final String getBvid() {
        return this.bvid;
    }

    public final void setBvid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bvid = str;
    }

    public final long getWidth() {
        return this.width;
    }

    public final void setWidth(long j) {
        this.width = j;
    }

    public final long getHeight() {
        return this.height;
    }

    public final void setHeight(long j) {
        this.height = j;
    }

    public final long getRotate() {
        return this.rotate;
    }

    public final void setRotate(long j) {
        this.rotate = j;
    }

    /* renamed from: getDuration-UwyO8pc  reason: not valid java name */
    public final long m2773getDurationUwyO8pc() {
        return this.duration;
    }

    /* renamed from: setDuration-LRDsOJo  reason: not valid java name */
    public final void m2774setDurationLRDsOJo(long j) {
        this.duration = j;
    }

    public final int getDanmakuCount() {
        return this.danmakuCount;
    }

    public final void setDanmakuCount(int i) {
        this.danmakuCount = i;
    }

    public final int getRealVideoQuality() {
        return this.realVideoQuality;
    }

    public final void setRealVideoQuality(int i) {
        this.realVideoQuality = i;
    }

    public final int getPreferredVideoQuality() {
        return this.preferredVideoQuality;
    }

    public final void setPreferredVideoQuality(int i) {
        this.preferredVideoQuality = i;
    }

    public final String getQualityDisplay() {
        return this.qualityDisplay;
    }

    public final void setQualityDisplay(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qualityDisplay = str;
    }

    public final String getQualityName() {
        return this.qualityName;
    }

    public final void setQualityName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qualityName = str;
    }

    public final MediaType getMediaType() {
        return this.mediaType;
    }

    public final void setMediaType(MediaType mediaType) {
        Intrinsics.checkNotNullParameter(mediaType, "<set-?>");
        this.mediaType = mediaType;
    }

    public final String getQnPath() {
        return this.qnPath;
    }

    public final void setQnPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qnPath = str;
    }

    public final VideoPlayInfo getVideoInfo() {
        return this.videoInfo;
    }

    public final void setVideoInfo(VideoPlayInfo videoPlayInfo) {
        Intrinsics.checkNotNullParameter(videoPlayInfo, "<set-?>");
        this.videoInfo = videoPlayInfo;
    }

    public final int getStateValue() {
        return this.stateValue;
    }

    public final void setStateValue(int i) {
        this.stateValue = i;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final long getTotalSize() {
        return this.totalSize;
    }

    public final void setTotalSize(long j) {
        this.totalSize = j;
    }

    public final long getDownloadedSize() {
        return this.downloadedSize;
    }

    public final void setDownloadedSize(long j) {
        this.downloadedSize = j;
    }

    public final String getStoragePath() {
        return this.storagePath;
    }

    public final void setStoragePath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.storagePath = str;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public final long getVideoIndex() {
        return this.videoIndex;
    }

    public final void setVideoIndex(long j) {
        this.videoIndex = j;
    }

    public final long getPageIndex() {
        return this.pageIndex;
    }

    public final void setPageIndex(long j) {
        this.pageIndex = j;
    }

    public final SeasonType getSeasonType() {
        return this.seasonType;
    }

    public final void setSeasonType(SeasonType seasonType) {
        Intrinsics.checkNotNullParameter(seasonType, "<set-?>");
        this.seasonType = seasonType;
    }

    public final String getFrom() {
        return this.from;
    }

    public final void setFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.from = str;
    }

    public final int getAppVersion() {
        return this.appVersion;
    }

    public final void setAppVersion(int i) {
        this.appVersion = i;
    }

    public final String getExtended() {
        return this.extended;
    }

    public final void setExtended(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extended = str;
    }

    public final int getAuthCode() {
        return this.authCode;
    }

    public final void setAuthCode(int i) {
        this.authCode = i;
    }

    public final String getLink() {
        return this.link;
    }

    public final void setLink(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.link = str;
    }

    public final List<Long> getSectionsLengthList() {
        return this.sectionsLengthList;
    }

    public final void setSectionsLengthList(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sectionsLengthList = list;
    }

    public final List<Long> getSectionsContentTime() {
        return this.sectionsContentTime;
    }

    public final void setSectionsContentTime(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sectionsContentTime = list;
    }

    public final List<Long> getSectionsDownloadedList() {
        return this.sectionsDownloadedList;
    }

    public final void setSectionsDownloadedList(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sectionsDownloadedList = list;
    }

    public final List<String> getEpSortedIds() {
        return this.epSortedIds;
    }

    public final void setEpSortedIds(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.epSortedIds = list;
    }

    public final int getSections() {
        return this.sections;
    }

    public final void setSections(int i) {
        this.sections = i;
    }

    public final String getIndexTitle() {
        return this.indexTitle;
    }

    public final void setIndexTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.indexTitle = str;
    }

    public final int getEpStatus() {
        return this.epStatus;
    }

    public final void setEpStatus(int i) {
        this.epStatus = i;
    }

    public final int getTriedCount() {
        return this.triedCount;
    }

    public final void setTriedCount(int i) {
        this.triedCount = i;
    }

    public final State getState() {
        switch (this.stateValue) {
            case 0:
                return State.IDLE.INSTANCE;
            case 1:
                return new State.PAUSED(this.downloadedSize, this.totalSize);
            case 2:
                return State.PENDING.INSTANCE;
            case 3:
                return State.RESOLVING.INSTANCE;
            case 4:
                return new State.DOWNLOADING(this.downloadedSize, this.totalSize);
            case 5:
                return State.COMPLETED.INSTANCE;
            case 6:
                return new State.ERROR(this.errorCode);
            default:
                return new State.ERROR(this.errorCode);
        }
    }

    public final void setState(State value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.stateValue = value.getStateValue();
        if (value instanceof State.ERROR) {
            this.errorCode = ((State.ERROR) value).getCode();
        } else if (value instanceof State.DOWNLOADING) {
            this.downloadedSize = ((State.DOWNLOADING) value).getCurrent();
        } else if (value instanceof State.PAUSED) {
            this.downloadedSize = ((State.PAUSED) value).getCurrent();
        } else if (value instanceof State.COMPLETED) {
            this.downloadedSize = this.totalSize;
        }
    }

    public final long getDurationInSeconds() {
        return Duration.getInWholeSeconds-impl(this.duration);
    }

    public final Object getDisplaySubtitle(Continuation<? super String> continuation) {
        String str;
        if (WhenMappings.$EnumSwitchMapping$0[this.bizType.ordinal()] == 2) {
            StringBuilder builder = new StringBuilder();
            if (VBStriingExtKt.isDigitsOnly(this.videoTitle)) {
                if (this.seasonType == SeasonType.BANGUMI || this.seasonType == SeasonType.CN_BANGUMI) {
                    builder.append(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_232(PlayerbaseresRes.INSTANCE.getString()), new Object[]{this.videoTitle}));
                } else {
                    builder.append(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2278(PlayerbaseresRes.INSTANCE.getString()), new Object[]{this.videoTitle}));
                }
            } else {
                builder.append(this.videoTitle);
            }
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(this.pageTitle);
            str = builder.toString();
        } else {
            str = this.pageTitle;
        }
        Intrinsics.checkNotNull(str);
        return str;
    }

    /* compiled from: OfflineVideoEntity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J&\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r¨\u0006\u000e"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$Companion;", "", "<init>", "()V", "avEmptyModel", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "aid", "", "cid", "epEmptyModel", "seasonId", "episodeId", "serializer", "Lkotlinx/serialization/KSerializer;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OfflineVideoEntity> serializer() {
            return new GeneratedSerializer<OfflineVideoEntity>() { // from class: video.biz.offline.base.model.entity.OfflineVideoEntity$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.base.model.entity.OfflineVideoEntity", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<video.biz.offline.base.model.entity.OfflineVideoEntity> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<video.biz.offline.base.model.entity.OfflineVideoEntity> A[REMOVE]) =  video.biz.offline.base.model.entity.OfflineVideoEntity$$serializer.INSTANCE video.biz.offline.base.model.entity.OfflineVideoEntity$$serializer)
                         in method: video.biz.offline.base.model.entity.OfflineVideoEntity.Companion.serializer():kotlinx.serialization.KSerializer<video.biz.offline.base.model.entity.OfflineVideoEntity>, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.util.ArrayList.forEach(ArrayList.java:1257)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:309)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                          ("video.biz.offline.base.model.entity.OfflineVideoEntity")
                          (wrap: video.biz.offline.base.model.entity.OfflineVideoEntity$$serializer : 0x0009: SGET  (r1v0 video.biz.offline.base.model.entity.OfflineVideoEntity$$serializer A[REMOVE]) =  video.biz.offline.base.model.entity.OfflineVideoEntity$$serializer.INSTANCE video.biz.offline.base.model.entity.OfflineVideoEntity$$serializer)
                          (52 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: video.biz.offline.base.model.entity.OfflineVideoEntity$$serializer.<clinit>():void, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: video.biz.offline.base.model.entity.OfflineVideoEntity$$serializer
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:775)
                        	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:765)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                        	... 15 more
                        */
                    /*
                        this = this;
                        video.biz.offline.base.model.entity.OfflineVideoEntity$$serializer r0 = video.biz.offline.base.model.entity.OfflineVideoEntity$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: video.biz.offline.base.model.entity.OfflineVideoEntity.Companion.serializer():kotlinx.serialization.KSerializer");
                }

                public final OfflineVideoEntity avEmptyModel(long aid, long cid) {
                    return new OfflineVideoEntity(0L, "", aid, cid, 0L, 0L, BizType.UGC, null, 0, 0L, null, 0L, null, null, null, 0L, null, 0L, 0L, 0L, 0L, 0, 0, 0, null, null, null, null, null, 0, 0, 0L, 0L, null, 0L, 0L, 0L, 0L, null, null, 0, null, 0, null, null, null, null, -128, 32767, null);
                }

                public final OfflineVideoEntity epEmptyModel(long aid, long cid, long seasonId, long episodeId) {
                    return new OfflineVideoEntity(0L, "", aid, cid, seasonId, episodeId, BizType.OGV, null, 0, 0L, null, 0L, null, null, null, 0L, null, 0L, 0L, 0L, 0L, 0, 0, 0, null, null, null, null, null, 0, 0, 0L, 0L, null, 0L, 0L, 0L, 0L, null, null, 0, null, 0, null, null, null, null, -128, 32767, null);
                }
            }

            public final String getProgressDesc() {
                String fileSize = VBNumberExtKt.toFileSize(this.downloadedSize);
                return fileSize + EntryScannerKt.PATH_SEPARATOR + VBNumberExtKt.toFileSize(this.totalSize);
            }

            public final String getLinkStr() {
                String str = this.link;
                if (StringsKt.isBlank(str)) {
                    str = "bilibili://video/" + this.aid + "?cid=" + this.cid;
                }
                return str;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (other instanceof OfflineVideoEntity) {
                    return Intrinsics.areEqual(this.key, ((OfflineVideoEntity) other).key);
                }
                return super.equals(other);
            }

            public final boolean getCanPlay() {
                Long l = (Long) CollectionsKt.firstOrNull(this.sectionsDownloadedList);
                long videoDownloaded = l != null ? l.longValue() : this.downloadedSize;
                Long l2 = (Long) CollectionsKt.firstOrNull(this.sectionsLengthList);
                long videoAll = l2 != null ? l2.longValue() : this.totalSize;
                return this.totalSize > 0 && ((long) 5) * videoDownloaded >= videoAll;
            }

            public final int getProgressPercentage() {
                if (this.totalSize > 0) {
                    return (int) ((this.downloadedSize * 100) / this.totalSize);
                }
                return 0;
            }

            public final String getDownloadDesc() {
                State state = getState();
                if (Intrinsics.areEqual(state, State.IDLE.INSTANCE)) {
                    return PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2229(PlayerbaseresRes.INSTANCE.getString()));
                }
                if (state instanceof State.PAUSED) {
                    String string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2208(PlayerbaseresRes.INSTANCE.getString()));
                    return string + " " + getProgressDesc();
                } else if (Intrinsics.areEqual(state, State.PENDING.INSTANCE)) {
                    return PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2220(PlayerbaseresRes.INSTANCE.getString()));
                } else {
                    if (Intrinsics.areEqual(state, State.RESOLVING.INSTANCE)) {
                        return PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2234(PlayerbaseresRes.INSTANCE.getString()));
                    }
                    if (state instanceof State.DOWNLOADING) {
                        String string2 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2204(PlayerbaseresRes.INSTANCE.getString()));
                        return string2 + " " + getProgressDesc();
                    } else if (Intrinsics.areEqual(state, State.COMPLETED.INSTANCE)) {
                        return VBNumberExtKt.toFileSize(this.downloadedSize);
                    } else {
                        if (state instanceof State.ERROR) {
                            return PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2196(PlayerbaseresRes.INSTANCE.getString()));
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }

            public final boolean getDownloaded() {
                return Intrinsics.areEqual(getState(), State.COMPLETED.INSTANCE);
            }

            public final boolean isDownloading() {
                return getState().isDownloading();
            }

            public final boolean isVipQuality() {
                if (WhenMappings.$EnumSwitchMapping$0[this.bizType.ordinal()] == 2) {
                    return AuthCodeKt.isOgvVip(AuthCodeKt.toAuthCode(this.authCode));
                }
                return OfflineConfigKt.getVipQualities().contains(Integer.valueOf(this.realVideoQuality));
            }

            public final boolean isDolbyAudio() {
                DolbyType dolbyType = DolbyType.Companion.from(this.videoInfo.getAudioType());
                return dolbyType != DolbyType.NOTDOLBY;
            }

            public final boolean isVip() {
                return isVipQuality() || isDolbyAudio();
            }

            public final String getNotifyBody() {
                switch (WhenMappings.$EnumSwitchMapping$0[this.bizType.ordinal()]) {
                    case 1:
                        if (hitAttr(VideoAttr.DramaVideo)) {
                            String str = this.groupTitle;
                            return str + " " + this.pageTitle;
                        } else if (Intrinsics.areEqual(this.videoTitle, this.pageTitle)) {
                            return this.videoTitle;
                        } else {
                            String str2 = this.videoTitle;
                            return str2 + " " + this.pageTitle;
                        }
                    case 2:
                        String str3 = this.groupTitle;
                        return str3 + " " + this.videoTitle;
                    default:
                        return this.videoTitle;
                }
            }

            public final long getVideoSize() {
                Long l = (Long) CollectionsKt.firstOrNull(this.sectionsLengthList);
                if (l != null) {
                    return l.longValue();
                }
                return 0L;
            }

            public final long getAudioSize() {
                Long l = (Long) CollectionsKt.getOrNull(this.sectionsLengthList, 1);
                if (l != null) {
                    return l.longValue();
                }
                return 0L;
            }

            public final boolean isValid() {
                switch (WhenMappings.$EnumSwitchMapping$0[this.bizType.ordinal()]) {
                    case 1:
                        return this.aid > 0 && this.cid > 0;
                    case 2:
                        return this.seasonId > 0 && this.episodeId > 0;
                    default:
                        return false;
                }
            }

            public final boolean hitAttr(VideoAttr attr) {
                Intrinsics.checkNotNullParameter(attr, "attr");
                return attr.hitIn(this.videoAttr);
            }

            public final void addAttr(VideoAttr attr) {
                Intrinsics.checkNotNullParameter(attr, "attr");
                this.videoAttr |= attr.getValue();
            }

            /* compiled from: OfflineVideoEntity.kt */
            @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\r\u000e\u000f\u0010\u0011\u0012\u0013B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0007\u0014\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "", "<init>", "()V", "isDownloading", "", "()Z", "stateValue", "", "getStateValue", "()I", "toString", "", "IDLE", "PAUSED", "PENDING", "RESOLVING", "DOWNLOADING", "COMPLETED", "ERROR", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State$COMPLETED;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State$DOWNLOADING;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State$ERROR;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State$IDLE;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State$PAUSED;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State$PENDING;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State$RESOLVING;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static abstract class State {
                public static final int $stable = 0;

                public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                /* compiled from: OfflineVideoEntity.kt */
                @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State$IDLE;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class IDLE extends State {
                    public static final int $stable = 0;
                    public static final IDLE INSTANCE = new IDLE();

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof IDLE) {
                            IDLE idle = (IDLE) obj;
                            return true;
                        }
                        return false;
                    }

                    public int hashCode() {
                        return 1533477314;
                    }

                    @Override // video.biz.offline.base.model.entity.OfflineVideoEntity.State
                    public String toString() {
                        return "IDLE";
                    }

                    private IDLE() {
                        super(null);
                    }
                }

                private State() {
                }

                /* compiled from: OfflineVideoEntity.kt */
                @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State$PAUSED;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "current", "", "total", "<init>", "(JJ)V", "getCurrent", "()J", "getTotal", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class PAUSED extends State {
                    public static final int $stable = 0;
                    private final long current;
                    private final long total;

                    public static /* synthetic */ PAUSED copy$default(PAUSED paused, long j, long j2, int i, Object obj) {
                        if ((i & 1) != 0) {
                            j = paused.current;
                        }
                        if ((i & 2) != 0) {
                            j2 = paused.total;
                        }
                        return paused.copy(j, j2);
                    }

                    public final long component1() {
                        return this.current;
                    }

                    public final long component2() {
                        return this.total;
                    }

                    public final PAUSED copy(long j, long j2) {
                        return new PAUSED(j, j2);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof PAUSED) {
                            PAUSED paused = (PAUSED) obj;
                            return this.current == paused.current && this.total == paused.total;
                        }
                        return false;
                    }

                    public int hashCode() {
                        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.current) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.total);
                    }

                    @Override // video.biz.offline.base.model.entity.OfflineVideoEntity.State
                    public String toString() {
                        long j = this.current;
                        return "PAUSED(current=" + j + ", total=" + this.total + ")";
                    }

                    public PAUSED(long current, long total) {
                        super(null);
                        this.current = current;
                        this.total = total;
                    }

                    public final long getCurrent() {
                        return this.current;
                    }

                    public final long getTotal() {
                        return this.total;
                    }
                }

                /* compiled from: OfflineVideoEntity.kt */
                @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State$PENDING;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class PENDING extends State {
                    public static final int $stable = 0;
                    public static final PENDING INSTANCE = new PENDING();

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof PENDING) {
                            PENDING pending = (PENDING) obj;
                            return true;
                        }
                        return false;
                    }

                    public int hashCode() {
                        return 203611337;
                    }

                    @Override // video.biz.offline.base.model.entity.OfflineVideoEntity.State
                    public String toString() {
                        return "PENDING";
                    }

                    private PENDING() {
                        super(null);
                    }
                }

                /* compiled from: OfflineVideoEntity.kt */
                @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State$RESOLVING;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class RESOLVING extends State {
                    public static final int $stable = 0;
                    public static final RESOLVING INSTANCE = new RESOLVING();

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof RESOLVING) {
                            RESOLVING resolving = (RESOLVING) obj;
                            return true;
                        }
                        return false;
                    }

                    public int hashCode() {
                        return -757457317;
                    }

                    @Override // video.biz.offline.base.model.entity.OfflineVideoEntity.State
                    public String toString() {
                        return "RESOLVING";
                    }

                    private RESOLVING() {
                        super(null);
                    }
                }

                /* compiled from: OfflineVideoEntity.kt */
                @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State$DOWNLOADING;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "current", "", "total", "<init>", "(JJ)V", "getCurrent", "()J", "getTotal", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class DOWNLOADING extends State {
                    public static final int $stable = 0;
                    private final long current;
                    private final long total;

                    public static /* synthetic */ DOWNLOADING copy$default(DOWNLOADING downloading, long j, long j2, int i, Object obj) {
                        if ((i & 1) != 0) {
                            j = downloading.current;
                        }
                        if ((i & 2) != 0) {
                            j2 = downloading.total;
                        }
                        return downloading.copy(j, j2);
                    }

                    public final long component1() {
                        return this.current;
                    }

                    public final long component2() {
                        return this.total;
                    }

                    public final DOWNLOADING copy(long j, long j2) {
                        return new DOWNLOADING(j, j2);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof DOWNLOADING) {
                            DOWNLOADING downloading = (DOWNLOADING) obj;
                            return this.current == downloading.current && this.total == downloading.total;
                        }
                        return false;
                    }

                    public int hashCode() {
                        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.current) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.total);
                    }

                    @Override // video.biz.offline.base.model.entity.OfflineVideoEntity.State
                    public String toString() {
                        long j = this.current;
                        return "DOWNLOADING(current=" + j + ", total=" + this.total + ")";
                    }

                    public DOWNLOADING(long current, long total) {
                        super(null);
                        this.current = current;
                        this.total = total;
                    }

                    public final long getCurrent() {
                        return this.current;
                    }

                    public final long getTotal() {
                        return this.total;
                    }
                }

                /* compiled from: OfflineVideoEntity.kt */
                @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State$COMPLETED;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class COMPLETED extends State {
                    public static final int $stable = 0;
                    public static final COMPLETED INSTANCE = new COMPLETED();

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof COMPLETED) {
                            COMPLETED completed = (COMPLETED) obj;
                            return true;
                        }
                        return false;
                    }

                    public int hashCode() {
                        return -169131779;
                    }

                    @Override // video.biz.offline.base.model.entity.OfflineVideoEntity.State
                    public String toString() {
                        return "COMPLETED";
                    }

                    private COMPLETED() {
                        super(null);
                    }
                }

                /* compiled from: OfflineVideoEntity.kt */
                @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State$ERROR;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "code", "", "<init>", "(I)V", "getCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class ERROR extends State {
                    public static final int $stable = 0;
                    private final int code;

                    public static /* synthetic */ ERROR copy$default(ERROR error, int i, int i2, Object obj) {
                        if ((i2 & 1) != 0) {
                            i = error.code;
                        }
                        return error.copy(i);
                    }

                    public final int component1() {
                        return this.code;
                    }

                    public final ERROR copy(int i) {
                        return new ERROR(i);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof ERROR) && this.code == ((ERROR) obj).code;
                    }

                    public int hashCode() {
                        return this.code;
                    }

                    @Override // video.biz.offline.base.model.entity.OfflineVideoEntity.State
                    public String toString() {
                        return "ERROR(code=" + this.code + ")";
                    }

                    public ERROR(int code) {
                        super(null);
                        this.code = code;
                    }

                    public final int getCode() {
                        return this.code;
                    }
                }

                public final boolean isDownloading() {
                    return (this instanceof DOWNLOADING) || (this instanceof PENDING) || (this instanceof RESOLVING);
                }

                public final int getStateValue() {
                    if (this instanceof IDLE) {
                        return 0;
                    }
                    if (this instanceof PAUSED) {
                        return 1;
                    }
                    if (this instanceof PENDING) {
                        return 2;
                    }
                    if (this instanceof RESOLVING) {
                        return 3;
                    }
                    if (this instanceof DOWNLOADING) {
                        return 4;
                    }
                    if (this instanceof COMPLETED) {
                        return 5;
                    }
                    if (this instanceof ERROR) {
                        return 6;
                    }
                    throw new NoWhenBranchMatchedException();
                }

                public String toString() {
                    if (this instanceof IDLE) {
                        return "IDLE";
                    }
                    if (this instanceof PAUSED) {
                        String fileSize = VBNumberExtKt.toFileSize(((PAUSED) this).getCurrent());
                        return "PAUSED " + fileSize + EntryScannerKt.PATH_SEPARATOR + VBNumberExtKt.toFileSize(((PAUSED) this).getTotal());
                    } else if (this instanceof PENDING) {
                        return "PENDING";
                    } else {
                        if (this instanceof RESOLVING) {
                            return "RESOLVING";
                        }
                        if (this instanceof DOWNLOADING) {
                            String fileSize2 = VBNumberExtKt.toFileSize(((DOWNLOADING) this).getCurrent());
                            return "DOWNLOADING " + fileSize2 + EntryScannerKt.PATH_SEPARATOR + VBNumberExtKt.toFileSize(((DOWNLOADING) this).getTotal());
                        } else if (this instanceof COMPLETED) {
                            return "COMPLETED";
                        } else {
                            if (this instanceof ERROR) {
                                return String.valueOf(((ERROR) this).getCode());
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
            }

            /* compiled from: OfflineVideoEntity.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0013\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;", "", "seasonType", "", "<init>", "(Ljava/lang/String;II)V", "getSeasonType", "()I", "UNKNOWN", "BANGUMI", "MOVIE", "DOCUMENTARY", "CN_BANGUMI", "TV_SERIES", "VARIETY", "Companion", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public enum SeasonType {
                UNKNOWN(0),
                BANGUMI(1),
                MOVIE(2),
                DOCUMENTARY(3),
                CN_BANGUMI(4),
                TV_SERIES(5),
                VARIETY(7);
                
                private final int seasonType;
                private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
                public static final Companion Companion = new Companion(null);

                public static EnumEntries<SeasonType> getEntries() {
                    return $ENTRIES;
                }

                SeasonType(int seasonType) {
                    this.seasonType = seasonType;
                }

                /* synthetic */ SeasonType(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i2 & 1) != 0 ? 0 : i);
                }

                public final int getSeasonType() {
                    return this.seasonType;
                }

                /* compiled from: OfflineVideoEntity.kt */
                @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType$Companion;", "", "<init>", "()V", "from", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;", "value", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final SeasonType from(int value) {
                        Object element$iv;
                        boolean z;
                        Iterable $this$firstOrNull$iv = SeasonType.getEntries();
                        Iterator it = $this$firstOrNull$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                SeasonType it2 = (SeasonType) element$iv;
                                if (it2.getSeasonType() == value) {
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
                        SeasonType seasonType = (SeasonType) element$iv;
                        return seasonType == null ? SeasonType.UNKNOWN : seasonType;
                    }
                }
            }

            /* compiled from: OfflineVideoEntity.kt */
            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$VideoAttr;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Migration", "ChargingPay", "DramaVideo", "hitIn", "", "flags", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public enum VideoAttr {
                Migration(1),
                ChargingPay(2),
                DramaVideo(4);
                
                private final int value;
                private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

                public static EnumEntries<VideoAttr> getEntries() {
                    return $ENTRIES;
                }

                VideoAttr(int value) {
                    this.value = value;
                }

                public final int getValue() {
                    return this.value;
                }

                public final boolean hitIn(int flags) {
                    return (this.value & flags) != 0;
                }
            }

            /* compiled from: OfflineVideoEntity.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0013\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$DolbyType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "NOTDOLBY", "DOLBYNORMAL", "DOLBYATMOS", "Companion", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public enum DolbyType {
                NOTDOLBY(0),
                DOLBYNORMAL(1),
                DOLBYATMOS(2);
                
                private final int type;
                private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
                public static final Companion Companion = new Companion(null);

                public static EnumEntries<DolbyType> getEntries() {
                    return $ENTRIES;
                }

                DolbyType(int type) {
                    this.type = type;
                }

                /* synthetic */ DolbyType(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i2 & 1) != 0 ? 0 : i);
                }

                public final int getType() {
                    return this.type;
                }

                /* compiled from: OfflineVideoEntity.kt */
                @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$DolbyType$Companion;", "", "<init>", "()V", "from", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$DolbyType;", "value", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final DolbyType from(int value) {
                        Object element$iv;
                        boolean z;
                        Iterable $this$firstOrNull$iv = DolbyType.getEntries();
                        Iterator it = $this$firstOrNull$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                DolbyType it2 = (DolbyType) element$iv;
                                if (it2.getType() == value) {
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
                        DolbyType dolbyType = (DolbyType) element$iv;
                        return dolbyType == null ? DolbyType.NOTDOLBY : dolbyType;
                    }
                }
            }

            public int hashCode() {
                return Reflection.getOrCreateKotlinClass(getClass()).hashCode();
            }

            public String toString() {
                String str = this.key;
                int i = this.videoAttr;
                BizType bizType = this.bizType;
                long j = this.createTime;
                String str2 = this.groupTitle;
                String str3 = this.videoTitle;
                String str4 = this.pageTitle;
                return "[" + str + "] [" + i + "] [" + bizType + "] [" + j + "] [" + str2 + "] [" + str3 + "] [" + str4 + "] [" + getState() + "]";
            }
        }