package com.firefly.layers.core;

import com.firefly.layers.data.MultiDim;
import com.firefly.layers.data.Shape;

/**
 * 网络层
 */
public interface Layer extends java.io.Serializable{
    /**
     * 获取层的输入数量
     * @return
     */
    Shape getInputShape();

    /**
     * 设置层的输入数量
     * @param inputShape
     */
    void setInputShape(Shape inputShape);

    /**
     * 获取层的输出数量，即是神经元数
     * @return
     */
    Shape getUnitShape();

    /**
     * 设置层的输出数量，即是神经元数
     * @param unitShape
     */
    void setUnitShape(Shape unitShape);

    /**
     * 获取层的W参数
     * @return
     */
    MultiDim getW();

    /**
     * 设置层的W参数
     * @param w
     */
    void setW(MultiDim w);

    /**
     * 获取层的B参数
     * @return
     */
    MultiDim getB();

    /**
     * 设置层的B参数
     * @param b
     */
    void setB(MultiDim b);

    /**
     * 初始化层
     */
    void init();

    /**
     * 正向计算
     * @param input 输入数量
     * @param out 计算后并输出数据
     */
    void calc(MultiDim input,MultiDim out);

    /**
     * 重置反向更新参数梯度
     */
    void resetBackUpdateParamPrtGrad();

    /**
     * 累加反向更新参数梯度
     * @param input 输入值
     * @param targetVal 目标值
     * @param outFrontLayerPrtGrad 输出 识差函数/输入值的梯度
     * @param backLayerPrtGrad 误差函数/输出值的梯度
     */
    void addBackUpdateParamPrtGrad(MultiDim input,MultiDim targetVal,MultiDim outFrontLayerPrtGrad,MultiDim backLayerPrtGrad);

    /**
     * 更新参数梯度
     */
    void flushBackUpdateParamPrtGrad(int batchSize);

}
