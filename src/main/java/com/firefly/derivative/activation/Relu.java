package com.firefly.derivative.activation;

import com.firefly.derivative.core.Function;
import com.firefly.derivative.core.OperationActivation;
import com.firefly.layers.data.MultiDim;

/**
 * relu
 */
public class Relu extends OperationActivation {
    private static final long serialVersionUID = 1L;

    @Override
    public double prtGrad(Function dx) {
        double val=0;

        if(this==dx){
            val=1;
        }else{
            if(this.getVal().isDx(dx)){
                double v=this.getVal().calc();
                val=v>0?1:0;
                val=prtGradEx(
                        dx,
                        val
                );
            }
        }

        return val;
    }

    public double prtGrad(Function dx, MultiDim targetVal){
        return prtGrad(dx);
    }

    @Override
    public double calc() {
        double v=this.getVal().calc();
        //f(v)=max(0,v)
        return v>0?v:0;
    }
}
