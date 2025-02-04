package com.firefly.derivative.operation;

import com.firefly.derivative.core.Function;
import com.firefly.derivative.core.OperationUnary;
import com.firefly.derivative.util.MathEx;

/**
 * tan
 */
public class Tan extends OperationUnary {
    private static final long serialVersionUID = 1L;

    private double val=Double.MAX_VALUE,calcVal=Double.MAX_VALUE;

    public Tan(){

    }

    public Tan(double val) {
        super(val);
    }

    public Tan(Function val){
        super(val);
    }

    @Override
    public double prtGrad(Function dx) {
        double val=0;

        if(this==dx){
            val=1;
        }else{
            if(this.getVal().isDx(dx)){
                val=MathEx.pow(MathEx.sec(this.getVal().calc()),2);
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
            calcVal=Math.tan(v);
        }
        return calcVal;
    }
}
