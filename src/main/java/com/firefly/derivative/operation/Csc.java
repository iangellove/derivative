package com.firefly.derivative.operation;

import com.firefly.derivative.core.Function;
import com.firefly.derivative.core.OperationUnary;
import com.firefly.derivative.util.MathEx;

/**
 * sec
 */
public class Csc extends OperationUnary {
    private static final long serialVersionUID = 1L;

    private double val=Double.MAX_VALUE,calcVal=Double.MAX_VALUE;

    public Csc(){

    }

    public Csc(double val) {
        super(val);
    }

    public Csc(Function val){
        super(val);
    }

    @Override
    public double prtGrad(Function dx) {
        double v=this.getVal().calc();
        double val=0;

        if(this==dx){
            val=1;
        }else{
            if(this.getVal().isDx(dx)){
                val=-MathEx.csc(v)*MathEx.cot(v);
                val=prtGradEx(
                        dx,
                        val
                );
            }
        }

        return val;
    }

    @Override
    public double calc() {
        double v=this.getVal().calc();
        if(val!=v){
            val=v;
            calcVal=MathEx.csc(v);
        }
        return calcVal;
    }
}
