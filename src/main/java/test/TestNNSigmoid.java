package test;

import com.firefly.derivative.operation.Sigmoid;
import com.firefly.derivative.operation.Softmax;
import com.firefly.layers.core.Model;
import com.firefly.layers.init.params.InitParamsRandomGaussian;
import com.firefly.layers.layers.Dense;
import com.firefly.layers.listeners.LossCallBackListener;
import com.firefly.layers.loss.Mse;
import com.firefly.layers.models.Sequential;

public class TestNNSigmoid {
    public static void main(String[] args){
        double[][] x=new double[][]{
                {1,1,1,1,0,1,1,0,1,1,1,1},
                {0,1,1,1,0,1,1,0,1,1,1,1},
                {1,1,0,1,0,1,1,0,1,1,1,1},
                {1,1,1,1,0,1,1,0,1,1,1,0},
                {1,1,1,1,0,1,1,0,1,0,1,1},
                {0,0,0,1,1,1,1,0,1,1,1,1},
                {0,0,0,0,1,1,1,0,1,1,1,1},
                {0,0,0,1,1,0,1,0,1,1,1,1},
                {0,0,0,1,1,1,1,0,1,1,1,0},
                {0,0,0,1,1,1,1,0,1,0,1,1},
                {1,1,1,1,0,1,1,1,1,0,0,0},
                {0,1,1,1,0,1,1,1,1,0,0,0},
                {1,1,0,1,0,1,1,1,1,0,0,0},
                {1,1,1,1,0,1,1,1,0,0,0,0},
                {1,1,1,1,0,1,0,1,1,0,0,0},
                {1,0,1,1,0,1,1,0,1,1,1,1},
                {1,1,1,1,0,0,1,0,1,1,1,1},
                {1,1,1,1,0,1,1,0,0,1,1,1},
                {1,1,1,1,0,1,1,0,1,1,0,1},
                {1,1,1,1,0,1,0,0,1,1,1,1},
                {1,1,1,0,0,1,1,0,1,1,1,1},
                {0,0,1,1,0,1,1,0,1,1,1,1},
                {0,1,1,1,0,0,1,0,1,1,1,1},
                {0,1,1,1,0,1,1,0,0,1,1,1},
                {0,1,1,1,0,1,1,0,1,1,0,1},
                {0,1,1,1,0,1,0,0,1,1,1,1},
                {0,1,1,0,0,1,1,0,1,1,1,1},
                {1,1,0,1,0,0,1,0,1,1,1,1},
                {1,1,0,1,0,1,1,0,0,1,1,1},
                {1,1,0,1,0,1,1,0,1,1,0,1},
                {1,1,0,1,0,1,0,0,1,1,1,1},
                {1,1,0,0,0,1,1,0,1,1,1,1},
                {0,1,0,0,1,0,0,1,0,0,1,0},
                {1,1,0,0,1,0,0,1,0,0,1,0},
                {0,1,0,0,1,0,0,1,0,0,1,0},
                {0,1,0,0,1,0,0,1,0,1,1,0},
                {0,1,0,0,1,0,0,1,0,0,1,1},
                {1,1,0,0,1,0,0,1,0,1,1,0},
                {1,1,0,0,1,0,0,1,0,0,1,1},
                {1,1,0,0,1,0,0,1,0,1,1,1},
                {0,1,0,0,1,1,0,1,0,0,1,0},
                {0,1,0,0,1,0,0,1,1,0,1,0},
                {1,1,0,0,1,1,0,1,0,0,1,0},
                {1,1,0,0,1,0,0,1,1,0,1,0},
                {0,1,0,0,1,1,0,1,0,1,1,0},
                {0,1,0,0,1,0,0,1,1,1,1,0},
                {0,1,0,0,1,0,0,1,0,1,1,1},
                {1,1,0,0,1,1,0,1,1,0,1,1},
                {1,1,0,0,1,0,0,1,0,0,1,0},
                {0,1,1,0,1,1,0,1,1,0,1,1},
                {1,1,0,1,1,0,0,1,0,0,1,0},
                {1,1,0,0,1,0,1,1,0,0,1,0},
                {1,1,0,1,1,0,1,1,0,1,1,0},
                {1,1,0,0,1,0,0,0,0,0,1,0},
                {0,1,0,0,1,0,0,1,0,1,0,0},
                {1,0,0,0,1,0,0,1,0,0,1,0},
                {1,0,0,0,1,0,0,1,0,0,0,1},
                {0,1,0,0,0,0,0,1,0,1,1,0},
                {0,1,0,0,1,0,0,0,0,1,1,0},
                {0,0,0,0,1,0,0,1,0,1,1,0},
                {0,0,0,0,1,0,0,1,0,0,1,0},
                {0,1,0,0,1,0,0,1,0,0,0,0},
                {0,1,0,0,0,1,0,0,1,0,1,0},
                {0,1,0,1,0,0,1,0,0,0,1,0}
        };

        double[][] y=new double[][]{
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {1,0},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1},
                {0,1}
        };

        Model model=new Sequential(0.1);
        model.add(new Dense(12,3, Sigmoid.class,new InitParamsRandomGaussian()));
        model.add(new Dense(2, Sigmoid.class));
        //识差函数
        model.setLossCls(Mse.class);

        model.fit(x, y, 10000, x.length, new LossCallBackListener() {
            @Override
            public void onLoss(double val) {
                System.out.println(String.format("%.10f", val));
            }
        });

        for(int i=0;i<x.length;i++){
            double[] py=model.predict(x[i]);
            for(int j=0;j<py.length;j++){
                System.out.print(String.format("%.10f   ", py[j]));
            }
            for(int j=0;j<y[i].length;j++){
                System.out.print(String.format("%.10f   ", y[i][j]));
            }
            System.out.println();
        }

    }
}
