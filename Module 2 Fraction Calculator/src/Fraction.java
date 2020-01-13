class Fraction {
    private int numerator;
    private  int denominator;

    public Fraction (int numerator, int denominator){
        // try catch if denominator is zero
        if (denominator == 0){
            throw new IllegalArgumentException("denominator cannot be zero");
        }
        if (denominator < 0 ){
            this.denominator = denominator * -1;
            this.numerator = numerator * -1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }

    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction() {
        this(0, 1);
    }

    public int getNumerator (){
        System.out.println(numerator);
        return numerator;
    }
    public  int getDenominator(){
        System.out.println(denominator);
        return denominator;
    }
    public String toString(){
        String num = String.valueOf(numerator);
        String den =  Integer.toString(denominator);
        return num+"/"+den;
    }
    public double toDouble(){
        double num = (double)(numerator);
        double den =  (double)(denominator);
        return num/den;
    }
    public Fraction add(Fraction other){
           Fraction res = other;
           res.denominator = other.denominator + denominator;
           res.numerator = other.numerator + numerator;
           System.out.println(other.numerator+"/"+other.denominator + " + "+ numerator + "/" +denominator + " = " + res.numerator+"/"+res.denominator);
           return res;
    }


    public Fraction subtract (Fraction other){
return other;
    }


    public Fraction multipy(Fraction other){
return other;
    }


    public Fraction divide(Fraction other){
return other;
    }
    public boolean equals(Object other){
        if(other == this){
            return true;
        } else {
            return false;
        }
    }
    public void toLowestTerms(){

    }
    public static int gcd(int num, int num2){
          if(num > num2){
              if(num % num2 == 0){
                  return num;
              } else {
                  return  num * num2;
              }
          } else if (num2 > num){
              if(num2%num==0){
                  return num2;
              } else {
                  return  num2 * num;
              }
          } else {
              return num;
          }
    }
}
