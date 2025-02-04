package com.firefly.layers.data;

/**
 * 2维
 */
public class TwoDimShape extends Shape{
    private static final long serialVersionUID = 1L;

    public static final int X=0;//X轴
    public static final int Y=1;//Y轴

    public TwoDimShape(int oneDimDataNum, int twoDimDataNum) {
        int[] dimDataNum = new int[2];
        dimDataNum[0]=oneDimDataNum;
        dimDataNum[1]=twoDimDataNum;
        this.setDims(dimDataNum);
    }

    public TwoDimShape(Shape shape){
        this(shape.getDim(0),shape.getDim(1));
        if(shape.getDims().length!=2){
            throw new RuntimeException("Wrong dimension!");
        }
    }

    public int getX(){
        return getDim(X);
    }

    public int getY(){
        return getDim(Y);
    }
}
