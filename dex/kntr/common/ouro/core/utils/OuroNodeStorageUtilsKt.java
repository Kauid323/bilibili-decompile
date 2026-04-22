package kntr.common.ouro.core.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.NodeStorageBuilder;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.OuroNodeStorageKt;
import kntr.common.ouro.core.model.OuroPoint;
import kntr.common.ouro.core.model.OuroSelection;
import kntr.common.ouro.core.model.OuroSelectionKt;
import kntr.common.ouro.core.model.OuroTextRange;
import kntr.common.ouro.core.model.mark.OuroItalicMark;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroSemiBoldMark;
import kntr.common.ouro.core.model.mark.OuroStrikethroughMark;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.mark.OuroUnderlineMark;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.model.node.OuroH1;
import kntr.common.ouro.core.model.node.OuroH2;
import kntr.common.ouro.core.model.node.OuroH3;
import kntr.common.ouro.core.model.node.OuroLink;
import kntr.common.ouro.core.model.node.OuroList;
import kntr.common.ouro.core.model.node.OuroListItem;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroOrderedList;
import kntr.common.ouro.core.model.node.OuroParagraph;
import kntr.common.ouro.core.model.node.OuroParagraphChild;
import kntr.common.ouro.core.model.node.OuroQuoteBlock;
import kntr.common.ouro.core.model.node.OuroText;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.model.node.drawable.OuroInlineContent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* compiled from: OuroNodeStorageUtils.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0002\u001a(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0000\u001a2\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0010\b\u0000\u0010\r*\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f*\b\u0012\u0004\u0012\u0002H\r0\f2\u0006\u0010\n\u001a\u00020\tH\u0002\u001aQ\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\r0\u0011\"\u0010\b\u0000\u0010\r*\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f*\b\u0012\u0004\u0012\u0002H\r0\u00112\u0006\u0010\n\u001a\u00020\t2\u001d\u0010\u0012\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016H\u0000\u001a\u009c\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\r0\u0011\"\u0010\b\u0000\u0010\r*\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f*\b\u0012\u0004\u0012\u0002H\r0\u00112\u0006\u0010\u0017\u001a\u00020\u001824\u0010\u0019\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u001aj\u0002`!¢\u0006\u0002\b\u001622\u0010\u0012\u001a.\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0014\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00150\u001a¢\u0006\u0002\b\u0016H\u0000\u001ab\u0010\"\u001a\u00020\t\"\u0010\b\u0000\u0010\r*\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f*\b\u0012\u0004\u0012\u0002H\r0\u001b2\u0006\u0010\u0017\u001a\u00020\u001824\u0010\u0019\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u001aj\u0002`!¢\u0006\u0002\b\u0016H\u0000\u001af\u0010#\u001a\u0002H$\"\u0004\b\u0000\u0010$\"\u0010\b\u0001\u0010\r*\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f*\b\u0012\u0004\u0012\u0002H\r0\u001b2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010%\u001a\u0002H$2'\u0010&\u001a#\u0012\u0013\u0012\u0011H$¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H$0\u001a¢\u0006\u0002\u0010(\u001a\u0018\u0010)\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010*\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\n\u001a\u00020\tH\u0000\u001a\u001a\u0010+\u001a\u0004\u0018\u00010,*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a \u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0004*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010.\u001a\u00020,H\u0000\u001a\u001a\u0010/\u001a\u0004\u0018\u000100*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001a\u00101\u001a\u0004\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u00102\u001a\u00020\u001c*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a,\u00103\u001a\u0004\u0018\u0001H4\"\n\b\u0000\u00104\u0018\u0001*\u00020\u001c*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0082\b¢\u0006\u0002\u00105\u001a*\u00106\u001a\u0002H4\"\n\b\u0000\u00104\u0018\u0001*\u00020\u001c*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0082\b¢\u0006\u0002\u00105\u001a,\u00107\u001a\u0004\u0018\u0001H4\"\n\b\u0000\u00104\u0018\u0001*\u00020\u001c*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0082\b¢\u0006\u0002\u00105\u001a*\u00108\u001a\u0002H4\"\n\b\u0000\u00104\u0018\u0001*\u00020\u001c*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0082\b¢\u0006\u0002\u00105\u001a,\u00109\u001a\u0004\u0018\u0001H4\"\n\b\u0000\u00104\u0018\u0001*\u00020\u001c*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0080\b¢\u0006\u0002\u00105\u001a*\u0010:\u001a\u0002H4\"\n\b\u0000\u00104\u0018\u0001*\u00020\u001c*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0080\b¢\u0006\u0002\u00105\u001a,\u0010;\u001a\u0004\u0018\u0001H4\"\n\b\u0000\u00104\u0018\u0001*\u00020\u001c*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0080\b¢\u0006\u0002\u00105\u001a*\u0010<\u001a\u0002H4\"\n\b\u0000\u00104\u0018\u0001*\u00020\u001c*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0080\b¢\u0006\u0002\u00105\u001a\u001e\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0004*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\n\u001a\u00020\tH\u0000\u001a\"\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u0006\u0012\u0002\b\u00030\u001b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0000\u001a\u001e\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u001f\u001a\u00020\u0005H\u0000\u001a \u0010@\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010A*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a*\u0010C\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010A*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010D\u001a\u00020\u0007H\u0000\u001a\u0018\u0010E\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010F\u001a\u00020\u0015*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010G\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010H\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\n\u001a\u00020\tH\u0000\u001a\u0018\u0010I\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0018\u0010J\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010K\u001a\u00020\u0015*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010L\u001a\u00020\u0015*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001a\u0010M\u001a\u0004\u0018\u00010,*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010N\u001a\u00020\u0015*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010O\u001a\u00020,H\u0000\u001a\u0018\u0010P\u001a\u00020\u0015*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010O\u001a\u00020,H\u0000\u001a^\u0010Q\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\f2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\n\u001a\u00020\t24\u0010\u0019\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u001aj\u0002`!¢\u0006\u0002\b\u0016H\u0000\u001a\u001a\u0010S\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u001a\u0010T\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u0018\u0010U\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010V\u001a\u00020\u0015*\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a \u0010W\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u0005H\u0000\u001a$\u0010W\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\f2\n\u0010Y\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010X\u001a\u00020\u0005H\u0000\u001a \u0010Z\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u0005H\u0000\u001a$\u0010Z\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\f2\n\u0010Y\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010X\u001a\u00020\u0005H\u0000\u001a\"\u0010[\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010\u0014*\b\u0012\u0004\u0012\u00020\\0\u00112\u0006\u0010\n\u001a\u00020\tH\u0000\u001a\u0012\u0010]\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\\0\fH\u0000\u001a\f\u0010^\u001a\u00020\u0007*\u00020\u0005H\u0002\u001a4\u0010_\u001a\u00020\u0015\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u0005*\b\u0012\u0004\u0012\u00020\\0\f2\u0006\u0010`\u001a\u0002H\r2\u0006\u0010X\u001a\u0002H\rH\u0080\b¢\u0006\u0002\u0010a\u001a\"\u0010b\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\\0\u001b2\u0006\u0010c\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a(\u0010d\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\\0\u001b2\u0006\u0010\u001f\u001a\u00020\u00052\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\\0\u0014H\u0002\u001a(\u0010f\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\\0\u001b2\u0006\u0010\u001f\u001a\u00020\u00052\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\\0\u0014H\u0002\u001a3\u0010g\u001a\b\u0012\u0004\u0012\u0002Hh0\u0004\"\n\b\u0000\u0010h\u0018\u0001*\u00020\u0005*\u0006\u0012\u0002\b\u00030\u001b2\u000e\u0010i\u001a\n\u0012\u0002\b\u00030\u000ej\u0002`\u000fH\u0080\b\u001a&\u0010j\u001a\u00020\u0015*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u001f\u001a\u00020\u00052\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00050lH\u0000\u001aP\u0010m\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010c\u001a\u00020\u001c24\u0010\u0019\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u001aj\u0002`!¢\u0006\u0002\b\u0016H\u0000\u001aP\u0010n\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010c\u001a\u00020\u001c24\u0010\u0019\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u001aj\u0002`!¢\u0006\u0002\b\u0016H\u0000¨\u0006o"}, d2 = {"constrainPoint", "Lkntr/common/ouro/core/model/OuroPoint;", "point", "allSelectables", "", "Lkntr/common/ouro/core/model/node/OuroNode;", "preferNext", "", "constrainSelection", "Lkntr/common/ouro/core/model/OuroSelection;", "selection", "separate", "Lkntr/common/ouro/core/model/OuroNodeMutableStorage;", "T", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/OuroParent;", "mutate", "Lkntr/common/ouro/core/model/NodeStorage;", "fn", "Lkotlin/Function1;", "Lkntr/common/ouro/core/model/NodeStorageBuilder;", "", "Lkotlin/ExtensionFunctionType;", "textRange", "Lkntr/common/ouro/core/model/OuroTextRange;", "displayLengthTransform", "Lkotlin/Function2;", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "Lkotlin/ParameterName;", "name", "node", "", "Lkntr/common/ouro/core/model/DisplayLengthTransform;", "getConstrainSelection", "reduce", "S", "initial", "operation", "acc", "(Lkntr/common/ouro/core/model/OuroNodeStorage;Lkntr/common/ouro/core/model/node/OuroNode;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "isInBlockQuote", "isQuoteStart", "getParentListItemOrNull", "Lkntr/common/ouro/core/model/node/OuroListItem;", "getChildrenListItemsOrNull", "item", "getParentListOrNull", "Lkntr/common/ouro/core/model/node/OuroList;", "getSelectableOrNull", "getSelectable", "getLastSelectableBeforeOrNull", "Selectable", "(Lkntr/common/ouro/core/model/OuroNodeStorage;Lkntr/common/ouro/core/model/OuroPoint;)Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "getLastSelectableBefore", "getFirstSelectableAfterOrNull", "getFirstSelectableAfter", "getPreviousSelectableOrNull", "getPreviousSelectable", "getNextSelectableOrNull", "getNextSelectable", "getSelectables", "getLeavesInSelection", "getLeavesOfNode", "getTextMarksAtPoint", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "getResolvedTextMarks", "forDisplayPanel", "willLeaveQuote", "leaveQuote", "willLeaveList", "willGetIntoList", "isInList", "isHeadingParagraphEnd", "leaveHeading", "outdentList", "currentListItem", "outdentListItem", "listItem", "indentListItem", "getIntoQuoteIfNeeded", "selectables", "isEmpty", "isBlank", "isInOuroList", "splitListItemAt", "insertAfter", "target", "storage", "insertBefore", "subdocument", "Lkntr/common/ouro/core/model/node/OuroDocument;", "deleteSingleStructurePath", "isStructureNode", "replace", "source", "(Lkntr/common/ouro/core/model/OuroNodeMutableStorage;Lkntr/common/ouro/core/model/node/OuroNode;Lkntr/common/ouro/core/model/node/OuroNode;)V", "selectableContainsPoint", "selectable", "addPathToRoot", "toDocument", "addAllDescendants", "collectNodeInParentWithDFS", "N", "parent", "collectNodes", "nodeList", "", "getTextRangeAfter", "getTextRangeBefore", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroNodeStorageUtilsKt {
    static /* synthetic */ OuroPoint constrainPoint$default(OuroPoint ouroPoint, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return constrainPoint(ouroPoint, list, z);
    }

    private static final OuroPoint constrainPoint(OuroPoint point, List<? extends OuroNode> list, boolean preferNext) {
        OuroNode insideNode;
        List processedAllSelectables = CollectionsKt.dropLast(list, CollectionsKt.lastOrNull(list) instanceof OuroTextElement.HardBreak ? 1 : 0);
        if (!point.isInside()) {
            int constrainIndex = RangesKt.coerceIn(point.getIndex(), 0, processedAllSelectables.size());
            if (constrainIndex != point.getIndex()) {
                return OuroPoint.copy$default(point, constrainIndex, 0, 2, null);
            }
            return point;
        }
        if (point.isInside()) {
            insideNode = (OuroNode) CollectionsKt.getOrNull(processedAllSelectables, point.getIndex());
        } else {
            insideNode = null;
        }
        if (OuroNodeUtilsKt.isSeparable(insideNode)) {
            int constrainOffset = RangesKt.coerceIn(point.getOffset(), 0, ((OuroNode.Separable) insideNode).getLength());
            if (constrainOffset != point.getOffset()) {
                return OuroPoint.copy$default(point, 0, constrainOffset, 1, null);
            }
            return point;
        } else if (preferNext) {
            int constrainIndex2 = RangesKt.coerceIn(point.getIndex() + 1, 0, processedAllSelectables.size());
            if (constrainIndex2 != point.getIndex()) {
                return point.copy(constrainIndex2, 0);
            }
            return OuroPoint.copy$default(point, 0, 0, 1, null);
        } else {
            int constrainIndex3 = RangesKt.coerceIn(point.getIndex(), 0, processedAllSelectables.size());
            if (constrainIndex3 != point.getIndex()) {
                return point.copy(constrainIndex3, 0);
            }
            return OuroPoint.copy$default(point, 0, 0, 1, null);
        }
    }

    public static /* synthetic */ OuroSelection constrainSelection$default(OuroSelection ouroSelection, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return constrainSelection(ouroSelection, list, z);
    }

    public static final OuroSelection constrainSelection(OuroSelection selection, List<? extends OuroNode> list, boolean preferNext) {
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(list, "allSelectables");
        if (selection.isCollapsed()) {
            OuroPoint point = constrainPoint(selection.getAnchor(), list, preferNext);
            if (Intrinsics.areEqual(selection.getAnchor(), point)) {
                return selection;
            }
            return new OuroSelection(point);
        }
        OuroPoint newAnchor = constrainPoint(selection.getAnchor(), list, selection.isBackward());
        OuroPoint newFocus = constrainPoint(selection.getFocus(), list, selection.isForward());
        if (Intrinsics.areEqual(newAnchor, selection.getAnchor()) && Intrinsics.areEqual(newFocus, selection.getFocus())) {
            return selection;
        }
        return new OuroSelection(newAnchor, newFocus);
    }

    private static final <T extends OuroNode.Parent<?>> OuroNodeMutableStorage<T> separate(OuroNodeMutableStorage<T> ouroNodeMutableStorage, OuroSelection selection) {
        if (selection.isCollapsed()) {
            OuroNode.Selectable selectedElement = getSelectableOrNull(ouroNodeMutableStorage, selection.getAnchor());
            if (OuroNodeUtilsKt.isSeparable(selectedElement)) {
                List replacement = ((OuroNode.Separable) selectedElement).separate(selection.getAnchor().getOffset());
                ouroNodeMutableStorage.replace((OuroNodeMutableStorage<T>) selectedElement, (Collection<? extends OuroNodeMutableStorage<T>>) replacement);
            }
            return ouroNodeMutableStorage;
        }
        OuroNode.Selectable startElement = getSelectableOrNull(ouroNodeMutableStorage, selection.getStart());
        OuroNode.Selectable endElement = getSelectableOrNull(ouroNodeMutableStorage, selection.getEnd());
        if (!OuroNodeUtilsKt.isSeparable(startElement) && !OuroNodeUtilsKt.isSeparable(endElement)) {
            return ouroNodeMutableStorage;
        }
        if (startElement == endElement) {
            if (OuroNodeUtilsKt.isSeparable(startElement)) {
                List replacement2 = ((OuroNode.Separable) startElement).separate(selection.getStart().getOffset(), selection.getEnd().getOffset());
                ouroNodeMutableStorage.replace((OuroNodeMutableStorage<T>) startElement, (Collection<? extends OuroNodeMutableStorage<T>>) replacement2);
            }
            return ouroNodeMutableStorage;
        }
        if (OuroNodeUtilsKt.isSeparable(startElement)) {
            List replacement3 = ((OuroNode.Separable) startElement).separate(selection.getStart().getOffset());
            ouroNodeMutableStorage.replace((OuroNodeMutableStorage<T>) startElement, (Collection<? extends OuroNodeMutableStorage<T>>) replacement3);
        }
        if (OuroNodeUtilsKt.isSeparable(endElement)) {
            List replacement4 = ((OuroNode.Separable) endElement).separate(selection.getEnd().getOffset());
            ouroNodeMutableStorage.replace((OuroNodeMutableStorage<T>) endElement, (Collection<? extends OuroNodeMutableStorage<T>>) replacement4);
        }
        return ouroNodeMutableStorage;
    }

    public static final <T extends OuroNode.Parent<?>> NodeStorage<T> mutate(NodeStorage<T> nodeStorage, final OuroSelection selection, final Function1<? super NodeStorageBuilder<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(function1, "fn");
        return NodeStorage.mutate$core_debug$default(nodeStorage, false, new Function1() { // from class: kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit mutate$lambda$0;
                mutate$lambda$0 = OuroNodeStorageUtilsKt.mutate$lambda$0(OuroSelection.this, function1, (NodeStorageBuilder) obj);
                return mutate$lambda$0;
            }
        }, 1, null);
    }

    public static final Unit mutate$lambda$0(OuroSelection $selection, Function1 $fn, NodeStorageBuilder $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        separate($this$mutate, $selection);
        $fn.invoke($this$mutate);
        return Unit.INSTANCE;
    }

    public static final <T extends OuroNode.Parent<?>> NodeStorage<T> mutate(NodeStorage<T> nodeStorage, final OuroTextRange textRange, final Function2<? super OuroNodeStorage<?>, ? super OuroNode.Selectable, Integer> function2, final Function2<? super NodeStorageBuilder<T>, ? super OuroSelection, Unit> function22) {
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(textRange, "textRange");
        Intrinsics.checkNotNullParameter(function2, "displayLengthTransform");
        Intrinsics.checkNotNullParameter(function22, "fn");
        return NodeStorage.mutate$core_debug$default(nodeStorage, false, new Function1() { // from class: kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit mutate$lambda$1;
                mutate$lambda$1 = OuroNodeStorageUtilsKt.mutate$lambda$1(OuroTextRange.this, function2, function22, (NodeStorageBuilder) obj);
                return mutate$lambda$1;
            }
        }, 1, null);
    }

    public static final Unit mutate$lambda$1(OuroTextRange $textRange, Function2 $displayLengthTransform, Function2 $fn, NodeStorageBuilder $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        separate($this$mutate, OuroSelectionKt.getSelection($this$mutate, $textRange, $displayLengthTransform));
        $fn.invoke($this$mutate, getConstrainSelection($this$mutate, $textRange, $displayLengthTransform));
        return Unit.INSTANCE;
    }

    public static final <T extends OuroNode.Parent<?>> OuroSelection getConstrainSelection(OuroNodeStorage<T> ouroNodeStorage, OuroTextRange textRange, Function2<? super OuroNodeStorage<?>, ? super OuroNode.Selectable, Integer> function2) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(textRange, "textRange");
        Intrinsics.checkNotNullParameter(function2, "displayLengthTransform");
        return constrainSelection$default(OuroSelectionKt.getSelection(ouroNodeStorage, textRange, function2), ouroNodeStorage.getAllSelectables(), false, 4, null);
    }

    public static final <S, T extends OuroNode.Parent<?>> S reduce(OuroNodeStorage<T> ouroNodeStorage, OuroNode node, S s, Function2<? super S, ? super OuroNode, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(function2, "operation");
        S s2 = (S) function2.invoke(s, node);
        OuroNode.Parent parent = ouroNodeStorage.getParent(node);
        return parent == null ? s2 : (S) reduce(ouroNodeStorage, parent, s2, function2);
    }

    public static final boolean isInBlockQuote(OuroNodeStorage<?> ouroNodeStorage, OuroPoint point) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        Object selectableOrNull = getSelectableOrNull(ouroNodeStorage, point);
        if (selectableOrNull == null) {
            int nextIndex$iv = point.isInside() ? point.getIndex() + 1 : point.getIndex();
            if (nextIndex$iv < ouroNodeStorage.getAllSelectables().size()) {
                Object orNull = CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), nextIndex$iv);
                r6 = (OuroNode.Selectable) (orNull instanceof OuroNode.Selectable ? orNull : null);
            }
            selectableOrNull = r6;
        }
        OuroNode current = (OuroNode) selectableOrNull;
        while (current != null) {
            if (current instanceof OuroQuoteBlock) {
                return true;
            }
            current = ouroNodeStorage.getParent(current);
        }
        return false;
    }

    public static final boolean isQuoteStart(OuroNodeStorage<?> ouroNodeStorage, OuroSelection selection) {
        Integer indexInSiblings;
        Integer indexInSiblings2;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(selection, "selection");
        if (!selection.isCollapsed() || selection.getStart().isInside()) {
            return false;
        }
        OuroPoint point = selection.getStart();
        OuroParagraph it = (OuroParagraph) CollectionsKt.firstOrNull(OuroNodeStorageKt.getSelectedParagraphs$default(ouroNodeStorage, selection, false, false, 6, null));
        if (it == null || (indexInSiblings = ouroNodeStorage.getIndexInSiblings(it)) == null || indexInSiblings.intValue() != 0) {
            return false;
        }
        Object selectableOrNull = getSelectableOrNull(ouroNodeStorage, point);
        if (selectableOrNull == null) {
            int nextIndex$iv = point.isInside() ? point.getIndex() + 1 : point.getIndex();
            if (nextIndex$iv < ouroNodeStorage.getAllSelectables().size()) {
                Object orNull = CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), nextIndex$iv);
                r10 = (OuroNode.Selectable) (orNull instanceof OuroNode.Selectable ? orNull : null);
            }
            selectableOrNull = r10;
        }
        if ((selectableOrNull == null || (indexInSiblings2 = ouroNodeStorage.getIndexInSiblings((OuroNode) selectableOrNull)) == null || indexInSiblings2.intValue() != 0) ? false : true) {
            OuroNode current = (OuroNode) selectableOrNull;
            while (current != null) {
                if (current instanceof OuroQuoteBlock) {
                    return true;
                }
                current = ouroNodeStorage.getParent(current);
            }
            return false;
        }
        return false;
    }

    public static final OuroListItem getParentListItemOrNull(OuroNodeStorage<?> ouroNodeStorage, OuroPoint point) {
        OuroNode ouroNode;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        OuroNode element = getSelectableOrNull(ouroNodeStorage, point);
        if (element == null) {
            int nextIndex$iv = point.isInside() ? point.getIndex() + 1 : point.getIndex();
            if (nextIndex$iv < ouroNodeStorage.getAllSelectables().size()) {
                Object orNull = CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), nextIndex$iv);
                if (!(orNull instanceof OuroNode.Selectable)) {
                    orNull = null;
                }
                ouroNode = (OuroNode.Selectable) orNull;
            } else {
                ouroNode = null;
            }
            if (ouroNode == null) {
                return null;
            }
            element = ouroNode;
        }
        OuroNode node$iv = element;
        OuroNode.Parent<?> firstAncestorOrNull = ouroNodeStorage.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt$getParentListItemOrNull$$inlined$findFirstAncestorOrNull$1
            public final Boolean invoke(OuroNode.Parent<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "it");
                return Boolean.valueOf(parent instanceof OuroListItem);
            }
        });
        return firstAncestorOrNull instanceof OuroListItem ? firstAncestorOrNull : null;
    }

    public static final List<OuroListItem> getChildrenListItemsOrNull(OuroNodeStorage<?> ouroNodeStorage, OuroListItem item) {
        Object element$iv;
        Iterable children;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Iterable children2 = ouroNodeStorage.getChildren(item);
        if (children2 != null) {
            Iterable $this$firstOrNull$iv = children2;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    OuroNode it2 = (OuroNode) element$iv;
                    if (it2 instanceof OuroList) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            OuroNode list = (OuroNode) element$iv;
            if (list == null || (children = ouroNodeStorage.getChildren((OuroList) list)) == null) {
                return null;
            }
            Iterable $this$filterIsInstance$iv = children;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterIsInstance$iv) {
                if (element$iv$iv instanceof OuroListItem) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            return (List) destination$iv$iv;
        }
        return null;
    }

    public static final OuroList getParentListOrNull(OuroNodeStorage<?> ouroNodeStorage, OuroPoint point) {
        OuroNode ouroNode;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        OuroNode element = getSelectableOrNull(ouroNodeStorage, point);
        if (element == null) {
            int nextIndex$iv = point.isInside() ? point.getIndex() + 1 : point.getIndex();
            if (nextIndex$iv < ouroNodeStorage.getAllSelectables().size()) {
                Object orNull = CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), nextIndex$iv);
                if (!(orNull instanceof OuroNode.Selectable)) {
                    orNull = null;
                }
                ouroNode = (OuroNode.Selectable) orNull;
            } else {
                ouroNode = null;
            }
            if (ouroNode == null) {
                return null;
            }
            element = ouroNode;
        }
        OuroNode node$iv = element;
        OuroNode.Parent<?> firstAncestorOrNull = ouroNodeStorage.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt$getParentListOrNull$$inlined$findFirstAncestorOrNull$1
            public final Boolean invoke(OuroNode.Parent<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "it");
                return Boolean.valueOf(parent instanceof OuroList);
            }
        });
        return firstAncestorOrNull instanceof OuroList ? firstAncestorOrNull : null;
    }

    public static final OuroNode.Selectable getSelectableOrNull(OuroNodeStorage<?> ouroNodeStorage, OuroPoint point) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        if (point.isInside()) {
            return (OuroNode.Selectable) CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), point.getIndex());
        }
        return null;
    }

    public static final OuroNode.Selectable getSelectable(OuroNodeStorage<?> ouroNodeStorage, OuroPoint point) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        OuroNode.Selectable selectableOrNull = getSelectableOrNull(ouroNodeStorage, point);
        if (selectableOrNull != null) {
            return selectableOrNull;
        }
        throw new IllegalArgumentException("OuroNode.Selectable not found for point: " + point);
    }

    private static final /* synthetic */ <Selectable extends OuroNode.Selectable> Selectable getLastSelectableBeforeOrNull(OuroNodeStorage<?> ouroNodeStorage, OuroPoint point) {
        int i = point.getIndex();
        while (true) {
            i--;
            if (-1 < i) {
                Selectable selectable = (Selectable) CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), i);
                Intrinsics.reifiedOperationMarker(3, "Selectable");
                if (selectable instanceof OuroNode.Selectable) {
                    return selectable;
                }
            } else {
                return null;
            }
        }
    }

    private static final /* synthetic */ <Selectable extends OuroNode.Selectable> Selectable getLastSelectableBefore(OuroNodeStorage<?> ouroNodeStorage, OuroPoint point) {
        Selectable selectable;
        int i$iv = point.getIndex();
        while (true) {
            i$iv--;
            if (-1 < i$iv) {
                selectable = (Selectable) CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), i$iv);
                Intrinsics.reifiedOperationMarker(3, "Selectable");
                if (selectable instanceof OuroNode.Selectable) {
                    break;
                }
            } else {
                selectable = null;
                break;
            }
        }
        if (selectable != null) {
            return selectable;
        }
        Intrinsics.reifiedOperationMarker(4, "Selectable");
        throw new IllegalArgumentException("OuroNode of type " + Reflection.getOrCreateKotlinClass(OuroNode.Selectable.class) + " not found before point: " + point);
    }

    private static final /* synthetic */ <Selectable extends OuroNode.Selectable> Selectable getFirstSelectableAfterOrNull(OuroNodeStorage<?> ouroNodeStorage, OuroPoint point) {
        int size = ouroNodeStorage.getAllSelectables().size();
        for (int i = point.getIndex(); i < size; i++) {
            Selectable selectable = (Selectable) CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), i);
            Intrinsics.reifiedOperationMarker(3, "Selectable");
            if (selectable instanceof OuroNode.Selectable) {
                return selectable;
            }
        }
        return null;
    }

    private static final /* synthetic */ <Selectable extends OuroNode.Selectable> Selectable getFirstSelectableAfter(OuroNodeStorage<?> ouroNodeStorage, OuroPoint point) {
        Selectable selectable;
        int i$iv = point.getIndex();
        int size = ouroNodeStorage.getAllSelectables().size();
        while (true) {
            if (i$iv < size) {
                selectable = (Selectable) CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), i$iv);
                Intrinsics.reifiedOperationMarker(3, "Selectable");
                if (selectable instanceof OuroNode.Selectable) {
                    break;
                }
                i$iv++;
            } else {
                selectable = null;
                break;
            }
        }
        if (selectable != null) {
            return selectable;
        }
        Intrinsics.reifiedOperationMarker(4, "Selectable");
        throw new IllegalArgumentException("OuroNode of type " + Reflection.getOrCreateKotlinClass(OuroNode.Selectable.class) + " not found after point: " + point);
    }

    public static final /* synthetic */ <Selectable extends OuroNode.Selectable> Selectable getPreviousSelectableOrNull(OuroNodeStorage<?> ouroNodeStorage, OuroPoint point) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        int prevIndex = point.getIndex() - 1;
        if (prevIndex >= 0) {
            Object orNull = CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), prevIndex);
            Intrinsics.reifiedOperationMarker(2, "Selectable");
            return (Selectable) orNull;
        }
        return null;
    }

    public static final /* synthetic */ <Selectable extends OuroNode.Selectable> Selectable getPreviousSelectable(OuroNodeStorage<?> ouroNodeStorage, OuroPoint point) {
        Selectable selectable;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        int prevIndex$iv = point.getIndex() - 1;
        if (prevIndex$iv >= 0) {
            Object orNull = CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), prevIndex$iv);
            Intrinsics.reifiedOperationMarker(2, "Selectable");
            selectable = (Selectable) orNull;
        } else {
            selectable = null;
        }
        if (selectable != null) {
            return selectable;
        }
        Intrinsics.reifiedOperationMarker(4, "Selectable");
        throw new IllegalArgumentException("previous " + Reflection.getOrCreateKotlinClass(OuroNode.Selectable.class) + " not found before point " + point);
    }

    public static final /* synthetic */ <Selectable extends OuroNode.Selectable> Selectable getNextSelectableOrNull(OuroNodeStorage<?> ouroNodeStorage, OuroPoint point) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        int nextIndex = point.isInside() ? point.getIndex() + 1 : point.getIndex();
        if (nextIndex < ouroNodeStorage.getAllSelectables().size()) {
            Object orNull = CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), nextIndex);
            Intrinsics.reifiedOperationMarker(2, "Selectable");
            return (Selectable) orNull;
        }
        return null;
    }

    public static final /* synthetic */ <Selectable extends OuroNode.Selectable> Selectable getNextSelectable(OuroNodeStorage<?> ouroNodeStorage, OuroPoint point) {
        Selectable selectable;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        int nextIndex$iv = point.isInside() ? point.getIndex() + 1 : point.getIndex();
        if (nextIndex$iv < ouroNodeStorage.getAllSelectables().size()) {
            Object orNull = CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), nextIndex$iv);
            Intrinsics.reifiedOperationMarker(2, "Selectable");
            selectable = (Selectable) orNull;
        } else {
            selectable = null;
        }
        if (selectable != null) {
            return selectable;
        }
        Intrinsics.reifiedOperationMarker(4, "Selectable");
        throw new IllegalArgumentException("next " + Reflection.getOrCreateKotlinClass(OuroNode.Selectable.class) + " not found after point " + point + "\"");
    }

    public static final List<OuroNode.Selectable> getSelectables(OuroNodeStorage<?> ouroNodeStorage, OuroSelection selection) {
        int index;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(selection, "selection");
        if (selection.isCollapsed()) {
            return CollectionsKt.emptyList();
        }
        List<OuroNode.Selectable> allSelectables = ouroNodeStorage.getAllSelectables();
        int coerceIn = RangesKt.coerceIn(selection.getStart().getIndex(), 0, ouroNodeStorage.getAllSelectables().size());
        if (selection.getEnd().isInside()) {
            index = selection.getEnd().getIndex() + 1;
        } else {
            index = selection.getEnd().getIndex();
        }
        return allSelectables.subList(coerceIn, RangesKt.coerceIn(index, 0, ouroNodeStorage.getAllSelectables().size()));
    }

    public static /* synthetic */ List getLeavesInSelection$default(OuroNodeStorage ouroNodeStorage, OuroSelection ouroSelection, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroSelection = null;
        }
        return getLeavesInSelection(ouroNodeStorage, ouroSelection);
    }

    public static final List<OuroNode> getLeavesInSelection(OuroNodeStorage<?> ouroNodeStorage, OuroSelection selection) {
        Iterable selectables;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        if (selection == null) {
            selectables = ouroNodeStorage.getAllSelectables();
        } else {
            selectables = getSelectables(ouroNodeStorage, selection);
        }
        List result = new ArrayList();
        Iterable $this$fold$iv = selectables;
        for (Object element$iv : $this$fold$iv) {
            OuroNode.Selectable node = (OuroNode.Selectable) element$iv;
            result.addAll(getLeavesOfNode(ouroNodeStorage, node));
        }
        return CollectionsKt.toList(result);
    }

    public static final List<OuroNode> getLeavesOfNode(OuroNodeStorage<?> ouroNodeStorage, OuroNode node) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        List result = new ArrayList();
        if (node instanceof OuroNode.Parent) {
            Iterable children = ouroNodeStorage.getChildren((OuroNode.Parent) node);
            if (children != null) {
                Iterable $this$forEach$iv = children;
                for (Object element$iv : $this$forEach$iv) {
                    OuroNode child = (OuroNode) element$iv;
                    if (child instanceof OuroNode.Parent) {
                        result.addAll(getLeavesOfNode(ouroNodeStorage, child));
                    } else {
                        result.add(child);
                    }
                }
            }
        } else {
            result.add(node);
        }
        return CollectionsKt.toList(result);
    }

    public static final OuroMarks<OuroTextMark> getTextMarksAtPoint(OuroNodeStorage<?> ouroNodeStorage, OuroPoint point) {
        OuroNode.Selectable selectable$iv;
        OuroNode.Selectable selectable$iv2;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        OuroNode.Selectable selectableOrNull = getSelectableOrNull(ouroNodeStorage, point);
        OuroTextElement current = selectableOrNull instanceof OuroTextElement ? (OuroTextElement) selectableOrNull : null;
        if (current != null) {
            return current.getMarks();
        }
        int i$iv = point.getIndex();
        while (true) {
            i$iv--;
            if (-1 < i$iv) {
                selectable$iv = (OuroNode.Selectable) CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), i$iv);
                if (selectable$iv instanceof OuroTextElement) {
                    break;
                }
            } else {
                selectable$iv = null;
                break;
            }
        }
        OuroTextElement before = (OuroTextElement) selectable$iv;
        int i$iv2 = point.getIndex();
        int size = ouroNodeStorage.getAllSelectables().size();
        while (true) {
            if (i$iv2 < size) {
                selectable$iv2 = (OuroNode.Selectable) CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), i$iv2);
                if (selectable$iv2 instanceof OuroTextElement) {
                    break;
                }
                i$iv2++;
            } else {
                selectable$iv2 = null;
                break;
            }
        }
        OuroTextElement after = (OuroTextElement) selectable$iv2;
        if (before == null && after == null) {
            return MarkConflictResolver.INSTANCE.applyDefaults(OuroMarks.Empty.INSTANCE.getTextMarks());
        }
        if (before == null || after != null) {
            if (before != null || after == null) {
                if (!(before instanceof OuroTextElement.HardBreak) || after == null) {
                    if (before != null) {
                        return before.getMarks();
                    }
                    return null;
                }
                return after.getMarks();
            }
            return after.getMarks();
        }
        return before.getMarks();
    }

    public static /* synthetic */ OuroMarks getResolvedTextMarks$default(OuroNodeStorage ouroNodeStorage, OuroSelection ouroSelection, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return getResolvedTextMarks(ouroNodeStorage, ouroSelection, z);
    }

    public static final OuroMarks<OuroTextMark> getResolvedTextMarks(OuroNodeStorage<?> ouroNodeStorage, OuroSelection selection, boolean forDisplayPanel) {
        OuroMarks allMarks;
        Iterable destination$iv$iv;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(selection, "selection");
        if (selection.isCollapsed() || !forDisplayPanel) {
            return getTextMarksAtPoint(ouroNodeStorage, selection.getStart());
        }
        OuroMarks list$iv$iv = new OuroMarks(CollectionsKt.listOf(new OuroMark[]{OuroUnderlineMark.INSTANCE, OuroSemiBoldMark.INSTANCE, OuroStrikethroughMark.INSTANCE, OuroItalicMark.INSTANCE}));
        Iterable<OuroNode.Selectable> $this$flatMap$iv = getSelectables(ouroNodeStorage, selection);
        Collection destination$iv$iv2 = new ArrayList();
        for (OuroNode.Selectable node : $this$flatMap$iv) {
            if (node instanceof OuroTextElement.Plain) {
                destination$iv$iv = CollectionsKt.listOf(((OuroTextElement.Plain) node).getMarks());
                allMarks = list$iv$iv;
            } else if (node instanceof OuroLink) {
                Iterable $this$filterIsInstance$iv = ouroNodeStorage.getChildren((OuroNode.Parent) node);
                if ($this$filterIsInstance$iv != null) {
                    Collection destination$iv$iv3 = new ArrayList();
                    for (Object element$iv$iv : $this$filterIsInstance$iv) {
                        OuroMarks allMarks2 = list$iv$iv;
                        if (element$iv$iv instanceof OuroTextElement.Plain) {
                            destination$iv$iv3.add(element$iv$iv);
                        }
                        list$iv$iv = allMarks2;
                    }
                    allMarks = list$iv$iv;
                    Iterable $this$map$iv = (List) destination$iv$iv3;
                    Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        OuroTextElement.Plain it = (OuroTextElement.Plain) item$iv$iv;
                        destination$iv$iv4.add(it.getMarks());
                        $this$map$iv = $this$map$iv;
                    }
                    destination$iv$iv = (List) destination$iv$iv4;
                } else {
                    allMarks = list$iv$iv;
                    destination$iv$iv = CollectionsKt.emptyList();
                }
            } else {
                allMarks = list$iv$iv;
                if (node instanceof OuroInlineContent) {
                    Iterable $this$filterIsInstance$iv2 = ((OuroInlineContent) node).getMarks();
                    boolean z = false;
                    Collection destination$iv$iv5 = new ArrayList();
                    for (Object element$iv$iv2 : $this$filterIsInstance$iv2) {
                        Iterable $this$filterIsInstance$iv3 = $this$filterIsInstance$iv2;
                        boolean z2 = z;
                        if (element$iv$iv2 instanceof OuroTextMark) {
                            destination$iv$iv5.add(element$iv$iv2);
                        }
                        $this$filterIsInstance$iv2 = $this$filterIsInstance$iv3;
                        z = z2;
                    }
                    OuroMarks m = new OuroMarks((List) destination$iv$iv5);
                    destination$iv$iv = CollectionsKt.listOf(m);
                } else {
                    destination$iv$iv = CollectionsKt.emptyList();
                }
            }
            Iterable list$iv$iv2 = destination$iv$iv;
            CollectionsKt.addAll(destination$iv$iv2, list$iv$iv2);
            list$iv$iv = allMarks;
        }
        List marksList = (List) destination$iv$iv2;
        if (marksList.isEmpty()) {
            return null;
        }
        return MarkConflictResolver.INSTANCE.resolveMarksConflict(marksList);
    }

    public static final boolean willLeaveQuote(NodeStorageBuilder<?> nodeStorageBuilder, OuroPoint point) {
        OuroNode.Selectable selectable;
        Intrinsics.checkNotNullParameter(nodeStorageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        if (isInBlockQuote(nodeStorageBuilder, point)) {
            NodeStorageBuilder<?> $this$getNextSelectableOrNull$iv = nodeStorageBuilder;
            int nextIndex$iv = point.isInside() ? point.getIndex() + 1 : point.getIndex();
            if (nextIndex$iv < $this$getNextSelectableOrNull$iv.getAllSelectables().size()) {
                Object orNull = CollectionsKt.getOrNull($this$getNextSelectableOrNull$iv.getAllSelectables(), nextIndex$iv);
                if (!(orNull instanceof OuroNode.Selectable)) {
                    orNull = null;
                }
                selectable = (OuroNode.Selectable) orNull;
            } else {
                selectable = null;
            }
            OuroNode.Selectable afterElement = selectable;
            OuroNode.Parent<?> firstAncestorOrNull = afterElement != null ? nodeStorageBuilder.firstAncestorOrNull(afterElement, new Function1() { // from class: kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    boolean willLeaveQuote$lambda$0;
                    willLeaveQuote$lambda$0 = OuroNodeStorageUtilsKt.willLeaveQuote$lambda$0((OuroNode.Parent) obj);
                    return Boolean.valueOf(willLeaveQuote$lambda$0);
                }
            }) : null;
            OuroQuoteBlock parentQuote = firstAncestorOrNull instanceof OuroQuoteBlock ? (OuroQuoteBlock) firstAncestorOrNull : null;
            if (parentQuote != null) {
                List<OuroNode> siblings = nodeStorageBuilder.getSiblings(afterElement);
                if (siblings != null && siblings.size() == 1) {
                    List selectables = nodeStorageBuilder.calcAllSelectables(parentQuote);
                    if (Intrinsics.areEqual(CollectionsKt.last(selectables), afterElement)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static final boolean willLeaveQuote$lambda$0(OuroNode.Parent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof OuroQuoteBlock;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void leaveQuote(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroPoint point) {
        OuroNode ouroNode;
        Integer indexInSiblings;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        OuroNodeMutableStorage<?> $this$getNextSelectableOrNull$iv = ouroNodeMutableStorage;
        int nextIndex$iv = point.isInside() ? point.getIndex() + 1 : point.getIndex();
        if (nextIndex$iv < $this$getNextSelectableOrNull$iv.getAllSelectables().size()) {
            Object orNull = CollectionsKt.getOrNull($this$getNextSelectableOrNull$iv.getAllSelectables(), nextIndex$iv);
            if (!(orNull instanceof OuroNode.Selectable)) {
                orNull = null;
            }
            ouroNode = (OuroNode.Selectable) orNull;
        } else {
            ouroNode = null;
        }
        OuroNode afterElement = ouroNode;
        OuroNodeMutableStorage<?> $this$findFirstAncestorOrNull$iv = ouroNodeMutableStorage;
        OuroNode node$iv = afterElement;
        OuroNode.Parent<?> firstAncestorOrNull = node$iv != null ? $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt$leaveQuote$$inlined$findFirstAncestorOrNull$1
            public final Boolean invoke(OuroNode.Parent<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "it");
                return Boolean.valueOf(parent instanceof OuroParagraph);
            }
        }) : null;
        if (!(firstAncestorOrNull instanceof OuroParagraph)) {
            firstAncestorOrNull = null;
        }
        OuroParagraph parentParagraph = (OuroParagraph) firstAncestorOrNull;
        OuroNodeMutableStorage<?> $this$findFirstAncestorOrNull$iv2 = ouroNodeMutableStorage;
        OuroNode node$iv2 = afterElement;
        OuroNode.Parent<?> firstAncestorOrNull2 = node$iv2 != null ? $this$findFirstAncestorOrNull$iv2.firstAncestorOrNull(node$iv2, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt$leaveQuote$$inlined$findFirstAncestorOrNull$2
            public final Boolean invoke(OuroNode.Parent<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "it");
                return Boolean.valueOf(parent instanceof OuroQuoteBlock);
            }
        }) : null;
        if (!(firstAncestorOrNull2 instanceof OuroQuoteBlock)) {
            firstAncestorOrNull2 = null;
        }
        OuroQuoteBlock parentQuoteBlock = (OuroQuoteBlock) firstAncestorOrNull2;
        int indexInParent = (parentQuoteBlock == null || (indexInSiblings = ouroNodeMutableStorage.getIndexInSiblings(parentQuoteBlock)) == null) ? 0 : indexInSiblings.intValue();
        OuroNode.Parent quoteParent = parentQuoteBlock != null ? ouroNodeMutableStorage.getParent(parentQuoteBlock) : null;
        if (parentParagraph == null) {
            return;
        }
        ouroNodeMutableStorage.removeFromParent(parentParagraph);
        if (quoteParent != null) {
            ouroNodeMutableStorage.add(quoteParent, indexInParent + 1, parentParagraph);
        }
    }

    public static final boolean willLeaveList(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroPoint point) {
        Boolean isLast;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        OuroListItem p = getParentListItemOrNull(ouroNodeMutableStorage, point);
        if (p == null || (isLast = p.isLast(ouroNodeMutableStorage)) == null) {
            return false;
        }
        boolean isLast2 = isLast.booleanValue();
        return isLast2 && isBlank(ouroNodeMutableStorage, p);
    }

    public static final boolean willGetIntoList(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroSelection selection) {
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(selection, "selection");
        boolean startInList = isInList(ouroNodeMutableStorage, selection.getStart());
        boolean endInList = isInList(ouroNodeMutableStorage, selection.getEnd());
        return startInList && !endInList;
    }

    private static final boolean isInList(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroPoint point) {
        return getParentListItemOrNull(ouroNodeMutableStorage, point) != null;
    }

    public static final boolean isHeadingParagraphEnd(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroPoint point) {
        OuroNode.Selectable selectable$iv;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        OuroNodeMutableStorage<?> $this$getFirstSelectableAfterOrNull$iv = ouroNodeMutableStorage;
        int i$iv = point.getIndex();
        int size = $this$getFirstSelectableAfterOrNull$iv.getAllSelectables().size();
        while (true) {
            if (i$iv < size) {
                selectable$iv = (OuroNode.Selectable) CollectionsKt.getOrNull($this$getFirstSelectableAfterOrNull$iv.getAllSelectables(), i$iv);
                if (selectable$iv instanceof OuroNode.Selectable) {
                    break;
                }
                i$iv++;
            } else {
                selectable$iv = null;
                break;
            }
        }
        OuroNode.Selectable afterSelectable = selectable$iv;
        OuroNode.Parent<?> parent = afterSelectable != null ? ouroNodeMutableStorage.getParent(afterSelectable) : null;
        if (((parent instanceof OuroH1) || (parent instanceof OuroH2) || (parent instanceof OuroH3)) && (afterSelectable instanceof OuroTextElement.HardBreak)) {
            List<OuroNode> siblings = ouroNodeMutableStorage.getSiblings(afterSelectable);
            return Intrinsics.areEqual(siblings != null ? (OuroNode) CollectionsKt.lastOrNull(siblings) : null, afterSelectable);
        }
        return false;
    }

    public static final void leaveHeading(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroPoint point) {
        OuroNode.Selectable selectable$iv;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        OuroNodeMutableStorage<?> $this$getFirstSelectableAfterOrNull$iv = ouroNodeMutableStorage;
        int i$iv = point.getIndex();
        int size = $this$getFirstSelectableAfterOrNull$iv.getAllSelectables().size();
        while (true) {
            if (i$iv < size) {
                selectable$iv = (OuroNode.Selectable) CollectionsKt.getOrNull($this$getFirstSelectableAfterOrNull$iv.getAllSelectables(), i$iv);
                if (selectable$iv instanceof OuroNode.Selectable) {
                    break;
                }
                i$iv++;
            } else {
                selectable$iv = null;
                break;
            }
        }
        if (selectable$iv == null) {
            OuroNodeMutableStorage<?> $this$getLastSelectableBeforeOrNull$iv = ouroNodeMutableStorage;
            int i$iv2 = point.getIndex() - 1;
            while (true) {
                if (-1 < i$iv2) {
                    selectable$iv = (OuroNode.Selectable) CollectionsKt.getOrNull($this$getLastSelectableBeforeOrNull$iv.getAllSelectables(), i$iv2);
                    if (selectable$iv instanceof OuroNode.Selectable) {
                        break;
                    }
                    i$iv2--;
                } else {
                    selectable$iv = null;
                    break;
                }
            }
            if (selectable$iv == null) {
                return;
            }
        }
        OuroNode.Selectable afterSelectable = selectable$iv;
        OuroNodeMutableStorage<?> $this$findFirstAncestorOrNull$iv = ouroNodeMutableStorage;
        OuroNode.Selectable node$iv = afterSelectable;
        OuroNode.Parent<?> firstAncestorOrNull = $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt$leaveHeading$$inlined$findFirstAncestorOrNull$1
            public final Boolean invoke(OuroNode.Parent<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "it");
                return Boolean.valueOf(parent instanceof OuroParagraph);
            }
        });
        if (!(firstAncestorOrNull instanceof OuroParagraph)) {
            firstAncestorOrNull = null;
        }
        OuroParagraph parentParagraph = (OuroParagraph) firstAncestorOrNull;
        if (parentParagraph == null) {
            return;
        }
        OuroText p = new OuroText(parentParagraph.getParagraphMarks());
        ouroNodeMutableStorage.add(p, new OuroTextElement.HardBreak(null, 1, null));
        insertAfter(ouroNodeMutableStorage, p, parentParagraph);
    }

    public static final void outdentList(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroPoint point) {
        OuroNode ouroNode;
        List items;
        Integer indexInSiblings;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        OuroNodeMutableStorage<?> $this$getNextSelectableOrNull$iv = ouroNodeMutableStorage;
        int nextIndex$iv = point.isInside() ? point.getIndex() + 1 : point.getIndex();
        if (nextIndex$iv < $this$getNextSelectableOrNull$iv.getAllSelectables().size()) {
            Object orNull = CollectionsKt.getOrNull($this$getNextSelectableOrNull$iv.getAllSelectables(), nextIndex$iv);
            if (!(orNull instanceof OuroNode.Selectable)) {
                orNull = null;
            }
            ouroNode = (OuroNode.Selectable) orNull;
        } else {
            ouroNode = null;
        }
        OuroNode.Selectable afterElement = ouroNode;
        if (afterElement instanceof OuroTextElement.HardBreak) {
            List<OuroNode> siblings = ouroNodeMutableStorage.getSiblings(afterElement);
            if (siblings != null && siblings.size() == 1) {
                OuroNodeMutableStorage<?> $this$findFirstAncestorOrNull$iv = ouroNodeMutableStorage;
                OuroNode.Selectable node$iv = afterElement;
                OuroNode.Parent<?> firstAncestorOrNull = $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt$outdentList$$inlined$findFirstAncestorOrNull$1
                    public final Boolean invoke(OuroNode.Parent<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "it");
                        return Boolean.valueOf(parent instanceof OuroParagraph);
                    }
                });
                if (!(firstAncestorOrNull instanceof OuroParagraph)) {
                    firstAncestorOrNull = null;
                }
                OuroParagraph paragraph = (OuroParagraph) firstAncestorOrNull;
                OuroNodeMutableStorage<?> $this$findFirstAncestorOrNull$iv2 = ouroNodeMutableStorage;
                OuroNode.Selectable node$iv2 = afterElement;
                OuroNode.Parent<?> firstAncestorOrNull2 = $this$findFirstAncestorOrNull$iv2.firstAncestorOrNull(node$iv2, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt$outdentList$$inlined$findFirstAncestorOrNull$2
                    public final Boolean invoke(OuroNode.Parent<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "it");
                        return Boolean.valueOf(parent instanceof OuroListItem);
                    }
                });
                if (!(firstAncestorOrNull2 instanceof OuroListItem)) {
                    firstAncestorOrNull2 = null;
                }
                OuroListItem listItem = (OuroListItem) firstAncestorOrNull2;
                int indexInParent = (listItem == null || (indexInSiblings = ouroNodeMutableStorage.getIndexInSiblings(listItem)) == null) ? 0 : indexInSiblings.intValue();
                OuroNode.Parent ouroList = listItem != null ? ouroNodeMutableStorage.getParent(listItem) : null;
                if (paragraph == null) {
                    return;
                }
                ouroNodeMutableStorage.removeFromParent(paragraph);
                if (ouroList instanceof OuroList) {
                    OuroNode.Parent listParent = ouroNodeMutableStorage.getParent(ouroList);
                    if (!(listParent instanceof OuroListItem)) {
                        if (listParent instanceof OuroDocument) {
                            ouroNodeMutableStorage.removeFromParent(listItem);
                            OuroText p = new OuroText(null, 1, null);
                            ouroNodeMutableStorage.add(p, new OuroTextElement.HardBreak(null, 1, null));
                            Integer indexInSiblings2 = ouroNodeMutableStorage.getIndexInSiblings(ouroList);
                            int indexInDoc = indexInSiblings2 != null ? indexInSiblings2.intValue() : 0;
                            ouroNodeMutableStorage.add(listParent, indexInDoc + 1, p);
                            return;
                        }
                        return;
                    }
                    OuroNode.Parent targetParent = ouroNodeMutableStorage.getParent(listParent);
                    OuroListItem newListItem = new OuroListItem((OuroMarks) null, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
                    ouroNodeMutableStorage.add(newListItem, paragraph);
                    Integer indexInSiblings3 = ouroNodeMutableStorage.getIndexInSiblings(listParent);
                    int listIndexInParent = indexInSiblings3 != null ? indexInSiblings3.intValue() : 0;
                    if (targetParent != null) {
                        ouroNodeMutableStorage.add(targetParent, listIndexInParent + 1, newListItem);
                    }
                    List<OuroNode> siblings2 = ouroNodeMutableStorage.getSiblings(listItem);
                    if (siblings2 != null && (items = CollectionsKt.drop(siblings2, indexInParent + 1)) != null) {
                        ouroNodeMutableStorage.removeFromParent(listItem);
                        if (items.isEmpty()) {
                            return;
                        }
                        OuroOrderedList orderedList = new OuroOrderedList(0, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
                        ouroNodeMutableStorage.add(newListItem, orderedList);
                        List $this$forEach$iv = items;
                        for (Object element$iv : $this$forEach$iv) {
                            OuroNode.Selectable afterElement2 = afterElement;
                            OuroNode it = (OuroNode) element$iv;
                            ouroNodeMutableStorage.removeFromParent(it);
                            ouroNodeMutableStorage.add(orderedList, it);
                            afterElement = afterElement2;
                        }
                    }
                }
            }
        }
    }

    public static final OuroListItem currentListItem(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroPoint point) {
        OuroNode ouroNode;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        OuroNode element = getSelectableOrNull(ouroNodeMutableStorage, point);
        if (element == null) {
            OuroNodeMutableStorage<?> $this$getNextSelectableOrNull$iv = ouroNodeMutableStorage;
            int nextIndex$iv = point.isInside() ? point.getIndex() + 1 : point.getIndex();
            if (nextIndex$iv < $this$getNextSelectableOrNull$iv.getAllSelectables().size()) {
                Object orNull = CollectionsKt.getOrNull($this$getNextSelectableOrNull$iv.getAllSelectables(), nextIndex$iv);
                if (!(orNull instanceof OuroNode.Selectable)) {
                    orNull = null;
                }
                ouroNode = (OuroNode.Selectable) orNull;
            } else {
                ouroNode = null;
            }
            element = ouroNode;
        }
        if (element == null) {
            return null;
        }
        OuroNodeMutableStorage<?> $this$findFirstAncestorOrNull$iv = ouroNodeMutableStorage;
        OuroNode node$iv = element;
        OuroNode.Parent<?> firstAncestorOrNull = $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt$currentListItem$$inlined$findFirstAncestorOrNull$1
            public final Boolean invoke(OuroNode.Parent<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "it");
                return Boolean.valueOf(parent instanceof OuroListItem);
            }
        });
        return firstAncestorOrNull instanceof OuroListItem ? firstAncestorOrNull : null;
    }

    public static final void outdentListItem(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroListItem listItem) {
        OuroNode ouroNode;
        Iterable items;
        Object element$iv;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(listItem, "listItem");
        OuroNodeMutableStorage<?> $this$findFirstAncestorOrNull$iv = ouroNodeMutableStorage;
        OuroListItem node$iv = listItem;
        OuroNode.Parent<?> firstAncestorOrNull = $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt$outdentListItem$$inlined$findFirstAncestorOrNull$1
            public final Boolean invoke(OuroNode.Parent<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "it");
                return Boolean.valueOf(parent instanceof OuroList);
            }
        });
        if (!(firstAncestorOrNull instanceof OuroList)) {
            firstAncestorOrNull = null;
        }
        OuroList list = (OuroList) firstAncestorOrNull;
        if (list == null) {
            return;
        }
        Integer indexInSiblings = ouroNodeMutableStorage.getIndexInSiblings(listItem);
        int listItemIndex = indexInSiblings != null ? indexInSiblings.intValue() : 0;
        OuroNode.Parent<?> parent = ouroNodeMutableStorage.getParent(list);
        if (parent instanceof OuroListItem) {
            OuroNode.Parent<?> parent2 = ouroNodeMutableStorage.getParent(list);
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type kntr.common.ouro.core.model.node.OuroListItem");
            OuroListItem parentItem = (OuroListItem) parent2;
            OuroNode.Parent targetParent = ouroNodeMutableStorage.getParent(parentItem);
            Integer indexInSiblings2 = ouroNodeMutableStorage.getIndexInSiblings(parentItem);
            int targetIndex = indexInSiblings2 != null ? indexInSiblings2.intValue() : 0;
            Iterable children = ouroNodeMutableStorage.getChildren(listItem);
            if (children != null) {
                Iterable $this$firstOrNull$iv = children;
                Iterator<T> it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        if (((OuroNode) element$iv) instanceof OuroList) {
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
            OuroOrderedList ouroOrderedList = ouroNode instanceof OuroList ? (OuroList) ouroNode : null;
            if (ouroOrderedList == null) {
                OuroOrderedList it2 = new OuroOrderedList(0, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
                ouroNodeMutableStorage.add(listItem, it2);
                ouroOrderedList = it2;
            }
            OuroList childrenList = ouroOrderedList;
            List listSiblings = ouroNodeMutableStorage.getSiblings(listItem);
            if (listSiblings != null && (items = CollectionsKt.drop(listSiblings, listItemIndex + 1)) != null) {
                Iterable $this$forEach$iv = items;
                for (Object element$iv2 : $this$forEach$iv) {
                    OuroNode it3 = (OuroNode) element$iv2;
                    ouroNodeMutableStorage.removeFromParent(it3);
                    ouroNodeMutableStorage.add(childrenList, it3);
                    parentItem = parentItem;
                }
            }
            ouroNodeMutableStorage.removeFromParent(listItem);
            if (targetParent != null) {
                ouroNodeMutableStorage.add(targetParent, targetIndex + 1, listItem);
            }
        } else if (parent instanceof OuroDocument) {
            OuroNode.Parent<?> parent3 = ouroNodeMutableStorage.getParent(list);
            Intrinsics.checkNotNull(parent3, "null cannot be cast to non-null type kntr.common.ouro.core.model.node.OuroDocument");
            OuroDocument doc = (OuroDocument) parent3;
            Integer indexInSiblings3 = ouroNodeMutableStorage.getIndexInSiblings(list);
            int indexInDoc = indexInSiblings3 != null ? indexInSiblings3.intValue() : 0;
            List listChildren = ouroNodeMutableStorage.getChildrenOrNull(list);
            if (listChildren == null) {
                return;
            }
            if (listItemIndex < listChildren.size() - 1) {
                ouroNodeMutableStorage.removeAllChildren(list);
                Pair<OuroNode.Parent<OuroListItem>, OuroNode.Parent<OuroListItem>> tryDivide = list.tryDivide();
                OuroList first = (OuroList) tryDivide.component1();
                OuroList second = (OuroList) tryDivide.component2();
                ouroNodeMutableStorage.add(first, listChildren.subList(0, listItemIndex + 1));
                ouroNodeMutableStorage.add(second, listChildren.subList(listItemIndex + 1, listChildren.size()));
                ouroNodeMutableStorage.replace((OuroNodeMutableStorage<?>) list, (Collection<? extends OuroNodeMutableStorage<?>>) CollectionsKt.listOf(new OuroList[]{first, second}));
            }
            ouroNodeMutableStorage.removeFromParent(listItem);
            List p = ouroNodeMutableStorage.getChildren(listItem);
            if (p == null) {
                return;
            }
            ouroNodeMutableStorage.add(doc, indexInDoc + 1, p);
        }
    }

    public static final void indentListItem(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroListItem listItem) {
        OuroNode.Parent ouroList;
        Object obj;
        Object element$iv;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(listItem, "listItem");
        Integer indexInSiblings = ouroNodeMutableStorage.getIndexInSiblings(listItem);
        int indexInParent = indexInSiblings != null ? indexInSiblings.intValue() : 0;
        if (indexInParent > 0 && (ouroList = ouroNodeMutableStorage.getParent(listItem)) != null && (ouroList instanceof OuroList)) {
            List<OuroNode> siblings = ouroNodeMutableStorage.getSiblings(listItem);
            OuroNode ouroNode = siblings != null ? (OuroNode) CollectionsKt.getOrNull(siblings, indexInParent - 1) : null;
            OuroListItem prevListItem = ouroNode instanceof OuroListItem ? (OuroListItem) ouroNode : null;
            if (prevListItem == null) {
                return;
            }
            Iterable children = ouroNodeMutableStorage.getChildren(prevListItem);
            if (children == null) {
                obj = null;
            } else {
                Iterable $this$firstOrNull$iv = children;
                Iterator<T> it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        OuroNode it2 = (OuroNode) element$iv;
                        if (it2 instanceof OuroList) {
                            break;
                        }
                    } else {
                        element$iv = null;
                        break;
                    }
                }
                obj = (OuroNode) element$iv;
            }
            OuroList nestedList = obj instanceof OuroList ? (OuroList) obj : null;
            if (nestedList == null) {
                nestedList = ((OuroList) ouroList).copy();
                ouroNodeMutableStorage.add(prevListItem, nestedList);
            }
            ouroNodeMutableStorage.removeFromParent(listItem);
            ouroNodeMutableStorage.add(nestedList, listItem);
        }
    }

    public static final OuroTextRange getIntoQuoteIfNeeded(OuroNodeMutableStorage<?> ouroNodeMutableStorage, List<? extends OuroNode.Selectable> list, OuroSelection selection, Function2<? super OuroNodeStorage<?>, ? super OuroNode.Selectable, Integer> function2) {
        OuroNode.Selectable selectable;
        OuroNode.Selectable selectable2;
        OuroParagraphChild accumulator$iv;
        OuroNode.Selectable beforeElement;
        Integer indexInSiblings;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(list, "selectables");
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(function2, "displayLengthTransform");
        if (isInBlockQuote(ouroNodeMutableStorage, selection.getStart()) && !isInBlockQuote(ouroNodeMutableStorage, selection.getEnd()) && list.size() == 1 && (CollectionsKt.first(list) instanceof OuroTextElement.HardBreak) && getSelectableOrNull(ouroNodeMutableStorage, selection.getEnd()) == null) {
            OuroNodeMutableStorage<?> $this$getPreviousSelectableOrNull$iv = ouroNodeMutableStorage;
            int prevIndex$iv = selection.getEnd().getIndex() - 1;
            if (prevIndex$iv >= 0) {
                Object orNull = CollectionsKt.getOrNull($this$getPreviousSelectableOrNull$iv.getAllSelectables(), prevIndex$iv);
                if (!(orNull instanceof OuroNode.Selectable)) {
                    orNull = null;
                }
                selectable = (OuroNode.Selectable) orNull;
            } else {
                selectable = null;
            }
            OuroNode.Selectable beforeElement2 = selectable;
            OuroNodeMutableStorage<?> $this$getNextSelectableOrNull$iv = ouroNodeMutableStorage;
            OuroPoint point$iv = selection.getEnd();
            int nextIndex$iv = point$iv.isInside() ? point$iv.getIndex() + 1 : point$iv.getIndex();
            if (nextIndex$iv < $this$getNextSelectableOrNull$iv.getAllSelectables().size()) {
                Object orNull2 = CollectionsKt.getOrNull($this$getNextSelectableOrNull$iv.getAllSelectables(), nextIndex$iv);
                if (!(orNull2 instanceof OuroNode.Selectable)) {
                    orNull2 = null;
                }
                selectable2 = (OuroNode.Selectable) orNull2;
            } else {
                selectable2 = null;
            }
            OuroNode.Selectable afterElement = selectable2;
            OuroNode.Parent<?> firstAncestorOrNull = beforeElement2 != null ? ouroNodeMutableStorage.firstAncestorOrNull(beforeElement2, new Function1() { // from class: kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    boolean intoQuoteIfNeeded$lambda$0;
                    intoQuoteIfNeeded$lambda$0 = OuroNodeStorageUtilsKt.getIntoQuoteIfNeeded$lambda$0((OuroNode.Parent) obj);
                    return Boolean.valueOf(intoQuoteIfNeeded$lambda$0);
                }
            }) : null;
            OuroParagraph beforeParentParagraph = firstAncestorOrNull instanceof OuroParagraph ? (OuroParagraph) firstAncestorOrNull : null;
            OuroNode.Parent<?> firstAncestorOrNull2 = afterElement != null ? ouroNodeMutableStorage.firstAncestorOrNull(afterElement, new Function1() { // from class: kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    boolean intoQuoteIfNeeded$lambda$1;
                    intoQuoteIfNeeded$lambda$1 = OuroNodeStorageUtilsKt.getIntoQuoteIfNeeded$lambda$1((OuroNode.Parent) obj);
                    return Boolean.valueOf(intoQuoteIfNeeded$lambda$1);
                }
            }) : null;
            OuroParagraph afterParentParagraph = firstAncestorOrNull2 instanceof OuroParagraph ? (OuroParagraph) firstAncestorOrNull2 : null;
            if (afterParentParagraph == null) {
                return null;
            }
            int hardBreakIndexInParent = (beforeElement2 == null || (indexInSiblings = ouroNodeMutableStorage.getIndexInSiblings(beforeElement2)) == null) ? 0 : indexInSiblings.intValue();
            if (beforeElement2 != null) {
                ouroNodeMutableStorage.removeFromParent(beforeElement2);
            }
            Iterable childrenOrNull = ouroNodeMutableStorage.getChildrenOrNull(afterParentParagraph);
            if (childrenOrNull != null) {
                Iterable $this$foldIndexed$iv = childrenOrNull;
                int index$iv = 0;
                accumulator$iv = null;
                for (Object element$iv : $this$foldIndexed$iv) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    OuroParagraphChild child = (OuroParagraphChild) element$iv;
                    OuroParagraphChild acc = accumulator$iv;
                    ouroNodeMutableStorage.removeFromParent(child);
                    if (beforeParentParagraph != null) {
                        beforeElement = beforeElement2;
                        ouroNodeMutableStorage.add(beforeParentParagraph, hardBreakIndexInParent + index$iv, child);
                    } else {
                        beforeElement = beforeElement2;
                    }
                    if (acc != null) {
                        child = acc;
                    }
                    accumulator$iv = child;
                    index$iv = index$iv2;
                    beforeElement2 = beforeElement;
                }
            } else {
                accumulator$iv = null;
            }
            OuroNode.Selectable beforeTarget = accumulator$iv instanceof OuroNode.Selectable ? (OuroNode.Selectable) accumulator$iv : null;
            if (beforeTarget != null) {
                return getTextRangeBefore(ouroNodeMutableStorage, beforeTarget, function2);
            }
            return null;
        }
        return null;
    }

    public static final boolean getIntoQuoteIfNeeded$lambda$0(OuroNode.Parent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof OuroParagraph;
    }

    public static final boolean getIntoQuoteIfNeeded$lambda$1(OuroNode.Parent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof OuroParagraph;
    }

    public static final boolean isEmpty(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroNode node) {
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        if (node == null) {
            return true;
        }
        if (!(node instanceof OuroNode.Parent)) {
            return (node instanceof OuroTextElement) && ((OuroTextElement) node).getMeta().length() == 0;
        }
        Iterable children = ouroNodeMutableStorage.getChildren((OuroNode.Parent) node);
        List<OuroNode> list = (Collection) children;
        if (list == null || list.isEmpty()) {
            return true;
        }
        Iterable $this$all$iv = children;
        if (($this$all$iv instanceof Collection) && ((Collection) $this$all$iv).isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            OuroNode it = (OuroNode) element$iv;
            if (!isEmpty(ouroNodeMutableStorage, it)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isBlank(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroNode node) {
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        if (node instanceof OuroNode.Parent) {
            Iterable children = ouroNodeMutableStorage.getChildren((OuroNode.Parent) node);
            List<OuroNode> list = (Collection) children;
            if (list == null || list.isEmpty()) {
                return true;
            }
            Iterable $this$all$iv = children;
            if (($this$all$iv instanceof Collection) && ((Collection) $this$all$iv).isEmpty()) {
                return true;
            }
            for (Object element$iv : $this$all$iv) {
                OuroNode it = (OuroNode) element$iv;
                if (!isBlank(ouroNodeMutableStorage, it)) {
                    return false;
                }
            }
            return true;
        } else if (node instanceof OuroTextElement) {
            return Intrinsics.areEqual(((OuroTextElement) node).getMeta(), "\n");
        } else {
            return false;
        }
    }

    public static final boolean isInOuroList(NodeStorageBuilder<?> nodeStorageBuilder, OuroPoint point) {
        Intrinsics.checkNotNullParameter(nodeStorageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        return getParentListItemOrNull(nodeStorageBuilder, point) != null;
    }

    public static final void splitListItemAt(NodeStorageBuilder<?> nodeStorageBuilder, OuroPoint point) {
        OuroNode.Selectable selectable;
        List<OuroNode> siblings;
        Iterable drop;
        Integer indexInSiblings;
        List<OuroNode> subList;
        Iterable it;
        Intrinsics.checkNotNullParameter(nodeStorageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        OuroListItem parentListItem = getParentListItemOrNull(nodeStorageBuilder, point);
        if (parentListItem == null) {
            return;
        }
        separate(nodeStorageBuilder, new OuroSelection(point));
        NodeStorageBuilder<?> $this$getNextSelectable$iv = nodeStorageBuilder;
        OuroPoint point$iv = constrainPoint$default(point, nodeStorageBuilder.getAllSelectables(), false, 4, null);
        int nextIndex$iv$iv = point$iv.isInside() ? point$iv.getIndex() + 1 : point$iv.getIndex();
        if (nextIndex$iv$iv < $this$getNextSelectable$iv.getAllSelectables().size()) {
            Object orNull = CollectionsKt.getOrNull($this$getNextSelectable$iv.getAllSelectables(), nextIndex$iv$iv);
            if (!(orNull instanceof OuroNode.Selectable)) {
                orNull = null;
            }
            selectable = (OuroNode.Selectable) orNull;
        } else {
            selectable = null;
        }
        if (selectable != null) {
            OuroNode.Selectable afterElement = selectable;
            Integer indexInSiblings2 = nodeStorageBuilder.getIndexInSiblings(parentListItem);
            int listItemIndexInParent = indexInSiblings2 != null ? indexInSiblings2.intValue() : 0;
            List<OuroNode> siblings2 = nodeStorageBuilder.getSiblings(afterElement);
            if (siblings2 == null) {
                return;
            }
            int siblingsLen = siblings2.size();
            Integer indexInSiblings3 = nodeStorageBuilder.getIndexInSiblings(afterElement);
            int elementIndex = indexInSiblings3 != null ? indexInSiblings3.intValue() : 0;
            OuroListItem newListItem = OuroListItem.copy$default(parentListItem, null, null, 3, null);
            OuroNode.Parent originalAfterElementParent = nodeStorageBuilder.getParent(afterElement);
            OuroText p = new OuroText(null, 1, null);
            List<OuroNode> siblings3 = nodeStorageBuilder.getSiblings(afterElement);
            if (siblings3 != null && (subList = siblings3.subList(elementIndex, siblingsLen)) != null && (it = CollectionsKt.toList(subList)) != null) {
                Iterable $this$forEach$iv = it;
                for (Object element$iv : $this$forEach$iv) {
                    OuroNode c = (OuroNode) element$iv;
                    nodeStorageBuilder.removeFromParent(c);
                }
                nodeStorageBuilder.add(p, (Collection) it);
                nodeStorageBuilder.add(newListItem, p);
            }
            if (elementIndex == 0 && originalAfterElementParent != null) {
                nodeStorageBuilder.add(originalAfterElementParent, new OuroTextElement.HardBreak(null, 1, null));
            }
            int parentIndex = (originalAfterElementParent == null || (indexInSiblings = nodeStorageBuilder.getIndexInSiblings(originalAfterElementParent)) == null) ? 0 : indexInSiblings.intValue();
            if (originalAfterElementParent != null && (siblings = nodeStorageBuilder.getSiblings(originalAfterElementParent)) != null && (drop = CollectionsKt.drop(siblings, parentIndex + 1)) != null) {
                Iterable $this$forEach$iv2 = drop;
                for (Object element$iv2 : $this$forEach$iv2) {
                    OuroNode it2 = (OuroNode) element$iv2;
                    nodeStorageBuilder.removeFromParent(it2);
                    nodeStorageBuilder.add(newListItem, it2);
                }
            }
            OuroNode.Parent<?> parent = nodeStorageBuilder.getParent(parentListItem);
            if (parent != null) {
                nodeStorageBuilder.add(parent, listItemIndexInParent + 1, newListItem);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("next " + Reflection.getOrCreateKotlinClass(OuroNode.Selectable.class) + " not found after point " + point$iv + "\"");
    }

    public static final boolean insertAfter(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroNode node, OuroNode target) {
        Integer indexInSiblings;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(target, "target");
        OuroNode.Parent parent = ouroNodeMutableStorage.getParent(target);
        if (parent == null || (indexInSiblings = ouroNodeMutableStorage.getIndexInSiblings(target)) == null) {
            return false;
        }
        int indexInParent = indexInSiblings.intValue();
        if (parent.isValidParentOf(node)) {
            ouroNodeMutableStorage.add(parent, indexInParent + 1, node);
            return true;
        }
        Pair divided = parent.tryDivide();
        if (divided == null) {
            return insertAfter(ouroNodeMutableStorage, node, parent);
        }
        OuroNode.Parent<?> first = divided.component1();
        OuroNode.Parent<?> second = divided.component2();
        List children = ouroNodeMutableStorage.removeAllChildren(parent);
        if ((children != null && (children.isEmpty() ^ true)) && children.size() > indexInParent) {
            ouroNodeMutableStorage.add(first, children.subList(0, indexInParent + 1));
            ouroNodeMutableStorage.add(second, children.subList(indexInParent + 1, children.size()));
        }
        ouroNodeMutableStorage.replace((OuroNodeMutableStorage<?>) parent, (Collection<? extends OuroNodeMutableStorage<?>>) CollectionsKt.listOf(new OuroNode.Parent[]{first, second}));
        if (first.isValidParentOf(node)) {
            ouroNodeMutableStorage.add(first, node);
            return true;
        }
        return insertAfter(ouroNodeMutableStorage, node, first);
    }

    public static final boolean insertAfter(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroNodeStorage<?> ouroNodeStorage, OuroNode target) {
        Integer indexInSiblings;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "storage");
        Intrinsics.checkNotNullParameter(target, "target");
        OuroNode.Parent parent = ouroNodeMutableStorage.getParent(target);
        if (parent == null || (indexInSiblings = ouroNodeMutableStorage.getIndexInSiblings(target)) == null) {
            return false;
        }
        int indexInParent = indexInSiblings.intValue();
        if (parent.isValidParentOf(ouroNodeStorage.getRoot())) {
            ouroNodeMutableStorage.add((OuroNodeMutableStorage<?>) parent, indexInParent + 1, ouroNodeStorage);
            return true;
        }
        Pair divided = parent.tryDivide();
        if (divided == null) {
            return insertAfter(ouroNodeMutableStorage, ouroNodeStorage, parent);
        }
        OuroNode.Parent<?> first = divided.component1();
        OuroNode.Parent<?> second = divided.component2();
        List children = ouroNodeMutableStorage.removeAllChildren(parent);
        if ((children != null && (children.isEmpty() ^ true)) && children.size() > indexInParent) {
            ouroNodeMutableStorage.add(first, children.subList(0, indexInParent + 1));
            ouroNodeMutableStorage.add(second, children.subList(indexInParent + 1, children.size()));
        }
        ouroNodeMutableStorage.replace((OuroNodeMutableStorage<?>) parent, (Collection<? extends OuroNodeMutableStorage<?>>) CollectionsKt.listOf(new OuroNode.Parent[]{first, second}));
        if (first.isValidParentOf(ouroNodeStorage.getRoot())) {
            ouroNodeMutableStorage.add((OuroNodeMutableStorage<?>) first, ouroNodeStorage);
            return true;
        }
        return insertAfter(ouroNodeMutableStorage, ouroNodeStorage, first);
    }

    public static final boolean insertBefore(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroNode node, OuroNode target) {
        Integer indexInSiblings;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(target, "target");
        OuroNode.Parent parent = ouroNodeMutableStorage.getParent(target);
        if (parent == null || (indexInSiblings = ouroNodeMutableStorage.getIndexInSiblings(target)) == null) {
            return false;
        }
        int indexInParent = indexInSiblings.intValue();
        if (parent.isValidParentOf(node)) {
            ouroNodeMutableStorage.add(parent, indexInParent, node);
            return true;
        }
        Pair divided = parent.tryDivide();
        if (divided == null) {
            return insertBefore(ouroNodeMutableStorage, node, parent);
        }
        OuroNode.Parent<?> first = divided.component1();
        OuroNode.Parent<?> second = divided.component2();
        List children = ouroNodeMutableStorage.removeAllChildren(parent);
        if ((children != null && (children.isEmpty() ^ true)) && children.size() > indexInParent) {
            ouroNodeMutableStorage.add(first, children.subList(0, indexInParent));
            ouroNodeMutableStorage.add(second, children.subList(indexInParent, children.size()));
        }
        if (indexInParent == 0) {
            ouroNodeMutableStorage.replace(parent, second);
            if (second.isValidParentOf(node)) {
                ouroNodeMutableStorage.add(second, 0, node);
                return true;
            }
        } else {
            ouroNodeMutableStorage.replace((OuroNodeMutableStorage<?>) parent, (Collection<? extends OuroNodeMutableStorage<?>>) CollectionsKt.listOf(new OuroNode.Parent[]{first, second}));
        }
        return insertBefore(ouroNodeMutableStorage, node, second);
    }

    public static final boolean insertBefore(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroNodeStorage<?> ouroNodeStorage, OuroNode target) {
        Integer indexInSiblings;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "storage");
        Intrinsics.checkNotNullParameter(target, "target");
        OuroNode.Parent parent = ouroNodeMutableStorage.getParent(target);
        if (parent == null || (indexInSiblings = ouroNodeMutableStorage.getIndexInSiblings(target)) == null) {
            return false;
        }
        int indexInParent = indexInSiblings.intValue();
        if (parent.isValidParentOf(ouroNodeStorage.getRoot())) {
            ouroNodeMutableStorage.add((OuroNodeMutableStorage<?>) parent, indexInParent, ouroNodeStorage);
            return true;
        }
        Pair divided = parent.tryDivide();
        if (divided == null) {
            return insertBefore(ouroNodeMutableStorage, ouroNodeStorage, parent);
        }
        OuroNode.Parent<?> first = divided.component1();
        OuroNode.Parent<?> second = divided.component2();
        List children = ouroNodeMutableStorage.removeAllChildren(parent);
        if ((children != null && (children.isEmpty() ^ true)) && children.size() > indexInParent) {
            ouroNodeMutableStorage.add(first, children.subList(0, indexInParent));
            ouroNodeMutableStorage.add(second, children.subList(indexInParent, children.size()));
        }
        if (indexInParent == 0) {
            ouroNodeMutableStorage.replace(parent, second);
            if (second.isValidParentOf(ouroNodeStorage.getRoot())) {
                ouroNodeMutableStorage.add((OuroNodeMutableStorage<?>) second, 0, ouroNodeStorage);
                return true;
            }
        } else {
            ouroNodeMutableStorage.replace((OuroNodeMutableStorage<?>) parent, (Collection<? extends OuroNodeMutableStorage<?>>) CollectionsKt.listOf(new OuroNode.Parent[]{first, second}));
        }
        return insertBefore(ouroNodeMutableStorage, ouroNodeStorage, second);
    }

    public static final NodeStorageBuilder<OuroDocument> subdocument(NodeStorage<OuroDocument> nodeStorage, OuroSelection selection) {
        OuroNode replacement;
        Integer indexInSiblings;
        OuroNode replacement2;
        Integer indexInSiblings2;
        Integer indexInSiblings3;
        Integer indexInSiblings4;
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(selection, "selection");
        if (selection.isCollapsed()) {
            return null;
        }
        NodeStorageBuilder newDocument = new NodeStorageBuilder(nodeStorage.getRoot(), null, null, 6, null);
        List selectables = getSelectables(nodeStorage, selection);
        List $this$forEach$iv = selectables;
        for (Object element$iv : $this$forEach$iv) {
            OuroNode.Selectable selectable = (OuroNode.Selectable) element$iv;
            addPathToRoot(nodeStorage, selectable, newDocument);
            addAllDescendants(nodeStorage, selectable, newDocument);
        }
        OuroNode.Selectable first = (OuroNode.Selectable) CollectionsKt.firstOrNull(selectables);
        if (first != null) {
            if (OuroNodeUtilsKt.isSeparable(first) && selectableContainsPoint(nodeStorage, first, selection.getStart())) {
                if (selectableContainsPoint(nodeStorage, first, selection.getEnd())) {
                    OuroNode replacement3 = (OuroNode.Separable) CollectionsKt.getOrNull(((OuroNode.Separable) first).separate(selection.getStart().getOffset(), selection.getEnd().getOffset()), 1);
                    if (replacement3 != null) {
                        NodeStorageBuilder $this$replace$iv = newDocument;
                        OuroNode.Selectable source$iv = first;
                        OuroNode target$iv = replacement3;
                        OuroNode.Parent parent$iv = $this$replace$iv.getParent(source$iv);
                        if (parent$iv != null && (indexInSiblings4 = $this$replace$iv.getIndexInSiblings(source$iv)) != null) {
                            int indexInParent$iv = indexInSiblings4.intValue();
                            $this$replace$iv.removeFromParent(source$iv);
                            $this$replace$iv.add(parent$iv, indexInParent$iv, target$iv);
                        }
                    }
                } else {
                    OuroNode replacement4 = (OuroNode.Separable) CollectionsKt.lastOrNull(((OuroNode.Separable) first).separate(selection.getStart().getOffset()));
                    if (replacement4 != null) {
                        NodeStorageBuilder $this$replace$iv2 = newDocument;
                        OuroNode.Selectable source$iv2 = first;
                        OuroNode target$iv2 = replacement4;
                        OuroNode.Parent parent$iv2 = $this$replace$iv2.getParent(source$iv2);
                        if (parent$iv2 != null && (indexInSiblings3 = $this$replace$iv2.getIndexInSiblings(source$iv2)) != null) {
                            int indexInParent$iv2 = indexInSiblings3.intValue();
                            $this$replace$iv2.removeFromParent(source$iv2);
                            $this$replace$iv2.add(parent$iv2, indexInParent$iv2, target$iv2);
                        }
                    }
                    OuroNode.Selectable last = (OuroNode.Selectable) CollectionsKt.lastOrNull(selectables);
                    if (last != null && OuroNodeUtilsKt.isSeparable(last) && selectableContainsPoint(nodeStorage, last, selection.getEnd()) && (replacement2 = (OuroNode.Separable) CollectionsKt.firstOrNull(((OuroNode.Separable) last).separate(selection.getEnd().getOffset()))) != null) {
                        NodeStorageBuilder $this$replace$iv3 = newDocument;
                        OuroNode.Selectable source$iv3 = last;
                        OuroNode target$iv3 = replacement2;
                        OuroNode.Parent parent$iv3 = $this$replace$iv3.getParent(source$iv3);
                        if (parent$iv3 != null && (indexInSiblings2 = $this$replace$iv3.getIndexInSiblings(source$iv3)) != null) {
                            int indexInParent$iv3 = indexInSiblings2.intValue();
                            $this$replace$iv3.removeFromParent(source$iv3);
                            $this$replace$iv3.add(parent$iv3, indexInParent$iv3, target$iv3);
                        }
                    }
                }
            } else {
                OuroNode.Selectable last2 = (OuroNode.Selectable) CollectionsKt.lastOrNull(selectables);
                if (last2 != null && OuroNodeUtilsKt.isSeparable(last2) && selectableContainsPoint(nodeStorage, last2, selection.getEnd()) && (replacement = (OuroNode.Separable) CollectionsKt.firstOrNull(((OuroNode.Separable) last2).separate(selection.getEnd().getOffset()))) != null) {
                    NodeStorageBuilder $this$replace$iv4 = newDocument;
                    OuroNode.Selectable source$iv4 = last2;
                    OuroNode target$iv4 = replacement;
                    OuroNode.Parent parent$iv4 = $this$replace$iv4.getParent(source$iv4);
                    if (parent$iv4 != null && (indexInSiblings = $this$replace$iv4.getIndexInSiblings(source$iv4)) != null) {
                        int indexInParent$iv4 = indexInSiblings.intValue();
                        $this$replace$iv4.removeFromParent(source$iv4);
                        $this$replace$iv4.add(parent$iv4, indexInParent$iv4, target$iv4);
                    }
                }
            }
        }
        return newDocument;
    }

    public static final void deleteSingleStructurePath(OuroNodeMutableStorage<OuroDocument> ouroNodeMutableStorage) {
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        List<OuroNode> children = ouroNodeMutableStorage.getChildren(ouroNodeMutableStorage.getRoot());
        OuroNode ouroNode = children != null ? (OuroNode) CollectionsKt.first(children) : null;
        OuroNode.Parent node = ouroNode instanceof OuroNode.Parent ? (OuroNode.Parent) ouroNode : null;
        while (true) {
            boolean z = true;
            if (node != null && isStructureNode(node)) {
                List<OuroNode> siblings = ouroNodeMutableStorage.getSiblings(node);
                if ((siblings != null ? (OuroNode) CollectionsKt.singleOrNull(siblings) : null) != null) {
                    List<OuroNode> children2 = ouroNodeMutableStorage.getChildren(node);
                    OuroNode ouroNode2 = children2 != null ? (OuroNode) CollectionsKt.first(children2) : null;
                    node = ouroNode2 instanceof OuroNode.Parent ? (OuroNode.Parent) ouroNode2 : null;
                } else {
                    return;
                }
            } else {
                List<OuroNode> siblings2 = node != null ? ouroNodeMutableStorage.getSiblings(node) : null;
                List<OuroNode> list = siblings2;
                if (list != null && !list.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    ouroNodeMutableStorage.removeAllChildren(ouroNodeMutableStorage.getRoot());
                    ouroNodeMutableStorage.add(ouroNodeMutableStorage.getRoot(), siblings2);
                    return;
                }
                return;
            }
        }
    }

    private static final boolean isStructureNode(OuroNode $this$isStructureNode) {
        return ($this$isStructureNode instanceof OuroList) || ($this$isStructureNode instanceof OuroListItem) || ($this$isStructureNode instanceof OuroQuoteBlock) || ($this$isStructureNode instanceof OuroDocument);
    }

    public static final /* synthetic */ <T extends OuroNode> void replace(OuroNodeMutableStorage<OuroDocument> ouroNodeMutableStorage, T t, T t2) {
        Integer indexInSiblings;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(t, "source");
        Intrinsics.checkNotNullParameter(t2, "target");
        OuroNode.Parent parent = ouroNodeMutableStorage.getParent(t);
        if (parent == null || (indexInSiblings = ouroNodeMutableStorage.getIndexInSiblings(t)) == null) {
            return;
        }
        int indexInParent = indexInSiblings.intValue();
        ouroNodeMutableStorage.removeFromParent(t);
        ouroNodeMutableStorage.add(parent, indexInParent, t2);
    }

    public static final boolean selectableContainsPoint(OuroNodeStorage<OuroDocument> ouroNodeStorage, OuroNode.Selectable selectable, OuroPoint point) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(point, "point");
        if (point.isInside()) {
            int index = point.getIndex();
            List $this$indexOfFirst$iv = ouroNodeStorage.getAllSelectables();
            int index$iv = 0;
            Iterator<OuroNode.Selectable> it = $this$indexOfFirst$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object item$iv = it.next();
                    OuroNode.Selectable it2 = (OuroNode.Selectable) item$iv;
                    if (Intrinsics.areEqual(it2, selectable)) {
                        break;
                    }
                    index$iv++;
                } else {
                    index$iv = -1;
                    break;
                }
            }
            return index == index$iv && OuroNodeUtilsKt.isSeparable(selectable) && point.getOffset() > 0 && point.getOffset() < ((OuroNode.Separable) selectable).getLength();
        }
        return false;
    }

    private static final void addPathToRoot(OuroNodeStorage<OuroDocument> ouroNodeStorage, OuroNode node, NodeStorageBuilder<OuroDocument> nodeStorageBuilder) {
        List<OuroNode> list;
        OuroNode.Parent parent = node;
        OuroNode.Parent parent2 = ouroNodeStorage.getParent(node);
        while (parent2 != null) {
            nodeStorageBuilder.getParentMap().put(parent, parent2);
            if (nodeStorageBuilder.getChildrenMap().get(parent2) == null) {
                nodeStorageBuilder.getChildrenMap().put(parent2, new ArrayList());
            }
            Iterable iterable = (List) nodeStorageBuilder.getChildrenMap().get(parent2);
            Object obj = null;
            if (iterable != null) {
                Iterable $this$firstOrNull$iv = iterable;
                Iterator<T> it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object element$iv = it.next();
                    OuroNode it2 = (OuroNode) element$iv;
                    if (Intrinsics.areEqual(it2, parent)) {
                        obj = element$iv;
                        break;
                    }
                }
                obj = (OuroNode) obj;
            }
            if (obj == null && (list = nodeStorageBuilder.getChildrenMap().get(parent2)) != null) {
                list.add(parent);
            }
            parent = parent2;
            parent2 = ouroNodeStorage.getParent(parent);
        }
    }

    private static final void addAllDescendants(OuroNodeStorage<OuroDocument> ouroNodeStorage, OuroNode node, NodeStorageBuilder<OuroDocument> nodeStorageBuilder) {
        OuroNode.Parent<?> parent = node instanceof OuroNode.Parent ? (OuroNode.Parent) node : null;
        Iterable children = parent != null ? ouroNodeStorage.getChildren(parent) : null;
        if (node instanceof OuroNode.Parent) {
            List<OuroNode> list = (Collection) children;
            if (!(list == null || list.isEmpty())) {
                Iterable $this$forEach$iv = children;
                for (Object element$iv : $this$forEach$iv) {
                    OuroNode child = (OuroNode) element$iv;
                    nodeStorageBuilder.getParentMap().put(child, node);
                    if (nodeStorageBuilder.getChildrenMap().get(node) == null) {
                        nodeStorageBuilder.getChildrenMap().put(node, new ArrayList());
                    }
                    List<OuroNode> list2 = nodeStorageBuilder.getChildrenMap().get(node);
                    if (list2 != null) {
                        list2.add(child);
                    }
                    addAllDescendants(ouroNodeStorage, child, nodeStorageBuilder);
                }
            }
        }
    }

    public static final /* synthetic */ <N extends OuroNode> List<N> collectNodeInParentWithDFS(OuroNodeStorage<?> ouroNodeStorage, OuroNode.Parent<?> parent) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(parent, "parent");
        List nodeList = new ArrayList();
        collectNodes(ouroNodeStorage, parent, nodeList);
        List $this$filterIsInstance$iv = nodeList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            Intrinsics.reifiedOperationMarker(3, "N");
            if (element$iv$iv instanceof Object) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final void collectNodes(OuroNodeStorage<?> ouroNodeStorage, OuroNode node, List<OuroNode> list) {
        Iterable children;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(list, "nodeList");
        list.add(node);
        if (!(node instanceof OuroNode.Parent) || (children = ouroNodeStorage.getChildren((OuroNode.Parent) node)) == null) {
            return;
        }
        Iterable $this$forEach$iv = children;
        for (Object element$iv : $this$forEach$iv) {
            OuroNode it = (OuroNode) element$iv;
            collectNodes(ouroNodeStorage, it, list);
        }
    }

    public static final OuroTextRange getTextRangeAfter(OuroNodeStorage<?> ouroNodeStorage, OuroNode.Selectable selectable, Function2<? super OuroNodeStorage<?>, ? super OuroNode.Selectable, Integer> function2) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(function2, "displayLengthTransform");
        int pos = 0;
        Iterable $this$any$iv = ouroNodeStorage.getAllSelectables();
        boolean z = false;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator<T> it = $this$any$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                OuroNode.Selectable it2 = (OuroNode.Selectable) element$iv;
                pos += ((Number) function2.invoke(ouroNodeStorage, it2)).intValue();
                if (Intrinsics.areEqual(it2, selectable)) {
                    z = true;
                    break;
                }
            }
        }
        boolean hasResult = z;
        if ((hasResult ? ouroNodeStorage : null) != null) {
            return new OuroTextRange(pos);
        }
        return null;
    }

    public static final OuroTextRange getTextRangeBefore(OuroNodeStorage<?> ouroNodeStorage, OuroNode.Selectable selectable, Function2<? super OuroNodeStorage<?>, ? super OuroNode.Selectable, Integer> function2) {
        OuroNode.Selectable it;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(function2, "displayLengthTransform");
        int pos = 0;
        Iterable $this$any$iv = ouroNodeStorage.getAllSelectables();
        boolean z = false;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator<T> it2 = $this$any$iv.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object element$iv = it2.next();
                OuroNode.Selectable it3 = (OuroNode.Selectable) element$iv;
                if (Intrinsics.areEqual(it3, selectable)) {
                    it = 1;
                    continue;
                } else {
                    pos += ((Number) function2.invoke(ouroNodeStorage, it3)).intValue();
                    it = null;
                    continue;
                }
                if (it != null) {
                    z = true;
                    break;
                }
            }
        }
        boolean hasResult = z;
        if ((hasResult ? ouroNodeStorage : null) != null) {
            return new OuroTextRange(pos);
        }
        return null;
    }
}