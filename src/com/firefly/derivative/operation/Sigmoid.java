package com.firefly.derivative.operation;

import com.firefly.derivative.core.Function;
import com.firefly.derivative.core.OperationUnary;

/**
 * sigmoid
 */
public class Sigmoid extends OperationUnary {
    private double val=Double.MAX_VALUE,calcVal=Double.MAX_VALUE;

    public Sigmoid(){

    }

    public Sigmoid(Function val){
        super(val);
    }

    @Override
    public double der(Function dx) {
        double val=0;
        if(this.getVal().isDx(dx)){
            double fv=calc();
            val=fv*(1-fv);
        }
        return derEx(
                dx,
                val
        );
    }

    @Override
    public double calc() {
        double v=this.getVal().calc();
        if(val!=v){
            val=v;
            calcVal=1/(1+Math.exp(-v));
        }
        return calcVal;
    }
}
