package soot.jimple.spark.queue;

import soot.util.*;
import soot.jimple.spark.bdddomains.*;
import soot.jimple.spark.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Rsrc_dstIter extends Rsrc_dst {
    protected Iterator r;
    
    public Rsrc_dstIter(Iterator r) {
        super();
        this.r = r;
    }
    
    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() {
                boolean ret = r.hasNext();
                return ret;
            }
            
            public Object next() { return new Tuple((VarNode) r.next(), (VarNode) r.next()); }
            
            public void remove() { throw new UnsupportedOperationException(); }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { src.v(), dst.v() },
                                              new PhysicalDomain[] { V1.v(), V2.v() },
                                              ("<soot.jimple.spark.bdddomains.src:soot.jimple.spark.bdddomai" +
                                               "ns.V1, soot.jimple.spark.bdddomains.dst:soot.jimple.spark.bd" +
                                               "ddomains.V2> ret = jedd.internal.Jedd.v().falseBDD(); at /ho" +
                                               "me/olhotak/soot-2-jedd/src/soot/jimple/spark/queue/Rsrc_dstI" +
                                               "ter.jedd:46,25-28"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next() },
                                                       new Attribute[] { src.v(), dst.v() },
                                                       new PhysicalDomain[] { V1.v(), V2.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { dst.v(), src.v() },
                                                   new PhysicalDomain[] { V2.v(), V1.v() },
                                                   ("return ret; at /home/olhotak/soot-2-jedd/src/soot/jimple/spa" +
                                                    "rk/queue/Rsrc_dstIter.jedd:50,8-14"),
                                                   ret);
    }
    
    public boolean hasNext() { return r.hasNext(); }
}
