package com.firefly.derivative.operation;

import com.firefly.derivative.core.Function;
import com.firefly.derivative.core.OperationMultiple;

/**
 * 减法，多参数
 */
public class SubMult extends OperationMultiple {
    public SubMult(){

    }

    public SubMult(Function[] params){
        super(params);
    }

    @Override
    public double der(Function dx) {
        double val=0;
        if(this==dx){
            val=1;
        }else{
            if(this.getParams()!=null && this.getParams().length>0){
                int i=0;
                for(Function param:this.getParams()){
                    if(param.isDx(dx)){
                        val+=this.derEx(param,dx,i==0?1.0:-1.0);
                    }
                    i++;
                }
            }
        }

        return val;
    }
}
