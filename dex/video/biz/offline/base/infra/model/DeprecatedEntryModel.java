package video.biz.offline.base.infra.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;
import video.biz.offline.base.infra.utils.ExtensionKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: DeprecatedEntryModel.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bM\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ®\u00012\u00020\u0001:\u0004\u00ad\u0001®\u0001Bß\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\b\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\b\b\u0002\u0010!\u001a\u00020\b\u0012\b\b\u0002\u0010\"\u001a\u00020\u000b\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020\u000b¢\u0006\u0004\b*\u0010+B½\u0002\b\u0010\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010!\u001a\u00020\b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010#\u001a\u00020\u0005\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010&\u0012\b\u0010'\u001a\u0004\u0018\u00010(\u0012\b\u0010.\u001a\u0004\u0018\u00010/¢\u0006\u0004\b*\u00100J\u0006\u0010|\u001a\u00020}J\t\u0010~\u001a\u00020\u0003HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010&HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010(HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u000bHÆ\u0003Jâ\u0002\u0010 \u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u000bHÆ\u0001J\u0015\u0010¡\u0001\u001a\u00020\u00052\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010£\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010¤\u0001\u001a\u00020\u000bHÖ\u0001J-\u0010¥\u0001\u001a\u00030¦\u00012\u0007\u0010§\u0001\u001a\u00020\u00002\b\u0010¨\u0001\u001a\u00030©\u00012\b\u0010ª\u0001\u001a\u00030«\u0001H\u0001¢\u0006\u0003\b¬\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u00102\u001a\u0004\b6\u00107R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u00102\u001a\u0004\b\u0006\u00107R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u00102\u001a\u0004\b:\u0010;R\u001c\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u00102\u001a\u0004\b=\u0010;R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u00102\u001a\u0004\b?\u0010@R\u001c\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u00102\u001a\u0004\bB\u0010@R\u001c\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u00102\u001a\u0004\bD\u0010@R\u001c\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u00102\u001a\u0004\bF\u00104R\u001c\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u00102\u001a\u0004\bH\u00104R\u001c\u0010\u0010\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u00102\u001a\u0004\bJ\u0010;R\u001c\u0010\u0011\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u00102\u001a\u0004\bL\u0010;R\u001c\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u00102\u001a\u0004\bN\u00104R\u001c\u0010\u0013\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u00102\u001a\u0004\bP\u0010;R\u001c\u0010\u0014\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bQ\u00102\u001a\u0004\bR\u0010;R\u001c\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bS\u00102\u001a\u0004\bT\u00107R\u001c\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u00102\u001a\u0004\bV\u00107R\u001c\u0010\u0017\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bW\u00102\u001a\u0004\bX\u0010@R\u001c\u0010\u0018\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bY\u00102\u001a\u0004\bZ\u0010@R\u001c\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b[\u00102\u001a\u0004\b\\\u00107R\u001c\u0010\u001a\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b]\u00102\u001a\u0004\b^\u00104R\u001c\u0010\u001b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b_\u00102\u001a\u0004\b`\u00104R\u001c\u0010\u001c\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\ba\u00102\u001a\u0004\bb\u00104R\u001c\u0010\u001d\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bc\u00102\u001a\u0004\bd\u0010;R\u001c\u0010\u001e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\be\u00102\u001a\u0004\bf\u00104R\u001c\u0010\u001f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bg\u00102\u001a\u0004\bh\u0010;R\u001c\u0010 \u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bi\u00102\u001a\u0004\bj\u0010@R\u001c\u0010!\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bk\u00102\u001a\u0004\bl\u0010;R\u001c\u0010\"\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bm\u00102\u001a\u0004\bn\u0010@R\u001c\u0010#\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bo\u00102\u001a\u0004\b#\u00107R\u001c\u0010$\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bp\u00102\u001a\u0004\bq\u00104R\u001e\u0010%\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\br\u00102\u001a\u0004\bs\u0010tR\u001e\u0010'\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bu\u00102\u001a\u0004\bv\u0010wR$\u0010)\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bx\u00102\u001a\u0004\by\u0010@\"\u0004\bz\u0010{¨\u0006¯\u0001"}, d2 = {"Lvideo/biz/offline/base/infra/model/DeprecatedEntryModel;", "", "mediaType", "", "hasDashAudio", "", "isCompleted", "totalBytes", "", "downloadedBytes", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "typeTag", RankRouter.BundleKey.VIDEO_DETAIL_COVER, "videoQuality", "preferedVideoQuality", "guessedTotalBytes", "totalTimeMilli", "danmakuCount", "timeUpdateStamp", "timeCreateStamp", "canPlayInAdvance", "interruptTransformTempFile", "qualityPithyDescription", "qualitySuperscript", "variableResolutionRatio", "cacheVersionCode", "preferredAudioQuality", "audioQuality", "avid", "spid", "seasonId", "bvid", "ownerId", "ownerName", "isChargeVideo", "verificationCode", "pageData", "Lvideo/biz/offline/base/infra/model/DeprecatedPageModel;", "ep", "Lvideo/biz/offline/base/infra/model/DeprecatedEpisodeModel;", "storagePath", "<init>", "(IZZJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJJIJJZZLjava/lang/String;Ljava/lang/String;ZIIIJIJLjava/lang/String;JLjava/lang/String;ZILvideo/biz/offline/base/infra/model/DeprecatedPageModel;Lvideo/biz/offline/base/infra/model/DeprecatedEpisodeModel;Ljava/lang/String;)V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIZZJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJJIJJZZLjava/lang/String;Ljava/lang/String;ZIIIJIJLjava/lang/String;JLjava/lang/String;ZILvideo/biz/offline/base/infra/model/DeprecatedPageModel;Lvideo/biz/offline/base/infra/model/DeprecatedEpisodeModel;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMediaType$annotations", "()V", "getMediaType", "()I", "getHasDashAudio$annotations", "getHasDashAudio", "()Z", "isCompleted$annotations", "getTotalBytes$annotations", "getTotalBytes", "()J", "getDownloadedBytes$annotations", "getDownloadedBytes", "getTitle$annotations", "getTitle", "()Ljava/lang/String;", "getTypeTag$annotations", "getTypeTag", "getCover$annotations", "getCover", "getVideoQuality$annotations", "getVideoQuality", "getPreferedVideoQuality$annotations", "getPreferedVideoQuality", "getGuessedTotalBytes$annotations", "getGuessedTotalBytes", "getTotalTimeMilli$annotations", "getTotalTimeMilli", "getDanmakuCount$annotations", "getDanmakuCount", "getTimeUpdateStamp$annotations", "getTimeUpdateStamp", "getTimeCreateStamp$annotations", "getTimeCreateStamp", "getCanPlayInAdvance$annotations", "getCanPlayInAdvance", "getInterruptTransformTempFile$annotations", "getInterruptTransformTempFile", "getQualityPithyDescription$annotations", "getQualityPithyDescription", "getQualitySuperscript$annotations", "getQualitySuperscript", "getVariableResolutionRatio$annotations", "getVariableResolutionRatio", "getCacheVersionCode$annotations", "getCacheVersionCode", "getPreferredAudioQuality$annotations", "getPreferredAudioQuality", "getAudioQuality$annotations", "getAudioQuality", "getAvid$annotations", "getAvid", "getSpid$annotations", "getSpid", "getSeasonId$annotations", "getSeasonId", "getBvid$annotations", "getBvid", "getOwnerId$annotations", "getOwnerId", "getOwnerName$annotations", "getOwnerName", "isChargeVideo$annotations", "getVerificationCode$annotations", "getVerificationCode", "getPageData$annotations", "getPageData", "()Lvideo/biz/offline/base/infra/model/DeprecatedPageModel;", "getEp$annotations", "getEp", "()Lvideo/biz/offline/base/infra/model/DeprecatedEpisodeModel;", "getStoragePath$annotations", "getStoragePath", "setStoragePath", "(Ljava/lang/String;)V", "transform", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$infra_debug", "$serializer", "Companion", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class DeprecatedEntryModel {
    private final int audioQuality;
    private final long avid;
    private final String bvid;
    private final int cacheVersionCode;
    private final boolean canPlayInAdvance;
    private final String cover;
    private final int danmakuCount;
    private final long downloadedBytes;
    private final DeprecatedEpisodeModel ep;
    private final long guessedTotalBytes;
    private final boolean hasDashAudio;
    private final boolean interruptTransformTempFile;
    private final boolean isChargeVideo;
    private final boolean isCompleted;
    private final int mediaType;
    private final long ownerId;
    private final String ownerName;
    private final DeprecatedPageModel pageData;
    private final int preferedVideoQuality;
    private final int preferredAudioQuality;
    private final String qualityPithyDescription;
    private final String qualitySuperscript;
    private final long seasonId;
    private final int spid;
    private String storagePath;
    private final long timeCreateStamp;
    private final long timeUpdateStamp;
    private final String title;
    private final long totalBytes;
    private final long totalTimeMilli;
    private final String typeTag;
    private final boolean variableResolutionRatio;
    private final int verificationCode;
    private final int videoQuality;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DeprecatedEntryModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflineVideoEntity.BizType.values().length];
            try {
                iArr[OfflineVideoEntity.BizType.OGV.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DeprecatedEntryModel() {
        this(0, false, false, 0L, 0L, null, null, null, 0, 0, 0L, 0L, 0, 0L, 0L, false, false, null, null, false, 0, 0, 0, 0L, 0, 0L, null, 0L, null, false, 0, null, null, null, -1, 3, null);
    }

    @SerialName("audio_quality")
    public static /* synthetic */ void getAudioQuality$annotations() {
    }

    @SerialName("avid")
    public static /* synthetic */ void getAvid$annotations() {
    }

    @SerialName("bvid")
    public static /* synthetic */ void getBvid$annotations() {
    }

    @SerialName("cache_version_code")
    public static /* synthetic */ void getCacheVersionCode$annotations() {
    }

    @SerialName("can_play_in_advance")
    public static /* synthetic */ void getCanPlayInAdvance$annotations() {
    }

    @SerialName(RankRouter.BundleKey.VIDEO_DETAIL_COVER)
    public static /* synthetic */ void getCover$annotations() {
    }

    @SerialName("danmaku_count")
    public static /* synthetic */ void getDanmakuCount$annotations() {
    }

    @SerialName("downloaded_bytes")
    public static /* synthetic */ void getDownloadedBytes$annotations() {
    }

    @SerialName("ep")
    public static /* synthetic */ void getEp$annotations() {
    }

    @SerialName("guessed_total_bytes")
    public static /* synthetic */ void getGuessedTotalBytes$annotations() {
    }

    @SerialName("has_dash_audio")
    public static /* synthetic */ void getHasDashAudio$annotations() {
    }

    @SerialName("interrupt_transform_temp_file")
    public static /* synthetic */ void getInterruptTransformTempFile$annotations() {
    }

    @SerialName("media_type")
    public static /* synthetic */ void getMediaType$annotations() {
    }

    @SerialName("owner_id")
    public static /* synthetic */ void getOwnerId$annotations() {
    }

    @SerialName("owner_name")
    public static /* synthetic */ void getOwnerName$annotations() {
    }

    @SerialName("page_data")
    public static /* synthetic */ void getPageData$annotations() {
    }

    @SerialName("prefered_video_quality")
    public static /* synthetic */ void getPreferedVideoQuality$annotations() {
    }

    @SerialName("preferred_audio_quality")
    public static /* synthetic */ void getPreferredAudioQuality$annotations() {
    }

    @SerialName("quality_pithy_description")
    public static /* synthetic */ void getQualityPithyDescription$annotations() {
    }

    @SerialName("quality_superscript")
    public static /* synthetic */ void getQualitySuperscript$annotations() {
    }

    @SerialName("season_id")
    public static /* synthetic */ void getSeasonId$annotations() {
    }

    @SerialName("spid")
    public static /* synthetic */ void getSpid$annotations() {
    }

    @Transient
    public static /* synthetic */ void getStoragePath$annotations() {
    }

    @SerialName("time_create_stamp")
    public static /* synthetic */ void getTimeCreateStamp$annotations() {
    }

    @SerialName("time_update_stamp")
    public static /* synthetic */ void getTimeUpdateStamp$annotations() {
    }

    @SerialName(RankRouter.BundleKey.ACTION_PARAM_TITLE)
    public static /* synthetic */ void getTitle$annotations() {
    }

    @SerialName("total_bytes")
    public static /* synthetic */ void getTotalBytes$annotations() {
    }

    @SerialName("total_time_milli")
    public static /* synthetic */ void getTotalTimeMilli$annotations() {
    }

    @SerialName("type_tag")
    public static /* synthetic */ void getTypeTag$annotations() {
    }

    @SerialName("variable_resolution_ratio")
    public static /* synthetic */ void getVariableResolutionRatio$annotations() {
    }

    @SerialName("verification_code")
    public static /* synthetic */ void getVerificationCode$annotations() {
    }

    @SerialName("video_quality")
    public static /* synthetic */ void getVideoQuality$annotations() {
    }

    @SerialName("is_charge_video")
    public static /* synthetic */ void isChargeVideo$annotations() {
    }

    @SerialName("is_completed")
    public static /* synthetic */ void isCompleted$annotations() {
    }

    public final int component1() {
        return this.mediaType;
    }

    public final int component10() {
        return this.preferedVideoQuality;
    }

    public final long component11() {
        return this.guessedTotalBytes;
    }

    public final long component12() {
        return this.totalTimeMilli;
    }

    public final int component13() {
        return this.danmakuCount;
    }

    public final long component14() {
        return this.timeUpdateStamp;
    }

    public final long component15() {
        return this.timeCreateStamp;
    }

    public final boolean component16() {
        return this.canPlayInAdvance;
    }

    public final boolean component17() {
        return this.interruptTransformTempFile;
    }

    public final String component18() {
        return this.qualityPithyDescription;
    }

    public final String component19() {
        return this.qualitySuperscript;
    }

    public final boolean component2() {
        return this.hasDashAudio;
    }

    public final boolean component20() {
        return this.variableResolutionRatio;
    }

    public final int component21() {
        return this.cacheVersionCode;
    }

    public final int component22() {
        return this.preferredAudioQuality;
    }

    public final int component23() {
        return this.audioQuality;
    }

    public final long component24() {
        return this.avid;
    }

    public final int component25() {
        return this.spid;
    }

    public final long component26() {
        return this.seasonId;
    }

    public final String component27() {
        return this.bvid;
    }

    public final long component28() {
        return this.ownerId;
    }

    public final String component29() {
        return this.ownerName;
    }

    public final boolean component3() {
        return this.isCompleted;
    }

    public final boolean component30() {
        return this.isChargeVideo;
    }

    public final int component31() {
        return this.verificationCode;
    }

    public final DeprecatedPageModel component32() {
        return this.pageData;
    }

    public final DeprecatedEpisodeModel component33() {
        return this.ep;
    }

    public final String component34() {
        return this.storagePath;
    }

    public final long component4() {
        return this.totalBytes;
    }

    public final long component5() {
        return this.downloadedBytes;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.typeTag;
    }

    public final String component8() {
        return this.cover;
    }

    public final int component9() {
        return this.videoQuality;
    }

    public final DeprecatedEntryModel copy(int i, boolean z, boolean z2, long j, long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, int i4, long j5, long j6, boolean z3, boolean z4, String str4, String str5, boolean z5, int i5, int i6, int i7, long j7, int i8, long j8, String str6, long j9, String str7, boolean z6, int i9, DeprecatedPageModel deprecatedPageModel, DeprecatedEpisodeModel deprecatedEpisodeModel, String str8) {
        Intrinsics.checkNotNullParameter(str, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(str2, "typeTag");
        Intrinsics.checkNotNullParameter(str3, RankRouter.BundleKey.VIDEO_DETAIL_COVER);
        Intrinsics.checkNotNullParameter(str4, "qualityPithyDescription");
        Intrinsics.checkNotNullParameter(str5, "qualitySuperscript");
        Intrinsics.checkNotNullParameter(str6, "bvid");
        Intrinsics.checkNotNullParameter(str7, "ownerName");
        Intrinsics.checkNotNullParameter(str8, "storagePath");
        return new DeprecatedEntryModel(i, z, z2, j, j2, str, str2, str3, i2, i3, j3, j4, i4, j5, j6, z3, z4, str4, str5, z5, i5, i6, i7, j7, i8, j8, str6, j9, str7, z6, i9, deprecatedPageModel, deprecatedEpisodeModel, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeprecatedEntryModel) {
            DeprecatedEntryModel deprecatedEntryModel = (DeprecatedEntryModel) obj;
            return this.mediaType == deprecatedEntryModel.mediaType && this.hasDashAudio == deprecatedEntryModel.hasDashAudio && this.isCompleted == deprecatedEntryModel.isCompleted && this.totalBytes == deprecatedEntryModel.totalBytes && this.downloadedBytes == deprecatedEntryModel.downloadedBytes && Intrinsics.areEqual(this.title, deprecatedEntryModel.title) && Intrinsics.areEqual(this.typeTag, deprecatedEntryModel.typeTag) && Intrinsics.areEqual(this.cover, deprecatedEntryModel.cover) && this.videoQuality == deprecatedEntryModel.videoQuality && this.preferedVideoQuality == deprecatedEntryModel.preferedVideoQuality && this.guessedTotalBytes == deprecatedEntryModel.guessedTotalBytes && this.totalTimeMilli == deprecatedEntryModel.totalTimeMilli && this.danmakuCount == deprecatedEntryModel.danmakuCount && this.timeUpdateStamp == deprecatedEntryModel.timeUpdateStamp && this.timeCreateStamp == deprecatedEntryModel.timeCreateStamp && this.canPlayInAdvance == deprecatedEntryModel.canPlayInAdvance && this.interruptTransformTempFile == deprecatedEntryModel.interruptTransformTempFile && Intrinsics.areEqual(this.qualityPithyDescription, deprecatedEntryModel.qualityPithyDescription) && Intrinsics.areEqual(this.qualitySuperscript, deprecatedEntryModel.qualitySuperscript) && this.variableResolutionRatio == deprecatedEntryModel.variableResolutionRatio && this.cacheVersionCode == deprecatedEntryModel.cacheVersionCode && this.preferredAudioQuality == deprecatedEntryModel.preferredAudioQuality && this.audioQuality == deprecatedEntryModel.audioQuality && this.avid == deprecatedEntryModel.avid && this.spid == deprecatedEntryModel.spid && this.seasonId == deprecatedEntryModel.seasonId && Intrinsics.areEqual(this.bvid, deprecatedEntryModel.bvid) && this.ownerId == deprecatedEntryModel.ownerId && Intrinsics.areEqual(this.ownerName, deprecatedEntryModel.ownerName) && this.isChargeVideo == deprecatedEntryModel.isChargeVideo && this.verificationCode == deprecatedEntryModel.verificationCode && Intrinsics.areEqual(this.pageData, deprecatedEntryModel.pageData) && Intrinsics.areEqual(this.ep, deprecatedEntryModel.ep) && Intrinsics.areEqual(this.storagePath, deprecatedEntryModel.storagePath);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.mediaType * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasDashAudio)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCompleted)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.totalBytes)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.downloadedBytes)) * 31) + this.title.hashCode()) * 31) + this.typeTag.hashCode()) * 31) + this.cover.hashCode()) * 31) + this.videoQuality) * 31) + this.preferedVideoQuality) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.guessedTotalBytes)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.totalTimeMilli)) * 31) + this.danmakuCount) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timeUpdateStamp)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timeCreateStamp)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.canPlayInAdvance)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.interruptTransformTempFile)) * 31) + this.qualityPithyDescription.hashCode()) * 31) + this.qualitySuperscript.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.variableResolutionRatio)) * 31) + this.cacheVersionCode) * 31) + this.preferredAudioQuality) * 31) + this.audioQuality) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.avid)) * 31) + this.spid) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.seasonId)) * 31) + this.bvid.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.ownerId)) * 31) + this.ownerName.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isChargeVideo)) * 31) + this.verificationCode) * 31) + (this.pageData == null ? 0 : this.pageData.hashCode())) * 31) + (this.ep != null ? this.ep.hashCode() : 0)) * 31) + this.storagePath.hashCode();
    }

    public String toString() {
        int i = this.mediaType;
        boolean z = this.hasDashAudio;
        boolean z2 = this.isCompleted;
        long j = this.totalBytes;
        long j2 = this.downloadedBytes;
        String str = this.title;
        String str2 = this.typeTag;
        String str3 = this.cover;
        int i2 = this.videoQuality;
        int i3 = this.preferedVideoQuality;
        long j3 = this.guessedTotalBytes;
        long j4 = this.totalTimeMilli;
        int i4 = this.danmakuCount;
        long j5 = this.timeUpdateStamp;
        long j6 = this.timeCreateStamp;
        boolean z3 = this.canPlayInAdvance;
        boolean z4 = this.interruptTransformTempFile;
        String str4 = this.qualityPithyDescription;
        String str5 = this.qualitySuperscript;
        boolean z5 = this.variableResolutionRatio;
        int i5 = this.cacheVersionCode;
        int i6 = this.preferredAudioQuality;
        int i7 = this.audioQuality;
        long j7 = this.avid;
        int i8 = this.spid;
        long j8 = this.seasonId;
        String str6 = this.bvid;
        long j9 = this.ownerId;
        String str7 = this.ownerName;
        boolean z6 = this.isChargeVideo;
        int i9 = this.verificationCode;
        DeprecatedPageModel deprecatedPageModel = this.pageData;
        DeprecatedEpisodeModel deprecatedEpisodeModel = this.ep;
        return "DeprecatedEntryModel(mediaType=" + i + ", hasDashAudio=" + z + ", isCompleted=" + z2 + ", totalBytes=" + j + ", downloadedBytes=" + j2 + ", title=" + str + ", typeTag=" + str2 + ", cover=" + str3 + ", videoQuality=" + i2 + ", preferedVideoQuality=" + i3 + ", guessedTotalBytes=" + j3 + ", totalTimeMilli=" + j4 + ", danmakuCount=" + i4 + ", timeUpdateStamp=" + j5 + ", timeCreateStamp=" + j6 + ", canPlayInAdvance=" + z3 + ", interruptTransformTempFile=" + z4 + ", qualityPithyDescription=" + str4 + ", qualitySuperscript=" + str5 + ", variableResolutionRatio=" + z5 + ", cacheVersionCode=" + i5 + ", preferredAudioQuality=" + i6 + ", audioQuality=" + i7 + ", avid=" + j7 + ", spid=" + i8 + ", seasonId=" + j8 + ", bvid=" + str6 + ", ownerId=" + j9 + ", ownerName=" + str7 + ", isChargeVideo=" + z6 + ", verificationCode=" + i9 + ", pageData=" + deprecatedPageModel + ", ep=" + deprecatedEpisodeModel + ", storagePath=" + this.storagePath + ")";
    }

    /* compiled from: DeprecatedEntryModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/infra/model/DeprecatedEntryModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/base/infra/model/DeprecatedEntryModel;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DeprecatedEntryModel> serializer() {
            return new GeneratedSerializer<DeprecatedEntryModel>() { // from class: video.biz.offline.base.infra.model.DeprecatedEntryModel$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.base.infra.model.DeprecatedEntryModel", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<video.biz.offline.base.infra.model.DeprecatedEntryModel> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<video.biz.offline.base.infra.model.DeprecatedEntryModel> A[REMOVE]) =  video.biz.offline.base.infra.model.DeprecatedEntryModel$$serializer.INSTANCE video.biz.offline.base.infra.model.DeprecatedEntryModel$$serializer)
                         in method: video.biz.offline.base.infra.model.DeprecatedEntryModel.Companion.serializer():kotlinx.serialization.KSerializer<video.biz.offline.base.infra.model.DeprecatedEntryModel>, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
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
                          ("video.biz.offline.base.infra.model.DeprecatedEntryModel")
                          (wrap: video.biz.offline.base.infra.model.DeprecatedEntryModel$$serializer : 0x0009: SGET  (r1v0 video.biz.offline.base.infra.model.DeprecatedEntryModel$$serializer A[REMOVE]) =  video.biz.offline.base.infra.model.DeprecatedEntryModel$$serializer.INSTANCE video.biz.offline.base.infra.model.DeprecatedEntryModel$$serializer)
                          (33 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: video.biz.offline.base.infra.model.DeprecatedEntryModel$$serializer.<clinit>():void, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: video.biz.offline.base.infra.model.DeprecatedEntryModel$$serializer
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
                        video.biz.offline.base.infra.model.DeprecatedEntryModel$$serializer r0 = video.biz.offline.base.infra.model.DeprecatedEntryModel$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: video.biz.offline.base.infra.model.DeprecatedEntryModel.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ DeprecatedEntryModel(int seen0, int seen1, int mediaType, boolean hasDashAudio, boolean isCompleted, long totalBytes, long downloadedBytes, String title, String typeTag, String cover, int videoQuality, int preferedVideoQuality, long guessedTotalBytes, long totalTimeMilli, int danmakuCount, long timeUpdateStamp, long timeCreateStamp, boolean canPlayInAdvance, boolean interruptTransformTempFile, String qualityPithyDescription, String qualitySuperscript, boolean variableResolutionRatio, int cacheVersionCode, int preferredAudioQuality, int audioQuality, long avid, int spid, long seasonId, String bvid, long ownerId, String ownerName, boolean isChargeVideo, int verificationCode, DeprecatedPageModel pageData, DeprecatedEpisodeModel ep, SerializationConstructorMarker serializationConstructorMarker) {
                boolean z;
                if ((seen0 & 1) == 0) {
                    this.mediaType = 0;
                } else {
                    this.mediaType = mediaType;
                }
                if ((seen0 & 2) == 0) {
                    this.hasDashAudio = false;
                } else {
                    this.hasDashAudio = hasDashAudio;
                }
                if ((seen0 & 4) == 0) {
                    this.isCompleted = false;
                } else {
                    this.isCompleted = isCompleted;
                }
                if ((seen0 & 8) == 0) {
                    this.totalBytes = 0L;
                } else {
                    this.totalBytes = totalBytes;
                }
                if ((seen0 & 16) == 0) {
                    this.downloadedBytes = 0L;
                } else {
                    this.downloadedBytes = downloadedBytes;
                }
                if ((seen0 & 32) == 0) {
                    this.title = "";
                } else {
                    this.title = title;
                }
                if ((seen0 & 64) == 0) {
                    this.typeTag = "";
                } else {
                    this.typeTag = typeTag;
                }
                if ((seen0 & 128) == 0) {
                    this.cover = "";
                } else {
                    this.cover = cover;
                }
                if ((seen0 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
                    this.videoQuality = 0;
                } else {
                    this.videoQuality = videoQuality;
                }
                if ((seen0 & 512) == 0) {
                    this.preferedVideoQuality = 0;
                } else {
                    this.preferedVideoQuality = preferedVideoQuality;
                }
                if ((seen0 & 1024) == 0) {
                    this.guessedTotalBytes = 0L;
                } else {
                    this.guessedTotalBytes = guessedTotalBytes;
                }
                if ((seen0 & IjkMediaMeta.FF_PROFILE_H264_INTRA) == 0) {
                    this.totalTimeMilli = 0L;
                } else {
                    this.totalTimeMilli = totalTimeMilli;
                }
                if ((seen0 & 4096) == 0) {
                    this.danmakuCount = 0;
                } else {
                    this.danmakuCount = danmakuCount;
                }
                if ((seen0 & 8192) == 0) {
                    this.timeUpdateStamp = 0L;
                } else {
                    this.timeUpdateStamp = timeUpdateStamp;
                }
                if ((seen0 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) == 0) {
                    this.timeCreateStamp = 0L;
                } else {
                    this.timeCreateStamp = timeCreateStamp;
                }
                if ((seen0 & 32768) == 0) {
                    z = false;
                    this.canPlayInAdvance = false;
                } else {
                    z = false;
                    this.canPlayInAdvance = canPlayInAdvance;
                }
                if ((seen0 & 65536) == 0) {
                    this.interruptTransformTempFile = z;
                } else {
                    this.interruptTransformTempFile = interruptTransformTempFile;
                }
                if ((seen0 & 131072) == 0) {
                    this.qualityPithyDescription = "";
                } else {
                    this.qualityPithyDescription = qualityPithyDescription;
                }
                if ((seen0 & 262144) == 0) {
                    this.qualitySuperscript = "";
                } else {
                    this.qualitySuperscript = qualitySuperscript;
                }
                if ((seen0 & 524288) == 0) {
                    this.variableResolutionRatio = false;
                } else {
                    this.variableResolutionRatio = variableResolutionRatio;
                }
                if ((seen0 & 1048576) == 0) {
                    this.cacheVersionCode = 0;
                } else {
                    this.cacheVersionCode = cacheVersionCode;
                }
                if ((seen0 & 2097152) == 0) {
                    this.preferredAudioQuality = 0;
                } else {
                    this.preferredAudioQuality = preferredAudioQuality;
                }
                if ((seen0 & 4194304) == 0) {
                    this.audioQuality = 0;
                } else {
                    this.audioQuality = audioQuality;
                }
                if ((seen0 & 8388608) == 0) {
                    this.avid = 0L;
                } else {
                    this.avid = avid;
                }
                if ((seen0 & 16777216) == 0) {
                    this.spid = 0;
                } else {
                    this.spid = spid;
                }
                if ((33554432 & seen0) == 0) {
                    this.seasonId = 0L;
                } else {
                    this.seasonId = seasonId;
                }
                if ((seen0 & 67108864) == 0) {
                    this.bvid = "";
                } else {
                    this.bvid = bvid;
                }
                if ((134217728 & seen0) == 0) {
                    this.ownerId = 0L;
                } else {
                    this.ownerId = ownerId;
                }
                if ((seen0 & 268435456) == 0) {
                    this.ownerName = "";
                } else {
                    this.ownerName = ownerName;
                }
                if ((536870912 & seen0) == 0) {
                    this.isChargeVideo = false;
                } else {
                    this.isChargeVideo = isChargeVideo;
                }
                if ((seen0 & 1073741824) == 0) {
                    this.verificationCode = 0;
                } else {
                    this.verificationCode = verificationCode;
                }
                if ((seen0 & Integer.MIN_VALUE) == 0) {
                    this.pageData = null;
                } else {
                    this.pageData = pageData;
                }
                if ((seen1 & 1) == 0) {
                    this.ep = null;
                } else {
                    this.ep = ep;
                }
                this.storagePath = "";
            }

            public DeprecatedEntryModel(int mediaType, boolean hasDashAudio, boolean isCompleted, long totalBytes, long downloadedBytes, String title, String typeTag, String cover, int videoQuality, int preferedVideoQuality, long guessedTotalBytes, long totalTimeMilli, int danmakuCount, long timeUpdateStamp, long timeCreateStamp, boolean canPlayInAdvance, boolean interruptTransformTempFile, String qualityPithyDescription, String qualitySuperscript, boolean variableResolutionRatio, int cacheVersionCode, int preferredAudioQuality, int audioQuality, long avid, int spid, long seasonId, String bvid, long ownerId, String ownerName, boolean isChargeVideo, int verificationCode, DeprecatedPageModel pageData, DeprecatedEpisodeModel ep, String storagePath) {
                Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
                Intrinsics.checkNotNullParameter(typeTag, "typeTag");
                Intrinsics.checkNotNullParameter(cover, RankRouter.BundleKey.VIDEO_DETAIL_COVER);
                Intrinsics.checkNotNullParameter(qualityPithyDescription, "qualityPithyDescription");
                Intrinsics.checkNotNullParameter(qualitySuperscript, "qualitySuperscript");
                Intrinsics.checkNotNullParameter(bvid, "bvid");
                Intrinsics.checkNotNullParameter(ownerName, "ownerName");
                Intrinsics.checkNotNullParameter(storagePath, "storagePath");
                this.mediaType = mediaType;
                this.hasDashAudio = hasDashAudio;
                this.isCompleted = isCompleted;
                this.totalBytes = totalBytes;
                this.downloadedBytes = downloadedBytes;
                this.title = title;
                this.typeTag = typeTag;
                this.cover = cover;
                this.videoQuality = videoQuality;
                this.preferedVideoQuality = preferedVideoQuality;
                this.guessedTotalBytes = guessedTotalBytes;
                this.totalTimeMilli = totalTimeMilli;
                this.danmakuCount = danmakuCount;
                this.timeUpdateStamp = timeUpdateStamp;
                this.timeCreateStamp = timeCreateStamp;
                this.canPlayInAdvance = canPlayInAdvance;
                this.interruptTransformTempFile = interruptTransformTempFile;
                this.qualityPithyDescription = qualityPithyDescription;
                this.qualitySuperscript = qualitySuperscript;
                this.variableResolutionRatio = variableResolutionRatio;
                this.cacheVersionCode = cacheVersionCode;
                this.preferredAudioQuality = preferredAudioQuality;
                this.audioQuality = audioQuality;
                this.avid = avid;
                this.spid = spid;
                this.seasonId = seasonId;
                this.bvid = bvid;
                this.ownerId = ownerId;
                this.ownerName = ownerName;
                this.isChargeVideo = isChargeVideo;
                this.verificationCode = verificationCode;
                this.pageData = pageData;
                this.ep = ep;
                this.storagePath = storagePath;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$infra_debug(DeprecatedEntryModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.mediaType != 0) {
                    output.encodeIntElement(serialDesc, 0, self.mediaType);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.hasDashAudio) {
                    output.encodeBooleanElement(serialDesc, 1, self.hasDashAudio);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.isCompleted) {
                    output.encodeBooleanElement(serialDesc, 2, self.isCompleted);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.totalBytes != 0) {
                    output.encodeLongElement(serialDesc, 3, self.totalBytes);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.downloadedBytes != 0) {
                    output.encodeLongElement(serialDesc, 4, self.downloadedBytes);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.title, "")) {
                    output.encodeStringElement(serialDesc, 5, self.title);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.typeTag, "")) {
                    output.encodeStringElement(serialDesc, 6, self.typeTag);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.cover, "")) {
                    output.encodeStringElement(serialDesc, 7, self.cover);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.videoQuality != 0) {
                    output.encodeIntElement(serialDesc, 8, self.videoQuality);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.preferedVideoQuality != 0) {
                    output.encodeIntElement(serialDesc, 9, self.preferedVideoQuality);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.guessedTotalBytes != 0) {
                    output.encodeLongElement(serialDesc, 10, self.guessedTotalBytes);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.totalTimeMilli != 0) {
                    output.encodeLongElement(serialDesc, 11, self.totalTimeMilli);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 12) || self.danmakuCount != 0) {
                    output.encodeIntElement(serialDesc, 12, self.danmakuCount);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.timeUpdateStamp != 0) {
                    output.encodeLongElement(serialDesc, 13, self.timeUpdateStamp);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 14) || self.timeCreateStamp != 0) {
                    output.encodeLongElement(serialDesc, 14, self.timeCreateStamp);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.canPlayInAdvance) {
                    output.encodeBooleanElement(serialDesc, 15, self.canPlayInAdvance);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 16) || self.interruptTransformTempFile) {
                    output.encodeBooleanElement(serialDesc, 16, self.interruptTransformTempFile);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 17) || !Intrinsics.areEqual(self.qualityPithyDescription, "")) {
                    output.encodeStringElement(serialDesc, 17, self.qualityPithyDescription);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 18) || !Intrinsics.areEqual(self.qualitySuperscript, "")) {
                    output.encodeStringElement(serialDesc, 18, self.qualitySuperscript);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 19) || self.variableResolutionRatio) {
                    output.encodeBooleanElement(serialDesc, 19, self.variableResolutionRatio);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 20) || self.cacheVersionCode != 0) {
                    output.encodeIntElement(serialDesc, 20, self.cacheVersionCode);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 21) || self.preferredAudioQuality != 0) {
                    output.encodeIntElement(serialDesc, 21, self.preferredAudioQuality);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 22) || self.audioQuality != 0) {
                    output.encodeIntElement(serialDesc, 22, self.audioQuality);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 23) || self.avid != 0) {
                    output.encodeLongElement(serialDesc, 23, self.avid);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 24) || self.spid != 0) {
                    output.encodeIntElement(serialDesc, 24, self.spid);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 25) || self.seasonId != 0) {
                    output.encodeLongElement(serialDesc, 25, self.seasonId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 26) || !Intrinsics.areEqual(self.bvid, "")) {
                    output.encodeStringElement(serialDesc, 26, self.bvid);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 27) || self.ownerId != 0) {
                    output.encodeLongElement(serialDesc, 27, self.ownerId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 28) || !Intrinsics.areEqual(self.ownerName, "")) {
                    output.encodeStringElement(serialDesc, 28, self.ownerName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 29) || self.isChargeVideo) {
                    output.encodeBooleanElement(serialDesc, 29, self.isChargeVideo);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 30) || self.verificationCode != 0) {
                    output.encodeIntElement(serialDesc, 30, self.verificationCode);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 31) || self.pageData != null) {
                    output.encodeNullableSerializableElement(serialDesc, 31, DeprecatedPageModel$$serializer.INSTANCE, self.pageData);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 32) || self.ep != null) {
                    output.encodeNullableSerializableElement(serialDesc, 32, DeprecatedEpisodeModel$$serializer.INSTANCE, self.ep);
                }
            }

            public /* synthetic */ DeprecatedEntryModel(int i, boolean z, boolean z2, long j, long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, int i4, long j5, long j6, boolean z3, boolean z4, String str4, String str5, boolean z5, int i5, int i6, int i7, long j7, int i8, long j8, String str6, long j9, String str7, boolean z6, int i9, DeprecatedPageModel deprecatedPageModel, DeprecatedEpisodeModel deprecatedEpisodeModel, String str8, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
                this((i10 & 1) != 0 ? 0 : i, (i10 & 2) != 0 ? false : z, (i10 & 4) != 0 ? false : z2, (i10 & 8) != 0 ? 0L : j, (i10 & 16) != 0 ? 0L : j2, (i10 & 32) != 0 ? "" : str, (i10 & 64) != 0 ? "" : str2, (i10 & 128) != 0 ? "" : str3, (i10 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? 0 : i2, (i10 & 512) != 0 ? 0 : i3, (i10 & 1024) != 0 ? 0L : j3, (i10 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? 0L : j4, (i10 & 4096) != 0 ? 0 : i4, (i10 & 8192) != 0 ? 0L : j5, (i10 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? 0L : j6, (32768 & i10) != 0 ? false : z3, (i10 & 65536) != 0 ? false : z4, (i10 & 131072) != 0 ? "" : str4, (i10 & 262144) != 0 ? "" : str5, (i10 & 524288) != 0 ? false : z5, (i10 & 1048576) != 0 ? 0 : i5, (i10 & 2097152) != 0 ? 0 : i6, (i10 & 4194304) != 0 ? 0 : i7, (i10 & 8388608) != 0 ? 0L : j7, (i10 & 16777216) != 0 ? 0 : i8, (i10 & 33554432) != 0 ? 0L : j8, (i10 & 67108864) != 0 ? "" : str6, (i10 & 134217728) != 0 ? 0L : j9, (i10 & 268435456) != 0 ? "" : str7, (i10 & 536870912) != 0 ? false : z6, (i10 & 1073741824) != 0 ? 0 : i9, (i10 & Integer.MIN_VALUE) != 0 ? null : deprecatedPageModel, (i11 & 1) == 0 ? deprecatedEpisodeModel : null, (i11 & 2) != 0 ? "" : str8);
            }

            public final int getMediaType() {
                return this.mediaType;
            }

            public final boolean getHasDashAudio() {
                return this.hasDashAudio;
            }

            public final boolean isCompleted() {
                return this.isCompleted;
            }

            public final long getTotalBytes() {
                return this.totalBytes;
            }

            public final long getDownloadedBytes() {
                return this.downloadedBytes;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getTypeTag() {
                return this.typeTag;
            }

            public final String getCover() {
                return this.cover;
            }

            public final int getVideoQuality() {
                return this.videoQuality;
            }

            public final int getPreferedVideoQuality() {
                return this.preferedVideoQuality;
            }

            public final long getGuessedTotalBytes() {
                return this.guessedTotalBytes;
            }

            public final long getTotalTimeMilli() {
                return this.totalTimeMilli;
            }

            public final int getDanmakuCount() {
                return this.danmakuCount;
            }

            public final long getTimeUpdateStamp() {
                return this.timeUpdateStamp;
            }

            public final long getTimeCreateStamp() {
                return this.timeCreateStamp;
            }

            public final boolean getCanPlayInAdvance() {
                return this.canPlayInAdvance;
            }

            public final boolean getInterruptTransformTempFile() {
                return this.interruptTransformTempFile;
            }

            public final String getQualityPithyDescription() {
                return this.qualityPithyDescription;
            }

            public final String getQualitySuperscript() {
                return this.qualitySuperscript;
            }

            public final boolean getVariableResolutionRatio() {
                return this.variableResolutionRatio;
            }

            public final int getCacheVersionCode() {
                return this.cacheVersionCode;
            }

            public final int getPreferredAudioQuality() {
                return this.preferredAudioQuality;
            }

            public final int getAudioQuality() {
                return this.audioQuality;
            }

            public final long getAvid() {
                return this.avid;
            }

            public final int getSpid() {
                return this.spid;
            }

            public final long getSeasonId() {
                return this.seasonId;
            }

            public final String getBvid() {
                return this.bvid;
            }

            public final long getOwnerId() {
                return this.ownerId;
            }

            public final String getOwnerName() {
                return this.ownerName;
            }

            public final boolean isChargeVideo() {
                return this.isChargeVideo;
            }

            public final int getVerificationCode() {
                return this.verificationCode;
            }

            public final DeprecatedPageModel getPageData() {
                return this.pageData;
            }

            public final DeprecatedEpisodeModel getEp() {
                return this.ep;
            }

            public final String getStoragePath() {
                return this.storagePath;
            }

            public final void setStoragePath(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.storagePath = str;
            }

            /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
            /* JADX WARN: Removed duplicated region for block: B:104:0x0135  */
            /* JADX WARN: Removed duplicated region for block: B:107:0x015f  */
            /* JADX WARN: Removed duplicated region for block: B:108:0x0163  */
            /* JADX WARN: Removed duplicated region for block: B:111:0x01f6  */
            /* JADX WARN: Removed duplicated region for block: B:114:0x0204  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0023  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0039  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x004f  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x006c  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x007b  */
            /* JADX WARN: Removed duplicated region for block: B:52:0x0089  */
            /* JADX WARN: Removed duplicated region for block: B:53:0x008e  */
            /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
            /* JADX WARN: Removed duplicated region for block: B:57:0x0098  */
            /* JADX WARN: Removed duplicated region for block: B:63:0x00a7  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x00ac  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x00c5  */
            /* JADX WARN: Removed duplicated region for block: B:74:0x00d3  */
            /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
            /* JADX WARN: Removed duplicated region for block: B:84:0x00f4  */
            /* JADX WARN: Removed duplicated region for block: B:91:0x0105  */
            /* JADX WARN: Removed duplicated region for block: B:94:0x0115  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final OfflineVideoEntity transform() {
                String pageTitle;
                String indexTitle;
                DeprecatedPageModel deprecatedPageModel;
                long width;
                long width2;
                DeprecatedPageModel deprecatedPageModel2;
                long height;
                long height2;
                DeprecatedPageModel deprecatedPageModel3;
                long rotate;
                long rotate2;
                DeprecatedPageModel deprecatedPageModel4;
                long index;
                long sortIndex;
                DeprecatedPageModel deprecatedPageModel5;
                DeprecatedEpisodeModel deprecatedEpisodeModel;
                String from;
                String from2;
                OfflineVideoEntity.BizType bizType;
                long aid;
                long cid;
                String bvid;
                String str;
                String index2;
                String bvid2;
                DeprecatedPageModel deprecatedPageModel6 = this.pageData;
                if (deprecatedPageModel6 == null || (indexTitle = deprecatedPageModel6.getPart()) == null) {
                    DeprecatedEpisodeModel deprecatedEpisodeModel2 = this.ep;
                    if (deprecatedEpisodeModel2 != null) {
                        indexTitle = deprecatedEpisodeModel2.getIndexTitle();
                    } else {
                        pageTitle = "";
                        deprecatedPageModel = this.pageData;
                        if (deprecatedPageModel == null) {
                            width2 = deprecatedPageModel.getWidth();
                        } else {
                            DeprecatedEpisodeModel deprecatedEpisodeModel3 = this.ep;
                            if (deprecatedEpisodeModel3 != null) {
                                width2 = deprecatedEpisodeModel3.getWidth();
                            } else {
                                width = 0;
                                deprecatedPageModel2 = this.pageData;
                                if (deprecatedPageModel2 != null) {
                                    height2 = deprecatedPageModel2.getHeight();
                                } else {
                                    DeprecatedEpisodeModel deprecatedEpisodeModel4 = this.ep;
                                    if (deprecatedEpisodeModel4 != null) {
                                        height2 = deprecatedEpisodeModel4.getHeight();
                                    } else {
                                        height = 0;
                                        deprecatedPageModel3 = this.pageData;
                                        if (deprecatedPageModel3 == null) {
                                            rotate2 = deprecatedPageModel3.getRotate();
                                        } else {
                                            DeprecatedEpisodeModel deprecatedEpisodeModel5 = this.ep;
                                            if (deprecatedEpisodeModel5 != null) {
                                                rotate2 = deprecatedEpisodeModel5.getRotate();
                                            } else {
                                                rotate = 0;
                                                deprecatedPageModel4 = this.pageData;
                                                if (deprecatedPageModel4 != null) {
                                                    sortIndex = deprecatedPageModel4.getPage();
                                                } else {
                                                    DeprecatedEpisodeModel deprecatedEpisodeModel6 = this.ep;
                                                    if (deprecatedEpisodeModel6 == null) {
                                                        index = 0;
                                                        deprecatedPageModel5 = this.pageData;
                                                        if (deprecatedPageModel5 != null || (from2 = deprecatedPageModel5.getFrom()) == null) {
                                                            deprecatedEpisodeModel = this.ep;
                                                            if (deprecatedEpisodeModel != null) {
                                                                from = "";
                                                                if (this.pageData == null) {
                                                                    bizType = OfflineVideoEntity.BizType.UGC;
                                                                } else {
                                                                    bizType = this.ep != null ? OfflineVideoEntity.BizType.OGV : OfflineVideoEntity.BizType.UGC;
                                                                }
                                                                DeprecatedEpisodeModel deprecatedEpisodeModel7 = this.ep;
                                                                int seasonType = deprecatedEpisodeModel7 == null ? deprecatedEpisodeModel7.getSeasonType() : 0;
                                                                if (WhenMappings.$EnumSwitchMapping$0[bizType.ordinal()] != 1) {
                                                                    DeprecatedEpisodeModel deprecatedEpisodeModel8 = this.ep;
                                                                    aid = deprecatedEpisodeModel8 != null ? deprecatedEpisodeModel8.getAvId() : 0L;
                                                                } else {
                                                                    aid = this.avid;
                                                                }
                                                                if (WhenMappings.$EnumSwitchMapping$0[bizType.ordinal()] != 1) {
                                                                    DeprecatedEpisodeModel deprecatedEpisodeModel9 = this.ep;
                                                                    cid = deprecatedEpisodeModel9 != null ? deprecatedEpisodeModel9.getDanmaku() : 0L;
                                                                } else {
                                                                    DeprecatedPageModel deprecatedPageModel7 = this.pageData;
                                                                    cid = deprecatedPageModel7 != null ? deprecatedPageModel7.getCid() : 0L;
                                                                }
                                                                if (WhenMappings.$EnumSwitchMapping$0[bizType.ordinal()] != 1) {
                                                                    DeprecatedEpisodeModel deprecatedEpisodeModel10 = this.ep;
                                                                    bvid = (deprecatedEpisodeModel10 == null || (bvid2 = deprecatedEpisodeModel10.getBvid()) == null) ? "" : bvid2;
                                                                } else {
                                                                    bvid = this.bvid;
                                                                }
                                                                if (WhenMappings.$EnumSwitchMapping$0[bizType.ordinal()] != 1) {
                                                                    DeprecatedEpisodeModel deprecatedEpisodeModel11 = this.ep;
                                                                    str = (deprecatedEpisodeModel11 == null || (index2 = deprecatedEpisodeModel11.getIndex()) == null) ? "" : index2;
                                                                } else {
                                                                    str = this.title;
                                                                }
                                                                String str2 = this.cover;
                                                                String str3 = this.ownerName;
                                                                long j = this.ownerId;
                                                                DeprecatedEpisodeModel deprecatedEpisodeModel12 = this.ep;
                                                                long episodeId = deprecatedEpisodeModel12 != null ? deprecatedEpisodeModel12.getEpisodeId() : 0L;
                                                                long j2 = this.seasonId;
                                                                Duration.Companion companion = Duration.Companion;
                                                                OfflineVideoEntity $this$transform_u24lambda_u240 = new OfflineVideoEntity(0L, null, aid, cid, j2, episodeId, bizType, null, 0, 0L, str, 0L, pageTitle, str2, str3, j, bvid, width, height, rotate, DurationKt.toDuration(this.totalTimeMilli, DurationUnit.MILLISECONDS), this.danmakuCount, this.videoQuality, this.preferedVideoQuality, this.qualityPithyDescription, null, DeprecatedEntryModelKt.toMediaType(this.mediaType), this.typeTag, null, !this.isCompleted ? 5 : 0, 0, this.totalBytes, this.downloadedBytes, this.storagePath, this.timeCreateStamp, this.timeUpdateStamp, 0L, index, ExtensionKt.seasonType(seasonType), from, this.cacheVersionCode, null, this.verificationCode, null, null, null, null, 1375734659, 31232, null);
                                                                if (bizType == OfflineVideoEntity.BizType.OGV) {
                                                                    $this$transform_u24lambda_u240.setGroupTitle(this.title);
                                                                }
                                                                $this$transform_u24lambda_u240.addAttr(OfflineVideoEntity.VideoAttr.Migration);
                                                                if (this.isChargeVideo) {
                                                                    $this$transform_u24lambda_u240.addAttr(OfflineVideoEntity.VideoAttr.ChargingPay);
                                                                }
                                                                $this$transform_u24lambda_u240.getVideoInfo().setQn($this$transform_u24lambda_u240.getPreferredVideoQuality());
                                                                $this$transform_u24lambda_u240.getVideoInfo().setPreferredAudioQuality(this.preferredAudioQuality);
                                                                $this$transform_u24lambda_u240.getVideoInfo().setAudioType(this.audioQuality);
                                                                return $this$transform_u24lambda_u240;
                                                            }
                                                            from2 = deprecatedEpisodeModel.getFrom();
                                                        }
                                                        from = from2;
                                                        if (this.pageData == null) {
                                                        }
                                                        DeprecatedEpisodeModel deprecatedEpisodeModel72 = this.ep;
                                                        int seasonType2 = deprecatedEpisodeModel72 == null ? deprecatedEpisodeModel72.getSeasonType() : 0;
                                                        if (WhenMappings.$EnumSwitchMapping$0[bizType.ordinal()] != 1) {
                                                        }
                                                        if (WhenMappings.$EnumSwitchMapping$0[bizType.ordinal()] != 1) {
                                                        }
                                                        if (WhenMappings.$EnumSwitchMapping$0[bizType.ordinal()] != 1) {
                                                        }
                                                        if (WhenMappings.$EnumSwitchMapping$0[bizType.ordinal()] != 1) {
                                                        }
                                                        String str22 = this.cover;
                                                        String str32 = this.ownerName;
                                                        long j3 = this.ownerId;
                                                        DeprecatedEpisodeModel deprecatedEpisodeModel122 = this.ep;
                                                        long episodeId2 = deprecatedEpisodeModel122 != null ? deprecatedEpisodeModel122.getEpisodeId() : 0L;
                                                        long j22 = this.seasonId;
                                                        Duration.Companion companion2 = Duration.Companion;
                                                        OfflineVideoEntity $this$transform_u24lambda_u2402 = new OfflineVideoEntity(0L, null, aid, cid, j22, episodeId2, bizType, null, 0, 0L, str, 0L, pageTitle, str22, str32, j3, bvid, width, height, rotate, DurationKt.toDuration(this.totalTimeMilli, DurationUnit.MILLISECONDS), this.danmakuCount, this.videoQuality, this.preferedVideoQuality, this.qualityPithyDescription, null, DeprecatedEntryModelKt.toMediaType(this.mediaType), this.typeTag, null, !this.isCompleted ? 5 : 0, 0, this.totalBytes, this.downloadedBytes, this.storagePath, this.timeCreateStamp, this.timeUpdateStamp, 0L, index, ExtensionKt.seasonType(seasonType2), from, this.cacheVersionCode, null, this.verificationCode, null, null, null, null, 1375734659, 31232, null);
                                                        if (bizType == OfflineVideoEntity.BizType.OGV) {
                                                        }
                                                        $this$transform_u24lambda_u2402.addAttr(OfflineVideoEntity.VideoAttr.Migration);
                                                        if (this.isChargeVideo) {
                                                        }
                                                        $this$transform_u24lambda_u2402.getVideoInfo().setQn($this$transform_u24lambda_u2402.getPreferredVideoQuality());
                                                        $this$transform_u24lambda_u2402.getVideoInfo().setPreferredAudioQuality(this.preferredAudioQuality);
                                                        $this$transform_u24lambda_u2402.getVideoInfo().setAudioType(this.audioQuality);
                                                        return $this$transform_u24lambda_u2402;
                                                    }
                                                    sortIndex = deprecatedEpisodeModel6.getSortIndex();
                                                }
                                                index = sortIndex;
                                                deprecatedPageModel5 = this.pageData;
                                                if (deprecatedPageModel5 != null) {
                                                }
                                                deprecatedEpisodeModel = this.ep;
                                                if (deprecatedEpisodeModel != null) {
                                                }
                                            }
                                        }
                                        rotate = rotate2;
                                        deprecatedPageModel4 = this.pageData;
                                        if (deprecatedPageModel4 != null) {
                                        }
                                        index = sortIndex;
                                        deprecatedPageModel5 = this.pageData;
                                        if (deprecatedPageModel5 != null) {
                                        }
                                        deprecatedEpisodeModel = this.ep;
                                        if (deprecatedEpisodeModel != null) {
                                        }
                                    }
                                }
                                height = height2;
                                deprecatedPageModel3 = this.pageData;
                                if (deprecatedPageModel3 == null) {
                                }
                                rotate = rotate2;
                                deprecatedPageModel4 = this.pageData;
                                if (deprecatedPageModel4 != null) {
                                }
                                index = sortIndex;
                                deprecatedPageModel5 = this.pageData;
                                if (deprecatedPageModel5 != null) {
                                }
                                deprecatedEpisodeModel = this.ep;
                                if (deprecatedEpisodeModel != null) {
                                }
                            }
                        }
                        width = width2;
                        deprecatedPageModel2 = this.pageData;
                        if (deprecatedPageModel2 != null) {
                        }
                        height = height2;
                        deprecatedPageModel3 = this.pageData;
                        if (deprecatedPageModel3 == null) {
                        }
                        rotate = rotate2;
                        deprecatedPageModel4 = this.pageData;
                        if (deprecatedPageModel4 != null) {
                        }
                        index = sortIndex;
                        deprecatedPageModel5 = this.pageData;
                        if (deprecatedPageModel5 != null) {
                        }
                        deprecatedEpisodeModel = this.ep;
                        if (deprecatedEpisodeModel != null) {
                        }
                    }
                }
                pageTitle = indexTitle;
                deprecatedPageModel = this.pageData;
                if (deprecatedPageModel == null) {
                }
                width = width2;
                deprecatedPageModel2 = this.pageData;
                if (deprecatedPageModel2 != null) {
                }
                height = height2;
                deprecatedPageModel3 = this.pageData;
                if (deprecatedPageModel3 == null) {
                }
                rotate = rotate2;
                deprecatedPageModel4 = this.pageData;
                if (deprecatedPageModel4 != null) {
                }
                index = sortIndex;
                deprecatedPageModel5 = this.pageData;
                if (deprecatedPageModel5 != null) {
                }
                deprecatedEpisodeModel = this.ep;
                if (deprecatedEpisodeModel != null) {
                }
            }
        }