package soot.jimple.spark.queue;

import soot.util.*;
import soot.jimple.spark.bdddomains.*;
import soot.jimple.spark.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qsrcc_srcm_stmt_kind_tgtc_tgtmTrad extends Qsrcc_srcm_stmt_kind_tgtc_tgtm {
    private ChunkedQueue q = new ChunkedQueue();
    
    public void add(Context _srcc, SootMethod _srcm, Unit _stmt, Kind _kind, Context _tgtc, SootMethod _tgtm) {
        q.add(_srcc);
        q.add(_srcm);
        q.add(_stmt);
        q.add(_kind);
        q.add(_tgtc);
        q.add(_tgtm);
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { srcc.v(), srcm.v(), tgtm.v(), tgtc.v(), stmt.v(), kind.v() },
                                              new PhysicalDomain[] { V1.v(), T1.v(), T2.v(), V2.v(), ST.v(), FD.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at /home/olhotak/soot-2" +
                                               "-jedd/src/soot/jimple/spark/queue/Qsrcc_srcm_stmt_kind_tgtc_" +
                                               "tgtmTrad.jedd:41,22-24"),
                                              in).iterator(new Attribute[] { srcc.v(), srcm.v(), stmt.v(), kind.v(), tgtc.v(), tgtm.v() });
        while (it.hasNext()) {
            Object[] tuple = (Object[]) it.next();
            for (int i = 0; i < 6; i++) {
                this.add((Context) tuple[0],
                         (SootMethod) tuple[1],
                         (Unit) tuple[2],
                         (Kind) tuple[3],
                         (Context) tuple[4],
                         (SootMethod) tuple[5]);
            }
        }
    }
    
    public Rsrcc_srcm_stmt_kind_tgtc_tgtm reader() { return new Rsrcc_srcm_stmt_kind_tgtc_tgtmTrad(q.reader()); }
    
    public Qsrcc_srcm_stmt_kind_tgtc_tgtmTrad() { super(); }
}
