package com.firefly.derivative.operation;

import com.firefly.derivative.core.Function;
import com.firefly.derivative.core.OperationBinary;

/**
 * 乘法
 */
public class Mcl extends OperationBinary {
    private double calcA=Double.MAX_VALUE,calcB=Double.MAX_VALUE,calcVal=Double.MAX_VALUE;

    public Mcl(){

    }

    public Mcl(Function a, Function b){
        super(a,b);
    }

    @Override
    public double der(Function dx) {
        double val=0;
        if(this.getA().isDx(dx)){
            val=this.getB().calc();
        }else if(this.getB().isDx(dx)){
            val=this.getA().calc();
        }

        return derEx(
                dx,
                val
        );
    }

    @Override
    public double calc() {
        double a=this.getA().calc();
        double b=this.getB().calc();
        if(calcA!=a || calcB!=b){
            calcA=a;
            calcB=b;
            calcVal=a*b;
        }
        return calcVal;
    }
}
