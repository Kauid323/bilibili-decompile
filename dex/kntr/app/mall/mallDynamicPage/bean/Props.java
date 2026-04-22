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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Props.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b^\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u008a\u00012\u00020\u0001:\u0004\u0089\u0001\u008a\u0001B¿\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001f\u0010 B\u009f\u0002\b\u0010\u0012\u0006\u0010!\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0004\b\u001f\u0010$J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010g\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010AJ\u0010\u0010m\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010p\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010AJ\u0010\u0010q\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010r\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010s\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010AJ\u0010\u0010t\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010AJ\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010y\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010z\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010AJÆ\u0002\u0010{\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010|J\u0013\u0010}\u001a\u00020\u00102\b\u0010~\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u007f\u001a\u00020\u0006HÖ\u0001J\n\u0010\u0080\u0001\u001a\u00020\u0003HÖ\u0001J-\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u00002\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0001¢\u0006\u0003\b\u0088\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010&\"\u0004\b1\u0010(R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b2\u0010,\"\u0004\b3\u0010.R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010&\"\u0004\b5\u0010(R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b6\u0010,\"\u0004\b7\u0010.R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010&\"\u0004\b9\u0010(R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010&\"\u0004\b;\u0010(R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010&\"\u0004\b?\u0010(R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010D\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\bE\u0010,\"\u0004\bF\u0010.R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\bG\u0010,\"\u0004\bH\u0010.R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010&\"\u0004\bJ\u0010(R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010D\u001a\u0004\bK\u0010A\"\u0004\bL\u0010CR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\bM\u0010,\"\u0004\bN\u0010.R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\bO\u0010,\"\u0004\bP\u0010.R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010D\u001a\u0004\bQ\u0010A\"\u0004\bR\u0010CR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010D\u001a\u0004\bS\u0010A\"\u0004\bT\u0010CR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010&\"\u0004\bV\u0010(R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010&\"\u0004\bX\u0010(R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010&\"\u0004\bZ\u0010(R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010&\"\u0004\b\\\u0010(R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b]\u0010,\"\u0004\b^\u0010.R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010D\u001a\u0004\b_\u0010A\"\u0004\b`\u0010C¨\u0006\u008b\u0001"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Props;", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "color", "fontSize", RoomRecommendViewModel.EMPTY_CURSOR, "fontStyle", "fontWeight", "fontFamily", "letterSpacing", "textDecoration", "textAlign", "lineHeight", "overflow", "softWrap", RoomRecommendViewModel.EMPTY_CURSOR, "maxLines", "minLines", "src", "scrollable", "width", "height", "checked", "enabled", "title", "rightIcon", "jumpUrl", "dataKey", "columns", "userScrollEnabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getColor", "setColor", "getFontSize", "()Ljava/lang/Integer;", "setFontSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFontStyle", "setFontStyle", "getFontWeight", "setFontWeight", "getFontFamily", "setFontFamily", "getLetterSpacing", "setLetterSpacing", "getTextDecoration", "setTextDecoration", "getTextAlign", "setTextAlign", "getLineHeight", "setLineHeight", "getOverflow", "setOverflow", "getSoftWrap", "()Ljava/lang/Boolean;", "setSoftWrap", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMaxLines", "setMaxLines", "getMinLines", "setMinLines", "getSrc", "setSrc", "getScrollable", "setScrollable", "getWidth", "setWidth", "getHeight", "setHeight", "getChecked", "setChecked", "getEnabled", "setEnabled", "getTitle", "setTitle", "getRightIcon", "setRightIcon", "getJumpUrl", "setJumpUrl", "getDataKey", "setDataKey", "getColumns", "setColumns", "getUserScrollEnabled", "setUserScrollEnabled", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lkntr/app/mall/mallDynamicPage/bean/Props;", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$mallDynamicPage_debug", "$serializer", "Companion", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class Props {
    private Boolean checked;
    private String color;
    private Integer columns;
    private String dataKey;
    private Boolean enabled;
    private String fontFamily;
    private Integer fontSize;
    private String fontStyle;
    private Integer fontWeight;
    private Integer height;
    private String jumpUrl;
    private Integer letterSpacing;
    private Integer lineHeight;
    private Integer maxLines;
    private Integer minLines;
    private String overflow;
    private String rightIcon;
    private Boolean scrollable;
    private Boolean softWrap;
    private String src;
    private String text;
    private String textAlign;
    private String textDecoration;
    private String title;
    private Boolean userScrollEnabled;
    private Integer width;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public Props() {
        this((String) null, (String) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, (Boolean) null, (Integer) null, (Integer) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Boolean) null, 67108863, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.text;
    }

    public final Integer component10() {
        return this.lineHeight;
    }

    public final String component11() {
        return this.overflow;
    }

    public final Boolean component12() {
        return this.softWrap;
    }

    public final Integer component13() {
        return this.maxLines;
    }

    public final Integer component14() {
        return this.minLines;
    }

    public final String component15() {
        return this.src;
    }

    public final Boolean component16() {
        return this.scrollable;
    }

    public final Integer component17() {
        return this.width;
    }

    public final Integer component18() {
        return this.height;
    }

    public final Boolean component19() {
        return this.checked;
    }

    public final String component2() {
        return this.color;
    }

    public final Boolean component20() {
        return this.enabled;
    }

    public final String component21() {
        return this.title;
    }

    public final String component22() {
        return this.rightIcon;
    }

    public final String component23() {
        return this.jumpUrl;
    }

    public final String component24() {
        return this.dataKey;
    }

    public final Integer component25() {
        return this.columns;
    }

    public final Boolean component26() {
        return this.userScrollEnabled;
    }

    public final Integer component3() {
        return this.fontSize;
    }

    public final String component4() {
        return this.fontStyle;
    }

    public final Integer component5() {
        return this.fontWeight;
    }

    public final String component6() {
        return this.fontFamily;
    }

    public final Integer component7() {
        return this.letterSpacing;
    }

    public final String component8() {
        return this.textDecoration;
    }

    public final String component9() {
        return this.textAlign;
    }

    public final Props copy(String str, String str2, Integer num, String str3, Integer num2, String str4, Integer num3, String str5, String str6, Integer num4, String str7, Boolean bool, Integer num5, Integer num6, String str8, Boolean bool2, Integer num7, Integer num8, Boolean bool3, Boolean bool4, String str9, String str10, String str11, String str12, Integer num9, Boolean bool5) {
        return new Props(str, str2, num, str3, num2, str4, num3, str5, str6, num4, str7, bool, num5, num6, str8, bool2, num7, num8, bool3, bool4, str9, str10, str11, str12, num9, bool5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Props) {
            Props props = (Props) obj;
            return Intrinsics.areEqual(this.text, props.text) && Intrinsics.areEqual(this.color, props.color) && Intrinsics.areEqual(this.fontSize, props.fontSize) && Intrinsics.areEqual(this.fontStyle, props.fontStyle) && Intrinsics.areEqual(this.fontWeight, props.fontWeight) && Intrinsics.areEqual(this.fontFamily, props.fontFamily) && Intrinsics.areEqual(this.letterSpacing, props.letterSpacing) && Intrinsics.areEqual(this.textDecoration, props.textDecoration) && Intrinsics.areEqual(this.textAlign, props.textAlign) && Intrinsics.areEqual(this.lineHeight, props.lineHeight) && Intrinsics.areEqual(this.overflow, props.overflow) && Intrinsics.areEqual(this.softWrap, props.softWrap) && Intrinsics.areEqual(this.maxLines, props.maxLines) && Intrinsics.areEqual(this.minLines, props.minLines) && Intrinsics.areEqual(this.src, props.src) && Intrinsics.areEqual(this.scrollable, props.scrollable) && Intrinsics.areEqual(this.width, props.width) && Intrinsics.areEqual(this.height, props.height) && Intrinsics.areEqual(this.checked, props.checked) && Intrinsics.areEqual(this.enabled, props.enabled) && Intrinsics.areEqual(this.title, props.title) && Intrinsics.areEqual(this.rightIcon, props.rightIcon) && Intrinsics.areEqual(this.jumpUrl, props.jumpUrl) && Intrinsics.areEqual(this.dataKey, props.dataKey) && Intrinsics.areEqual(this.columns, props.columns) && Intrinsics.areEqual(this.userScrollEnabled, props.userScrollEnabled);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.text == null ? 0 : this.text.hashCode()) * 31) + (this.color == null ? 0 : this.color.hashCode())) * 31) + (this.fontSize == null ? 0 : this.fontSize.hashCode())) * 31) + (this.fontStyle == null ? 0 : this.fontStyle.hashCode())) * 31) + (this.fontWeight == null ? 0 : this.fontWeight.hashCode())) * 31) + (this.fontFamily == null ? 0 : this.fontFamily.hashCode())) * 31) + (this.letterSpacing == null ? 0 : this.letterSpacing.hashCode())) * 31) + (this.textDecoration == null ? 0 : this.textDecoration.hashCode())) * 31) + (this.textAlign == null ? 0 : this.textAlign.hashCode())) * 31) + (this.lineHeight == null ? 0 : this.lineHeight.hashCode())) * 31) + (this.overflow == null ? 0 : this.overflow.hashCode())) * 31) + (this.softWrap == null ? 0 : this.softWrap.hashCode())) * 31) + (this.maxLines == null ? 0 : this.maxLines.hashCode())) * 31) + (this.minLines == null ? 0 : this.minLines.hashCode())) * 31) + (this.src == null ? 0 : this.src.hashCode())) * 31) + (this.scrollable == null ? 0 : this.scrollable.hashCode())) * 31) + (this.width == null ? 0 : this.width.hashCode())) * 31) + (this.height == null ? 0 : this.height.hashCode())) * 31) + (this.checked == null ? 0 : this.checked.hashCode())) * 31) + (this.enabled == null ? 0 : this.enabled.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.rightIcon == null ? 0 : this.rightIcon.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.dataKey == null ? 0 : this.dataKey.hashCode())) * 31) + (this.columns == null ? 0 : this.columns.hashCode())) * 31) + (this.userScrollEnabled != null ? this.userScrollEnabled.hashCode() : 0);
    }

    public String toString() {
        String str = this.text;
        String str2 = this.color;
        Integer num = this.fontSize;
        String str3 = this.fontStyle;
        Integer num2 = this.fontWeight;
        String str4 = this.fontFamily;
        Integer num3 = this.letterSpacing;
        String str5 = this.textDecoration;
        String str6 = this.textAlign;
        Integer num4 = this.lineHeight;
        String str7 = this.overflow;
        Boolean bool = this.softWrap;
        Integer num5 = this.maxLines;
        Integer num6 = this.minLines;
        String str8 = this.src;
        Boolean bool2 = this.scrollable;
        Integer num7 = this.width;
        Integer num8 = this.height;
        Boolean bool3 = this.checked;
        Boolean bool4 = this.enabled;
        String str9 = this.title;
        String str10 = this.rightIcon;
        String str11 = this.jumpUrl;
        String str12 = this.dataKey;
        Integer num9 = this.columns;
        return "Props(text=" + str + ", color=" + str2 + ", fontSize=" + num + ", fontStyle=" + str3 + ", fontWeight=" + num2 + ", fontFamily=" + str4 + ", letterSpacing=" + num3 + ", textDecoration=" + str5 + ", textAlign=" + str6 + ", lineHeight=" + num4 + ", overflow=" + str7 + ", softWrap=" + bool + ", maxLines=" + num5 + ", minLines=" + num6 + ", src=" + str8 + ", scrollable=" + bool2 + ", width=" + num7 + ", height=" + num8 + ", checked=" + bool3 + ", enabled=" + bool4 + ", title=" + str9 + ", rightIcon=" + str10 + ", jumpUrl=" + str11 + ", dataKey=" + str12 + ", columns=" + num9 + ", userScrollEnabled=" + this.userScrollEnabled + ")";
    }

    /* compiled from: Props.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Props$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/mallDynamicPage/bean/Props;", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Props> serializer() {
            return new GeneratedSerializer<Props>() { // from class: kntr.app.mall.mallDynamicPage.bean.Props$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.mallDynamicPage.bean.Props", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.mallDynamicPage.bean.Props> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.mallDynamicPage.bean.Props> A[REMOVE]) =  kntr.app.mall.mallDynamicPage.bean.Props$$serializer.INSTANCE kntr.app.mall.mallDynamicPage.bean.Props$$serializer)
                         in method: kntr.app.mall.mallDynamicPage.bean.Props.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.mallDynamicPage.bean.Props>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                          ("kntr.app.mall.mallDynamicPage.bean.Props")
                          (wrap: kntr.app.mall.mallDynamicPage.bean.Props$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.mallDynamicPage.bean.Props$$serializer A[REMOVE]) =  kntr.app.mall.mallDynamicPage.bean.Props$$serializer.INSTANCE kntr.app.mall.mallDynamicPage.bean.Props$$serializer)
                          (26 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.mallDynamicPage.bean.Props$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.mallDynamicPage.bean.Props$$serializer
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
                        kntr.app.mall.mallDynamicPage.bean.Props$$serializer r0 = kntr.app.mall.mallDynamicPage.bean.Props$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.mallDynamicPage.bean.Props.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ Props(int seen0, String text, String color, Integer fontSize, String fontStyle, Integer fontWeight, String fontFamily, Integer letterSpacing, String textDecoration, String textAlign, Integer lineHeight, String overflow, Boolean softWrap, Integer maxLines, Integer minLines, String src, Boolean scrollable, Integer width, Integer height, Boolean checked, Boolean enabled, String title, String rightIcon, String jumpUrl, String dataKey, Integer columns, Boolean userScrollEnabled, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.text = null;
                } else {
                    this.text = text;
                }
                if ((seen0 & 2) == 0) {
                    this.color = null;
                } else {
                    this.color = color;
                }
                if ((seen0 & 4) == 0) {
                    this.fontSize = null;
                } else {
                    this.fontSize = fontSize;
                }
                if ((seen0 & 8) == 0) {
                    this.fontStyle = null;
                } else {
                    this.fontStyle = fontStyle;
                }
                if ((seen0 & 16) == 0) {
                    this.fontWeight = null;
                } else {
                    this.fontWeight = fontWeight;
                }
                if ((seen0 & 32) == 0) {
                    this.fontFamily = null;
                } else {
                    this.fontFamily = fontFamily;
                }
                if ((seen0 & 64) == 0) {
                    this.letterSpacing = null;
                } else {
                    this.letterSpacing = letterSpacing;
                }
                if ((seen0 & 128) == 0) {
                    this.textDecoration = null;
                } else {
                    this.textDecoration = textDecoration;
                }
                if ((seen0 & 256) == 0) {
                    this.textAlign = null;
                } else {
                    this.textAlign = textAlign;
                }
                if ((seen0 & 512) == 0) {
                    this.lineHeight = null;
                } else {
                    this.lineHeight = lineHeight;
                }
                if ((seen0 & 1024) == 0) {
                    this.overflow = null;
                } else {
                    this.overflow = overflow;
                }
                if ((seen0 & 2048) == 0) {
                    this.softWrap = null;
                } else {
                    this.softWrap = softWrap;
                }
                if ((seen0 & 4096) == 0) {
                    this.maxLines = null;
                } else {
                    this.maxLines = maxLines;
                }
                if ((seen0 & 8192) == 0) {
                    this.minLines = null;
                } else {
                    this.minLines = minLines;
                }
                if ((seen0 & 16384) == 0) {
                    this.src = null;
                } else {
                    this.src = src;
                }
                if ((seen0 & 32768) == 0) {
                    this.scrollable = null;
                } else {
                    this.scrollable = scrollable;
                }
                if ((seen0 & 65536) == 0) {
                    this.width = null;
                } else {
                    this.width = width;
                }
                if ((seen0 & 131072) == 0) {
                    this.height = null;
                } else {
                    this.height = height;
                }
                if ((seen0 & 262144) == 0) {
                    this.checked = null;
                } else {
                    this.checked = checked;
                }
                if ((seen0 & 524288) == 0) {
                    this.enabled = null;
                } else {
                    this.enabled = enabled;
                }
                if ((seen0 & 1048576) == 0) {
                    this.title = null;
                } else {
                    this.title = title;
                }
                if ((seen0 & 2097152) == 0) {
                    this.rightIcon = null;
                } else {
                    this.rightIcon = rightIcon;
                }
                if ((seen0 & 4194304) == 0) {
                    this.jumpUrl = null;
                } else {
                    this.jumpUrl = jumpUrl;
                }
                if ((seen0 & 8388608) == 0) {
                    this.dataKey = null;
                } else {
                    this.dataKey = dataKey;
                }
                if ((seen0 & 16777216) == 0) {
                    this.columns = null;
                } else {
                    this.columns = columns;
                }
                if ((seen0 & 33554432) == 0) {
                    this.userScrollEnabled = null;
                } else {
                    this.userScrollEnabled = userScrollEnabled;
                }
            }

            public Props(String text, String color, Integer fontSize, String fontStyle, Integer fontWeight, String fontFamily, Integer letterSpacing, String textDecoration, String textAlign, Integer lineHeight, String overflow, Boolean softWrap, Integer maxLines, Integer minLines, String src, Boolean scrollable, Integer width, Integer height, Boolean checked, Boolean enabled, String title, String rightIcon, String jumpUrl, String dataKey, Integer columns, Boolean userScrollEnabled) {
                this.text = text;
                this.color = color;
                this.fontSize = fontSize;
                this.fontStyle = fontStyle;
                this.fontWeight = fontWeight;
                this.fontFamily = fontFamily;
                this.letterSpacing = letterSpacing;
                this.textDecoration = textDecoration;
                this.textAlign = textAlign;
                this.lineHeight = lineHeight;
                this.overflow = overflow;
                this.softWrap = softWrap;
                this.maxLines = maxLines;
                this.minLines = minLines;
                this.src = src;
                this.scrollable = scrollable;
                this.width = width;
                this.height = height;
                this.checked = checked;
                this.enabled = enabled;
                this.title = title;
                this.rightIcon = rightIcon;
                this.jumpUrl = jumpUrl;
                this.dataKey = dataKey;
                this.columns = columns;
                this.userScrollEnabled = userScrollEnabled;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$mallDynamicPage_debug(Props self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.text != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.text);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.color != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.color);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.fontSize != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.fontSize);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.fontStyle != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.fontStyle);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.fontWeight != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.fontWeight);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.fontFamily != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.fontFamily);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.letterSpacing != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.letterSpacing);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.textDecoration != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.textDecoration);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.textAlign != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.textAlign);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.lineHeight != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.lineHeight);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.overflow != null) {
                    output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.overflow);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.softWrap != null) {
                    output.encodeNullableSerializableElement(serialDesc, 11, BooleanSerializer.INSTANCE, self.softWrap);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 12) || self.maxLines != null) {
                    output.encodeNullableSerializableElement(serialDesc, 12, IntSerializer.INSTANCE, self.maxLines);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.minLines != null) {
                    output.encodeNullableSerializableElement(serialDesc, 13, IntSerializer.INSTANCE, self.minLines);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 14) || self.src != null) {
                    output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.src);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.scrollable != null) {
                    output.encodeNullableSerializableElement(serialDesc, 15, BooleanSerializer.INSTANCE, self.scrollable);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 16) || self.width != null) {
                    output.encodeNullableSerializableElement(serialDesc, 16, IntSerializer.INSTANCE, self.width);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 17) || self.height != null) {
                    output.encodeNullableSerializableElement(serialDesc, 17, IntSerializer.INSTANCE, self.height);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 18) || self.checked != null) {
                    output.encodeNullableSerializableElement(serialDesc, 18, BooleanSerializer.INSTANCE, self.checked);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 19) || self.enabled != null) {
                    output.encodeNullableSerializableElement(serialDesc, 19, BooleanSerializer.INSTANCE, self.enabled);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 20) || self.title != null) {
                    output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.title);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 21) || self.rightIcon != null) {
                    output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.rightIcon);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 22) || self.jumpUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.jumpUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 23) || self.dataKey != null) {
                    output.encodeNullableSerializableElement(serialDesc, 23, StringSerializer.INSTANCE, self.dataKey);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 24) || self.columns != null) {
                    output.encodeNullableSerializableElement(serialDesc, 24, IntSerializer.INSTANCE, self.columns);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 25) || self.userScrollEnabled != null) {
                    output.encodeNullableSerializableElement(serialDesc, 25, BooleanSerializer.INSTANCE, self.userScrollEnabled);
                }
            }

            public /* synthetic */ Props(String str, String str2, Integer num, String str3, Integer num2, String str4, Integer num3, String str5, String str6, Integer num4, String str7, Boolean bool, Integer num5, Integer num6, String str8, Boolean bool2, Integer num7, Integer num8, Boolean bool3, Boolean bool4, String str9, String str10, String str11, String str12, Integer num9, Boolean bool5, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : num3, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : num4, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? null : bool, (i & 4096) != 0 ? null : num5, (i & 8192) != 0 ? null : num6, (i & 16384) != 0 ? null : str8, (i & 32768) != 0 ? null : bool2, (i & 65536) != 0 ? null : num7, (i & 131072) != 0 ? null : num8, (i & 262144) != 0 ? null : bool3, (i & 524288) != 0 ? null : bool4, (i & 1048576) != 0 ? null : str9, (i & 2097152) != 0 ? null : str10, (i & 4194304) != 0 ? null : str11, (i & 8388608) != 0 ? null : str12, (i & 16777216) != 0 ? null : num9, (i & 33554432) != 0 ? null : bool5);
            }

            public final String getText() {
                return this.text;
            }

            public final void setText(String str) {
                this.text = str;
            }

            public final String getColor() {
                return this.color;
            }

            public final void setColor(String str) {
                this.color = str;
            }

            public final Integer getFontSize() {
                return this.fontSize;
            }

            public final void setFontSize(Integer num) {
                this.fontSize = num;
            }

            public final String getFontStyle() {
                return this.fontStyle;
            }

            public final void setFontStyle(String str) {
                this.fontStyle = str;
            }

            public final Integer getFontWeight() {
                return this.fontWeight;
            }

            public final void setFontWeight(Integer num) {
                this.fontWeight = num;
            }

            public final String getFontFamily() {
                return this.fontFamily;
            }

            public final void setFontFamily(String str) {
                this.fontFamily = str;
            }

            public final Integer getLetterSpacing() {
                return this.letterSpacing;
            }

            public final void setLetterSpacing(Integer num) {
                this.letterSpacing = num;
            }

            public final String getTextDecoration() {
                return this.textDecoration;
            }

            public final void setTextDecoration(String str) {
                this.textDecoration = str;
            }

            public final String getTextAlign() {
                return this.textAlign;
            }

            public final void setTextAlign(String str) {
                this.textAlign = str;
            }

            public final Integer getLineHeight() {
                return this.lineHeight;
            }

            public final void setLineHeight(Integer num) {
                this.lineHeight = num;
            }

            public final String getOverflow() {
                return this.overflow;
            }

            public final void setOverflow(String str) {
                this.overflow = str;
            }

            public final Boolean getSoftWrap() {
                return this.softWrap;
            }

            public final void setSoftWrap(Boolean bool) {
                this.softWrap = bool;
            }

            public final Integer getMaxLines() {
                return this.maxLines;
            }

            public final void setMaxLines(Integer num) {
                this.maxLines = num;
            }

            public final Integer getMinLines() {
                return this.minLines;
            }

            public final void setMinLines(Integer num) {
                this.minLines = num;
            }

            public final String getSrc() {
                return this.src;
            }

            public final void setSrc(String str) {
                this.src = str;
            }

            public final Boolean getScrollable() {
                return this.scrollable;
            }

            public final void setScrollable(Boolean bool) {
                this.scrollable = bool;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public final void setWidth(Integer num) {
                this.width = num;
            }

            public final Integer getHeight() {
                return this.height;
            }

            public final void setHeight(Integer num) {
                this.height = num;
            }

            public final Boolean getChecked() {
                return this.checked;
            }

            public final void setChecked(Boolean bool) {
                this.checked = bool;
            }

            public final Boolean getEnabled() {
                return this.enabled;
            }

            public final void setEnabled(Boolean bool) {
                this.enabled = bool;
            }

            public final String getTitle() {
                return this.title;
            }

            public final void setTitle(String str) {
                this.title = str;
            }

            public final String getRightIcon() {
                return this.rightIcon;
            }

            public final void setRightIcon(String str) {
                this.rightIcon = str;
            }

            public final String getJumpUrl() {
                return this.jumpUrl;
            }

            public final void setJumpUrl(String str) {
                this.jumpUrl = str;
            }

            public final String getDataKey() {
                return this.dataKey;
            }

            public final void setDataKey(String str) {
                this.dataKey = str;
            }

            public final Integer getColumns() {
                return this.columns;
            }

            public final void setColumns(Integer num) {
                this.columns = num;
            }

            public final Boolean getUserScrollEnabled() {
                return this.userScrollEnabled;
            }

            public final void setUserScrollEnabled(Boolean bool) {
                this.userScrollEnabled = bool;
            }
        }