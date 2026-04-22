package tv.danmaku.bili.ui.garb.digital.base.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import com.bili.digital.common.CardNumberColorUtilKt;
import com.bili.digital.common.player.DigitalCardPlayerManager;
import com.bili.digital.common.player.DigitalCardProgressCallback;
import com.bili.digital.common.player.VideoParams;
import com.bilibili.app.authorspace.ui.nft.ui.activity.NftType;
import com.bilibili.app.authorspace.ui.nft.utils.SpaceNftUtils;
import com.bilibili.droid.TypeFaceHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.NftCardBgLoader;
import tv.danmaku.bili.ui.garb.NftCardLayoutType;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;
import tv.danmaku.bili.ui.garb.api.DLCItem;
import tv.danmaku.bili.ui.garb.api.NftReporterHelper;
import tv.danmaku.bili.ui.garb.digital.DigitalCardDetailCallback;
import tv.danmaku.bili.ui.garb.digital.DigitalCardDetailRecycleView;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailContainerRenderData;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRenderData;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRouterInfo;
import tv.danmaku.bili.ui.garb.nft.model.CardShareInfo;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardShareModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCPlayModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCSubtitles;
import tv.danmaku.bili.ui.garb.nft.model.DLCTagModel;
import tv.danmaku.bili.ui.garb.nft.model.Utterances;
import tv.danmaku.bili.ui.garb.nft.util.DLCDownlaodCallback;
import tv.danmaku.bili.ui.garb.nft.util.DLCResDownloader;
import tv.danmaku.bili.ui.garb.view.MarqueeView;
import tv.danmaku.video.bilicardplayer.BiliCardPlayerManager;

/* compiled from: DigitalCardDetailBaseView.kt */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010z\u001a\u00020\u0014H\u0016J\u0018\u0010{\u001a\u00020|2\u0006\u0010G\u001a\u00020H2\u0006\u0010}\u001a\u00020~H\u0016J\u001f\u0010\u007f\u001a\u00020|2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0016J'\u0010\u0083\u0001\u001a\u00020|2\u0007\u0010\u0084\u0001\u001a\u00020\u00142\u0007\u0010\u0085\u0001\u001a\u00020\u00142\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0016J\u0012\u0010\u0088\u0001\u001a\u00020|2\u0007\u0010\u0089\u0001\u001a\u00020\u0018H\u0016J\u0012\u0010\u008a\u0001\u001a\u00020|2\u0007\u0010\u008b\u0001\u001a\u00020[H&J\u0012\u0010\u008c\u0001\u001a\u00020|2\u0007\u0010\u008b\u0001\u001a\u00020[H&J\u0012\u0010\u008d\u0001\u001a\u00020|2\u0007\u0010\u008b\u0001\u001a\u00020[H\u0014J\t\u0010\u008e\u0001\u001a\u00020|H\u0014J]\u0010\u008f\u0001\u001a\u00020|2\u0007\u0010\u0090\u0001\u001a\u00020\u000f2\u0007\u0010\u0086\u0001\u001a\u00020H2\f\b\u0002\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u00182\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u00182\t\b\u0002\u0010\u0095\u0001\u001a\u00020\u00142\u000b\b\u0002\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0003\u0010\u0097\u0001J]\u0010\u0098\u0001\u001a\u00020|2\u0007\u0010\u0090\u0001\u001a\u00020\u000f2\u0007\u0010\u0086\u0001\u001a\u00020H2\f\b\u0002\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u00182\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u00182\t\b\u0002\u0010\u0095\u0001\u001a\u00020\u00142\u000b\b\u0002\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0003\u0010\u0097\u0001JB\u0010\u0099\u0001\u001a\u00020|2\u0007\u0010\u0090\u0001\u001a\u00020\u000f2\u0007\u0010\u0086\u0001\u001a\u00020H2\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u00182\u0007\u0010\u0094\u0001\u001a\u00020\u00182\u0007\u0010\u0095\u0001\u001a\u00020\u0014H\u0014J\t\u0010\u009a\u0001\u001a\u00020|H\u0016J\u0011\u0010\u009b\u0001\u001a\u00020\u00182\u0006\u0010}\u001a\u00020~H\u0016Jn\u0010\u009c\u0001\u001a\u00020|2\u0007\u0010\u009d\u0001\u001a\u00020[2\u0007\u0010\u0090\u0001\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020H2\f\b\u0002\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0011\b\u0002\u0010\u009e\u0001\u001a\n\u0012\u0004\u0012\u00020~\u0018\u0001082\t\b\u0002\u0010\u009f\u0001\u001a\u00020\u00142\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u00182\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u00182\t\b\u0002\u0010\u0095\u0001\u001a\u00020\u0014J\u0012\u0010 \u0001\u001a\u00020|2\u0007\u0010\u009d\u0001\u001a\u00020[H\u0002J\u0010\u0010¡\u0001\u001a\u00020|2\u0007\u0010\u009d\u0001\u001a\u00020[J\u001f\u0010¢\u0001\u001a\u00020|2\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u00012\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u0001J\u0007\u0010¥\u0001\u001a\u00020|J\u0007\u0010¦\u0001\u001a\u00020|J\t\u0010§\u0001\u001a\u0004\u0018\u00010\u0011J\u000f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0018¢\u0006\u0003\u0010¨\u0001J\u0007\u0010©\u0001\u001a\u00020[J\u0007\u0010ª\u0001\u001a\u00020[J\u0007\u0010«\u0001\u001a\u00020[Jd\u0010¢\u0001\u001a\u00020|2\u0007\u0010\u0090\u0001\u001a\u00020\u000f2\u0007\u0010\u0086\u0001\u001a\u00020H2\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u000f\u0010¬\u0001\u001a\n\u0012\u0004\u0012\u00020~\u0018\u0001082\t\b\u0002\u0010\u009f\u0001\u001a\u00020\u00142\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u00182\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u00182\t\b\u0002\u0010\u0095\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010\u00ad\u0001\u001a\u00020|2\u0007\u0010\u0086\u0001\u001a\u00020~H\u0002J#\u0010\u00ad\u0001\u001a\u00020|2\r\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020~082\t\b\u0002\u0010\u009f\u0001\u001a\u00020\u0014H\u0002J\u001b\u0010®\u0001\u001a\u00020|2\u0007\u0010\u009d\u0001\u001a\u00020[2\u0007\u0010\u0086\u0001\u001a\u00020HH\u0002J\u0007\u0010¯\u0001\u001a\u00020|J\u0007\u0010°\u0001\u001a\u00020|J\u0007\u0010±\u0001\u001a\u00020\u0018J\u0007\u0010²\u0001\u001a\u00020\u0018J\u000f\u0010³\u0001\u001a\u0004\u0018\u00010\u0014¢\u0006\u0003\u0010´\u0001J\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u0011J\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u0011J\t\u0010·\u0001\u001a\u0004\u0018\u00010\u0011J\u0007\u0010¸\u0001\u001a\u00020\u000fJ\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0011J\t\u0010º\u0001\u001a\u0004\u0018\u00010\u0011J\t\u0010»\u0001\u001a\u0004\u0018\u00010\u0011J\t\u0010¼\u0001\u001a\u0004\u0018\u00010\u0011J\u0007\u0010½\u0001\u001a\u00020\u0014J\u0007\u0010¾\u0001\u001a\u00020\rJ\u0007\u0010¿\u0001\u001a\u00020\rJ\u0007\u0010À\u0001\u001a\u00020\u0011J\u000f\u0010Á\u0001\u001a\u0004\u0018\u00010\u0014¢\u0006\u0003\u0010´\u0001J\u0007\u0010Â\u0001\u001a\u00020\u0011J\u000f\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0014¢\u0006\u0003\u0010´\u0001J\u0019\u0010Ä\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010$J\u000f\u0010Å\u0001\u001a\u0004\u0018\u00010\u0018¢\u0006\u0003\u0010¨\u0001J\u000f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0014¢\u0006\u0003\u0010´\u0001J\t\u0010Ç\u0001\u001a\u0004\u0018\u000105J\t\u0010È\u0001\u001a\u0004\u0018\u00010\u0011J\u000f\u0010É\u0001\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u000108J\t\u0010Ê\u0001\u001a\u00020|H\u0002J,\u0010Ë\u0001\u001a\u00020|2\u0006\u0010G\u001a\u00020H2\u0006\u0010}\u001a\u00020~2\u000b\b\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0003\u0010Ì\u0001J\u0014\u0010Í\u0001\u001a\u00020|2\t\u0010Î\u0001\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010Ó\u0001\u001a\u00020|2\u0007\u0010Ô\u0001\u001a\u00020\u0014H\u0002J\u001f\u0010Õ\u0001\u001a\u0005\u0018\u00010Ò\u00012\u0007\u0010Ô\u0001\u001a\u00020\u00142\b\u0010Ö\u0001\u001a\u00030Ð\u0001H\u0002J\u001c\u0010×\u0001\u001a\u00020|2\b\u0010Ø\u0001\u001a\u00030Ù\u00012\u0007\u0010Ú\u0001\u001a\u00020\u0018H\u0004J\u0016\u0010Û\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110Ü\u0001H\u0004J:\u0010Ý\u0001\u001a\u00020|2\u0007\u0010Þ\u0001\u001a\u00020\u000f2\u0007\u0010\u0086\u0001\u001a\u00020H2\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u000b\b\u0002\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0003\u0010ß\u0001J\u0012\u0010à\u0001\u001a\u00020|2\u0007\u0010á\u0001\u001a\u00020\u0018H\u0002J\u0007\u0010â\u0001\u001a\u00020|J\u0007\u0010ã\u0001\u001a\u00020|R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010#\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(R\u0012\u0010)\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0012\u0010*\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(R\u0012\u0010+\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010,\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010<\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010=\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u00020HX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0010\u0010M\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010N\u001a\u00020OX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001b\u0010T\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bV\u0010WR\u000e\u0010Z\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020@X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020DX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020@X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020BX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010n\u001a\u00020:X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001a\u0010s\u001a\u00020:X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010p\"\u0004\bu\u0010rR\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Ñ\u0001\u001a\u00030Ò\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ä\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalCardDetailBaseView;", "Ltv/danmaku/bili/ui/garb/digital/DigitalCardDetailCallback;", "context", "Landroid/content/Context;", "mFragment", "Landroidx/fragment/app/Fragment;", "onCancelClickListener", "Ltv/danmaku/bili/ui/garb/digital/base/view/OnCancelClickListener;", "playerManager", "Lcom/bili/digital/common/player/DigitalCardPlayerManager;", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Ltv/danmaku/bili/ui/garb/digital/base/view/OnCancelClickListener;Lcom/bili/digital/common/player/DigitalCardPlayerManager;)V", "mMid", "", "mFromType", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;", "mToHolderListUrl", "", "mRedeemItemId", "mActivityId", "", "mCanDonate", "Ljava/lang/Integer;", "canSaveImage", "", "getCanSaveImage", "()Z", "setCanSaveImage", "(Z)V", "mCurrentCardTypeId", "mCurrentCardId", "mCurrentAvatarUrl", "mCurrentCardHash", "mCurrentCardType", "Lcom/bilibili/app/authorspace/ui/nft/ui/activity/NftType;", "mCurrentLimitInfo", "Lkotlin/Pair;", "Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "Ltv/danmaku/bili/ui/garb/api/CardRight;", "mCurrentCardGained", "Ljava/lang/Boolean;", "mCurrentCrdMaterialType", "mCurrentIsFullScreen", "mCurrentShareType", "mCurrentFrom", "mCurrentFromId", "mCurrentSource", "mCurrentName", "mSetBgUrl", "mSubtitlesUrl", "mPlay", "Ltv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;", "mTag", "Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;", "mImgDownloadUrl", "mVideoDownloadUrl", "", "mTrialLayout", "Landroid/widget/LinearLayout;", "mLastVideoPosition", "mPageType", "leftTopTagImg", "frameImg", "mCardIndex", "Landroid/widget/TextView;", "mExchangeLabel", "Landroid/view/View;", "mSoundSwitch", "Landroidx/appcompat/widget/AppCompatImageView;", "mVideoMuteState", "mHasLocalSetting", "containerRenderData", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;", "getContainerRenderData", "()Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;", "setContainerRenderData", "(Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;)V", "rewardTag", "cardLockComposeView", "Landroidx/compose/ui/platform/ComposeView;", "getCardLockComposeView", "()Landroidx/compose/ui/platform/ComposeView;", "setCardLockComposeView", "(Landroidx/compose/ui/platform/ComposeView;)V", "mInnerRecycleView", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalCardDetailBaseRecycleView;", "getMInnerRecycleView", "()Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalCardDetailBaseRecycleView;", "mInnerRecycleView$delegate", "Lkotlin/Lazy;", "mCardNameGroup", "Landroid/view/ViewGroup;", "mCardName", "mCancelBtn", "mCardRatioGroup", "mCardRatio", "mCardRatioArrow", "mCardExtTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "mNeedResumeVideoAfterAnim", "mNftCardBgLoader", "Ltv/danmaku/bili/ui/garb/NftCardBgLoader;", "mTopContainer", "mIndexContainer", "mBottomContainer", "mSingleViewContainer", "mSingleBottomNameGroup", "mMultiViewContainer", "mBottomFloatContainer", "mAnimationContainer", "mTopMenuContainer", "getMTopMenuContainer", "()Landroid/widget/LinearLayout;", "setMTopMenuContainer", "(Landroid/widget/LinearLayout;)V", "mBottomMenuContainer", "getMBottomMenuContainer", "setMBottomMenuContainer", "mSubtitleView", "Ltv/danmaku/bili/ui/garb/view/MarqueeView;", "mActivityHomeUrl", "scrolling", "resId", "onCardItemChanged", "", "cardInfo", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRenderData;", "setShareData", "shareType", "shareModel", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardShareModel;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "setSmeltingTutorialBtnVisible", "visible", "initTopContainer", "container", "initBottomContainer", "initBottomFloatContainer", "closeContainer", "renderTopContainerUI", "fromType", "routerInfo", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;", "isFullScreen", "isMultiView", "materialType", "fromItemChanged", "(Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;ZZILjava/lang/Boolean;)V", "renderBottomContainerUI", "renderBottomFloatContainerUI", "onScrollStart", "onScrollEnd", "initData", "root", "cardRenderDataList", "jumpToIndex", "findViews", "initViews", "renderUI", "item", "Ltv/danmaku/bili/ui/garb/api/DLCItem;", "hideSingleView", "showSingleView", "getSetBgUrl", "()Ljava/lang/Boolean;", "getMultiViewContainer", "getBottomFloatContainer", "getDrawCardContainer", "cardTypeList", "renderRecycleView", "initCardsBg", "hideVideoView", "hideImage", "isMe", "isCurrentCardVideoType", "getPageType", "()Ljava/lang/Integer;", "getCardName", "getLeftTopTagImg", "getFrameImg", "getFromType", "getFrom", "getFromId", "getSource", "getRedeemItemId", "getActivityId", "getCardTypeId", "getCardId", "getCardImgUrl", "getCardMaterialType", "getCardHash", "getCardCanDonate", "getCardLimitInfo", "getCardHasGained", "getCardShareType", "getTagInfo", "getImgDownloadUrl", "getVideoDownloadUrl", "compatHalfContainer", "showCard", "(Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRenderData;Ljava/lang/Boolean;)V", "downloadSubtitles", "url", "mDLCSubtitles", "Ltv/danmaku/bili/ui/garb/nft/model/DLCSubtitles;", "mLastSubtitle", "", "updateSubtitles", "current", "findNearestSubtitle", "subtitle", "renderRatio", "ratio", "", "hasGained", "buildParam", "", "registerButtonListener", "type", "(Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;Ljava/lang/Integer;)V", "switchVideoSound", "mute", "onResume", "onDestroy", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class DigitalCardDetailBaseView implements DigitalCardDetailCallback {
    public static final int $stable = 8;
    private boolean canSaveImage;
    public ComposeView cardLockComposeView;
    public DigitalCardDetailContainerRenderData containerRenderData;
    private final Context context;
    private String frameImg;
    private String leftTopTagImg;
    private String mActivityHomeUrl;
    private int mActivityId;
    private ViewGroup mAnimationContainer;
    private ViewGroup mBottomContainer;
    private ViewGroup mBottomFloatContainer;
    protected LinearLayout mBottomMenuContainer;
    private Integer mCanDonate;
    private AppCompatImageView mCancelBtn;
    private AppCompatTextView mCardExtTextView;
    private TextView mCardIndex;
    private TextView mCardName;
    private ViewGroup mCardNameGroup;
    private TextView mCardRatio;
    private View mCardRatioArrow;
    private ViewGroup mCardRatioGroup;
    private String mCurrentAvatarUrl;
    private Boolean mCurrentCardGained;
    private String mCurrentCardHash;
    private long mCurrentCardId;
    private NftType mCurrentCardType;
    private long mCurrentCardTypeId;
    private Integer mCurrentCrdMaterialType;
    private String mCurrentFrom;
    private String mCurrentFromId;
    private Boolean mCurrentIsFullScreen;
    private Pair<CardRightShow, CardRight> mCurrentLimitInfo;
    private String mCurrentName;
    private Integer mCurrentShareType;
    private String mCurrentSource;
    private DLCSubtitles mDLCSubtitles;
    private View mExchangeLabel;
    private final Fragment mFragment;
    private DigitalFromType mFromType;
    private boolean mHasLocalSetting;
    private String mImgDownloadUrl;
    private ViewGroup mIndexContainer;
    private final Lazy mInnerRecycleView$delegate;
    private CharSequence mLastSubtitle;
    private int mLastVideoPosition;
    private long mMid;
    private ViewGroup mMultiViewContainer;
    private boolean mNeedResumeVideoAfterAnim;
    private NftCardBgLoader mNftCardBgLoader;
    private Integer mPageType;
    private DLCPlayModel mPlay;
    private String mRedeemItemId;
    private String mSetBgUrl;
    private ViewGroup mSingleBottomNameGroup;
    private ViewGroup mSingleViewContainer;
    private AppCompatImageView mSoundSwitch;
    private MarqueeView mSubtitleView;
    private String mSubtitlesUrl;
    private DLCTagModel mTag;
    private String mToHolderListUrl;
    private ViewGroup mTopContainer;
    protected LinearLayout mTopMenuContainer;
    private LinearLayout mTrialLayout;
    private List<String> mVideoDownloadUrl;
    private boolean mVideoMuteState;
    private final OnCancelClickListener onCancelClickListener;
    private final DigitalCardPlayerManager playerManager;
    private TextView rewardTag;
    private boolean scrolling;

    /* compiled from: DigitalCardDetailBaseView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DigitalFromType.values().length];
            try {
                iArr[DigitalFromType.SEE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DigitalFromType.SCAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DigitalFromType.TASK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DigitalFromType.RESULT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DigitalFromType.AWARD_POOL_CARD_PREVIEW.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[DigitalFromType.DRAW.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[DigitalFromType.DETAIL.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public abstract void initBottomContainer(ViewGroup viewGroup);

    public abstract void initTopContainer(ViewGroup viewGroup);

    @Override // tv.danmaku.bili.ui.garb.digital.DigitalCardDetailCallback
    public /* synthetic */ void onCardLoadSuccess(DigitalCardDetailRenderData digitalCardDetailRenderData) {
        DigitalCardDetailCallback.CC.$default$onCardLoadSuccess(this, digitalCardDetailRenderData);
    }

    public abstract void renderBottomContainerUI(DigitalFromType digitalFromType, DigitalCardDetailContainerRenderData digitalCardDetailContainerRenderData, DigitalCardDetailRouterInfo digitalCardDetailRouterInfo, boolean z, boolean z2, int i, Boolean bool);

    public abstract void renderTopContainerUI(DigitalFromType digitalFromType, DigitalCardDetailContainerRenderData digitalCardDetailContainerRenderData, DigitalCardDetailRouterInfo digitalCardDetailRouterInfo, boolean z, boolean z2, int i, Boolean bool);

    @Override // tv.danmaku.bili.ui.garb.digital.DigitalCardDetailCallback
    public /* synthetic */ void showCardInfo(DigitalCardDetailRenderData digitalCardDetailRenderData) {
        DigitalCardDetailCallback.CC.$default$showCardInfo(this, digitalCardDetailRenderData);
    }

    public DigitalCardDetailBaseView(Context context, Fragment mFragment, OnCancelClickListener onCancelClickListener, DigitalCardPlayerManager playerManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playerManager, "playerManager");
        this.context = context;
        this.mFragment = mFragment;
        this.onCancelClickListener = onCancelClickListener;
        this.playerManager = playerManager;
        this.mCanDonate = 0;
        this.mCurrentAvatarUrl = "";
        this.mCurrentCardHash = "";
        this.mCurrentCardType = NftType.IMAGE;
        this.mCurrentIsFullScreen = true;
        this.mCurrentShareType = 0;
        this.mLastVideoPosition = -1;
        this.mPageType = 0;
        this.mInnerRecycleView$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView$$ExternalSyntheticLambda0
            public final Object invoke() {
                DigitalCardDetailRecycleView mInnerRecycleView_delegate$lambda$0;
                mInnerRecycleView_delegate$lambda$0 = DigitalCardDetailBaseView.mInnerRecycleView_delegate$lambda$0(DigitalCardDetailBaseView.this);
                return mInnerRecycleView_delegate$lambda$0;
            }
        });
        this.mLastSubtitle = "";
    }

    public /* synthetic */ DigitalCardDetailBaseView(Context context, Fragment fragment, OnCancelClickListener onCancelClickListener, DigitalCardPlayerManager digitalCardPlayerManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : fragment, (i & 4) != 0 ? null : onCancelClickListener, digitalCardPlayerManager);
    }

    public final boolean getCanSaveImage() {
        return this.canSaveImage;
    }

    public final void setCanSaveImage(boolean z) {
        this.canSaveImage = z;
    }

    public final DigitalCardDetailContainerRenderData getContainerRenderData() {
        DigitalCardDetailContainerRenderData digitalCardDetailContainerRenderData = this.containerRenderData;
        if (digitalCardDetailContainerRenderData != null) {
            return digitalCardDetailContainerRenderData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("containerRenderData");
        return null;
    }

    public final void setContainerRenderData(DigitalCardDetailContainerRenderData digitalCardDetailContainerRenderData) {
        Intrinsics.checkNotNullParameter(digitalCardDetailContainerRenderData, "<set-?>");
        this.containerRenderData = digitalCardDetailContainerRenderData;
    }

    public final ComposeView getCardLockComposeView() {
        ComposeView composeView = this.cardLockComposeView;
        if (composeView != null) {
            return composeView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cardLockComposeView");
        return null;
    }

    public final void setCardLockComposeView(ComposeView composeView) {
        Intrinsics.checkNotNullParameter(composeView, "<set-?>");
        this.cardLockComposeView = composeView;
    }

    private final DigitalCardDetailBaseRecycleView getMInnerRecycleView() {
        return (DigitalCardDetailBaseRecycleView) this.mInnerRecycleView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DigitalCardDetailRecycleView mInnerRecycleView_delegate$lambda$0(final DigitalCardDetailBaseView this$0) {
        return new DigitalCardDetailRecycleView(new VideoParams(this$0.playerManager, new DigitalCardProgressCallback() { // from class: tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView$mInnerRecycleView$2$1
            public void onProgressUpdate(int position) {
                int i;
                BLog.w("NftCardDialog", "play progress call back: " + position);
                i = DigitalCardDetailBaseView.this.mLastVideoPosition;
                if (i != position) {
                    DigitalCardDetailBaseView.this.updateSubtitles(position);
                    DigitalCardDetailBaseView.this.mLastVideoPosition = position;
                }
            }
        }), Intrinsics.areEqual(this$0.mCurrentIsFullScreen, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinearLayout getMTopMenuContainer() {
        LinearLayout linearLayout = this.mTopMenuContainer;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTopMenuContainer");
        return null;
    }

    protected final void setMTopMenuContainer(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.mTopMenuContainer = linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinearLayout getMBottomMenuContainer() {
        LinearLayout linearLayout = this.mBottomMenuContainer;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBottomMenuContainer");
        return null;
    }

    protected final void setMBottomMenuContainer(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.mBottomMenuContainer = linearLayout;
    }

    public int resId() {
        return R.layout.bili_app_dialog_digital_detail_view;
    }

    public void onCardItemChanged(DigitalCardDetailContainerRenderData containerRenderData, DigitalCardDetailRenderData cardInfo) {
        Intrinsics.checkNotNullParameter(containerRenderData, "containerRenderData");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
    }

    public void setShareData(DigitalFromType shareType, DLCCardShareModel shareModel) {
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void setSmeltingTutorialBtnVisible(boolean visible) {
    }

    protected void initBottomFloatContainer(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
    }

    protected void closeContainer() {
    }

    public static /* synthetic */ void renderTopContainerUI$default(DigitalCardDetailBaseView digitalCardDetailBaseView, DigitalFromType digitalFromType, DigitalCardDetailContainerRenderData digitalCardDetailContainerRenderData, DigitalCardDetailRouterInfo digitalCardDetailRouterInfo, boolean z, boolean z2, int i, Boolean bool, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderTopContainerUI");
        }
        digitalCardDetailBaseView.renderTopContainerUI(digitalFromType, digitalCardDetailContainerRenderData, (i2 & 4) != 0 ? null : digitalCardDetailRouterInfo, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? 1 : i, (i2 & 64) != 0 ? false : bool);
    }

    public static /* synthetic */ void renderBottomContainerUI$default(DigitalCardDetailBaseView digitalCardDetailBaseView, DigitalFromType digitalFromType, DigitalCardDetailContainerRenderData digitalCardDetailContainerRenderData, DigitalCardDetailRouterInfo digitalCardDetailRouterInfo, boolean z, boolean z2, int i, Boolean bool, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderBottomContainerUI");
        }
        digitalCardDetailBaseView.renderBottomContainerUI(digitalFromType, digitalCardDetailContainerRenderData, (i2 & 4) != 0 ? null : digitalCardDetailRouterInfo, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? 1 : i, (i2 & 64) != 0 ? false : bool);
    }

    protected void renderBottomFloatContainerUI(DigitalFromType fromType, DigitalCardDetailContainerRenderData data, DigitalCardDetailRouterInfo routerInfo, boolean isFullScreen, boolean isMultiView, int materialType) {
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // tv.danmaku.bili.ui.garb.digital.DigitalCardDetailCallback
    public void onScrollStart() {
        this.scrolling = true;
        MarqueeView marqueeView = this.mSubtitleView;
        if (marqueeView != null) {
            marqueeView.setVisibility(8);
        }
        hideVideoView();
    }

    @Override // tv.danmaku.bili.ui.garb.digital.DigitalCardDetailCallback
    public boolean onScrollEnd(DigitalCardDetailRenderData cardInfo) {
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        this.scrolling = false;
        showCard$default(this, getContainerRenderData(), cardInfo, null, 4, null);
        return this.mVideoMuteState;
    }

    public static /* synthetic */ void initData$default(DigitalCardDetailBaseView digitalCardDetailBaseView, ViewGroup viewGroup, DigitalFromType digitalFromType, DigitalCardDetailContainerRenderData digitalCardDetailContainerRenderData, DigitalCardDetailRouterInfo digitalCardDetailRouterInfo, List list, int i, boolean z, boolean z2, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initData");
        }
        digitalCardDetailBaseView.initData(viewGroup, digitalFromType, digitalCardDetailContainerRenderData, (i3 & 8) != 0 ? null : digitalCardDetailRouterInfo, (i3 & 16) != 0 ? null : list, (i3 & 32) != 0 ? 0 : i, (i3 & 64) != 0 ? true : z, (i3 & BR.cover) != 0 ? false : z2, (i3 & BR.hallEnterHotText) != 0 ? 1 : i2);
    }

    public final void initData(ViewGroup root, DigitalFromType fromType, DigitalCardDetailContainerRenderData containerRenderData, DigitalCardDetailRouterInfo routerInfo, List<? extends DigitalCardDetailRenderData> list, int jumpToIndex, boolean isFullScreen, boolean isMultiView, int materialType) {
        DigitalFromType digitalFromType;
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        Intrinsics.checkNotNullParameter(containerRenderData, "containerRenderData");
        setContainerRenderData(containerRenderData);
        this.mFromType = fromType;
        this.mToHolderListUrl = containerRenderData.getHolderListUrl();
        this.mCanDonate = containerRenderData.getCanDonate();
        this.canSaveImage = containerRenderData.getCanSaveImage();
        this.mMid = routerInfo != null ? routerInfo.getMid() : 0L;
        Integer activityId = containerRenderData.getActivityId();
        boolean z = false;
        this.mActivityId = activityId != null ? activityId.intValue() : 0;
        this.mCurrentIsFullScreen = Boolean.valueOf(isFullScreen);
        this.mCurrentShareType = containerRenderData.getShareType();
        this.mCurrentFrom = containerRenderData.getFrom();
        this.mCurrentFromId = containerRenderData.getFromId();
        this.mCurrentSource = containerRenderData.getFSource();
        this.mActivityHomeUrl = containerRenderData.getActHomepageurl();
        this.mSetBgUrl = containerRenderData.getSetBgUrl();
        this.mPageType = containerRenderData.getPageType();
        this.mRedeemItemId = containerRenderData.getRedeemItemId();
        initCardsBg(root, containerRenderData);
        DigitalCardDetailBaseRecycleView mInnerRecycleView = getMInnerRecycleView();
        Context context = this.context;
        DigitalCardDetailBaseView digitalCardDetailBaseView = this;
        DigitalFromType digitalFromType2 = this.mFromType;
        DigitalFromType digitalFromType3 = null;
        if (digitalFromType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFromType");
            digitalFromType = null;
        } else {
            digitalFromType = digitalFromType2;
        }
        Integer activityId2 = containerRenderData.getActivityId();
        mInnerRecycleView.init(root, context, digitalCardDetailBaseView, digitalFromType, activityId2 != null ? activityId2.intValue() : 0, !isFullScreen);
        DigitalFromType digitalFromType4 = this.mFromType;
        if (digitalFromType4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFromType");
            digitalFromType4 = null;
        }
        registerButtonListener(digitalFromType4, containerRenderData, routerInfo, Integer.valueOf(materialType));
        renderUI(fromType, containerRenderData, routerInfo, list, jumpToIndex, isFullScreen, isMultiView, materialType);
        DigitalFromType digitalFromType5 = this.mFromType;
        if (digitalFromType5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFromType");
        } else {
            digitalFromType3 = digitalFromType5;
        }
        if (digitalFromType3 == DigitalFromType.DETAIL) {
            if (routerInfo != null && routerInfo.getUseScene() == 1) {
                NftReporterHelper.INSTANCE.reportAvatarDetailShow(String.valueOf(containerRenderData.getActivityId()), this.mMid, routerInfo.isMe() ? 1 : 2, 2);
                return;
            }
            if (routerInfo != null && routerInfo.getUseScene() == 2) {
                z = true;
            }
            if (z) {
                NftReporterHelper.INSTANCE.reportHeaderDetailShow(String.valueOf(containerRenderData.getActivityId()), this.mMid, routerInfo.isMe() ? 1 : 2, 2);
            }
        }
    }

    private final void findViews(ViewGroup root) {
        AppCompatImageView findViewById = root.findViewById(R.id.nft_card_sound_switch);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mSoundSwitch = findViewById;
        View findViewById2 = root.findViewById(R.id.nft_card_exchange_label);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mExchangeLabel = findViewById2;
        View findViewById3 = root.findViewById(R.id.nft_card_top_index);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mCardIndex = (TextView) findViewById3;
        AppCompatTextView findViewById4 = root.findViewById(R.id.nft_ext_name);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mCardExtTextView = findViewById4;
        View findViewById5 = root.findViewById(R.id.nft_card_name_group);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.mCardNameGroup = (ViewGroup) findViewById5;
        View findViewById6 = root.findViewById(R.id.nft_card_bottom_name);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.mCardName = (TextView) findViewById6;
        AppCompatImageView findViewById7 = root.findViewById(R.id.nft_card_top_cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.mCancelBtn = findViewById7;
        View findViewById8 = root.findViewById(R.id.nft_card_bottom_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.mCardRatioGroup = (ViewGroup) findViewById8;
        View findViewById9 = root.findViewById(R.id.nft_card_bottom_ratio);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.mCardRatio = (TextView) findViewById9;
        View findViewById10 = root.findViewById(R.id.nft_card_bottom_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        this.mCardRatioArrow = findViewById10;
        View findViewById11 = root.findViewById(R.id.nft_card_top_container);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        this.mTopContainer = (ViewGroup) findViewById11;
        View findViewById12 = root.findViewById(R.id.nft_card_index_above_container);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        this.mIndexContainer = (ViewGroup) findViewById12;
        View findViewById13 = root.findViewById(R.id.nft_card_bottom_container);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
        this.mBottomContainer = (ViewGroup) findViewById13;
        View findViewById14 = root.findViewById(R.id.nft_card_bottom_float_container);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
        this.mBottomFloatContainer = (ViewGroup) findViewById14;
        View findViewById15 = root.findViewById(R.id.nft_card_multi_view_container);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(...)");
        this.mMultiViewContainer = (ViewGroup) findViewById15;
        View findViewById16 = root.findViewById(R.id.nft_card_single_view_container);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(...)");
        this.mSingleViewContainer = (ViewGroup) findViewById16;
        View findViewById17 = root.findViewById(R.id.nft_card_bottom_group);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(...)");
        this.mSingleBottomNameGroup = (ViewGroup) findViewById17;
        View findViewById18 = root.findViewById(R.id.nft_card_top_menu_container);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(...)");
        setMTopMenuContainer((LinearLayout) findViewById18);
        View findViewById19 = root.findViewById(R.id.nft_card_bottom_menu_container);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "findViewById(...)");
        setMBottomMenuContainer((LinearLayout) findViewById19);
        View findViewById20 = root.findViewById(R.id.nft_card_animation_container);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "findViewById(...)");
        this.mAnimationContainer = (ViewGroup) findViewById20;
        this.mSubtitleView = (MarqueeView) root.findViewById(R.id.marqueeView);
        this.mTrialLayout = (LinearLayout) root.findViewById(R.id.trial_link_layout);
        this.rewardTag = (TextView) root.findViewById(R.id.reward_tag);
        View findViewById21 = root.findViewById(R.id.nft_card_lock_view);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "findViewById(...)");
        setCardLockComposeView((ComposeView) findViewById21);
    }

    public final void initViews(ViewGroup root) {
        Intrinsics.checkNotNullParameter(root, "root");
        findViews(root);
        LinearLayout linearLayout = this.mTrialLayout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DigitalCardDetailBaseView.initViews$lambda$0(DigitalCardDetailBaseView.this, view);
                }
            });
        }
        AppCompatImageView appCompatImageView = this.mCancelBtn;
        ViewGroup viewGroup = null;
        if (appCompatImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelBtn");
            appCompatImageView = null;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DigitalCardDetailBaseView.initViews$lambda$1(DigitalCardDetailBaseView.this, view);
            }
        });
        ViewGroup viewGroup2 = this.mTopContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
            viewGroup2 = null;
        }
        initTopContainer(viewGroup2);
        ViewGroup viewGroup3 = this.mBottomContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
            viewGroup3 = null;
        }
        initBottomContainer(viewGroup3);
        ViewGroup viewGroup4 = this.mBottomFloatContainer;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomFloatContainer");
        } else {
            viewGroup = viewGroup4;
        }
        initBottomFloatContainer(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(DigitalCardDetailBaseView this$0, View it) {
        SpaceNftUtils.INSTANCE.routeTo(this$0.mActivityHomeUrl, this$0.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(DigitalCardDetailBaseView this$0, View it) {
        OnCancelClickListener onCancelClickListener = this$0.onCancelClickListener;
        if (onCancelClickListener != null) {
            onCancelClickListener.onCancelClick();
        }
    }

    public final void renderUI(DLCCardShareModel shareModel, DLCItem item) {
        List<CardShareInfo> cardList;
        int size = (shareModel == null || (cardList = shareModel.getCardList()) == null) ? 0 : cardList.size();
        if (size > 1) {
            DigitalCardDetailContainerRenderData data = new DigitalCardDetailContainerRenderData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 268435455, null);
            renderUI(DigitalFromType.RESULT, data, null, null, 0, Intrinsics.areEqual(isFullScreen(), true), true, -1);
        } else if (size == 1) {
            DigitalCardDetailContainerRenderData data2 = new DigitalCardDetailContainerRenderData(item);
            showSingleView();
            renderUI(DigitalFromType.RESULT, data2, null, null, 0, Intrinsics.areEqual(isFullScreen(), true), false, item != null ? item.getItemType() : 1);
        }
    }

    public final void hideSingleView() {
        ViewGroup viewGroup = this.mSingleViewContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSingleViewContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
    }

    public final void showSingleView() {
        ViewGroup viewGroup = this.mSingleViewContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSingleViewContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
    }

    public final String getSetBgUrl() {
        return this.mSetBgUrl;
    }

    public final Boolean isFullScreen() {
        return this.mCurrentIsFullScreen;
    }

    public final ViewGroup getMultiViewContainer() {
        ViewGroup viewGroup = this.mMultiViewContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiViewContainer");
            return null;
        }
        return viewGroup;
    }

    public final ViewGroup getBottomFloatContainer() {
        ViewGroup viewGroup = this.mBottomFloatContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomFloatContainer");
            return null;
        }
        return viewGroup;
    }

    public final ViewGroup getDrawCardContainer() {
        ViewGroup viewGroup = this.mAnimationContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimationContainer");
            return null;
        }
        return viewGroup;
    }

    static /* synthetic */ void renderUI$default(DigitalCardDetailBaseView digitalCardDetailBaseView, DigitalFromType digitalFromType, DigitalCardDetailContainerRenderData digitalCardDetailContainerRenderData, DigitalCardDetailRouterInfo digitalCardDetailRouterInfo, List list, int i, boolean z, boolean z2, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderUI");
        }
        digitalCardDetailBaseView.renderUI(digitalFromType, digitalCardDetailContainerRenderData, digitalCardDetailRouterInfo, list, (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? true : z, (i3 & 64) != 0 ? false : z2, (i3 & BR.cover) != 0 ? 1 : i2);
    }

    private final void renderUI(DigitalFromType fromType, DigitalCardDetailContainerRenderData data, DigitalCardDetailRouterInfo routerInfo, List<? extends DigitalCardDetailRenderData> list, int jumpToIndex, boolean isFullScreen, boolean isMultiView, int materialType) {
        DigitalCardDetailRenderData renderData;
        ViewGroup viewGroup = null;
        if (isMultiView) {
            ViewGroup viewGroup2 = this.mTopContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(0);
            ViewGroup viewGroup3 = this.mMultiViewContainer;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMultiViewContainer");
                viewGroup3 = null;
            }
            viewGroup3.setVisibility(0);
            ViewGroup viewGroup4 = this.mSingleViewContainer;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSingleViewContainer");
            } else {
                viewGroup = viewGroup4;
            }
            viewGroup.setVisibility(8);
        } else {
            ViewGroup viewGroup5 = this.mTopContainer;
            if (viewGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                viewGroup5 = null;
            }
            viewGroup5.setVisibility(0);
            ViewGroup viewGroup6 = this.mMultiViewContainer;
            if (viewGroup6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMultiViewContainer");
                viewGroup6 = null;
            }
            viewGroup6.setVisibility(8);
            ViewGroup viewGroup7 = this.mSingleViewContainer;
            if (viewGroup7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSingleViewContainer");
                viewGroup7 = null;
            }
            viewGroup7.setVisibility(0);
            if (!isFullScreen) {
                DigitalCardDetailRenderData renderData2 = data.getRenderData();
                if (renderData2 != null) {
                    renderData2.setGyroscope(null);
                }
                if (Intrinsics.areEqual(data.getHasAnimation(), false) && (renderData = data.getRenderData()) != null) {
                    renderData.setVideoList(null);
                }
                data.setHCardLightUrl(null);
                data.setHCardShadowUrl(null);
                data.setVCardLightUrl(null);
                data.setVCardShadowUrl(null);
                DigitalCardDetailRenderData renderData3 = data.getRenderData();
                if (renderData3 != null) {
                    renderData3.setSilence(true);
                }
            }
            switch (WhenMappings.$EnumSwitchMapping$0[fromType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    if (list == null) {
                        if (isFullScreen) {
                            ViewGroup viewGroup8 = this.mSingleBottomNameGroup;
                            if (viewGroup8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mSingleBottomNameGroup");
                            } else {
                                viewGroup = viewGroup8;
                            }
                            viewGroup.setVisibility(0);
                        } else {
                            ViewGroup viewGroup9 = this.mSingleBottomNameGroup;
                            if (viewGroup9 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mSingleBottomNameGroup");
                            } else {
                                viewGroup = viewGroup9;
                            }
                            viewGroup.setVisibility(4);
                        }
                        DigitalCardDetailRenderData it = data.getRenderData();
                        if (it != null) {
                            renderRecycleView(it);
                            showCard(data, it, Boolean.valueOf(isFullScreen));
                            break;
                        }
                    } else if (!list.isEmpty() && jumpToIndex < list.size()) {
                        renderRecycleView(list, jumpToIndex);
                        showCard(data, list.get(jumpToIndex), Boolean.valueOf(isFullScreen));
                        break;
                    }
                    break;
                case 6:
                case 7:
                    DigitalCardDetailRenderData it2 = data.getRenderData();
                    if (it2 != null) {
                        renderRecycleView(it2);
                        showCard(data, it2, Boolean.valueOf(isFullScreen));
                        break;
                    }
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        renderTopContainerUI(fromType, data, routerInfo, isFullScreen, isMultiView, materialType, false);
        renderBottomContainerUI(fromType, data, routerInfo, isFullScreen, isMultiView, materialType, false);
        renderBottomFloatContainerUI(fromType, data, routerInfo, isFullScreen, isMultiView, materialType);
    }

    private final void renderRecycleView(DigitalCardDetailRenderData data) {
        getMInnerRecycleView().updateData(data);
        getMInnerRecycleView().show();
    }

    static /* synthetic */ void renderRecycleView$default(DigitalCardDetailBaseView digitalCardDetailBaseView, List list, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderRecycleView");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        digitalCardDetailBaseView.renderRecycleView(list, i);
    }

    private final void renderRecycleView(List<? extends DigitalCardDetailRenderData> list, int jumpToIndex) {
        getMInnerRecycleView().updateCardData(list, jumpToIndex);
        getMInnerRecycleView().show();
    }

    private final void initCardsBg(ViewGroup root, DigitalCardDetailContainerRenderData data) {
        this.mNftCardBgLoader = new NftCardBgLoader(root);
        DigitalFromType digitalFromType = this.mFromType;
        NftCardBgLoader nftCardBgLoader = null;
        if (digitalFromType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFromType");
            digitalFromType = null;
        }
        if (digitalFromType == DigitalFromType.AWARD_POOL_CARD_PREVIEW) {
            NftCardBgLoader nftCardBgLoader2 = this.mNftCardBgLoader;
            if (nftCardBgLoader2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNftCardBgLoader");
                nftCardBgLoader2 = null;
            }
            nftCardBgLoader2.init(data.getHCardLightUrl(), null, data.getVCardLightUrl(), null);
            return;
        }
        NftCardBgLoader nftCardBgLoader3 = this.mNftCardBgLoader;
        if (nftCardBgLoader3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNftCardBgLoader");
        } else {
            nftCardBgLoader = nftCardBgLoader3;
        }
        nftCardBgLoader.init(data.getHCardLightUrl(), data.getHCardShadowUrl(), data.getVCardLightUrl(), data.getVCardShadowUrl());
    }

    public final void hideVideoView() {
        getMInnerRecycleView().hideVideoView();
        this.playerManager.setMute(true);
        AppCompatImageView appCompatImageView = this.mSoundSwitch;
        if (appCompatImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSoundSwitch");
            appCompatImageView = null;
        }
        appCompatImageView.setVisibility(8);
    }

    public final void hideImage() {
        getMInnerRecycleView().hide();
    }

    public final boolean isMe() {
        return this.mMid == BiliAccounts.get(this.context).mid() && this.mMid != 0;
    }

    public final boolean isCurrentCardVideoType() {
        return this.mCurrentCardType == NftType.VIDEO;
    }

    public final Integer getPageType() {
        return this.mPageType;
    }

    public final String getCardName() {
        return this.mCurrentName;
    }

    public final String getLeftTopTagImg() {
        return this.leftTopTagImg;
    }

    public final String getFrameImg() {
        return this.frameImg;
    }

    public final DigitalFromType getFromType() {
        DigitalFromType digitalFromType = this.mFromType;
        if (digitalFromType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFromType");
            return null;
        }
        return digitalFromType;
    }

    public final String getFrom() {
        return this.mCurrentFrom;
    }

    public final String getFromId() {
        return this.mCurrentFromId;
    }

    public final String getSource() {
        return this.mCurrentSource;
    }

    public final String getRedeemItemId() {
        return this.mRedeemItemId;
    }

    public final int getActivityId() {
        return this.mActivityId;
    }

    public final long getCardTypeId() {
        return this.mCurrentCardTypeId;
    }

    public final long getCardId() {
        return this.mCurrentCardId;
    }

    public final String getCardImgUrl() {
        return this.mCurrentAvatarUrl;
    }

    public final Integer getCardMaterialType() {
        return this.mCurrentCrdMaterialType;
    }

    public final String getCardHash() {
        return this.mCurrentCardHash;
    }

    public final Integer getCardCanDonate() {
        return this.mCanDonate;
    }

    public final Pair<CardRightShow, CardRight> getCardLimitInfo() {
        return this.mCurrentLimitInfo;
    }

    public final Boolean getCardHasGained() {
        return this.mCurrentCardGained;
    }

    public final Integer getCardShareType() {
        return this.mCurrentShareType;
    }

    public final DLCTagModel getTagInfo() {
        return this.mTag;
    }

    public final String getImgDownloadUrl() {
        return this.mImgDownloadUrl;
    }

    public final List<String> getVideoDownloadUrl() {
        return this.mVideoDownloadUrl;
    }

    private final void compatHalfContainer() {
        AppCompatImageView appCompatImageView = this.mCancelBtn;
        ViewGroup viewGroup = null;
        if (appCompatImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelBtn");
            appCompatImageView = null;
        }
        appCompatImageView.setVisibility(Intrinsics.areEqual(isFullScreen(), false) ? 0 : 8);
        ViewGroup viewGroup2 = this.mSingleBottomNameGroup;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSingleBottomNameGroup");
        } else {
            viewGroup = viewGroup2;
        }
        viewGroup.setVisibility(Intrinsics.areEqual(isFullScreen(), false) ? 8 : 0);
    }

    static /* synthetic */ void showCard$default(DigitalCardDetailBaseView digitalCardDetailBaseView, DigitalCardDetailContainerRenderData digitalCardDetailContainerRenderData, DigitalCardDetailRenderData digitalCardDetailRenderData, Boolean bool, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCard");
        }
        if ((i & 4) != 0) {
            bool = true;
        }
        digitalCardDetailBaseView.showCard(digitalCardDetailContainerRenderData, digitalCardDetailRenderData, bool);
    }

    private final void showCard(DigitalCardDetailContainerRenderData containerRenderData, DigitalCardDetailRenderData cardInfo, Boolean isFullScreen) {
        String indexLabel;
        int i;
        compatHalfContainer();
        String rewardTip = cardInfo.getRewardTip();
        boolean z = true;
        AppCompatImageView appCompatImageView = null;
        if (!(rewardTip == null || rewardTip.length() == 0)) {
            TextView textView = this.mCardIndex;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardIndex");
                textView = null;
            }
            textView.setText(cardInfo.getRewardTip());
            TextView textView2 = this.mCardIndex;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardIndex");
                textView2 = null;
            }
            textView2.setTextColor(Color.parseColor("#99FFFFFF"));
        } else {
            if (!TextUtils.isEmpty(cardInfo.getIndex())) {
                if (TextUtils.isEmpty(cardInfo.getTotalCount())) {
                    indexLabel = cardInfo.getIndex();
                } else {
                    indexLabel = cardInfo.getIndex() + "/" + cardInfo.getTotalCount();
                }
            } else {
                indexLabel = "";
            }
            TextView textView3 = this.mCardIndex;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardIndex");
                textView3 = null;
            }
            textView3.setText(indexLabel);
            TextView textView4 = this.mCardIndex;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardIndex");
                textView4 = null;
            }
            textView4.setTypeface(TypeFaceHelper.createFromAsset(this.context, "digital_id_num.ttf"));
            if (cardInfo.getTopNumberGradientColor() != null) {
                TextView textView5 = this.mCardIndex;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCardIndex");
                    textView5 = null;
                }
                CardNumberColorUtilKt.setCardNumberGradientColor(textView5, cardInfo.getTopNumberGradientColor());
            } else {
                TextView textView6 = this.mCardIndex;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCardIndex");
                    textView6 = null;
                }
                textView6.setTextColor(Color.parseColor("#FFFFFF"));
            }
        }
        String indexLabel2 = cardInfo.getRewardTag();
        String str = indexLabel2;
        if (!(str == null || str.length() == 0)) {
            TextView textView7 = this.rewardTag;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
            TextView textView8 = this.rewardTag;
            if (textView8 != null) {
                textView8.setText(cardInfo.getRewardTag());
            }
            ViewGroup viewGroup = this.mCardRatioGroup;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardRatioGroup");
                viewGroup = null;
            }
            viewGroup.setVisibility(8);
        } else {
            TextView textView9 = this.rewardTag;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
            renderRatio(cardInfo.getRatio(), cardInfo.getHasGained());
        }
        String it = cardInfo.getName();
        TextView textView10 = this.mCardName;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardName");
            textView10 = null;
        }
        textView10.setText(it);
        ViewGroup viewGroup2 = this.mCardNameGroup;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardNameGroup");
            viewGroup2 = null;
        }
        viewGroup2.setVisibility(0);
        ViewGroup viewGroup3 = this.mCardNameGroup;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardNameGroup");
            viewGroup3 = null;
        }
        viewGroup3.findViewById(R.id.view_name_line_left).setVisibility(it.length() < 12 ? 0 : 8);
        ViewGroup viewGroup4 = this.mCardNameGroup;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardNameGroup");
            viewGroup4 = null;
        }
        viewGroup4.findViewById(R.id.view_name_line_right).setVisibility(it.length() < 12 ? 0 : 8);
        if (!TextUtils.isEmpty(cardInfo.getExtName())) {
            AppCompatTextView appCompatTextView = this.mCardExtTextView;
            if (appCompatTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardExtTextView");
                appCompatTextView = null;
            }
            appCompatTextView.setVisibility(0);
            AppCompatTextView appCompatTextView2 = this.mCardExtTextView;
            if (appCompatTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardExtTextView");
                appCompatTextView2 = null;
            }
            appCompatTextView2.setText(cardInfo.getExtName());
        } else {
            AppCompatTextView appCompatTextView3 = this.mCardExtTextView;
            if (appCompatTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardExtTextView");
                appCompatTextView3 = null;
            }
            appCompatTextView3.setVisibility(8);
        }
        if (cardInfo.getShowExchanged()) {
            View view = this.mExchangeLabel;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExchangeLabel");
                view = null;
            }
            view.setVisibility(0);
        } else {
            View view2 = this.mExchangeLabel;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExchangeLabel");
                view2 = null;
            }
            view2.setVisibility(8);
        }
        if (Intrinsics.areEqual(isFullScreen, true)) {
            NftCardLayoutType type = (cardInfo.getWidth() <= 0 || cardInfo.getHeight() <= 0 || cardInfo.getWidth() <= cardInfo.getHeight()) ? NftCardLayoutType.Vertical : NftCardLayoutType.Horizontal;
            NftCardBgLoader nftCardBgLoader = this.mNftCardBgLoader;
            if (nftCardBgLoader == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNftCardBgLoader");
                nftCardBgLoader = null;
            }
            nftCardBgLoader.showBg(type);
        }
        this.mCurrentCardTypeId = cardInfo.getCardTypeId();
        this.mCurrentCardId = cardInfo.getCardId();
        this.mCurrentAvatarUrl = cardInfo.getImgUrl();
        this.mCurrentCardHash = cardInfo.getHashCode();
        this.mCurrentCardType = cardInfo.getType();
        this.mCurrentCardGained = Boolean.valueOf(cardInfo.getHasGained());
        this.mCurrentCrdMaterialType = Integer.valueOf(cardInfo.getMaterialType());
        this.mCurrentName = cardInfo.getName();
        this.mCurrentLimitInfo = new Pair<>(cardInfo.getCardRightShow(), cardInfo.getCardRight());
        this.mSubtitlesUrl = cardInfo.getSubtitlesUrl();
        this.mPlay = cardInfo.getPlay();
        this.mTag = cardInfo.getTag();
        this.mImgDownloadUrl = cardInfo.getImgDownloadUrl();
        this.mVideoDownloadUrl = cardInfo.getVideoDownloadUrls();
        this.leftTopTagImg = cardInfo.getLeftTopTagImg();
        this.frameImg = cardInfo.getFrameImg();
        onCardItemChanged(containerRenderData, cardInfo);
        MarqueeView marqueeView = this.mSubtitleView;
        if (marqueeView != null) {
            marqueeView.setVisibility(8);
        }
        this.mDLCSubtitles = null;
        DLCPlayModel dLCPlayModel = this.mPlay;
        if (dLCPlayModel != null && dLCPlayModel.getTrialDuration() == 0) {
            downloadSubtitles(this.mSubtitlesUrl);
        }
        LinearLayout linearLayout = this.mTrialLayout;
        if (linearLayout != null) {
            if (this.mPlay != null) {
                DLCPlayModel dLCPlayModel2 = this.mPlay;
                Intrinsics.checkNotNull(dLCPlayModel2);
                if (dLCPlayModel2.getTrialDuration() > 0) {
                    i = 0;
                    linearLayout.setVisibility(i);
                }
            }
            i = 8;
            linearLayout.setVisibility(i);
        }
        if (cardInfo.getType() == NftType.VIDEO) {
            if (!cardInfo.getSilence()) {
                DLCPlayModel dLCPlayModel3 = this.mPlay;
                if (dLCPlayModel3 == null || !dLCPlayModel3.getShowProgressBar()) {
                    z = false;
                }
                if (!z) {
                    AppCompatImageView appCompatImageView2 = this.mSoundSwitch;
                    if (appCompatImageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSoundSwitch");
                    } else {
                        appCompatImageView = appCompatImageView2;
                    }
                    appCompatImageView.setVisibility(0);
                    if (!this.mHasLocalSetting) {
                        this.mVideoMuteState = cardInfo.getSilence();
                    }
                    switchVideoSound(this.mVideoMuteState);
                    return;
                }
            }
            AppCompatImageView appCompatImageView3 = this.mSoundSwitch;
            if (appCompatImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSoundSwitch");
            } else {
                appCompatImageView = appCompatImageView3;
            }
            appCompatImageView.setVisibility(8);
            return;
        }
        this.mNeedResumeVideoAfterAnim = false;
    }

    private final void downloadSubtitles(String url) {
        DLCResDownloader.Companion.downloadJson(this.context, url, new DLCDownlaodCallback() { // from class: tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView$downloadSubtitles$1
            @Override // tv.danmaku.bili.ui.garb.nft.util.DLCDownlaodCallback
            public void success(DLCSubtitles subtitle) {
                DigitalCardDetailBaseView.this.mDLCSubtitles = subtitle;
            }

            @Override // tv.danmaku.bili.ui.garb.nft.util.DLCDownlaodCallback
            public void fail(Throwable t) {
                BLog.e(DLCResDownloader.Companion.getTAG(), "subtitles exception  t: " + t);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSubtitles(int current) {
        CharSequence content;
        MarqueeView marqueeView = this.mSubtitleView;
        if (marqueeView != null) {
            marqueeView.setVisibility((this.mDLCSubtitles == null || this.scrolling) ? 8 : 0);
        }
        DLCSubtitles it = this.mDLCSubtitles;
        if (it != null && (content = findNearestSubtitle(current, it)) != null && !Intrinsics.areEqual(this.mLastSubtitle, content)) {
            MarqueeView marqueeView2 = this.mSubtitleView;
            if (marqueeView2 != null) {
                marqueeView2.startAnimation(content);
            }
            this.mLastSubtitle = content;
        }
    }

    private final CharSequence findNearestSubtitle(int current, DLCSubtitles subtitle) {
        Iterable $this$forEach$iv = subtitle.getUtterances();
        for (Object element$iv : $this$forEach$iv) {
            Utterances it = (Utterances) element$iv;
            if (it.getStartTime() <= current && it.getEndTime() >= current) {
                return it.getTranscript();
            }
        }
        return null;
    }

    protected final void renderRatio(float ratio, boolean hasGained) {
        Integer num;
        Integer num2;
        ViewGroup viewGroup = null;
        if (ratio <= 0.0f) {
            TextView textView = this.mCardRatio;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardRatio");
                textView = null;
            }
            textView.setText("查看持有人");
            ViewGroup viewGroup2 = this.mCardRatioGroup;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardRatioGroup");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility((!hasGained || TextUtils.isEmpty(this.mToHolderListUrl) || (num2 = this.mCurrentCrdMaterialType) == null || num2.intValue() != 1) ? 4 : 0);
            View view = this.mCardRatioArrow;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardRatioArrow");
                view = null;
            }
            if (hasGained && !TextUtils.isEmpty(this.mToHolderListUrl) && (num = this.mCurrentCrdMaterialType) != null && num.intValue() == 1) {
                r3 = 0;
            }
            view.setVisibility(r3);
            ViewGroup viewGroup3 = this.mCardRatioGroup;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardRatioGroup");
            } else {
                viewGroup = viewGroup3;
            }
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DigitalCardDetailBaseView.renderRatio$lambda$0(DigitalCardDetailBaseView.this, view2);
                }
            });
            return;
        }
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String ratioText = "稀有度" + df.format(Float.valueOf(ratio)) + "%";
        TextView textView2 = this.mCardRatio;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardRatio");
            textView2 = null;
        }
        textView2.setText(ratioText);
        View view2 = this.mCardRatioArrow;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardRatioArrow");
            view2 = null;
        }
        view2.setVisibility(TextUtils.isEmpty(this.mToHolderListUrl) ? 4 : 0);
        ViewGroup viewGroup4 = this.mCardRatioGroup;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardRatioGroup");
            viewGroup4 = null;
        }
        viewGroup4.setVisibility(0);
        ViewGroup viewGroup5 = this.mCardRatioGroup;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardRatioGroup");
        } else {
            viewGroup = viewGroup5;
        }
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DigitalCardDetailBaseView.renderRatio$lambda$1(DigitalCardDetailBaseView.this, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderRatio$lambda$0(DigitalCardDetailBaseView this$0, View it) {
        String it2 = this$0.mToHolderListUrl;
        if (it2 != null) {
            SpaceNftUtils.INSTANCE.routeWithMap(it2, this$0.buildParam(), this$0.context);
            this$0.closeContainer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderRatio$lambda$1(DigitalCardDetailBaseView this$0, View it) {
        String it2 = this$0.mToHolderListUrl;
        if (it2 != null) {
            SpaceNftUtils.INSTANCE.routeWithMap(it2, this$0.buildParam(), this$0.context);
            this$0.closeContainer();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map<String, String> buildParam() {
        Map map = new LinkedHashMap();
        map.put("card_type_id", String.valueOf(getCardTypeId()));
        map.put("act_id", String.valueOf(getActivityId()));
        return map;
    }

    public static /* synthetic */ void registerButtonListener$default(DigitalCardDetailBaseView digitalCardDetailBaseView, DigitalFromType digitalFromType, DigitalCardDetailContainerRenderData digitalCardDetailContainerRenderData, DigitalCardDetailRouterInfo digitalCardDetailRouterInfo, Integer num, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerButtonListener");
        }
        if ((i & 8) != 0) {
            num = 1;
        }
        digitalCardDetailBaseView.registerButtonListener(digitalFromType, digitalCardDetailContainerRenderData, digitalCardDetailRouterInfo, num);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerButtonListener(DigitalFromType type, DigitalCardDetailContainerRenderData data, DigitalCardDetailRouterInfo routerInfo, Integer materialType) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        AppCompatImageView appCompatImageView = this.mSoundSwitch;
        if (appCompatImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSoundSwitch");
            appCompatImageView = null;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DigitalCardDetailBaseView.registerButtonListener$lambda$0(DigitalCardDetailBaseView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$0(DigitalCardDetailBaseView this$0, View it) {
        this$0.mHasLocalSetting = true;
        this$0.switchVideoSound(true ^ this$0.mVideoMuteState);
    }

    private final void switchVideoSound(boolean mute) {
        this.mVideoMuteState = mute;
        AppCompatImageView appCompatImageView = null;
        if (mute) {
            AppCompatImageView appCompatImageView2 = this.mSoundSwitch;
            if (appCompatImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSoundSwitch");
            } else {
                appCompatImageView = appCompatImageView2;
            }
            appCompatImageView.setImageResource(com.bilibili.app.authorspace.R.drawable.ic_sound_off);
        } else {
            AppCompatImageView appCompatImageView3 = this.mSoundSwitch;
            if (appCompatImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSoundSwitch");
            } else {
                appCompatImageView = appCompatImageView3;
            }
            appCompatImageView.setImageResource(com.bilibili.app.authorspace.R.drawable.ic_sound_on);
        }
        this.playerManager.setMute(mute);
    }

    public final void onResume() {
    }

    public final void onDestroy() {
        if (this.mFragment == null) {
            BiliCardPlayerManager.INSTANCE.remove(this.context);
        } else {
            BiliCardPlayerManager.INSTANCE.remove(this.mFragment);
        }
    }
}