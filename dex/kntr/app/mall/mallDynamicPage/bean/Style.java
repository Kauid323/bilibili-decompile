package kntr.app.mall.mallDynamicPage.bean;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Style.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bk\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u009d\u00012\u00020\u0001:\u0004\u009c\u0001\u009d\u0001B\u009f\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b%\u0010&B\u0083\u0002\b\u0010\u0012\u0006\u0010'\u001a\u00020$\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u0011\u0012\u0006\u0010\u001e\u001a\u00020\u0011\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010 \u001a\u0004\u0018\u00010!\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\u0010#\u001a\u0004\u0018\u00010$\u0012\b\u0010(\u001a\u0004\u0018\u00010)¢\u0006\u0004\b%\u0010*J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010DJ\t\u0010~\u001a\u00020\u0011HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0011HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0011HÆ\u0003J\u0011\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010gJ\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010!HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010!HÆ\u0003J\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010$HÆ\u0003¢\u0006\u0002\u0010rJ¨\u0002\u0010\u008e\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$HÆ\u0001¢\u0006\u0003\u0010\u008f\u0001J\u0015\u0010\u0090\u0001\u001a\u00020\u000f2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0092\u0001\u001a\u00020$HÖ\u0001J\n\u0010\u0093\u0001\u001a\u00020\u0003HÖ\u0001J-\u0010\u0094\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u00002\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0001¢\u0006\u0003\b\u009b\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00102\"\u0004\b6\u00104R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010\u0012\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010I\"\u0004\bM\u0010KR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010,\"\u0004\bS\u0010.R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010,\"\u0004\bU\u0010.R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010,\"\u0004\bW\u0010.R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010,\"\u0004\bY\u0010.R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010,\"\u0004\b[\u0010.R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010,\"\u0004\b]\u0010.R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010\u001d\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010I\"\u0004\bc\u0010KR\u001a\u0010\u001e\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010I\"\u0004\be\u0010KR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010j\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001c\u0010\"\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010l\"\u0004\bp\u0010nR\u001e\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u0010\n\u0002\u0010u\u001a\u0004\bq\u0010r\"\u0004\bs\u0010t¨\u0006\u009e\u0001"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Style;", RoomRecommendViewModel.EMPTY_CURSOR, "width", RoomRecommendViewModel.EMPTY_CURSOR, "height", "padding", "Lkntr/app/mall/mallDynamicPage/bean/Rect;", "margin", "background", "Lkntr/app/mall/mallDynamicPage/bean/Background;", "border", "Lkntr/app/mall/mallDynamicPage/bean/Border;", "clip", "Lkntr/app/mall/mallDynamicPage/bean/Clip;", "clipToBounds", RoomRecommendViewModel.EMPTY_CURSOR, "zIndex", RoomRecommendViewModel.EMPTY_CURSOR, "alpha", "shadow", "Lkntr/app/mall/mallDynamicPage/bean/Shadow;", "verticalArrangement", "horizontalAlignment", "verticalAlignment", "horizontalArrangement", "contentAlignment", "align", "offset", "Lkntr/app/mall/mallDynamicPage/bean/Position;", "rotate", "scale", "weight", "widthIn", "Lkntr/app/mall/mallDynamicPage/bean/Range;", "heightIn", "blur", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/mallDynamicPage/bean/Rect;Lkntr/app/mall/mallDynamicPage/bean/Rect;Lkntr/app/mall/mallDynamicPage/bean/Background;Lkntr/app/mall/mallDynamicPage/bean/Border;Lkntr/app/mall/mallDynamicPage/bean/Clip;Ljava/lang/Boolean;FFLkntr/app/mall/mallDynamicPage/bean/Shadow;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/mallDynamicPage/bean/Position;FFLjava/lang/Float;Lkntr/app/mall/mallDynamicPage/bean/Range;Lkntr/app/mall/mallDynamicPage/bean/Range;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkntr/app/mall/mallDynamicPage/bean/Rect;Lkntr/app/mall/mallDynamicPage/bean/Rect;Lkntr/app/mall/mallDynamicPage/bean/Background;Lkntr/app/mall/mallDynamicPage/bean/Border;Lkntr/app/mall/mallDynamicPage/bean/Clip;Ljava/lang/Boolean;FFLkntr/app/mall/mallDynamicPage/bean/Shadow;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/mallDynamicPage/bean/Position;FFLjava/lang/Float;Lkntr/app/mall/mallDynamicPage/bean/Range;Lkntr/app/mall/mallDynamicPage/bean/Range;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWidth", "()Ljava/lang/String;", "setWidth", "(Ljava/lang/String;)V", "getHeight", "setHeight", "getPadding", "()Lkntr/app/mall/mallDynamicPage/bean/Rect;", "setPadding", "(Lkntr/app/mall/mallDynamicPage/bean/Rect;)V", "getMargin", "setMargin", "getBackground", "()Lkntr/app/mall/mallDynamicPage/bean/Background;", "setBackground", "(Lkntr/app/mall/mallDynamicPage/bean/Background;)V", "getBorder", "()Lkntr/app/mall/mallDynamicPage/bean/Border;", "setBorder", "(Lkntr/app/mall/mallDynamicPage/bean/Border;)V", "getClip", "()Lkntr/app/mall/mallDynamicPage/bean/Clip;", "setClip", "(Lkntr/app/mall/mallDynamicPage/bean/Clip;)V", "getClipToBounds", "()Ljava/lang/Boolean;", "setClipToBounds", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getZIndex", "()F", "setZIndex", "(F)V", "getAlpha", "setAlpha", "getShadow", "()Lkntr/app/mall/mallDynamicPage/bean/Shadow;", "setShadow", "(Lkntr/app/mall/mallDynamicPage/bean/Shadow;)V", "getVerticalArrangement", "setVerticalArrangement", "getHorizontalAlignment", "setHorizontalAlignment", "getVerticalAlignment", "setVerticalAlignment", "getHorizontalArrangement", "setHorizontalArrangement", "getContentAlignment", "setContentAlignment", "getAlign", "setAlign", "getOffset", "()Lkntr/app/mall/mallDynamicPage/bean/Position;", "setOffset", "(Lkntr/app/mall/mallDynamicPage/bean/Position;)V", "getRotate", "setRotate", "getScale", "setScale", "getWeight", "()Ljava/lang/Float;", "setWeight", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getWidthIn", "()Lkntr/app/mall/mallDynamicPage/bean/Range;", "setWidthIn", "(Lkntr/app/mall/mallDynamicPage/bean/Range;)V", "getHeightIn", "setHeightIn", "getBlur", "()Ljava/lang/Integer;", "setBlur", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/mallDynamicPage/bean/Rect;Lkntr/app/mall/mallDynamicPage/bean/Rect;Lkntr/app/mall/mallDynamicPage/bean/Background;Lkntr/app/mall/mallDynamicPage/bean/Border;Lkntr/app/mall/mallDynamicPage/bean/Clip;Ljava/lang/Boolean;FFLkntr/app/mall/mallDynamicPage/bean/Shadow;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/mallDynamicPage/bean/Position;FFLjava/lang/Float;Lkntr/app/mall/mallDynamicPage/bean/Range;Lkntr/app/mall/mallDynamicPage/bean/Range;Ljava/lang/Integer;)Lkntr/app/mall/mallDynamicPage/bean/Style;", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$mallDynamicPage_debug", "$serializer", "Companion", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class Style {
    private String align;
    private float alpha;
    private Background background;
    private Integer blur;
    private Border border;
    private Clip clip;
    private Boolean clipToBounds;
    private String contentAlignment;
    private String height;
    private Range heightIn;
    private String horizontalAlignment;
    private String horizontalArrangement;
    private Rect margin;
    private Position offset;
    private Rect padding;
    private float rotate;
    private float scale;
    private Shadow shadow;
    private String verticalAlignment;
    private String verticalArrangement;
    private Float weight;
    private String width;
    private Range widthIn;
    private float zIndex;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public Style() {
        this((String) null, (String) null, (Rect) null, (Rect) null, (Background) null, (Border) null, (Clip) null, (Boolean) null, 0.0f, 0.0f, (Shadow) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Position) null, 0.0f, 0.0f, (Float) null, (Range) null, (Range) null, (Integer) null, 16777215, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.width;
    }

    public final float component10() {
        return this.alpha;
    }

    public final Shadow component11() {
        return this.shadow;
    }

    public final String component12() {
        return this.verticalArrangement;
    }

    public final String component13() {
        return this.horizontalAlignment;
    }

    public final String component14() {
        return this.verticalAlignment;
    }

    public final String component15() {
        return this.horizontalArrangement;
    }

    public final String component16() {
        return this.contentAlignment;
    }

    public final String component17() {
        return this.align;
    }

    public final Position component18() {
        return this.offset;
    }

    public final float component19() {
        return this.rotate;
    }

    public final String component2() {
        return this.height;
    }

    public final float component20() {
        return this.scale;
    }

    public final Float component21() {
        return this.weight;
    }

    public final Range component22() {
        return this.widthIn;
    }

    public final Range component23() {
        return this.heightIn;
    }

    public final Integer component24() {
        return this.blur;
    }

    public final Rect component3() {
        return this.padding;
    }

    public final Rect component4() {
        return this.margin;
    }

    public final Background component5() {
        return this.background;
    }

    public final Border component6() {
        return this.border;
    }

    public final Clip component7() {
        return this.clip;
    }

    public final Boolean component8() {
        return this.clipToBounds;
    }

    public final float component9() {
        return this.zIndex;
    }

    public final Style copy(String str, String str2, Rect rect, Rect rect2, Background background, Border border, Clip clip, Boolean bool, float f, float f2, Shadow shadow, String str3, String str4, String str5, String str6, String str7, String str8, Position position, float f3, float f4, Float f5, Range range, Range range2, Integer num) {
        return new Style(str, str2, rect, rect2, background, border, clip, bool, f, f2, shadow, str3, str4, str5, str6, str7, str8, position, f3, f4, f5, range, range2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Style) {
            Style style = (Style) obj;
            return Intrinsics.areEqual(this.width, style.width) && Intrinsics.areEqual(this.height, style.height) && Intrinsics.areEqual(this.padding, style.padding) && Intrinsics.areEqual(this.margin, style.margin) && Intrinsics.areEqual(this.background, style.background) && Intrinsics.areEqual(this.border, style.border) && Intrinsics.areEqual(this.clip, style.clip) && Intrinsics.areEqual(this.clipToBounds, style.clipToBounds) && Float.compare(this.zIndex, style.zIndex) == 0 && Float.compare(this.alpha, style.alpha) == 0 && Intrinsics.areEqual(this.shadow, style.shadow) && Intrinsics.areEqual(this.verticalArrangement, style.verticalArrangement) && Intrinsics.areEqual(this.horizontalAlignment, style.horizontalAlignment) && Intrinsics.areEqual(this.verticalAlignment, style.verticalAlignment) && Intrinsics.areEqual(this.horizontalArrangement, style.horizontalArrangement) && Intrinsics.areEqual(this.contentAlignment, style.contentAlignment) && Intrinsics.areEqual(this.align, style.align) && Intrinsics.areEqual(this.offset, style.offset) && Float.compare(this.rotate, style.rotate) == 0 && Float.compare(this.scale, style.scale) == 0 && Intrinsics.areEqual(this.weight, style.weight) && Intrinsics.areEqual(this.widthIn, style.widthIn) && Intrinsics.areEqual(this.heightIn, style.heightIn) && Intrinsics.areEqual(this.blur, style.blur);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((this.width == null ? 0 : this.width.hashCode()) * 31) + (this.height == null ? 0 : this.height.hashCode())) * 31) + (this.padding == null ? 0 : this.padding.hashCode())) * 31) + (this.margin == null ? 0 : this.margin.hashCode())) * 31) + (this.background == null ? 0 : this.background.hashCode())) * 31) + (this.border == null ? 0 : this.border.hashCode())) * 31) + (this.clip == null ? 0 : this.clip.hashCode())) * 31) + (this.clipToBounds == null ? 0 : this.clipToBounds.hashCode())) * 31) + Float.floatToIntBits(this.zIndex)) * 31) + Float.floatToIntBits(this.alpha)) * 31) + (this.shadow == null ? 0 : this.shadow.hashCode())) * 31) + (this.verticalArrangement == null ? 0 : this.verticalArrangement.hashCode())) * 31) + (this.horizontalAlignment == null ? 0 : this.horizontalAlignment.hashCode())) * 31) + (this.verticalAlignment == null ? 0 : this.verticalAlignment.hashCode())) * 31) + (this.horizontalArrangement == null ? 0 : this.horizontalArrangement.hashCode())) * 31) + (this.contentAlignment == null ? 0 : this.contentAlignment.hashCode())) * 31) + (this.align == null ? 0 : this.align.hashCode())) * 31) + (this.offset == null ? 0 : this.offset.hashCode())) * 31) + Float.floatToIntBits(this.rotate)) * 31) + Float.floatToIntBits(this.scale)) * 31) + (this.weight == null ? 0 : this.weight.hashCode())) * 31) + (this.widthIn == null ? 0 : this.widthIn.hashCode())) * 31) + (this.heightIn == null ? 0 : this.heightIn.hashCode())) * 31) + (this.blur != null ? this.blur.hashCode() : 0);
    }

    public String toString() {
        String str = this.width;
        String str2 = this.height;
        Rect rect = this.padding;
        Rect rect2 = this.margin;
        Background background = this.background;
        Border border = this.border;
        Clip clip = this.clip;
        Boolean bool = this.clipToBounds;
        float f = this.zIndex;
        float f2 = this.alpha;
        Shadow shadow = this.shadow;
        String str3 = this.verticalArrangement;
        String str4 = this.horizontalAlignment;
        String str5 = this.verticalAlignment;
        String str6 = this.horizontalArrangement;
        String str7 = this.contentAlignment;
        String str8 = this.align;
        Position position = this.offset;
        float f3 = this.rotate;
        float f4 = this.scale;
        Float f5 = this.weight;
        Range range = this.widthIn;
        Range range2 = this.heightIn;
        return "Style(width=" + str + ", height=" + str2 + ", padding=" + rect + ", margin=" + rect2 + ", background=" + background + ", border=" + border + ", clip=" + clip + ", clipToBounds=" + bool + ", zIndex=" + f + ", alpha=" + f2 + ", shadow=" + shadow + ", verticalArrangement=" + str3 + ", horizontalAlignment=" + str4 + ", verticalAlignment=" + str5 + ", horizontalArrangement=" + str6 + ", contentAlignment=" + str7 + ", align=" + str8 + ", offset=" + position + ", rotate=" + f3 + ", scale=" + f4 + ", weight=" + f5 + ", widthIn=" + range + ", heightIn=" + range2 + ", blur=" + this.blur + ")";
    }

    /* compiled from: Style.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Style$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/mallDynamicPage/bean/Style;", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Style> serializer() {
            return new GeneratedSerializer<Style>() { // from class: kntr.app.mall.mallDynamicPage.bean.Style$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.mallDynamicPage.bean.Style", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.mallDynamicPage.bean.Style> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.mallDynamicPage.bean.Style> A[REMOVE]) =  kntr.app.mall.mallDynamicPage.bean.Style$$serializer.INSTANCE kntr.app.mall.mallDynamicPage.bean.Style$$serializer)
                         in method: kntr.app.mall.mallDynamicPage.bean.Style.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.mallDynamicPage.bean.Style>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                          ("kntr.app.mall.mallDynamicPage.bean.Style")
                          (wrap: kntr.app.mall.mallDynamicPage.bean.Style$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.mallDynamicPage.bean.Style$$serializer A[REMOVE]) =  kntr.app.mall.mallDynamicPage.bean.Style$$serializer.INSTANCE kntr.app.mall.mallDynamicPage.bean.Style$$serializer)
                          (24 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.mallDynamicPage.bean.Style$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.mallDynamicPage.bean.Style$$serializer
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
                        kntr.app.mall.mallDynamicPage.bean.Style$$serializer r0 = kntr.app.mall.mallDynamicPage.bean.Style$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.mallDynamicPage.bean.Style.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ Style(int seen0, String width, String height, Rect padding, Rect margin, Background background, Border border, Clip clip, Boolean clipToBounds, float zIndex, float alpha, Shadow shadow, String verticalArrangement, String horizontalAlignment, String verticalAlignment, String horizontalArrangement, String contentAlignment, String align, Position offset, float rotate, float scale, Float weight, Range widthIn, Range heightIn, Integer blur, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.width = null;
                } else {
                    this.width = width;
                }
                if ((seen0 & 2) == 0) {
                    this.height = null;
                } else {
                    this.height = height;
                }
                if ((seen0 & 4) == 0) {
                    this.padding = null;
                } else {
                    this.padding = padding;
                }
                if ((seen0 & 8) == 0) {
                    this.margin = null;
                } else {
                    this.margin = margin;
                }
                if ((seen0 & 16) == 0) {
                    this.background = null;
                } else {
                    this.background = background;
                }
                if ((seen0 & 32) == 0) {
                    this.border = null;
                } else {
                    this.border = border;
                }
                if ((seen0 & 64) == 0) {
                    this.clip = null;
                } else {
                    this.clip = clip;
                }
                if ((seen0 & 128) == 0) {
                    this.clipToBounds = null;
                } else {
                    this.clipToBounds = clipToBounds;
                }
                if ((seen0 & 256) == 0) {
                    this.zIndex = 0.0f;
                } else {
                    this.zIndex = zIndex;
                }
                if ((seen0 & 512) == 0) {
                    this.alpha = 1.0f;
                } else {
                    this.alpha = alpha;
                }
                if ((seen0 & 1024) == 0) {
                    this.shadow = null;
                } else {
                    this.shadow = shadow;
                }
                if ((seen0 & 2048) == 0) {
                    this.verticalArrangement = null;
                } else {
                    this.verticalArrangement = verticalArrangement;
                }
                if ((seen0 & 4096) == 0) {
                    this.horizontalAlignment = null;
                } else {
                    this.horizontalAlignment = horizontalAlignment;
                }
                if ((seen0 & 8192) == 0) {
                    this.verticalAlignment = null;
                } else {
                    this.verticalAlignment = verticalAlignment;
                }
                if ((seen0 & 16384) == 0) {
                    this.horizontalArrangement = null;
                } else {
                    this.horizontalArrangement = horizontalArrangement;
                }
                if ((seen0 & 32768) == 0) {
                    this.contentAlignment = null;
                } else {
                    this.contentAlignment = contentAlignment;
                }
                if ((seen0 & 65536) == 0) {
                    this.align = null;
                } else {
                    this.align = align;
                }
                if ((seen0 & 131072) == 0) {
                    this.offset = null;
                } else {
                    this.offset = offset;
                }
                if ((seen0 & 262144) == 0) {
                    this.rotate = 0.0f;
                } else {
                    this.rotate = rotate;
                }
                if ((seen0 & 524288) == 0) {
                    this.scale = 1.0f;
                } else {
                    this.scale = scale;
                }
                if ((seen0 & 1048576) == 0) {
                    this.weight = null;
                } else {
                    this.weight = weight;
                }
                if ((seen0 & 2097152) == 0) {
                    this.widthIn = null;
                } else {
                    this.widthIn = widthIn;
                }
                if ((seen0 & 4194304) == 0) {
                    this.heightIn = null;
                } else {
                    this.heightIn = heightIn;
                }
                if ((seen0 & 8388608) == 0) {
                    this.blur = null;
                } else {
                    this.blur = blur;
                }
            }

            public Style(String width, String height, Rect padding, Rect margin, Background background, Border border, Clip clip, Boolean clipToBounds, float zIndex, float alpha, Shadow shadow, String verticalArrangement, String horizontalAlignment, String verticalAlignment, String horizontalArrangement, String contentAlignment, String align, Position offset, float rotate, float scale, Float weight, Range widthIn, Range heightIn, Integer blur) {
                this.width = width;
                this.height = height;
                this.padding = padding;
                this.margin = margin;
                this.background = background;
                this.border = border;
                this.clip = clip;
                this.clipToBounds = clipToBounds;
                this.zIndex = zIndex;
                this.alpha = alpha;
                this.shadow = shadow;
                this.verticalArrangement = verticalArrangement;
                this.horizontalAlignment = horizontalAlignment;
                this.verticalAlignment = verticalAlignment;
                this.horizontalArrangement = horizontalArrangement;
                this.contentAlignment = contentAlignment;
                this.align = align;
                this.offset = offset;
                this.rotate = rotate;
                this.scale = scale;
                this.weight = weight;
                this.widthIn = widthIn;
                this.heightIn = heightIn;
                this.blur = blur;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$mallDynamicPage_debug(Style self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.width != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.width);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.height != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.height);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.padding != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, Rect$$serializer.INSTANCE, self.padding);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.margin != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, Rect$$serializer.INSTANCE, self.margin);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.background != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, Background$$serializer.INSTANCE, self.background);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.border != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, Border$$serializer.INSTANCE, self.border);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.clip != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, Clip$$serializer.INSTANCE, self.clip);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.clipToBounds != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.clipToBounds);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || Float.compare(self.zIndex, 0.0f) != 0) {
                    output.encodeFloatElement(serialDesc, 8, self.zIndex);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || Float.compare(self.alpha, 1.0f) != 0) {
                    output.encodeFloatElement(serialDesc, 9, self.alpha);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.shadow != null) {
                    output.encodeNullableSerializableElement(serialDesc, 10, Shadow$$serializer.INSTANCE, self.shadow);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.verticalArrangement != null) {
                    output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.verticalArrangement);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 12) || self.horizontalAlignment != null) {
                    output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.horizontalAlignment);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.verticalAlignment != null) {
                    output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.verticalAlignment);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 14) || self.horizontalArrangement != null) {
                    output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.horizontalArrangement);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.contentAlignment != null) {
                    output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.contentAlignment);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 16) || self.align != null) {
                    output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.align);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 17) || self.offset != null) {
                    output.encodeNullableSerializableElement(serialDesc, 17, Position$$serializer.INSTANCE, self.offset);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 18) || Float.compare(self.rotate, 0.0f) != 0) {
                    output.encodeFloatElement(serialDesc, 18, self.rotate);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 19) || Float.compare(self.scale, 1.0f) != 0) {
                    output.encodeFloatElement(serialDesc, 19, self.scale);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 20) || self.weight != null) {
                    output.encodeNullableSerializableElement(serialDesc, 20, FloatSerializer.INSTANCE, self.weight);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 21) || self.widthIn != null) {
                    output.encodeNullableSerializableElement(serialDesc, 21, Range$$serializer.INSTANCE, self.widthIn);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 22) || self.heightIn != null) {
                    output.encodeNullableSerializableElement(serialDesc, 22, Range$$serializer.INSTANCE, self.heightIn);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 23) || self.blur != null) {
                    output.encodeNullableSerializableElement(serialDesc, 23, IntSerializer.INSTANCE, self.blur);
                }
            }

            public /* synthetic */ Style(String str, String str2, Rect rect, Rect rect2, Background background, Border border, Clip clip, Boolean bool, float f, float f2, Shadow shadow, String str3, String str4, String str5, String str6, String str7, String str8, Position position, float f3, float f4, Float f5, Range range, Range range2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : rect, (i & 8) != 0 ? null : rect2, (i & 16) != 0 ? null : background, (i & 32) != 0 ? null : border, (i & 64) != 0 ? null : clip, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? 0.0f : f, (i & 512) != 0 ? 1.0f : f2, (i & 1024) != 0 ? null : shadow, (i & 2048) != 0 ? null : str3, (i & 4096) != 0 ? null : str4, (i & 8192) != 0 ? null : str5, (i & 16384) != 0 ? null : str6, (i & 32768) != 0 ? null : str7, (i & 65536) != 0 ? null : str8, (i & 131072) != 0 ? null : position, (i & 262144) != 0 ? 0.0f : f3, (i & 524288) != 0 ? 1.0f : f4, (i & 1048576) != 0 ? null : f5, (i & 2097152) != 0 ? null : range, (i & 4194304) != 0 ? null : range2, (i & 8388608) != 0 ? null : num);
            }

            public final String getWidth() {
                return this.width;
            }

            public final void setWidth(String str) {
                this.width = str;
            }

            public final String getHeight() {
                return this.height;
            }

            public final void setHeight(String str) {
                this.height = str;
            }

            public final Rect getPadding() {
                return this.padding;
            }

            public final void setPadding(Rect rect) {
                this.padding = rect;
            }

            public final Rect getMargin() {
                return this.margin;
            }

            public final void setMargin(Rect rect) {
                this.margin = rect;
            }

            public final Background getBackground() {
                return this.background;
            }

            public final void setBackground(Background background) {
                this.background = background;
            }

            public final Border getBorder() {
                return this.border;
            }

            public final void setBorder(Border border) {
                this.border = border;
            }

            public final Clip getClip() {
                return this.clip;
            }

            public final void setClip(Clip clip) {
                this.clip = clip;
            }

            public final Boolean getClipToBounds() {
                return this.clipToBounds;
            }

            public final void setClipToBounds(Boolean bool) {
                this.clipToBounds = bool;
            }

            public final float getZIndex() {
                return this.zIndex;
            }

            public final void setZIndex(float f) {
                this.zIndex = f;
            }

            public final float getAlpha() {
                return this.alpha;
            }

            public final void setAlpha(float f) {
                this.alpha = f;
            }

            public final Shadow getShadow() {
                return this.shadow;
            }

            public final void setShadow(Shadow shadow) {
                this.shadow = shadow;
            }

            public final String getVerticalArrangement() {
                return this.verticalArrangement;
            }

            public final void setVerticalArrangement(String str) {
                this.verticalArrangement = str;
            }

            public final String getHorizontalAlignment() {
                return this.horizontalAlignment;
            }

            public final void setHorizontalAlignment(String str) {
                this.horizontalAlignment = str;
            }

            public final String getVerticalAlignment() {
                return this.verticalAlignment;
            }

            public final void setVerticalAlignment(String str) {
                this.verticalAlignment = str;
            }

            public final String getHorizontalArrangement() {
                return this.horizontalArrangement;
            }

            public final void setHorizontalArrangement(String str) {
                this.horizontalArrangement = str;
            }

            public final String getContentAlignment() {
                return this.contentAlignment;
            }

            public final void setContentAlignment(String str) {
                this.contentAlignment = str;
            }

            public final String getAlign() {
                return this.align;
            }

            public final void setAlign(String str) {
                this.align = str;
            }

            public final Position getOffset() {
                return this.offset;
            }

            public final void setOffset(Position position) {
                this.offset = position;
            }

            public final float getRotate() {
                return this.rotate;
            }

            public final void setRotate(float f) {
                this.rotate = f;
            }

            public final float getScale() {
                return this.scale;
            }

            public final void setScale(float f) {
                this.scale = f;
            }

            public final Float getWeight() {
                return this.weight;
            }

            public final void setWeight(Float f) {
                this.weight = f;
            }

            public final Range getWidthIn() {
                return this.widthIn;
            }

            public final void setWidthIn(Range range) {
                this.widthIn = range;
            }

            public final Range getHeightIn() {
                return this.heightIn;
            }

            public final void setHeightIn(Range range) {
                this.heightIn = range;
            }

            public final Integer getBlur() {
                return this.blur;
            }

            public final void setBlur(Integer num) {
                this.blur = num;
            }
        }