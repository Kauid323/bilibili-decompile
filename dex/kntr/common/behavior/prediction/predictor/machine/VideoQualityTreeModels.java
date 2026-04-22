package kntr.common.behavior.prediction.predictor.machine;

import java.util.ArrayList;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoQualityTreeModels.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¨\u0006\r"}, d2 = {"Lkntr/common/behavior/prediction/predictor/machine/VideoQualityTreeModels;", "", "<init>", "()V", "tree0", "", "input", "", "tree1", "tree2", "tree3", "tree4", "predictAll", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VideoQualityTreeModels {
    private final double tree0(List<Double> list) {
        if (list.get(71).doubleValue() <= 48.0d) {
            if (list.get(63).doubleValue() <= 24.0d) {
                if (list.get(74).doubleValue() <= 1.5d) {
                    if (list.get(72).doubleValue() <= 0.8959999978542328d) {
                        if (list.get(63).doubleValue() <= 8.0d) {
                            return 0.07581802715402672d;
                        }
                        if (list.get(71).doubleValue() <= 24.0d) {
                            return 0.9963610488464625d;
                        }
                        return 0.25025515796409714d;
                    } else if (list.get(63).doubleValue() > 8.0d) {
                        if (list.get(58).doubleValue() <= 1.5d) {
                            if (list.get(64).doubleValue() <= 3.8604999780654907d) {
                                if (list.get(69).doubleValue() <= 24.0d) {
                                    if (list.get(61).doubleValue() <= 24.0d) {
                                        if (list.get(71).doubleValue() <= 24.0d) {
                                            if (list.get(72).doubleValue() <= 3.8394999504089355d) {
                                                if (list.get(72).doubleValue() <= 2.9700000286102295d) {
                                                    return 0.9286619094496518d;
                                                }
                                                return 0.6449314784965452d;
                                            }
                                            return 0.30504777948515865d;
                                        }
                                        return 0.05899339309057758d;
                                    } else if (list.get(72).doubleValue() <= 4.350499868392944d) {
                                        return 0.03238455224822716d;
                                    } else {
                                        if (list.get(71).doubleValue() <= 8.0d) {
                                            return 0.27733221623488913d;
                                        }
                                        return 0.09118470890405571d;
                                    }
                                } else if (list.get(72).doubleValue() <= 4.599999904632568d) {
                                    if (list.get(71).doubleValue() <= 8.0d) {
                                        return 0.07746219005993005d;
                                    }
                                    if (list.get(71).doubleValue() <= 24.0d) {
                                        if (list.get(55).doubleValue() <= 8.0d) {
                                            if (list.get(64).doubleValue() <= 2.25d) {
                                                if (list.get(72).doubleValue() <= 1.7005000114440918d) {
                                                    return 0.8361151485607542d;
                                                }
                                                if (list.get(61).doubleValue() <= 72.0d) {
                                                    if (list.get(64).doubleValue() <= 1.8690000176429749d) {
                                                        return 0.3523237925233706d;
                                                    }
                                                    return 0.5931541345842922d;
                                                }
                                                return 0.13164821246566324d;
                                            } else if (list.get(61).doubleValue() <= 72.0d) {
                                                return 0.7815849013005693d;
                                            } else {
                                                if (list.get(64).doubleValue() <= 2.740499973297119d) {
                                                    return 0.41227042158706145d;
                                                }
                                                return 0.7097330054356938d;
                                            }
                                        } else if (list.get(55).doubleValue() <= 24.0d) {
                                            return 0.9054051513794893d;
                                        } else {
                                            if (list.get(64).doubleValue() <= 3.020500063896179d) {
                                                return 0.27826895057796475d;
                                            }
                                            return 0.5694092573303925d;
                                        }
                                    } else if (list.get(64).doubleValue() <= 3.068000078201294d) {
                                        return 0.0905932857065325d;
                                    } else {
                                        return 0.4433582626364153d;
                                    }
                                } else if (list.get(69).doubleValue() <= 48.0d) {
                                    return 0.1540680276408764d;
                                } else {
                                    return 0.0575661259055731d;
                                }
                            } else if (list.get(55).doubleValue() <= 48.0d) {
                                if (list.get(69).doubleValue() <= 24.0d) {
                                    if (list.get(61).doubleValue() > 48.0d) {
                                        if (list.get(56).doubleValue() <= 5.700000047683716d) {
                                            if (list.get(72).doubleValue() <= 12.944499969482422d) {
                                                return 0.11359287082525728d;
                                            }
                                            return 0.22437413456945626d;
                                        } else if (list.get(53).doubleValue() > 24.0d) {
                                            if (list.get(47).doubleValue() <= 72.0d) {
                                                if (list.get(39).doubleValue() <= 48.0d) {
                                                    return 0.373017083783505d;
                                                }
                                                return 0.1780070437735765d;
                                            }
                                            return 0.12807102568456302d;
                                        } else {
                                            return 0.6633706078565585d;
                                        }
                                    } else if (list.get(53).doubleValue() <= 24.0d) {
                                        if (list.get(56).doubleValue() > 4.2834999561309814d) {
                                            if (list.get(47).doubleValue() <= 24.0d) {
                                                if (list.get(37).doubleValue() <= 24.0d) {
                                                    return 0.7897141797522597d;
                                                }
                                                return 0.6268402622391498d;
                                            }
                                            return 0.4612570808812857d;
                                        } else if (list.get(71).doubleValue() <= 24.0d) {
                                            if (list.get(71).doubleValue() <= 8.0d) {
                                                if (list.get(61).doubleValue() <= 24.0d) {
                                                    return 0.649227292098872d;
                                                }
                                                if (list.get(72).doubleValue() <= 10.921000003814697d) {
                                                    return 0.32162379382917d;
                                                }
                                                return 0.5386298405165648d;
                                            }
                                            return 0.8257639354730888d;
                                        } else if (list.get(64).doubleValue() <= 5.867500066757202d) {
                                            return 0.29398925256240555d;
                                        } else {
                                            return 0.4623314638775361d;
                                        }
                                    } else if (list.get(47).doubleValue() <= 72.0d) {
                                        if (list.get(55).doubleValue() <= 24.0d) {
                                            if (list.get(71).doubleValue() <= 24.0d) {
                                                if (list.get(71).doubleValue() <= 8.0d) {
                                                    return 0.4595591641425227d;
                                                }
                                                return 0.8270464734014852d;
                                            } else if (list.get(64).doubleValue() <= 11.156499862670898d) {
                                                return 0.17888822699036808d;
                                            } else {
                                                return 0.3757848918804874d;
                                            }
                                        }
                                        return 0.2863867632587425d;
                                    } else {
                                        return 0.17801810690709194d;
                                    }
                                } else if (list.get(55).doubleValue() <= 24.0d) {
                                    if (list.get(47).doubleValue() <= 48.0d) {
                                        if (list.get(71).doubleValue() <= 24.0d) {
                                            if (list.get(71).doubleValue() <= 8.0d) {
                                                return 0.41321192538307516d;
                                            }
                                            if (list.get(69).doubleValue() <= 100.0d) {
                                                if (list.get(72).doubleValue() <= 7.22350001335144d) {
                                                    return 0.9003990955027691d;
                                                }
                                                if (list.get(64).doubleValue() > 7.388999938964844d) {
                                                    if (list.get(39).doubleValue() <= 24.0d) {
                                                        if (list.get(66).doubleValue() <= 1.5d) {
                                                            if (list.get(47).doubleValue() <= 24.0d) {
                                                                if (list.get(55).doubleValue() <= 8.0d) {
                                                                    return 0.7398476216942071d;
                                                                }
                                                                return 0.8990675157125471d;
                                                            }
                                                            return 0.6009936935236949d;
                                                        }
                                                        return 0.4303443192256964d;
                                                    }
                                                    return 0.6207823277164409d;
                                                }
                                                return 0.153566777078797d;
                                            } else if (list.get(64).doubleValue() <= 4.959499835968018d) {
                                                return 0.5589687782952464d;
                                            } else {
                                                return 0.8910984844309244d;
                                            }
                                        }
                                        return 0.4461760339152701d;
                                    } else if (list.get(55).doubleValue() <= 8.0d) {
                                        return 0.2364473230106038d;
                                    } else {
                                        if (list.get(71).doubleValue() <= 8.0d) {
                                            return 0.10537667904836348d;
                                        }
                                        if (list.get(71).doubleValue() <= 24.0d) {
                                            if (list.get(47).doubleValue() <= 72.0d) {
                                                return 0.5359869236823371d;
                                            }
                                            return 0.7578298049779879d;
                                        }
                                        return 0.27029503824821904d;
                                    }
                                } else if (list.get(72).doubleValue() <= 8.914499759674072d) {
                                    return 0.4816555608578445d;
                                } else {
                                    if (list.get(64).doubleValue() <= 9.210000038146973d) {
                                        return 0.06782194904367045d;
                                    }
                                    return 0.3839918821189861d;
                                }
                            } else if (list.get(69).doubleValue() <= 24.0d) {
                                if (list.get(55).doubleValue() <= 72.0d) {
                                    if (list.get(53).doubleValue() <= 48.0d) {
                                        return 0.26961091323612213d;
                                    }
                                    return 0.12125603810164912d;
                                }
                                return 0.06577276104648458d;
                            } else if (list.get(71).doubleValue() <= 8.0d) {
                                return 0.07727167988637557d;
                            } else {
                                if (list.get(71).doubleValue() <= 24.0d) {
                                    if (list.get(55).doubleValue() <= 72.0d) {
                                        if (list.get(72).doubleValue() <= 10.25d) {
                                            return 0.5426778610255031d;
                                        }
                                        if (list.get(64).doubleValue() <= 10.308000087738037d) {
                                            return 0.028310158460674126d;
                                        }
                                        if (list.get(72).doubleValue() <= 12.473000049591064d) {
                                            return 0.5112884039438378d;
                                        }
                                        return 0.2719672940651106d;
                                    } else if (list.get(72).doubleValue() <= 11.220499992370605d) {
                                        return 0.7633445510883694d;
                                    } else {
                                        return 0.5307928155731269d;
                                    }
                                }
                                return 0.16603106716245017d;
                            }
                        } else if (list.get(66).doubleValue() <= 1.5d) {
                            if (list.get(69).doubleValue() <= 24.0d) {
                                if (list.get(32).doubleValue() <= 5.809499979019165d) {
                                    if (list.get(71).doubleValue() <= 8.0d) {
                                        return 0.04344525973035491d;
                                    }
                                    if (list.get(71).doubleValue() <= 24.0d) {
                                        return 0.6009422986197376d;
                                    }
                                    if (list.get(61).doubleValue() <= 48.0d) {
                                        return 0.19929804209713564d;
                                    }
                                    return 0.05204301790121316d;
                                } else if (list.get(53).doubleValue() <= 24.0d) {
                                    if (list.get(55).doubleValue() <= 48.0d) {
                                        if (list.get(42).doubleValue() <= 1.5d) {
                                            return 0.7084231388933481d;
                                        }
                                        return 0.3224514353350969d;
                                    }
                                    return 0.15731517047791455d;
                                } else {
                                    return 0.1327889735343372d;
                                }
                            } else if (list.get(71).doubleValue() <= 8.0d) {
                                return 0.061309716414859605d;
                            } else {
                                if (list.get(71).doubleValue() <= 24.0d) {
                                    if (list.get(55).doubleValue() <= 24.0d) {
                                        return 0.6960830587258732d;
                                    }
                                    return 0.37014169591165397d;
                                }
                                return 0.32242390490660255d;
                            }
                        } else {
                            return 0.029379122434271935d;
                        }
                    } else if (list.get(66).doubleValue() <= 1.5d) {
                        if (list.get(71).doubleValue() <= 8.0d) {
                            return 0.05081807177399445d;
                        }
                        if (list.get(64).doubleValue() <= 4.630000114440918d) {
                            if (list.get(72).doubleValue() <= 4.619999885559082d) {
                                return 0.12461692097415905d;
                            }
                            return 0.01932823082638748d;
                        } else if (list.get(55).doubleValue() <= 48.0d) {
                            if (list.get(53).doubleValue() > 8.0d) {
                                if (list.get(47).doubleValue() <= 24.0d) {
                                    if (list.get(69).doubleValue() <= 24.0d) {
                                        return 0.21564744722289503d;
                                    }
                                    if (list.get(55).doubleValue() <= 24.0d) {
                                        if (list.get(71).doubleValue() <= 24.0d) {
                                            if (list.get(47).doubleValue() <= 8.0d) {
                                                return 0.47213138836099916d;
                                            }
                                            return 0.7087626674685201d;
                                        } else if (list.get(55).doubleValue() <= 8.0d) {
                                            return 0.12390621026105464d;
                                        } else {
                                            return 0.445811136775384d;
                                        }
                                    } else if (list.get(71).doubleValue() <= 24.0d) {
                                        return 0.1766656804815977d;
                                    } else {
                                        return 0.40146787277418167d;
                                    }
                                }
                                return 0.21790851851457546d;
                            } else if (list.get(61).doubleValue() <= 24.0d) {
                                if (list.get(69).doubleValue() <= 24.0d) {
                                    return 0.09349764087522393d;
                                }
                                return 0.411377183318347d;
                            } else {
                                return 0.1252075876221319d;
                            }
                        } else if (list.get(69).doubleValue() <= 24.0d) {
                            return 0.013037741423985826d;
                        } else {
                            return 0.11703918843162521d;
                        }
                    } else {
                        return 0.009444931589440748d;
                    }
                } else if (list.get(63).doubleValue() > 8.0d) {
                    if (list.get(41).doubleValue() > 0.5d) {
                        if (list.get(47).doubleValue() > 24.0d) {
                            if (list.get(45).doubleValue() <= 24.0d) {
                                if (list.get(42).doubleValue() <= 1.5d) {
                                    return 0.7431932941334645d;
                                }
                                if (list.get(55).doubleValue() <= 24.0d) {
                                    return 0.6752510277199962d;
                                }
                                return 0.5052349958652568d;
                            } else if (list.get(55).doubleValue() <= 24.0d) {
                                if (list.get(55).doubleValue() <= 8.0d) {
                                    if (list.get(66).doubleValue() <= 1.5d) {
                                        return 0.6150625398857337d;
                                    }
                                    return 0.2467905133927599d;
                                } else if (list.get(71).doubleValue() <= 24.0d) {
                                    if (list.get(72).doubleValue() <= 8.127500057220459d) {
                                        return 0.810941094560774d;
                                    }
                                    if (list.get(64).doubleValue() <= 8.427000045776367d) {
                                        return 0.09205334216578683d;
                                    }
                                    if (list.get(71).doubleValue() <= 8.0d) {
                                        if (list.get(66).doubleValue() <= 1.5d) {
                                            return 0.8519515720506509d;
                                        }
                                        return 0.30690710385804815d;
                                    }
                                    return 0.7041679332288762d;
                                } else {
                                    return 0.37966671079571235d;
                                }
                            } else if (list.get(71).doubleValue() <= 8.0d) {
                                if (list.get(66).doubleValue() <= 1.5d) {
                                    return 0.4351619612695514d;
                                }
                                return 0.10686157916885956d;
                            } else if (list.get(71).doubleValue() <= 24.0d) {
                                if (list.get(72).doubleValue() <= 6.802000045776367d) {
                                    return 0.7512822913066033d;
                                }
                                if (list.get(64).doubleValue() <= 7.196000099182129d) {
                                    return 0.057273214083662344d;
                                }
                                if (list.get(55).doubleValue() <= 72.0d) {
                                    return 0.40201412684937715d;
                                }
                                return 0.6418939659614926d;
                            } else if (list.get(55).doubleValue() <= 72.0d) {
                                if (list.get(61).doubleValue() <= 48.0d) {
                                    return 0.3910234019567101d;
                                }
                                return 0.23921489930897952d;
                            } else {
                                return 0.11454538663184384d;
                            }
                        } else if (list.get(55).doubleValue() <= 48.0d) {
                            if (list.get(72).doubleValue() > 6.05649995803833d) {
                                if (list.get(56).doubleValue() > 5.757499933242798d) {
                                    if (list.get(31).doubleValue() <= 24.0d) {
                                        if (list.get(31).doubleValue() <= 8.0d) {
                                            if (list.get(29).doubleValue() <= 24.0d) {
                                                return 0.8049204209188145d;
                                            }
                                            return 0.5343358489714326d;
                                        }
                                        return 0.9163502654051419d;
                                    } else if (list.get(29).doubleValue() <= 24.0d) {
                                        return 0.8488427820987602d;
                                    } else {
                                        return 0.6504637715203451d;
                                    }
                                } else if (list.get(53).doubleValue() <= 48.0d) {
                                    return 0.5227018140400392d;
                                } else {
                                    return 0.26601485015989423d;
                                }
                            } else if (list.get(71).doubleValue() <= 8.0d) {
                                return 0.5072389892431803d;
                            } else {
                                if (list.get(71).doubleValue() <= 24.0d) {
                                    return 0.9784526325783993d;
                                }
                                return 0.6486860528392228d;
                            }
                        } else if (list.get(66).doubleValue() > 1.5d) {
                            if (list.get(47).doubleValue() <= 8.0d) {
                                if (list.get(69).doubleValue() <= 48.0d) {
                                    return 0.1722862935506296d;
                                }
                                return 0.523367547953967d;
                            }
                            return 0.5604986694191993d;
                        } else if (list.get(69).doubleValue() <= 24.0d) {
                            return 0.8731797327485832d;
                        } else {
                            return 0.3249022575134101d;
                        }
                    } else if (list.get(72).doubleValue() <= 1.2425000071525574d) {
                        if (list.get(71).doubleValue() <= 24.0d) {
                            return 0.9903979302854d;
                        }
                        return 0.26730121366147486d;
                    } else if (list.get(64).doubleValue() <= 8.026000022888184d) {
                        if (list.get(69).doubleValue() <= 24.0d) {
                            if (list.get(61).doubleValue() <= 24.0d) {
                                if (list.get(71).doubleValue() <= 24.0d) {
                                    if (list.get(72).doubleValue() <= 9.236500263214111d) {
                                        return 0.8159248176159273d;
                                    }
                                    return 0.36453496793220785d;
                                }
                                return 0.2649907340797094d;
                            } else if (list.get(72).doubleValue() <= 4.400500059127808d) {
                                if (list.get(67).doubleValue() <= 0.5d) {
                                    if (list.get(71).doubleValue() <= 24.0d) {
                                        return 0.8537738670905431d;
                                    }
                                    return 0.05344601991501721d;
                                }
                                return 0.04883219783398653d;
                            } else if (list.get(71).doubleValue() <= 24.0d) {
                                if (list.get(72).doubleValue() <= 8.056500434875488d) {
                                    if (list.get(61).doubleValue() <= 72.0d) {
                                        return 0.39931284990396104d;
                                    }
                                    return 0.13362627542798325d;
                                }
                                return 0.42020940914460014d;
                            } else if (list.get(64).doubleValue() <= 3.156499981880188d) {
                                return 0.13032128852350933d;
                            } else {
                                if (list.get(61).doubleValue() <= 48.0d) {
                                    return 0.34965864645147865d;
                                }
                                return 0.19047517292660202d;
                            }
                        } else if (list.get(72).doubleValue() <= 5.773000001907349d) {
                            if (list.get(64).doubleValue() <= 1.8690000176429749d) {
                                if (list.get(71).doubleValue() <= 24.0d) {
                                    if (list.get(71).doubleValue() <= 8.0d) {
                                        return 0.14399182132238106d;
                                    }
                                    if (list.get(72).doubleValue() <= 2.25d) {
                                        return 0.8288190888531636d;
                                    }
                                    if (list.get(61).doubleValue() <= 72.0d) {
                                        return 0.6887196353608114d;
                                    }
                                    return 0.2261118119405139d;
                                }
                                return 0.16558349639261988d;
                            } else if (list.get(71).doubleValue() <= 8.0d) {
                                return 0.25844221143681256d;
                            } else {
                                if (list.get(71).doubleValue() <= 24.0d) {
                                    if (list.get(61).doubleValue() <= 72.0d) {
                                        return 0.9243529267187388d;
                                    }
                                    if (list.get(64).doubleValue() <= 2.802999973297119d) {
                                        if (list.get(72).doubleValue() <= 3.481500029563904d) {
                                            return 0.8003172289124496d;
                                        }
                                        return 0.31715815082976695d;
                                    }
                                    return 0.9204051186298502d;
                                }
                                return 0.472512020628051d;
                            }
                        } else if (list.get(64).doubleValue() <= 5.267999887466431d) {
                            if (list.get(69).doubleValue() <= 72.0d) {
                                return 0.17294014534413332d;
                            }
                            return 0.06784812555736748d;
                        } else if (list.get(72).doubleValue() <= 8.174499988555908d) {
                            return 0.6906280908243436d;
                        } else {
                            return 0.28040373092517257d;
                        }
                    } else if (list.get(66).doubleValue() <= 1.5d) {
                        if (list.get(53).doubleValue() <= 24.0d) {
                            return 0.874750846241777d;
                        }
                        if (list.get(55).doubleValue() <= 48.0d) {
                            return 0.7572202914953232d;
                        }
                        return 0.4105574158164336d;
                    } else if (list.get(69).doubleValue() <= 24.0d) {
                        if (list.get(61).doubleValue() <= 48.0d) {
                            if (list.get(71).doubleValue() <= 8.0d) {
                                return 0.34655790339749537d;
                            }
                            if (list.get(71).doubleValue() <= 24.0d) {
                                return 0.8923777307530767d;
                            }
                            if (list.get(53).doubleValue() <= 24.0d) {
                                if (list.get(56).doubleValue() <= 2.524999976158142d) {
                                    return 0.5510246079643711d;
                                }
                                return 0.8345778086000964d;
                            } else if (list.get(55).doubleValue() <= 48.0d) {
                                return 0.45108390853584157d;
                            } else {
                                return 0.08709552133399429d;
                            }
                        } else if (list.get(72).doubleValue() <= 11.821000099182129d) {
                            if (list.get(71).doubleValue() <= 8.0d) {
                                return 0.09221630140662175d;
                            }
                            if (list.get(71).doubleValue() <= 24.0d) {
                                return 0.8456950671970844d;
                            }
                            return 0.20003672906654482d;
                        } else if (list.get(53).doubleValue() <= 24.0d) {
                            if (list.get(56).doubleValue() <= 2.8765000104904175d) {
                                if (list.get(64).doubleValue() <= 11.837500095367432d) {
                                    return 0.5492913573980331d;
                                }
                                if (list.get(72).doubleValue() <= 12.723999977111816d) {
                                    return 0.16052008388297898d;
                                }
                                if (list.get(64).doubleValue() <= 12.729000091552734d) {
                                    return 0.5839834290423563d;
                                }
                                return 0.305393651754667d;
                            }
                            return 0.5590124973495092d;
                        } else if (list.get(55).doubleValue() <= 48.0d) {
                            return 0.3728368450637634d;
                        } else {
                            return 0.11296482694331858d;
                        }
                    } else if (list.get(55).doubleValue() <= 24.0d) {
                        return 0.8063985405148555d;
                    } else {
                        if (list.get(71).doubleValue() > 8.0d) {
                            if (list.get(50).doubleValue() <= 1.5d) {
                                return 0.6840649689164232d;
                            }
                            return 0.4970959160390623d;
                        }
                        return 0.17373843034147285d;
                    }
                } else if (list.get(64).doubleValue() <= 9.491499900817871d) {
                    if (list.get(72).doubleValue() <= 8.456500053405762d) {
                        if (list.get(69).doubleValue() <= 48.0d) {
                            if (list.get(64).doubleValue() <= 4.749000072479248d) {
                                return 0.08110954437426894d;
                            }
                            if (list.get(71).doubleValue() <= 8.0d) {
                                return 0.0799620066718054d;
                            }
                            return 0.40935609759396635d;
                        } else if (list.get(55).doubleValue() <= 48.0d) {
                            if (list.get(64).doubleValue() <= 2.802999973297119d) {
                                return 0.2302078693304527d;
                            }
                            return 0.42828999377609595d;
                        } else {
                            return 0.13206342682307265d;
                        }
                    }
                    return 0.05833879053130142d;
                } else if (list.get(61).doubleValue() <= 24.0d) {
                    if (list.get(55).doubleValue() <= 48.0d) {
                        if (list.get(58).doubleValue() > 1.5d) {
                            if (list.get(39).doubleValue() <= 24.0d) {
                                return 0.5305393685027957d;
                            }
                            return 0.25691882458015053d;
                        }
                        return 0.6626812678906967d;
                    }
                    return 0.11435717217589594d;
                } else if (list.get(71).doubleValue() <= 8.0d) {
                    return 0.07652785758952338d;
                } else {
                    if (list.get(53).doubleValue() <= 24.0d) {
                        return 0.3545073610794461d;
                    }
                    if (list.get(55).doubleValue() <= 48.0d) {
                        return 0.32900043647686367d;
                    }
                    return 0.1998561435148289d;
                }
            } else if (list.get(74).doubleValue() <= 1.5d) {
                if (list.get(66).doubleValue() <= 1.5d) {
                    if (list.get(71).doubleValue() <= 8.0d) {
                        if (list.get(69).doubleValue() <= 24.0d) {
                            if (list.get(69).doubleValue() <= 8.0d) {
                                return 0.01459968017749318d;
                            }
                            if (list.get(64).doubleValue() <= 5.909499883651733d) {
                                return 0.057670522651459166d;
                            }
                            if (list.get(63).doubleValue() <= 100.0d) {
                                if (list.get(31).doubleValue() <= 24.0d) {
                                    if (list.get(73).doubleValue() <= 4.5d) {
                                        if (list.get(65).doubleValue() <= 4.5d) {
                                            return 0.28887111669623167d;
                                        }
                                        return 0.06991977066071849d;
                                    } else if (list.get(65).doubleValue() > 4.5d) {
                                        if (list.get(56).doubleValue() <= 4.762500047683716d) {
                                            return 0.49713280135296095d;
                                        }
                                        return 0.31468512292241796d;
                                    } else {
                                        return 0.12187814221326862d;
                                    }
                                }
                                return 0.11545614524694493d;
                            }
                            return 0.13683644061516456d;
                        } else if (list.get(61).doubleValue() <= 24.0d) {
                            if (list.get(61).doubleValue() > 8.0d) {
                                if (list.get(47).doubleValue() <= 72.0d) {
                                    if (list.get(56).doubleValue() <= 8.78499984741211d) {
                                        return 0.12592010669281664d;
                                    }
                                    return 0.19976591045016986d;
                                }
                                return 0.04966202557966337d;
                            }
                            return 0.006373845602263811d;
                        } else if (list.get(63).doubleValue() <= 48.0d) {
                            if (list.get(61).doubleValue() <= 48.0d) {
                                if (list.get(72).doubleValue() <= 2.8615000247955322d) {
                                    return 0.2738821379615959d;
                                }
                                return 0.1174210173498419d;
                            }
                            return 0.0328770101461133d;
                        } else if (list.get(63).doubleValue() <= 100.0d) {
                            return 0.026238108174422715d;
                        } else {
                            return 0.006225471237350019d;
                        }
                    } else if (list.get(71).doubleValue() <= 24.0d) {
                        if (list.get(72).doubleValue() <= 2.25d) {
                            if (list.get(72).doubleValue() <= 1.8690000176429749d) {
                                return 0.6915623259808973d;
                            }
                            if (list.get(64).doubleValue() <= 1.8690000176429749d) {
                                return 0.32436363477565683d;
                            }
                            return 0.7554778616737436d;
                        } else if (list.get(69).doubleValue() <= 24.0d) {
                            if (list.get(61).doubleValue() <= 8.0d) {
                                return 0.854822286005531d;
                            }
                            if (list.get(72).doubleValue() <= 11.0d) {
                                return 0.527657748000938d;
                            }
                            return 0.2782588346084727d;
                        } else if (list.get(69).doubleValue() <= 72.0d) {
                            if (list.get(64).doubleValue() <= 3.384000062942505d) {
                                if (list.get(72).doubleValue() <= 3.7494999170303345d) {
                                    if (list.get(47).doubleValue() <= 8.0d) {
                                        return 0.10209133213754955d;
                                    }
                                    return 0.2763787105251404d;
                                }
                                return 0.023075176618554766d;
                            } else if (list.get(72).doubleValue() <= 8.415499687194824d) {
                                if (list.get(63).doubleValue() <= 48.0d) {
                                    if (list.get(55).doubleValue() <= 48.0d) {
                                        if (list.get(55).doubleValue() <= 24.0d) {
                                            if (list.get(69).doubleValue() <= 48.0d) {
                                                return 0.22687317742408253d;
                                            }
                                            return 0.6400214756193402d;
                                        }
                                        return 0.6585376815229365d;
                                    }
                                    return 0.15591711913563996d;
                                }
                                return 0.183289024542427d;
                            } else if (list.get(64).doubleValue() <= 8.38450002670288d) {
                                return 0.012707440625961694d;
                            } else {
                                if (list.get(72).doubleValue() <= 12.119500160217285d) {
                                    return 0.18840847288649468d;
                                }
                                if (list.get(64).doubleValue() > 12.147500038146973d) {
                                    if (list.get(47).doubleValue() <= 24.0d) {
                                        if (list.get(55).doubleValue() <= 72.0d) {
                                            return 0.16896973498545673d;
                                        }
                                        return 0.10026112954857971d;
                                    }
                                    return 0.10317164235872835d;
                                }
                                return 0.028078619768788494d;
                            }
                        } else if (list.get(72).doubleValue() <= 7.73199987411499d) {
                            if (list.get(64).doubleValue() <= 2.441499948501587d) {
                                if (list.get(72).doubleValue() <= 2.8615000247955322d) {
                                    return 0.30653189214954685d;
                                }
                                return 0.09459523249250057d;
                            } else if (list.get(63).doubleValue() <= 48.0d) {
                                return 0.5646389073638314d;
                            } else {
                                if (list.get(61).doubleValue() <= 24.0d) {
                                    return 0.5611204995955454d;
                                }
                                if (list.get(72).doubleValue() > 2.6734999418258667d) {
                                    if (list.get(51).doubleValue() > 0.5d) {
                                        if (list.get(56).doubleValue() <= 0.5494999885559082d) {
                                            return 0.9723475906583998d;
                                        }
                                        return 0.3106135902511851d;
                                    }
                                    return 0.17277337084061395d;
                                }
                                return 0.9671351048681471d;
                            }
                        } else if (list.get(64).doubleValue() <= 7.789499998092651d) {
                            return 0.022550801960669834d;
                        } else {
                            if (list.get(69).doubleValue() <= 100.0d) {
                                if (list.get(63).doubleValue() > 48.0d) {
                                    if (list.get(56).doubleValue() <= 11.053999900817871d) {
                                        return 0.20658866331199588d;
                                    }
                                    return 0.11984941783258662d;
                                }
                                return 0.27381541559882155d;
                            }
                            return 0.2990961312705963d;
                        }
                    } else if (list.get(61).doubleValue() <= 24.0d) {
                        if (list.get(55).doubleValue() <= 24.0d) {
                            if (list.get(69).doubleValue() <= 48.0d) {
                                if (list.get(56).doubleValue() <= 7.372999906539917d) {
                                    return 0.11382855479995631d;
                                }
                                return 0.24889437449629004d;
                            } else if (list.get(72).doubleValue() <= 11.01550006866455d) {
                                if (list.get(51).doubleValue() <= 0.5d) {
                                    if (list.get(61).doubleValue() <= 8.0d) {
                                        return 0.12507911580614745d;
                                    }
                                    return 0.5909863242338742d;
                                }
                                return 0.31136759820777193d;
                            } else if (list.get(56).doubleValue() <= 11.63349962234497d) {
                                if (list.get(52).doubleValue() <= 2.0d) {
                                    return 0.25479528517224326d;
                                }
                                return 0.14924906372429605d;
                            } else {
                                return 0.29987106210250614d;
                            }
                        } else if (list.get(69).doubleValue() <= 48.0d) {
                            return 0.03599666786613845d;
                        } else {
                            return 0.13814788587940827d;
                        }
                    } else if (list.get(72).doubleValue() <= 8.372499942779541d) {
                        if (list.get(69).doubleValue() <= 72.0d) {
                            if (list.get(61).doubleValue() <= 72.0d) {
                                if (list.get(53).doubleValue() <= 24.0d) {
                                    if (list.get(72).doubleValue() <= 1.2425000071525574d) {
                                        return 0.009309355769758387d;
                                    }
                                    if (list.get(72).doubleValue() <= 3.1985000371932983d) {
                                        if (list.get(63).doubleValue() <= 48.0d) {
                                            return 0.08736321688216166d;
                                        }
                                        if (list.get(63).doubleValue() <= 72.0d) {
                                            return 0.42113556231556304d;
                                        }
                                        return 0.1832221208908399d;
                                    } else if (list.get(63).doubleValue() <= 72.0d) {
                                        return 0.17501129507613933d;
                                    } else {
                                        return 0.07194188553008106d;
                                    }
                                }
                                return 0.06547177967222204d;
                            } else if (list.get(72).doubleValue() <= 4.102499961853027d) {
                                if (list.get(69).doubleValue() <= 48.0d) {
                                    return 0.08273780387478438d;
                                }
                                return 0.4172816264633314d;
                            } else {
                                return 0.24123488657758377d;
                            }
                        }
                        return 0.05699979048336852d;
                    } else if (list.get(69).doubleValue() <= 72.0d) {
                        if (list.get(64).doubleValue() <= 8.295499801635742d) {
                            return 0.03614647123111563d;
                        }
                        if (list.get(53).doubleValue() <= 24.0d) {
                            if (list.get(53).doubleValue() <= 8.0d) {
                                return 0.06948124026212474d;
                            }
                            return 0.21762546032914795d;
                        }
                        return 0.06394208044504969d;
                    } else {
                        return 0.02981064605096147d;
                    }
                }
                return 0.0032039742548920173d;
            } else if (list.get(61).doubleValue() <= 24.0d) {
                if (list.get(58).doubleValue() <= 1.5d) {
                    if (list.get(71).doubleValue() <= 24.0d) {
                        if (list.get(63).doubleValue() > 72.0d) {
                            if (list.get(47).doubleValue() <= 48.0d) {
                                if (list.get(71).doubleValue() <= 8.0d) {
                                    if (list.get(61).doubleValue() <= 8.0d) {
                                        return 0.15986316736705383d;
                                    }
                                    return 0.6933286070583058d;
                                } else if (list.get(72).doubleValue() <= 12.236500263214111d) {
                                    return 0.7304674605528514d;
                                } else {
                                    if (list.get(64).doubleValue() <= 12.367499828338623d) {
                                        return 0.24738513753471666d;
                                    }
                                    return 0.5489740757298988d;
                                }
                            }
                            return 0.3138843179528892d;
                        } else if (list.get(71).doubleValue() <= 8.0d) {
                            return 0.6256486925640135d;
                        } else {
                            if (list.get(53).doubleValue() <= 24.0d) {
                                if (list.get(72).doubleValue() <= 12.41450023651123d) {
                                    return 0.5329231066010301d;
                                }
                                if (list.get(64).doubleValue() <= 12.543999671936035d) {
                                    return 0.08861620175962646d;
                                }
                                return 0.4336033448394712d;
                            }
                            return 0.19883535566760283d;
                        }
                    } else if (list.get(55).doubleValue() <= 24.0d) {
                        if (list.get(45).doubleValue() > 24.0d) {
                            if (list.get(56).doubleValue() <= 7.848999977111816d) {
                                return 0.23710553464479744d;
                            }
                            return 0.6601237978015315d;
                        }
                        return 0.7453970926658392d;
                    } else {
                        return 0.45542734582385247d;
                    }
                } else if (list.get(71).doubleValue() <= 24.0d) {
                    if (list.get(47).doubleValue() <= 24.0d) {
                        if (list.get(72).doubleValue() <= 6.2149999141693115d) {
                            if (list.get(71).doubleValue() > 8.0d) {
                                if (list.get(67).doubleValue() <= 16.5d) {
                                    if (list.get(63).doubleValue() <= 72.0d) {
                                        return 0.5774073100366285d;
                                    }
                                    return 0.8466933335195173d;
                                }
                                return 0.39836655145304073d;
                            }
                            return 0.12752918806032226d;
                        } else if (list.get(63).doubleValue() <= 72.0d) {
                            if (list.get(48).doubleValue() <= 4.171000003814697d) {
                                if (list.get(69).doubleValue() <= 24.0d) {
                                    return 0.3861590573564172d;
                                }
                                return 0.10940894276340733d;
                            }
                            return 0.30822608069346547d;
                        } else if (list.get(64).doubleValue() <= 6.463000059127808d) {
                            return 0.12721709070357087d;
                        } else {
                            return 0.34820610583738354d;
                        }
                    }
                    return 0.09227154922790494d;
                } else if (list.get(69).doubleValue() <= 24.0d) {
                    if (list.get(55).doubleValue() <= 24.0d) {
                        return 0.28372977091999935d;
                    }
                    return 0.10499412947928402d;
                } else if (list.get(55).doubleValue() <= 24.0d) {
                    if (list.get(72).doubleValue() > 10.34250020980835d) {
                        if (list.get(56).doubleValue() > 10.580499649047852d) {
                            if (list.get(45).doubleValue() <= 24.0d) {
                                return 0.5231834925810056d;
                            }
                            return 0.4033958804958415d;
                        }
                        return 0.3378483124084118d;
                    }
                    return 0.6059947081040347d;
                } else {
                    return 0.2821739199763557d;
                }
            } else if (list.get(71).doubleValue() <= 8.0d) {
                if (list.get(69).doubleValue() > 24.0d) {
                    if (list.get(58).doubleValue() <= 1.5d) {
                        if (list.get(63).doubleValue() <= 100.0d) {
                            return 0.12674013946028656d;
                        }
                        return 0.049408934869716516d;
                    } else if (list.get(63).doubleValue() <= 48.0d) {
                        return 0.07869478574153924d;
                    } else {
                        return 0.02601113374696657d;
                    }
                }
                return 0.20946974188496617d;
            } else if (list.get(72).doubleValue() > 8.320499897003174d) {
                if (list.get(58).doubleValue() <= 1.5d) {
                    if (list.get(53).doubleValue() > 24.0d) {
                        if (list.get(45).doubleValue() <= 24.0d) {
                            if (list.get(45).doubleValue() <= 8.0d) {
                                return 0.1571661353122674d;
                            }
                            if (list.get(71).doubleValue() <= 24.0d) {
                                return 0.21317747262764897d;
                            }
                            return 0.4691479707315454d;
                        }
                        return 0.13684273608819134d;
                    } else if (list.get(53).doubleValue() <= 8.0d) {
                        if (list.get(66).doubleValue() <= 1.5d) {
                            return 0.09811720484105449d;
                        }
                        if (list.get(71).doubleValue() <= 24.0d) {
                            if (list.get(59).doubleValue() <= 16.5d) {
                                return 0.36704670957429975d;
                            }
                            return 0.18083343126950013d;
                        } else if (list.get(63).doubleValue() <= 100.0d) {
                            return 0.21501561339111971d;
                        } else {
                            return 0.08588656576493947d;
                        }
                    } else if (list.get(71).doubleValue() > 24.0d) {
                        if (list.get(50).doubleValue() <= 1.5d) {
                            return 0.586129835544649d;
                        }
                        return 0.34875038402270553d;
                    } else {
                        return 0.23996693479321615d;
                    }
                } else if (list.get(64).doubleValue() <= 8.370999813079834d) {
                    if (list.get(71).doubleValue() <= 24.0d) {
                        return 0.0221507165932452d;
                    }
                    return 0.08353382269384375d;
                } else if (list.get(53).doubleValue() <= 24.0d) {
                    if (list.get(53).doubleValue() <= 8.0d) {
                        if (list.get(63).doubleValue() <= 48.0d) {
                            return 0.22083875914297013d;
                        }
                        return 0.12966011727451313d;
                    } else if (list.get(71).doubleValue() > 24.0d) {
                        if (list.get(50).doubleValue() <= 1.5d) {
                            return 0.45670231646643233d;
                        }
                        return 0.28146310873363645d;
                    } else {
                        return 0.1647638774430881d;
                    }
                } else if (list.get(55).doubleValue() <= 24.0d) {
                    if (list.get(55).doubleValue() <= 8.0d) {
                        return 0.1673325887465995d;
                    }
                    return 0.36601758236021575d;
                } else if (list.get(71).doubleValue() <= 24.0d) {
                    if (list.get(69).doubleValue() <= 24.0d) {
                        return 0.6390579839547476d;
                    }
                    if (list.get(63).doubleValue() <= 48.0d) {
                        if (list.get(55).doubleValue() <= 48.0d) {
                            return 0.3590473843124675d;
                        }
                        if (list.get(69).doubleValue() <= 48.0d) {
                            return 0.10320464697926585d;
                        }
                        return 0.2666621595566782d;
                    }
                    return 0.11179519848851442d;
                } else if (list.get(63).doubleValue() <= 72.0d) {
                    if (list.get(45).doubleValue() <= 24.0d) {
                        if (list.get(45).doubleValue() <= 8.0d) {
                            return 0.11350778748036511d;
                        }
                        return 0.24673239944602746d;
                    }
                    return 0.09109998832071907d;
                } else {
                    return 0.0590968287792921d;
                }
            } else if (list.get(71).doubleValue() > 24.0d) {
                if (list.get(67).doubleValue() > 48.0d) {
                    if (list.get(67).doubleValue() <= 72.0d) {
                        if (list.get(53).doubleValue() <= 24.0d) {
                            if (list.get(61).doubleValue() <= 72.0d) {
                                return 0.2791942584321795d;
                            }
                            return 0.5173665511143787d;
                        }
                        return 0.17953874111619594d;
                    }
                    return 0.14217497504543006d;
                } else if (list.get(53).doubleValue() <= 24.0d) {
                    if (list.get(69).doubleValue() <= 72.0d) {
                        if (list.get(61).doubleValue() <= 72.0d) {
                            return 0.16570729253360839d;
                        }
                        return 0.29889777096298836d;
                    }
                    return 0.12107317693873813d;
                } else {
                    return 0.08351980903588241d;
                }
            } else if (list.get(72).doubleValue() <= 2.524999976158142d) {
                if (list.get(63).doubleValue() <= 48.0d) {
                    return 0.6757168987023285d;
                }
                return 0.40770438788803637d;
            } else if (list.get(64).doubleValue() <= 3.3140000104904175d) {
                if (list.get(72).doubleValue() <= 3.9795000553131104d) {
                    if (list.get(63).doubleValue() <= 48.0d) {
                        if (list.get(69).doubleValue() <= 48.0d) {
                            return 0.22615932882369424d;
                        }
                        return 0.636683280235284d;
                    }
                    return 0.1915873041712846d;
                }
                return 0.07697423574149231d;
            } else if (list.get(72).doubleValue() <= 6.476999998092651d) {
                if (list.get(63).doubleValue() <= 48.0d) {
                    if (list.get(69).doubleValue() <= 48.0d) {
                        if (list.get(55).doubleValue() <= 48.0d) {
                            if (list.get(55).doubleValue() <= 8.0d) {
                                return 0.49804159704206596d;
                            }
                            return 0.8272358663380146d;
                        }
                        return 0.27088592840386005d;
                    }
                    return 0.7528013752139721d;
                }
                return 0.33230505828340084d;
            } else if (list.get(64).doubleValue() <= 5.799000024795532d) {
                return 0.061934952783966594d;
            } else {
                return 0.3487294629081397d;
            }
        } else if (list.get(71).doubleValue() <= 72.0d) {
            if (list.get(69).doubleValue() <= 24.0d) {
                if (list.get(74).doubleValue() <= 1.5d) {
                    if (list.get(63).doubleValue() <= 24.0d) {
                        if (list.get(24).doubleValue() <= 7.27049994468689d) {
                            if (list.get(64).doubleValue() <= 6.0970001220703125d) {
                                return 0.044932957384698186d;
                            }
                            if (list.get(53).doubleValue() <= 24.0d) {
                                if (list.get(55).doubleValue() <= 24.0d) {
                                    if (list.get(58).doubleValue() <= 1.5d) {
                                        if (list.get(61).doubleValue() <= 72.0d) {
                                            if (list.get(61).doubleValue() <= 48.0d) {
                                                return 0.191928272249958d;
                                            }
                                            return 0.40265215371295604d;
                                        }
                                        return 0.14987551887391198d;
                                    }
                                    return 0.07964162434415165d;
                                } else if (list.get(55).doubleValue() <= 72.0d) {
                                    if (list.get(58).doubleValue() > 1.5d) {
                                        if (list.get(50).doubleValue() <= 1.5d) {
                                            return 0.45571188044164385d;
                                        }
                                        return 0.23531647937682768d;
                                    } else if (list.get(61).doubleValue() <= 48.0d) {
                                        return 0.39429642425034367d;
                                    } else {
                                        return 0.7045055988893499d;
                                    }
                                } else if (list.get(56).doubleValue() <= 10.03499984741211d) {
                                    if (list.get(58).doubleValue() <= 1.5d) {
                                        return 0.5027772717838807d;
                                    }
                                    return 0.11065468646896383d;
                                } else {
                                    return 0.13078623533021536d;
                                }
                            } else if (list.get(55).doubleValue() <= 72.0d) {
                                if (list.get(50).doubleValue() <= 1.5d) {
                                    if (list.get(45).doubleValue() <= 24.0d) {
                                        if (list.get(45).doubleValue() <= 8.0d) {
                                            return 0.19045368708493632d;
                                        }
                                        return 0.4108672529482283d;
                                    }
                                    return 0.15049117769290185d;
                                }
                                return 0.06905238615346028d;
                            } else {
                                return 0.03631394094233411d;
                            }
                        } else if (list.get(53).doubleValue() <= 24.0d) {
                            if (list.get(23).doubleValue() <= 72.0d) {
                                if (list.get(55).doubleValue() <= 72.0d) {
                                    if (list.get(31).doubleValue() <= 24.0d) {
                                        if (list.get(15).doubleValue() <= 72.0d) {
                                            return 0.8494261594500715d;
                                        }
                                        return 0.4415029093297027d;
                                    } else if (list.get(58).doubleValue() <= 1.5d) {
                                        return 0.6751187923734754d;
                                    } else {
                                        return 0.391112553349219d;
                                    }
                                }
                                return 0.1455906777331659d;
                            }
                            return 0.25216738293446d;
                        } else if (list.get(31).doubleValue() <= 72.0d) {
                            if (list.get(23).doubleValue() <= 72.0d) {
                                if (list.get(15).doubleValue() <= 72.0d) {
                                    if (list.get(45).doubleValue() > 24.0d) {
                                        if (list.get(37).doubleValue() <= 24.0d) {
                                            return 0.5192212879036864d;
                                        }
                                        return 0.27347603005496085d;
                                    }
                                    return 0.5769009976695311d;
                                }
                                return 0.10630786219569682d;
                            }
                            return 0.1153916711268821d;
                        } else {
                            return 0.06544142153484406d;
                        }
                    } else if (list.get(55).doubleValue() <= 24.0d) {
                        if (list.get(56).doubleValue() <= 8.722500324249268d) {
                            return 0.03839639268177307d;
                        }
                        return 0.15052207660813727d;
                    } else {
                        return 0.015709930159415974d;
                    }
                } else if (list.get(63).doubleValue() <= 24.0d) {
                    if (list.get(64).doubleValue() <= 8.34749984741211d) {
                        if (list.get(64).doubleValue() <= 4.559000015258789d) {
                            return 0.11030423690644443d;
                        }
                        if (list.get(53).doubleValue() <= 24.0d) {
                            if (list.get(55).doubleValue() <= 24.0d) {
                                return 0.37874253992601403d;
                            }
                            return 0.6652186800342211d;
                        }
                        return 0.2152252290743982d;
                    } else if (list.get(53).doubleValue() <= 24.0d) {
                        if (list.get(55).doubleValue() > 8.0d) {
                            if (list.get(47).doubleValue() > 24.0d) {
                                if (list.get(39).doubleValue() <= 72.0d) {
                                    return 0.7264738154271381d;
                                }
                                return 0.2860630737666629d;
                            } else if (list.get(55).doubleValue() <= 48.0d) {
                                return 0.7814730626169945d;
                            } else {
                                if (list.get(55).doubleValue() <= 72.0d) {
                                    return 0.9420563966826125d;
                                }
                                if (list.get(66).doubleValue() <= 1.5d) {
                                    return 0.9297685491002124d;
                                }
                                return 0.6751099474282947d;
                            }
                        } else if (list.get(66).doubleValue() <= 1.5d) {
                            return 0.8167425199744807d;
                        } else {
                            if (list.get(61).doubleValue() <= 72.0d) {
                                return 0.5665161277429251d;
                            }
                            return 0.3945555755924736d;
                        }
                    } else if (list.get(66).doubleValue() > 1.5d) {
                        if (list.get(8).doubleValue() > 6.11899995803833d) {
                            if (list.get(45).doubleValue() > 24.0d) {
                                if (list.get(37).doubleValue() > 24.0d) {
                                    if (list.get(29).doubleValue() > 24.0d) {
                                        if (list.get(21).doubleValue() <= 24.0d) {
                                            return 0.6247524321079254d;
                                        }
                                        return 0.2519536458907117d;
                                    }
                                    return 0.6583983780985528d;
                                }
                                return 0.7700776344922892d;
                            }
                            return 0.8118391067991334d;
                        } else if (list.get(55).doubleValue() <= 72.0d) {
                            if (list.get(45).doubleValue() <= 24.0d) {
                                if (list.get(48).doubleValue() <= 2.481500029563904d) {
                                    return 0.37472505568373926d;
                                }
                                return 0.6597631614873605d;
                            }
                            return 0.3157032062456655d;
                        } else {
                            return 0.1831958535379179d;
                        }
                    } else if (list.get(55).doubleValue() <= 100.0d) {
                        if (list.get(45).doubleValue() <= 24.0d) {
                            if (list.get(47).doubleValue() <= 8.0d) {
                                return 0.6961175694981998d;
                            }
                            return 0.8950920903961018d;
                        } else if (list.get(37).doubleValue() <= 24.0d) {
                            if (list.get(36).doubleValue() <= 1.5d) {
                                return 0.6057639642991126d;
                            }
                            return 0.8783524421128359d;
                        } else {
                            return 0.55596451446414d;
                        }
                    } else {
                        return 0.3713104093912989d;
                    }
                } else if (list.get(66).doubleValue() <= 1.5d) {
                    if (list.get(55).doubleValue() <= 48.0d) {
                        if (list.get(61).doubleValue() <= 24.0d) {
                            if (list.get(56).doubleValue() <= 7.413500070571899d) {
                                return 0.470651630007937d;
                            }
                            return 0.7294415342864037d;
                        }
                        return 0.24762735218696652d;
                    }
                    return 0.25449635182506675d;
                } else if (list.get(55).doubleValue() <= 24.0d) {
                    if (list.get(56).doubleValue() <= 8.188499927520752d) {
                        return 0.12892499279951491d;
                    }
                    return 0.3376619003734164d;
                } else {
                    return 0.057772762314702124d;
                }
            } else if (list.get(61).doubleValue() <= 24.0d) {
                if (list.get(74).doubleValue() <= 1.5d) {
                    if (list.get(61).doubleValue() <= 8.0d) {
                        return 0.007198080189631248d;
                    }
                    if (list.get(66).doubleValue() <= 1.5d) {
                        if (list.get(53).doubleValue() <= 72.0d) {
                            if (list.get(55).doubleValue() <= 24.0d) {
                                return 0.1271006349272077d;
                            }
                            return 0.05427845949521169d;
                        }
                        return 0.04743418940980596d;
                    }
                    return 0.018863574110120643d;
                } else if (list.get(66).doubleValue() <= 1.5d) {
                    if (list.get(58).doubleValue() <= 1.5d) {
                        if (list.get(47).doubleValue() <= 72.0d) {
                            return 0.6139397168040482d;
                        }
                        return 0.251627485475587d;
                    }
                    return 0.28048733447878116d;
                } else if (list.get(55).doubleValue() <= 24.0d) {
                    if (list.get(53).doubleValue() <= 72.0d) {
                        if (list.get(45).doubleValue() <= 24.0d) {
                            if (list.get(47).doubleValue() <= 48.0d) {
                                return 0.26807501850859483d;
                            }
                            return 0.5342932149430203d;
                        }
                        return 0.21014357441538978d;
                    } else if (list.get(56).doubleValue() <= 7.694499969482422d) {
                        return 0.05684934795869986d;
                    } else {
                        return 0.22814661596424265d;
                    }
                } else {
                    return 0.11093835242023897d;
                }
            } else if (list.get(74).doubleValue() <= 1.5d) {
                if (list.get(63).doubleValue() <= 48.0d) {
                    return 0.021946900711319408d;
                }
                return 0.007982946814715291d;
            } else if (list.get(66).doubleValue() <= 1.5d) {
                if (list.get(53).doubleValue() <= 24.0d) {
                    if (list.get(53).doubleValue() > 8.0d) {
                        if (list.get(50).doubleValue() <= 1.5d) {
                            return 0.5165013580865362d;
                        }
                        return 0.2524867611994345d;
                    }
                    return 0.07502563645067452d;
                }
                return 0.06624206755373083d;
            } else if (list.get(63).doubleValue() <= 48.0d) {
                return 0.048236966843056284d;
            } else {
                return 0.019822268270416225d;
            }
        } else if (list.get(61).doubleValue() <= 24.0d) {
            if (list.get(63).doubleValue() <= 72.0d) {
                if (list.get(74).doubleValue() <= 1.5d) {
                    if (list.get(56).doubleValue() <= 11.513499736785889d) {
                        return 0.01776044490824882d;
                    }
                    if (list.get(55).doubleValue() <= 24.0d) {
                        if (list.get(71).doubleValue() <= 100.0d) {
                            return 0.09804044763284564d;
                        }
                        return 0.02709634875844275d;
                    }
                    return 0.00747309421424629d;
                } else if (list.get(58).doubleValue() <= 1.5d) {
                    if (list.get(66).doubleValue() <= 1.5d) {
                        if (list.get(55).doubleValue() <= 24.0d) {
                            if (list.get(56).doubleValue() > 11.498000144958496d) {
                                if (list.get(45).doubleValue() <= 24.0d) {
                                    if (list.get(47).doubleValue() <= 72.0d) {
                                        if (list.get(63).doubleValue() <= 8.0d) {
                                            return 0.7666827345741088d;
                                        }
                                        return 0.5122816396016989d;
                                    }
                                    return 0.9258989302238615d;
                                } else if (list.get(37).doubleValue() <= 24.0d) {
                                    if (list.get(40).doubleValue() <= 3.0869998931884766d) {
                                        return 0.3708235510449566d;
                                    }
                                    return 0.7950312539961346d;
                                } else {
                                    return 0.3328298342581102d;
                                }
                            } else if (list.get(64).doubleValue() <= 2.6019999980926514d) {
                                return 0.56557255440028d;
                            } else {
                                return 0.30591281958418515d;
                            }
                        }
                        return 0.12276258168689094d;
                    }
                    return 0.08288883485102212d;
                } else if (list.get(55).doubleValue() <= 24.0d) {
                    if (list.get(56).doubleValue() > 10.700500011444092d) {
                        if (list.get(45).doubleValue() <= 24.0d) {
                            if (list.get(47).doubleValue() <= 72.0d) {
                                return 0.20458423839818266d;
                            }
                            return 0.5647355102198929d;
                        }
                        return 0.11556911150637961d;
                    }
                    return 0.06386736952175855d;
                } else {
                    return 0.020689247103515315d;
                }
            } else if (list.get(74).doubleValue() <= 1.5d) {
                return 0.0010265801670083694d;
            } else {
                if (list.get(64).doubleValue() <= 2.6019999980926514d) {
                    if (list.get(66).doubleValue() <= 1.5d) {
                        if (list.get(61).doubleValue() <= 8.0d) {
                            return 0.008937247588417248d;
                        }
                        return 0.43807891265215715d;
                    }
                    return 0.07069749899894065d;
                } else if (list.get(66).doubleValue() <= 1.5d) {
                    if (list.get(55).doubleValue() <= 8.0d) {
                        if (list.get(71).doubleValue() <= 100.0d) {
                            return 0.23757584086698877d;
                        }
                        return 0.08649588839175458d;
                    }
                    return 0.024661455867951085d;
                } else {
                    return 0.006023778485451411d;
                }
            }
        } else if (list.get(63).doubleValue() <= 48.0d) {
            if (list.get(32).doubleValue() > 9.18149995803833d) {
                if (list.get(45).doubleValue() > 24.0d) {
                    if (list.get(37).doubleValue() <= 24.0d) {
                        if (list.get(74).doubleValue() <= 1.5d) {
                            return 0.02989417829917368d;
                        }
                        return 0.13919364361456746d;
                    }
                    return 0.007531045913487463d;
                } else if (list.get(69).doubleValue() <= 24.0d) {
                    if (list.get(55).doubleValue() > 72.0d) {
                        if (list.get(47).doubleValue() <= 72.0d) {
                            if (list.get(63).doubleValue() <= 8.0d) {
                                return 0.08720639573933416d;
                            }
                            return 0.8838660915532861d;
                        }
                        return 0.10938021278356645d;
                    }
                    return 0.1058263505766542d;
                } else {
                    return 0.044890352649838074d;
                }
            }
            return 0.004176427760698417d;
        } else {
            return 6.702075963277083E-4d;
        }
    }

    private final double tree1(List<Double> list) {
        if (list.get(63).doubleValue() <= 48.0d) {
            if (list.get(63).doubleValue() <= 24.0d) {
                if (list.get(61).doubleValue() <= 48.0d) {
                    if (list.get(72).doubleValue() <= 3.450000047683716d) {
                        if (list.get(71).doubleValue() <= 48.0d) {
                            if (list.get(64).doubleValue() <= 0.8959999978542328d) {
                                if (list.get(71).doubleValue() <= 24.0d) {
                                    if (list.get(72).doubleValue() <= 1.4975000023841858d) {
                                        return 0.02113033683890167d;
                                    }
                                    return 0.24365225373887156d;
                                }
                                return 0.6148127350690908d;
                            } else if (list.get(47).doubleValue() <= 8.0d) {
                                if (list.get(61).doubleValue() <= 24.0d) {
                                    if (list.get(71).doubleValue() > 24.0d) {
                                        if (list.get(49).doubleValue() <= 0.5d) {
                                            return 0.3001043469086289d;
                                        }
                                        return 0.8873422256139405d;
                                    } else if (list.get(56).doubleValue() <= 2.441499948501587d) {
                                        return 0.06818865714706963d;
                                    } else {
                                        return 0.48717867538087173d;
                                    }
                                } else if (list.get(74).doubleValue() <= 1.5d) {
                                    if (list.get(72).doubleValue() <= 2.8615000247955322d) {
                                        if (list.get(72).doubleValue() <= 1.7005000114440918d) {
                                            if (list.get(71).doubleValue() <= 24.0d) {
                                                return 0.20840179598336794d;
                                            }
                                            return 0.9822203781869676d;
                                        } else if (list.get(69).doubleValue() <= 48.0d) {
                                            if (list.get(71).doubleValue() <= 8.0d) {
                                                if (list.get(63).doubleValue() <= 8.0d) {
                                                    return 0.21173631421171446d;
                                                }
                                                if (list.get(53).doubleValue() <= 48.0d) {
                                                    return 0.9087046588460604d;
                                                }
                                                return 0.01652705919696018d;
                                            }
                                            return 0.7090437594425026d;
                                        } else {
                                            return 0.10385612586978824d;
                                        }
                                    } else if (list.get(71).doubleValue() <= 8.0d) {
                                        if (list.get(63).doubleValue() <= 8.0d) {
                                            return 0.09614669466723821d;
                                        }
                                        if (list.get(53).doubleValue() <= 48.0d) {
                                            return 0.8456275968159707d;
                                        }
                                        return 0.007856878543283197d;
                                    } else if (list.get(56).doubleValue() <= 0.5494999885559082d) {
                                        return 0.3641057164644139d;
                                    } else {
                                        if (list.get(53).doubleValue() <= 48.0d) {
                                            return 0.6104431064278893d;
                                        }
                                        return 0.06395658266264945d;
                                    }
                                } else if (list.get(69).doubleValue() <= 24.0d) {
                                    if (list.get(72).doubleValue() <= 2.9700000286102295d) {
                                        return 0.807055344006845d;
                                    }
                                    return 0.4436422487643237d;
                                } else if (list.get(64).doubleValue() <= 1.8690000176429749d) {
                                    return 0.5519257520495144d;
                                } else {
                                    return 0.12443335321610476d;
                                }
                            } else if (list.get(71).doubleValue() <= 24.0d) {
                                if (list.get(71).doubleValue() <= 8.0d) {
                                    if (list.get(45).doubleValue() <= 48.0d) {
                                        if (list.get(47).doubleValue() <= 48.0d) {
                                            return 0.7240651953883311d;
                                        }
                                        return 0.21202941241226286d;
                                    }
                                    return 0.022658460985569815d;
                                }
                                return 0.051033973209064866d;
                            } else {
                                return 0.7680253398576469d;
                            }
                        } else if (list.get(71).doubleValue() <= 72.0d) {
                            return 0.11611568519927246d;
                        } else {
                            return 0.015303082300349208d;
                        }
                    } else if (list.get(71).doubleValue() <= 100.0d) {
                        if (list.get(63).doubleValue() <= 8.0d) {
                            if (list.get(71).doubleValue() <= 72.0d) {
                                if (list.get(49).doubleValue() > 0.5d) {
                                    if (list.get(55).doubleValue() <= 48.0d) {
                                        if (list.get(55).doubleValue() <= 24.0d) {
                                            if (list.get(72).doubleValue() <= 6.8459999561309814d) {
                                                if (list.get(71).doubleValue() <= 48.0d) {
                                                    if (list.get(71).doubleValue() > 24.0d) {
                                                        if (list.get(55).doubleValue() <= 8.0d) {
                                                            return 0.8771659827217702d;
                                                        }
                                                        if (list.get(56).doubleValue() <= 2.6019999980926514d) {
                                                            return 0.14632444837064082d;
                                                        }
                                                        if (list.get(53).doubleValue() <= 48.0d) {
                                                            return 0.6828582223144269d;
                                                        }
                                                        return 0.1858886959652106d;
                                                    }
                                                    return 0.24929963663073784d;
                                                }
                                                return 0.06170848182773219d;
                                            } else if (list.get(53).doubleValue() <= 48.0d) {
                                                return 0.15187431961273928d;
                                            } else {
                                                return 0.07314775573509517d;
                                            }
                                        } else if (list.get(71).doubleValue() <= 24.0d) {
                                            if (list.get(53).doubleValue() <= 48.0d) {
                                                if (list.get(37).doubleValue() <= 48.0d) {
                                                    if (list.get(50).doubleValue() <= 1.5d) {
                                                        return 0.6830665780446767d;
                                                    }
                                                    return 0.27968460108932935d;
                                                }
                                                return 0.23302188328805776d;
                                            }
                                            return 0.19137768407505334d;
                                        } else if (list.get(74).doubleValue() <= 1.5d) {
                                            if (list.get(69).doubleValue() <= 24.0d) {
                                                return 0.4881298000558272d;
                                            }
                                            return 0.1657529602310884d;
                                        } else if (list.get(71).doubleValue() <= 48.0d) {
                                            return 0.2215026008302947d;
                                        } else {
                                            if (list.get(64).doubleValue() <= 11.84499979019165d) {
                                                return 0.2593784074544803d;
                                            }
                                            return 0.5844527974611882d;
                                        }
                                    }
                                    return 0.06276581618287404d;
                                } else if (list.get(64).doubleValue() <= 7.401000022888184d) {
                                    return 0.028181730058457748d;
                                } else {
                                    return 0.10530557896147817d;
                                }
                            } else if (list.get(74).doubleValue() > 1.5d) {
                                if (list.get(66).doubleValue() <= 1.5d) {
                                    if (list.get(55).doubleValue() <= 24.0d) {
                                        return 0.18541676707945123d;
                                    }
                                    if (list.get(55).doubleValue() <= 48.0d) {
                                        return 0.589440268313146d;
                                    }
                                    return 0.1470191688561865d;
                                }
                                return 0.033536937881536805d;
                            } else {
                                return 0.02109420927238822d;
                            }
                        } else if (list.get(61).doubleValue() <= 24.0d) {
                            if (list.get(71).doubleValue() <= 48.0d) {
                                if (list.get(71).doubleValue() > 24.0d) {
                                    if (list.get(58).doubleValue() <= 1.5d) {
                                        if (list.get(53).doubleValue() <= 24.0d) {
                                            return 0.21073552677721635d;
                                        }
                                        if (list.get(72).doubleValue() <= 11.985000133514404d) {
                                            return 0.7793085186591221d;
                                        }
                                        return 0.3765066105333972d;
                                    }
                                    return 0.09241704608463515d;
                                }
                                return 0.06042867469202627d;
                            }
                            return 0.05163896331112703d;
                        } else if (list.get(71).doubleValue() <= 48.0d) {
                            if (list.get(72).doubleValue() <= 6.322499990463257d) {
                                if (list.get(53).doubleValue() <= 48.0d) {
                                    if (list.get(71).doubleValue() <= 8.0d) {
                                        if (list.get(72).doubleValue() <= 3.921999931335449d) {
                                            return 0.6685974770158022d;
                                        }
                                        return 0.4301368582858432d;
                                    } else if (list.get(71).doubleValue() <= 24.0d) {
                                        if (list.get(55).doubleValue() <= 24.0d) {
                                            if (list.get(64).doubleValue() <= 2.350499987602234d) {
                                                return 0.3574539908086476d;
                                            }
                                            return 0.05268894914988601d;
                                        }
                                        return 0.37739777895497906d;
                                    } else if (list.get(64).doubleValue() <= 3.1130000352859497d) {
                                        if (list.get(69).doubleValue() <= 24.0d) {
                                            return 0.09941592265296387d;
                                        }
                                        return 0.5297005980626329d;
                                    } else {
                                        return 0.4424793594274626d;
                                    }
                                }
                                return 0.06286238152171653d;
                            } else if (list.get(69).doubleValue() <= 24.0d) {
                                if (list.get(58).doubleValue() <= 1.5d) {
                                    if (list.get(71).doubleValue() <= 24.0d) {
                                        if (list.get(55).doubleValue() <= 24.0d) {
                                            return 0.12615082677507827d;
                                        }
                                        if (list.get(53).doubleValue() <= 48.0d) {
                                            if (list.get(45).doubleValue() <= 48.0d) {
                                                return 0.4003983351104143d;
                                            }
                                            return 0.14577201450039157d;
                                        }
                                        return 0.11791607159733151d;
                                    } else if (list.get(64).doubleValue() <= 6.0924999713897705d) {
                                        return 0.015671308896116898d;
                                    } else {
                                        if (list.get(53).doubleValue() <= 48.0d) {
                                            if (list.get(53).doubleValue() > 24.0d) {
                                                if (list.get(55).doubleValue() <= 48.0d) {
                                                    return 0.2713816671400018d;
                                                }
                                                return 0.08995113156611953d;
                                            }
                                            return 0.08941413752470362d;
                                        }
                                        return 0.04103119666588144d;
                                    }
                                }
                                return 0.03640084287178091d;
                            } else if (list.get(55).doubleValue() <= 24.0d) {
                                if (list.get(58).doubleValue() <= 1.5d) {
                                    return 0.17449741867286728d;
                                }
                                return 0.09172389756702717d;
                            } else if (list.get(53).doubleValue() <= 48.0d) {
                                if (list.get(58).doubleValue() <= 1.5d) {
                                    if (list.get(37).doubleValue() <= 24.0d) {
                                        return 0.4754856439607607d;
                                    }
                                    return 0.275639682871749d;
                                }
                                return 0.2195801224496198d;
                            } else if (list.get(71).doubleValue() <= 24.0d) {
                                return 0.1319902464085722d;
                            } else {
                                return 0.33318900594886147d;
                            }
                        } else if (list.get(74).doubleValue() <= 1.5d) {
                            if (list.get(58).doubleValue() <= 1.5d) {
                                if (list.get(64).doubleValue() <= 11.370999813079834d) {
                                    if (list.get(71).doubleValue() <= 72.0d) {
                                        return 0.1919821768623562d;
                                    }
                                    return 0.09229632996313111d;
                                }
                                return 0.22941661865737062d;
                            }
                            return 0.10495750033148951d;
                        } else if (list.get(66).doubleValue() > 1.5d) {
                            if (list.get(55).doubleValue() <= 48.0d) {
                                if (list.get(56).doubleValue() <= 8.795000076293945d) {
                                    return 0.23180531893359185d;
                                }
                                return 0.33885542756572296d;
                            }
                            return 0.11553036313823284d;
                        } else if (list.get(71).doubleValue() <= 72.0d) {
                            return 0.23970722266133695d;
                        } else {
                            if (list.get(64).doubleValue() <= 7.137500047683716d) {
                                return 0.31630459674775147d;
                            }
                            return 0.6847398127452434d;
                        }
                    } else {
                        return 0.009550658785296524d;
                    }
                } else if (list.get(71).doubleValue() <= 100.0d) {
                    if (list.get(74).doubleValue() > 1.5d) {
                        if (list.get(66).doubleValue() <= 1.5d) {
                            if (list.get(71).doubleValue() <= 72.0d) {
                                return 0.07368758054033345d;
                            }
                            if (list.get(63).doubleValue() <= 8.0d) {
                                return 0.08704317397666157d;
                            }
                            if (list.get(64).doubleValue() <= 6.289499998092651d) {
                                return 0.17273903330460952d;
                            }
                            if (list.get(47).doubleValue() <= 48.0d) {
                                return 0.5842220976829996d;
                            }
                            return 0.3418602190305431d;
                        } else if (list.get(71).doubleValue() <= 8.0d) {
                            return 0.021596113834099744d;
                        } else {
                            if (list.get(64).doubleValue() <= 6.021999835968018d) {
                                return 0.0591177850532019d;
                            }
                            if (list.get(71).doubleValue() > 48.0d) {
                                if (list.get(55).doubleValue() <= 72.0d) {
                                    return 0.13139895278217573d;
                                }
                                return 0.06375806132598173d;
                            } else if (list.get(69).doubleValue() <= 24.0d) {
                                return 0.03646226166913375d;
                            } else {
                                if (list.get(71).doubleValue() <= 24.0d) {
                                    return 0.06741741560981437d;
                                }
                                return 0.18533198893290706d;
                            }
                        }
                    } else if (list.get(71).doubleValue() > 8.0d) {
                        if (list.get(66).doubleValue() <= 1.5d) {
                            if (list.get(71).doubleValue() <= 48.0d) {
                                if (list.get(69).doubleValue() <= 24.0d) {
                                    return 0.03764329935249615d;
                                }
                                if (list.get(71).doubleValue() <= 24.0d) {
                                    return 0.056809652558675504d;
                                }
                                return 0.15173442674174453d;
                            } else if (list.get(63).doubleValue() <= 8.0d) {
                                return 0.017527717850329763d;
                            } else {
                                if (list.get(64).doubleValue() <= 5.427000045776367d) {
                                    return 0.029137040280909434d;
                                }
                                return 0.07041010247565263d;
                            }
                        }
                        return 0.01505495590350737d;
                    } else {
                        return 0.010768644084815477d;
                    }
                } else {
                    return 0.0010420466933136138d;
                }
            } else if (list.get(74).doubleValue() <= 1.5d) {
                if (list.get(71).doubleValue() <= 48.0d) {
                    if (list.get(61).doubleValue() <= 48.0d) {
                        if (list.get(58).doubleValue() > 1.5d) {
                            if (list.get(66).doubleValue() <= 1.5d) {
                                if (list.get(71).doubleValue() <= 8.0d) {
                                    return 0.09230446756643047d;
                                }
                                return 0.43545626397490894d;
                            }
                            return 0.08015076458017924d;
                        } else if (list.get(53).doubleValue() <= 48.0d) {
                            if (list.get(55).doubleValue() > 48.0d) {
                                if (list.get(15).doubleValue() <= 48.0d) {
                                    if (list.get(71).doubleValue() <= 8.0d) {
                                        return 0.3133696063448974d;
                                    }
                                    if (list.get(72).doubleValue() <= 8.26550006866455d) {
                                        return 0.5660968923647379d;
                                    }
                                    if (list.get(64).doubleValue() <= 8.364500045776367d) {
                                        return 0.12982665591447712d;
                                    }
                                    return 0.47537307200734447d;
                                }
                                return 0.12532525508470013d;
                            } else if (list.get(55).doubleValue() <= 24.0d) {
                                if (list.get(64).doubleValue() > 0.3465000092983246d) {
                                    if (list.get(45).doubleValue() <= 48.0d) {
                                        if (list.get(71).doubleValue() <= 8.0d) {
                                            if (list.get(47).doubleValue() <= 24.0d) {
                                                return 0.5080721729661478d;
                                            }
                                            return 0.6617038523736334d;
                                        } else if (list.get(72).doubleValue() <= 5.505000114440918d) {
                                            if (list.get(72).doubleValue() <= 2.25d) {
                                                if (list.get(71).doubleValue() <= 24.0d) {
                                                    return 0.4446757439331248d;
                                                }
                                                return 0.9166707143639073d;
                                            }
                                            return 0.8188440114109214d;
                                        } else if (list.get(64).doubleValue() <= 4.791500091552734d) {
                                            if (list.get(71).doubleValue() <= 24.0d) {
                                                return 0.49185160047521714d;
                                            }
                                            return 0.14045131833960076d;
                                        } else if (list.get(69).doubleValue() <= 48.0d) {
                                            if (list.get(21).doubleValue() <= 48.0d) {
                                                return 0.7347661342331583d;
                                            }
                                            return 0.3493705374536148d;
                                        } else {
                                            return 0.379926381916448d;
                                        }
                                    } else if (list.get(47).doubleValue() <= 24.0d) {
                                        return 0.08858441371099517d;
                                    } else {
                                        return 0.465784584912263d;
                                    }
                                } else if (list.get(72).doubleValue() <= 1.2425000071525574d) {
                                    if (list.get(71).doubleValue() <= 24.0d) {
                                        return 0.045340992510318756d;
                                    }
                                    return 0.9954926112423772d;
                                } else {
                                    return 0.04902508494089107d;
                                }
                            } else if (list.get(71).doubleValue() <= 24.0d) {
                                if (list.get(37).doubleValue() <= 48.0d) {
                                    if (list.get(47).doubleValue() <= 72.0d) {
                                        if (list.get(56).doubleValue() <= 0.5494999885559082d) {
                                            return 0.32911104358306276d;
                                        }
                                        if (list.get(71).doubleValue() <= 8.0d) {
                                            return 0.7501572311074207d;
                                        }
                                        return 0.56123329175341d;
                                    }
                                    return 0.12792098654077003d;
                                }
                                return 0.24153275798539653d;
                            } else if (list.get(39).doubleValue() <= 48.0d) {
                                if (list.get(29).doubleValue() <= 48.0d) {
                                    if (list.get(72).doubleValue() <= 5.244500160217285d) {
                                        return 0.9790131278904313d;
                                    }
                                    if (list.get(64).doubleValue() <= 4.952499866485596d) {
                                        return 0.20919402344035917d;
                                    }
                                    return 0.9011779769297479d;
                                }
                                return 0.515919619722833d;
                            } else {
                                return 0.5272633190175319d;
                            }
                        } else if (list.get(71).doubleValue() <= 8.0d) {
                            return 0.13357403029944512d;
                        } else {
                            return 0.3021568248555668d;
                        }
                    } else if (list.get(72).doubleValue() > 1.7005000114440918d) {
                        if (list.get(58).doubleValue() <= 1.5d) {
                            if (list.get(71).doubleValue() <= 24.0d) {
                                if (list.get(71).doubleValue() <= 8.0d) {
                                    return 0.05953151222777795d;
                                }
                                if (list.get(64).doubleValue() > 8.570499897003174d) {
                                    if (list.get(55).doubleValue() <= 72.0d) {
                                        if (list.get(53).doubleValue() <= 48.0d) {
                                            if (list.get(53).doubleValue() <= 24.0d) {
                                                return 0.28096847369491856d;
                                            }
                                            return 0.43145738067377243d;
                                        }
                                        return 0.1780406724691657d;
                                    }
                                    return 0.14194959327804021d;
                                } else if (list.get(72).doubleValue() <= 8.68149995803833d) {
                                    if (list.get(64).doubleValue() <= 4.983500003814697d) {
                                        return 0.13083650070769118d;
                                    }
                                    return 0.24577591935538015d;
                                } else {
                                    return 0.05686160823982694d;
                                }
                            } else if (list.get(64).doubleValue() <= 1.2425000071525574d) {
                                return 0.03448550013863044d;
                            } else {
                                if (list.get(72).doubleValue() <= 8.412499904632568d) {
                                    if (list.get(55).doubleValue() <= 48.0d) {
                                        if (list.get(55).doubleValue() <= 24.0d) {
                                            if (list.get(64).doubleValue() <= 4.085999965667725d) {
                                                if (list.get(72).doubleValue() <= 4.2834999561309814d) {
                                                    if (list.get(64).doubleValue() <= 1.8690000176429749d) {
                                                        return 0.3455402267863974d;
                                                    }
                                                    return 0.6014746645783505d;
                                                }
                                                return 0.13699250778380043d;
                                            }
                                            return 0.8186215614964222d;
                                        }
                                        return 0.8449437335762195d;
                                    } else if (list.get(64).doubleValue() <= 4.06850004196167d) {
                                        return 0.2948183248994021d;
                                    } else {
                                        return 0.4983161627436669d;
                                    }
                                } else if (list.get(64).doubleValue() > 8.274499893188477d) {
                                    if (list.get(55).doubleValue() > 48.0d) {
                                        if (list.get(1).doubleValue() <= 0.5d) {
                                            if (list.get(69).doubleValue() <= 72.0d) {
                                                return 0.21177078079531447d;
                                            }
                                            if (list.get(72).doubleValue() <= 11.864500045776367d) {
                                                return 0.524461684370519d;
                                            }
                                            return 0.29169555519827917d;
                                        }
                                        return 0.13998323875076185d;
                                    } else if (list.get(69).doubleValue() <= 100.0d) {
                                        return 0.45671263000340057d;
                                    } else {
                                        if (list.get(47).doubleValue() <= 48.0d) {
                                            return 0.8199327183925376d;
                                        }
                                        return 0.4970972059304489d;
                                    }
                                } else {
                                    return 0.047785502469177316d;
                                }
                            }
                        }
                        return 0.025980517113614172d;
                    } else if (list.get(71).doubleValue() <= 24.0d) {
                        return 0.24279882768812394d;
                    } else {
                        return 0.9783154725657814d;
                    }
                } else if (list.get(56).doubleValue() <= 6.177000045776367d) {
                    if (list.get(71).doubleValue() <= 100.0d) {
                        if (list.get(61).doubleValue() <= 48.0d) {
                            if (list.get(72).doubleValue() <= 8.128499984741211d) {
                                return 0.011405410145835553d;
                            }
                            if (list.get(61).doubleValue() <= 24.0d) {
                                if (list.get(53).doubleValue() <= 8.0d) {
                                    return 0.21987664700242274d;
                                }
                                return 0.07887579901278538d;
                            }
                            return 0.05132919092463857d;
                        } else if (list.get(64).doubleValue() > 4.758000135421753d) {
                            if (list.get(58).doubleValue() <= 1.5d) {
                                if (list.get(61).doubleValue() <= 72.0d) {
                                    if (list.get(71).doubleValue() <= 72.0d) {
                                        if (list.get(53).doubleValue() <= 48.0d) {
                                            return 0.4469072092634076d;
                                        }
                                        return 0.2256885496423687d;
                                    }
                                    return 0.20433832692645815d;
                                }
                                return 0.19647554886900798d;
                            }
                            return 0.08763943445143198d;
                        } else if (list.get(72).doubleValue() <= 4.269999980926514d) {
                            if (list.get(72).doubleValue() <= 0.3465000092983246d) {
                                return 0.5359487164961664d;
                            }
                            return 0.03999553874260498d;
                        } else if (list.get(72).doubleValue() <= 8.622499942779541d) {
                            if (list.get(71).doubleValue() <= 72.0d) {
                                return 0.24966883167424606d;
                            }
                            return 0.10949085734991801d;
                        } else {
                            return 0.0768785500666272d;
                        }
                    }
                    return 1.3000663417550714E-4d;
                } else if (list.get(53).doubleValue() <= 48.0d) {
                    if (list.get(71).doubleValue() <= 100.0d) {
                        if (list.get(47).doubleValue() <= 48.0d) {
                            if (list.get(58).doubleValue() > 1.5d) {
                                if (list.get(42).doubleValue() <= 1.5d) {
                                    if (list.get(47).doubleValue() <= 24.0d) {
                                        return 0.2089178021075552d;
                                    }
                                    return 0.5097920657001423d;
                                } else if (list.get(71).doubleValue() <= 72.0d) {
                                    if (list.get(55).doubleValue() <= 72.0d) {
                                        if (list.get(50).doubleValue() <= 1.5d) {
                                            return 0.39136359967258677d;
                                        }
                                        return 0.12754852219383744d;
                                    }
                                    return 0.028192228637895295d;
                                } else if (list.get(55).doubleValue() <= 72.0d) {
                                    return 0.1391995864727332d;
                                } else {
                                    return 0.27302114818232487d;
                                }
                            } else if (list.get(47).doubleValue() > 24.0d) {
                                if (list.get(37).doubleValue() <= 48.0d) {
                                    if (list.get(61).doubleValue() > 48.0d) {
                                        if (list.get(37).doubleValue() <= 24.0d) {
                                            return 0.5254878312723955d;
                                        }
                                        if (list.get(69).doubleValue() <= 48.0d) {
                                            return 0.7163027398896008d;
                                        }
                                        return 0.29557036437416595d;
                                    } else if (list.get(71).doubleValue() <= 72.0d) {
                                        return 0.5367294670914482d;
                                    } else {
                                        return 0.2989301810394037d;
                                    }
                                }
                                return 0.4211074396815559d;
                            } else if (list.get(61).doubleValue() > 48.0d) {
                                if (list.get(59).doubleValue() <= 72.0d) {
                                    if (list.get(69).doubleValue() <= 48.0d) {
                                        if (list.get(45).doubleValue() <= 48.0d) {
                                            return 0.47364326301237014d;
                                        }
                                        return 0.2960589615335139d;
                                    }
                                    return 0.1194481723977355d;
                                }
                                return 0.2338020979198018d;
                            } else if (list.get(71).doubleValue() <= 72.0d) {
                                if (list.get(55).doubleValue() <= 24.0d) {
                                    return 0.38657987940528d;
                                }
                                return 0.1888168342195124d;
                            } else {
                                return 0.12184234520536048d;
                            }
                        } else if (list.get(47).doubleValue() <= 72.0d) {
                            return 0.2139413941735033d;
                        } else {
                            return 0.10696504776891826d;
                        }
                    }
                    return 0.0015216859846702824d;
                } else if (list.get(71).doubleValue() <= 100.0d) {
                    if (list.get(58).doubleValue() <= 1.5d) {
                        if (list.get(39).doubleValue() <= 72.0d) {
                            if (list.get(55).doubleValue() > 72.0d) {
                                if (list.get(39).doubleValue() <= 8.0d) {
                                    return 0.08036754520690843d;
                                }
                                return 0.20071452420625224d;
                            } else if (list.get(71).doubleValue() <= 72.0d) {
                                if (list.get(45).doubleValue() <= 48.0d) {
                                    return 0.3190335851693817d;
                                }
                                return 0.2053751951345653d;
                            } else if (list.get(45).doubleValue() <= 48.0d) {
                                return 0.19859541208778433d;
                            } else {
                                return 0.10421587821561869d;
                            }
                        }
                        return 0.08388497110773636d;
                    }
                    return 0.06914221396808479d;
                } else {
                    return 0.0012270750032993976d;
                }
            } else if (list.get(71).doubleValue() <= 100.0d) {
                if (list.get(66).doubleValue() <= 1.5d) {
                    if (list.get(58).doubleValue() <= 1.5d) {
                        if (list.get(71).doubleValue() <= 48.0d) {
                            if (list.get(69).doubleValue() <= 48.0d) {
                                if (list.get(64).doubleValue() <= 7.94599986076355d) {
                                    return 0.17386282418719343d;
                                }
                                return 0.3525802887941132d;
                            }
                            return 0.12657316299422502d;
                        } else if (list.get(64).doubleValue() <= 9.078999996185303d) {
                            if (list.get(64).doubleValue() <= 5.856499910354614d) {
                                return 0.2299804999964951d;
                            }
                            return 0.4372855299582503d;
                        } else if (list.get(53).doubleValue() <= 48.0d) {
                            if (list.get(61).doubleValue() <= 48.0d) {
                                return 0.5511828568492841d;
                            }
                            if (list.get(53).doubleValue() <= 24.0d) {
                                return 0.66001138234732d;
                            }
                            return 0.8748870576149784d;
                        } else if (list.get(61).doubleValue() > 24.0d) {
                            if (list.get(55).doubleValue() <= 100.0d) {
                                if (list.get(45).doubleValue() <= 48.0d) {
                                    return 0.6265905639266267d;
                                }
                                return 0.46322638947721345d;
                            }
                            return 0.2466184700923109d;
                        } else {
                            return 0.3125638618950759d;
                        }
                    } else if (list.get(53).doubleValue() > 48.0d) {
                        if (list.get(45).doubleValue() > 48.0d) {
                            if (list.get(37).doubleValue() <= 48.0d) {
                                if (list.get(37).doubleValue() <= 24.0d) {
                                    return 0.5808895370587456d;
                                }
                                return 0.7900946968131595d;
                            }
                            return 0.5012060013390621d;
                        } else if (list.get(45).doubleValue() <= 24.0d) {
                            return 0.6208956432100733d;
                        } else {
                            return 0.819873077063998d;
                        }
                    } else if (list.get(53).doubleValue() > 24.0d) {
                        if (list.get(50).doubleValue() <= 1.5d) {
                            return 0.9386664557671353d;
                        }
                        if (list.get(71).doubleValue() <= 48.0d) {
                            return 0.5525681398167098d;
                        }
                        return 0.8264639428470127d;
                    } else if (list.get(72).doubleValue() <= 13.314499855041504d) {
                        return 0.8268758769413044d;
                    } else {
                        return 0.7161297780090949d;
                    }
                } else if (list.get(64).doubleValue() <= 7.128999948501587d) {
                    if (list.get(72).doubleValue() <= 1.2425000071525574d) {
                        if (list.get(71).doubleValue() <= 24.0d) {
                            return 0.3342344213484062d;
                        }
                        if (list.get(71).doubleValue() <= 48.0d) {
                            return 0.9856548145536549d;
                        }
                        return 0.4473941993955695d;
                    } else if (list.get(71).doubleValue() <= 72.0d) {
                        if (list.get(72).doubleValue() <= 8.375999927520752d) {
                            if (list.get(71).doubleValue() <= 48.0d) {
                                if (list.get(71).doubleValue() <= 24.0d) {
                                    if (list.get(61).doubleValue() <= 48.0d) {
                                        return 0.4067530548319289d;
                                    }
                                    if (list.get(71).doubleValue() <= 8.0d) {
                                        return 0.07900685532981759d;
                                    }
                                    if (list.get(69).doubleValue() <= 48.0d) {
                                        return 0.30630603984497196d;
                                    }
                                    return 0.13732267585078964d;
                                } else if (list.get(64).doubleValue() <= 0.3465000092983246d) {
                                    return 0.2544308569587288d;
                                } else {
                                    if (list.get(72).doubleValue() <= 6.11050009727478d) {
                                        if (list.get(55).doubleValue() > 48.0d) {
                                            if (list.get(5).doubleValue() <= 8.0d) {
                                                return 0.6683010754370412d;
                                            }
                                            return 0.13030012771196198d;
                                        } else if (list.get(55).doubleValue() <= 24.0d) {
                                            return 0.7007829299381961d;
                                        } else {
                                            return 0.9098468358628452d;
                                        }
                                    } else if (list.get(64).doubleValue() <= 5.7820000648498535d) {
                                        return 0.15854575032047427d;
                                    } else {
                                        return 0.6828358719015822d;
                                    }
                                }
                            } else if (list.get(72).doubleValue() <= 4.952499866485596d) {
                                return 0.09047861715996958d;
                            } else {
                                if (list.get(61).doubleValue() <= 48.0d) {
                                    return 0.2401234433794386d;
                                }
                                return 0.4563906391180528d;
                            }
                        } else if (list.get(71).doubleValue() <= 48.0d) {
                            if (list.get(69).doubleValue() <= 48.0d) {
                                return 0.15558215716289572d;
                            }
                            return 0.047283238169413155d;
                        } else {
                            return 0.3006233872062764d;
                        }
                    } else if (list.get(72).doubleValue() <= 5.139000177383423d) {
                        return 0.02456912686992212d;
                    } else {
                        return 0.19999562699406748d;
                    }
                } else if (list.get(53).doubleValue() <= 48.0d) {
                    if (list.get(53).doubleValue() <= 24.0d) {
                        if (list.get(71).doubleValue() <= 24.0d) {
                            if (list.get(61).doubleValue() <= 48.0d) {
                                return 0.4923840481033081d;
                            }
                            if (list.get(71).doubleValue() > 8.0d) {
                                if (list.get(55).doubleValue() <= 72.0d) {
                                    return 0.3568180112225379d;
                                }
                                return 0.13742806003875174d;
                            }
                            return 0.10751723636746068d;
                        } else if (list.get(71).doubleValue() <= 72.0d) {
                            if (list.get(45).doubleValue() <= 48.0d) {
                                if (list.get(61).doubleValue() <= 72.0d) {
                                    if (list.get(61).doubleValue() <= 48.0d) {
                                        if (list.get(71).doubleValue() <= 48.0d) {
                                            return 0.6985147278866118d;
                                        }
                                        return 0.39554404990102143d;
                                    } else if (list.get(71).doubleValue() <= 48.0d) {
                                        return 0.33591883075838486d;
                                    } else {
                                        return 0.7044210376413277d;
                                    }
                                }
                                return 0.4664876885090259d;
                            }
                            return 0.3783294847228195d;
                        } else if (list.get(61).doubleValue() > 48.0d) {
                            if (list.get(55).doubleValue() <= 72.0d) {
                                if (list.get(58).doubleValue() <= 1.5d) {
                                    return 0.2776998476333678d;
                                }
                                return 0.42707819815952075d;
                            }
                            return 0.5731798829401097d;
                        } else {
                            return 0.23420469357198065d;
                        }
                    } else if (list.get(69).doubleValue() > 48.0d) {
                        if (list.get(50).doubleValue() <= 1.5d) {
                            return 0.5123726971004057d;
                        }
                        return 0.3218176227115399d;
                    } else if (list.get(47).doubleValue() > 48.0d) {
                        if (list.get(45).doubleValue() <= 48.0d) {
                            if (list.get(71).doubleValue() > 24.0d) {
                                if (list.get(37).doubleValue() <= 48.0d) {
                                    return 0.4688426958171859d;
                                }
                                return 0.6582454631227981d;
                            }
                            return 0.33332443023742786d;
                        }
                        return 0.251685788581001d;
                    } else if (list.get(71).doubleValue() <= 48.0d) {
                        if (list.get(55).doubleValue() <= 48.0d) {
                            if (list.get(69).doubleValue() <= 24.0d) {
                                return 0.28246814146405086d;
                            }
                            return 0.6929915662563966d;
                        }
                        return 0.4611929335408069d;
                    } else if (list.get(61).doubleValue() <= 48.0d) {
                        if (list.get(56).doubleValue() <= 6.956999778747559d) {
                            return 0.2568815585320408d;
                        }
                        return 0.6142192338646556d;
                    } else if (list.get(71).doubleValue() <= 72.0d) {
                        if (list.get(55).doubleValue() <= 72.0d) {
                            return 0.8665900872056276d;
                        }
                        return 0.712718265002531d;
                    } else if (list.get(55).doubleValue() > 72.0d) {
                        if (list.get(39).doubleValue() <= 72.0d) {
                            return 0.7223235185578143d;
                        }
                        return 0.8886880750960864d;
                    } else {
                        return 0.47409403914905557d;
                    }
                } else if (list.get(71).doubleValue() <= 24.0d) {
                    if (list.get(61).doubleValue() <= 24.0d) {
                        return 0.4619899995392188d;
                    }
                    return 0.22361602774221087d;
                } else if (list.get(71).doubleValue() <= 72.0d) {
                    if (list.get(39).doubleValue() > 48.0d) {
                        if (list.get(37).doubleValue() <= 48.0d) {
                            return 0.44480165723633874d;
                        }
                        return 0.2970012365139003d;
                    } else if (list.get(39).doubleValue() <= 24.0d) {
                        if (list.get(55).doubleValue() <= 72.0d) {
                            if (list.get(55).doubleValue() <= 24.0d) {
                                return 0.33952423401236603d;
                            }
                            return 0.5017512211854075d;
                        }
                        return 0.31141383241092097d;
                    } else {
                        return 0.6026423317587245d;
                    }
                } else if (list.get(45).doubleValue() <= 48.0d) {
                    if (list.get(45).doubleValue() <= 24.0d) {
                        return 0.2654654049944108d;
                    }
                    return 0.46316908295956005d;
                } else {
                    return 0.2105655223343906d;
                }
            } else if (list.get(55).doubleValue() <= 100.0d) {
                return 0.003952995290591456d;
            } else {
                return 0.37370497788813534d;
            }
        } else if (list.get(71).doubleValue() <= 72.0d) {
            if (list.get(74).doubleValue() <= 1.5d) {
                if (list.get(66).doubleValue() <= 1.5d) {
                    if (list.get(71).doubleValue() <= 8.0d) {
                        if (list.get(69).doubleValue() <= 48.0d) {
                            if (list.get(69).doubleValue() <= 24.0d) {
                                return 0.018527278670799292d;
                            }
                            if (list.get(61).doubleValue() > 8.0d) {
                                if (list.get(40).doubleValue() <= 2.441499948501587d) {
                                    if (list.get(64).doubleValue() <= 10.464499950408936d) {
                                        if (list.get(72).doubleValue() <= 10.3725004196167d) {
                                            if (list.get(55).doubleValue() <= 72.0d) {
                                                if (list.get(55).doubleValue() <= 8.0d) {
                                                    return 0.09371443484667931d;
                                                }
                                                if (list.get(55).doubleValue() <= 48.0d) {
                                                    return 0.37317864405486034d;
                                                }
                                                return 0.10135629507751398d;
                                            }
                                            return 0.03888952694159064d;
                                        }
                                        return 0.018373485142579214d;
                                    } else if (list.get(56).doubleValue() <= 7.057999849319458d) {
                                        return 0.20919524898812916d;
                                    } else {
                                        return 0.12256198597181454d;
                                    }
                                }
                                return 0.04985807046672698d;
                            }
                            return 0.0016821210221807878d;
                        }
                        return 0.00710928529860818d;
                    } else if (list.get(71).doubleValue() <= 24.0d) {
                        if (list.get(69).doubleValue() <= 48.0d) {
                            if (list.get(63).doubleValue() <= 72.0d) {
                                if (list.get(55).doubleValue() <= 48.0d) {
                                    if (list.get(61).doubleValue() <= 24.0d) {
                                        return 0.12663392877605345d;
                                    }
                                    if (list.get(61).doubleValue() <= 48.0d) {
                                        return 0.4578522428266191d;
                                    }
                                    return 0.18554017511105128d;
                                }
                                return 0.17562406603759936d;
                            } else if (list.get(69).doubleValue() > 24.0d) {
                                if (list.get(16).doubleValue() <= 1.4975000023841858d) {
                                    return 0.6802725286569763d;
                                }
                                return 0.31707835683895d;
                            } else {
                                return 0.1577551185426946d;
                            }
                        } else if (list.get(63).doubleValue() <= 72.0d) {
                            return 0.09013718730605565d;
                        } else {
                            if (list.get(69).doubleValue() <= 72.0d) {
                                return 0.10583382339958469d;
                            }
                            if (list.get(61).doubleValue() <= 24.0d) {
                                return 0.14640618758195487d;
                            }
                            if (list.get(72).doubleValue() <= 10.476500034332275d) {
                                if (list.get(55).doubleValue() <= 72.0d) {
                                    return 0.483205079548858d;
                                }
                                return 0.2778897741893779d;
                            } else if (list.get(61).doubleValue() <= 48.0d) {
                                return 0.36145946131939416d;
                            } else {
                                return 0.22882307409229924d;
                            }
                        }
                    } else if (list.get(71).doubleValue() > 48.0d) {
                        if (list.get(55).doubleValue() <= 48.0d) {
                            if (list.get(55).doubleValue() <= 8.0d) {
                                if (list.get(61).doubleValue() <= 48.0d) {
                                    if (list.get(69).doubleValue() <= 48.0d) {
                                        return 0.037009914297312096d;
                                    }
                                    return 0.07688297052769802d;
                                }
                                return 0.034174684577997355d;
                            } else if (list.get(56).doubleValue() > 6.811500072479248d) {
                                if (list.get(39).doubleValue() <= 48.0d) {
                                    if (list.get(39).doubleValue() > 24.0d) {
                                        if (list.get(34).doubleValue() <= 1.5d) {
                                            return 0.30837944165935516d;
                                        }
                                        return 0.13979110652149118d;
                                    }
                                    return 0.15715279266165894d;
                                }
                                return 0.1192131925254678d;
                            } else {
                                return 0.058993088934881276d;
                            }
                        } else if (list.get(47).doubleValue() <= 48.0d) {
                            if (list.get(47).doubleValue() > 8.0d) {
                                if (list.get(48).doubleValue() <= 9.48799991607666d) {
                                    return 0.05404579260967886d;
                                }
                                return 0.11316574373177134d;
                            }
                            return 0.026066407820886105d;
                        } else {
                            return 0.02013369138835567d;
                        }
                    } else if (list.get(72).doubleValue() <= 8.121500015258789d) {
                        if (list.get(72).doubleValue() <= 2.138000011444092d) {
                            if (list.get(64).doubleValue() <= 1.7005000114440918d) {
                                if (list.get(72).doubleValue() <= 1.7005000114440918d) {
                                    return 0.5378508547956865d;
                                }
                                return 0.1334738343701853d;
                            }
                            return 0.8605904522224922d;
                        } else if (list.get(69).doubleValue() <= 8.0d) {
                            return 0.8031212894512074d;
                        } else {
                            if (list.get(53).doubleValue() <= 24.0d) {
                                if (list.get(64).doubleValue() <= 3.540500044822693d) {
                                    return 0.09158266040950473d;
                                }
                                return 0.14872022727957493d;
                            } else if (list.get(56).doubleValue() > 0.3465000092983246d) {
                                if (list.get(55).doubleValue() <= 72.0d) {
                                    if (list.get(63).doubleValue() <= 72.0d) {
                                        if (list.get(61).doubleValue() > 48.0d) {
                                            if (list.get(55).doubleValue() <= 24.0d) {
                                                return 0.12017566415256467d;
                                            }
                                            return 0.4199147291282946d;
                                        } else if (list.get(69).doubleValue() <= 48.0d) {
                                            return 0.34877670857531484d;
                                        } else {
                                            return 0.11747867345004168d;
                                        }
                                    } else if (list.get(69).doubleValue() <= 24.0d) {
                                        return 0.4717454909271485d;
                                    } else {
                                        return 0.12490536498577406d;
                                    }
                                }
                                return 0.11924164858777715d;
                            } else if (list.get(64).doubleValue() <= 2.012499988079071d) {
                                return 0.09556417303780715d;
                            } else {
                                return 0.7847172261903858d;
                            }
                        }
                    } else if (list.get(64).doubleValue() <= 8.126500129699707d) {
                        return 0.006210770947480718d;
                    } else {
                        if (list.get(69).doubleValue() <= 100.0d) {
                            if (list.get(69).doubleValue() <= 48.0d) {
                                if (list.get(61).doubleValue() <= 8.0d) {
                                    return 0.46642530381679537d;
                                }
                                return 0.13200978916382317d;
                            } else if (list.get(72).doubleValue() <= 11.473499774932861d) {
                                return 0.12390531403594206d;
                            } else {
                                if (list.get(64).doubleValue() > 11.47249984741211d) {
                                    if (list.get(8).doubleValue() <= 0.3465000092983246d) {
                                        if (list.get(72).doubleValue() <= 12.780499935150146d) {
                                            return 0.11230241612736243d;
                                        }
                                        if (list.get(64).doubleValue() <= 12.785500049591064d) {
                                            return 0.006966849330536165d;
                                        }
                                        return 0.07789286722807251d;
                                    }
                                    return 0.036714851744738715d;
                                }
                                return 0.0056481774945831295d;
                            }
                        }
                        return 0.16627780363430286d;
                    }
                }
                return 0.004527134207928718d;
            } else if (list.get(58).doubleValue() <= 1.5d) {
                if (list.get(71).doubleValue() <= 48.0d) {
                    if (list.get(71).doubleValue() > 8.0d) {
                        if (list.get(66).doubleValue() <= 1.5d) {
                            if (list.get(71).doubleValue() <= 24.0d) {
                                return 0.13820179013850778d;
                            }
                            return 0.035902685230826056d;
                        } else if (list.get(71).doubleValue() <= 24.0d) {
                            if (list.get(61).doubleValue() <= 24.0d) {
                                return 0.15455086227274825d;
                            }
                            if (list.get(61).doubleValue() <= 48.0d) {
                                if (list.get(56).doubleValue() <= 7.676000118255615d) {
                                    return 0.28381239412618536d;
                                }
                                return 0.4915430839375957d;
                            }
                            return 0.18469976050007567d;
                        } else if (list.get(72).doubleValue() <= 12.888499736785889d) {
                            return 0.207595648341906d;
                        } else {
                            if (list.get(64).doubleValue() <= 12.891499996185303d) {
                                return 0.028365758114549423d;
                            }
                            if (list.get(61).doubleValue() <= 24.0d) {
                                return 0.06368425164071499d;
                            }
                            if (list.get(61).doubleValue() <= 48.0d) {
                                return 0.19047572919596434d;
                            }
                            return 0.10904369308276808d;
                        }
                    } else if (list.get(61).doubleValue() <= 48.0d) {
                        if (list.get(59).doubleValue() <= 24.0d) {
                            return 0.09083270119179954d;
                        }
                        return 0.2599235730807104d;
                    } else {
                        return 0.035153731860635945d;
                    }
                } else if (list.get(61).doubleValue() <= 48.0d) {
                    if (list.get(50).doubleValue() <= 1.5d) {
                        if (list.get(59).doubleValue() > 24.0d) {
                            if (list.get(59).doubleValue() <= 48.0d) {
                                if (list.get(50).doubleValue() <= 0.5d) {
                                    return 0.7222648613463493d;
                                }
                                if (list.get(56).doubleValue() <= 9.401500225067139d) {
                                    return 0.3395787700204752d;
                                }
                                return 0.5931993337500647d;
                            }
                            return 0.20954121538414539d;
                        } else if (list.get(69).doubleValue() > 48.0d) {
                            if (list.get(55).doubleValue() <= 72.0d) {
                                if (list.get(69).doubleValue() <= 72.0d) {
                                    if (list.get(66).doubleValue() <= 1.5d) {
                                        return 0.25874853737064096d;
                                    }
                                    return 0.5693448905529844d;
                                } else if (list.get(67).doubleValue() <= 40.5d) {
                                    return 0.38583826378975705d;
                                } else {
                                    return 0.2578433237194831d;
                                }
                            }
                            return 0.21548286130107838d;
                        } else {
                            return 0.18430507760476297d;
                        }
                    } else if (list.get(61).doubleValue() <= 24.0d) {
                        if (list.get(66).doubleValue() <= 1.5d) {
                            return 0.18576621460683998d;
                        }
                        return 0.43623603194336086d;
                    } else if (list.get(55).doubleValue() <= 48.0d) {
                        if (list.get(55).doubleValue() <= 8.0d) {
                            return 0.1613465104950592d;
                        }
                        return 0.7597312253561055d;
                    } else {
                        return 0.16702357059683326d;
                    }
                } else if (list.get(53).doubleValue() <= 48.0d) {
                    if (list.get(42).doubleValue() <= 1.5d) {
                        if (list.get(63).doubleValue() <= 100.0d) {
                            if (list.get(64).doubleValue() <= 7.412499904632568d) {
                                return 0.17579748158216296d;
                            }
                            return 0.27040933050661403d;
                        }
                        return 0.16692216378858019d;
                    } else if (list.get(47).doubleValue() <= 48.0d) {
                        if (list.get(47).doubleValue() <= 24.0d) {
                            return 0.3229551136822385d;
                        }
                        return 0.5675301732136363d;
                    } else {
                        return 0.14310937070777588d;
                    }
                } else if (list.get(23).doubleValue() <= 48.0d) {
                    if (list.get(23).doubleValue() <= 24.0d) {
                        if (list.get(55).doubleValue() <= 72.0d) {
                            return 0.2132123249298603d;
                        }
                        return 0.13655099394466014d;
                    } else if (list.get(45).doubleValue() <= 48.0d) {
                        return 0.6390436588830891d;
                    } else {
                        return 0.284129059166714d;
                    }
                } else if (list.get(31).doubleValue() > 48.0d) {
                    if (list.get(39).doubleValue() <= 48.0d) {
                        return 0.25114241632439677d;
                    }
                    return 0.06036324070080067d;
                } else {
                    return 0.30661099327237457d;
                }
            } else if (list.get(71).doubleValue() > 8.0d) {
                if (list.get(55).doubleValue() <= 48.0d) {
                    if (list.get(55).doubleValue() <= 24.0d) {
                        if (list.get(72).doubleValue() <= 8.792500019073486d) {
                            if (list.get(71).doubleValue() <= 48.0d) {
                                if (list.get(72).doubleValue() <= 6.1559998989105225d) {
                                    if (list.get(69).doubleValue() <= 48.0d) {
                                        return 0.380884745533235d;
                                    }
                                    if (list.get(69).doubleValue() <= 72.0d) {
                                        return 0.17728165073518942d;
                                    }
                                    if (list.get(63).doubleValue() <= 72.0d) {
                                        if (list.get(71).doubleValue() <= 24.0d) {
                                            return 0.11328210498192418d;
                                        }
                                        return 0.4843777246111869d;
                                    }
                                    return 0.2139355960542778d;
                                } else if (list.get(64).doubleValue() <= 5.552500009536743d) {
                                    return 0.049533288957635785d;
                                } else {
                                    return 0.1853465357614432d;
                                }
                            } else if (list.get(72).doubleValue() <= 3.9795000553131104d) {
                                if (list.get(63).doubleValue() <= 72.0d) {
                                    if (list.get(69).doubleValue() <= 48.0d) {
                                        return 0.05033075470339982d;
                                    }
                                    return 0.16902710604071047d;
                                }
                                return 0.040461332248446544d;
                            } else if (list.get(64).doubleValue() <= 3.450000047683716d) {
                                if (list.get(63).doubleValue() <= 72.0d) {
                                    return 0.40401934235304854d;
                                }
                                return 0.21852198444463522d;
                            } else {
                                return 0.10417031021900178d;
                            }
                        } else if (list.get(61).doubleValue() <= 48.0d) {
                            if (list.get(71).doubleValue() > 48.0d) {
                                if (list.get(59).doubleValue() <= 8.5d) {
                                    return 0.13969058853433317d;
                                }
                                if (list.get(69).doubleValue() <= 48.0d) {
                                    return 0.1196160834706413d;
                                }
                                return 0.30344790532689525d;
                            } else if (list.get(71).doubleValue() <= 24.0d) {
                                if (list.get(53).doubleValue() <= 48.0d) {
                                    return 0.16137896591669293d;
                                }
                                return 0.0619088707659014d;
                            } else {
                                return 0.050156285332364464d;
                            }
                        } else {
                            return 0.07685374894545531d;
                        }
                    } else if (list.get(71).doubleValue() <= 48.0d) {
                        if (list.get(71).doubleValue() <= 24.0d) {
                            return 0.28902877581348235d;
                        }
                        if (list.get(72).doubleValue() <= 6.191499948501587d) {
                            return 0.3847783170709536d;
                        }
                        if (list.get(69).doubleValue() <= 48.0d) {
                            return 0.18549078250059559d;
                        }
                        return 0.055005816873145236d;
                    } else if (list.get(56).doubleValue() > 9.382999897003174d) {
                        if (list.get(39).doubleValue() > 48.0d) {
                            if (list.get(37).doubleValue() <= 48.0d) {
                                return 0.37644944006417685d;
                            }
                            return 0.20925346629824057d;
                        } else if (list.get(39).doubleValue() <= 24.0d) {
                            return 0.4038629483577997d;
                        } else {
                            return 0.5322459160100456d;
                        }
                    } else if (list.get(72).doubleValue() <= 5.198499917984009d) {
                        return 0.051250152635510034d;
                    } else {
                        return 0.21924162490643517d;
                    }
                } else if (list.get(71).doubleValue() <= 48.0d) {
                    if (list.get(72).doubleValue() <= 7.755499839782715d) {
                        if (list.get(55).doubleValue() <= 72.0d) {
                            if (list.get(71).doubleValue() <= 24.0d) {
                                return 0.1208711730772686d;
                            }
                            return 0.4712873883025032d;
                        }
                        return 0.19519569615618107d;
                    } else if (list.get(5).doubleValue() <= 8.0d) {
                        return 0.09969212057007684d;
                    } else {
                        return 0.04823065142176312d;
                    }
                } else if (list.get(47).doubleValue() <= 48.0d) {
                    if (list.get(48).doubleValue() <= 8.354000091552734d) {
                        return 0.0634277889279086d;
                    }
                    if (list.get(47).doubleValue() > 24.0d) {
                        if (list.get(37).doubleValue() <= 48.0d) {
                            return 0.35273910411800913d;
                        }
                        return 0.19982809219916692d;
                    }
                    return 0.12912505871451133d;
                } else {
                    return 0.047834108392624766d;
                }
            } else {
                return 0.02386173724358529d;
            }
        } else if (list.get(71).doubleValue() <= 100.0d) {
            if (list.get(74).doubleValue() > 1.5d) {
                if (list.get(66).doubleValue() <= 1.5d) {
                    if (list.get(61).doubleValue() <= 48.0d) {
                        if (list.get(50).doubleValue() > 1.5d) {
                            if (list.get(58).doubleValue() <= 1.5d) {
                                if (list.get(55).doubleValue() <= 48.0d) {
                                    if (list.get(55).doubleValue() <= 24.0d) {
                                        if (list.get(63).doubleValue() > 72.0d) {
                                            if (list.get(55).doubleValue() <= 8.0d) {
                                                return 0.056234356481581926d;
                                            }
                                            return 0.5476310769059549d;
                                        }
                                        return 0.21841085881064293d;
                                    } else if (list.get(69).doubleValue() > 48.0d) {
                                        if (list.get(45).doubleValue() <= 48.0d) {
                                            return 0.6486468182276871d;
                                        }
                                        return 0.4331180337745293d;
                                    } else {
                                        return 0.7756145468602578d;
                                    }
                                }
                                return 0.0506660578719544d;
                            } else if (list.get(55).doubleValue() <= 48.0d) {
                                return 0.22106392347107842d;
                            } else {
                                return 0.04891946322673405d;
                            }
                        } else if (list.get(72).doubleValue() > 7.232499837875366d) {
                            if (list.get(58).doubleValue() <= 1.5d) {
                                if (list.get(59).doubleValue() <= 24.0d) {
                                    if (list.get(55).doubleValue() > 48.0d) {
                                        if (list.get(42).doubleValue() <= 1.5d) {
                                            return 0.12106271720755794d;
                                        }
                                        if (list.get(47).doubleValue() <= 48.0d) {
                                            return 0.5365950603957917d;
                                        }
                                        return 0.038607566538523486d;
                                    } else if (list.get(55).doubleValue() <= 24.0d) {
                                        return 0.21724174801347546d;
                                    } else {
                                        return 0.3883354633005144d;
                                    }
                                } else if (list.get(59).doubleValue() <= 48.0d) {
                                    return 0.4670892906174795d;
                                } else {
                                    return 0.13062825808923043d;
                                }
                            }
                            return 0.09076136771221015d;
                        } else {
                            return 0.015275001544870612d;
                        }
                    } else if (list.get(53).doubleValue() <= 48.0d) {
                        if (list.get(51).doubleValue() <= 0.5d) {
                            return 0.05094483415909501d;
                        }
                        if (list.get(47).doubleValue() <= 48.0d) {
                            if (list.get(58).doubleValue() <= 1.5d) {
                                if (list.get(48).doubleValue() <= 7.936000108718872d) {
                                    return 0.17360240563607235d;
                                }
                                return 0.37732831833227204d;
                            }
                            return 0.14703116301860522d;
                        }
                        return 0.088236856458999d;
                    } else {
                        return 0.03342943638281432d;
                    }
                } else if (list.get(61).doubleValue() <= 48.0d) {
                    if (list.get(56).doubleValue() > 9.100500106811523d) {
                        if (list.get(55).doubleValue() <= 48.0d) {
                            if (list.get(55).doubleValue() > 24.0d) {
                                if (list.get(45).doubleValue() <= 48.0d) {
                                    if (list.get(47).doubleValue() <= 72.0d) {
                                        return 0.18893469462143908d;
                                    }
                                    return 0.3715836883075431d;
                                }
                                return 0.12424000359422653d;
                            }
                            return 0.08177997172289944d;
                        }
                        return 0.017857280016244384d;
                    } else if (list.get(72).doubleValue() <= 5.856499910354614d) {
                        return 0.005409082811410308d;
                    } else {
                        return 0.034425200521792876d;
                    }
                } else {
                    return 0.00777650135170218d;
                }
            } else if (list.get(63).doubleValue() <= 72.0d) {
                if (list.get(61).doubleValue() <= 48.0d) {
                    if (list.get(55).doubleValue() <= 48.0d) {
                        if (list.get(56).doubleValue() <= 7.4664998054504395d) {
                            return 0.02655807096568883d;
                        }
                        return 0.07448322223283478d;
                    }
                    return 0.010576024242834995d;
                }
                return 0.010371306630733362d;
            } else {
                return 0.0045532464292122425d;
            }
        } else {
            return 7.653804284453284E-4d;
        }
    }

    private final double tree2(List<Double> list) {
        if (list.get(63).doubleValue() <= 72.0d) {
            if (list.get(63).doubleValue() > 48.0d) {
                if (list.get(74).doubleValue() <= 1.5d) {
                    if (list.get(58).doubleValue() <= 1.5d) {
                        if (list.get(71).doubleValue() <= 100.0d) {
                            if (list.get(47).doubleValue() > 72.0d) {
                                if (list.get(55).doubleValue() <= 72.0d) {
                                    if (list.get(39).doubleValue() <= 72.0d) {
                                        if (list.get(39).doubleValue() <= 48.0d) {
                                            if (list.get(71).doubleValue() > 8.0d) {
                                                if (list.get(64).doubleValue() <= 4.204999923706055d) {
                                                    return 0.23531235513042517d;
                                                }
                                                return 0.41139341236084603d;
                                            }
                                            return 0.21156875131356676d;
                                        }
                                        return 0.5513521445621427d;
                                    } else if (list.get(71).doubleValue() <= 72.0d) {
                                        if (list.get(71).doubleValue() <= 48.0d) {
                                            return 0.24691516332096328d;
                                        }
                                        if (list.get(72).doubleValue() > 9.833499908447266d) {
                                            if (list.get(64).doubleValue() <= 9.907999992370605d) {
                                                return 0.03546990196889219d;
                                            }
                                            return 0.43530139241126486d;
                                        }
                                        return 0.6328054099633972d;
                                    } else {
                                        return 0.1390083067419103d;
                                    }
                                } else if (list.get(64).doubleValue() > 5.987499952316284d) {
                                    if (list.get(39).doubleValue() <= 72.0d) {
                                        if (list.get(39).doubleValue() <= 48.0d) {
                                            if (list.get(71).doubleValue() <= 24.0d) {
                                                return 0.13695722637761676d;
                                            }
                                            return 0.2830117568718819d;
                                        } else if (list.get(71).doubleValue() <= 72.0d) {
                                            return 0.3050263847634467d;
                                        } else {
                                            return 0.4711663575670229d;
                                        }
                                    }
                                    return 0.18548228719396903d;
                                } else {
                                    return 0.10386143822354224d;
                                }
                            } else if (list.get(47).doubleValue() <= 48.0d) {
                                if (list.get(64).doubleValue() > 6.08299994468689d) {
                                    if (list.get(55).doubleValue() <= 100.0d) {
                                        if (list.get(71).doubleValue() <= 8.0d) {
                                            if (list.get(61).doubleValue() <= 72.0d) {
                                                if (list.get(69).doubleValue() <= 48.0d) {
                                                    return 0.21722225749066898d;
                                                }
                                                return 0.39811420266435055d;
                                            }
                                            return 0.16626967002371398d;
                                        } else if (list.get(45).doubleValue() <= 72.0d) {
                                            if (list.get(66).doubleValue() <= 1.5d) {
                                                if (list.get(59).doubleValue() <= 0.5d) {
                                                    if (list.get(71).doubleValue() <= 72.0d) {
                                                        return 0.49158569840590355d;
                                                    }
                                                    if (list.get(61).doubleValue() <= 72.0d) {
                                                        return 0.25322079342252624d;
                                                    }
                                                    return 0.5457616227283848d;
                                                } else if (list.get(45).doubleValue() <= 48.0d) {
                                                    if (list.get(69).doubleValue() <= 100.0d) {
                                                        if (list.get(69).doubleValue() <= 72.0d) {
                                                            if (list.get(61).doubleValue() <= 100.0d) {
                                                                if (list.get(53).doubleValue() <= 72.0d) {
                                                                    if (list.get(53).doubleValue() <= 48.0d) {
                                                                        if (list.get(61).doubleValue() <= 72.0d) {
                                                                            if (list.get(71).doubleValue() <= 72.0d) {
                                                                                if (list.get(53).doubleValue() <= 8.0d) {
                                                                                    if (list.get(69).doubleValue() <= 24.0d) {
                                                                                        return 0.7928483907373682d;
                                                                                    }
                                                                                    return 0.5840150491743972d;
                                                                                }
                                                                                return 0.48067212089903183d;
                                                                            } else if (list.get(69).doubleValue() <= 48.0d) {
                                                                                return 0.19749848998591338d;
                                                                            } else {
                                                                                if (list.get(61).doubleValue() <= 48.0d) {
                                                                                    return 0.43208664584067474d;
                                                                                }
                                                                                return 0.27984872711804465d;
                                                                            }
                                                                        } else if (list.get(71).doubleValue() <= 72.0d) {
                                                                            return 0.3503551458175419d;
                                                                        } else {
                                                                            return 0.6173425958391803d;
                                                                        }
                                                                    } else if (list.get(56).doubleValue() > 2.441499948501587d) {
                                                                        if (list.get(51).doubleValue() <= 0.5d) {
                                                                            return 0.4702531387342415d;
                                                                        }
                                                                        if (list.get(71).doubleValue() <= 72.0d) {
                                                                            if (list.get(55).doubleValue() <= 72.0d) {
                                                                                return 0.6976208015278929d;
                                                                            }
                                                                            return 0.4262713132010269d;
                                                                        } else if (list.get(55).doubleValue() <= 24.0d) {
                                                                            return 0.4773883265719566d;
                                                                        } else {
                                                                            return 0.7592660509248822d;
                                                                        }
                                                                    } else if (list.get(71).doubleValue() <= 72.0d) {
                                                                        return 0.631094077533042d;
                                                                    } else {
                                                                        return 0.24975336104852158d;
                                                                    }
                                                                } else if (list.get(56).doubleValue() <= 0.3465000092983246d) {
                                                                    return 0.16616845214033016d;
                                                                } else {
                                                                    return 0.4270292593207244d;
                                                                }
                                                            }
                                                            return 0.33494877743755636d;
                                                        }
                                                        return 0.3046540726394222d;
                                                    } else if (list.get(71).doubleValue() <= 72.0d) {
                                                        if (list.get(71).doubleValue() > 48.0d) {
                                                            if (list.get(55).doubleValue() <= 72.0d) {
                                                                return 0.8137360742190699d;
                                                            }
                                                            return 0.5440104183120033d;
                                                        }
                                                        return 0.36994631576632697d;
                                                    } else {
                                                        return 0.38188782846782265d;
                                                    }
                                                } else {
                                                    return 0.5649028005394495d;
                                                }
                                            } else if (list.get(61).doubleValue() <= 48.0d) {
                                                if (list.get(71).doubleValue() <= 48.0d) {
                                                    if (list.get(53).doubleValue() <= 72.0d) {
                                                        return 0.7732181116445744d;
                                                    }
                                                    return 0.45522726926247814d;
                                                }
                                                return 0.4301553314480071d;
                                            } else {
                                                return 0.4079726287490089d;
                                            }
                                        } else {
                                            return 0.36586303177970114d;
                                        }
                                    }
                                    return 0.22387735998876407d;
                                } else if (list.get(72).doubleValue() <= 9.065999984741211d) {
                                    if (list.get(71).doubleValue() <= 72.0d) {
                                        if (list.get(71).doubleValue() <= 48.0d) {
                                            if (list.get(61).doubleValue() <= 72.0d) {
                                                if (list.get(53).doubleValue() <= 72.0d) {
                                                    if (list.get(55).doubleValue() <= 72.0d) {
                                                        if (list.get(69).doubleValue() <= 72.0d) {
                                                            if (list.get(69).doubleValue() <= 48.0d) {
                                                                if (list.get(55).doubleValue() <= 48.0d) {
                                                                    return 0.39741288492245985d;
                                                                }
                                                                return 0.6881425327520623d;
                                                            } else if (list.get(45).doubleValue() <= 72.0d) {
                                                                return 0.6188833874645887d;
                                                            } else {
                                                                return 0.1697906397411134d;
                                                            }
                                                        }
                                                        return 0.2658679193454898d;
                                                    }
                                                    return 0.22335363163923225d;
                                                }
                                                return 0.19512168313065015d;
                                            } else if (list.get(71).doubleValue() <= 24.0d) {
                                                return 0.09123277084618031d;
                                            } else {
                                                return 0.24920318246024467d;
                                            }
                                        } else if (list.get(72).doubleValue() <= 6.767500162124634d) {
                                            if (list.get(72).doubleValue() > 1.2425000071525574d) {
                                                if (list.get(64).doubleValue() > 0.8959999978542328d) {
                                                    if (list.get(55).doubleValue() <= 72.0d) {
                                                        if (list.get(55).doubleValue() <= 48.0d) {
                                                            if (list.get(69).doubleValue() <= 48.0d) {
                                                                if (list.get(55).doubleValue() <= 24.0d) {
                                                                    return 0.8235871072816139d;
                                                                }
                                                                if (list.get(53).doubleValue() <= 48.0d) {
                                                                    return 0.3998989503588577d;
                                                                }
                                                                return 0.8271531593976634d;
                                                            } else if (list.get(61).doubleValue() > 48.0d) {
                                                                if (list.get(64).doubleValue() <= 2.8615000247955322d) {
                                                                    if (list.get(61).doubleValue() <= 72.0d) {
                                                                        return 0.8979961008188271d;
                                                                    }
                                                                    return 0.49991870252013415d;
                                                                }
                                                                return 0.831561051097578d;
                                                            } else {
                                                                return 0.37606989015892683d;
                                                            }
                                                        }
                                                        return 0.8957024785009164d;
                                                    }
                                                    return 0.47481207824069005d;
                                                }
                                                return 0.3577716618159513d;
                                            }
                                            return 0.9846621125591972d;
                                        } else if (list.get(69).doubleValue() <= 100.0d) {
                                            return 0.16091865134941197d;
                                        } else {
                                            return 0.5846253092908724d;
                                        }
                                    } else if (list.get(72).doubleValue() <= 4.619999885559082d) {
                                        if (list.get(72).doubleValue() > 3.1130000352859497d) {
                                            if (list.get(50).doubleValue() <= 0.5d) {
                                                return 0.2479642075740924d;
                                            }
                                            return 0.11103387248164223d;
                                        }
                                        return 0.06922355957645537d;
                                    } else if (list.get(72).doubleValue() <= 6.0269999504089355d) {
                                        if (list.get(64).doubleValue() <= 4.166499853134155d) {
                                            return 0.43697027948294437d;
                                        }
                                        if (list.get(61).doubleValue() <= 72.0d) {
                                            return 0.14994388284498794d;
                                        }
                                        return 0.3548423440800701d;
                                    } else {
                                        return 0.5043418927335945d;
                                    }
                                } else if (list.get(71).doubleValue() <= 72.0d) {
                                    if (list.get(71).doubleValue() <= 48.0d) {
                                        if (list.get(61).doubleValue() <= 48.0d) {
                                            return 0.3264507207476483d;
                                        }
                                        return 0.13422735150437803d;
                                    }
                                    return 0.07269772974843919d;
                                } else if (list.get(69).doubleValue() <= 72.0d) {
                                    if (list.get(72).doubleValue() <= 12.643499851226807d) {
                                        return 0.3970735627512615d;
                                    }
                                    return 0.27429743417992425d;
                                } else {
                                    return 0.14885572243642897d;
                                }
                            } else if (list.get(55).doubleValue() <= 100.0d) {
                                if (list.get(31).doubleValue() <= 72.0d) {
                                    if (list.get(31).doubleValue() <= 48.0d) {
                                        if (list.get(48).doubleValue() <= 5.949000120162964d) {
                                            if (list.get(72).doubleValue() > 7.181999921798706d) {
                                                if (list.get(64).doubleValue() <= 7.301499843597412d) {
                                                    return 0.24125775978386266d;
                                                }
                                                return 0.5286002016769207d;
                                            } else if (list.get(71).doubleValue() <= 72.0d) {
                                                if (list.get(71).doubleValue() <= 48.0d) {
                                                    if (list.get(45).doubleValue() <= 72.0d) {
                                                        return 0.7148513652646216d;
                                                    }
                                                    return 0.2825759035784417d;
                                                }
                                                return 0.8908771489553308d;
                                            } else {
                                                return 0.348498135330599d;
                                            }
                                        } else if (list.get(71).doubleValue() <= 72.0d) {
                                            if (list.get(55).doubleValue() <= 72.0d) {
                                                if (list.get(39).doubleValue() <= 72.0d) {
                                                    return 0.7561806934030075d;
                                                }
                                                return 0.5569292443062295d;
                                            }
                                            return 0.42054378304298706d;
                                        } else if (list.get(53).doubleValue() <= 48.0d) {
                                            return 0.5444901853639325d;
                                        } else {
                                            if (list.get(69).doubleValue() <= 72.0d) {
                                                if (list.get(55).doubleValue() <= 72.0d) {
                                                    return 0.7049344317088803d;
                                                }
                                                return 0.8491935406625271d;
                                            }
                                            return 0.47865603652096145d;
                                        }
                                    } else if (list.get(15).doubleValue() <= 72.0d) {
                                        if (list.get(15).doubleValue() > 48.0d) {
                                            if (list.get(55).doubleValue() <= 72.0d) {
                                                return 0.8963809990957046d;
                                            }
                                            if (list.get(71).doubleValue() <= 72.0d) {
                                                if (list.get(39).doubleValue() <= 72.0d) {
                                                    return 0.7065540383352588d;
                                                }
                                                return 0.36961488718457364d;
                                            }
                                            return 0.8925548089862816d;
                                        }
                                        return 0.7563012996823898d;
                                    } else {
                                        return 0.6470563871547311d;
                                    }
                                } else if (list.get(23).doubleValue() <= 72.0d) {
                                    return 0.5674710939660431d;
                                } else {
                                    return 0.42612088766957246d;
                                }
                            } else if (list.get(53).doubleValue() <= 8.0d) {
                                return 0.08028831910965285d;
                            } else {
                                return 0.3820093932271529d;
                            }
                        } else if (list.get(69).doubleValue() <= 100.0d) {
                            if (list.get(69).doubleValue() <= 8.0d) {
                                if (list.get(61).doubleValue() > 48.0d) {
                                    if (list.get(67).doubleValue() <= 60.5d) {
                                        return 0.9334706276246099d;
                                    }
                                    return 0.04611260704197256d;
                                }
                                return 0.449969397000529d;
                            } else if (list.get(61).doubleValue() <= 100.0d) {
                                if (list.get(56).doubleValue() <= 6.055500030517578d) {
                                    return 0.04899820528574246d;
                                }
                                if (list.get(47).doubleValue() <= 72.0d) {
                                    if (list.get(47).doubleValue() > 48.0d) {
                                        if (list.get(55).doubleValue() <= 100.0d) {
                                            return 0.1980556550826781d;
                                        }
                                        return 0.387549763785376d;
                                    }
                                    return 0.10335837173852236d;
                                }
                                return 0.0713483521825625d;
                            } else if (list.get(53).doubleValue() <= 72.0d) {
                                if (list.get(53).doubleValue() <= 48.0d) {
                                    return 0.13093920232942094d;
                                }
                                if (list.get(47).doubleValue() <= 72.0d) {
                                    if (list.get(47).doubleValue() <= 48.0d) {
                                        return 0.27436226250212736d;
                                    }
                                    return 0.4543968843614651d;
                                }
                                return 0.12547266079347122d;
                            } else {
                                return 0.10150890949506641d;
                            }
                        } else if (list.get(61).doubleValue() <= 100.0d) {
                            if (list.get(53).doubleValue() <= 100.0d) {
                                if (list.get(67).doubleValue() <= 32.5d) {
                                    return 0.5338541109377224d;
                                }
                                return 0.04682305838828749d;
                            } else if (list.get(67).doubleValue() <= 32.5d) {
                                if (list.get(61).doubleValue() <= 72.0d) {
                                    return 0.94640438522893d;
                                }
                                return 0.1772353008487507d;
                            } else {
                                return 0.02799148447992329d;
                            }
                        } else {
                            return 0.0463664205115587d;
                        }
                    } else if (list.get(71).doubleValue() <= 100.0d) {
                        if (list.get(66).doubleValue() <= 1.5d) {
                            if (list.get(71).doubleValue() > 8.0d) {
                                if (list.get(55).doubleValue() <= 100.0d) {
                                    if (list.get(56).doubleValue() <= 6.275500059127808d) {
                                        if (list.get(61).doubleValue() <= 100.0d) {
                                            return 0.28840738614071926d;
                                        }
                                        return 0.11091170779481116d;
                                    } else if (list.get(47).doubleValue() <= 72.0d) {
                                        if (list.get(47).doubleValue() > 48.0d) {
                                            if (list.get(42).doubleValue() <= 1.5d) {
                                                return 0.7065474364505469d;
                                            }
                                            return 0.44358009611236876d;
                                        }
                                        return 0.3980669847751784d;
                                    } else {
                                        return 0.2785485422281123d;
                                    }
                                }
                                return 0.1146837676037149d;
                            }
                            return 0.049954556168050564d;
                        } else if (list.get(61).doubleValue() <= 48.0d) {
                            if (list.get(71).doubleValue() > 24.0d) {
                                if (list.get(64).doubleValue() <= 10.819499969482422d) {
                                    return 0.13405677469484453d;
                                }
                                if (list.get(47).doubleValue() <= 72.0d) {
                                    return 0.31943280290543763d;
                                }
                                return 0.12239075325237062d;
                            } else if (list.get(61).doubleValue() <= 24.0d) {
                                if (list.get(48).doubleValue() <= 10.25950002670288d) {
                                    return 0.3957242792469966d;
                                }
                                return 0.6638445156957301d;
                            } else {
                                return 0.25286837813169677d;
                            }
                        } else if (list.get(71).doubleValue() <= 72.0d) {
                            return 0.051932489923236735d;
                        } else {
                            if (list.get(61).doubleValue() <= 100.0d) {
                                return 0.21543022936187256d;
                            }
                            return 0.03981087124109189d;
                        }
                    } else {
                        return 0.05194356741898984d;
                    }
                } else if (list.get(64).doubleValue() > 7.85699987411499d) {
                    if (list.get(66).doubleValue() <= 1.5d) {
                        if (list.get(71).doubleValue() > 72.0d) {
                            if (list.get(58).doubleValue() > 1.5d) {
                                if (list.get(50).doubleValue() <= 1.5d) {
                                    if (list.get(53).doubleValue() <= 48.0d) {
                                        if (list.get(71).doubleValue() <= 100.0d) {
                                            return 0.9018772996102582d;
                                        }
                                        return 0.7950313465538792d;
                                    } else if (list.get(53).doubleValue() <= 72.0d) {
                                        return 0.9627909667528098d;
                                    } else {
                                        return 0.8399759055532187d;
                                    }
                                } else if (list.get(71).doubleValue() <= 100.0d) {
                                    if (list.get(55).doubleValue() <= 48.0d) {
                                        return 0.7273050371842386d;
                                    }
                                    return 0.9262551836574853d;
                                } else if (list.get(32).doubleValue() <= 10.567999839782715d) {
                                    return 0.631394555219295d;
                                } else {
                                    return 0.7733567320033873d;
                                }
                            } else if (list.get(61).doubleValue() <= 48.0d) {
                                if (list.get(61).doubleValue() <= 24.0d) {
                                    return 0.3399544571498568d;
                                }
                                return 0.5109693221836885d;
                            } else if (list.get(47).doubleValue() <= 72.0d) {
                                if (list.get(47).doubleValue() <= 48.0d) {
                                    return 0.7233766985150379d;
                                }
                                return 0.9036235960120961d;
                            } else if (list.get(45).doubleValue() <= 72.0d) {
                                return 0.7124486154995208d;
                            } else {
                                return 0.47639930048775275d;
                            }
                        } else if (list.get(71).doubleValue() <= 48.0d) {
                            if (list.get(58).doubleValue() <= 1.5d) {
                                return 0.3850336957149842d;
                            }
                            return 0.6335141445119377d;
                        } else {
                            return 0.20723521881592377d;
                        }
                    } else if (list.get(71).doubleValue() > 100.0d) {
                        if (list.get(55).doubleValue() <= 100.0d) {
                            if (list.get(24).doubleValue() <= 10.748499870300293d) {
                                if (list.get(61).doubleValue() <= 100.0d) {
                                    return 0.1986897423781476d;
                                }
                                return 0.3191835283249447d;
                            }
                            return 0.3564811260698279d;
                        } else if (list.get(53).doubleValue() <= 72.0d) {
                            if (list.get(47).doubleValue() <= 72.0d) {
                                if (list.get(47).doubleValue() <= 24.0d) {
                                    return 0.4727707153752176d;
                                }
                                return 0.7071368268198716d;
                            }
                            return 0.2749395220845318d;
                        } else {
                            return 0.2043217557623565d;
                        }
                    } else if (list.get(71).doubleValue() <= 72.0d) {
                        if (list.get(55).doubleValue() <= 72.0d) {
                            if (list.get(47).doubleValue() <= 48.0d) {
                                if (list.get(58).doubleValue() <= 1.5d) {
                                    return 0.4177145461954619d;
                                }
                                if (list.get(61).doubleValue() <= 72.0d) {
                                    return 0.5796882915681925d;
                                }
                                return 0.4517115228292231d;
                            } else if (list.get(47).doubleValue() <= 72.0d) {
                                if (list.get(31).doubleValue() > 48.0d) {
                                    if (list.get(31).doubleValue() <= 72.0d) {
                                        return 0.813453970719423d;
                                    }
                                    return 0.6725340714736725d;
                                }
                                return 0.6508463553802104d;
                            } else {
                                return 0.5209756922350403d;
                            }
                        } else if (list.get(71).doubleValue() <= 8.0d) {
                            return 0.23943168654732055d;
                        } else {
                            if (list.get(69).doubleValue() <= 72.0d) {
                                if (list.get(53).doubleValue() <= 24.0d) {
                                    return 0.34883070907082514d;
                                }
                                if (list.get(53).doubleValue() <= 72.0d) {
                                    if (list.get(53).doubleValue() <= 48.0d) {
                                        return 0.44877505180540683d;
                                    }
                                    return 0.5751446891389924d;
                                }
                                return 0.39074096808201925d;
                            } else if (list.get(72).doubleValue() > 13.280499935150146d) {
                                if (list.get(64).doubleValue() <= 13.280499935150146d) {
                                    return 0.1074006827241572d;
                                }
                                return 0.3862983097745092d;
                            } else {
                                return 0.4793952602522346d;
                            }
                        }
                    } else if (list.get(47).doubleValue() > 72.0d) {
                        if (list.get(39).doubleValue() <= 72.0d) {
                            if (list.get(39).doubleValue() <= 48.0d) {
                                return 0.5140773230132176d;
                            }
                            return 0.7221537362636066d;
                        }
                        return 0.407935135651903d;
                    } else if (list.get(47).doubleValue() > 48.0d) {
                        if (list.get(55).doubleValue() <= 72.0d) {
                            return 0.7288785686192238d;
                        }
                        if (list.get(69).doubleValue() <= 72.0d) {
                            return 0.8962618720369968d;
                        }
                        return 0.5852288014106453d;
                    } else if (list.get(61).doubleValue() <= 72.0d) {
                        if (list.get(69).doubleValue() <= 48.0d) {
                            return 0.43399404582801604d;
                        }
                        return 0.6256977565127055d;
                    } else if (list.get(53).doubleValue() <= 72.0d) {
                        if (list.get(61).doubleValue() <= 100.0d) {
                            if (list.get(69).doubleValue() <= 72.0d) {
                                return 0.7862212630497638d;
                            }
                            return 0.4315942193404967d;
                        }
                        return 0.6094738552985969d;
                    } else {
                        return 0.5688475898784665d;
                    }
                } else if (list.get(71).doubleValue() <= 100.0d) {
                    if (list.get(72).doubleValue() <= 8.688499927520752d) {
                        if (list.get(71).doubleValue() <= 72.0d) {
                            if (list.get(71).doubleValue() <= 48.0d) {
                                if (list.get(61).doubleValue() <= 72.0d) {
                                    if (list.get(55).doubleValue() <= 72.0d) {
                                        if (list.get(71).doubleValue() <= 8.0d) {
                                            return 0.6452964035502583d;
                                        }
                                        return 0.4453406191148388d;
                                    }
                                    return 0.18638184608011416d;
                                } else if (list.get(71).doubleValue() <= 24.0d) {
                                    return 0.15838169478549502d;
                                } else {
                                    return 0.31146768318920975d;
                                }
                            } else if (list.get(72).doubleValue() <= 7.5625d) {
                                if (list.get(64).doubleValue() > 2.25d) {
                                    if (list.get(55).doubleValue() <= 72.0d) {
                                        return 0.8188471810245108d;
                                    }
                                    return 0.6006306275994837d;
                                } else if (list.get(72).doubleValue() <= 4.241000175476074d) {
                                    if (list.get(72).doubleValue() > 0.8959999978542328d) {
                                        if (list.get(64).doubleValue() <= 0.3465000092983246d) {
                                            return 0.41063438165717975d;
                                        }
                                        return 0.7320793139124105d;
                                    }
                                    return 0.9755313674064532d;
                                } else {
                                    return 0.2141207734662327d;
                                }
                            } else if (list.get(64).doubleValue() <= 6.008500099182129d) {
                                return 0.12619824777545047d;
                            } else {
                                return 0.70441256682534d;
                            }
                        } else if (list.get(72).doubleValue() <= 4.890499830245972d) {
                            if (list.get(72).doubleValue() > 2.9170000553131104d) {
                                if (list.get(55).doubleValue() <= 48.0d) {
                                    return 0.3355835797388277d;
                                }
                                return 0.10649422154962192d;
                            }
                            return 0.07526549356421365d;
                        } else if (list.get(47).doubleValue() <= 72.0d) {
                            return 0.5513742223750187d;
                        } else {
                            return 0.23142019559292834d;
                        }
                    } else if (list.get(71).doubleValue() <= 72.0d) {
                        if (list.get(71).doubleValue() <= 48.0d) {
                            if (list.get(61).doubleValue() <= 48.0d) {
                                return 0.4379753133830991d;
                            }
                            return 0.2362149078307474d;
                        }
                        return 0.0688802900095098d;
                    } else if (list.get(69).doubleValue() <= 72.0d) {
                        if (list.get(61).doubleValue() <= 24.0d) {
                            return 0.301661929636098d;
                        }
                        return 0.5596538228116715d;
                    } else {
                        return 0.3192517046378896d;
                    }
                } else {
                    return 0.1227621168952547d;
                }
            } else if (list.get(71).doubleValue() > 100.0d) {
                if (list.get(74).doubleValue() > 1.5d) {
                    if (list.get(66).doubleValue() <= 1.5d) {
                        if (list.get(63).doubleValue() > 8.0d) {
                            if (list.get(58).doubleValue() <= 1.5d) {
                                if (list.get(64).doubleValue() <= 7.940000057220459d) {
                                    return 0.11086100188998861d;
                                }
                                return 0.3966505004600549d;
                            } else if (list.get(63).doubleValue() <= 24.0d) {
                                return 0.5078526613320843d;
                            } else {
                                return 0.7483399872964882d;
                            }
                        } else if (list.get(61).doubleValue() <= 72.0d) {
                            if (list.get(55).doubleValue() <= 72.0d) {
                                if (list.get(55).doubleValue() <= 48.0d) {
                                    return 0.20895130159208378d;
                                }
                                return 0.7065910684235196d;
                            }
                            return 0.09653380967657778d;
                        } else {
                            return 0.06805050922550471d;
                        }
                    }
                    return 0.0409442423852715d;
                }
                return 0.016004150372462604d;
            } else if (list.get(61).doubleValue() <= 72.0d) {
                if (list.get(61).doubleValue() <= 48.0d) {
                    if (list.get(71).doubleValue() <= 24.0d) {
                        if (list.get(53).doubleValue() <= 48.0d) {
                            if (list.get(72).doubleValue() <= 7.50849986076355d) {
                                return 0.04798369402164756d;
                            }
                            if (list.get(71).doubleValue() <= 8.0d) {
                                return 0.06740546514699547d;
                            }
                            return 0.12805669419099344d;
                        } else if (list.get(53).doubleValue() <= 72.0d) {
                            if (list.get(72).doubleValue() <= 3.7494999170303345d) {
                                return 0.6546650629525973d;
                            }
                            return 0.21299232280087357d;
                        } else {
                            return 0.09986216797229404d;
                        }
                    } else if (list.get(71).doubleValue() <= 72.0d) {
                        if (list.get(72).doubleValue() <= 7.4624998569488525d) {
                            if (list.get(71).doubleValue() <= 48.0d) {
                                if (list.get(53).doubleValue() <= 48.0d) {
                                    return 0.11645345678500599d;
                                }
                                if (list.get(56).doubleValue() <= 0.8959999978542328d) {
                                    return 0.013609204570515936d;
                                }
                                if (list.get(69).doubleValue() <= 24.0d) {
                                    return 0.5017327462593625d;
                                }
                                return 0.17044226705921142d;
                            } else if (list.get(53).doubleValue() <= 72.0d) {
                                if (list.get(47).doubleValue() <= 72.0d) {
                                    if (list.get(72).doubleValue() > 4.986999988555908d) {
                                        if (list.get(64).doubleValue() <= 4.677500009536743d) {
                                            return 0.27155963392566923d;
                                        }
                                        return 0.4875350850823774d;
                                    } else if (list.get(45).doubleValue() <= 72.0d) {
                                        if (list.get(49).doubleValue() > 0.5d) {
                                            if (list.get(55).doubleValue() <= 72.0d) {
                                                return 0.6956205576498955d;
                                            }
                                            return 0.29443544711031744d;
                                        } else if (list.get(61).doubleValue() <= 24.0d) {
                                            return 0.356928848834964d;
                                        } else {
                                            return 0.5852038450008239d;
                                        }
                                    } else {
                                        return 0.18412832266651094d;
                                    }
                                }
                                return 0.1883055029394427d;
                            } else if (list.get(56).doubleValue() <= 0.5494999885559082d) {
                                return 0.9979802254173491d;
                            } else {
                                return 0.04549556457129042d;
                            }
                        } else if (list.get(71).doubleValue() > 48.0d) {
                            if (list.get(58).doubleValue() <= 1.5d) {
                                if (list.get(64).doubleValue() <= 7.396000146865845d) {
                                    return 0.07153330690572877d;
                                }
                                if (list.get(72).doubleValue() > 12.096499919891357d) {
                                    if (list.get(64).doubleValue() <= 12.104499816894531d) {
                                        return 0.032403225161254254d;
                                    }
                                    if (list.get(72).doubleValue() <= 13.560500144958496d) {
                                        return 0.23116221885158125d;
                                    }
                                    return 0.13444899582471942d;
                                }
                                return 0.2945863252943174d;
                            }
                            return 0.07558386566990023d;
                        } else if (list.get(69).doubleValue() <= 24.0d) {
                            if (list.get(53).doubleValue() <= 48.0d) {
                                if (list.get(63).doubleValue() <= 24.0d) {
                                    return 0.21280945055626305d;
                                }
                                return 0.08573170160517261d;
                            }
                            return 0.36356675092940044d;
                        } else {
                            return 0.11852433352288054d;
                        }
                    } else if (list.get(72).doubleValue() > 7.036499977111816d) {
                        if (list.get(58).doubleValue() <= 1.5d) {
                            if (list.get(55).doubleValue() > 8.0d) {
                                if (list.get(55).doubleValue() <= 72.0d) {
                                    if (list.get(63).doubleValue() <= 8.0d) {
                                        if (list.get(55).doubleValue() <= 24.0d) {
                                            return 0.09601328991019466d;
                                        }
                                        return 0.2390498945615705d;
                                    }
                                    return 0.2725706557826873d;
                                }
                                return 0.09274535845882344d;
                            } else if (list.get(69).doubleValue() <= 24.0d) {
                                if (list.get(61).doubleValue() <= 24.0d) {
                                    return 0.09517541190113715d;
                                }
                                return 0.2937153772198318d;
                            } else {
                                return 0.0971861105021249d;
                            }
                        } else if (list.get(63).doubleValue() <= 8.0d) {
                            return 0.14920574671803533d;
                        } else {
                            return 0.2768206498610998d;
                        }
                    } else {
                        return 0.03536488486710845d;
                    }
                } else if (list.get(72).doubleValue() <= 3.8394999504089355d) {
                    if (list.get(69).doubleValue() <= 48.0d) {
                        if (list.get(71).doubleValue() <= 72.0d) {
                            if (list.get(53).doubleValue() <= 72.0d) {
                                if (list.get(71).doubleValue() <= 8.0d) {
                                    return 0.8422854176666934d;
                                }
                                if (list.get(71).doubleValue() <= 24.0d) {
                                    if (list.get(74).doubleValue() <= 1.5d) {
                                        return 0.6244363924833121d;
                                    }
                                    return 0.30144200612493693d;
                                }
                                return 0.7652074565434751d;
                            }
                            return 0.20583235500361843d;
                        }
                        return 0.24552112550488595d;
                    } else if (list.get(71).doubleValue() <= 72.0d) {
                        if (list.get(71).doubleValue() > 48.0d) {
                            if (list.get(63).doubleValue() <= 8.0d) {
                                if (list.get(51).doubleValue() <= 0.5d) {
                                    return 0.050257604371301765d;
                                }
                                return 0.7618425689815056d;
                            }
                            return 0.9032710248496505d;
                        } else if (list.get(71).doubleValue() > 8.0d) {
                            if (list.get(63).doubleValue() <= 8.0d) {
                                if (list.get(64).doubleValue() <= 2.138000011444092d) {
                                    return 0.7329285733887002d;
                                }
                                return 0.3857135491231484d;
                            } else if (list.get(55).doubleValue() <= 48.0d) {
                                return 0.1257742732501235d;
                            } else {
                                if (list.get(53).doubleValue() <= 72.0d) {
                                    return 0.5758086233313329d;
                                }
                                return 0.07907684813611783d;
                            }
                        } else if (list.get(45).doubleValue() <= 24.0d) {
                            return 0.6395653648624957d;
                        } else {
                            return 0.18488699809023348d;
                        }
                    } else {
                        return 0.06494868255578949d;
                    }
                } else if (list.get(71).doubleValue() > 72.0d) {
                    if (list.get(55).doubleValue() <= 72.0d) {
                        if (list.get(55).doubleValue() <= 48.0d) {
                            if (list.get(63).doubleValue() <= 8.0d) {
                                if (list.get(74).doubleValue() > 1.5d) {
                                    if (list.get(66).doubleValue() <= 1.5d) {
                                        return 0.6743815645642646d;
                                    }
                                    return 0.28936598757799303d;
                                }
                                return 0.10184649338055243d;
                            } else if (list.get(59).doubleValue() <= 72.0d) {
                                if (list.get(66).doubleValue() > 1.5d) {
                                    if (list.get(74).doubleValue() <= 1.5d) {
                                        return 0.2658696565549912d;
                                    }
                                    return 0.4484257736739134d;
                                }
                                return 0.33100880655090825d;
                            } else {
                                return 0.19941134237420188d;
                            }
                        } else if (list.get(56).doubleValue() > 5.198499917984009d) {
                            if (list.get(39).doubleValue() <= 72.0d) {
                                if (list.get(39).doubleValue() <= 48.0d) {
                                    if (list.get(31).doubleValue() <= 72.0d) {
                                        return 0.5304510886548501d;
                                    }
                                    return 0.3487582676819985d;
                                }
                                return 0.6303074352009338d;
                            }
                            return 0.4042246461750197d;
                        } else {
                            return 0.37728821551617797d;
                        }
                    }
                    return 0.15232227856837777d;
                } else if (list.get(71).doubleValue() <= 48.0d) {
                    if (list.get(71).doubleValue() <= 24.0d) {
                        if (list.get(55).doubleValue() <= 48.0d) {
                            if (list.get(64).doubleValue() <= 7.9659998416900635d) {
                                if (list.get(69).doubleValue() <= 72.0d) {
                                    return 0.2615609171274875d;
                                }
                                return 0.11118415443625422d;
                            } else if (list.get(69).doubleValue() <= 24.0d) {
                                return 0.09945876250742992d;
                            } else {
                                return 0.18912821078115405d;
                            }
                        } else if (list.get(55).doubleValue() <= 72.0d) {
                            if (list.get(53).doubleValue() <= 72.0d) {
                                return 0.41647366192534513d;
                            }
                            return 0.22823346173603368d;
                        } else {
                            return 0.174006963740349d;
                        }
                    } else if (list.get(69).doubleValue() > 24.0d) {
                        if (list.get(55).doubleValue() <= 72.0d) {
                            if (list.get(55).doubleValue() <= 48.0d) {
                                return 0.22613970834391084d;
                            }
                            if (list.get(53).doubleValue() <= 72.0d) {
                                return 0.42929883373847405d;
                            }
                            return 0.2683382629687677d;
                        }
                        return 0.14228946671851825d;
                    } else if (list.get(72).doubleValue() > 9.55649995803833d) {
                        if (list.get(64).doubleValue() <= 9.39650011062622d) {
                            return 0.3214138071717961d;
                        }
                        return 0.5131616623672718d;
                    } else {
                        return 0.6896947113649043d;
                    }
                } else if (list.get(72).doubleValue() <= 6.927500009536743d) {
                    if (list.get(64).doubleValue() > 3.2769999504089355d) {
                        if (list.get(55).doubleValue() <= 48.0d) {
                            if (list.get(72).doubleValue() <= 6.102499961853027d) {
                                return 0.6258251499369906d;
                            }
                            return 0.2900073445189799d;
                        }
                        return 0.25198084732955933d;
                    }
                    return 0.11082938263283698d;
                } else if (list.get(64).doubleValue() <= 6.713500022888184d) {
                    return 0.013689198740161331d;
                } else {
                    if (list.get(72).doubleValue() <= 11.35349988937378d) {
                        return 0.1959783570816651d;
                    }
                    if (list.get(69).doubleValue() <= 48.0d) {
                        if (list.get(63).doubleValue() <= 8.0d) {
                            return 0.25630615626293024d;
                        }
                        return 0.050402767677159184d;
                    } else if (list.get(63).doubleValue() <= 8.0d) {
                        return 0.05292181953707426d;
                    } else {
                        return 0.3491765182360112d;
                    }
                }
            } else if (list.get(71).doubleValue() <= 24.0d) {
                if (list.get(71).doubleValue() <= 8.0d) {
                    return 0.038419575770077194d;
                }
                if (list.get(72).doubleValue() <= 11.343500137329102d) {
                    return 0.053544846823883906d;
                }
                return 0.1181946945829504d;
            } else if (list.get(69).doubleValue() <= 24.0d) {
                if (list.get(71).doubleValue() <= 48.0d) {
                    if (list.get(72).doubleValue() > 6.653500080108643d) {
                        if (list.get(64).doubleValue() <= 6.61050009727478d) {
                            return 0.16055077182397057d;
                        }
                        if (list.get(72).doubleValue() > 11.983500003814697d) {
                            if (list.get(64).doubleValue() <= 11.988500118255615d) {
                                return 0.21238183882698292d;
                            }
                            return 0.4144202564833753d;
                        }
                        return 0.5353077190033545d;
                    }
                    return 0.6983855925590897d;
                } else if (list.get(71).doubleValue() <= 72.0d) {
                    return 0.048392716998659616d;
                } else {
                    if (list.get(72).doubleValue() > 5.2804999351501465d) {
                        if (list.get(74).doubleValue() <= 1.5d) {
                            return 0.16610971042411055d;
                        }
                        return 0.2816226755848141d;
                    }
                    return 0.035757117596947864d;
                }
            } else if (list.get(71).doubleValue() <= 72.0d) {
                if (list.get(63).doubleValue() <= 24.0d) {
                    return 0.13609959783688413d;
                }
                if (list.get(69).doubleValue() <= 48.0d) {
                    return 0.05807271639461555d;
                }
                return 0.10338407615838355d;
            } else if (list.get(63).doubleValue() <= 24.0d) {
                if (list.get(74).doubleValue() <= 1.5d) {
                    return 0.08634969302270622d;
                }
                return 0.22587046873236488d;
            } else if (list.get(72).doubleValue() > 4.388000011444092d) {
                if (list.get(39).doubleValue() <= 72.0d) {
                    if (list.get(39).doubleValue() <= 48.0d) {
                        return 0.19934447026111646d;
                    }
                    return 0.3474295247203715d;
                } else if (list.get(47).doubleValue() <= 48.0d) {
                    return 0.08171637191316998d;
                } else {
                    if (list.get(47).doubleValue() <= 72.0d) {
                        return 0.4108680485619332d;
                    }
                    return 0.1263058057356479d;
                }
            } else {
                return 0.05508139713178017d;
            }
        } else if (list.get(71).doubleValue() <= 100.0d) {
            if (list.get(74).doubleValue() <= 1.5d) {
                if (list.get(66).doubleValue() <= 1.5d) {
                    if (list.get(71).doubleValue() > 72.0d) {
                        if (list.get(55).doubleValue() <= 72.0d) {
                            if (list.get(56).doubleValue() > 7.37250018119812d) {
                                if (list.get(55).doubleValue() <= 8.0d) {
                                    return 0.062391958764408235d;
                                }
                                if (list.get(55).doubleValue() > 48.0d) {
                                    if (list.get(39).doubleValue() <= 72.0d) {
                                        if (list.get(39).doubleValue() <= 24.0d) {
                                            return 0.22850008392356927d;
                                        }
                                        return 0.3574687900892416d;
                                    }
                                    return 0.16113722573559314d;
                                }
                                return 0.15796859694331636d;
                            } else if (list.get(61).doubleValue() <= 72.0d) {
                                if (list.get(61).doubleValue() <= 8.0d) {
                                    return 0.007502122444645083d;
                                }
                                if (list.get(72).doubleValue() > 5.763499975204468d) {
                                    if (list.get(64).doubleValue() <= 3.941499948501587d) {
                                        return 0.1078551797015078d;
                                    }
                                    if (list.get(69).doubleValue() <= 72.0d) {
                                        if (list.get(55).doubleValue() <= 8.0d) {
                                            return 0.03807651833195802d;
                                        }
                                        return 0.10814021670567636d;
                                    }
                                    return 0.09301941134122865d;
                                }
                                return 0.05176580868963352d;
                            } else {
                                return 0.03731499480646313d;
                            }
                        } else if (list.get(47).doubleValue() <= 72.0d) {
                            if (list.get(47).doubleValue() <= 48.0d) {
                                return 0.03748784770493991d;
                            }
                            if (list.get(53).doubleValue() <= 8.0d) {
                                if (list.get(69).doubleValue() <= 72.0d) {
                                    return 0.132348059760794d;
                                }
                                return 0.9188230653302838d;
                            }
                            return 0.11094636366893877d;
                        } else {
                            return 0.021801240598364108d;
                        }
                    } else if (list.get(71).doubleValue() <= 8.0d) {
                        if (list.get(69).doubleValue() <= 72.0d) {
                            if (list.get(69).doubleValue() > 48.0d) {
                                if (list.get(63).doubleValue() <= 100.0d) {
                                    if (list.get(40).doubleValue() <= 2.802999973297119d) {
                                        if (list.get(64).doubleValue() <= 4.569499969482422d) {
                                            return 0.06387312449951041d;
                                        }
                                        return 0.3108651136533821d;
                                    }
                                    return 0.11963082693815837d;
                                }
                                return 0.09002855543715445d;
                            }
                            return 0.02076921003056403d;
                        }
                        return 0.019140870278992434d;
                    } else if (list.get(71).doubleValue() <= 24.0d) {
                        if (list.get(69).doubleValue() <= 48.0d) {
                            return 0.16611512588134147d;
                        }
                        if (list.get(69).doubleValue() <= 72.0d) {
                            if (list.get(61).doubleValue() <= 48.0d) {
                                return 0.5390837526621757d;
                            }
                            return 0.7667219792524539d;
                        } else if (list.get(72).doubleValue() > 10.835999965667725d) {
                            if (list.get(64).doubleValue() <= 10.901000022888184d) {
                                return 0.7566960444522871d;
                            }
                            return 0.4828227640890981d;
                        } else {
                            return 0.33223131047692805d;
                        }
                    } else if (list.get(69).doubleValue() <= 8.0d) {
                        if (list.get(61).doubleValue() <= 8.0d) {
                            if (list.get(71).doubleValue() > 48.0d) {
                                if (list.get(63).doubleValue() <= 100.0d) {
                                    return 0.22312895520353468d;
                                }
                                return 0.8479986003964533d;
                            }
                            return 0.14119666090621152d;
                        }
                        return 0.07211740695408451d;
                    } else if (list.get(72).doubleValue() > 11.753499984741211d) {
                        if (list.get(64).doubleValue() > 11.754499912261963d) {
                            if (list.get(67).doubleValue() <= 72.0d) {
                                if (list.get(72).doubleValue() > 13.34250020980835d) {
                                    if (list.get(64).doubleValue() <= 13.34250020980835d) {
                                        return 0.03528111432555468d;
                                    }
                                    if (list.get(71).doubleValue() <= 48.0d) {
                                        return 0.18091387554922014d;
                                    }
                                    if (list.get(72).doubleValue() <= 13.67549991607666d) {
                                        return 0.16716256241617836d;
                                    }
                                    if (list.get(69).doubleValue() <= 48.0d) {
                                        return 0.16225018830316115d;
                                    }
                                    if (list.get(61).doubleValue() <= 72.0d) {
                                        return 0.0633530376646889d;
                                    }
                                    return 0.11946914432172107d;
                                }
                                return 0.16445635609049844d;
                            }
                            return 0.0817288671677484d;
                        } else if (list.get(71).doubleValue() <= 48.0d) {
                            return 0.10089444855659985d;
                        } else {
                            return 0.016350614848230003d;
                        }
                    } else if (list.get(53).doubleValue() <= 100.0d) {
                        if (list.get(69).doubleValue() <= 100.0d) {
                            if (list.get(64).doubleValue() <= 4.9664998054504395d) {
                                if (list.get(72).doubleValue() <= 6.090000152587891d) {
                                    return 0.11410344129785885d;
                                }
                                return 0.039113168767086d;
                            } else if (list.get(53).doubleValue() <= 72.0d) {
                                return 0.1587065188846634d;
                            } else {
                                return 0.0952068005631715d;
                            }
                        } else if (list.get(61).doubleValue() <= 100.0d) {
                            if (list.get(63).doubleValue() <= 100.0d) {
                                return 0.3669313856516965d;
                            }
                            return 0.12637321876999127d;
                        } else if (list.get(71).doubleValue() > 48.0d) {
                            if (list.get(51).doubleValue() <= 0.5d) {
                                if (list.get(63).doubleValue() <= 100.0d) {
                                    if (list.get(72).doubleValue() <= 7.8374998569488525d) {
                                        return 0.5521527699601483d;
                                    }
                                    return 0.1730797676204313d;
                                }
                                return 0.12260535145347155d;
                            } else if (list.get(56).doubleValue() > 0.8959999978542328d) {
                                if (list.get(35).doubleValue() <= 0.5d) {
                                    return 0.2758874326048666d;
                                }
                                return 0.6264427960516247d;
                            } else {
                                return 0.9848966936475223d;
                            }
                        } else {
                            return 0.10630823876754975d;
                        }
                    } else if (list.get(56).doubleValue() > 0.3465000092983246d) {
                        if (list.get(39).doubleValue() <= 100.0d) {
                            if (list.get(63).doubleValue() <= 100.0d) {
                                return 0.2476219563317587d;
                            }
                            return 0.08828587527044392d;
                        } else if (list.get(40).doubleValue() > 0.3465000092983246d) {
                            if (list.get(63).doubleValue() <= 100.0d) {
                                if (list.get(61).doubleValue() <= 100.0d) {
                                    if (list.get(61).doubleValue() <= 72.0d) {
                                        return 0.15565180958704636d;
                                    }
                                    return 0.8565383331842895d;
                                }
                                return 0.20890554176044548d;
                            }
                            return 0.103727030714489d;
                        } else {
                            return 0.8768175333406124d;
                        }
                    } else if (list.get(71).doubleValue() <= 48.0d) {
                        return 0.092480223774816d;
                    } else {
                        return 0.9045270009215726d;
                    }
                } else if (list.get(71).doubleValue() <= 24.0d) {
                    if (list.get(71).doubleValue() > 8.0d) {
                        if (list.get(32).doubleValue() > 2.669000029563904d) {
                            if (list.get(55).doubleValue() <= 24.0d) {
                                return 0.03569946266510402d;
                            }
                            return 0.516324259821612d;
                        }
                        return 0.8774611975795346d;
                    }
                    return 0.008952710933512888d;
                } else {
                    return 0.014465812906531423d;
                }
            } else if (list.get(58).doubleValue() > 1.5d) {
                if (list.get(55).doubleValue() <= 72.0d) {
                    if (list.get(55).doubleValue() <= 24.0d) {
                        if (list.get(71).doubleValue() <= 8.0d) {
                            return 0.06981570041382379d;
                        }
                        if (list.get(71).doubleValue() <= 24.0d) {
                            if (list.get(72).doubleValue() > 6.177999973297119d) {
                                if (list.get(35).doubleValue() <= 0.5d) {
                                    return 0.5193154763960872d;
                                }
                                return 0.13936102393750302d;
                            }
                            return 0.24293811507931848d;
                        } else if (list.get(69).doubleValue() > 100.0d) {
                            if (list.get(63).doubleValue() <= 100.0d) {
                                if (list.get(72).doubleValue() <= 7.184999942779541d) {
                                    if (list.get(71).doubleValue() <= 72.0d) {
                                        return 0.7553445024852548d;
                                    }
                                    return 0.45782132969101896d;
                                }
                                return 0.13791429449955508d;
                            } else if (list.get(61).doubleValue() <= 72.0d) {
                                return 0.2374200434434467d;
                            } else {
                                return 0.12759494033189045d;
                            }
                        } else if (list.get(71).doubleValue() <= 48.0d) {
                            return 0.17917911152206004d;
                        } else {
                            return 0.11558335264871848d;
                        }
                    } else if (list.get(71).doubleValue() <= 72.0d) {
                        if (list.get(71).doubleValue() <= 48.0d) {
                            if (list.get(55).doubleValue() <= 48.0d) {
                                return 0.21369637454330226d;
                            }
                            if (list.get(71).doubleValue() <= 8.0d) {
                                return 0.18523733009226687d;
                            }
                            if (list.get(71).doubleValue() <= 24.0d) {
                                return 0.6732168067902536d;
                            }
                            return 0.43030439996514064d;
                        } else if (list.get(72).doubleValue() <= 7.802000045776367d) {
                            if (list.get(69).doubleValue() <= 72.0d) {
                                return 0.4937556001226887d;
                            }
                            return 0.21415512641578383d;
                        } else if (list.get(69).doubleValue() <= 48.0d) {
                            return 0.21618841575651332d;
                        } else {
                            if (list.get(61).doubleValue() <= 100.0d) {
                                return 0.09243191308509051d;
                            }
                            return 0.38080295477794784d;
                        }
                    } else if (list.get(72).doubleValue() > 7.667999982833862d) {
                        if (list.get(63).doubleValue() <= 100.0d) {
                            return 0.3240159573212354d;
                        }
                        if (list.get(69).doubleValue() <= 48.0d) {
                            return 0.32999986374542173d;
                        }
                        return 0.5751372943688735d;
                    } else {
                        return 0.08765140606553777d;
                    }
                } else if (list.get(47).doubleValue() <= 72.0d) {
                    if (list.get(48).doubleValue() <= 7.865000009536743d) {
                        if (list.get(69).doubleValue() <= 72.0d) {
                            if (list.get(72).doubleValue() <= 4.5274999141693115d) {
                                return 0.03212767885172663d;
                            }
                            return 0.10575476794568016d;
                        } else if (list.get(71).doubleValue() <= 8.0d) {
                            return 0.02758203744527459d;
                        } else {
                            return 0.15473307480895726d;
                        }
                    } else if (list.get(69).doubleValue() <= 100.0d) {
                        return 0.16731259811292745d;
                    } else {
                        if (list.get(71).doubleValue() <= 72.0d) {
                            return 0.15225948953020182d;
                        }
                        return 0.4171775721602377d;
                    }
                } else if (list.get(23).doubleValue() <= 72.0d) {
                    return 0.09135067188010763d;
                } else {
                    return 0.04420760664909011d;
                }
            } else if (list.get(71).doubleValue() <= 72.0d) {
                if (list.get(66).doubleValue() <= 1.5d) {
                    if (list.get(71).doubleValue() <= 48.0d) {
                        if (list.get(71).doubleValue() <= 8.0d) {
                            return 0.10255634831301456d;
                        }
                        if (list.get(71).doubleValue() <= 24.0d) {
                            return 0.5062872468172257d;
                        }
                        return 0.18231125687568162d;
                    }
                    return 0.04566317370166291d;
                } else if (list.get(71).doubleValue() <= 48.0d) {
                    if (list.get(71).doubleValue() <= 8.0d) {
                        return 0.13471491129924487d;
                    }
                    if (list.get(61).doubleValue() > 48.0d) {
                        if (list.get(50).doubleValue() <= 1.5d) {
                            if (list.get(69).doubleValue() <= 100.0d) {
                                return 0.3674913002843464d;
                            }
                            return 0.5613523442804633d;
                        }
                        return 0.5562485693344051d;
                    }
                    return 0.2211753757654487d;
                } else if (list.get(72).doubleValue() > 12.95550012588501d) {
                    if (list.get(64).doubleValue() <= 12.965499877929688d) {
                        return 0.033476338246240835d;
                    }
                    return 0.17623318256903622d;
                } else {
                    return 0.2431529167940467d;
                }
            } else if (list.get(69).doubleValue() > 48.0d) {
                if (list.get(55).doubleValue() <= 72.0d) {
                    if (list.get(55).doubleValue() > 48.0d) {
                        if (list.get(50).doubleValue() <= 1.5d) {
                            if (list.get(56).doubleValue() <= 7.805500030517578d) {
                                return 0.3821341470216534d;
                            }
                            return 0.6838846522463632d;
                        }
                        return 0.8569864713813331d;
                    } else if (list.get(69).doubleValue() <= 100.0d) {
                        if (list.get(61).doubleValue() <= 72.0d) {
                            if (list.get(63).doubleValue() <= 100.0d) {
                                return 0.2822563250418818d;
                            }
                            return 0.4343809059459131d;
                        }
                        return 0.19461666611280704d;
                    } else if (list.get(61).doubleValue() <= 72.0d) {
                        if (list.get(61).doubleValue() <= 48.0d) {
                            if (list.get(66).doubleValue() <= 1.5d) {
                                return 0.3450503276740113d;
                            }
                            return 0.5621898829022439d;
                        }
                        return 0.5703298625142673d;
                    } else {
                        return 0.346677793410577d;
                    }
                } else if (list.get(47).doubleValue() > 72.0d) {
                    if (list.get(39).doubleValue() <= 72.0d) {
                        if (list.get(39).doubleValue() <= 48.0d) {
                            return 0.2259338772166201d;
                        }
                        return 0.5610306716988458d;
                    }
                    return 0.1478663123959753d;
                } else if (list.get(47).doubleValue() <= 48.0d) {
                    if (list.get(69).doubleValue() <= 100.0d) {
                        return 0.18577718402993848d;
                    }
                    if (list.get(53).doubleValue() <= 72.0d) {
                        return 0.42192276162922704d;
                    }
                    return 0.2558683636729516d;
                } else {
                    return 0.6359086685691997d;
                }
            } else if (list.get(72).doubleValue() <= 7.408000230789185d) {
                return 0.03966939514991774d;
            } else {
                return 0.19308048937131944d;
            }
        } else if (list.get(74).doubleValue() > 1.5d) {
            if (list.get(66).doubleValue() > 1.5d) {
                if (list.get(63).doubleValue() <= 100.0d) {
                    return 0.029041713382118396d;
                }
                return 0.005812498835776803d;
            } else if (list.get(61).doubleValue() <= 72.0d) {
                if (list.get(55).doubleValue() <= 72.0d) {
                    if (list.get(55).doubleValue() <= 24.0d) {
                        if (list.get(63).doubleValue() <= 100.0d) {
                            return 0.20933604928066243d;
                        }
                        return 0.09021674629116812d;
                    } else if (list.get(56).doubleValue() > 8.896499633789062d) {
                        if (list.get(58).doubleValue() <= 1.5d) {
                            if (list.get(55).doubleValue() > 48.0d) {
                                if (list.get(50).doubleValue() > 1.5d) {
                                    if (list.get(42).doubleValue() <= 1.5d) {
                                        return 0.8280027669552554d;
                                    }
                                    return 0.6122799549543958d;
                                }
                                return 0.5508831317133303d;
                            }
                            return 0.46185324353919854d;
                        }
                        return 0.44982997531623037d;
                    } else {
                        return 0.2570467301459707d;
                    }
                } else if (list.get(47).doubleValue() <= 72.0d) {
                    if (list.get(47).doubleValue() > 24.0d) {
                        if (list.get(48).doubleValue() <= 9.189000129699707d) {
                            return 0.16193431294642718d;
                        }
                        return 0.5152062566521582d;
                    }
                    return 0.0545918594814499d;
                } else {
                    return 0.03798674054033025d;
                }
            } else if (list.get(63).doubleValue() <= 100.0d) {
                return 0.09491817022147334d;
            } else {
                return 0.037149688878069916d;
            }
        } else {
            return 0.0036009722225121676d;
        }
    }

    private final double tree3(List<Double> list) {
        if (list.get(63).doubleValue() <= 100.0d) {
            if (list.get(63).doubleValue() <= 72.0d) {
                if (list.get(61).doubleValue() <= 100.0d) {
                    if (list.get(74).doubleValue() <= 1.5d) {
                        if (list.get(61).doubleValue() <= 72.0d) {
                            if (list.get(71).doubleValue() <= 100.0d) {
                                if (list.get(71).doubleValue() <= 48.0d) {
                                    if (list.get(58).doubleValue() <= 1.5d) {
                                        if (list.get(55).doubleValue() <= 72.0d) {
                                            if (list.get(63).doubleValue() <= 8.0d) {
                                                if (list.get(72).doubleValue() <= 3.8394999504089355d) {
                                                    return 0.18323013468700644d;
                                                }
                                                if (list.get(64).doubleValue() <= 2.9700000286102295d) {
                                                    if (list.get(71).doubleValue() <= 8.0d) {
                                                        return 0.30375375921241216d;
                                                    }
                                                    return 0.763830338365951d;
                                                } else if (list.get(66).doubleValue() <= 1.5d) {
                                                    return 0.31544251754792124d;
                                                } else {
                                                    return 0.6246677352454506d;
                                                }
                                            } else if (list.get(53).doubleValue() <= 72.0d) {
                                                if (list.get(72).doubleValue() <= 6.958500146865845d) {
                                                    return 0.0979787970165317d;
                                                }
                                                if (list.get(64).doubleValue() > 6.893500089645386d) {
                                                    if (list.get(47).doubleValue() <= 72.0d) {
                                                        if (list.get(71).doubleValue() > 8.0d) {
                                                            if (list.get(45).doubleValue() <= 72.0d) {
                                                                return 0.10482122913303535d;
                                                            }
                                                            return 0.24242938264671798d;
                                                        }
                                                        return 0.23391025888531514d;
                                                    }
                                                    return 0.3546262772126488d;
                                                }
                                                return 0.4427807684350876d;
                                            } else if (list.get(53).doubleValue() <= 100.0d) {
                                                if (list.get(71).doubleValue() <= 8.0d) {
                                                    return 0.5964453755564724d;
                                                }
                                                return 0.38155339018708584d;
                                            } else {
                                                return 0.12856278516461528d;
                                            }
                                        } else if (list.get(55).doubleValue() <= 100.0d) {
                                            if (list.get(63).doubleValue() <= 8.0d) {
                                                return 0.7449250855198446d;
                                            }
                                            if (list.get(71).doubleValue() <= 8.0d) {
                                                return 0.6458854095607813d;
                                            }
                                            return 0.44598498040401263d;
                                        } else {
                                            return 0.2655485902954426d;
                                        }
                                    } else if (list.get(66).doubleValue() > 1.5d) {
                                        if (list.get(69).doubleValue() <= 100.0d) {
                                            if (list.get(53).doubleValue() <= 100.0d) {
                                                if (list.get(55).doubleValue() <= 100.0d) {
                                                    if (list.get(55).doubleValue() <= 72.0d) {
                                                        if (list.get(64).doubleValue() <= 9.455000400543213d) {
                                                            return 0.6997346645613052d;
                                                        }
                                                        if (list.get(53).doubleValue() <= 72.0d) {
                                                            if (list.get(71).doubleValue() <= 24.0d) {
                                                                return 0.4305212390082235d;
                                                            }
                                                            return 0.5938978665753384d;
                                                        }
                                                        return 0.760495646857425d;
                                                    }
                                                    return 0.8704125829748206d;
                                                }
                                                return 0.2951858143830654d;
                                            }
                                            return 0.2556866911934845d;
                                        }
                                        return 0.11043990582157955d;
                                    } else if (list.get(71).doubleValue() <= 8.0d) {
                                        if (list.get(53).doubleValue() <= 100.0d) {
                                            return 0.5110226136502398d;
                                        }
                                        return 0.07516742977288111d;
                                    } else {
                                        return 0.2609807493716367d;
                                    }
                                } else if (list.get(64).doubleValue() <= 7.0954999923706055d) {
                                    if (list.get(71).doubleValue() <= 72.0d) {
                                        if (list.get(72).doubleValue() > 7.373500108718872d) {
                                            if (list.get(59).doubleValue() <= 100.0d) {
                                                if (list.get(53).doubleValue() <= 100.0d) {
                                                    return 0.7105371767792851d;
                                                }
                                                return 0.23162829518457007d;
                                            }
                                            return 0.23990390337300752d;
                                        } else if (list.get(53).doubleValue() > 72.0d) {
                                            if (list.get(56).doubleValue() <= 0.3465000092983246d) {
                                                return 0.006596442125173426d;
                                            }
                                            if (list.get(61).doubleValue() <= 24.0d) {
                                                return 0.9066774130558952d;
                                            }
                                            return 0.5111807894262245d;
                                        } else if (list.get(55).doubleValue() <= 72.0d) {
                                            if (list.get(63).doubleValue() <= 48.0d) {
                                                if (list.get(72).doubleValue() <= 3.3140000104904175d) {
                                                    return 0.21613553119404869d;
                                                }
                                                return 0.3664596084791007d;
                                            }
                                            return 0.16169514423938813d;
                                        } else {
                                            return 0.5493348030885897d;
                                        }
                                    } else if (list.get(72).doubleValue() <= 7.118000030517578d) {
                                        if (list.get(69).doubleValue() <= 48.0d) {
                                            if (list.get(61).doubleValue() <= 48.0d) {
                                                return 0.9097852639402114d;
                                            }
                                            return 0.6084169797533187d;
                                        } else if (list.get(55).doubleValue() <= 48.0d) {
                                            if (list.get(72).doubleValue() <= 3.1985000371932983d) {
                                                return 0.7794417417223255d;
                                            }
                                            return 0.4336400572044868d;
                                        } else {
                                            return 0.8678050029716488d;
                                        }
                                    } else if (list.get(61).doubleValue() <= 48.0d) {
                                        if (list.get(69).doubleValue() <= 48.0d) {
                                            if (list.get(63).doubleValue() <= 24.0d) {
                                                return 0.3131232484196921d;
                                            }
                                            return 0.547337100516536d;
                                        }
                                        return 0.3048550975951744d;
                                    } else {
                                        return 0.23238358073109527d;
                                    }
                                } else if (list.get(63).doubleValue() <= 8.0d) {
                                    if (list.get(69).doubleValue() <= 72.0d) {
                                        if (list.get(55).doubleValue() <= 100.0d) {
                                            if (list.get(55).doubleValue() <= 72.0d) {
                                                return 0.5825890491656287d;
                                            }
                                            return 0.7920303427617071d;
                                        } else if (list.get(53).doubleValue() <= 8.0d) {
                                            return 0.8431524819321307d;
                                        } else {
                                            return 0.3261170623955697d;
                                        }
                                    }
                                    return 0.37136465900223664d;
                                } else if (list.get(56).doubleValue() > 5.725500106811523d) {
                                    if (list.get(47).doubleValue() > 72.0d) {
                                        if (list.get(47).doubleValue() <= 100.0d) {
                                            if (list.get(71).doubleValue() > 72.0d) {
                                                if (list.get(39).doubleValue() > 72.0d) {
                                                    if (list.get(45).doubleValue() <= 100.0d) {
                                                        return 0.6948557936670363d;
                                                    }
                                                    return 0.34035442582854025d;
                                                } else if (list.get(53).doubleValue() <= 48.0d) {
                                                    return 0.606915937607678d;
                                                } else {
                                                    return 0.27044638006476035d;
                                                }
                                            } else if (list.get(58).doubleValue() <= 1.5d) {
                                                return 0.5747086082182319d;
                                            } else {
                                                return 0.769234477489478d;
                                            }
                                        }
                                        return 0.34001752382390227d;
                                    } else if (list.get(55).doubleValue() <= 72.0d) {
                                        if (list.get(58).doubleValue() <= 1.5d) {
                                            if (list.get(31).doubleValue() <= 72.0d) {
                                                return 0.23209941778638946d;
                                            }
                                            return 0.3655417577144035d;
                                        } else if (list.get(71).doubleValue() <= 72.0d) {
                                            if (list.get(50).doubleValue() <= 1.5d) {
                                                return 0.3739942173474731d;
                                            }
                                            return 0.6030262789657388d;
                                        } else {
                                            return 0.2868045107634d;
                                        }
                                    } else if (list.get(71).doubleValue() <= 72.0d) {
                                        if (list.get(55).doubleValue() <= 100.0d) {
                                            if (list.get(58).doubleValue() <= 1.5d) {
                                                return 0.5853302944053032d;
                                            }
                                            return 0.8701233929232635d;
                                        }
                                        return 0.2942239197970732d;
                                    } else if (list.get(72).doubleValue() <= 11.995999813079834d) {
                                        return 0.613879570080761d;
                                    } else {
                                        return 0.316944211532739d;
                                    }
                                } else if (list.get(72).doubleValue() <= 12.02150011062622d) {
                                    if (list.get(71).doubleValue() > 72.0d) {
                                        if (list.get(69).doubleValue() <= 48.0d) {
                                            if (list.get(61).doubleValue() <= 48.0d) {
                                                return 0.7915455472685842d;
                                            }
                                            return 0.5183844114588388d;
                                        } else if (list.get(55).doubleValue() <= 48.0d) {
                                            return 0.43073624929183923d;
                                        } else {
                                            return 0.7445078333342121d;
                                        }
                                    } else if (list.get(63).doubleValue() <= 48.0d) {
                                        return 0.4829530515973848d;
                                    } else {
                                        return 0.19073031882810243d;
                                    }
                                } else if (list.get(64).doubleValue() <= 12.022500038146973d) {
                                    if (list.get(71).doubleValue() <= 72.0d) {
                                        return 0.5956869546650628d;
                                    }
                                    return 0.23412106172347744d;
                                } else if (list.get(72).doubleValue() <= 13.203500270843506d) {
                                    return 0.5530366843912482d;
                                } else {
                                    if (list.get(64).doubleValue() <= 13.195499897003174d) {
                                        if (list.get(71).doubleValue() <= 72.0d) {
                                            return 0.5152234438928249d;
                                        }
                                        return 0.21663013839135994d;
                                    }
                                    return 0.4767934810267664d;
                                }
                            } else if (list.get(55).doubleValue() <= 100.0d) {
                                if (list.get(53).doubleValue() <= 100.0d) {
                                    if (list.get(55).doubleValue() <= 72.0d) {
                                        if (list.get(37).doubleValue() <= 100.0d) {
                                            if (list.get(53).doubleValue() > 72.0d) {
                                                if (list.get(56).doubleValue() > 0.5494999885559082d) {
                                                    if (list.get(45).doubleValue() <= 72.0d) {
                                                        return 0.6419316213984905d;
                                                    }
                                                    return 0.37368196950365046d;
                                                }
                                                return 0.030492185090283667d;
                                            } else if (list.get(63).doubleValue() > 8.0d) {
                                                if (list.get(59).doubleValue() <= 100.0d) {
                                                    if (list.get(72).doubleValue() <= 6.612499952316284d) {
                                                        if (list.get(51).doubleValue() <= 0.5d) {
                                                            return 0.574801587253843d;
                                                        }
                                                        return 0.24391733263366105d;
                                                    } else if (list.get(47).doubleValue() <= 100.0d) {
                                                        if (list.get(67).doubleValue() <= 8.5d) {
                                                            return 0.3162844809515317d;
                                                        }
                                                        return 0.4212076680144278d;
                                                    } else {
                                                        return 0.13227898601235713d;
                                                    }
                                                }
                                                return 0.10741787396186425d;
                                            } else if (list.get(55).doubleValue() <= 8.0d) {
                                                return 0.14519804639521408d;
                                            } else {
                                                return 0.35363419247540767d;
                                            }
                                        }
                                        return 0.07048639241020373d;
                                    } else if (list.get(39).doubleValue() <= 100.0d) {
                                        return 0.6379028167035399d;
                                    } else {
                                        return 0.2548500876063455d;
                                    }
                                }
                                return 0.07983141797530882d;
                            } else {
                                return 0.05601261099261449d;
                            }
                        } else if (list.get(71).doubleValue() <= 72.0d) {
                            if (list.get(72).doubleValue() <= 1.7005000114440918d) {
                                if (list.get(71).doubleValue() <= 8.0d) {
                                    return 0.5491505887509818d;
                                }
                                return 0.021363908508597828d;
                            } else if (list.get(58).doubleValue() <= 1.5d) {
                                if (list.get(71).doubleValue() <= 8.0d) {
                                    if (list.get(72).doubleValue() <= 4.667999982833862d) {
                                        return 0.9011491841065629d;
                                    }
                                    return 0.6701762429173704d;
                                } else if (list.get(63).doubleValue() <= 8.0d) {
                                    return 0.7344443150415447d;
                                } else {
                                    if (list.get(72).doubleValue() <= 8.233999729156494d) {
                                        if (list.get(64).doubleValue() > 2.8615000247955322d) {
                                            if (list.get(69).doubleValue() <= 48.0d) {
                                                if (list.get(71).doubleValue() <= 48.0d) {
                                                    return 0.3392077488984779d;
                                                }
                                                return 0.7217647801131397d;
                                            } else if (list.get(55).doubleValue() <= 72.0d) {
                                                return 0.2092977921286789d;
                                            } else {
                                                return 0.4231101357882897d;
                                            }
                                        } else if (list.get(71).doubleValue() <= 24.0d) {
                                            return 0.6833851559469429d;
                                        } else {
                                            if (list.get(71).doubleValue() > 48.0d) {
                                                if (list.get(69).doubleValue() <= 48.0d) {
                                                    return 0.8494190363107655d;
                                                }
                                                return 0.41260336149821575d;
                                            } else if (list.get(64).doubleValue() <= 0.8959999978542328d) {
                                                return 0.8283346561534751d;
                                            } else {
                                                return 0.2851786150243995d;
                                            }
                                        }
                                    } else if (list.get(64).doubleValue() <= 8.206500053405762d) {
                                        return 0.769081662998215d;
                                    } else {
                                        if (list.get(71).doubleValue() > 48.0d) {
                                            if (list.get(69).doubleValue() <= 48.0d) {
                                                return 0.6711157308517367d;
                                            }
                                            if (list.get(55).doubleValue() <= 72.0d) {
                                                return 0.36900768559299874d;
                                            }
                                            return 0.5865543232129727d;
                                        } else if (list.get(63).doubleValue() <= 24.0d) {
                                            return 0.2983491431419449d;
                                        } else {
                                            if (list.get(66).doubleValue() <= 1.5d) {
                                                return 0.4714560190783849d;
                                            }
                                            return 0.631352501436915d;
                                        }
                                    }
                                }
                            } else if (list.get(53).doubleValue() > 100.0d) {
                                if (list.get(50).doubleValue() <= 1.5d) {
                                    return 0.5457415674908511d;
                                }
                                return 0.13259877553206048d;
                            } else if (list.get(55).doubleValue() <= 100.0d) {
                                if (list.get(45).doubleValue() <= 100.0d) {
                                    if (list.get(66).doubleValue() <= 1.5d) {
                                        return 0.7345063129909758d;
                                    }
                                    return 0.858445440497518d;
                                }
                                return 0.3625814443344117d;
                            } else {
                                return 0.4249118277352804d;
                            }
                        } else if (list.get(72).doubleValue() <= 11.15250015258789d) {
                            if (list.get(72).doubleValue() > 5.92549991607666d) {
                                if (list.get(69).doubleValue() > 48.0d) {
                                    if (list.get(69).doubleValue() <= 72.0d) {
                                        return 0.4082126083482121d;
                                    }
                                    return 0.5506023163016425d;
                                } else if (list.get(64).doubleValue() <= 5.870500087738037d) {
                                    if (list.get(71).doubleValue() <= 100.0d) {
                                        return 0.23202319677887756d;
                                    }
                                    return 0.7170632720541794d;
                                } else {
                                    return 0.7681804513616378d;
                                }
                            } else if (list.get(63).doubleValue() <= 8.0d) {
                                if (list.get(69).doubleValue() <= 72.0d) {
                                    return 0.8380578470342711d;
                                }
                                return 0.455237321079488d;
                            } else if (list.get(55).doubleValue() <= 100.0d) {
                                if (list.get(72).doubleValue() <= 3.9795000553131104d) {
                                    return 0.8831144465253703d;
                                }
                                if (list.get(63).doubleValue() <= 48.0d) {
                                    return 0.8551322448660027d;
                                }
                                return 0.6419381226248317d;
                            } else {
                                return 0.38481497873056075d;
                            }
                        } else if (list.get(71).doubleValue() <= 100.0d) {
                            if (list.get(63).doubleValue() > 24.0d) {
                                if (list.get(69).doubleValue() <= 72.0d) {
                                    if (list.get(69).doubleValue() > 48.0d) {
                                        if (list.get(47).doubleValue() <= 72.0d) {
                                            return 0.1957091842762743d;
                                        }
                                        if (list.get(47).doubleValue() <= 100.0d) {
                                            return 0.3831236979837079d;
                                        }
                                        return 0.1714164075289748d;
                                    } else if (list.get(64).doubleValue() <= 11.15500020980835d) {
                                        return 0.17370034899266268d;
                                    } else {
                                        if (list.get(55).doubleValue() <= 48.0d) {
                                            return 0.47008192326700976d;
                                        }
                                        return 0.29949388435230323d;
                                    }
                                }
                                return 0.6711718654226335d;
                            } else if (list.get(64).doubleValue() <= 11.15250015258789d) {
                                return 0.25101443813965796d;
                            } else {
                                if (list.get(55).doubleValue() <= 100.0d) {
                                    if (list.get(72).doubleValue() <= 12.991499900817871d) {
                                        return 0.7027612170154166d;
                                    }
                                    if (list.get(64).doubleValue() <= 12.993500232696533d) {
                                        return 0.31493326119625625d;
                                    }
                                    return 0.5831106893744223d;
                                }
                                return 0.19772145357162213d;
                            }
                        } else if (list.get(53).doubleValue() <= 100.0d) {
                            if (list.get(55).doubleValue() <= 100.0d) {
                                if (list.get(64).doubleValue() > 11.170499801635742d) {
                                    if (list.get(45).doubleValue() <= 100.0d) {
                                        if (list.get(69).doubleValue() <= 100.0d) {
                                            if (list.get(37).doubleValue() <= 100.0d) {
                                                if (list.get(69).doubleValue() <= 48.0d) {
                                                    return 0.6977729384465348d;
                                                }
                                                if (list.get(55).doubleValue() <= 72.0d) {
                                                    return 0.517866193538293d;
                                                }
                                                return 0.6675857997026899d;
                                            }
                                            return 0.27567991019904176d;
                                        }
                                        return 0.16498113770908257d;
                                    }
                                    return 0.2395212346523684d;
                                }
                                return 0.3976802466995042d;
                            }
                            return 0.2418388349337401d;
                        } else {
                            return 0.20853609723932487d;
                        }
                    } else if (list.get(64).doubleValue() <= 7.0315001010894775d) {
                        if (list.get(71).doubleValue() <= 72.0d) {
                            if (list.get(72).doubleValue() <= 7.8434998989105225d) {
                                if (list.get(71).doubleValue() <= 8.0d) {
                                    if (list.get(61).doubleValue() <= 72.0d) {
                                        if (list.get(47).doubleValue() <= 72.0d) {
                                            return 0.2020441584247166d;
                                        }
                                        return 0.6846175699823797d;
                                    }
                                    return 0.8213788204075092d;
                                } else if (list.get(63).doubleValue() <= 8.0d) {
                                    return 0.4272828109701094d;
                                } else {
                                    if (list.get(55).doubleValue() <= 72.0d) {
                                        if (list.get(71).doubleValue() <= 48.0d) {
                                            if (list.get(61).doubleValue() <= 72.0d) {
                                                return 0.05731428855852989d;
                                            }
                                            if (list.get(71).doubleValue() <= 24.0d) {
                                                if (list.get(55).doubleValue() <= 8.0d) {
                                                    return 0.36568872317062034d;
                                                }
                                                return 0.07298901521559661d;
                                            }
                                            return 0.10558066244651268d;
                                        } else if (list.get(63).doubleValue() <= 48.0d) {
                                            return 0.3504916003725675d;
                                        } else {
                                            return 0.11683826810761934d;
                                        }
                                    }
                                    return 0.37719630471449006d;
                                }
                            } else if (list.get(63).doubleValue() <= 8.0d) {
                                return 0.7328813878031686d;
                            } else {
                                if (list.get(61).doubleValue() <= 72.0d) {
                                    return 0.4255136549565986d;
                                }
                                return 0.6272586518287554d;
                            }
                        } else if (list.get(72).doubleValue() <= 6.317999839782715d) {
                            if (list.get(72).doubleValue() <= 4.11899995803833d) {
                                if (list.get(71).doubleValue() <= 100.0d) {
                                    return 0.8525649269790202d;
                                }
                                if (list.get(63).doubleValue() <= 8.0d) {
                                    return 0.40606080495289654d;
                                }
                                return 0.7656901810404628d;
                            }
                            return 0.6063854844095747d;
                        } else if (list.get(72).doubleValue() > 7.036999940872192d) {
                            if (list.get(69).doubleValue() <= 72.0d) {
                                return 0.1982520645445728d;
                            }
                            return 0.3859233409032384d;
                        } else {
                            return 0.46892747283576697d;
                        }
                    } else if (list.get(66).doubleValue() <= 1.5d) {
                        if (list.get(69).doubleValue() <= 72.0d) {
                            if (list.get(71).doubleValue() <= 100.0d) {
                                if (list.get(71).doubleValue() <= 72.0d) {
                                    if (list.get(55).doubleValue() <= 72.0d) {
                                        return 0.07993788612305815d;
                                    }
                                    return 0.26240101337486105d;
                                }
                                return 0.01460632997516132d;
                            } else if (list.get(61).doubleValue() <= 72.0d) {
                                return 0.11352242740942871d;
                            } else {
                                return 0.243115469370268d;
                            }
                        }
                        return 0.28094160234927135d;
                    } else if (list.get(61).doubleValue() <= 72.0d) {
                        if (list.get(71).doubleValue() > 48.0d) {
                            if (list.get(48).doubleValue() > 8.48199987411499d) {
                                if (list.get(47).doubleValue() <= 72.0d) {
                                    if (list.get(63).doubleValue() <= 8.0d) {
                                        return 0.3280303628457477d;
                                    }
                                    return 0.12607407554080113d;
                                }
                                return 0.2682943907950676d;
                            } else if (list.get(63).doubleValue() <= 8.0d) {
                                if (list.get(71).doubleValue() <= 100.0d) {
                                    if (list.get(69).doubleValue() <= 72.0d) {
                                        return 0.6026093157860197d;
                                    }
                                    return 0.1687984852875808d;
                                }
                                return 0.25139793111286135d;
                            } else if (list.get(71).doubleValue() <= 100.0d) {
                                return 0.24524941136560147d;
                            } else {
                                return 0.39973746898449214d;
                            }
                        } else if (list.get(55).doubleValue() <= 72.0d) {
                            if (list.get(71).doubleValue() <= 8.0d) {
                                return 0.2530556472825573d;
                            }
                            return 0.08450117677021793d;
                        } else {
                            return 0.2731807805492614d;
                        }
                    } else if (list.get(71).doubleValue() <= 100.0d) {
                        if (list.get(63).doubleValue() <= 24.0d) {
                            if (list.get(71).doubleValue() <= 48.0d) {
                                if (list.get(71).doubleValue() <= 8.0d) {
                                    return 0.5898092380158779d;
                                }
                                if (list.get(63).doubleValue() <= 8.0d) {
                                    return 0.43768027450243696d;
                                }
                                return 0.14010121758023664d;
                            }
                            return 0.48234650721111805d;
                        } else if (list.get(71).doubleValue() > 72.0d) {
                            if (list.get(69).doubleValue() <= 72.0d) {
                                return 0.14515803675699712d;
                            }
                            return 0.6374363204807761d;
                        } else {
                            return 0.3171686750408118d;
                        }
                    } else if (list.get(55).doubleValue() <= 100.0d) {
                        if (list.get(53).doubleValue() <= 100.0d) {
                            if (list.get(69).doubleValue() <= 48.0d) {
                                return 0.7295483755626775d;
                            }
                            return 0.5276371927988875d;
                        }
                        return 0.3281725241891938d;
                    } else {
                        return 0.22397985883454094d;
                    }
                } else if (list.get(71).doubleValue() <= 100.0d) {
                    if (list.get(58).doubleValue() <= 1.5d) {
                        if (list.get(71).doubleValue() <= 72.0d) {
                            if (list.get(55).doubleValue() <= 72.0d) {
                                if (list.get(72).doubleValue() <= 8.488500118255615d) {
                                    return 0.07395608595436097d;
                                }
                                return 0.16942360656126462d;
                            } else if (list.get(55).doubleValue() <= 100.0d) {
                                return 0.40588990662298935d;
                            } else {
                                return 0.17468434116511558d;
                            }
                        } else if (list.get(63).doubleValue() > 8.0d) {
                            if (list.get(69).doubleValue() <= 72.0d) {
                                return 0.21441996706971475d;
                            }
                            return 0.4939871610419846d;
                        } else if (list.get(72).doubleValue() <= 11.785499572753906d) {
                            return 0.6573481888683256d;
                        } else {
                            return 0.4221763978741421d;
                        }
                    }
                    return 0.08403895170886623d;
                } else {
                    return 0.06476588383276882d;
                }
            } else if (list.get(71).doubleValue() > 100.0d) {
                if (list.get(69).doubleValue() <= 8.0d) {
                    if (list.get(67).doubleValue() <= 60.5d) {
                        if (list.get(61).doubleValue() <= 8.0d) {
                            return 0.2628673123050244d;
                        }
                        return 0.9604264596408842d;
                    }
                    return 0.3712610246167307d;
                } else if (list.get(69).doubleValue() <= 100.0d) {
                    if (list.get(67).doubleValue() <= 0.5d) {
                        if (list.get(72).doubleValue() > 6.181999921798706d) {
                            if (list.get(69).doubleValue() <= 72.0d) {
                                if (list.get(61).doubleValue() <= 100.0d) {
                                    return 0.5631173888783472d;
                                }
                                return 0.32986965213783254d;
                            }
                            return 0.36737188944437144d;
                        } else if (list.get(55).doubleValue() <= 100.0d) {
                            return 0.7575169675025296d;
                        } else {
                            return 0.3062683153011994d;
                        }
                    } else if (list.get(72).doubleValue() <= 6.180999994277954d) {
                        if (list.get(69).doubleValue() <= 48.0d) {
                            if (list.get(55).doubleValue() <= 100.0d) {
                                return 0.7248601338309367d;
                            }
                            return 0.2255487434707296d;
                        } else if (list.get(55).doubleValue() > 72.0d) {
                            if (list.get(56).doubleValue() > 0.3465000092983246d) {
                                if (list.get(47).doubleValue() <= 100.0d) {
                                    if (list.get(69).doubleValue() <= 72.0d) {
                                        if (list.get(55).doubleValue() <= 100.0d) {
                                            return 0.7617866711953849d;
                                        }
                                        return 0.2515019375370373d;
                                    }
                                    return 0.3395158489506351d;
                                }
                                return 0.05192307935899127d;
                            }
                            return 0.016067277979054256d;
                        } else if (list.get(66).doubleValue() <= 1.5d) {
                            if (list.get(72).doubleValue() <= 4.102499961853027d) {
                                if (list.get(61).doubleValue() <= 100.0d) {
                                    if (list.get(59).doubleValue() <= 0.5d) {
                                        return 0.713238341356764d;
                                    }
                                    return 0.5202947288554878d;
                                }
                                return 0.2788533574001401d;
                            }
                            return 0.37789341791581926d;
                        } else {
                            return 0.2188145855204008d;
                        }
                    } else if (list.get(74).doubleValue() <= 1.5d) {
                        if (list.get(47).doubleValue() > 100.0d) {
                            if (list.get(39).doubleValue() <= 100.0d) {
                                return 0.15614140078183958d;
                            }
                            return 0.060920673200996825d;
                        } else if (list.get(47).doubleValue() <= 8.0d) {
                            if (list.get(69).doubleValue() <= 48.0d) {
                                return 0.3610020269178219d;
                            }
                            if (list.get(58).doubleValue() <= 1.5d) {
                                if (list.get(56).doubleValue() <= 0.8959999978542328d) {
                                    return 0.16481674449874148d;
                                }
                                return 0.21403533620752135d;
                            }
                            return 0.10083217335001625d;
                        } else if (list.get(53).doubleValue() > 8.0d) {
                            if (list.get(37).doubleValue() <= 100.0d) {
                                if (list.get(58).doubleValue() <= 1.5d) {
                                    if (list.get(69).doubleValue() > 48.0d) {
                                        if (list.get(47).doubleValue() > 72.0d) {
                                            if (list.get(48).doubleValue() > 5.695499897003174d) {
                                                if (list.get(31).doubleValue() <= 100.0d) {
                                                    return 0.45698450961346065d;
                                                }
                                                return 0.2854184430388627d;
                                            }
                                            return 0.3002316610571648d;
                                        }
                                        return 0.2972641795651938d;
                                    }
                                    return 0.5725696941149223d;
                                }
                                return 0.1951779351586473d;
                            }
                            return 0.20178486982932783d;
                        } else {
                            return 0.03669279517750477d;
                        }
                    } else if (list.get(66).doubleValue() > 1.5d) {
                        if (list.get(56).doubleValue() > 7.018500089645386d) {
                            if (list.get(47).doubleValue() <= 100.0d) {
                                if (list.get(47).doubleValue() <= 72.0d) {
                                    return 0.3107733296499619d;
                                }
                                return 0.4884988246677706d;
                            }
                            return 0.2135417936835305d;
                        }
                        return 0.19723434028080486d;
                    } else if (list.get(58).doubleValue() <= 1.5d) {
                        return 0.28511032605040726d;
                    } else {
                        if (list.get(55).doubleValue() > 72.0d) {
                            if (list.get(50).doubleValue() <= 1.5d) {
                                return 0.7372958013079929d;
                            }
                            return 0.5237009998123271d;
                        }
                        return 0.4231262511454794d;
                    }
                } else if (list.get(61).doubleValue() <= 100.0d) {
                    if (list.get(61).doubleValue() <= 72.0d) {
                        if (list.get(55).doubleValue() <= 100.0d) {
                            if (list.get(58).doubleValue() <= 1.5d) {
                                if (list.get(64).doubleValue() <= 4.27649998664856d) {
                                    return 0.12250631774194388d;
                                }
                                return 0.6087674389632144d;
                            }
                            return 0.1996782495991411d;
                        }
                        return 0.1948771172433951d;
                    } else if (list.get(58).doubleValue() <= 1.5d) {
                        if (list.get(53).doubleValue() <= 100.0d) {
                            return 0.8454013396568523d;
                        }
                        return 0.9689826634756393d;
                    } else {
                        return 0.2306637388900921d;
                    }
                } else if (list.get(55).doubleValue() <= 100.0d) {
                    if (list.get(64).doubleValue() <= 4.505499839782715d) {
                        return 0.06798462793428255d;
                    }
                    return 0.5312172632264363d;
                } else {
                    return 0.10017036926856186d;
                }
            } else if (list.get(55).doubleValue() > 100.0d) {
                if (list.get(47).doubleValue() <= 100.0d) {
                    if (list.get(58).doubleValue() <= 1.5d) {
                        if (list.get(61).doubleValue() <= 8.0d) {
                            if (list.get(59).doubleValue() <= 60.5d) {
                                return 0.0437643526530288d;
                            }
                            return 0.6858720371505562d;
                        } else if (list.get(72).doubleValue() <= 8.66949987411499d) {
                            if (list.get(69).doubleValue() <= 72.0d) {
                                return 0.8149429270988877d;
                            }
                            return 0.6122757912143937d;
                        } else if (list.get(61).doubleValue() > 100.0d) {
                            if (list.get(47).doubleValue() <= 72.0d) {
                                if (list.get(56).doubleValue() <= 4.181999921798706d) {
                                    if (list.get(64).doubleValue() <= 6.9649999141693115d) {
                                        return 0.34822639025198904d;
                                    }
                                    return 0.630839837160278d;
                                }
                                return 0.3818620439158119d;
                            } else if (list.get(39).doubleValue() <= 100.0d) {
                                return 0.6175685668200451d;
                            } else {
                                return 0.40867208248490916d;
                            }
                        } else if (list.get(64).doubleValue() <= 8.695000171661377d) {
                            if (list.get(71).doubleValue() <= 72.0d) {
                                return 0.6534135627052148d;
                            }
                            return 0.26447841510418113d;
                        } else if (list.get(74).doubleValue() <= 1.5d) {
                            return 0.667187666428722d;
                        } else {
                            return 0.45064760940033893d;
                        }
                    } else if (list.get(61).doubleValue() <= 100.0d) {
                        if (list.get(59).doubleValue() <= 100.0d) {
                            if (list.get(72).doubleValue() <= 4.753499984741211d) {
                                return 0.8305333339604946d;
                            }
                            return 0.5588446473883025d;
                        }
                        return 0.27114096848730557d;
                    } else if (list.get(74).doubleValue() <= 1.5d) {
                        return 0.11908088902782867d;
                    } else {
                        return 0.31948694632222147d;
                    }
                } else if (list.get(61).doubleValue() <= 100.0d) {
                    if (list.get(61).doubleValue() <= 8.0d) {
                        return 0.08941552250872876d;
                    }
                    return 0.46708956525985107d;
                } else if (list.get(72).doubleValue() <= 9.462499618530273d) {
                    return 0.44087609851886667d;
                } else {
                    return 0.2395931319535991d;
                }
            } else if (list.get(71).doubleValue() <= 72.0d) {
                if (list.get(74).doubleValue() <= 1.5d) {
                    if (list.get(61).doubleValue() <= 100.0d) {
                        if (list.get(66).doubleValue() <= 1.5d) {
                            if (list.get(53).doubleValue() <= 100.0d) {
                                if (list.get(71).doubleValue() <= 48.0d) {
                                    if (list.get(71).doubleValue() <= 8.0d) {
                                        if (list.get(69).doubleValue() <= 72.0d) {
                                            if (list.get(21).doubleValue() <= 8.0d) {
                                                if (list.get(64).doubleValue() <= 9.974500179290771d) {
                                                    return 0.7816614010521317d;
                                                }
                                                return 0.6225019017780727d;
                                            }
                                            return 0.8722779893592443d;
                                        }
                                        return 0.8253568737858953d;
                                    } else if (list.get(71).doubleValue() > 24.0d) {
                                        if (list.get(47).doubleValue() <= 72.0d) {
                                            if (list.get(61).doubleValue() <= 24.0d) {
                                                return 0.5667852422486467d;
                                            }
                                            if (list.get(72).doubleValue() > 2.6019999980926514d) {
                                                if (list.get(47).doubleValue() <= 8.0d) {
                                                    return 0.7466631712280519d;
                                                }
                                                return 0.6225996115575056d;
                                            }
                                            return 0.3837101837156357d;
                                        }
                                        return 0.8173200851717621d;
                                    } else {
                                        return 0.044498904772741356d;
                                    }
                                } else if (list.get(61).doubleValue() > 24.0d) {
                                    if (list.get(69).doubleValue() <= 100.0d) {
                                        if (list.get(53).doubleValue() <= 72.0d) {
                                            if (list.get(43).doubleValue() > 0.5d) {
                                                if (list.get(47).doubleValue() <= 72.0d) {
                                                    return 0.7009497636164147d;
                                                }
                                                if (list.get(53).doubleValue() <= 8.0d) {
                                                    return 0.30162503663476875d;
                                                }
                                                return 0.8583243340557931d;
                                            }
                                            return 0.8215994127278409d;
                                        }
                                        return 0.8690154944721848d;
                                    }
                                    return 0.48636772601255296d;
                                } else if (list.get(55).doubleValue() <= 72.0d) {
                                    return 0.6312928344471702d;
                                } else {
                                    return 0.8033868472604571d;
                                }
                            } else if (list.get(61).doubleValue() > 72.0d) {
                                if (list.get(67).doubleValue() <= 16.5d) {
                                    return 0.1970618843425941d;
                                }
                                return 0.6962863242156835d;
                            } else {
                                return 0.5900068129953882d;
                            }
                        } else if (list.get(71).doubleValue() <= 24.0d) {
                            if (list.get(71).doubleValue() > 8.0d) {
                                if (list.get(32).doubleValue() <= 2.669000029563904d) {
                                    return 0.03196432689286654d;
                                }
                                if (list.get(55).doubleValue() <= 24.0d) {
                                    return 0.9528444576760133d;
                                }
                                return 0.334308248888683d;
                            }
                            return 0.8526033289028152d;
                        } else if (list.get(53).doubleValue() <= 100.0d) {
                            if (list.get(58).doubleValue() > 1.5d) {
                                if (list.get(59).doubleValue() <= 100.0d) {
                                    if (list.get(45).doubleValue() <= 100.0d) {
                                        return 0.8711730653479264d;
                                    }
                                    return 0.42462557060096195d;
                                }
                                return 0.24513486238634763d;
                            }
                            return 0.9534753049901773d;
                        } else {
                            return 0.4633881421622541d;
                        }
                    } else if (list.get(58).doubleValue() <= 1.5d) {
                        if (list.get(64).doubleValue() <= 4.731500148773193d) {
                            return 0.27938763248439014d;
                        }
                        if (list.get(55).doubleValue() <= 72.0d) {
                            return 0.5116958041872793d;
                        }
                        return 0.705240014791547d;
                    } else {
                        return 0.11114773556500937d;
                    }
                } else if (list.get(58).doubleValue() <= 1.5d) {
                    if (list.get(61).doubleValue() <= 24.0d) {
                        return 0.16483559866932182d;
                    }
                    if (list.get(66).doubleValue() <= 1.5d) {
                        return 0.5213047301040159d;
                    }
                    if (list.get(61).doubleValue() <= 48.0d) {
                        return 0.3113894639568926d;
                    }
                    if (list.get(71).doubleValue() <= 48.0d) {
                        if (list.get(71).doubleValue() <= 8.0d) {
                            return 0.5557808183304029d;
                        }
                        if (list.get(71).doubleValue() <= 24.0d) {
                            return 0.00981101257812707d;
                        }
                        return 0.3136678038421692d;
                    }
                    return 0.5173969655555385d;
                } else if (list.get(61).doubleValue() <= 100.0d) {
                    if (list.get(61).doubleValue() <= 24.0d) {
                        if (list.get(55).doubleValue() <= 72.0d) {
                            return 0.3730701837512199d;
                        }
                        return 0.6603974333957391d;
                    } else if (list.get(71).doubleValue() <= 48.0d) {
                        if (list.get(71).doubleValue() <= 8.0d) {
                            return 0.7768701653144557d;
                        }
                        if (list.get(71).doubleValue() <= 24.0d) {
                            return 0.012816608800675285d;
                        }
                        return 0.5905718381591739d;
                    } else if (list.get(61).doubleValue() <= 48.0d) {
                        if (list.get(56).doubleValue() <= 7.427999973297119d) {
                            return 0.7402094800627698d;
                        }
                        if (list.get(55).doubleValue() <= 48.0d) {
                            return 0.44651242829251403d;
                        }
                        return 0.728994504895218d;
                    } else {
                        return 0.7658611107145343d;
                    }
                } else {
                    return 0.28827332861420285d;
                }
            } else if (list.get(72).doubleValue() <= 9.286499977111816d) {
                if (list.get(55).doubleValue() <= 72.0d) {
                    if (list.get(64).doubleValue() <= 1.2425000071525574d) {
                        if (list.get(72).doubleValue() > 3.020500063896179d) {
                            if (list.get(69).doubleValue() <= 72.0d) {
                                return 0.6667876920387961d;
                            }
                            return 0.20967501321031973d;
                        }
                        return 0.8174245054272175d;
                    } else if (list.get(72).doubleValue() <= 4.916500091552734d) {
                        if (list.get(69).doubleValue() <= 100.0d) {
                            return 0.9137773850891682d;
                        }
                        return 0.5861344489582807d;
                    } else if (list.get(64).doubleValue() <= 3.9605000019073486d) {
                        return 0.6270393345617782d;
                    } else {
                        return 0.8993399324888781d;
                    }
                }
                return 0.9528609997619156d;
            } else if (list.get(64).doubleValue() <= 5.917500019073486d) {
                if (list.get(61).doubleValue() <= 100.0d) {
                    if (list.get(56).doubleValue() <= 2.25d) {
                        if (list.get(64).doubleValue() <= 3.2384999990463257d) {
                            return 0.5334550636950883d;
                        }
                        return 0.6503488028642678d;
                    }
                    return 0.4395942511565148d;
                } else if (list.get(64).doubleValue() <= 4.255500078201294d) {
                    return 0.16256445219744622d;
                } else {
                    return 0.709395415897561d;
                }
            } else if (list.get(55).doubleValue() > 72.0d) {
                if (list.get(47).doubleValue() <= 100.0d) {
                    if (list.get(64).doubleValue() > 9.002999782562256d) {
                        if (list.get(39).doubleValue() <= 100.0d) {
                            if (list.get(47).doubleValue() <= 72.0d) {
                                if (list.get(47).doubleValue() <= 8.0d) {
                                    return 0.9321623227084458d;
                                }
                                return 0.8063229650447219d;
                            }
                            return 0.9553571069272341d;
                        }
                        return 0.7980117003789731d;
                    }
                    return 0.7717892546796733d;
                }
                return 0.6952173650166233d;
            } else if (list.get(55).doubleValue() <= 8.0d) {
                if (list.get(52).doubleValue() <= 2.0d) {
                    return 0.8775324404372564d;
                }
                return 0.7463119371718612d;
            } else if (list.get(74).doubleValue() <= 1.5d) {
                if (list.get(66).doubleValue() <= 1.5d) {
                    if (list.get(64).doubleValue() <= 9.29099988937378d) {
                        return 0.4123276075854029d;
                    }
                    return 0.6829820170550281d;
                }
                return 0.41464257601983884d;
            } else if (list.get(66).doubleValue() <= 1.5d) {
                return 0.10915116160221411d;
            } else {
                return 0.557272013655203d;
            }
        } else if (list.get(71).doubleValue() <= 100.0d) {
            if (list.get(72).doubleValue() > 6.796499967575073d) {
                if (list.get(69).doubleValue() <= 100.0d) {
                    if (list.get(71).doubleValue() <= 24.0d) {
                        if (list.get(69).doubleValue() <= 72.0d) {
                            return 0.09339672105475348d;
                        }
                        if (list.get(71).doubleValue() <= 8.0d) {
                            if (list.get(47).doubleValue() <= 100.0d) {
                                return 0.3884755662638829d;
                            }
                            return 0.22000505821126268d;
                        }
                        return 0.042758816773593215d;
                    } else if (list.get(71).doubleValue() <= 48.0d) {
                        if (list.get(69).doubleValue() <= 72.0d) {
                            if (list.get(74).doubleValue() <= 1.5d) {
                                if (list.get(66).doubleValue() <= 1.5d) {
                                    return 0.5326050259900158d;
                                }
                                return 0.8493857584591803d;
                            }
                            return 0.3318427340037586d;
                        }
                        return 0.8139984768745325d;
                    } else if (list.get(69).doubleValue() <= 48.0d) {
                        if (list.get(61).doubleValue() > 8.0d) {
                            if (list.get(69).doubleValue() <= 8.0d) {
                                return 0.12219746683806365d;
                            }
                            if (list.get(64).doubleValue() <= 6.76449990272522d) {
                                return 0.2250863371867753d;
                            }
                            if (list.get(72).doubleValue() <= 12.13450002670288d) {
                                if (list.get(71).doubleValue() <= 72.0d) {
                                    return 0.3331330360887905d;
                                }
                                return 0.5768215188314787d;
                            } else if (list.get(64).doubleValue() > 12.13450002670288d) {
                                if (list.get(67).doubleValue() <= 0.5d) {
                                    return 0.5023795611082279d;
                                }
                                if (list.get(67).doubleValue() <= 100.0d) {
                                    return 0.3669307588003594d;
                                }
                                return 0.1647699104893088d;
                            } else {
                                return 0.14854196635444927d;
                            }
                        } else if (list.get(71).doubleValue() > 72.0d) {
                            if (list.get(59).doubleValue() <= 60.5d) {
                                return 0.9527454321345755d;
                            }
                            return 0.4265616856122067d;
                        } else {
                            return 0.09799151487372293d;
                        }
                    } else if (list.get(71).doubleValue() <= 72.0d) {
                        if (list.get(69).doubleValue() <= 72.0d) {
                            if (list.get(67).doubleValue() <= 100.0d) {
                                if (list.get(67).doubleValue() <= 32.5d) {
                                    return 0.23299386045302956d;
                                }
                                return 0.6377400994537145d;
                            }
                            return 0.08642862679252036d;
                        } else if (list.get(61).doubleValue() <= 72.0d) {
                            if (list.get(66).doubleValue() <= 1.5d) {
                                return 0.5178245288564923d;
                            }
                            return 0.26846165337404965d;
                        } else if (list.get(61).doubleValue() <= 100.0d) {
                            if (list.get(66).doubleValue() <= 1.5d) {
                                return 0.7861601793468223d;
                            }
                            return 0.6336888031016308d;
                        } else {
                            return 0.4143768268283565d;
                        }
                    } else if (list.get(67).doubleValue() <= 0.5d) {
                        if (list.get(69).doubleValue() <= 72.0d) {
                            if (list.get(64).doubleValue() <= 6.766000032424927d) {
                                return 0.14617574911838604d;
                            }
                            if (list.get(55).doubleValue() <= 100.0d) {
                                return 0.395433828385781d;
                            }
                            return 0.2619561137545039d;
                        }
                        return 0.17013895989209216d;
                    } else if (list.get(47).doubleValue() <= 100.0d) {
                        if (list.get(64).doubleValue() > 6.780500173568726d) {
                            if (list.get(67).doubleValue() <= 100.0d) {
                                return 0.23269887675423914d;
                            }
                            return 0.08426010743982187d;
                        }
                        return 0.08296492499028923d;
                    } else {
                        return 0.08184888064472406d;
                    }
                } else if (list.get(66).doubleValue() <= 1.5d) {
                    if (list.get(71).doubleValue() <= 24.0d) {
                        if (list.get(64).doubleValue() <= 3.5975000858306885d) {
                            return 0.29467699693001964d;
                        }
                        return 0.04567654137762842d;
                    } else if (list.get(72).doubleValue() <= 9.827000141143799d) {
                        if (list.get(61).doubleValue() <= 100.0d) {
                            if (list.get(64).doubleValue() <= 2.138000011444092d) {
                                return 0.6158074000336641d;
                            }
                            if (list.get(61).doubleValue() <= 48.0d) {
                                return 0.4300200263285356d;
                            }
                            return 0.1959949492635587d;
                        } else if (list.get(71).doubleValue() > 72.0d) {
                            if (list.get(67).doubleValue() <= 100.0d) {
                                return 0.697469605214642d;
                            }
                            return 0.3481760946047319d;
                        } else {
                            return 0.10321825593893047d;
                        }
                    } else if (list.get(71).doubleValue() > 48.0d) {
                        if (list.get(47).doubleValue() <= 100.0d) {
                            if (list.get(50).doubleValue() > 0.5d) {
                                if (list.get(56).doubleValue() > 0.3465000092983246d) {
                                    if (list.get(44).doubleValue() > 0.5d) {
                                        if (list.get(45).doubleValue() <= 100.0d) {
                                            if (list.get(61).doubleValue() <= 100.0d) {
                                                if (list.get(55).doubleValue() <= 100.0d) {
                                                    if (list.get(74).doubleValue() <= 1.5d) {
                                                        return 0.36249420897682016d;
                                                    }
                                                    return 0.06283063820432132d;
                                                }
                                                return 0.15059918628776073d;
                                            } else if (list.get(71).doubleValue() > 72.0d) {
                                                if (list.get(67).doubleValue() <= 60.5d) {
                                                    if (list.get(45).doubleValue() > 72.0d) {
                                                        if (list.get(47).doubleValue() <= 72.0d) {
                                                            return 0.3952028347656819d;
                                                        }
                                                        return 0.9030446521338013d;
                                                    }
                                                    return 0.4982097631988779d;
                                                }
                                                return 0.2651936612268552d;
                                            } else {
                                                return 0.13552499178825425d;
                                            }
                                        }
                                        return 0.1486780571368636d;
                                    } else if (list.get(55).doubleValue() <= 100.0d) {
                                        if (list.get(53).doubleValue() <= 100.0d) {
                                            if (list.get(56).doubleValue() <= 9.93149995803833d) {
                                                return 0.15306858691672862d;
                                            }
                                            return 0.3427719463011418d;
                                        }
                                        return 0.09750953998045207d;
                                    } else {
                                        return 0.0884440350398179d;
                                    }
                                } else if (list.get(71).doubleValue() <= 72.0d) {
                                    return 0.10039014931247844d;
                                } else {
                                    if (list.get(61).doubleValue() <= 100.0d) {
                                        return 0.09881331291037822d;
                                    }
                                    return 0.7666475028741359d;
                                }
                            } else if (list.get(64).doubleValue() <= 1.8690000176429749d) {
                                return 0.240158605487395d;
                            } else {
                                return 0.09199042836368952d;
                            }
                        } else if (list.get(61).doubleValue() > 100.0d) {
                            if (list.get(67).doubleValue() <= 100.0d) {
                                if (list.get(45).doubleValue() <= 8.0d) {
                                    return 0.5964269885046394d;
                                }
                                if (list.get(45).doubleValue() > 100.0d) {
                                    if (list.get(31).doubleValue() <= 100.0d) {
                                        if (list.get(39).doubleValue() > 72.0d) {
                                            if (list.get(40).doubleValue() > 0.3465000092983246d) {
                                                if (list.get(27).doubleValue() <= 0.5d) {
                                                    return 0.1219515409943919d;
                                                }
                                                return 0.5530327024206022d;
                                            }
                                            return 0.7926258546452025d;
                                        }
                                        return 0.14616439277303564d;
                                    }
                                    return 0.17960314790345402d;
                                }
                                return 0.09704076632405491d;
                            }
                            return 0.05276498778518351d;
                        } else {
                            return 0.06401142950388772d;
                        }
                    } else {
                        return 0.6121544028650058d;
                    }
                } else if (list.get(74).doubleValue() <= 1.5d) {
                    return 0.02661430019312355d;
                } else {
                    return 0.10714056433704952d;
                }
            } else if (list.get(71).doubleValue() <= 24.0d) {
                if (list.get(61).doubleValue() <= 100.0d) {
                    if (list.get(69).doubleValue() <= 72.0d) {
                        return 0.1306228868892766d;
                    }
                    if (list.get(64).doubleValue() <= 2.9700000286102295d) {
                        return 0.4697277920277518d;
                    }
                    return 0.2593916064153827d;
                }
                return 0.026643703127468367d;
            } else if (list.get(64).doubleValue() <= 2.25d) {
                if (list.get(61).doubleValue() <= 72.0d) {
                    if (list.get(71).doubleValue() <= 72.0d) {
                        return 0.4564643462137068d;
                    }
                    if (list.get(72).doubleValue() > 2.441499948501587d) {
                        if (list.get(69).doubleValue() <= 100.0d) {
                            if (list.get(72).doubleValue() <= 4.310499906539917d) {
                                return 0.7456865948925462d;
                            }
                            return 0.45269640777686626d;
                        } else if (list.get(72).doubleValue() <= 4.5274999141693115d) {
                            return 0.63537220862046d;
                        } else {
                            return 0.9365088943226948d;
                        }
                    } else if (list.get(64).doubleValue() <= 0.8959999978542328d) {
                        return 0.35144842134776133d;
                    } else {
                        return 0.9435509697973257d;
                    }
                } else if (list.get(72).doubleValue() <= 2.740499973297119d) {
                    if (list.get(64).doubleValue() <= 0.8959999978542328d) {
                        return 0.16542567821604667d;
                    }
                    return 0.7184041114347383d;
                } else {
                    return 0.4121762433148023d;
                }
            } else if (list.get(61).doubleValue() <= 48.0d) {
                if (list.get(69).doubleValue() <= 8.0d) {
                    if (list.get(71).doubleValue() <= 72.0d) {
                        return 0.006657279431161261d;
                    }
                    return 0.9906168100683213d;
                } else if (list.get(61).doubleValue() <= 8.0d) {
                    if (list.get(69).doubleValue() <= 48.0d) {
                        return 0.8097708037567403d;
                    }
                    return 0.06749880696355984d;
                } else if (list.get(55).doubleValue() <= 100.0d) {
                    if (list.get(55).doubleValue() <= 24.0d) {
                        return 0.5995410298211323d;
                    }
                    return 0.8063866275975282d;
                } else {
                    return 0.3598984053023167d;
                }
            } else if (list.get(72).doubleValue() > 3.068000078201294d) {
                if (list.get(47).doubleValue() <= 100.0d) {
                    if (list.get(47).doubleValue() <= 8.0d) {
                        if (list.get(67).doubleValue() <= 100.0d) {
                            if (list.get(67).doubleValue() <= 72.0d) {
                                return 0.42162091854229805d;
                            }
                            return 0.832178685822384d;
                        }
                        return 0.31473699908953207d;
                    }
                    return 0.6307469798767108d;
                } else if (list.get(61).doubleValue() <= 100.0d) {
                    return 0.1379590050047206d;
                } else {
                    return 0.38329989966313055d;
                }
            } else {
                return 0.6600370854265281d;
            }
        } else if (list.get(55).doubleValue() > 100.0d) {
            if (list.get(47).doubleValue() <= 100.0d) {
                if (list.get(47).doubleValue() <= 8.0d) {
                    return 0.01007797637969835d;
                }
                if (list.get(53).doubleValue() <= 8.0d) {
                    if (list.get(45).doubleValue() <= 72.0d) {
                        return 0.07752165408785718d;
                    }
                    return 0.6559776076320933d;
                }
                return 0.06510560096417523d;
            }
            return 0.007536930215743173d;
        } else if (list.get(55).doubleValue() > 8.0d) {
            if (list.get(69).doubleValue() <= 8.0d) {
                if (list.get(67).doubleValue() <= 60.5d) {
                    if (list.get(55).doubleValue() > 72.0d) {
                        if (list.get(47).doubleValue() > 100.0d) {
                            if (list.get(45).doubleValue() <= 24.0d) {
                                return 0.8747239916795284d;
                            }
                            return 0.48002974515166746d;
                        }
                        return 0.5311604333328432d;
                    }
                    return 0.13136019779551455d;
                }
                return 0.09619904199465917d;
            } else if (list.get(61).doubleValue() <= 100.0d) {
                if (list.get(69).doubleValue() <= 48.0d) {
                    if (list.get(53).doubleValue() <= 100.0d) {
                        if (list.get(53).doubleValue() <= 72.0d) {
                            return 0.21953701086710084d;
                        }
                        return 0.4371419956305622d;
                    }
                    return 0.08906135157089475d;
                } else if (list.get(74).doubleValue() <= 1.5d) {
                    if (list.get(67).doubleValue() <= 72.0d) {
                        if (list.get(72).doubleValue() <= 8.473999977111816d) {
                            if (list.get(69).doubleValue() > 100.0d) {
                                if (list.get(47).doubleValue() <= 72.0d) {
                                    return 0.20882047886691021d;
                                }
                                return 0.5364168880433777d;
                            }
                            return 0.11795676426961552d;
                        }
                        return 0.11849064165479312d;
                    }
                    return 0.06306151568990263d;
                } else if (list.get(66).doubleValue() <= 1.5d) {
                    if (list.get(55).doubleValue() <= 72.0d) {
                        return 0.1325444376809452d;
                    }
                    return 0.34101539240239137d;
                } else {
                    return 0.11766767521892975d;
                }
            } else if (list.get(53).doubleValue() <= 100.0d) {
                if (list.get(53).doubleValue() > 72.0d) {
                    if (list.get(69).doubleValue() > 100.0d) {
                        if (list.get(47).doubleValue() <= 100.0d) {
                            return 0.4193522893786864d;
                        }
                        return 0.8705779062365612d;
                    }
                    return 0.04266985587133432d;
                }
                return 0.10929766151114867d;
            } else {
                return 0.06518490030358642d;
            }
        } else if (list.get(64).doubleValue() > 0.3465000092983246d) {
            if (list.get(69).doubleValue() <= 48.0d) {
                return 0.05030685896726164d;
            }
            return 0.018690083702599745d;
        } else if (list.get(72).doubleValue() <= 6.2220001220703125d) {
            if (list.get(72).doubleValue() <= 5.476500034332275d) {
                return 0.1032902715590219d;
            }
            if (list.get(61).doubleValue() <= 100.0d) {
                return 0.6401933600681774d;
            }
            return 0.03271211728007217d;
        } else {
            return 0.051983148902148044d;
        }
    }

    private final double tree4(List<Double> list) {
        if (list.get(63).doubleValue() <= 100.0d) {
            if (list.get(71).doubleValue() > 100.0d) {
                if (list.get(69).doubleValue() > 8.0d) {
                    if (list.get(69).doubleValue() <= 100.0d) {
                        if (list.get(74).doubleValue() > 1.5d) {
                            if (list.get(66).doubleValue() <= 1.5d) {
                                if (list.get(58).doubleValue() <= 1.5d) {
                                    if (list.get(64).doubleValue() <= 11.332499980926514d) {
                                        if (list.get(61).doubleValue() <= 100.0d) {
                                            if (list.get(55).doubleValue() <= 100.0d) {
                                                return 0.3871827741693557d;
                                            }
                                            return 0.6799560171887552d;
                                        }
                                        return 0.6549292181945707d;
                                    } else if (list.get(55).doubleValue() <= 100.0d) {
                                        if (list.get(56).doubleValue() <= 8.5d) {
                                            return 0.3955165305169488d;
                                        }
                                        return 0.17066988565101476d;
                                    } else if (list.get(47).doubleValue() <= 100.0d) {
                                        if (list.get(47).doubleValue() <= 24.0d) {
                                            return 0.47843715371433976d;
                                        }
                                        return 0.19752520121073566d;
                                    } else {
                                        return 0.6122157096444464d;
                                    }
                                } else if (list.get(63).doubleValue() <= 72.0d) {
                                    if (list.get(63).doubleValue() <= 8.0d) {
                                        return 0.6830283646443698d;
                                    }
                                    return 0.07747296565573829d;
                                } else if (list.get(56).doubleValue() <= 9.978000164031982d) {
                                    return 0.4594765304517283d;
                                } else {
                                    return 0.2444830643639029d;
                                }
                            } else if (list.get(63).doubleValue() > 72.0d) {
                                if (list.get(69).doubleValue() <= 48.0d) {
                                    if (list.get(55).doubleValue() <= 100.0d) {
                                        return 0.4356959949001097d;
                                    }
                                    return 0.6942324422481584d;
                                } else if (list.get(56).doubleValue() <= 9.233500003814697d) {
                                    if (list.get(67).doubleValue() <= 0.5d) {
                                        return 0.5140448238347265d;
                                    }
                                    return 0.7831625282329706d;
                                } else if (list.get(47).doubleValue() > 100.0d) {
                                    if (list.get(39).doubleValue() <= 100.0d) {
                                        return 0.6681352020877271d;
                                    }
                                    return 0.8358614447236694d;
                                } else if (list.get(47).doubleValue() <= 24.0d) {
                                    return 0.6685077951037511d;
                                } else {
                                    return 0.4589937853461166d;
                                }
                            } else if (list.get(63).doubleValue() <= 8.0d) {
                                if (list.get(55).doubleValue() <= 100.0d) {
                                    if (list.get(55).doubleValue() <= 8.0d) {
                                        return 0.745626604702842d;
                                    }
                                    if (list.get(53).doubleValue() <= 100.0d) {
                                        return 0.3958631768679672d;
                                    }
                                    return 0.7339751384556726d;
                                }
                                return 0.906129945026178d;
                            } else if (list.get(61).doubleValue() <= 100.0d) {
                                if (list.get(61).doubleValue() <= 72.0d) {
                                    if (list.get(53).doubleValue() <= 100.0d) {
                                        if (list.get(55).doubleValue() <= 24.0d) {
                                            return 0.4631273302315112d;
                                        }
                                        return 0.3162288668715829d;
                                    }
                                    return 0.612893509639884d;
                                } else if (list.get(47).doubleValue() <= 100.0d) {
                                    return 0.23819505574068184d;
                                } else {
                                    return 0.48959585267356504d;
                                }
                            } else if (list.get(63).doubleValue() <= 48.0d) {
                                return 0.8738973679807039d;
                            } else {
                                if (list.get(64).doubleValue() <= 7.276000022888184d) {
                                    return 0.7709700998547789d;
                                }
                                if (list.get(53).doubleValue() <= 100.0d) {
                                    return 0.42263088315283565d;
                                }
                                return 0.6449511792343944d;
                            }
                        } else if (list.get(47).doubleValue() > 100.0d) {
                            if (list.get(39).doubleValue() <= 100.0d) {
                                if (list.get(55).doubleValue() <= 100.0d) {
                                    if (list.get(50).doubleValue() <= 1.5d) {
                                        if (list.get(39).doubleValue() <= 8.0d) {
                                            return 0.7286344025604021d;
                                        }
                                        return 0.5825343445481829d;
                                    }
                                    return 0.8330758810314042d;
                                }
                                return 0.8718417441029325d;
                            }
                            return 0.9298937484564688d;
                        } else if (list.get(72).doubleValue() <= 6.610000133514404d) {
                            if (list.get(53).doubleValue() <= 100.0d) {
                                if (list.get(69).doubleValue() > 72.0d) {
                                    if (list.get(51).doubleValue() <= 0.5d) {
                                        if (list.get(72).doubleValue() <= 4.388000011444092d) {
                                            if (list.get(61).doubleValue() <= 100.0d) {
                                                if (list.get(59).doubleValue() <= 0.5d) {
                                                    return 0.3052938276630619d;
                                                }
                                                if (list.get(61).doubleValue() <= 72.0d) {
                                                    return 0.5620070819256341d;
                                                }
                                                return 0.3491824274498269d;
                                            }
                                            return 0.6891727475556986d;
                                        } else if (list.get(63).doubleValue() <= 72.0d) {
                                            if (list.get(63).doubleValue() <= 8.0d) {
                                                return 0.6175405873129001d;
                                            }
                                            return 0.18257873218596185d;
                                        } else {
                                            return 0.6128675572129536d;
                                        }
                                    } else if (list.get(56).doubleValue() <= 0.3465000092983246d) {
                                        if (list.get(63).doubleValue() <= 72.0d) {
                                            return 0.32985883937670024d;
                                        }
                                        return 0.9859213068817012d;
                                    } else if (list.get(53).doubleValue() <= 72.0d) {
                                        return 0.705552369031584d;
                                    } else {
                                        return 0.48463125961767284d;
                                    }
                                } else if (list.get(61).doubleValue() <= 100.0d) {
                                    if (list.get(61).doubleValue() <= 72.0d) {
                                        if (list.get(63).doubleValue() <= 48.0d) {
                                            if (list.get(56).doubleValue() <= 0.3465000092983246d) {
                                                if (list.get(51).doubleValue() <= 0.5d) {
                                                    if (list.get(63).doubleValue() <= 8.0d) {
                                                        return 0.7294734128706283d;
                                                    }
                                                    return 0.47368190091838625d;
                                                }
                                                return 0.9424075539475788d;
                                            } else if (list.get(55).doubleValue() <= 100.0d) {
                                                if (list.get(37).doubleValue() <= 100.0d) {
                                                    return 0.2842753998244459d;
                                                }
                                                return 0.9163445845447682d;
                                            } else {
                                                return 0.862020855404667d;
                                            }
                                        } else if (list.get(55).doubleValue() <= 100.0d) {
                                            if (list.get(69).doubleValue() > 48.0d) {
                                                if (list.get(67).doubleValue() <= 0.5d) {
                                                    return 0.23378544206328875d;
                                                }
                                                if (list.get(55).doubleValue() <= 72.0d) {
                                                    return 0.519059674714809d;
                                                }
                                                return 0.23225534182816068d;
                                            }
                                            return 0.21634852953937608d;
                                        } else {
                                            return 0.7073445450275754d;
                                        }
                                    } else if (list.get(63).doubleValue() <= 72.0d) {
                                        return 0.09809934292661637d;
                                    } else {
                                        return 0.5769580915238303d;
                                    }
                                } else if (list.get(63).doubleValue() <= 48.0d) {
                                    return 0.9247044565275063d;
                                } else {
                                    return 0.6393123020474704d;
                                }
                            }
                            return 0.9078187544168597d;
                        } else if (list.get(61).doubleValue() <= 100.0d) {
                            if (list.get(63).doubleValue() > 72.0d) {
                                if (list.get(67).doubleValue() <= 0.5d) {
                                    if (list.get(69).doubleValue() <= 72.0d) {
                                        if (list.get(64).doubleValue() <= 6.343500137329102d) {
                                            return 0.5633582510191238d;
                                        }
                                        return 0.3587990052434081d;
                                    }
                                    return 0.5836766811523973d;
                                } else if (list.get(56).doubleValue() <= 10.58050012588501d) {
                                    if (list.get(69).doubleValue() <= 48.0d) {
                                        return 0.6003802852389674d;
                                    }
                                    if (list.get(61).doubleValue() <= 72.0d) {
                                        if (list.get(48).doubleValue() <= 1.7005000114440918d) {
                                            return 0.8159125888125494d;
                                        }
                                        if (list.get(61).doubleValue() <= 8.0d) {
                                            return 0.28436411051090027d;
                                        }
                                        return 0.7156939410299555d;
                                    } else if (list.get(55).doubleValue() <= 72.0d) {
                                        return 0.8546967424135026d;
                                    } else {
                                        return 0.9506108623634935d;
                                    }
                                } else if (list.get(55).doubleValue() <= 100.0d) {
                                    if (list.get(69).doubleValue() > 48.0d) {
                                        if (list.get(31).doubleValue() <= 100.0d) {
                                            if (list.get(31).doubleValue() <= 8.0d) {
                                                return 0.6444926467298141d;
                                            }
                                            return 0.5056075829872109d;
                                        }
                                        return 0.7768566513324131d;
                                    }
                                    return 0.3764296307405829d;
                                } else {
                                    return 0.8340608078484416d;
                                }
                            } else if (list.get(61).doubleValue() <= 72.0d) {
                                if (list.get(63).doubleValue() <= 8.0d) {
                                    if (list.get(47).doubleValue() <= 24.0d) {
                                        if (list.get(64).doubleValue() <= 8.704999923706055d) {
                                            return 0.8936620002175509d;
                                        }
                                        if (list.get(55).doubleValue() <= 100.0d) {
                                            if (list.get(55).doubleValue() <= 24.0d) {
                                                return 0.7702120822303068d;
                                            }
                                            if (list.get(53).doubleValue() <= 100.0d) {
                                                return 0.4576975774063556d;
                                            }
                                            return 0.8324995050531122d;
                                        }
                                        return 0.9209341214963803d;
                                    } else if (list.get(45).doubleValue() <= 100.0d) {
                                        return 0.4951760290919038d;
                                    } else {
                                        return 0.8167290934727054d;
                                    }
                                } else if (list.get(53).doubleValue() <= 100.0d) {
                                    if (list.get(37).doubleValue() <= 100.0d) {
                                        if (list.get(56).doubleValue() <= 1.7005000114440918d) {
                                            if (list.get(51).doubleValue() <= 0.5d) {
                                                if (list.get(59).doubleValue() <= 100.0d) {
                                                    return 0.5937773550291059d;
                                                }
                                                return 0.8686186504745823d;
                                            } else if (list.get(56).doubleValue() <= 0.3465000092983246d) {
                                                return 0.9245828623845153d;
                                            } else {
                                                return 0.6501910957408712d;
                                            }
                                        } else if (list.get(55).doubleValue() <= 100.0d) {
                                            if (list.get(45).doubleValue() <= 100.0d) {
                                                if (list.get(56).doubleValue() > 11.327499866485596d) {
                                                    if (list.get(23).doubleValue() <= 100.0d) {
                                                        return 0.3130792499884045d;
                                                    }
                                                    return 0.6468494304614824d;
                                                }
                                                return 0.4823986002060622d;
                                            }
                                            return 0.7038440955424212d;
                                        } else {
                                            return 0.707287701653876d;
                                        }
                                    }
                                    return 0.8255693720044185d;
                                } else {
                                    return 0.861375092116198d;
                                }
                            } else if (list.get(53).doubleValue() <= 100.0d) {
                                if (list.get(55).doubleValue() <= 100.0d) {
                                    if (list.get(63).doubleValue() <= 8.0d) {
                                        if (list.get(55).doubleValue() <= 24.0d) {
                                            return 0.5653240965451233d;
                                        }
                                        return 0.36899075117836067d;
                                    } else if (list.get(45).doubleValue() <= 100.0d) {
                                        if (list.get(56).doubleValue() <= 7.627999782562256d) {
                                            if (list.get(72).doubleValue() <= 11.825000286102295d) {
                                                return 0.24369044470854895d;
                                            }
                                            if (list.get(64).doubleValue() > 11.827499866485596d) {
                                                if (list.get(69).doubleValue() <= 48.0d) {
                                                    return 0.2708595601158615d;
                                                }
                                                return 0.41974732154119854d;
                                            }
                                            return 0.5564464487957084d;
                                        }
                                        return 0.22828738615316066d;
                                    } else {
                                        return 0.6336213402075773d;
                                    }
                                }
                                return 0.6264131672795356d;
                            } else {
                                return 0.7353579267257965d;
                            }
                        } else if (list.get(47).doubleValue() > 24.0d) {
                            if (list.get(58).doubleValue() <= 1.5d) {
                                if (list.get(31).doubleValue() <= 100.0d) {
                                    return 0.5411599435393996d;
                                }
                                return 0.6893429948962491d;
                            }
                            return 0.8497120030484561d;
                        } else if (list.get(63).doubleValue() > 48.0d) {
                            if (list.get(58).doubleValue() <= 1.5d) {
                                if (list.get(64).doubleValue() <= 3.6510000228881836d) {
                                    return 0.893163057025522d;
                                }
                                if (list.get(72).doubleValue() <= 9.38450002670288d) {
                                    return 0.5894040490896146d;
                                }
                                return 0.7630868502443755d;
                            }
                            return 0.9230666677580083d;
                        } else {
                            return 0.9315312207536903d;
                        }
                    } else if (list.get(61).doubleValue() <= 100.0d) {
                        if (list.get(63).doubleValue() <= 48.0d) {
                            return 0.9032001077303553d;
                        }
                        if (list.get(53).doubleValue() > 100.0d) {
                            if (list.get(67).doubleValue() <= 8.5d) {
                                if (list.get(58).doubleValue() <= 1.5d) {
                                    return 0.03552771947821157d;
                                }
                                return 0.7134131493866507d;
                            }
                            return 0.721854880239956d;
                        } else if (list.get(61).doubleValue() > 72.0d) {
                            if (list.get(58).doubleValue() <= 1.5d) {
                                return 0.1630968984473339d;
                            }
                            return 0.6741827284693246d;
                        } else if (list.get(55).doubleValue() <= 100.0d) {
                            if (list.get(58).doubleValue() <= 1.5d) {
                                if (list.get(64).doubleValue() > 4.27649998664856d) {
                                    if (list.get(67).doubleValue() <= 32.5d) {
                                        return 0.33682008454152124d;
                                    }
                                    return 0.6186068927749784d;
                                }
                                return 0.79356466452962d;
                            }
                            return 0.7552228800223797d;
                        } else {
                            return 0.7654702664070412d;
                        }
                    } else if (list.get(63).doubleValue() <= 48.0d) {
                        return 0.9619285010825223d;
                    } else {
                        if (list.get(55).doubleValue() <= 100.0d) {
                            if (list.get(64).doubleValue() > 4.505499839782715d) {
                                if (list.get(58).doubleValue() <= 1.5d) {
                                    return 0.4310319135276969d;
                                }
                                return 0.7448252175186502d;
                            }
                            return 0.9269513635954354d;
                        }
                        return 0.8915148891639443d;
                    }
                } else if (list.get(63).doubleValue() > 48.0d) {
                    if (list.get(67).doubleValue() <= 60.5d) {
                        if (list.get(61).doubleValue() <= 8.0d) {
                            return 0.7534855089853613d;
                        }
                        if (list.get(61).doubleValue() <= 48.0d) {
                            return 0.22021417892997508d;
                        }
                        return 0.03382331089387766d;
                    }
                    return 0.6100385818108229d;
                } else {
                    return 0.8728701164968294d;
                }
            } else if (list.get(55).doubleValue() <= 100.0d) {
                if (list.get(61).doubleValue() > 100.0d) {
                    if (list.get(58).doubleValue() > 1.5d) {
                        if (list.get(74).doubleValue() <= 1.5d) {
                            if (list.get(64).doubleValue() <= 11.717000007629395d) {
                                return 0.9087508197793024d;
                            }
                            return 0.7800426586485599d;
                        } else if (list.get(71).doubleValue() <= 8.0d) {
                            if (list.get(66).doubleValue() <= 1.5d) {
                                return 0.09177435702359765d;
                            }
                            return 0.7112431241320297d;
                        } else if (list.get(64).doubleValue() <= 6.760499954223633d) {
                            if (list.get(72).doubleValue() <= 7.325500011444092d) {
                                if (list.get(63).doubleValue() <= 48.0d) {
                                    return 0.30431153228456104d;
                                }
                                return 0.09742166029986218d;
                            }
                            return 0.6558416478225404d;
                        } else {
                            return 0.2142458683067594d;
                        }
                    } else if (list.get(64).doubleValue() > 4.388000011444092d) {
                        if (list.get(69).doubleValue() <= 100.0d) {
                            if (list.get(56).doubleValue() <= 1.7005000114440918d) {
                                if (list.get(71).doubleValue() <= 8.0d) {
                                    return 0.7005075360316874d;
                                }
                                if (list.get(63).doubleValue() <= 72.0d) {
                                    return 0.43561644515964937d;
                                }
                                if (list.get(64).doubleValue() <= 9.287499904632568d) {
                                    if (list.get(72).doubleValue() <= 9.131999969482422d) {
                                        return 0.1352175753212681d;
                                    }
                                    return 0.6181293390900057d;
                                }
                                return 0.20587400087350502d;
                            } else if (list.get(47).doubleValue() <= 100.0d) {
                                return 0.12505321267574754d;
                            } else {
                                return 0.3468426706303526d;
                            }
                        } else if (list.get(47).doubleValue() > 100.0d) {
                            if (list.get(31).doubleValue() <= 100.0d) {
                                return 0.24264326193674782d;
                            }
                            return 0.48909606709543585d;
                        } else if (list.get(63).doubleValue() > 8.0d) {
                            if (list.get(39).doubleValue() <= 100.0d) {
                                return 0.03570434343954903d;
                            }
                            return 0.19613177438409538d;
                        } else {
                            return 0.26132321733022573d;
                        }
                    } else if (list.get(72).doubleValue() <= 8.065499782562256d) {
                        if (list.get(71).doubleValue() <= 24.0d) {
                            if (list.get(50).doubleValue() <= 0.5d) {
                                if (list.get(71).doubleValue() <= 8.0d) {
                                    return 0.8747676304250798d;
                                }
                                return 0.6144172676977823d;
                            }
                            return 0.40280984198354186d;
                        } else if (list.get(55).doubleValue() <= 24.0d) {
                            if (list.get(63).doubleValue() <= 48.0d) {
                                return 0.4662054294899246d;
                            }
                            return 0.2803262027125393d;
                        } else {
                            return 0.1016931188340606d;
                        }
                    } else if (list.get(64).doubleValue() <= 0.8959999978542328d) {
                        return 0.8468345037935094d;
                    } else {
                        return 0.6515133162352671d;
                    }
                } else if (list.get(47).doubleValue() > 100.0d) {
                    if (list.get(37).doubleValue() <= 100.0d) {
                        if (list.get(74).doubleValue() <= 1.5d) {
                            if (list.get(58).doubleValue() > 1.5d) {
                                if (list.get(50).doubleValue() <= 1.5d) {
                                    return 0.3455761373874695d;
                                }
                                if (list.get(53).doubleValue() <= 100.0d) {
                                    return 0.5177583666988655d;
                                }
                                return 0.8061366324060761d;
                            } else if (list.get(71).doubleValue() <= 72.0d) {
                                if (list.get(71).doubleValue() <= 8.0d) {
                                    return 0.3156733021613411d;
                                }
                                return 0.14389580903922816d;
                            } else if (list.get(55).doubleValue() <= 48.0d) {
                                return 0.46271852044267936d;
                            } else {
                                if (list.get(72).doubleValue() <= 10.697999954223633d) {
                                    return 0.1495312371315752d;
                                }
                                if (list.get(64).doubleValue() <= 10.698999881744385d) {
                                    return 0.6390986002992717d;
                                }
                                return 0.2860010522876304d;
                            }
                        } else if (list.get(39).doubleValue() <= 100.0d) {
                            return 0.11484180718145395d;
                        } else {
                            return 0.2670087617871594d;
                        }
                    } else if (list.get(50).doubleValue() > 1.5d) {
                        if (list.get(74).doubleValue() <= 1.5d) {
                            return 0.7761752776995722d;
                        }
                        return 0.36289197586701283d;
                    } else {
                        return 0.3956411718946693d;
                    }
                } else if (list.get(71).doubleValue() > 72.0d) {
                    if (list.get(74).doubleValue() <= 1.5d) {
                        if (list.get(66).doubleValue() > 1.5d) {
                            if (list.get(58).doubleValue() <= 1.5d) {
                                return 0.2102193128797199d;
                            }
                            if (list.get(63).doubleValue() <= 72.0d) {
                                if (list.get(64).doubleValue() <= 11.91949987411499d) {
                                    if (list.get(72).doubleValue() <= 7.665499925613403d) {
                                        return 0.11376121134013849d;
                                    }
                                    return 0.6095901715874535d;
                                }
                                return 0.4062463147019371d;
                            } else if (list.get(72).doubleValue() <= 7.1590001583099365d) {
                                return 0.043285171932485614d;
                            } else {
                                if (list.get(64).doubleValue() <= 7.023499965667725d) {
                                    return 0.4793547401617884d;
                                }
                                return 0.23906836457533637d;
                            }
                        } else if (list.get(72).doubleValue() <= 8.297500133514404d) {
                            if (list.get(69).doubleValue() <= 48.0d) {
                                return 0.033087013744639335d;
                            }
                            if (list.get(55).doubleValue() <= 48.0d) {
                                if (list.get(72).doubleValue() <= 3.5695000886917114d) {
                                    if (list.get(63).doubleValue() <= 8.0d) {
                                        if (list.get(69).doubleValue() <= 72.0d) {
                                            return 0.0864043994094599d;
                                        }
                                        return 0.5266659034548429d;
                                    }
                                    return 0.05893622371546697d;
                                } else if (list.get(64).doubleValue() <= 0.3465000092983246d) {
                                    if (list.get(69).doubleValue() <= 72.0d) {
                                        return 0.2136475912788335d;
                                    }
                                    return 0.9062205207248654d;
                                } else {
                                    return 0.16451071666566122d;
                                }
                            }
                            return 0.03560591214534791d;
                        } else if (list.get(64).doubleValue() <= 7.4065001010894775d) {
                            if (list.get(63).doubleValue() <= 24.0d) {
                                if (list.get(59).doubleValue() <= 100.0d) {
                                    return 0.5319213015272429d;
                                }
                                return 0.8828784323109247d;
                            } else if (list.get(69).doubleValue() > 48.0d) {
                                if (list.get(59).doubleValue() <= 100.0d) {
                                    return 0.33402780792186315d;
                                }
                                return 0.8143132921042187d;
                            } else if (list.get(61).doubleValue() <= 48.0d) {
                                if (list.get(53).doubleValue() <= 8.0d) {
                                    return 0.19195921360750048d;
                                }
                                return 0.323331657944183d;
                            } else {
                                return 0.40644727495651517d;
                            }
                        } else if (list.get(63).doubleValue() > 72.0d) {
                            if (list.get(39).doubleValue() <= 100.0d) {
                                if (list.get(55).doubleValue() <= 72.0d) {
                                    return 0.07918034911415418d;
                                }
                                return 0.029193256709323885d;
                            }
                            return 0.19520713574999954d;
                        } else if (list.get(55).doubleValue() > 8.0d) {
                            if (list.get(39).doubleValue() <= 100.0d) {
                                if (list.get(48).doubleValue() > 8.429500102996826d) {
                                    if (list.get(31).doubleValue() <= 100.0d) {
                                        return 0.06815858947391364d;
                                    }
                                    return 0.24941200215914858d;
                                } else if (list.get(53).doubleValue() > 100.0d) {
                                    if (list.get(50).doubleValue() <= 1.5d) {
                                        return 0.2842444470739101d;
                                    }
                                    return 0.7100097968390113d;
                                } else {
                                    return 0.1305667765207619d;
                                }
                            }
                            return 0.3484211118618226d;
                        } else if (list.get(72).doubleValue() <= 13.166500091552734d) {
                            if (list.get(67).doubleValue() <= 48.0d) {
                                return 0.12488105222504929d;
                            }
                            return 0.2707148541523453d;
                        } else if (list.get(64).doubleValue() <= 12.92549991607666d) {
                            return 0.3580000491418543d;
                        } else {
                            return 0.18213650580974206d;
                        }
                    } else if (list.get(63).doubleValue() <= 8.0d) {
                        if (list.get(59).doubleValue() <= 100.0d) {
                            return 0.12170821425439858d;
                        }
                        return 0.6077580547780204d;
                    } else if (list.get(53).doubleValue() <= 100.0d) {
                        return 0.02965891740242715d;
                    } else {
                        return 0.19614340979990824d;
                    }
                } else if (list.get(53).doubleValue() <= 100.0d) {
                    if (list.get(59).doubleValue() <= 100.0d) {
                        if (list.get(45).doubleValue() > 100.0d) {
                            if (list.get(48).doubleValue() > 0.3465000092983246d) {
                                if (list.get(42).doubleValue() > 1.5d) {
                                    if (list.get(74).doubleValue() <= 1.5d) {
                                        return 0.5852021880036462d;
                                    }
                                    return 0.16399796904988556d;
                                }
                                return 0.1449990561436698d;
                            }
                            return 0.6867534741456044d;
                        } else if (list.get(71).doubleValue() > 8.0d) {
                            if (list.get(69).doubleValue() <= 100.0d) {
                                if (list.get(37).doubleValue() <= 100.0d) {
                                    if (list.get(64).doubleValue() > 1.4975000023841858d) {
                                        if (list.get(43).doubleValue() <= 100.0d) {
                                            return 0.02040593180242821d;
                                        }
                                        return 0.18339329806854843d;
                                    } else if (list.get(72).doubleValue() <= 5.9700000286102295d) {
                                        return 0.014494398061742568d;
                                    } else {
                                        return 0.12356013475087235d;
                                    }
                                }
                                return 0.14061421760178872d;
                            } else if (list.get(66).doubleValue() > 1.5d) {
                                if (list.get(74).doubleValue() <= 1.5d) {
                                    return 0.6559957085822898d;
                                }
                                return 0.14769138349203917d;
                            } else {
                                return 0.111993915044843d;
                            }
                        } else if (list.get(63).doubleValue() <= 8.0d) {
                            if (list.get(53).doubleValue() <= 8.0d) {
                                if (list.get(64).doubleValue() <= 1.4975000023841858d) {
                                    return 0.27860934937661835d;
                                }
                                if (list.get(61).doubleValue() <= 48.0d) {
                                    return 0.7110795081040617d;
                                }
                                return 0.3294408437795937d;
                            }
                            return 0.10475092504578927d;
                        } else if (list.get(72).doubleValue() <= 8.20550012588501d) {
                            return 0.04212683844067427d;
                        } else {
                            if (list.get(56).doubleValue() <= 3.3140000104904175d) {
                                if (list.get(63).doubleValue() <= 72.0d) {
                                    return 0.15349209100784733d;
                                }
                                return 0.08093709544714595d;
                            }
                            return 0.054512631619741826d;
                        }
                    } else if (list.get(61).doubleValue() <= 8.0d) {
                        return 0.10191658725598016d;
                    } else {
                        if (list.get(61).doubleValue() <= 72.0d) {
                            if (list.get(72).doubleValue() <= 6.15149998664856d) {
                                return 0.2758741053371446d;
                            }
                            return 0.5723241966880747d;
                        }
                        return 0.1946172184926906d;
                    }
                } else if (list.get(50).doubleValue() > 1.5d) {
                    if (list.get(74).doubleValue() <= 1.5d) {
                        if (list.get(58).doubleValue() <= 1.5d) {
                            return 0.4595925050745319d;
                        }
                        return 0.7802665661258993d;
                    }
                    return 0.2280177485670248d;
                } else if (list.get(71).doubleValue() <= 8.0d) {
                    return 0.34128908819701076d;
                } else {
                    return 0.15926744251260616d;
                }
            } else if (list.get(47).doubleValue() > 100.0d) {
                if (list.get(74).doubleValue() <= 1.5d) {
                    if (list.get(58).doubleValue() <= 1.5d) {
                        if (list.get(45).doubleValue() <= 100.0d) {
                            if (list.get(71).doubleValue() > 72.0d) {
                                if (list.get(69).doubleValue() <= 48.0d) {
                                    return 0.4735488566347081d;
                                }
                                if (list.get(61).doubleValue() <= 8.0d) {
                                    return 0.9411317790139323d;
                                }
                                return 0.6325450321679861d;
                            } else if (list.get(71).doubleValue() <= 8.0d) {
                                if (list.get(61).doubleValue() <= 100.0d) {
                                    return 0.5248041380014737d;
                                }
                                return 0.8199001829462084d;
                            } else if (list.get(61).doubleValue() <= 100.0d) {
                                return 0.30971921920068735d;
                            } else {
                                return 0.511062907579477d;
                            }
                        }
                        return 0.6998026185431532d;
                    }
                    return 0.8730929716891419d;
                } else if (list.get(71).doubleValue() > 8.0d) {
                    if (list.get(42).doubleValue() <= 1.5d) {
                        return 0.3231985985535731d;
                    }
                    return 0.5263983070599682d;
                } else {
                    return 0.7605461654508786d;
                }
            } else if (list.get(45).doubleValue() <= 100.0d) {
                if (list.get(74).doubleValue() <= 1.5d) {
                    if (list.get(58).doubleValue() <= 1.5d) {
                        if (list.get(61).doubleValue() <= 8.0d) {
                            if (list.get(67).doubleValue() <= 72.0d) {
                                return 0.768117223121708d;
                            }
                            return 0.20869598244968013d;
                        } else if (list.get(72).doubleValue() <= 8.6875d) {
                            if (list.get(53).doubleValue() <= 48.0d) {
                                return 0.12482455287678802d;
                            }
                            if (list.get(71).doubleValue() <= 8.0d) {
                                return 0.4490535005053169d;
                            }
                            return 0.2551753517678162d;
                        } else if (list.get(47).doubleValue() > 8.0d) {
                            if (list.get(31).doubleValue() <= 100.0d) {
                                if (list.get(64).doubleValue() > 8.55649995803833d) {
                                    if (list.get(29).doubleValue() <= 100.0d) {
                                        return 0.20958878391276534d;
                                    }
                                    return 0.4632517235803124d;
                                }
                                return 0.5151147151175719d;
                            }
                            return 0.43922725026049436d;
                        } else if (list.get(64).doubleValue() <= 8.70300006866455d) {
                            if (list.get(71).doubleValue() <= 72.0d) {
                                return 0.461667759094839d;
                            }
                            return 0.664915569820711d;
                        } else if (list.get(56).doubleValue() <= 6.683500051498413d) {
                            if (list.get(71).doubleValue() <= 72.0d) {
                                return 0.1724880673171977d;
                            }
                            return 0.34225803809788297d;
                        } else if (list.get(61).doubleValue() <= 100.0d) {
                            if (list.get(63).doubleValue() <= 8.0d) {
                                return 0.5610516134856459d;
                            }
                            if (list.get(71).doubleValue() <= 72.0d) {
                                return 0.23590822159367822d;
                            }
                            return 0.4204325386717556d;
                        } else if (list.get(71).doubleValue() <= 8.0d) {
                            return 0.8004144592035911d;
                        } else {
                            return 0.5623652960584229d;
                        }
                    } else if (list.get(61).doubleValue() <= 100.0d) {
                        if (list.get(59).doubleValue() <= 100.0d) {
                            if (list.get(67).doubleValue() <= 72.0d) {
                                return 0.5929654558305631d;
                            }
                            return 0.30559136455981034d;
                        }
                        return 0.7892889620031851d;
                    } else {
                        return 0.8526290017342157d;
                    }
                } else if (list.get(53).doubleValue() <= 100.0d) {
                    if (list.get(63).doubleValue() <= 8.0d) {
                        return 0.4210244678297828d;
                    }
                    if (list.get(61).doubleValue() > 100.0d) {
                        if (list.get(50).doubleValue() <= 1.5d) {
                            return 0.1833343502539786d;
                        }
                        return 0.38933925954583054d;
                    }
                    return 0.14120560641875715d;
                } else {
                    return 0.4993154609493697d;
                }
            } else if (list.get(74).doubleValue() <= 1.5d) {
                if (list.get(58).doubleValue() <= 1.5d) {
                    if (list.get(71).doubleValue() <= 8.0d) {
                        return 0.7471187499533134d;
                    }
                    if (list.get(53).doubleValue() <= 100.0d) {
                        return 0.5555476116147701d;
                    }
                    return 0.31117703476820213d;
                }
                return 0.9002242860376292d;
            } else if (list.get(50).doubleValue() <= 1.5d) {
                return 0.2902484467465046d;
            } else {
                return 0.49539917213651713d;
            }
        } else if (list.get(71).doubleValue() <= 100.0d) {
            if (list.get(72).doubleValue() <= 6.203999996185303d) {
                if (list.get(71).doubleValue() <= 8.0d) {
                    if (list.get(61).doubleValue() <= 100.0d) {
                        if (list.get(55).doubleValue() <= 100.0d) {
                            if (list.get(59).doubleValue() <= 0.5d) {
                                return 0.42031631829548566d;
                            }
                            if (list.get(55).doubleValue() <= 8.0d) {
                                if (list.get(64).doubleValue() <= 3.5115000009536743d) {
                                    return 0.5912358188146516d;
                                }
                                return 0.8014951921854689d;
                            }
                            return 0.40926333422852584d;
                        }
                        return 0.9118940962331878d;
                    }
                    return 0.9585010999143906d;
                } else if (list.get(61).doubleValue() <= 48.0d) {
                    if (list.get(55).doubleValue() > 100.0d) {
                        if (list.get(69).doubleValue() <= 8.0d) {
                            return 0.012481797697077706d;
                        }
                        if (list.get(56).doubleValue() <= 0.3465000092983246d) {
                            return 0.1178375378835805d;
                        }
                        return 0.6397942086901451d;
                    } else if (list.get(64).doubleValue() > 1.8690000176429749d) {
                        if (list.get(69).doubleValue() <= 8.0d) {
                            return 0.004802364778083154d;
                        }
                        if (list.get(61).doubleValue() <= 8.0d) {
                            if (list.get(69).doubleValue() <= 48.0d) {
                                return 7.031554142475554E-5d;
                            }
                            return 0.860398340260448d;
                        } else if (list.get(53).doubleValue() <= 100.0d) {
                            if (list.get(55).doubleValue() <= 8.0d) {
                                return 0.22783604504816482d;
                            }
                            return 0.09760032141367984d;
                        } else {
                            return 0.6342885644413004d;
                        }
                    } else {
                        return 0.07024728573032778d;
                    }
                } else if (list.get(72).doubleValue() <= 2.740499973297119d) {
                    if (list.get(64).doubleValue() > 0.8959999978542328d) {
                        if (list.get(69).doubleValue() <= 8.0d) {
                            return 0.9725860475259535d;
                        }
                        return 0.15889445805246552d;
                    }
                    return 0.7314263944600224d;
                } else if (list.get(71).doubleValue() <= 48.0d) {
                    return 0.0014790387543836055d;
                } else {
                    if (list.get(47).doubleValue() <= 100.0d) {
                        if (list.get(47).doubleValue() > 8.0d) {
                            if (list.get(39).doubleValue() <= 100.0d) {
                                return 0.2188157124616529d;
                            }
                            return 0.6087121440671157d;
                        } else if (list.get(64).doubleValue() > 1.8690000176429749d) {
                            if (list.get(69).doubleValue() <= 8.0d) {
                                return 0.940713302813249d;
                            }
                            if (list.get(71).doubleValue() <= 72.0d) {
                                if (list.get(69).doubleValue() <= 100.0d) {
                                    return 0.18940027692853287d;
                                }
                                return 0.5206236744216874d;
                            } else if (list.get(72).doubleValue() > 3.068000078201294d) {
                                if (list.get(69).doubleValue() <= 48.0d) {
                                    return 0.2586091608646784d;
                                }
                                if (list.get(61).doubleValue() <= 72.0d) {
                                    if (list.get(55).doubleValue() <= 100.0d) {
                                        if (list.get(72).doubleValue() <= 5.027000188827515d) {
                                            return 0.5243920742355708d;
                                        }
                                        return 0.3399382174635927d;
                                    }
                                    return 0.7301588866841764d;
                                } else if (list.get(55).doubleValue() <= 8.0d) {
                                    return 0.6693790616493045d;
                                } else {
                                    if (list.get(56).doubleValue() <= 0.8959999978542328d) {
                                        return 0.03941840973908577d;
                                    }
                                    return 0.6320681573543092d;
                                }
                            } else {
                                return 0.38914943919526723d;
                            }
                        } else if (list.get(72).doubleValue() > 4.667999982833862d) {
                            if (list.get(69).doubleValue() <= 100.0d) {
                                return 0.5901161038376596d;
                            }
                            return 0.09065295150349731d;
                        } else {
                            return 0.5431873401861317d;
                        }
                    } else if (list.get(45).doubleValue() <= 8.0d) {
                        return 0.06060487943598558d;
                    } else {
                        if (list.get(61).doubleValue() <= 100.0d) {
                            return 0.8547005411223688d;
                        }
                        return 0.6320967869554028d;
                    }
                }
            } else if (list.get(47).doubleValue() <= 100.0d) {
                if (list.get(74).doubleValue() <= 1.5d) {
                    if (list.get(66).doubleValue() > 1.5d) {
                        if (list.get(69).doubleValue() <= 100.0d) {
                            if (list.get(71).doubleValue() > 48.0d) {
                                if (list.get(69).doubleValue() <= 72.0d) {
                                    return 0.8798863972024926d;
                                }
                                if (list.get(71).doubleValue() <= 72.0d) {
                                    if (list.get(61).doubleValue() <= 72.0d) {
                                        return 0.766018683431782d;
                                    }
                                    if (list.get(61).doubleValue() <= 100.0d) {
                                        return 0.3959251862282135d;
                                    }
                                    return 0.8019501967572196d;
                                }
                                return 0.8850587488233717d;
                            } else if (list.get(71).doubleValue() <= 8.0d) {
                                return 0.8505358840371d;
                            } else {
                                return 0.06805041290024937d;
                            }
                        } else if (list.get(71).doubleValue() <= 48.0d) {
                            if (list.get(71).doubleValue() > 8.0d) {
                                if (list.get(40).doubleValue() <= 10.589000225067139d) {
                                    return 0.02784103613805716d;
                                }
                                return 0.6095183612523275d;
                            }
                            return 0.9730946513896254d;
                        } else {
                            return 0.9721536556519847d;
                        }
                    } else if (list.get(71).doubleValue() <= 8.0d) {
                        if (list.get(61).doubleValue() <= 100.0d) {
                            if (list.get(61).doubleValue() > 72.0d) {
                                if (list.get(69).doubleValue() <= 100.0d) {
                                    if (list.get(67).doubleValue() <= 100.0d) {
                                        return 0.5081740676491944d;
                                    }
                                    return 0.7311302272621358d;
                                } else if (list.get(64).doubleValue() <= 4.134999990463257d) {
                                    return 0.5344920062964531d;
                                } else {
                                    return 0.8451288521541891d;
                                }
                            } else if (list.get(47).doubleValue() <= 8.0d) {
                                return 0.8381926907327569d;
                            } else {
                                return 0.6837982027858014d;
                            }
                        }
                        return 0.9464856943171339d;
                    } else if (list.get(71).doubleValue() > 48.0d) {
                        if (list.get(69).doubleValue() <= 48.0d) {
                            if (list.get(61).doubleValue() > 8.0d) {
                                if (list.get(69).doubleValue() <= 8.0d) {
                                    return 0.7787197194527349d;
                                }
                                if (list.get(64).doubleValue() <= 6.148499965667725d) {
                                    return 0.6457908753840649d;
                                }
                                if (list.get(72).doubleValue() <= 12.13450002670288d) {
                                    return 0.3183186122912314d;
                                }
                                if (list.get(64).doubleValue() <= 12.13450002670288d) {
                                    return 0.7455951780516733d;
                                }
                                if (list.get(55).doubleValue() <= 100.0d) {
                                    return 0.369810636192077d;
                                }
                                return 0.5299097710211336d;
                            }
                            return 0.059814917045899266d;
                        } else if (list.get(47).doubleValue() > 8.0d) {
                            if (list.get(39).doubleValue() <= 100.0d) {
                                if (list.get(45).doubleValue() <= 100.0d) {
                                    if (list.get(61).doubleValue() > 8.0d) {
                                        if (list.get(39).doubleValue() > 24.0d) {
                                            if (list.get(35).doubleValue() <= 100.0d) {
                                                return 0.3448565934271528d;
                                            }
                                            return 0.6510506218215393d;
                                        } else if (list.get(55).doubleValue() <= 100.0d) {
                                            return 0.39735463241383157d;
                                        } else {
                                            return 0.6279347099723129d;
                                        }
                                    }
                                    return 0.7518803602644094d;
                                } else if (list.get(55).doubleValue() <= 100.0d) {
                                    if (list.get(61).doubleValue() <= 100.0d) {
                                        return 0.6374450204288985d;
                                    }
                                    return 0.21880159959203505d;
                                } else {
                                    return 0.7900171499194558d;
                                }
                            } else if (list.get(55).doubleValue() <= 100.0d) {
                                if (list.get(61).doubleValue() > 100.0d) {
                                    if (list.get(69).doubleValue() <= 100.0d) {
                                        return 0.8555268476732442d;
                                    }
                                    return 0.14425093561841187d;
                                }
                                return 0.6823536399410396d;
                            } else {
                                return 0.8152803760688422d;
                            }
                        } else if (list.get(71).doubleValue() <= 72.0d) {
                            if (list.get(69).doubleValue() <= 100.0d) {
                                if (list.get(69).doubleValue() <= 72.0d) {
                                    if (list.get(64).doubleValue() <= 6.291499853134155d) {
                                        return 0.8644621884906208d;
                                    }
                                    return 0.5953601084824396d;
                                }
                                return 0.20834576545396444d;
                            }
                            return 0.7482143857108308d;
                        } else if (list.get(72).doubleValue() <= 9.727499961853027d) {
                            if (list.get(69).doubleValue() <= 100.0d) {
                                if (list.get(64).doubleValue() <= 6.180000066757202d) {
                                    return 0.9126405994836251d;
                                }
                                return 0.6060496755968182d;
                            } else if (list.get(64).doubleValue() <= 2.138000011444092d) {
                                return 0.1771912277987006d;
                            } else {
                                if (list.get(61).doubleValue() > 100.0d) {
                                    if (list.get(51).doubleValue() <= 0.5d) {
                                        return 0.5800684785394761d;
                                    }
                                    if (list.get(56).doubleValue() <= 0.5494999885559082d) {
                                        return 0.014201827305333823d;
                                    }
                                    return 0.5231123830203859d;
                                } else if (list.get(61).doubleValue() <= 72.0d) {
                                    return 0.44660778458665107d;
                                } else {
                                    return 0.7553408314726945d;
                                }
                            }
                        } else if (list.get(64).doubleValue() <= 9.779500007629395d) {
                            if (list.get(64).doubleValue() <= 2.138000011444092d) {
                                return 0.6748590646217568d;
                            }
                            return 0.8818586799327159d;
                        } else if (list.get(72).doubleValue() <= 12.5625d) {
                            if (list.get(59).doubleValue() <= 72.0d) {
                                if (list.get(53).doubleValue() <= 8.0d) {
                                    return 0.676730631732315d;
                                }
                                if (list.get(56).doubleValue() <= 0.3465000092983246d) {
                                    return 0.1158083802002655d;
                                }
                                if (list.get(55).doubleValue() <= 72.0d) {
                                    return 0.3645869644135237d;
                                }
                                return 0.697521729608853d;
                            }
                            return 0.791315177600178d;
                        } else if (list.get(64).doubleValue() > 12.563000202178955d) {
                            if (list.get(67).doubleValue() > 0.5d) {
                                if (list.get(52).doubleValue() <= 0.5d) {
                                    return 0.8033424210789193d;
                                }
                                if (list.get(56).doubleValue() <= 0.3465000092983246d) {
                                    if (list.get(61).doubleValue() <= 100.0d) {
                                        return 0.8341584945511487d;
                                    }
                                    return 0.22045339536095082d;
                                } else if (list.get(55).doubleValue() <= 100.0d) {
                                    if (list.get(53).doubleValue() <= 100.0d) {
                                        return 0.5409863116267605d;
                                    }
                                    return 0.8271446816381353d;
                                } else {
                                    return 0.8408278806923015d;
                                }
                            }
                            return 0.6159781885732605d;
                        } else {
                            return 0.887316861551329d;
                        }
                    } else {
                        return 0.013228181404915768d;
                    }
                } else if (list.get(58).doubleValue() > 1.5d) {
                    if (list.get(69).doubleValue() <= 100.0d) {
                        if (list.get(71).doubleValue() <= 8.0d) {
                            return 0.7250448161426893d;
                        }
                        if (list.get(71).doubleValue() <= 48.0d) {
                            return 0.014880748881040864d;
                        }
                        if (list.get(55).doubleValue() <= 100.0d) {
                            if (list.get(56).doubleValue() <= 5.860999822616577d) {
                                if (list.get(71).doubleValue() <= 72.0d) {
                                    return 0.3451036720578144d;
                                }
                                return 0.5364196685563233d;
                            }
                            return 0.26910486401183736d;
                        }
                        return 0.6013411133523646d;
                    } else if (list.get(71).doubleValue() <= 8.0d) {
                        return 0.8963487657698783d;
                    } else {
                        if (list.get(71).doubleValue() <= 48.0d) {
                            return 0.020443755740744765d;
                        }
                        if (list.get(61).doubleValue() <= 72.0d) {
                            return 0.5851307410879174d;
                        }
                        return 0.7421847461540778d;
                    }
                } else if (list.get(61).doubleValue() <= 100.0d) {
                    if (list.get(71).doubleValue() <= 8.0d) {
                        return 0.4916674100193902d;
                    }
                    if (list.get(71).doubleValue() <= 48.0d) {
                        return 0.007483850014355155d;
                    }
                    if (list.get(55).doubleValue() <= 100.0d) {
                        if (list.get(56).doubleValue() <= 10.966000080108643d) {
                            if (list.get(69).doubleValue() <= 100.0d) {
                                return 0.25100315344788215d;
                            }
                            if (list.get(61).doubleValue() <= 72.0d) {
                                return 0.3028795007886919d;
                            }
                            return 0.47254207354443034d;
                        } else if (list.get(53).doubleValue() <= 100.0d) {
                            return 0.1524355846738322d;
                        } else {
                            return 0.36574593668855315d;
                        }
                    }
                    return 0.4502765568433939d;
                } else if (list.get(71).doubleValue() <= 8.0d) {
                    return 0.8069635226053898d;
                } else {
                    if (list.get(71).doubleValue() <= 48.0d) {
                        return 0.004241619226538934d;
                    }
                    return 0.5159022278352116d;
                }
            } else if (list.get(69).doubleValue() > 48.0d) {
                if (list.get(74).doubleValue() <= 1.5d) {
                    if (list.get(66).doubleValue() <= 1.5d) {
                        if (list.get(71).doubleValue() <= 8.0d) {
                            if (list.get(69).doubleValue() <= 100.0d) {
                                return 0.8428137240710674d;
                            }
                            return 0.9729693079132117d;
                        } else if (list.get(71).doubleValue() > 48.0d) {
                            if (list.get(31).doubleValue() <= 100.0d) {
                                if (list.get(71).doubleValue() <= 72.0d) {
                                    if (list.get(69).doubleValue() <= 100.0d) {
                                        if (list.get(69).doubleValue() <= 72.0d) {
                                            return 0.7405341049956511d;
                                        }
                                        return 0.31009167213433575d;
                                    }
                                    return 0.8163749636862596d;
                                } else if (list.get(61).doubleValue() > 100.0d) {
                                    if (list.get(69).doubleValue() > 100.0d) {
                                        if (list.get(67).doubleValue() <= 92.0d) {
                                            if (list.get(39).doubleValue() > 72.0d) {
                                                if (list.get(40).doubleValue() > 0.3465000092983246d) {
                                                    if (list.get(31).doubleValue() <= 8.0d) {
                                                        return 0.7911303903944835d;
                                                    }
                                                    return 0.39826729311670706d;
                                                }
                                                return 0.09577264063674364d;
                                            }
                                            return 0.7609594404905374d;
                                        }
                                        return 0.8767466846149828d;
                                    }
                                    return 0.9135031011463798d;
                                } else {
                                    return 0.8493559777316309d;
                                }
                            } else if (list.get(71).doubleValue() <= 72.0d) {
                                if (list.get(69).doubleValue() <= 100.0d) {
                                    if (list.get(69).doubleValue() <= 72.0d) {
                                        return 0.7545352707096076d;
                                    }
                                    return 0.4168421021183326d;
                                }
                                return 0.918841220281958d;
                            } else {
                                return 0.9124475869050861d;
                            }
                        } else {
                            return 0.006683555424738319d;
                        }
                    }
                    return 0.9605450680847096d;
                } else if (list.get(58).doubleValue() <= 1.5d) {
                    if (list.get(55).doubleValue() > 72.0d) {
                        if (list.get(7).doubleValue() <= 100.0d) {
                            if (list.get(42).doubleValue() <= 1.5d) {
                                return 0.5186361100151007d;
                            }
                            return 0.7269734032241532d;
                        }
                        return 0.794380526618539d;
                    } else if (list.get(71).doubleValue() <= 72.0d) {
                        return 0.4847550211954086d;
                    } else {
                        return 0.18011168073679568d;
                    }
                } else if (list.get(71).doubleValue() <= 8.0d) {
                    return 0.9385776732627039d;
                } else {
                    if (list.get(71).doubleValue() <= 48.0d) {
                        return 0.00685994875036358d;
                    }
                    if (list.get(55).doubleValue() <= 72.0d) {
                        return 0.6365265524132171d;
                    }
                    return 0.8095728882464537d;
                }
            } else if (list.get(61).doubleValue() > 8.0d) {
                if (list.get(69).doubleValue() <= 8.0d) {
                    return 0.948527214354758d;
                }
                if (list.get(71).doubleValue() <= 8.0d) {
                    return 0.8572786443561917d;
                }
                if (list.get(71).doubleValue() <= 48.0d) {
                    return 0.005808267289132309d;
                }
                if (list.get(72).doubleValue() <= 11.467999935150146d) {
                    if (list.get(61).doubleValue() <= 100.0d) {
                        return 0.584370655532323d;
                    }
                    return 0.19196257131222483d;
                }
                return 0.6739926992764292d;
            } else if (list.get(71).doubleValue() > 8.0d) {
                if (list.get(59).doubleValue() <= 60.5d) {
                    return 0.04485289437104026d;
                }
                return 0.7708461500075926d;
            } else {
                return 0.9206065390594851d;
            }
        } else if (list.get(55).doubleValue() <= 100.0d) {
            if (list.get(55).doubleValue() > 8.0d) {
                if (list.get(69).doubleValue() <= 8.0d) {
                    if (list.get(67).doubleValue() <= 60.5d) {
                        if (list.get(47).doubleValue() <= 100.0d) {
                            return 0.4785347281095676d;
                        }
                        if (list.get(45).doubleValue() <= 24.0d) {
                            return 0.1283167173351005d;
                        }
                        return 0.5112019637562835d;
                    }
                    return 0.8752791315945584d;
                } else if (list.get(74).doubleValue() > 1.5d) {
                    if (list.get(66).doubleValue() <= 1.5d) {
                        if (list.get(55).doubleValue() > 72.0d) {
                            if (list.get(48).doubleValue() <= 10.42799997329712d) {
                                return 0.6393363274540433d;
                            }
                            return 0.44285318932998896d;
                        } else if (list.get(56).doubleValue() <= 9.179500102996826d) {
                            return 0.6624880868672806d;
                        } else {
                            return 0.20164370887541222d;
                        }
                    } else if (list.get(55).doubleValue() <= 72.0d) {
                        return 0.7710115046360664d;
                    } else {
                        return 0.8707456274798767d;
                    }
                } else if (list.get(61).doubleValue() <= 100.0d) {
                    if (list.get(67).doubleValue() <= 72.0d) {
                        if (list.get(53).doubleValue() <= 100.0d) {
                            if (list.get(53).doubleValue() <= 72.0d) {
                                if (list.get(67).doubleValue() > 0.5d) {
                                    if (list.get(69).doubleValue() <= 48.0d) {
                                        return 0.7668889478202133d;
                                    }
                                    return 0.8811027826135962d;
                                }
                                return 0.7188861166295765d;
                            } else if (list.get(72).doubleValue() <= 9.223999977111816d) {
                                if (list.get(69).doubleValue() <= 100.0d) {
                                    if (list.get(69).doubleValue() <= 48.0d) {
                                        return 0.367988161917995d;
                                    }
                                    return 0.8640855467002068d;
                                }
                                return 0.3382294030276001d;
                            } else if (list.get(55).doubleValue() > 72.0d) {
                                if (list.get(69).doubleValue() <= 100.0d) {
                                    return 0.9280179152737944d;
                                }
                                return 0.7165523303020045d;
                            } else {
                                return 0.6756386812382458d;
                            }
                        }
                        return 0.894542876166561d;
                    }
                    return 0.9273058899079447d;
                } else if (list.get(53).doubleValue() <= 100.0d) {
                    if (list.get(45).doubleValue() > 100.0d) {
                        if (list.get(69).doubleValue() <= 100.0d) {
                            return 0.9670231362869d;
                        }
                        if (list.get(47).doubleValue() <= 100.0d) {
                            return 0.7735765062186503d;
                        }
                        return 0.12869083978317428d;
                    }
                    return 0.7693489257733377d;
                } else {
                    return 0.9357502580215835d;
                }
            } else if (list.get(64).doubleValue() > 0.3465000092983246d) {
                if (list.get(74).doubleValue() <= 1.5d) {
                    if (list.get(69).doubleValue() <= 48.0d) {
                        return 0.9475203503288216d;
                    }
                    return 0.983406879687108d;
                } else if (list.get(66).doubleValue() <= 1.5d) {
                    if (list.get(61).doubleValue() <= 100.0d) {
                        return 0.8479726862225473d;
                    }
                    return 0.9466656014517817d;
                } else {
                    return 0.9743365774498065d;
                }
            } else if (list.get(72).doubleValue() <= 6.2220001220703125d) {
                if (list.get(72).doubleValue() <= 5.476500034332275d) {
                    return 0.890519243258868d;
                }
                if (list.get(61).doubleValue() <= 100.0d) {
                    if (list.get(61).doubleValue() <= 72.0d) {
                        return 0.81035456564053d;
                    }
                    return 0.26747192152134786d;
                }
                return 0.9657017300444201d;
            } else {
                return 0.9315037410093172d;
            }
        } else if (list.get(47).doubleValue() <= 100.0d) {
            if (list.get(47).doubleValue() <= 8.0d) {
                return 0.9881267587487025d;
            }
            if (list.get(53).doubleValue() > 8.0d) {
                if (list.get(74).doubleValue() > 1.5d) {
                    if (list.get(66).doubleValue() <= 1.5d) {
                        if (list.get(47).doubleValue() <= 72.0d) {
                            if (list.get(48).doubleValue() <= 9.35450029373169d) {
                                return 0.767677146488818d;
                            }
                            return 0.3350808342133534d;
                        }
                        return 0.7070946223265754d;
                    }
                    return 0.9144500866464432d;
                } else if (list.get(53).doubleValue() <= 100.0d) {
                    return 0.9504395617420452d;
                } else {
                    if (list.get(45).doubleValue() <= 100.0d) {
                        if (list.get(37).doubleValue() <= 100.0d) {
                            return 0.9064047706471859d;
                        }
                        return 0.43194452674254646d;
                    }
                    return 0.9637083492353948d;
                }
            } else if (list.get(45).doubleValue() <= 48.0d) {
                return 0.921683136525811d;
            } else {
                return 0.3678002686965226d;
            }
        } else {
            return 0.9909735753350392d;
        }
    }

    public final List<Double> predictAll(List<Double> list) {
        Intrinsics.checkNotNullParameter(list, "input");
        if (list.size() != 80) {
            ArrayList arrayList = new ArrayList(5);
            for (int i = 0; i < 5; i++) {
                arrayList.add(Double.valueOf(0.0d));
            }
            return arrayList;
        }
        return CollectionsKt.listOf(new Double[]{Double.valueOf(tree0(list)), Double.valueOf(tree1(list)), Double.valueOf(tree2(list)), Double.valueOf(tree3(list)), Double.valueOf(tree4(list))});
    }
}