package Vektor;

/**
 * Created by Ezydenias on 4/12/2017.
 */
public class VektorFunktionen {

    public static double[] add(double[] a, double[] b) {
        if (a.length != b.length)
            return null;

        double[] sum = new double[a.length];
        for (int i=0; i<a.length; i++)
            if((a[i]<=0 && b[i]>=0)||(a[i]>=0 && b[i]<=0)) {
                sum[i] = a[i] + b[i];
            } else {
                if(a[i]>0) {
                    if(b[i]<(Double.MAX_VALUE-a[i])){
                        sum[i] = a[i] + b[i];
                    } else {
                            return null;
                    }
                }else if (a[i]<0) {
                    if(b[i]>(Double.MIN_VALUE-a[i])){
                        sum[i] = a[i] + b[i];
                    }else{
                        return null;
                    }

                } else {
                    return null;
                }

            }
        return sum;
    }

    public static double[] sub(double[] a, double[] b){
        if (a.length != b.length)
            return null;
        for (int i=0; i<b.length;i++){
            b[i]*=-1.0;
        }
        return (add(a,b));

    }

    public static double[] mult(double[] a, double[] b){
        //if (a.length != b.length)
        //    return null;

        double[] sum = new double[a.length];    //korrigieren nach vorgabe
        for (int i=0; i<a.length; i++){
                if (a[i]==0||b[i]==0){
                    sum[i]=0;
                } else if ((a[i]<0 && b[i]<0)||(a[i]>0 && b[i]>0)){
                    sum[i]=a[i]*b[i];
                    //if (sum[i])
                } else if ((a[i]<=0 && b[i]>=0)||(a[i]>=0 && b[i]<=0)){

                } else {
                    return null;
                }

        }
        return sum;
    }
}
