/* Soot - a J*va Optimization Framework
 * Copyright (C) 1997-1999 Raja Vallee-Rai
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

/*
 * Modified by the Sable Research Group and others 1997-1999.  
 * See the 'credits' file distributed with Soot for the complete list of
 * contributors.  (Soot is distributed at http://www.sable.mcgill.ca/soot)
 */





package soot.jimple;

import soot.*;
import java.util.*;

public interface LookupSwitchStmt extends Stmt
{
    public Unit getDefaultTarget();
    public void setDefaultTarget(Unit defaultTarget);
    public UnitBox getDefaultTargetBox();
    public Value getKey();
    public void setKey(Value key);
    public ValueBox getKeyBox();
    public void setLookupValues(List<IntConstant> lookupValues);
    public void setLookupValue(int index, int value);
    public int getLookupValue(int index);
    public List<IntConstant> getLookupValues();
    public int getTargetCount();
    public Unit getTarget(int index);
    public UnitBox getTargetBox(int index);
    public void setTarget(int index, Unit target);
    public List<Unit> getTargets();
    public void setTargets(Unit[] targets);
}
