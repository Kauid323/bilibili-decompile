package kntr.common.ouro.ui.span;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.Editable;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.EditText;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.lifecycle.Lifecycle;
import bili.resource.ouro_editor.R;
import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import com.bilibili.base.BiliContext;
import com.bilibili.compose.iconfont.BiliIconfontChars;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.DrawableAcquireRequestBuilder;
import com.bilibili.lib.image2.ImageMeasureBuilder;
import com.bilibili.lib.image2.bean.DrawableHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.ImageDataSubscriber;
import com.bilibili.lib.image2.bean.utils.DeferredReleaser;
import com.bilibili.lib.image2.bean.utils.DrawableWrapper;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.utils.CoroutineExJvmKt;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.renderable.OuroDivider;
import kntr.common.ouro.core.model.node.renderable.OuroLocalImage;
import kntr.common.ouro.core.model.node.renderable.OuroRemoteImage;
import kntr.common.ouro.core.model.node.renderable.OuroRenderable;
import kntr.common.ouro.core.model.node.renderable.OuroUnrecognizedCard;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageAction;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageState;
import kntr.common.ouro.ui.utils.OuroDrawableUtilsKt;
import kntr.common.ouro.ui.utils.SpannableStringBuilderContext;
import kotlin.KotlinVersion;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroDrawableSpan.kt */
@Metadata(d1 = {"\u0000\u0089\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001v\b\u0001\u0018\u0000 »\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004º\u0001»\u0001B¡\u0001\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010g\u001a\u00020hH\u0016J\u0010\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020%H\u0002J\b\u0010k\u001a\u00020hH\u0002J\u0010\u0010l\u001a\u00020h2\u0006\u0010m\u001a\u00020nH\u0002J\u0010\u0010o\u001a\u00020h2\u0006\u0010m\u001a\u00020pH\u0002J\b\u0010q\u001a\u00020hH\u0002J\b\u0010r\u001a\u00020hH\u0002J\u0010\u0010s\u001a\u00020h2\u0006\u0010m\u001a\u00020\u0007H\u0002J\b\u0010t\u001a\u00020\u0019H\u0002J\r\u0010u\u001a\u00020vH\u0002¢\u0006\u0002\u0010wJ\b\u0010x\u001a\u00020hH\u0002J\b\u0010y\u001a\u00020hH\u0002J\b\u0010z\u001a\u00020hH\u0002J\b\u0010{\u001a\u00020hH\u0002J\b\u0010|\u001a\u00020hH\u0002J'\u0010}\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010j\u001a\u00020%2\u0006\u0010~\u001a\u00020\u007f2\u0007\u0010\u0080\u0001\u001a\u00020SH\u0002J(\u0010}\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010j\u001a\u00020%2\u0006\u0010~\u001a\u00020\u007f2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0002J<\u0010\u0082\u0001\u001a\u00020\u000b2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u000b2\u0007\u0010\u0088\u0001\u001a\u00020\u000b2\t\u0010\u0089\u0001\u001a\u0004\u0018\u000100H\u0016J_\u0010\u008a\u0001\u001a\u00020h2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u000b2\u0007\u0010\u0088\u0001\u001a\u00020\u000b2\u0007\u0010\u008d\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\u000b2\u0007\u0010\u008f\u0001\u001a\u00020\u000b2\u0007\u0010\u0090\u0001\u001a\u00020\u000b2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J<\u0010\u0091\u0001\u001a\u00020\u00192\u0007\u0010\u0092\u0001\u001a\u00020\u000b2\u0007\u0010\u0093\u0001\u001a\u00020\u000b2\u0007\u0010\u0094\u0001\u001a\u00020\u000b2\u0007\u0010\u0095\u0001\u001a\u00020\u000b2\u0007\u0010\u0096\u0001\u001a\u00020\u000bH\u0000¢\u0006\u0003\b\u0097\u0001Jq\u0010\u0098\u0001\u001a\u00020h2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u000b2\u0007\u0010\u0088\u0001\u001a\u00020\u000b2\u0007\u0010\u008d\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\u000b2\u0007\u0010\u008f\u0001\u001a\u00020\u000b2\u0007\u0010\u0090\u0001\u001a\u00020\u000b2\u0007\u0010\u0099\u0001\u001a\u00020\t2\u0007\u0010\u009a\u0001\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\u0013\u0010\u009b\u0001\u001a\u00020h2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0002J\u0012\u0010\u009c\u0001\u001a\u00020\u000b2\u0007\u0010\u0089\u0001\u001a\u000200H\u0002J\u0011\u0010\u009d\u0001\u001a\u00020h2\u0006\u0010j\u001a\u00020%H\u0016J\t\u0010\u009e\u0001\u001a\u00020hH\u0016J\t\u0010\u009f\u0001\u001a\u00020hH\u0002J\t\u0010 \u0001\u001a\u00020hH\u0002J\u001f\u0010¡\u0001\u001a\u00020h2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\n\u0010¢\u0001\u001a\u0005\u0018\u00010£\u0001H\u0002J\u0013\u0010¤\u0001\u001a\u00020h2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0002J\u001d\u0010¥\u0001\u001a\u00020h2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\b\u0010¦\u0001\u001a\u00030§\u0001H\u0002J\u001d\u0010¨\u0001\u001a\u00020h2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\b\u0010¦\u0001\u001a\u00030§\u0001H\u0002J\u0013\u0010©\u0001\u001a\u00020h2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0002J%\u0010ª\u0001\u001a\u00020h2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010«\u0001\u001a\u00020\t2\u0007\u0010¬\u0001\u001a\u00020\tH\u0002J\u001d\u0010\u00ad\u0001\u001a\u00020h2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\b\u0010¦\u0001\u001a\u00030§\u0001H\u0002J\u0007\u0010®\u0001\u001a\u00020\u0019J\t\u0010¯\u0001\u001a\u00020hH\u0002J\t\u0010°\u0001\u001a\u00020hH\u0002J\t\u0010±\u0001\u001a\u00020hH\u0002J\u0012\u0010²\u0001\u001a\u00020h2\u0007\u0010³\u0001\u001a\u00020\u0014H\u0016J&\u0010´\u0001\u001a\u00020h2\u0007\u0010³\u0001\u001a\u00020\u00142\b\u0010µ\u0001\u001a\u00030¶\u00012\b\u0010·\u0001\u001a\u00030¸\u0001H\u0016J\u001c\u0010¹\u0001\u001a\u00020h2\u0007\u0010³\u0001\u001a\u00020\u00142\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00101\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103R\u001b\u00106\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00105\u001a\u0004\b7\u00103R\u001d\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u00105\u001a\u0004\b;\u0010<R\u001b\u0010>\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u00105\u001a\u0004\b?\u0010@R\u001b\u0010B\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u00105\u001a\u0004\bC\u0010@R\u001b\u0010E\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u00105\u001a\u0004\bF\u0010@R\u001b\u0010H\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u00105\u001a\u0004\bJ\u0010KR\u001b\u0010M\u001a\u00020N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u00105\u001a\u0004\bO\u0010PR\u001b\u0010R\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u00105\u001a\u0004\bT\u0010UR\u001b\u0010W\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u00105\u001a\u0004\bX\u00103R\u001b\u0010Z\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u00105\u001a\u0004\b[\u00103R\u0011\u0010]\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b]\u0010^R\u001e\u0010`\u001a\u00020\u00192\u0006\u0010_\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\ba\u0010^R\u0011\u0010b\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0011\u0010e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bf\u0010d¨\u0006¼\u0001"}, d2 = {"Lkntr/common/ouro/ui/span/OuroDrawableSpan;", "Landroid/text/style/ReplacementSpan;", "Lcom/bilibili/lib/image2/bean/utils/DeferredReleaser$Releasable;", "Lkntr/common/ouro/ui/span/AttachableSpan;", "Landroid/graphics/drawable/Drawable$Callback;", "nodes", "", "Lkntr/common/ouro/core/model/node/OuroNode;", "density", "", "drawableWidth", "", "drawableHeight", "spannableContext", "Lkntr/common/ouro/ui/utils/SpannableStringBuilderContext;", "pl", "pt", "pr", "pb", "placeHolderDrawable", "Landroid/graphics/drawable/Drawable;", "errorDrawable", "verticalAlignment", "Lkntr/common/ouro/ui/span/OuroDrawableSpan$Alignment;", "isDarkTheme", "", "shouldClipRoundedCorner", "tintColor", "Lkntr/common/ouro/core/model/mark/OuroColor;", "<init>", "(Ljava/util/List;FIILkntr/common/ouro/ui/utils/SpannableStringBuilderContext;IIIILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lkntr/common/ouro/ui/span/OuroDrawableSpan$Alignment;ZZLkntr/common/ouro/core/model/mark/OuroColor;)V", "mockLifecycle", "Lkntr/common/ouro/ui/span/MockLifecycle;", "actualPlaceHolderDrawable", "actualDrawable", "Lcom/bilibili/lib/image2/bean/utils/DrawableWrapper;", "attachedView", "Landroid/view/View;", "dataSource", "Lcom/bilibili/lib/image2/bean/ImageDataSource;", "Lcom/bilibili/lib/image2/bean/DrawableHolder;", "isAnimationEnabled", "currentAnimatable", "Landroid/graphics/drawable/Animatable;", "rotationAnimator", "Landroid/animation/ValueAnimator;", "currentRotation", "drawFontMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "minDrawableSizeToShowFailedText", "getMinDrawableSizeToShowFailedText", "()F", "minDrawableSizeToShowFailedText$delegate", "Lkotlin/Lazy;", "imageCornerRadius", "getImageCornerRadius", "imageCornerRadius$delegate", "imageCornerClipPath", "Landroid/graphics/Path;", "getImageCornerClipPath", "()Landroid/graphics/Path;", "imageCornerClipPath$delegate", "dividerDrawable", "getDividerDrawable", "()Landroid/graphics/drawable/Drawable;", "dividerDrawable$delegate", "unrecognizedCardDrawable", "getUnrecognizedCardDrawable", "unrecognizedCardDrawable$delegate", "failIconDrawable", "getFailIconDrawable", "failIconDrawable$delegate", "loadBitmapRectCache", "Landroid/graphics/RectF;", "getLoadBitmapRectCache", "()Landroid/graphics/RectF;", "loadBitmapRectCache$delegate", "retryTextPaint", "Landroid/text/TextPaint;", "getRetryTextPaint", "()Landroid/text/TextPaint;", "retryTextPaint$delegate", "retryText", "", "getRetryText", "()Ljava/lang/String;", "retryText$delegate", "retryTextOffsetXPx", "getRetryTextOffsetXPx", "retryTextOffsetXPx$delegate", "retryTextOffsetYPx", "getRetryTextOffsetYPx", "retryTextOffsetYPx$delegate", "isAttached", "()Z", "value", "willRelease", "getWillRelease", "width", "getWidth", "()I", "height", "getHeight", "release", "", "attach", "view", "detach", "loadRemoteImage", "node", "Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage;", "loadLocalImage", "Lkntr/common/ouro/core/model/node/renderable/OuroLocalImage;", "loadDivider", "loadUnrecognizedCard", "tryLoadImage", "checkExistingDataSource", "createImageDataSubscriber", "kntr/common/ouro/ui/span/OuroDrawableSpan$createImageDataSubscriber$1", "()Lkntr/common/ouro/ui/span/OuroDrawableSpan$createImageDataSubscriber$1;", "resetDataSource", "applyErrorSource", "applyDataSource", "startAnimationIfNeeded", "stopAnimation", "obtainImageDataSource", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "imageUri", "Landroid/net/Uri;", "getSize", "paint", "Landroid/graphics/Paint;", "text", "", "start", "end", "fm", "draw", "canvas", "Landroid/graphics/Canvas;", "x", "top", "y", "bottom", "checkVisibility", "spanTop", "spanBottom", "visibleTop", "visibleBottom", "buffer", "checkVisibility$ui_debug", "drawInternal", "transX", "transY", "drawContent", "getOffsetAboveBaseline", "onAttach", "onDetach", "startUploadAnimation", "stopUploadAnimation", "drawUploadState", "uploadState", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;", "drawUploadingOverlay", "drawSpinningLoader", "bounds", "Landroid/graphics/Rect;", "drawFallbackSpinningLoader", "drawFailureOverlay", "drawFailIcon", "centerX", "centerY", "drawRetryText", "handleClick", "postInvalidate", "regularInvalidate", "experimentalInvalidate", "invalidateDrawable", "who", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "", "unscheduleDrawable", "Alignment", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroDrawableSpan extends ReplacementSpan implements DeferredReleaser.Releasable, AttachableSpan, Drawable.Callback {
    private static final float DEFAULT_ICON_SIZE = 20.0f;
    private static final float IMAGE_CORNER_RADIUS = 4.0f;
    private static final float MIN_DRAWABLE_SIZE_TO_SHOW_FAILED_TEXT = 60.0f;
    private static final float RETRY_TEXT_FONT_SIZE = 10.0f;
    private static final float RETRY_TEXT_TO_ICON_PADDING = 4.0f;
    private static final Paint loaderBgPaint;
    private static final Paint loadingBitmapPaint;
    private final DrawableWrapper actualDrawable;
    private final Drawable actualPlaceHolderDrawable;
    private View attachedView;
    private Animatable currentAnimatable;
    private float currentRotation;
    private ImageDataSource<DrawableHolder> dataSource;
    private final float density;
    private final Lazy dividerDrawable$delegate;
    private final Paint.FontMetricsInt drawFontMetrics;
    private final int drawableHeight;
    private final int drawableWidth;
    private final Drawable errorDrawable;
    private final Lazy failIconDrawable$delegate;
    private final int height;
    private final Lazy imageCornerClipPath$delegate;
    private final Lazy imageCornerRadius$delegate;
    private boolean isAnimationEnabled;
    private final boolean isDarkTheme;
    private final Lazy loadBitmapRectCache$delegate;
    private final Lazy minDrawableSizeToShowFailedText$delegate;
    private MockLifecycle mockLifecycle;
    private final List<OuroNode> nodes;
    private final int pb;
    private final int pl;
    private final Drawable placeHolderDrawable;
    private final int pr;
    private final int pt;
    private final Lazy retryText$delegate;
    private final Lazy retryTextOffsetXPx$delegate;
    private final Lazy retryTextOffsetYPx$delegate;
    private final Lazy retryTextPaint$delegate;
    private ValueAnimator rotationAnimator;
    private final boolean shouldClipRoundedCorner;
    private final SpannableStringBuilderContext spannableContext;
    private final OuroColor tintColor;
    private final Lazy unrecognizedCardDrawable$delegate;
    private final Alignment verticalAlignment;
    private final int width;
    private boolean willRelease;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<Drawable> EMPTY_DRAWABLE$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda3
        public final Object invoke() {
            Drawable EMPTY_DRAWABLE_delegate$lambda$0;
            EMPTY_DRAWABLE_delegate$lambda$0 = OuroDrawableSpan.EMPTY_DRAWABLE_delegate$lambda$0();
            return EMPTY_DRAWABLE_delegate$lambda$0;
        }
    });
    private static final Lazy<Bitmap> loadingBitmap$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda4
        public final Object invoke() {
            Bitmap loadingBitmap_delegate$lambda$0;
            loadingBitmap_delegate$lambda$0 = OuroDrawableSpan.loadingBitmap_delegate$lambda$0();
            return loadingBitmap_delegate$lambda$0;
        }
    });
    private static final Lazy<Paint> overlayPaint$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda5
        public final Object invoke() {
            Paint overlayPaint_delegate$lambda$0;
            overlayPaint_delegate$lambda$0 = OuroDrawableSpan.overlayPaint_delegate$lambda$0();
            return overlayPaint_delegate$lambda$0;
        }
    });
    private static final Lazy<Paint> loaderPaint$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda6
        public final Object invoke() {
            Paint loaderPaint_delegate$lambda$0;
            loaderPaint_delegate$lambda$0 = OuroDrawableSpan.loaderPaint_delegate$lambda$0();
            return loaderPaint_delegate$lambda$0;
        }
    });

    /* compiled from: OuroDrawableSpan.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lkntr/common/ouro/ui/span/OuroDrawableSpan$Alignment;", "", "<init>", "(Ljava/lang/String;I)V", "BOTTOM_TO_DESCENT", "BOTTOM_TO_BOTTOM", "BOTTOM_TO_BASELINE", "BOTTOM_TO_CENTER", "CENTER_TO_CENTER", "TOP_TO_CENTER", "TOP_TO_ASCENT", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public enum Alignment {
        BOTTOM_TO_DESCENT,
        BOTTOM_TO_BOTTOM,
        BOTTOM_TO_BASELINE,
        BOTTOM_TO_CENTER,
        CENTER_TO_CENTER,
        TOP_TO_CENTER,
        TOP_TO_ASCENT;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Alignment> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: OuroDrawableSpan.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Alignment.values().length];
            try {
                iArr[Alignment.BOTTOM_TO_DESCENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Alignment.BOTTOM_TO_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Alignment.CENTER_TO_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Alignment.BOTTOM_TO_BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Alignment.BOTTOM_TO_CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Alignment.TOP_TO_ASCENT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[Alignment.TOP_TO_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OuroDrawableSpan(List<? extends OuroNode> list, float density, int drawableWidth, int drawableHeight, SpannableStringBuilderContext spannableContext, int pl, int pt, int pr, int pb, Drawable placeHolderDrawable, Drawable errorDrawable, Alignment verticalAlignment, boolean isDarkTheme, boolean shouldClipRoundedCorner, OuroColor tintColor) {
        Intrinsics.checkNotNullParameter(spannableContext, "spannableContext");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.nodes = list;
        this.density = density;
        this.drawableWidth = drawableWidth;
        this.drawableHeight = drawableHeight;
        this.spannableContext = spannableContext;
        this.pl = pl;
        this.pt = pt;
        this.pr = pr;
        this.pb = pb;
        this.placeHolderDrawable = placeHolderDrawable;
        this.errorDrawable = errorDrawable;
        this.verticalAlignment = verticalAlignment;
        this.isDarkTheme = isDarkTheme;
        this.shouldClipRoundedCorner = shouldClipRoundedCorner;
        this.tintColor = tintColor;
        Drawable drawable = this.placeHolderDrawable;
        this.actualPlaceHolderDrawable = drawable == null ? Companion.getEMPTY_DRAWABLE() : drawable;
        this.actualDrawable = new DrawableWrapper(this.actualPlaceHolderDrawable);
        this.isAnimationEnabled = true;
        this.drawFontMetrics = new Paint.FontMetricsInt();
        this.minDrawableSizeToShowFailedText$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda7
            public final Object invoke() {
                float minDrawableSizeToShowFailedText_delegate$lambda$0;
                minDrawableSizeToShowFailedText_delegate$lambda$0 = OuroDrawableSpan.minDrawableSizeToShowFailedText_delegate$lambda$0(OuroDrawableSpan.this);
                return Float.valueOf(minDrawableSizeToShowFailedText_delegate$lambda$0);
            }
        });
        this.imageCornerRadius$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda9
            public final Object invoke() {
                float imageCornerRadius_delegate$lambda$0;
                imageCornerRadius_delegate$lambda$0 = OuroDrawableSpan.imageCornerRadius_delegate$lambda$0(OuroDrawableSpan.this);
                return Float.valueOf(imageCornerRadius_delegate$lambda$0);
            }
        });
        this.imageCornerClipPath$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda10
            public final Object invoke() {
                Path imageCornerClipPath_delegate$lambda$0;
                imageCornerClipPath_delegate$lambda$0 = OuroDrawableSpan.imageCornerClipPath_delegate$lambda$0(OuroDrawableSpan.this);
                return imageCornerClipPath_delegate$lambda$0;
            }
        });
        this.dividerDrawable$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda11
            public final Object invoke() {
                Drawable dividerDrawable_delegate$lambda$0;
                dividerDrawable_delegate$lambda$0 = OuroDrawableSpan.dividerDrawable_delegate$lambda$0(OuroDrawableSpan.this);
                return dividerDrawable_delegate$lambda$0;
            }
        });
        this.unrecognizedCardDrawable$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda12
            public final Object invoke() {
                Drawable unrecognizedCardDrawable_delegate$lambda$0;
                unrecognizedCardDrawable_delegate$lambda$0 = OuroDrawableSpan.unrecognizedCardDrawable_delegate$lambda$0(OuroDrawableSpan.this);
                return unrecognizedCardDrawable_delegate$lambda$0;
            }
        });
        this.failIconDrawable$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda13
            public final Object invoke() {
                Drawable failIconDrawable_delegate$lambda$0;
                failIconDrawable_delegate$lambda$0 = OuroDrawableSpan.failIconDrawable_delegate$lambda$0(OuroDrawableSpan.this);
                return failIconDrawable_delegate$lambda$0;
            }
        });
        this.loadBitmapRectCache$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda14
            public final Object invoke() {
                RectF loadBitmapRectCache_delegate$lambda$0;
                loadBitmapRectCache_delegate$lambda$0 = OuroDrawableSpan.loadBitmapRectCache_delegate$lambda$0();
                return loadBitmapRectCache_delegate$lambda$0;
            }
        });
        this.retryTextPaint$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda15
            public final Object invoke() {
                TextPaint retryTextPaint_delegate$lambda$0;
                retryTextPaint_delegate$lambda$0 = OuroDrawableSpan.retryTextPaint_delegate$lambda$0(OuroDrawableSpan.this);
                return retryTextPaint_delegate$lambda$0;
            }
        });
        this.retryText$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda1
            public final Object invoke() {
                String retryText_delegate$lambda$0;
                retryText_delegate$lambda$0 = OuroDrawableSpan.retryText_delegate$lambda$0();
                return retryText_delegate$lambda$0;
            }
        });
        this.retryTextOffsetXPx$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda2
            public final Object invoke() {
                float retryTextOffsetXPx_delegate$lambda$0;
                retryTextOffsetXPx_delegate$lambda$0 = OuroDrawableSpan.retryTextOffsetXPx_delegate$lambda$0(OuroDrawableSpan.this);
                return Float.valueOf(retryTextOffsetXPx_delegate$lambda$0);
            }
        });
        this.retryTextOffsetYPx$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda8
            public final Object invoke() {
                float retryTextOffsetYPx_delegate$lambda$0;
                retryTextOffsetYPx_delegate$lambda$0 = OuroDrawableSpan.retryTextOffsetYPx_delegate$lambda$0(OuroDrawableSpan.this);
                return Float.valueOf(retryTextOffsetYPx_delegate$lambda$0);
            }
        });
        this.width = this.drawableWidth + this.pl + this.pr;
        this.height = this.drawableHeight + this.pt + this.pb;
        this.actualDrawable.setBounds(0, 0, this.drawableWidth, this.drawableHeight);
        this.actualDrawable.setCallback(this);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ OuroDrawableSpan(List list, float f, int i, int i2, SpannableStringBuilderContext spannableStringBuilderContext, int i3, int i4, int i5, int i6, Drawable drawable, Drawable drawable2, Alignment alignment, boolean z, boolean z2, OuroColor ouroColor, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, f, i, i2, spannableStringBuilderContext, r9, r10, r11, r12, r13, (i7 & 1024) != 0 ? r13 : drawable2, (i7 & 2048) != 0 ? Alignment.CENTER_TO_CENTER : alignment, (i7 & 4096) != 0 ? false : z, (i7 & 8192) != 0 ? false : z2, (i7 & 16384) != 0 ? null : ouroColor);
        int i8 = (i7 & 32) != 0 ? 0 : i3;
        int i9 = (i7 & 64) != 0 ? 0 : i4;
        int i10 = (i7 & 128) != 0 ? 0 : i5;
        int i11 = (i7 & 256) != 0 ? 0 : i6;
        Drawable drawable3 = (i7 & 512) != 0 ? null : drawable;
    }

    /* compiled from: OuroDrawableSpan.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lkntr/common/ouro/ui/span/OuroDrawableSpan$Companion;", "", "<init>", "()V", "EMPTY_DRAWABLE", "Landroid/graphics/drawable/Drawable;", "getEMPTY_DRAWABLE", "()Landroid/graphics/drawable/Drawable;", "EMPTY_DRAWABLE$delegate", "Lkotlin/Lazy;", "createEmptyDrawable", "loadingBitmap", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "getLoadingBitmap", "()Landroid/graphics/Bitmap;", "loadingBitmap$delegate", "overlayPaint", "Landroid/graphics/Paint;", "getOverlayPaint", "()Landroid/graphics/Paint;", "overlayPaint$delegate", "loaderPaint", "getLoaderPaint", "loaderPaint$delegate", "loaderBgPaint", "loadingBitmapPaint", "DEFAULT_ICON_SIZE", "", "MIN_DRAWABLE_SIZE_TO_SHOW_FAILED_TEXT", "RETRY_TEXT_FONT_SIZE", "RETRY_TEXT_TO_ICON_PADDING", "IMAGE_CORNER_RADIUS", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Drawable getEMPTY_DRAWABLE() {
            return (Drawable) OuroDrawableSpan.EMPTY_DRAWABLE$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Drawable createEmptyDrawable() {
            GradientDrawable drawable = new GradientDrawable();
            drawable.setShape(0);
            drawable.setSize(100, 100);
            drawable.setColor(ColorKt.toArgb-8_81llA(Color.Companion.getTransparent-0d7_KjU()));
            drawable.setStroke(1, ColorKt.toArgb-8_81llA(Color.Companion.getTransparent-0d7_KjU()));
            return drawable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bitmap getLoadingBitmap() {
            return (Bitmap) OuroDrawableSpan.loadingBitmap$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Paint getOverlayPaint() {
            return (Paint) OuroDrawableSpan.overlayPaint$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Paint getLoaderPaint() {
            return (Paint) OuroDrawableSpan.loaderPaint$delegate.getValue();
        }
    }

    static {
        Paint $this$loaderBgPaint_u24lambda_u240 = new Paint();
        $this$loaderBgPaint_u24lambda_u240.setColor(ColorKt.toArgb-8_81llA(Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null)));
        $this$loaderBgPaint_u24lambda_u240.setStyle(Paint.Style.STROKE);
        $this$loaderBgPaint_u24lambda_u240.setStrokeWidth(1.0f);
        $this$loaderBgPaint_u24lambda_u240.setAntiAlias(true);
        loaderBgPaint = $this$loaderBgPaint_u24lambda_u240;
        Paint $this$loadingBitmapPaint_u24lambda_u240 = new Paint();
        $this$loadingBitmapPaint_u24lambda_u240.setAntiAlias(true);
        loadingBitmapPaint = $this$loadingBitmapPaint_u24lambda_u240;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable EMPTY_DRAWABLE_delegate$lambda$0() {
        return Companion.createEmptyDrawable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap loadingBitmap_delegate$lambda$0() {
        return (Bitmap) CoroutineExJvmKt.variantRunBlocking$default(null, new OuroDrawableSpan$Companion$loadingBitmap$2$1(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint overlayPaint_delegate$lambda$0() {
        Paint $this$overlayPaint_delegate_u24lambda_u240_u240 = new Paint();
        $this$overlayPaint_delegate_u24lambda_u240_u240.setColor(ColorKt.toArgb-8_81llA(Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null)));
        $this$overlayPaint_delegate_u24lambda_u240_u240.setStyle(Paint.Style.FILL);
        $this$overlayPaint_delegate_u24lambda_u240_u240.setAntiAlias(true);
        return $this$overlayPaint_delegate_u24lambda_u240_u240;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint loaderPaint_delegate$lambda$0() {
        Paint $this$loaderPaint_delegate_u24lambda_u240_u240 = new Paint();
        $this$loaderPaint_delegate_u24lambda_u240_u240.setColor(ColorKt.toArgb-8_81llA(Color.Companion.getWhite-0d7_KjU()));
        $this$loaderPaint_delegate_u24lambda_u240_u240.setStyle(Paint.Style.STROKE);
        $this$loaderPaint_delegate_u24lambda_u240_u240.setAntiAlias(true);
        $this$loaderPaint_delegate_u24lambda_u240_u240.setStrokeWidth(1.0f);
        return $this$loaderPaint_delegate_u24lambda_u240_u240;
    }

    private final float getMinDrawableSizeToShowFailedText() {
        return ((Number) this.minDrawableSizeToShowFailedText$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float minDrawableSizeToShowFailedText_delegate$lambda$0(OuroDrawableSpan this$0) {
        return this$0.density * MIN_DRAWABLE_SIZE_TO_SHOW_FAILED_TEXT;
    }

    private final float getImageCornerRadius() {
        return ((Number) this.imageCornerRadius$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float imageCornerRadius_delegate$lambda$0(OuroDrawableSpan this$0) {
        return this$0.density * 4.0f;
    }

    private final Path getImageCornerClipPath() {
        return (Path) this.imageCornerClipPath$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Path imageCornerClipPath_delegate$lambda$0(OuroDrawableSpan this$0) {
        if (this$0.shouldClipRoundedCorner) {
            Path $this$imageCornerClipPath_delegate_u24lambda_u240_u240 = new Path();
            $this$imageCornerClipPath_delegate_u24lambda_u240_u240.addRoundRect(0.0f, 0.0f, this$0.drawableWidth, this$0.drawableHeight, this$0.getImageCornerRadius(), this$0.getImageCornerRadius(), Path.Direction.CW);
            return $this$imageCornerClipPath_delegate_u24lambda_u240_u240;
        }
        return null;
    }

    private final Drawable getDividerDrawable() {
        return (Drawable) this.dividerDrawable$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable dividerDrawable_delegate$lambda$0(OuroDrawableSpan this$0) {
        return OuroDrawableUtilsKt.createDividerDrawable(this$0.isDarkTheme, this$0.density);
    }

    private final Drawable getUnrecognizedCardDrawable() {
        return (Drawable) this.unrecognizedCardDrawable$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable unrecognizedCardDrawable_delegate$lambda$0(OuroDrawableSpan this$0) {
        return OuroDrawableUtilsKt.createUnrecognizedCardDrawable(this$0.isDarkTheme, this$0.density, DEFAULT_ICON_SIZE);
    }

    private final Drawable getFailIconDrawable() {
        return (Drawable) this.failIconDrawable$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable failIconDrawable_delegate$lambda$0(OuroDrawableSpan this$0) {
        return OuroDrawableUtilsKt.createIconFontDrawable(BiliIconfontChars.INSTANCE.getArrow_replay_line_500(), DEFAULT_ICON_SIZE, ColorKt.toArgb-8_81llA((this$0.isDarkTheme ? BiliColorsSourceKt.getNightColors() : BiliColorsSourceKt.getDayColors()).getText_white-0d7_KjU()), this$0.density);
    }

    private final RectF getLoadBitmapRectCache() {
        return (RectF) this.loadBitmapRectCache$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RectF loadBitmapRectCache_delegate$lambda$0() {
        return new RectF();
    }

    private final TextPaint getRetryTextPaint() {
        return (TextPaint) this.retryTextPaint$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextPaint retryTextPaint_delegate$lambda$0(OuroDrawableSpan this$0) {
        TextPaint $this$retryTextPaint_delegate_u24lambda_u240_u240 = new TextPaint();
        $this$retryTextPaint_delegate_u24lambda_u240_u240.setColor(ColorKt.toArgb-8_81llA((this$0.isDarkTheme ? BiliColorsSourceKt.getNightColors() : BiliColorsSourceKt.getDayColors()).getText_white-0d7_KjU()));
        $this$retryTextPaint_delegate_u24lambda_u240_u240.setTextSize(this$0.density * RETRY_TEXT_FONT_SIZE);
        $this$retryTextPaint_delegate_u24lambda_u240_u240.setAntiAlias(true);
        $this$retryTextPaint_delegate_u24lambda_u240_u240.setStyle(Paint.Style.FILL);
        return $this$retryTextPaint_delegate_u24lambda_u240_u240;
    }

    private final String getRetryText() {
        return (String) this.retryText$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String retryText_delegate$lambda$0() {
        String string;
        Activity activity = BiliContext.topActivity();
        if (activity == null || (string = activity.getString(R.string.ouro_editor_global_string_22)) == null) {
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            String string2 = application.getString(R.string.ouro_editor_global_string_22);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        return string;
    }

    private final float getRetryTextOffsetXPx() {
        return ((Number) this.retryTextOffsetXPx$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float retryTextOffsetXPx_delegate$lambda$0(OuroDrawableSpan this$0) {
        return (-this$0.getRetryTextPaint().measureText(this$0.getRetryText())) / 2;
    }

    private final float getRetryTextOffsetYPx() {
        return ((Number) this.retryTextOffsetYPx$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float retryTextOffsetYPx_delegate$lambda$0(OuroDrawableSpan this$0) {
        return (this$0.density * 24.0f) - this$0.getRetryTextPaint().ascent();
    }

    public final boolean isAttached() {
        return this.attachedView != null;
    }

    public final boolean getWillRelease() {
        return this.willRelease;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public void release() {
        this.willRelease = false;
        stopAnimation();
        stopUploadAnimation();
        this.attachedView = null;
        resetDataSource();
        MockLifecycle mockLifecycle = this.mockLifecycle;
        if (mockLifecycle != null) {
            mockLifecycle.setCurrentState(Lifecycle.State.DESTROYED);
        }
        this.mockLifecycle = null;
    }

    private final void attach(View view) {
        Object element$iv;
        DeferredReleaser.INSTANCE.cancelDeferredRelease(this);
        this.willRelease = false;
        if (!Intrinsics.areEqual(this.attachedView, view)) {
            this.attachedView = view;
        }
        if (this.mockLifecycle == null) {
            MockLifecycle $this$attach_u24lambda_u240 = new MockLifecycle();
            $this$attach_u24lambda_u240.setCurrentState(Lifecycle.State.CREATED);
            this.mockLifecycle = $this$attach_u24lambda_u240;
        }
        Iterable iterable = this.nodes;
        if (iterable != null) {
            Iterable $this$firstOrNull$iv = iterable;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    element$iv = null;
                    break;
                }
                element$iv = it.next();
                OuroNode it2 = (OuroNode) element$iv;
                if (it2 instanceof OuroRenderable.BuiltIn) {
                    break;
                }
            }
            OuroNode node = (OuroNode) element$iv;
            if (node == null) {
                return;
            }
            tryLoadImage(node);
        }
    }

    private final void detach() {
        if (!isAttached()) {
            return;
        }
        this.willRelease = true;
        DeferredReleaser.INSTANCE.scheduleDeferredRelease(this);
    }

    private final void loadRemoteImage(OuroRemoteImage node) {
        MockLifecycle lifecycle;
        String url = node.getLightImageURL();
        View view = this.attachedView;
        if (view == null || (lifecycle = this.mockLifecycle) == null || checkExistingDataSource()) {
            return;
        }
        this.dataSource = obtainImageDataSource(view, lifecycle, url);
        ImageDataSource<DrawableHolder> imageDataSource = this.dataSource;
        if (imageDataSource != null) {
            imageDataSource.subscribe(createImageDataSubscriber());
        }
    }

    private final void loadLocalImage(OuroLocalImage node) {
        MockLifecycle lifecycle;
        View view = this.attachedView;
        if (view == null || (lifecycle = this.mockLifecycle) == null || checkExistingDataSource()) {
            return;
        }
        CoroutineExJvmKt.variantRunBlocking$default(null, new OuroDrawableSpan$loadLocalImage$1(node, this, view, lifecycle, null), 1, null);
    }

    private final void loadDivider() {
        this.actualDrawable.setCurrent(getDividerDrawable());
    }

    private final void loadUnrecognizedCard() {
        this.actualDrawable.setCurrent(getUnrecognizedCardDrawable());
    }

    private final void tryLoadImage(OuroNode node) {
        if (!(node instanceof OuroRemoteImage)) {
            if (!(node instanceof OuroLocalImage)) {
                if (!(node instanceof OuroDivider)) {
                    if (node instanceof OuroUnrecognizedCard) {
                        loadUnrecognizedCard();
                        return;
                    }
                    return;
                }
                loadDivider();
                return;
            }
            loadLocalImage((OuroLocalImage) node);
            return;
        }
        loadRemoteImage((OuroRemoteImage) node);
    }

    private final boolean checkExistingDataSource() {
        ImageDataSource it = this.dataSource;
        if (it != null) {
            if (it.hasFailed().booleanValue() || it.isClosed()) {
                resetDataSource();
                return false;
            } else if (it.isFinished()) {
                applyDataSource();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [kntr.common.ouro.ui.span.OuroDrawableSpan$createImageDataSubscriber$1] */
    public final OuroDrawableSpan$createImageDataSubscriber$1 createImageDataSubscriber() {
        return new ImageDataSubscriber<DrawableHolder>() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$createImageDataSubscriber$1
            public /* synthetic */ void onProgressUpdate(ImageDataSource imageDataSource) {
                ImageDataSubscriber.-CC.$default$onProgressUpdate(this, imageDataSource);
            }

            public void onResult(ImageDataSource<DrawableHolder> imageDataSource) {
                ImageDataSource imageDataSource2;
                imageDataSource2 = OuroDrawableSpan.this.dataSource;
                if (Intrinsics.areEqual(imageDataSource2, imageDataSource)) {
                    OuroDrawableSpan.this.applyDataSource();
                }
            }

            public void onFailure(ImageDataSource<DrawableHolder> imageDataSource) {
                ImageDataSource imageDataSource2;
                OuroDrawableSpan.this.applyErrorSource();
                imageDataSource2 = OuroDrawableSpan.this.dataSource;
                if (Intrinsics.areEqual(imageDataSource2, imageDataSource)) {
                    OuroDrawableSpan.this.resetDataSource();
                } else if (imageDataSource != null) {
                    imageDataSource.close();
                }
            }

            public void onCancellation(ImageDataSource<DrawableHolder> imageDataSource) {
                ImageDataSource imageDataSource2;
                imageDataSource2 = OuroDrawableSpan.this.dataSource;
                if (Intrinsics.areEqual(imageDataSource2, imageDataSource)) {
                    OuroDrawableSpan.this.resetDataSource();
                } else if (imageDataSource != null) {
                    imageDataSource.close();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetDataSource() {
        ImageDataSource<DrawableHolder> imageDataSource = this.dataSource;
        if (imageDataSource != null) {
            imageDataSource.close();
        }
        this.dataSource = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyErrorSource() {
        DrawableWrapper drawableWrapper = this.actualDrawable;
        Drawable drawable = this.errorDrawable;
        if (drawable == null) {
            drawable = Companion.getEMPTY_DRAWABLE();
        }
        drawableWrapper.setCurrent(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if (r3 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void applyDataSource() {
        ImageDataSource<DrawableHolder> imageDataSource;
        DrawableHolder drawableHolder;
        Drawable drawable;
        Drawable drawable2;
        if (isAttached() && (imageDataSource = this.dataSource) != null && (drawableHolder = (DrawableHolder) imageDataSource.getResult()) != null && (drawable = drawableHolder.get()) != null) {
            DrawableWrapper drawableWrapper = this.actualDrawable;
            OuroColor it = this.tintColor;
            if (it != null) {
                drawable2 = OuroDrawableUtilsKt.tint(drawable, this.isDarkTheme ? it.getDarkColor() : it.getLightColor());
            }
            drawable2 = drawable;
            drawableWrapper.setCurrent(drawable2);
            startAnimationIfNeeded();
        }
    }

    private final void startAnimationIfNeeded() {
        if (!this.isAnimationEnabled || !isAttached()) {
            return;
        }
        Drawable current = this.actualDrawable.getCurrent();
        Animatable animatable = current instanceof Animatable ? (Animatable) current : null;
        if (animatable != null && !animatable.isRunning()) {
            this.currentAnimatable = animatable;
            animatable.start();
        }
    }

    private final void stopAnimation() {
        Animatable animatable = this.currentAnimatable;
        if (animatable != null && animatable.isRunning()) {
            animatable.stop();
        }
        this.currentAnimatable = null;
    }

    private final ImageDataSource<DrawableHolder> obtainImageDataSource(View view, Lifecycle lifecycle, String imageUri) {
        int width;
        int height;
        BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ImageMeasureBuilder $this$obtainImageDataSource_u24lambda_u240 = biliImageLoader.acquire(context, lifecycle);
        int picPixels = this.drawableWidth * this.drawableHeight;
        if (picPixels > 524288) {
            double picRatio = this.drawableWidth / this.drawableHeight;
            height = (int) (this.drawableHeight * Math.sqrt(524288 / picPixels));
            width = (int) (height * picRatio);
        } else {
            width = this.drawableWidth;
            height = this.drawableHeight;
        }
        return DrawableAcquireRequestBuilder.enableAnimatable$default($this$obtainImageDataSource_u24lambda_u240.with(width, height).asDrawable().noLimitWidth().url(imageUri), 0, true, 1, (Object) null).submit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageDataSource<DrawableHolder> obtainImageDataSource(View view, Lifecycle lifecycle, Uri imageUri) {
        BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return DrawableAcquireRequestBuilder.enableAnimatable$default(biliImageLoader.acquire(context, lifecycle).with(this.drawableWidth, this.drawableHeight).asDrawable().noLimitWidth().url(imageUri), 0, true, 1, (Object) null).submit();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (fm != null) {
            int offsetAbove = getOffsetAboveBaseline(fm);
            int offsetBelow = this.height + offsetAbove;
            if (offsetAbove < fm.ascent) {
                fm.ascent = offsetAbove;
            }
            if (offsetAbove < fm.top) {
                fm.top = offsetAbove;
            }
            if (offsetBelow > fm.descent) {
                fm.descent = offsetBelow;
            }
            if (offsetBelow > fm.bottom) {
                fm.bottom = offsetBelow;
            }
        }
        return this.width;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (!isAttached()) {
            return;
        }
        paint.getFontMetricsInt(this.drawFontMetrics);
        int iconTop = y + getOffsetAboveBaseline(this.drawFontMetrics) + this.pt;
        drawInternal(canvas, text, start, end, x, top, y, bottom, x + this.pl, iconTop, paint);
    }

    public final boolean checkVisibility$ui_debug(int spanTop, int spanBottom, int visibleTop, int visibleBottom, int buffer) {
        return spanTop <= visibleBottom + buffer && spanBottom >= visibleTop - buffer;
    }

    private final void drawInternal(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, float transX, float transY, Paint paint) {
        int checkpoint$iv = canvas.save();
        canvas.translate(transX, transY);
        try {
            Path clipPath = getImageCornerClipPath();
            if (clipPath == null) {
                drawContent(canvas);
            } else {
                int checkpoint$iv2 = canvas.save();
                canvas.clipPath(clipPath);
                drawContent(canvas);
                canvas.restoreToCount(checkpoint$iv2);
            }
        } finally {
            canvas.restoreToCount(checkpoint$iv);
        }
    }

    private final void drawContent(Canvas canvas) {
        OuroNode ouroNode;
        boolean isValid;
        Object element$iv;
        Iterable iterable = this.nodes;
        if (iterable == null) {
            ouroNode = null;
        } else {
            Iterable $this$firstOrNull$iv = iterable;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    OuroNode it2 = (OuroNode) element$iv;
                    if (it2 instanceof OuroRenderable.BuiltIn) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            ouroNode = (OuroNode) element$iv;
        }
        OuroNode node = ouroNode;
        isValid = OuroDrawableSpanKt.isValid(this.actualDrawable);
        if (isValid) {
            this.actualDrawable.draw(canvas);
        }
        if (node != null && (node instanceof OuroLocalImage)) {
            OuroLocalImageState localImageState = this.spannableContext.getLocalImageState();
            UploadTaskState uploadState = localImageState != null ? localImageState.getTaskState().get(((OuroLocalImage) node).getAsset().getIdentifier()) : null;
            boolean shouldShowUploadUI = !Intrinsics.areEqual(uploadState, UploadTaskState.Success.Companion);
            if (shouldShowUploadUI) {
                drawUploadState(canvas, uploadState);
            }
            if (uploadState instanceof UploadTaskState.Unfinished) {
                startUploadAnimation();
            } else if ((uploadState instanceof UploadTaskState.Success) || (uploadState instanceof UploadTaskState.Failure)) {
                stopUploadAnimation();
            } else if (uploadState != null) {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    private final int getOffsetAboveBaseline(Paint.FontMetricsInt fm) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.verticalAlignment.ordinal()]) {
            case 1:
                return fm.descent - this.height;
            case 2:
                return fm.bottom - this.height;
            case 3:
                int textHeight = fm.descent - fm.ascent;
                int offset = (textHeight - this.height) / 2;
                int textHeight2 = fm.ascent + offset;
                return textHeight2;
            case 4:
                return -this.height;
            case 5:
                int center = (fm.descent + fm.ascent) / 2;
                return center - this.height;
            case 6:
                return fm.ascent;
            case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                int center2 = (fm.descent + fm.ascent) / 2;
                return center2 + this.height;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // kntr.common.ouro.ui.span.AttachableSpan
    public void onAttach(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        attach(view);
    }

    @Override // kntr.common.ouro.ui.span.AttachableSpan
    public void onDetach() {
        detach();
    }

    private final void startUploadAnimation() {
        if (this.rotationAnimator == null) {
            ValueAnimator $this$startUploadAnimation_u24lambda_u240 = ValueAnimator.ofFloat(0.0f, 360.0f);
            $this$startUploadAnimation_u24lambda_u240.setDuration(1000L);
            $this$startUploadAnimation_u24lambda_u240.setRepeatCount(-1);
            $this$startUploadAnimation_u24lambda_u240.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: kntr.common.ouro.ui.span.OuroDrawableSpan$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    OuroDrawableSpan.startUploadAnimation$lambda$0$0(OuroDrawableSpan.this, valueAnimator);
                }
            });
            this.rotationAnimator = $this$startUploadAnimation_u24lambda_u240;
        }
        ValueAnimator it = this.rotationAnimator;
        if (it != null && !it.isStarted()) {
            it.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startUploadAnimation$lambda$0$0(OuroDrawableSpan this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.currentRotation = ((Float) animatedValue).floatValue();
        this$0.postInvalidate();
    }

    private final void stopUploadAnimation() {
        ValueAnimator valueAnimator = this.rotationAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.rotationAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
        }
        this.rotationAnimator = null;
        this.currentRotation = 0.0f;
    }

    private final void drawUploadState(Canvas canvas, UploadTaskState uploadState) {
        if (!(uploadState instanceof UploadTaskState.Unfinished)) {
            if (uploadState instanceof UploadTaskState.Failure) {
                drawFailureOverlay(canvas);
                return;
            }
            return;
        }
        drawUploadingOverlay(canvas);
    }

    private final void drawUploadingOverlay(Canvas canvas) {
        Rect bounds = this.actualDrawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        if (bounds.isEmpty()) {
            return;
        }
        canvas.drawRect(bounds, Companion.getOverlayPaint());
        drawSpinningLoader(canvas, bounds);
    }

    private final void drawSpinningLoader(Canvas canvas, Rect bounds) {
        float centerX = bounds.centerX();
        float centerY = bounds.centerY();
        Bitmap bitmap = Companion.getLoadingBitmap();
        if (bitmap == null) {
            OuroDrawableSpan $this$drawSpinningLoader_u24lambda_u241 = this;
            $this$drawSpinningLoader_u24lambda_u241.drawFallbackSpinningLoader(canvas, bounds);
            return;
        }
        float iconSize = this.density * DEFAULT_ICON_SIZE;
        float f = 2;
        float left = centerX - (iconSize / f);
        float top = centerY - (iconSize / f);
        float right = (iconSize / f) + centerX;
        float bottom = centerY + (iconSize / f);
        getLoadBitmapRectCache().set(left, top, right, bottom);
        float degrees$iv = this.currentRotation;
        int checkpoint$iv = canvas.save();
        canvas.rotate(degrees$iv, centerX, centerY);
        try {
            try {
                try {
                    canvas.drawBitmap(bitmap, (Rect) null, getLoadBitmapRectCache(), loadingBitmapPaint);
                    canvas.restoreToCount(checkpoint$iv);
                } catch (Throwable th) {
                    th = th;
                    canvas.restoreToCount(checkpoint$iv);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private final void drawFallbackSpinningLoader(Canvas canvas, Rect bounds) {
        int checkpoint$iv;
        Canvas $this$withRotation$iv;
        Paint.Cap cap;
        float centerX = bounds.centerX();
        float centerY = bounds.centerY();
        float radius = this.density * DEFAULT_ICON_SIZE;
        canvas.drawCircle(centerX, centerY, radius, loaderBgPaint);
        float anglePerSegment = 270.0f / 30;
        float degrees$iv = this.currentRotation;
        float pivotY$iv = centerY;
        Canvas $this$withRotation$iv2 = canvas;
        float pivotX$iv = centerX;
        int checkpoint$iv2 = $this$withRotation$iv2.save();
        $this$withRotation$iv2.rotate(degrees$iv, pivotX$iv, pivotY$iv);
        boolean z = false;
        int i = 0;
        while (i < 30) {
            float segmentStartAngle = (i * anglePerSegment) - 90.0f;
            boolean z2 = z;
            float alphaProgress = i / (30 - 1);
            int alpha = (int) ((1 - (0.9f * alphaProgress)) * 1.0f * ((float) KotlinVersion.MAX_COMPONENT_VALUE));
            try {
                Paint $this$drawFallbackSpinningLoader_u24lambda_u240_u240 = Companion.getLoaderPaint();
                $this$drawFallbackSpinningLoader_u24lambda_u240_u240.setAlpha(alpha);
                if (i != 0) {
                    cap = Paint.Cap.BUTT;
                } else {
                    try {
                        cap = Paint.Cap.ROUND;
                    } catch (Throwable th) {
                        th = th;
                        checkpoint$iv = checkpoint$iv2;
                        $this$withRotation$iv = $this$withRotation$iv2;
                        $this$withRotation$iv.restoreToCount(checkpoint$iv);
                        throw th;
                    }
                }
                $this$drawFallbackSpinningLoader_u24lambda_u240_u240.setStrokeCap(cap);
                int i2 = i;
                checkpoint$iv = checkpoint$iv2;
                float pivotX$iv2 = pivotX$iv;
                $this$withRotation$iv = $this$withRotation$iv2;
                float pivotY$iv2 = pivotY$iv;
                float degrees$iv2 = degrees$iv;
                try {
                    $this$withRotation$iv2.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius, segmentStartAngle, anglePerSegment, false, Companion.getLoaderPaint());
                    i = i2 + 1;
                    pivotX$iv = pivotX$iv2;
                    z = z2;
                    pivotY$iv = pivotY$iv2;
                    checkpoint$iv2 = checkpoint$iv;
                    $this$withRotation$iv2 = $this$withRotation$iv;
                    degrees$iv = degrees$iv2;
                } catch (Throwable th2) {
                    th = th2;
                    $this$withRotation$iv.restoreToCount(checkpoint$iv);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                checkpoint$iv = checkpoint$iv2;
                $this$withRotation$iv = $this$withRotation$iv2;
            }
        }
        $this$withRotation$iv2.restoreToCount(checkpoint$iv2);
    }

    private final void drawFailureOverlay(Canvas canvas) {
        Rect bounds = this.actualDrawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        if (bounds.isEmpty()) {
            return;
        }
        canvas.drawRect(bounds, Companion.getOverlayPaint());
        float centerX = bounds.centerX();
        float centerY = bounds.centerY();
        drawFailIcon(canvas, centerX, centerY);
        if (this.drawableHeight > getMinDrawableSizeToShowFailedText() * this.density && this.drawableWidth > getMinDrawableSizeToShowFailedText() * this.density) {
            drawRetryText(canvas, bounds);
        }
    }

    private final void drawFailIcon(Canvas canvas, float centerX, float centerY) {
        Drawable iconDrawable = getFailIconDrawable();
        int left = (int) (centerX - (iconDrawable.getIntrinsicWidth() / 2));
        int top = (int) (centerY - (iconDrawable.getIntrinsicHeight() / 2));
        int right = (int) ((iconDrawable.getIntrinsicWidth() / 2) + centerX);
        int bottom = (int) ((iconDrawable.getIntrinsicHeight() / 2) + centerY);
        iconDrawable.setBounds(left, top, right, bottom);
        iconDrawable.draw(canvas);
    }

    private final void drawRetryText(Canvas canvas, Rect bounds) {
        float textX = bounds.centerX() + getRetryTextOffsetXPx();
        float textY = bounds.centerY() + getRetryTextOffsetYPx();
        canvas.drawText(getRetryText(), textX, textY, getRetryTextPaint());
    }

    public final boolean handleClick() {
        OuroNode ouroNode;
        Object element$iv;
        Iterable iterable = this.nodes;
        if (iterable != null) {
            Iterable $this$firstOrNull$iv = iterable;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    OuroNode it2 = (OuroNode) element$iv;
                    if (it2 instanceof OuroLocalImage) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            ouroNode = (OuroNode) element$iv;
        } else {
            ouroNode = null;
        }
        OuroLocalImage ouroLocalImage = ouroNode instanceof OuroLocalImage ? (OuroLocalImage) ouroNode : null;
        if (ouroLocalImage == null) {
            return false;
        }
        OuroLocalImage node = ouroLocalImage;
        OuroLocalImageState localImageState = this.spannableContext.getLocalImageState();
        UploadTaskState uploadState = localImageState != null ? localImageState.getTaskState().get(node.getAsset().getIdentifier()) : null;
        if (uploadState instanceof UploadTaskState.Failure) {
            String assetId = node.getAsset().getIdentifier();
            Function1<OuroAction, Unit> dispatcher = this.spannableContext.getDispatcher();
            if (dispatcher != null) {
                dispatcher.invoke(new OuroLocalImageAction.RetryUploadImage(assetId));
                return true;
            }
            return true;
        }
        return false;
    }

    private final void postInvalidate() {
        if (OuroDrawableUtilsKt.getUseExperimentalRender()) {
            experimentalInvalidate();
        } else {
            regularInvalidate();
        }
    }

    private final void regularInvalidate() {
        View view = this.attachedView;
        if (view != null) {
            view.postInvalidate();
        }
    }

    private final void experimentalInvalidate() {
        Editable editableText;
        View view = this.attachedView;
        EditText editText = view instanceof EditText ? (EditText) view : null;
        if (editText == null || (editableText = editText.getEditableText()) == null) {
            return;
        }
        Integer valueOf = Integer.valueOf(editableText.getSpanStart(this));
        int it = valueOf.intValue();
        int it2 = it >= 0 ? 1 : 0;
        if (it2 == 0) {
            valueOf = null;
        }
        if (valueOf == null) {
            return;
        }
        int start = valueOf.intValue();
        Integer valueOf2 = Integer.valueOf(editableText.getSpanEnd(this));
        int it3 = valueOf2.intValue();
        Integer num = it3 >= 0 ? valueOf2 : null;
        if (num == null) {
            return;
        }
        int end = num.intValue();
        int flag = editableText.getSpanFlags(this);
        editableText.setSpan(this, start, end, flag);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        postInvalidate();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        View view = this.attachedView;
        if (view != null) {
            view.scheduleDrawable(who, what, when);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable who, Runnable what) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        View view = this.attachedView;
        if (view != null) {
            view.unscheduleDrawable(who, what);
        }
    }
}