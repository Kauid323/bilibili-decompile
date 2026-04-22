package bili.resource.downloads;

import com.bilibili.upper.BR;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0003\bö\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0017\u0010\u0007R\u001b\u0010\u0019\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u001c\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010\u001f\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b \u0010\u0007R\u001b\u0010\"\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b#\u0010\u0007R\u001b\u0010%\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b&\u0010\u0007R\u001b\u0010(\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\t\u001a\u0004\b)\u0010\u0007R\u001b\u0010+\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b,\u0010\u0007R\u001b\u0010.\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b/\u0010\u0007R\u001b\u00101\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b2\u0010\u0007R\u001b\u00104\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b5\u0010\u0007R\u001b\u00107\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\t\u001a\u0004\b8\u0010\u0007R\u001b\u0010:\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\t\u001a\u0004\b;\u0010\u0007R\u001b\u0010=\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\t\u001a\u0004\b>\u0010\u0007R\u001b\u0010@\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\t\u001a\u0004\bA\u0010\u0007R\u001b\u0010C\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\t\u001a\u0004\bD\u0010\u0007R\u001b\u0010F\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\t\u001a\u0004\bG\u0010\u0007R\u001b\u0010I\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\t\u001a\u0004\bJ\u0010\u0007R\u001b\u0010L\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\t\u001a\u0004\bM\u0010\u0007R\u001b\u0010O\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\t\u001a\u0004\bP\u0010\u0007R\u001b\u0010R\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\t\u001a\u0004\bS\u0010\u0007R\u001b\u0010U\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\t\u001a\u0004\bV\u0010\u0007R\u001b\u0010X\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\t\u001a\u0004\bY\u0010\u0007R\u001b\u0010[\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\t\u001a\u0004\b\\\u0010\u0007R\u001b\u0010^\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\t\u001a\u0004\b_\u0010\u0007R\u001b\u0010a\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\t\u001a\u0004\bb\u0010\u0007R\u001b\u0010d\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\t\u001a\u0004\be\u0010\u0007R\u001b\u0010g\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bi\u0010\t\u001a\u0004\bh\u0010\u0007R\u001b\u0010j\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bl\u0010\t\u001a\u0004\bk\u0010\u0007R\u001b\u0010m\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\t\u001a\u0004\bn\u0010\u0007R\u001b\u0010p\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\br\u0010\t\u001a\u0004\bq\u0010\u0007R\u001b\u0010s\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bu\u0010\t\u001a\u0004\bt\u0010\u0007R\u001b\u0010v\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bx\u0010\t\u001a\u0004\bw\u0010\u0007R\u001b\u0010y\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\t\u001a\u0004\bz\u0010\u0007R\u001b\u0010|\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b~\u0010\t\u001a\u0004\b}\u0010\u0007R\u001d\u0010\u007f\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010\t\u001a\u0005\b\u0080\u0001\u0010\u0007R\u001e\u0010\u0082\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010\t\u001a\u0005\b\u0083\u0001\u0010\u0007R\u001e\u0010\u0085\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010\t\u001a\u0005\b\u0086\u0001\u0010\u0007R\u001e\u0010\u0088\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010\t\u001a\u0005\b\u0089\u0001\u0010\u0007R\u001e\u0010\u008b\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008d\u0001\u0010\t\u001a\u0005\b\u008c\u0001\u0010\u0007R\u001e\u0010\u008e\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010\t\u001a\u0005\b\u008f\u0001\u0010\u0007R\u001e\u0010\u0091\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0093\u0001\u0010\t\u001a\u0005\b\u0092\u0001\u0010\u0007R\u001e\u0010\u0094\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0096\u0001\u0010\t\u001a\u0005\b\u0095\u0001\u0010\u0007R\u001e\u0010\u0097\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0099\u0001\u0010\t\u001a\u0005\b\u0098\u0001\u0010\u0007R\u001e\u0010\u009a\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009c\u0001\u0010\t\u001a\u0005\b\u009b\u0001\u0010\u0007R\u001e\u0010\u009d\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009f\u0001\u0010\t\u001a\u0005\b\u009e\u0001\u0010\u0007R\u001e\u0010 \u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¢\u0001\u0010\t\u001a\u0005\b¡\u0001\u0010\u0007R\u001e\u0010£\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¥\u0001\u0010\t\u001a\u0005\b¤\u0001\u0010\u0007R\u001e\u0010¦\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¨\u0001\u0010\t\u001a\u0005\b§\u0001\u0010\u0007R\u001e\u0010©\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b«\u0001\u0010\t\u001a\u0005\bª\u0001\u0010\u0007R\u001e\u0010¬\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b®\u0001\u0010\t\u001a\u0005\b\u00ad\u0001\u0010\u0007R\u001e\u0010¯\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b±\u0001\u0010\t\u001a\u0005\b°\u0001\u0010\u0007R\u001e\u0010²\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b´\u0001\u0010\t\u001a\u0005\b³\u0001\u0010\u0007R\u001e\u0010µ\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b·\u0001\u0010\t\u001a\u0005\b¶\u0001\u0010\u0007R\u001e\u0010¸\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bº\u0001\u0010\t\u001a\u0005\b¹\u0001\u0010\u0007R\u001e\u0010»\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b½\u0001\u0010\t\u001a\u0005\b¼\u0001\u0010\u0007R\u001e\u0010¾\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÀ\u0001\u0010\t\u001a\u0005\b¿\u0001\u0010\u0007R\u001e\u0010Á\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÃ\u0001\u0010\t\u001a\u0005\bÂ\u0001\u0010\u0007R\u001e\u0010Ä\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÆ\u0001\u0010\t\u001a\u0005\bÅ\u0001\u0010\u0007R\u001e\u0010Ç\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÉ\u0001\u0010\t\u001a\u0005\bÈ\u0001\u0010\u0007R\u001e\u0010Ê\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÌ\u0001\u0010\t\u001a\u0005\bË\u0001\u0010\u0007R\u001e\u0010Í\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÏ\u0001\u0010\t\u001a\u0005\bÎ\u0001\u0010\u0007R\u001e\u0010Ð\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÒ\u0001\u0010\t\u001a\u0005\bÑ\u0001\u0010\u0007R\u001e\u0010Ó\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÕ\u0001\u0010\t\u001a\u0005\bÔ\u0001\u0010\u0007R\u001e\u0010Ö\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bØ\u0001\u0010\t\u001a\u0005\b×\u0001\u0010\u0007R\u001e\u0010Ù\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÛ\u0001\u0010\t\u001a\u0005\bÚ\u0001\u0010\u0007R\u001e\u0010Ü\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÞ\u0001\u0010\t\u001a\u0005\bÝ\u0001\u0010\u0007R\u001e\u0010ß\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bá\u0001\u0010\t\u001a\u0005\bà\u0001\u0010\u0007R\u001e\u0010â\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bä\u0001\u0010\t\u001a\u0005\bã\u0001\u0010\u0007R\u001e\u0010å\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bç\u0001\u0010\t\u001a\u0005\bæ\u0001\u0010\u0007R\u001e\u0010è\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bê\u0001\u0010\t\u001a\u0005\bé\u0001\u0010\u0007R\u001e\u0010ë\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bí\u0001\u0010\t\u001a\u0005\bì\u0001\u0010\u0007R\u001e\u0010î\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bð\u0001\u0010\t\u001a\u0005\bï\u0001\u0010\u0007R\u001e\u0010ñ\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bó\u0001\u0010\t\u001a\u0005\bò\u0001\u0010\u0007R\u001e\u0010ô\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bö\u0001\u0010\t\u001a\u0005\bõ\u0001\u0010\u0007R\u001e\u0010÷\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bù\u0001\u0010\t\u001a\u0005\bø\u0001\u0010\u0007R\u001e\u0010ú\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bü\u0001\u0010\t\u001a\u0005\bû\u0001\u0010\u0007R\u001e\u0010ý\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÿ\u0001\u0010\t\u001a\u0005\bþ\u0001\u0010\u0007R\u001e\u0010\u0080\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0082\u0002\u0010\t\u001a\u0005\b\u0081\u0002\u0010\u0007R\u001e\u0010\u0083\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0085\u0002\u0010\t\u001a\u0005\b\u0084\u0002\u0010\u0007R\u001e\u0010\u0086\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0088\u0002\u0010\t\u001a\u0005\b\u0087\u0002\u0010\u0007R\u001e\u0010\u0089\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008b\u0002\u0010\t\u001a\u0005\b\u008a\u0002\u0010\u0007R\u001e\u0010\u008c\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008e\u0002\u0010\t\u001a\u0005\b\u008d\u0002\u0010\u0007R\u001e\u0010\u008f\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0091\u0002\u0010\t\u001a\u0005\b\u0090\u0002\u0010\u0007R\u001e\u0010\u0092\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0094\u0002\u0010\t\u001a\u0005\b\u0093\u0002\u0010\u0007R\u001e\u0010\u0095\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0097\u0002\u0010\t\u001a\u0005\b\u0096\u0002\u0010\u0007R\u001e\u0010\u0098\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009a\u0002\u0010\t\u001a\u0005\b\u0099\u0002\u0010\u0007R\u001e\u0010\u009b\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009d\u0002\u0010\t\u001a\u0005\b\u009c\u0002\u0010\u0007R\u001e\u0010\u009e\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b \u0002\u0010\t\u001a\u0005\b\u009f\u0002\u0010\u0007R\u001e\u0010¡\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b£\u0002\u0010\t\u001a\u0005\b¢\u0002\u0010\u0007R\u001e\u0010¤\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¦\u0002\u0010\t\u001a\u0005\b¥\u0002\u0010\u0007R\u001e\u0010§\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b©\u0002\u0010\t\u001a\u0005\b¨\u0002\u0010\u0007R\u001e\u0010ª\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¬\u0002\u0010\t\u001a\u0005\b«\u0002\u0010\u0007R\u001e\u0010\u00ad\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¯\u0002\u0010\t\u001a\u0005\b®\u0002\u0010\u0007R\u001e\u0010°\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b²\u0002\u0010\t\u001a\u0005\b±\u0002\u0010\u0007R\u001e\u0010³\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bµ\u0002\u0010\t\u001a\u0005\b´\u0002\u0010\u0007R\u001e\u0010¶\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¸\u0002\u0010\t\u001a\u0005\b·\u0002\u0010\u0007R\u001e\u0010¹\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b»\u0002\u0010\t\u001a\u0005\bº\u0002\u0010\u0007R\u001e\u0010¼\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¾\u0002\u0010\t\u001a\u0005\b½\u0002\u0010\u0007R\u001e\u0010¿\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÁ\u0002\u0010\t\u001a\u0005\bÀ\u0002\u0010\u0007R\u001e\u0010Â\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÄ\u0002\u0010\t\u001a\u0005\bÃ\u0002\u0010\u0007R\u001e\u0010Å\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÇ\u0002\u0010\t\u001a\u0005\bÆ\u0002\u0010\u0007R\u001e\u0010È\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÊ\u0002\u0010\t\u001a\u0005\bÉ\u0002\u0010\u0007R\u001e\u0010Ë\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÍ\u0002\u0010\t\u001a\u0005\bÌ\u0002\u0010\u0007R\u001e\u0010Î\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÐ\u0002\u0010\t\u001a\u0005\bÏ\u0002\u0010\u0007R\u001e\u0010Ñ\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÓ\u0002\u0010\t\u001a\u0005\bÒ\u0002\u0010\u0007R\u001e\u0010Ô\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÖ\u0002\u0010\t\u001a\u0005\bÕ\u0002\u0010\u0007R\u001e\u0010×\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÙ\u0002\u0010\t\u001a\u0005\bØ\u0002\u0010\u0007R\u001e\u0010Ú\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÜ\u0002\u0010\t\u001a\u0005\bÛ\u0002\u0010\u0007R\u001e\u0010Ý\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bß\u0002\u0010\t\u001a\u0005\bÞ\u0002\u0010\u0007R\u001e\u0010à\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bâ\u0002\u0010\t\u001a\u0005\bá\u0002\u0010\u0007R\u001e\u0010ã\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bå\u0002\u0010\t\u001a\u0005\bä\u0002\u0010\u0007R\u001e\u0010æ\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bè\u0002\u0010\t\u001a\u0005\bç\u0002\u0010\u0007R\u001e\u0010é\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bë\u0002\u0010\t\u001a\u0005\bê\u0002\u0010\u0007R\u001e\u0010ì\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bî\u0002\u0010\t\u001a\u0005\bí\u0002\u0010\u0007R\u001e\u0010ï\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bñ\u0002\u0010\t\u001a\u0005\bð\u0002\u0010\u0007R\u001e\u0010ò\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bô\u0002\u0010\t\u001a\u0005\bó\u0002\u0010\u0007R\u001e\u0010õ\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b÷\u0002\u0010\t\u001a\u0005\bö\u0002\u0010\u0007R\u001e\u0010ø\u0002\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bú\u0002\u0010\t\u001a\u0005\bù\u0002\u0010\u0007¨\u0006û\u0002"}, d2 = {"Lbili/resource/downloads/CommonMainString0;", "", "<init>", "()V", "downloads_global_string_1", "Lorg/jetbrains/compose/resources/StringResource;", "getDownloads_global_string_1", "()Lorg/jetbrains/compose/resources/StringResource;", "downloads_global_string_1$delegate", "Lkotlin/Lazy;", "downloads_global_string_10", "getDownloads_global_string_10", "downloads_global_string_10$delegate", "downloads_global_string_100", "getDownloads_global_string_100", "downloads_global_string_100$delegate", "downloads_global_string_101", "getDownloads_global_string_101", "downloads_global_string_101$delegate", "downloads_global_string_102", "getDownloads_global_string_102", "downloads_global_string_102$delegate", "downloads_global_string_103", "getDownloads_global_string_103", "downloads_global_string_103$delegate", "downloads_global_string_104", "getDownloads_global_string_104", "downloads_global_string_104$delegate", "downloads_global_string_105", "getDownloads_global_string_105", "downloads_global_string_105$delegate", "downloads_global_string_106", "getDownloads_global_string_106", "downloads_global_string_106$delegate", "downloads_global_string_107", "getDownloads_global_string_107", "downloads_global_string_107$delegate", "downloads_global_string_108", "getDownloads_global_string_108", "downloads_global_string_108$delegate", "downloads_global_string_109", "getDownloads_global_string_109", "downloads_global_string_109$delegate", "downloads_global_string_11", "getDownloads_global_string_11", "downloads_global_string_11$delegate", "downloads_global_string_110", "getDownloads_global_string_110", "downloads_global_string_110$delegate", "downloads_global_string_111", "getDownloads_global_string_111", "downloads_global_string_111$delegate", "downloads_global_string_112", "getDownloads_global_string_112", "downloads_global_string_112$delegate", "downloads_global_string_113", "getDownloads_global_string_113", "downloads_global_string_113$delegate", "downloads_global_string_114", "getDownloads_global_string_114", "downloads_global_string_114$delegate", "downloads_global_string_115", "getDownloads_global_string_115", "downloads_global_string_115$delegate", "downloads_global_string_116", "getDownloads_global_string_116", "downloads_global_string_116$delegate", "downloads_global_string_117", "getDownloads_global_string_117", "downloads_global_string_117$delegate", "downloads_global_string_118", "getDownloads_global_string_118", "downloads_global_string_118$delegate", "downloads_global_string_119", "getDownloads_global_string_119", "downloads_global_string_119$delegate", "downloads_global_string_12", "getDownloads_global_string_12", "downloads_global_string_12$delegate", "downloads_global_string_120", "getDownloads_global_string_120", "downloads_global_string_120$delegate", "downloads_global_string_121", "getDownloads_global_string_121", "downloads_global_string_121$delegate", "downloads_global_string_122", "getDownloads_global_string_122", "downloads_global_string_122$delegate", "downloads_global_string_123", "getDownloads_global_string_123", "downloads_global_string_123$delegate", "downloads_global_string_125", "getDownloads_global_string_125", "downloads_global_string_125$delegate", "downloads_global_string_13", "getDownloads_global_string_13", "downloads_global_string_13$delegate", "downloads_global_string_14", "getDownloads_global_string_14", "downloads_global_string_14$delegate", "downloads_global_string_15", "getDownloads_global_string_15", "downloads_global_string_15$delegate", "downloads_global_string_16", "getDownloads_global_string_16", "downloads_global_string_16$delegate", "downloads_global_string_17", "getDownloads_global_string_17", "downloads_global_string_17$delegate", "downloads_global_string_18", "getDownloads_global_string_18", "downloads_global_string_18$delegate", "downloads_global_string_19", "getDownloads_global_string_19", "downloads_global_string_19$delegate", "downloads_global_string_2", "getDownloads_global_string_2", "downloads_global_string_2$delegate", "downloads_global_string_20", "getDownloads_global_string_20", "downloads_global_string_20$delegate", "downloads_global_string_21", "getDownloads_global_string_21", "downloads_global_string_21$delegate", "downloads_global_string_22", "getDownloads_global_string_22", "downloads_global_string_22$delegate", "downloads_global_string_23", "getDownloads_global_string_23", "downloads_global_string_23$delegate", "downloads_global_string_24", "getDownloads_global_string_24", "downloads_global_string_24$delegate", "downloads_global_string_25", "getDownloads_global_string_25", "downloads_global_string_25$delegate", "downloads_global_string_26", "getDownloads_global_string_26", "downloads_global_string_26$delegate", "downloads_global_string_27", "getDownloads_global_string_27", "downloads_global_string_27$delegate", "downloads_global_string_28", "getDownloads_global_string_28", "downloads_global_string_28$delegate", "downloads_global_string_29", "getDownloads_global_string_29", "downloads_global_string_29$delegate", "downloads_global_string_3", "getDownloads_global_string_3", "downloads_global_string_3$delegate", "downloads_global_string_30", "getDownloads_global_string_30", "downloads_global_string_30$delegate", "downloads_global_string_31", "getDownloads_global_string_31", "downloads_global_string_31$delegate", "downloads_global_string_32", "getDownloads_global_string_32", "downloads_global_string_32$delegate", "downloads_global_string_33", "getDownloads_global_string_33", "downloads_global_string_33$delegate", "downloads_global_string_34", "getDownloads_global_string_34", "downloads_global_string_34$delegate", "downloads_global_string_35", "getDownloads_global_string_35", "downloads_global_string_35$delegate", "downloads_global_string_36", "getDownloads_global_string_36", "downloads_global_string_36$delegate", "downloads_global_string_37", "getDownloads_global_string_37", "downloads_global_string_37$delegate", "downloads_global_string_38", "getDownloads_global_string_38", "downloads_global_string_38$delegate", "downloads_global_string_39", "getDownloads_global_string_39", "downloads_global_string_39$delegate", "downloads_global_string_4", "getDownloads_global_string_4", "downloads_global_string_4$delegate", "downloads_global_string_40", "getDownloads_global_string_40", "downloads_global_string_40$delegate", "downloads_global_string_41", "getDownloads_global_string_41", "downloads_global_string_41$delegate", "downloads_global_string_42", "getDownloads_global_string_42", "downloads_global_string_42$delegate", "downloads_global_string_43", "getDownloads_global_string_43", "downloads_global_string_43$delegate", "downloads_global_string_44", "getDownloads_global_string_44", "downloads_global_string_44$delegate", "downloads_global_string_45", "getDownloads_global_string_45", "downloads_global_string_45$delegate", "downloads_global_string_46", "getDownloads_global_string_46", "downloads_global_string_46$delegate", "downloads_global_string_47", "getDownloads_global_string_47", "downloads_global_string_47$delegate", "downloads_global_string_48", "getDownloads_global_string_48", "downloads_global_string_48$delegate", "downloads_global_string_49", "getDownloads_global_string_49", "downloads_global_string_49$delegate", "downloads_global_string_5", "getDownloads_global_string_5", "downloads_global_string_5$delegate", "downloads_global_string_50", "getDownloads_global_string_50", "downloads_global_string_50$delegate", "downloads_global_string_51", "getDownloads_global_string_51", "downloads_global_string_51$delegate", "downloads_global_string_52", "getDownloads_global_string_52", "downloads_global_string_52$delegate", "downloads_global_string_53", "getDownloads_global_string_53", "downloads_global_string_53$delegate", "downloads_global_string_54", "getDownloads_global_string_54", "downloads_global_string_54$delegate", "downloads_global_string_55", "getDownloads_global_string_55", "downloads_global_string_55$delegate", "downloads_global_string_56", "getDownloads_global_string_56", "downloads_global_string_56$delegate", "downloads_global_string_57", "getDownloads_global_string_57", "downloads_global_string_57$delegate", "downloads_global_string_58", "getDownloads_global_string_58", "downloads_global_string_58$delegate", "downloads_global_string_59", "getDownloads_global_string_59", "downloads_global_string_59$delegate", "downloads_global_string_6", "getDownloads_global_string_6", "downloads_global_string_6$delegate", "downloads_global_string_60", "getDownloads_global_string_60", "downloads_global_string_60$delegate", "downloads_global_string_61", "getDownloads_global_string_61", "downloads_global_string_61$delegate", "downloads_global_string_62", "getDownloads_global_string_62", "downloads_global_string_62$delegate", "downloads_global_string_63", "getDownloads_global_string_63", "downloads_global_string_63$delegate", "downloads_global_string_64", "getDownloads_global_string_64", "downloads_global_string_64$delegate", "downloads_global_string_65", "getDownloads_global_string_65", "downloads_global_string_65$delegate", "downloads_global_string_66", "getDownloads_global_string_66", "downloads_global_string_66$delegate", "downloads_global_string_67", "getDownloads_global_string_67", "downloads_global_string_67$delegate", "downloads_global_string_68", "getDownloads_global_string_68", "downloads_global_string_68$delegate", "downloads_global_string_69", "getDownloads_global_string_69", "downloads_global_string_69$delegate", "downloads_global_string_7", "getDownloads_global_string_7", "downloads_global_string_7$delegate", "downloads_global_string_70", "getDownloads_global_string_70", "downloads_global_string_70$delegate", "downloads_global_string_71", "getDownloads_global_string_71", "downloads_global_string_71$delegate", "downloads_global_string_72", "getDownloads_global_string_72", "downloads_global_string_72$delegate", "downloads_global_string_73", "getDownloads_global_string_73", "downloads_global_string_73$delegate", "downloads_global_string_74", "getDownloads_global_string_74", "downloads_global_string_74$delegate", "downloads_global_string_75", "getDownloads_global_string_75", "downloads_global_string_75$delegate", "downloads_global_string_76", "getDownloads_global_string_76", "downloads_global_string_76$delegate", "downloads_global_string_77", "getDownloads_global_string_77", "downloads_global_string_77$delegate", "downloads_global_string_78", "getDownloads_global_string_78", "downloads_global_string_78$delegate", "downloads_global_string_79", "getDownloads_global_string_79", "downloads_global_string_79$delegate", "downloads_global_string_8", "getDownloads_global_string_8", "downloads_global_string_8$delegate", "downloads_global_string_80", "getDownloads_global_string_80", "downloads_global_string_80$delegate", "downloads_global_string_81", "getDownloads_global_string_81", "downloads_global_string_81$delegate", "downloads_global_string_82", "getDownloads_global_string_82", "downloads_global_string_82$delegate", "downloads_global_string_83", "getDownloads_global_string_83", "downloads_global_string_83$delegate", "downloads_global_string_84", "getDownloads_global_string_84", "downloads_global_string_84$delegate", "downloads_global_string_85", "getDownloads_global_string_85", "downloads_global_string_85$delegate", "downloads_global_string_86", "getDownloads_global_string_86", "downloads_global_string_86$delegate", "downloads_global_string_87", "getDownloads_global_string_87", "downloads_global_string_87$delegate", "downloads_global_string_88", "getDownloads_global_string_88", "downloads_global_string_88$delegate", "downloads_global_string_89", "getDownloads_global_string_89", "downloads_global_string_89$delegate", "downloads_global_string_9", "getDownloads_global_string_9", "downloads_global_string_9$delegate", "downloads_global_string_90", "getDownloads_global_string_90", "downloads_global_string_90$delegate", "downloads_global_string_91", "getDownloads_global_string_91", "downloads_global_string_91$delegate", "downloads_global_string_92", "getDownloads_global_string_92", "downloads_global_string_92$delegate", "downloads_global_string_93", "getDownloads_global_string_93", "downloads_global_string_93$delegate", "downloads_global_string_94", "getDownloads_global_string_94", "downloads_global_string_94$delegate", "downloads_global_string_95", "getDownloads_global_string_95", "downloads_global_string_95$delegate", "downloads_global_string_96", "getDownloads_global_string_96", "downloads_global_string_96$delegate", "downloads_global_string_97", "getDownloads_global_string_97", "downloads_global_string_97$delegate", "downloads_global_string_98", "getDownloads_global_string_98", "downloads_global_string_98$delegate", "downloads_global_string_99", "getDownloads_global_string_99", "downloads_global_string_99$delegate", "downloads_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainString0 {
    public static final CommonMainString0 INSTANCE = new CommonMainString0();
    private static final Lazy downloads_global_string_1$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda0
        public final Object invoke() {
            StringResource downloads_global_string_1_delegate$lambda$0;
            downloads_global_string_1_delegate$lambda$0 = CommonMainString0.downloads_global_string_1_delegate$lambda$0();
            return downloads_global_string_1_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_10$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda52
        public final Object invoke() {
            StringResource downloads_global_string_10_delegate$lambda$0;
            downloads_global_string_10_delegate$lambda$0 = CommonMainString0.downloads_global_string_10_delegate$lambda$0();
            return downloads_global_string_10_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_100$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda64
        public final Object invoke() {
            StringResource downloads_global_string_100_delegate$lambda$0;
            downloads_global_string_100_delegate$lambda$0 = CommonMainString0.downloads_global_string_100_delegate$lambda$0();
            return downloads_global_string_100_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_101$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda76
        public final Object invoke() {
            StringResource downloads_global_string_101_delegate$lambda$0;
            downloads_global_string_101_delegate$lambda$0 = CommonMainString0.downloads_global_string_101_delegate$lambda$0();
            return downloads_global_string_101_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_102$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda88
        public final Object invoke() {
            StringResource downloads_global_string_102_delegate$lambda$0;
            downloads_global_string_102_delegate$lambda$0 = CommonMainString0.downloads_global_string_102_delegate$lambda$0();
            return downloads_global_string_102_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_103$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda100
        public final Object invoke() {
            StringResource downloads_global_string_103_delegate$lambda$0;
            downloads_global_string_103_delegate$lambda$0 = CommonMainString0.downloads_global_string_103_delegate$lambda$0();
            return downloads_global_string_103_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_104$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda113
        public final Object invoke() {
            StringResource downloads_global_string_104_delegate$lambda$0;
            downloads_global_string_104_delegate$lambda$0 = CommonMainString0.downloads_global_string_104_delegate$lambda$0();
            return downloads_global_string_104_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_105$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda2
        public final Object invoke() {
            StringResource downloads_global_string_105_delegate$lambda$0;
            downloads_global_string_105_delegate$lambda$0 = CommonMainString0.downloads_global_string_105_delegate$lambda$0();
            return downloads_global_string_105_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_106$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda14
        public final Object invoke() {
            StringResource downloads_global_string_106_delegate$lambda$0;
            downloads_global_string_106_delegate$lambda$0 = CommonMainString0.downloads_global_string_106_delegate$lambda$0();
            return downloads_global_string_106_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_107$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda26
        public final Object invoke() {
            StringResource downloads_global_string_107_delegate$lambda$0;
            downloads_global_string_107_delegate$lambda$0 = CommonMainString0.downloads_global_string_107_delegate$lambda$0();
            return downloads_global_string_107_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_108$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda22
        public final Object invoke() {
            StringResource downloads_global_string_108_delegate$lambda$0;
            downloads_global_string_108_delegate$lambda$0 = CommonMainString0.downloads_global_string_108_delegate$lambda$0();
            return downloads_global_string_108_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_109$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda38
        public final Object invoke() {
            StringResource downloads_global_string_109_delegate$lambda$0;
            downloads_global_string_109_delegate$lambda$0 = CommonMainString0.downloads_global_string_109_delegate$lambda$0();
            return downloads_global_string_109_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_11$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda43
        public final Object invoke() {
            StringResource downloads_global_string_11_delegate$lambda$0;
            downloads_global_string_11_delegate$lambda$0 = CommonMainString0.downloads_global_string_11_delegate$lambda$0();
            return downloads_global_string_11_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_110$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda44
        public final Object invoke() {
            StringResource downloads_global_string_110_delegate$lambda$0;
            downloads_global_string_110_delegate$lambda$0 = CommonMainString0.downloads_global_string_110_delegate$lambda$0();
            return downloads_global_string_110_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_111$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda45
        public final Object invoke() {
            StringResource downloads_global_string_111_delegate$lambda$0;
            downloads_global_string_111_delegate$lambda$0 = CommonMainString0.downloads_global_string_111_delegate$lambda$0();
            return downloads_global_string_111_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_112$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda47
        public final Object invoke() {
            StringResource downloads_global_string_112_delegate$lambda$0;
            downloads_global_string_112_delegate$lambda$0 = CommonMainString0.downloads_global_string_112_delegate$lambda$0();
            return downloads_global_string_112_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_113$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda48
        public final Object invoke() {
            StringResource downloads_global_string_113_delegate$lambda$0;
            downloads_global_string_113_delegate$lambda$0 = CommonMainString0.downloads_global_string_113_delegate$lambda$0();
            return downloads_global_string_113_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_114$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda49
        public final Object invoke() {
            StringResource downloads_global_string_114_delegate$lambda$0;
            downloads_global_string_114_delegate$lambda$0 = CommonMainString0.downloads_global_string_114_delegate$lambda$0();
            return downloads_global_string_114_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_115$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda50
        public final Object invoke() {
            StringResource downloads_global_string_115_delegate$lambda$0;
            downloads_global_string_115_delegate$lambda$0 = CommonMainString0.downloads_global_string_115_delegate$lambda$0();
            return downloads_global_string_115_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_116$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda51
        public final Object invoke() {
            StringResource downloads_global_string_116_delegate$lambda$0;
            downloads_global_string_116_delegate$lambda$0 = CommonMainString0.downloads_global_string_116_delegate$lambda$0();
            return downloads_global_string_116_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_117$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda53
        public final Object invoke() {
            StringResource downloads_global_string_117_delegate$lambda$0;
            downloads_global_string_117_delegate$lambda$0 = CommonMainString0.downloads_global_string_117_delegate$lambda$0();
            return downloads_global_string_117_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_118$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda54
        public final Object invoke() {
            StringResource downloads_global_string_118_delegate$lambda$0;
            downloads_global_string_118_delegate$lambda$0 = CommonMainString0.downloads_global_string_118_delegate$lambda$0();
            return downloads_global_string_118_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_119$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda55
        public final Object invoke() {
            StringResource downloads_global_string_119_delegate$lambda$0;
            downloads_global_string_119_delegate$lambda$0 = CommonMainString0.downloads_global_string_119_delegate$lambda$0();
            return downloads_global_string_119_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_12$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda56
        public final Object invoke() {
            StringResource downloads_global_string_12_delegate$lambda$0;
            downloads_global_string_12_delegate$lambda$0 = CommonMainString0.downloads_global_string_12_delegate$lambda$0();
            return downloads_global_string_12_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_120$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda58
        public final Object invoke() {
            StringResource downloads_global_string_120_delegate$lambda$0;
            downloads_global_string_120_delegate$lambda$0 = CommonMainString0.downloads_global_string_120_delegate$lambda$0();
            return downloads_global_string_120_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_121$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda59
        public final Object invoke() {
            StringResource downloads_global_string_121_delegate$lambda$0;
            downloads_global_string_121_delegate$lambda$0 = CommonMainString0.downloads_global_string_121_delegate$lambda$0();
            return downloads_global_string_121_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_122$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda60
        public final Object invoke() {
            StringResource downloads_global_string_122_delegate$lambda$0;
            downloads_global_string_122_delegate$lambda$0 = CommonMainString0.downloads_global_string_122_delegate$lambda$0();
            return downloads_global_string_122_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_123$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda61
        public final Object invoke() {
            StringResource downloads_global_string_123_delegate$lambda$0;
            downloads_global_string_123_delegate$lambda$0 = CommonMainString0.downloads_global_string_123_delegate$lambda$0();
            return downloads_global_string_123_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_125$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda62
        public final Object invoke() {
            StringResource downloads_global_string_125_delegate$lambda$0;
            downloads_global_string_125_delegate$lambda$0 = CommonMainString0.downloads_global_string_125_delegate$lambda$0();
            return downloads_global_string_125_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_13$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda63
        public final Object invoke() {
            StringResource downloads_global_string_13_delegate$lambda$0;
            downloads_global_string_13_delegate$lambda$0 = CommonMainString0.downloads_global_string_13_delegate$lambda$0();
            return downloads_global_string_13_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_14$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda65
        public final Object invoke() {
            StringResource downloads_global_string_14_delegate$lambda$0;
            downloads_global_string_14_delegate$lambda$0 = CommonMainString0.downloads_global_string_14_delegate$lambda$0();
            return downloads_global_string_14_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_15$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda66
        public final Object invoke() {
            StringResource downloads_global_string_15_delegate$lambda$0;
            downloads_global_string_15_delegate$lambda$0 = CommonMainString0.downloads_global_string_15_delegate$lambda$0();
            return downloads_global_string_15_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_16$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda67
        public final Object invoke() {
            StringResource downloads_global_string_16_delegate$lambda$0;
            downloads_global_string_16_delegate$lambda$0 = CommonMainString0.downloads_global_string_16_delegate$lambda$0();
            return downloads_global_string_16_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_17$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda69
        public final Object invoke() {
            StringResource downloads_global_string_17_delegate$lambda$0;
            downloads_global_string_17_delegate$lambda$0 = CommonMainString0.downloads_global_string_17_delegate$lambda$0();
            return downloads_global_string_17_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_18$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda70
        public final Object invoke() {
            StringResource downloads_global_string_18_delegate$lambda$0;
            downloads_global_string_18_delegate$lambda$0 = CommonMainString0.downloads_global_string_18_delegate$lambda$0();
            return downloads_global_string_18_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_19$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda71
        public final Object invoke() {
            StringResource downloads_global_string_19_delegate$lambda$0;
            downloads_global_string_19_delegate$lambda$0 = CommonMainString0.downloads_global_string_19_delegate$lambda$0();
            return downloads_global_string_19_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_2$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda72
        public final Object invoke() {
            StringResource downloads_global_string_2_delegate$lambda$0;
            downloads_global_string_2_delegate$lambda$0 = CommonMainString0.downloads_global_string_2_delegate$lambda$0();
            return downloads_global_string_2_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_20$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda73
        public final Object invoke() {
            StringResource downloads_global_string_20_delegate$lambda$0;
            downloads_global_string_20_delegate$lambda$0 = CommonMainString0.downloads_global_string_20_delegate$lambda$0();
            return downloads_global_string_20_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_21$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda74
        public final Object invoke() {
            StringResource downloads_global_string_21_delegate$lambda$0;
            downloads_global_string_21_delegate$lambda$0 = CommonMainString0.downloads_global_string_21_delegate$lambda$0();
            return downloads_global_string_21_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_22$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda75
        public final Object invoke() {
            StringResource downloads_global_string_22_delegate$lambda$0;
            downloads_global_string_22_delegate$lambda$0 = CommonMainString0.downloads_global_string_22_delegate$lambda$0();
            return downloads_global_string_22_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_23$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda77
        public final Object invoke() {
            StringResource downloads_global_string_23_delegate$lambda$0;
            downloads_global_string_23_delegate$lambda$0 = CommonMainString0.downloads_global_string_23_delegate$lambda$0();
            return downloads_global_string_23_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_24$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda78
        public final Object invoke() {
            StringResource downloads_global_string_24_delegate$lambda$0;
            downloads_global_string_24_delegate$lambda$0 = CommonMainString0.downloads_global_string_24_delegate$lambda$0();
            return downloads_global_string_24_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_25$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda80
        public final Object invoke() {
            StringResource downloads_global_string_25_delegate$lambda$0;
            downloads_global_string_25_delegate$lambda$0 = CommonMainString0.downloads_global_string_25_delegate$lambda$0();
            return downloads_global_string_25_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_26$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda81
        public final Object invoke() {
            StringResource downloads_global_string_26_delegate$lambda$0;
            downloads_global_string_26_delegate$lambda$0 = CommonMainString0.downloads_global_string_26_delegate$lambda$0();
            return downloads_global_string_26_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_27$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda82
        public final Object invoke() {
            StringResource downloads_global_string_27_delegate$lambda$0;
            downloads_global_string_27_delegate$lambda$0 = CommonMainString0.downloads_global_string_27_delegate$lambda$0();
            return downloads_global_string_27_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_28$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda83
        public final Object invoke() {
            StringResource downloads_global_string_28_delegate$lambda$0;
            downloads_global_string_28_delegate$lambda$0 = CommonMainString0.downloads_global_string_28_delegate$lambda$0();
            return downloads_global_string_28_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_29$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda84
        public final Object invoke() {
            StringResource downloads_global_string_29_delegate$lambda$0;
            downloads_global_string_29_delegate$lambda$0 = CommonMainString0.downloads_global_string_29_delegate$lambda$0();
            return downloads_global_string_29_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_3$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda85
        public final Object invoke() {
            StringResource downloads_global_string_3_delegate$lambda$0;
            downloads_global_string_3_delegate$lambda$0 = CommonMainString0.downloads_global_string_3_delegate$lambda$0();
            return downloads_global_string_3_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_30$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda86
        public final Object invoke() {
            StringResource downloads_global_string_30_delegate$lambda$0;
            downloads_global_string_30_delegate$lambda$0 = CommonMainString0.downloads_global_string_30_delegate$lambda$0();
            return downloads_global_string_30_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_31$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda87
        public final Object invoke() {
            StringResource downloads_global_string_31_delegate$lambda$0;
            downloads_global_string_31_delegate$lambda$0 = CommonMainString0.downloads_global_string_31_delegate$lambda$0();
            return downloads_global_string_31_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_32$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda89
        public final Object invoke() {
            StringResource downloads_global_string_32_delegate$lambda$0;
            downloads_global_string_32_delegate$lambda$0 = CommonMainString0.downloads_global_string_32_delegate$lambda$0();
            return downloads_global_string_32_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_33$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda91
        public final Object invoke() {
            StringResource downloads_global_string_33_delegate$lambda$0;
            downloads_global_string_33_delegate$lambda$0 = CommonMainString0.downloads_global_string_33_delegate$lambda$0();
            return downloads_global_string_33_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_34$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda92
        public final Object invoke() {
            StringResource downloads_global_string_34_delegate$lambda$0;
            downloads_global_string_34_delegate$lambda$0 = CommonMainString0.downloads_global_string_34_delegate$lambda$0();
            return downloads_global_string_34_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_35$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda93
        public final Object invoke() {
            StringResource downloads_global_string_35_delegate$lambda$0;
            downloads_global_string_35_delegate$lambda$0 = CommonMainString0.downloads_global_string_35_delegate$lambda$0();
            return downloads_global_string_35_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_36$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda94
        public final Object invoke() {
            StringResource downloads_global_string_36_delegate$lambda$0;
            downloads_global_string_36_delegate$lambda$0 = CommonMainString0.downloads_global_string_36_delegate$lambda$0();
            return downloads_global_string_36_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_37$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda95
        public final Object invoke() {
            StringResource downloads_global_string_37_delegate$lambda$0;
            downloads_global_string_37_delegate$lambda$0 = CommonMainString0.downloads_global_string_37_delegate$lambda$0();
            return downloads_global_string_37_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_38$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda96
        public final Object invoke() {
            StringResource downloads_global_string_38_delegate$lambda$0;
            downloads_global_string_38_delegate$lambda$0 = CommonMainString0.downloads_global_string_38_delegate$lambda$0();
            return downloads_global_string_38_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_39$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda97
        public final Object invoke() {
            StringResource downloads_global_string_39_delegate$lambda$0;
            downloads_global_string_39_delegate$lambda$0 = CommonMainString0.downloads_global_string_39_delegate$lambda$0();
            return downloads_global_string_39_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_4$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda98
        public final Object invoke() {
            StringResource downloads_global_string_4_delegate$lambda$0;
            downloads_global_string_4_delegate$lambda$0 = CommonMainString0.downloads_global_string_4_delegate$lambda$0();
            return downloads_global_string_4_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_40$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda99
        public final Object invoke() {
            StringResource downloads_global_string_40_delegate$lambda$0;
            downloads_global_string_40_delegate$lambda$0 = CommonMainString0.downloads_global_string_40_delegate$lambda$0();
            return downloads_global_string_40_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_41$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda102
        public final Object invoke() {
            StringResource downloads_global_string_41_delegate$lambda$0;
            downloads_global_string_41_delegate$lambda$0 = CommonMainString0.downloads_global_string_41_delegate$lambda$0();
            return downloads_global_string_41_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_42$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda103
        public final Object invoke() {
            StringResource downloads_global_string_42_delegate$lambda$0;
            downloads_global_string_42_delegate$lambda$0 = CommonMainString0.downloads_global_string_42_delegate$lambda$0();
            return downloads_global_string_42_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_43$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda104
        public final Object invoke() {
            StringResource downloads_global_string_43_delegate$lambda$0;
            downloads_global_string_43_delegate$lambda$0 = CommonMainString0.downloads_global_string_43_delegate$lambda$0();
            return downloads_global_string_43_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_44$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda105
        public final Object invoke() {
            StringResource downloads_global_string_44_delegate$lambda$0;
            downloads_global_string_44_delegate$lambda$0 = CommonMainString0.downloads_global_string_44_delegate$lambda$0();
            return downloads_global_string_44_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_45$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda106
        public final Object invoke() {
            StringResource downloads_global_string_45_delegate$lambda$0;
            downloads_global_string_45_delegate$lambda$0 = CommonMainString0.downloads_global_string_45_delegate$lambda$0();
            return downloads_global_string_45_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_46$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda107
        public final Object invoke() {
            StringResource downloads_global_string_46_delegate$lambda$0;
            downloads_global_string_46_delegate$lambda$0 = CommonMainString0.downloads_global_string_46_delegate$lambda$0();
            return downloads_global_string_46_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_47$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda108
        public final Object invoke() {
            StringResource downloads_global_string_47_delegate$lambda$0;
            downloads_global_string_47_delegate$lambda$0 = CommonMainString0.downloads_global_string_47_delegate$lambda$0();
            return downloads_global_string_47_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_48$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda109
        public final Object invoke() {
            StringResource downloads_global_string_48_delegate$lambda$0;
            downloads_global_string_48_delegate$lambda$0 = CommonMainString0.downloads_global_string_48_delegate$lambda$0();
            return downloads_global_string_48_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_49$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda110
        public final Object invoke() {
            StringResource downloads_global_string_49_delegate$lambda$0;
            downloads_global_string_49_delegate$lambda$0 = CommonMainString0.downloads_global_string_49_delegate$lambda$0();
            return downloads_global_string_49_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_5$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda111
        public final Object invoke() {
            StringResource downloads_global_string_5_delegate$lambda$0;
            downloads_global_string_5_delegate$lambda$0 = CommonMainString0.downloads_global_string_5_delegate$lambda$0();
            return downloads_global_string_5_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_50$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda114
        public final Object invoke() {
            StringResource downloads_global_string_50_delegate$lambda$0;
            downloads_global_string_50_delegate$lambda$0 = CommonMainString0.downloads_global_string_50_delegate$lambda$0();
            return downloads_global_string_50_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_51$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda115
        public final Object invoke() {
            StringResource downloads_global_string_51_delegate$lambda$0;
            downloads_global_string_51_delegate$lambda$0 = CommonMainString0.downloads_global_string_51_delegate$lambda$0();
            return downloads_global_string_51_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_52$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda116
        public final Object invoke() {
            StringResource downloads_global_string_52_delegate$lambda$0;
            downloads_global_string_52_delegate$lambda$0 = CommonMainString0.downloads_global_string_52_delegate$lambda$0();
            return downloads_global_string_52_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_53$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda117
        public final Object invoke() {
            StringResource downloads_global_string_53_delegate$lambda$0;
            downloads_global_string_53_delegate$lambda$0 = CommonMainString0.downloads_global_string_53_delegate$lambda$0();
            return downloads_global_string_53_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_54$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda118
        public final Object invoke() {
            StringResource downloads_global_string_54_delegate$lambda$0;
            downloads_global_string_54_delegate$lambda$0 = CommonMainString0.downloads_global_string_54_delegate$lambda$0();
            return downloads_global_string_54_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_55$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda119
        public final Object invoke() {
            StringResource downloads_global_string_55_delegate$lambda$0;
            downloads_global_string_55_delegate$lambda$0 = CommonMainString0.downloads_global_string_55_delegate$lambda$0();
            return downloads_global_string_55_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_56$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda120
        public final Object invoke() {
            StringResource downloads_global_string_56_delegate$lambda$0;
            downloads_global_string_56_delegate$lambda$0 = CommonMainString0.downloads_global_string_56_delegate$lambda$0();
            return downloads_global_string_56_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_57$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda121
        public final Object invoke() {
            StringResource downloads_global_string_57_delegate$lambda$0;
            downloads_global_string_57_delegate$lambda$0 = CommonMainString0.downloads_global_string_57_delegate$lambda$0();
            return downloads_global_string_57_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_58$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda122
        public final Object invoke() {
            StringResource downloads_global_string_58_delegate$lambda$0;
            downloads_global_string_58_delegate$lambda$0 = CommonMainString0.downloads_global_string_58_delegate$lambda$0();
            return downloads_global_string_58_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_59$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda1
        public final Object invoke() {
            StringResource downloads_global_string_59_delegate$lambda$0;
            downloads_global_string_59_delegate$lambda$0 = CommonMainString0.downloads_global_string_59_delegate$lambda$0();
            return downloads_global_string_59_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_6$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda3
        public final Object invoke() {
            StringResource downloads_global_string_6_delegate$lambda$0;
            downloads_global_string_6_delegate$lambda$0 = CommonMainString0.downloads_global_string_6_delegate$lambda$0();
            return downloads_global_string_6_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_60$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda4
        public final Object invoke() {
            StringResource downloads_global_string_60_delegate$lambda$0;
            downloads_global_string_60_delegate$lambda$0 = CommonMainString0.downloads_global_string_60_delegate$lambda$0();
            return downloads_global_string_60_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_61$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda5
        public final Object invoke() {
            StringResource downloads_global_string_61_delegate$lambda$0;
            downloads_global_string_61_delegate$lambda$0 = CommonMainString0.downloads_global_string_61_delegate$lambda$0();
            return downloads_global_string_61_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_62$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda6
        public final Object invoke() {
            StringResource downloads_global_string_62_delegate$lambda$0;
            downloads_global_string_62_delegate$lambda$0 = CommonMainString0.downloads_global_string_62_delegate$lambda$0();
            return downloads_global_string_62_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_63$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda7
        public final Object invoke() {
            StringResource downloads_global_string_63_delegate$lambda$0;
            downloads_global_string_63_delegate$lambda$0 = CommonMainString0.downloads_global_string_63_delegate$lambda$0();
            return downloads_global_string_63_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_64$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda8
        public final Object invoke() {
            StringResource downloads_global_string_64_delegate$lambda$0;
            downloads_global_string_64_delegate$lambda$0 = CommonMainString0.downloads_global_string_64_delegate$lambda$0();
            return downloads_global_string_64_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_65$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda9
        public final Object invoke() {
            StringResource downloads_global_string_65_delegate$lambda$0;
            downloads_global_string_65_delegate$lambda$0 = CommonMainString0.downloads_global_string_65_delegate$lambda$0();
            return downloads_global_string_65_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_66$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda10
        public final Object invoke() {
            StringResource downloads_global_string_66_delegate$lambda$0;
            downloads_global_string_66_delegate$lambda$0 = CommonMainString0.downloads_global_string_66_delegate$lambda$0();
            return downloads_global_string_66_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_67$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda12
        public final Object invoke() {
            StringResource downloads_global_string_67_delegate$lambda$0;
            downloads_global_string_67_delegate$lambda$0 = CommonMainString0.downloads_global_string_67_delegate$lambda$0();
            return downloads_global_string_67_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_68$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda13
        public final Object invoke() {
            StringResource downloads_global_string_68_delegate$lambda$0;
            downloads_global_string_68_delegate$lambda$0 = CommonMainString0.downloads_global_string_68_delegate$lambda$0();
            return downloads_global_string_68_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_69$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda15
        public final Object invoke() {
            StringResource downloads_global_string_69_delegate$lambda$0;
            downloads_global_string_69_delegate$lambda$0 = CommonMainString0.downloads_global_string_69_delegate$lambda$0();
            return downloads_global_string_69_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_7$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda16
        public final Object invoke() {
            StringResource downloads_global_string_7_delegate$lambda$0;
            downloads_global_string_7_delegate$lambda$0 = CommonMainString0.downloads_global_string_7_delegate$lambda$0();
            return downloads_global_string_7_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_70$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda17
        public final Object invoke() {
            StringResource downloads_global_string_70_delegate$lambda$0;
            downloads_global_string_70_delegate$lambda$0 = CommonMainString0.downloads_global_string_70_delegate$lambda$0();
            return downloads_global_string_70_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_71$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda18
        public final Object invoke() {
            StringResource downloads_global_string_71_delegate$lambda$0;
            downloads_global_string_71_delegate$lambda$0 = CommonMainString0.downloads_global_string_71_delegate$lambda$0();
            return downloads_global_string_71_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_72$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda19
        public final Object invoke() {
            StringResource downloads_global_string_72_delegate$lambda$0;
            downloads_global_string_72_delegate$lambda$0 = CommonMainString0.downloads_global_string_72_delegate$lambda$0();
            return downloads_global_string_72_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_73$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda20
        public final Object invoke() {
            StringResource downloads_global_string_73_delegate$lambda$0;
            downloads_global_string_73_delegate$lambda$0 = CommonMainString0.downloads_global_string_73_delegate$lambda$0();
            return downloads_global_string_73_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_74$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda21
        public final Object invoke() {
            StringResource downloads_global_string_74_delegate$lambda$0;
            downloads_global_string_74_delegate$lambda$0 = CommonMainString0.downloads_global_string_74_delegate$lambda$0();
            return downloads_global_string_74_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_75$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda23
        public final Object invoke() {
            StringResource downloads_global_string_75_delegate$lambda$0;
            downloads_global_string_75_delegate$lambda$0 = CommonMainString0.downloads_global_string_75_delegate$lambda$0();
            return downloads_global_string_75_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_76$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda24
        public final Object invoke() {
            StringResource downloads_global_string_76_delegate$lambda$0;
            downloads_global_string_76_delegate$lambda$0 = CommonMainString0.downloads_global_string_76_delegate$lambda$0();
            return downloads_global_string_76_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_77$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda25
        public final Object invoke() {
            StringResource downloads_global_string_77_delegate$lambda$0;
            downloads_global_string_77_delegate$lambda$0 = CommonMainString0.downloads_global_string_77_delegate$lambda$0();
            return downloads_global_string_77_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_78$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda35
        public final Object invoke() {
            StringResource downloads_global_string_78_delegate$lambda$0;
            downloads_global_string_78_delegate$lambda$0 = CommonMainString0.downloads_global_string_78_delegate$lambda$0();
            return downloads_global_string_78_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_79$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda46
        public final Object invoke() {
            StringResource downloads_global_string_79_delegate$lambda$0;
            downloads_global_string_79_delegate$lambda$0 = CommonMainString0.downloads_global_string_79_delegate$lambda$0();
            return downloads_global_string_79_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_8$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda57
        public final Object invoke() {
            StringResource downloads_global_string_8_delegate$lambda$0;
            downloads_global_string_8_delegate$lambda$0 = CommonMainString0.downloads_global_string_8_delegate$lambda$0();
            return downloads_global_string_8_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_80$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda68
        public final Object invoke() {
            StringResource downloads_global_string_80_delegate$lambda$0;
            downloads_global_string_80_delegate$lambda$0 = CommonMainString0.downloads_global_string_80_delegate$lambda$0();
            return downloads_global_string_80_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_81$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda79
        public final Object invoke() {
            StringResource downloads_global_string_81_delegate$lambda$0;
            downloads_global_string_81_delegate$lambda$0 = CommonMainString0.downloads_global_string_81_delegate$lambda$0();
            return downloads_global_string_81_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_82$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda90
        public final Object invoke() {
            StringResource downloads_global_string_82_delegate$lambda$0;
            downloads_global_string_82_delegate$lambda$0 = CommonMainString0.downloads_global_string_82_delegate$lambda$0();
            return downloads_global_string_82_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_83$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda101
        public final Object invoke() {
            StringResource downloads_global_string_83_delegate$lambda$0;
            downloads_global_string_83_delegate$lambda$0 = CommonMainString0.downloads_global_string_83_delegate$lambda$0();
            return downloads_global_string_83_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_84$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda112
        public final Object invoke() {
            StringResource downloads_global_string_84_delegate$lambda$0;
            downloads_global_string_84_delegate$lambda$0 = CommonMainString0.downloads_global_string_84_delegate$lambda$0();
            return downloads_global_string_84_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_85$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda123
        public final Object invoke() {
            StringResource downloads_global_string_85_delegate$lambda$0;
            downloads_global_string_85_delegate$lambda$0 = CommonMainString0.downloads_global_string_85_delegate$lambda$0();
            return downloads_global_string_85_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_86$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda11
        public final Object invoke() {
            StringResource downloads_global_string_86_delegate$lambda$0;
            downloads_global_string_86_delegate$lambda$0 = CommonMainString0.downloads_global_string_86_delegate$lambda$0();
            return downloads_global_string_86_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_87$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda27
        public final Object invoke() {
            StringResource downloads_global_string_87_delegate$lambda$0;
            downloads_global_string_87_delegate$lambda$0 = CommonMainString0.downloads_global_string_87_delegate$lambda$0();
            return downloads_global_string_87_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_88$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda28
        public final Object invoke() {
            StringResource downloads_global_string_88_delegate$lambda$0;
            downloads_global_string_88_delegate$lambda$0 = CommonMainString0.downloads_global_string_88_delegate$lambda$0();
            return downloads_global_string_88_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_89$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda29
        public final Object invoke() {
            StringResource downloads_global_string_89_delegate$lambda$0;
            downloads_global_string_89_delegate$lambda$0 = CommonMainString0.downloads_global_string_89_delegate$lambda$0();
            return downloads_global_string_89_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_9$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda30
        public final Object invoke() {
            StringResource downloads_global_string_9_delegate$lambda$0;
            downloads_global_string_9_delegate$lambda$0 = CommonMainString0.downloads_global_string_9_delegate$lambda$0();
            return downloads_global_string_9_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_90$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda31
        public final Object invoke() {
            StringResource downloads_global_string_90_delegate$lambda$0;
            downloads_global_string_90_delegate$lambda$0 = CommonMainString0.downloads_global_string_90_delegate$lambda$0();
            return downloads_global_string_90_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_91$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda32
        public final Object invoke() {
            StringResource downloads_global_string_91_delegate$lambda$0;
            downloads_global_string_91_delegate$lambda$0 = CommonMainString0.downloads_global_string_91_delegate$lambda$0();
            return downloads_global_string_91_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_92$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda33
        public final Object invoke() {
            StringResource downloads_global_string_92_delegate$lambda$0;
            downloads_global_string_92_delegate$lambda$0 = CommonMainString0.downloads_global_string_92_delegate$lambda$0();
            return downloads_global_string_92_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_93$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda34
        public final Object invoke() {
            StringResource downloads_global_string_93_delegate$lambda$0;
            downloads_global_string_93_delegate$lambda$0 = CommonMainString0.downloads_global_string_93_delegate$lambda$0();
            return downloads_global_string_93_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_94$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda36
        public final Object invoke() {
            StringResource downloads_global_string_94_delegate$lambda$0;
            downloads_global_string_94_delegate$lambda$0 = CommonMainString0.downloads_global_string_94_delegate$lambda$0();
            return downloads_global_string_94_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_95$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda37
        public final Object invoke() {
            StringResource downloads_global_string_95_delegate$lambda$0;
            downloads_global_string_95_delegate$lambda$0 = CommonMainString0.downloads_global_string_95_delegate$lambda$0();
            return downloads_global_string_95_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_96$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda39
        public final Object invoke() {
            StringResource downloads_global_string_96_delegate$lambda$0;
            downloads_global_string_96_delegate$lambda$0 = CommonMainString0.downloads_global_string_96_delegate$lambda$0();
            return downloads_global_string_96_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_97$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda40
        public final Object invoke() {
            StringResource downloads_global_string_97_delegate$lambda$0;
            downloads_global_string_97_delegate$lambda$0 = CommonMainString0.downloads_global_string_97_delegate$lambda$0();
            return downloads_global_string_97_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_98$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda41
        public final Object invoke() {
            StringResource downloads_global_string_98_delegate$lambda$0;
            downloads_global_string_98_delegate$lambda$0 = CommonMainString0.downloads_global_string_98_delegate$lambda$0();
            return downloads_global_string_98_delegate$lambda$0;
        }
    });
    private static final Lazy downloads_global_string_99$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.downloads.CommonMainString0$$ExternalSyntheticLambda42
        public final Object invoke() {
            StringResource downloads_global_string_99_delegate$lambda$0;
            downloads_global_string_99_delegate$lambda$0 = CommonMainString0.downloads_global_string_99_delegate$lambda$0();
            return downloads_global_string_99_delegate$lambda$0;
        }
    });

    private CommonMainString0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_1_delegate$lambda$0() {
        StringResource init_downloads_global_string_1;
        init_downloads_global_string_1 = String0_commonMainKt.init_downloads_global_string_1();
        return init_downloads_global_string_1;
    }

    public final StringResource getDownloads_global_string_1() {
        return (StringResource) downloads_global_string_1$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_10_delegate$lambda$0() {
        StringResource init_downloads_global_string_10;
        init_downloads_global_string_10 = String0_commonMainKt.init_downloads_global_string_10();
        return init_downloads_global_string_10;
    }

    public final StringResource getDownloads_global_string_10() {
        return (StringResource) downloads_global_string_10$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_100_delegate$lambda$0() {
        StringResource init_downloads_global_string_100;
        init_downloads_global_string_100 = String0_commonMainKt.init_downloads_global_string_100();
        return init_downloads_global_string_100;
    }

    public final StringResource getDownloads_global_string_100() {
        return (StringResource) downloads_global_string_100$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_101_delegate$lambda$0() {
        StringResource init_downloads_global_string_101;
        init_downloads_global_string_101 = String0_commonMainKt.init_downloads_global_string_101();
        return init_downloads_global_string_101;
    }

    public final StringResource getDownloads_global_string_101() {
        return (StringResource) downloads_global_string_101$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_102_delegate$lambda$0() {
        StringResource init_downloads_global_string_102;
        init_downloads_global_string_102 = String0_commonMainKt.init_downloads_global_string_102();
        return init_downloads_global_string_102;
    }

    public final StringResource getDownloads_global_string_102() {
        return (StringResource) downloads_global_string_102$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_103_delegate$lambda$0() {
        StringResource init_downloads_global_string_103;
        init_downloads_global_string_103 = String0_commonMainKt.init_downloads_global_string_103();
        return init_downloads_global_string_103;
    }

    public final StringResource getDownloads_global_string_103() {
        return (StringResource) downloads_global_string_103$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_104_delegate$lambda$0() {
        StringResource init_downloads_global_string_104;
        init_downloads_global_string_104 = String0_commonMainKt.init_downloads_global_string_104();
        return init_downloads_global_string_104;
    }

    public final StringResource getDownloads_global_string_104() {
        return (StringResource) downloads_global_string_104$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_105_delegate$lambda$0() {
        StringResource init_downloads_global_string_105;
        init_downloads_global_string_105 = String0_commonMainKt.init_downloads_global_string_105();
        return init_downloads_global_string_105;
    }

    public final StringResource getDownloads_global_string_105() {
        return (StringResource) downloads_global_string_105$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_106_delegate$lambda$0() {
        StringResource init_downloads_global_string_106;
        init_downloads_global_string_106 = String0_commonMainKt.init_downloads_global_string_106();
        return init_downloads_global_string_106;
    }

    public final StringResource getDownloads_global_string_106() {
        return (StringResource) downloads_global_string_106$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_107_delegate$lambda$0() {
        StringResource init_downloads_global_string_107;
        init_downloads_global_string_107 = String0_commonMainKt.init_downloads_global_string_107();
        return init_downloads_global_string_107;
    }

    public final StringResource getDownloads_global_string_107() {
        return (StringResource) downloads_global_string_107$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_108_delegate$lambda$0() {
        StringResource init_downloads_global_string_108;
        init_downloads_global_string_108 = String0_commonMainKt.init_downloads_global_string_108();
        return init_downloads_global_string_108;
    }

    public final StringResource getDownloads_global_string_108() {
        return (StringResource) downloads_global_string_108$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_109_delegate$lambda$0() {
        StringResource init_downloads_global_string_109;
        init_downloads_global_string_109 = String0_commonMainKt.init_downloads_global_string_109();
        return init_downloads_global_string_109;
    }

    public final StringResource getDownloads_global_string_109() {
        return (StringResource) downloads_global_string_109$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_11_delegate$lambda$0() {
        StringResource init_downloads_global_string_11;
        init_downloads_global_string_11 = String0_commonMainKt.init_downloads_global_string_11();
        return init_downloads_global_string_11;
    }

    public final StringResource getDownloads_global_string_11() {
        return (StringResource) downloads_global_string_11$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_110_delegate$lambda$0() {
        StringResource init_downloads_global_string_110;
        init_downloads_global_string_110 = String0_commonMainKt.init_downloads_global_string_110();
        return init_downloads_global_string_110;
    }

    public final StringResource getDownloads_global_string_110() {
        return (StringResource) downloads_global_string_110$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_111_delegate$lambda$0() {
        StringResource init_downloads_global_string_111;
        init_downloads_global_string_111 = String0_commonMainKt.init_downloads_global_string_111();
        return init_downloads_global_string_111;
    }

    public final StringResource getDownloads_global_string_111() {
        return (StringResource) downloads_global_string_111$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_112_delegate$lambda$0() {
        StringResource init_downloads_global_string_112;
        init_downloads_global_string_112 = String0_commonMainKt.init_downloads_global_string_112();
        return init_downloads_global_string_112;
    }

    public final StringResource getDownloads_global_string_112() {
        return (StringResource) downloads_global_string_112$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_113_delegate$lambda$0() {
        StringResource init_downloads_global_string_113;
        init_downloads_global_string_113 = String0_commonMainKt.init_downloads_global_string_113();
        return init_downloads_global_string_113;
    }

    public final StringResource getDownloads_global_string_113() {
        return (StringResource) downloads_global_string_113$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_114_delegate$lambda$0() {
        StringResource init_downloads_global_string_114;
        init_downloads_global_string_114 = String0_commonMainKt.init_downloads_global_string_114();
        return init_downloads_global_string_114;
    }

    public final StringResource getDownloads_global_string_114() {
        return (StringResource) downloads_global_string_114$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_115_delegate$lambda$0() {
        StringResource init_downloads_global_string_115;
        init_downloads_global_string_115 = String0_commonMainKt.init_downloads_global_string_115();
        return init_downloads_global_string_115;
    }

    public final StringResource getDownloads_global_string_115() {
        return (StringResource) downloads_global_string_115$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_116_delegate$lambda$0() {
        StringResource init_downloads_global_string_116;
        init_downloads_global_string_116 = String0_commonMainKt.init_downloads_global_string_116();
        return init_downloads_global_string_116;
    }

    public final StringResource getDownloads_global_string_116() {
        return (StringResource) downloads_global_string_116$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_117_delegate$lambda$0() {
        StringResource init_downloads_global_string_117;
        init_downloads_global_string_117 = String0_commonMainKt.init_downloads_global_string_117();
        return init_downloads_global_string_117;
    }

    public final StringResource getDownloads_global_string_117() {
        return (StringResource) downloads_global_string_117$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_118_delegate$lambda$0() {
        StringResource init_downloads_global_string_118;
        init_downloads_global_string_118 = String0_commonMainKt.init_downloads_global_string_118();
        return init_downloads_global_string_118;
    }

    public final StringResource getDownloads_global_string_118() {
        return (StringResource) downloads_global_string_118$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_119_delegate$lambda$0() {
        StringResource init_downloads_global_string_119;
        init_downloads_global_string_119 = String0_commonMainKt.init_downloads_global_string_119();
        return init_downloads_global_string_119;
    }

    public final StringResource getDownloads_global_string_119() {
        return (StringResource) downloads_global_string_119$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_12_delegate$lambda$0() {
        StringResource init_downloads_global_string_12;
        init_downloads_global_string_12 = String0_commonMainKt.init_downloads_global_string_12();
        return init_downloads_global_string_12;
    }

    public final StringResource getDownloads_global_string_12() {
        return (StringResource) downloads_global_string_12$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_120_delegate$lambda$0() {
        StringResource init_downloads_global_string_120;
        init_downloads_global_string_120 = String0_commonMainKt.init_downloads_global_string_120();
        return init_downloads_global_string_120;
    }

    public final StringResource getDownloads_global_string_120() {
        return (StringResource) downloads_global_string_120$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_121_delegate$lambda$0() {
        StringResource init_downloads_global_string_121;
        init_downloads_global_string_121 = String0_commonMainKt.init_downloads_global_string_121();
        return init_downloads_global_string_121;
    }

    public final StringResource getDownloads_global_string_121() {
        return (StringResource) downloads_global_string_121$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_122_delegate$lambda$0() {
        StringResource init_downloads_global_string_122;
        init_downloads_global_string_122 = String0_commonMainKt.init_downloads_global_string_122();
        return init_downloads_global_string_122;
    }

    public final StringResource getDownloads_global_string_122() {
        return (StringResource) downloads_global_string_122$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_123_delegate$lambda$0() {
        StringResource init_downloads_global_string_123;
        init_downloads_global_string_123 = String0_commonMainKt.init_downloads_global_string_123();
        return init_downloads_global_string_123;
    }

    public final StringResource getDownloads_global_string_123() {
        return (StringResource) downloads_global_string_123$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_125_delegate$lambda$0() {
        StringResource init_downloads_global_string_125;
        init_downloads_global_string_125 = String0_commonMainKt.init_downloads_global_string_125();
        return init_downloads_global_string_125;
    }

    public final StringResource getDownloads_global_string_125() {
        return (StringResource) downloads_global_string_125$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_13_delegate$lambda$0() {
        StringResource init_downloads_global_string_13;
        init_downloads_global_string_13 = String0_commonMainKt.init_downloads_global_string_13();
        return init_downloads_global_string_13;
    }

    public final StringResource getDownloads_global_string_13() {
        return (StringResource) downloads_global_string_13$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_14_delegate$lambda$0() {
        StringResource init_downloads_global_string_14;
        init_downloads_global_string_14 = String0_commonMainKt.init_downloads_global_string_14();
        return init_downloads_global_string_14;
    }

    public final StringResource getDownloads_global_string_14() {
        return (StringResource) downloads_global_string_14$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_15_delegate$lambda$0() {
        StringResource init_downloads_global_string_15;
        init_downloads_global_string_15 = String0_commonMainKt.init_downloads_global_string_15();
        return init_downloads_global_string_15;
    }

    public final StringResource getDownloads_global_string_15() {
        return (StringResource) downloads_global_string_15$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_16_delegate$lambda$0() {
        StringResource init_downloads_global_string_16;
        init_downloads_global_string_16 = String0_commonMainKt.init_downloads_global_string_16();
        return init_downloads_global_string_16;
    }

    public final StringResource getDownloads_global_string_16() {
        return (StringResource) downloads_global_string_16$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_17_delegate$lambda$0() {
        StringResource init_downloads_global_string_17;
        init_downloads_global_string_17 = String0_commonMainKt.init_downloads_global_string_17();
        return init_downloads_global_string_17;
    }

    public final StringResource getDownloads_global_string_17() {
        return (StringResource) downloads_global_string_17$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_18_delegate$lambda$0() {
        StringResource init_downloads_global_string_18;
        init_downloads_global_string_18 = String0_commonMainKt.init_downloads_global_string_18();
        return init_downloads_global_string_18;
    }

    public final StringResource getDownloads_global_string_18() {
        return (StringResource) downloads_global_string_18$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_19_delegate$lambda$0() {
        StringResource init_downloads_global_string_19;
        init_downloads_global_string_19 = String0_commonMainKt.init_downloads_global_string_19();
        return init_downloads_global_string_19;
    }

    public final StringResource getDownloads_global_string_19() {
        return (StringResource) downloads_global_string_19$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_2_delegate$lambda$0() {
        StringResource init_downloads_global_string_2;
        init_downloads_global_string_2 = String0_commonMainKt.init_downloads_global_string_2();
        return init_downloads_global_string_2;
    }

    public final StringResource getDownloads_global_string_2() {
        return (StringResource) downloads_global_string_2$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_20_delegate$lambda$0() {
        StringResource init_downloads_global_string_20;
        init_downloads_global_string_20 = String0_commonMainKt.init_downloads_global_string_20();
        return init_downloads_global_string_20;
    }

    public final StringResource getDownloads_global_string_20() {
        return (StringResource) downloads_global_string_20$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_21_delegate$lambda$0() {
        StringResource init_downloads_global_string_21;
        init_downloads_global_string_21 = String0_commonMainKt.init_downloads_global_string_21();
        return init_downloads_global_string_21;
    }

    public final StringResource getDownloads_global_string_21() {
        return (StringResource) downloads_global_string_21$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_22_delegate$lambda$0() {
        StringResource init_downloads_global_string_22;
        init_downloads_global_string_22 = String0_commonMainKt.init_downloads_global_string_22();
        return init_downloads_global_string_22;
    }

    public final StringResource getDownloads_global_string_22() {
        return (StringResource) downloads_global_string_22$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_23_delegate$lambda$0() {
        StringResource init_downloads_global_string_23;
        init_downloads_global_string_23 = String0_commonMainKt.init_downloads_global_string_23();
        return init_downloads_global_string_23;
    }

    public final StringResource getDownloads_global_string_23() {
        return (StringResource) downloads_global_string_23$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_24_delegate$lambda$0() {
        StringResource init_downloads_global_string_24;
        init_downloads_global_string_24 = String0_commonMainKt.init_downloads_global_string_24();
        return init_downloads_global_string_24;
    }

    public final StringResource getDownloads_global_string_24() {
        return (StringResource) downloads_global_string_24$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_25_delegate$lambda$0() {
        StringResource init_downloads_global_string_25;
        init_downloads_global_string_25 = String0_commonMainKt.init_downloads_global_string_25();
        return init_downloads_global_string_25;
    }

    public final StringResource getDownloads_global_string_25() {
        return (StringResource) downloads_global_string_25$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_26_delegate$lambda$0() {
        StringResource init_downloads_global_string_26;
        init_downloads_global_string_26 = String0_commonMainKt.init_downloads_global_string_26();
        return init_downloads_global_string_26;
    }

    public final StringResource getDownloads_global_string_26() {
        return (StringResource) downloads_global_string_26$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_27_delegate$lambda$0() {
        StringResource init_downloads_global_string_27;
        init_downloads_global_string_27 = String0_commonMainKt.init_downloads_global_string_27();
        return init_downloads_global_string_27;
    }

    public final StringResource getDownloads_global_string_27() {
        return (StringResource) downloads_global_string_27$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_28_delegate$lambda$0() {
        StringResource init_downloads_global_string_28;
        init_downloads_global_string_28 = String0_commonMainKt.init_downloads_global_string_28();
        return init_downloads_global_string_28;
    }

    public final StringResource getDownloads_global_string_28() {
        return (StringResource) downloads_global_string_28$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_29_delegate$lambda$0() {
        StringResource init_downloads_global_string_29;
        init_downloads_global_string_29 = String0_commonMainKt.init_downloads_global_string_29();
        return init_downloads_global_string_29;
    }

    public final StringResource getDownloads_global_string_29() {
        return (StringResource) downloads_global_string_29$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_3_delegate$lambda$0() {
        StringResource init_downloads_global_string_3;
        init_downloads_global_string_3 = String0_commonMainKt.init_downloads_global_string_3();
        return init_downloads_global_string_3;
    }

    public final StringResource getDownloads_global_string_3() {
        return (StringResource) downloads_global_string_3$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_30_delegate$lambda$0() {
        StringResource init_downloads_global_string_30;
        init_downloads_global_string_30 = String0_commonMainKt.init_downloads_global_string_30();
        return init_downloads_global_string_30;
    }

    public final StringResource getDownloads_global_string_30() {
        return (StringResource) downloads_global_string_30$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_31_delegate$lambda$0() {
        StringResource init_downloads_global_string_31;
        init_downloads_global_string_31 = String0_commonMainKt.init_downloads_global_string_31();
        return init_downloads_global_string_31;
    }

    public final StringResource getDownloads_global_string_31() {
        return (StringResource) downloads_global_string_31$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_32_delegate$lambda$0() {
        StringResource init_downloads_global_string_32;
        init_downloads_global_string_32 = String0_commonMainKt.init_downloads_global_string_32();
        return init_downloads_global_string_32;
    }

    public final StringResource getDownloads_global_string_32() {
        return (StringResource) downloads_global_string_32$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_33_delegate$lambda$0() {
        StringResource init_downloads_global_string_33;
        init_downloads_global_string_33 = String0_commonMainKt.init_downloads_global_string_33();
        return init_downloads_global_string_33;
    }

    public final StringResource getDownloads_global_string_33() {
        return (StringResource) downloads_global_string_33$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_34_delegate$lambda$0() {
        StringResource init_downloads_global_string_34;
        init_downloads_global_string_34 = String0_commonMainKt.init_downloads_global_string_34();
        return init_downloads_global_string_34;
    }

    public final StringResource getDownloads_global_string_34() {
        return (StringResource) downloads_global_string_34$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_35_delegate$lambda$0() {
        StringResource init_downloads_global_string_35;
        init_downloads_global_string_35 = String0_commonMainKt.init_downloads_global_string_35();
        return init_downloads_global_string_35;
    }

    public final StringResource getDownloads_global_string_35() {
        return (StringResource) downloads_global_string_35$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_36_delegate$lambda$0() {
        StringResource init_downloads_global_string_36;
        init_downloads_global_string_36 = String0_commonMainKt.init_downloads_global_string_36();
        return init_downloads_global_string_36;
    }

    public final StringResource getDownloads_global_string_36() {
        return (StringResource) downloads_global_string_36$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_37_delegate$lambda$0() {
        StringResource init_downloads_global_string_37;
        init_downloads_global_string_37 = String0_commonMainKt.init_downloads_global_string_37();
        return init_downloads_global_string_37;
    }

    public final StringResource getDownloads_global_string_37() {
        return (StringResource) downloads_global_string_37$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_38_delegate$lambda$0() {
        StringResource init_downloads_global_string_38;
        init_downloads_global_string_38 = String0_commonMainKt.init_downloads_global_string_38();
        return init_downloads_global_string_38;
    }

    public final StringResource getDownloads_global_string_38() {
        return (StringResource) downloads_global_string_38$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_39_delegate$lambda$0() {
        StringResource init_downloads_global_string_39;
        init_downloads_global_string_39 = String0_commonMainKt.init_downloads_global_string_39();
        return init_downloads_global_string_39;
    }

    public final StringResource getDownloads_global_string_39() {
        return (StringResource) downloads_global_string_39$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_4_delegate$lambda$0() {
        StringResource init_downloads_global_string_4;
        init_downloads_global_string_4 = String0_commonMainKt.init_downloads_global_string_4();
        return init_downloads_global_string_4;
    }

    public final StringResource getDownloads_global_string_4() {
        return (StringResource) downloads_global_string_4$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_40_delegate$lambda$0() {
        StringResource init_downloads_global_string_40;
        init_downloads_global_string_40 = String0_commonMainKt.init_downloads_global_string_40();
        return init_downloads_global_string_40;
    }

    public final StringResource getDownloads_global_string_40() {
        return (StringResource) downloads_global_string_40$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_41_delegate$lambda$0() {
        StringResource init_downloads_global_string_41;
        init_downloads_global_string_41 = String0_commonMainKt.init_downloads_global_string_41();
        return init_downloads_global_string_41;
    }

    public final StringResource getDownloads_global_string_41() {
        return (StringResource) downloads_global_string_41$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_42_delegate$lambda$0() {
        StringResource init_downloads_global_string_42;
        init_downloads_global_string_42 = String0_commonMainKt.init_downloads_global_string_42();
        return init_downloads_global_string_42;
    }

    public final StringResource getDownloads_global_string_42() {
        return (StringResource) downloads_global_string_42$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_43_delegate$lambda$0() {
        StringResource init_downloads_global_string_43;
        init_downloads_global_string_43 = String0_commonMainKt.init_downloads_global_string_43();
        return init_downloads_global_string_43;
    }

    public final StringResource getDownloads_global_string_43() {
        return (StringResource) downloads_global_string_43$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_44_delegate$lambda$0() {
        StringResource init_downloads_global_string_44;
        init_downloads_global_string_44 = String0_commonMainKt.init_downloads_global_string_44();
        return init_downloads_global_string_44;
    }

    public final StringResource getDownloads_global_string_44() {
        return (StringResource) downloads_global_string_44$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_45_delegate$lambda$0() {
        StringResource init_downloads_global_string_45;
        init_downloads_global_string_45 = String0_commonMainKt.init_downloads_global_string_45();
        return init_downloads_global_string_45;
    }

    public final StringResource getDownloads_global_string_45() {
        return (StringResource) downloads_global_string_45$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_46_delegate$lambda$0() {
        StringResource init_downloads_global_string_46;
        init_downloads_global_string_46 = String0_commonMainKt.init_downloads_global_string_46();
        return init_downloads_global_string_46;
    }

    public final StringResource getDownloads_global_string_46() {
        return (StringResource) downloads_global_string_46$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_47_delegate$lambda$0() {
        StringResource init_downloads_global_string_47;
        init_downloads_global_string_47 = String0_commonMainKt.init_downloads_global_string_47();
        return init_downloads_global_string_47;
    }

    public final StringResource getDownloads_global_string_47() {
        return (StringResource) downloads_global_string_47$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_48_delegate$lambda$0() {
        StringResource init_downloads_global_string_48;
        init_downloads_global_string_48 = String0_commonMainKt.init_downloads_global_string_48();
        return init_downloads_global_string_48;
    }

    public final StringResource getDownloads_global_string_48() {
        return (StringResource) downloads_global_string_48$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_49_delegate$lambda$0() {
        StringResource init_downloads_global_string_49;
        init_downloads_global_string_49 = String0_commonMainKt.init_downloads_global_string_49();
        return init_downloads_global_string_49;
    }

    public final StringResource getDownloads_global_string_49() {
        return (StringResource) downloads_global_string_49$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_5_delegate$lambda$0() {
        StringResource init_downloads_global_string_5;
        init_downloads_global_string_5 = String0_commonMainKt.init_downloads_global_string_5();
        return init_downloads_global_string_5;
    }

    public final StringResource getDownloads_global_string_5() {
        return (StringResource) downloads_global_string_5$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_50_delegate$lambda$0() {
        StringResource init_downloads_global_string_50;
        init_downloads_global_string_50 = String0_commonMainKt.init_downloads_global_string_50();
        return init_downloads_global_string_50;
    }

    public final StringResource getDownloads_global_string_50() {
        return (StringResource) downloads_global_string_50$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_51_delegate$lambda$0() {
        StringResource init_downloads_global_string_51;
        init_downloads_global_string_51 = String0_commonMainKt.init_downloads_global_string_51();
        return init_downloads_global_string_51;
    }

    public final StringResource getDownloads_global_string_51() {
        return (StringResource) downloads_global_string_51$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_52_delegate$lambda$0() {
        StringResource init_downloads_global_string_52;
        init_downloads_global_string_52 = String0_commonMainKt.init_downloads_global_string_52();
        return init_downloads_global_string_52;
    }

    public final StringResource getDownloads_global_string_52() {
        return (StringResource) downloads_global_string_52$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_53_delegate$lambda$0() {
        StringResource init_downloads_global_string_53;
        init_downloads_global_string_53 = String0_commonMainKt.init_downloads_global_string_53();
        return init_downloads_global_string_53;
    }

    public final StringResource getDownloads_global_string_53() {
        return (StringResource) downloads_global_string_53$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_54_delegate$lambda$0() {
        StringResource init_downloads_global_string_54;
        init_downloads_global_string_54 = String0_commonMainKt.init_downloads_global_string_54();
        return init_downloads_global_string_54;
    }

    public final StringResource getDownloads_global_string_54() {
        return (StringResource) downloads_global_string_54$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_55_delegate$lambda$0() {
        StringResource init_downloads_global_string_55;
        init_downloads_global_string_55 = String0_commonMainKt.init_downloads_global_string_55();
        return init_downloads_global_string_55;
    }

    public final StringResource getDownloads_global_string_55() {
        return (StringResource) downloads_global_string_55$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_56_delegate$lambda$0() {
        StringResource init_downloads_global_string_56;
        init_downloads_global_string_56 = String0_commonMainKt.init_downloads_global_string_56();
        return init_downloads_global_string_56;
    }

    public final StringResource getDownloads_global_string_56() {
        return (StringResource) downloads_global_string_56$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_57_delegate$lambda$0() {
        StringResource init_downloads_global_string_57;
        init_downloads_global_string_57 = String0_commonMainKt.init_downloads_global_string_57();
        return init_downloads_global_string_57;
    }

    public final StringResource getDownloads_global_string_57() {
        return (StringResource) downloads_global_string_57$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_58_delegate$lambda$0() {
        StringResource init_downloads_global_string_58;
        init_downloads_global_string_58 = String0_commonMainKt.init_downloads_global_string_58();
        return init_downloads_global_string_58;
    }

    public final StringResource getDownloads_global_string_58() {
        return (StringResource) downloads_global_string_58$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_59_delegate$lambda$0() {
        StringResource init_downloads_global_string_59;
        init_downloads_global_string_59 = String0_commonMainKt.init_downloads_global_string_59();
        return init_downloads_global_string_59;
    }

    public final StringResource getDownloads_global_string_59() {
        return (StringResource) downloads_global_string_59$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_6_delegate$lambda$0() {
        StringResource init_downloads_global_string_6;
        init_downloads_global_string_6 = String0_commonMainKt.init_downloads_global_string_6();
        return init_downloads_global_string_6;
    }

    public final StringResource getDownloads_global_string_6() {
        return (StringResource) downloads_global_string_6$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_60_delegate$lambda$0() {
        StringResource init_downloads_global_string_60;
        init_downloads_global_string_60 = String0_commonMainKt.init_downloads_global_string_60();
        return init_downloads_global_string_60;
    }

    public final StringResource getDownloads_global_string_60() {
        return (StringResource) downloads_global_string_60$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_61_delegate$lambda$0() {
        StringResource init_downloads_global_string_61;
        init_downloads_global_string_61 = String0_commonMainKt.init_downloads_global_string_61();
        return init_downloads_global_string_61;
    }

    public final StringResource getDownloads_global_string_61() {
        return (StringResource) downloads_global_string_61$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_62_delegate$lambda$0() {
        StringResource init_downloads_global_string_62;
        init_downloads_global_string_62 = String0_commonMainKt.init_downloads_global_string_62();
        return init_downloads_global_string_62;
    }

    public final StringResource getDownloads_global_string_62() {
        return (StringResource) downloads_global_string_62$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_63_delegate$lambda$0() {
        StringResource init_downloads_global_string_63;
        init_downloads_global_string_63 = String0_commonMainKt.init_downloads_global_string_63();
        return init_downloads_global_string_63;
    }

    public final StringResource getDownloads_global_string_63() {
        return (StringResource) downloads_global_string_63$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_64_delegate$lambda$0() {
        StringResource init_downloads_global_string_64;
        init_downloads_global_string_64 = String0_commonMainKt.init_downloads_global_string_64();
        return init_downloads_global_string_64;
    }

    public final StringResource getDownloads_global_string_64() {
        return (StringResource) downloads_global_string_64$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_65_delegate$lambda$0() {
        StringResource init_downloads_global_string_65;
        init_downloads_global_string_65 = String0_commonMainKt.init_downloads_global_string_65();
        return init_downloads_global_string_65;
    }

    public final StringResource getDownloads_global_string_65() {
        return (StringResource) downloads_global_string_65$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_66_delegate$lambda$0() {
        StringResource init_downloads_global_string_66;
        init_downloads_global_string_66 = String0_commonMainKt.init_downloads_global_string_66();
        return init_downloads_global_string_66;
    }

    public final StringResource getDownloads_global_string_66() {
        return (StringResource) downloads_global_string_66$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_67_delegate$lambda$0() {
        StringResource init_downloads_global_string_67;
        init_downloads_global_string_67 = String0_commonMainKt.init_downloads_global_string_67();
        return init_downloads_global_string_67;
    }

    public final StringResource getDownloads_global_string_67() {
        return (StringResource) downloads_global_string_67$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_68_delegate$lambda$0() {
        StringResource init_downloads_global_string_68;
        init_downloads_global_string_68 = String0_commonMainKt.init_downloads_global_string_68();
        return init_downloads_global_string_68;
    }

    public final StringResource getDownloads_global_string_68() {
        return (StringResource) downloads_global_string_68$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_69_delegate$lambda$0() {
        StringResource init_downloads_global_string_69;
        init_downloads_global_string_69 = String0_commonMainKt.init_downloads_global_string_69();
        return init_downloads_global_string_69;
    }

    public final StringResource getDownloads_global_string_69() {
        return (StringResource) downloads_global_string_69$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_7_delegate$lambda$0() {
        StringResource init_downloads_global_string_7;
        init_downloads_global_string_7 = String0_commonMainKt.init_downloads_global_string_7();
        return init_downloads_global_string_7;
    }

    public final StringResource getDownloads_global_string_7() {
        return (StringResource) downloads_global_string_7$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_70_delegate$lambda$0() {
        StringResource init_downloads_global_string_70;
        init_downloads_global_string_70 = String0_commonMainKt.init_downloads_global_string_70();
        return init_downloads_global_string_70;
    }

    public final StringResource getDownloads_global_string_70() {
        return (StringResource) downloads_global_string_70$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_71_delegate$lambda$0() {
        StringResource init_downloads_global_string_71;
        init_downloads_global_string_71 = String0_commonMainKt.init_downloads_global_string_71();
        return init_downloads_global_string_71;
    }

    public final StringResource getDownloads_global_string_71() {
        return (StringResource) downloads_global_string_71$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_72_delegate$lambda$0() {
        StringResource init_downloads_global_string_72;
        init_downloads_global_string_72 = String0_commonMainKt.init_downloads_global_string_72();
        return init_downloads_global_string_72;
    }

    public final StringResource getDownloads_global_string_72() {
        return (StringResource) downloads_global_string_72$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_73_delegate$lambda$0() {
        StringResource init_downloads_global_string_73;
        init_downloads_global_string_73 = String0_commonMainKt.init_downloads_global_string_73();
        return init_downloads_global_string_73;
    }

    public final StringResource getDownloads_global_string_73() {
        return (StringResource) downloads_global_string_73$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_74_delegate$lambda$0() {
        StringResource init_downloads_global_string_74;
        init_downloads_global_string_74 = String0_commonMainKt.init_downloads_global_string_74();
        return init_downloads_global_string_74;
    }

    public final StringResource getDownloads_global_string_74() {
        return (StringResource) downloads_global_string_74$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_75_delegate$lambda$0() {
        StringResource init_downloads_global_string_75;
        init_downloads_global_string_75 = String0_commonMainKt.init_downloads_global_string_75();
        return init_downloads_global_string_75;
    }

    public final StringResource getDownloads_global_string_75() {
        return (StringResource) downloads_global_string_75$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_76_delegate$lambda$0() {
        StringResource init_downloads_global_string_76;
        init_downloads_global_string_76 = String0_commonMainKt.init_downloads_global_string_76();
        return init_downloads_global_string_76;
    }

    public final StringResource getDownloads_global_string_76() {
        return (StringResource) downloads_global_string_76$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_77_delegate$lambda$0() {
        StringResource init_downloads_global_string_77;
        init_downloads_global_string_77 = String0_commonMainKt.init_downloads_global_string_77();
        return init_downloads_global_string_77;
    }

    public final StringResource getDownloads_global_string_77() {
        return (StringResource) downloads_global_string_77$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_78_delegate$lambda$0() {
        StringResource init_downloads_global_string_78;
        init_downloads_global_string_78 = String0_commonMainKt.init_downloads_global_string_78();
        return init_downloads_global_string_78;
    }

    public final StringResource getDownloads_global_string_78() {
        return (StringResource) downloads_global_string_78$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_79_delegate$lambda$0() {
        StringResource init_downloads_global_string_79;
        init_downloads_global_string_79 = String0_commonMainKt.init_downloads_global_string_79();
        return init_downloads_global_string_79;
    }

    public final StringResource getDownloads_global_string_79() {
        return (StringResource) downloads_global_string_79$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_8_delegate$lambda$0() {
        StringResource init_downloads_global_string_8;
        init_downloads_global_string_8 = String0_commonMainKt.init_downloads_global_string_8();
        return init_downloads_global_string_8;
    }

    public final StringResource getDownloads_global_string_8() {
        return (StringResource) downloads_global_string_8$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_80_delegate$lambda$0() {
        StringResource init_downloads_global_string_80;
        init_downloads_global_string_80 = String0_commonMainKt.init_downloads_global_string_80();
        return init_downloads_global_string_80;
    }

    public final StringResource getDownloads_global_string_80() {
        return (StringResource) downloads_global_string_80$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_81_delegate$lambda$0() {
        StringResource init_downloads_global_string_81;
        init_downloads_global_string_81 = String0_commonMainKt.init_downloads_global_string_81();
        return init_downloads_global_string_81;
    }

    public final StringResource getDownloads_global_string_81() {
        return (StringResource) downloads_global_string_81$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_82_delegate$lambda$0() {
        StringResource init_downloads_global_string_82;
        init_downloads_global_string_82 = String0_commonMainKt.init_downloads_global_string_82();
        return init_downloads_global_string_82;
    }

    public final StringResource getDownloads_global_string_82() {
        return (StringResource) downloads_global_string_82$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_83_delegate$lambda$0() {
        StringResource init_downloads_global_string_83;
        init_downloads_global_string_83 = String0_commonMainKt.init_downloads_global_string_83();
        return init_downloads_global_string_83;
    }

    public final StringResource getDownloads_global_string_83() {
        return (StringResource) downloads_global_string_83$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_84_delegate$lambda$0() {
        StringResource init_downloads_global_string_84;
        init_downloads_global_string_84 = String0_commonMainKt.init_downloads_global_string_84();
        return init_downloads_global_string_84;
    }

    public final StringResource getDownloads_global_string_84() {
        return (StringResource) downloads_global_string_84$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_85_delegate$lambda$0() {
        StringResource init_downloads_global_string_85;
        init_downloads_global_string_85 = String0_commonMainKt.init_downloads_global_string_85();
        return init_downloads_global_string_85;
    }

    public final StringResource getDownloads_global_string_85() {
        return (StringResource) downloads_global_string_85$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_86_delegate$lambda$0() {
        StringResource init_downloads_global_string_86;
        init_downloads_global_string_86 = String0_commonMainKt.init_downloads_global_string_86();
        return init_downloads_global_string_86;
    }

    public final StringResource getDownloads_global_string_86() {
        return (StringResource) downloads_global_string_86$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_87_delegate$lambda$0() {
        StringResource init_downloads_global_string_87;
        init_downloads_global_string_87 = String0_commonMainKt.init_downloads_global_string_87();
        return init_downloads_global_string_87;
    }

    public final StringResource getDownloads_global_string_87() {
        return (StringResource) downloads_global_string_87$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_88_delegate$lambda$0() {
        StringResource init_downloads_global_string_88;
        init_downloads_global_string_88 = String0_commonMainKt.init_downloads_global_string_88();
        return init_downloads_global_string_88;
    }

    public final StringResource getDownloads_global_string_88() {
        return (StringResource) downloads_global_string_88$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_89_delegate$lambda$0() {
        StringResource init_downloads_global_string_89;
        init_downloads_global_string_89 = String0_commonMainKt.init_downloads_global_string_89();
        return init_downloads_global_string_89;
    }

    public final StringResource getDownloads_global_string_89() {
        return (StringResource) downloads_global_string_89$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_9_delegate$lambda$0() {
        StringResource init_downloads_global_string_9;
        init_downloads_global_string_9 = String0_commonMainKt.init_downloads_global_string_9();
        return init_downloads_global_string_9;
    }

    public final StringResource getDownloads_global_string_9() {
        return (StringResource) downloads_global_string_9$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_90_delegate$lambda$0() {
        StringResource init_downloads_global_string_90;
        init_downloads_global_string_90 = String0_commonMainKt.init_downloads_global_string_90();
        return init_downloads_global_string_90;
    }

    public final StringResource getDownloads_global_string_90() {
        return (StringResource) downloads_global_string_90$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_91_delegate$lambda$0() {
        StringResource init_downloads_global_string_91;
        init_downloads_global_string_91 = String0_commonMainKt.init_downloads_global_string_91();
        return init_downloads_global_string_91;
    }

    public final StringResource getDownloads_global_string_91() {
        return (StringResource) downloads_global_string_91$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_92_delegate$lambda$0() {
        StringResource init_downloads_global_string_92;
        init_downloads_global_string_92 = String0_commonMainKt.init_downloads_global_string_92();
        return init_downloads_global_string_92;
    }

    public final StringResource getDownloads_global_string_92() {
        return (StringResource) downloads_global_string_92$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_93_delegate$lambda$0() {
        StringResource init_downloads_global_string_93;
        init_downloads_global_string_93 = String0_commonMainKt.init_downloads_global_string_93();
        return init_downloads_global_string_93;
    }

    public final StringResource getDownloads_global_string_93() {
        return (StringResource) downloads_global_string_93$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_94_delegate$lambda$0() {
        StringResource init_downloads_global_string_94;
        init_downloads_global_string_94 = String0_commonMainKt.init_downloads_global_string_94();
        return init_downloads_global_string_94;
    }

    public final StringResource getDownloads_global_string_94() {
        return (StringResource) downloads_global_string_94$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_95_delegate$lambda$0() {
        StringResource init_downloads_global_string_95;
        init_downloads_global_string_95 = String0_commonMainKt.init_downloads_global_string_95();
        return init_downloads_global_string_95;
    }

    public final StringResource getDownloads_global_string_95() {
        return (StringResource) downloads_global_string_95$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_96_delegate$lambda$0() {
        StringResource init_downloads_global_string_96;
        init_downloads_global_string_96 = String0_commonMainKt.init_downloads_global_string_96();
        return init_downloads_global_string_96;
    }

    public final StringResource getDownloads_global_string_96() {
        return (StringResource) downloads_global_string_96$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_97_delegate$lambda$0() {
        StringResource init_downloads_global_string_97;
        init_downloads_global_string_97 = String0_commonMainKt.init_downloads_global_string_97();
        return init_downloads_global_string_97;
    }

    public final StringResource getDownloads_global_string_97() {
        return (StringResource) downloads_global_string_97$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_98_delegate$lambda$0() {
        StringResource init_downloads_global_string_98;
        init_downloads_global_string_98 = String0_commonMainKt.init_downloads_global_string_98();
        return init_downloads_global_string_98;
    }

    public final StringResource getDownloads_global_string_98() {
        return (StringResource) downloads_global_string_98$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource downloads_global_string_99_delegate$lambda$0() {
        StringResource init_downloads_global_string_99;
        init_downloads_global_string_99 = String0_commonMainKt.init_downloads_global_string_99();
        return init_downloads_global_string_99;
    }

    public final StringResource getDownloads_global_string_99() {
        return (StringResource) downloads_global_string_99$delegate.getValue();
    }
}