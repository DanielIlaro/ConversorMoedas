package br.com.alphaaquilae.conversormoedas.functionalites;

public class Conversion {
    //variavel
    private double conversionValue;

    //valores das moedas em relação ao real
    private double euro = 4.81;
    private double dollarAmerican = 4.09;

    public Conversion(String coin, double real){
       this.conversionValue = valueMoeda(coin, real);
    }

    private Double valueMoeda(String coin, double real){
        double result;

        switch (coin){
            case "euro":
                result = real*this.euro;
                break;
            default:
                result = real*this.dollarAmerican;
        }

        return result;
    }

    public Double getConversionValue() {
        return conversionValue;
    }
}
